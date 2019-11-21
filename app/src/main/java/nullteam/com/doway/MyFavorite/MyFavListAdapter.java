package nullteam.com.doway.MyFavorite;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;
import nullteam.com.doway.R;
import nullteam.com.doway.model.Restaurant;

public class MyFavListAdapter extends BaseAdapter {
    LayoutInflater inflater;
    private Restaurant restaurant;
    private ArrayList<Restaurant> restaurants;

    public MyFavListAdapter(Context context, ArrayList<Restaurant> restaurants) {
        this.restaurants = restaurants;
        inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return restaurants.size();
    }

    @Override
    public Object getItem(int position) {
        return restaurants.get(position);
    }

    @Override
    public long getItemId(int position) {
        return restaurants.indexOf(getItem(position));
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Restaurant one_restaurant = (Restaurant) getItem(position);
        convertView = inflater.inflate(R.layout.item_restaurant, null);
        CircleImageView image_restaurant = convertView.findViewById(R.id.Pic);
        TextView name_restaurant = convertView.findViewById(R.id.Subject);
        TextView tel_restaurant = convertView.findViewById(R.id.Tel);
        TextView address_restaurant = convertView.findViewById(R.id.Address);
        Button btn_detail = convertView.findViewById(R.id.BtnDetail);

        name_restaurant.setText(one_restaurant.getName());
        tel_restaurant.setText(one_restaurant.getTel());
        address_restaurant.setText(one_restaurant.getAddress());

        //如果取得的圖片URL不為空值，就將原有的預設圖片覆蓋掉
        if (!restaurant.getPicURL().isEmpty()){
            ImageLoader imageLoader = ImageLoader.getInstance();
            imageLoader.displayImage(restaurant.getPicURL(), image_restaurant);
        }
        return convertView;
    }
}
