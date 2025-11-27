/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import static controller.Controller.tk;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import model.KhachHang;

/**
 *
 * @author LENOVO
 */
public class SuaThongTinFRM extends JFrame {

    private JLabel baoloi, baoloiSDT, baoloimail, baoloiname, baoloins;
    private com.toedter.calendar.JDateChooser ipbDate;
    private JTextField ipEmail, ipSDT, ifname, txt;
    private JButton btnSave, btn2;
    private JLabel lblInfoFix, lblFname, lblSDT, lblbDate, lblEmail, lblLogName, lblLinkPWFix;
    private JPanel pnB, pnB1, pnT, pnN, pnN1, pnN2;

    public SuaThongTinFRM() {
        initComponents();

        new connection.LoadData();

        KhachHang kh = null;
        for (KhachHang khh : controller.Controller.arrayListKhachHang) {
            if (khh.getTenDangNhap().equals(tk.getTenDangNhap())) {
                kh = khh;
                break;
            }
        }

        if (kh == null) {
            JOptionPane.showMessageDialog(this, "Không tìm thấy thông tin khách hàng!");
            new TimChuyenBayFRM().setVisible(true);
            dispose();
            return;
        }

        ifname.setText(kh.getTenKhachHang());
        if (kh.getNgaySinh() != null) {
            ipbDate.setDate(kh.getNgaySinh());
        }
        ipSDT.setText(kh.getSDT());
        ipEmail.setText(kh.getEmail());
        txt.setText(kh.getTenDangNhap());
        ipSDT.setEnabled(false);
        txt.setEnabled(false);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
    }

    private void initComponents() {
        this.setTitle("SUA THONG TIN");
        this.setLayout(new BorderLayout());
        this.setSize(500, 490);
        lblInfoFix = new JLabel();
        lblFname = new JLabel();
        ifname = new JTextField();
        ipbDate = new com.toedter.calendar.JDateChooser();
        lblbDate = new JLabel();
        lblSDT = new JLabel();
        ipSDT = new JTextField();
        lblEmail = new JLabel();
        ipEmail = new JTextField();
        lblLogName = new JLabel();
        txt = new JTextField();

        btnSave = new JButton();
        baoloiname = new JLabel();
        baoloiSDT = new JLabel();
        baoloimail = new JLabel();
        lblLinkPWFix = new JLabel();
        btn2 = new JButton();
        baoloins = new JLabel();
        baoloi = new JLabel();

        baoloiname.setForeground(new Color(220, 20, 60));
        baoloins.setForeground(new Color(220, 20, 60));
        baoloiSDT.setForeground(new Color(220, 20, 60));
        baoloimail.setForeground(new Color(220, 20, 60));
        baoloi.setForeground(new Color(220, 20, 60));

        btnSave.setBackground(new Color(14, 165, 233));
        btnSave.setForeground(Color.WHITE);
        btnSave.setFocusPainted(false);
        btnSave.setFont(btnSave.getFont().deriveFont(13f));

        lblInfoFix.setFont(lblInfoFix.getFont().deriveFont(16f));
        lblInfoFix.setForeground(new Color(0, 100, 150));
        lblLinkPWFix.setForeground(new Color(0, 100, 150));

        lblInfoFix.setText("Sửa Thông Tin");
        lblInfoFix.setHorizontalAlignment(JLabel.CENTER);
        lblFname.setText("Họ Và Tên");
        lblFname.setHorizontalAlignment(JLabel.CENTER);
        lblbDate.setText("Ngày Sinh");
        lblbDate.setHorizontalAlignment(JLabel.CENTER);
        ipbDate.setDateFormatString("dd/MM/yyyy");
        lblSDT.setText("SDT");
        lblSDT.setHorizontalAlignment(JLabel.CENTER);
        lblEmail.setText("Email");
        lblEmail.setHorizontalAlignment(JLabel.CENTER);
        lblLogName.setText("Tên Đăng Nhập");
        lblLogName.setHorizontalAlignment(JLabel.CENTER);
        btnSave.setText("Lưu Thông Tin");
        lblLinkPWFix.setText("<HTML><u>Sửa Mật Khẩu</u></HTML>");

        btn2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new TimChuyenBayFRM().setVisible(true);
                dispose();
            }

        });
        lblLinkPWFix.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                new DoiMKFRM().setVisible(true);
                dispose();
            }
        });
        btnSave.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String str = ipSDT.getText();
                KhachHang kh = new KhachHang(ipSDT.getText(), txt.getText(), ifname.getText(), ipEmail.getText(),
                        new java.sql.Date(ipbDate.getDate().getTime()));
                int a = 0;
                if (ifname.getText().length() == 0) {
                    baoloiname.setText("Họ Tên không được để trống");
                    a++;
                }
                if (ipbDate.getDate().equals("") == true) {
                    baoloins.setText("Ngày Sinh không được để trống");
                    a++;
                }
                if (ipEmail.getText().length() == 0) {
                    baoloimail.setText("Email không hợp lệ");
                    a++;
                }
                System.out.println(kh.getTenKhachHang());
                if (a == 0) {
                    connection.UpdateData.updateKhachHang(kh);
                    new TimChuyenBayFRM().setVisible(true);
                    dispose();
                    baoloi.setText("Sửa thông tin thành công");
                }
            }

        });
        ifname.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                baoloiname.setText("");
            }
        });
        ipSDT.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                baoloiSDT.setText("");
            }
        });
        ipEmail.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                baoloimail.setText("");
            }
        });
        pnB = new JPanel(new GridLayout(2, 1));

        pnB1 = new JPanel(new BorderLayout());
        pnB1.add(btn2, BorderLayout.WEST);
        btn2.setIcon(new ImageIcon(getClass().getResource("/images/back.png")));

        pnB.add(pnB1);
        pnB.add(lblInfoFix);
        
        Color bgMain = new Color(240, 253, 255);
        Color panelBg = Color.WHITE;
        Color accentColor = new Color(14, 165, 233);

        this.getContentPane().setBackground(bgMain);

        Color headerColor = new Color(248, 250, 252);
        pnB.setBackground(headerColor);
        pnB.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(226, 232, 240), 1),
                BorderFactory.createEmptyBorder(15, 15, 15, 15)));
        pnB1.setBackground(headerColor);
        lblInfoFix.setForeground(new Color(2, 132, 199));
        add(pnB, BorderLayout.NORTH);

        pnT = new JPanel(new GridLayout(5, 2, 10, 10));

        pnT.add(lblFname);
        JPanel pnName = new JPanel(new BorderLayout());
        pnName.add(ifname, BorderLayout.CENTER);
        pnName.add(baoloiname, BorderLayout.SOUTH);
        pnT.add(pnName);

        pnT.add(lblbDate);
        JPanel pnDate = new JPanel(new BorderLayout());
        pnDate.add(ipbDate, BorderLayout.CENTER);
        pnDate.add(baoloins, BorderLayout.SOUTH);
        pnT.add(pnDate);

        pnT.add(lblSDT);
        JPanel pnSDT = new JPanel(new BorderLayout());
        pnSDT.add(ipSDT, BorderLayout.CENTER);
        pnSDT.add(baoloiSDT, BorderLayout.SOUTH);
        pnT.add(pnSDT);

        pnT.add(lblEmail);
        JPanel pnEmail = new JPanel(new BorderLayout());
        pnEmail.add(ipEmail, BorderLayout.CENTER);
        pnEmail.add(baoloimail, BorderLayout.SOUTH);
        pnT.add(pnEmail);

        pnT.add(lblLogName);
        JPanel pnLogName = new JPanel(new BorderLayout());
        pnLogName.add(txt, BorderLayout.CENTER);
        pnLogName.add(baoloi, BorderLayout.SOUTH);
        pnT.add(pnLogName);

        pnT.setBackground(panelBg);
        pnT.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(226, 232, 240), 1),
                BorderFactory.createEmptyBorder(25, 30, 25, 30)));

        lblFname.setForeground(new Color(55, 65, 81));
        lblbDate.setForeground(new Color(55, 65, 81));
        lblSDT.setForeground(new Color(55, 65, 81));
        lblEmail.setForeground(new Color(55, 65, 81));
        lblLogName.setForeground(new Color(55, 65, 81));

        add(pnT, BorderLayout.CENTER);

        pnN = new JPanel(new GridLayout(2, 1));
        pnN1 = new JPanel();
        pnN1.add(btnSave);
        pnN2 = new JPanel();
        pnN2.add(lblLinkPWFix);

        Color footerColor = new Color(248, 250, 252);
        pnN1.setBackground(footerColor);
        pnN2.setBackground(footerColor);
        pnN.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createMatteBorder(1, 0, 0, 0, new Color(226, 232, 240)),
                BorderFactory.createEmptyBorder(15, 20, 15, 20)));
        lblLinkPWFix.setForeground(accentColor);
        lblLinkPWFix.setFont(lblLinkPWFix.getFont().deriveFont(12f));

        pnN.add(pnN1);
        pnN.add(pnN2);

        add(pnN, BorderLayout.SOUTH);

        // pack();
    }

    public static void main(String[] args) {
        new SuaThongTinFRM().setVisible(true);
    }
}
