-- phpMyAdmin SQL Dump
-- version 4.7.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jan 30, 2018 at 07:19 AM
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

-- --------------------------------------------------------

--
-- Table structure for table `tbbarangkeluar`
--

CREATE TABLE `tbbarangkeluar` (
  `IdBarangKeluar` int(10) NOT NULL,
  `NomorBarangKeluar` varchar(12) NOT NULL,
  `TanggalBarangKeluar` date NOT NULL,
  `IdKaryawan` int(10) NOT NULL,
  `IdBarang` int(10) NOT NULL,
  `JumlahBarang` int(5) NOT NULL,
  `Keterangan` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `tbbarangmasuk`
--

CREATE TABLE `tbbarangmasuk` (
  `IdBarangMasuk` int(10) NOT NULL,
  `NomorBarangMasuk` varchar(12) NOT NULL,
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
  `NomorBarangMasuk` varchar(12) NOT NULL,
  `NomorKolom` int(5) NOT NULL,
  `IdBarang` int(10) NOT NULL,
  `SerialNumber` varchar(50) NOT NULL,
  `JumlahBarang` int(5) NOT NULL,
  `Keterangan` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

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
  ADD KEY `JumlahBarang` (`JumlahBarang`);

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
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
