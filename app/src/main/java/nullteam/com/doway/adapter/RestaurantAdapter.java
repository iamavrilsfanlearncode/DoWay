package nullteam.com.doway.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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
        //用getCity()方法讀取每筆資料的縣市
        if(datas.get(position).getCity().equals("基隆市")){

        }
        if(datas.get(position).getCity().equals("新北市")){

        }
        if(datas.get(position).getCity().equals("台北市")){

        }
        if(datas.get(position).getCity().equals("桃園市")){

        }
        if(datas.get(position).getCity().equals("新竹縣")){

        }
        if(datas.get(position).getCity().equals("新竹市")){

        }
        if(datas.get(position).getCity().equals("苗栗縣")){

        }
        if(datas.get(position).getCity().equals("台中市")){

        }
        if(datas.get(position).getCity().equals("彰化縣")){

        }
        if(datas.get(position).getCity().equals("雲林縣")){

        }
        if(datas.get(position).getCity().equals("嘉義縣")){

        }
        if(datas.get(position).getCity().equals("台南市")){

        }
        if(datas.get(position).getCity().equals("高雄市")){

        }
        if(datas.get(position).getCity().equals("屏東縣")){

        }
        if(datas.get(position).getCity().equals("宜蘭縣")){

        }
        if(datas.get(position).getCity().equals("花蓮縣")){

        }
        if(datas.get(position).getCity().equals("台東縣")){

        }
        if(datas.get(position).getCity().equals("南投縣")){

        }
        if(datas.get(position).getCity().equals("連江縣")){

        }
        if(datas.get(position).getCity().equals("澎湖縣")){

        }
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
        //宣告為第三方的圓框套件
        de.hdodenhof.circleimageview.CircleImageView picImageView;

        public ViewHolder(View view) {
            super(view);
            nameTextView = view.findViewById(R.id.Name);
            telTextView = view.findViewById(R.id.Tel);
            addressTextView = view.findViewById(R.id.Address);
            picImageView = view.findViewById(R.id.Pic);
        }
    }
}
