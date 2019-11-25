package nullteam.com.doway.activity;

import android.content.Intent;
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
import nullteam.com.doway.R;
import nullteam.com.doway.model.Restaurant;


public class RestaurantDetail extends AppCompatActivity {
    private Restaurant restaurant;
    private TextView tv_Tel,tv_Name,tv_Address,tv_FoodFeature;
    private ImageView iv_Default;
    private Button btn_Back;
    private ImageButton btn_Favorite;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.restaurant_detail);

        restaurant = (Restaurant)getIntent().getSerializableExtra("restaurant");
        tv_Tel = findViewById(R.id.Tel);
        tv_Tel.setText(restaurant.getTel());
        tv_Name = findViewById(R.id.Subject);
        tv_Name.setText(restaurant.getName());
        tv_Address =findViewById(R.id.Address);
        tv_Address.setText(restaurant.getAddress());
        tv_FoodFeature = findViewById(R.id.FoodFeature);
        tv_FoodFeature.setText(restaurant.getFoodFeature());
        //詳細頁圖片
        iv_Default = findViewById(R.id.Default);
        //如果取得的圖片URL不為空值，就將原有的預設圖片覆蓋掉
        if (!restaurant.getPicURL().isEmpty()){
            ImageLoader imageLoader = ImageLoader.getInstance();
            imageLoader.displayImage(restaurant.getPicURL(), iv_Default);
        }
        //按鈕部分
        //返回
        btn_Back = findViewById(R.id.BtnBack);
        btn_Back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent().setClass(RestaurantDetail.this, MainActivity.class));
                finish();
            }
        });
        //收藏
        btn_Favorite = findViewById(R.id.BtnFavorite);
        btn_Favorite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(RestaurantDetail.this,"收藏成功!", Toast.LENGTH_SHORT).show(); // version1
            }
        });
    }
}
