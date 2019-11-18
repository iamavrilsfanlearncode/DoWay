package nullteam.com.doway.adapter;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import java.security.Key;
import java.util.ArrayList;

import nullteam.com.doway.R;
import nullteam.com.doway.activity.RestaurantDetail;
import nullteam.com.doway.model.Restaurant;

public class RestaurantAdapter extends RecyclerView.Adapter<RestaurantAdapter.ViewHolder> {
    private ArrayList<Restaurant> datas;
    private Fragment mFragment;

    public RestaurantAdapter(Fragment fragment, ArrayList<Restaurant> datas) {
        mFragment = fragment;
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
        holder.restaurant = datas.get(position);
        //用getCity()方法讀取每筆資料的縣市
        if (datas.get(position).getCity().equals("基隆市")) {
            holder.picImageView.setImageResource(R.drawable.fullcolor_blue);
        }
        if (datas.get(position).getCity().equals("新北市")) {
            holder.picImageView.setImageResource(R.drawable.fullcolor_cyan);
        }
        if(datas.get(position).getCity().equals("臺北市")){
            holder.picImageView.setImageResource(R.drawable.fullcolor_green);
        }
        if (datas.get(position).getCity().equals("桃園市")) {
            holder.picImageView.setImageResource(R.drawable.fullcolor_purple);
        }
        if (datas.get(position).getCity().equals("新竹縣")) {
            holder.picImageView.setImageResource(R.drawable.fullcolor_red);
        }
        if (datas.get(position).getCity().equals("新竹市")) {
            holder.picImageView.setImageResource(R.drawable.fullcolor_yellow);
        }
        if (datas.get(position).getCity().equals("苗栗縣")) {
            holder.picImageView.setImageResource(R.drawable.fullcolor);
        }
        if(datas.get(position).getCity().equals("臺中市")){
            holder.picImageView.setImageResource(R.drawable.fullcolor_reverse);
        }
        if (datas.get(position).getCity().equals("彰化縣")) {
            holder.picImageView.setImageResource(R.drawable.movieicon1);
        }
        if (datas.get(position).getCity().equals("雲林縣")) {
            holder.picImageView.setImageResource(R.drawable.baseball_icon);
        }
        if (datas.get(position).getCity().equals("嘉義縣")) {
            holder.picImageView.setImageResource(R.drawable.fullcolor_high);
        }
        if(datas.get(position).getCity().equals("臺南市")){
            holder.picImageView.setImageResource(R.drawable.fullcolor_low);
        }
        if (datas.get(position).getCity().equals("高雄市")) {
            holder.picImageView.setImageResource(R.drawable.fullcolor_mid);
        }
        if (datas.get(position).getCity().equals("屏東縣")) {
            holder.picImageView.setImageResource(R.drawable.fullcolor_high_high);
        }
        if (datas.get(position).getCity().equals("宜蘭縣")) {
            holder.picImageView.setImageResource(R.drawable.fullcolor_high_low);
        }
        if (datas.get(position).getCity().equals("花蓮縣")) {
            holder.picImageView.setImageResource(R.drawable.fullcolor_low_high);
        }
        if(datas.get(position).getCity().equals("臺東縣")){
            holder.picImageView.setImageResource(R.drawable.fullcolor_low_low);
        }
        if (datas.get(position).getCity().equals("南投縣")) {
            holder.picImageView.setImageResource(R.drawable.bible_icon);
        }
        if (datas.get(position).getCity().equals("連江縣")) {
            holder.picImageView.setImageResource(R.drawable.storage_icon_2);
        }
		if (datas.get(position).getCity().equals("金門縣")){
            holder.picImageView.setImageResource(R.drawable.dbicon1);
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
        TextView nameTextView, telTextView, addressTextView, cityTextView;
        Button but_detail, btn_favorite;
        //宣告為第三方的圓框套件
        de.hdodenhof.circleimageview.CircleImageView picImageView;

        Restaurant restaurant;

        public ViewHolder(View view) {
            super(view);
            nameTextView = view.findViewById(R.id.Name);
            telTextView = view.findViewById(R.id.Tel);
            addressTextView = view.findViewById(R.id.Address);
            picImageView = view.findViewById(R.id.Pic);
			// add by G
			cityTextView = view.findViewById(R.id.City);
            but_detail = view.findViewById(R.id.BtnDetail);
            btn_favorite = view.findViewById(R.id.BtnFavorite);

            //跳至詳細頁的點擊事件
            but_detail.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent();
                    Bundle bag = new Bundle();
                    bag.putSerializable("restaurant", restaurant);
                    intent.putExtras(bag);
                    intent.setClass(mFragment.getActivity(), RestaurantDetail.class);
                    mFragment.getActivity().startActivity(intent);
                }
            });//跳至詳細頁 END
        }
    }// ViewHolder extends RecyclerView.ViewHolder   END
}//RestaurantAdapter END
