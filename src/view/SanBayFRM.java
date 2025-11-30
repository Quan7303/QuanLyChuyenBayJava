/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import connection.LoadData;
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
import model.DuongBay;
import model.SanBay;

/**
 *
 * @author KHOA
 */
public class SanBayFRM extends JFrame {

    private JButton back, btnADD, btnCann, btnDel, btnEdit, btnSave;
    private JScrollPane jScrollPane1;
    private JLabel lbl1, baoLoi, lbl2, lbl3, lbl4;
    private JTable jTable1;
    private JTextField txtDiaDiem, txtMaSB, txtName;
    private JPanel pnB, pnB1, pnT, pnT1, pnT11, pnT12, pnT13;
    private DefaultTableModel model;

    private void setButtonIcon(JButton button, String path, int width, int height) {
        ImageIcon icon = new ImageIcon(getClass().getResource(path));
        Image img = icon.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);
        button.setIcon(new ImageIcon(img));
    }

    public SanBayFRM() {
        initComponents();
        model = (DefaultTableModel) jTable1.getModel();
        showData();
        jTable1.setDefaultEditor(Object.class, null);
        jTable1.setSelectionBackground(Color.BLUE);
        jTable1.setSelectionMode(0);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
    }

    private void showData() {
        new LoadData();
        model.setRowCount(0);
        for (SanBay sb : controller.Controller.arrayListSanBay) {
            model.addRow(new Object[]{sb.getMaSanBay(), sb.getTenSanBay(), sb.getDiaDiem()});
        }
    }

    private void initComponents() {
        setTitle("QUẢN LÝ SÂN BAY");
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
        txtDiaDiem = new JTextField();
        txtMaSB = new JTextField();
        txtName = new JTextField();
        back = new JButton();
        jScrollPane1 = new JScrollPane();
        jTable1 = new JTable();
        baoLoi = new javax.swing.JLabel();

        btnADD.setText("Thêm");
        btnEdit.setText("Sửa");
        btnDel.setText("Xóa");
        btnSave.setText("Lưu");
        btnCann.setText("Hủy");
        lbl2.setText("Mã Sân Bay");
        lbl3.setText("Tên Sân Bay");
        lbl4.setText("Địa Điểm");
        baoLoi.setForeground(new Color(255, 0, 0));
        lbl1.setText("Danh Sách Sân Bay");
        lbl1.setHorizontalAlignment(JLabel.CENTER);
        baoLoi.setHorizontalAlignment(JLabel.CENTER);

        btnADD.setBackground(new Color(76, 175, 80));
        btnEdit.setBackground(new Color(33, 150, 243));
        btnDel.setBackground(new Color(244, 67, 54));
        btnSave.setBackground(new Color(33, 150, 243));
        btnCann.setBackground(new Color(244, 67, 54));

        setButtonIcon(back, "/images/back.png", 20, 20);
        setButtonIcon(btnDel, "/images/nut_xoa.png", 20, 20);
        setButtonIcon(btnADD, "/images/nut_them.png", 20, 20);
        setButtonIcon(btnEdit, "/images/nut_sua.png", 20, 20);

        jTable1.setModel(new DefaultTableModel(
                new Object[][]{},
                new String[]{
                    "Mã Sân Bay", "Tên Sân Bay", "Địa Điểm"
                }));

        jTable1.setRowHeight(30);
        jScrollPane1.setViewportView(jTable1);
        txtMaSB.setEnabled(false);
        txtName.setEnabled(false);
        txtDiaDiem.setEnabled(false);
        btnSave.setEnabled(false);
        btnCann.setEnabled(false);

        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new QuanLyFRM().setVisible(true);
                dispose();
            }

        });
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
                txtMaSB.setText((String) jTable1.getValueAt(row, 0));
                txtName.setText((String) jTable1.getValueAt(row, 1));
                txtDiaDiem.setText((String) jTable1.getValueAt(row, 2));
            }
        });
        btnADD.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                baoLoi.setText("");
                jTable1.setEnabled(false);
                jTable1.clearSelection();
                txtMaSB.setText("");
                txtName.setText("");
                txtDiaDiem.setText("");
                txtMaSB.setEnabled(true);
                txtName.setEnabled(true);
                txtDiaDiem.setEnabled(true);
                btnSave.setEnabled(true);
                btnCann.setEnabled(true);
                btnEdit.setEnabled(false);
                btnDel.setEnabled(false);
            }
        });
        btnEdit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                baoLoi.setText("");
                int row = jTable1.getSelectedRow();
                if (row == -1) {
                    baoLoi.setText("Vui lòng chọn sân bay");
                    return;
                } else {
                    jTable1.setEnabled(false);
                    txtName.setEnabled(true);
                    txtDiaDiem.setEnabled(true);
                    btnSave.setEnabled(true);
                    btnCann.setEnabled(true);
                    btnADD.setEnabled(false);
                    btnDel.setEnabled(false);
                }
                baoLoi.setText("");

            }

        });
        btnDel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (jTable1.getSelectedRow() == -1) {
                    baoLoi.setText("Vui lòng chọn sân bay");
                    return;
                }
                for (DuongBay db : controller.Controller.arrayListDuongBay) {
                    if (db.getMaSanBayDi().equals(txtMaSB.getText()) || db.getMasanBayDen().equals(txtMaSB.getText())) {
                        baoLoi.setText("Không Thể Xóa Sân Bay Này");
                        return;
                    }
                }
                int cf = JOptionPane.showConfirmDialog(null, "Xác Nhận Xóa Sân Bay?", "Xác nhận",
                        JOptionPane.YES_NO_OPTION);
                if (cf == JOptionPane.YES_OPTION) {
                    connection.DeleteData.deleteSanBay((String) jTable1.getValueAt(jTable1.getSelectedRow(), 0));
                    showData();
                    txtMaSB.setText("");
                    txtName.setText("");
                    txtDiaDiem.setText("");
                }
            }

        });
        btnCann.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                baoLoi.setText("");
                jTable1.setEnabled(true);
                txtMaSB.setEnabled(false);
                txtName.setEnabled(false);
                txtDiaDiem.setEnabled(false);
                btnSave.setEnabled(false);
                btnCann.setEnabled(false);
                btnEdit.setEnabled(true);
                btnDel.setEnabled(true);
                btnADD.setEnabled(true);
            }

        });
        txtMaSB.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                baoLoi.setText("");
            }
        });
        txtName.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                baoLoi.setText("");
            }
        });
        txtDiaDiem.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                baoLoi.setText("");
            }
        });
        btnSave.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int row = jTable1.getSelectedRow();
                if (txtMaSB.getText().equals("") || txtName.getText().equals("") || txtDiaDiem.getText().equals("")) {
                    baoLoi.setText("Thông tin không được để trống");
                    return;
                }
                if (txtMaSB.getText().length() != 3) {
                    baoLoi.setText("Mã Sân Bay Không Hợp Lệ");
                    return;
                }
                txtMaSB.setText(txtMaSB.getText().toUpperCase());

                SanBay sb = new SanBay(txtMaSB.getText(), txtName.getText(), txtDiaDiem.getText());
                if (row == -1) {
                    for (SanBay sbb : controller.Controller.arrayListSanBay) {
                        if (sbb.getMaSanBay().equals(txtMaSB.getText())) {
                            baoLoi.setText("Mã Sân Bay Không Hợp Lệ");
                            return;
                        }
                    }
                    connection.InsertData.insertSanBay(sb);
                    showData();

                    baoLoi.setText("");
                    txtMaSB.setEnabled(false);
                    txtName.setEnabled(false);
                    txtDiaDiem.setEnabled(false);
                    jTable1.setEnabled(true);
                    btnSave.setEnabled(false);
                    btnCann.setEnabled(false);
                    btnEdit.setEnabled(true);
                    btnDel.setEnabled(true);
                    btnADD.setEnabled(true);
                    jTable1.getSelectionModel().setSelectionInterval(jTable1.getRowCount() - 1,
                            jTable1.getRowCount() - 1);
                } else {
                    connection.UpdateData.updateSanBay(sb);
                    showData();
                    baoLoi.setText("");
                    txtName.setEnabled(false);
                    txtDiaDiem.setEnabled(false);
                    jTable1.setEnabled(true);
                    btnSave.setEnabled(false);
                    btnCann.setEnabled(false);
                    btnEdit.setEnabled(true);
                    btnDel.setEnabled(true);
                    btnADD.setEnabled(true);
                    jTable1.getSelectionModel().setSelectionInterval(row, row);
                }
            }

        });

        pnB = new JPanel(new GridLayout(2, 1));
        pnB.setBackground(new Color(255, 253, 208));
        pnB1 = new JPanel(new BorderLayout());
        pnB1.setBackground(new Color(255, 253, 208));
        pnB1.add(back, BorderLayout.WEST);
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

        pnT12 = new JPanel(new GridLayout(4, 2, 10, 10));
        pnT12.setBackground(new Color(248, 187, 208));
        pnT12.add(lbl2);
        pnT12.add(txtMaSB);
        pnT12.add(lbl3);
        pnT12.add(txtName);
        pnT12.add(lbl4);
        pnT12.add(txtDiaDiem);
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

        pack();
    }

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (Exception e) {
            System.out.println("Không thể dùng Nimbus, dùng giao diện mặc định!");
        }
        SwingUtilities.invokeLater(() -> new SanBayFRM().setVisible(true));
    }

}
