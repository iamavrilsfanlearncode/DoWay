package nullteam.com.doway.MyFavorite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import android.widget.Toast;

public class MyFavDbAdapter {
    public static final String KEY_ID = "_id";
    // 注意：好像一定要把 primary key 的名字設定為 _id，不然會 error（？）
    public static final String KEY_IMG = "image_restaurant";
    public static final String KEY_NAME = "name_restaurant";
    public static final String KEY_TEL = "tel_restaurant";
    public static final String KEY_ADDRESS = "address_restaurant";
    public static final String TABLE_NAME = "myFavRestaurant";
    private MyFavDbHelper mDbHelper;
    private SQLiteDatabase mdb;
    private final Context mCtx;
    private ContentValues values;

    public MyFavDbAdapter(Context mCtx) {
        this.mCtx = mCtx;
        open();
    }
    public void open(){
        mDbHelper = new MyFavDbHelper(mCtx);
        mdb = mDbHelper.getWritableDatabase();
        Log.i("DB=",mdb.toString());
    }
    public long createMyFavRestaurant(String image_restaurant, String name_restaurant, String tel_restaurant, String address_restaurant){
        long id = 0;
        try {
            values = new ContentValues();
            values.put(KEY_IMG, image_restaurant);
            values.put(KEY_NAME, name_restaurant);
            values.put(KEY_TEL, tel_restaurant);
            values.put(KEY_ADDRESS, address_restaurant);
            id = mdb.insert(TABLE_NAME, null, values);
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            mdb.close(); // 關閉資料庫，才不會有資訊安全的風險，也可以釋放空間
            Log.v("tel", values.toString());
            Toast.makeText(mCtx,"Test收藏成功！", Toast.LENGTH_SHORT).show();
        }
        return id;
    }
    public Cursor listMyFavRestaurant(){
        Cursor mCursor = mdb.query(TABLE_NAME, new String[]{KEY_ID, KEY_IMG, KEY_NAME, KEY_TEL, KEY_ADDRESS},
                null, null,null,null,null);
        if(mCursor != null){
            mCursor.moveToFirst();
        }
        return mCursor;
    }
    public Cursor queryByID(int item_id){
        Cursor mCursor = mdb.query(TABLE_NAME, new String[]{KEY_ID, KEY_IMG, KEY_NAME, KEY_TEL, KEY_ADDRESS},
                KEY_ID + "=" + item_id, null,null,null,null,null);
        if(mCursor != null){
            mCursor.moveToFirst();
        }
        return mCursor;
    }
    public boolean deleteMyFavRestaurant(int id){
        String[] args = {Integer.toString(id)};
        mdb.delete(TABLE_NAME,"_id=?",args);
        Toast.makeText(mCtx,"Test取消收藏！", Toast.LENGTH_SHORT).show();
        return true;
    }
}
