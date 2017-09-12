package exercise.quanly;

import java.util.Scanner;

public class LapTrinhVien extends NhanVien{
    private double soGioLamThem;
    private final double LUONG_MAX = 20000000;
    Scanner scan = new Scanner(System.in);

    public LapTrinhVien(){
        super();
        soGioLamThem=0;
    }
    public boolean tangLuong(double luong){
        if(luong<LUONG_MAX){
            return true;
        }
        return false;
    }

    public double tinhLuong(){
        return luongCoBan * getHeSoLuong() + soGioLamThem*200000;
    }


    public void nhap() {
        super.nhap();
        Scanner scan=new Scanner(System.in);
        System.out.println("Nhap so gio lam them: ");
        soGioLamThem=scan.nextInt();
    }

    public void xuat(){
        System.out.println("Xuat lap trinh vien ");
        xuatThongTinChung();
    }


    public int getVaiTro() {
        return 2;
    }
}
