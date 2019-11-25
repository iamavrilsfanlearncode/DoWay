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
import nullteam.com.doway.model.ActivityPicInfo;


public class ActivityInfoFragment extends Fragment {
    private RecyclerView listView;
    private ActivityInfoAdapter adapter;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_activityinfo, container, false);
        listView = root.findViewById(R.id.activityinfo_List);
        ArrayList<ActivityInfo> result = new ArrayList<ActivityInfo>();
        //加入ActivityPicInfo
        ArrayList<ActivityPicInfo> picResult = new ArrayList<ActivityPicInfo>();
        adapter = new ActivityInfoAdapter(this,result,picResult);
        final LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        listView.setLayoutManager(layoutManager);
        listView.setAdapter(adapter);

        //加入ProgressDialog
        DialogHelper.showProgressDialog(getActivity(), "更新活動列表");
        OpenDataService.getInstance().GetActivityInfo(new OpenDataService.GetActivityInfoResponse(){
            @Override
            public void onGetRestlt(final ArrayList<ActivityInfo> result) {
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
            public void onGetPicRestlt(final ArrayList<ActivityPicInfo> picResult){
                getActivity().runOnUiThread(new Runnable(){
                    @Override
                    public void run() {
                        if (picResult != null) {
                            adapter.setPicDatas(picResult);
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
        return root;
    }
}