/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import com.toedter.calendar.JDateChooser;
import connection.LoadData;
import controller.Controller;
import static controller.Controller.arrayListChuyenBay;
import static controller.Controller.arrayListTaiKhoan;
import static controller.Controller.tk;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSpinner;
import model.ChuyenBay;
import model.TaiKhoan;

/**
 *
 * @author LENOVO
 */
public class TimChuyenBayFRM extends JFrame {

    private JLabel lblBaoLoi;
    private ButtonGroup btnG1;
    private JButton btnTimCB, btnBack;
    private JComboBox<String> cbxSanBayDi, cbxSanBayDen;
    private JDateChooser jDateChooser1, jDateChooser2;
    private JLabel lblDiemKhoiHanh, lblXinChao, lblSuaThongTin, lblDangXuat, lblDiemDen, lblAnhDiemDen, lblAnhDiemKhoiHanh, lblNgayDi, lblNguoiLon, lblTreEm, lbl12Tuoi, lbl11Tuoi, lblNgayVe, lblName;
    private JPanel pnThongTin, pnB, pnB1, pnT, pnN, pnN1, pnN2;
    private JRadioButton rbtnKhuHoi, rbtnMotChieu;
    private JSpinner jSpinner1, jSpinner2;
    private Date datenow;

    public TimChuyenBayFRM() {
        initComponents();
        if (Controller.tk.getLoaiTaiKhoan().equals("guest")) {
            lblName.setText(Controller.tk.getTenDangNhap());
            btnBack.setVisible(false);
        } else {
            pnThongTin.setVisible(false);
            controller.Controller.tk.setLoaiTaiKhoan("guest");
        }
        String date = new SimpleDateFormat("dd/MM/yyyy").format(Calendar.getInstance().getTime());
        try {
            datenow = new SimpleDateFormat("dd/MM/yyyy").parse(date);
        } catch (ParseException ex) {
            Logger.getLogger(TimChuyenBayFRM.class.getName()).log(Level.SEVERE, null, ex);
        }
        jDateChooser1.setDate(datenow);
        jDateChooser2.setDate(datenow);

        new LoadData();
        for (model.SanBay sb : controller.Controller.arrayListSanBay) {
            cbxSanBayDi.addItem(sb.getMaSanBay().trim() + "-" + sb.getTenSanBay());
            cbxSanBayDen.addItem(sb.getMaSanBay().trim() + "-" + sb.getTenSanBay());
        }

        System.out.println(controller.Controller.tk.getLoaiTaiKhoan());
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
    }

    private void initComponents() {

        setTitle("TÌM CHUYẾN BAY");
        setSize(600, 650);
        setLayout(new BorderLayout());
        getContentPane().setBackground(new Color(245, 247, 250));

        btnG1 = new ButtonGroup();
        rbtnKhuHoi = new JRadioButton();
        rbtnMotChieu = new JRadioButton();
        cbxSanBayDi = new JComboBox<>();
        jDateChooser1 = new JDateChooser();
        lblDiemKhoiHanh = new JLabel();
        lblDiemDen = new JLabel();
        cbxSanBayDen = new JComboBox<>();
        jDateChooser2 = new JDateChooser();
        btnTimCB = new JButton();
        lblNguoiLon = new JLabel();
        lblTreEm = new JLabel();
        lbl12Tuoi = new JLabel();
        lbl11Tuoi = new JLabel();
        jSpinner1 = new JSpinner();
        jSpinner2 = new JSpinner();
        lblNgayDi = new JLabel();
        lblNgayVe = new JLabel();
        pnThongTin = new JPanel();
        lblName = new JLabel();
        lblXinChao = new JLabel();
        lblSuaThongTin = new JLabel();
        lblDangXuat = new JLabel();
        lblAnhDiemDen = new JLabel();
        lblAnhDiemKhoiHanh = new JLabel();
        lblBaoLoi = new JLabel();
        btnBack = new JButton();

        btnG1.add(rbtnKhuHoi);
        rbtnKhuHoi.setText("Khứ Hồi");
        rbtnKhuHoi.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        rbtnKhuHoi.setForeground(new Color(51, 51, 51));
        btnG1.add(rbtnMotChieu);
        rbtnMotChieu.setSelected(true);
        rbtnMotChieu.setText("Một Chiều");
        rbtnMotChieu.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        rbtnMotChieu.setForeground(new Color(51, 51, 51));

        Font labelFont = new Font("Segoe UI", Font.BOLD, 13);
        Font titleFont = new Font("Segoe UI", Font.BOLD, 14);

        lblDiemKhoiHanh.setText("Điểm khởi hành");
        lblDiemKhoiHanh.setFont(labelFont);
        lblDiemKhoiHanh.setForeground(new Color(51, 51, 51));
        lblAnhDiemKhoiHanh.setIcon(new ImageIcon(getClass().getResource("/images/icons8_airplane_mode_on_52px.png")));
        lblDiemDen.setText("Điểm đến");
        lblDiemDen.setFont(labelFont);
        lblDiemDen.setForeground(new Color(51, 51, 51));
        lblAnhDiemDen.setIcon(new ImageIcon(getClass().getResource("/images/Ma.png")));

        lblNgayDi.setText("Ngày đi");
        lblNgayDi.setFont(labelFont);
        lblNgayDi.setForeground(new Color(51, 51, 51));
        lblNgayVe.setText("Ngày về");
        lblNgayVe.setFont(labelFont);
        lblNgayVe.setForeground(new Color(51, 51, 51));
        lblNguoiLon.setIcon(new ImageIcon(getClass().getResource("/images/image-removebg-preview.png")));
        lblNguoiLon.setText("Người lớn");
        lblNguoiLon.setFont(labelFont);
        lblNguoiLon.setForeground(new Color(51, 51, 51));
        lblTreEm.setIcon(new ImageIcon(getClass().getResource("/images/image-removebg-preview (1).png")));
        lblTreEm.setText("Trẻ em");
        lblTreEm.setFont(labelFont);
        lblTreEm.setForeground(new Color(51, 51, 51));
        lbl12Tuoi.setText(">= 12 tuổi");
        lbl12Tuoi.setFont(new Font("Segoe UI", Font.PLAIN, 11));
        lbl12Tuoi.setForeground(new Color(128, 128, 128));
        lbl11Tuoi.setText("0-11 tuổi");
        lbl11Tuoi.setFont(new Font("Segoe UI", Font.PLAIN, 11));
        lbl11Tuoi.setForeground(new Color(128, 128, 128));

        btnBack.setIcon(new ImageIcon(getClass().getResource("/images/back.png")));

        jDateChooser1.setToolTipText("csa");
        jDateChooser1.setDateFormatString("dd/MM/yyyy");

        jDateChooser2.setToolTipText("");
        jDateChooser2.setDateFormatString("dd/MM/yyyy");
        jDateChooser2.setEnabled(false);

        jSpinner1.setModel(new javax.swing.SpinnerNumberModel(1, 1, 9, 1));
        jSpinner1.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        jSpinner2.setModel(new javax.swing.SpinnerNumberModel(0, 0, 9, 1));
        jSpinner2.setFont(new Font("Segoe UI", Font.PLAIN, 13));

        cbxSanBayDi.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        cbxSanBayDen.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        cbxSanBayDi.setBackground(Color.WHITE);
        cbxSanBayDen.setBackground(Color.WHITE);

        jDateChooser1.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        jDateChooser2.setFont(new Font("Segoe UI", Font.PLAIN, 13));

        btnTimCB.setBackground(new Color(0, 120, 215));
        btnTimCB.setFont(new Font("Segoe UI", Font.BOLD, 14));
        btnTimCB.setForeground(Color.WHITE);
        btnTimCB.setText("Tìm Chuyến Bay");
        btnTimCB.setPreferredSize(new Dimension(200, 45));
        btnTimCB.setFocusPainted(false);
        btnTimCB.setBorderPainted(false);
        btnTimCB.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        lblName.setText("User");
        lblName.setFont(new Font("Segoe UI", Font.BOLD, 13));
        lblName.setForeground(new Color(0, 120, 215));
        lblXinChao.setText("Xin chào! ");
        lblXinChao.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        lblXinChao.setForeground(new Color(51, 51, 51));
        lblSuaThongTin.setText("<HTML><u>Sửa Thông Tin</u></HTML>");
        lblSuaThongTin.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        lblSuaThongTin.setForeground(new Color(0, 120, 215));
        lblSuaThongTin.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblDangXuat.setForeground(new Color(220, 53, 69));
        lblDangXuat.setText("<HTML><u>Đăng xuất</u></HTML>");
        lblDangXuat.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        lblDangXuat.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        lblBaoLoi.setForeground(new Color(220, 53, 69));
        lblBaoLoi.setFont(new Font("Segoe UI", Font.PLAIN, 12));

        pnB = new JPanel(new GridLayout(1, 2, 100, 10));
        pnB.setBackground(new Color(245, 247, 250));
        pnB.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10));

        pnThongTin.setLayout(new GridLayout(2, 2, 10, 10));
        pnThongTin.setBackground(new Color(245, 247, 250));
        pnThongTin.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 5, 5, 5));
        pnThongTin.add(lblXinChao);
        pnThongTin.add(lblName);
        pnThongTin.add(lblSuaThongTin);
        pnThongTin.add(lblDangXuat);

        pnB1 = new JPanel(new BorderLayout());
        pnB1.setBackground(new Color(245, 247, 250));
        pnB1.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 5, 5, 5));
        pnB1.add(btnBack, BorderLayout.WEST);
        pnB.add(pnB1);
        pnB.add(pnThongTin);
        add(pnB, BorderLayout.NORTH);

        pnT = new JPanel(new GridBagLayout());
        pnT.setBackground(Color.WHITE);
        pnT.setBorder(javax.swing.BorderFactory.createCompoundBorder(
                javax.swing.BorderFactory.createLineBorder(new Color(230, 230, 230), 1),
                javax.swing.BorderFactory.createEmptyBorder(20, 20, 20, 20)));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.BOTH;
        gbc.insets = new Insets(8, 10, 8, 10);
        gbc.weightx = 400;
        gbc.weighty = 430;

        gbc.gridx = 0;
        gbc.gridy = 0;
        pnT.add(rbtnMotChieu, gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        pnT.add(rbtnKhuHoi, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        pnT.add(lblDiemKhoiHanh, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        pnT.add(lblAnhDiemKhoiHanh, gbc);

        gbc.gridx = 1;
        gbc.gridy = 2;
        pnT.add(cbxSanBayDi, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        pnT.add(lblDiemDen, gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        pnT.add(lblAnhDiemDen, gbc);

        gbc.gridx = 1;
        gbc.gridy = 4;
        pnT.add(cbxSanBayDen, gbc);

        gbc.gridx = 0;
        gbc.gridy = 5;
        pnT.add(lblNgayDi, gbc);

        gbc.gridx = 1;
        gbc.gridy = 5;
        pnT.add(lblNgayVe, gbc);

        gbc.gridx = 0;
        gbc.gridy = 6;
        pnT.add(jDateChooser1, gbc);

        gbc.gridx = 1;
        gbc.gridy = 6;
        pnT.add(jDateChooser2, gbc);

        gbc.gridx = 0;
        gbc.gridy = 7;
        pnT.add(lblNguoiLon, gbc);

        gbc.gridx = 1;
        gbc.gridy = 7;
        pnT.add(jSpinner1, gbc);

        gbc.gridx = 0;
        gbc.gridy = 8;
        pnT.add(lbl12Tuoi, gbc);

        gbc.gridx = 0;
        gbc.gridy = 9;
        pnT.add(lblTreEm, gbc);

        gbc.gridx = 1;
        gbc.gridy = 9;
        pnT.add(jSpinner2, gbc);

        gbc.gridx = 0;
        gbc.gridy = 10;
        pnT.add(lbl11Tuoi, gbc);

//        gbc.gridx = 0;
//        gbc.gridy = 11;
//        pnT.add(lblBaoLoi, gbc);
        add(pnT, BorderLayout.CENTER);

        pnN = new JPanel(new GridLayout(2, 1));
        pnN.setBackground(new Color(245, 247, 250));
        pnN.setBorder(javax.swing.BorderFactory.createEmptyBorder(15, 15, 15, 15));
        pnN1 = new JPanel();
        pnN1.add(lblBaoLoi);
        pnN2 = new JPanel();
        pnN2.add(btnTimCB);
        pnN.add(pnN1);
        pnN.add(pnN2);
        add(pnN, BorderLayout.SOUTH);
        //pack();
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                lblBaoLoi.setText("");
            }
        });
        rbtnKhuHoi.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jDateChooser2.setEnabled(true);
                // lblDiemKhoiHanh.setText(jDateChooser1.getDate().toString());
            }

        });
        rbtnMotChieu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jDateChooser2.setEnabled(false);
            }

        });

        lblSuaThongTin.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(java.awt.event.MouseEvent e) {
                new SuaThongTinFRM().setVisible(true);
                dispose();
            }
        });

        btnTimCB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String SanBayDi = cbxSanBayDi.getSelectedItem().toString().substring(0, 3);
                String SanBayDen = cbxSanBayDen.getSelectedItem().toString().substring(0, 3);
                if (SanBayDi.equals(SanBayDen)) {
                    lblBaoLoi.setText("San bay di va den trung nhau");
                    return;
                }
                Date ngayDi = new java.sql.Date(jDateChooser1.getDate().getTime());
                if (ngayDi.before(datenow)) {
                    lblBaoLoi.setText("Ngay di khong hop Le");
                    return;
                }
                String maDuongBayDi = SanBayDi + SanBayDen;
                System.out.println(maDuongBayDi);

                int soGheNguoiLon = (int) (jSpinner1.getValue());
                int soGheTreEm = (int) (jSpinner2.getValue());

                controller.Controller.soLuongVeChon = soGheNguoiLon + soGheTreEm;

                controller.Controller.arrayListTimChuyenBay.removeAll(controller.Controller.arrayListTimChuyenBay);
                for (ChuyenBay cb : arrayListChuyenBay) {
                    if (cb.getTrangThai() == ChuyenBay.CONVE
                            && cb.getDuongBay().getMaDuongBay().equals(maDuongBayDi)
                            && cb.getNgayBay().equals(ngayDi)) {

                        if (cb.getSoGheTrong() < (soGheNguoiLon + soGheTreEm)) {
                            lblBaoLoi.setText("Không đủ ghế");
                        } else {
                            controller.Controller.arrayListTimChuyenBay.add(cb);
                        }
                    }
                }
                if (!controller.Controller.arrayListTimChuyenBay.isEmpty()) {
                    new ChonChuyenBayFRM().setVisible(true);
                    dispose();
                } else {
                    lblBaoLoi.setText("Không có chuyến bay phù hợp!");
                }
            }

        });
        lblDangXuat.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(java.awt.event.MouseEvent e) {
                new DangNhapFRM().setVisible(true);
                dispose();
            }
        });
        btnBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (TaiKhoan taiKhoan : arrayListTaiKhoan) {
                    if (tk.getTenDangNhap().equals(taiKhoan.getTenDangNhap())) {
                        controller.Controller.tk = taiKhoan;
                        break;
                    }
                }
                new QuanLyFRM().setVisible(true);
                dispose();
            }

        });
    }

    public static void main(String[] args) {
        new TimChuyenBayFRM().setVisible(true);
    }
}
