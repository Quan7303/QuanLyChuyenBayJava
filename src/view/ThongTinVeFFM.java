/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import static controller.Controller.arrayListTaiKhoan;
import static controller.Controller.arrayListTimChuyenBay;
import static controller.Controller.cb;
import static controller.Controller.dsGheChon;
import static controller.Controller.dsVeChon;
import static controller.Controller.soLuongVeChon;
import static controller.Controller.tk;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import model.TaiKhoan;
import model.Ve;

/**
 *
 * @author LENOVO
 */
public class ThongTinVeFFM extends JFrame {

    private JLabel lblTitle, lblBaoLoi, lblSDT, lblTenHK, lblSoGhe, lblMaGhe;
    private JButton btnXacNhan;
    private JTextField txtHoTen, txtSDT;
    private JPanel pnB, pnT, pnT1, pnT2, pnN, pnN1, pnN2;

    public ThongTinVeFFM() {
        initComponents();
        lblTitle.setText("Thông Tin Hành Khách " + (controller.Controller.dsVeChon.size() + 1));
        lblMaGhe.setText(dsGheChon.get(dsVeChon.size()));
        System.out.println(dsGheChon.size());
        if ((controller.Controller.dsVeChon.size() + 1) == controller.Controller.dsGheChon.size()) {
            btnXacNhan.setText("Xác Nhận Đặt Vé");
        }

        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
    }

    private boolean checkIP() {
        if (txtHoTen.getText().length() == 0) {
            lblBaoLoi.setText("Họ Tên không được để trống");
            return false;
        }

        String str = txtSDT.getText();
        if (str.length() != 10) {
            lblBaoLoi.setText("Số điện thoại không hợp lệ");
            return false;
        }

        for (int i = 0; i < str.length(); i++) {
            if (!Character.isDigit(str.charAt(i))) {
                lblBaoLoi.setText("Số điện thoại không hợp lệ");
                return false;
            }
        }
        return true;
    }

    private void initComponents() {
        setTitle("NHẬP THÔNG TIN VÉ");
        this.setLayout(new BorderLayout());
        this.setSize(450, 380);
        getContentPane().setBackground(new Color(245, 247, 250));

        lblSDT = new JLabel();
        txtSDT = new JTextField();
        lblTenHK = new JLabel();
        txtHoTen = new JTextField();
        lblSoGhe = new JLabel();
        lblTitle = new JLabel();
        btnXacNhan = new JButton();
        lblMaGhe = new JLabel();
        lblBaoLoi = new JLabel();

        Font labelFont = new Font("Segoe UI", Font.BOLD, 13);
        Font titleFont = new Font("Segoe UI", Font.BOLD, 16);
        Font plainFont = new Font("Segoe UI", Font.PLAIN, 12);

        lblSDT.setText("SĐT");
        lblSDT.setFont(labelFont);
        lblSDT.setForeground(new Color(51, 51, 51));
        lblTenHK.setText("Tên Hành Khách");
        lblTenHK.setFont(labelFont);
        lblTenHK.setForeground(new Color(51, 51, 51));
        lblSoGhe.setText("Mã Ghế");
        lblSoGhe.setFont(labelFont);
        lblSoGhe.setForeground(new Color(51, 51, 51));
        lblTitle.setText("Title");
        lblTitle.setFont(titleFont);
        lblTitle.setForeground(new Color(51, 51, 51));
        lblTitle.setHorizontalAlignment(JLabel.CENTER);
        btnXacNhan.setText("Tiếp Theo");
        btnXacNhan.setBackground(new Color(0, 120, 215));
        btnXacNhan.setForeground(Color.WHITE);
        btnXacNhan.setFont(new Font("Segoe UI", Font.BOLD, 14));
        btnXacNhan.setPreferredSize(new Dimension(150, 40));
        btnXacNhan.setFocusPainted(false);
        btnXacNhan.setBorderPainted(false);
        btnXacNhan.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnXacNhan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnXacNhan.setBackground(new Color(0, 102, 204));
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnXacNhan.setBackground(new Color(0, 120, 215));
            }
        });

        lblMaGhe.setFont(new Font("Segoe UI", Font.BOLD, 14));
        lblMaGhe.setForeground(new Color(0, 120, 215));
        lblBaoLoi.setFont(plainFont);
        lblBaoLoi.setForeground(new Color(220, 53, 69));

        txtHoTen.setFont(plainFont);
        txtSDT.setFont(plainFont);
        txtHoTen.setBorder(javax.swing.BorderFactory.createCompoundBorder(
                javax.swing.BorderFactory.createLineBorder(new Color(200, 200, 200), 1),
                javax.swing.BorderFactory.createEmptyBorder(8, 10, 8, 10)));
        txtSDT.setBorder(javax.swing.BorderFactory.createCompoundBorder(
                javax.swing.BorderFactory.createLineBorder(new Color(200, 200, 200), 1),
                javax.swing.BorderFactory.createEmptyBorder(8, 10, 8, 10)));

        btnXacNhan.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (checkIP()) {
                    dsVeChon.add(new Ve(cb.getMaChuyenBay(), txtHoTen.getText(), txtSDT.getText(), dsGheChon.get(dsVeChon.size())));

                    if ((dsVeChon.size()) < dsGheChon.size()) {
                        new ThongTinVeFFM().setVisible(true);
                        dispose();
                    } else {

                        connection.InsertData.insertVe(dsVeChon);
                        if (cb.getSoGheTrong() == soLuongVeChon) {
                            connection.UpdateData.capNhatHetVe(cb.getMaChuyenBay());
                        }
                        dsVeChon.removeAll(dsVeChon);
                        arrayListTimChuyenBay.remove(arrayListTimChuyenBay);
                        for (TaiKhoan taiKhoan : arrayListTaiKhoan) {
                            if (tk.getTenDangNhap().equals(taiKhoan.getTenDangNhap())) {
                                controller.Controller.tk = taiKhoan;
                                break;
                            }
                        }
                        new TimChuyenBayFRM().setVisible(true);
                        dispose();
                    }
                }
            }

        });
        txtHoTen.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                lblBaoLoi.setText("");
            }
        });
        txtSDT.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                lblBaoLoi.setText("");
            }
        });
        pnB = new JPanel();
        pnB.setBackground(new Color(245, 247, 250));
        pnB.setBorder(javax.swing.BorderFactory.createEmptyBorder(15, 15, 10, 15));
        pnB.add(lblTitle);

        pnT = new JPanel(new BorderLayout());
        pnT.setBackground(Color.WHITE);
        pnT.setBorder(javax.swing.BorderFactory.createCompoundBorder(
                javax.swing.BorderFactory.createLineBorder(new Color(230, 230, 230), 1),
                javax.swing.BorderFactory.createEmptyBorder(25, 25, 25, 25)));

        pnT1 = new JPanel(new GridLayout(3, 1));
        pnT2 = new JPanel(new GridLayout(3, 1));
        pnT1.add(lblTenHK);
        pnT1.add(lblSDT);
        pnT1.add(lblSoGhe);
        pnT2.add(txtHoTen);
        pnT2.add(txtSDT);
        pnT2.add(lblMaGhe);
        pnT.add(pnT1, BorderLayout.WEST);
        pnT.add(pnT2, BorderLayout.CENTER);

        pnN = new JPanel(new GridLayout(2, 1));
        pnN.setBackground(new Color(245, 247, 250));
        pnN.setBorder(javax.swing.BorderFactory.createEmptyBorder(15, 15, 15, 15));
        pnN1 = new JPanel();
        pnN2 = new JPanel();
        pnN1.add(lblBaoLoi);
        pnN2.add(btnXacNhan);
        pnN.add(pnN1);
        pnN.add(pnN2);

        add(pnB, BorderLayout.NORTH);
        add(pnT, BorderLayout.CENTER);
        add(pnN, BorderLayout.SOUTH);
        // pack();
    }

    public static void main(String[] args) {
        new ThongTinVeFFM().setVisible(true);

    }
}
