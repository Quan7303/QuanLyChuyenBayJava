/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import controller.Controller;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import model.ChuyenBay;
import model.Ve;

/**
 *
 * @author LENOVO
 */
public class DSVeFRM extends JFrame {

    private JButton btnBack, btnDo, btnTrang, btnXanh, btnHuy;
    private JPanel pnChuThich, pnThongTinVe, pnListGhe, pnB, pnB1, pnTT, pnT, pnT1, pnH;
    private JLabel lblDaChon, lblConTrong, lblDangChon, lblTenKH, lblSDT, lblMaGhe, lblVe, lblTitle;
    private JScrollPane jScrollPane2;
    private JTextField txtSDT, txtTenKH;
    private ArrayList<JButton> listGhe = new ArrayList<>();

    public DSVeFRM() {
        initComponents();
        System.out.println(controller.Controller.tk.getLoaiTaiKhoan());
        controller.Controller.dsGheChon.removeAll(controller.Controller.dsGheChon);
        lblTitle.setText("Sơ Đồ Vé Chuyến Bay " + controller.Controller.cb.getMaChuyenBay());

        if (Controller.cb.getTrangThai() == ChuyenBay.HUYCHUYEN || Controller.cb.getTrangThai() == ChuyenBay.HOANTAT) {
            btnHuy.setVisible(false);
        }
        
        ArrayList<String> mapGhe = new ArrayList<>();
        int soGhe = controller.Controller.cb.getSoGhe();
        pnThongTinVe.setVisible(false);
        mapGhe.add("");
        for (int i = 0; i < soGhe; i++) {
            mapGhe.add("0");
        }

        for (Ve Ve : controller.Controller.cb.getArrayListVe()) {
            mapGhe.set(Integer.parseInt(Ve.getMaGhe()), Ve.getMaGhe());
        }

        int chiso = 1;
        while (true) {
            JButton jButton1 = new JButton();
            jButton1.setPreferredSize(new Dimension(45, 45));
            pnListGhe.add(jButton1);
            jButton1.setText(String.valueOf(chiso));
            
            jButton1.setFont(new Font("Segoe UI", Font.BOLD, 12));
            jButton1.setFocusPainted(false);
            jButton1.setBorderPainted(true);
            jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
            
            if (!mapGhe.get(chiso).equals("0")) {//Do
                jButton1.setBackground(new Color(220, 53, 69));
                jButton1.setForeground(Color.WHITE);
                jButton1.setBorder(javax.swing.BorderFactory.createLineBorder(new Color(200, 33, 49), 2));
                if (Controller.tk.getLoaiTaiKhoan().trim().equals("guest")) {
                    jButton1.setEnabled(false);
                }
            } else {
                jButton1.setBackground(new Color(240, 240, 240));
                jButton1.setForeground(new Color(51, 51, 51));
                jButton1.setBorder(javax.swing.BorderFactory.createLineBorder(new Color(200, 200, 200), 2));
                
                if (!Controller.tk.getLoaiTaiKhoan().trim().equals("guest")) {
                    jButton1.setEnabled(false);
                }
            }

            jButton1.addActionListener(new java.awt.event.ActionListener() {
                @Override
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    chonGhe(evt, jButton1);
                }
            });

            listGhe.add(jButton1);
            if (chiso++ == soGhe) {
                return;
            }

        }
    }

    private void chonGhe(java.awt.event.ActionEvent evt, JButton btn) {
        if (Controller.tk.getLoaiTaiKhoan().equals("guest")) {

            for (String st : controller.Controller.dsGheChon) {
                if (btn.getText().equals(st)) {
                    btn.setBackground(new Color(240, 240, 240));//Trang
                    btn.setForeground(new Color(51, 51, 51));
                    btn.setBorder(javax.swing.BorderFactory.createLineBorder(new Color(200, 200, 200), 2));
                    
                    controller.Controller.dsGheChon.remove(st);
                    return;
                }
            }

            if (controller.Controller.dsGheChon.size() + 1 < controller.Controller.soLuongVeChon) {
                btn.setBackground(new Color(40, 167, 69));//xanh
                btn.setForeground(Color.WHITE);
                btn.setBorder(javax.swing.BorderFactory.createLineBorder(new Color(30, 130, 50), 2));
                
                controller.Controller.dsGheChon.add(btn.getText());
            } else {
                controller.Controller.dsGheChon.add(btn.getText());
                controller.Controller.dsVeChon.removeAll(controller.Controller.dsVeChon);
                new ThongTinVeFFM().setVisible(true);
                this.dispose();
            }

        } else {
            pnThongTinVe.setVisible(true);
            for (Ve ve : controller.Controller.cb.getArrayListVe()) {
                if (btn.getText().equals(ve.getMaGhe())) {
                    lblMaGhe.setText(ve.getMaGhe());
                    txtTenKH.setText(ve.getTenHanhKhach());
                    txtSDT.setText(ve.getsDT());
                    return;
                }

            }

        }

    }

    private void initComponents() {
        this.setTitle("SƠ ĐỒ VÉ");
        this.setLayout(new BorderLayout());
        getContentPane().setBackground(new Color(245, 247, 250));

        btnBack = new JButton();
        lblTitle = new JLabel();
        jScrollPane2 = new JScrollPane();
        pnListGhe = new JPanel(new GridLayout(30, 6, 15, 15));
        pnListGhe.setBackground(new Color(245, 247, 250));
        pnListGhe.setBorder(javax.swing.BorderFactory.createEmptyBorder(20, 20, 20, 20));
        pnThongTinVe = new JPanel();
        lblVe = new JLabel();
        lblTenKH = new JLabel();
        lblSDT = new JLabel();
        btnHuy = new JButton();
        lblMaGhe = new JLabel();
        txtTenKH = new JTextField();
        txtSDT = new JTextField();
        pnChuThich = new JPanel();
        btnDo = new JButton();
        btnTrang = new JButton();
        btnXanh = new JButton();
        lblDaChon = new JLabel();
        lblConTrong = new JLabel();
        lblDangChon = new JLabel();

        btnBack.setIcon(new ImageIcon(getClass().getResource("/images/back.png")));
        btnBack.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblTitle.setText("SƠ ĐỒ VÉ");
        lblTitle.setHorizontalAlignment(JLabel.CENTER);
        lblTitle.setFont(new Font("Segoe UI", Font.BOLD, 18));
        lblTitle.setForeground(new Color(51, 51, 51));
        pnB = new JPanel(new GridLayout(2, 1));
        pnB.setBackground(new Color(245, 247, 250));
        pnB.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10));
        pnB1 = new JPanel(new BorderLayout());
        pnB1.setBackground(new Color(245, 247, 250));
        pnB1.add(btnBack, BorderLayout.WEST);
        pnB.add(pnB1);
        pnB.add(lblTitle);

        add(pnB, BorderLayout.NORTH);

        pnT = new JPanel(new BorderLayout());
        pnT.setBackground(new Color(245, 247, 250));
        jScrollPane2.setViewportView(pnListGhe);
        jScrollPane2.setPreferredSize(new Dimension(900, 800));
        jScrollPane2.setBackground(Color.WHITE);

        Font labelFont = new Font("Segoe UI", Font.BOLD, 13);
        Font plainFont = new Font("Segoe UI", Font.PLAIN, 12);

        lblVe.setText("Vé");
        lblVe.setFont(labelFont);
        lblVe.setForeground(new Color(51, 51, 51));
        lblTenKH.setText("Tên Khách Hàng");
        lblTenKH.setFont(labelFont);
        lblTenKH.setForeground(new Color(51, 51, 51));
        lblSDT.setText("SDT");
        lblSDT.setFont(labelFont);
        lblSDT.setForeground(new Color(51, 51, 51));
        btnHuy.setBackground(new Color(220, 53, 69));
        btnHuy.setForeground(Color.WHITE);
        btnHuy.setFont(new Font("Segoe UI", Font.BOLD, 13));
        btnHuy.setText("Hủy Vé");
        btnHuy.setFocusPainted(false);
        btnHuy.setBorderPainted(false);
        btnHuy.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnHuy.setPreferredSize(new Dimension(120, 35));
        
        lblDaChon.setText("Đã Chọn");
        lblDaChon.setFont(plainFont);
        lblDaChon.setForeground(new Color(51, 51, 51));
        lblConTrong.setText("Còn Trống");
        lblConTrong.setFont(plainFont);
        lblConTrong.setForeground(new Color(51, 51, 51));
        lblDangChon.setText("Đang Chọn");
        lblDangChon.setFont(plainFont);
        lblDangChon.setForeground(new Color(51, 51, 51));
        btnDo.setBackground(new Color(220, 53, 69));
        btnDo.setPreferredSize(new Dimension(30, 30));
        btnDo.setBorder(javax.swing.BorderFactory.createLineBorder(new Color(200, 33, 49), 2));
        btnXanh.setBackground(new Color(40, 167, 69));
        btnXanh.setPreferredSize(new Dimension(30, 30));
        btnXanh.setBorder(javax.swing.BorderFactory.createLineBorder(new Color(30, 130, 50), 2));
        btnTrang.setBackground(new Color(240, 240, 240));
        btnTrang.setPreferredSize(new Dimension(30, 30));
        btnTrang.setBorder(javax.swing.BorderFactory.createLineBorder(new Color(200, 200, 200), 2));

        pnThongTinVe.setBackground(Color.WHITE);
        pnThongTinVe.setLayout(new GridLayout(6, 1));
        pnThongTinVe.setBorder(javax.swing.BorderFactory.createCompoundBorder(
                javax.swing.BorderFactory.createLineBorder(new Color(230, 230, 230), 1),
                javax.swing.BorderFactory.createEmptyBorder(15, 15, 15, 15)));

        txtTenKH.setFont(plainFont);
        txtSDT.setFont(plainFont);
        lblMaGhe.setFont(new Font("Segoe UI", Font.BOLD, 14));
        lblMaGhe.setForeground(new Color(0, 120, 215));
        btnBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (controller.Controller.tk.getLoaiTaiKhoan().equals("guest")) {
                    new ChonChuyenBayFRM().setVisible(true);
                } else {
                    new ChuyenBayFRM().setVisible(true);
                }
                dispose();
            }

        });
        btnHuy.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int confirmed = JOptionPane.showConfirmDialog(null,
                        "Xác Nhận Hủy Vé ?", "Xác nhận", JOptionPane.YES_NO_OPTION);

                if (confirmed == JOptionPane.YES_OPTION) {
                    connection.DeleteData.deleteVe(controller.Controller.cb.getMaChuyenBay(), lblMaGhe.getText());
                    listGhe.get(Integer.parseInt(lblMaGhe.getText()) - 1).setEnabled(false);
                    listGhe.get(Integer.parseInt(lblMaGhe.getText()) - 1)
                            .setBackground(new java.awt.Color(240, 240, 240));
                    if (controller.Controller.cb.getTrangThai() == ChuyenBay.HETVE) {
                        connection.UpdateData.capNhatConVe(controller.Controller.cb.getMaChuyenBay());
                    }
                }
            }

        });
        pnTT = new JPanel(new GridLayout(1, 2));
        pnTT.add(lblVe);
        pnTT.add(lblMaGhe);
        pnThongTinVe.add(pnTT);
        pnThongTinVe.add(lblTenKH);
        pnThongTinVe.add(txtTenKH);
        pnThongTinVe.add(lblSDT);
        pnThongTinVe.add(txtSDT);
        pnH = new JPanel();
        pnH.add(btnHuy);
        pnThongTinVe.add(pnH);

        pnChuThich.setBackground(Color.WHITE);
        pnChuThich.setLayout(new GridLayout(3, 2, 10, 15));
        pnChuThich.add(btnTrang);
        pnChuThich.add(lblConTrong);
        pnChuThich.add(btnXanh);
        pnChuThich.add(lblDangChon);
        pnChuThich.add(btnDo);
        pnChuThich.add(lblDaChon);

        pnT1 = new JPanel(new GridLayout(2, 1, 10, 10));
        pnT1.setBackground(new Color(245, 247, 250));
        pnT1.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10));
        pnT1.add(pnThongTinVe);
        pnT1.add(pnChuThich);
        pnT.add(jScrollPane2, BorderLayout.CENTER);
        pnT.add(pnT1, BorderLayout.EAST);

        add(pnT, BorderLayout.CENTER);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        pack();
    }

    public static void main(String[] args) {
        new DSVeFRM().setVisible(true);
    }
}
