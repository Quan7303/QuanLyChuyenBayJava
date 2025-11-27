/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

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
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import model.TaiKhoan;

/**
 *
 * @author LENOVO
 */
public class DangNhapFRM extends JFrame {

    private JLabel baoLoi;
    private JLabel lblMatKhau;
    private JLabel lblTenDN;
    private JLabel btnSignUp;
    private JButton btnLogin;
    private JTextField ipName;
    private JPasswordField ipPass;
    private JPanel pn1, pn2, pn21, pn22;

    public DangNhapFRM() {
        initComponents();
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
    }

    private void initComponents() {
        setTitle("ĐĂNG NHẬP");
        setSize(300, 350);

        baoLoi = new JLabel();
        lblMatKhau = new JLabel("Mật Khẩu");
        lblTenDN = new JLabel("Tên Đăng Nhập");
        btnSignUp = new JLabel("<HTML><u>Đăng ký</u></HTML>");
        btnLogin = new JButton("Đăng Nhập");
        ipName = new JTextField();
        ipPass = new JPasswordField();
        baoLoi.setHorizontalAlignment(JLabel.CENTER);
        baoLoi.setForeground(new Color(220, 20, 60));

        btnLogin.setBackground(new Color(59, 130, 246));
        btnLogin.setForeground(Color.WHITE);
        btnLogin.setFocusPainted(false);
        btnLogin.setFont(btnLogin.getFont().deriveFont(14f));

        lblTenDN.setFont(lblTenDN.getFont().deriveFont(13f));
        lblMatKhau.setFont(lblMatKhau.getFont().deriveFont(13f));
        btnSignUp.setForeground(new Color(25, 25, 112));
        pn1 = new JPanel();
        pn2 = new JPanel();

        this.setLayout(new BorderLayout());
        pn1.setLayout(new GridLayout(5, 1));
        pn2.setLayout(new GridLayout(2, 1));
        pn1.add(lblTenDN);
        pn1.add(ipName);
        pn1.add(lblMatKhau);
        pn1.add(ipPass);
        pn1.add(baoLoi);

        pn21 = new JPanel();
        pn21.add(btnLogin);
        pn22 = new JPanel();
        pn22.add(btnSignUp);

        pn2.add(pn21);
        pn2.add(pn22);

        this.add(pn1, BorderLayout.CENTER);
        this.add(pn2, BorderLayout.SOUTH);
        btnLogin.addActionListener((ActionEvent e) -> {
            String name1 = ipName.getText();
            String pass = ipPass.getText();
            LoadData.loadTableTaiKhoan();
            int index = -1;
            for (TaiKhoan tk : Controller.arrayListTaiKhoan) {
                if (name1.equals(tk.getTenDangNhap().trim())) {
                    index = Controller.arrayListTaiKhoan.indexOf(tk);
                }
            }
            if (index == -1) {
                baoLoi.setText("Tài khoản Không Tồn Tại");
            } else {
                TaiKhoan tk = Controller.arrayListTaiKhoan.get(index);
                if (tk.getMatKhau().equals(pass)) {
                    Controller.tk = tk;
                    if (tk.getLoaiTaiKhoan().equals("guest")) {
                        new TimChuyenBayFRM().setVisible(true);
                        dispose();

                    } else {
                        new QuanLyFRM().setVisible(true);
                        dispose();
                    }

                }
                baoLoi.setText("Sai Mật Khẩu");
            }
        });
        ipName.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                baoLoi.setText("");
            }
        });
        ipPass.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                baoLoi.setText("");
            }
        });
        btnSignUp.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                new DangKyFRM().setVisible(true);
                dispose();
            }
        });

        Color bgMain = new Color(245, 247, 250);
        Color panelBg = Color.WHITE;
        Color accentColor = new Color(59, 130, 246);

        this.getContentPane().setBackground(bgMain);

        pn1.setBackground(panelBg);
        pn1.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(229, 231, 235), 1),
                BorderFactory.createEmptyBorder(30, 40, 30, 40)));

        pn2.setBackground(panelBg);
        pn2.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createMatteBorder(1, 0, 0, 0, new Color(229, 231, 235)),
                BorderFactory.createEmptyBorder(15, 40, 15, 40)));

        pn21.setBackground(panelBg);
        pn22.setBackground(panelBg);

        lblTenDN.setForeground(new Color(55, 65, 81));
        lblMatKhau.setForeground(new Color(55, 65, 81));
        btnSignUp.setForeground(accentColor);
        btnSignUp.setFont(btnSignUp.getFont().deriveFont(12f));

    }

    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(() -> {
            new DangNhapFRM().setVisible(true);
        });
    }
}
