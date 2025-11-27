/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;

/**
 *
 * @author LENOVO
 */
public class DoiMKFRM extends JFrame {

    private JLabel lblPWChange, lblRecentPW, lblNewPW, lblIdenPW, baoloi;
    private JPasswordField ipPass1, ipPass2, ipPass3;
    private JButton btn1, btn2;
    private JPanel pn1, pn2, pn3;

    public DoiMKFRM() {
        initComponents();
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
    }

    private void initComponents() {
        this.setTitle("DOI MAT KHAU");
        this.setLayout(new BorderLayout());
        this.setSize(450, 350);

        lblPWChange = new JLabel();
        lblRecentPW = new JLabel();
        lblNewPW = new JLabel();
        ipPass1 = new JPasswordField();
        ipPass2 = new JPasswordField();
        lblIdenPW = new JLabel();
        ipPass3 = new JPasswordField();
        btn1 = new JButton();
        btn2 = new JButton();
        baoloi = new JLabel();

        lblPWChange.setText("Đổi Mật Khẩu");
        lblRecentPW.setText("Mật khẩu hiện tại");
        lblNewPW.setText("Mật khẩu mới");
        lblIdenPW.setText("Xác thực mật khẩu");
        btn1.setText("Lưu");
        btn2.setText("Hủy");

        lblPWChange.setFont(lblPWChange.getFont().deriveFont(16f));
        lblPWChange.setForeground(new Color(75, 0, 130));
        lblPWChange.setHorizontalAlignment(JLabel.CENTER);
        baoloi.setForeground(new Color(220, 20, 60));
        baoloi.setHorizontalAlignment(JLabel.CENTER);


        btn1.setBackground(new Color(168, 85, 247));
        btn1.setForeground(Color.WHITE);
        btn1.setFocusPainted(false);
        btn1.setFont(btn1.getFont().deriveFont(13f));

        btn2.setBackground(new Color(192, 132, 252));
        btn2.setForeground(Color.WHITE);
        btn2.setFocusPainted(false);
        btn2.setFont(btn2.getFont().deriveFont(13f));

        btn1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (ipPass1.getText().equals("") || ipPass2.getText().equals("") || ipPass3.getText().equals("")) {
                    baoloi.setText("Vui lòng nhập đầy đủ thông tin.");
                } else if (ipPass1.getText().equals(controller.Controller.tk.getMatKhau()) == false) {
                    baoloi.setText(" Mật khẩu hiện tại không chính xác.");
                } else if (ipPass2.getText().equals(ipPass3.getText()) == false) {
                    baoloi.setText("Xác thực mật khẩu không chính xác.");
                } else {

                    int confirmed = JOptionPane.showConfirmDialog(null, "Xác Nhận Đổi Mật Khẩu?", "Xác nhận",
                            JOptionPane.YES_NO_OPTION);

                    if (confirmed == JOptionPane.YES_OPTION) {
                        connection.UpdateData.doiMatKhau(controller.Controller.tk, ipPass2.getText());
                        new SuaThongTinFRM().setVisible(true);
                        dispose();
                    }
                }

            }

        });
        btn2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new SuaThongTinFRM().setVisible(true);
                dispose();
            }

        });

        pn1 = new JPanel();
        pn1.add(lblPWChange);
        add(pn1, BorderLayout.NORTH);

        GridLayout gl = new GridLayout(4, 2);
        gl.setHgap(10);
        gl.setVgap(10);
        pn2 = new JPanel(gl);

        pn2.add(lblRecentPW);
        pn2.add(ipPass1);
        pn2.add(lblNewPW);
        pn2.add(ipPass2);
        pn2.add(lblIdenPW);
        pn2.add(ipPass3);
        pn2.add(baoloi);

        add(pn2, BorderLayout.CENTER);

        pn3 = new JPanel();
        pn3.add(btn1);
        pn3.add(btn2);
        add(pn3, BorderLayout.SOUTH);


        Color bgMain = new Color(250, 245, 255);
        Color panelBg = Color.WHITE;
        Color accentColor = new Color(168, 85, 247);

        this.getContentPane().setBackground(bgMain);

        pn1.setBackground(new Color(249, 245, 255));
        pn1.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(233, 213, 255), 1),
                BorderFactory.createEmptyBorder(20, 20, 20, 20)));
        lblPWChange.setForeground(new Color(126, 34, 206));

        pn2.setBackground(panelBg);
        pn2.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(233, 213, 255), 1),
                BorderFactory.createEmptyBorder(25, 30, 25, 30)));

        lblRecentPW.setForeground(new Color(55, 65, 81));
        lblNewPW.setForeground(new Color(55, 65, 81));
        lblIdenPW.setForeground(new Color(55, 65, 81));

        pn3.setBackground(new Color(249, 245, 255));
        pn3.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createMatteBorder(1, 0, 0, 0, new Color(233, 213, 255)),
                BorderFactory.createEmptyBorder(15, 20, 15, 20)));
        // pack();
    }

    public static void main(String[] args) {
        new DoiMKFRM().setVisible(true);
    }
}
