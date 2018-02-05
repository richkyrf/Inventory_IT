-- phpMyAdmin SQL Dump
-- version 4.7.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Feb 04, 2018 at 04:24 AM
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
-- Table structure for table `tbbarangkeluar`
--

CREATE TABLE `tbbarangkeluar` (
  `IdBarangKeluar` int(10) NOT NULL,
  `NomorBarangKeluar` varchar(10) NOT NULL,
  `TanggalBarangKeluar` date NOT NULL,
  `IdKaryawan` int(10) NOT NULL,
  `IdBarang` int(10) NOT NULL,
  `JumlahBarang` int(5) NOT NULL,
  `Keterangan` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbbarangkeluar`
--

INSERT INTO `tbbarangkeluar` (`IdBarangKeluar`, `NomorBarangKeluar`, `TanggalBarangKeluar`, `IdKaryawan`, `IdBarang`, `JumlahBarang`, `Keterangan`) VALUES
(1, '0001/18/BK', '2018-02-03', 47, 2, 1, ''),
(2, '0002/18/BK', '2018-02-03', 38, 2, 1, '');

-- --------------------------------------------------------

--
-- Table structure for table `tbbarangmasuk`
--

CREATE TABLE `tbbarangmasuk` (
  `IdBarangMasuk` int(10) NOT NULL,
  `NomorBarangMasuk` varchar(10) NOT NULL,
  `TanggalBarangMasuk` date NOT NULL,
  `NomorPurchaseRequest` varchar(25) NOT NULL,
  `IdVendor` int(10) NOT NULL,
  `UrlPurchaseRequest` varchar(50) NOT NULL,
  `UrlNotaBarangMasuk` varchar(50) NOT NULL,
  `Keterangan` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `tbbarangmasukdetail`
--

CREATE TABLE `tbbarangmasukdetail` (
  `IdDetailBarangMasuk` int(10) NOT NULL,
  `NomorBarangMasuk` varchar(10) NOT NULL,
  `NomorKolom` int(5) NOT NULL,
  `IdBarang` int(10) NOT NULL,
  `HargaBarang` int(10) NOT NULL,
  `JumlahBarang` int(5) NOT NULL,
  `SerialNumber` varchar(50) NOT NULL,
  `Keterangan` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

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
(1, 'ADMIN', 'Berhasil Tambah Data Master Jenis Barang', '2018-02-02 15:21:28'),
(2, 'ADMIN', 'Berhasil Tambah Data Master Kategori Barang', '2018-02-02 15:22:13'),
(3, 'ADMIN', 'Berhasil Tambah Data Master Barang', '2018-02-02 15:22:39'),
(4, 'ADMIN', 'Berhasil Tambah Data Master Jenis Service', '2018-02-02 15:23:01'),
(5, 'ADMIN', 'Berhasil Tambah Data Master Jenis Barang Service', '2018-02-02 15:23:43'),
(6, 'ADMIN', 'Berhasil Tambah Data Master Barang Service', '2018-02-02 15:24:03'),
(7, 'ADMIN', 'Berhasil Tambah Data Master Vendor', '2018-02-02 15:26:55'),
(8, 'ADMIN', 'Berhasil Tambah Data Master Karyawan (Pemakai)', '2018-02-02 15:28:41'),
(9, 'ADMIN', 'Berhasil Ubah Data Master Karyawan (Pemakai)', '2018-02-02 15:28:50'),
(10, 'ADMIN', 'Berhasil Ubah Data Master Karyawan (Pemakai)', '2018-02-02 15:29:19'),
(11, 'ADMIN', 'Berhasil Ubah Data Master Karyawan (Pemakai)', '2018-02-02 15:29:42'),
(12, 'ADMIN', 'Berhasil Ubah Data Master Karyawan (Pemakai)', '2018-02-02 15:30:02'),
(13, 'ADMIN', 'Berhasil Tambah Data Master Jenis Barang', '2018-02-02 15:34:00'),
(14, 'ADMIN', 'Berhasil Tambah Data Master Jenis Barang', '2018-02-02 15:34:05'),
(15, 'ADMIN', 'Berhasil Tambah Data Master Jenis Barang', '2018-02-02 15:34:08'),
(16, 'ADMIN', 'Berhasil Tambah Data Master Kategori Barang', '2018-02-02 15:37:54'),
(17, 'ADMIN', 'Berhasil Ubah Data Master Kategori Barang', '2018-02-02 15:38:49'),
(18, 'ADMIN', 'Berhasil Tambah Data Master Kategori Barang', '2018-02-02 15:39:13'),
(19, 'ADMIN', 'Berhasil Tambah Data Master Kategori Barang', '2018-02-02 15:39:37'),
(20, 'ADMIN', 'Berhasil Tambah Data Master Kategori Barang', '2018-02-02 15:40:24'),
(21, 'ADMIN', 'Berhasil Tambah Data Master Jenis Barang', '2018-02-02 15:42:11'),
(22, 'ADMIN', 'Berhasil Tambah Data Master Kategori Barang', '2018-02-02 15:42:39'),
(23, 'ADMIN', 'Berhasil Ubah Data Master Kategori Barang', '2018-02-02 15:43:41'),
(24, 'ADMIN', 'Berhasil Tambah Data Master Kategori Barang', '2018-02-02 15:44:16'),
(25, 'ADMIN', 'Berhasil Tambah Data Master Kategori Barang', '2018-02-02 15:44:30'),
(26, 'ADMIN', 'Berhasil Tambah Data Master Kategori Barang', '2018-02-02 15:45:20'),
(27, 'ADMIN', 'Berhasil Tambah Data Master Kategori Barang', '2018-02-02 15:45:34'),
(28, 'ADMIN', 'Berhasil Tambah Data Master Kategori Barang', '2018-02-02 15:45:46'),
(29, 'ADMIN', 'Berhasil Tambah Data Master Kategori Barang', '2018-02-02 15:45:50'),
(30, 'ADMIN', 'Berhasil Tambah Data Master Kategori Barang', '2018-02-02 15:45:59'),
(31, 'ADMIN', 'Berhasil Tambah Data Master Kategori Barang', '2018-02-02 15:46:12'),
(32, 'ADMIN', 'Berhasil Tambah Data Master Kategori Barang', '2018-02-02 15:46:27'),
(33, 'ADMIN', 'Berhasil Tambah Data Master Kategori Barang', '2018-02-02 15:46:34'),
(34, 'ADMIN', 'Berhasil Tambah Data Master Kategori Barang', '2018-02-02 15:47:04'),
(35, 'ADMIN', 'Berhasil Tambah Data Master Kategori Barang', '2018-02-02 15:47:16'),
(36, 'ADMIN', 'Berhasil Tambah Data Master Kategori Barang', '2018-02-02 15:47:25'),
(37, 'ADMIN', 'Berhasil Tambah Data Master Kategori Barang', '2018-02-02 15:48:16'),
(38, 'ADMIN', 'Berhasil Ubah Data Master Kategori Barang', '2018-02-02 15:48:59'),
(39, 'ADMIN', 'Berhasil Tambah Data Master Kategori Barang', '2018-02-02 15:49:12'),
(40, 'ADMIN', 'Berhasil Tambah Data Master Kategori Barang', '2018-02-02 15:49:18'),
(41, 'ADMIN', 'Berhasil Tambah Data Master Kategori Barang', '2018-02-02 15:49:58'),
(42, 'ADMIN', 'Berhasil Tambah Data Master Kategori Barang', '2018-02-02 15:50:26'),
(43, 'ADMIN', 'Berhasil Tambah Data Master Kategori Barang', '2018-02-02 15:50:38'),
(44, 'ADMIN', 'Berhasil Tambah Data Master Kategori Barang', '2018-02-02 15:52:16'),
(45, 'ADMIN', 'Berhasil Tambah Data Master Kategori Barang', '2018-02-02 15:52:23'),
(46, 'ADMIN', 'Berhasil Tambah Data Master Kategori Barang', '2018-02-02 15:53:30'),
(47, 'ADMIN', 'Berhasil Tambah Data Master Kategori Barang', '2018-02-02 15:54:49'),
(48, 'ADMIN', 'Berhasil Tambah Data Master Kategori Barang', '2018-02-02 15:55:03'),
(49, 'ADMIN', 'Berhasil Tambah Data Master Kategori Barang', '2018-02-02 15:55:14'),
(50, 'ADMIN', 'Berhasil Tambah Data Master Kategori Barang', '2018-02-02 15:55:54'),
(51, 'ADMIN', 'Berhasil Ubah Data Master Jenis Barang', '2018-02-02 16:02:48'),
(52, 'ADMIN', 'Berhasil Tambah Data Master Jenis Barang', '2018-02-02 16:04:53'),
(53, 'ADMIN', 'Berhasil Tambah Data Master Kategori Barang', '2018-02-02 16:05:25'),
(54, 'ADMIN', 'Berhasil Tambah Data Master Kategori Barang', '2018-02-02 16:05:30'),
(55, 'ADMIN', 'Berhasil Tambah Data Master Kategori Barang', '2018-02-02 16:05:47'),
(56, 'ADMIN', 'Berhasil Tambah Data Master Kategori Barang', '2018-02-02 16:05:53'),
(57, 'ADMIN', 'Berhasil Tambah Data Master Kategori Barang', '2018-02-02 16:07:44'),
(58, 'ADMIN', 'Berhasil Tambah Data Master Kategori Barang', '2018-02-02 16:08:02'),
(59, 'ADMIN', 'Berhasil Tambah Data Master Kategori Barang', '2018-02-02 16:08:06'),
(60, 'ADMIN', 'Berhasil Tambah Data Master Kategori Barang', '2018-02-02 16:08:20'),
(61, 'ADMIN', 'Berhasil Tambah Data Master Kategori Barang', '2018-02-02 16:10:20'),
(62, 'ADMIN', 'Berhasil Hapus Data Master Kategori Barang', '2018-02-02 16:10:27'),
(63, 'ADMIN', 'Berhasil Hapus Data Master Kategori Barang', '2018-02-02 16:11:52'),
(64, 'ADMIN', 'Berhasil Tambah Data Master Kategori Barang', '2018-02-02 16:12:08'),
(65, 'ADMIN', 'Berhasil Tambah Data Master Kategori Barang', '2018-02-02 16:13:16'),
(66, 'ADMIN', 'Berhasil Tambah Data Master Kategori Barang', '2018-02-02 16:13:21'),
(67, 'ADMIN', 'Berhasil Tambah Data Master Kategori Barang', '2018-02-02 16:13:29'),
(68, 'ADMIN', 'Berhasil Tambah Data Master Kategori Barang', '2018-02-02 16:14:12'),
(69, 'ADMIN', 'Berhasil Tambah Data Master Kategori Barang', '2018-02-02 16:14:30'),
(70, 'ADMIN', 'Berhasil Tambah Data Master Kategori Barang', '2018-02-02 16:15:11'),
(71, 'ADMIN', 'Berhasil Tambah Data Master Kategori Barang', '2018-02-02 16:15:21'),
(72, 'ADMIN', 'Berhasil Ubah Data Master Kategori Barang', '2018-02-02 16:16:02'),
(73, 'ADMIN', 'Berhasil Tambah Data Master Kategori Barang', '2018-02-02 16:16:25'),
(74, 'ADMIN', 'Berhasil Tambah Data Master Kategori Barang', '2018-02-02 16:16:30'),
(75, 'ADMIN', 'Berhasil Ubah Data Master Kategori Barang', '2018-02-02 16:16:40'),
(76, 'ADMIN', 'Berhasil Tambah Data Master Kategori Barang', '2018-02-02 16:17:13'),
(77, 'ADMIN', 'Berhasil Tambah Data Master Kategori Barang', '2018-02-02 16:17:19'),
(78, 'ADMIN', 'Berhasil Tambah Data Master Kategori Barang', '2018-02-02 16:17:26'),
(79, 'ADMIN', 'Berhasil Tambah Data Master Kategori Barang', '2018-02-02 16:18:02'),
(80, 'ADMIN', 'Berhasil Tambah Data Master Kategori Barang', '2018-02-02 16:18:43'),
(81, 'ADMIN', 'Berhasil Tambah Data Master Kategori Barang', '2018-02-02 16:19:00'),
(82, 'ADMIN', 'Berhasil Tambah Data Master Kategori Barang', '2018-02-02 16:19:28'),
(83, 'ADMIN', 'Berhasil Ubah Data Master Barang', '2018-02-02 16:31:12'),
(84, 'ADMIN', 'Berhasil Tambah Data Master Barang', '2018-02-02 16:31:38'),
(85, 'ADMIN', 'Berhasil Tambah Data Master Barang', '2018-02-02 16:31:46'),
(86, 'ADMIN', 'Berhasil Tambah Data Master Barang', '2018-02-02 16:32:26'),
(87, 'ADMIN', 'Berhasil Tambah Data Master Barang', '2018-02-02 16:33:24'),
(88, 'ADMIN', 'Berhasil Tambah Data Master Barang', '2018-02-02 16:33:45'),
(89, 'ADMIN', 'Berhasil Tambah Data Master Barang', '2018-02-02 16:33:52'),
(90, 'ADMIN', 'Berhasil Tambah Data Master Barang', '2018-02-02 16:35:18'),
(91, 'ADMIN', 'Berhasil Tambah Data Master Barang', '2018-02-02 16:36:07'),
(92, 'ADMIN', 'Melihat Laporan Master Barang', '2018-02-02 16:41:39'),
(93, 'ADMIN', 'Berhasil Tambah Data Master Vendor', '2018-02-02 16:42:10'),
(94, 'ADMIN', 'Berhasil Tambah Data Master Vendor', '2018-02-02 16:42:34'),
(95, 'ADMIN', 'Melihat Laporan Service', '2018-02-02 17:18:09'),
(96, 'ADMIN', 'Melihat Laporan Service', '2018-02-02 17:18:35'),
(97, 'ADMIN', ' Multi Insert', '2018-02-02 17:28:46'),
(98, 'ADMIN', ' Multi Insert', '2018-02-02 17:28:46'),
(99, 'ADMIN', ' Multi Insert', '2018-02-02 17:28:46'),
(100, 'ADMIN', 'PurchaseRequest', '2018-02-02 17:28:48'),
(101, 'ADMIN', ' Multi Insert', '2018-02-02 17:32:59'),
(102, 'ADMIN', ' Multi Insert', '2018-02-02 17:32:59'),
(103, 'ADMIN', ' Multi Insert', '2018-02-02 17:32:59'),
(104, 'ADMIN', ' Multi Insert', '2018-02-02 17:32:59'),
(105, 'ADMIN', 'PurchaseRequest', '2018-02-02 17:33:01'),
(106, 'ADMIN', ' Multi Insert', '2018-02-02 17:35:17'),
(107, 'ADMIN', ' Multi Insert', '2018-02-02 17:35:17'),
(108, 'ADMIN', ' Multi Insert', '2018-02-02 17:35:17'),
(109, 'ADMIN', ' Multi Insert', '2018-02-02 17:35:17'),
(110, 'ADMIN', 'PurchaseRequest', '2018-02-02 17:35:19'),
(111, 'ADMIN', ' Multi Insert', '2018-02-02 17:43:45'),
(112, 'ADMIN', ' Multi Insert', '2018-02-02 17:43:46'),
(113, 'ADMIN', ' Multi Insert', '2018-02-02 17:43:46'),
(114, 'ADMIN', 'Melihat Laporan Master Barang', '2018-02-02 17:44:36'),
(115, 'ADMIN', 'Melihat Laporan Service', '2018-02-03 06:24:10'),
(116, 'ADMIN', 'Melihat Laporan Service', '2018-02-03 06:25:03'),
(117, 'ADMIN', 'Melihat Laporan Service', '2018-02-03 08:42:17'),
(118, 'ADMIN', 'Melihat Laporan DetailBarangKeluar', '2018-02-03 08:52:16'),
(119, 'ADMIN', 'Melihat Laporan DetailBarangKeluar', '2018-02-03 08:52:49'),
(120, 'ADMIN', 'Melihat Laporan Service', '2018-02-03 08:56:12'),
(121, 'ADMIN', 'Melihat Laporan Service', '2018-02-03 08:57:27'),
(122, 'ADMIN', 'Melihat Laporan Service', '2018-02-03 08:58:33'),
(123, 'ADMIN', 'Melihat Laporan Service', '2018-02-03 08:59:31'),
(124, 'ADMIN', 'Melihat Laporan Service', '2018-02-03 09:01:08'),
(125, 'ADMIN', 'Melihat Laporan Service', '2018-02-03 09:02:04'),
(126, 'ADMIN', 'Melihat Laporan Barang Rusak', '2018-02-03 09:04:42'),
(127, 'ADMIN', 'Melihat Laporan Barang Rusak', '2018-02-03 09:06:54'),
(128, 'ADMIN', 'Melihat Laporan Barang Rusak', '2018-02-03 09:09:19'),
(129, 'ADMIN', 'Melihat Laporan Barang Rusak', '2018-02-03 09:11:44'),
(130, 'ADMIN', 'Melihat Laporan Barang Keluar', '2018-02-03 09:26:44'),
(131, 'ADMIN', 'Melihat Laporan Barang Masuk', '2018-02-03 09:40:47'),
(132, 'ADMIN', 'Melihat Laporan Barang Masuk', '2018-02-03 09:41:02'),
(133, 'ADMIN', 'Melihat Laporan Barang Masuk', '2018-02-03 09:52:59'),
(134, 'ADMIN', 'Melihat Laporan Barang Masuk', '2018-02-03 09:53:15'),
(135, 'ADMIN', 'Melihat Laporan Barang Masuk', '2018-02-03 09:57:19'),
(136, 'ADMIN', 'Melihat Laporan Purchase Request', '2018-02-03 10:13:01'),
(137, 'ADMIN', 'Melihat Laporan Purchase Request', '2018-02-03 10:14:14'),
(138, 'ADMIN', 'Melihat Laporan Purchase Request', '2018-02-03 10:14:44'),
(139, 'ADMIN', 'Melihat Laporan Purchase Request', '2018-02-03 10:16:05'),
(140, 'ADMIN', 'Melihat Laporan Purchase Request', '2018-02-03 10:17:00'),
(141, 'ADMIN', 'Melihat Laporan Barang Masuk', '2018-02-03 10:18:54'),
(142, 'ADMIN', 'Melihat Laporan Purchase Request', '2018-02-03 10:19:57'),
(143, 'ADMIN', 'Melihat Laporan Purchase Request', '2018-02-03 10:20:03'),
(144, 'ADMIN', 'Melihat Laporan Master Barang', '2018-02-03 11:05:51'),
(145, 'ADMIN', 'Melihat Laporan Master Barang Service', '2018-02-03 11:05:58'),
(146, 'ADMIN', 'Melihat Laporan Master Barang', '2018-02-03 11:06:05'),
(147, 'ADMIN', 'Melihat Laporan Master Barang Service', '2018-02-03 11:06:13'),
(148, 'ADMIN', 'Melihat Laporan Master Karyawan (Pemakai)', '2018-02-03 11:06:22'),
(149, 'ADMIN', 'Melihat Laporan Master Vendor', '2018-02-03 11:06:27'),
(150, 'ADMIN', 'Melihat Laporan Purchase Request', '2018-02-03 11:06:34'),
(151, 'ADMIN', 'Melihat Laporan Purchase Request', '2018-02-03 11:06:48'),
(152, 'ADMIN', 'Melihat Laporan Purchase Request', '2018-02-03 11:07:31'),
(153, 'ADMIN', 'Melihat Laporan Barang Masuk', '2018-02-03 11:07:52'),
(154, 'ADMIN', 'Melihat Laporan Barang Masuk', '2018-02-03 11:08:01'),
(155, 'ADMIN', 'Melihat Laporan Barang Keluar', '2018-02-03 11:08:19'),
(156, 'ADMIN', 'Melihat Laporan Penyesuaian Stok', '2018-02-03 11:08:32'),
(157, 'ADMIN', 'Melihat Laporan Service', '2018-02-03 11:08:45'),
(158, 'ADMIN', 'Melihat Laporan Barang Rusak', '2018-02-03 11:09:00'),
(159, 'ADMIN', ' Multi Insert', '2018-02-03 11:14:09'),
(160, 'ADMIN', ' Multi Insert', '2018-02-03 11:14:09'),
(161, 'ADMIN', ' Multi Insert', '2018-02-03 11:14:21'),
(162, 'ADMIN', ' Multi Insert', '2018-02-03 13:25:00'),
(163, 'ADMIN', ' Multi Insert', '2018-02-03 13:25:01'),
(164, 'ADMIN', ' Multi Insert', '2018-02-03 13:25:01'),
(165, 'ADMIN', ' Multi Insert', '2018-02-03 13:25:01'),
(166, 'ADMIN', ' Multi Insert', '2018-02-03 13:25:12'),
(167, 'ADMIN', ' Multi Insert', '2018-02-03 13:25:12'),
(168, 'ADMIN', 'Berhasil Hapus Data Barang Masuk', '2018-02-03 13:25:15'),
(169, 'ADMIN', 'Berhasil Hapus Data PurchaseRequest', '2018-02-03 13:25:25'),
(170, 'ADMIN', ' Multi Insert', '2018-02-03 13:33:26'),
(171, 'ADMIN', ' Multi Insert', '2018-02-03 13:33:26'),
(172, 'ADMIN', ' Multi Insert', '2018-02-03 13:33:26'),
(173, 'ADMIN', 'PurchaseRequest', '2018-02-03 13:33:34'),
(174, 'ADMIN', 'PurchaseRequest', '2018-02-03 13:36:47'),
(175, 'ADMIN', 'PurchaseRequest', '2018-02-03 13:42:45'),
(176, 'ADMIN', ' Multi Insert', '2018-02-03 13:48:09'),
(177, 'ADMIN', ' Multi Insert', '2018-02-03 13:48:09'),
(178, 'ADMIN', ' Multi Insert', '2018-02-03 13:48:09'),
(179, 'ADMIN', ' Multi Insert', '2018-02-03 13:53:01'),
(180, 'ADMIN', ' Multi Insert', '2018-02-03 13:53:01'),
(181, 'ADMIN', ' Multi Insert', '2018-02-03 13:53:01'),
(182, 'ADMIN', ' Multi Insert', '2018-02-03 13:53:01'),
(183, 'ADMIN', ' Multi Insert', '2018-02-03 13:54:39'),
(184, 'ADMIN', ' Multi Insert', '2018-02-03 13:54:39'),
(185, 'ADMIN', ' Multi Insert', '2018-02-03 13:54:39'),
(186, 'ADMIN', ' Multi Insert', '2018-02-03 13:54:39'),
(187, 'ADMIN', ' Multi Insert', '2018-02-03 14:16:31'),
(188, 'ADMIN', ' Multi Insert', '2018-02-03 14:16:31'),
(189, 'ADMIN', ' Multi Insert', '2018-02-03 14:24:11'),
(190, 'ADMIN', ' Multi Insert', '2018-02-03 14:24:11'),
(191, 'ADMIN', 'Berhasil Hapus Data Barang Masuk', '2018-02-03 14:24:36'),
(192, 'ADMIN', ' Multi Insert', '2018-02-03 14:24:51'),
(193, 'ADMIN', ' Multi Insert', '2018-02-03 14:24:51'),
(194, 'ADMIN', 'Melihat Laporan Master Barang', '2018-02-03 14:25:58'),
(195, 'ADMIN', 'Melihat Laporan Master Barang', '2018-02-03 14:27:27'),
(196, 'ADMIN', 'Berhasil Tambah Data Barang Keluar', '2018-02-03 14:34:27'),
(197, 'ADMIN', 'Berhasil Tambah Data Barang Keluar', '2018-02-03 14:34:38'),
(198, 'ADMIN', 'Melihat Laporan Master Barang', '2018-02-03 14:35:13'),
(199, 'ADMIN', 'Berhasil Tambah Data Penyesuaian Stok', '2018-02-03 14:35:42'),
(200, 'ADMIN', 'Melihat Laporan Penyesuaian Stok', '2018-02-03 14:36:03'),
(201, 'ADMIN', 'Melihat Laporan Master Barang', '2018-02-03 14:36:12'),
(202, 'ADMIN', 'Berhasil Tambah Data Master Jenis Service', '2018-02-03 14:37:07'),
(203, 'ADMIN', 'Berhasil Tambah Data Master Jenis Barang Service', '2018-02-03 14:37:18'),
(204, 'ADMIN', 'Berhasil Ubah Data Master Barang Service', '2018-02-03 14:37:48'),
(205, 'ADMIN', 'Berhasil Tambah Data Master Barang Service', '2018-02-03 14:38:09'),
(206, 'ADMIN', 'Berhasil Tambah Data Master Barang Service', '2018-02-03 14:38:18'),
(207, 'ADMIN', 'Berhasil Tambah Data Master Barang Service', '2018-02-03 14:38:30'),
(208, 'ADMIN', 'Berhasil Tambah Data Master Barang Service', '2018-02-03 14:38:47'),
(209, 'ADMIN', 'Berhasil Tambah Data Master Barang Service', '2018-02-03 14:38:57'),
(210, 'ADMIN', 'Berhasil Tambah Data Master Barang Service', '2018-02-03 14:39:10'),
(211, 'ADMIN', 'Berhasil Tambah Data Master Barang Service', '2018-02-03 14:39:16'),
(212, 'ADMIN', 'Berhasil Tambah Data Master Barang Service', '2018-02-03 14:39:26'),
(213, 'ADMIN', 'Berhasil Tambah Data Master Barang Service', '2018-02-03 14:39:39'),
(214, 'ADMIN', 'Berhasil Tambah Data Master Barang Service', '2018-02-03 14:39:51'),
(215, 'ADMIN', 'Berhasil Tambah Data Master Barang Service', '2018-02-03 14:39:57'),
(216, 'ADMIN', 'Berhasil Tambah Data Master Barang Service', '2018-02-03 14:40:24'),
(217, 'ADMIN', 'Berhasil Tambah Data Master Barang Service', '2018-02-03 14:40:42'),
(218, 'ADMIN', 'Berhasil Tambah Data Master Barang Service', '2018-02-03 14:40:48'),
(219, 'ADMIN', 'Berhasil Tambah Data Master Barang Service', '2018-02-03 14:40:58'),
(220, 'ADMIN', 'Berhasil Tambah Data Master Barang Service', '2018-02-03 14:41:07'),
(221, 'ADMIN', 'Berhasil Tambah Data Master Barang Service', '2018-02-03 14:41:21'),
(222, 'ADMIN', 'Berhasil Tambah Data Master Barang Service', '2018-02-03 14:41:26'),
(223, 'ADMIN', 'Berhasil Tambah Data Master Barang Service', '2018-02-03 14:41:36'),
(224, 'ADMIN', 'Berhasil Tambah Data Master Barang Service', '2018-02-03 14:41:44'),
(225, 'ADMIN', 'Berhasil Tambah Data Master Barang Service', '2018-02-03 14:41:54'),
(226, 'ADMIN', 'Berhasil Tambah Data Master Barang Service', '2018-02-03 14:42:03'),
(227, 'ADMIN', 'Berhasil Tambah Data Master Barang Service', '2018-02-03 14:42:09'),
(228, 'ADMIN', 'Berhasil Tambah Data Master Barang Service', '2018-02-03 14:42:18'),
(229, 'ADMIN', 'Berhasil Tambah Data Master Barang Service', '2018-02-03 14:42:27'),
(230, 'ADMIN', 'Berhasil Tambah Data Master Barang Service', '2018-02-03 14:42:37'),
(231, 'ADMIN', 'Berhasil Tambah Data Master Barang Service', '2018-02-03 14:42:43'),
(232, 'ADMIN', 'Berhasil Tambah Data Master Barang Service', '2018-02-03 14:42:58'),
(233, 'ADMIN', 'Berhasil Tambah Data Master Barang Service', '2018-02-03 14:43:07'),
(234, 'ADMIN', 'Berhasil Tambah Data Master Barang Service', '2018-02-03 14:43:12'),
(235, 'ADMIN', 'Berhasil Tambah Data Master Barang Service', '2018-02-03 14:43:20'),
(236, 'ADMIN', 'Berhasil Tambah Data Master Barang Service', '2018-02-03 14:43:26'),
(237, 'ADMIN', 'Berhasil Tambah Data Master Barang Service', '2018-02-03 14:43:34'),
(238, 'ADMIN', 'Berhasil Tambah Data Master Barang Service', '2018-02-03 14:43:49'),
(239, 'ADMIN', 'Berhasil Tambah Data Master Barang Service', '2018-02-03 14:43:58'),
(240, 'ADMIN', 'Berhasil Tambah Data Master Barang Service', '2018-02-03 14:44:05'),
(241, 'ADMIN', 'Berhasil Tambah Data Master Barang Service', '2018-02-03 14:44:13'),
(242, 'ADMIN', 'Berhasil Tambah Data Master Barang Service', '2018-02-03 14:44:22'),
(243, 'ADMIN', 'Berhasil Tambah Data Master Barang Service', '2018-02-03 14:44:37'),
(244, 'ADMIN', 'Berhasil Tambah Data Master Barang Service', '2018-02-03 14:44:47'),
(245, 'ADMIN', 'Berhasil Tambah Data Master Barang Service', '2018-02-03 14:45:00'),
(246, 'ADMIN', 'Berhasil Tambah Data Master Barang Service', '2018-02-03 14:45:06'),
(247, 'ADMIN', 'Berhasil Tambah Data Master Barang Service', '2018-02-03 14:45:18'),
(248, 'ADMIN', 'Berhasil Tambah Data Master Barang Service', '2018-02-03 14:45:28'),
(249, 'ADMIN', 'Berhasil Tambah Data Master Barang Service', '2018-02-03 14:45:39'),
(250, 'ADMIN', 'Berhasil Tambah Data Master Barang Service', '2018-02-03 14:45:46'),
(251, 'ADMIN', 'Berhasil Tambah Data Master Barang Service', '2018-02-03 14:45:52'),
(252, 'ADMIN', 'Berhasil Tambah Data Master Barang Service', '2018-02-03 14:46:00'),
(253, 'ADMIN', 'Berhasil Tambah Data Master Barang Service', '2018-02-03 14:46:13'),
(254, 'ADMIN', 'Berhasil Tambah Data Master Barang Service', '2018-02-03 14:46:21'),
(255, 'ADMIN', 'Berhasil Tambah Data Master Barang Service', '2018-02-03 14:46:29'),
(256, 'ADMIN', 'Berhasil Tambah Data Master Barang Service', '2018-02-03 14:46:38'),
(257, 'ADMIN', 'Berhasil Tambah Data Master Barang Service', '2018-02-03 14:46:46'),
(258, 'ADMIN', 'Berhasil Tambah Data Master Barang Service', '2018-02-03 14:46:52'),
(259, 'ADMIN', 'Berhasil Tambah Data Master Barang Service', '2018-02-03 14:47:00'),
(260, 'ADMIN', 'Berhasil Tambah Data Master Barang Service', '2018-02-03 14:47:09'),
(261, 'ADMIN', 'Berhasil Tambah Data Master Barang Service', '2018-02-03 14:47:15'),
(262, 'ADMIN', 'Berhasil Tambah Data Master Barang Service', '2018-02-03 14:47:26'),
(263, 'ADMIN', 'Berhasil Tambah Data Service', '2018-02-03 14:50:26'),
(264, 'ADMIN', 'Berhasil Ubah Data Service', '2018-02-03 14:51:12'),
(265, 'ADMIN', 'Berhasil Tambah Data Service', '2018-02-03 14:52:36'),
(266, 'ADMIN', 'Berhasil Tambah Data Service', '2018-02-03 14:55:17'),
(267, 'ADMIN', ' Multi Insert', '2018-02-03 14:56:10'),
(268, 'ADMIN', ' Multi Insert', '2018-02-03 14:56:33'),
(269, 'ADMIN', ' Multi Insert', '2018-02-03 14:56:33'),
(270, 'ADMIN', 'Melihat Laporan Service', '2018-02-03 14:57:22'),
(271, 'ADMIN', 'Berhasil Tambah Data Barang Rusak', '2018-02-03 14:59:08'),
(272, 'ADMIN', 'Melihat Laporan Barang Rusak', '2018-02-03 15:00:12'),
(273, 'ADMIN', 'Melihat Laporan Barang Rusak', '2018-02-03 15:04:29'),
(274, 'ADMIN', 'Berhasil Ubah Data Barang Rusak', '2018-02-03 15:05:18'),
(275, 'ADMIN', 'Berhasil Ubah Data Barang Rusak', '2018-02-03 15:05:34'),
(276, 'ADMIN', 'Berhasil Hapus Data Barang Rusak', '2018-02-03 15:05:45'),
(277, 'ADMIN', ' Multi Insert', '2018-02-03 15:07:20'),
(278, 'ADMIN', ' Multi Insert', '2018-02-03 15:07:20'),
(279, 'ADMIN', 'Berhasil Hapus Data Barang Masuk', '2018-02-03 15:07:24'),
(280, 'ADMIN', ' Multi Insert', '2018-02-03 15:07:36'),
(281, 'ADMIN', ' Multi Insert', '2018-02-03 15:07:36'),
(282, 'ADMIN', 'Berhasil Hapus Data Barang Masuk', '2018-02-03 15:07:42'),
(283, 'ADMIN', 'Melihat Laporan Master Barang Service', '2018-02-04 09:06:44'),
(284, 'ADMIN', 'Melihat Laporan Master Barang Service', '2018-02-04 09:06:58'),
(285, 'ADMIN', 'Melihat Laporan Master Barang Service', '2018-02-04 09:07:07'),
(286, 'ADMIN', 'Melihat Laporan Barang Rusak', '2018-02-04 09:13:48'),
(287, 'ADMIN', 'Melihat Laporan Penyesuaian Stok', '2018-02-04 09:17:36'),
(288, 'ADMIN', 'Melihat Laporan Penyesuaian Stok', '2018-02-04 09:17:41'),
(289, 'ADMIN', 'Berhasil Ubah Data Master Barang', '2018-02-04 09:54:38'),
(290, 'ADMIN', 'Berhasil Ubah Data Master Barang', '2018-02-04 09:54:59'),
(291, 'ADMIN', 'Melihat Laporan Master Barang', '2018-02-04 10:23:01'),
(292, 'ADMIN', 'Melihat Laporan Master Barang Service', '2018-02-04 10:23:30'),
(293, 'ADMIN', 'Melihat Laporan Barang Keluar', '2018-02-04 10:23:38'),
(294, 'ADMIN', 'Melihat Laporan Penyesuaian Stok', '2018-02-04 10:23:57');

-- --------------------------------------------------------

--
-- Table structure for table `tbmbarang`
--

CREATE TABLE `tbmbarang` (
  `IdBarang` int(10) NOT NULL,
  `IdKategoriBarang` int(10) NOT NULL,
  `NamaBarang` varchar(50) NOT NULL,
  `Garansi` enum('Ya','Tidak') NOT NULL,
  `Satuan` varchar(25) NOT NULL,
  `Keterangan` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbmbarang`
--

INSERT INTO `tbmbarang` (`IdBarang`, `IdKategoriBarang`, `NamaBarang`, `Garansi`, `Satuan`, `Keterangan`) VALUES
(1, 23, 'ICA 600 V.A', 'Tidak', 'BUAH', ''),
(2, 31, 'HP 802 HITAM', 'Tidak', 'BOTOL', ''),
(3, 31, 'HP 802 WARNA', 'Tidak', '', ''),
(4, 7, 'GIGABIT', 'Tidak', '', ''),
(5, 12, 'LOGITECH', 'Tidak', '', ''),
(6, 11, 'LOGITECH', 'Tidak', '', ''),
(7, 13, 'LOGITECH', 'Tidak', '', ''),
(8, 17, 'BATERAI CMOS', 'Tidak', '', ''),
(9, 8, 'SANDISK 8GB', 'Tidak', '', '');

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
(1, 1, 'AC AKUNTING SERVER', ''),
(2, 1, 'AC AKUNTING HAYATI', ''),
(3, 1, 'AC AKUNTING LINDA', ''),
(4, 1, 'AC AKUNTING TINA', ''),
(5, 1, 'AC AKUNTING SILVI', ''),
(6, 1, 'AC AKUNTING WILLIAM', ''),
(7, 1, 'AC RUANG IT', ''),
(8, 1, 'AC RUANG MEETING', ''),
(9, 1, 'AC TENDER CITRA', ''),
(10, 1, 'AC TENDER LIDYA', ''),
(11, 1, 'AC APM MONIC', ''),
(12, 1, 'AC APM PUTRA', ''),
(13, 2, 'KOMPUTER MEILISA', ''),
(14, 2, 'KOMPUTER EVELYN', ''),
(15, 2, 'KOMPUTER MIRA', ''),
(16, 2, 'KOMPUTER ALVIN', ''),
(17, 2, 'KOMPUTER SERVER AKUNTING', ''),
(18, 2, 'KOMPUTER HAYATI', ''),
(19, 2, 'KOMPUTER LINDA', ''),
(20, 2, 'KOMPUTER TOMMY', ''),
(21, 2, 'KOMPUTER YESSI', ''),
(22, 2, 'KOMPUTER TAHSYA', ''),
(23, 2, 'KOMPUTER FENNI', ''),
(24, 2, 'KOMPUTER DEWI', ''),
(25, 2, 'KOMPUTER TINA', ''),
(26, 2, 'KOMPUTER SILVI', ''),
(27, 2, 'KOMPUTER LENA', ''),
(28, 2, 'KOMPUTER WINDA', ''),
(29, 2, 'KOMPUTER FERNANDA', ''),
(30, 2, 'KOMPUTER SUSAN', ''),
(31, 2, 'KOMPUTER MONIC', ''),
(32, 2, 'KOMPUTER BIKA', ''),
(33, 2, 'KOMPUTER CITRA', ''),
(34, 2, 'KOMPUTER SHINTA', ''),
(35, 2, 'KOMPUTER LIDYA', ''),
(36, 2, 'KOMPUTER SERVER TENDER', ''),
(37, 2, 'KOMPUTER MERI', ''),
(38, 2, 'KOMPUTER YULI', ''),
(39, 2, 'KOMPUTER LILIANTI', ''),
(40, 2, 'KOMPUTER SHINTA K', ''),
(41, 2, 'KOMPUTER LILIANI', ''),
(42, 2, 'KOMPUTER RUDI', ''),
(43, 2, 'KOMPUTER JIMMY', ''),
(44, 2, 'KOMPUTER RATNA', ''),
(45, 2, 'KOMPUTER DELLA', ''),
(46, 2, 'KOMPUTER SERVER PAJAK', ''),
(47, 2, 'KOMPUTER YANTI', ''),
(48, 2, 'KOMPUTER HALIK', ''),
(49, 2, 'KOMPUTER HERISON', ''),
(50, 1, 'AC PAJAK MERI', ''),
(51, 1, 'AC PAJAK LILIANTI', ''),
(52, 1, 'AC PAJAK RATNA', ''),
(53, 1, 'AC PAJAK RUANG TUNGGU', ''),
(54, 1, 'AC PAJAK YENNI', ''),
(55, 1, 'AC PAJAK YANTI', ''),
(56, 1, 'AC PAJAK HALIK', ''),
(57, 1, 'AC PAJAK WILLIAM', ''),
(58, 1, 'AC PAJAK HERISON', ''),
(59, 1, 'AC PAJAK RUANG MEETING', '');

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
(1, 'KOMPUTER', ''),
(2, 'LAPTOP', ''),
(3, 'PRINTER', ''),
(4, 'AC', ''),
(5, 'LISTRIK', ''),
(6, 'FOTOCOPY', '');

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
(2, 'KOMPUTER', '');

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
(1, 'CUCI AC', ''),
(2, 'MAINTENANCE', '');

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
(44, '2020042', 'Fernanda, S.Kom', ''),
(45, '2020090', 'Riki Fernando, S.Kom, MTA', ''),
(46, '2020026', 'William', ''),
(47, '2020023', 'Winda', ''),
(48, '2020037', 'Zeppri', ''),
(49, '2020099T', 'Lidiya', ''),
(50, '2020100T', 'Hayril', ''),
(51, '2020092', 'Liliani', ''),
(52, '2020000', 'Server', ''),
(53, '2020104', 'Martono', '');

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
(1, 1, 'PROSESOR', ''),
(2, 1, 'MOTHERBOARD', ''),
(3, 1, 'RAM', ''),
(4, 1, 'HARDDISK INTERNAL', ''),
(5, 1, 'HARDDISK EKSTERNAL', ''),
(6, 1, 'POWER SUPPLY', ''),
(7, 1, 'LAN CARD', ''),
(8, 1, 'FLASH DISK', ''),
(9, 1, 'UPS', ''),
(10, 1, 'MONITOR', ''),
(11, 1, 'KEYBOARD', ''),
(12, 1, 'MOUSE', ''),
(13, 1, 'KEYBOARD & MOUSE', ''),
(14, 1, 'CASING', ''),
(15, 1, 'KIPAS PROSESOR', ''),
(16, 1, 'KIPAS CASING', ''),
(17, 1, 'BATERAI CMOS', ''),
(18, 1, 'DVD INTERNAL', ''),
(19, 1, 'DVD EKSTERNAL', ''),
(20, 1, 'KABEL LAN & RJ 45', ''),
(22, 1, 'RJ 45', ''),
(23, 1, 'BATERAI UPS', ''),
(24, 1, 'SSD', ''),
(25, 1, 'MOUSE PAD', ''),
(26, 1, 'KASET CD', ''),
(27, 1, 'KASET DVD', ''),
(28, 3, 'PRINTER', ''),
(29, 3, 'CARTRIDGE', ''),
(30, 3, 'PITA', ''),
(31, 3, 'TINTA', ''),
(32, 3, 'PRINT HEAD', ''),
(33, 6, 'DRUM', ''),
(34, 6, 'TONER', ''),
(35, 6, 'CARTRIDGE', ''),
(36, 6, 'AKSESORIS', ''),
(37, 1, 'SWITCH', ''),
(38, 1, 'MODEM', ''),
(39, 1, 'HUB', ''),
(40, 1, 'STABILIZER', ''),
(42, 1, 'KABEL LAN', ''),
(43, 2, 'RAM', ''),
(44, 2, 'BATERAI', ''),
(45, 2, 'ADAPTOR', ''),
(46, 2, 'KEYBOARD', ''),
(47, 2, 'LCD', ''),
(48, 4, 'UNIT BARU', ''),
(49, 4, 'KOMPRESOR', ''),
(50, 4, 'UNIT INDOOR', ''),
(51, 4, 'UNIT OUTDOOR', ''),
(52, 5, 'TERMINAL', ''),
(53, 5, 'MCB', ''),
(54, 5, 'BOX', ''),
(55, 5, 'CABANG TIGA', ''),
(56, 5, 'LAMPU', ''),
(57, 5, 'STOP KONTAK', ''),
(58, 5, 'SKRING', '');

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
(1, 'ELEVEN KOMPUTER', '(0741)-889900', 'JL. GATOT SUBROTO', ''),
(2, 'TOKOPEDIA', '', '', ''),
(3, 'SIGMA KOMPUTER', '', '', '');

-- --------------------------------------------------------

--
-- Table structure for table `tbpenyesuaianstok`
--

CREATE TABLE `tbpenyesuaianstok` (
  `IdPenyesuaianStok` int(10) NOT NULL,
  `IdBarang` int(10) NOT NULL,
  `NomorPenyesuaianStok` varchar(10) NOT NULL,
  `TanggalPenyesuaianStok` date NOT NULL,
  `PenyesuaianStok` int(5) NOT NULL,
  `Keterangan` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbpenyesuaianstok`
--

INSERT INTO `tbpenyesuaianstok` (`IdPenyesuaianStok`, `IdBarang`, `NomorPenyesuaianStok`, `TanggalPenyesuaianStok`, `PenyesuaianStok`, `Keterangan`) VALUES
(1, 2, '0001/18/PY', '2018-02-03', 2, '');

-- --------------------------------------------------------

--
-- Table structure for table `tbpurchaserequest`
--

CREATE TABLE `tbpurchaserequest` (
  `IdPurchaseRequest` int(10) NOT NULL,
  `NomorPurchaseRequest` varchar(25) NOT NULL,
  `TanggalPurchaseRequest` date NOT NULL,
  `IdVendor` int(10) NOT NULL,
  `Keterangan` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbpurchaserequest`
--

INSERT INTO `tbpurchaserequest` (`IdPurchaseRequest`, `NomorPurchaseRequest`, `TanggalPurchaseRequest`, `IdVendor`, `Keterangan`) VALUES
(2, '0001/PR/PLT/II/2018', '2018-02-03', 1, '');

-- --------------------------------------------------------

--
-- Table structure for table `tbpurchaserequestdetail`
--

CREATE TABLE `tbpurchaserequestdetail` (
  `IdDetailPurchaseRequest` int(10) NOT NULL,
  `NomorPurchaseRequest` varchar(25) NOT NULL,
  `NomorKolom` int(5) NOT NULL,
  `IdBarang` int(10) NOT NULL,
  `HargaBarang` int(10) NOT NULL,
  `JumlahBarang` int(5) NOT NULL,
  `Keterangan` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbpurchaserequestdetail`
--

INSERT INTO `tbpurchaserequestdetail` (`IdDetailPurchaseRequest`, `NomorPurchaseRequest`, `NomorKolom`, `IdBarang`, `HargaBarang`, `JumlahBarang`, `Keterangan`) VALUES
(7, '0001/PR/PLT/II/2018', 1, 5, 75000, 1, 'Untuk Ko Herison'),
(8, '0001/PR/PLT/II/2018', 2, 2, 103000, 2, '1 Untuk Ce Yanti, 1 Untuk Winda');

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
(1, 1, 2, '2017-12-30', '2018-03-30', ''),
(2, 1, 1, '2017-12-30', '2018-03-30', ''),
(3, 2, 13, '2017-09-26', '2018-03-26', ''),
(4, 1, 2, '2018-02-03', '2018-02-04', ''),
(5, 1, 2, '2018-02-03', '2018-02-08', ''),
(6, 1, 1, '2018-02-03', '2018-02-08', '');

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
(1, 'ADMIN', '73acd9a5972130b75066c82595a1fae3', 'Administrator'),
(2, 'FERNANDA', 'decf5488b93edaa5b910f9c1f6aee96a', 'Operator');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `tbbarangkeluar`
--
ALTER TABLE `tbbarangkeluar`
  ADD PRIMARY KEY (`IdBarangKeluar`),
  ADD UNIQUE KEY `NomorBarangKeluar` (`NomorBarangKeluar`),
  ADD KEY `IdBarang` (`IdBarang`),
  ADD KEY `IdKaryawan` (`IdKaryawan`),
  ADD KEY `JumlahBarang` (`JumlahBarang`);

--
-- Indexes for table `tbbarangmasuk`
--
ALTER TABLE `tbbarangmasuk`
  ADD PRIMARY KEY (`IdBarangMasuk`),
  ADD UNIQUE KEY `NomorBarangMasuk` (`NomorBarangMasuk`),
  ADD KEY `NomorPurchaseRequest` (`NomorPurchaseRequest`),
  ADD KEY `IdVendor` (`IdVendor`);

--
-- Indexes for table `tbbarangmasukdetail`
--
ALTER TABLE `tbbarangmasukdetail`
  ADD PRIMARY KEY (`IdDetailBarangMasuk`),
  ADD KEY `NomorBarangMasuk` (`NomorBarangMasuk`),
  ADD KEY `IdBarang` (`IdBarang`),
  ADD KEY `JumlahBarang` (`JumlahBarang`),
  ADD KEY `HargaBarang` (`HargaBarang`);

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
-- Indexes for table `tbpurchaserequest`
--
ALTER TABLE `tbpurchaserequest`
  ADD PRIMARY KEY (`IdPurchaseRequest`),
  ADD UNIQUE KEY `NomorPurchaseRequest` (`NomorPurchaseRequest`),
  ADD KEY `IdVendor` (`IdVendor`),
  ADD KEY `TanggalPurchaseRequest` (`TanggalPurchaseRequest`);

--
-- Indexes for table `tbpurchaserequestdetail`
--
ALTER TABLE `tbpurchaserequestdetail`
  ADD PRIMARY KEY (`IdDetailPurchaseRequest`),
  ADD KEY `NomorPurchaseRequest` (`NomorPurchaseRequest`),
  ADD KEY `IdBarang` (`IdBarang`),
  ADD KEY `HargaBarang` (`HargaBarang`),
  ADD KEY `JumlahBarang` (`JumlahBarang`);

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
-- AUTO_INCREMENT for table `tbbarangkeluar`
--
ALTER TABLE `tbbarangkeluar`
  MODIFY `IdBarangKeluar` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `tbbarangmasuk`
--
ALTER TABLE `tbbarangmasuk`
  MODIFY `IdBarangMasuk` int(10) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `tbbarangmasukdetail`
--
ALTER TABLE `tbbarangmasukdetail`
  MODIFY `IdDetailBarangMasuk` int(10) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `tbbarangrusak`
--
ALTER TABLE `tbbarangrusak`
  MODIFY `IdBarangRusak` int(10) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `tbhistory`
--
ALTER TABLE `tbhistory`
  MODIFY `IdHistory` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=295;

--
-- AUTO_INCREMENT for table `tbmbarang`
--
ALTER TABLE `tbmbarang`
  MODIFY `IdBarang` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT for table `tbmbarangservice`
--
ALTER TABLE `tbmbarangservice`
  MODIFY `IdBarangService` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=60;

--
-- AUTO_INCREMENT for table `tbmjenisbarang`
--
ALTER TABLE `tbmjenisbarang`
  MODIFY `IdJenisBarang` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT for table `tbmjenisbarangservice`
--
ALTER TABLE `tbmjenisbarangservice`
  MODIFY `IdJenisBarangService` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `tbmjenisservice`
--
ALTER TABLE `tbmjenisservice`
  MODIFY `IdJenisService` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `tbmkaryawan`
--
ALTER TABLE `tbmkaryawan`
  MODIFY `IdKaryawan` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=54;

--
-- AUTO_INCREMENT for table `tbmkategoribarang`
--
ALTER TABLE `tbmkategoribarang`
  MODIFY `IdKategoriBarang` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=59;

--
-- AUTO_INCREMENT for table `tbmvendor`
--
ALTER TABLE `tbmvendor`
  MODIFY `IdVendor` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `tbpenyesuaianstok`
--
ALTER TABLE `tbpenyesuaianstok`
  MODIFY `IdPenyesuaianStok` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `tbpurchaserequest`
--
ALTER TABLE `tbpurchaserequest`
  MODIFY `IdPurchaseRequest` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `tbpurchaserequestdetail`
--
ALTER TABLE `tbpurchaserequestdetail`
  MODIFY `IdDetailPurchaseRequest` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT for table `tbservice`
--
ALTER TABLE `tbservice`
  MODIFY `IdService` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT for table `tbuser`
--
ALTER TABLE `tbuser`
  MODIFY `IdUser` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `tbbarangkeluar`
--
ALTER TABLE `tbbarangkeluar`
  ADD CONSTRAINT `tbbarangkeluar_ibfk_1` FOREIGN KEY (`IdBarang`) REFERENCES `tbmbarang` (`IdBarang`) ON UPDATE CASCADE,
  ADD CONSTRAINT `tbbarangkeluar_ibfk_2` FOREIGN KEY (`IdKaryawan`) REFERENCES `tbmkaryawan` (`IdKaryawan`) ON UPDATE CASCADE;

--
-- Constraints for table `tbbarangmasuk`
--
ALTER TABLE `tbbarangmasuk`
  ADD CONSTRAINT `tbbarangmasuk_ibfk_1` FOREIGN KEY (`IdVendor`) REFERENCES `tbmvendor` (`IdVendor`) ON UPDATE CASCADE,
  ADD CONSTRAINT `tbbarangmasuk_ibfk_2` FOREIGN KEY (`NomorPurchaseRequest`) REFERENCES `tbpurchaserequest` (`NomorPurchaseRequest`) ON UPDATE CASCADE;

--
-- Constraints for table `tbbarangmasukdetail`
--
ALTER TABLE `tbbarangmasukdetail`
  ADD CONSTRAINT `tbbarangmasukdetail_ibfk_1` FOREIGN KEY (`IdBarang`) REFERENCES `tbmbarang` (`IdBarang`) ON UPDATE CASCADE,
  ADD CONSTRAINT `tbbarangmasukdetail_ibfk_2` FOREIGN KEY (`NomorBarangMasuk`) REFERENCES `tbbarangmasuk` (`NomorBarangMasuk`) ON UPDATE CASCADE;

--
-- Constraints for table `tbbarangrusak`
--
ALTER TABLE `tbbarangrusak`
  ADD CONSTRAINT `tbbarangrusak_ibfk_1` FOREIGN KEY (`IdBarang`) REFERENCES `tbmbarang` (`IdBarang`) ON UPDATE CASCADE,
  ADD CONSTRAINT `tbbarangrusak_ibfk_2` FOREIGN KEY (`IdKaryawan`) REFERENCES `tbmkaryawan` (`IdKaryawan`) ON UPDATE CASCADE;

--
-- Constraints for table `tbmbarang`
--
ALTER TABLE `tbmbarang`
  ADD CONSTRAINT `tbmbarang_ibfk_1` FOREIGN KEY (`IdKategoriBarang`) REFERENCES `tbmkategoribarang` (`IdKategoriBarang`) ON UPDATE CASCADE;

--
-- Constraints for table `tbmbarangservice`
--
ALTER TABLE `tbmbarangservice`
  ADD CONSTRAINT `tbmbarangservice_ibfk_1` FOREIGN KEY (`IdJenisBarangService`) REFERENCES `tbmjenisbarangservice` (`IdJenisBarangService`) ON UPDATE CASCADE;

--
-- Constraints for table `tbmkategoribarang`
--
ALTER TABLE `tbmkategoribarang`
  ADD CONSTRAINT `tbmkategoribarang_ibfk_1` FOREIGN KEY (`IdJenisBarang`) REFERENCES `tbmjenisbarang` (`IdJenisBarang`) ON UPDATE CASCADE;

--
-- Constraints for table `tbpenyesuaianstok`
--
ALTER TABLE `tbpenyesuaianstok`
  ADD CONSTRAINT `tbpenyesuaianstok_ibfk_1` FOREIGN KEY (`IdBarang`) REFERENCES `tbmbarang` (`IdBarang`) ON UPDATE CASCADE;

--
-- Constraints for table `tbpurchaserequest`
--
ALTER TABLE `tbpurchaserequest`
  ADD CONSTRAINT `tbpurchaserequest_ibfk_1` FOREIGN KEY (`IdVendor`) REFERENCES `tbmvendor` (`IdVendor`) ON UPDATE CASCADE;

--
-- Constraints for table `tbpurchaserequestdetail`
--
ALTER TABLE `tbpurchaserequestdetail`
  ADD CONSTRAINT `tbpurchaserequestdetail_ibfk_1` FOREIGN KEY (`IdBarang`) REFERENCES `tbmbarang` (`IdBarang`) ON UPDATE CASCADE,
  ADD CONSTRAINT `tbpurchaserequestdetail_ibfk_2` FOREIGN KEY (`NomorPurchaseRequest`) REFERENCES `tbpurchaserequest` (`NomorPurchaseRequest`) ON UPDATE CASCADE;

--
-- Constraints for table `tbservice`
--
ALTER TABLE `tbservice`
  ADD CONSTRAINT `tbservice_ibfk_1` FOREIGN KEY (`IdBarangService`) REFERENCES `tbmbarangservice` (`IdBarangService`) ON UPDATE CASCADE,
  ADD CONSTRAINT `tbservice_ibfk_2` FOREIGN KEY (`IdJenisService`) REFERENCES `tbmjenisservice` (`IdJenisService`) ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
