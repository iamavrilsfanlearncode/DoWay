package nullteam.com.doway;

import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

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
                            } catch (Exception ignored) {

                            }
                        }
                        response.close();
                    } catch (Exception ignored) {

                    }
                }
            }

            @Override
            public void onFailure(@NotNull Call call, @NotNull IOException e) {
                Log.d(TAG, "onFailure: " + e.getMessage());
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
                callback.onResponse(datas);
            }
        });
    }

    public interface CallbackResponse {
        void onResponse(String result);
    }

    public interface GetRestaurantResponse {
        void onResponse(ArrayList<Restaurant> result);
    }
}
