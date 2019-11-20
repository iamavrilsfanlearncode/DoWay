package nullteam.com.doway.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import nullteam.com.doway.MainActivity;
import nullteam.com.doway.R;
import nullteam.com.doway.model.Hotel;

public class HotelDetail extends AppCompatActivity {
    private Hotel hotel;
    private TextView tv_Tel,tv_Name,tv_Add,tv_Toldescribe;
    private Button btn_Back,btn_Favorite;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hotel_detail);

        hotel = (Hotel)getIntent().getSerializableExtra("hotel");
        tv_Tel = findViewById(R.id.Tel);
        tv_Tel.setText(hotel.getTel());
        tv_Name = findViewById(R.id.Subject);
        tv_Name.setText(hotel.getName());
        tv_Add =findViewById(R.id.activityaddress);
        tv_Add.setText(hotel.getAdd());
        tv_Toldescribe = findViewById(R.id.Toldescribe);
        tv_Toldescribe.setText(hotel.getToldescribe());


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
        btn_Favorite = findViewById(R.id.BtnFavorite);
        btn_Favorite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(HotelDetail.this,"收藏成功!", Toast.LENGTH_SHORT).show(); // version1
            }
        });
    }


}
