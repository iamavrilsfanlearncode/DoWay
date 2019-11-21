package nullteam.com.doway.MyFavorite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

public class MyFavDbHelper extends SQLiteOpenHelper {
    public static final String KEY_ID = "_id";
    // 注意：好像一定要把 primary key 的名字設定為 _id，不然會 error（？）
    public static final String KEY_IMG = "image_restaurant";
    public static final String KEY_NAME = "name_restaurant";
    public static final String KEY_TEL = "tel_restaurant";
    public static final String KEY_ADDRESS = "address_restaurant";
    public static final String DATABASE_NAME = "MyFavRestaurants";
    public static final String TABLE_NAME = "myFavRestaurant";
    public static final int DB_VERSION = 1; //  版本 1

    public MyFavDbHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DB_VERSION);
        // super 關鍵字指的是目前這個 class 的上一層，也就是 SQLiteOpenHelper
    }

    @Override
    //  如果 Android 載入時找不到生成的資料庫檔案，就會觸發 onCreate
    public void onCreate(SQLiteDatabase db) {
        // 組裝建立資料表的 SQL 語法
        final String DATABASE_CREATE = "CREATE TABLE IF NOT EXISTS " + TABLE_NAME + " (" +
                KEY_ID + " integer PRIMARY KEY autoincrement," +
                KEY_IMG + "," +
                KEY_NAME + "," +
                KEY_TEL + "," +
                KEY_ADDRESS + ");";
        Log.d("SQL=",DATABASE_CREATE);
        db.execSQL(DATABASE_CREATE); // 用 execSQL() 執行 SQL 指令
    }

    @Override
    // 如果資料庫版本（DB_VERSION）結構有改變了就會觸發 onUpgrade
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // 刪除舊資料表
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        // 重新建立新資料表
        onCreate(db);
    }
}
