package nullteam.com.doway.MyFavorite;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.content.DialogInterface;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;
import java.util.ArrayList;
import nullteam.com.doway.R;
import nullteam.com.doway.model.Restaurant;

public class MyFavoriteActivity extends AppCompatActivity {
    ListView myFavList;
    ArrayList<Restaurant> restaurants = new ArrayList<>();
    MyFavListAdapter myFavListAdapter;
    private MyFavDbAdapter myFavDbAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    Cursor cursor;
    int item_id;
    private AlertDialog dialog = null;
    AlertDialog.Builder builder = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_favorite);

        myFavList = findViewById(R.id.myFavList);
        myFavDbAdapter = new MyFavDbAdapter(this);
        mLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false); // 不確定是否正確
        displayaList(); // 顯示所有 memo 資料

        myFavList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                cursor.move(position);
                item_id = cursor.getInt(cursor.getColumnIndexOrThrow("_id"));
            }
        });
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
                .setMessage("確定移除我的最愛？")
                .setPositiveButton("確定", new DialogInterface.OnClickListener() {
                    // 設定確定按鈕
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        boolean is_deleted = myFavDbAdapter.deleteMyFavRestaurant(item_id);
                        if(is_deleted){
                            Toast.makeText(MyFavoriteActivity.this,"已取消收藏！", Toast.LENGTH_SHORT).show();
                            restaurants = new ArrayList<>();
                            displayaList();
                        }
                    }
                })
                .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
    }

    private void displayaList() {
        // 在 ListView 上顯示所有 myFavList 的資料
        cursor = myFavDbAdapter.listMyFavRestaurant();
        if(cursor.moveToFirst()){
            do{
                // 待補
            }while (cursor.moveToNext());
        }
        cursor.moveToFirst();
        myFavListAdapter = new MyFavListAdapter(this,restaurants);
        myFavList.setAdapter(myFavListAdapter);
    }
}
