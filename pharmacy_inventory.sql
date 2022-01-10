-- phpMyAdmin SQL Dump
-- version 5.0.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 08, 2021 at 02:55 AM
-- Server version: 10.4.11-MariaDB
-- PHP Version: 7.4.3

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `pharmacy_inventory`
--

-- --------------------------------------------------------

--
-- Table structure for table `character`
--

CREATE TABLE `character` (
  `Char` varchar(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `character`
--

INSERT INTO `character` (`Char`) VALUES
('A'),
('B'),
('C'),
('D'),
('E'),
('F'),
('G'),
('H'),
('I'),
('J'),
('K'),
('L'),
('M'),
('N'),
('O'),
('P'),
('Q'),
('R'),
('S'),
('T'),
('U'),
('V'),
('W'),
('X'),
('Y'),
('Z');

-- --------------------------------------------------------

--
-- Table structure for table `customer`
--

CREATE TABLE `customer` (
  `CustomerID` int(15) NOT NULL,
  `Name` varchar(100) NOT NULL,
  `Phone1` varchar(11) NOT NULL,
  `Phone2` varchar(11) DEFAULT NULL,
  `Address` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `customer`
--

INSERT INTO `customer` (`CustomerID`, `Name`, `Phone1`, `Phone2`, `Address`) VALUES
(100, 'Hossam Naser Hassan', '01115150542', '01222154878', 'Giza Governoment');

-- --------------------------------------------------------

--
-- Table structure for table `importingprocess`
--

CREATE TABLE `importingprocess` (
  `SellerID` int(15) NOT NULL,
  `SellerName` varchar(100) NOT NULL,
  `Quantity` double NOT NULL,
  `Price` double NOT NULL,
  `SupplierID` int(15) NOT NULL,
  `SupplierName` varchar(100) NOT NULL,
  `ProductID` int(15) NOT NULL,
  `ProductName` varchar(100) NOT NULL,
  `ExpireDate` date NOT NULL,
  `Date` datetime NOT NULL DEFAULT current_timestamp(),
  `sequence` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `importingprocess`
--

INSERT INTO `importingprocess` (`SellerID`, `SellerName`, `Quantity`, `Price`, `SupplierID`, `SupplierName`, `ProductID`, `ProductName`, `ExpireDate`, `Date`, `sequence`) VALUES
(1001, 'Omar Atef', 22, 12, 1006, 'ElSafaa', 126, 'setofax', '2021-06-05', '2021-05-26 15:58:38', 16),
(1001, 'Omar Atef', 25, 13, 1006, 'ElSafaa', 134, 'Gongestal', '2021-06-05', '2021-05-03 18:21:33', 17),
(1001, 'Omar Atef', 25, 13, 1006, 'ElSafaa', 981, 'Shezax', '2021-06-05', '2021-05-03 18:22:10', 18),
(1001, 'Omar Atef', 21, 10, 1005, 'El Noor', 127, 'fine', '2021-06-16', '2021-05-03 18:51:18', 19),
(1001, 'Omar Atef', 21, 10, 1005, 'El Noor', 134, 'Gongestal', '2021-06-16', '2021-05-03 18:51:36', 20),
(1001, 'Omar Atef', 21, 10, 1005, 'El Noor', 125, 'catafast', '2021-06-16', '2021-05-03 18:51:39', 21),
(1001, 'Omar Atef', 21, 10, 1005, 'El Noor', 125, 'catafast', '2021-07-10', '2021-05-03 18:51:49', 22),
(1001, 'Omar Atef', 21, 10, 1005, 'El Noor', 981, 'Shezax', '2021-07-10', '2021-05-03 18:51:58', 23),
(1001, 'Omar Atef', 12, 10, 1005, 'El Noor', 125, 'catafast', '2021-07-22', '2021-05-03 18:52:08', 24),
(1001, 'Omar Atef', 15, 10, 1005, 'El Noor', 125, 'catafast', '2021-05-13', '2021-05-03 18:55:27', 25),
(1001, 'Omar Atef', 510, 13, 1006, 'ElSafaa', 127, 'fine', '2021-05-26', '2021-05-03 18:59:34', 26),
(1001, 'Omar Atef', 4, 21.5, 1006, 'ElSafaa', 981, 'Shezax', '2021-06-05', '2021-05-03 19:25:20', 27),
(1001, 'Omar Atef', 21, 10, 1007, 'El Shrook', 952, 'cenacomp', '2021-06-05', '2021-05-06 19:56:48', 28),
(200202, 'Ahmed', 90, 4.5, 10054, 'El Esraa', 125, 'catafast', '2021-05-29', '2021-05-08 00:47:18', 29);

-- --------------------------------------------------------

--
-- Table structure for table `product`
--

CREATE TABLE `product` (
  `ProductID` int(15) NOT NULL,
  `ProductName` varchar(100) NOT NULL,
  `Char` varchar(1) NOT NULL,
  `Quantity` double NOT NULL,
  `TotalPrice` double NOT NULL,
  `Ribbon` tinyint(1) NOT NULL,
  `RibbonPrice` double NOT NULL,
  `ExpireDate` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `product`
--

INSERT INTO `product` (`ProductID`, `ProductName`, `Char`, `Quantity`, `TotalPrice`, `Ribbon`, `RibbonPrice`, `ExpireDate`) VALUES
(125, 'catafast', 'C', 295, 20.25, 2, 10, '2021-05-12'),
(126, 'setofax', 'S', 110, 27, 3, 9, '2021-05-16'),
(127, 'fine', 'F', 593.9, 240, 12, 20, '2021-05-06'),
(134, 'Gongestal', 'G', 5.7999999999999945, 30, 3, 10, '2021-05-28'),
(521, 'Xezon', 'X', 5.2, 14, 3, 5, '2021-05-27'),
(952, 'cenacomp', 'C', 40.4, 50, 5, 10, '2021-06-05'),
(981, 'Shezax', 'S', 58.89999999999999, 65, 2, 30, '2022-06-03');

-- --------------------------------------------------------

--
-- Table structure for table `sellingprocess`
--

CREATE TABLE `sellingprocess` (
  `SellerID` int(15) NOT NULL,
  `SellerName` varchar(100) NOT NULL,
  `CustomerID` varchar(100) DEFAULT NULL,
  `ProductID` int(15) NOT NULL,
  `ProductName` varchar(100) NOT NULL,
  `Quantity` double NOT NULL,
  `Price` double NOT NULL,
  `Date` datetime NOT NULL DEFAULT current_timestamp(),
  `statues` varchar(15) NOT NULL,
  `seq` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `sellingprocess`
--

INSERT INTO `sellingprocess` (`SellerID`, `SellerName`, `CustomerID`, `ProductID`, `ProductName`, `Quantity`, `Price`, `Date`, `statues`, `seq`) VALUES
(1001, 'Omar Atef', '', 981, 'Shezax', 5, 300, '2021-05-04 04:19:36', 'In Pharmacy', 44),
(1001, 'Omar Atef', '2', 134, 'Gongestal', 10, 300, '2021-05-04 04:26:18', 'In Pharmacy', 45),
(1001, 'Omar Atef', '2', 126, 'setofax', 1, 27, '2021-05-04 04:26:18', 'In Pharmacy', 46),
(1001, 'Omar Atef', '2', 127, 'fine', 0.2, 40, '2021-05-04 04:26:18', 'In Pharmacy', 47),
(1001, 'Omar Atef', 'Unkown', 126, 'setofax', 2, 54, '2021-05-04 04:32:45', 'Delivery', 48),
(1001, 'Omar Atef', 'Unkown', 126, 'setofax', 2, 54, '2021-05-04 04:34:40', 'Delivery', 49),
(1001, 'Omar Atef', 'Unkown', 126, 'setofax', 0.2, 18, '2021-05-04 04:35:54', 'Delivery', 50),
(1001, 'Omar Atef', 'Unkown', 125, 'catafast', 3, 60.75, '2021-05-04 04:49:42', 'In Pharmacy', 51),
(1001, 'Omar Atef', 'Unkown', 125, 'catafast', 0.2, 20, '2021-05-04 04:49:42', 'In Pharmacy', 52),
(1001, 'Omar Atef', 'Unkown', 125, 'catafast', 3, 60.75, '2021-05-04 04:49:42', 'In Pharmacy', 53),
(1001, 'Omar Atef', 'Unkown', 125, 'catafast', 0.4, 40, '2021-05-04 04:49:42', 'In Pharmacy', 54),
(1001, 'Omar Atef', 'Unkown', 952, 'cenacomp', 1, 50, '2021-05-06 19:57:55', 'In Pharmacy', 55),
(1001, 'Omar Atef', 'Unkown', 125, 'catafast', 0.5, 50, '2021-05-06 19:57:55', 'In Pharmacy', 56),
(1001, 'Omar Atef', 'Unkown', 127, 'fine', 2, 480, '2021-05-06 19:57:55', 'In Pharmacy', 57),
(1001, 'Omar Atef', 'Unkown', 125, 'catafast', 2, 40.5, '2021-05-06 22:46:36', 'Delivery', 58),
(1001, 'Omar Atef', 'Unkown', 125, 'catafast', 2, 40.5, '2021-05-06 22:46:36', 'Delivery', 59),
(1001, 'Omar Atef', 'Unkown', 125, 'catafast', 2, 40.5, '2021-05-06 22:46:36', 'Delivery', 60),
(1001, 'Omar Atef', 'Unkown', 125, 'catafast', 1, 20.25, '2021-05-06 22:46:59', 'Delivery', 61),
(1001, 'Omar Atef', 'Unkown', 134, 'Gongestal', 70, 2100, '2021-05-06 23:54:30', 'In Pharmacy', 62),
(1001, 'Omar Atef', 'Unkown', 126, 'setofax', 2, 54, '2021-05-07 00:17:55', 'In Pharmacy', 63),
(1001, 'Omar Atef', 'Unkown', 126, 'setofax', 2, 54, '2021-05-07 00:17:55', 'In Pharmacy', 64),
(1001, 'Omar Atef', 'Unkown', 126, 'setofax', 2, 54, '2021-05-07 00:17:55', 'In Pharmacy', 65),
(1001, 'Omar Atef', 'Unkown', 126, 'setofax', 2, 54, '2021-05-07 00:17:55', 'In Pharmacy', 66),
(1001, 'Omar Atef', 'Unkown', 126, 'setofax', 2, 54, '2021-05-07 00:17:55', 'In Pharmacy', 67),
(1001, 'Omar Atef', 'Unkown', 981, 'Shezax', 0.2, 60, '2021-05-07 00:19:41', 'Delivery', 68),
(1001, 'Omar Atef', 'Unkown', 981, 'Shezax', 0.2, 60, '2021-05-07 00:19:41', 'Delivery', 69),
(1001, 'Omar Atef', '852', 134, 'Gongestal', 0.1, 10, '2021-05-07 01:13:46', 'Delivery', 70),
(1001, 'Omar Atef', '100', 981, 'Shezax', 1, 65, '2021-05-08 00:48:59', 'In Pharmacy', 71),
(1001, 'Omar Atef', '100', 127, 'fine', 0.1, 20, '2021-05-08 00:48:59', 'In Pharmacy', 72),
(1001, 'Omar Atef', 'Unkown', 134, 'Gongestal', 0.2, 20, '2021-05-08 00:49:20', 'Delivery', 73);

-- --------------------------------------------------------

--
-- Table structure for table `supplier`
--

CREATE TABLE `supplier` (
  `SupplierID` int(15) NOT NULL,
  `CompanyName` varchar(100) NOT NULL,
  `Phone1` varchar(11) NOT NULL,
  `Phone2` varchar(11) DEFAULT NULL,
  `Phone3` varchar(11) DEFAULT NULL,
  `Phone4` varchar(11) DEFAULT NULL,
  `Address` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `supplier`
--

INSERT INTO `supplier` (`SupplierID`, `CompanyName`, `Phone1`, `Phone2`, `Phone3`, `Phone4`, `Address`) VALUES
(1006, 'ElSafaa', '01118180845', '', '', '', 'Gizaaa'),
(10054, 'El Esraa', '0123456789', '0123456789', '0123456789', '0123456789', 'faisal');

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `SellerID` int(15) NOT NULL,
  `Password` varchar(50) NOT NULL,
  `Name` varchar(50) NOT NULL,
  `Phone1` varchar(11) NOT NULL,
  `Phone2` varchar(11) NOT NULL,
  `Date` datetime NOT NULL DEFAULT current_timestamp(),
  `department` varchar(20) NOT NULL,
  `statues` varchar(10) NOT NULL DEFAULT 'LogedOut'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`SellerID`, `Password`, `Name`, `Phone1`, `Phone2`, `Date`, `department`, `statues`) VALUES
(1001, 'Omar', 'Omar Atef', '01118180845', '01118180845', '2021-04-29 02:33:51', 'Admin', 'LogedOut'),
(1002, '1002', 'Mohamed Osama', '01118180845', '01118180845', '2021-04-29 03:39:36', 'Staff', 'LogedOut'),
(200202, 'Ahmed', 'Ahmed', '01118180845', '01118180845', '2021-05-08 00:37:25', 'Admin', 'LogedOut'),
(300303, 'Nour', 'Nour', '01118180845', '01118180845', '2021-05-08 00:37:41', 'Staff', 'LogedOut');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `character`
--
ALTER TABLE `character`
  ADD PRIMARY KEY (`Char`);

--
-- Indexes for table `customer`
--
ALTER TABLE `customer`
  ADD PRIMARY KEY (`CustomerID`);

--
-- Indexes for table `importingprocess`
--
ALTER TABLE `importingprocess`
  ADD PRIMARY KEY (`sequence`),
  ADD KEY `ProductID` (`ProductID`),
  ADD KEY `SupplierID` (`SupplierID`),
  ADD KEY `SellerID` (`SellerID`);

--
-- Indexes for table `product`
--
ALTER TABLE `product`
  ADD PRIMARY KEY (`ProductID`),
  ADD KEY `CategoryID` (`Char`);

--
-- Indexes for table `sellingprocess`
--
ALTER TABLE `sellingprocess`
  ADD PRIMARY KEY (`seq`),
  ADD KEY `SellerID` (`SellerID`),
  ADD KEY `CustomerID` (`CustomerID`),
  ADD KEY `ProductID` (`ProductID`);

--
-- Indexes for table `supplier`
--
ALTER TABLE `supplier`
  ADD PRIMARY KEY (`SupplierID`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`SellerID`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `importingprocess`
--
ALTER TABLE `importingprocess`
  MODIFY `sequence` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=30;

--
-- AUTO_INCREMENT for table `sellingprocess`
--
ALTER TABLE `sellingprocess`
  MODIFY `seq` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=74;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `product`
--
ALTER TABLE `product`
  ADD CONSTRAINT `product_ibfk_1` FOREIGN KEY (`Char`) REFERENCES `character` (`Char`) ON DELETE NO ACTION;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
