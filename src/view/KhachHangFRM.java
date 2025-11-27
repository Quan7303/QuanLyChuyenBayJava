package view;
/**
  @author Huy
*/
import connection.LoadData;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.table.*;
import model.KhachHang;

public class KhachHangFRM extends JFrame {

    private JButton btnBack;
    private JLabel lblTitle;
    private JScrollPane scrollPane;
    private JTable table;
    private JPanel pnTop, pnHeader, pnCenter;

    public KhachHangFRM() {
        initComponents();
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
    }

    private void initComponents() {
        setTitle("QUẢN LÝ KHÁCH HÀNG");
        setLayout(new BorderLayout());
        setSize(900, 600);
        getContentPane().setBackground(Color.WHITE);

        // ==== HEADER ====
        lblTitle = new JLabel("THÔNG TIN KHÁCH HÀNG", JLabel.CENTER);
        lblTitle.setFont(new Font("Segoe UI", Font.BOLD, 20));
        lblTitle.setForeground(new Color(0, 102, 204));

        btnBack = new JButton("Quay lại", new ImageIcon(getClass().getResource("/images/back.png")));
        btnBack.setFocusPainted(false);
        btnBack.setBackground(new Color(230, 230, 230));

        pnHeader = new JPanel(new BorderLayout());
        pnHeader.setBackground(new Color(240, 240, 240));
        pnHeader.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
        pnHeader.add(btnBack, BorderLayout.WEST);
        pnHeader.add(lblTitle, BorderLayout.CENTER);

        // ==== TABLE ====
        table = new JTable();
        table.setModel(new DefaultTableModel(
                new Object[][]{},
                new String[]{"Tên Khách Hàng", "SĐT", "Tên Đăng Nhập", "Ngày Sinh", "Email"}
        ));

        table.setRowHeight(30);
        table.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        table.setGridColor(new Color(220, 220, 220));
        table.setSelectionBackground(new Color(255, 102, 102));
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        table.setDefaultEditor(Object.class, null);

        // Căn giữa tiêu đề cột
        JTableHeader header = table.getTableHeader();
        header.setFont(new Font("Segoe UI", Font.BOLD, 15));
        ((DefaultTableCellRenderer) header.getDefaultRenderer()).setHorizontalAlignment(JLabel.CENTER);
        header.setBackground(new Color(0, 102, 204));
        header.setForeground(Color.WHITE);

        scrollPane = new JScrollPane(table);
        scrollPane.setBorder(BorderFactory.createEmptyBorder(10, 20, 20, 20));

        pnCenter = new JPanel(new BorderLayout());
        pnCenter.setBackground(Color.WHITE);
        pnCenter.add(scrollPane, BorderLayout.CENTER);

        // ==== TẢI DỮ LIỆU ====
        new LoadData();
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0);
        for (KhachHang kh : controller.Controller.arrayListKhachHang) {
            model.addRow(new Object[]{
                kh.getTenKhachHang(),
                kh.getSDT(),
                kh.getTenDangNhap(),
                kh.getNgaySinh(),
                kh.getEmail()
            });
        }

        // ==== GẮN CÁC PANEL ====
        add(pnHeader, BorderLayout.NORTH);
        add(pnCenter, BorderLayout.CENTER);

        // ==== SỰ KIỆN NÚT BACK ====
        btnBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new QuanLyFRM().setVisible(true);
                dispose();
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new KhachHangFRM().setVisible(true);
        });
    }
}
