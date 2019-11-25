package nullteam.com.doway.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import nullteam.com.doway.OpenDataService;
import nullteam.com.doway.R;
import nullteam.com.doway.Utils.DialogHelper;
import nullteam.com.doway.adapter.RestaurantAdapter;
import nullteam.com.doway.model.Restaurant;

public class RestaurantFragment extends Fragment {
    private RecyclerView listView;
    private RestaurantAdapter adapter;
    private Spinner spinnercity;
    private TextView S_Txt;
    private ArrayList<Restaurant> datas;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_restaurant, container, false);
        S_Txt = root.findViewById(R.id.STxt);
        spinnercity = root.findViewById(R.id.spinner);
        listView = root.findViewById(R.id.restaurant_List);
        ArrayList<Restaurant> result = new ArrayList<Restaurant>();
        adapter = new RestaurantAdapter(this, result);

        //使用Spinner
        ArrayAdapter<CharSequence> nAdapter = ArrayAdapter.createFromResource(
                getActivity(), R.array.City, android.R.layout.simple_spinner_item );
        nAdapter.setDropDownViewResource(
                android.R.layout.simple_spinner_dropdown_item);
        spinnercity.setAdapter(nAdapter);
        spinnercity.setOnItemSelectedListener(new Spinner.OnItemSelectedListener(){
            public void onItemSelected(AdapterView adapterView, View view, int position, long id){
                String selectCity =  spinnercity.getSelectedItem().toString();
                adapter.getFilter().filter(selectCity);
            }
            public void onNothingSelected(AdapterView arg0) {
            }
        });

        final LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);

        listView.setLayoutManager(layoutManager);
        listView.setAdapter(adapter);

        //加入ProgressDialog
        DialogHelper.showProgressDialog(getActivity(), "更新餐廳列表");
        OpenDataService.getInstance().GetRestaurant(new OpenDataService.GetRestaurantResponse(){
            @Override
            public void onGetRestlt(final ArrayList<Restaurant> result) {
                getActivity().runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        if (result != null) {
                            datas = result;
                            adapter.setDatas(result);
                            String selectCity =  spinnercity.getSelectedItem().toString();
                            adapter.getFilter().filter(selectCity);
                            //adapter.notifyDataSetChanged();
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