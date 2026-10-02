/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author 84889
 */
public class NguyenLieu {

    private  int MANL;
    private String TENNL;
    private int SOLUONG;
    private int TONGGT;
    private String NHACUNGCAP;
    public NguyenLieu(int mANL, String tENNL, int sOLUONG, int tONGGT, String nHACUNGCAP) {
        MANL = mANL;
        TENNL = tENNL;
        SOLUONG = sOLUONG;
        TONGGT = tONGGT;
        NHACUNGCAP = nHACUNGCAP;
    }
    public NguyenLieu() {
    }
    public int getMANL() {
        return MANL;
    }
    public void setMANL(int mANL) {
        MANL = mANL;
    }
    public String getTENNL() {
        return TENNL;
    }
    public void setTENNL(String tENNL) {
        TENNL = tENNL;
    }
    public int getSOLUONG() {
        return SOLUONG;
    }
    public void setSOLUONG(int sOLUONG) {
        SOLUONG = sOLUONG;
    }
    public int getTONGGT() {
        return TONGGT;
    }
    public void setTONGGT(int tONGGT) {
        TONGGT = tONGGT;
    }
    public String getNHACUNGCAP() {
        return NHACUNGCAP;
    }
    public void setNHACUNGCAP(String nHACUNGCAP) {
        NHACUNGCAP = nHACUNGCAP;
    }
     @Override
    public String toString() {
        return "NguyenLieu [MANL=" + MANL + ", TENNL=" + TENNL + ", SOLUONG=" + SOLUONG + ", TONGGT=" + TONGGT
                + ", NHACUNGCAP=" + NHACUNGCAP + "]";
    } 
    
}

