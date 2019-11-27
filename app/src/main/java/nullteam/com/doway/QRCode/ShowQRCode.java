package nullteam.com.doway.QRCode;

import androidx.appcompat.app.AppCompatActivity;
import com.journeyapps.barcodescanner.BarcodeEncoder;
import com.google.zxing.BarcodeFormat;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import nullteam.com.doway.MainActivity;
import nullteam.com.doway.R;

public class ShowQRCode extends AppCompatActivity {
    ImageView qrCode_show;
    Button btnBack;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_qrcode);

        qrCode_show = findViewById(R.id.qrCodeShow);

        String url = "https://github.com/iamavrilsfanlearncode/DoWay";
        try{
            BarcodeEncoder barcodeEncoder = new BarcodeEncoder();
            Bitmap bitmap = barcodeEncoder.encodeBitmap(url, BarcodeFormat.QR_CODE,500,500);
            qrCode_show.setImageBitmap(bitmap);
        } catch (Exception e) {
            e.printStackTrace();
        }

        btnBack = findViewById(R.id.BtnBack);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 跳回首頁
                intent = new Intent();
                intent.setClass(ShowQRCode.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });

    }
}
