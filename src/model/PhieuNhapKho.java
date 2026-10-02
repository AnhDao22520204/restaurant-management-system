/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author 84889
 */
import java.sql.Date;
public class PhieuNhapKho {
    private int MANK ;            
    private int MANL   ;           
   private int  MANV    ;          
   private Date NGAYNHAP ;          
   private  int SOLUONGNHAP   ;         
   private int GIANHAP ;
public PhieuNhapKho() {
}
public PhieuNhapKho(int mANK, int mANL, int mANV, Date nGAYNHAP, int sOLUONGNHAP, int gIANHAP) {
    MANK = mANK;
    MANL = mANL;
    MANV = mANV;
    NGAYNHAP = nGAYNHAP;
    SOLUONGNHAP = sOLUONGNHAP;
    GIANHAP = gIANHAP;
}
public int getMANK() {
    return MANK;
}
public void setMANK(int mANK) {
    MANK = mANK;
}
public int getMANL() {
    return MANL;
}
public void setMANL(int mANL) {
    MANL = mANL;
}
public int getMANV() {
    return MANV;
}
public void setMANV(int mANV) {
    MANV = mANV;
}
public Date getNGAYNHAP() {
    return NGAYNHAP;
}
public void setNGAYNHAP(Date nGAYNHAP) {
    NGAYNHAP = nGAYNHAP;
}
public int getSOLUONGNHAP() {
    return SOLUONGNHAP;
}
public void setSOLUONGNHAP(int sOLUONGNHAP) {
    SOLUONGNHAP = sOLUONGNHAP;
}
public int getGIANHAP() {
    return GIANHAP;
}
public void setGIANHAP(int gIANHAP) {
    GIANHAP = gIANHAP;
}
}
  