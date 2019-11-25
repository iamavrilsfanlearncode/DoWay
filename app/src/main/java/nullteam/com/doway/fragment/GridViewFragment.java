package nullteam.com.doway.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.PagerSnapHelper;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import nullteam.com.doway.OpenDataService;
import nullteam.com.doway.R;
import nullteam.com.doway.Utils.DialogHelper;
import nullteam.com.doway.adapter.RestaurantAdapter;
import nullteam.com.doway.model.Restaurant;
import nullteam.com.doway.slide.CustomGrid;
import nullteam.com.doway.slide.SmoothLinearLayoutManager;
import nullteam.com.doway.slide.ViewPagerAdapter;

public class GridViewFragment extends Fragment {
    private List<Integer> list = new ArrayList<>(3);
    RecyclerView recyclerView;
    GridLayoutManager layoutManager;
    public CustomGrid adapter;
    public ArrayList<Restaurant> Gird_Data = null;


   // private int iconId[] = {R.drawable.aa, R.drawable.bb, R.drawable.cc, R.drawable.dd, R.drawable.ee, R.drawable.ff};
   // private String nameList[] = {"十股糖仁文創園區", "國家歌劇院", "傳統藝術中心", "清水斷崖", "奇美博物館", "六福村"};

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_gridview, container, false);

        recyclerView = root.findViewById(R.id.Gridrecycler);
        Gird_Data = new ArrayList<Restaurant>();
        Gird_Data.add(new Restaurant());

       // ArrayList<Restaurant> result = new ArrayList<Restaurant>();
        adapter = new CustomGrid(this,result);
        layoutManager = new GridLayoutManager(getActivity(), 2);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(layoutManager);


        recyclerView.setAdapter(adapter);


        list.add(R.drawable.aaa);
        list.add(R.drawable.b);
        list.add(R.drawable.c);

        final ViewPagerAdapter adapter = new ViewPagerAdapter(list, getActivity());
        final RecyclerView recyclerView = root.findViewById(R.id.recycler);
        final SmoothLinearLayoutManager layoutManager = new SmoothLinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(adapter);
        recyclerView.scrollToPosition(list.size() * 10);

        PagerSnapHelper snapHelper = new PagerSnapHelper();
        snapHelper.attachToRecyclerView(recyclerView);

        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(1);
        scheduledExecutorService.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                recyclerView.smoothScrollToPosition(layoutManager.findFirstVisibleItemPosition() + 1);
            }
        }, 2000, 2000, TimeUnit.MILLISECONDS);

        //加入ProgressDialog
        DialogHelper.showProgressDialog(getActivity(), "請稍候");
        OpenDataService.getInstance().GetRestaurant(new OpenDataService.GetRestaurantResponse(){
            @Override
            public void onGetRestlt(final ArrayList<Restaurant> result) {
                getActivity().runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        if (result != null) {
                            adapter.setDatas(result);
                            adapter.notifyDataSetChanged();
                        }
                    }
                });
                DialogHelper.closeProgressDialog();
            }

            @Override
            public void onFail(final Exception ex) {
                getActivity().runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(getActivity(), ex.getLocalizedMessage(), Toast.LENGTH_LONG).show();
                    }
                });
            }
        });


        return root;
    }
}


