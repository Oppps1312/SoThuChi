package com.example.sothuchiv4;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.sothuchiv4.databinding.ActivityMainBinding;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    BottomNavigationView btn1;
    ActivityMainBinding binding;
    ActivityMainBinding binding2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        replaceFragment(new ThuChiFragment());
        binding.bottomNavigationView.setOnItemSelectedListener(item -> {
            switch (item.getItemId()){
                case R.id.input:
                    replaceFragment(new ThuChiFragment());
                    break;
                case R.id.calender:
                    replaceFragment(new LichFragment());
                    break;
                case R.id.report:
                    replaceFragment(new BaoCaoFragment());
                    break;
                case R.id.setting:
                    replaceFragment(new CaiDatFragment());
                    break;
            }
            return true;
        });
        //khoitaobandau();




    }
    private void replaceFragment(Fragment fragment){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.main_layout, fragment);
        fragmentTransaction.commit();
    }

    public void khoitaobandau(){

        taoDanhMucChiBanDau();
        taoDanhMucThuBanDau();
    }
    public void taoDanhMucChiBanDau(){
        MyDatabaseHelper mydatabase = new MyDatabaseHelper(MainActivity.this);

        mydatabase.themDanhMucChi("Ăn uống");
        mydatabase.themDanhMucChi("Chi tiêu hàng ngày");
        mydatabase.themDanhMucChi("Quần áo");
        mydatabase.themDanhMucChi("Mỹ phẩm");
        mydatabase.themDanhMucChi("Phí giao lưu");
        mydatabase.themDanhMucChi("Y tế");
        mydatabase.themDanhMucChi("giáo dục");
        mydatabase.themDanhMucChi("Tiền điện");
        mydatabase.themDanhMucChi("Đi lại");



    }
    public void taoDanhMucThuBanDau(){
        MyDatabaseHelper mydatabase = new MyDatabaseHelper(MainActivity.this);
        mydatabase.themDanhMucThu("Tiền lương");
        mydatabase.themDanhMucThu("Tiền phụ cấp");
        mydatabase.themDanhMucThu("Tiền thưởng");
        mydatabase.themDanhMucThu("Thu nhập phụ");
        mydatabase.themDanhMucThu("Đầu tư");
        mydatabase.themDanhMucThu("Thu nhập tạm thời");


    }
//    public ArrayList<String> danhSachChi(){
//        mydatabase = openOrCreateDatabase("sothuchi.db",MODE_PRIVATE,null);
//        ArrayList<String> danhsach = new ArrayList<String>();
//        String sql = "Select tendanhmucchi from danhmucchi";
//        Cursor cursor = mydatabase.rawQuery(sql,null);
//        cursor.moveToNext();
//
//        while (cursor.isAfterLast() == false){
//            String data =cursor.getString(0);
//            cursor.moveToNext();
//            danhsach.add(data);
//        }
//        cursor.close();
//        return  danhsach;
//    }
//    public ArrayList<String> danhSachThu(){
//
//        ArrayList<String> danhsach = new ArrayList<String>();
//        String sql = "Select tendanhmucthu from danhmucthu";
//        Cursor cursor = mydatabase.rawQuery(sql,null);
//        cursor.moveToNext();
//
//        while (cursor.isAfterLast() == false){
//            String data =cursor.getString(0);
//            cursor.moveToNext();
//            danhsach.add(data);
//        }
//        cursor.close();
//        return  danhsach;
//    }


}