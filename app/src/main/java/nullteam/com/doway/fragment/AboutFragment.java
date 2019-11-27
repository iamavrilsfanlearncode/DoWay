package nullteam.com.doway.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import nullteam.com.doway.R;

public class AboutFragment extends Fragment {
    ImageButton btn_share, btn_scan, btn_qrCode;
    ImageView img_cela, img_george, img_lula, img_polly;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_about, container, false); // 在 onCreateView 中返回 Fragment 的 Layout
    }

    // 在 onActivityCreated 中透過 getActivity() 獲取與 Fragment 關聯的 Activity，並為按鈕添加監聽事件
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        btn_share = getActivity().findViewById(R.id.btnShare);
        btn_scan = getActivity().findViewById(R.id.btnScan);
        btn_qrCode = getActivity().findViewById(R.id.btnQrCode);

        img_cela = getActivity().findViewById(R.id.imgCela);
        img_george = getActivity().findViewById(R.id.imgGeorge);
        img_lula = getActivity().findViewById(R.id.imgLula);
        img_polly = getActivity().findViewById(R.id.imgPolly);

        // 添加按鈕的監聽事件
        btn_share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "Clicked btnShare", Toast.LENGTH_LONG).show();
            }
        });

        btn_scan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "Clicked btnScan", Toast.LENGTH_LONG).show();
            }
        });

        btn_qrCode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "Clicked btnQrCode", Toast.LENGTH_LONG).show();
            }
        });
    }
}
