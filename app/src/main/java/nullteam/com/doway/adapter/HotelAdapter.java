package nullteam.com.doway.adapter;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import com.nostra13.universalimageloader.core.ImageLoader;
import java.util.ArrayList;
import nullteam.com.doway.R;
import nullteam.com.doway.activity.HotelDetail;
import nullteam.com.doway.model.Hotel;

public class HotelAdapter extends RecyclerView.Adapter<HotelAdapter.ViewHolder>{
    private ArrayList<Hotel> datas;
    private Fragment mFragment;

    public HotelAdapter(Fragment fragment, ArrayList<Hotel> datas) {
        mFragment = fragment;
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
        Hotel data = datas.get(position);

        holder.nameTextView.setText(data.getName());
        holder.addTextView.setText(data.getAdd());
        holder.TelTextView.setText(data.getTel());
        holder.hotel = data;
        //如果URL不為空，就顯示從URL載下來的圖片
        try{
            if (!data.getImageUrl().isEmpty()){
                ImageLoader imageLoader = ImageLoader.getInstance();
                imageLoader.displayImage(data.getImageUrl(), holder.picImageView);
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
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
        TextView nameTextView, TelTextView, addTextView;
        ImageButton but_detail;
        //宣告為第三方的圓框套件
        de.hdodenhof.circleimageview.CircleImageView picImageView;
        Hotel hotel;

        public ViewHolder(View view) {
            super(view);
            nameTextView = view.findViewById(R.id.Subject);
            TelTextView = view.findViewById(R.id.Tel);
            addTextView = view.findViewById(R.id.Add);
            picImageView = view.findViewById(R.id.Pic);
            // add by G
            but_detail = view.findViewById(R.id.BtnDetail);

            //跳至詳細頁的點擊事件
            but_detail.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent();
                    Bundle bag = new Bundle();
                    bag.putSerializable("hotel", hotel);
                    intent.putExtras(bag);
                    intent.setClass(mFragment.getActivity(), HotelDetail.class);
                    mFragment.getActivity().startActivity(intent);
                }
            });//跳至詳細頁 END
        }
    }
}
