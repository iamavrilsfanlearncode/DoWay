package nullteam.com.doway.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.PagerSnapHelper;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import nullteam.com.doway.OpenDataService;
import nullteam.com.doway.R;
import nullteam.com.doway.Utils.DialogHelper;
import nullteam.com.doway.model.GridView;
import nullteam.com.doway.slide.CustomGrid;
import nullteam.com.doway.slide.SmoothLinearLayoutManager;
import nullteam.com.doway.slide.ViewPagerAdapter;

public class GridViewFragment extends Fragment {
    private List<Integer> list = new ArrayList<>(3);
    RecyclerView listview;
    GridLayoutManager layoutManager;
    private CustomGrid adapter;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_gridview, container, false);

        listview = root.findViewById(R.id.Gridrecycler);
        ArrayList<GridView> result = new ArrayList<GridView>();
        adapter = new CustomGrid(this,result);
        layoutManager = new GridLayoutManager(getActivity(),2);
        listview.setHasFixedSize(true);
        listview.setLayoutManager(layoutManager);
        listview.setAdapter(adapter);


        //加入ProgressDialog
        DialogHelper.showProgressDialog(getActivity(), "請稍候");
        OpenDataService.getInstance().GetGridView(new OpenDataService.GetGridViewResponse(){
            @Override
            public void onGetRestlt(final ArrayList<GridView> result) {
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

        list.add(R.drawable.aaa);
        list.add(R.drawable.b);
        list.add(R.drawable.c);

        final ViewPagerAdapter adapter = new ViewPagerAdapter(getActivity(),list);
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

        return root;
    }
}


