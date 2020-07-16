package vn.ntu.edu.nguyenthanhhuynh.kt591_nguyenthanhhuynh;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;

import java.util.Calendar;
import java.util.List;

import vn.ntu.edu.nguyenthanhhuynh.kt591_nguyenthanhhuynh.Controller.ITienTeController;
import vn.ntu.edu.nguyenthanhhuynh.kt591_nguyenthanhhuynh.Model.TienTeModel;

public class FirstFragment extends Fragment implements MyDatePicker.OnMyDateChangeListener{

    EditText edtNgay, edtMuaVao, edtBanRa;
    ImageView imgvDate;

    NavController controller;
    ITienTeController tienTeController;
    List<TienTeModel> tienTeList;

    Spinner spnLoai;

    String [] arrayLoai;
    ArrayAdapter adapterLoai;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_first, container, false);;
        return view;
    }

    //
    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        controller = NavHostFragment.findNavController(this);
        ((MainActivity) getActivity()).controller = controller;
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        addViews();

        //Sử dụng DatePicker để nhận thông tin ngày, tháng, năm khi nhấn vào igmNgaySinh
        imgvDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyDatePicker myDatePicker = new MyDatePicker(getActivity(), Calendar.getInstance(),
                        FirstFragment.this);
                myDatePicker.showMyDatePicker();
            }
        });

        //Xử lý thêm giao dịch tiền tệ
        view.findViewById(R.id.btnAdd).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addTienTe();
            }
        });

        //Chuyển đến giao diện 2
        view.findViewById(R.id.button_first).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(FirstFragment.this)
                        .navigate(R.id.action_FirstFragment_to_SecondFragment);
            }
        });
    }

    //
    public void addViews(){
        FragmentActivity activity = getActivity();

        edtNgay = activity.findViewById(R.id.edtNgay);
        imgvDate = activity.findViewById(R.id.imgvDate);
        edtMuaVao = activity.findViewById(R.id.edtMuaVao);
        edtBanRa = activity.findViewById(R.id.edtBanRa);

        spnLoai = activity.findViewById(R.id.spnLoai);
        arrayLoai = activity.getResources().getStringArray(R.array.Loai);
        adapterLoai = new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1, arrayLoai);
        spnLoai.setAdapter(adapterLoai);

    }

    public void addTienTe(){
        //Nhận thông tin từ EditText
        String Ngay = edtNgay.getText().toString();
        String MuaVao = edtMuaVao.getText().toString();
        String BanRa = edtBanRa.getText().toString();

        //Nhận Thông tin dịch vụ từ Spinner
        String LuaChon = spnLoai.getSelectedItem().toString();

        TienTeModel tienTe = new TienTeModel(Ngay, LuaChon ,MuaVao, BanRa);

        tienTeController = ((MainActivity) getActivity()).tienTeController;

        tienTeList = tienTeController.getAllTienTe();

        //Thêm giao dịch mới vào list
        tienTeController.addTienTe(tienTe);
        Toast.makeText(getActivity(), "Thêm thành công", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void dateUpdate(Calendar calendar) {
        StringBuilder builder = new StringBuilder();

        //Định dạng: Ngày/Tháng/Năm
        StringBuilder abc = builder
                .append(calendar.get(calendar.DAY_OF_MONTH))
                .append("/")
                .append(calendar.get(calendar.MONTH) + 1)
                .append("/")
                .append(calendar.get(calendar.YEAR));

        //Hiển thị ngày/tháng/năm lên editTextDate
        edtNgay.setText(builder.toString());
    }
}