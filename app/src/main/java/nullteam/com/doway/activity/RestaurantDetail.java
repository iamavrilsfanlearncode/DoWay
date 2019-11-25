package nullteam.com.doway.activity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.nostra13.universalimageloader.core.ImageLoader;
import nullteam.com.doway.MainActivity;
import nullteam.com.doway.MyFavorite.MyFavDbAdapter;
import nullteam.com.doway.R;
import nullteam.com.doway.model.Restaurant;

public class RestaurantDetail extends AppCompatActivity {
    private Restaurant restaurant;
    private TextView tv_Tel,tv_Name,tv_Address,tv_FoodFeature;
    private ImageView iv_Default;
    private Button btn_Back;
    private ImageButton btn_Favorite;
    private MyFavDbAdapter myFavDbAdapter;
    Cursor lists;
    boolean isExists = false;
    String my_fav_name;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.restaurant_detail);

        restaurant = (Restaurant)getIntent().getSerializableExtra("restaurant");
        tv_Tel = findViewById(R.id.Tel);
        tv_Name = findViewById(R.id.Subject);
        tv_Address =findViewById(R.id.Address);
        tv_FoodFeature = findViewById(R.id.FoodFeature);
        tv_Tel.setText(restaurant.getTel());
        tv_Name.setText(restaurant.getName());
        tv_Address.setText(restaurant.getAddress());
        tv_FoodFeature.setText(restaurant.getFoodFeature());

        // 詳細頁圖片
        iv_Default = findViewById(R.id.Default);
        // 如果取得的圖片URL不為空值，就將原有的預設圖片覆蓋掉
        if (!restaurant.getPicURL().isEmpty()){
            ImageLoader imageLoader = ImageLoader.getInstance();
            imageLoader.displayImage(restaurant.getPicURL(), iv_Default);
        }

        // 按鈕部分
        // 返回
        btn_Back = findViewById(R.id.BtnBack);
        btn_Back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent().setClass(RestaurantDetail.this, MainActivity.class));
                finish();
            }
        });
        //------------ 收藏功能開始
        btn_Favorite = findViewById(R.id.BtnFavorite);

        myFavDbAdapter = new MyFavDbAdapter(this);
        lists = myFavDbAdapter.listMyFavRestaurant();

        btn_Favorite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
 		        addFavorite(restaurant, lists, restaurant.getName());
            }
        });
    }

    public void addFavorite(Restaurant restaurant, Cursor lists, String name_restaurant){
        lists.moveToFirst(); // 不加這句的話，收藏後馬上再按收藏，會閃退
        for (int i = 0; i < lists.getCount(); i++) {
            my_fav_name = lists.getString(lists.getColumnIndexOrThrow("name_restaurant"));
            if (name_restaurant.equals(my_fav_name)) {
                // 若已收藏，設定 isExists = true
                isExists = true;
                break; // 跳出迴圈
            }
            lists.moveToNext();  // Cursor 移到下一筆資料
            // 若不加上面那句的話，就會有重複收藏的問題，迴圈會一直卡在第一筆資料，只有第一筆資料不會被重複收藏
        }
        if (isExists == false) {
            // 加入收藏
            myFavDbAdapter.createMyFavRestaurant(
                    restaurant.getPicURL(),
                    restaurant.getName(),
                    restaurant.getTel(),
                    restaurant.getAddress()
            );
            // 加入收藏後愛心會變色
            btn_Favorite.setBackgroundResource(R.drawable.like);
        } else {
            // 已收藏，不能再重複收藏
            Toast.makeText(this, "已經收藏過囉～", Toast.LENGTH_SHORT).show();
        }
    }
    //------------ 收藏功能結束
}
