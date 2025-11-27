/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import com.toedter.calendar.JDateChooser;
import connection.LoadData;
import controller.Controller;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.*;
import model.KhachHang;
import model.TaiKhoan;

/**
 *
 * @author LENOVO
 */
public class DangKyFRM extends JFrame {

    private JLabel lblTenDN, lblMatKhau, lblHoTen, lblNgaySinh, lblSDT, lblTitle, lblXacThucMK, lblEmail,
            lblLinkDangNhap, lblEmailDomain, baoloiChung;
    private JTextField ipEmail, ipName, ipSDT, ipTenDN;
    private JButton btn1;
    private JPasswordField ipPass, ipXacThuc;
    private JDateChooser jDateNgaySinh;
    private JPanel pn1, pn2, pn21, pn22, pnemail, pn3, pn31, pn32, pn33;

    public DangKyFRM() {
        initComponents();
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
    }

    private void initComponents() {
        this.setTitle("ĐĂNG KÝ");
        this.setSize(450, 550);
        this.setLayout(new BorderLayout());
        lblTenDN = new JLabel("Tên Đăng Nhập");
        lblMatKhau = new JLabel("Mật Khẩu");
        lblHoTen = new JLabel("Họ và Tên");
        lblNgaySinh = new JLabel("Ngày Sinh");
        lblSDT = new JLabel("SDT");
        lblTitle = new JLabel("ĐĂNG KÍ TÀI KHOẢN");
        lblXacThucMK = new JLabel("Xác thực Mật Khẩu");
        lblEmail = new JLabel("Email");
        lblLinkDangNhap = new JLabel("<HTML><u>Đăng Nhập</u></HTML>");
        lblEmailDomain = new JLabel("@gmail.com");

        jDateNgaySinh = new JDateChooser();
        jDateNgaySinh.setDateFormatString("dd/MM/yyyy");
        baoloiChung = new JLabel();
        baoloiChung.setHorizontalAlignment(JLabel.CENTER);
        ipName = new JTextField();
        ipSDT = new JTextField();
        ipEmail = new JTextField();
        ipTenDN = new JTextField();
        ipPass = new JPasswordField();
        ipXacThuc = new JPasswordField();
        btn1 = new JButton("Đăng Ký");

        btn1.setBackground(new Color(34, 197, 94));
        btn1.setForeground(Color.WHITE);
        btn1.setFocusPainted(false);
        btn1.setFont(btn1.getFont().deriveFont(14f));

        lblTitle.setFont(lblTitle.getFont().deriveFont(18f));
        lblTitle.setForeground(new Color(16, 185, 129));
        baoloiChung.setForeground(new Color(220, 20, 60));
        lblLinkDangNhap.setForeground(new Color(34, 197, 94));
        lblLinkDangNhap.setFont(lblLinkDangNhap.getFont().deriveFont(12f));

        JLabel[] formLabels = { lblHoTen, lblNgaySinh, lblSDT, lblEmail, lblTenDN, lblMatKhau, lblXacThucMK };
        for (JLabel lbl : formLabels) {
            lbl.setFont(lbl.getFont().deriveFont(12f));
            lbl.setForeground(new Color(55, 65, 81));
        }

        pn1 = new JPanel();
        pn1.add(lblTitle);
        pn2 = new JPanel(new BorderLayout());
        pn21 = new JPanel(new GridLayout(7, 1));
        pn22 = new JPanel(new GridLayout(7, 1));
        pn21.add(lblHoTen);
        pn21.add(lblNgaySinh);
        pn21.add(lblSDT);
        pn21.add(lblEmail);
        pn21.add(lblTenDN);
        pn21.add(lblMatKhau);
        pn21.add(lblXacThucMK);

        pn22.add(ipName);
        pn22.add(jDateNgaySinh);
        pn22.add(ipSDT);
        pnemail = new JPanel(new BorderLayout());
        pnemail.add(ipEmail, BorderLayout.CENTER);
        pnemail.add(lblEmailDomain, BorderLayout.EAST);
        pn22.add(pnemail);
        pn22.add(ipTenDN);
        pn22.add(ipPass);
        pn22.add(ipXacThuc);

        pn2.add(pn21, BorderLayout.WEST);
        pn2.add(pn22, BorderLayout.CENTER);

        pn3 = new JPanel(new GridLayout(3, 1));
        pn31 = new JPanel();
        pn31.add(baoloiChung);
        pn3.add(pn31);
        pn32 = new JPanel();
        pn32.add(btn1);
        pn3.add(pn32);
        pn33 = new JPanel();
        pn33.add(lblLinkDangNhap);
        pn3.add(pn33);

        this.add(pn1, BorderLayout.NORTH);
        this.add(pn2, BorderLayout.CENTER);
        this.add(pn3, BorderLayout.SOUTH);
        btn1.setOpaque(true);
        btn1.setBorderPainted(false);
        btn1.setContentAreaFilled(true);

        btn1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (checkIP()) {
                    TaiKhoan tk = new TaiKhoan(ipTenDN.getText(), ipPass.getText(), "guest");
                    KhachHang kh = new KhachHang(ipSDT.getText(), ipTenDN.getText(), ipName.getText(),
                            ipEmail.getText()+"@gmai.com", new java.sql.Date(jDateNgaySinh.getDate().getTime()));

                    connection.InsertData.insertTaiKhoan(tk);
                    connection.InsertData.insertKhachHang(kh);

                    new DangNhapFRM().setVisible(true);
                    dispose();
                }
            }

        });

        lblLinkDangNhap.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                new DangNhapFRM().setVisible(true);
                dispose();
            }

        });
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                baoloiChung.setText("");
            }
        });
        ipName.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                baoloiChung.setText("");
            }
        });
        ipSDT.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                baoloiChung.setText("");
            }
        });
        ipEmail.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                baoloiChung.setText("");
            }
        });
        ipTenDN.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                baoloiChung.setText("");
            }
        });
        ipPass.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                baoloiChung.setText("");
            }
        });
        ipXacThuc.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                baoloiChung.setText("");
            }
        });
        jDateNgaySinh.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                baoloiChung.setText("");
            }
        });

        Color bgMain = new Color(247, 250, 252);
        Color panelBg = Color.WHITE;
        Color accentColor = new Color(34, 197, 94);

        this.getContentPane().setBackground(bgMain);

        pn1.setBackground(new Color(249, 250, 251));
        pn1.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(229, 231, 235), 1),
                BorderFactory.createEmptyBorder(20, 20, 20, 20)));

        pn2.setBackground(panelBg);
        pn2.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(229, 231, 235), 1),
                BorderFactory.createEmptyBorder(25, 30, 25, 30)));

        pn21.setBackground(panelBg);
        pn22.setBackground(panelBg);

        pn3.setBackground(new Color(249, 250, 251));
        pn3.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createMatteBorder(1, 0, 0, 0, new Color(229, 231, 235)),
                BorderFactory.createEmptyBorder(15, 20, 15, 20)));
        pn31.setBackground(new Color(249, 250, 251));
        pn32.setBackground(new Color(249, 250, 251));
        pn33.setBackground(new Color(249, 250, 251));

    }

    private boolean checkIP() {
        String name = ipTenDN.getText();
        if (ipName.getText().length() == 0) {
            baoloiChung.setText("Họ và tên không được để trống");
            return false;
        }
        if (jDateNgaySinh.getDate() == (null)) {
            baoloiChung.setText("Vui lòng chọn ngày sinh");
            return false;
        } else {
            baoloiChung.setText("");
        }
        String str = ipSDT.getText();
        if (str.length() != 10) {
            baoloiChung.setText("Số điện thoại không hợp lệ");
            return false;
        }

        for (int i = 0; i < str.length(); i++) {
            if (!Character.isDigit(str.charAt(i))) {
                baoloiChung.setText("Số điện thoại không hợp lệ");
                return false;
            }
        }
        if (ipEmail.getText().length() == 0) {
            baoloiChung.setText("Email không được để trống");
            return false;
        }
        if (name.length() == 0) {
            baoloiChung.setText("Ten đăng nhập không được để trống");
            return false;
        }
        new LoadData();
        for (TaiKhoan tk : Controller.arrayListTaiKhoan) {
            if (name.equals(tk.getTenDangNhap().trim())) {
                baoloiChung.setText("Tên Đăng Nhập đã tồn tại");
                return false;
            }
        }

        if (ipPass.getText().length() == 0) {
            baoloiChung.setText("Mật khẩu không được để trống");
            return false;
        }

        if (!ipXacThuc.getText().equals(ipPass.getText())) {
            baoloiChung.setText("Xác thực mật khẩu không trùng khớp");
            return false;
        }

        return true;
    }

    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DangKyFRM().setVisible(true);
            }
        });
    }
}
