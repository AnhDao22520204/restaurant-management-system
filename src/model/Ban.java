package model;

public class Ban {
    private int maBan;
    private String tenBan;
    private String viTri;
    private String trangThai;
    public int getMaBan() {
        return maBan;
    }
    public void setMaBan(int maBan) {
        this.maBan = maBan;
    }
    public String getTenBan() {
        return tenBan;
    }
    public void setTenBan(String tenBan) {
        this.tenBan = tenBan;
    }
    public String getViTri() {
        return viTri;
    }
    public void setViTri(String viTri) {
        this.viTri = viTri;
    }
    public String getTrangThai() {
        return trangThai;
    }
    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }
    public Ban(int maBan, String tenBan, String viTri, String trangThai) {
        this.maBan = maBan;
        this.tenBan = tenBan;
        this.viTri = viTri;
        this.trangThai = trangThai;
    }
    public Ban() {
    }

    
    
}
