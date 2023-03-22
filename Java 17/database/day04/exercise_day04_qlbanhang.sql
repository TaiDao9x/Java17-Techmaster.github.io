-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Mar 22, 2023 at 06:18 PM
-- Server version: 10.4.27-MariaDB
-- PHP Version: 8.2.0

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `exercise_day04_qlbanhang`
--

-- --------------------------------------------------------

--
-- Table structure for table `cthd`
--

CREATE TABLE `cthd` (
  `invoice_id` int(11) DEFAULT NULL,
  `product_id` int(11) DEFAULT NULL,
  `quantity` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `cthd`
--

INSERT INTO `cthd` (`invoice_id`, `product_id`, `quantity`) VALUES
(2, 7, 1),
(3, 2, 1),
(1, 5, 2),
(4, 9, 3),
(5, 10, 1),
(5, 9, 1),
(6, 1, 1),
(7, 4, 1),
(8, 6, 1),
(9, 8, 1),
(9, 9, 1),
(10, 5, 2),
(10, 2, 1);

-- --------------------------------------------------------

--
-- Table structure for table `customers`
--

CREATE TABLE `customers` (
  `id` int(11) NOT NULL,
  `name` char(30) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `phone` char(11) DEFAULT NULL,
  `birthday` date DEFAULT NULL,
  `doanhSo` decimal(10,0) DEFAULT NULL,
  `dateRegis` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `customers`
--

INSERT INTO `customers` (`id`, `name`, `address`, `phone`, `birthday`, `doanhSo`, `dateRegis`) VALUES
(1, 'Leonel Messi', 'Bacar', '0969957697', '1987-06-24', '10997000', '2020-02-19'),
(2, 'Christiano Ronaldo', 'Real', '0987702769', '1985-02-05', '14028000', '2020-02-20'),
(3, 'Kevil De Bruyne', 'Mc', '0972664579', '1991-06-30', '6837000', '2020-02-21'),
(4, 'Casemiro', 'MU', '0912373916', '1991-03-29', '34899000', '2020-02-22'),
(5, 'Kante', 'Chelsea, England', '0972046304', '1992-02-23', '9996000', '2020-02-23');

-- --------------------------------------------------------

--
-- Table structure for table `invoices`
--

CREATE TABLE `invoices` (
  `invoice_id` int(11) NOT NULL,
  `purchase_day` date DEFAULT NULL,
  `customer_id` int(11) DEFAULT NULL,
  `staff_id` int(11) DEFAULT NULL,
  `total` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `invoices`
--

INSERT INTO `invoices` (`invoice_id`, `purchase_day`, `customer_id`, `staff_id`, `total`) VALUES
(1, '2020-09-12', 1, 2, 1398000),
(2, '2020-10-12', 3, 4, 1959000),
(3, '2020-11-12', 2, 3, 3030000),
(4, '2020-12-12', 5, 4, 897000),
(5, '2021-04-04', 3, 5, 4878000),
(6, '2021-04-14', 2, 3, 6570000),
(7, '2021-05-05', 5, 2, 9099000),
(8, '2022-05-15', 1, 3, 9599000),
(9, '2022-06-15', 4, 4, 34899000),
(10, '2023-06-15', 2, 1, 4428000);

-- --------------------------------------------------------

--
-- Table structure for table `products`
--

CREATE TABLE `products` (
  `product_id` int(30) NOT NULL,
  `product_name` char(50) DEFAULT NULL,
  `unit` char(30) DEFAULT NULL,
  `country` char(30) DEFAULT NULL,
  `unit_price` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `products`
--

INSERT INTO `products` (`product_id`, `product_name`, `unit`, `country`, `unit_price`) VALUES
(1, 'Tủ lạnh SamSung', 'Cái', 'Hàn Quốc', 6570000),
(2, 'Bếp điện Kangaroo', 'Cái', 'Trung Quốc', 3030000),
(3, 'Máy rửa bát Bosch', 'Cái', 'Đức', 30090000),
(4, 'Máy hút bụi Deboot 950', 'Cái', 'Trung Quốc', 9099000),
(5, 'Quạt cây', 'Cái', 'Trung Quốc', 699000),
(6, 'Tivi Sony', 'Cái', 'Nhật bản', 9599000),
(7, 'Đồng hồ', 'Cái', 'Trung Quốc', 1959000),
(8, 'Điện thoại iPhone', 'Cái', 'Singapore', 34600000),
(9, 'Sạc dự phòng', 'Cái', 'Trung Quốc', 299000),
(10, 'Điện thoại V Smart', 'Cái', 'Việt Nam', 4579000),
(11, 'Ô tô Vinfast', 'Cái', 'Việt Nam', 1568000000),
(12, 'Ô tô Tesla', 'Cái', 'Việt Nam', 3959000000),
(13, 'Ô tô Toyota', 'Cái', 'Nhật Bản', 695000000),
(14, 'Ô tô Mercedes', 'Cái', 'Đức', 2968000000),
(15, 'Ô tô Lambogini', 'Cái', 'Italy', 3959000000),
(16, 'Bút bi Thiên Long', 'Cái', 'Việt Nam', 10000);

-- --------------------------------------------------------

--
-- Table structure for table `staff`
--

CREATE TABLE `staff` (
  `staff_id` int(30) NOT NULL,
  `name` char(30) DEFAULT NULL,
  `dayIn` date DEFAULT NULL,
  `phone` char(30) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `staff`
--

INSERT INTO `staff` (`staff_id`, `name`, `dayIn`, `phone`) VALUES
(1, 'Nguyễn Tiến Linh', '2021-09-28', '0969955697'),
(2, 'Nguyễn Quang Hải', '2020-01-30', '0987772766'),
(3, 'Hà Đức Chinh', '2020-05-07', '0987422726'),
(4, 'Đặng Văn Lâm', '2022-05-07', '0986372724'),
(5, 'Nguyễn Văn Tới', '2019-11-22', '0986368591');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `cthd`
--
ALTER TABLE `cthd`
  ADD KEY `fk_cthd_invoice` (`invoice_id`),
  ADD KEY `fk_cthd_product` (`product_id`);

--
-- Indexes for table `customers`
--
ALTER TABLE `customers`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `invoices`
--
ALTER TABLE `invoices`
  ADD PRIMARY KEY (`invoice_id`),
  ADD KEY `fk_invoices_customers` (`customer_id`),
  ADD KEY `fk_invoices_staff` (`staff_id`);

--
-- Indexes for table `products`
--
ALTER TABLE `products`
  ADD PRIMARY KEY (`product_id`),
  ADD UNIQUE KEY `product_id` (`product_id`);

--
-- Indexes for table `staff`
--
ALTER TABLE `staff`
  ADD PRIMARY KEY (`staff_id`),
  ADD UNIQUE KEY `staff_id` (`staff_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `customers`
--
ALTER TABLE `customers`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `invoices`
--
ALTER TABLE `invoices`
  MODIFY `invoice_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT for table `products`
--
ALTER TABLE `products`
  MODIFY `product_id` int(30) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=17;

--
-- AUTO_INCREMENT for table `staff`
--
ALTER TABLE `staff`
  MODIFY `staff_id` int(30) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `cthd`
--
ALTER TABLE `cthd`
  ADD CONSTRAINT `fk_cthd_invoice` FOREIGN KEY (`invoice_id`) REFERENCES `invoices` (`invoice_id`),
  ADD CONSTRAINT `fk_cthd_product` FOREIGN KEY (`product_id`) REFERENCES `products` (`product_id`);

--
-- Constraints for table `invoices`
--
ALTER TABLE `invoices`
  ADD CONSTRAINT `fk_invoices_customers` FOREIGN KEY (`customer_id`) REFERENCES `customers` (`id`),
  ADD CONSTRAINT `fk_invoices_staff` FOREIGN KEY (`staff_id`) REFERENCES `staff` (`staff_id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
