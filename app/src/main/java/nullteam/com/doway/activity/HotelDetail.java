package nullteam.com.doway.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.nostra13.universalimageloader.core.ImageLoader;

import nullteam.com.doway.MainActivity;
import nullteam.com.doway.R;
import nullteam.com.doway.model.Hotel;

public class HotelDetail extends AppCompatActivity {
    private Hotel hotel;
    private TextView tv_Tel,tv_Name,tv_Add,tv_Toldescribe;
    private Button btn_Back,btn_Favorite;
    private ImageView iv_Default;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hotel_detail);

        //文字部份
        hotel = (Hotel)getIntent().getSerializableExtra("hotel");
        tv_Tel = findViewById(R.id.Tel);
        tv_Tel.setText(hotel.getTel());
        tv_Name = findViewById(R.id.Subject);
        tv_Name.setText(hotel.getName());
        tv_Add =findViewById(R.id.Add);
        tv_Add.setText(hotel.getAdd());
        tv_Toldescribe = findViewById(R.id.Toldescribe);
        tv_Toldescribe.setText(hotel.getToldescribe());
        // 詳細頁圖片
        iv_Default = findViewById(R.id.Default);
        // 如果取得的圖片URL不為空值，就將原有的預設圖片覆蓋掉
        try{
            if (!hotel.getImageUrl().isEmpty()){
                ImageLoader imageLoader = ImageLoader.getInstance();
                imageLoader.displayImage(hotel.getImageUrl(), iv_Default);
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        //按鈕部分
        //返回
        btn_Back = findViewById(R.id.BtnBack);
        btn_Back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent().setClass(HotelDetail.this, MainActivity.class));
                finish();
            }
        });
        //收藏
        btn_Favorite =findViewById(R.id.BtnFavorite);
        btn_Favorite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(HotelDetail.this,"收藏成功!", Toast.LENGTH_SHORT).show(); // version1
            }
        });
    }


}
