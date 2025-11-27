/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import com.toedter.calendar.JDateChooser;
import connection.LoadData;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;
import model.ChuyenBay;
import model.DuongBay;
import model.MayBay;

/**
 *
 * @author KHOA
 */
public class ChuyenBayFRM extends JFrame {

    private JLabel baoLoi;
    private ButtonGroup btnG1;
    private JButton btn7, btnADD, btnCan, btnDSVe, btnEdit, btnHC, btnSave;
    private JComboBox<String> jComboBoxDuongBay, jComboBoxSHMB, jComboBox_GioDi1, jComboBox_PhutDi;
    private JDateChooser jDateChooserNgayBay;
    private JLabel lbl1, lbl2, lbl3, lbl4, lbl5, lbl6;
    private JRadioButton jRadioButton1, jRadioButton2, jRadioButton3, jRadioButton4;
    private JScrollPane jScrollPane2;
    private JTable jTable1;
    private JTextField jTextFieldMaCB;
    private JPanel pnB, pnB1, pnB2, pnT, pnT1, pnT11, pnT12, pnT13, pnT14;
    private DefaultTableModel model;
    private int cheDo;

    private void setButtonIcon(JButton button, String path, int width, int height) {
        ImageIcon icon = new ImageIcon(getClass().getResource(path));
        Image img = icon.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);
        button.setIcon(new ImageIcon(img));
    }

    public ChuyenBayFRM() {
        initComponents();
        this.cheDo = 0;
        showData();
        jTable1.setDefaultEditor(Object.class, null);
        jTable1.setSelectionBackground(Color.BLUE);
        jTable1.setSelectionMode(0);
        for (MayBay mb : controller.Controller.arrayListMayBay) {
            jComboBoxSHMB.addItem(mb.getSHMB().trim());
        }
        for (DuongBay db : controller.Controller.arrayListDuongBay) {
            jComboBoxDuongBay.addItem(db.getMaSanBayDi() + "->" + db.getMasanBayDen());
        }
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
    }

    private void showData() {
        new LoadData();
        model.setRowCount(0);
        for (ChuyenBay cb : controller.Controller.arrayListChuyenBay) {
            if (cb.getTrangThai() == this.cheDo) {
                model.addRow(new Object[] { cb.getMaChuyenBay(), cb.getSHMB(),
                        cb.getDuongBay().getMaSanBayDi() + "->" + cb.getDuongBay().getMasanBayDen(),
                        cb.getNgayBay() + " " + cb.getGioBay() });
            }
        }
    }

    private void initComponents() {
        setTitle("QUẢN LÝ CHUYẾN BAY");
        this.setLayout(new BorderLayout());
        btnG1 = new ButtonGroup();
        btnADD = new JButton();
        btnHC = new JButton();
        btnEdit = new JButton();
        lbl1 = new JLabel();
        btnSave = new JButton();
        btnCan = new JButton();
        lbl2 = new JLabel();
        btn7 = new JButton();
        lbl4 = new JLabel();
        jTextFieldMaCB = new JTextField();
        jComboBoxSHMB = new JComboBox<>();
        lbl5 = new JLabel();
        jDateChooserNgayBay = new com.toedter.calendar.JDateChooser();
        jComboBox_GioDi1 = new JComboBox<>();
        jComboBox_PhutDi = new JComboBox<>();
        lbl6 = new JLabel();
        lbl3 = new JLabel();
        jComboBoxDuongBay = new JComboBox<>();
        btnDSVe = new JButton();
        jScrollPane2 = new JScrollPane();
        jTable1 = new JTable();
        baoLoi = new JLabel();
        jRadioButton2 = new JRadioButton();
        jRadioButton3 = new JRadioButton();
        jRadioButton4 = new JRadioButton();
        jRadioButton1 = new JRadioButton();
        btnADD.setText("Thêm");
        btnHC.setText("Hủy Chuyến");
        btnEdit.setText("Sửa");
        lbl1.setText("SHMB");
        btnSave.setText("Lưu");
        btnCan.setText("Hủy");
        lbl2.setText("Giờ Bay");
        lbl4.setText("Mã Chuyến Bay");
        lbl5.setText("Ngày Bay");
        jDateChooserNgayBay.setDateFormatString("dd/MM/yyyy");
        jComboBox_GioDi1.setModel(
                new DefaultComboBoxModel<>(new String[] { "00", "01", "02", "03", "04", "05", "06", "07", "08", "09",
                        "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23" }));
        jComboBox_PhutDi.setModel(new DefaultComboBoxModel<>(
                new String[] { "00", "05", "10", "15", "20", "25", "30", "35", "40", "45", "50", "55" }));
        lbl6.setText(":");
        lbl3.setText("Đường Bay");
        btnDSVe.setText("DSVe");

        btnADD.setBackground(new Color(76, 175, 80));
        btnEdit.setBackground(new Color(33, 150, 243));
        btnHC.setBackground(new Color(244, 67, 54));
        btnSave.setBackground(new Color(33, 150, 243));
        btnCan.setBackground(new Color(244, 67, 54));

        setButtonIcon(btn7, "/images/back.png", 20, 20);
        setButtonIcon(btnHC, "/images/nut_xoa.png", 20, 20);
        setButtonIcon(btnADD, "/images/nut_them.png", 20, 20);
        setButtonIcon(btnEdit, "/images/nut_sua.png", 20, 20);

        jTable1.setModel(new DefaultTableModel(
                new Object[][] {},
                new String[] {
                        "Mã Chuyến Bay", "SHMB", "Đường Bay", "Thời Gian"
                }));
        model = (DefaultTableModel) jTable1.getModel();
        jTable1.setRowHeight(34);
        jScrollPane2.setViewportView(jTable1);
        baoLoi.setForeground(new Color(255, 0, 0));
        baoLoi.setHorizontalAlignment(JLabel.CENTER);
        btnG1.add(jRadioButton2);
        jRadioButton2.setText("Còn Vé");
        jRadioButton2.setSelected(true);
        btnG1.add(jRadioButton3);
        jRadioButton3.setText("Hết Vé");
        btnG1.add(jRadioButton4);
        jRadioButton4.setText("Hủy Chuyến");
        btnG1.add(jRadioButton1);
        jRadioButton1.setText("Hoàn Tất");
        jComboBox_GioDi1.setEnabled(false);
        jTextFieldMaCB.setEnabled(false);
        jComboBoxSHMB.setEnabled(false);
        jComboBoxDuongBay.setEnabled(false);
        jDateChooserNgayBay.setEnabled(false);
        jComboBox_PhutDi.setEnabled(false);
        btnSave.setEnabled(false);
        btnCan.setEnabled(false);

        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                baoLoi.setText("");
            }

        });
        jRadioButton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cheDo = ChuyenBay.CONVE;

                btnEdit.setEnabled(true);
                btnHC.setEnabled(true);
                showData();
            }

        });
        jRadioButton3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cheDo = ChuyenBay.HETVE;
                btnEdit.setEnabled(true);
                btnHC.setEnabled(true);
                showData();
            }

        });
        jRadioButton4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cheDo = ChuyenBay.HUYCHUYEN;
                showData();
                btnEdit.setEnabled(false);
                btnHC.setEnabled(false);
            }

        });
        jRadioButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cheDo = ChuyenBay.HOANTAT;
                showData();
                btnEdit.setEnabled(false);
                btnHC.setEnabled(false);
            }

        });

        btnADD.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jTable1.setEnabled(false);
                jTable1.clearSelection();
                jTextFieldMaCB.setText("");
                jComboBoxSHMB.setSelectedIndex(0);
                jComboBoxDuongBay.setSelectedIndex(0);
                jComboBox_GioDi1.setSelectedIndex(0);
                jComboBox_PhutDi.setSelectedIndex(0);
                jComboBox_GioDi1.setEnabled(true);
                jTextFieldMaCB.setEnabled(true);
                jComboBoxSHMB.setEnabled(true);
                jComboBoxDuongBay.setEnabled(true);
                jDateChooserNgayBay.setEnabled(true);
                jComboBox_PhutDi.setEnabled(true);
                btnSave.setEnabled(true);
                btnCan.setEnabled(true);
                btnHC.setEnabled(false);
                btnEdit.setEnabled(false);
                btnDSVe.setEnabled(false);
                String date = new SimpleDateFormat("dd/MM/yyyy").format(Calendar.getInstance().getTime());
                try {
                    java.util.Date datenow = new SimpleDateFormat("dd/MM/yyyy").parse(date);
                    jDateChooserNgayBay.setDate(datenow);
                } catch (ParseException ex) {
                    Logger.getLogger(ChuyenBayFRM.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        });
        btnEdit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                baoLoi.setText("");
                if (jTable1.getSelectedRow() == -1) {
                    baoLoi.setText("Vui lòng chọn chuyến bay.");
                } else {
                    jTable1.setEnabled(false);
                    jDateChooserNgayBay.setEnabled(true);
                    jComboBox_GioDi1.setEnabled(true);
                    jComboBox_PhutDi.setEnabled(true);
                    btnSave.setEnabled(true);
                    btnCan.setEnabled(true);
                    btnADD.setEnabled(false);
                    btnHC.setEnabled(false);
                    btnDSVe.setEnabled(false);
                }
            }

        });
        btnHC.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                baoLoi.setText("");
                if (jTable1.getSelectedRow() == -1) {
                    baoLoi.setText("Vui lòng chọn chuyến bay.");
                } else {
                    int cf = JOptionPane.showConfirmDialog(null, "Xác Nhận Xóa Chuyến Bay?", "Xác nhận",
                            JOptionPane.YES_NO_OPTION);
                    if (cf == JOptionPane.YES_OPTION) {
                        connection.UpdateData.huyChuyenBay((String) jTable1.getValueAt(jTable1.getSelectedRow(), 0));
                        showData();
                    }
                }
            }

        });
        btnCan.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                baoLoi.setText("");
                jTable1.setEnabled(true);
                jTextFieldMaCB.setEnabled(false);
                jComboBoxSHMB.setEnabled(false);
                jComboBoxDuongBay.setEnabled(false);
                jDateChooserNgayBay.setEnabled(false);
                jComboBox_GioDi1.setEnabled(false);
                jComboBox_PhutDi.setEnabled(false);
                btnSave.setEnabled(false);
                btnCan.setEnabled(false);
                btnDSVe.setEnabled(true);
                btnEdit.setEnabled(true);
                btnHC.setEnabled(true);
                btnADD.setEnabled(true);
            }

        });
        btnSave.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                baoLoi.setText("");
                jTextFieldMaCB.setText(jTextFieldMaCB.getText().toUpperCase());
                if (jTextFieldMaCB.getText().equals("")) {
                    baoLoi.setText("Vui lòng điền đầy đủ thông tin chuyến bay");
                    return;
                }
                Date datenow = Calendar.getInstance().getTime();
                Time myTime = new Time(
                        Integer.parseInt(jComboBox_GioDi1.getSelectedItem().toString()),
                        Integer.parseInt(jComboBox_PhutDi.getSelectedItem().toString()),
                        0);
                if ((jDateChooserNgayBay.getDate().getTime() + myTime.getTime() + 7 * 3600000) - datenow.getTime() < 24
                        * 3600000) {
                    baoLoi.setText("Chuyen Bay Phải mở trước khi bay 1 ngày");
                    return;
                }
                java.sql.Date myDate = new java.sql.Date(jDateChooserNgayBay.getDate().getTime());
                DuongBay myDuongBay = controller.Controller.arrayListDuongBay.get(jComboBoxDuongBay.getSelectedIndex());

                ChuyenBay cb = new ChuyenBay(jTextFieldMaCB.getText(), jComboBoxSHMB.getSelectedItem().toString(),
                        myDuongBay,
                        myDate, myTime, ChuyenBay.CONVE);
                int row = jTable1.getSelectedRow();
                if (jTable1.getSelectedRow() == -1) {
                    for (ChuyenBay chbay : controller.Controller.arrayListChuyenBay) {
                        if (cb.getMaChuyenBay().equals(chbay.getMaChuyenBay())) {
                            baoLoi.setText("Mã Chuyến Bay đã tồn tại ");
                            return;
                        }
                        if ((cb.getSHMB().equals(chbay.getSHMB()) || (cb.getDuongBay().equals(chbay.getDuongBay())))
                                && (Math.abs(chbay.getCBTime().getTime() - cb.getCBTime().getTime()) < 1800000)) {
                            baoLoi.setText("Không Thể Thêm CB Vao Thoi Gian Nay");
                            return;
                        }
                    }
                    connection.InsertData.insertChuyenBay(cb);
                    showData();
                    baoLoi.setText("");
                    jTable1.setEnabled(true);
                    jTextFieldMaCB.setEnabled(false);
                    jComboBoxSHMB.setEnabled(false);
                    jComboBoxDuongBay.setEnabled(false);
                    jDateChooserNgayBay.setEnabled(false);
                    jComboBox_GioDi1.setEnabled(false);
                    jComboBox_PhutDi.setEnabled(false);
                    btnSave.setEnabled(false);
                    btnCan.setEnabled(false);
                    btnHC.setEnabled(true);
                    btnEdit.setEnabled(true);
                    btnDSVe.setEnabled(true);
                    btnADD.setEnabled(true);
                    jTable1.getSelectionModel().setSelectionInterval(jTable1.getRowCount() - 1,
                            jTable1.getRowCount() - 1);
                } else {
                    connection.UpdateData.updateChuyenBay(cb);
                    showData();
                    baoLoi.setText("");
                    jTable1.setEnabled(true);
                    jTextFieldMaCB.setEnabled(false);
                    jComboBoxSHMB.setEnabled(false);
                    jComboBoxDuongBay.setEnabled(false);
                    jDateChooserNgayBay.setEnabled(false);
                    jComboBox_GioDi1.setEnabled(false);
                    jComboBox_PhutDi.setEnabled(false);
                    btnSave.setEnabled(false);
                    btnCan.setEnabled(false);
                    btnHC.setEnabled(true);
                    btnEdit.setEnabled(true);
                    btnDSVe.setEnabled(true);
                    btnADD.setEnabled(true);
                    jTable1.getSelectionModel().setSelectionInterval(row, row);
                }
            }

        });
        jTable1.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                baoLoi.setText("");
                int row = jTable1.getSelectedRow();
                jTextFieldMaCB.setText((String) jTable1.getValueAt(row, 0));
                jComboBoxSHMB.setSelectedItem((String) jTable1.getValueAt(row, 1));
                jComboBoxDuongBay.setSelectedItem((String) jTable1.getValueAt(row, 2));
                String datebay = jTable1.getValueAt(jTable1.getSelectedRow(), 3).toString();
                jComboBox_GioDi1.setSelectedItem(datebay.substring(11, 13));
                jComboBox_PhutDi.setSelectedItem(datebay.substring(14, 16));

                datebay = datebay.substring(8, 10) + "/" + datebay.substring(5, 7) + "/" + datebay.substring(0, 4);

                try {
                    java.util.Date datetmp = new SimpleDateFormat("dd/MM/yyyy").parse(datebay);
                    jDateChooserNgayBay.setDate(datetmp);
                } catch (ParseException ex) {
                    Logger.getLogger(ChuyenBayFRM.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        btnDSVe.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                baoLoi.setText("");
                if (jTable1.getSelectedRow() == -1) {
                    baoLoi.setText("Vui lòng chọn chuyến bay.");
                    return;
                }
                for (ChuyenBay cbb : controller.Controller.arrayListChuyenBay) {
                    if (cbb.getMaChuyenBay().equals((String) jTable1.getValueAt(jTable1.getSelectedRow(), 0))) {
                        controller.Controller.cb = cbb;
                        break;
                    }
                }
                new DSVeFRM().setVisible(true);
                dispose();
            }

        });
        pnB = new JPanel(new GridLayout(2, 1));
        pnB.setBackground(new Color(255, 253, 208));
        pnB1 = new JPanel(new BorderLayout());
        pnB1.setBackground(new Color(255, 253, 208));

        pnB1.add(btn7, BorderLayout.WEST);
        pnB2 = new JPanel();
        pnB2.setBackground(new Color(255, 253, 208));
        pnB2.add(jRadioButton2);
        pnB2.add(jRadioButton3);
        pnB2.add(jRadioButton4);
        pnB2.add(jRadioButton1);
        pnB.add(pnB1);
        pnB.add(pnB2);
        pnT = new JPanel(new GridLayout(1, 2));
        pnT.setBackground(new Color(248, 187, 208));
        pnT.add(jScrollPane2);

        pnT1 = new JPanel(new GridLayout(5, 1));
        pnT1.setBackground(new Color(248, 187, 208));
        pnT11 = new JPanel();
        pnT11.setBackground(new Color(248, 187, 208));
        pnT11.add(btnDSVe);
        pnT11.add(btnADD);
        pnT11.add(btnEdit);
        pnT11.add(btnHC);

        pnT12 = new JPanel(new GridLayout(4, 2));
        pnT12.setBackground(new Color(248, 187, 208));
        pnT12.add(lbl4);
        pnT12.add(jTextFieldMaCB);
        pnT12.add(lbl1);
        pnT12.add(jComboBoxSHMB);
        pnT12.add(lbl3);
        pnT12.add(jComboBoxDuongBay);
        pnT12.add(lbl5);
        pnT12.add(jDateChooserNgayBay);

        pnT13 = new JPanel();
        pnT13.setBackground(new Color(248, 187, 208));
        pnT13.add(lbl2);
        pnT13.add(jComboBox_GioDi1);
        pnT13.add(lbl6);
        pnT13.add(jComboBox_PhutDi);

        pnT14 = new JPanel();
        pnT14.setBackground(new Color(248, 187, 208));
        pnT14.add(btnSave);
        pnT14.add(btnCan);

        pnT1.add(pnT11);
        pnT1.add(pnT12);
        pnT1.add(pnT13);
        pnT1.add(pnT14);
        pnT1.add(baoLoi);
        pnT.add(pnT1);

        add(pnB, BorderLayout.NORTH);
        add(pnT, BorderLayout.CENTER);

        btn7.addActionListener(new ActionListener() {
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
        SwingUtilities.invokeLater(() -> new ChuyenBayFRM().setVisible(true));
    }

}
