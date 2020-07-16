package vn.ntu.edu.nguyenthanhhuynh.kt591_nguyenthanhhuynh.Model;

public class TienTeModel {
    String ngay;
    String luaChon;
    String muaVao;
    String banRa;

    public TienTeModel() {
    }

    public TienTeModel(String ngay, String luaChon, String muaVao, String banRa) {
        this.ngay = ngay;
        this.luaChon = luaChon;
        this.muaVao = muaVao;
        this.banRa = banRa;
    }

    public String getNgay() {
        return ngay;
    }

    public void setNgay(String ngay) {
        this.ngay = ngay;
    }

    public String getLuaChon() {
        return luaChon;
    }

    public void setLuaChon(String luaChon) {
        this.luaChon = luaChon;
    }

    public String getMuaVao() {
        return muaVao;
    }

    public void setMuaVao(String muaVao) {
        this.muaVao = muaVao;
    }

    public String getBanRa() {
        return banRa;
    }

    public void setBanRa(String banRa) {
        this.banRa = banRa;
    }

    @Override
    public String toString() {
        return "TienTeModel{" +
                "ngay='" + ngay + '\'' +
                ", luaChon='" + luaChon + '\'' +
                ", muaVao='" + muaVao + '\'' +
                ", banRa='" + banRa + '\'' +
                '}';
    }
}
