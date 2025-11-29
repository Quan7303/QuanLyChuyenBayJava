/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package connection;

import controller.Controller;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.ChuyenBay;
import model.DuongBay;
import model.KhachHang;
import model.MayBay;
import model.NhanVien;
import model.SanBay;
import model.TaiKhoan;
import model.Ve;


public class LoadData {

    public static void loadTableTaiKhoan() {
        ResultSet rs = DataConnection.retrieveData("select * from taikhoan");
        try {
            while (rs.next()) {
                TaiKhoan taiKhoan = new TaiKhoan(
                        rs.getString(1).trim(),
                        rs.getString(2).trim(),
                        rs.getString(3).trim());
                Controller.arrayListTaiKhoan.add(taiKhoan);
            }
        } catch (SQLException ex) {
            Logger.getLogger(LoadData.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void loadTableNhanVien() {
        ResultSet rs = DataConnection.retrieveData("select * from NHANVIEN");
        try {
            while (rs.next()) {
                NhanVien nv = new NhanVien(
                        rs.getString(1).trim(),
                        rs.getString(2).trim(),
                        rs.getString(3).trim(),
                        rs.getInt(4));
                Controller.arrayListNhanVien.add(nv);
            }
        } catch (SQLException ex) {
            Logger.getLogger(LoadData.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void loadTableKhachHang() {
        ResultSet rs = DataConnection.retrieveData("select * from khachhang");
        try {
            while (rs.next()) {
                KhachHang nv = new KhachHang(
                        rs.getString(1).trim(),
                        rs.getString(2).trim(),
                        rs.getString(3).trim(),
                        rs.getString(4).trim(),
                        rs.getDate(5));
                Controller.arrayListKhachHang.add(nv);
            }
        } catch (SQLException ex) {
            Logger.getLogger(LoadData.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void loadTableDuongBay() {
        ResultSet rs = DataConnection.retrieveData("select * from DUONGBAY");
        try {
            while (rs.next()) {
                DuongBay duongBay = new DuongBay(
                        rs.getString(1).trim(),
                        rs.getString(2).trim(),
                        rs.getString(3).trim(),
                        rs.getInt(4));

                Controller.arrayListDuongBay.add(duongBay);
            }
        } catch (SQLException ex) {
            Logger.getLogger(LoadData.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void loadTableMayBay() {
        ResultSet rs = DataConnection.retrieveData("select * from MAYBAY");
        try {
            while (rs.next()) {
                MayBay mayBay = new MayBay(
                        rs.getString(1).trim(),
                        rs.getString(2).trim(),
                        rs.getInt(3));
                Controller.arrayListMayBay.add(mayBay);
            }
        } catch (SQLException ex) {
            Logger.getLogger(LoadData.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void loadTableSanBay() {
        ResultSet rs = DataConnection.retrieveData("select * from SANBAY");
        try {
            while (rs.next()) {
                SanBay sanBay = new SanBay(
                        rs.getString(1).trim(),
                        rs.getString(2).trim(),
                        rs.getString(3).trim());
                Controller.arrayListSanBay.add(sanBay);
            }
        } catch (SQLException ex) {
            Logger.getLogger(LoadData.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static void loadTableChuyenBay() {
        ResultSet rs = DataConnection.retrieveData("select * from CHUYENBAY");

        Date datenow = Calendar.getInstance().getTime();
        try {
            while (rs.next()) {
                ChuyenBay cb = new ChuyenBay(
                        rs.getString(1).trim(),
                        rs.getString(2).trim(),
                        ChuyenBay.timDuongBay(rs.getString(3).trim()),
                        rs.getDate(4),
                        rs.getTime(5),
                        rs.getInt(6));
                cb.setArrayListVe(loadTableVe(cb.getMaChuyenBay().trim()));
                if (cb.getTrangThai() == ChuyenBay.CONVE || cb.getTrangThai() == ChuyenBay.HETVE) {
                    if (datenow.after(cb.getCBTime())) {
                        connection.UpdateData.capNhatHoanTat(cb.getMaChuyenBay());
                        cb.setTrangThai(ChuyenBay.HOANTAT);
                    }
                }

                controller.Controller.arrayListChuyenBay.add(cb);
            }
        } catch (SQLException ex) {
            Logger.getLogger(LoadData.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static ArrayList<Ve> loadTableVe(String maChuyenBay) {

        ArrayList<Ve> arrayListVe = new ArrayList<>();
        ResultSet rs = DataConnection.retrieveData("select * from Ve where mcb like '" + maChuyenBay + "'");
        try {
            while (rs.next()) {
                Ve ve = new Ve(
                        rs.getString(1).trim(),
                        rs.getString(2).trim(),
                        rs.getString(3).trim(),
                        rs.getString(4).trim());
                arrayListVe.add(ve);
            }
        } catch (SQLException ex) {
            Logger.getLogger(LoadData.class.getName()).log(Level.SEVERE, null, ex);
        }
        return arrayListVe;
    }

    public LoadData() {
        controller.Controller.arrayListSanBay.removeAll(controller.Controller.arrayListSanBay);
        controller.Controller.arrayListDuongBay.removeAll(controller.Controller.arrayListDuongBay);
        controller.Controller.arrayListTaiKhoan.removeAll(controller.Controller.arrayListTaiKhoan);
        controller.Controller.arrayListMayBay.removeAll(controller.Controller.arrayListMayBay);
        controller.Controller.arrayListKhachHang.removeAll(controller.Controller.arrayListKhachHang);
        controller.Controller.arrayListNhanVien.removeAll(controller.Controller.arrayListNhanVien);
        controller.Controller.arrayListChuyenBay.removeAll(controller.Controller.arrayListChuyenBay);

        loadTableTaiKhoan();
        loadTableSanBay();
        loadTableDuongBay();
        loadTableNhanVien();
        loadTableMayBay();
        loadTableChuyenBay();
        loadTableKhachHang();
        System.out.println("LOAD thanh cong");
    }
}
