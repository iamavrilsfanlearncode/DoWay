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
import nullteam.com.doway.adapter.ActivityInfoAdapter;

import nullteam.com.doway.model.ActivityInfo;


public class ActivityInfoFragment extends Fragment {
    private RecyclerView listView;
    private ActivityInfoAdapter adapter;
    private ArrayList<ActivityInfo> picInfo;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_activityinfo, container, false);
        listView = root.findViewById(R.id.activityinfo_List);
        ArrayList<ActivityInfo> dataInfo = new ArrayList<ActivityInfo>();
        picInfo = new ArrayList<ActivityInfo>();
        adapter = new ActivityInfoAdapter(this,dataInfo);
        final LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        listView.setLayoutManager(layoutManager);
        listView.setAdapter(adapter);

        //加入ProgressDialog
        DialogHelper.showProgressDialog(getActivity(), "更新活動列表");
        OpenDataService.getInstance().GetActivityPicInfo(new OpenDataService.GetActivityPicInfoResponse(){
            @Override
            public void onGetRestlt(final ArrayList<ActivityInfo> picResult) {
                getActivity().runOnUiThread(new Runnable(){
                    @Override
                    public void run() {
                        if(picResult != null){
                            picInfo = picResult;
                        }
                        OpenDataService.getInstance().GetActivityInfo(new OpenDataService.GetActivityInfoResponse(){
                            @Override
                            public void onGetRestlt(final ArrayList<ActivityInfo> result) {
                                getActivity().runOnUiThread(new Runnable() {
                                    @Override
                                    public void run() {
                                        if (result != null) {
                                            //將上個方法中得到的URL，利用setImageUrl存入同一個adapter中
                                            for(int i = 0;i < result.size();i++) {
                                                try{
                                                    if(picInfo.get(i).getImageUrl() != null){
                                                        result.get(i).setImageUrl(picInfo.get(i).getImageUrl());
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
                            }

                            @Override
                            public void onFail(final Exception ex) {
                                DialogHelper.closeProgressDialog();
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