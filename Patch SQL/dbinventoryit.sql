-- phpMyAdmin SQL Dump
-- version 4.7.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jan 27, 2018 at 08:13 AM
-- Server version: 10.1.29-MariaDB
-- PHP Version: 7.2.0

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `dbinventoryit`
--
CREATE DATABASE IF NOT EXISTS `dbinventoryit` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `dbinventoryit`;

-- --------------------------------------------------------

--
-- Table structure for table `tbbarangrusak`
--

CREATE TABLE `tbbarangrusak` (
  `IdBarangRusak` int(10) NOT NULL,
  `IdBarang` int(10) NOT NULL,
  `IdKaryawan` int(10) NOT NULL,
  `TanggalBeli` date NOT NULL,
  `TanggalRusak` date NOT NULL,
  `Keterangan` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbbarangrusak`
--

INSERT INTO `tbbarangrusak` (`IdBarangRusak`, `IdBarang`, `IdKaryawan`, `TanggalBeli`, `TanggalRusak`, `Keterangan`) VALUES
(2, 2, 19, '2018-01-21', '2018-01-30', 'coba'),
(5, 1, 20, '2018-01-26', '2018-01-29', ''),
(6, 3, 17, '2018-01-22', '2018-01-31', ''),
(7, 3, 1, '2018-01-22', '2018-01-22', ''),
(8, 3, 42, '2018-01-22', '2018-01-22', ''),
(9, 1, 17, '2018-01-25', '2018-01-25', ''),
(10, 11, 17, '2018-01-25', '2018-01-25', ''),
(11, 12, 17, '2018-01-25', '2018-01-25', '');

-- --------------------------------------------------------

--
-- Table structure for table `tbhistory`
--

CREATE TABLE `tbhistory` (
  `IdHistory` int(10) NOT NULL,
  `Username` varchar(25) NOT NULL,
  `Activity` varchar(250) NOT NULL,
  `DateAndTime` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbhistory`
--

INSERT INTO `tbhistory` (`IdHistory`, `Username`, `Activity`, `DateAndTime`) VALUES
(1, 'Admin', 'Berhasil Ubah Data Password', '2018-01-06 08:10:00'),
(2, 'Martono', 'Berhasil Ubah Data Password', '2018-01-06 08:10:42'),
(3, 'Admin', 'Berhasil Ubah Data Password', '2018-01-06 08:43:02'),
(4, 'Admin', 'Berhasil Ubah Data Password', '2018-01-06 08:43:20'),
(5, 'Admin', 'Berhasil menghapus  data Vendor', '2018-01-06 10:05:31'),
(6, 'Admin', 'Berhasil menghapus  data Vendor', '2018-01-06 10:05:59'),
(7, 'Admin', 'Berhasil Ubah Data Vendor', '2018-01-06 10:06:11'),
(8, 'Admin', 'Berhasil menghapus  data Vendor', '2018-01-06 12:00:02'),
(9, 'Admin', 'Berhasil menghapus  data Vendor', '2018-01-06 12:00:13'),
(10, 'Admin', 'Berhasil Ubah Data Jenis Barang', '2018-01-06 13:18:17'),
(11, 'Admin', 'Berhasil Ubah Data Jenis Barang', '2018-01-06 13:19:27'),
(12, 'Admin', 'Berhasil menghapus  data Jenis Barang', '2018-01-06 13:19:43'),
(13, 'Admin', 'Berhasil Ubah Data Password', '2018-01-06 19:46:23'),
(14, 'Admin', 'Berhasil menghapus data Vendor', '2018-01-07 11:20:46'),
(15, 'Admin', 'Berhasil menghapus data  Tambah User Baru', '2018-01-07 14:30:37'),
(16, 'Admin', 'Berhasil Ubah Data Password', '2018-01-07 18:54:19'),
(17, 'Admin', 'Berhasil Ubah Data Password', '2018-01-07 19:24:35'),
(18, 'Admin', 'Berhasil Ubah Data Password', '2018-01-07 19:25:56'),
(19, 'Admin', 'Berhasil menghapus data Tambah User', '2018-01-08 00:26:28'),
(20, 'Admin', 'Berhasil menghapus data Tambah User', '2018-01-08 00:27:54'),
(21, 'Admin', 'Berhasil menghapus data Tambah User', '2018-01-08 00:28:18'),
(22, 'Admin', 'Berhasil menghapus data Tambah User', '2018-01-08 00:49:15'),
(23, 'Admin', 'Berhasil Tambah User', '2018-01-08 00:52:16'),
(24, 'Admin', 'Berhasil Ubah Data Password', '2018-01-08 00:54:46'),
(25, 'Admin', 'Berhasil Password', '2018-01-08 00:57:54'),
(26, 'Admin', 'Berhasil Ganti Password', '2018-01-08 00:58:52'),
(27, 'Admin', 'Berhasil Ganti Password', '2018-01-08 00:59:36'),
(28, 'Admin', 'Berhasil Reset Password', '2018-01-08 02:52:22'),
(29, 'Admin', 'Berhasil Reset Password', '2018-01-08 02:52:37'),
(30, 'Admin', 'Berhasil Reset Password', '2018-01-08 02:53:01'),
(31, 'Admin', 'Berhasil Reset Password', '2018-01-08 02:53:24'),
(32, 'Admin', 'Berhasil Reset Password', '2018-01-08 02:55:18'),
(33, 'Admin', 'Berhasil Reset Password', '2018-01-08 02:56:54'),
(34, 'Admin', 'Berhasil Reset Password', '2018-01-08 02:57:33'),
(35, 'Admin', 'Berhasil Reset Password', '2018-01-08 03:12:27'),
(36, 'Admin', 'Berhasil Reset Password', '2018-01-08 03:12:58'),
(37, 'Admin', 'Berhasil Reset Password', '2018-01-08 03:13:11'),
(38, 'Admin', 'Berhasil Reset Password User', '2018-01-08 03:17:34'),
(39, 'Admin', 'Berhasil Vendor', '2018-01-08 08:45:28'),
(40, 'Admin', 'Berhasil menghapus data Vendor', '2018-01-08 08:47:11'),
(41, 'Admin', 'Berhasil menghapus data Hapus Data Master Vendor', '2018-01-08 08:49:45'),
(42, 'Admin', 'Berhasil Menghapus Data Master Vendor', '2018-01-08 08:53:14'),
(43, 'Admin', 'Berhasil Menghapus Data Master Vendor', '2018-01-08 10:17:54'),
(44, 'Admin', 'Berhasil Menghapus Data Master Vendor', '2018-01-08 11:24:15'),
(45, 'Admin', 'Berhasil Tambah Master Vendor', '2018-01-08 13:48:29'),
(46, 'Admin', 'Berhasil Tambah Master Vendor', '2018-01-08 13:51:02'),
(47, 'Admin', 'Berhasil Tambah Master Vendor', '2018-01-08 13:52:42'),
(48, 'Admin', 'Berhasil Tambah Master Vendor', '2018-01-08 13:53:05'),
(49, 'Admin', 'Berhasil Tambah Master Vendor', '2018-01-08 13:55:42'),
(50, 'Admin', 'Berhasil Tambah Master Vendor', '2018-01-08 13:55:50'),
(51, 'Admin', 'Berhasil Tambah Master Vendor', '2018-01-08 13:55:57'),
(52, 'Admin', 'Berhasil Ubah Data Master Vendor', '2018-01-08 13:56:10'),
(53, 'Admin', 'Berhasil Ubah Data Master Vendor', '2018-01-08 13:56:19'),
(54, 'Admin', 'Berhasil Tambah Master Vendor', '2018-01-08 13:56:29'),
(55, 'Admin', 'Berhasil Tambah Master Vendor', '2018-01-08 13:56:34'),
(56, 'Admin', 'Berhasil Tambah Master Vendor', '2018-01-08 13:56:36'),
(57, 'Admin', 'Berhasil Tambah Master Vendor', '2018-01-08 13:56:42'),
(58, 'Admin', 'Berhasil Tambah Master Vendor', '2018-01-08 13:56:46'),
(59, 'Admin', 'Berhasil Tambah Master Vendor', '2018-01-08 13:56:50'),
(60, 'Admin', 'Berhasil Tambah Master Vendor', '2018-01-08 13:57:58'),
(61, 'Admin', 'Berhasil Tambah Master Vendor', '2018-01-08 13:58:03'),
(62, 'Admin', 'Berhasil Tambah Master Vendor', '2018-01-08 13:58:07'),
(63, 'Admin', 'Berhasil Tambah Master Vendor', '2018-01-08 13:58:15'),
(64, 'Admin', 'Berhasil Tambah Master Vendor', '2018-01-08 13:58:21'),
(65, 'Admin', 'Berhasil Tambah Master Vendor', '2018-01-08 13:58:27'),
(66, 'Admin', 'Berhasil Tambah Master Vendor', '2018-01-08 13:58:39'),
(67, 'Admin', 'Berhasil Ubah Data Master Vendor', '2018-01-08 13:58:48'),
(68, 'Admin', 'Berhasil Menambah Data Master Vendor', '2018-01-08 14:03:42'),
(69, 'Admin', 'Berhasil Mengubah Data Master Vendor', '2018-01-08 14:04:09'),
(70, 'Admin', 'Berhasil Mengubah Data Master Vendor', '2018-01-08 14:04:26'),
(71, 'Admin', 'Berhasil Mengubah Data Master Vendor', '2018-01-08 14:04:32'),
(72, 'Admin', 'Berhasil Mengubah Data Master Vendor', '2018-01-08 14:04:47'),
(73, 'Admin', 'Berhasil Menghapus Data Master Vendor', '2018-01-08 14:04:56'),
(74, 'null', 'Berhasil Menghapus Data Master Jenis Barang', '2018-01-08 14:20:00'),
(75, 'Admin', 'Berhasil Menambah Data Master Vendor', '2018-01-08 14:48:14'),
(76, 'Admin', 'Berhasil Menambah Data Master Vendor', '2018-01-08 14:49:32'),
(77, 'Admin', 'Berhasil Menambah Data Master Vendor', '2018-01-08 14:53:18'),
(78, 'Admin', 'Berhasil Menambah Data Master Vendor', '2018-01-08 14:53:29'),
(79, 'Admin', 'Berhasil Reset Password User', '2018-01-08 21:06:16'),
(80, 'Admin', 'Berhasil Ganti Password', '2018-01-08 21:06:30'),
(81, 'Admin', 'Berhasil Menambah Data Master Vendor', '2018-01-12 14:16:11'),
(82, 'Admin', 'Berhasil Menambah Data Master Vendor', '2018-01-12 14:16:48'),
(83, 'Admin', 'Berhasil Menambah Data Master Vendor', '2018-01-12 14:18:41'),
(84, 'Admin', 'Berhasil Menambah Data Master Vendor', '2018-01-12 14:18:49'),
(85, 'Admin', 'Berhasil Mengubah Data Master Vendor', '2018-01-12 14:21:18'),
(86, 'Admin', 'Berhasil Menambah Data Master Vendor', '2018-01-12 14:23:20'),
(87, '', 'Berhasil Menambah Data Master Vendor', '2018-01-12 14:33:23'),
(88, '', 'Berhasil Mengubah Data Master Vendor', '2018-01-12 14:35:04'),
(89, '', 'Berhasil Mengubah Data Master Vendor', '2018-01-12 14:35:20'),
(90, 'Admin', 'Berhasil Mengubah Data Master Karyawan', '2018-01-12 15:18:14'),
(91, 'Admin', 'Berhasil Mengubah Data Master Karyawan (Pemakai)', '2018-01-12 15:20:00'),
(92, 'Admin', 'Berhasil Tambah Data Master Karyawan (Pemakai)', '2018-01-12 15:39:46'),
(93, 'Admin', 'Berhasil Hapus Data Master Karyawan (Pemakai)', '2018-01-12 15:40:08'),
(94, 'Admin', 'Berhasil Ubah Data Master Jenis Barang', '2018-01-12 16:05:33'),
(95, 'Admin', 'Berhasil Tambah Data Master Jenis Barang', '2018-01-12 16:06:00'),
(96, 'Admin', 'Berhasil Tambah Data Master Jenis Barang', '2018-01-12 16:06:25'),
(97, 'Admin', 'Berhasil Tambah Data Master Jenis Barang', '2018-01-13 15:24:25'),
(98, 'Admin', 'Berhasil Tambah Data Master Jenis Barang', '2018-01-13 15:25:37'),
(99, 'Admin', 'Berhasil Tambah Data Master Kategori Barang', '2018-01-13 15:50:15'),
(100, 'Admin', 'Berhasil Tambah Data Master Kategori Barang', '2018-01-13 15:50:27'),
(101, '', 'Berhasil Tambah Data Master Kategori Barang', '2018-01-13 15:53:29'),
(102, '', 'Berhasil Tambah Data Master Kategori Barang', '2018-01-13 15:53:50'),
(103, 'Martono', 'Berhasil Tambah Data Master Jenis Barang', '2018-01-14 10:15:32'),
(104, 'Admin', 'Berhasil Tambah Data Master Kategori Barang', '2018-01-14 10:19:20'),
(105, 'Admin', 'Berhasil Hapus Data Master Kategori Barang', '2018-01-14 10:19:39'),
(106, 'Admin', 'Berhasil Hapus Data Master Kategori Barang', '2018-01-14 10:19:43'),
(107, 'Admin', 'Berhasil Hapus Data Master Kategori Barang', '2018-01-14 10:19:49'),
(108, 'Admin', 'Berhasil Hapus Data Master Kategori Barang', '2018-01-14 10:19:53'),
(109, 'Admin', 'Berhasil Ubah Data Master KategoriBarang', '2018-01-14 10:20:24'),
(110, '', 'Berhasil Ubah Data Master KategoriBarang', '2018-01-14 10:21:27'),
(111, 'Admin', 'Berhasil Tambah Data Master Jenis Barang', '2018-01-14 10:42:11'),
(112, 'Admin', 'Berhasil Tambah Data Master Jenis Barang', '2018-01-14 10:42:19'),
(113, 'Admin', 'Berhasil Tambah Data Master Jenis Barang', '2018-01-14 10:43:45'),
(114, 'Admin', 'Berhasil Tambah Data Master Jenis Barang', '2018-01-14 10:44:00'),
(115, 'Admin', 'Berhasil Tambah Data Master Jenis Barang', '2018-01-14 10:45:25'),
(116, 'Admin', 'Berhasil Tambah Data Master Jenis Barang', '2018-01-14 10:45:53'),
(117, 'Admin', 'Berhasil Tambah Data Master Jenis Barang', '2018-01-14 10:45:58'),
(118, 'Admin', 'Berhasil Tambah Data Master Jenis Barang', '2018-01-14 10:46:45'),
(119, 'Admin', 'Berhasil Ubah Data Master KategoriBarang', '2018-01-14 10:46:52'),
(120, 'Admin', 'Berhasil Tambah Data Master Jenis Barang', '2018-01-14 10:51:27'),
(121, '', 'Berhasil Ubah Data Master KategoriBarang', '2018-01-14 12:22:30'),
(122, '', 'Berhasil Ubah Data Master KategoriBarang', '2018-01-14 12:29:00'),
(123, '', 'Berhasil Ubah Data Master KategoriBarang', '2018-01-14 12:36:17'),
(124, '', 'Berhasil Ubah Data Master KategoriBarang', '2018-01-14 12:36:32'),
(125, '', 'Berhasil Ubah Data Master KategoriBarang', '2018-01-14 12:42:23'),
(126, '', 'Berhasil Ubah Data Master KategoriBarang', '2018-01-14 12:42:33'),
(127, 'Admin', 'Berhasil Tambah Data Master Kategori Barang', '2018-01-14 18:11:37'),
(128, 'Admin', 'Berhasil Tambah Data Master Kategori Barang', '2018-01-14 18:11:51'),
(129, 'Admin', 'Berhasil Tambah Data Master Kategori Barang', '2018-01-14 18:12:24'),
(130, '', 'Berhasil Ubah Data Master KategoriBarang', '2018-01-14 18:16:56'),
(131, '', 'Berhasil Ubah Data Master KategoriBarang', '2018-01-14 18:18:28'),
(132, '', 'Berhasil Tambah Data Master Kategori Barang', '2018-01-14 18:23:02'),
(133, '', 'Berhasil Tambah Data Master Kategori Barang', '2018-01-14 18:23:47'),
(134, '', 'Berhasil Tambah Data Master Kategori Barang', '2018-01-14 18:26:42'),
(135, '', 'Berhasil Tambah Data Master Kategori Barang', '2018-01-14 18:26:49'),
(136, '', 'Berhasil Tambah Data Master Jenis Barang', '2018-01-15 08:06:37'),
(137, 'Admin', 'Berhasil Hapus Data Master Kategori Barang', '2018-01-15 09:03:47'),
(138, 'Admin', 'Berhasil Ubah Data Master Kategori Barang', '2018-01-15 09:03:59'),
(139, 'Admin', 'Berhasil Ubah Data Master Kategori Barang', '2018-01-15 09:05:03'),
(140, 'Admin', 'Berhasil Tambah Data Master Jenis Barang', '2018-01-15 09:05:24'),
(141, 'Admin', 'Berhasil Tambah Data Master Kategori Barang', '2018-01-15 09:05:38'),
(142, 'Admin', 'Berhasil Tambah Data Master Jenis Barang', '2018-01-15 09:05:48'),
(143, 'Admin', 'Berhasil Ubah Data Master Kategori Barang', '2018-01-15 09:05:54'),
(144, '', 'Berhasil Tambah Data Master Kategori Barang', '2018-01-15 14:41:26'),
(145, '', 'Berhasil Tambah Data Master Barang', '2018-01-15 21:06:35'),
(146, '', 'Berhasil Tambah Data Master Barang', '2018-01-15 21:07:07'),
(147, '', 'Berhasil Tambah Data Master Barang', '2018-01-15 22:09:48'),
(148, '', 'Berhasil Tambah Data Master Barang', '2018-01-15 22:12:10'),
(149, '', 'Berhasil Tambah Data Master Barang', '2018-01-15 22:13:51'),
(150, '', 'Berhasil Tambah Data Master Barang', '2018-01-15 22:16:29'),
(151, '', 'Berhasil Tambah Data Master Barang', '2018-01-15 22:16:49'),
(152, '', 'Berhasil Tambah Data Master Barang', '2018-01-16 06:16:49'),
(153, '', 'Berhasil Tambah Data Master Barang', '2018-01-16 06:17:07'),
(154, '', 'Berhasil Tambah Data Master Kategori Barang', '2018-01-16 06:26:40'),
(155, '', 'Berhasil Tambah Data Master Kategori Barang', '2018-01-16 06:31:04'),
(156, '', 'Berhasil Tambah Data Master Kategori Barang', '2018-01-16 06:31:17'),
(157, '', 'Berhasil Tambah Data Master Kategori Barang', '2018-01-16 06:31:32'),
(158, '', 'Berhasil Tambah Data Master Kategori Barang', '2018-01-16 06:32:21'),
(159, '', 'Berhasil Tambah Data Master Kategori Barang', '2018-01-16 06:32:37'),
(160, '', 'Berhasil Tambah Data Master Kategori Barang', '2018-01-16 06:39:40'),
(161, '', 'Berhasil Tambah Data Master Barang', '2018-01-16 06:49:26'),
(162, '', 'Berhasil Tambah Data Master Barang', '2018-01-16 06:49:41'),
(163, '', 'Berhasil Tambah Data Master Barang', '2018-01-16 06:49:47'),
(164, '', 'Berhasil Tambah Data Master Barang', '2018-01-16 06:49:55'),
(165, '', 'Berhasil Tambah Data Master Barang', '2018-01-16 07:52:59'),
(166, '', 'Berhasil Tambah Data Master Barang', '2018-01-16 07:53:59'),
(167, '', 'Berhasil Tambah Data Master Barang', '2018-01-16 07:54:04'),
(168, '', 'Berhasil Tambah Data Master Barang', '2018-01-16 07:55:01'),
(169, '', 'Berhasil Tambah Data Master Barang', '2018-01-16 07:55:11'),
(170, '', 'Berhasil Tambah Data Master Barang', '2018-01-16 07:56:29'),
(171, '', 'Berhasil Tambah Data Master Barang', '2018-01-16 07:57:54'),
(172, '', 'Berhasil Ubah Data Master Barang', '2018-01-16 08:37:17'),
(173, '', 'Berhasil Ubah Data Master Barang', '2018-01-16 08:37:48'),
(174, '', 'Berhasil Tambah Data Master Kategori Barang', '2018-01-16 10:21:22'),
(175, '', 'Berhasil Tambah Data Master Kategori Barang', '2018-01-16 10:22:10'),
(176, '', 'Berhasil Tambah Data Master Jenis Barang', '2018-01-16 10:22:33'),
(177, '', 'Berhasil Tambah Data Master Jenis Barang', '2018-01-16 10:28:07'),
(178, '', 'Berhasil Tambah Data Master Jenis Barang', '2018-01-16 10:30:14'),
(179, '', 'Berhasil Tambah Data Master Jenis Barang', '2018-01-16 10:30:32'),
(180, '', 'Berhasil Tambah Data Master Kategori Barang', '2018-01-16 10:33:09'),
(181, '', 'Berhasil Tambah Data Master Kategori Barang', '2018-01-16 10:40:26'),
(182, '', 'Berhasil Tambah Data Master Kategori Barang', '2018-01-16 10:40:30'),
(183, '', 'Berhasil Tambah Data Master Jenis Barang', '2018-01-16 11:29:19'),
(184, '', 'Berhasil Tambah Data Master Jenis Barang', '2018-01-16 12:01:17'),
(185, '', 'Berhasil Tambah Data Master Jenis Barang', '2018-01-16 12:01:32'),
(186, '', 'Berhasil Tambah Data Master Jenis Barang', '2018-01-16 12:04:10'),
(187, '', 'Berhasil Tambah Data Master Jenis Barang', '2018-01-16 12:09:59'),
(188, '', 'Berhasil Tambah Data Master Jenis Barang', '2018-01-16 12:10:15'),
(189, '', 'Berhasil Tambah Data Master Jenis Barang', '2018-01-16 12:10:28'),
(190, '', 'Berhasil Tambah Data Master Jenis Barang', '2018-01-16 12:11:42'),
(191, '', 'Berhasil Tambah Data Master Jenis Barang', '2018-01-16 12:11:51'),
(192, '', 'Berhasil Tambah Data Master Jenis Barang', '2018-01-16 13:41:18'),
(193, '', 'Berhasil Tambah Data Master Jenis Barang', '2018-01-16 13:41:26'),
(194, '', 'Berhasil Tambah Data Master Jenis Barang', '2018-01-16 13:41:53'),
(195, '', 'Berhasil Tambah Data Master Jenis Barang', '2018-01-16 13:42:30'),
(196, '', 'Berhasil Tambah Data Master Kategori Barang', '2018-01-16 13:42:49'),
(197, '', 'Berhasil Tambah Data Master Kategori Barang', '2018-01-16 13:46:29'),
(198, '', 'Berhasil Tambah Data Master Kategori Barang', '2018-01-16 13:46:49'),
(199, '', 'Berhasil Tambah Data Master Kategori Barang', '2018-01-16 13:48:19'),
(200, '', 'Berhasil Tambah Data Master Kategori Barang', '2018-01-16 13:48:37'),
(201, '', 'Berhasil Tambah Data Master Kategori Barang', '2018-01-16 13:49:06'),
(202, '', 'Berhasil Tambah Data Master Kategori Barang', '2018-01-16 13:51:33'),
(203, '', 'Berhasil Tambah Data Master Barang', '2018-01-16 13:55:09'),
(204, '', 'Berhasil Tambah Data Master Barang', '2018-01-16 14:04:13'),
(205, '', 'Berhasil Tambah Data Master Barang', '2018-01-16 14:04:27'),
(206, '', 'Berhasil Tambah Data Master Barang', '2018-01-16 14:12:22'),
(207, '', 'Berhasil Tambah Data Master Barang', '2018-01-16 14:12:33'),
(208, '', 'Berhasil Tambah Data Master Barang', '2018-01-16 14:12:40'),
(209, '', 'Berhasil Tambah Data Master Barang', '2018-01-16 14:12:47'),
(210, '', 'Berhasil Ubah Data Master Barang', '2018-01-16 14:13:02'),
(211, '', 'Berhasil Ubah Data Master Barang', '2018-01-16 14:13:08'),
(212, '', 'Berhasil Tambah Data Master Kategori Barang', '2018-01-16 14:14:13'),
(213, '', 'Berhasil Tambah Data Master Barang', '2018-01-16 14:14:29'),
(214, '', 'Berhasil Ganti Password', '2018-01-16 21:33:19'),
(215, '', 'Berhasil Ganti Password', '2018-01-16 21:33:32'),
(216, '', 'Berhasil Ganti Password', '2018-01-16 21:34:34'),
(217, 'Admin', 'Berhasil Reset Password User', '2018-01-17 06:52:04'),
(218, 'Admin', 'Berhasil Reset Password User', '2018-01-17 06:52:14'),
(219, 'Admin', 'Berhasil Tambah User', '2018-01-17 07:02:58'),
(220, 'Admin', 'Berhasil Tambah User', '2018-01-17 07:04:04'),
(221, '', 'Berhasil Tambah Data Master Jenis Service', '2018-01-17 16:06:02'),
(222, '', 'Berhasil Ubah Data Master Jenis Service', '2018-01-17 16:06:11'),
(223, '', 'Berhasil Ubah Data Master Jenis Service', '2018-01-17 16:06:22'),
(224, '', 'Berhasil Hapus Data Master Jenis Service', '2018-01-17 16:06:26'),
(225, '', 'Berhasil Tambah Data Master Barang Service', '2018-01-17 21:10:04'),
(226, '', 'Berhasil Ubah Data Master Barang Service', '2018-01-17 21:10:25'),
(227, '', 'Berhasil Ubah Data Master Barang Service', '2018-01-17 21:10:48'),
(228, '', 'Berhasil Tambah Data Master Jenis Barang Service', '2018-01-17 21:22:21'),
(229, '', 'Berhasil Tambah Data Master Barang Service', '2018-01-17 21:22:38'),
(230, '', 'Berhasil Tambah Data Master Jenis Service', '2018-01-18 07:54:27'),
(231, '', 'Berhasil Tambah Data Master Jenis Service', '2018-01-18 07:54:35'),
(232, '', 'Berhasil Ubah Data Master Jenis Service', '2018-01-18 07:54:45'),
(233, '', 'Berhasil Hapus Data Master Jenis Service', '2018-01-18 07:54:51'),
(234, '', 'Berhasil Tambah Data Master Jenis Barang Service', '2018-01-18 07:55:17'),
(235, '', 'Berhasil Tambah Data Master Jenis Barang Service', '2018-01-18 07:55:37'),
(236, '', 'Berhasil Ubah Data Master Jenis Barang Service', '2018-01-18 07:55:44'),
(237, '', 'Berhasil Hapus Data Master Jenis Barang Service', '2018-01-18 07:56:00'),
(238, '', 'Berhasil Tambah Data Master Barang Service', '2018-01-18 07:56:25'),
(239, '', 'Berhasil Tambah Data Master Barang Service', '2018-01-18 07:56:40'),
(240, '', 'Berhasil Tambah Data Master Jenis Barang Service', '2018-01-18 07:57:08'),
(241, '', 'Berhasil Tambah Data Master Jenis Barang Service', '2018-01-18 07:57:18'),
(242, '', 'Berhasil Tambah Data Master Jenis Barang Service', '2018-01-18 07:57:56'),
(243, '', 'Berhasil Ubah Data Master Barang Service', '2018-01-18 07:58:06'),
(244, '', 'Berhasil Ubah Data Master Barang Service', '2018-01-18 07:58:12'),
(245, '', 'Berhasil Ubah Data Master Barang Service', '2018-01-18 07:58:45'),
(246, '', 'Berhasil Hapus Data Master Barang Service', '2018-01-18 07:58:49'),
(247, '', 'Berhasil Tambah Data Master Jenis Barang', '2018-01-19 01:03:33'),
(248, '', 'Berhasil Tambah Data Master Jenis Barang', '2018-01-19 01:04:33'),
(249, '', 'Berhasil Tambah Data Master Jenis Barang', '2018-01-19 01:04:46'),
(250, '', 'Berhasil Tambah Data Master Jenis Barang', '2018-01-19 01:05:08'),
(251, '', 'Berhasil Tambah Data Master Jenis Barang', '2018-01-19 01:50:43'),
(252, '', 'Berhasil Tambah Data Master Jenis Barang', '2018-01-19 01:51:12'),
(253, '', 'Berhasil Hapus Data Master Barang', '2018-01-20 13:45:51'),
(254, '', 'Berhasil Hapus Data Master Barang', '2018-01-20 13:45:55'),
(255, '', 'Berhasil Tambah Data Barang Rusak', '2018-01-21 15:31:08'),
(256, '', 'Berhasil Tambah Data Barang Rusak', '2018-01-21 15:42:53'),
(257, '', 'Berhasil Tambah Data Barang Rusak', '2018-01-21 15:43:51'),
(258, '', 'Berhasil Ubah Data Barang Rusak', '2018-01-21 16:27:15'),
(259, '', 'Berhasil Ubah Data Barang Rusak', '2018-01-21 16:27:34'),
(260, '', 'Berhasil Ubah Data Barang Rusak', '2018-01-21 16:28:02'),
(261, '', 'Berhasil Tambah Data Barang Rusak', '2018-01-21 16:44:52'),
(262, '', 'Berhasil Ubah Data Barang Rusak', '2018-01-21 16:45:14'),
(263, '', 'Berhasil Ubah Data Barang Rusak', '2018-01-21 16:45:56'),
(264, '', 'Berhasil Ubah Data Barang Rusak', '2018-01-21 16:46:09'),
(265, '', 'Berhasil Ubah Data Barang Rusak', '2018-01-21 16:46:30'),
(266, '', 'Berhasil Tambah Data Master Jenis Barang', '2018-01-21 22:38:26'),
(267, '', 'Berhasil Hapus Data Master Jenis Barang', '2018-01-21 22:45:20'),
(268, '', 'Berhasil Tambah Data Master Jenis Barang', '2018-01-21 22:45:50'),
(269, '', 'Berhasil Hapus Data Master Jenis Barang', '2018-01-21 22:46:00'),
(270, '', 'Berhasil Tambah Data Master Jenis Barang', '2018-01-21 22:46:24'),
(271, '', 'Berhasil Tambah Data Master Jenis Barang', '2018-01-21 22:46:36'),
(272, '', 'Berhasil Tambah Data Master Jenis Barang', '2018-01-21 22:46:42'),
(273, '', 'Berhasil Tambah Data Master Kategori Barang', '2018-01-21 22:47:20'),
(274, '', 'Berhasil Tambah Data Master Kategori Barang', '2018-01-21 22:52:03'),
(275, '', 'Berhasil Tambah Data Master Kategori Barang', '2018-01-21 22:52:20'),
(276, '', 'Berhasil Tambah Data Master Kategori Barang', '2018-01-21 22:53:01'),
(277, '', 'Berhasil Tambah Data Master Kategori Barang', '2018-01-21 22:53:14'),
(278, '', 'Berhasil Tambah Data Master Karyawan (Pemakai)', '2018-01-21 22:57:28'),
(279, '', 'Berhasil Tambah Data Master Karyawan (Pemakai)', '2018-01-21 22:57:37'),
(280, '', 'Berhasil Hapus Data Master Karyawan (Pemakai)', '2018-01-21 22:57:58'),
(281, '', 'Berhasil Hapus Data Master Karyawan (Pemakai)', '2018-01-21 22:58:01'),
(282, '', 'Berhasil Tambah Data Master Karyawan (Pemakai)', '2018-01-21 23:00:36'),
(283, '', 'Berhasil Hapus Data Master Karyawan (Pemakai)', '2018-01-21 23:01:12'),
(284, '', 'Berhasil Tambah Data Master Barang', '2018-01-22 11:37:50'),
(285, '', 'Berhasil Tambah Data Barang Rusak', '2018-01-22 11:48:38'),
(286, '', 'Berhasil Ubah Data Barang Rusak', '2018-01-22 11:48:53'),
(287, '', 'Berhasil Tambah Data Barang Rusak', '2018-01-22 20:23:23'),
(288, '', 'Berhasil Tambah Data Barang Rusak', '2018-01-22 20:24:04'),
(289, '', 'Berhasil Tambah Data Barang Rusak', '2018-01-22 20:35:59'),
(290, '', 'Berhasil Tambah Data Barang Rusak', '2018-01-22 20:36:11'),
(291, '', 'Berhasil Ubah Data Barang Rusak', '2018-01-22 20:36:31'),
(292, '', 'Berhasil Hapus Data Barang Rusak', '2018-01-22 20:36:44'),
(293, '', 'Berhasil Hapus Data Barang Rusak', '2018-01-22 20:36:51'),
(294, '', 'Berhasil Ubah Data Barang Rusak', '2018-01-22 20:37:11'),
(295, '', 'Berhasil Ubah Data Barang Rusak', '2018-01-22 20:37:18'),
(296, '', 'Berhasil Tambah Data Master Barang', '2018-01-22 21:09:50'),
(297, '', 'Berhasil Tambah Data Master Barang', '2018-01-22 21:36:03'),
(298, '', 'Berhasil Tambah Data Master Barang', '2018-01-22 21:36:10'),
(299, '', 'Berhasil Tambah Data Master Barang', '2018-01-22 21:36:50'),
(300, '', 'Berhasil Tambah Data Master Barang', '2018-01-22 22:04:41'),
(301, '', 'Berhasil Tambah Data Master Barang', '2018-01-22 22:24:22'),
(302, '', 'Berhasil Tambah Data Master Barang', '2018-01-22 22:24:28'),
(303, '', 'Berhasil Ubah Data Master Kategori Barang', '2018-01-22 23:01:39'),
(304, '', 'Berhasil Tambah Data Master Kategori Barang', '2018-01-22 23:29:33'),
(305, '', 'Berhasil Tambah Data Master Kategori Barang', '2018-01-22 23:29:55'),
(306, '', 'Berhasil Tambah Data Master Kategori Barang', '2018-01-22 23:33:38'),
(307, '', 'Berhasil Tambah Data Master Kategori Barang', '2018-01-22 23:33:53'),
(308, '', 'Berhasil Hapus Data Master Kategori Barang', '2018-01-22 23:40:31'),
(309, '', 'Berhasil Hapus Data Master Kategori Barang', '2018-01-22 23:40:34'),
(310, '', 'Berhasil Hapus Data Master Kategori Barang', '2018-01-22 23:40:39'),
(311, '', 'Berhasil Hapus Data Master Kategori Barang', '2018-01-22 23:40:42'),
(312, '', 'Berhasil Tambah Data Master Kategori Barang', '2018-01-22 23:41:05'),
(313, '', 'Berhasil Hapus Data Master Kategori Barang', '2018-01-22 23:41:09'),
(314, '', 'Berhasil Tambah Data Master Kategori Barang', '2018-01-22 23:41:33'),
(315, '', 'Berhasil Tambah Data Master Kategori Barang', '2018-01-22 23:41:48'),
(316, '', 'Berhasil Hapus Data Master Kategori Barang', '2018-01-22 23:42:02'),
(317, '', 'Berhasil Hapus Data Master Kategori Barang', '2018-01-22 23:42:07'),
(318, '', 'Berhasil Tambah Data Master Jenis Barang', '2018-01-23 08:21:48'),
(319, '', 'Berhasil Tambah Data Master Jenis Service', '2018-01-23 09:31:23'),
(320, '', 'Berhasil Tambah Data Master Jenis Barang Service', '2018-01-23 09:31:51'),
(321, '', 'Berhasil Tambah Data Master Barang Service', '2018-01-23 09:38:48'),
(322, '', 'Berhasil Tambah Data Master Barang Service', '2018-01-23 09:39:07'),
(323, '', 'Berhasil Tambah Data Service', '2018-01-23 14:43:43'),
(324, '', 'Berhasil Tambah Data Master Barang Service', '2018-01-23 14:45:06'),
(325, '', 'Berhasil Tambah Data Service', '2018-01-23 14:46:33'),
(326, '', 'Berhasil Tambah Data Service', '2018-01-23 14:48:32'),
(327, '', 'Berhasil Ubah Data Service', '2018-01-23 15:34:31'),
(328, '', 'Berhasil Ubah Data Service', '2018-01-23 15:34:48'),
(329, '', 'Berhasil Ubah Data Service', '2018-01-23 15:54:40'),
(330, '', 'Berhasil Ubah Data Service', '2018-01-23 15:55:28'),
(331, '', 'Berhasil Hapus Data Barang Rusak', '2018-01-23 16:24:23'),
(332, '', 'Berhasil Hapus Data Barang Rusak', '2018-01-23 16:24:31'),
(333, '', 'Berhasil Hapus Data Barang Rusak', '2018-01-23 16:24:42'),
(334, '', 'Berhasil Hapus Data Service', '2018-01-23 16:25:39'),
(335, '', 'Berhasil Hapus Data Service', '2018-01-23 16:25:43'),
(336, '', 'Berhasil Hapus Data Service', '2018-01-23 16:25:46'),
(337, '', 'Berhasil Hapus Data Service', '2018-01-23 16:25:50'),
(338, '', 'Berhasil Tambah Data Service', '2018-01-23 16:26:32'),
(339, '', 'Berhasil Tambah Data Service', '2018-01-23 16:27:07'),
(340, '', 'Berhasil Tambah Data Service', '2018-01-23 16:27:23'),
(341, '', 'Berhasil Hapus Data Service', '2018-01-23 18:22:11'),
(342, '', 'Berhasil Hapus Data Service', '2018-01-23 18:22:14'),
(343, '', 'Berhasil Hapus Data Service', '2018-01-23 18:22:18'),
(344, '', 'Berhasil Tambah Data Service', '2018-01-23 18:29:59'),
(345, '', 'Berhasil Hapus Data Service', '2018-01-23 21:54:08'),
(346, '', 'Berhasil Tambah Data Service', '2018-01-24 06:32:18'),
(347, '', 'Berhasil Tambah Data Service', '2018-01-24 06:33:15'),
(348, 'Admin', 'Berhasil Tambah Data Service', '2018-01-24 06:37:05'),
(349, '', 'Berhasil Ubah Data Service', '2018-01-24 08:11:45'),
(350, '', 'Berhasil Ubah Data Service', '2018-01-24 08:12:25'),
(351, '', 'Berhasil Ubah Data Service', '2018-01-24 08:53:20'),
(352, '', 'Berhasil Ubah Data Service', '2018-01-24 08:53:32'),
(353, '', 'Berhasil Ubah Data Service', '2018-01-24 08:53:57'),
(354, '', 'Berhasil Ubah Data Service', '2018-01-24 08:54:26'),
(355, '', 'Berhasil Ubah Data Service', '2018-01-24 08:55:22'),
(356, '', 'Berhasil Ubah Data Service', '2018-01-24 08:55:35'),
(357, '', 'Berhasil Ubah Data Service', '2018-01-24 09:00:00'),
(358, '', 'Berhasil Ubah Data Service', '2018-01-24 09:02:02'),
(359, '', 'Berhasil Ubah Data Service', '2018-01-24 09:02:09'),
(360, '', 'Berhasil Ubah Data Service', '2018-01-24 09:02:28'),
(361, '', 'Berhasil Ubah Data Service', '2018-01-24 09:06:41'),
(362, '', 'Berhasil Hapus Data Service', '2018-01-24 16:12:39'),
(363, '', 'Berhasil Ubah Data Master Barang', '2018-01-24 20:02:14'),
(364, '', 'Berhasil Ubah Data Master Barang', '2018-01-24 20:02:20'),
(365, '', 'Berhasil Ubah Data Master Barang Service', '2018-01-25 08:14:04'),
(366, '', 'Berhasil Hapus Data Service', '2018-01-25 08:21:03'),
(367, '', 'Berhasil Ubah Data Service', '2018-01-25 08:21:23'),
(368, '', 'Berhasil Hapus Data Service', '2018-01-25 08:21:44'),
(369, '', 'Berhasil Tambah Data Service', '2018-01-25 08:22:19'),
(370, '', 'Berhasil Ubah Data Service', '2018-01-25 08:22:41'),
(371, '', 'Berhasil Ubah Data Service', '2018-01-25 08:23:03'),
(372, '', 'Berhasil Ubah Data Service', '2018-01-25 08:23:11'),
(373, '', 'Berhasil Ubah Data Service', '2018-01-25 08:23:27'),
(374, '', 'Berhasil Ubah Data Service', '2018-01-25 08:49:16'),
(375, '', 'Berhasil Ubah Data Service', '2018-01-25 08:49:25'),
(376, '', 'Berhasil Tambah Data Barang Rusak', '2018-01-25 10:51:57'),
(377, '', 'Berhasil Tambah Data Master Barang', '2018-01-25 10:52:51'),
(378, '', 'Berhasil Tambah Data Barang Rusak', '2018-01-25 10:53:23'),
(379, '', 'Berhasil Tambah Data Master Kategori Barang', '2018-01-25 10:54:58'),
(380, '', 'Berhasil Tambah Data Master Barang', '2018-01-25 10:55:10'),
(381, '', 'Berhasil Tambah Data Barang Rusak', '2018-01-25 10:55:14'),
(382, '', 'Berhasil Tambah Data Service', '2018-01-25 13:16:28'),
(383, '', 'Berhasil Tambah Data Service', '2018-01-25 13:21:00'),
(384, '', 'Berhasil Tambah Data Service', '2018-01-25 13:21:03'),
(385, '', 'Berhasil Tambah Data Service', '2018-01-25 13:21:27'),
(386, '', 'Berhasil Tambah Data Service', '2018-01-25 13:21:29'),
(387, '', 'Berhasil Service', '2018-01-25 13:38:16'),
(388, '', 'Berhasil Service', '2018-01-25 13:38:43'),
(389, '', 'Berhasil Service', '2018-01-25 13:38:51'),
(390, '', 'Berhasil Service', '2018-01-25 13:39:14'),
(391, '', 'Berhasil Tambah Service', '2018-01-25 13:39:47'),
(392, '', 'Berhasil Tambah Data Service', '2018-01-25 13:39:59'),
(393, '', 'Berhasil Tambah Service', '2018-01-25 13:40:06'),
(394, '', 'Berhasil Service', '2018-01-25 13:42:42'),
(395, '', 'Berhasil Service', '2018-01-25 13:42:43'),
(396, '', 'Berhasil Service', '2018-01-25 14:32:40'),
(397, '', 'Berhasil Service', '2018-01-25 14:32:41'),
(398, '', 'Berhasil Hapus Data Service', '2018-01-25 14:36:43'),
(399, '', 'Berhasil Hapus Data Service', '2018-01-25 14:36:46'),
(400, '', 'Berhasil Hapus Data Service', '2018-01-25 14:36:51'),
(401, '', 'Berhasil Tambah Data Service', '2018-01-25 14:40:33'),
(402, '', ' Multi Insert', '2018-01-25 15:19:57'),
(403, '', ' Multi Insert', '2018-01-25 15:19:57'),
(404, '', ' Multi Insert', '2018-01-25 15:34:07'),
(405, '', ' Multi Insert', '2018-01-25 15:34:07'),
(406, '', ' Multi Insert', '2018-01-25 15:34:07'),
(407, '', ' Multi Insert', '2018-01-25 15:34:22'),
(408, '', ' Multi Insert', '2018-01-25 15:34:22'),
(409, '', 'Berhasil Ubah Data Service', '2018-01-25 15:48:01'),
(410, 'Admin', ' Multi Insert', '2018-01-26 00:07:04'),
(411, 'Admin', ' Multi Insert', '2018-01-26 00:07:05'),
(412, '', 'Berhasil Hapus Data Penyesuaian Stok', '2018-01-26 10:32:21');

-- --------------------------------------------------------

--
-- Table structure for table `tbmbarang`
--

CREATE TABLE `tbmbarang` (
  `IdBarang` int(10) NOT NULL,
  `IdKategoriBarang` int(10) NOT NULL,
  `NamaBarang` varchar(50) NOT NULL,
  `Garansi` enum('Ya','Tidak') NOT NULL,
  `Keterangan` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbmbarang`
--

INSERT INTO `tbmbarang` (`IdBarang`, `IdKategoriBarang`, `NamaBarang`, `Garansi`, `Keterangan`) VALUES
(1, 1, 'Win dow', 'Ya', ''),
(2, 2, 'Win dows', 'Ya', ''),
(3, 3, 'Casing', 'Tidak', ''),
(4, 2, 'RAM', 'Ya', ''),
(5, 1, 'xxxxxx', 'Tidak', ''),
(6, 1, 'yyyyy', 'Tidak', ''),
(7, 3, 'kipas', 'Tidak', ''),
(8, 3, 'wwwww', 'Tidak', ''),
(9, 3, '1111', 'Tidak', ''),
(10, 3, '22222', 'Tidak', ''),
(11, 7, 'Win dow', 'Tidak', ''),
(12, 9, 'Win dow', 'Ya', '');

-- --------------------------------------------------------

--
-- Table structure for table `tbmbarangservice`
--

CREATE TABLE `tbmbarangservice` (
  `IdBarangService` int(10) NOT NULL,
  `IdJenisBarangService` int(10) NOT NULL,
  `NamaBarangService` varchar(50) NOT NULL,
  `Keterangan` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbmbarangservice`
--

INSERT INTO `tbmbarangservice` (`IdBarangService`, `IdJenisBarangService`, `NamaBarangService`, `Keterangan`) VALUES
(1, 1, 'AC Server', ''),
(2, 8, 'AC', ''),
(3, 8, '234', ''),
(4, 3, 'Komputer Martono', '');

-- --------------------------------------------------------

--
-- Table structure for table `tbmjenisbarang`
--

CREATE TABLE `tbmjenisbarang` (
  `IdJenisBarang` int(10) NOT NULL,
  `JenisBarang` varchar(50) NOT NULL,
  `Keterangan` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbmjenisbarang`
--

INSERT INTO `tbmjenisbarang` (`IdJenisBarang`, `JenisBarang`, `Keterangan`) VALUES
(1, 'AC', ''),
(2, 'Komputer', ''),
(5, 'Notebook', ''),
(6, 'Kelapa', ''),
(7, 'Sepatu', ''),
(8, '123', '');

-- --------------------------------------------------------

--
-- Table structure for table `tbmjenisbarangservice`
--

CREATE TABLE `tbmjenisbarangservice` (
  `IdJenisBarangService` int(10) NOT NULL,
  `JenisBarangService` varchar(50) NOT NULL,
  `Keterangan` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbmjenisbarangservice`
--

INSERT INTO `tbmjenisbarangservice` (`IdJenisBarangService`, `JenisBarangService`, `Keterangan`) VALUES
(1, 'AC', ''),
(3, 'Komputer', ''),
(4, 'Notebook', ''),
(5, 'Kompor', ''),
(6, 'Alat Berat', ''),
(7, 'xxxxx', ''),
(8, '345', '');

-- --------------------------------------------------------

--
-- Table structure for table `tbmjenisservice`
--

CREATE TABLE `tbmjenisservice` (
  `IdJenisService` int(10) NOT NULL,
  `JenisService` varchar(50) NOT NULL,
  `Keterangan` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbmjenisservice`
--

INSERT INTO `tbmjenisservice` (`IdJenisService`, `JenisService`, `Keterangan`) VALUES
(1, 'Cuci AC', ''),
(2, 'Maintenance', '');

-- --------------------------------------------------------

--
-- Table structure for table `tbmkaryawan`
--

CREATE TABLE `tbmkaryawan` (
  `IdKaryawan` int(10) NOT NULL,
  `NIK` varchar(10) NOT NULL,
  `NamaKaryawan` varchar(50) NOT NULL,
  `Keterangan` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbmkaryawan`
--

INSERT INTO `tbmkaryawan` (`IdKaryawan`, `NIK`, `NamaKaryawan`, `Keterangan`) VALUES
(1, '2020029', 'Alfin', ''),
(2, '2020013', 'Dewi', ''),
(3, '2020034', 'Dina', ''),
(4, '2020036', 'Evelyn', ''),
(5, '2020014', 'Fenni', ''),
(6, '2020028', 'Gustina', ''),
(7, '2020002', 'Hayati', ''),
(8, '2020015', 'Linda', ''),
(9, '2020035', 'Madalena', ''),
(10, '2020024', 'Meilisa', ''),
(11, '2020055', 'Mira', ''),
(12, '2020043', 'Sylvia', ''),
(13, '2020022', 'Tashya', ''),
(14, '2020031', 'Tommy P', ''),
(15, '2020033', 'Yessi', ''),
(16, '2020058', 'Yunita', ''),
(17, '2020004', 'Ahong', ''),
(18, '2020010', 'Ali', ''),
(19, '2020003', 'Apeng', ''),
(20, '2020005', 'Ate', ''),
(21, '2020012', 'Harijono', ''),
(22, '2020006', 'Leni', ''),
(23, '2020017', 'Monica', ''),
(24, '2020038', 'Putra', ''),
(25, '2020001', 'Suiseng', ''),
(26, '2020019', 'Susan', ''),
(27, '2020053', 'Debbi', ''),
(28, '2020099', 'Della', ''),
(29, '2020055P', 'Fitra', ''),
(30, '2020027', 'Halik', ''),
(31, '2020020', 'Lilianti', ''),
(32, '2020041', 'Meriana', ''),
(33, '2020052', 'Ratna', ''),
(34, '2020057', 'Revasi', ''),
(35, '2020100', 'Rudi', ''),
(36, '2020018', 'Shinta K', ''),
(37, '2020058P', 'Tria', ''),
(38, '2020007', 'Yanti', ''),
(39, '2020008', 'Yenni', ''),
(40, '2020016', 'Yuli', ''),
(41, '2020046', 'Bika', ''),
(42, '2020044', 'Citra', ''),
(43, '2020053T', 'Shinta', ''),
(44, '2020042', 'Fernanda', ''),
(45, '2020090', 'Riki', ''),
(46, '2020026', 'William', ''),
(47, '2020023', 'Winda', ''),
(48, '2020037', 'Zeppri', ''),
(49, '2020099T', 'Lidiya', ''),
(50, '2020100T', 'Hayril', ''),
(51, '2020092', 'Liliani', ''),
(52, '2020000', 'Server', '');

-- --------------------------------------------------------

--
-- Table structure for table `tbmkategoribarang`
--

CREATE TABLE `tbmkategoribarang` (
  `IdKategoriBarang` int(10) NOT NULL,
  `IdJenisBarang` int(10) NOT NULL,
  `KategoriBarang` varchar(50) NOT NULL,
  `Keterangan` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbmkategoribarang`
--

INSERT INTO `tbmkategoribarang` (`IdKategoriBarang`, `IdJenisBarang`, `KategoriBarang`, `Keterangan`) VALUES
(1, 1, 'Part', ''),
(2, 2, 'Part', ''),
(3, 1, 'Aksesoris', ''),
(4, 7, 'Sekolah', ''),
(5, 7, 'Olahraga', ''),
(6, 7, 'Bermain', ''),
(7, 1, 'Mesin', ''),
(8, 1, 'Body', ''),
(9, 2, 'Mesin', '');

-- --------------------------------------------------------

--
-- Table structure for table `tbmvendor`
--

CREATE TABLE `tbmvendor` (
  `IdVendor` int(10) NOT NULL,
  `NamaVendor` varchar(50) NOT NULL,
  `NomorTelepon` varchar(20) NOT NULL,
  `Alamat` varchar(250) NOT NULL,
  `Keterangan` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbmvendor`
--

INSERT INTO `tbmvendor` (`IdVendor`, `NamaVendor`, `NomorTelepon`, `Alamat`, `Keterangan`) VALUES
(3, 'Systech', '1234', 'Jambi', ''),
(4, 'sdfsdf', '', '', ''),
(5, '321', '', '', ''),
(6, '456', '', '', ''),
(8, 'sdf', '', '', ''),
(16, 'zzzz', '232323', 'sdfsdf', 'sfsfd'),
(19, 'Eleven Komputer', '074188888', 'Jambi', ''),
(23, 'Master Komputer', '0741-888888', 'Pasar Jambi', 'Supplier Komputer'),
(25, 'SysComp', '', '', '\n'),
(26, 'Metro', '23423', 'sdfsf', 'sdfsdfsdf'),
(27, 'fsdfsdf', 'sdfsd', 'sfsf', 'sfsfsf'),
(28, '1', '1', '1', '1'),
(29, '2', '2', '2', '2'),
(30, '3', '3', '3', '3'),
(31, '4', '4', '4', '4'),
(32, '5', '5', '5', '\n5'),
(33, '6', '6', '66', '\n'),
(35, '8', '8', '8', '\n8'),
(36, '9', '9', '9', '\n9'),
(38, 'a', 'a', 'a', 'a\n'),
(39, 'd', 'd', 'd', 'd\n'),
(40, 'f', 'f', 'f', 'f\n'),
(41, 'g', 'g', 'g', 'g\n'),
(42, 'h', 'hh', '', 'h\n'),
(43, 'j', 'j', 'j', 'j'),
(44, 'y', 'y', 'y', 'y'),
(45, 'w', 'w', 'w', 'w\n'),
(46, 's', 's', 's', 's\n'),
(47, 'q', 'q', 'q', 'q'),
(48, 'z', 'z', 'z', 'z\n'),
(49, 'x', 'x', 'x', 'x\n'),
(50, 'Cobaaaaaa', '1212', '1212', '12121212\n\n\n\n\n\n\n\n\n\n'),
(51, 'sfsdf', 'sdfsdf', 'sdfsdf', 'sdfsdff\n\n\n\n'),
(52, 'sfdsfdsfsdf', 'sdfsdf', 'sdfdsf', 'sdfsdfsdfsdfsdf'),
(53, 'sdfsd', 'sdf', 'sdfdsf', 'sdfsdfsdfsdfsdf'),
(55, 'sdfsdfddd', 'fsdfs', 'sdfdsf', 'sdfsdf'),
(56, 'zx', '', '', 'x');

-- --------------------------------------------------------

--
-- Table structure for table `tbpenyesuaianstok`
--

CREATE TABLE `tbpenyesuaianstok` (
  `IdPenyesuaianStok` int(10) NOT NULL,
  `IdBarang` int(10) NOT NULL,
  `NomorPenyesuaianStok` varchar(12) NOT NULL,
  `TanggalPenyesuaianStok` date NOT NULL,
  `PenyesuaianStok` int(5) NOT NULL,
  `Keterangan` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbpenyesuaianstok`
--

INSERT INTO `tbpenyesuaianstok` (`IdPenyesuaianStok`, `IdBarang`, `NomorPenyesuaianStok`, `TanggalPenyesuaianStok`, `PenyesuaianStok`, `Keterangan`) VALUES
(1, 1, '000001/18/PY', '2018-01-27', 1, '');

-- --------------------------------------------------------

--
-- Table structure for table `tbservice`
--

CREATE TABLE `tbservice` (
  `IdService` int(10) NOT NULL,
  `IdJenisService` int(10) NOT NULL,
  `IdBarangService` int(10) NOT NULL,
  `TanggalService` date NOT NULL,
  `TanggalServiceSelanjutnya` date NOT NULL,
  `Keterangan` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbservice`
--

INSERT INTO `tbservice` (`IdService`, `IdJenisService`, `IdBarangService`, `TanggalService`, `TanggalServiceSelanjutnya`, `Keterangan`) VALUES
(9, 1, 1, '2018-01-24', '2018-01-29', ''),
(15, 1, 1, '2018-01-26', '2018-01-29', ''),
(16, 2, 4, '2018-01-01', '2018-02-05', ''),
(17, 1, 1, '2018-01-25', '2018-01-25', ''),
(18, 2, 4, '2018-01-25', '2018-01-25', ''),
(19, 1, 1, '2018-01-25', '2018-02-04', ''),
(20, 2, 4, '2018-01-25', '2018-02-04', ''),
(21, 1, 1, '2018-01-25', '2018-02-17', ''),
(22, 2, 4, '2018-01-25', '2018-02-17', ''),
(23, 2, 4, '2018-01-25', '2018-01-25', ''),
(24, 2, 4, '2018-01-25', '2018-02-05', ''),
(25, 2, 4, '2018-01-25', '2018-01-25', ''),
(26, 2, 4, '2018-01-25', '2018-01-25', ''),
(27, 2, 4, '2018-01-25', '2018-01-25', ''),
(28, 1, 3, '2018-01-25', '2018-01-25', ''),
(29, 1, 3, '2018-01-25', '2018-01-25', ''),
(31, 1, 1, '2018-01-25', '2018-01-25', ''),
(32, 1, 1, '2018-01-25', '2018-01-25', ''),
(33, 2, 4, '2018-01-25', '2018-01-25', ''),
(34, 1, 2, '2018-01-25', '2018-02-06', ''),
(35, 1, 1, '2018-01-25', '2018-02-06', ''),
(36, 2, 4, '2018-01-25', '2018-02-06', ''),
(37, 1, 3, '2018-01-25', '2018-02-17', ''),
(38, 1, 2, '2018-01-25', '2018-02-17', ''),
(39, 1, 1, '2018-01-25', '2018-02-28', ''),
(40, 1, 2, '2018-01-25', '2018-02-28', ''),
(41, 2, 4, '2018-01-25', '2018-02-28', ''),
(42, 1, 1, '2018-01-26', '2018-02-07', ''),
(43, 2, 4, '2018-01-26', '2018-02-07', '');

-- --------------------------------------------------------

--
-- Table structure for table `tbuser`
--

CREATE TABLE `tbuser` (
  `IdUser` int(10) NOT NULL,
  `Username` varchar(25) NOT NULL,
  `Password` varchar(32) NOT NULL,
  `Level` enum('Administrator','Operator') NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbuser`
--

INSERT INTO `tbuser` (`IdUser`, `Username`, `Password`, `Level`) VALUES
(1, 'Admin', 'd41d8cd98f00b204e9800998ecf8427e', 'Administrator'),
(2, 'Martono', 'd41d8cd98f00b204e9800998ecf8427e', 'Operator'),
(3, '', 'd41d8cd98f00b204e9800998ecf8427e', 'Administrator'),
(4, 'Budi', 'd41d8cd98f00b204e9800998ecf8427e', 'Administrator'),
(5, 'Joko', 'd41d8cd98f00b204e9800998ecf8427e', 'Administrator'),
(6, 'Ani', 'd41d8cd98f00b204e9800998ecf8427e', 'Operator'),
(7, 'Fernanda', 'd41d8cd98f00b204e9800998ecf8427e', 'Operator'),
(12, 'Rudi', 'd41d8cd98f00b204e9800998ecf8427e', 'Administrator'),
(13, 'sdfsdfsdf', 'd41d8cd98f00b204e9800998ecf8427e', 'Administrator'),
(14, '123', 'd41d8cd98f00b204e9800998ecf8427e', 'Administrator');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `tbbarangrusak`
--
ALTER TABLE `tbbarangrusak`
  ADD PRIMARY KEY (`IdBarangRusak`),
  ADD KEY `IdBarang` (`IdBarang`),
  ADD KEY `IdKaryawan` (`IdKaryawan`);

--
-- Indexes for table `tbhistory`
--
ALTER TABLE `tbhistory`
  ADD PRIMARY KEY (`IdHistory`);

--
-- Indexes for table `tbmbarang`
--
ALTER TABLE `tbmbarang`
  ADD PRIMARY KEY (`IdBarang`),
  ADD UNIQUE KEY `IdKategoriBarang` (`IdKategoriBarang`,`NamaBarang`);

--
-- Indexes for table `tbmbarangservice`
--
ALTER TABLE `tbmbarangservice`
  ADD PRIMARY KEY (`IdBarangService`),
  ADD UNIQUE KEY `IdJenisBarangService` (`IdJenisBarangService`,`NamaBarangService`);

--
-- Indexes for table `tbmjenisbarang`
--
ALTER TABLE `tbmjenisbarang`
  ADD PRIMARY KEY (`IdJenisBarang`),
  ADD UNIQUE KEY `JenisBarang` (`JenisBarang`);

--
-- Indexes for table `tbmjenisbarangservice`
--
ALTER TABLE `tbmjenisbarangservice`
  ADD PRIMARY KEY (`IdJenisBarangService`),
  ADD UNIQUE KEY `JenisBarangService` (`JenisBarangService`);

--
-- Indexes for table `tbmjenisservice`
--
ALTER TABLE `tbmjenisservice`
  ADD PRIMARY KEY (`IdJenisService`),
  ADD UNIQUE KEY `JenisService` (`JenisService`);

--
-- Indexes for table `tbmkaryawan`
--
ALTER TABLE `tbmkaryawan`
  ADD PRIMARY KEY (`IdKaryawan`),
  ADD UNIQUE KEY `NIK` (`NIK`),
  ADD KEY `NamaKaryawan` (`NamaKaryawan`);

--
-- Indexes for table `tbmkategoribarang`
--
ALTER TABLE `tbmkategoribarang`
  ADD PRIMARY KEY (`IdKategoriBarang`),
  ADD UNIQUE KEY `IdJenisBarang` (`IdJenisBarang`,`KategoriBarang`);

--
-- Indexes for table `tbmvendor`
--
ALTER TABLE `tbmvendor`
  ADD PRIMARY KEY (`IdVendor`),
  ADD UNIQUE KEY `NamaVendor` (`NamaVendor`);

--
-- Indexes for table `tbpenyesuaianstok`
--
ALTER TABLE `tbpenyesuaianstok`
  ADD PRIMARY KEY (`IdPenyesuaianStok`),
  ADD UNIQUE KEY `NomorPenyesuaianStok` (`NomorPenyesuaianStok`) USING BTREE,
  ADD KEY `IdBarang` (`IdBarang`);

--
-- Indexes for table `tbservice`
--
ALTER TABLE `tbservice`
  ADD PRIMARY KEY (`IdService`),
  ADD KEY `IdJenisService` (`IdJenisService`),
  ADD KEY `IdBarangService` (`IdBarangService`);

--
-- Indexes for table `tbuser`
--
ALTER TABLE `tbuser`
  ADD PRIMARY KEY (`IdUser`),
  ADD UNIQUE KEY `Username` (`Username`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `tbbarangrusak`
--
ALTER TABLE `tbbarangrusak`
  MODIFY `IdBarangRusak` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- AUTO_INCREMENT for table `tbhistory`
--
ALTER TABLE `tbhistory`
  MODIFY `IdHistory` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=413;

--
-- AUTO_INCREMENT for table `tbmbarang`
--
ALTER TABLE `tbmbarang`
  MODIFY `IdBarang` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- AUTO_INCREMENT for table `tbmbarangservice`
--
ALTER TABLE `tbmbarangservice`
  MODIFY `IdBarangService` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `tbmjenisbarang`
--
ALTER TABLE `tbmjenisbarang`
  MODIFY `IdJenisBarang` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT for table `tbmjenisbarangservice`
--
ALTER TABLE `tbmjenisbarangservice`
  MODIFY `IdJenisBarangService` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT for table `tbmjenisservice`
--
ALTER TABLE `tbmjenisservice`
  MODIFY `IdJenisService` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `tbmkaryawan`
--
ALTER TABLE `tbmkaryawan`
  MODIFY `IdKaryawan` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=53;

--
-- AUTO_INCREMENT for table `tbmkategoribarang`
--
ALTER TABLE `tbmkategoribarang`
  MODIFY `IdKategoriBarang` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT for table `tbmvendor`
--
ALTER TABLE `tbmvendor`
  MODIFY `IdVendor` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=57;

--
-- AUTO_INCREMENT for table `tbpenyesuaianstok`
--
ALTER TABLE `tbpenyesuaianstok`
  MODIFY `IdPenyesuaianStok` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `tbservice`
--
ALTER TABLE `tbservice`
  MODIFY `IdService` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=44;

--
-- AUTO_INCREMENT for table `tbuser`
--
ALTER TABLE `tbuser`
  MODIFY `IdUser` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
