-- phpMyAdmin SQL Dump
-- version 5.0.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jan 31, 2022 at 03:56 PM
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
-- Database: `hospital`
--

-- --------------------------------------------------------

--
-- Table structure for table `admin`
--

CREATE TABLE `admin` (
  `id` int(4) NOT NULL,
  `name` varchar(50) NOT NULL,
  `username` varchar(50) NOT NULL,
  `password` varchar(500) NOT NULL,
  `phone` int(10) NOT NULL,
  `email` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `admin`
--

INSERT INTO `admin` (`id`, `name`, `username`, `password`, `phone`, `email`) VALUES
(5, 'Manoj Madushanka', 'manoj', '$2a$10$9.3J7pl3uvydbSGeYa7.FeSsOJ3lv2wi2s0Al.Y/NYwlLOM2xMHFK', 715147270, 'madushankamanoj414@gmail.com');

-- --------------------------------------------------------

--
-- Table structure for table `admin_roles`
--

CREATE TABLE `admin_roles` (
  `user_id` int(11) NOT NULL,
  `role_id` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `admin_roles`
--

INSERT INTO `admin_roles` (`user_id`, `role_id`) VALUES
(5, 1);

-- --------------------------------------------------------

--
-- Table structure for table `diagnosisdata`
--

CREATE TABLE `diagnosisdata` (
  `symptoms` varchar(500) NOT NULL,
  `diagnosis_id` int(3) NOT NULL,
  `administered_by` varchar(255) DEFAULT NULL,
  `bill_amount` double DEFAULT NULL,
  `card_number` int(11) DEFAULT NULL,
  `date_of_diagnosis` date DEFAULT NULL,
  `date_of_follow_up` date DEFAULT NULL,
  `diagnosis_provided` varchar(255) DEFAULT NULL,
  `follow_up_required` bit(1) DEFAULT NULL,
  `mode_of_payment` varchar(255) DEFAULT NULL,
  `patient_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `diagnosisdata`
--

INSERT INTO `diagnosisdata` (`symptoms`, `diagnosis_id`, `administered_by`, `bill_amount`, `card_number`, `date_of_diagnosis`, `date_of_follow_up`, `diagnosis_provided`, `follow_up_required`, `mode_of_payment`, `patient_id`) VALUES
('test', 1, 'PR007', 100, 123456, '2022-01-31', '2022-01-31', 'test', b'0', 'cash', 1),
('test1', 2, 'PR007', 100, 123456, NULL, '2022-01-31', 'test1', b'1', 'card', 1),
('fever', 3, 'PR008', 100, 123456, '2022-01-31', '2022-01-31', 'covid', b'1', 'card', 4),
('fever', 4, 'PR008', 100, 123456, '2022-01-31', '2022-01-31', 'covid delta', b'1', 'card', 4);

-- --------------------------------------------------------

--
-- Table structure for table `patient`
--

CREATE TABLE `patient` (
  `id` int(4) NOT NULL,
  `password` varchar(200) DEFAULT NULL,
  `email` varchar(200) DEFAULT NULL,
  `contact` int(10) DEFAULT NULL,
  `state` varchar(100) DEFAULT NULL,
  `date_of_birth` date DEFAULT NULL,
  `first_name` varchar(255) DEFAULT NULL,
  `insurance_plan` varchar(255) DEFAULT NULL,
  `last_name` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `patient`
--

INSERT INTO `patient` (`id`, `password`, `email`, `contact`, `state`, `date_of_birth`, `first_name`, `insurance_plan`, `last_name`) VALUES
(1, '123', 'madushankamanoj414@gmail.com', 715147270, 'test', NULL, NULL, NULL, NULL),
(2, '123', 'madushankamanoj414@gmail.com', 715147270, 'Select One', NULL, NULL, NULL, NULL),
(3, '123', 'abd@123.com', 715147270, 'dfg', '1995-04-21', 'kusal', 'dertt', 'kalhara'),
(4, '123', 'madushankamanoj414@gmail.com', 715147270, 'Select', '1995-03-23', 'patient1', 'test', 'patient1');

-- --------------------------------------------------------

--
-- Table structure for table `physician`
--

CREATE TABLE `physician` (
  `id` varchar(5) NOT NULL DEFAULT '0',
  `department` varchar(60) NOT NULL,
  `state` varchar(100) NOT NULL,
  `education_qualification` varchar(255) DEFAULT NULL,
  `first_name` varchar(255) DEFAULT NULL,
  `insurance_plan` varchar(255) DEFAULT NULL,
  `last_name` varchar(255) DEFAULT NULL,
  `years_of_experience` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `physician`
--

INSERT INTO `physician` (`id`, `department`, `state`, `education_qualification`, `first_name`, `insurance_plan`, `last_name`, `years_of_experience`) VALUES
('PR001', 'test', 'Select One', 'test', 'Manoj1', '3fdgf', 'Madushanka', 13),
('PR005', 'test', 'Select One', 'test', 'Manoj', 'test', 'Madushanka', 12),
('PR006', 'test', 'Select One', 'test', 'Manoj', 'test', 'Madushanka', 12),
('PR007', 'test', 'Select One', 'test', 'Manoj234', 'dertt', 'Madushanka', 12),
('PR008', 'testDep', 'south', 'MBA SL', 'physician1', 'test', 'physician1', 4);

--
-- Triggers `physician`
--
DELIMITER $$
CREATE TRIGGER `increment_physician_id` BEFORE INSERT ON `physician` FOR EACH ROW BEGIN
  INSERT INTO physician_seq VALUES (NULL);
  SET NEW.id = CONCAT('PR', LPAD(LAST_INSERT_ID(), 3, '0'));
END
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Table structure for table `physician_seq`
--

CREATE TABLE `physician_seq` (
  `id` int(3) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `physician_seq`
--

INSERT INTO `physician_seq` (`id`) VALUES
(1),
(5),
(6),
(7),
(8);

-- --------------------------------------------------------

--
-- Table structure for table `role`
--

CREATE TABLE `role` (
  `id` bigint(20) NOT NULL,
  `name` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `role`
--

INSERT INTO `role` (`id`, `name`) VALUES
(1, 'ROLE_USER');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `admin`
--
ALTER TABLE `admin`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `admin_roles`
--
ALTER TABLE `admin_roles`
  ADD KEY `FKcjlqrvoka3pq87dm3nhyx6h5c` (`role_id`),
  ADD KEY `FK6lsos98isnpkvp318ral0msln` (`user_id`);

--
-- Indexes for table `diagnosisdata`
--
ALTER TABLE `diagnosisdata`
  ADD PRIMARY KEY (`diagnosis_id`),
  ADD KEY `patient_id` (`patient_id`),
  ADD KEY `administered_by` (`administered_by`);

--
-- Indexes for table `patient`
--
ALTER TABLE `patient`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `physician`
--
ALTER TABLE `physician`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `physician_seq`
--
ALTER TABLE `physician_seq`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `role`
--
ALTER TABLE `role`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `admin`
--
ALTER TABLE `admin`
  MODIFY `id` int(4) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `diagnosisdata`
--
ALTER TABLE `diagnosisdata`
  MODIFY `diagnosis_id` int(3) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `patient`
--
ALTER TABLE `patient`
  MODIFY `id` int(4) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `physician_seq`
--
ALTER TABLE `physician_seq`
  MODIFY `id` int(3) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT for table `role`
--
ALTER TABLE `role`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `admin_roles`
--
ALTER TABLE `admin_roles`
  ADD CONSTRAINT `FK6lsos98isnpkvp318ral0msln` FOREIGN KEY (`user_id`) REFERENCES `admin` (`id`),
  ADD CONSTRAINT `FKcjlqrvoka3pq87dm3nhyx6h5c` FOREIGN KEY (`role_id`) REFERENCES `role` (`id`);

--
-- Constraints for table `diagnosisdata`
--
ALTER TABLE `diagnosisdata`
  ADD CONSTRAINT `diagnosisdata_ibfk_1` FOREIGN KEY (`patient_id`) REFERENCES `patient` (`id`),
  ADD CONSTRAINT `diagnosisdata_ibfk_2` FOREIGN KEY (`administered_by`) REFERENCES `physician` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
