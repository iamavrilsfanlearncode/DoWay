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
import androidx.viewpager.widget.ViewPager;

import java.util.Timer;
import java.util.TimerTask;

import nullteam.com.doway.R;
import nullteam.com.doway.slide.CustomGrid;
import nullteam.com.doway.slide.ViewPagerAdapter;

public class GridViewFragment extends Fragment {
    ViewPager viewPager;
    LinearLayout sliderDotsPanel;
    private int dotscount;
    private ImageView[] dots;
    private GridView grid;
    private int[]imageId={R.drawable.aa,R.drawable.bb,R.drawable.cc,R.drawable.dd,R.drawable.ee,R.drawable.ff};
    private String[] text ={"十股糖仁文創園區","國家歌劇院","傳統藝術中心","清水斷崖","奇美博物館","六福村"};

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState){
        View root = inflater.inflate(R.layout.fragment_gridview, container, false);

        viewPager = root.findViewById(R.id.viewPager);
        sliderDotsPanel = root.findViewById(R.id.SliderDots);
        grid = root.findViewById(R.id.grid);

        CustomGrid adapter = new CustomGrid(getActivity(),text,imageId);
        grid.setAdapter(adapter);
        grid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getActivity(),"你選了"+text[+position],Toast.LENGTH_SHORT).show();

            }
        });

        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(getActivity());

        viewPager.setAdapter(viewPagerAdapter);

        dotscount = viewPagerAdapter.getCount();
        dots = new ImageView[dotscount];

        for(int i=0;i<dotscount;i++){
            dots[i] = new ImageView(getActivity());
            dots[i].setImageDrawable(ContextCompat.getDrawable(getContext(),R.drawable.nonactive_dots));

            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,LinearLayout.LayoutParams.WRAP_CONTENT);
            params.setMargins(8,0,8,0);
            sliderDotsPanel.addView(dots[i],params);
        }
        dots[0].setImageDrawable(ContextCompat.getDrawable(getContext(),R.drawable.avtive_dots));

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                for(int i=0;i<dotscount;i++){
                    dots[i].setImageDrawable(ContextCompat.getDrawable(getContext(),R.drawable.nonactive_dots));
                }
                dots[position].setImageDrawable(ContextCompat.getDrawable(getContext(),R.drawable.avtive_dots));

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new MyTimeTask(),2000,4000);
        return root;
    }
    //轉成自動撥放
    public class MyTimeTask extends TimerTask {

        @Override
        public void run() {

            getActivity().runOnUiThread(new Runnable() {
                @Override
                public void run() {

                    if(viewPager.getCurrentItem() == 0){
                        viewPager.setCurrentItem(1);
                    }else if(viewPager.getCurrentItem() == 1){
                        viewPager.setCurrentItem(2);
                    }else {
                        viewPager.setCurrentItem(0);
                    }

                }
            });

        }
    }

    }


