package nullteam.com.doway.QRCode;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import com.google.zxing.BarcodeFormat;
import com.journeyapps.barcodescanner.BarcodeEncoder;
import nullteam.com.doway.MainActivity;
import nullteam.com.doway.R;

public class GenerateQRCode extends AppCompatActivity implements View.OnClickListener {
    ImageView myQRCode;
    EditText edtUrl;
    Button btn_generate, btn_back;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_generate_qrcode);

        myQRCode = findViewById(R.id.myQRCode);
        edtUrl = findViewById(R.id.edtUrl);
        btn_generate = findViewById(R.id.BtnGenerate);
        btn_back = findViewById(R.id.BtnBack);

        btn_generate.setOnClickListener(this);
        btn_back.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.BtnGenerate:
                // 產生 QR Code
                getCode();
                break;
            case R.id.BtnBack:
                // 跳回首頁
                intent = new Intent(GenerateQRCode.this, MainActivity.class);
                startActivity(intent);
                finish();
                break;
        }
    }

    private void getCode() {
        // 呼叫 BarcodeEncoder 類別
        BarcodeEncoder encoder = new BarcodeEncoder();
        try{
            Bitmap bit = encoder.encodeBitmap(edtUrl.getText().toString(), BarcodeFormat.QR_CODE,800,800);
            myQRCode.setImageBitmap(bit);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
