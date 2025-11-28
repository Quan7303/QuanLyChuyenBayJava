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
('CN2', 'MB1', 'DADVII', CAST('2022-02-18' AS Date), CAST('17:00:00' AS Time), 0);
insert into duongbay values
('CXRSGN', 'CXR', 'SGN', 500),
('DADSGN', 'DAD', 'SGN', 800),
('DADVII', 'DAD', 'VII', 700),
('HANSGN', 'HAN', 'SGN', 1600),
('PQCCXR', 'PQC', 'CXR', 700),
('SGNHAN', 'SGN', 'HAN', 1600),
('SGNVII', 'SGN', 'VII', 1300),
('VIIHAN', 'VII', 'HAN', 600);
insert into khachhang values
('0725356821', 'thi12', 'Mac Van Thi', 'vthi', '1993-08-24'),
('0976262341', 'vuong12', 'Pham Nhat Vuong', 'nhatvuong','2022-02-14');

insert into maybay values
('MB1', 'Vietnam Airlines', 100),
('MB2', 'Vietnam Airlines', 240),
 ('MB3', 'BAMBOO', 50),
('MB4', 'Vietjet Air', 200),
('MB5', 'Vietjet Air', 220),
('MB6', 'Jetstar Pacific', 204);
insert into nhanvien values
('0000000000', 'Le Thi A', 'ta', 1200),
('0912836521', 'Le Van A', 'levana', 1000);
insert into sanbay values
('CXR', 'CAM RANH', 'Khanh Hoa'),
('DAD','DA NANG', 'Da Nang'),
('HAN', 'NOI BAI', 'Ha Noi'),
('HPH', 'CAT BI', 'Hai Phong'),
('HUI', 'PHU BAI', 'Hue'),
('PQC', 'PHU QUOC', 'Kien Giang'),
('SGN', 'TAN SON NHAT ', 'Ho Chi Minh'),
('VCA', 'CAN THO', 'Can Tho'),
('VII', 'VINH', 'Nghe An');
insert into taikhoan values
('antiem', '12', 'guest'),
('levana', '0912836521', 'staff'),
('ta', '0000000000', 'staff'),
('thi12', '12', 'guest'),
('vuong12', '1', 'guest'),
('admin', '1', 'admin');
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

