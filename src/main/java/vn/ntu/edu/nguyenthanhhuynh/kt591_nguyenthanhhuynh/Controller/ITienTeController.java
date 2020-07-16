package vn.ntu.edu.nguyenthanhhuynh.kt591_nguyenthanhhuynh.Controller;

import java.util.List;

import vn.ntu.edu.nguyenthanhhuynh.kt591_nguyenthanhhuynh.Model.TienTeModel;

public interface ITienTeController {
    public List<TienTeModel> getAllTienTe();
    boolean addTienTe(TienTeModel tienTe);
}
