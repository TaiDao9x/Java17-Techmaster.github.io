-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Generation Time: Mar 04, 2023 at 01:49 PM
-- Server version: 10.4.27-MariaDB
-- PHP Version: 8.1.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `ThucTap`
--

-- --------------------------------------------------------

--
-- Table structure for table `TBLDeTai`
--

CREATE TABLE `TBLDeTai` (
  `Madt` char(10) NOT NULL,
  `Tendt` char(30) DEFAULT NULL,
  `Kinhphi` int(11) DEFAULT NULL,
  `Noithuctap` char(30) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `TBLDeTai`
--

INSERT INTO `TBLDeTai` (`Madt`, `Tendt`, `Kinhphi`, `Noithuctap`) VALUES
('Dt01', 'GIS', 100, 'Nghe An'),
('Dt02', 'ARC GIS', 500, 'Nam Dinh'),
('Dt03', 'Spatial DB', 100, 'Ha Tinh'),
('Dt04', 'MAP', 300, 'Quang Binh');

-- --------------------------------------------------------

--
-- Table structure for table `TBLGiangVien`
--

CREATE TABLE `TBLGiangVien` (
  `Magv` int(11) NOT NULL,
  `Hotengv` char(30) DEFAULT NULL,
  `Luong` decimal(5,2) DEFAULT NULL,
  `Makhoa` char(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `TBLGiangVien`
--

INSERT INTO `TBLGiangVien` (`Magv`, `Hotengv`, `Luong`, `Makhoa`) VALUES
(11, 'Thanh Binh', '700.00', 'Geo'),
(12, 'Thu Huong', '500.00', 'Math'),
(13, 'Chu Vinh', '650.00', 'Geo'),
(14, 'Le Thi Ly', '500.00', 'Bio'),
(15, 'Tran Son', '900.00', 'Math');

-- --------------------------------------------------------

--
-- Table structure for table `TBLHuongDan`
--

CREATE TABLE `TBLHuongDan` (
  `Masv` int(11) NOT NULL,
  `Madt` char(10) DEFAULT NULL,
  `Magv` int(11) DEFAULT NULL,
  `KetQua` decimal(5,2) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `TBLHuongDan`
--

INSERT INTO `TBLHuongDan` (`Masv`, `Madt`, `Magv`, `KetQua`) VALUES
(1, 'Dt01', 13, '8.00'),
(2, 'Dt03', 14, '0.00'),
(3, 'Dt03', 12, '10.00'),
(5, 'Dt04', 14, '7.00'),
(6, 'Dt01', 13, NULL),
(7, 'Dt04', 11, '10.00'),
(8, 'Dt03', 15, '6.00');

-- --------------------------------------------------------

--
-- Table structure for table `TBLKhoa`
--

CREATE TABLE `TBLKhoa` (
  `Makhoa` char(10) NOT NULL,
  `Tenkhoa` char(30) DEFAULT NULL,
  `Dienthoai` char(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `TBLKhoa`
--

INSERT INTO `TBLKhoa` (`Makhoa`, `Tenkhoa`, `Dienthoai`) VALUES
('Bio', 'Cong nghe Sinh hoc', '3855412'),
('Geo', 'Dia ly va QLTN', '3855413'),
('Math', 'Toan', '3855411');

-- --------------------------------------------------------

--
-- Table structure for table `TBLSinhVien`
--

CREATE TABLE `TBLSinhVien` (
  `Masv` int(11) NOT NULL,
  `Hotensv` char(40) DEFAULT NULL,
  `Makhoa` char(10) DEFAULT NULL,
  `Namsinh` int(11) DEFAULT NULL,
  `Quequan` char(30) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `TBLSinhVien`
--

INSERT INTO `TBLSinhVien` (`Masv`, `Hotensv`, `Makhoa`, `Namsinh`, `Quequan`) VALUES
(1, 'Le Van Son', 'Bio', 1990, 'Nghe An'),
(2, 'Nguyen Thi Mai', 'Geo', 1990, 'Thanh Hoa'),
(3, 'Bui Xuan Duc', 'Math', 1992, 'Ha Noi'),
(4, 'Nguyen Van Tung', 'Bio', NULL, 'Ha Tinh'),
(5, 'Le Khanh Linh', 'Bio', 1989, 'Ha Nam'),
(6, 'Tran Khac Trong', 'Geo', 1991, 'Thanh Hoa'),
(7, 'Le Thi Van', 'Math', NULL, 'null'),
(8, 'Hoang Van Duc', 'Bio', 1992, 'Nghe An');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `TBLDeTai`
--
ALTER TABLE `TBLDeTai`
  ADD PRIMARY KEY (`Madt`);

--
-- Indexes for table `TBLGiangVien`
--
ALTER TABLE `TBLGiangVien`
  ADD PRIMARY KEY (`Magv`),
  ADD KEY `fk_gv_khoa` (`Makhoa`);

--
-- Indexes for table `TBLHuongDan`
--
ALTER TABLE `TBLHuongDan`
  ADD PRIMARY KEY (`Masv`),
  ADD KEY `fk_huongdan_detai` (`Madt`),
  ADD KEY `fk_huongdan_gv` (`Magv`);

--
-- Indexes for table `TBLKhoa`
--
ALTER TABLE `TBLKhoa`
  ADD PRIMARY KEY (`Makhoa`);

--
-- Indexes for table `TBLSinhVien`
--
ALTER TABLE `TBLSinhVien`
  ADD PRIMARY KEY (`Masv`),
  ADD KEY `fk_sv_khoa` (`Makhoa`);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `TBLGiangVien`
--
ALTER TABLE `TBLGiangVien`
  ADD CONSTRAINT `fk_gv_khoa` FOREIGN KEY (`Makhoa`) REFERENCES `TBLKhoa` (`Makhoa`);

--
-- Constraints for table `TBLHuongDan`
--
ALTER TABLE `TBLHuongDan`
  ADD CONSTRAINT `fk_huongdan_detai` FOREIGN KEY (`Madt`) REFERENCES `TBLDeTai` (`Madt`),
  ADD CONSTRAINT `fk_huongdan_gv` FOREIGN KEY (`Magv`) REFERENCES `TBLGiangVien` (`Magv`);

--
-- Constraints for table `TBLSinhVien`
--
ALTER TABLE `TBLSinhVien`
  ADD CONSTRAINT `fk_sv_khoa` FOREIGN KEY (`Makhoa`) REFERENCES `TBLKhoa` (`Makhoa`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
