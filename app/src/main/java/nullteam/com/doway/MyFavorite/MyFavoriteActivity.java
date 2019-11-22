package nullteam.com.doway.MyFavorite;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import java.util.ArrayList;
import nullteam.com.doway.R;
import nullteam.com.doway.activity.RestaurantDetail;
import nullteam.com.doway.model.Restaurant;

public class MyFavoriteActivity extends AppCompatActivity {
    private MyFavDbAdapter myFavDbAdapter;
    TextView no_data;
    ListView myFavList;
    int item_id;
    private Intent intent;
    MyFavListAdapter myFavListAdapter;
    ArrayList<Restaurant> restaurants = new ArrayList<>();
    Cursor cursor;
    private AlertDialog dialog = null;
    AlertDialog.Builder builder = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_favorite);

        myFavList = findViewById(R.id.myFavList);
        no_data = findViewById(R.id.noData);

        myFavDbAdapter = new MyFavDbAdapter(this);

        //判斷目前是否有收藏資料並設定顯示元件，如果是0，就顯示「尚無收藏項目」
        if(myFavDbAdapter.listMyFavRestaurant().getCount() == 0){
            myFavList.setVisibility(View.INVISIBLE);
            no_data.setVisibility(View.VISIBLE);
        }else {
            myFavList.setVisibility(View.VISIBLE);
            no_data.setVisibility(View.INVISIBLE);
        }
        displayList(); // 顯示所有收藏資料

        // 跳到各筆資料的詳細頁
        myFavList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                cursor.move(position);
                item_id = cursor.getInt(cursor.getColumnIndexOrThrow("_id"));

                intent = new Intent();
                intent.putExtra("item_id", item_id);
                intent.setClass(MyFavoriteActivity.this, RestaurantDetail.class);
                startActivity(intent);
            }
        });

        // 移除收藏
        myFavList.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                cursor.move(position);
                item_id = cursor.getInt(cursor.getColumnIndexOrThrow("_id"));
                dialog = builder.create();
                dialog.show();
                return true;
            }
        });
        builder = new AlertDialog.Builder(this);
        builder.setTitle("訊息")
                .setMessage("確定移除收藏？")
                .setPositiveButton("確定", new DialogInterface.OnClickListener() {
                    // 設定確定按鈕
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        boolean is_deleted = myFavDbAdapter.deleteMyFavRestaurant(item_id);
                        if(is_deleted){
                            Toast.makeText(MyFavoriteActivity.this,"已取消收藏！", Toast.LENGTH_SHORT).show();
                            restaurants = new ArrayList<>();
                            displayList();
                        }
                    }
                })
                .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    //設定取消按鈕
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
    }

    private void displayList() {
        // 在 ListView 上顯示所有 myFavList 的資料
        cursor = myFavDbAdapter.listMyFavRestaurant();
        if(cursor != null){
            cursor.moveToFirst();
        }
        if(cursor.moveToFirst()){
            do{
                restaurants.add(new Restaurant(
                        cursor.getString(cursor.getColumnIndex(MyFavDbAdapter.KEY_ID)),
                        cursor.getString(cursor.getColumnIndex(MyFavDbAdapter.KEY_NAME)),
                        cursor.getString(cursor.getColumnIndex(MyFavDbAdapter.KEY_ADDRESS)),
                        cursor.getString(cursor.getColumnIndex(MyFavDbAdapter.KEY_TEL)),
                        cursor.getString(cursor.getColumnIndex(MyFavDbAdapter.KEY_IMG))
                       ));
            }while (cursor.moveToNext());
        }
        cursor.moveToFirst();
        myFavListAdapter = new MyFavListAdapter(this,restaurants);
        myFavList.setAdapter(myFavListAdapter);
    }
}