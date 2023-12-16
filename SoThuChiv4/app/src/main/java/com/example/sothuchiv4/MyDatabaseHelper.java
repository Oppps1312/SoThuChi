package com.example.sothuchiv4;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class MyDatabaseHelper extends SQLiteOpenHelper {


    private Context context;
    public static String DATABASE_NAME = "sothuchi.db";
    public static final int  DATABASE_VERSION = 1;

    public MyDatabaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        try {
            String sql1 = "CREATE TABLE IF NOT EXISTS danhsachchi ( iddanhmucchi INTEGER PRIMARY KEY AUTOINCREMENT  ,tendanhmucchi TEXT)";
            String sql2 = "CREATE TABLE IF NOT EXISTS danhsachthu ( iddanhmucthu INTEGER PRIMARY KEY AUTOINCREMENT  ,tendanhmucthu TEXT)";
            String sql3 = "CREATE TABLE IF NOT EXISTS tienchi ( idtienchi INTEGER PRIMARY KEY AUTOINCREMENT  ,ngaychi TEXT NOT NULL, ghichu TEXT, tienchi INTEGER NOT NULL,danhmucchi TEXT NOT NULL)";
            String sql4 = "CREATE TABLE IF NOT EXISTS tienthu ( idtienthu INTEGER PRIMARY KEY AUTOINCREMENT  ,ngaythu TEXT NOT NULL, ghichu TEXT, tienthu INTEGER NOT NULL,danhmucthu TEXT NOT NULL)";

            sqLiteDatabase.execSQL(sql1);
            sqLiteDatabase.execSQL(sql2);
            sqLiteDatabase.execSQL(sql3);
            sqLiteDatabase.execSQL(sql4);

        }
        catch (Exception e){
            Log.e("Error","CSDL DA TON TAI");
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS danhsachchi");
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS danhsachthu");
    }
    void themDanhMucChi(String tendanhmuc){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("tendanhmucchi",tendanhmuc);
        long rs = db.insert("danhsachchi", null,cv);
        String  msg ="";
        if(rs == -1){
            msg ="Khong the add dc danh muc";
        }
        else {
            msg =" add thanh cong";

        }
        Toast.makeText(context, msg, Toast.LENGTH_SHORT).show();
    }
    void themDanhMucThu(String tendanhmuc){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("tendanhmucthu",tendanhmuc);
        long rs = db.insert("danhsachthu", null,cv);
        String  msg ="";
        if(rs == -1){
            msg ="Khong the add dc danh muc";
        }
        else {
            msg =" add thanh cong";

        }
        Toast.makeText(context, msg, Toast.LENGTH_SHORT).show();
    }
    void themKhoanChi(String ngaychi, String ghichu, int sotien, String danhmucchi){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("ngaychi",ngaychi);
        cv.put("ghichu", ghichu);
        cv.put("tienchi",sotien);
        cv.put("danhmucchi",danhmucchi);
        long rs = db.insert("tienchi", null,cv);
        String  msg ="";
        if(rs == -1){
            msg ="Khong the add dc tien chi";
        }
        else {
            msg =" add thanh cong";

        }
        Toast.makeText(context, msg, Toast.LENGTH_SHORT).show();
    }
    void themKhoanThu(String ngaythu, String ghichu, int sotien, String danhmucthu){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("ngaythu",ngaythu);
        cv.put("ghichu", ghichu);
        cv.put("tienthu",sotien);
        cv.put("danhmucthu",danhmucthu);
        long rs = db.insert("tienthu", null,cv);
        String  msg ="";
        if(rs == -1){
            msg ="Khong the add dc tien chi";
        }
        else {
            msg =" add thanh cong";

        }
        Toast.makeText(context, msg, Toast.LENGTH_SHORT).show();
    }
    ArrayList<String> docDucLieuDanhMucThu(){
        ArrayList<String> danhsach = new ArrayList<String>();
        String sql = "Select tendanhmucthu from danhsachthu";
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.rawQuery(sql,null);
        cursor.moveToNext();

        while (cursor.isAfterLast() == false){
            String data =cursor.getString(0);
            cursor.moveToNext();
            danhsach.add(data);
        }
        cursor.close();
        return  danhsach;
    }
    ArrayList<String> docDucLieuDanhMucChi(){
        ArrayList<String> danhsach = new ArrayList<String>();
        String sql = "Select tendanhmucchi from danhsachchi";
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.rawQuery(sql,null);
        cursor.moveToNext();

        while (cursor.isAfterLast() == false){
            String data =cursor.getString(0);
            cursor.moveToNext();
            danhsach.add(data);
        }
        cursor.close();
        return  danhsach;

    }
//    ArrayList<String> truyvandanhmucchi(String ngaytruyvan){
//        ArrayList<String> danhsach = new ArrayList<String>();
//        String sql = " select * from tienchi where ngaychi = "+ ngaytruyvan ;
//    }

    void suadulieu(String iddanhmuc, String tendanhmuc){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("tendanhmucchi",tendanhmuc);
        long rs = db.update("tbldanhsachchi",cv,"iddanhmuc = ?",new String[]{iddanhmuc});
    }
    void xoadulieu(String iddanhmuc){
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete("tbldanhsachchi","iddanhmuc =?",new String[]{iddanhmuc});
    }
}
