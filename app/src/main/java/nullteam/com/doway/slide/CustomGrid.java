package nullteam.com.doway.slide;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.ArrayList;

import nullteam.com.doway.R;
import nullteam.com.doway.model.Restaurant;

public class CustomGrid extends RecyclerView.Adapter<CustomGrid.ViewHolder> {
    private ArrayList<Restaurant> datas;
    private Fragment mFragment;

    public CustomGrid(Fragment mFragment,ArrayList<Restaurant> datas) {
        this.datas = datas;
        this.mFragment = mFragment;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.grid_layout,parent,false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }


    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Restaurant data = datas.get(position);
        holder.nameTextView.setText(data.getName());
        holder.restaurant = data;


    }

    @Override
    public int getItemCount() {return datas.size();}

    public void setDatas(ArrayList<Restaurant>datas){
        this.datas = datas;
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView nameTextView;
        de.hdodenhof.circleimageview.CircleImageView picImageView;
        Restaurant restaurant;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            nameTextView = itemView.findViewById(R.id.Subject);
            picImageView = itemView.findViewById(R.id.Pic);
        }
    }
}

