package exercise.quanly;

import java.util.Scanner;
import java.util.*;

public abstract class NhanVien {
    private String maNhanVien;
    private String tenNhanVien;
    private int tuoi;
    private String soDT;
    protected double luongCoBan;
    private double heSoLuong;
    private String password;

    public NhanVien(String maNhanVien, String tenNhanVien, String password, int tuoi, String soDT, double luongCoBan, double heSoLuong) {
        this.maNhanVien = maNhanVien;
        this.tenNhanVien = tenNhanVien;
        this.password = password;
        this.tuoi = tuoi;
        this.soDT = soDT;
        this.luongCoBan = luongCoBan;
        this.heSoLuong = heSoLuong;
    }

    public String getPassword() {
        return password;
    }

    public NhanVien() {
        maNhanVien = "20141513";
        tenNhanVien = "hieu";
        tuoi = 21;
        soDT = "01689453162";
        luongCoBan = 2000000;
        heSoLuong = 2;
    }


    public String getMaNhanVien() {
        return maNhanVien;
    }


    public String getTenNhanVien() {
        return tenNhanVien;
    }

    public void setTenNhanVien(String tenNhanVien) {
        this.tenNhanVien = tenNhanVien;
    }

    public void setTuoi(int tuoi) {
        this.tuoi = tuoi;
    }

    public void setSoDT(String soDT) {
        this.soDT = soDT;
    }

    public double getLuongCoBan() {
        return luongCoBan;
    }

    public void setLuongCoBan(double luongCoBan) {
        this.luongCoBan = luongCoBan;
    }

    public double getHeSoLuong() {
        return heSoLuong;
    }

    public void setHeSoLuong(double heSoLuong) {
        this.heSoLuong = heSoLuong;
    }

    public void nhap() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Nhap ma nhan vien: ");
        maNhanVien = scan.nextLine();
        System.out.println("Nhap ten nhan vien: ");
        tenNhanVien = scan.nextLine();
        System.out.println("Nhap password: ");
        password = scan.nextLine();
        System.out.println("Nhap tuoi: ");
        tuoi = scan.nextInt();
        String c = scan.nextLine();
        System.out.println("Nhap so dien thoai: ");
        soDT = scan.nextLine();
        System.out.println("Nhap luong co ban: ");
        luongCoBan = scan.nextDouble();
        System.out.println("Nhap he so luong: ");
        heSoLuong = scan.nextDouble();
        String x = scan.nextLine();
    }

    protected void xuatThongTinChung() {
        System.out.println("Ma nhan vien: " + maNhanVien);
        System.out.println("Ten nhan vien: " + tenNhanVien);
        System.out.println("Tuoi: " + tuoi);
        System.out.println("So dien thoai: " + soDT);
        System.out.println("Luong co ban: " + luongCoBan);
        System.out.println("He so luong: " + heSoLuong);
        System.out.println("Luong thuc nhan: " + tinhLuong());
    }

    abstract public boolean tangLuong(double luong);

    abstract public double tinhLuong();

    abstract public int getVaiTro();

    abstract public void xuat();
}
