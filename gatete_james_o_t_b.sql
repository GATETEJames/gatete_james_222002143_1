-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Feb 19, 2024 at 10:30 AM
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
-- Database: `gatete_james_o_t_b`
--

-- --------------------------------------------------------

--
-- Table structure for table `admin`
--

CREATE TABLE `admin` (
  `id` int(12) NOT NULL,
  `email` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `admin`
--

INSERT INTO `admin` (`id`, `email`, `password`) VALUES
(1, 'admin@gmail.com', '1234');

-- --------------------------------------------------------

--
-- Table structure for table `agency`
--

CREATE TABLE `agency` (
  `agencyID` int(255) NOT NULL,
  `AgencyName` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `phone` varchar(255) NOT NULL,
  `location` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `agency`
--

INSERT INTO `agency` (`agencyID`, `AgencyName`, `email`, `phone`, `location`) VALUES
(1, 'ritco epress', 'ritco1@gmail.com', '078665654', 'huye'),
(2, 'horizon express', 'jgfyfhdg', '456783456', 'gisagara'),
(5, 'stella express', 'stella@gmail.com', '2345678987', 'huye'),
(6, 'volcano express', 'volcano express@gmail.com', '0987654321', 'muhanga');

-- --------------------------------------------------------

--
-- Table structure for table `booking`
--

CREATE TABLE `booking` (
  `bookingID` int(255) NOT NULL,
  `fullname` varchar(255) NOT NULL,
  `phone` varchar(255) NOT NULL,
  `idnumber` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `agencyID` int(255) DEFAULT NULL,
  `amount` varchar(255) NOT NULL,
  `location` varchar(255) NOT NULL,
  `destination` varchar(255) NOT NULL,
  `bookingDate` date DEFAULT NULL,
  `busStation` varchar(255) NOT NULL,
  `dateNow` timestamp(6) NOT NULL DEFAULT current_timestamp(6) ON UPDATE current_timestamp(6),
  `status` varchar(255) NOT NULL DEFAULT 'NOT APPROVED'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `booking`
--

INSERT INTO `booking` (`bookingID`, `fullname`, `phone`, `idnumber`, `email`, `agencyID`, `amount`, `location`, `destination`, `bookingDate`, `busStation`, `dateNow`, `status`) VALUES
(1, 'GATETE JAMES', '0789766191', '435687434532', 'gatetejames@gmail.com', 2, '1800', 'huye', 'kgl', '2024-01-10', 'huye', '2024-01-23 08:00:00.000000', 'pending'),
(2, 'fred kamugundu', '0789476574', '120037747473', 'fred@gmail.com', 1, '2100', 'huye', 'kigali', '2021-01-01', 'huye', '2021-01-01 22:00:00.000000', 'now'),
(3, 'james', '345678', '123456745', 'sdfghjhgfd', 1, '123', 'huye', 'ertyui', '2021-01-01', 'huy', '2021-01-01 22:00:00.000000', 'now'),
(10, 'fred', '078976543', '234567765432', 'dfghjhfgdfsdfgf', 1, '45653', 'huye', 'kigali', '2021-01-09', 'huye', '2021-01-01 08:00:00.000000', 'active');

-- --------------------------------------------------------

--
-- Table structure for table `bus`
--

CREATE TABLE `bus` (
  `busID` int(255) NOT NULL,
  `BusPlate` varchar(255) NOT NULL,
  `agencyID` int(255) DEFAULT NULL,
  `FreeSeats` varchar(255) NOT NULL,
  `destination` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `bus`
--

INSERT INTO `bus` (`busID`, `BusPlate`, `agencyID`, `FreeSeats`, `destination`) VALUES
(1, 'E400Q', 1, '20', 'HUYE');

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `user_id` int(255) NOT NULL,
  `firstname` varchar(255) NOT NULL,
  `lastname` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `phone` varchar(255) NOT NULL,
  `address` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `role` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`user_id`, `firstname`, `lastname`, `email`, `phone`, `address`, `password`, `role`) VALUES
(1, 'GATETE', 'JAMES', 'gatete@gmail.com', 'huye', '0789766191', '1234', 'client'),
(2, 'gisa', 'patrick', 'gisapatrick@gmail.com', 'kigali', '84565431654', 'gisap123', 'client'),
(8, 'good', '', 'dfghjk', '', '', 'aasdfgh', ''),
(9, 'valentin', 'kwizera', 'quiz@gmail.com', 'huye', '0784566543', '12345', 'customer'),
(10, 'fred', 'kamugundu', 'kamugundu@gmail.com', 'kigali', '078664645', 'fred', 'client');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `admin`
--
ALTER TABLE `admin`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `agency`
--
ALTER TABLE `agency`
  ADD PRIMARY KEY (`agencyID`),
  ADD UNIQUE KEY `AgencyName` (`AgencyName`);

--
-- Indexes for table `booking`
--
ALTER TABLE `booking`
  ADD PRIMARY KEY (`bookingID`),
  ADD KEY `agencyID` (`agencyID`);

--
-- Indexes for table `bus`
--
ALTER TABLE `bus`
  ADD PRIMARY KEY (`busID`),
  ADD KEY `agencyID` (`agencyID`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`user_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `agency`
--
ALTER TABLE `agency`
  MODIFY `agencyID` int(255) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT for table `booking`
--
ALTER TABLE `booking`
  MODIFY `bookingID` int(255) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT for table `bus`
--
ALTER TABLE `bus`
  MODIFY `busID` int(255) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `user_id` int(255) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `booking`
--
ALTER TABLE `booking`
  ADD CONSTRAINT `booking_ibfk_1` FOREIGN KEY (`agencyID`) REFERENCES `agency` (`agencyID`);

--
-- Constraints for table `bus`
--
ALTER TABLE `bus`
  ADD CONSTRAINT `bus_ibfk_1` FOREIGN KEY (`agencyID`) REFERENCES `agency` (`agencyID`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
