-- Tạo Database
CREATE DATABASE K22cnt3_DinhCongDinh_2210900095_Project3_db;
USE K22cnt3_DinhCongDinh_2210900095_Project3_db;

-- Bảng Công dân
CREATE TABLE CongDan (
    CongDanID       INT PRIMARY KEY AUTO_INCREMENT,
    HoTen           VARCHAR(100) CHARACTER SET UTF8MB4 NOT NULL,
    NgaySinh        DATE NOT NULL,
    GioiTinh        VARCHAR(10) CHARACTER SET UTF8MB4 NOT NULL,
    DanToc          VARCHAR(50) CHARACTER SET UTF8MB4,
    TonGiao         VARCHAR(50) CHARACTER SET UTF8MB4,
    QueQuan         VARCHAR(255) CHARACTER SET UTF8MB4,
    DiaChiThuongTru VARCHAR(255) CHARACTER SET UTF8MB4,
    DiaChiTamTru    VARCHAR(255) CHARACTER SET UTF8MB4,
    SoDienThoai     VARCHAR(15) CHARACTER SET UTF8MB4 UNIQUE,
    Email           VARCHAR(100) CHARACTER SET UTF8MB4 UNIQUE,
    NgayCap         DATE NOT NULL,
    NoiCap          VARCHAR(255) CHARACTER SET UTF8MB4 NOT NULL
);

-- Bảng Căn cước công dân
CREATE TABLE CanCuocCongDan (
    CCCD_ID        CHAR(12) PRIMARY KEY,
    CongDanID      INT UNIQUE,
    NgayCap        DATE NOT NULL,
    NgayHetHan     DATE NOT NULL,
    NoiCap         VARCHAR(255) CHARACTER SET UTF8MB4 NOT NULL,
    TrangThai      VARCHAR(20) CHARACTER SET UTF8MB4 NOT NULL DEFAULT 'Có hiệu lực',
    FOREIGN KEY (CongDanID) REFERENCES CongDan(CongDanID) ON DELETE CASCADE
);

-- Bảng Quan hệ gia đình
CREATE TABLE QuanHeGiaDinh (
    ID               INT PRIMARY KEY AUTO_INCREMENT,
    CongDanID        INT NOT NULL,
    NguoiThanID      INT NOT NULL,
    MoiQuanHe        VARCHAR(20) CHARACTER SET UTF8MB4 NOT NULL,
    FOREIGN KEY (CongDanID) REFERENCES CongDan(CongDanID) ON DELETE NO ACTION,
    FOREIGN KEY (NguoiThanID) REFERENCES CongDan(CongDanID) ON DELETE NO ACTION
);

-- Bảng Hộ khẩu
CREATE TABLE HoKhau (
    HoKhauID    INT PRIMARY KEY AUTO_INCREMENT,
    MaHoKhau    VARCHAR(20) CHARACTER SET UTF8MB4 UNIQUE NOT NULL,
    ChuHoID     INT NOT NULL,
    DiaChi      VARCHAR(255) CHARACTER SET UTF8MB4 NOT NULL,
    FOREIGN KEY (ChuHoID) REFERENCES CongDan(CongDanID) ON DELETE CASCADE
);

-- Bảng Thành viên hộ khẩu
CREATE TABLE ThanhVienHoKhau (
    ID          INT PRIMARY KEY AUTO_INCREMENT,
    HoKhauID    INT NOT NULL,
    CongDanID   INT NOT NULL,
    VaiTro      VARCHAR(20) CHARACTER SET UTF8MB4 NOT NULL,
    FOREIGN KEY (HoKhauID) REFERENCES HoKhau(HoKhauID) ON DELETE CASCADE,
    FOREIGN KEY (CongDanID) REFERENCES CongDan(CongDanID) ON DELETE NO ACTION
);

-- Bảng Lịch sử cấp CCCD
CREATE TABLE LichSuCapCCCD (
    ID           INT PRIMARY KEY AUTO_INCREMENT,
    CCCD_ID      CHAR(12),
    NgayCap      DATE NOT NULL,
    LyDoCap      VARCHAR(255) CHARACTER SET UTF8MB4 NOT NULL,
    FOREIGN KEY (CCCD_ID) REFERENCES CanCuocCongDan(CCCD_ID) ON DELETE CASCADE
);

-- Bảng Danh sách công dân bị cấm xuất cảnh
CREATE TABLE DoiTuongBiCam (
    ID            INT PRIMARY KEY AUTO_INCREMENT,
    CongDanID     INT NOT NULL,
    LyDoCam       VARCHAR(255) CHARACTER SET UTF8MB4 NOT NULL,
    ThoiHanCam    DATE NOT NULL,
    FOREIGN KEY (CongDanID) REFERENCES CongDan(CongDanID) ON DELETE CASCADE
);

-- Bảng Lịch sử di chuyển
CREATE TABLE LichSuDiChuyen (
    ID           INT PRIMARY KEY AUTO_INCREMENT,
    CongDanID    INT NOT NULL,
    NoiDi        VARCHAR(255) CHARACTER SET UTF8MB4 NOT NULL,
    NoiDen       VARCHAR(255) CHARACTER SET UTF8MB4 NOT NULL,
    NgayDi       DATE NOT NULL,
    NgayDen      DATE,
    FOREIGN KEY (CongDanID) REFERENCES CongDan(CongDanID) ON DELETE CASCADE
);

-- Thêm dữ liệu vào bảng Công dân
INSERT INTO CongDan (HoTen, NgaySinh, GioiTinh, DanToc, TonGiao, QueQuan, DiaChiThuongTru, DiaChiTamTru, SoDienThoai, Email, NgayCap, NoiCap) 
VALUES 
(N'Nguyen Van A', '1990-01-01', N'Nam', N'Kinh', N'Không', N'Hà Nội', N'Hà Nội', N'Hồ Chí Minh', '0912345678', 'a@gmail.com', '2020-01-01', N'Hà Nội'),
(N'Tran Thi B', '1992-02-02', N'Nữ', N'Kinh', N'Không', N'Hải Phòng', N'Hải Phòng', N'Hà Nội', '0923456789', 'b@gmail.com', '2021-02-02', N'Hải Phòng');

-- Thêm dữ liệu vào bảng Căn cước công dân
INSERT INTO CanCuocCongDan (CCCD_ID, CongDanID, NgayCap, NgayHetHan, NoiCap, TrangThai) 
VALUES 
('001122334455', 1, '2020-01-01', '2030-01-01', N'Hà Nội', N'Có hiệu lực'),
('005566778899', 2, '2021-02-02', '2031-02-02', N'Hải Phòng', N'Có hiệu lực');
