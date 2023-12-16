package com.example.sothuchiv4;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class DatabaseHelper extends AppCompatActivity {
    SQLiteDatabase mydatabase;
    public DatabaseHelper(){

    }
//    public void createDatabase(){
//        //Tao va mo co so du lieu
//        mydatabase = openOrCreateDatabase("sothuchi.db",MODE_PRIVATE,null);
//        //Tao table danh muc chi, danh muc thu
//        try {
//            String sql = "CREATE TABLE IF NOT EXISTS danhmucchi ( iddanhmucchi INTEGER PRIMARY KEY AUTOINCREMENT  ,tendanhmucchi TEXT)";
//            mydatabase.execSQL(sql);
//        }
//        catch (Exception e){
//            Log.e("Error","Bang danh muc chi DA TON TAI");
//        }
//        try {
//            String sql = "CREATE TABLE IF NOT EXISTS danhmucthu ( iddanhmucthu INTEGER PRIMARY KEY AUTOINCREMENT  ,tendanhmucthu TEXT)";
//            mydatabase.execSQL(sql);
//        }
//        catch (Exception e){
//            Log.e("Error","Bang danh muc thu DA TON TAI");
//        }
//
//    }
//    public void khoitaobandau(){
//        createDatabase();
//        taoDanhMucChi();
//        taoDanhMucThu();
//    }
//    public void taoDanhMucChi(){
//        ContentValues  contentValues =new ContentValues();
//        contentValues.put("tendanhmucchi","Ăn uống");
//        contentValues.put("tendanhmucchi","Chi tiêu hàng ngày");
//        contentValues.put("tendanhmucchi","Quần áo");
//        contentValues.put("tendanhmucchi","Mỹ phẩm");
//        contentValues.put("tendanhmucchi","Phí giao lưu");
//        contentValues.put("tendanhmucchi","Y tế");
//        contentValues.put("tendanhmucchi","giáo dục");
//        contentValues.put("tendanhmucchi","Tiền điện");
//        contentValues.put("tendanhmucchi","Đi lại");
//        String msg ="";
//        if(mydatabase.insert("danhmucchi",null,contentValues) == -1){
//            Log.e("Error","Them du lieu vao danh muc chi khong thanh cong");
//        }
//        else{
//            Log.e("Succes","Them du lieu vao danh muc chi thanh cong!");
//        }
//
//    }
//    public void taoDanhMucThu(){
//        ContentValues  contentValues =new ContentValues();
//        contentValues.put("tendanhmucthu","Tiền lương");
//        contentValues.put("tendanhmucthu","Tiền phụ cấp");
//        contentValues.put("tendanhmucthu","Tiền thưởng");
//        contentValues.put("tendanhmucthu","Thu nhập phụ");
//        contentValues.put("tendanhmucthu","Đầu tư");
//        contentValues.put("tendanhmucthu","Thu nhập tạm thời");
//        if(mydatabase.insert("danhmucthu",null,contentValues) == -1){
//            Log.e("Error","Them du lieu vao danh muc thu khong thanh cong");
//        }
//        else{
//            Log.e("Succes","Them du lieu vao danh muc thu thanh cong!");
//        }
//    }
}
