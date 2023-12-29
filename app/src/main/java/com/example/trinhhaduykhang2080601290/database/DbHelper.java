package com.example.trinhhaduykhang2080601290.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DbHelper extends SQLiteOpenHelper {

    public DbHelper(@Nullable Context context) {
        super(context, "QLSanPham", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE SanPham(MaSP INTEGER PRIMARY KEY AUTOINCREMENT, " + "TenSP TEXT, GiaTien REAL, Image TEXT)";
        db.execSQL(sql);
        String data = "INSERT INTO SanPham VALUES(1, 'Bánh Canh', '20.000', 'https://cdn.tgdd.vn/Files/2019/07/01/1176655/banh-canh-cua-dong-1-760x367.jpg')," +
                "(2, 'Hủ tiếu', '35.000', 'https://mekongrestaurant.vn/wp-content/uploads/2023/07/Hu-tieu-Mekong-1.png')," +
                "(3, 'Bún bò', '60.000', 'https://static.vinwonders.com/production/bun-bo-hue-cau-giay-1.jpg')";
        db.execSQL(data);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        if (i != i1){
            db.execSQL("DROP TABLE IF EXISTS SanPham");
            onCreate(db);
        }
    }
}