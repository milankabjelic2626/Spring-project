-- phpMyAdmin SQL Dump
-- version 4.7.0
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Generation Time: Apr 04, 2018 at 12:26 AM
-- Server version: 10.1.21-MariaDB
-- PHP Version: 5.6.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `it355pzmilanka`
--

-- --------------------------------------------------------

--
-- Table structure for table `korisnik`
--

CREATE TABLE `korisnik` (
  `korisnik_id` int(11) NOT NULL,
  `enabled` bit(1) DEFAULT NULL,
  `korisnicko_ime` varchar(255) DEFAULT NULL,
  `lozinka` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `korisnik`
--

INSERT INTO `korisnik` (`korisnik_id`, `enabled`, `korisnicko_ime`, `lozinka`) VALUES
(1, b'1', 'milanka', 'milanka'),
(2, b'1', 'mira', 'mira'),
(3, b'1', 'ime1', 'ime1'),
(4, b'1', 'tamara', 'tamara123'),
(5, b'1', 'nemanja', 'nemanja123'),
(6, b'1', 'ime6', 'ime6'),
(7, b'1', 'jovanajo', 'jedigovna'),
(8, b'1', '520marija', 'marija520');

-- --------------------------------------------------------

--
-- Table structure for table `kupac`
--

CREATE TABLE `kupac` (
  `kupac_id` int(11) NOT NULL,
  `enabled` bit(1) NOT NULL,
  `korisnicko_ime` varchar(255) NOT NULL,
  `kupac_adresa` varchar(255) NOT NULL,
  `kupac_email` varchar(255) NOT NULL,
  `kupac_grad` varchar(255) NOT NULL,
  `kupac_ime` varchar(255) NOT NULL,
  `kupac_telefon` varchar(255) NOT NULL,
  `lozinka` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `kupac`
--

INSERT INTO `kupac` (`kupac_id`, `enabled`, `korisnicko_ime`, `kupac_adresa`, `kupac_email`, `kupac_grad`, `kupac_ime`, `kupac_telefon`, `lozinka`) VALUES
(1, b'1', 'milanka', 'Nikole Tesle bb', 'milanka@gmail.com', 'Sid', 'Milanka Bjelic', '066555678', 'milanka'),
(2, b'1', 'mira', 'Cvijiceva', 'mira@gmail.com', 'Novi Sad', 'Mira Miric', '0614455321', 'mira'),
(3, b'1', 'ime1', 'adresa1', 'email@gmail.com', 'grad1', 'ime1', '065444332', 'ime1'),
(4, b'1', 'tamara', 'Jurija Gagarina 30', 'tamara@gmail.com', 'Beograd', 'Tamara Lesic', '065446789', 'tamara123'),
(5, b'1', 'nemanja', 'Vija Bajamondi', 'nemanja@gmail.com', 'Trst', 'Nemanja Vico', '065444321', 'nemanja123'),
(6, b'1', 'ime6', 'adresa6', 'email6', 'grad6', 'ime6', 'broj6', 'ime6'),
(7, b'1', 'jovanajo', 'Bulevar Arsenija carnojevica 223', 'jowana13@gmail.com', 'Beograd', 'Jovana Stankovic', '0611738096', 'jedigovna'),
(8, b'1', '520marija', 'Matije Ivanica 5', '520marija@gmail.com', 'Beograd', 'Marija Petrovic', '0631026559', 'marija520');

-- --------------------------------------------------------

--
-- Table structure for table `porudzbina`
--

CREATE TABLE `porudzbina` (
  `porudzbina_id` int(11) NOT NULL,
  `datum` datetime DEFAULT NULL,
  `korisnicko_ime` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `porudzbina`
--

INSERT INTO `porudzbina` (`porudzbina_id`, `datum`, `korisnicko_ime`) VALUES
(1, '2018-02-27 13:28:16', 'mira'),
(2, '2018-02-27 21:13:30', 'tamara'),
(3, '2018-03-05 01:23:50', 'mira'),
(4, '2018-03-29 23:17:00', 'mira'),
(5, '2018-03-30 23:51:54', 'milanka'),
(6, '2018-03-31 14:48:45', 'mira'),
(7, '2018-04-01 14:12:59', 'jovanajo'),
(8, '2018-04-01 14:17:21', '520marija'),
(9, '2018-04-01 14:20:14', '520marija'),
(10, '2018-04-04 00:22:23', 'mira');

-- --------------------------------------------------------

--
-- Table structure for table `porudzbina_detalji`
--

CREATE TABLE `porudzbina_detalji` (
  `detalji_id` int(11) NOT NULL,
  `cena` double NOT NULL,
  `kolicina` int(11) NOT NULL,
  `porudzbina_id` int(11) NOT NULL,
  `proizvod_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `porudzbina_detalji`
--

INSERT INTO `porudzbina_detalji` (`detalji_id`, `cena`, `kolicina`, `porudzbina_id`, `proizvod_id`) VALUES
(1, 3200, 1, 1, 2),
(2, 1999, 1, 1, 3),
(3, 3200, 1, 2, 2),
(4, 3450, 1, 2, 5),
(5, 1789, 1, 3, 1),
(6, 5000, 1, 3, 4),
(7, 3200, 1, 4, 2),
(8, 1999, 1, 4, 3),
(9, 3050, 1, 5, 5),
(10, 1789, 1, 6, 1),
(11, 5500, 1, 7, 4),
(12, 1999, 1, 8, 3),
(13, 3200, 1, 8, 2),
(14, 3050, 1, 9, 5),
(15, 1999, 1, 10, 3),
(16, 2289, 1, 10, 1);

-- --------------------------------------------------------

--
-- Table structure for table `proizvod`
--

CREATE TABLE `proizvod` (
  `proizvod_id` int(11) NOT NULL,
  `proizvod_cena` double DEFAULT NULL,
  `proizvod_kategorija` varchar(255) DEFAULT NULL,
  `proizvod_kolicina` int(11) DEFAULT NULL,
  `proizvod_naziv` varchar(255) NOT NULL,
  `proizvod_opis` varchar(255) DEFAULT NULL,
  `proizvod_slika` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `proizvod`
--

INSERT INTO `proizvod` (`proizvod_id`, `proizvod_cena`, `proizvod_kategorija`, `proizvod_kolicina`, `proizvod_naziv`, `proizvod_opis`, `proizvod_slika`) VALUES
(1, 2289, 'naocare', 340, 'cool', 'plava stakla su kul', '/Slike/slika10.jpg'),
(2, 3300, 'naocare', 100, 'crna udovica', 'za razvedene', '/Slike/slika17.jpg'),
(3, 1999, 'naocare', 230, 'barbie', 'roza bas', '/Slike/slika3.jpg'),
(4, 4500, 'naocare', 12, 'wow wow', 'samo okruglo', '/Slike/slika8.jpg'),
(5, 3050, 'naocare', 300, 'simple', 'klasika moze', '/Slike/slika14.jpg'),
(6, 4140, 'naocare', 34, 'Osmougao', 'crveno volim te', '/Slike/slika13.jpg');

-- --------------------------------------------------------

--
-- Table structure for table `rola`
--

CREATE TABLE `rola` (
  `rola_id` int(11) NOT NULL,
  `korisnicko_ime` varchar(255) DEFAULT NULL,
  `rola_naziv` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `rola`
--

INSERT INTO `rola` (`rola_id`, `korisnicko_ime`, `rola_naziv`) VALUES
(1, 'milanka', 'ROLA_ADMIN'),
(2, 'mira', 'ROLA_KORISNIK'),
(3, 'ime1', 'ROLA_KORISNIK'),
(4, 'tamara', 'ROLA_KORISNIK'),
(5, 'nemanja', 'ROLA_KORISNIK'),
(6, 'ime6', 'ROLA_KORISNIK'),
(7, 'jovanajo', 'ROLA_KORISNIK'),
(8, '520marija', 'ROLA_KORISNIK');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `korisnik`
--
ALTER TABLE `korisnik`
  ADD PRIMARY KEY (`korisnik_id`);

--
-- Indexes for table `kupac`
--
ALTER TABLE `kupac`
  ADD PRIMARY KEY (`kupac_id`);

--
-- Indexes for table `porudzbina`
--
ALTER TABLE `porudzbina`
  ADD PRIMARY KEY (`porudzbina_id`);

--
-- Indexes for table `porudzbina_detalji`
--
ALTER TABLE `porudzbina_detalji`
  ADD PRIMARY KEY (`detalji_id`);

--
-- Indexes for table `proizvod`
--
ALTER TABLE `proizvod`
  ADD PRIMARY KEY (`proizvod_id`);

--
-- Indexes for table `rola`
--
ALTER TABLE `rola`
  ADD PRIMARY KEY (`rola_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `korisnik`
--
ALTER TABLE `korisnik`
  MODIFY `korisnik_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;
--
-- AUTO_INCREMENT for table `kupac`
--
ALTER TABLE `kupac`
  MODIFY `kupac_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;
--
-- AUTO_INCREMENT for table `porudzbina`
--
ALTER TABLE `porudzbina`
  MODIFY `porudzbina_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;
--
-- AUTO_INCREMENT for table `porudzbina_detalji`
--
ALTER TABLE `porudzbina_detalji`
  MODIFY `detalji_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=17;
--
-- AUTO_INCREMENT for table `proizvod`
--
ALTER TABLE `proizvod`
  MODIFY `proizvod_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;
--
-- AUTO_INCREMENT for table `rola`
--
ALTER TABLE `rola`
  MODIFY `rola_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
