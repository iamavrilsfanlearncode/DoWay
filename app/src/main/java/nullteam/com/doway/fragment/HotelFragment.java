package nullteam.com.doway.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import nullteam.com.doway.OpenDataService;
import nullteam.com.doway.R;
import nullteam.com.doway.Utils.DialogHelper;
import nullteam.com.doway.adapter.HotelAdapter;
import nullteam.com.doway.adapter.RestaurantAdapter;
import nullteam.com.doway.model.Hotel;
import nullteam.com.doway.model.Restaurant;

public class HotelFragment extends Fragment {
    private RecyclerView listView;
    private HotelAdapter adapter;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_hotel, container, false);
        listView = root.findViewById(R.id.hotel_List);
        ArrayList<Hotel> result = new ArrayList<Hotel>();
        adapter = new HotelAdapter(result);
        final LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        listView.setLayoutManager(layoutManager);
        listView.setAdapter(adapter);

        //加入ProgressDialog
        DialogHelper.showProgressDialog(getActivity(), "更新飯店列表");
        OpenDataService.getInstance().GetHotel(new OpenDataService.GetHotelResponse(){
            @Override
            public void onGetRestlt(final ArrayList<Hotel> result) {
                getActivity().runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        if (result != null) {
                            adapter.setDatas(result);
                            adapter.notifyDataSetChanged();
                        }
                    }
                });
                DialogHelper.closeProgressDialog();
            }

            @Override
            public void onFail(final Exception ex) {
                getActivity().runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(getActivity(), ex.getLocalizedMessage(), Toast.LENGTH_LONG).show();
                    }
                });
            }
        });

        return root;
    }
}