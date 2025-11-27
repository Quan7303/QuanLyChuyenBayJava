package view;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.LineBorder;

/**
 
  @author Huy
 */
public class QuanLyFRM extends JFrame {

    private JButton btnNhanVien, btnDuongBay, btnSanBay, btnChuyenBay,
            btnThoat, btnKhachHang, btnMayBay, btnTimChuyen;
    private JPanel panelMain;

    public QuanLyFRM() {
        initComponents();
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
    }

    private void initComponents() {
        setTitle("HỆ THỐNG QUẢN LÝ CHUYẾN BAY");
        setSize(850, 500);
        setLayout(new BorderLayout());
        getContentPane().setBackground(Color.WHITE);

        JLabel lblTitle = new JLabel("HỆ THỐNG QUẢN LÝ CHUYẾN BAY", JLabel.CENTER);
        lblTitle.setFont(new Font("Segoe UI", Font.BOLD, 22));
        lblTitle.setForeground(new Color(20, 50, 100));
        lblTitle.setBorder(BorderFactory.createEmptyBorder(15, 0, 15, 0));

        panelMain = new JPanel(new GridLayout(2, 4, 20, 20));
        panelMain.setBackground(Color.WHITE);
        panelMain.setBorder(BorderFactory.createEmptyBorder(20, 30, 30, 30));

        // === Khởi tạo nút ===
        btnNhanVien = createStyledButton("Nhân Viên", "/images/—Pngtree—employee icon vector illustration in_4257910.png", new Color(255, 77, 77));
        btnKhachHang = createStyledButton("Khách Hàng", "/images/icons8_customer_50px_2.png", new Color(255, 153, 204));
        btnTimChuyen = createStyledButton("Tìm Vé", "/images/7d74215fae51a37bb027798dedc16812-removebg-preview.png", new Color(255, 255, 102));
        btnThoat = createStyledButton("Thoát", "/images/Thoat.png", new Color(255, 51, 102));
        btnChuyenBay = createStyledButton("Chuyến Bay", "/images/kisspng-airplane-flight-computer-icons-airline-ticket-ticket-5abcf231227d01.6528235915223322091413.png", new Color(102, 255, 102));
        btnSanBay = createStyledButton("Sân Bay", "/images/icons8_runway_52px.png", new Color(102, 153, 255));
        btnDuongBay = createStyledButton("Đường Bay", "/images/_Pngtree_route_flat_multi_color_icon_3777261-removebg-preview.png", new Color(255, 179, 71));
        btnMayBay = createStyledButton("Máy Bay", "/images/image-removebg-preview (1)w.png", new Color(0, 204, 204));

        // === Thêm vào panel ===
        panelMain.add(btnNhanVien);
        panelMain.add(btnKhachHang);
        panelMain.add(btnTimChuyen);
        panelMain.add(btnThoat);
        panelMain.add(btnChuyenBay);
        panelMain.add(btnSanBay);
        panelMain.add(btnDuongBay);
        panelMain.add(btnMayBay);

        add(lblTitle, BorderLayout.NORTH);
        add(panelMain, BorderLayout.CENTER);

        // === Xử lý sự kiện ===
        btnThoat.addActionListener(e -> {
            new DangNhapFRM().setVisible(true);
            dispose();
        });
        btnNhanVien.addActionListener(e -> {
            new NhanVienFRM().setVisible(true);
            dispose();
        });
        btnDuongBay.addActionListener(e -> {
            new DuongBayFRM().setVisible(true);
            dispose();
        });
        btnSanBay.addActionListener(e -> {
            new SanBayFRM().setVisible(true);
            dispose();
        });
        btnChuyenBay.addActionListener(e -> {
            new ChuyenBayFRM().setVisible(true);
            dispose();
        });
        btnKhachHang.addActionListener(e -> {
            new KhachHangFRM().setVisible(true);
            dispose();
        });
        btnMayBay.addActionListener(e -> {
            new MayBayFRM().setVisible(true);
            dispose();
        });
        btnTimChuyen.addActionListener(e -> {
            new TimChuyenBayFRM().setVisible(true);
            dispose();
        });
    }

    // === Hàm tạo nút có style ===
    private JButton createStyledButton(String text, String iconPath, Color bgColor) {
        JButton button = new JButton(text);
        button.setFont(new Font("Segoe UI", Font.BOLD, 15));
        button.setForeground(Color.BLACK);
        button.setBackground(bgColor);
        button.setIcon(new ImageIcon(getClass().getResource(iconPath)));
        button.setHorizontalTextPosition(SwingConstants.CENTER);
        button.setVerticalTextPosition(SwingConstants.BOTTOM);
        button.setFocusPainted(false);
        button.setBorder(new LineBorder(Color.WHITE, 2, true));
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));

        // Hiệu ứng hover
        button.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                button.setBackground(bgColor.darker());
            }

            @Override
            public void mouseExited(MouseEvent e) {
                button.setBackground(bgColor);
            }
        });
        return button;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new QuanLyFRM().setVisible(true));
    }
}
