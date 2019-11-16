package nullteam.com.doway.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import nullteam.com.doway.R;
import nullteam.com.doway.model.ActivityInfo;

public class ActivityInfoAdapter extends RecyclerView.Adapter<ActivityInfoAdapter.ViewHolder>{
    private ArrayList<ActivityInfo> datas;

    public ActivityInfoAdapter(ArrayList<ActivityInfo> datas) {
        this.datas = datas;
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
        holder.subjectTextView.setText(datas.get(position).getSubject());
        holder.addressTextView.setText(datas.get(position).getActivityaddress());
        holder.telTextView.setText(datas.get(position).getLiaisontel());
    }

    @Override
    public int getItemCount() {
        return datas.size();
    }

    public void setDatas(ArrayList<ActivityInfo> datas) {
        this.datas = datas;
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView subjectTextView, telTextView, addressTextView;
        ImageView picImageView;

        public ViewHolder(View view) {
            super(view);
            subjectTextView = view.findViewById(R.id.Subject);
            telTextView = view.findViewById(R.id.Tel);
            addressTextView = view.findViewById(R.id.Address);
            picImageView = view.findViewById(R.id.Pic);
        }
    }
}
