/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;
import java.sql.Date;

public class PhieuXuatKho {
       private int MAXK ;            
    private int MANL   ;           
   private int  MANV    ;          
   private Date NGAYXUAT ;         
   private  int SOLUONGXUAT   ;         
   private int GIAXUAT ;
public int getMAXK() {
    return MAXK;
}
public void setMAXK(int mAXK) {
    MAXK = mAXK;
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
public Date getNGAYXUAT() {
    return NGAYXUAT;
}
public void setNGAYXUAT(Date nGAYXUAT) {
    NGAYXUAT = nGAYXUAT;
}
public int getSOLUONGXUAT() {
    return SOLUONGXUAT;
}
public void setSOLUONGXUAT(int sOLUONGXUAT) {
    SOLUONGXUAT = sOLUONGXUAT;
}
public int getGIAXUAT() {
    return GIAXUAT;
}
public void setGIAXUAT(int gIAXUAT) {
    GIAXUAT = gIAXUAT;
}
public PhieuXuatKho(int mAXK, int mANL, int mANV, Date nGAYXUAT, int sOLUONGXUAT, int gIAXUAT) {
    MAXK = mAXK;
    MANL = mANL;
    MANV = mANV;
    NGAYXUAT = nGAYXUAT;
    SOLUONGXUAT = sOLUONGXUAT;
    GIAXUAT = gIAXUAT;
}
public PhieuXuatKho() {
}


   
}
