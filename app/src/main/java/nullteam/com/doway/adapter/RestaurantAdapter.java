package nullteam.com.doway.adapter;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.ArrayList;
import java.util.stream.Collectors;

import nullteam.com.doway.R;
import nullteam.com.doway.activity.RestaurantDetail;
import nullteam.com.doway.model.Restaurant;

public class RestaurantAdapter extends RecyclerView.Adapter<RestaurantAdapter.ViewHolder> implements Filterable {
    private ArrayList<Restaurant> datas;
    private ArrayList<Restaurant> datasFiltered;
    private Fragment mFragment;

    //範例網站
    //https://litotom.com/2016/03/26/%E6%B8%85%E5%96%AE%E5%85%83%E4%BB%B6%E5%AF%A6%E4%BD%9C%EF%BC%8D%E4%B8%8B%E6%8B%89%E5%BC%8F%E9%81%B8%E5%96%AEspinner/
    //https://www.androidhive.info/2017/11/android-recyclerview-with-search-filter-functionality/
    //http://cooking-java.blogspot.com/2010/02/android-spinner.html
    public RestaurantAdapter(Fragment fragment, ArrayList<Restaurant> datas) {
        mFragment = fragment;
        this.datas = datas;
        this.datasFiltered = datas;
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
        Restaurant data = datasFiltered.get(position);

        holder.nameTextView.setText(data.getName());
        holder.addressTextView.setText(data.getAddress());
        holder.telTextView.setText(data.getTel());
        holder.restaurant = data;

        //用getCity()方法取得每筆資料的縣市
        holder.cityTextView.setText(data.getCity());
        if (!data.getPicURL().isEmpty()){
            ImageLoader imageLoader = ImageLoader.getInstance();
            imageLoader.displayImage(data.getPicURL(), holder.picImageView);
        }

    }

    @Override
    public int getItemCount() {
        return datasFiltered.size();
    }

    public void setDatas(ArrayList<Restaurant> datas) {
        this.datas = datas;
        notifyDataSetChanged();
    }

    @Override
    public Filter getFilter() {
        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence charSequence) {
                ArrayList<Restaurant> filteredList = new ArrayList<>();
                String charString = charSequence.toString();
                if (charString.isEmpty() || charString.equals("顯示全部")) {
                    filteredList = datas;
                } else {

                    for (Restaurant row : datas) {
                        if (row.getCity().equals(charSequence)) {
                            filteredList.add(row);
                        }
                    }
                }

                FilterResults filterResults = new FilterResults();
                filterResults.values = filteredList;
                return filterResults;
            }

            @Override
            protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
                datasFiltered = (ArrayList<Restaurant>) filterResults.values;
                notifyDataSetChanged();
            }
        };
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView nameTextView, telTextView, addressTextView, cityTextView;
        ImageButton but_detail;
        //宣告為第三方的圓框套件
        de.hdodenhof.circleimageview.CircleImageView picImageView;

        Restaurant restaurant;

        public ViewHolder(View view) {
            super(view);
            nameTextView = view.findViewById(R.id.Subject);
            telTextView = view.findViewById(R.id.Tel);
            addressTextView = view.findViewById(R.id.Address);
            picImageView = view.findViewById(R.id.Pic);
			// add by G
			cityTextView = view.findViewById(R.id.City);
            but_detail = view.findViewById(R.id.BtnDetail);


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
