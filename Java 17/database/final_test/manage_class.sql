-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Apr 02, 2023 at 12:11 PM
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
-- Database: `manage_class`
--

-- --------------------------------------------------------

--
-- Table structure for table `attendances`
--

CREATE TABLE `attendances` (
  `id` int(11) NOT NULL,
  `student_id` int(11) DEFAULT NULL,
  `subject_id` int(11) DEFAULT NULL,
  `is_attend` tinyint(1) DEFAULT NULL,
  `created_at` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `attendances`
--

INSERT INTO `attendances` (`id`, `student_id`, `subject_id`, `is_attend`, `created_at`) VALUES
(1, 1, 8, 1, '2023-03-30 18:03:55'),
(2, 3, 8, 1, '2023-03-30 18:03:55'),
(3, 4, 8, 1, '2023-03-30 18:03:55'),
(4, 5, 8, 1, '2023-03-30 18:03:55'),
(5, 6, 8, 1, '2023-03-30 18:03:55'),
(6, 7, 8, 1, '2023-03-30 18:03:55'),
(7, 8, 8, 1, '2023-03-30 18:03:55'),
(8, 9, 8, 1, '2023-03-30 18:03:55'),
(9, 10, 8, 1, '2023-03-30 18:03:55'),
(10, 11, 8, 1, '2023-03-30 18:03:55'),
(11, 5, 12, 0, '2023-03-31 18:03:55'),
(12, 5, 12, 0, '2023-04-01 18:03:55'),
(13, 8, 7, 0, '2023-03-01 19:04:39');

-- --------------------------------------------------------

--
-- Table structure for table `classes`
--

CREATE TABLE `classes` (
  `id` int(11) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `course_id` int(11) DEFAULT NULL,
  `description` text DEFAULT NULL,
  `status_id` int(11) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `start_at` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `end_at` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `classes`
--

INSERT INTO `classes` (`id`, `name`, `course_id`, `description`, `status_id`, `address`, `start_at`, `end_at`) VALUES
(1, 'Java16', 3, 'Học 18h30 - 21h30 thứ 2, 4, 6', 10, 'Tố Hữu, Hà Nội', '2022-09-30 17:31:07', '2023-05-18 17:31:07'),
(2, 'Java17', 3, 'học 18h30 - 21h30 thứ 3,5,7', 10, 'Dịch Vọng Hậu, Hà Nội', '2022-11-03 17:31:07', '2023-06-19 17:31:07'),
(3, 'AWS 19', 5, 'Học tối thứ 7, CN', 9, 'online', '2022-10-17 05:40:15', '2023-05-14 10:06:20');

-- --------------------------------------------------------

--
-- Table structure for table `classrooms`
--

CREATE TABLE `classrooms` (
  `id` int(11) NOT NULL,
  `user_id` int(11) DEFAULT NULL,
  `class_id` int(11) DEFAULT NULL,
  `subject_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `classrooms`
--

INSERT INTO `classrooms` (`id`, `user_id`, `class_id`, `subject_id`) VALUES
(1, 1, 2, NULL),
(2, 3, 2, NULL),
(3, 4, 2, NULL),
(4, 5, 2, NULL),
(5, 6, 2, NULL),
(6, 7, 2, NULL),
(7, 8, 2, NULL),
(8, 9, 2, NULL),
(9, 10, 2, NULL),
(10, 11, 2, NULL),
(11, 12, 2, 8),
(12, 13, 2, 12),
(13, 14, 2, 7),
(14, 13, 1, 12),
(15, 14, 1, 7),
(16, 15, 3, NULL),
(17, 16, 3, NULL),
(18, 17, 3, 11),
(19, 13, 2, 1);

-- --------------------------------------------------------

--
-- Table structure for table `comments`
--

CREATE TABLE `comments` (
  `id` int(11) NOT NULL,
  `user_id` int(11) DEFAULT NULL,
  `content` text DEFAULT NULL,
  `status_id` int(11) DEFAULT NULL,
  `created_at` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `updated_at` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `deleted_at` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `comments`
--

INSERT INTO `comments` (`id`, `user_id`, `content`, `status_id`, `created_at`, `updated_at`, `deleted_at`) VALUES
(1, 1, 'Khóa học rất ok, Giảng viên cũng rất xịn xò. Giá cả thì ổn áp hơn nhiều so với các trung tâm khác', 14, '2023-03-22 18:13:26', '0000-00-00 00:00:00', '0000-00-00 00:00:00'),
(2, 15, 'Good job Techmaster!', 14, '2023-03-24 09:03:21', '0000-00-00 00:00:00', '0000-00-00 00:00:00'),
(3, 16, 'Go for it!', 14, '2023-03-24 09:03:21', '0000-00-00 00:00:00', '0000-00-00 00:00:00');

-- --------------------------------------------------------

--
-- Table structure for table `courses`
--

CREATE TABLE `courses` (
  `id` int(11) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `infomation` text DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `courses`
--

INSERT INTO `courses` (`id`, `name`, `infomation`) VALUES
(1, 'Bootcamp Full Stack Web', '\r\n- Hoàn lại 100% học phí + 10 triệu VND nếu sinh viên không xin được việc\r\n- 5 tháng học toàn thời gian + 1 tháng thực tập có lương tại doanh nghiệp\r\n- Giảng viên hướng dẫn 1:1 kết hợp làm việc nhóm 2-3 sinh viên\r\n- 8 tiếng mỗi ngày, 5 ngày 1 tuần, thời lượng thực hành tăng gấp 3\r\n- Nội dung học giúp học viên làm đa dạng nhiều kỹ năng, dễ kiếm việc làm hơn: thêm Node.js, database, mongodb, docker'),
(2, 'Web Front End + React', 'Học lập trình Web Frontend + React 5 tháng 60 buổi với hình thức đào tạo Offline hoặc 7 tháng 84 buổi với hình thức đào tạo Online. Cam kết việc làm cho học viên sau khi tốt nghiệp với cả hai hình thức đào tạo. Đội ngũ Giảng viên dày dặn kinh nghiệm, Giáo trình đào tạo bài bản, liên tục cập nhật các kiến thức mới nhất, bám sát thực tế khi làm việc.'),
(3, 'Full Stack Java\r\n', 'Khoá học lập trình Full Stack Java bằng Java SpringBoot Fullstack đào tạo học viên xây dựng hoàn thiện trang web từ Frontend đến Backend với Java. Toàn bộ giáo trình xây dựng cho học viên bắt đầu học lập trình từ con số 0 tới khi hoàn thiện được sản phẩm cụ thể. Lộ trình học dài hạn trong 7 tháng với cam kết việc làm cho học viên'),
(4, 'DevOps', '33 buổi học tương đương gần 3 tháng, được học cùng chuyên gia với những kiến thức có thể áp dụng được ngay vào thực tế công việc: Cài đặt sử dụng Linux, Quản lý version với Git, Configuration Management sử dụng Terraform, đóng gói và triển khai ứng dụng với Docker + Kubernetes,...'),
(5, 'Amazon Web Service', 'Nội dung học bao gồm 2 chứng chỉ Solution Architect và Developer, bao quát các dịch vụ AWS đang được ứng dụng rộng rãi nhất\r\n3 tháng học với chuyên gia tương đương 1 năm tự học, tiết kiệm thời gian, tăng tỉ lệ thi đỗ chứng chỉ AWS từ 40% lên 80%\r\nThực hành AWS với 120 video + bài lab thực tế trên các ngôn ngữ Python, Java, Golang: giảng viên thao tác hướng dẫn tỉ mỉ\r\n700 câu hỏi AWS Tiếng Anh có đầy đủ đáp án. 300 câu hỏi được giảng viên giải đáp kĩ lưỡng mỗi buổi học\r\nMỗi học viên sở hữu vĩnh viễn 1 tài khoản giáo trình Microlearning trên hệ thống Techmaster\r\nMôi trường học hỏi năng động, đa chiều, hỏi đáp với với giảng viên và nhiều bạn học từ các công ty đang sử dụng AWS');

-- --------------------------------------------------------

--
-- Table structure for table `homeworks`
--

CREATE TABLE `homeworks` (
  `id` int(11) NOT NULL,
  `lesson_id` int(11) DEFAULT NULL,
  `student_id` int(11) DEFAULT NULL,
  `content` text DEFAULT NULL,
  `created_at` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `homeworks`
--

INSERT INTO `homeworks` (`id`, `lesson_id`, `student_id`, `content`, `created_at`) VALUES
(1, 14, 1, 'Link bài tập', '2023-03-31 17:51:51'),
(2, 14, 3, 'Link bài tập', '2023-03-31 17:51:51'),
(3, 14, 4, 'Link bài tập', '2023-03-31 17:51:51'),
(4, 14, 5, 'Link bài tập', '2023-03-31 17:51:51'),
(5, 14, 6, 'Link bài tập', '2023-03-31 17:51:51'),
(6, 14, 7, 'Link bài tập', '2023-03-31 17:51:51'),
(7, 14, 8, 'Link bài tập', '2023-03-31 17:51:51'),
(8, 14, 9, 'Link bài tập', '2023-03-31 17:51:51'),
(9, 14, 10, 'Link bài tập', '2023-03-31 17:51:51'),
(10, 14, 11, 'Link bài tập', '2023-03-31 17:51:51');

-- --------------------------------------------------------

--
-- Table structure for table `lessons`
--

CREATE TABLE `lessons` (
  `id` int(11) NOT NULL,
  `teacher_id` int(11) DEFAULT NULL,
  `subject_id` int(11) DEFAULT NULL,
  `title` char(255) DEFAULT NULL,
  `Content` text DEFAULT NULL,
  `type` char(255) DEFAULT NULL,
  `status_id` int(11) DEFAULT NULL,
  `created_at` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `updated_at` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `deleted_at` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `lessons`
--

INSERT INTO `lessons` (`id`, `teacher_id`, `subject_id`, `title`, `Content`, `type`, `status_id`, `created_at`, `updated_at`, `deleted_at`) VALUES
(8, 13, 1, 'HTML cơ bản', 'HTML cơ bản', 'Bài giảng', 11, '2021-04-21 17:42:31', '2021-05-21 17:42:31', '0000-00-00 00:00:00'),
(9, 13, 1, 'CSS cơ bản + hướng dẫn sử dụng Git', 'Link bài', 'Bài giảng', 11, '2021-04-21 17:42:31', '0000-00-00 00:00:00', '0000-00-00 00:00:00'),
(10, 13, 1, 'Dàn layout với flex box', 'abc', 'Bài giảng', 11, '2021-04-21 17:42:31', '0000-00-00 00:00:00', '0000-00-00 00:00:00'),
(11, 13, 12, 'Nhập xuất trong Java', 'abc', 'Bài giảng', 11, '2021-04-21 17:42:31', '0000-00-00 00:00:00', '0000-00-00 00:00:00'),
(12, 14, 7, 'Mảng và Chuỗi | Array & String (DB)', 'abc', 'Bài giảng', 11, '2021-04-21 17:42:31', '0000-00-00 00:00:00', '0000-00-00 00:00:00'),
(13, 12, 8, 'Giới thiệu về Database', 'abc', 'Bài giảng', 11, '2021-04-21 17:42:31', '0000-00-00 00:00:00', '0000-00-00 00:00:00'),
(14, 12, 8, 'JOIN TABLE (DB)', 'abc', 'Bài tập', 11, '2021-04-21 17:42:31', '0000-00-00 00:00:00', '0000-00-00 00:00:00');

-- --------------------------------------------------------

--
-- Table structure for table `marks`
--

CREATE TABLE `marks` (
  `id` int(11) NOT NULL,
  `teacher_id` int(11) DEFAULT NULL,
  `homework_id` int(11) DEFAULT NULL,
  `score` decimal(5,2) DEFAULT NULL,
  `comment` text DEFAULT NULL,
  `created_at` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `updated_at` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `deleted_at` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `marks`
--

INSERT INTO `marks` (`id`, `teacher_id`, `homework_id`, `score`, `comment`, `created_at`, `updated_at`, `deleted_at`) VALUES
(1, 12, 1, '9.60', 'Well done!', '2023-04-01 17:55:12', '0000-00-00 00:00:00', '0000-00-00 00:00:00'),
(2, 12, 10, '9.30', 'Good Job!', '2023-04-01 17:55:12', '0000-00-00 00:00:00', '0000-00-00 00:00:00'),
(3, 12, 8, '9.00', 'Good!', '2023-04-01 17:55:12', '0000-00-00 00:00:00', '0000-00-00 00:00:00'),
(4, 12, 2, '8.80', 'Well done!', '2023-04-01 17:55:12', '0000-00-00 00:00:00', '0000-00-00 00:00:00'),
(5, 12, 3, '8.60', 'Good Job!', '2023-04-01 17:55:12', '0000-00-00 00:00:00', '0000-00-00 00:00:00'),
(6, 12, 4, '8.50', 'Good!', '2023-04-01 17:55:12', '0000-00-00 00:00:00', '0000-00-00 00:00:00'),
(7, 12, 5, '8.90', 'Well done!', '2023-04-01 17:55:12', '0000-00-00 00:00:00', '0000-00-00 00:00:00'),
(8, 12, 6, '8.00', 'Good Job!', '2023-04-01 17:55:12', '0000-00-00 00:00:00', '0000-00-00 00:00:00'),
(9, 12, 7, '7.00', 'Good!', '2023-04-01 17:55:12', '0000-00-00 00:00:00', '0000-00-00 00:00:00'),
(10, 12, 9, '7.60', 'Well done!', '2023-04-01 17:55:12', '0000-00-00 00:00:00', '0000-00-00 00:00:00');

-- --------------------------------------------------------

--
-- Table structure for table `status`
--

CREATE TABLE `status` (
  `id` int(11) NOT NULL,
  `key` char(30) DEFAULT NULL,
  `value` char(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `status`
--

INSERT INTO `status` (`id`, `key`, `value`) VALUES
(1, 'User', 'Actived'),
(2, 'User', 'Baned'),
(9, 'Class', 'online'),
(10, 'Class', 'offline'),
(11, 'lesson', 'on'),
(12, 'lesson', 'off'),
(13, 'Comment', 'hidden'),
(14, 'Comment', 'show');

-- --------------------------------------------------------

--
-- Table structure for table `subjects`
--

CREATE TABLE `subjects` (
  `id` int(11) NOT NULL,
  `name` char(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `subjects`
--

INSERT INTO `subjects` (`id`, `name`) VALUES
(1, 'Web căn bản (HTML, CSS)'),
(2, 'JavaScript'),
(3, 'Thiết kế UI/UX'),
(4, 'ReactJS'),
(5, 'NodeJS'),
(6, 'Project Web tĩnh'),
(7, 'Data structure and Algorithm'),
(8, 'Database'),
(9, 'Spring boot'),
(10, 'DevOps'),
(11, 'AWS'),
(12, 'Java Core');

-- --------------------------------------------------------

--
-- Table structure for table `type_of_comments`
--

CREATE TABLE `type_of_comments` (
  `id` int(11) NOT NULL,
  `model_has_comment` int(11) DEFAULT NULL,
  `type` char(30) DEFAULT NULL,
  `comment_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `type_of_comments`
--

INSERT INTO `type_of_comments` (`id`, `model_has_comment`, `type`, `comment_id`) VALUES
(2, 3, 'Course', 1),
(3, 5, 'Course', 2),
(4, 5, 'Course', 3);

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `id` int(11) NOT NULL,
  `email` char(30) DEFAULT NULL,
  `password` char(30) DEFAULT NULL,
  `avatar` text DEFAULT NULL,
  `first_name` char(30) DEFAULT NULL,
  `last_name` char(30) DEFAULT NULL,
  `genDer` char(50) DEFAULT NULL,
  `date_of_birth` date DEFAULT NULL,
  `phone` char(11) DEFAULT NULL,
  `about` text DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `status_id` int(11) DEFAULT NULL,
  `role` char(30) DEFAULT NULL,
  `created_at` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `updated_at` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `deleted_at` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`id`, `email`, `password`, `avatar`, `first_name`, `last_name`, `genDer`, `date_of_birth`, `phone`, `about`, `address`, `status_id`, `role`, `created_at`, `updated_at`, `deleted_at`) VALUES
(1, 'tai@gmail.com', 'tai123', NULL, 'Dao', 'Tai', 'male', '1992-11-22', '0969957697', 'Bộ đội xuất ngũ', 'Bắc Từ Liêm, Hà Nội', 1, 'Student', '2022-10-19 07:05:38', '0000-00-00 00:00:00', '0000-00-00 00:00:00'),
(2, 'admin@gmail.com', 'admin123', NULL, 'admin', 'admin', NULL, NULL, NULL, 'admin', 'Hà Nội', 1, 'Admin', '2016-04-20 19:15:43', '0000-00-00 00:00:00', '0000-00-00 00:00:00'),
(3, 'Long@gmail.com', 'long123', NULL, 'Tran', 'Long', 'male', '1998-11-22', '0986372724', 'Học đại học bách khoa năm cuối', 'Hà Nội', 1, 'Student', '2022-11-20 17:14:18', '0000-00-00 00:00:00', '0000-00-00 00:00:00'),
(4, 'kien@gmail.com', 'kien123', NULL, 'Nguyen', 'Kien', 'male', '1993-11-22', '0123456789', 'Nhà xa ở Đông Anh. Ngày đi làm', 'Đông Anh, Hà Nội', 1, 'Student', '2022-10-13 17:16:39', '0000-00-00 00:00:00', '0000-00-00 00:00:00'),
(5, 'loc@gmail.com', 'loc123', NULL, 'Nguyen', 'Loc', 'male', '1998-11-22', '0987422726', 'Nhà xa', 'Vĩnh Tuy, HN', 1, 'Student', '2022-10-14 17:17:49', '0000-00-00 00:00:00', '0000-00-00 00:00:00'),
(6, 'toan@gmail.com', 'toan123', NULL, 'Vu', 'Toan', 'male', '2023-04-20', '098765432', 'Ngày đi làm', 'Hà Nội', 1, 'Student', '2022-10-14 17:17:49', '0000-00-00 00:00:00', '0000-00-00 00:00:00'),
(7, 'thang@gmail.com', 'thang123', NULL, 'Vuong', 'Thang', 'male', '1998-11-22', '0223456789', 'Bình luận viên, học KTQD', 'Hà nội', 1, 'Student', '2022-10-14 17:17:49', '0000-00-00 00:00:00', '0000-00-00 00:00:00'),
(8, 'hien@gmail.com', 'hien123', NULL, 'Nguyen', 'HIển', 'male', '1996-04-20', '091234567', 'Làm xây dựng. Bố làm to quân đội', 'An Bình city, Hà Nội', 1, 'Student', '2022-10-14 17:17:49', '0000-00-00 00:00:00', '0000-00-00 00:00:00'),
(9, 'trong@gmail.com', 'trong1213', NULL, 'Tran', 'Trong', 'male', '2003-11-22', '0123456789', 'Nhà gần trung tâm, ko học đại học', 'Dịch vọng Hậu, Hà nội', 1, 'Student', '2022-10-14 17:17:49', '0000-00-00 00:00:00', '0000-00-00 00:00:00'),
(10, 'dung@gmail.com', 'dung123', NULL, 'Pham', 'Dung', 'male', '1996-04-20', '012345678', 'Đi Nhật về', 'Hà Nội', 1, 'Student', '2022-10-14 17:17:49', '0000-00-00 00:00:00', '0000-00-00 00:00:00'),
(11, 'anh@gmail.com', 'anh123', NULL, 'Nguyen', 'Anh', 'male', '1998-11-22', '0123456789', 'Thông minh', 'Hà Nội', 1, 'Student', '2022-10-14 17:17:49', '0000-00-00 00:00:00', '0000-00-00 00:00:00'),
(12, 'phong@gmail.com', 'phong123', NULL, 'Tran', 'Phong', 'male', '1996-11-22', '0123456789', 'Database', 'Hà Nội', 1, 'Teacher', '2022-09-14 17:17:49', '0000-00-00 00:00:00', '0000-00-00 00:00:00'),
(13, 'HienGV@gmail.com', 'hien123', NULL, 'Nguyen', 'Hien', 'male', '1996-04-20', '0123456789', 'Java core, HTML, CSS', 'Hà Nội', 1, 'Teacher', '2021-10-14 17:17:49', '0000-00-00 00:00:00', '0000-00-00 00:00:00'),
(14, 'duc@gmail.com', 'duc123', NULL, 'Tran', 'Duc', 'male', '1998-04-19', '012345678', 'data structure and algorithm', 'Hà Nội', 1, 'Teacher', '2021-10-14 17:17:49', '0000-00-00 00:00:00', '0000-00-00 00:00:00'),
(15, 'messi@gmail.com', 'messi123', NULL, 'Leonel', 'Messi', 'male', '1987-11-22', '0123456789', 'cầu thủ đá bong muốn chuyển sang làm IT vì đam mê', 'Argentina', 1, 'student', '2022-10-24 05:35:59', '0000-00-00 00:00:00', '0000-00-00 00:00:00'),
(16, 'ronaldo@gmail.com', 'ronaldo123', NULL, 'Christiano', 'Ronaldo', 'male', '1985-04-20', '0123456789', 'cầu thủ bóng đá muốn chuyển sang IT', 'Portugal', 1, 'student', '2022-11-01 05:35:59', '0000-00-00 00:00:00', '0000-00-00 00:00:00'),
(17, 'Alex_Feguson@gmail.com', 'Alex_Feguson123', NULL, 'Alex', 'Feguson', 'male', '1956-11-22', '0123456789', 'Legend of AWS', 'England', 1, 'Teacher', '2021-04-08 05:46:10', '0000-00-00 00:00:00', '0000-00-00 00:00:00');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `attendances`
--
ALTER TABLE `attendances`
  ADD PRIMARY KEY (`id`),
  ADD KEY `student_id` (`student_id`);

--
-- Indexes for table `classes`
--
ALTER TABLE `classes`
  ADD PRIMARY KEY (`id`),
  ADD KEY `course_id` (`course_id`),
  ADD KEY `status_id` (`status_id`);

--
-- Indexes for table `classrooms`
--
ALTER TABLE `classrooms`
  ADD PRIMARY KEY (`id`),
  ADD KEY `user_id` (`user_id`),
  ADD KEY `class_id` (`class_id`),
  ADD KEY `fk_classroom_subject` (`subject_id`);

--
-- Indexes for table `comments`
--
ALTER TABLE `comments`
  ADD PRIMARY KEY (`id`),
  ADD KEY `user_id` (`user_id`),
  ADD KEY `status_id` (`status_id`);

--
-- Indexes for table `courses`
--
ALTER TABLE `courses`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `homeworks`
--
ALTER TABLE `homeworks`
  ADD PRIMARY KEY (`id`),
  ADD KEY `lesson_id` (`lesson_id`),
  ADD KEY `student_id` (`student_id`);

--
-- Indexes for table `lessons`
--
ALTER TABLE `lessons`
  ADD PRIMARY KEY (`id`),
  ADD KEY `teacher_id` (`teacher_id`),
  ADD KEY `status_id` (`status_id`),
  ADD KEY `subject_id` (`subject_id`);

--
-- Indexes for table `marks`
--
ALTER TABLE `marks`
  ADD PRIMARY KEY (`id`),
  ADD KEY `teacher_id` (`teacher_id`),
  ADD KEY `homework_id` (`homework_id`);

--
-- Indexes for table `status`
--
ALTER TABLE `status`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `subjects`
--
ALTER TABLE `subjects`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `type_of_comments`
--
ALTER TABLE `type_of_comments`
  ADD PRIMARY KEY (`id`),
  ADD KEY `comment_id` (`comment_id`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`id`),
  ADD KEY `status_id` (`status_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `attendances`
--
ALTER TABLE `attendances`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;

--
-- AUTO_INCREMENT for table `classes`
--
ALTER TABLE `classes`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `classrooms`
--
ALTER TABLE `classrooms`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=20;

--
-- AUTO_INCREMENT for table `comments`
--
ALTER TABLE `comments`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `courses`
--
ALTER TABLE `courses`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `homeworks`
--
ALTER TABLE `homeworks`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT for table `lessons`
--
ALTER TABLE `lessons`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;

--
-- AUTO_INCREMENT for table `marks`
--
ALTER TABLE `marks`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT for table `status`
--
ALTER TABLE `status`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;

--
-- AUTO_INCREMENT for table `subjects`
--
ALTER TABLE `subjects`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- AUTO_INCREMENT for table `type_of_comments`
--
ALTER TABLE `type_of_comments`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `users`
--
ALTER TABLE `users`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=18;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `attendances`
--
ALTER TABLE `attendances`
  ADD CONSTRAINT `attendances_ibfk_1` FOREIGN KEY (`student_id`) REFERENCES `users` (`id`);

--
-- Constraints for table `classes`
--
ALTER TABLE `classes`
  ADD CONSTRAINT `classes_ibfk_1` FOREIGN KEY (`course_id`) REFERENCES `courses` (`id`),
  ADD CONSTRAINT `classes_ibfk_2` FOREIGN KEY (`status_id`) REFERENCES `status` (`id`);

--
-- Constraints for table `classrooms`
--
ALTER TABLE `classrooms`
  ADD CONSTRAINT `classrooms_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`),
  ADD CONSTRAINT `classrooms_ibfk_2` FOREIGN KEY (`class_id`) REFERENCES `classes` (`id`),
  ADD CONSTRAINT `fk_classroom_subject` FOREIGN KEY (`subject_id`) REFERENCES `subjects` (`id`);

--
-- Constraints for table `comments`
--
ALTER TABLE `comments`
  ADD CONSTRAINT `comments_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`),
  ADD CONSTRAINT `comments_ibfk_2` FOREIGN KEY (`status_id`) REFERENCES `status` (`id`);

--
-- Constraints for table `homeworks`
--
ALTER TABLE `homeworks`
  ADD CONSTRAINT `homeworks_ibfk_1` FOREIGN KEY (`lesson_id`) REFERENCES `lessons` (`id`),
  ADD CONSTRAINT `homeworks_ibfk_2` FOREIGN KEY (`student_id`) REFERENCES `users` (`id`);

--
-- Constraints for table `lessons`
--
ALTER TABLE `lessons`
  ADD CONSTRAINT `lessons_ibfk_1` FOREIGN KEY (`teacher_id`) REFERENCES `users` (`id`),
  ADD CONSTRAINT `lessons_ibfk_2` FOREIGN KEY (`status_id`) REFERENCES `status` (`id`),
  ADD CONSTRAINT `lessons_ibfk_3` FOREIGN KEY (`subject_id`) REFERENCES `subjects` (`id`);

--
-- Constraints for table `marks`
--
ALTER TABLE `marks`
  ADD CONSTRAINT `marks_ibfk_1` FOREIGN KEY (`teacher_id`) REFERENCES `users` (`id`),
  ADD CONSTRAINT `marks_ibfk_2` FOREIGN KEY (`homework_id`) REFERENCES `homeworks` (`id`);

--
-- Constraints for table `users`
--
ALTER TABLE `users`
  ADD CONSTRAINT `users_ibfk_1` FOREIGN KEY (`status_id`) REFERENCES `status` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
