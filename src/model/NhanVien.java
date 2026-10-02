/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;
import java.sql.Date;


public class NhanVien {

private int MANV;             
private int  NGQL;         
private int   MAND;        
private String   HOTEN;        
 private Date  NGSINH;               
 private Date  NGVL;
private String   SODT ;
public int getMANV() {
    return MANV;
}
public void setMANV(int mANV) {
    MANV = mANV;
}
public int getNGQL() {
    return NGQL;
}
public void setNGQL(int nGQL) {
    NGQL = nGQL;
}
public int getMAND() {
    return MAND;
}
public void setMAND(int mAND) {
    MAND = mAND;
}
public String getHOTEN() {
    return HOTEN;
}
public void setHOTEN(String hOTEN) {
    HOTEN = hOTEN;
}
public Date getNGSINH() {
    return NGSINH;
}
public void setNGSINH(Date nGSINH) {
    NGSINH = nGSINH;
}
public Date getNGVL() {
    return NGVL;
}
public void setNGVL(Date nGVL) {
    NGVL = nGVL;
}
public String getSODT() {
    return SODT;
}
public void setSODT(String sODT) {
    SODT = sODT;
}
public NhanVien() {
}
public NhanVien(int mANV, int nGQL, int mAND, String hOTEN, Date nGSINH, Date nGVL, String sODT) {
    MANV = mANV;
    NGQL = nGQL;
    MAND = mAND;
    HOTEN = hOTEN;
    NGSINH = nGSINH;
    NGVL = nGVL;
    SODT = sODT;
}
}
