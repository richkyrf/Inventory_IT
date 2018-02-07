-- phpMyAdmin SQL Dump
-- version 4.7.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Feb 07, 2018 at 03:32 AM
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
  `IdDetailBarangMasuk` int(10) NOT NULL,
  `Keterangan` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

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
(1, 'Admin', 'Melihat Laporan Master Barang Service', '2018-02-07 09:20:48'),
(2, 'Admin', 'Melihat Laporan Service', '2018-02-07 09:21:01'),
(3, 'Admin', 'Melihat Laporan Service', '2018-02-07 09:29:36');

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
(1, 23, 'ICA 600 V.A', 'Tidak', 'PCS', ''),
(2, 31, 'HP 802 HITAM', 'Tidak', 'PCS', ''),
(3, 31, 'HP 802 WARNA', 'Tidak', 'PCS', ''),
(4, 7, 'GIGABIT', 'Tidak', 'PCS', ''),
(5, 12, 'LOGITECH', 'Tidak', 'PCS', ''),
(6, 11, 'LOGITECH', 'Tidak', 'PCS', ''),
(7, 13, 'LOGITECH', 'Tidak', 'PCS', ''),
(8, 17, 'BATERAI CMOS', 'Tidak', 'PCS', ''),
(9, 8, 'SANDISK 8GB', 'Tidak', 'PCS', '');

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
(44, '2020042', 'Fernanda', ''),
(45, '2020090', 'Riki Fernando', ''),
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
(1, 1, 1, '2017-12-30', '2018-03-30', ''),
(2, 1, 2, '2017-12-30', '2018-03-30', ''),
(3, 1, 3, '2017-12-30', '2018-03-30', ''),
(4, 1, 4, '2017-12-30', '2018-03-30', ''),
(5, 1, 5, '2017-12-30', '2018-03-30', ''),
(6, 1, 6, '2017-12-30', '2018-03-30', ''),
(7, 1, 7, '2017-12-30', '2018-03-30', ''),
(8, 1, 8, '2017-12-30', '2018-03-30', ''),
(9, 1, 9, '2017-12-30', '2018-03-30', ''),
(10, 1, 10, '2017-12-30', '2018-03-30', ''),
(11, 1, 11, '2017-09-11', '2017-12-11', ''),
(12, 1, 12, '2017-09-11', '2017-12-11', ''),
(13, 1, 50, '2017-09-14', '2017-12-14', ''),
(14, 1, 51, '2017-09-14', '2017-12-14', ''),
(15, 1, 52, '2017-09-14', '2017-12-14', ''),
(16, 1, 54, '2017-09-14', '2017-12-14', ''),
(17, 1, 55, '2017-09-14', '2017-12-14', ''),
(18, 1, 53, '2017-09-14', '2017-12-14', ''),
(19, 1, 56, '2017-09-14', '2017-12-14', ''),
(20, 1, 57, '2017-09-14', '2017-12-14', ''),
(21, 1, 58, '2017-09-14', '2017-12-14', ''),
(22, 1, 59, '2017-09-14', '2017-12-14', ''),
(23, 2, 13, '2017-09-26', '2017-09-26', ''),
(24, 2, 14, '2017-09-26', '2017-09-26', ''),
(25, 2, 15, '2017-09-26', '2017-09-26', ''),
(26, 2, 16, '2017-09-26', '2017-09-26', ''),
(27, 2, 17, '2017-09-26', '2017-09-26', ''),
(28, 2, 18, '2017-09-26', '2017-09-26', ''),
(29, 2, 19, '2017-09-26', '2017-09-26', ''),
(30, 2, 20, '2017-09-26', '2017-09-26', ''),
(31, 2, 21, '2017-09-26', '2017-09-26', ''),
(32, 2, 22, '2017-09-26', '2017-09-26', ''),
(33, 2, 23, '2017-09-26', '2017-09-26', ''),
(34, 2, 24, '2017-09-26', '2017-09-26', ''),
(35, 2, 25, '2017-09-26', '2017-09-26', ''),
(36, 2, 26, '2017-09-26', '2017-09-26', ''),
(37, 2, 27, '2017-09-26', '2017-09-26', ''),
(38, 2, 28, '2017-09-26', '2017-09-26', ''),
(39, 2, 29, '2017-09-26', '2017-09-26', ''),
(40, 2, 30, '2017-09-26', '2017-09-26', ''),
(41, 2, 31, '2017-09-26', '2017-09-26', ''),
(42, 2, 32, '2017-09-26', '2017-09-26', ''),
(43, 2, 33, '2017-09-26', '2017-09-26', ''),
(44, 2, 34, '2017-09-26', '2017-09-26', ''),
(45, 2, 35, '2017-09-26', '2017-09-26', ''),
(46, 2, 36, '2017-09-26', '2017-09-26', ''),
(47, 2, 37, '2017-12-23', '2018-10-23', ''),
(48, 2, 38, '2017-12-23', '2018-10-23', ''),
(49, 2, 39, '2017-12-23', '2018-10-23', ''),
(50, 2, 40, '2017-12-23', '2018-10-23', ''),
(51, 2, 41, '2017-09-26', '2017-09-26', ''),
(52, 2, 42, '2017-09-26', '2017-09-26', ''),
(53, 2, 43, '2017-12-23', '2018-10-23', ''),
(54, 2, 44, '2017-12-23', '2018-10-23', ''),
(55, 2, 45, '2017-09-26', '2017-09-26', ''),
(56, 2, 46, '2017-09-26', '2017-09-26', ''),
(57, 2, 47, '2017-12-23', '2018-10-23', ''),
(58, 2, 48, '2017-12-26', '2018-10-26', ''),
(59, 2, 49, '2017-12-26', '2018-10-26', '');

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
(2, 'Fernanda', 'd41d8cd98f00b204e9800998ecf8427e', 'Operator');

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
  ADD KEY `JumlahBarang` (`JumlahBarang`),
  ADD KEY `IdDetailBarangMasuk` (`IdDetailBarangMasuk`);

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
  MODIFY `IdBarangKeluar` int(10) NOT NULL AUTO_INCREMENT;

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
  MODIFY `IdHistory` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

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
  MODIFY `IdPenyesuaianStok` int(10) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `tbpurchaserequest`
--
ALTER TABLE `tbpurchaserequest`
  MODIFY `IdPurchaseRequest` int(10) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `tbpurchaserequestdetail`
--
ALTER TABLE `tbpurchaserequestdetail`
  MODIFY `IdDetailPurchaseRequest` int(10) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `tbservice`
--
ALTER TABLE `tbservice`
  MODIFY `IdService` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=60;

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
