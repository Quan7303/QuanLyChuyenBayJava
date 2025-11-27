/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import static controller.Controller.arrayListTaiKhoan;
import static controller.Controller.tk;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.text.SimpleDateFormat;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import model.ChuyenBay;
import model.TaiKhoan;

/**
 *
 * @author LENOVO
 */
public class ChonChuyenBayFRM extends JFrame {

    private JButton btnBack;
    private JLabel lblTitle;
    private JScrollPane jScrollPane3;
    private JTable tbl;
    private JPanel pn;
    private DefaultTableModel model;

    public ChonChuyenBayFRM() {
        initComponents();
        model = (DefaultTableModel) tbl.getModel();
        showData();
        System.out.println(controller.Controller.tk.getLoaiTaiKhoan());
        tbl.setDefaultEditor(Object.class, null);
        tbl.setSelectionBackground(new Color(173, 216, 230));
        tbl.setSelectionMode(0);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
    }

    private void showData() {
        for (ChuyenBay cb : controller.Controller.arrayListTimChuyenBay) {
            model.addRow(new Object[] {
                    cb.getMaChuyenBay(), cb.getSHMB(),
                    cb.getDuongBay().getTenSanBayDi() + " - " + cb.getDuongBay().getTenSanBayDen(),
                    new SimpleDateFormat("dd/MM/yyyy").format(cb.getNgayBay()) + " | " + cb.getGioBay() });
        }
    }

    private void initComponents() {
        setTitle("CHỌN CHUYẾN BAY");
        setSize(900, 600);
        setLayout(new BorderLayout());
        getContentPane().setBackground(new Color(245, 247, 250));
        btnBack = new JButton();
        lblTitle = new JLabel();
        jScrollPane3 = new JScrollPane();
        tbl = new JTable();

        tbl.setModel(new DefaultTableModel(
                new Object[][] {},
                new String[] {
                        "Mã Chuyến Bay", "Máy Bay", "Đường Bay", "Thời Gian"
                }));


        tbl.setRowHeight(40);
        tbl.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        tbl.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 14));
        tbl.getTableHeader().setBackground(new Color(0, 120, 215));
        tbl.getTableHeader().setForeground(Color.WHITE);
        tbl.getTableHeader().setPreferredSize(new Dimension(0, 45));
        tbl.setSelectionBackground(new Color(173, 216, 230));
        tbl.setSelectionForeground(new Color(51, 51, 51));
        tbl.setGridColor(new Color(230, 230, 230));
        tbl.setShowGrid(true);
        tbl.setBackground(Color.WHITE);

        jScrollPane3.setViewportView(tbl);
        jScrollPane3.setBorder(javax.swing.BorderFactory.createCompoundBorder(
                javax.swing.BorderFactory.createLineBorder(new Color(230, 230, 230), 1),
                javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10)));
        jScrollPane3.setBackground(Color.WHITE);

        lblTitle.setText("CHỌN CHUYẾN BAY");
        lblTitle.setHorizontalAlignment(JLabel.CENTER);
        lblTitle.setFont(new Font("Segoe UI", Font.BOLD, 18));
        lblTitle.setForeground(new Color(51, 51, 51));

        btnBack.setIcon(new ImageIcon(getClass().getResource("/images/back.png")));
        btnBack.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        pn = new JPanel(new BorderLayout());
        pn.setBackground(new Color(245, 247, 250));
        pn.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10));
        pn.add(btnBack, BorderLayout.WEST);
        pn.add(lblTitle, BorderLayout.CENTER);
        add(pn, BorderLayout.NORTH);

        JPanel centerPanel = new JPanel(new BorderLayout());
        centerPanel.setBackground(new Color(245, 247, 250));
        centerPanel.setBorder(javax.swing.BorderFactory.createEmptyBorder(15, 15, 15, 15));
        centerPanel.add(jScrollPane3, BorderLayout.CENTER);
        add(centerPanel, BorderLayout.CENTER);

        tbl.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent e) {
                if (tbl.getSelectedRow() >= 0) {
                    controller.Controller.cb = controller.Controller.arrayListTimChuyenBay.get(tbl.getSelectedRow());
                    new DSVeFRM().setVisible(true);
                    dispose();
                }
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
                new TimChuyenBayFRM().setVisible(true);
                dispose();
            }

        });

        //pack();
    }

    public static void main(String[] args) {
        new ChonChuyenBayFRM().setVisible(true);
    }
}
