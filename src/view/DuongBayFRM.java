/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import connection.LoadData;
import static controller.Controller.arrayListDuongBay;
import static controller.Controller.arrayListSanBay;
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
import javax.swing.JComboBox;
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
import model.DuongBay;
import model.SanBay;

/**
 *
 * @author KHOA
 */
public class DuongBayFRM extends JFrame {

    private JButton back, btnAdd, btnCanncel, btnDel, btnEdit, btnSave;
    private JLabel baoLoi, lbl1, lbl2, lbl3, lbl4;
    private JComboBox<String> jComboBox1, jComboBox2;
    private JScrollPane jScrollPane1;
    private JTable jTable1;
    private JTextField txt5;
    private JPanel pnB, pnB1, pnT, pnT1, pnT11, pnT12, pnT13;
    private DefaultTableModel model;

    private void setButtonIcon(JButton button, String path, int width, int height) {
        ImageIcon icon = new ImageIcon(getClass().getResource(path));
        Image img = icon.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);
        button.setIcon(new ImageIcon(img));
    }

    public DuongBayFRM() {
        initComponents();
        model = (DefaultTableModel) jTable1.getModel();
        jTable1.setDefaultEditor(Object.class, null);
        jTable1.setSelectionBackground(Color.RED);
        showData();
        for (model.SanBay sb : controller.Controller.arrayListSanBay) {
            jComboBox1.addItem(sb.getMaSanBay().trim() + "-" + sb.getTenSanBay());
            jComboBox2.addItem(sb.getMaSanBay().trim() + "-" + sb.getTenSanBay());
        }
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);

    }

    private void showData() {
        new LoadData();
        model.setRowCount(0);
        for (DuongBay db : controller.Controller.arrayListDuongBay) {
            model.addRow(
                    new Object[]{db.getMaDuongBay(), db.getMaSanBayDi(), db.getMasanBayDen(), db.getKhoangCach()});
        }
    }

    private void initComponents() {
        setTitle("QUẢN LÝ ĐƯỜNG BAY");
        this.setLayout(new BorderLayout());

        lbl1 = new JLabel();
        jScrollPane1 = new JScrollPane();
        jTable1 = new JTable();
        btnAdd = new JButton();
        btnEdit = new JButton();
        btnDel = new JButton();
        lbl2 = new JLabel();
        lbl3 = new JLabel();
        lbl4 = new JLabel();
        btnSave = new JButton();
        btnCanncel = new JButton();
        txt5 = new JTextField();
        back = new JButton();
        jComboBox1 = new JComboBox<>();
        jComboBox2 = new JComboBox<>();
        baoLoi = new JLabel();

        btnAdd.setBackground(new Color(76, 175, 80));
        btnEdit.setBackground(new Color(33, 150, 243));
        btnDel.setBackground(new Color(244, 67, 54));
        btnSave.setBackground(new Color(33, 150, 243));
        btnCanncel.setBackground(new Color(244, 67, 54));

        setButtonIcon(back, "/images/back.png", 20, 20);
        setButtonIcon(btnDel, "/images/nut_xoa.png", 20, 20);
        setButtonIcon(btnAdd, "/images/nut_them.png", 20, 20);
        setButtonIcon(btnEdit, "/images/nut_sua.png", 20, 20);

        lbl1.setText("Danh Sách Đường Bay");
        lbl1.setHorizontalAlignment(JLabel.CENTER);
        jTable1.setModel(new DefaultTableModel(
                new Object[][]{
                    {null, null, null, null},
                    {null, null, null, null},
                    {null, null, null, null},
                    {null, null, null, null},
                    {null, null, null, null},
                    {null, null, null, null},
                    {null, null, null, null},
                    {null, null, null, null},
                    {null, null, null, null},
                    {null, null, null, null}
                },
                new String[]{
                    "Mã Đường Bay", "Sân Bay Đi", "Sân Bay Đến", "Khoảng Cách"
                }));
        jTable1.setRowHeight(30);
        jScrollPane1.setViewportView(jTable1);
        btnAdd.setText("Thêm");
        btnEdit.setText("Sửa");
        btnDel.setText("Xóa");

        lbl2.setText("Sân Bay Đi");
        lbl3.setText("Sân Bay Đến");
        lbl4.setText("Khoảng Cách");
        btnSave.setText("Lưu");
        btnCanncel.setText("Hủy");
        jComboBox1.setEnabled(false);
        jComboBox2.setEnabled(false);
        txt5.setEnabled(false);
        btnSave.setEnabled(false);
        btnCanncel.setEnabled(false);
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
                for (SanBay sb : arrayListSanBay) {
                    if (sb.getMaSanBay().equals(jTable1.getValueAt(jTable1.getSelectedRow(), 1))) {
                        jComboBox1.setSelectedIndex(arrayListSanBay.indexOf(sb));
                    }
                    if (sb.getMaSanBay().equals(jTable1.getValueAt(jTable1.getSelectedRow(), 2))) {
                        jComboBox2.setSelectedIndex(arrayListSanBay.indexOf(sb));
                    }
                }
                txt5.setText(String.valueOf(jTable1.getValueAt(jTable1.getSelectedRow(), 3)));
            }
        });
        jComboBox1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                baoLoi.setText("");
            }
        });
        jComboBox2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                baoLoi.setText("");
            }
        });
        txt5.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                baoLoi.setText("");
            }
        });
        btnAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                baoLoi.setText("");
                jTable1.setEnabled(false);
                jTable1.clearSelection();
                jComboBox1.setEnabled(true);
                jComboBox1.setSelectedIndex(0);
                jComboBox2.setEnabled(true);
                jComboBox2.setSelectedIndex(0);
                txt5.setText("");
                txt5.setEnabled(true);
                btnDel.setEnabled(false);
                btnEdit.setEnabled(false);
                btnSave.setEnabled(true);
                btnCanncel.setEnabled(true);
            }

        });
        btnEdit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                baoLoi.setText("");
                if (jTable1.getSelectedRow() == -1) {
                    baoLoi.setText("Vui lòng chọn đường bay.");
                    return;
                } else {
                    jTable1.setEnabled(false);
                    txt5.setEnabled(true);
                    btnSave.setEnabled(true);
                    btnCanncel.setEnabled(true);
                    btnAdd.setEnabled(false);
                    btnDel.setEnabled(false);
                }
            }

        });
        btnDel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                baoLoi.setText("");
                if (jTable1.getSelectedRow() == -1) {
                    baoLoi.setText("Vui lòng chọn đường bay.");
                    return;
                }
                for (ChuyenBay cb : controller.Controller.arrayListChuyenBay) {
                    if (cb.getDuongBay().getMaDuongBay().equals(jTable1.getValueAt(jTable1.getSelectedRow(), 0))) {
                        baoLoi.setText("Duong Bay Khong The Xoa");
                        return;
                    }
                }
                int cf = JOptionPane.showConfirmDialog(null, "Xác Nhận Xóa Đường Bay?", "Xác nhận",
                        JOptionPane.YES_NO_OPTION);
                ;
                if (cf == JOptionPane.YES_OPTION) {
                    connection.DeleteData.deleteDuongBay((String) jTable1.getValueAt(jTable1.getSelectedRow(), 0));
                    showData();
                    txt5.setText("");
                    jComboBox1.setSelectedIndex(0);
                    jComboBox2.setSelectedIndex(0);
                }
            }

        });
        btnCanncel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                baoLoi.setText("");
                jTable1.setEnabled(true);
                jComboBox1.setEnabled(false);
                jComboBox2.setEnabled(false);
                txt5.setEnabled(false);
                btnEdit.setEnabled(true);
                btnDel.setEnabled(true);
                btnAdd.setEnabled(true);
                btnSave.setEnabled(false);
                btnCanncel.setEnabled(false);
            }

        });
        btnSave.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                baoLoi.setText("");
                for (int i = 0; i < txt5.getText().length(); i++) {
                    if (Character.isDigit(txt5.getText().charAt(i))) {
                        continue;
                    } else {
                        baoLoi.setText("thông tin đường bay không hợp lệ!");
                        return;
                    }

                }
                System.out.println(txt5.getText());
                if (txt5.getText().equals("")) {
                    baoLoi.setText("Vui lòng nhập đầy đủ thông tin đường bay!");
                } else {
                    String sb1 = controller.Controller.arrayListSanBay.get(jComboBox1.getSelectedIndex()).getMaSanBay();
                    String sb2 = controller.Controller.arrayListSanBay.get(jComboBox2.getSelectedIndex()).getMaSanBay();
                    DuongBay db = new DuongBay(sb1.concat(sb2), sb1, sb2, Integer.parseInt(txt5.getText()));
                    if (jTable1.getSelectedRow() == -1) {

                        for (DuongBay dbb : arrayListDuongBay) {
                            if (dbb.getMaDuongBay().equals(sb1 + sb2)) {
                                baoLoi.setText("Đường bay đã tồn tại!");
                                return;
                            }
                        }

                        if (sb1.equals(sb2)) {
                            baoLoi.setText("Đường bay không hợp lệ!");
                        } else {

                            connection.InsertData.insertDuongBay(db);
                            showData();
                            jComboBox1.setEnabled(false);
                            jComboBox2.setEnabled(false);
                            txt5.setEnabled(false);
                            btnSave.setEnabled(false);
                            btnCanncel.setEnabled(false);
                            btnEdit.setEnabled(true);
                            btnDel.setEnabled(true);
                            btnAdd.setEnabled(true);
                            jTable1.setEnabled(true);
                            jTable1.getSelectionModel().setSelectionInterval(jTable1.getRowCount() - 1,
                                    jTable1.getRowCount() - 1);

                        }
                    } else {
                        int row = jTable1.getSelectedRow();
                        connection.UpdateData.updateDuongBay(db);
                        showData();
                        jComboBox1.setEnabled(false);
                        jComboBox2.setEnabled(false);
                        txt5.setEnabled(false);
                        btnSave.setEnabled(false);
                        btnCanncel.setEnabled(false);
                        btnEdit.setEnabled(true);
                        btnDel.setEnabled(true);
                        btnAdd.setEnabled(true);
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
        pnB1.add(back, BorderLayout.WEST);
        pnB.add(pnB1);
        pnB.add(lbl1);
        add(pnB, BorderLayout.NORTH);

        pnT = new JPanel(new GridLayout(1, 2));
        pnT.setBackground(new Color(248, 187, 208));
        pnT.add(jScrollPane1);

        pnT1 = new JPanel(new GridLayout(3, 1));
        pnT1.setBackground(new Color(248, 187, 208));

        pnT11 = new JPanel();
        pnT11.setBackground(new Color(248, 187, 208));
        pnT11.add(btnAdd);
        pnT11.add(btnEdit);
        pnT11.add(btnDel);

        pnT12 = new JPanel(new GridLayout(4, 2, 10, 10));
        pnT12.setBackground(new Color(248, 187, 208));
        pnT12.add(lbl2);
        pnT12.add(jComboBox1);
        pnT12.add(lbl3);
        pnT12.add(jComboBox2);
        pnT12.add(lbl4);
        pnT12.add(txt5);
        pnT12.add(baoLoi);

        pnT13 = new JPanel();
        pnT13.setBackground(new Color(248, 187, 208));
        pnT13.add(btnSave);
        pnT13.add(btnCanncel);

        pnT1.add(pnT11);
        pnT1.add(pnT12);
        pnT1.add(pnT13);
        pnT.add(pnT1);

        add(pnT, BorderLayout.CENTER);
        back.addActionListener(new ActionListener() {
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
        SwingUtilities.invokeLater(() -> new DuongBayFRM().setVisible(true));
    }
}
