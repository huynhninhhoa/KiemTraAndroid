package vn.ntu.edu.nguyenthanhhuynh.kt591_nguyenthanhhuynh;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import vn.ntu.edu.nguyenthanhhuynh.kt591_nguyenthanhhuynh.Controller.ITienTeController;
import vn.ntu.edu.nguyenthanhhuynh.kt591_nguyenthanhhuynh.Model.TienTeModel;

public class SecondFragment extends Fragment {

    NavController controller;
    RecyclerView rvListTienTe;
    TienTeAdapter adapter;
    List<TienTeModel> listTienTe;

    ITienTeController tienTeController;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_second, container, false);
        return view;
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

//        view.findViewById(R.id.button_second).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                NavHostFragment.findNavController(SecondFragment.this)
//                        .navigate(R.id.action_SecondFragment_to_FirstFragment);
//            }
//        });

        addViews();
    }

    //
    public void addViews(){

        FragmentActivity activity = getActivity();

        rvListTienTe = activity.findViewById(R.id.rvListTienTe);
        rvListTienTe.setLayoutManager(new LinearLayoutManager(activity));

        tienTeController = ((MainActivity)getActivity()).tienTeController;
        listTienTe = tienTeController.getAllTienTe();

        adapter = new TienTeAdapter(listTienTe);
        rvListTienTe.setAdapter(adapter);

    }

    //Lớp cài đặt cho việc hiển thị của một giao dịch
    private class TienTeViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        TextView txtNgay, txtLuaChon, txtMuaVao, txtBanRa;
        //ImageView imvAddToCart;
        TienTeModel tienTe;

        public TienTeViewHolder(@NonNull View itemView) {
            super(itemView);
            txtNgay = this.itemView.findViewById(R.id.txtNgay);
            txtLuaChon = this.itemView.findViewById(R.id.txtLuaChon);
            txtMuaVao = this.itemView.findViewById(R.id.txtMuaVao);
            txtBanRa = this.itemView.findViewById(R.id.txtBanRa);

        }

        public void bind(TienTeModel tienTe){
            this.tienTe = tienTe;

            txtNgay.setText(tienTe.getNgay());
            txtLuaChon.setText(tienTe.getLuaChon());
            txtMuaVao.setText("Mua vào: " + tienTe.getMuaVao());
            txtBanRa.setText("Bán ra: " + tienTe.getBanRa());
        }

        @Override
        public void onClick(View v) {
            //
        }
    }

    //Lớp Adapter kết nối RecycleView và dữ liệu
    private class TienTeAdapter extends RecyclerView.Adapter<TienTeViewHolder> {

        List<TienTeModel> listTienTes;

        private TienTeAdapter(List<TienTeModel> listTienTe) {
            this.listTienTes = listTienTe;
        }

        //Tạo một ViewHolder để hiển thị dữ liệu
        @NonNull
        @Override
        public TienTeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            LayoutInflater inflater = getLayoutInflater();
            View view = inflater.inflate(R.layout.tiente, parent,false);
            //Product.xml
            return new TienTeViewHolder(view);
        }

        //Kết nối một mục dữ liệu trong danh sách với một ViewHolder
        @Override
        public void onBindViewHolder(@NonNull TienTeViewHolder holder, int position) {
            holder.bind(listTienTes.get(position));
        }

        @Override
        public int getItemCount() {
            return listTienTes.size();
        }
    }
}