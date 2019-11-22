package nullteam.com.doway;

import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import nullteam.com.doway.model.ActivityInfo;
import nullteam.com.doway.model.Hotel;
import nullteam.com.doway.model.Restaurant;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import static android.content.ContentValues.TAG;

// 負責發出網路請求，取得OpenData
public class OpenDataService {
    private OkHttpClient client;
    private volatile static OpenDataService manager;
    private static OpenDataService instance = null;

    //單例模式實現
    private OpenDataService() {
        client = new OkHttpClient.Builder()
                .connectTimeout(10, TimeUnit.SECONDS)
                .writeTimeout(10, TimeUnit.SECONDS)
                .readTimeout(10, TimeUnit.SECONDS)
                .retryOnConnectionFailure(true)
                .build();
    }

    public static OpenDataService getInstance() {
        if (manager == null) {
            synchronized (OpenDataService.class) {
                if (instance == null) {
                    instance = new OpenDataService();
                    manager = instance;
                }
            }
        }
        return instance;
    }

    //callback 動作完成後 的 後續動作  (網路請求,非同步寫法)
    public void GetJson(String url, final CallbackResponse callback) {
        Request request = new Request.Builder().url(url).build();
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onResponse(@NotNull Call call, @NotNull Response response) {
                if (response.isSuccessful()) {
                    try {
                        if (callback != null) {
                            try {
                                callback.onResponse(response.body().string());
                            } catch (Exception ex) {
                                callback.onFail(ex);
                            }
                        }
                        response.close();
                    } catch (Exception ex) {
                        callback.onFail(ex);
                    }
                } else {
                    String resCode = Integer.toString(response.code());
                    callback.onFail(new Exception("取得回應失敗,錯誤狀態碼(" + resCode + ")"));
                }
            }

            @Override
            public void onFailure(@NotNull Call call, @NotNull IOException e) {
                Log.d(TAG, "onFailure: " + e.getMessage());
                callback.onFail(e);
            }
        });
    }

    public void GetRestaurant(final GetRestaurantResponse callback) {
        GetJson("http://data.coa.gov.tw/Service/OpenData/ODwsv/ODwsvTravelFood.aspx", new CallbackResponse() {
            @Override
            public void onResponse(String result) {
                ArrayList<Restaurant> datas = null;
                JsonArray arrayResults = new JsonParser().parse(result).getAsJsonArray();
                if (arrayResults != null) {
                    Gson gson = new Gson();
                    Type collectionType = new TypeToken<List<Restaurant>>() { }.getType();
                    datas = gson.fromJson(arrayResults, collectionType);
                }
                callback.onGetRestlt(datas);
            }

            public void onFail(Exception ex) {
                callback.onFail(ex);
            }
        });
    }

    public void GetHotel(final GetHotelResponse callback) {
        GetJson("https://data.tycg.gov.tw/api/v1/rest/datastore/c3340a19-9219-498a-9a46-21de506ba85b?format=json", new CallbackResponse() {
            @Override
            public void onResponse(String result) {
                JsonParser parser = new JsonParser();
                ArrayList<Hotel> datas = null;
                JsonObject root = parser.parse(result).getAsJsonObject();

                JsonArray arrayResults = root.getAsJsonObject("result").getAsJsonArray("records");

                if (arrayResults != null) {
                    Gson gson = new Gson();
                    Type collectionType = new TypeToken<List<Hotel>>() { }.getType();
                    datas = gson.fromJson(arrayResults, collectionType);
                }
                callback.onGetRestlt(datas);
            }

            public void onFail(Exception ex) {
                callback.onFail(ex);
            }
        });
    }

    public void GetActivityInfo(final GetActivityInfoResponse callback) {
        GetJson("https://data.tycg.gov.tw/api/v1/rest/datastore/3983e8e8-7a67-4bbd-b976-bb0cdb97e2f7?format=json", new CallbackResponse() {
            @Override
            public void onResponse(String result) {
                try {
                    JsonParser parser = new JsonParser();
                    ArrayList<ActivityInfo> datas = null;

                    JsonObject root = parser.parse(result).getAsJsonObject();

                    JsonArray arrayResults = root.getAsJsonObject("result").getAsJsonArray("records");
                    //如果從JSON取得的資料不為空，便執行
                    if (arrayResults != null) {
                        //利用JsonArray.size()得到項目總數，逐項檢查

                        for(int i = 0; i < arrayResults.size(); i++){
                            //再宣告一個JsonObject來讀取內層的Json資料
                            JsonObject obj = arrayResults.get(i).getAsJsonObject();
                            //如果「img」這項不為空，便執行
                            try{
                                if(obj.get("img") != null){
                                    //從已建立的JsonObject中讀取「img」這項，並存成JsonArray
                                    JsonArray imgUrl = obj.get("img").getAsJsonArray();
                                    //設定一個用來儲存活動圖片網址的字串陣列，利用imgUrl.size()來確認「imgUrl」這項有幾組資料
                                    String activityPicUrl[][] = new String[arrayResults.size()][imgUrl.size()];
                                    //使用get(i)來取得第(i+1)張圖的相關資料
                                    for(int j = 0;j < imgUrl.size();j++){
                                        activityPicUrl[i][j] = imgUrl.get(j).getAsJsonObject().get("imgurl").toString();
                                        Log.v("URL"+i+j,""+imgUrl.get(j).getAsJsonObject().get("imgurl"));
                                    }
                                }
                            }
                            //如果「img」這項為空
                            catch (Exception e){
                                e.printStackTrace();
                            }
                        }

                        Gson gson = new Gson();
                        Type collectionType = new TypeToken<List<ActivityInfo>>() {
                        }.getType();
                        datas = gson.fromJson(arrayResults, collectionType);
                    }
                    callback.onGetRestlt(datas);
                } catch (Exception ex) {
                    callback.onFail(ex);
                }
            }

            public void onFail(Exception ex) {
                callback.onFail(ex);
            }
        });
    }

    public interface CallbackResponse {
        void onResponse(String result);
        void onFail(Exception ex);
    }

    public interface GetRestaurantResponse{
        void onGetRestlt(ArrayList<Restaurant> result);
        void onFail(Exception ex);
    }

    public interface GetHotelResponse{
        void onGetRestlt(ArrayList<Hotel> result);
        void onFail(Exception ex);
    }

    public interface GetActivityInfoResponse{
        void onGetRestlt(ArrayList<ActivityInfo> result);
        void onFail(Exception ex);
    }
}
