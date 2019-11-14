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
import nullteam.com.doway.model.Restaurant;

public class RestaurantAdapter extends RecyclerView.Adapter<RestaurantAdapter.ViewHolder> {
    private ArrayList<Restaurant> datas;

    public RestaurantAdapter(ArrayList<Restaurant> datas) {
        this.datas = datas;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_restaurant, parent, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.nameTextView.setText(datas.get(position).getName());
        holder.addressTextView.setText(datas.get(position).getAddress());
        holder.telTextView.setText(datas.get(position).getTel());

     }

    @Override
    public int getItemCount() {
        return datas.size();
    }

    public void setDatas(ArrayList<Restaurant> datas) {
        this.datas = datas;
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView nameTextView, telTextView, addressTextView;
        ImageView picImageView;

        public ViewHolder(View view) {
            super(view);
            nameTextView = view.findViewById(R.id.Name);
            telTextView = view.findViewById(R.id.Tel);
            addressTextView = view.findViewById(R.id.Address);
            picImageView = view.findViewById(R.id.Pic);
        }
    }
}
