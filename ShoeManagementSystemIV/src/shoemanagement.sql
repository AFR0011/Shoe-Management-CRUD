-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 24, 2024 at 08:37 PM
-- Server version: 10.4.28-MariaDB
-- PHP Version: 8.2.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `shoemanagement`
--

-- --------------------------------------------------------

--
-- Table structure for table `customers`
--

CREATE TABLE `customers` (
  `cus_id` int(11) NOT NULL,
  `cus_name` varchar(255) NOT NULL,
  `cus_email` varchar(255) DEFAULT NULL,
  `cus_phone` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `customers`
--

INSERT INTO `customers` (`cus_id`, `cus_name`, `cus_email`, `cus_phone`) VALUES
(1, 'John Doe', 'john@example.com', '123-456-7890'),
(2, 'Jane Smith', 'jane@example.com', '987-654-3210'),
(3, 'Michael Brown', 'michael@example.com', '111-222-3333'),
(4, 'Emily Johnson', 'emily@example.com', '444-555-6666'),
(5, 'David Lee', 'david@example.com', '777-888-9999');

-- --------------------------------------------------------

--
-- Table structure for table `inventory`
--

CREATE TABLE `inventory` (
  `inv_id` int(11) NOT NULL,
  `shoe_id` int(11) DEFAULT NULL,
  `inv_quantity` int(11) DEFAULT NULL,
  `inv_location` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `inventory`
--

INSERT INTO `inventory` (`inv_id`, `shoe_id`, `inv_quantity`, `inv_location`) VALUES
(1, 1, 10, 'Main Store'),
(2, 2, 15, 'Warehouse'),
(3, 3, 20, 'Branch A'),
(4, 4, 8, 'Branch B'),
(5, 5, 25, 'Online Stock');

-- --------------------------------------------------------

--
-- Table structure for table `shoes`
--

CREATE TABLE `shoes` (
  `shoe_id` int(11) NOT NULL,
  `sup_id` int(11) DEFAULT NULL,
  `shoe_brand` varchar(255) DEFAULT NULL,
  `shoe_model` varchar(255) DEFAULT NULL,
  `shoe_size` int(11) DEFAULT NULL,
  `shoe_color` varchar(255) DEFAULT NULL,
  `shoe_price` float DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `shoes`
--

INSERT INTO `shoes` (`shoe_id`, `sup_id`, `shoe_brand`, `shoe_model`, `shoe_size`, `shoe_color`, `shoe_price`) VALUES
(1, 1, 'Nike', 'Air Max', 9, 'Black', 150),
(2, 2, 'Adidas', 'Superstar', 8, 'White', 120),
(3, 3, 'Puma', 'Suede', 7, 'Red', 100),
(4, 4, 'Reebok', 'Classic', 10, 'Blue', 130),
(5, 5, 'Vans', 'Old Skool', 9, 'Checkerboard', 80);

-- --------------------------------------------------------

--
-- Table structure for table `suppliers`
--

CREATE TABLE `suppliers` (
  `sup_id` int(11) NOT NULL,
  `sup_name` varchar(255) NOT NULL,
  `sup_contactPerson` varchar(255) DEFAULT NULL,
  `sup_email` varchar(255) DEFAULT NULL,
  `sup_phone` varchar(20) DEFAULT NULL,
  `sup_address` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `suppliers`
--

INSERT INTO `suppliers` (`sup_id`, `sup_name`, `sup_contactPerson`, `sup_email`, `sup_phone`, `sup_address`) VALUES
(1, 'ABC Shoes', 'John Smith', 'john@abcshoes.com', '123-456-7890', '123 Shoe Street, Cityville'),
(2, 'XYZ Footwear', 'Jane Doe', 'jane@xyzfootwear.com', '987-654-3210', '456 Footwear Avenue, Townsville'),
(3, 'Shoe Empire', 'Mike Johnson', 'mike@shoeempire.com', '111-222-3333', '789 Sneaker Road, Villageland'),
(4, 'Footprints Inc.', 'Emily Brown', 'emily@footprintsinc.com', '444-555-6666', '101 Boot Boulevard, Shoetown'),
(5, 'Sole Suppliers', 'David Lee', 'david@solesuppliers.com', '777-888-9999', '202 Sandal Street, Flipflop City');

-- --------------------------------------------------------

--
-- Table structure for table `transactions`
--

CREATE TABLE `transactions` (
  `trn_id` int(11) NOT NULL,
  `cus_id` int(11) DEFAULT NULL,
  `shoe_id` int(11) DEFAULT NULL,
  `trn_amount` int(11) DEFAULT NULL,
  `trn_totalPrice` float DEFAULT NULL,
  `trn_date` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `transactions`
--

INSERT INTO `transactions` (`trn_id`, `cus_id`, `shoe_id`, `trn_amount`, `trn_totalPrice`, `trn_date`) VALUES
(1, 1, 1, 2, 300, '2002-03-28'),
(3, 3, 2, 1, 120, '2002-05-17'),
(4, 4, 5, 3, 240, '2001-11-22'),
(5, 5, 4, 2, 260, '2002-02-19');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `customers`
--
ALTER TABLE `customers`
  ADD PRIMARY KEY (`cus_id`);

--
-- Indexes for table `inventory`
--
ALTER TABLE `inventory`
  ADD PRIMARY KEY (`inv_id`),
  ADD KEY `shoe_id` (`shoe_id`);

--
-- Indexes for table `shoes`
--
ALTER TABLE `shoes`
  ADD PRIMARY KEY (`shoe_id`),
  ADD KEY `sup_id` (`sup_id`);

--
-- Indexes for table `suppliers`
--
ALTER TABLE `suppliers`
  ADD PRIMARY KEY (`sup_id`);

--
-- Indexes for table `transactions`
--
ALTER TABLE `transactions`
  ADD PRIMARY KEY (`trn_id`),
  ADD KEY `cus_id` (`cus_id`),
  ADD KEY `shoe_id` (`shoe_id`);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `inventory`
--
ALTER TABLE `inventory`
  ADD CONSTRAINT `inventory_ibfk_1` FOREIGN KEY (`shoe_id`) REFERENCES `shoes` (`shoe_id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `shoes`
--
ALTER TABLE `shoes`
  ADD CONSTRAINT `shoes_ibfk_1` FOREIGN KEY (`sup_id`) REFERENCES `suppliers` (`sup_id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `transactions`
--
ALTER TABLE `transactions`
  ADD CONSTRAINT `transactions_ibfk_1` FOREIGN KEY (`cus_id`) REFERENCES `customers` (`cus_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `transactions_ibfk_2` FOREIGN KEY (`shoe_id`) REFERENCES `shoes` (`shoe_id`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
