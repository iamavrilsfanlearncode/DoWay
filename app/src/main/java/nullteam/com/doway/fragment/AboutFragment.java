package nullteam.com.doway.fragment;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import nullteam.com.doway.QRCode.ShowQRCode;
import nullteam.com.doway.R;

public class AboutFragment extends Fragment {
    ImageButton btn_share, btn_scan, btn_qrCode;
    ImageButton mail_cela, mail_george, mail_lula, mail_polly;
    ImageButton github_cela, github_george, github_lula, github_polly;
    ImageButton phone_cela, phone_george, phone_lula, phone_polly;
    Uri uri;
    Intent intent;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_about, container, false); // 在 onCreateView 中返回 Fragment 的 Layout
    }

    // 在 onActivityCreated 中透過 getActivity() 獲取與 Fragment 關聯的 Activity，並為按鈕添加監聽事件
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        init(); // 初始化介面元件

        // ---- 添加按鈕的監聽事件 START --- //
        btn_share.setOnClickListener(new View.OnClickListener() {
            // 分享 APP 給親朋好友
            @Override
            public void onClick(View v) {
                shareTo("兜we - 讓我們兜在一起❤",
                        "https://github.com/iamavrilsfanlearncode/DoWay",
                        "");
            }

            private void shareTo(String subject, String body, String chooserTitle) {
                Intent sharingIntent = new Intent(Intent.ACTION_SEND);
                sharingIntent.setType("text/plain");
                sharingIntent.putExtra(Intent.EXTRA_SUBJECT, subject);
                sharingIntent.putExtra(Intent.EXTRA_TEXT, body);

                startActivity(Intent.createChooser(sharingIntent, chooserTitle));
            }
        });

        btn_scan.setOnClickListener(new View.OnClickListener() {
            // 掃描 APP 的 QR Code 取得原始碼
            @Override
            public void onClick(View v) {
                intent = new Intent();
                intent.setClass(v.getContext(), ShowQRCode.class);
                startActivity(intent);
                ((Activity) v.getContext()).finish(); // 強制轉型
            }
        });

        btn_qrCode.setOnClickListener(new View.OnClickListener() {
            // 生成自己的 QR Code
            @Override
            public void onClick(View v) {

            }
        });

        mail_cela.setOnClickListener(new View.OnClickListener() {
            // 寄信給 Cela
            @Override
            public void onClick(View v) {
                intent = new Intent();
                intent.setAction(Intent.ACTION_SENDTO);
                intent.setData(Uri.parse("mailto:iamavrilsfan@gmail.com"));
                intent.putExtra(Intent.EXTRA_SUBJECT, "請輸入主旨");
                intent.putExtra(Intent.EXTRA_TEXT, "請輸入信件內容");
                startActivity(intent);
            }
        });

        mail_george.setOnClickListener(new View.OnClickListener() {
            // 寄信給 George
            @Override
            public void onClick(View v) {
                intent = new Intent();
                intent.setAction(Intent.ACTION_SENDTO);
                intent.setData(Uri.parse("mailto:georgecycuphy@gmail.com"));
                intent.putExtra(Intent.EXTRA_SUBJECT, "請輸入主旨");
                intent.putExtra(Intent.EXTRA_TEXT, "請輸入信件內容");
                startActivity(intent);
            }
        });

        mail_lula.setOnClickListener(new View.OnClickListener() {
            // 寄信給 Lula
            @Override
            public void onClick(View v) {
                intent = new Intent();
                intent.setAction(Intent.ACTION_SENDTO);
                intent.setData(Uri.parse("mailto:windandsprings@gmail.com"));
                intent.putExtra(Intent.EXTRA_SUBJECT, "請輸入主旨");
                intent.putExtra(Intent.EXTRA_TEXT, "請輸入信件內容");
                startActivity(intent);
            }
        });

        mail_polly.setOnClickListener(new View.OnClickListener() {
            // 寄信給 Polly
            @Override
            public void onClick(View v) {
                intent = new Intent();
                intent.setAction(Intent.ACTION_SENDTO);
                intent.setData(Uri.parse("mailto:yupollys654020@gmail.com"));
                intent.putExtra(Intent.EXTRA_SUBJECT, "請輸入主旨");
                intent.putExtra(Intent.EXTRA_TEXT, "請輸入信件內容");
                startActivity(intent);
            }
        });

        github_cela.setOnClickListener(new View.OnClickListener() {
            // 連到 Cela 的 GitHub
            @Override
            public void onClick(View v) {
                uri = Uri.parse("https://github.com/iamavrilsfanlearncode");
                intent = new Intent(Intent.ACTION_VIEW,uri);
                startActivity(intent);
            }
        });

        github_george.setOnClickListener(new View.OnClickListener() {
            // 連到 George 的 GitHub
            @Override
            public void onClick(View v) {
                uri = Uri.parse("https://github.com/George-Tseng");
                intent = new Intent(Intent.ACTION_VIEW,uri);
                startActivity(intent);
            }
        });

        github_lula.setOnClickListener(new View.OnClickListener() {
            // 連到 Lula 的 GitHub
            @Override
            public void onClick(View v) {
                uri = Uri.parse("https://github.com/LulaKao");
                intent = new Intent(Intent.ACTION_VIEW,uri);
                startActivity(intent);
            }
        });

        github_polly.setOnClickListener(new View.OnClickListener() {
            // 連到 Polly 的 GitHub
            @Override
            public void onClick(View v) {
                uri = Uri.parse("https://github.com/PollyWu0413");
                intent = new Intent(Intent.ACTION_VIEW,uri);
                startActivity(intent);
            }
        });

        phone_cela.setOnClickListener(new View.OnClickListener() {
            // 打電話給 Cela
            @Override
            public void onClick(View v) {
                uri = Uri.parse("tel:"+"0910271361");
                intent = new Intent(Intent.ACTION_VIEW,uri);
                startActivity(intent);
            }
        });

        phone_george.setOnClickListener(new View.OnClickListener() {
            // 打電話給 George
            @Override
            public void onClick(View v) {
                uri = Uri.parse("tel:"+"0911954504");
                intent = new Intent(Intent.ACTION_VIEW,uri);
                startActivity(intent);
            }
        });

        phone_lula.setOnClickListener(new View.OnClickListener() {
            // 打電話給 Lula
            @Override
            public void onClick(View v) {
                uri = Uri.parse("tel:"+"0970951857");
                intent = new Intent(Intent.ACTION_VIEW,uri);
                startActivity(intent);
            }
        });

        phone_polly.setOnClickListener(new View.OnClickListener() {
            // 打電話給 Polly
            @Override
            public void onClick(View v) {
                uri = Uri.parse("tel:"+"0930296255");
                intent = new Intent(Intent.ACTION_VIEW,uri);
                startActivity(intent);
            }
        });
        // ---- 添加按鈕的監聽事件 END --- //
    }


    // 初始化介面元件
    private void init() {

        // 關於 APP
        btn_share = getActivity().findViewById(R.id.btnShare);
        btn_scan = getActivity().findViewById(R.id.btnScan);
        btn_qrCode = getActivity().findViewById(R.id.btnQrCode);

        // E-mail 聯絡
        mail_cela = getActivity().findViewById(R.id.mail_cela);
        mail_george = getActivity().findViewById(R.id.mail_george);
        mail_lula = getActivity().findViewById(R.id.mail_lula);
        mail_polly = getActivity().findViewById(R.id.mail_polly);

        // 連結到 GitHub
        github_cela = getActivity().findViewById(R.id.github_cela);
        github_george = getActivity().findViewById(R.id.github_george);
        github_lula = getActivity().findViewById(R.id.github_lula);
        github_polly = getActivity().findViewById(R.id.github_polly);

        // 開啟手機內建打電話的功能
        phone_cela = getActivity().findViewById(R.id.phone_cela);
        phone_george = getActivity().findViewById(R.id.phone_george);
        phone_lula = getActivity().findViewById(R.id.phone_lula);
        phone_polly = getActivity().findViewById(R.id.phone_polly);
    }
}
