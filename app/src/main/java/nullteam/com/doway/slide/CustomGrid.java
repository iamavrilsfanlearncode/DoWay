package nullteam.com.doway.slide;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.ArrayList;

import nullteam.com.doway.R;
import nullteam.com.doway.activity.GridviewDetail;
import nullteam.com.doway.activity.RestaurantDetail;
import nullteam.com.doway.adapter.RestaurantAdapter;
import nullteam.com.doway.model.GridView;
import nullteam.com.doway.model.Restaurant;

public class CustomGrid extends RecyclerView.Adapter<CustomGrid.ViewHolder> {
    private ArrayList<GridView> datas;
    private Fragment mFragment;

    public CustomGrid(Fragment fragment, ArrayList<GridView> datas) {
        mFragment = fragment;
        this.datas = datas;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.grid_layout, parent, false);
        CustomGrid.ViewHolder vh = new ViewHolder(v);
        return vh;
    }


    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        GridView data = datas.get(position);
        holder.nameTextView.setText(data.getName());
        holder.gridView = data;

        if (!data.getPicURL().isEmpty()){
            ImageLoader imageLoader = ImageLoader.getInstance();
            imageLoader.displayImage(datas.get(position).getPicURL(), holder.btn_detail);
        }


    }

    @Override
    public int getItemCount() {return datas.size();}

    public void setDatas(ArrayList<GridView> datas) {
        this.datas = datas;
        notifyDataSetChanged();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView nameTextView;
        GridView gridView;
        ImageButton btn_detail;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            nameTextView = itemView.findViewById(R.id.GridTxt);
            btn_detail = itemView.findViewById(R.id.GridImg);

            btn_detail.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent();
                    Bundle bag = new Bundle();
                    bag.putSerializable("grid", gridView);
                    intent.putExtras(bag);
                    intent.setClass(mFragment.getActivity(), GridviewDetail.class);
                    mFragment.getActivity().startActivity(intent);
                }
            });



        }
    }
}

