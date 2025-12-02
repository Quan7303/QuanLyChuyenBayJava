/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import connection.LoadData;
import static controller.Controller.arrayListMayBay;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;
import model.ChuyenBay;
import model.MayBay;

/**
 *
 * @author KHOA
 */
public class MayBayFRM extends JFrame {

    private JButton btn5, btnADD, btnCann, btnDel, btnEdit, btnSave;
    private JScrollPane jScrollPane1;
    private JLabel lbl1, baoLoi, lbl2, lbl3, lbl4;
    private JTable jTable1;
    private JTextField txtHangMB, txtSHMB, txtSoGhe;
    private JPanel pnB, pnB1, pnT, pnT1, pnT11, pnT12, pnT13;
    private DefaultTableModel model;

    private void setButtonIcon(JButton button, String path, int width, int height) {
        ImageIcon icon = new ImageIcon(getClass().getResource(path));
        Image img = icon.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);
        button.setIcon(new ImageIcon(img));
    }

    public MayBayFRM() {
        initComponents();
        model = (DefaultTableModel) jTable1.getModel();
        showData();
        jTable1.setDefaultEditor(Object.class, null);
        jTable1.setSelectionBackground(Color.RED);
        jTable1.setSelectionMode(0);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
    }

    private void showData() {
        new LoadData();
        model.setRowCount(0);
        for (MayBay mb : controller.Controller.arrayListMayBay) {
            model.addRow(new Object[]{mb.getSHMB(), mb.getHangBay(), mb.getSoGhe()});
        }
    }

    private void initComponents() {
        setTitle("QUẢN LÝ MÁY BAY");
        // setLocation(new java.awt.Point(0, 0));
        // setResizable(false);
        // setSize(new java.awt.Dimension(723, 352));

        this.setLayout(new BorderLayout());
        lbl1 = new JLabel();
        btnADD = new JButton();
        btnEdit = new JButton();
        btnDel = new JButton();
        btnSave = new JButton();
        btnCann = new JButton();
        lbl2 = new JLabel();
        lbl3 = new JLabel();
        lbl4 = new JLabel();
        txtSHMB = new JTextField();
        txtHangMB = new JTextField();
        txtSoGhe = new JTextField();
        btn5 = new JButton();
        jScrollPane1 = new JScrollPane();
        jTable1 = new JTable();
        baoLoi = new JLabel();

        btnADD.setBackground(new Color(76, 175, 80));
        btnEdit.setBackground(new Color(33, 150, 243));
        btnDel.setBackground(new Color(244, 67, 54));
        btnSave.setBackground(new Color(33, 150, 243));
        btnCann.setBackground(new Color(244, 67, 54));

        setButtonIcon(btn5, "/images/back.png", 20, 20);
        setButtonIcon(btnDel, "/images/nut_xoa.png", 20, 20);
        setButtonIcon(btnADD, "/images/nut_them.png", 20, 20);
        setButtonIcon(btnEdit, "/images/nut_sua.png", 20, 20);

        lbl1.setText("Danh sách Máy Bay");
        lbl1.setHorizontalAlignment(JLabel.CENTER);
        btnADD.setText("Thêm");
        btnEdit.setText("Sửa");
        btnDel.setText("Xóa");
        btnSave.setText("Lưu");
        btnCann.setText("Hủy");
        lbl2.setText("Số hiệu máy bay");
        lbl3.setText("Hãng máy bay");
        lbl4.setText("Số ghế");
        jTable1.setModel(new DefaultTableModel(
                new Object[][]{},
                new String[]{
                    "SHMB", "Hãng Bay", "Số Ghế"
                }));
        jTable1.setRowHeight(30);
        jScrollPane1.setViewportView(jTable1);
        baoLoi.setForeground(new Color(255, 0, 0));
        baoLoi.setHorizontalAlignment(JLabel.CENTER);
        txtSHMB.setEnabled(false);
        txtHangMB.setEnabled(false);
        txtSoGhe.setEnabled(false);
        btnSave.setEnabled(false);
        btnCann.setEnabled(false);
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                baoLoi.setText("");
            }
        });
        jTable1.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                baoLoi.setText("");
                int row = jTable1.getSelectedRow();
                txtSHMB.setText((String) jTable1.getValueAt(row, 0));
                txtHangMB.setText((String) jTable1.getValueAt(row, 1));
                txtSoGhe.setText(String.valueOf(jTable1.getValueAt(row, 2)));
            }
        });
        txtSHMB.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                baoLoi.setText("");
            }
        });
        txtHangMB.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                baoLoi.setText("");
            }
        });
        txtSoGhe.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                baoLoi.setText("");
            }
        });
        btnADD.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                baoLoi.setText("");
                jTable1.setEnabled(false);
                jTable1.clearSelection();
                txtSHMB.setText("");
                txtHangMB.setText("");
                txtSoGhe.setText("");
                txtSHMB.setEnabled(true);
                txtHangMB.setEnabled(true);
                txtSoGhe.setEnabled(true);
                btnEdit.setEnabled(false);
                btnDel.setEnabled(false);
                btnSave.setEnabled(true);
                btnCann.setEnabled(true);
            }

        });
        btnEdit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                baoLoi.setText("");
                if (jTable1.getSelectedRow() == -1) {
                    baoLoi.setText("Vui lòng chọn máy bay");
                    return;
                } else {
                    for (ChuyenBay cb : controller.Controller.arrayListChuyenBay) {
                        if (cb.getSHMB().equals(txtSHMB.getText())) {
                            baoLoi.setText("Không được Sửa Máy Bay Này");
                            return;
                        }
                    }
                    txtSoGhe.setEnabled(true);
                    btnADD.setEnabled(false);
                    btnDel.setEnabled(false);
                    btnSave.setEnabled(true);
                    btnCann.setEnabled(true);
                    jTable1.setEnabled(false);

                }
            }

        });
        btnDel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                baoLoi.setText("");
                if (jTable1.getSelectedRow() == -1) {
                    baoLoi.setText("Vui lòng chọn máy bay");
                    return;
                } else {
                    for (ChuyenBay cb : controller.Controller.arrayListChuyenBay) {
                        if (cb.getSHMB().equals(txtSHMB.getText())) {
                            baoLoi.setText("Không được Sửa Máy Bay Này");
                            return;
                        }
                    }
                }
                int cf = JOptionPane.showConfirmDialog(null, "Xác Nhận Xóa Sân Bay?", "Xác nhận",
                        JOptionPane.YES_NO_OPTION);
                if (cf == JOptionPane.YES_OPTION) {
                    connection.DeleteData.deleteMayBay((String) jTable1.getValueAt(jTable1.getSelectedRow(), 0));
                    showData();
                }
            }

        });
        btnCann.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                baoLoi.setText("");
//                txtSHMB.setText("");
//                txtHangMB.setText("");
//                txtSoGhe.setText("");
                jTable1.setEnabled(true);
                txtSHMB.setEnabled(false);
                txtHangMB.setEnabled(false);
                txtSoGhe.setEnabled(false);
                btnADD.setEnabled(true);
                btnEdit.setEnabled(true);
                btnDel.setEnabled(true);
                btnSave.setEnabled(false);
                btnCann.setEnabled(false);
            }

        });
        btnSave.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                baoLoi.setText("");

                for (int i = 0; i < txtSoGhe.getText().length(); i++) {
                    if (Character.isDigit(txtSoGhe.getText().charAt(i))) {
                        continue;
                    } else {
                        baoLoi.setText("thông tin máy bay không hợp lệ!");
                        return;
                    }

                }
                
                txtSHMB.setText(txtSHMB.getText().toUpperCase());
                if (txtSHMB.getText().equals("") || txtHangMB.getText().equals("") || txtSoGhe.getText().equals("")) {
                    baoLoi.setText("Vui lòng nhập đầy đủ thông tin đường bay!");
                } else {
                    MayBay mb = new MayBay(txtSHMB.getText(), txtHangMB.getText(),
                            Integer.parseInt(txtSoGhe.getText()));
                    if (jTable1.getSelectedRow() == -1) {
                        for (MayBay mbb : arrayListMayBay) {
                            if (mbb.getSHMB().equals(txtSHMB.getText())) {
                                baoLoi.setText("Máy bay đã tồn tại!");
                                return;
                            }
                        }
                        connection.InsertData.insertMayBay(mb);
                        // model.addRow(new Object[]{mb.getSHMB(), mb.getHangBay(), mb.getSoGhe()});
                        showData();
                        txtSHMB.setEnabled(false);
                        txtHangMB.setEnabled(false);
                        txtSoGhe.setEnabled(false);
                        btnSave.setEnabled(false);
                        btnCann.setEnabled(false);
                        btnADD.setEnabled(true);
                        btnEdit.setEnabled(true);
                        btnDel.setEnabled(true);
                        jTable1.setEnabled(true);
                        jTable1.getSelectionModel().setSelectionInterval(jTable1.getRowCount() - 1, jTable1.getRowCount() - 1);
                    } else {
                        int row = jTable1.getSelectedRow();
                        connection.UpdateData.updateMayBay(mb);
                        showData();
                        txtSHMB.setEnabled(false);
                        txtHangMB.setEnabled(false);
                        txtSoGhe.setEnabled(false);
                        btnADD.setEnabled(true);
                        btnDel.setEnabled(true);
                        btnSave.setEnabled(false);
                        btnCann.setEnabled(false);
                        jTable1.setEnabled(true);
                        jTable1.getSelectionModel().setSelectionInterval(row, row);
                    }

                }
            }

        });
        pnB = new JPanel(new GridLayout(2, 1));
        pnB.setBackground(new Color(255, 253, 208));
        pnB1 = new JPanel(new BorderLayout());
        pnB1.setBackground(new Color(255, 253, 208));
        pnB1.add(btn5, BorderLayout.WEST);
        pnB.add(pnB1);
        pnB.add(lbl1);

        pnT = new JPanel(new GridLayout(1, 2));
        pnT.setBackground(new Color(248, 187, 208));
        pnT.add(jScrollPane1);

        pnT1 = new JPanel(new GridLayout(3, 1));
        pnT1.setBackground(new Color(248, 187, 208));
        pnT11 = new JPanel();
        pnT11.setBackground(new Color(248, 187, 208));
        pnT11.add(btnADD);
        pnT11.add(btnEdit);
        pnT11.add(btnDel);

        pnT12 = new JPanel(new GridLayout(4, 2));
        pnT12.setBackground(new Color(248, 187, 208));
        pnT12.add(lbl2);
        pnT12.add(txtSHMB);
        pnT12.add(lbl3);
        pnT12.add(txtHangMB);
        pnT12.add(lbl4);
        pnT12.add(txtSoGhe);
        pnT12.add(baoLoi);

        pnT13 = new JPanel();
        pnT13.setBackground(new Color(248, 187, 208));
        pnT13.add(btnSave);
        pnT13.add(btnCann);

        pnT1.add(pnT11);
        pnT1.add(pnT12);
        pnT1.add(pnT13);

        pnT.add(pnT1);

        add(pnB, BorderLayout.NORTH);
        add(pnT, BorderLayout.CENTER);
        btn5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new QuanLyFRM().setVisible(true);
                dispose();
            }

        });
        pack();
    }

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (Exception e) {
            System.out.println("Không thể dùng Nimbus, dùng giao diện mặc định!");
        }
        SwingUtilities.invokeLater(() -> new MayBayFRM().setVisible(true));
    }

}
