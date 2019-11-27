package nullteam.com.doway.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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
import nullteam.com.doway.model.Hotel;


public class HotelFragment extends Fragment {
    private RecyclerView listView;
    private HotelAdapter adapter;
    private ArrayList<Hotel> picHotel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_hotel, container, false);
        listView = root.findViewById(R.id.hotel_List);
        ArrayList<Hotel> dataHotel = new ArrayList<Hotel>();
        picHotel = new ArrayList<Hotel>();
        adapter = new HotelAdapter(this,dataHotel);
        final LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        listView.setLayoutManager(layoutManager);
        listView.setAdapter(adapter);

        //加入ProgressDialog
        DialogHelper.showProgressDialog(getActivity(), "更新住宿列表");
        OpenDataService.getInstance().GetPicHotel(new OpenDataService.GetHotelPicResponse(){
            @Override
            public void onGetRestlt(final ArrayList<Hotel> picResult) {
                getActivity().runOnUiThread(new Runnable(){
                    @Override
                    public void run() {
                        if(picResult != null){
                            picHotel = picResult;
                        }
                        OpenDataService.getInstance().GetHotel(new OpenDataService.GetHotelResponse(){
                            @Override
                            public void onGetRestlt(final ArrayList<Hotel> result) {
                                getActivity().runOnUiThread(new Runnable() {
                                    @Override
                                    public void run() {
                                        if (result != null) {
                                            //將上個方法中得到的URL，利用setImageUrl存入同一個adapter中
                                            for(int i = 0;i < result.size();i++){
                                                try{
                                                    if(picHotel.get(i).getImageUrl() != null){
                                                        result.get(i).setImageUrl(picHotel.get(i).getImageUrl());
                                                    }
                                                }
                                                catch (Exception e) {
                                                    e.printStackTrace();
                                                }
                                            }
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
                    }
                });
                DialogHelper.closeProgressDialog();
            }
            @Override
            public void onFail(final Exception ex) {
                getActivity().runOnUiThread(new Runnable(){
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