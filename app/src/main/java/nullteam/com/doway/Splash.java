package nullteam.com.doway;

import android.content.Intent;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

public class Splash extends AppCompatActivity {
    private LinearLayout logo;
    private ImageView pic;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        Animation fadeIn = AnimationUtils.loadAnimation(Splash.this, R.anim.fade_in);
        logo = findViewById(R.id.logo);
        pic = findViewById(R.id.pic);
        logo.setAnimation(fadeIn);
        //設定沉睡時間
        Thread timer = new Thread(){
            @Override
            public void run(){
                super.run();
                //1000=1秒
                try {
                    sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                finally {
                    startActivity(new Intent(Splash.this,MainActivity.class));
                    finish();
                    //淡入淡出特效
                    overridePendingTransition(android.R.anim.fade_out,android.R.anim.fade_in);
                }
            };//設定沉睡時間 END

       };//Thread END

        //開始執行沉睡效果
        timer.start();
    }//onCreate End
}//Splash Activity End
