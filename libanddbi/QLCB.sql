create database qlmb;
use qlmb;
create table chuyenbay(
	machuyenbay varchar(30) not null,
    shmb varchar(20) not null,
    duongbay varchar(10) not null,
    ngaybay date not null,
    giobay time(6) not null,
    trangthai int not null,
    primary key (machuyenbay)
);

CREATE TABLE DUONGBAY (
    MADUONGBAY VARCHAR(10) NOT NULL,
    SANBAYDI VARCHAR(10) NOT NULL,
    SANBAYDEN VARCHAR(10) NOT NULL,
    KHOANGCACH INT,
    PRIMARY KEY (MADUONGBAY)
);

CREATE TABLE khachhang (
    SDT VARCHAR(12) NOT NULL,
    TENDANGNHAP VARCHAR(30) NOT NULL,
    HOVATEN VARCHAR(60) NOT NULL,
    EMAIL VARCHAR(30) not null,
    NGAYSINH date not null,
    PRIMARY KEY (SDT)
);

create table maybay(
	shmb varchar(20) not null,
    hangbay varchar(50) not null,
    soghe int not null,
    primary key (shmb)
);

create table nhanvien(
	sdt varchar(12) not null,
    tennhanvien varchar(50) not null,
    tendangnhap varchar(30) not null,
    luong int not null,
	primary key (sdt)
);

create table sanbay(
	masanbay varchar(10) not null,
    tensanbay varchar(30) not null,
    diadiem varchar(30) not null,
    primary key (masanbay)
);

create table taikhoan(
	tendangnhap varchar(30) not null,
    matkhau varchar(30) not null,
    loaitaikhoan varchar(10) not null,
    primary key (tendangnhap)
);

create table ve(
	mcb varchar(30) not null,
    tenhanhkhach varchar(30) not null,
    sdt varchar(12) not null,
    soghe int not null,
    primary key (mcb,soghe) 
);

insert into chuyenbay values
('CB1', 'MB2', 'SGNVII', '2026-02-11','20:00:00', 0),
('CB2', 'MB6', 'SGNVII', '2022-02-14','18:00:00', 0),
('CN2', 'MB1', 'DADVII', CAST('2022-02-18' AS Date), CAST('17:00:00' AS Time), 0),
('HAN-SGN-001', 'VN_A350_01', 'HANSGN', '2025-12-20', '06:00:00', 0),
('HAN-SGN-002', 'VJ_A321_01', 'HANSGN', '2025-12-20', '07:30:00', 0),
('HAN-SGN-003', 'VN_B787_01', 'HANSGN', '2025-12-20', '09:00:00', 0),
('HAN-SGN-004', 'QH_B787_01', 'HANSGN', '2025-12-20', '12:00:00', 0),
('HAN-SGN-005', 'VJ_A321_02', 'HANSGN', '2025-12-20', '15:45:00', 0),
('HAN-SGN-006', 'VN_A321_01', 'HANSGN', '2025-12-20', '19:00:00', 0),
('HAN-SGN-007', 'VJ_A321_03', 'HANSGN', '2025-12-20', '21:30:00', 0),
('SGN-HAN-001', 'VN_A321_02', 'SGNHAN', '2025-12-20', '06:15:00', 0),
('SGN-HAN-002', 'VU_A321_01', 'SGNHAN', '2025-12-20', '10:00:00', 0),
('SGN-HAN-003', 'VN_A350_01', 'SGNHAN', '2025-12-20', '14:00:00', 0),
('SGN-DLI-001', 'VJ_A320_01', 'SGNDLI', '2025-12-24', '07:00:00', 0),
('SGN-DLI-002', 'VN_A321_01', 'SGNDLI', '2025-12-24', '16:30:00', 0),
('HAN-DLI-001', 'VJ_A321_01', 'HANDLI', '2025-12-24', '08:15:00', 0),
('HAN-PQC-001', 'VN_B787_01', 'HANPQC', '2025-12-24', '09:00:00', 0),
('SGN-PQC-001', 'VJ_A321_02', 'SGNPQC', '2025-12-24', '10:30:00', 0),
('SGN-VCS-001', 'QH_E190_01', 'SGNVCS', '2025-12-24', '06:45:00', 0),
('TET-SGN-HAN-1', 'VN_A350_01', 'SGNHAN', '2026-02-10', '05:00:00', 0),
('TET-SGN-HAN-2', 'VJ_A321_01', 'SGNHAN', '2026-02-10', '05:30:00', 0),
('TET-SGN-DAD-1', 'VN_A321_01', 'SGNDAD', '2026-02-10', '06:00:00', 0),
('TET-SGN-HUI-1', 'VJ_A320_01', 'SGNHUI', '2026-02-10', '07:00:00', 0),
('TET-SGN-UIH-1', 'QH_B787_01', 'SGNUIH', '2026-02-10', '08:00:00', 0),
('TET-SGN-BMV-1', 'VN_A321_02', 'SGNBMV', '2026-02-10', '09:00:00', 0),
('TET-SGN-HAN-3', 'VU_A321_01', 'SGNHAN', '2026-02-10', '23:00:00', 0), 
('PAST-001', 'VN_A321_01', 'HANSGN', '2024-01-01', '08:00:00', 1),
('PAST-002', 'VJ_A321_01', 'SGNDAD', '2024-06-15', '14:00:00', 1),
('PAST-003', 'QH_E190_01', 'SGNVCS', '2024-09-02', '09:00:00', 1);

insert into duongbay values
('DADVII', 'DAD', 'VII', 700),
('HANSGN', 'HAN', 'SGN', 1600),
('PQCCXR', 'PQC', 'CXR', 700),
('SGNHAN', 'SGN', 'HAN', 1600),
('SGNVII', 'SGN', 'VII', 1300),
('VIIHAN', 'VII', 'HAN', 600),
('HANVDO', 'HAN', 'VDO', 150), 
('VDOHAN', 'VDO', 'HAN', 150),
('HANDAD', 'HAN', 'DAD', 760), 
('DADHAN', 'DAD', 'HAN', 760),
('HANHUI', 'HAN', 'HUI', 660), 
('HUIHAN', 'HUI', 'HAN', 660),
('HANCXR', 'HAN', 'CXR', 1300), 
('CXRHAN', 'CXR', 'HAN', 1300),
('HANDLI', 'HAN', 'DLI', 1200),
 ('DLIHAN', 'DLI', 'HAN', 1200),
('HANUIH', 'HAN', 'UIH', 1000), 
('UIHHAN', 'UIH', 'HAN', 1000),
('HANPQC', 'HAN', 'PQC', 2000),
('PQCHAN', 'PQC', 'HAN', 2000),
('SGNDAD', 'SGN', 'DAD', 850), 
('DADSGN', 'DAD', 'SGN', 850),
('SGNHUI', 'SGN', 'HUI', 950), 
('HUISGN', 'HUI', 'SGN', 950),
('SGNCXR', 'SGN', 'CXR', 400), 
('CXRSGN', 'CXR', 'SGN', 400),
('SGNDLI', 'SGN', 'DLI', 300), 
('DLISGN', 'DLI', 'SGN', 300),
('SGNUIH', 'SGN', 'UIH', 600), 
('UIHSGN', 'UIH', 'SGN', 600),
('SGNPQC', 'SGN', 'PQC', 300), 
('PQCSGN', 'PQC', 'SGN', 300),
('SGNVCS', 'SGN', 'VCS', 250), 
('VCSSGN', 'VCS', 'SGN', 250),
('SGNBMV', 'SGN', 'BMV', 350), 
('BMVSGN', 'BMV', 'SGN', 350),
('DADCXR', 'DAD', 'CXR', 500), 
('CXRDAD', 'CXR', 'DAD', 500), 
('DLIHUI', 'DLI', 'HUI', 700), 
('HUIDLI', 'HUI', 'DLI', 700),
('VCSPQC', 'VCS', 'PQC', 400), 
('PQCVCS', 'PQC', 'VCS', 400);
 



insert into maybay values
('MB1', 'Vietnam Airlines', 100),
('MB2', 'Vietnam Airlines', 240),
('MB3', 'BAMBOO', 50),
('MB4', 'Vietjet Air', 200),
('MB5', 'Vietjet Air', 220),
('MB6', 'Jetstar Pacific', 204),
('VN_A321_01', 'Vietnam Airlines', 184),
('VN_A321_02', 'Vietnam Airlines', 184),
('VN_A350_01', 'Vietnam Airlines', 305),
('VN_B787_01', 'Vietnam Airlines', 274),
('VJ_A320_01', 'Vietjet Air', 180),
('VJ_A321_01', 'Vietjet Air', 230),
('VJ_A321_02', 'Vietjet Air', 230),
('VJ_A321_03', 'Vietjet Air', 230),
('QH_E190_01', 'BAMBOO', 110),
('QH_B787_01', 'BAMBOO', 290),
('VU_A321_01', 'Vietravel Airlines', 220);





insert into sanbay values
('DAD','DA NANG', 'Da Nang'),
('HAN', 'NOI BAI', 'Ha Noi'),
('HPH', 'CAT BI', 'Hai Phong'),
('SGN', 'TAN SON NHAT ', 'Ho Chi Minh'),
('VII', 'VINH', 'Nghe An'),
('VDO', 'VAN DON', 'Quang Ninh'),
('HUI', 'PHU BAI', 'Hue'),
('UIH', 'PHU CAT', 'Binh Dinh'),
('TBB', 'TUY HOA', 'Phu Yen'),
('CXR', 'CAM RANH', 'Khanh Hoa'), 
('DLI', 'LIEN KHUONG', 'Lam Dong'),
('BMV', 'BUON MA THUOT', 'Dak Lak'),
('PXU', 'PLEIKU', 'Gia Lai'),
('VCS', 'CON DAO', 'Ba Ria - Vung Tau'),
('PQC', 'PHU QUOC', 'Kien Giang'),
('VCA', 'CAN THO', 'Can Tho'),
('VKG', 'RACH GIA', 'Kien Giang');

insert into khachhang values
('0725356821', 'thi12', 'Mac Van Thi', 'vthi', '1993-08-24'),
('0976262341', 'vuong12', 'Pham Nhat Vuong', 'nhatvuong','2022-02-14'),
('0911222333', 'guest_nam', 'Tran Thanh Nam', 'nam.tran@gmail.com', '1995-01-01'),
('0922333444', 'guest_nu', 'Nguyen Thi My Nu', 'mynu99@yahoo.com', '1999-05-20'),
('0933444555', 'guest_rich', 'Pham Vang Bac', 'richkid@icloud.com', '1985-12-12'),
('0944555666', 'guest_student', 'Le Van Hieu Hoc', 'hieuhoc@edu.vn', '2004-09-05');

insert into nhanvien values
('0000000000', 'Le Thi A', 'ta', 1200),
('0912836521', 'Le Van A', 'levana', 1000),
('0999888777', 'Quan Tri Vien', 'staff_main', 2000),
('0988777666', 'Nhan Vien Quay', 'staff_checkin', 1000);

insert into taikhoan values
('levana', '0912836521', 'staff'),
('ta', '0000000000', 'staff'),
('thi12', '12', 'guest'),
('vuong12', '1', 'guest'),
('admin', '1', 'admin'),
('guest_nam', '123', 'guest'), 
('guest_nu', '123', 'guest'),
('guest_rich', '123', 'guest'), 
('guest_student', '123', 'guest'),
('staff_main', '0999888777', 'staff'), 
('staff_checkin', '0988777666', 'staff');


INSERT INTO ve (mcb, tenhanhkhach, sdt, soghe) VALUES 
('HAN-SGN-001', 'Le Van Khu', '0912345678', 10), 
('SGN-HAN-003', 'Le Van Khu', '0912345678', 10),
('HAN-SGN-001', 'Tran Thi Hoi', '0987654321', 11),
('SGN-HAN-003', 'Tran Thi Hoi', '0987654321', 11),
('SGN-DLI-001', 'Nguyen Van A', '0901111111', 5),
('SGN-DLI-001', 'Nguyen Van B', '0901111112', 6),
('SGN-DLI-001', 'Nguyen Van C', '0901111113', 7),
('SGN-DLI-001', 'Nguyen Van D', '0901111114', 8),
('SGN-DLI-001', 'Nguyen Van E', '0901111115', 9),
('TET-SGN-HAN-2', 'Hoang Thuy Linh', '0902222221', 1),
('TET-SGN-HAN-2', 'Den Vau', '0902222222', 2),
('TET-SGN-HAN-2', 'Son Tung MTP', '0902222223', 3),
('TET-SGN-HAN-2', 'Jack 5 Cu', '0902222224', 4),
('TET-SGN-HAN-2', 'Hieuthuhai', '0902222225', 5),
('TET-SGN-HAN-2', 'Mono', '0902222226', 6),
('TET-SGN-HAN-2', 'Toc Tien', '0902222227', 15),
('TET-SGN-HAN-2', 'Binz', '0902222228', 16),
('TET-SGN-HAN-2', 'Rhymastic', '0902222229', 17),
('TET-SGN-HAN-2', 'Justatee', '0902222230', 18),
('SGN-VCS-001', 'Khach Vip 1', '0999999991', 1),
('SGN-VCS-001', 'Khach Vip 2', '0999999992', 2),
('SGN-VCS-001', 'Khach Vip 3', '0999999993', 3),
('SGN-VCS-001', 'Khach Vip 4', '0999999994', 4),
('SGN-VCS-001', 'Ba Tan Vlog', '0988888888', 20),
('SGN-VCS-001', 'Quynh Tran JP', '0977777777', 21),
('HAN-SGN-002', 'CEO Nguyen', '0911000000', 1),
('HAN-SGN-002', 'Giam Doc Le', '0911000001', 2),
('HAN-SGN-002', 'Thu Ky Tran', '0911000002', 3);

alter table chuyenbay
add foreign key (duongbay) references duongbay(maduongbay); 

alter table chuyenbay
add foreign key (shmb) references maybay(shmb); 

alter table duongbay
add foreign key (sanbaydi) references sanbay(masanbay); 

alter table duongbay
add foreign key (sanbayden) references sanbay(masanbay); 

alter table khachhang
add foreign key (tendangnhap) references taikhoan(tendangnhap);

alter table nhanvien
add foreign key (tendangnhap) references taikhoan(tendangnhap);

alter table ve
add foreign key (mcb) references chuyenbay(machuyenbay);

