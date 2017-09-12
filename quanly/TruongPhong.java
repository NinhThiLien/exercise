package exercise.quanly;

import java.util.Scanner;

public  class TruongPhong extends NhanVien {
    private double phuCap;
    private final double LUONG_MAX = 50000000;
    private double soNamDuongChuc;
    Scanner scan = new Scanner(System.in);

    public TruongPhong(String maNhanVien, String tenNhanVien,String password, int tuoi, String soDT, double luongCoBan, double heSoLuong, double phuCap, double soNamDuongChuc) {
        super(maNhanVien, tenNhanVien,password, tuoi, soDT, luongCoBan, heSoLuong);
        this.phuCap = phuCap;
        this.soNamDuongChuc = soNamDuongChuc;
    }

    public TruongPhong(){
        super();
        this.phuCap =500000;
        this.soNamDuongChuc =1;
    }
    public boolean tangLuong(double luong){

        if(luong<LUONG_MAX){
            return true;
        }
        return false;
    }

    public void nhap(){
        super.nhap();
        System.out.println("Nhap vao phu cap: ");
        phuCap=scan.nextDouble();
        System.out.println("So nam duong chuc: ");
        soNamDuongChuc=scan.nextDouble();

    }
    public double tinhLuong() {
        return getLuongCoBan() * getHeSoLuong() + phuCap;
    }

    public void xuat() {
        System.out.println("Xuat truong phong");
        xuatThongTinChung();
    }

    public int getVaiTro() {
        return 1;
    }
}