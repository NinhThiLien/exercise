package exercise.quanly;

import java.util.Scanner;

public class KiemChungVien extends NhanVien {
    private int soLoi;
    private final double LUONG_MAX = 15000000;

    Scanner scan = new Scanner(System.in);

    public KiemChungVien() {
        super();
        soLoi = 0;
    }
    @Override
    public boolean tangLuong(double luong) {
        if (luong < LUONG_MAX) {
            return true;
        }
        return false;
    }

    public void nhap(){
        super.nhap();
        System.out.println("Nhap vao so loi: ");
        soLoi=scan.nextInt();

    }

    public double tinhLuong(){
        return getLuongCoBan()*getHeSoLuong()+soLoi*50000;
    }

    public void xuat(){
        System.out.println("Xuat kiem chung vien");
        xuatThongTinChung();
    }


    public int getVaiTro() {
        return 2;
    }
}