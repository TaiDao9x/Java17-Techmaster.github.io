-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Máy chủ: 127.0.0.1
-- Thời gian đã tạo: Th3 30, 2023 lúc 06:00 AM
-- Phiên bản máy phục vụ: 10.4.27-MariaDB
-- Phiên bản PHP: 8.2.0

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Cơ sở dữ liệu: `store`
--

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `carts`
--

CREATE TABLE `carts` (
  `id` int(11) NOT NULL,
  `user_id` int(11) DEFAULT NULL,
  `status_id` int(11) DEFAULT NULL,
  `created_at` timestamp NULL DEFAULT NULL,
  `updated_at` timestamp NULL DEFAULT NULL,
  `deleted_at` timestamp NULL DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `carts`
--

INSERT INTO `carts` (`id`, `user_id`, `status_id`, `created_at`, `updated_at`, `deleted_at`) VALUES
(1, 2, 1, '2022-10-26 14:17:09', '2022-10-26 14:20:09', NULL),
(2, 1, 1, '2022-12-22 14:17:09', '2022-12-22 14:25:00', NULL),
(3, 3, 1, '2023-02-14 14:17:09', '2023-02-14 14:31:09', NULL),
(4, 5, 3, '2023-02-14 14:21:47', NULL, NULL),
(5, 6, 2, '2023-02-05 14:26:57', NULL, '2023-02-05 14:27:57'),
(6, 4, 3, '2022-12-30 14:21:04', NULL, NULL),
(7, 5, 1, NULL, '2023-02-14 14:45:28', NULL),
(8, 4, 1, NULL, '2022-12-30 14:39:25', NULL),
(10, 6, 1, '2023-02-05 15:28:04', '2023-02-05 15:39:25', NULL);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `carts_detail`
--

CREATE TABLE `carts_detail` (
  `id` int(11) NOT NULL,
  `cart_id` int(11) DEFAULT NULL,
  `product_id` int(11) DEFAULT NULL,
  `quantity` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `carts_detail`
--

INSERT INTO `carts_detail` (`id`, `cart_id`, `product_id`, `quantity`) VALUES
(1, 1, 23, 12),
(2, 3, 12, 23),
(3, 4, 1, 50),
(4, 2, 34, 3),
(5, 6, 50, 1);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `categories`
--

CREATE TABLE `categories` (
  `id` int(11) NOT NULL,
  `code` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `categories`
--

INSERT INTO `categories` (`id`, `code`, `name`) VALUES
(1, 'DT', 'Điện thoại'),
(2, 'LT', 'Laptop'),
(3, 'MTB', 'Máy tinh bảng'),
(4, 'TBTM', 'Thiết bị thông minh'),
(5, 'PC', 'PC -linh kiện'),
(6, 'PK', 'Phụ kiện'),
(7, 'HGD', 'Hàng gia dụng'),
(8, 'ST', 'Sim & Thẻ'),
(9, 'KM', 'Khuyến mãi');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `comments`
--

CREATE TABLE `comments` (
  `id` int(11) NOT NULL,
  `user_id` int(11) DEFAULT NULL,
  `status_id` int(11) DEFAULT NULL,
  `content` varchar(255) DEFAULT NULL,
  `product_id` int(11) DEFAULT NULL,
  `created_at` timestamp NULL DEFAULT NULL,
  `updated_at` timestamp NULL DEFAULT NULL,
  `deleted_at` timestamp NULL DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `comments`
--

INSERT INTO `comments` (`id`, `user_id`, `status_id`, `content`, `product_id`, `created_at`, `updated_at`, `deleted_at`) VALUES
(1, 3, 1, 'Sản phẩm dùng tốt mượt mà, chụp ảnh đẹp đáng để mua', 23, '2023-03-13 14:29:28', '2023-03-13 14:30:28', NULL),
(2, 4, 1, 'Sản phẩm tuyệt vời', 2, '2023-01-01 14:29:28', '2023-01-01 14:29:28', NULL),
(3, 5, 3, 'Sản phẩm tốt, pin trâu, đã mua fpt shop Phổ Yên', 20, '2022-10-01 14:32:21', NULL, NULL),
(4, 5, 3, 'Mọi thứ trên cả toẹt vời!', 30, '2022-10-18 14:33:49', NULL, NULL),
(5, 6, 2, 'Mình được tư vấn, dùng thử rồi mới chọn, thật xứng đáng với tiền bỏ ra', 40, '2023-03-26 14:35:19', NULL, '2023-03-26 14:37:19'),
(6, 6, 2, 'nào giảm xuống 26 em ráng mua,chứ giá 28 vẫn cao quá', 44, '2023-03-19 14:35:19', NULL, '2023-03-19 14:37:19'),
(7, 2, 3, 'Xài và thấy ổn , chất lượng đỉnh', 50, '2022-11-01 14:34:40', NULL, NULL),
(8, 1, 1, 'Thủ tục mua hàng trả góp cực nhanh, shop hỗ trợ rất nhiệt tình', 33, '2022-12-04 14:29:28', '2022-12-04 14:29:28', NULL),
(9, 1, 1, 'Siêu bút S-Pen – ghi chú, phác thảo và hơn thế nữa trong quá trình làm việc', 44, '2023-02-14 14:29:28', '2023-02-14 14:29:28', NULL),
(10, 2, 1, 'Mua đợt giảm 1,1tr đến nay chưa nhận được voucher giảm 600k, vào site https://uudai.goevo.vn/voucher để lấy voucher thì báo thẻ cứng chưa nhận mặc dù đã nhận và kích hoạt từ lâu. Gọi chăm sóc khách hàng FPT, TP Bank thì đẩy qua đẩy lại. Còn số tiền 500k h', 5, '2023-01-22 14:29:28', '2023-01-22 14:29:28', NULL),
(11, 1, 1, 'Máy có kiểu dáng hiện đại, sang trọng, cấu hình siêu mạnh. Tuy nhiên shop đông khách mà hơi ít nhân viên, nên muốn hỏi kỹ hơn cũng khó, shop nên cải thiện trường hợp này shop nha.', 6, '2023-03-21 14:29:28', '2023-03-21 14:29:28', NULL),
(12, 3, 1, 'Sản phẩm đẹp, thiết kế cao cấp, cấu hình mạnh và thời lượng pin tốt, chỉ cần shop nâng cấp hệ thống thanh toán cho đỡ gặp lỗi nữa là tuyệt vời rồi.', 15, '2023-03-24 14:29:28', '2023-03-24 14:29:28', NULL),
(13, 4, 2, 'Tôi muốn mua ĐT iPhone 14 Plus 280GB mới tinh chưa ai dùng rồi, thì có hàng luôn không.?', 18, '2023-03-10 14:29:28', '2023-03-10 14:29:28', NULL),
(14, 5, 1, 'Mình có con 11prm muốn đổi lên 14prm không biết bên fpt có thu cũ đổi mới không ạ\r\n', 23, '2023-03-26 14:29:28', '2023-03-26 14:29:28', NULL),
(15, 5, 3, 'Sản phẩm tốt, pin trâu, đã mua fpt shop Phổ Yên', 20, NULL, '2022-10-01 14:32:54', NULL),
(16, 5, 3, 'Mọi thứ trên cả toẹt vời!', 30, NULL, '2022-10-18 14:40:49', NULL),
(17, 2, 3, 'Xài và thấy ổn , chất lượng đỉnh', 50, NULL, '2022-11-01 14:41:40', NULL);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `manufactures`
--

CREATE TABLE `manufactures` (
  `id` int(11) NOT NULL,
  `code` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `manufactures`
--

INSERT INTO `manufactures` (`id`, `code`, `name`) VALUES
(1, 'TQ', 'Trung Quốc'),
(2, 'VN', 'Việt Nam'),
(3, 'USA', 'Mỹ'),
(4, 'IND', 'Ấn Độ'),
(5, 'TW', 'Đài Loan'),
(6, 'GE', 'Đức'),
(7, 'KO', 'Hàn Quốc'),
(8, 'JA', 'Nhật Bản'),
(11, 'PL', 'Phần Lan');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `orders`
--

CREATE TABLE `orders` (
  `id` int(11) NOT NULL,
  `user_id` int(11) DEFAULT NULL,
  `status_id` int(11) DEFAULT NULL,
  `user_name` varchar(255) NOT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `total` double NOT NULL,
  `created_at` timestamp NULL DEFAULT NULL,
  `updated_at` timestamp NULL DEFAULT NULL,
  `deleted_at` timestamp NULL DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `orders`
--

INSERT INTO `orders` (`id`, `user_id`, `status_id`, `user_name`, `phone`, `address`, `total`, `created_at`, `updated_at`, `deleted_at`) VALUES
(1, 3, 1, 'Vũ Hạ Băng', '0998456321\r\n', 'Vân Đồn - Hạ Long', 55800000, '2023-02-12 14:38:23', '2023-02-12 14:38:23', NULL),
(2, 4, 1, 'tuấn anh', '0954136478', 'Mỹ Đình - Cầu Giấy - Hà Nội', 3950000, '2023-03-07 14:38:23', '2023-03-07 14:38:23', NULL),
(3, 5, 1, 'Thanh Lam', '0365478921', '13 Dịch Vọng Hậu, Cầu Giấy - Hà Nội', 63560000, '2023-02-01 14:38:23', '2023-02-01 14:38:23', NULL),
(4, 6, 2, '', '064651765', '322 Mỹ Đình, Nhân Mỹ, Cầu Giấy - Hà Nội', 0, '2023-03-26 14:39:09', NULL, '2023-03-26 14:40:09'),
(5, 4, 2, '', '0954136478', 'Mỹ Đình - Cầu Giấy - Hà Nội', 0, '2023-03-05 14:39:56', NULL, '2023-03-05 14:41:56'),
(6, 5, 2, '', '0365478921\r\n', '10 Dịch Vọng Hậu, Cầu Giấy - Hà Nội', 0, '2023-03-16 14:39:56', NULL, '2023-03-16 14:45:56'),
(8, 6, 2, '', '0958421641', 'Yên Hòa Hà nội', 0, '2023-03-24 14:40:15', NULL, '2023-03-24 14:45:15'),
(10, 4, 1, 'Mạnh Hùng', '0954214860', 'Mỹ Đình - Cầu Giấy - Hà Nội', 76990000, '2023-03-05 14:39:56', '2023-03-05 14:42:53', NULL),
(11, 5, 1, 'Thanh Hằng', '0365478921\r\n', '10 Dịch Vọng Hậu, Cầu Giấy - Hà Nội', 68970000, '2023-03-16 14:39:56', '2023-03-16 14:41:50', NULL);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `orders_detail`
--

CREATE TABLE `orders_detail` (
  `id` int(11) NOT NULL,
  `orders_id` int(11) DEFAULT NULL,
  `product_id` int(11) DEFAULT NULL,
  `code_product` varchar(255) NOT NULL,
  `image` text NOT NULL,
  `quantity` int(11) NOT NULL,
  `price` double NOT NULL,
  `note` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `orders_detail`
--

INSERT INTO `orders_detail` (`id`, `orders_id`, `product_id`, `code_product`, `image`, `quantity`, `price`, `note`) VALUES
(1, 3, 4, 'No.00808460', 'sad0565asdsadsa', 4, 15890000, ''),
(2, 1, 9, 'No.00797677', 'xcdfv065fsdaws', 20, 2790000, ''),
(3, 10, 36, 'No.00857495', 'rytuh521gdfg', 1, 76990000, ''),
(4, 2, 45, 'No.00773444', 'dsds0f65sd4fada', 5, 790000, ''),
(5, 11, 20, 'No.00852562', 'dsf4sdf7sdfsd', 3, 22990000, '');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `points`
--

CREATE TABLE `points` (
  `id` int(11) NOT NULL,
  `user_id` int(11) DEFAULT NULL,
  `discount` int(11) DEFAULT NULL,
  `start_at` datetime DEFAULT NULL,
  `end_at` datetime DEFAULT NULL,
  `created_at` timestamp NULL DEFAULT NULL,
  `updated_at` timestamp NULL DEFAULT NULL,
  `deleted_at` timestamp NULL DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `points`
--

INSERT INTO `points` (`id`, `user_id`, `discount`, `start_at`, `end_at`, `created_at`, `updated_at`, `deleted_at`) VALUES
(1, 3, 10, '2023-03-01 00:00:00', '2023-03-31 00:00:00', '2023-02-28 17:00:00', '2023-02-28 17:00:00', NULL),
(2, 6, 10, '2023-03-27 00:00:00', '2023-05-30 00:00:00', '2023-03-26 17:00:00', '2023-03-26 17:00:00', NULL),
(3, 5, 5, '2023-02-28 00:00:00', '2023-03-15 00:00:00', '2023-02-26 17:00:00', NULL, '2023-03-14 17:00:00'),
(4, 4, 20, '2023-02-20 00:00:00', '2023-04-15 00:00:00', '2023-02-19 17:00:00', '2023-04-14 17:00:00', NULL);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `products`
--

CREATE TABLE `products` (
  `id` int(11) NOT NULL,
  `code` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `category_id` int(11) DEFAULT NULL,
  `manufacture_id` int(11) DEFAULT NULL,
  `trademark_id` int(11) DEFAULT NULL,
  `image` varchar(255) DEFAULT NULL,
  `price` double DEFAULT NULL,
  `specification` text DEFAULT NULL,
  `created_at` timestamp NULL DEFAULT NULL,
  `updated_at` timestamp NULL DEFAULT NULL,
  `deleted_at` timestamp NULL DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `products`
--

INSERT INTO `products` (`id`, `code`, `name`, `category_id`, `manufacture_id`, `trademark_id`, `image`, `price`, `specification`, `created_at`, `updated_at`, `deleted_at`) VALUES
(1, 'No.00856571', 'Samsung Galaxy S23 Ultra 5G 256GB', 1, 7, 2, 'euyoy12f0h', 26990000, '\r\n6.8 inch, Dynamic AMOLED 2X, QHD+, 1440 x 3088 Pixels\r\n200.0 MP + 12.0 MP + 10.0 MP + 10.0 MP\r\n12.0 MP\r\nSnapdragon 8 Gen 2\r\n256 GB', '2022-07-18 16:12:08', NULL, NULL),
(2, 'No.00720580', 'iPhone 11 64GB', 1, 3, 1, '54jhfhsdfs2df', 10999000, '6.1 inch, IPS LCD, Liquid Retina HD, 828 x 1792 Pixels\r\n12.0 MP + 12.0 MP\r\n12.0 MP\r\nApple A13 Bionic\r\n64 GB', '2022-07-18 16:12:08', NULL, NULL),
(3, 'No.00822693', 'Vivo T1x 4GB-64GB', 1, 1, 4, 'mghj21dsf54', 4190000, 'Chính: 6.58 inch, Chính: LCD, FHD+, 2408 x 1080 Pixels\r\n50.0 MP + 2.0 MP + 2.0 MP\r\n8.0 MP\r\nSnapdragon 680\r\n64 GB', '2022-07-18 16:12:08', '2022-12-20 16:30:32', NULL),
(4, 'No.00808460', 'Laptop Asus TUF Gaming FX506LHB-HN188W i5 10300H/8GB/512GB/15.6\"FHD/GTX 1650 4GB/Win11 ', 2, 5, 6, 'dfg5454asd5', 15890000, '15.6 inch, 1920 x 1080 Pixels, IPS, 144 Hz, Anti-glare LED-backlit\r\nIntel, Core i5, 10300H\r\n8 GB (1 thanh 8 GB), DDR4, 2933 MHz\r\nSSD 512 GB\r\nNVIDIA GeForce GTX 1650 4GB; Intel UHD Graphics', '2022-07-18 16:12:08', NULL, NULL),
(5, '00836251', 'Laptop MSI Gaming GF63 Thin 11SC-1090VN i5 11400H/8GB/512GB/15.6\"FHD/GeForce GTX 1650 4GB/Win11', 2, 3, 9, 'fdg5dfg48er', 18990000, '15.6 inch, 1920 x 1080 Pixels, IPS, 144 Hz, IPS FHD\r\nIntel, Core i5, 11400H\r\n8 GB (1 thanh 8 GB), DDR4, 3200 MHz\r\nSSD 512 GB\r\nNVIDIA GeForce GTX 1650 4GB', '2022-07-18 16:12:08', '2022-12-20 16:30:32', NULL),
(6, 'No.00857687', 'Laptop Lenovo Gaming Legion 5 15IAH7H i7 12700H/16GB/512GB/15.6\"WQHD/RTX 3060 6GB/Win11', 2, 1, 7, 'ret51ndfgsd', 35990000, '15.6 inch, 2560 x 1440 Pixels, IPS, 165 Hz, 300 nits, IPS LCD LED Backlit, True Tone\r\nIntel, Core i7, 12700H\r\n16 GB (2 thanh 8 GB), DDR5, 4800 MHz\r\nSSD 512 GB\r\nNVIDIA GeForce RTX 3060 6GB; Intel Iris Xe Graphics', '2022-07-18 16:12:08', NULL, NULL),
(7, '00820325', 'Samsung Galaxy Tab S6 Lite 2022', 1, 7, 2, 'fdg21g5fh5s', 6990000, '10.4 inch, TFT LCD, FHD, 1200 x 2000 Pixels\r\n8.0 MP\r\n5.0 MP\r\nSnapdragon 720G\r\n64 GB', '2022-07-18 16:12:08', NULL, NULL),
(8, 'No.00773208', 'iPad mini 6 2021 8.3 inch WiFi 64GB', 4, 1, 3, 'dfg51845wrttu', 12690000, '\r\n8.3 inch, IPS LCD, Liquid Retina HD, 2048 x 1536 Pixels\r\n12.0 MP\r\n12.0 MP\r\nApple A15 Bionic\r\n64 GB\r\nXem chi tiết thông số kỹ thuật', '2022-07-18 16:12:08', '2022-12-20 16:30:32', NULL),
(9, 'No.00797677', 'Máy lọc không khí Xiaomi Mi AP 4 Lite ', 4, 1, 3, 'fghg21d4512fgd', 2790000, 'Phạm vi lọc hiệu quả	43 m2\r\nCông suất	33 W\r\nĐộ ồn	33 - 61 dB\r\nLượng gió thổi ra	360 m3/h', '2022-07-18 16:12:08', NULL, NULL),
(10, 'No.00797668', 'Robot hút bụi Xiaomi Mi Vacuum Mop 2 Lite', 4, 1, 3, 'uy5k1jh2hfg', 3390000, 'Độ ồn	72 dB\r\nDung tích chứa bụi	Hộp bụi: 0.45 lít\r\nBộ lọc bụi cho máy	HEPA\r\nCông nghệ hút bụi	Động cơ không chổi than Nidec\r\nDung lượng pin	2600 mAh', '2022-07-18 16:12:08', '2023-03-13 16:26:31', NULL),
(11, 'No.00833057', 'Apple Watch Ultra GPS + Cellular 49mm Titanium Alpine Loop Small', 4, 3, 1, 'ưd5a1sd5fsdfsd', 19990000, 'Màn hình	1.92 inch, LTPO OLED, 502 x 410 Pixels\r\nChất liệu	Viền máy: Titanium\r\nHệ điều hành	watchOS\r\nHệ điều hành tương thích	iOS\r\nThời gian sử dụng pin	36 giờ', '2022-07-18 16:12:08', NULL, NULL),
(12, 'No.00832909', 'iPhone 14 Pro Max 128GB', 1, 5, 1, 'g654gd1f2sdf', 27990000, 'Màn hình	6.7 inch, Super Retina XDR, 2796 x 1290 Pixels\r\nCamera sau	48.0 MP + 12.0 MP\r\nCamera Selfie	12.0 MP\r\nBộ nhớ trong	128 GB\r\nCPU	Apple A16 Bionic\r\nDung lượng pin	29 Giờ\r\nThẻ sim	1 - 1 eSIM, 1 Nano SIM\r\nHệ điều hành	iOS 16', '2022-07-18 16:12:08', NULL, NULL),
(13, 'No.00800302', 'iPhone 13 128GB', 1, 7, 1, '5w6as1ds7f', 17990000, 'Màn hình	6.1 inch, OLED, Super Retina XDR, 2532 x 1170 Pixels\r\nCamera sau	12.0 MP + 12.0 MP\r\nCamera Selfie	12.0 MP\r\nRAM	4 GB\r\nBộ nhớ trong	128 GB\r\nCPU	Apple A15 Bionic\r\nGPU	Apple GPU 5 nhân\r\nDung lượng pin	3225 mAh\r\nThẻ sim	1 - 1 eSIM, 1 Nano SIM\r\nHệ điều hành	iOS 15', '2022-07-18 16:12:08', '2022-12-20 16:30:32', NULL),
(14, 'No.00800295', 'iPhone SE 2022 64GB ', 1, 3, 1, '2sd1frg62gf', 11490000, 'Màn hình	4.7 inch, HD, 1334 x 750 Pixels\r\nRAM	4 GB\r\nBộ nhớ trong	64 GB\r\nCPU	Apple A15 Bionic\r\nDung lượng pin	15 Giờ\r\nThẻ sim	1 - 1 eSIM, 1 Nano SIM\r\nHệ điều hành	iOS 15', '2022-07-18 16:12:08', '2022-12-20 16:30:32', NULL),
(15, 'No.00842484', 'Nokia 5710 XpressAudio', 1, 11, 5, 'fdg5fdh5d4sd', 1790000, 'Màn hình	2.4 inch, TFT LCD, QVGA, 320 x 240 Pixels\r\nCamera sau	0.3 MP\r\nRAM	48 MB\r\nBộ nhớ trong	128 MB\r\nCPU	Unisoc T107\r\nDung lượng pin	1450 mAh\r\nThẻ sim	2 - 2 Nano SIM\r\nHệ điều hành	Nokia S30+', '2022-07-18 16:12:08', NULL, NULL),
(16, 'No.00771450', 'Nokia C30 3GB-32GB', 1, 11, 5, 'fdfg51fd2aw', 3190000, 'Màn hình	6.82 inch, IPS LCD, HD+, 720 x 1600 Pixels\r\nCamera sau	13.0 MP + 2.0 MP\r\nCamera Selfie	5.0 MP\r\nRAM	3 GB\r\nBộ nhớ trong	32 GB\r\nCPU	Spreadtrum SC9863A\r\nDung lượng pin	6000 mAh\r\nThẻ sim	2 - 2 Nano SIM\r\nHệ điều hành	Android 11', '2022-07-18 16:12:08', NULL, NULL),
(17, 'No.00824364', 'Samsung Galaxy Z Fold4 5G 256GB', 1, 7, 2, 'fdg23fd1hfg86n5f', 35990000, 'Màn hình	Chính: 7.6 inch, Phụ: 6.2 inch, Dynamic AMOLED 2X, WXGA+, 1768 x 2208 Pixels\r\nCamera sau	50.0 MP + 12.0 MP + 10.0 MP\r\nCamera Selfie	10.0 MP\r\nRAM	12 GB\r\nBộ nhớ trong	256 GB\r\nCPU	Snapdragon 8+ Gen 1\r\nDung lượng pin	4400 mAh\r\nThẻ sim	2 - 1 eSIM, 1 Nano SIM\r\nHệ điều hành	Android 12', '2022-07-18 16:12:08', NULL, NULL),
(18, 'No.00833471', 'Samsung Galaxy Z Flip4 5G Flex Mode Collection', 1, 7, 2, 'dfgdfg32d1fg6dfg', 18990000, 'Màn hình	Chính: 6.7 inch, Phụ: 1.9 inch, Dynamic AMOLED, FHD+, 1080 x 2636 Pixels\r\nCamera sau	12.0 MP + 12.0 MP\r\nCamera Selfie	10.0 MP\r\nRAM	8 GB\r\nBộ nhớ trong	256 GB\r\nCPU	Snapdragon 8+ Gen 1\r\nDung lượng pin	3700 mAh\r\nThẻ sim	2 - 1 eSIM, 1 Nano SIM\r\nHệ điều hành	Android 12', '2022-07-18 16:12:08', NULL, NULL),
(19, 'No.00825067', 'Asus ROG Phone 6 12GB-256GB', 1, 5, 6, 'fgh231gdf52g', 17990000, 'Màn hình	6.78 inch, AMOLED, FHD+, 2448 x 1080 Pixels\r\nCamera sau	50.0 MP + 13.0 MP + 5.0 MP\r\nCamera Selfie	12.0 MP\r\nRAM	12 GB\r\nBộ nhớ trong	256 GB\r\nCPU	Snapdragon 8+ Gen 1\r\nGPU	Adreno 730\r\nDung lượng pin	6000 mAh\r\nThẻ sim	2 - 2 Nano SIM\r\nHệ điều hành	Android 12', '2022-07-18 16:12:08', '2023-03-13 16:26:31', NULL),
(20, 'No.00852562', 'Asus ROG 6 DIABLO 16GB-512GB', 1, 5, 6, 'fgh321g45df', 22990000, 'Màn hình	6.78 inch, AMOLED, FHD+, 2448 x 1080 Pixels\r\nCamera sau	50.0 MP + 13.0 MP + 5.0 MP\r\nCamera Selfie	12.0 MP\r\nRAM	16 GB\r\nBộ nhớ trong	512 GB\r\nCPU	Snapdragon 8+ Gen 1\r\nGPU	Adreno 730\r\nDung lượng pin	6000 mAh\r\nThẻ sim	2 - 2 Nano SIM\r\nHệ điều hành	Android 12', '2022-07-18 16:12:08', '2022-12-20 16:30:32', NULL),
(21, 'No.00796679', 'Xiaomi Redmi Note 11S 8GB - 128GB', 1, 1, 3, '21ghd23fg0s', 5490000, 'Màn hình	6.43 inch, AMOLED, FHD+, 1080 x 2400 Pixels\r\nCamera sau	108.0 MP + 8.0 MP + 2.0 MP + 2.0 MP\r\nCamera Selfie	16.0 MP\r\nRAM	8 GB\r\nBộ nhớ trong	128 GB\r\nCPU	MediaTek Helio G96\r\nGPU	Mali-G57 MC2\r\nDung lượng pin	5000 mAh\r\nThẻ sim	2 - 2 Nano SIM\r\nHệ điều hành	Android 11', '2022-07-18 16:12:08', NULL, NULL),
(22, 'No.00861519', 'Laptop Acer Gaming Predator Helios PH16-71-94N1 i9-13900HX/32GB/2TB/16\'/Nvidia RTX4080 12GB/Win11', 2, 5, 13, 'sdf231dg1fd532b0', 122790000, 'Màn hình	16.0 inch Chính:, 2560 x 1600 Pixels, IPS, 240 Hz, Acer CineCrystalTM LED-backlit TFT LCD\r\nCPU	Intel, Core i9, 13980HX\r\nRAM	32 GB (2 thanh 16 GB), DDR5, 5600 MHz\r\nỔ cứng	SSD 2 TB\r\nHệ điều hành	Windows 11 Home Single Language\r\nTrọng lượng	2.6 kg\r\nKích thước	357.78 (W) x 278.74 (D) x 24.90/26.90 (H) mm', '2022-07-18 16:12:08', '2022-12-20 16:30:32', NULL),
(23, 'No.00818342', 'Laptop Acer Predator Gaming Helios PH315-54-99S6 i9 11900H/16G/512G/15.6/GeForce RTX3060 6G/Win 11', 2, 5, 13, 'dfg321fdg56df1g2', 40990000, 'Màn hình	15.6 inch, 2560 x 1440 Pixels, IPS, 165 Hz, Acer ComfyView LED-backlit\r\nCPU	Intel, Core i9, 11900H\r\nRAM	16 GB (2 thanh 8 GB), LPDDR4, 3200 MHz\r\nỔ cứng	SSD 512 GB\r\nĐồ họa	NVIDIA GeForce RTX 3060 6GB; Intel UHD Graphics\r\nHệ điều hành	Windows 11 Home Single Language\r\nTrọng lượng	2.3 kg\r\nKích thước	363 x 255 x 22.9 mm', '2022-07-18 16:12:08', NULL, NULL),
(24, 'No.00834406', 'Laptop Dell XPS 15 9520 i9 12900HK/16GB/512GB/15.6\" OLED 3.5K Touch/GeForce RTX 3050 Ti 4GB/Win11', 2, 3, 12, 'fdhgf32h1f6g5h', 77990000, 'Màn hình	15.6 inch, 3456 x 2160 Pixels, OLED, 60 Hz, 400 nits, Infinity Edge\r\nCPU	Intel, Core i9, 12900HK\r\nRAM	16 GB (2 thanh 8 GB), DDR5, 4800 MHz\r\nỔ cứng	SSD 512 GB\r\nĐồ họa	NVIDIA GeForce RTX 3050 Ti 4 GB; Intel Iris Xe Graphics\r\nHệ điều hành	Windows 11 Home\r\nTrọng lượng	1.96 kg\r\nKích thước	344 x 230 x 19 mm', '2022-07-18 16:12:08', NULL, NULL),
(25, 'No.00834407', 'Laptop Dell XPS 13 9320 i5 1240P/16GB/512GB SSD/13.4\" OLED 3.5K Touch/Win 11', 2, 3, 12, 'dfgdfg1df2gdfg', 44990000, 'Màn hình	13.4 inch, 3456 x 2234 Pixels, OLED, 60 Hz, 400 nits, Infinity Edge\r\nCPU	Intel, Core i5, 1240P\r\nRAM	16 GB (1 thanh 16 GB), LPDDR5, 5200 MHz\r\nỔ cứng	SSD 512 GB\r\nĐồ họa	Intel Iris Xe Graphics\r\nHệ điều hành	Windows 11 Home\r\nTrọng lượng	1.27 kg\r\nKích thước	295 x 199 x 16 mm', '2022-07-18 16:12:08', '2022-12-20 16:30:32', NULL),
(26, 'No.00861613', 'Laptop MSI Gaming Katana 15 B13VEK-252VN i7 13620H/8GB/512GB/15.6\"FHD/GeForce RTX 4050 6GB/Win11', 2, 5, 9, 'kl5hj12kgjg', 31990000, 'Màn hình	15.6 inch, 1920 x 1080 Pixels, IPS, 144 Hz, 250 nits, IPS FHD\r\nCPU	Intel, Core i7, 13620H\r\nRAM	8 GB, DDR5, 5200 MHz\r\nỔ cứng	SSD 512 GB\r\nHệ điều hành	Windows 11 Home\r\nTrọng lượng	2.29 kg\r\nKích thước	359 x 259 x 24.9 mm', '2022-07-18 16:12:08', NULL, NULL),
(27, 'No.00842517', 'Laptop MSI Gaming Katana GF66 12UCK-815VN i5 12450H/8GB/512GB/15.6\"/GeForce RTX 3050 4GB/Win11_Balo', 2, 5, 9, 'jh2k1hj5k', 20990000, 'Màn hình	15.6 inch, 1920 x 1080 Pixels, IPS, 144 Hz, 250 nits, FHD\r\nCPU	Intel, Core i5, 12450H\r\nRAM	8 GB (1 thanh 8 GB), DDR4, 3200 MHz\r\nỔ cứng	SSD 512 GB\r\nĐồ họa	NVIDIA GeForce RTX 3050 4GB; Intel UHD Graphics\r\nHệ điều hành	Windows 11 Home\r\nTrọng lượng	2.25 kg\r\nKích thước	359 x 259 x 27.9 mm', '2022-07-18 16:12:08', '2023-01-10 16:12:08', NULL),
(28, 'No.00815324', 'Laptop HP Gaming OMEN 16-b0178TX i5 11400H/16GB/1TB/16.1\"FHD/GeForce RTX 3050Ti 4GB/Win 1', 2, 3, 10, 'gh4jg54j1gh', 34990000, 'Màn hình	16.1 inch, 1920 x 1080 Pixels, IPS, 144 Hz, 300 nits, IPS LCD\r\nCPU	Intel, Core i5, 11400H\r\nRAM	16 GB (2 thanh 8 GB), DDR4, 2933 MHz\r\nỔ cứng	SSD 1 TB\r\nĐồ họa	NVIDIA GeForce RTX 3050 Ti 4 GB\r\nHệ điều hành	Windows 11 Home\r\nTrọng lượng	2.3 kg\r\nKích thước	369.2 x 248 x 23 mm', '2022-07-18 16:12:08', '2023-01-10 16:12:08', NULL),
(29, 'No.00815327', 'Laptop HP Gaming OMEN 16-b0176TX i7 11800H/16GB/1TB/16.1\"FHD/GeForce RTX 3060 6GB/Win 11', 2, 3, 10, 'ghj5gh4j85', 38990000, 'Màn hình	16.1 inch, 1920 x 1080 Pixels, IPS, 144 Hz, 300 nits, IPS LCD\r\nCPU	Intel, Core i7, 11800H\r\nRAM	16 GB, DDR4, 2933 MHz\r\nỔ cứng	SSD 1 TB\r\nĐồ họa	NVIDIA GeForce RTX 3060 6GB\r\nHệ điều hành	Windows 11 Home\r\nTrọng lượng	2.3 kg\r\nKích thước	369.2 x 248 x 23 cm', '2022-07-18 16:12:08', NULL, NULL),
(30, 'No.00861522', 'Laptop Microsoft Surface Pro 9 i5 1235U/8GB/128GB SSD/13\" Touchscreen/Win 11', 2, 3, 11, 'ghj1gh5j', 27990000, 'Màn hình	13.0 inch Chính:, 2880 x 1920 Pixels, IPS, 120 Hz, IPS Chính:\r\nCPU	Intel, Core i5, 1235U\r\nRAM	8 GB (1 thanh 8 GB), DDR5, 4800 MHz\r\nỔ cứng	SSD 128 GB\r\nĐồ họa	Intel Iris Xe Graphics\r\nHệ điều hành	Windows 11 Home\r\nTrọng lượng	879 g\r\nKích thước	287 x 208.3 x 10.2 mm', '2022-07-18 16:12:08', '2023-01-10 16:12:08', NULL),
(31, 'No.00734878', 'Laptop Microsoft Surface Pro 7 i5 1035G4/8GB/128GB SSD/12.3\" Touch/Win10', 2, 3, 11, 'gh5j1gh2jgh', 18890000, 'Màn hình	12.3 inch, 2736 x 1824 Pixels, IPS Glossy, 60 Hz, 395 nits\r\nCPU	Intel, Core i5, 1035G4\r\nRAM	8 GB, LPDDR4X, 3733 MHz\r\nỔ cứng	SSD 128 GB\r\nĐồ họa	Intel Iris Plus Graphics\r\nHệ điều hành	Windows 10\r\nTrọng lượng	0.775 kg\r\nKích thước	201 x 8.5 x 292 mm', '2022-07-18 16:12:08', NULL, NULL),
(32, '(No.00819430)', 'Laptop Gigabyte U4 UD-50VN823SO i5 1155G7/16GB/512GB/14\" FHD/Win 11', 2, 5, 8, '5gh1j6gh5j', 15490000, 'Màn hình	14.0 inch, 1920 x 1080 Pixels, IPS, Anti-glare LED-backlit\r\nCPU	Intel, Core i5, 1155G7\r\nRAM	16 GB (2 thanh 8 GB), DDR4, 3200 MHz\r\nỔ cứng	SSD 512 GB\r\nĐồ họa	Intel Iris Xe Graphics\r\nHệ điều hành	Windows 11 Home\r\nTrọng lượng	990 g', '2022-07-18 16:12:08', '2023-01-10 16:12:08', NULL),
(33, 'No.00850526', 'Laptop Gigabyte Gaming G5 GE-51VN213SH i5 12500H/16GB/512GB/15.6\"FHD/GeForce RTX3050 4GB/Win11', 2, 5, 8, '5g1hjg5jg', 25890000, 'Màn hình	15.6 inch, 1920 x 1080 Pixels, IPS, 144 Hz, Anti-Glare LED-Backlit Display\r\nCPU	Intel, Core i5, 12500H\r\nRAM	16 GB (2 thanh 8 GB), DDR4, 3200 MHz\r\nỔ cứng	SSD 512 GB\r\nĐồ họa	NVIDIA GeForce RTX 3050 4GB; Intel Iris Xe Graphics\r\nHệ điều hành	Windows 11 Home\r\nTrọng lượng	1.9 kg\r\nKích thước	360 x 238 x 22.7 mm', '2022-07-18 16:12:08', NULL, NULL),
(34, 'No.00836270', 'Laptop Lenovo IdeaPad 3 14IAU7 i3 1215U/8GB/512GB/14\"FHD/Win 11', 2, 1, 7, 'th45fg12f', 11990000, 'Màn hình	14.0 inch, 1920 x 1080 Pixels, TN, 60 Hz, 250 nits, LED Backlit\r\nCPU	Intel, Core i3, 1215U\r\nRAM	8 GB (1 thanh 8 GB), DDR4, 3200 MHz\r\nỔ cứng	SSD 512 GB\r\nĐồ họa	Intel UHD Graphics\r\nHệ điều hành	Windows 11 Home\r\nTrọng lượng	1.63 kg\r\nKích thước	359.2 x 236.5 x 19.9 mm', '2022-07-18 16:12:08', NULL, NULL),
(35, 'No.00856986', 'MacBook Pro 16 2023 M2 Pro 12CPU 19GPU 16GB/512GB', 2, 3, 1, 'dfg41aaw6521', 64990000, 'Màn hình	16.2 inch, 3456 x 2234 Pixels, OLED, 120 Hz, 1000 nits, Retina\r\nCPU	Apple, M2 Pro, 12-Core\r\nRAM	16 GB (1 thanh 16 GB), Hãng không công bố, Hãng không công bố\r\nỔ cứng	SSD 512 GB\r\nĐồ họa	Apple M2 Pro 19-core GPU\r\nHệ điều hành	Ventura\r\nTrọng lượng	2.15 kg\r\nKích thước	35.57 x 24.81 x 1.68 cm', '2022-07-18 16:12:08', '2023-03-13 16:26:31', NULL),
(36, 'No.00857495', 'MacBook Pro 16 2023 M2 Pro 12CPU 19GPU 32GB/512GB', 2, 3, 1, 'sdfrdrg30rfdg', 76990000, 'Màn hình	16.2 inch, 3456 x 2234 Pixels, OLED, 120 Hz, 1000 nits, Retina\r\nCPU	Apple, M2 Pro, 12-Core\r\nRAM	32 GB (1 thanh 16 GB), Hãng không công bố, Hãng không công bố\r\nỔ cứng	SSD 512 GB\r\nĐồ họa	Apple M2 Pro 16-core GPU\r\nHệ điều hành	Ventura\r\nTrọng lượng	2.15 kg\r\nKích thước	35.57 x 24.81 x 1.68 cm', '2022-07-18 16:12:08', NULL, NULL),
(37, 'No.00849663', 'Lenovo Tab M10 3GB-32GB (Gen 3)', 3, 1, 7, 'awf2d130fdg56dg', 4790000, 'Màn hình	10.1 inch Chính:, IPS Chính:, HD, 1920 x 1200 Pixels\r\nCamera sau	8.0 MP\r\nCamera Selfie	5.0 MP\r\nRAM	3 GB\r\nBộ nhớ trong	32 GB\r\nCPU	Unisoc T612\r\nDung lượng pin	5100\r\nThẻ sim	1 - 1 Nano SIM', '2022-07-18 16:12:08', '2023-03-13 16:26:31', NULL),
(38, 'No.00854232', 'PC E-Power Office 12 Core i3 10105 3.7 GHz - 4.4 GHz/8GB/240GB/250W', 5, 1, 3, 'hj2f65h2dg', 6990000, 'CPU	Intel, Core i3, 10105\r\nRAM	8 GB, DDR4, 3200 MHz\r\nỔ cứng	SSD 240 GB\r\nĐồ họa	Intel UHD Graphics 630\r\nTrọng lượng	4.5 kg\r\nKích thước (DxRxC)	370 x 188 x 413 mm', '2022-07-18 16:12:08', NULL, NULL),
(39, 'No.00788647', 'Máy tính để bàn HP ProDesk 400G6 DMPentG6400T4GB/256GBPC-59D82PA', 5, 3, 10, 'yuit1y20uth', 5990000, 'CPU	Intel, Pentium, G6400T\r\nRAM	4 GB, DDR4, 2666 MHz\r\nỔ cứng	SSD 256 GB\r\nĐồ họa	Intel HD Graphics 630\r\nHệ điều hành	Windows 10\r\nTrọng lượng	1.2 kg\r\nKích thước (DxRxC)	177 x 175 x 34 mm', '2022-07-18 16:12:08', '2023-01-10 16:12:08', NULL),
(40, 'No.00783557', 'Màn hình Acer VG240Y S/23.8 inch/FHD (1920x1080)/165Hz', 5, 5, 13, 'tg045er0gr', 4290000, 'Màn hình	23.8 inch, 1920 x 1080 Pixels, FHD, 250 nits, IPS\r\nTần số quét	165 Hz\r\nTấm nền	IPS\r\nThời gian phản hồi	0.5ms\r\nCổng kết nối	DisplayPort, HDMI\r\nĐầu ra âm thanh	Headphone\r\nThương hiệu	Acer', '2022-07-18 16:12:08', '2023-01-10 16:12:08', NULL),
(41, 'No.00832858', 'Tai nghe AirPods Pro 2022', 6, 3, 1, 'ouy203dg', 6390000, 'Loại tai nghe	Tai nghe không dây\r\nTính năng	Sạc không dây; Chống ồn', '2022-07-18 16:12:08', NULL, NULL),
(42, 'No.00555013', 'Tai nghe gaming F.Power G-23 grey có mic', 6, 1, 3, 'fh51ry98u15ty6', 595000, 'Loại tai nghe	Tai nghe chụp tai\r\nTính năng	Nghe nhạc; Mic đàm thoại; Xem phim', '2022-07-18 16:12:08', '2023-01-10 16:12:08', NULL),
(43, 'No.00720810', 'Bàn phím cơ có dây Logitech G512 Lightsync RG', 6, 1, 3, 'rwe5r4816we203', 2799000, 'Bàn phím gaming Logitech G512 Lightsync RG được tích hợp các nút điều khiển đa phương tiện và đèn LED ở ngay trong tầm tay. Thông qua tổ hợp phím Fn, người dùng có thể nhanh chóng điều khiển nhanh các chức năng như tăng giảm âm lượng, phát/tạm dừng, tắt tiếng, chuyển chế độ chơi game, thay đổi hiệu ứng ánh sáng của hệ thống đèn LED...', '2022-07-18 16:12:08', '2023-03-24 16:27:11', NULL),
(44, 'No.00686704', 'Bàn phím không dây Apple Magic Keyboard with Numeric Keypad', 6, 3, 1, 'wet14r5e20tert', 3999000, 'Kiểu kết nối	Bluetooth\r\nCổng giao tiếp	Lightning\r\nTính năng	Tích hợp multimedia; Bàn phím số, pin sạc tích hợp; Thời lượng pin khoảng 1 tháng; Gõ chính xác và thoải mái\r\nHệ điều hành tương thích	Windows, macOS, iOS, iPadOS', '2022-07-18 16:12:08', NULL, NULL),
(45, 'No.00773444', 'Bộ phát Wifi router chuẩn AC1200 ASUS RT-AC1200 V2', 6, 1, 3, 'qwr1t02jhfg', 790000, 'Mặc dù chỉ là một bộ định tuyến WiFi, Asus RT-AC1200 v2 vẫn được nhà sản xuất chăm chút tỉ mỉ về thiết kế bên ngoài. Để mang lại một kiểu dáng sang trọng và nổi bật, toàn bộ khung vỏ của router đều được hoàn thiện bằng nhựa nhám màu đen với các họa tiết nổi khối cắt ngang trên bề mặt. Thiết kế này giúp cho Asus RT-AC1200 v2 dễ dàng phối hợp với các đồ nội thất khác trong nhà. Ngoài ra, chất liệu nhựa nhám cũng giúp bộ định tuyến WiFi dễ dàng vệ sinh, ít bám bụi bẩn và tỏa nhiệt tốt.', '2022-07-18 16:12:08', NULL, NULL),
(46, 'No.00707297', 'Bộ phát Wifi Xiaomi Mi Router 4A', 6, 1, 3, 'erty0rt2fd', 400000, 'Bộ định tuyến băng tần kép tốc độ cao Mi Router 4A là sự lựa chọn hàng đầu của những gia đình đông thành viên và sở hữu nhiều thiết bị di động cần kết nối mạng. Với bốn ăng-ten rời cho hiệu quả thu phát mạnh mẽ, sản phẩm đảm bảo tốc độ truyền tải tín hiệu tới 64 thiết bị luôn ổn định, cho phép điều khiển từ xa qua ứng dụng và có thể ngăn chặn nguồn truy cập trái phép.', '2022-07-18 16:12:08', '2023-01-10 16:12:08', NULL),
(47, 'No.00781334', 'Khăn lau màn hình cao cấp Polishing Cloth', 6, 3, 1, 'rete87y56e1230', 590000, 'Khăn lau màn hình cao cấp Polishing Cloth là khăn lau chính hãng của Apple, có thể lau sạch và đánh bóng màn hình các sản phẩm như iPhone, MacBook, iPad, Apple Watch và nhiều đồ dùng công nghệ khác của bạn', '2022-07-18 16:12:08', NULL, NULL),
(48, 'No.00750641', 'Thiết bị định vị thông minh AirTag - 4 Pack', 6, 3, 1, 'qwe8w54612r0', 2799000, 'Gói Apple AirTag bạn đang theo dõi gồm 4 pack với giá thành hợp lý hơn nhiều so với việc bạn chỉ mua 1 pack riêng lẻ. Đây là thiết bị định vị tận dụng công nghệ bluetooth kết hợp với chip băng thông siêu rộng để giúp bạn tránh bị mất những đồ vật dễ thất lạc qua cơ chế tìm kiếm thông minh nhất do Apple cung cấp', '2022-07-18 16:12:08', NULL, NULL),
(49, 'No.00770651', 'Nồi chiên không dầu Kalite 10 lít Q10', 6, 1, 3, 'qwr7845120g', 2790000, 'Dung tích thực	10 lít\r\nCông suất	1800 W\r\nĐiều chỉnh nhiệt độ	80 - 200 độ C\r\nThời gian hẹn giờ	0 - 90 phút\r\nCông nghệ làm nóng	Rapid Air\r\nChất liệu	Vỏ máy: Inox 304, Vỏ máy: Nhựa PP, Lòng nồi: Kim loại phủ chống dính\r\nBảng điều khiển	Cảm ứng\r\nKích thước	430 x 380 x 380 mm\r\nTrọng lượng	8500 g', '2022-07-18 16:12:08', NULL, NULL),
(50, 'No.00839824', 'Máy massage mắt Buheung MK-321', 6, 1, 3, 'rt51re6203grd', 1555000, 'Loại máy	Máy massage mắt\r\nCông suất	5 W\r\nKích thước - Trọng lượng	0.28 kg', '2022-07-18 16:12:08', NULL, NULL),
(51, 'S123', 'Sim 0703569794', 8, 2, NULL, 'qw0wqd5', 770000, 'Sau khi đăng kí SIM thành công, có ngay: Không giới hạn. 6GB/ngày tốc độ cao, hết 6GB truy cập tốc độ 5Mbps\r\nNghe gọi, SMS bình thường theo quy định hiện hành của MobiFone\r\n8 Tháng đầu: Miễn Phí\r\nPhí gói: 540.000đ/ 8 tháng', '2022-07-18 16:12:08', NULL, NULL),
(52, 'S342', 'Sim 0765732950', 8, 2, NULL, 'wqeqw516e2', 1310000, 'Sau khi đăng kí SIM thành công, có ngay: Không giới hạn. 6GB/ngày tốc độ cao, hết 6GB truy cập tốc độ 5Mbps\r\nNghe gọi, SMS bình thường theo quy định hiện hành của MobiFone\r\n16 Tháng đầu: Miễn Phí\r\nPhí gói: 1.080.000đ/ 16 tháng', '2022-07-18 16:12:08', NULL, NULL),
(53, 'S021', 'Sim 0582248527', 8, 2, NULL, 'qwe512qw0e', 200000, 'Sau khi đăng kí SIM thành công, có ngay: 2 GB/ngày trong 30 ngày đầu tiên kể từ ngày kích hoạt số thành công\r\nChỉ bán kèm kho số đẹp VNMB TT', '2022-07-18 16:12:08', NULL, NULL),
(54, 'No.00831848', 'Ốp lưng iPhone 14 Pro Max Silicon chống sốc Mipow', 6, 2, 1, 'qwewq012e', 359000, 'Loại sản phẩm	Ốp lưng\r\nChất liệu	TPU, Nhựa Polycarbonate\r\nTính năng	Chống bám vân tay; Chống sốc; Chống trầy xước', '2022-07-18 16:12:08', NULL, NULL);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `status`
--

CREATE TABLE `status` (
  `key` int(11) NOT NULL,
  `value` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `status`
--

INSERT INTO `status` (`key`, `value`) VALUES
(1, 1),
(2, 2),
(3, 3);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `storages`
--

CREATE TABLE `storages` (
  `id` int(11) NOT NULL,
  `product_id` int(11) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `quantity` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `storages`
--

INSERT INTO `storages` (`id`, `product_id`, `description`, `quantity`) VALUES
(1, 39, '', 1001),
(2, 2, '', 500),
(3, 1, '', 902),
(4, 4, '', 451),
(5, 6, '', 687),
(6, 10, 'Hết hàng', 0),
(7, 7, '', 825),
(8, 8, '', 456),
(9, 9, '', 50),
(10, 18, '', 231),
(11, 17, '', 800),
(12, 51, '', 600),
(13, 43, 'Hết hàng', 0),
(14, 26, '', 751),
(15, 48, '', 654),
(16, 50, '', 254),
(17, 15, '', 365),
(18, 25, '', 851),
(19, 5, '', 555),
(20, 3, '', 333),
(21, 19, 'Hết hàng', 0),
(22, 16, '', 123),
(23, 24, '', 240),
(24, 23, '', 510),
(25, 14, '', 659),
(26, 30, '', 25),
(27, 31, '', 78),
(28, 32, '', 90),
(29, 35, 'Hết hàng', 0),
(30, 38, '', 150),
(31, 37, 'Hết hàng', 0),
(32, 12, NULL, 111),
(33, 11, NULL, 102),
(34, 13, NULL, 95),
(35, 46, NULL, 59),
(36, 47, NULL, 60),
(38, 49, NULL, 356),
(39, 44, NULL, 340),
(40, 20, NULL, 311),
(41, 22, NULL, 455),
(42, 21, NULL, 451),
(43, 25, NULL, 421),
(44, 27, NULL, 684),
(45, 29, NULL, 100),
(46, 33, NULL, 200),
(47, 34, NULL, 400),
(48, 40, NULL, 900),
(49, 41, NULL, 941),
(50, 42, NULL, 654),
(51, 52, NULL, 321),
(52, 53, NULL, 356),
(53, 54, NULL, 101);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `suppliers`
--

CREATE TABLE `suppliers` (
  `id` int(11) NOT NULL,
  `code` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `suppliers`
--

INSERT INTO `suppliers` (`id`, `code`, `name`) VALUES
(1, 'B001', 'BIDV'),
(2, 'H002', 'HSBC'),
(3, 'T003', 'TP BANK'),
(4, 'S005', 'SCB'),
(5, 'H011', 'HD BANK'),
(6, 'M010', 'MARITIME BANK'),
(7, 'V054', 'VCB'),
(8, 'M088', 'MB BANK'),
(9, 'G001', 'GIAO HÀNG TIẾT KIỆM'),
(10, 'G121', 'GIAO HÀNG NHANH'),
(11, 'V', 'VIETTEL POST'),
(12, 'J', 'J&T EXPRESS'),
(13, 'B054', 'BE'),
(14, 'G035', 'GRAB EXPRESS');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `trademarks`
--

CREATE TABLE `trademarks` (
  `id` int(11) NOT NULL,
  `code` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `trademarks`
--

INSERT INTO `trademarks` (`id`, `code`, `name`) VALUES
(1, 'A', 'Apple'),
(2, 'S', 'Sam Sung'),
(3, 'X', 'Xiaomi'),
(4, 'V', 'Vivo'),
(5, 'N', 'Nokia'),
(6, 'AS', 'Asus'),
(7, 'L', 'Lenovo'),
(8, 'G', 'Gigabyte'),
(9, 'M', 'MSI'),
(10, 'H', 'HP'),
(11, 'MI', 'Microsoft'),
(12, 'D', 'Dell'),
(13, 'AC', 'Acer'),
(14, 'Lg', 'LG');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `users`
--

CREATE TABLE `users` (
  `id` int(11) NOT NULL,
  `email` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `birthday` date DEFAULT NULL,
  `avatar` varchar(255) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `role` int(11) DEFAULT NULL,
  `created_at` timestamp NULL DEFAULT NULL,
  `updated_at` timestamp NULL DEFAULT NULL,
  `deleted_at` timestamp NULL DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `users`
--

INSERT INTO `users` (`id`, `email`, `password`, `name`, `phone`, `birthday`, `avatar`, `address`, `role`, `created_at`, `updated_at`, `deleted_at`) VALUES
(1, 'kttcnh@gmail.com', '9640fbd4163cfe013332954073bdfee7', 'Lục Anh', '0654971323', '1999-03-09', 'xz12zxcdcz', 'Cầu Giấy, Hà Nội', 1, '2022-09-21 16:06:16', '2022-11-15 16:06:16', NULL),
(2, 'xuananh@gmail.com', '29af19fecd90bbe3c2c7cf7aa39f21e1', 'Xuân Anh', '0988888888', '1998-11-16', 'xc21vxv4xffs', 'Hạ Long, Quảng Ninh', 2, '2023-02-14 16:06:43', NULL, NULL),
(3, 'vuhabang1122@gmail.com', '72f258d299543234a65ebf94392f2601', 'Hạ Băng', '0998456321', '1994-04-05', 'ewr5w12dfsef', 'Vân Đồn - Hạ Long', 3, '2022-09-19 16:07:03', '2022-11-22 16:07:03', NULL),
(4, 'ng.tuanh@gmail.com', '5854ce794015ba7e0d195b3649489df6', 'Nguyễn Anh Tuấn', '0954136478', '2002-10-10', 'qưe5454w8ewq', 'Mỹ Đình - Cầu Giấy - Hà Nội', 3, '2022-10-24 16:07:03', '2022-11-14 16:07:03', NULL),
(5, 'ngocvu@gmail.com', '924b9c3263d8b05ce7b80e325508fd81', 'Vũ Ngọc', '0365478921', '1990-01-31', 'qqe3213dwda', '13 Dịch Vọng Hậu, Cầu Giấy - Hà Nội', 3, '2022-11-07 16:07:03', '2023-02-13 16:07:03', NULL),
(6, 'ngocthaong.1@gmail.com', 'ab28b71ab479dd1892865e7584dee648', 'Nguyễn Thị Thảo Ngọc', '064651765', '2001-09-25', 'kjhgfd45489fsdf', '322 Mỹ Đình, Nhân Mỹ, Cầu Giấy - Hà Nội', 3, '2023-01-01 16:07:03', '2023-02-13 16:07:03', NULL),
(7, 'ngocvanhng@gmail.com', '8630ed635b577f3fd4af51a449791537', 'Nguyễn Vũ Ánh Ngọc', '065841178', '2001-09-25', 'kjhg5459fsdf', '322 Đống Đa - Hà Nội', 3, '2023-01-01 16:07:03', '0000-00-00 00:00:00', '2023-03-25 16:47:17');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `votes`
--

CREATE TABLE `votes` (
  `id` int(11) NOT NULL,
  `user_id` int(11) DEFAULT NULL,
  `product_id` int(11) DEFAULT NULL,
  `score` int(11) DEFAULT NULL,
  `created_at` timestamp NULL DEFAULT NULL,
  `updated_at` timestamp NULL DEFAULT NULL,
  `deleted_at` timestamp NULL DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `votes`
--

INSERT INTO `votes` (`id`, `user_id`, `product_id`, `score`, `created_at`, `updated_at`, `deleted_at`) VALUES
(1, 3, 20, 5, '2023-01-01 15:08:41', '2023-01-01 15:08:41', NULL),
(2, 5, 40, 4, '2023-03-06 15:08:41', '2023-03-06 15:08:41', NULL),
(3, 6, 25, 4, '2023-03-01 15:08:41', '2023-03-01 15:08:41', NULL),
(4, 4, 22, 3, '2023-03-09 15:08:41', '2023-03-09 15:08:41', NULL),
(5, 2, 5, 5, '2023-02-28 15:08:41', '2023-02-28 15:08:41', NULL),
(6, 1, 6, 5, '2023-02-16 15:08:41', '2023-02-16 15:08:41', NULL),
(7, 2, 28, 5, '2023-02-05 15:08:41', '2023-02-05 15:08:41', NULL),
(8, 1, 26, 5, '2023-01-01 15:08:41', '2023-01-01 15:08:41', NULL),
(9, 2, 15, 5, '2022-12-31 15:08:41', '2022-12-31 15:08:41', NULL),
(10, 1, 27, 5, '2022-12-21 15:08:41', '2022-12-21 15:08:41', NULL);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `vouchers`
--

CREATE TABLE `vouchers` (
  `id` int(11) NOT NULL,
  `code` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `supplier_id` int(11) DEFAULT NULL,
  `discount` int(11) DEFAULT NULL,
  `quantity` int(11) DEFAULT NULL,
  `start_at` date DEFAULT NULL,
  `end_at` date DEFAULT NULL,
  `created_at` timestamp NULL DEFAULT NULL,
  `updated_at` timestamp NULL DEFAULT NULL,
  `deleted_at` timestamp NULL DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `vouchers`
--

INSERT INTO `vouchers` (`id`, `code`, `name`, `supplier_id`, `discount`, `quantity`, `start_at`, `end_at`, `created_at`, `updated_at`, `deleted_at`) VALUES
(1, 'No.0001564', 'Giảm 25k Không giới hạn giá trị đơn hàng', 2, 5, 100, '2023-02-28', '2023-03-27', '2023-02-27 17:00:00', '0000-00-00 00:00:00', '2023-03-27 17:00:00'),
(2, 'No.00064', 'Giảm 50k Cho đơn hàng từ 1.000.000', 2, 10, 123, '2023-03-05', '2023-03-31', '2023-03-04 17:00:00', '2023-03-30 17:00:00', NULL),
(3, 'No.000245', 'FREE SHIP', 11, 10, 546, '2023-02-11', '2023-03-31', '2023-02-10 17:00:00', '2023-03-30 17:00:00', NULL),
(4, 'No.0008964', 'FREE SHIP', 12, 5, 45, '2023-03-27', '2023-04-30', '2023-03-26 17:00:00', '2023-04-29 17:00:00', NULL),
(5, 'No.00054', 'Giảm 10k Cho đơn hàng từ 1.200.000', 1, 10, 45, '2023-03-11', '2023-04-30', '2023-03-10 17:00:00', '2023-04-29 17:00:00', NULL),
(6, 'No.000246', 'Giảm 50k Cho đơn hàng từ 1.500.000', 3, 15, 90, '2023-04-04', '2023-05-05', '2023-04-03 17:00:00', '2023-05-04 17:00:00', NULL),
(7, 'No.000346', 'Giảm 10k Cho đơn hàng từ 100.000', 5, 10, 56, '2023-02-27', '2023-04-28', '2023-02-26 17:00:00', '2023-04-27 17:00:00', NULL),
(8, 'No.000846', 'Giảm 250k Cho đơn hàng từ 1.000.000', 7, 25, 30, '2023-01-20', '2023-04-20', '2023-01-19 17:00:00', '2023-04-19 17:00:00', NULL),
(9, 'No.00078', 'Giảm 150k Cho đơn hàng từ 1.000.000', 7, 15, 80, '2023-02-05', '2023-03-30', '2023-02-04 17:00:00', '2023-03-29 17:00:00', NULL),
(10, 'No.000120', 'Giảm 5k Cho đơn hàng từ 100.000', 4, 5, 546, '2023-03-30', '2023-04-30', '2023-03-29 17:00:00', '2023-04-29 17:00:00', NULL),
(11, 'No.000052', 'Giảm 100k Cho đơn hàng từ 2.000.000', 6, 5, 100, '2023-04-05', '2023-05-15', '2023-04-04 17:00:00', '2023-05-14 17:00:00', NULL),
(12, 'No.000254', 'Giảm 250k Cho đơn hàng từ 2.500.000', 8, 10, 50, '2023-05-06', '2023-06-07', '2023-05-05 17:00:00', '2023-06-06 17:00:00', NULL),
(13, 'No.000546', 'FREE SHIP', 9, 10, 300, '2023-04-04', '2023-05-15', '2023-04-03 17:00:00', '2023-05-14 17:00:00', NULL),
(14, 'No.000456', 'FREE SHIP', 10, 15, 250, '2023-03-28', '2023-04-05', '2023-03-27 17:00:00', '2023-04-04 17:00:00', NULL),
(15, 'No.000321', 'FREE SHIP', 13, 5, 456, '2023-04-16', '2023-05-26', '2023-04-15 17:00:00', '2023-05-25 17:00:00', NULL),
(16, 'No.000989', 'FREE SHIP', 14, 10, 545, '2023-01-01', '2023-04-21', '2022-12-31 17:00:00', '2023-04-20 17:00:00', NULL),
(17, 'No.000855', 'Giảm 50k Không giới hạn giá trị đơn hàng', 4, 10, 30, '2023-05-05', '2023-06-05', '2023-05-04 17:00:00', '2023-06-04 17:00:00', NULL),
(18, 'No.0005433', 'Giảm 50k Không giới hạn giá trị đơn hàng', 8, 30, 40, '2023-05-01', '2023-07-30', '2023-04-30 17:00:00', '2023-07-29 17:00:00', NULL);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `vouchers_item`
--

CREATE TABLE `vouchers_item` (
  `id` int(11) NOT NULL,
  `voucher_id` int(11) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  `product_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `vouchers_item`
--

INSERT INTO `vouchers_item` (`id`, `voucher_id`, `user_id`, `product_id`) VALUES
(1, 5, 3, 11),
(2, 14, 5, 20),
(3, 18, 4, 45),
(4, 3, 6, 26),
(5, 14, 5, 7),
(6, 10, 4, 39),
(7, 2, 3, 42),
(8, 1, 6, 53),
(9, 3, 4, 47);

--
-- Chỉ mục cho các bảng đã đổ
--

--
-- Chỉ mục cho bảng `carts`
--
ALTER TABLE `carts`
  ADD PRIMARY KEY (`id`),
  ADD KEY `user_id` (`user_id`),
  ADD KEY `status_id` (`status_id`);

--
-- Chỉ mục cho bảng `carts_detail`
--
ALTER TABLE `carts_detail`
  ADD PRIMARY KEY (`id`),
  ADD KEY `cart_id` (`cart_id`),
  ADD KEY `product_id` (`product_id`);

--
-- Chỉ mục cho bảng `categories`
--
ALTER TABLE `categories`
  ADD PRIMARY KEY (`id`);

--
-- Chỉ mục cho bảng `comments`
--
ALTER TABLE `comments`
  ADD PRIMARY KEY (`id`),
  ADD KEY `user_id` (`user_id`),
  ADD KEY `product_id` (`product_id`),
  ADD KEY `status_id` (`status_id`);

--
-- Chỉ mục cho bảng `manufactures`
--
ALTER TABLE `manufactures`
  ADD PRIMARY KEY (`id`);

--
-- Chỉ mục cho bảng `orders`
--
ALTER TABLE `orders`
  ADD PRIMARY KEY (`id`),
  ADD KEY `user_id` (`user_id`),
  ADD KEY `status_id` (`status_id`);

--
-- Chỉ mục cho bảng `orders_detail`
--
ALTER TABLE `orders_detail`
  ADD PRIMARY KEY (`id`),
  ADD KEY `orders_id` (`orders_id`),
  ADD KEY `product_id` (`product_id`);

--
-- Chỉ mục cho bảng `points`
--
ALTER TABLE `points`
  ADD PRIMARY KEY (`id`),
  ADD KEY `user_id` (`user_id`);

--
-- Chỉ mục cho bảng `products`
--
ALTER TABLE `products`
  ADD PRIMARY KEY (`id`),
  ADD KEY `trademark_id` (`trademark_id`),
  ADD KEY `manufacture_id` (`manufacture_id`),
  ADD KEY `category_id` (`category_id`);

--
-- Chỉ mục cho bảng `status`
--
ALTER TABLE `status`
  ADD PRIMARY KEY (`key`);

--
-- Chỉ mục cho bảng `storages`
--
ALTER TABLE `storages`
  ADD PRIMARY KEY (`id`),
  ADD KEY `product_id` (`product_id`);

--
-- Chỉ mục cho bảng `suppliers`
--
ALTER TABLE `suppliers`
  ADD PRIMARY KEY (`id`);

--
-- Chỉ mục cho bảng `trademarks`
--
ALTER TABLE `trademarks`
  ADD PRIMARY KEY (`id`);

--
-- Chỉ mục cho bảng `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`id`);

--
-- Chỉ mục cho bảng `votes`
--
ALTER TABLE `votes`
  ADD PRIMARY KEY (`id`),
  ADD KEY `user_id` (`user_id`),
  ADD KEY `product_id` (`product_id`);

--
-- Chỉ mục cho bảng `vouchers`
--
ALTER TABLE `vouchers`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_vouchers_supplier` (`supplier_id`);

--
-- Chỉ mục cho bảng `vouchers_item`
--
ALTER TABLE `vouchers_item`
  ADD PRIMARY KEY (`id`),
  ADD KEY `user_id` (`user_id`),
  ADD KEY `voucher_id` (`voucher_id`),
  ADD KEY `product_id` (`product_id`);

--
-- AUTO_INCREMENT cho các bảng đã đổ
--

--
-- AUTO_INCREMENT cho bảng `carts`
--
ALTER TABLE `carts`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT cho bảng `carts_detail`
--
ALTER TABLE `carts_detail`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT cho bảng `categories`
--
ALTER TABLE `categories`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT cho bảng `comments`
--
ALTER TABLE `comments`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=18;

--
-- AUTO_INCREMENT cho bảng `manufactures`
--
ALTER TABLE `manufactures`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- AUTO_INCREMENT cho bảng `orders`
--
ALTER TABLE `orders`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- AUTO_INCREMENT cho bảng `orders_detail`
--
ALTER TABLE `orders_detail`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT cho bảng `points`
--
ALTER TABLE `points`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT cho bảng `products`
--
ALTER TABLE `products`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=55;

--
-- AUTO_INCREMENT cho bảng `status`
--
ALTER TABLE `status`
  MODIFY `key` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT cho bảng `storages`
--
ALTER TABLE `storages`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=54;

--
-- AUTO_INCREMENT cho bảng `suppliers`
--
ALTER TABLE `suppliers`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;

--
-- AUTO_INCREMENT cho bảng `trademarks`
--
ALTER TABLE `trademarks`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;

--
-- AUTO_INCREMENT cho bảng `users`
--
ALTER TABLE `users`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT cho bảng `votes`
--
ALTER TABLE `votes`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- AUTO_INCREMENT cho bảng `vouchers`
--
ALTER TABLE `vouchers`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=19;

--
-- AUTO_INCREMENT cho bảng `vouchers_item`
--
ALTER TABLE `vouchers_item`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- Các ràng buộc cho các bảng đã đổ
--

--
-- Các ràng buộc cho bảng `carts`
--
ALTER TABLE `carts`
  ADD CONSTRAINT `carts_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`),
  ADD CONSTRAINT `carts_ibfk_2` FOREIGN KEY (`status_id`) REFERENCES `status` (`key`);

--
-- Các ràng buộc cho bảng `carts_detail`
--
ALTER TABLE `carts_detail`
  ADD CONSTRAINT `carts_detail_ibfk_1` FOREIGN KEY (`cart_id`) REFERENCES `carts` (`id`),
  ADD CONSTRAINT `carts_detail_ibfk_2` FOREIGN KEY (`product_id`) REFERENCES `products` (`id`);

--
-- Các ràng buộc cho bảng `comments`
--
ALTER TABLE `comments`
  ADD CONSTRAINT `comments_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`),
  ADD CONSTRAINT `comments_ibfk_2` FOREIGN KEY (`product_id`) REFERENCES `products` (`id`),
  ADD CONSTRAINT `comments_ibfk_3` FOREIGN KEY (`status_id`) REFERENCES `status` (`key`);

--
-- Các ràng buộc cho bảng `orders`
--
ALTER TABLE `orders`
  ADD CONSTRAINT `orders_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`),
  ADD CONSTRAINT `orders_ibfk_2` FOREIGN KEY (`status_id`) REFERENCES `status` (`key`);

--
-- Các ràng buộc cho bảng `orders_detail`
--
ALTER TABLE `orders_detail`
  ADD CONSTRAINT `orders_detail_ibfk_1` FOREIGN KEY (`orders_id`) REFERENCES `orders` (`id`),
  ADD CONSTRAINT `orders_detail_ibfk_2` FOREIGN KEY (`product_id`) REFERENCES `products` (`id`);

--
-- Các ràng buộc cho bảng `points`
--
ALTER TABLE `points`
  ADD CONSTRAINT `points_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`);

--
-- Các ràng buộc cho bảng `products`
--
ALTER TABLE `products`
  ADD CONSTRAINT `products_ibfk_1` FOREIGN KEY (`trademark_id`) REFERENCES `trademarks` (`id`),
  ADD CONSTRAINT `products_ibfk_2` FOREIGN KEY (`manufacture_id`) REFERENCES `manufactures` (`id`),
  ADD CONSTRAINT `products_ibfk_3` FOREIGN KEY (`category_id`) REFERENCES `categories` (`id`);

--
-- Các ràng buộc cho bảng `storages`
--
ALTER TABLE `storages`
  ADD CONSTRAINT `storages_ibfk_1` FOREIGN KEY (`product_id`) REFERENCES `products` (`id`);

--
-- Các ràng buộc cho bảng `votes`
--
ALTER TABLE `votes`
  ADD CONSTRAINT `votes_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`),
  ADD CONSTRAINT `votes_ibfk_2` FOREIGN KEY (`product_id`) REFERENCES `products` (`id`);

--
-- Các ràng buộc cho bảng `vouchers`
--
ALTER TABLE `vouchers`
  ADD CONSTRAINT `fk_vouchers_supplier` FOREIGN KEY (`supplier_id`) REFERENCES `suppliers` (`id`),
  ADD CONSTRAINT `vouchers_ibfk_1` FOREIGN KEY (`supplier_id`) REFERENCES `suppliers` (`id`);

--
-- Các ràng buộc cho bảng `vouchers_item`
--
ALTER TABLE `vouchers_item`
  ADD CONSTRAINT `vouchers_item_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`),
  ADD CONSTRAINT `vouchers_item_ibfk_2` FOREIGN KEY (`voucher_id`) REFERENCES `vouchers` (`id`),
  ADD CONSTRAINT `vouchers_item_ibfk_3` FOREIGN KEY (`product_id`) REFERENCES `products` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
