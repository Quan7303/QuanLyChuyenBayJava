package view;

/**
  @author Huy
 */
import connection.LoadData;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*;
import model.NhanVien;
import model.TaiKhoan;

public class NhanVienFRM extends JFrame {

    private JButton btnBack, btnAdd, btnCancel, btnDelete, btnEdit, btnSave;
    private JScrollPane scrollPaneTable;
    private JLabel lblTenNV, lblSDT, lblLuong, lblTitle, lblTenDangNhap, lblError;
    private JTable tableNhanVien;
    private JTextField txtLuong, txtSDT, txtTenNV, txtTenDangNhap;
    private JPanel panelHeader, panelBackButton, panelMain, panelRight, panelButtons, panelForm, panelSaveCancel;
    private DefaultTableModel model;

    public NhanVienFRM() {
        initComponents();
        model = (DefaultTableModel) tableNhanVien.getModel();
        showData();

        tableNhanVien.setDefaultEditor(Object.class, null);
        tableNhanVien.setSelectionBackground(new Color(51, 153, 255));
        tableNhanVien.setSelectionMode(0);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
    }

    private void showData() {
        new LoadData();
        model.setRowCount(0);
        for (NhanVien nv : controller.Controller.arrayListNhanVien) {
            model.addRow(new Object[] { nv.getTenNhanVien(), nv.getSDT(), nv.getTenDangNhap(), nv.getLuong() });
        }
    }

    private void initComponents() {
        setTitle("QUẢN LÝ NHÂN VIÊN");
        this.setLayout(new BorderLayout());
        Color mainBlue = new Color(0, 102, 204);
        Color bgWhite = Color.WHITE;
        Font mainFont = new Font("Segoe UI", Font.PLAIN, 14);

        // ===== Label =====
        lblTenNV = new JLabel("Tên Nhân Viên");
        lblSDT = new JLabel("Số Điện Thoại");
        lblLuong = new JLabel("Lương");
        lblTenDangNhap = new JLabel("Tên Đăng Nhập");

        JLabel[] labels = { lblTenNV, lblSDT, lblLuong, lblTenDangNhap };
        for (JLabel lbl : labels) {
            lbl.setFont(mainFont);
            lbl.setForeground(new Color(60, 60, 60));
        }

        lblTitle = new JLabel("DANH SÁCH NHÂN VIÊN", JLabel.CENTER);
        lblTitle.setFont(new Font("Segoe UI", Font.BOLD, 20));
        lblTitle.setForeground(mainBlue);
        lblTitle.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));

        lblError = new JLabel();
        lblError.setForeground(new Color(200, 0, 0));
        lblError.setFont(new Font("Segoe UI", Font.ITALIC, 13));

        // ===== TextField =====
        txtTenNV = new JTextField();
        txtSDT = new JTextField();
        txtTenDangNhap = new JTextField();
        txtLuong = new JTextField();
        JTextField[] fields = { txtTenNV, txtSDT, txtTenDangNhap, txtLuong };
        for (JTextField txt : fields) {
            txt.setEnabled(false);
            txt.setFont(mainFont);
            txt.setBackground(new Color(250, 250, 250));
            txt.setBorder(BorderFactory.createCompoundBorder(
                    BorderFactory.createLineBorder(new Color(200, 200, 200)),
                    BorderFactory.createEmptyBorder(5, 5, 5, 5)));
        }

        // ===== Buttons =====
        btnAdd = new JButton("Thêm");
        btnEdit = new JButton("Sửa");
        btnDelete = new JButton("Xóa");
        btnSave = new JButton("Lưu");
        btnCancel = new JButton("Hủy");
        btnBack = new JButton(new ImageIcon(getClass().getResource("/images/back.png")));

        JButton[] buttons = { btnAdd, btnEdit, btnDelete, btnSave, btnCancel };
        for (JButton btn : buttons) {
            btn.setFocusPainted(false);
            btn.setBackground(mainBlue);
            btn.setForeground(Color.WHITE);
            btn.setFont(new Font("Segoe UI", Font.BOLD, 13));
            btn.setBorder(BorderFactory.createEmptyBorder(6, 16, 6, 16));
        }

        btnSave.setEnabled(false);
        btnCancel.setEnabled(false);
        btnBack.setBackground(bgWhite);
        btnBack.setFocusPainted(false);
        btnBack.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));

        // ===== Table =====
        tableNhanVien = new JTable();
        tableNhanVien.setModel(new DefaultTableModel(
                new Object[][] {},
                new String[] { "Tên Nhân Viên", "SĐT", "Tên Đăng Nhập", "Lương" }));
        tableNhanVien.setFont(mainFont);
        tableNhanVien.setRowHeight(28);
        tableNhanVien.setGridColor(new Color(220, 220, 220));

        JTableHeader header = tableNhanVien.getTableHeader();
        header.setFont(new Font("Segoe UI", Font.BOLD, 14));
        header.setBackground(mainBlue);
        header.setForeground(Color.WHITE);
        ((DefaultTableCellRenderer) header.getDefaultRenderer()).setHorizontalAlignment(JLabel.CENTER);

        scrollPaneTable = new JScrollPane(tableNhanVien);
        scrollPaneTable.setBorder(BorderFactory.createEmptyBorder(10, 15, 10, 15));

        // ===== Panel Header =====
        panelHeader = new JPanel(new BorderLayout());
        panelHeader.setBackground(bgWhite);
        panelHeader.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, mainBlue));

        panelBackButton = new JPanel(new BorderLayout());
        panelBackButton.setBackground(bgWhite);
        panelBackButton.add(btnBack, BorderLayout.WEST);
        panelHeader.add(panelBackButton, BorderLayout.WEST);
        panelHeader.add(lblTitle, BorderLayout.CENTER);

        // ===== Panel Main =====
        panelMain = new JPanel(new GridLayout(1, 2, 10, 0));
        panelMain.setBackground(bgWhite);
        panelMain.add(scrollPaneTable);

        // ===== Panel Right =====
        panelRight = new JPanel(new GridLayout(3, 1, 0, 10));
        panelRight.setBackground(bgWhite);

        // Nút thêm/sửa/xóa
        panelButtons = new JPanel();
        panelButtons.setBackground(bgWhite);
        panelButtons.add(btnAdd);
        panelButtons.add(btnEdit);
        panelButtons.add(btnDelete);

        // Form nhập
        panelForm = new JPanel(new GridLayout(5, 2, 5, 5));
        panelForm.setBackground(bgWhite);
        panelForm.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
        panelForm.add(lblTenNV);
        panelForm.add(txtTenNV);
        panelForm.add(lblSDT);
        panelForm.add(txtSDT);
        panelForm.add(lblTenDangNhap);
        panelForm.add(txtTenDangNhap);
        panelForm.add(lblLuong);
        panelForm.add(txtLuong);
        panelForm.add(lblError);

        // Nút lưu/hủy
        panelSaveCancel = new JPanel();
        panelSaveCancel.setBackground(bgWhite);
        panelSaveCancel.add(btnSave);
        panelSaveCancel.add(btnCancel);

        panelRight.add(panelButtons);
        panelRight.add(panelForm);
        panelRight.add(panelSaveCancel);
        panelMain.add(panelRight);

        add(panelHeader, BorderLayout.NORTH);
        add(panelMain, BorderLayout.CENTER);

        // ===== Sự kiện =====
        btnBack.addActionListener(e -> {
            new QuanLyFRM().setVisible(true);
            dispose();
        });

        this.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                lblError.setText("");
            }
        });
        for (JTextField txt : fields) {
            txt.addMouseListener(new MouseAdapter() {
                public void mouseClicked(MouseEvent e) {
                    lblError.setText("");
                }
            });
        }

        btnAdd.addActionListener(e -> {
            lblError.setText("");
            for (JTextField txt : fields)
                txt.setText("");
            for (JTextField txt : fields)
                txt.setEnabled(true);
            tableNhanVien.setEnabled(false);
            btnSave.setEnabled(true);
            btnCancel.setEnabled(true);
            btnEdit.setEnabled(false);
            btnDelete.setEnabled(false);
        });

        btnDelete.addActionListener(e -> {
            lblError.setText("");
            if (tableNhanVien.getSelectedRow() == -1) {
                lblError.setText("Vui lòng chọn nhân viên");
            } else {
                int confirm = JOptionPane.showConfirmDialog(null, "Xác nhận xóa nhân viên?", "Xác nhận",
                        JOptionPane.YES_NO_OPTION);
                if (confirm == JOptionPane.YES_OPTION) {
                    connection.DeleteData
                            .deleteNhanvien((String) tableNhanVien.getValueAt(tableNhanVien.getSelectedRow(), 1));
                    connection.DeleteData
                            .deleteTaikhoan((String) tableNhanVien.getValueAt(tableNhanVien.getSelectedRow(), 2));
                    showData();
                }
            }
        });

        btnEdit.addActionListener(e -> {
            lblError.setText("");
            if (tableNhanVien.getSelectedRow() == -1) {
                lblError.setText("Vui lòng chọn nhân viên");
            } else {
                tableNhanVien.setEnabled(false);
                txtLuong.setEnabled(true);
                btnSave.setEnabled(true);
                btnCancel.setEnabled(true);
            }
        });

        tableNhanVien.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                lblError.setText("");
                int row = tableNhanVien.getSelectedRow();
                txtTenNV.setText((String) tableNhanVien.getValueAt(row, 0));
                txtSDT.setText((String) tableNhanVien.getValueAt(row, 1));
                txtTenDangNhap.setText((String) tableNhanVien.getValueAt(row, 2));
                txtLuong.setText(String.valueOf(tableNhanVien.getValueAt(row, 3)));
            }
        });

        btnCancel.addActionListener(e -> {
            lblError.setText("");
            tableNhanVien.setEnabled(true);
            for (JTextField txt : fields)
                txt.setEnabled(false);
            btnSave.setEnabled(false);
            btnEdit.setEnabled(true);
            btnDelete.setEnabled(true);
            btnCancel.setEnabled(false);
        });

        btnSave.addActionListener(e -> {
            for (char c : txtLuong.getText().toCharArray()) {
                if (!Character.isDigit(c)) {
                    lblError.setText("Thông tin về lương không hợp lệ!");
                    return;
                }
            }
            if (txtSDT.getText().length() != 10) {
                lblError.setText("Số điện thoại phải có 10 chữ số!");
                return;
            } else {
                for (char c : txtSDT.getText().toCharArray()) {
                    if (!Character.isDigit(c)) {
                        lblError.setText("Số điện thoại không hợp lệ!");
                        return;
                    }
                }
            }
            if (txtTenNV.getText().isEmpty() || txtSDT.getText().isEmpty() ||
                    txtTenDangNhap.getText().isEmpty() || txtLuong.getText().isEmpty()) {
                lblError.setText("Vui lòng nhập đầy đủ thông tin!");
                return;
            }

            int selectedRow = tableNhanVien.getSelectedRow();
            NhanVien nv = new NhanVien(txtSDT.getText(), txtTenNV.getText(), txtTenDangNhap.getText(),
                    Integer.parseInt(txtLuong.getText()));
            TaiKhoan tk = new TaiKhoan(txtTenDangNhap.getText(), txtSDT.getText(), "staff");

            if (selectedRow == -1) {
                for (NhanVien nvv : controller.Controller.arrayListNhanVien) {
                    if (nvv.getSDT().equals(txtSDT.getText())) {
                        lblError.setText("Nhân viên đã tồn tại!");
                        return;
                    }
                }
                for (TaiKhoan tkk : controller.Controller.arrayListTaiKhoan) {
                    if (tkk.getTenDangNhap().equals(txtTenDangNhap.getText())) {
                        lblError.setText("Tên đăng nhập đã tồn tại!");
                        return;
                    }
                }
                connection.InsertData.insertTaiKhoan(tk);
                connection.InsertData.insertNhanVien(nv);
                showData();
            } else {
                connection.UpdateData.updateNhanvien(nv);
                showData();
            }

            lblError.setText("");
            for (JTextField txt : fields) {
                txt.setText("");
                txt.setEnabled(false);
            }
            tableNhanVien.setEnabled(true);
            btnSave.setEnabled(false);
            btnCancel.setEnabled(false);
            btnEdit.setEnabled(true);
            btnDelete.setEnabled(true);
        });

        pack();
    }

    public static void main(String[] args) {
        new NhanVienFRM().setVisible(true);
    }
}
