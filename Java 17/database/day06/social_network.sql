-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Mar 27, 2023 at 07:10 PM
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
-- Database: `social_network`
--

-- --------------------------------------------------------

--
-- Table structure for table `albums`
--

CREATE TABLE `albums` (
  `id` int(11) NOT NULL,
  `userID` int(11) DEFAULT NULL,
  `typeID` int(11) DEFAULT NULL,
  `description` char(255) DEFAULT NULL,
  `createdAt` datetime DEFAULT NULL,
  `updateAt` datetime DEFAULT NULL,
  `deleteAt` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `albums`
--

INSERT INTO `albums` (`id`, `userID`, `typeID`, `description`, `createdAt`, `updateAt`, `deleteAt`) VALUES
(1, 1, 1, 'Ảnh phong cảnh', '2023-03-17 09:10:32', NULL, NULL),
(2, 1, 2, 'Để đây và không nói gì', '2023-03-18 09:10:32', NULL, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `comment`
--

CREATE TABLE `comment` (
  `id` int(11) NOT NULL,
  `userID` int(11) DEFAULT NULL,
  `commentID` int(11) DEFAULT NULL,
  `photoID` int(11) DEFAULT NULL,
  `postID` int(11) DEFAULT NULL,
  `content` text DEFAULT NULL,
  `statusID` int(11) DEFAULT NULL,
  `typeID` int(11) DEFAULT NULL,
  `createdAt` datetime DEFAULT NULL,
  `updateAt` datetime DEFAULT NULL,
  `deleteAt` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `comment`
--

INSERT INTO `comment` (`id`, `userID`, `commentID`, `photoID`, `postID`, `content`, `statusID`, `typeID`, `createdAt`, `updateAt`, `deleteAt`) VALUES
(1, 1, NULL, 1, NULL, 'Ảnh đẹp', 3, 1, '2023-03-17 10:39:32', NULL, NULL),
(2, 3, NULL, 1, NULL, 'Ảnh đâu đây a? Đẹp thế. :D', 3, 1, '2023-03-19 06:39:17', NULL, NULL),
(3, 1, 2, 1, NULL, ':D Ảnh a lấy trên mạng :v', 3, 1, '2023-03-19 06:45:26', '2023-03-19 06:46:26', NULL),
(4, 4, NULL, NULL, 1, 'Sao buồn thế đại ca?', 3, 2, '2023-03-19 10:39:17', NULL, NULL),
(5, 1, 4, NULL, 1, 'Thèm rượu :v', NULL, 2, '2023-03-19 10:40:30', NULL, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `emoj`
--

CREATE TABLE `emoj` (
  `id` int(11) NOT NULL,
  `type_emoj` char(30) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `emoj`
--

INSERT INTO `emoj` (`id`, `type_emoj`) VALUES
(1, 'like'),
(2, 'haha'),
(3, 'love'),
(4, 'supprise'),
(5, 'angry');

-- --------------------------------------------------------

--
-- Table structure for table `friendship`
--

CREATE TABLE `friendship` (
  `id` int(11) NOT NULL,
  `userRequestID` int(11) DEFAULT NULL,
  `userAcceptID` int(11) DEFAULT NULL,
  `statusID` int(11) DEFAULT NULL,
  `createdAt` datetime DEFAULT NULL,
  `acceptedAt` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `friendship`
--

INSERT INTO `friendship` (`id`, `userRequestID`, `userAcceptID`, `statusID`, `createdAt`, `acceptedAt`) VALUES
(1, 3, 1, 4, '2023-03-16 10:39:32', NULL),
(2, 3, 1, 9, '2023-03-16 10:39:32', '2023-03-16 10:10:32'),
(19, 4, 1, 4, '2023-03-17 09:10:32', NULL),
(20, 4, 1, 9, '2023-03-17 09:10:32', '2023-03-17 10:10:32'),
(21, 5, 1, 4, '2023-03-18 09:10:32', '0000-00-00 00:00:00'),
(22, 5, 1, 9, '2023-03-18 09:10:32', '2023-03-18 09:20:32'),
(23, 6, 1, 4, '2023-03-18 19:10:32', '0000-00-00 00:00:00'),
(24, 6, 1, 9, '2023-03-18 19:10:32', '2023-03-18 20:10:32'),
(25, 7, 1, 4, '2023-03-19 19:10:32', '0000-00-00 00:00:00');

-- --------------------------------------------------------

--
-- Table structure for table `like`
--

CREATE TABLE `like` (
  `id` int(11) NOT NULL,
  `userID` int(11) DEFAULT NULL,
  `photoID` int(11) DEFAULT NULL,
  `postID` int(11) DEFAULT NULL,
  `emojID` int(11) DEFAULT NULL,
  `commentID` int(11) DEFAULT NULL,
  `typeID` int(11) DEFAULT NULL,
  `timeLike` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `like`
--

INSERT INTO `like` (`id`, `userID`, `photoID`, `postID`, `emojID`, `commentID`, `typeID`, `timeLike`) VALUES
(1, 1, 1, NULL, 1, NULL, 1, '2023-03-17 10:39:17'),
(2, 1, 1, NULL, 1, 1, 1, '2023-03-17 10:42:17'),
(3, 3, 1, NULL, 3, NULL, 1, '2023-03-19 06:39:17'),
(4, 1, 1, NULL, 1, 2, 1, '2023-03-19 06:45:26'),
(5, 4, NULL, 1, 3, NULL, 2, '2023-03-19 10:39:17'),
(6, 1, NULL, 1, 1, 4, 2, '2023-03-19 10:40:17');

-- --------------------------------------------------------

--
-- Table structure for table `location`
--

CREATE TABLE `location` (
  `id` int(11) NOT NULL,
  `zipcode` char(45) DEFAULT NULL,
  `street` char(45) DEFAULT NULL,
  `city` char(45) DEFAULT NULL,
  `country` char(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `location`
--

INSERT INTO `location` (`id`, `zipcode`, `street`, `city`, `country`) VALUES
(1, '280000', 'Phan Boi Chau', 'Vinh Yen', 'Viet Nam'),
(2, '100000', 'Xuân Tảo', 'Hà Nội', 'Việt Nam'),
(3, '100000', 'Minh Tảo', 'Hà Nội', 'Việt Nam'),
(4, '100000', 'Phạm Văn Đồng', 'Hà Nội', 'Việt Nam'),
(5, '100000', 'Cổ Nhuế', 'Hà Nội', 'Việt Nam'),
(6, '100000', 'Dịch Vọng Hậu', 'Hà Nội', 'Việt Nam'),
(7, '100000', 'Cầu Giấy', 'Hà Nội', 'Việt Nam'),
(8, '100000', 'Láng', 'Hà Nội', 'Việt Nam'),
(9, '100000', 'Trường Chính', 'Hà Nội', 'Việt Nam'),
(10, '100000', 'Lạc Long Quân', 'Hà Nội', 'Việt Nam');

-- --------------------------------------------------------

--
-- Table structure for table `photos`
--

CREATE TABLE `photos` (
  `id` int(11) NOT NULL,
  `albumID` int(11) DEFAULT NULL,
  `content` text DEFAULT NULL,
  `statusID` int(11) DEFAULT NULL,
  `locationID` int(11) DEFAULT NULL,
  `createdAt` datetime DEFAULT NULL,
  `updateAt` datetime DEFAULT NULL,
  `deleteAt` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `photos`
--

INSERT INTO `photos` (`id`, `albumID`, `content`, `statusID`, `locationID`, `createdAt`, `updateAt`, `deleteAt`) VALUES
(1, 1, 'https://cdn.vjshop.vn/tin-tuc/5-cach-cai-thien-bo-cuc-anh-phong-canh-thong-qua-phoi-sang-lau/cai-thien-anh-phong-canh-bang-phuong-phap-chup-phoi-sang-lau.jpg', 8, 1, '2023-03-17 09:10:32', NULL, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `posts`
--

CREATE TABLE `posts` (
  `id` int(11) NOT NULL,
  `albumID` int(11) DEFAULT NULL,
  `statusID` int(11) DEFAULT NULL,
  `tiltle` char(255) DEFAULT NULL,
  `content` text DEFAULT NULL,
  `createdAt` datetime DEFAULT NULL,
  `updateAt` datetime DEFAULT NULL,
  `deleteAt` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `posts`
--

INSERT INTO `posts` (`id`, `albumID`, `statusID`, `tiltle`, `content`, `createdAt`, `updateAt`, `deleteAt`) VALUES
(1, 2, 8, 'Để đây và không nói gì', 'https://img.thuthuattinhoc.vn/uploads/2019/01/13/hinh-nen-phong-canh-tim-mong-mo_105623354.jpg', '2023-03-18 09:10:32', NULL, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `relationships`
--

CREATE TABLE `relationships` (
  `id` int(11) NOT NULL,
  `typeRelationship` char(30) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `relationships`
--

INSERT INTO `relationships` (`id`, `typeRelationship`) VALUES
(1, 'Married'),
(2, 'Engaged'),
(3, 'In a relationship'),
(4, 'Single'),
(5, 'it\'s Complicated'),
(6, 'Unspecified');

-- --------------------------------------------------------

--
-- Table structure for table `stats`
--

CREATE TABLE `stats` (
  `id` int(11) NOT NULL,
  `photoID` int(11) DEFAULT NULL,
  `postID` int(11) DEFAULT NULL,
  `typeID` char(20) DEFAULT NULL,
  `viewCount` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `stats`
--

INSERT INTO `stats` (`id`, `photoID`, `postID`, `typeID`, `viewCount`) VALUES
(1, 1, NULL, '1', 1),
(2, 1, NULL, '1', 2),
(3, 1, NULL, '1', 3),
(4, 1, NULL, '1', 4),
(5, 1, NULL, '1', 5),
(6, 1, NULL, '1', 6),
(7, 1, NULL, '1', 7),
(8, NULL, 1, '2', 1),
(9, NULL, 1, '2', 2),
(10, NULL, 1, '2', 3),
(11, NULL, 1, '2', 4),
(12, NULL, 1, '2', 5),
(13, NULL, 1, '2', 6),
(14, NULL, 1, '2', 7),
(15, NULL, 1, '2', 8);

-- --------------------------------------------------------

--
-- Table structure for table `status`
--

CREATE TABLE `status` (
  `id` int(11) NOT NULL,
  `type` char(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `status`
--

INSERT INTO `status` (`id`, `type`) VALUES
(1, 'actived'),
(2, 'locked'),
(3, 'sent'),
(4, 'wait for confirmation'),
(5, 'hidden'),
(6, 'deleted'),
(7, 'only me'),
(8, 'public'),
(9, 'friend');

-- --------------------------------------------------------

--
-- Table structure for table `types`
--

CREATE TABLE `types` (
  `id` int(11) NOT NULL,
  `typeName` char(30) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `types`
--

INSERT INTO `types` (`id`, `typeName`) VALUES
(1, 'photo'),
(2, 'post');

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `id` int(11) NOT NULL,
  `email` char(30) DEFAULT NULL,
  `password` char(30) DEFAULT NULL,
  `avatar` text DEFAULT NULL,
  `firstName` char(30) DEFAULT NULL,
  `lastName` char(30) DEFAULT NULL,
  `genDer` char(50) DEFAULT NULL,
  `dateOfBirth` date DEFAULT NULL,
  `phone` char(11) DEFAULT NULL,
  `about` text DEFAULT NULL,
  `locationID` int(11) DEFAULT NULL,
  `relationshipID` int(11) DEFAULT NULL,
  `statusID` int(11) DEFAULT NULL,
  `createdAt` datetime DEFAULT NULL,
  `updateAt` datetime DEFAULT NULL,
  `deleteAt` datetime DEFAULT NULL,
  `activedAt` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`id`, `email`, `password`, `avatar`, `firstName`, `lastName`, `genDer`, `dateOfBirth`, `phone`, `about`, `locationID`, `relationshipID`, `statusID`, `createdAt`, `updateAt`, `deleteAt`, `activedAt`) VALUES
(1, 'tai@gmail.com', 'tai123', 'https://d1hjkbq40fs2x4.cloudfront.net/2017-08-21/files/landscape-photography_1645-t.jpg', 'dao', 'tai', 'male', '1992-11-22', '0123456789', 'anh tài đẹp trai, vô cùng đẹp trai', 1, 1, 1, '2010-03-13 22:10:32', NULL, NULL, '2010-03-13 22:15:32'),
(3, 'a@gmail.com', 'a123', 'https://thuthuatphanmem.vn/uploads/2018/08/21/hinh-nen-thien-nhien-phong-canh-dep-8_043142233.jpg', 'A', 'Nguyen', 'male', '1993-11-22', '0223456789', 'i\'m A', 2, 3, 1, '2013-03-13 22:10:32', NULL, NULL, '2013-03-13 22:11:32'),
(4, 'b@gmail.com', 'b123', 'https://img.thuthuattinhoc.vn/uploads/2019/01/13/anh-nen-dep-nhat_105620947.jpeg', 'B', 'Đỗ', 'female', '1994-11-22', '0224456789', 'i am B', 3, 2, 1, '2014-07-17 09:10:32', NULL, NULL, '2013-07-17 09:11:32'),
(5, 'c@gmail.com', 'c123', 'https://thuthuatphanmem.vn/uploads/2018/08/21/hinh-nen-thien-nhien-phong-canh-dep-8_043142233.jpg', 'C', 'Lê', 'male', '1995-11-22', '0224456489', 'i am C', 4, 4, 1, '2014-07-18 09:10:32', NULL, NULL, '2013-07-18 09:11:32'),
(6, 'd@gmail.com', 'd123', 'https://itqnu.vn/wp-content/uploads/2023/02/49861659438_e4ccb14842_o.jpg', 'D', 'Trương', 'male', '1995-11-25', '0224436489', 'i am D', 5, 4, 1, '2014-07-19 09:10:32', NULL, NULL, '2013-07-19 09:11:32'),
(7, 'e@gmail.com', 'e123', 'https://thuthuatphanmem.vn/uploads/2018/08/21/hinh-nen-thien-nhien-phong-canh-dep-8_043142233.jpg', 'E', 'Cầm', 'female', '1996-11-22', '0224456459', 'i am E', 6, 5, 1, '2014-07-19 09:10:32', NULL, NULL, '2013-07-19 09:11:32');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `albums`
--
ALTER TABLE `albums`
  ADD PRIMARY KEY (`id`),
  ADD KEY `userID` (`userID`);

--
-- Indexes for table `comment`
--
ALTER TABLE `comment`
  ADD PRIMARY KEY (`id`),
  ADD KEY `userID` (`userID`),
  ADD KEY `commentID` (`commentID`),
  ADD KEY `photoID` (`photoID`),
  ADD KEY `postID` (`postID`);

--
-- Indexes for table `emoj`
--
ALTER TABLE `emoj`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `friendship`
--
ALTER TABLE `friendship`
  ADD PRIMARY KEY (`id`),
  ADD KEY `userRequestID` (`userRequestID`),
  ADD KEY `userAcceptID` (`userAcceptID`);

--
-- Indexes for table `like`
--
ALTER TABLE `like`
  ADD PRIMARY KEY (`id`),
  ADD KEY `commentID` (`commentID`),
  ADD KEY `photoID` (`photoID`),
  ADD KEY `postID` (`postID`),
  ADD KEY `typeID` (`typeID`),
  ADD KEY `fk_like_emoj` (`emojID`);

--
-- Indexes for table `location`
--
ALTER TABLE `location`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `photos`
--
ALTER TABLE `photos`
  ADD PRIMARY KEY (`id`),
  ADD KEY `albumID` (`albumID`);

--
-- Indexes for table `posts`
--
ALTER TABLE `posts`
  ADD PRIMARY KEY (`id`),
  ADD KEY `albumID` (`albumID`);

--
-- Indexes for table `relationships`
--
ALTER TABLE `relationships`
  ADD KEY `Key` (`id`);

--
-- Indexes for table `stats`
--
ALTER TABLE `stats`
  ADD PRIMARY KEY (`id`),
  ADD KEY `photoID` (`photoID`),
  ADD KEY `postID` (`postID`);

--
-- Indexes for table `status`
--
ALTER TABLE `status`
  ADD KEY `Key` (`id`);

--
-- Indexes for table `types`
--
ALTER TABLE `types`
  ADD KEY `Key` (`id`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `email` (`email`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `albums`
--
ALTER TABLE `albums`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `comment`
--
ALTER TABLE `comment`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `emoj`
--
ALTER TABLE `emoj`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `friendship`
--
ALTER TABLE `friendship`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=26;

--
-- AUTO_INCREMENT for table `like`
--
ALTER TABLE `like`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT for table `location`
--
ALTER TABLE `location`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT for table `photos`
--
ALTER TABLE `photos`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `posts`
--
ALTER TABLE `posts`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `relationships`
--
ALTER TABLE `relationships`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT for table `stats`
--
ALTER TABLE `stats`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;

--
-- AUTO_INCREMENT for table `status`
--
ALTER TABLE `status`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT for table `types`
--
ALTER TABLE `types`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `users`
--
ALTER TABLE `users`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `albums`
--
ALTER TABLE `albums`
  ADD CONSTRAINT `albums_ibfk_1` FOREIGN KEY (`userID`) REFERENCES `users` (`id`);

--
-- Constraints for table `comment`
--
ALTER TABLE `comment`
  ADD CONSTRAINT `comment_ibfk_1` FOREIGN KEY (`userID`) REFERENCES `users` (`id`),
  ADD CONSTRAINT `comment_ibfk_2` FOREIGN KEY (`commentID`) REFERENCES `comment` (`id`),
  ADD CONSTRAINT `comment_ibfk_3` FOREIGN KEY (`photoID`) REFERENCES `photos` (`id`),
  ADD CONSTRAINT `comment_ibfk_4` FOREIGN KEY (`postID`) REFERENCES `posts` (`id`);

--
-- Constraints for table `friendship`
--
ALTER TABLE `friendship`
  ADD CONSTRAINT `friendship_ibfk_1` FOREIGN KEY (`userRequestID`) REFERENCES `users` (`id`),
  ADD CONSTRAINT `friendship_ibfk_2` FOREIGN KEY (`userAcceptID`) REFERENCES `users` (`id`);

--
-- Constraints for table `like`
--
ALTER TABLE `like`
  ADD CONSTRAINT `fk_like_emoj` FOREIGN KEY (`emojID`) REFERENCES `emoj` (`id`),
  ADD CONSTRAINT `like_ibfk_1` FOREIGN KEY (`commentID`) REFERENCES `comment` (`id`),
  ADD CONSTRAINT `like_ibfk_2` FOREIGN KEY (`photoID`) REFERENCES `photos` (`id`),
  ADD CONSTRAINT `like_ibfk_3` FOREIGN KEY (`postID`) REFERENCES `posts` (`id`),
  ADD CONSTRAINT `like_ibfk_4` FOREIGN KEY (`typeID`) REFERENCES `types` (`id`);

--
-- Constraints for table `photos`
--
ALTER TABLE `photos`
  ADD CONSTRAINT `photos_ibfk_1` FOREIGN KEY (`albumID`) REFERENCES `albums` (`id`);

--
-- Constraints for table `posts`
--
ALTER TABLE `posts`
  ADD CONSTRAINT `posts_ibfk_1` FOREIGN KEY (`albumID`) REFERENCES `albums` (`id`);

--
-- Constraints for table `stats`
--
ALTER TABLE `stats`
  ADD CONSTRAINT `stats_ibfk_1` FOREIGN KEY (`photoID`) REFERENCES `photos` (`id`),
  ADD CONSTRAINT `stats_ibfk_2` FOREIGN KEY (`postID`) REFERENCES `posts` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
