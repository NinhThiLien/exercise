package exercise.quanly;

import java.util.Scanner;
import java.util.*;

public class PhongBan {
    private String tenPhongBan;

    private int counter;

    public final static int NV_MAX = 20;

    int a = 0;

    private HashMap<String, NhanVien> dsnv = new HashMap<String, NhanVien>();

    public HashMap<String, NhanVien> getDsnv() {
        return dsnv;
    }


    public void setDsnv(HashMap<String, NhanVien> dsnv) {
        this.dsnv = dsnv;
    }

    public String getTenPhongBan() {
        return tenPhongBan;
    }

    public void setTenPhongBan(String tenPhongBan) {
        this.tenPhongBan = tenPhongBan;
    }


    public byte getNV_MAX() {
        return NV_MAX;
    }


    public PhongBan(String tenPB, HashMap ds) {
        tenPhongBan = tenPB;
        dsnv = ds;
    }

    public PhongBan() {
        dsnv = new HashMap<String, NhanVien>();

        tenPhongBan = "aru";
    }

    public void nhapDS() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Nhap cong viec cua nhan vien:  ");
        System.out.println("1. Truong phong");
        System.out.println("2. Lap trinh vien");
        System.out.println("3. Kiem chung vien");
        a = scan.nextInt();
        NhanVien nv = null;
        if (a == 1) {
            nv = new TruongPhong();
        } else if (a == 2) {
            nv = new LapTrinhVien();
        } else if (a == 3) {
            nv = new KiemChungVien();
        } else return;
        System.out.println("Nhap thong tin nhan vien ");
        boolean bln;
        do {
            nv.nhap();
            bln = themNhanVien(nv);
        } while (!bln);
        System.out.println("Tiep tuc them nhan vien: (y/n)");
        String hieu = scan.nextLine();
        String x = scan.nextLine();
        if (x.equals("y")) {
            nhapDS();
        } else return;

    }

    public boolean themNhanVien(NhanVien nv) {
        if (dsnv.containsValue(nv)) {
            System.out.println("Ma nhan vien k hop le!!! XIn moi nhap lai");
            return false;
        } else {
            //dsnv[counter++] = nv;
            dsnv.put(nv.getMaNhanVien(), nv);
            return true;
        }
    }

    /*private boolean checkNhanVienExist(String maNV) {
        for (int j = 0; j < dsnv.lenght; j++) {
            if (dsnv[j] != null && dsnv[j].getMaNhanVien().equals(maNV)) {
                return true;
            }
        }

        return false;
        
    }*/

    public void inBaoCao() {
        /*for (int i = 0; i < dsnv.length; i++) {
            if (dsnv[i] != null) {
                System.out.println("====================================");
                dsnv[i].xuat();
                System.out.println("====================================");
            }
        }*/

        for (HashMap.Entry<String, NhanVien> ds : dsnv.entrySet()) {
            String key = ds.getKey();
            NhanVien nv = ds.getValue();
            nv.xuat();
        }
    }

    public boolean xoaNhanVien(String maNV) {
        /*for (int i = 0; i < dsnv.length; i++) {
            if (dsnv[i] != null) {
                if (dsnv[i].getMaNhanVien().equals(maNV)) {
                    for (int k = i; k < dsnv.length - 1; k++) {
                        dsnv[k] = dsnv[k + 1];
                    }
                    dsnv[dsnv.length - 1] = null;
                    return true;
                }
            }

        }*/
        if (dsnv.remove(maNV) == null)
            return false;
        return true;
    }

    public boolean timKiemTheoTen(String tenNV) {
        /*for (int j = 0; j < dsnv.length; j++) {
            if (dsnv[j] != null) {
                if (dsnv[j].getTenNhanVien().equals(tenNV)) {
                    return true;
                }
            }
        }*/
        Iterator it = dsnv.entrySet().iterator();
        while (it.hasNext()) {
            HashMap.Entry entry = (HashMap.Entry) it.next();
            NhanVien nv = (NhanVien) entry.getValue();
            if (nv.getTenNhanVien().equals(tenNV)) return true;
        }
        return false;
    }

    public boolean timKiemTheoMaNV(String maNV) {
        if (dsnv.containsKey(maNV)) return true;
        return false;
    }

    public boolean suaNhanVien(String maNV) {
//        if (checkNhanVienExist(maNV) == true){
        if (dsnv.containsKey(maNV) == true) {
            /*for (int j = 0; j < dsnv.size(); j++) {
                if (dsnv[j] != null) {*/
            Iterator it = dsnv.entrySet().iterator();
            while (it.hasNext()) {
                HashMap.Entry entry = (HashMap.Entry) it.next();
                NhanVien nv = (NhanVien) entry.getValue();
                Scanner scan = new Scanner(System.in);
                System.out.println("Nhap ten nhan vien: ");
                nv.setTenNhanVien(scan.nextLine());
                System.out.println("Nhap tuoi: ");
                nv.setTuoi(scan.nextInt());
                String c = scan.nextLine();
                System.out.println("Nhap so dien thoai: ");
                nv.setSoDT(scan.nextLine());
                System.out.println("Nhap luong co ban: ");
                nv.setLuongCoBan(scan.nextDouble());
                System.out.println("Nhap he so luong: ");
                nv.setHeSoLuong(scan.nextDouble());
                return true;
            }
        }
        return false;
    }


    public double tongLuong() {
        double tong = 0.0;
        /*for (int i = 0; i < dsnv.length; i++) {
            if (dsnv[i] != null) {
                if (getDsnv()[i] != null) {
                    tong += getDsnv()[i].tinhLuong();
                }
            }
        }*/
        Iterator it = dsnv.entrySet().iterator();
        while (it.hasNext()) {
            HashMap.Entry entry = (HashMap.Entry) it.next();
            NhanVien nv = (NhanVien) entry.getValue();
            tong += nv.tinhLuong();
        }
        return tong;
    }

    public void kTraTangLuong(String maNV, double luong) {
       if(dsnv.containsKey(maNV)==true)
       {
           Iterator it = dsnv.entrySet().iterator();
           while (it.hasNext()) {
               HashMap.Entry entry = (HashMap.Entry) it.next();
               NhanVien nv = (NhanVien) entry.getValue();
               if(nv.tangLuong(luong)) System.out.println("Du dieu kien tang luong");
               else System.out.println("Khong du dieu kien tang luong");
           }
       }
    }

    public double trungBinhLuong() {
        return tongLuong() /dsnv.size();
    }

    public void inThongTin(String maNV)
    {
            Iterator it = dsnv.entrySet().iterator();
            while (it.hasNext()) {
                HashMap.Entry entry = (HashMap.Entry) it.next();
                NhanVien nv = (NhanVien) entry.getValue();
                if (nv.getMaNhanVien().equals(maNV)) nv.xuatThongTinChung();
            }

    }
}
