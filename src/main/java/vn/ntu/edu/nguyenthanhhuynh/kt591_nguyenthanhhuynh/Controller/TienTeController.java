package vn.ntu.edu.nguyenthanhhuynh.kt591_nguyenthanhhuynh.Controller;

import android.app.Application;

import java.util.ArrayList;
import java.util.List;

import vn.ntu.edu.nguyenthanhhuynh.kt591_nguyenthanhhuynh.Model.TienTeModel;

public class TienTeController extends Application implements  ITienTeController {

    List<TienTeModel> tienTeList = new ArrayList<>();

    public TienTeController() {
        tienTeList.add(new TienTeModel("9/7/2020", "USD", "22300", "22400"));
        tienTeList.add(new TienTeModel("9/7/2020", "EUR", "32300", "32400"));
        tienTeList.add(new TienTeModel("9/7/2020", "CNY", "12300", "12400"));
    }

    @Override
    public List<TienTeModel> getAllTienTe() {
        return tienTeList;
    }

    @Override
    public boolean addTienTe(TienTeModel tienTe) {
        //return false;
        if(this.tienTeList.contains(tienTe))
            return false;
        this.tienTeList.add(tienTe);
        return true;
    }


}
