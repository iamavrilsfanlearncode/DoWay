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
import nullteam.com.doway.model.ActivityInfo;

public class ActivityInfoDetail extends AppCompatActivity {
    private ActivityInfo activityInfo;
    private TextView tv_Subject,tv_activitytime,tv_activityaddress,tv_detailcontent;
    private Button btn_Back,btn_Favorite;
    private ImageView iv_Default;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activityinfo_detail);

        //文字部份
        activityInfo = (ActivityInfo) getIntent().getSerializableExtra("activityInfo");

        tv_Subject = findViewById(R.id.Subject);
        tv_Subject.setText(activityInfo.getSubject());
        tv_activitytime = findViewById(R.id.activitytime);
        tv_activitytime.setText(activityInfo.getActivitytime());
        tv_activityaddress = findViewById(R.id.activityaddress);
        tv_activityaddress.setText(activityInfo.getActivityaddress());
        tv_detailcontent = findViewById(R.id.detailcontent);
        tv_detailcontent.setText(activityInfo.getDetailcontent());

        // 詳細頁圖片
        iv_Default = findViewById(R.id.Default);
        // 如果取得的圖片URL不為空值，就將原有的預設圖片覆蓋掉
        try{
            if (!activityInfo.getImageUrl().isEmpty()){
                ImageLoader imageLoader = ImageLoader.getInstance();
                imageLoader.displayImage(activityInfo.getImageUrl(), iv_Default);
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
                startActivity(new Intent().setClass(ActivityInfoDetail.this, MainActivity.class));
                finish();
            }
        });
        //收藏
        btn_Favorite = findViewById(R.id.BtnFavorite);
        btn_Favorite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(ActivityInfoDetail.this,"收藏成功!", Toast.LENGTH_SHORT).show(); // version1
            }
        });
    }

}
