package nullteam.com.doway.adapter;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import nullteam.com.doway.R;
import nullteam.com.doway.activity.ActivityInfoDetail;
import nullteam.com.doway.model.ActivityInfo;
import nullteam.com.doway.model.ActivityPicInfo;

public class ActivityInfoAdapter extends RecyclerView.Adapter<ActivityInfoAdapter.ViewHolder>{
    private ArrayList<ActivityInfo> datas;
    private Fragment mFragment;
    private ArrayList<ActivityPicInfo> picDatas;

    public ActivityInfoAdapter(Fragment fragment,ArrayList<ActivityInfo> datas,ArrayList<ActivityPicInfo> picDatas) {
        mFragment = fragment;
        this.datas = datas;
        this.picDatas = picDatas;
    }

    @NonNull
    @Override
    public ActivityInfoAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_activityinfo, parent, false);
        ActivityInfoAdapter.ViewHolder vh = new ActivityInfoAdapter.ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull ActivityInfoAdapter.ViewHolder holder, int position) {
        ActivityInfo data = datas.get(position);

        holder.subjectTextView.setText(data.getSubject());
        holder.addTextView.setText(data.getActivityaddress());
        holder.atTextView.setText(data.getActivitytime());
        holder.activityInfo = data;

        //取得datasourceunit文字
        holder.dsuTextView.setText(datas.get(position).getDatasourceunit());
    }

    @Override
    public int getItemCount() {
        return datas.size();
    }

    public void setDatas(ArrayList<ActivityInfo> datas) {
        this.datas = datas;
        notifyDataSetChanged();
    }

    public void setPicDatas(ArrayList<ActivityPicInfo> picDatas) {
        this.picDatas = picDatas;
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView subjectTextView, atTextView, addTextView,dsuTextView;
        ImageButton but_detail;
        //宣告為第三方的圓框套件
        de.hdodenhof.circleimageview.CircleImageView picImageView;

        ActivityInfo activityInfo;
        ActivityPicInfo activityPicInfo;

        public ViewHolder(View view) {
            super(view);
            subjectTextView = view.findViewById(R.id.Subject);
            atTextView = view.findViewById(R.id.activitytime);
            addTextView = view.findViewById(R.id.activityaddress);
            picImageView = view.findViewById(R.id.Pic);
            but_detail = view.findViewById(R.id.BtnDetail);
            dsuTextView = view.findViewById(R.id.datasourceunit);

            //跳至詳細頁的點擊事件
            but_detail.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent();
                    Bundle bag = new Bundle();
                    bag.putSerializable("activityInfo", activityInfo);
                    bag.putSerializable("activityPicInfo", activityPicInfo);
                    intent.putExtras(bag);
                    intent.setClass(mFragment.getActivity(), ActivityInfoDetail.class);
                    mFragment.getActivity().startActivity(intent);
                }
            });//跳至詳細頁 END
        }
    }
}
