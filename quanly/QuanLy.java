package exercise.quanly;

import java.util.Scanner;
import java.util.*;

public class QuanLy {
    private static int role;
    static String a, b;
    HashSet<PhongBan> dspb = new HashSet<PhongBan>();
    Scanner scan = new Scanner(System.in);
    int count = 0;

    public QuanLy() {
        taoPhongBan();
    }

    public boolean dangNhap(String id, String pass) {
        for (PhongBan pb : dspb) {
            Iterator it = pb.getDsnv().entrySet().iterator();
            while (it.hasNext()) {
                HashMap.Entry entry = (HashMap.Entry) it.next();
                NhanVien nv = (NhanVien) entry.getValue();
                if ((nv.getMaNhanVien().equals(id)) && (nv.getPassword().equals(pass))) {
                    role = nv.getVaiTro();
                    return true;
                }
            }
        }
        return false;
    }

    public void taoPhongBan() {
        int a = 0;
        do {
            System.out.println("***************Moi tao phong ban*************** ");
            System.out.println("1. Nhap ten phong ban");
            System.out.println("2. Thoat");
            System.out.println("Lua chon: ");
            a = scan.nextInt();
            if (a == 1) {
                PhongBan pb = new PhongBan();
                pb.setTenPhongBan(scan.nextLine());
                dspb.add(pb);
                System.out.println("Them nhan vien vao phong ban");
                pb.nhapDS();
            }
        }
            while (a == 1) ;
    }

    public void run() {
        do {
            while (true) {
                String aru = scan.nextLine();
                System.out.println("\t\tDANG NHAP");
                System.out.print("Nhap ID:");
                a = scan.nextLine();
                System.out.print("Nhap pass: ");
                b = scan.nextLine();
                if (dangNhap(a, b)) {
                    System.out.println("Dang nhap thanh cong ~~");
                    break;
                } else System.out.println("Dang nhap khong thanh cong :(( Dang nhap lai");
            }
            PhongBan pb = new PhongBan();
            for (PhongBan setPb : dspb) {
                if (setPb.timKiemTheoMaNV(a)) {
                    pb = setPb;
                    break;
                }
            }

            switch (role) {
                case 1: //Truong phong
                    int tacVu = 0;
                    while (tacVu != 8) {
                        System.out.println("Cach tac vu cau truong phong");
                        System.out.println("1. Them nhan vien vao phong ban");
                        System.out.println("2. Xoa nhan vien khoi phong ban");
                        System.out.println("3. Tim nhan vien");
                        System.out.println("4. Sua thong tin nhan vien");
                        System.out.println("5. In thong tin ");
                        System.out.println("6. Tinh tong va trung binh luong");
                        System.out.println("7. Kiem tra tang luong");
                        System.out.println("8. Exit");
                        tacVu = scan.nextInt();

                        switch (tacVu) {
                            case 1://Them nhan vien vao phong ban
                                pb.nhapDS();
                                break;
                            case 2: //Xoa nhan vien khoi phong ban
                                String test = scan.nextLine();
                                System.out.println("Nhap vao ma so nhan vien can xoa: ");
                                String xoa = scan.nextLine();
                                if (pb.xoaNhanVien(xoa)) {
                                    System.out.println("Xoa thanh cong");
                                    pb.inBaoCao();
                                } else {
                                    System.out.println("Khong tim thay ma nhan vien ban vua nhap trong phong ban " + pb.getTenPhongBan());
                                }
                                break;
                            case 3: //Tim nhan vien
                                String test1 = scan.nextLine();
                                System.out.println("Nhap vao ten nhan vien can tim kiem: ");
                                String timkiem = scan.nextLine();
                                if (pb.timKiemTheoTen(timkiem)) {
                                    System.out.println("Tim thay nhan vien trong phong " + pb.getTenPhongBan());
                                } else {
                                    System.out.println("Khong tim thay ma nhan vien ban vua nhap trong phong ban " + pb.getTenPhongBan());
                                }
                                break;
                            case 4: //Sua thong tin nhan vien
                                String test2 = scan.nextLine();
                                System.out.println("Nhap vao ma so nhan vien can sua: ");
                                String sua = scan.nextLine();
                                pb.suaNhanVien(sua);
                                pb.inBaoCao();
                                break;
                            case 5: //In thong tin
                                System.out.println("In thong tin cac nhan vien trong phong " + pb.getTenPhongBan());
                                pb.inBaoCao();
                                break;
                            case 6: //Tinh tong va trung binh luong
                                System.out.println("In ra luong va tong luong cua phong " + pb.getTenPhongBan());
                                System.out.println("Phong ban  " + pb.getTenPhongBan());
                                System.out.println("Tong luong: " + pb.tongLuong());
                                System.out.println("Trung binh luong: " + pb.trungBinhLuong());
                                break;
                            case 7://Kiem tra tang luong
                                String test4 = scan.nextLine();
                                System.out.println("Nhap vao ma so nhan vien ban muon kiem tra: ");
                                String test5 = scan.nextLine();
                                System.out.println("Nhap vao muc luong du kien: ");
                                double tangLuong = scan.nextDouble();
                                pb.kTraTangLuong(test5, tangLuong);
                                break;

                            case 8: //thoat
                                break;
                            default:
                                System.out.println("Nhap sai moi nhap lai");
                        }
                    }
                    break;
                case 2://Lap trinh vien va Kiem chung vien
                    pb.inThongTin(a);
                    break;
                default:
                    System.out.println("Ket thuc");
            }
            String c = scan.nextLine();
        } while (role == 1 || role == 2);
    }

    public static void main(String args[]) {
        QuanLy quanLy = new QuanLy();
        quanLy.run();

    }
}


