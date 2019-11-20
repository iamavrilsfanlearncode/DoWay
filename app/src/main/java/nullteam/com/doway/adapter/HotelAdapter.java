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
import nullteam.com.doway.model.Hotel;

public class HotelAdapter extends RecyclerView.Adapter<HotelAdapter.ViewHolder>{
    private ArrayList<Hotel> datas;

    public HotelAdapter(ArrayList<Hotel> datas) {
        this.datas = datas;
    }

    @NonNull
    @Override
    public HotelAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_hotel, parent, false);
        HotelAdapter.ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.nameTextView.setText(datas.get(position).getName());
        holder.addressTextView.setText(datas.get(position).getAdd());
        holder.telTextView.setText(datas.get(position).getTel());
    }

    @Override
    public int getItemCount() {
        return datas.size();
    }

    public void setDatas(ArrayList<Hotel> datas) {
        this.datas = datas;
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView nameTextView, telTextView, addressTextView;
        ImageView picImageView;

        public ViewHolder(View view) {
            super(view);
            nameTextView = view.findViewById(R.id.Subject);
            telTextView = view.findViewById(R.id.closedate);
            addressTextView = view.findViewById(R.id.activityaddress);
            picImageView = view.findViewById(R.id.Pic);
        }
    }


}
