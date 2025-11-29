# ✈️ FLIGHT MANAGEMENT SYSTEM

![Java](https://img.shields.io/badge/Core-Java_JDK_8+-orange?style=flat-square&logo=java)
![Platform](https://img.shields.io/badge/Platform-Swing_GUI-blue?style=flat-square)
![Database](https://img.shields.io/badge/Database-MySQL-4479A1?style=flat-square&logo=mysql)
![Architecture](https://img.shields.io/badge/Design_Pattern-MVC-green?style=flat-square)

> **Đồ án môn học: Lập trình hướng đối tượng (OOP)**
> **Học viện Công nghệ Bưu chính Viễn thông (PTIT)**

Một giải pháp phần mềm Desktop toàn diện, được thiết kế để **tự động hóa quy trình quản lý hàng không** và mang lại trải nghiệm **đặt vé điện tử trực quan** nhất.

---

## 🌟 Điểm Nhấn Của Dự Án

Hệ thống được xây dựng dựa trên kiến trúc **MVC (Model-View-Controller)** giúp tách biệt rõ ràng giữa xử lý nghiệp vụ, giao diện và dữ liệu, đảm bảo hiệu suất cao và dễ dàng bảo trì.

### 🚀 Trải Nghiệm Người Dùng (Client Side)
* **🔍 Smart Booking Engine:** Tìm kiếm chuyến bay thông minh theo thời gian thực, hỗ trợ lọc vé khứ hồi/một chiều và đa dạng đối tượng hành khách.
* **💺 Visual Seat Selection:** Tính năng "ăn tiền" nhất - Cho phép hành khách chọn ghế trực tiếp trên sơ đồ trực quan với mã màu hiển thị trạng thái (Trống/Đã đặt/Đang chọn).
* **🎫 Instant Management:** Đăng ký thành viên, quản lý lịch sử đặt vé và thông tin cá nhân bảo mật.

### 🛡️ Hệ Thống Quản Trị (Admin Side)
* **📊 Centralized Dashboard:** Trung tâm điều khiển toàn bộ hệ thống: Nhân sự, Khách hàng, và Hạ tầng bay.
* **✈️ Fleet & Route Control:** Quản lý chi tiết đội bay (Máy bay), mạng lưới đường bay và danh sách sân bay.
* **🔄 Auto-Status Update:** Hệ thống tự động cập nhật trạng thái chuyến bay (Còn vé -> Hết vé -> Hoàn tất) dựa trên thời gian thực và số lượng ghế trống.

---

## 🛠 Tech Stack

Dự án sử dụng các công nghệ tiêu chuẩn và ổn định:

* **Ngôn ngữ:** Java (JDK 8+).
* **Giao diện:** Java Swing Framework & JCalendar (Thiết kế hiện đại, thân thiện).
* **Cơ sở dữ liệu:** MySQL (Lưu trữ an toàn, toàn vẹn dữ liệu cao).
* **Kết nối:** JDBC & MySQL Connector.

---

## 📥 Hướng Dẫn Cài Đặt (Installation)

Để chạy được dự án trên máy của bạn, hãy làm theo 3 bước đơn giản sau:

1.  **Tải mã nguồn:**
    * Tải file `.zip` của dự án về máy và giải nén (hoặc Clone repository này).
2.  **Thiết lập Cơ sở dữ liệu:**
    * Mở MySQL Workbench (hoặc công cụ quản lý DB bất kỳ).
    * Import file `qlmb.sql` (nằm trong thư mục database của dự án).
    * *Lưu ý:* Kiểm tra file `src/connection/DataConnection.java` để đảm bảo username/password của MySQL khớp với máy bạn.
3.  **Khởi chạy:**
    * Mở dự án bằng **NetBeans IDE** (hoặc IDE Java bất kỳ).
    * Chạy file `DangNhapFRM.java` để bắt đầu trải nghiệm.

---

## 👨‍💻 Đội Ngũ Phát Triển

Dự án được thực hiện bởi nhóm sinh viên lớp **D23CQCN02-N**:

| MSSV | Thành Viên | Vai Trò Chính |
| :--- | :--- | :--- |
| **N23DCCN092** | Võ Nguyễn Bảo Hưng | Authentication & Account Security |
| **N23DCCN117** | Nguyễn Gia Quân | Booking Logic & Seat Map Algorithm |
| **N23DCCN098** | Đào Văn Khoa | Infrastructure Management (Airports/Planes) |
| **N23DCCN093** | Hoàng Phú Huy | User Management & Database Connection |

---

<p align="center">
  <b>Made with ❤️ by PTIT Students</b><br>
  <i>Tháng 11, 2025 - TP. Hồ Chí Minh</i>
</p>
