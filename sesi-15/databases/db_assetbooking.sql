-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jul 09, 2026 at 03:22 PM
-- Server version: 10.4.32-MariaDB
-- PHP Version: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `db_assetbooking`
--

-- --------------------------------------------------------

--
-- Table structure for table `tb_aset`
--

CREATE TABLE `tb_aset` (
  `id_aset` varchar(10) NOT NULL,
  `nama_aset` varchar(100) NOT NULL,
  `kategori` varchar(50) NOT NULL,
  `status_pinjam` varchar(20) DEFAULT 'Tersedia'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `tb_aset`
--

INSERT INTO `tb_aset` (`id_aset`, `nama_aset`, `kategori`, `status_pinjam`) VALUES
('E001', 'Infokus 1', 'Elektronik', 'Tersedia'),
('R001', 'Ruangan B1A', 'Ruangan', 'Dipinjam'),
('R002', 'Ruangan B1B', 'Ruangan', 'Tersedia');

-- --------------------------------------------------------

--
-- Table structure for table `tb_mahasiswa`
--

CREATE TABLE `tb_mahasiswa` (
  `nim` varchar(15) NOT NULL,
  `nama_lengkap` varchar(100) NOT NULL,
  `program_studi` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `tb_peminjaman`
--

CREATE TABLE `tb_peminjaman` (
  `id_pinjam` int(11) NOT NULL,
  `id_aset` varchar(10) DEFAULT NULL,
  `nim` varchar(15) DEFAULT NULL,
  `tanggal_pinjam` date DEFAULT NULL,
  `tanggal_kembali` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `tb_aset`
--
ALTER TABLE `tb_aset`
  ADD PRIMARY KEY (`id_aset`);

--
-- Indexes for table `tb_mahasiswa`
--
ALTER TABLE `tb_mahasiswa`
  ADD PRIMARY KEY (`nim`);

--
-- Indexes for table `tb_peminjaman`
--
ALTER TABLE `tb_peminjaman`
  ADD PRIMARY KEY (`id_pinjam`),
  ADD KEY `id_aset` (`id_aset`),
  ADD KEY `nim` (`nim`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `tb_peminjaman`
--
ALTER TABLE `tb_peminjaman`
  MODIFY `id_pinjam` int(11) NOT NULL AUTO_INCREMENT;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `tb_peminjaman`
--
ALTER TABLE `tb_peminjaman`
  ADD CONSTRAINT `tb_peminjaman_ibfk_1` FOREIGN KEY (`id_aset`) REFERENCES `tb_aset` (`id_aset`),
  ADD CONSTRAINT `tb_peminjaman_ibfk_2` FOREIGN KEY (`nim`) REFERENCES `tb_mahasiswa` (`nim`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
