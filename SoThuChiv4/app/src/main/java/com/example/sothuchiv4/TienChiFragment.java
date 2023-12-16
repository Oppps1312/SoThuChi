package com.example.sothuchiv4;

import android.app.DatePickerDialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;
import java.util.Calendar;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link TienChiFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class TienChiFragment extends Fragment {
    View view;
    private EditText ghiChu,soTienChi;
    private Spinner spinnerDanhMucChi;
    private DatePickerDialog picker;
    private Button dateButton;
    private Button nhapKhoanChiButton;
    ArrayList<String> danhMucChi ;
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public TienChiFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment TienChiFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static TienChiFragment newInstance(String param1, String param2) {
        TienChiFragment fragment = new TienChiFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_tien_chi, container, false);
        Anhxa();
        //Get current day, set to button
        Calendar cldr = Calendar.getInstance();
        int day = cldr.get(Calendar.DAY_OF_MONTH);
        int month = cldr.get(Calendar.MONTH) + 1;
        int year = cldr.get(Calendar.YEAR);

        dateButton.setText( year+ "/"+month+ "/" + day);
        dateButton.setOnClickListener( new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                final Calendar cldr = Calendar.getInstance();
                int day = cldr.get(Calendar.DAY_OF_MONTH);
                int month = cldr.get(Calendar.MONTH);
                int year = cldr.get(Calendar.YEAR);
                picker = new DatePickerDialog(getContext(),
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {

                                dateButton.setText(year + "/" + (monthOfYear + 1) + "/" + dayOfMonth);
                            }
                        }, year, month, day);

                picker.show();
            }

        });
        setSpinnerDanhMucChi();
        return view;
        //Logic nhap khoan chi


    }
    public void setSpinnerDanhMucChi(){
        MyDatabaseHelper databaseHelper = new MyDatabaseHelper(getActivity());
       danhMucChi = databaseHelper.docDucLieuDanhMucChi();

        ArrayAdapter adapter = new ArrayAdapter(getActivity(), android.R.layout.simple_spinner_item,danhMucChi);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerDanhMucChi.setAdapter(adapter);
        spinnerDanhMucChi.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(getActivity(), danhMucChi.get(i), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        nhapKhoanChiButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nhapKhoanChi();
            }
        });
    }
    public boolean kiemTraThongTin(){
        String msg = "";
        if(dateButton.getText().toString().length() == 0){
            msg = "Vui lòng nhập ngày!";
            Toast.makeText(getActivity(), "msg", Toast.LENGTH_SHORT).show();
            return false;
        }
        if(soTienChi.getText().toString().length() == 0){
            msg =" Vui lòng nhập số tiền chi!";
            Toast.makeText(getActivity(), "msg", Toast.LENGTH_SHORT).show();
            return false;
        }
        if(spinnerDanhMucChi.getSelectedItem().toString().length() == 0){
            msg =" Vui lòng nhập danh mục!";
            Toast.makeText(getActivity(), "msg", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }
    public void nhapKhoanChi(){
        if(kiemTraThongTin()){

            String ngaychi = dateButton.getText().toString();
            int num = Integer.parseInt(soTienChi.getText().toString());
            String ghichu = ghiChu.getText().toString();
            String danhmuc = spinnerDanhMucChi.getSelectedItem().toString();
            try {
                MyDatabaseHelper databaseHelper = new MyDatabaseHelper(getActivity());
                databaseHelper.themKhoanChi(ngaychi,ghichu,num,danhmuc);

            }catch (Exception e){
                Toast.makeText(getActivity(), "Nhập khoản chi thất bại", Toast.LENGTH_SHORT).show();
            }
        }

    }
    public void Anhxa(){
        ghiChu = view.findViewById(R.id.ghiChuKhoanChi);
        soTienChi = view.findViewById(R.id.soTienChi);
        nhapKhoanChiButton = view.findViewById(R.id.buttonNhapChi);
        spinnerDanhMucChi = (Spinner) view.findViewById(R.id.spinnerDanhMucChi);
        dateButton = view.findViewById(R.id.buttonGetDateChi);
    }



}