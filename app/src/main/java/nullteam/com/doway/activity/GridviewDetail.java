package nullteam.com.doway.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.nostra13.universalimageloader.core.ImageLoader;
import nullteam.com.doway.MainActivity;
import nullteam.com.doway.R;
import nullteam.com.doway.model.GridView;

public class GridviewDetail extends AppCompatActivity {
    private GridView gridView;
    private TextView tv_Tel,tv_Name,tv_Address,tv_FoodFeature;
    private ImageView iv_Default;
    private Button btn_Back;
//    private ImageButton btn_Favorite;
//    private MyFavDbAdapter myFavDbAdapter;
//    Cursor lists;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gridview_detail);

        gridView = (GridView) getIntent().getSerializableExtra("grid");

        tv_Tel = findViewById(R.id.Tel);
        tv_Name = findViewById(R.id.Subject);
        tv_Address =findViewById(R.id.Address);
        tv_FoodFeature = findViewById(R.id.FoodFeature);
        tv_Tel.setText(gridView.getTel());
        tv_Name.setText(gridView.getName());
        tv_Address.setText(gridView.getAddress());
        tv_FoodFeature.setText(gridView.getFoodFeature());

        //詳細頁圖片
        iv_Default = findViewById(R.id.Default);
        //如果取得的圖片URL不為空值，就將原有的預設圖片覆蓋掉
        if (!gridView.getPicURL().isEmpty()){
            ImageLoader imageLoader = ImageLoader.getInstance();
            imageLoader.displayImage(gridView.getPicURL(), iv_Default);
        }

        //按鈕部分
        //返回
        btn_Back = findViewById(R.id.BtnBack);
        btn_Back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent().setClass(GridviewDetail.this, MainActivity.class));
                finish();
            }
        });
//        //收藏
//        btn_Favorite = findViewById(R.id.BtnFavorite);
//        myFavDbAdapter = new MyFavDbAdapter(this);
//        lists = myFavDbAdapter.listMyFavRestaurant();
//        btn_Favorite.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//      Toast.makeText(GridviewDetail.this,"收藏成功!", Toast.LENGTH_SHORT).show(); // version1
// 		addFavorite(grid, lists, grid.getName());
//            }
//        });
//    }
//    public void addFavorite(Restaurant restaurant, Cursor lists, String name_restaurant){
//        boolean isExists = false;
//        for (int i = 0; i < lists.getCount(); i++) {
//            String my_fav_name = lists.getString(lists.getColumnIndexOrThrow("name_restaurant"));
//            if (name_restaurant.equals(my_fav_name)) {
//                // 已收藏，不能再重複收藏
//                isExists = true;
//                break;
//            }
//        }
//        if (isExists) {
//            Toast.makeText(this, "已經收藏過囉～", Toast.LENGTH_SHORT).show();
//        } else {
//            // 加入收藏
//
//            myFavDbAdapter.createMyFavRestaurant(
//                    restaurant.getPicURL(),
//                    restaurant.getName(),
//                    restaurant.getTel(),
//                    restaurant.getAddress()
//            );
//        }
    }
}
