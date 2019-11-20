package nullteam.com.doway.adapter;

import android.app.AlertDialog;
import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

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
        Restaurant data = datas.get(position);

        holder.nameTextView.setText(data.getName());
        holder.addressTextView.setText(data.getAddress());
        holder.telTextView.setText(data.getTel());
        holder.restaurant = data;

        //用getCity()方法取得每筆資料的縣市
        holder.cityTextView.setText(datas.get(position).getCity());
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
