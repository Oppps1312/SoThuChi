package com.example.sothuchiv4;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CalendarView;
import android.widget.DatePicker;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link LichFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class LichFragment extends Fragment {


    private CalendarView calendarView;
    private SimpleDateFormat dateFormat;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public LichFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment LichFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static LichFragment newInstance(String param1, String param2) {
        LichFragment fragment = new LichFragment();
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
        View view = inflater.inflate(R.layout.fragment_lich, container, false);

        calendarView = view.findViewById(R.id.calendarView);
        dateFormat = new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault());

        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(CalendarView view, int year, int month, int dayOfMonth) {
                showEventForDate(year, month, dayOfMonth);
            }
        });
        return view;
    }

        private void showEventForDate(final int year, final int month, final int dayOfMonth) {
            // Ở đây, bạn có thể thực hiện các hành động để hiển thị sự kiện cho ngày đã chọn
            // Ví dụ: Hiển thị danh sách sự kiện trong một Fragment hoặc mở một Activity mới
            String selectedDate = dateFormat.format(buildDate(year, month, dayOfMonth).getTime());
            Toast.makeText(getContext(), "Sự kiện cho " + selectedDate, Toast.LENGTH_SHORT).show();
            // Bạn có thể xử lý hiển thị sự kiện tại đây.
        }

    // Phương thức để xây dựng đối tượng Date từ năm, tháng và ngày
    private Date buildDate(int year, int month, int dayOfMonth) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(year, month, dayOfMonth);
        return calendar.getTime();
    }
}


