# ************************************************************
# Sequel Pro SQL dump
# Version 4500
#
# http://www.sequelpro.com/
# https://github.com/sequelpro/sequelpro
#
# Host: 127.0.0.1 (MySQL 5.7.17)
# Database: car_service
# Generation Time: 2021-01-20 21:06:47 +0000
# ************************************************************


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


# Dump of table appointments
# ------------------------------------------------------------

DROP TABLE IF EXISTS `appointments`;

CREATE TABLE `appointments` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `date` date NOT NULL,
  `price` decimal(19,2) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `car_id` bigint(20) DEFAULT NULL,
  `repair_shop_id` bigint(20) DEFAULT NULL,
  `user_id` bigint(20) DEFAULT NULL,
  `time` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKr9crwg4o6snwxbdfvag80fo4p` (`car_id`),
  KEY `FK6od6urt57h1t6tpo1jklpekyl` (`repair_shop_id`),
  KEY `FK886ced1atxgvnf1o3oxtj5m4s` (`user_id`),
  CONSTRAINT `FK6od6urt57h1t6tpo1jklpekyl` FOREIGN KEY (`repair_shop_id`) REFERENCES `repair_shops` (`id`),
  CONSTRAINT `FK886ced1atxgvnf1o3oxtj5m4s` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`),
  CONSTRAINT `FKr9crwg4o6snwxbdfvag80fo4p` FOREIGN KEY (`car_id`) REFERENCES `cars` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

LOCK TABLES `appointments` WRITE;
/*!40000 ALTER TABLE `appointments` DISABLE KEYS */;

INSERT INTO `appointments` (`id`, `date`, `price`, `status`, `car_id`, `repair_shop_id`, `user_id`, `time`)
VALUES
	(1,'2021-01-10',NULL,1,9,1,1,'11:30'),
	(2,'2020-10-16',260.00,3,9,1,1,'10:30'),
	(3,'2020-09-06',300.00,3,9,1,1,'10:30'),
	(4,'2020-12-16',40.00,3,9,1,1,'10:30'),
	(5,'2021-02-05',NULL,5,9,1,1,'10:46'),
	(6,'2023-03-12',250.00,4,9,1,1,'12:10'),
	(7,'2021-03-12',NULL,0,10,1,1,'16:20');

/*!40000 ALTER TABLE `appointments` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table appointments_services
# ------------------------------------------------------------

DROP TABLE IF EXISTS `appointments_services`;

CREATE TABLE `appointments_services` (
  `appointment_id` bigint(20) NOT NULL,
  `services_id` bigint(20) NOT NULL,
  PRIMARY KEY (`appointment_id`,`services_id`),
  KEY `FKnb28cy7afn2nb8f7xthtmhk9b` (`services_id`),
  CONSTRAINT `FKhiyjn8k13le6pwqayx3051koe` FOREIGN KEY (`appointment_id`) REFERENCES `appointments` (`id`),
  CONSTRAINT `FKnb28cy7afn2nb8f7xthtmhk9b` FOREIGN KEY (`services_id`) REFERENCES `car_services` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

LOCK TABLES `appointments_services` WRITE;
/*!40000 ALTER TABLE `appointments_services` DISABLE KEYS */;

INSERT INTO `appointments_services` (`appointment_id`, `services_id`)
VALUES
	(1,1),
	(2,1),
	(3,1),
	(6,1),
	(7,1),
	(1,2),
	(4,2),
	(5,2),
	(7,2),
	(1,3),
	(6,3),
	(2,4),
	(5,4),
	(3,5),
	(5,5),
	(7,5),
	(1,6),
	(6,6),
	(6,7),
	(7,7),
	(1,8),
	(6,8);

/*!40000 ALTER TABLE `appointments_services` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table car_manufacturers
# ------------------------------------------------------------

DROP TABLE IF EXISTS `car_manufacturers`;

CREATE TABLE `car_manufacturers` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

LOCK TABLES `car_manufacturers` WRITE;
/*!40000 ALTER TABLE `car_manufacturers` DISABLE KEYS */;

INSERT INTO `car_manufacturers` (`id`, `name`)
VALUES
	(1,'AC'),
	(2,'Abarth'),
	(3,'Acura'),
	(4,'Aixam'),
	(5,'Alfa Romeo'),
	(6,'Alpina'),
	(7,'Aro'),
	(8,'Asia'),
	(9,'Aston martin'),
	(10,'Audi'),
	(11,'Austin'),
	(12,'BMW'),
	(13,'Bentley'),
	(14,'Berliner'),
	(15,'Bertone'),
	(16,'Borgward'),
	(17,'Brilliance'),
	(18,'Bugatti'),
	(19,'Buick'),
	(20,'Cadillac'),
	(21,'Chevrolet'),
	(22,'Chrysler'),
	(23,'Citroen'),
	(24,'Corvette'),
	(25,'Cupra'),
	(26,'DS'),
	(27,'Dacia'),
	(28,'Daewoo'),
	(29,'Daihatsu'),
	(30,'Daimler'),
	(31,'Datsun'),
	(32,'Dkw'),
	(33,'Dodge'),
	(34,'Dr'),
	(35,'Eagle'),
	(36,'FSO'),
	(37,'Ferrari'),
	(38,'Fiat'),
	(39,'Ford'),
	(40,'GOUPIL'),
	(41,'Gaz'),
	(42,'Geo'),
	(43,'Gmc'),
	(44,'Great Wall'),
	(45,'Haval'),
	(46,'Heinkel'),
	(47,'Hillman'),
	(48,'Honda'),
	(49,'Hummer'),
	(50,'Hyundai'),
	(51,'Ifa'),
	(52,'Infiniti'),
	(53,'Innocenti'),
	(54,'Isuzu'),
	(55,'Iveco'),
	(56,'JAS'),
	(57,'Jaguar'),
	(58,'Jeep'),
	(59,'Jpx'),
	(60,'Kia'),
	(61,'Lada'),
	(62,'Laforza'),
	(63,'Lamborghini'),
	(64,'Lancia'),
	(65,'Land Rover'),
	(66,'Landwind'),
	(67,'Lexus'),
	(68,'Lifan'),
	(69,'Lincoln'),
	(70,'Lotus'),
	(71,'MG'),
	(72,'Mahindra'),
	(73,'Maserati'),
	(74,'Matra'),
	(75,'Maybach'),
	(76,'Mazda'),
	(77,'McLaren'),
	(78,'Mercedes-Benz'),
	(79,'Mercury'),
	(80,'Mg'),
	(81,'Microcar'),
	(82,'Mini'),
	(83,'Mitsubishi'),
	(84,'Morgan'),
	(85,'Moskvich'),
	(86,'Nissan'),
	(87,'Oldsmobile'),
	(88,'Opel'),
	(89,'Perodua'),
	(90,'Peugeot'),
	(91,'Pgo'),
	(92,'Plymouth'),
	(93,'Polonez'),
	(94,'Pontiac'),
	(95,'Porsche'),
	(96,'Proton'),
	(97,'Renault'),
	(98,'Rolls-Royce'),
	(99,'Rover'),
	(100,'SECMA'),
	(101,'SH auto'),
	(102,'Saab'),
	(103,'Samand'),
	(104,'Santana'),
	(105,'Saturn'),
	(106,'Scion'),
	(107,'Seat'),
	(108,'Shatenet'),
	(109,'Shuanghuan'),
	(110,'Simca'),
	(111,'Skoda'),
	(112,'Smart'),
	(113,'Ssang yong'),
	(114,'SsangYong'),
	(115,'Subaru'),
	(116,'Suzuki'),
	(117,'Talbot'),
	(118,'Tata'),
	(119,'Tavria'),
	(120,'Tazzari'),
	(121,'Tempo'),
	(122,'Terberg'),
	(123,'Tesla'),
	(124,'Tofas'),
	(125,'Toyota'),
	(126,'Trabant'),
	(127,'Triumph'),
	(128,'Uaz'),
	(129,'VROMOS'),
	(130,'VW'),
	(131,'Volga'),
	(132,'Volvo'),
	(133,'Warszawa'),
	(134,'Wartburg'),
	(135,'Wiesmann'),
	(136,'Xinkai'),
	(137,'Xinshun'),
	(138,'Zastava'),
	(139,'Zaz'),
	(140,'Други'),
	(141,'Победа'),
	(142,'София'),
	(143,'Чайка');

/*!40000 ALTER TABLE `car_manufacturers` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table car_services
# ------------------------------------------------------------

DROP TABLE IF EXISTS `car_services`;

CREATE TABLE `car_services` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

LOCK TABLES `car_services` WRITE;
/*!40000 ALTER TABLE `car_services` DISABLE KEYS */;

INSERT INTO `car_services` (`id`, `name`)
VALUES
	(1,'Undercarriage'),
	(2,'Engines'),
	(3,'Transmissions'),
	(4,'Break systems'),
	(5,'Tires and Rims'),
	(6,'Oils and Filters'),
	(7,'Car Wash'),
	(8,'Wheel alignment');

/*!40000 ALTER TABLE `car_services` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table cars
# ------------------------------------------------------------

DROP TABLE IF EXISTS `cars`;

CREATE TABLE `cars` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `model` varchar(255) DEFAULT NULL,
  `registration` varchar(255) DEFAULT NULL,
  `year` int(11) NOT NULL,
  `car_manufacturer_id` bigint(20) DEFAULT NULL,
  `user_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK1jio9styhd3lo038namk4bqd1` (`car_manufacturer_id`),
  KEY `FKqw4c8e6nqrvy3ti1xj8w8wyc9` (`user_id`),
  CONSTRAINT `FK1jio9styhd3lo038namk4bqd1` FOREIGN KEY (`car_manufacturer_id`) REFERENCES `car_manufacturers` (`id`),
  CONSTRAINT `FKqw4c8e6nqrvy3ti1xj8w8wyc9` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

LOCK TABLES `cars` WRITE;
/*!40000 ALTER TABLE `cars` DISABLE KEYS */;

INSERT INTO `cars` (`id`, `model`, `registration`, `year`, `car_manufacturer_id`, `user_id`)
VALUES
	(1,'A3','СВ5029АМ',1998,10,NULL),
	(2,'Audi','СВ5029АМ',1998,8,NULL),
	(4,'Passat','СВ5029АМ',2006,130,NULL),
	(5,'Calibra','СВ5029АМ',2010,88,NULL),
	(9,'A3','СВ5029АМ',1998,10,1),
	(10,'Passat','СВ6985КС',2010,130,1),
	(12,'Passat','СВ5029АМ',1234,10,1),
	(13,'passat b6','СВ5029АМ',1234,5,1);

/*!40000 ALTER TABLE `cars` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table cars_appointments
# ------------------------------------------------------------

DROP TABLE IF EXISTS `cars_appointments`;

CREATE TABLE `cars_appointments` (
  `car_id` bigint(20) NOT NULL,
  `appointments_id` bigint(20) NOT NULL,
  UNIQUE KEY `UK_i7l9w8h26458ujpmp4yb1dpfu` (`appointments_id`),
  KEY `FK4ajkk00wj1npwuly76gxhcfy9` (`car_id`),
  CONSTRAINT `FK352uip0rtdoc50grty9qv2o4s` FOREIGN KEY (`appointments_id`) REFERENCES `appointments` (`id`),
  CONSTRAINT `FK4ajkk00wj1npwuly76gxhcfy9` FOREIGN KEY (`car_id`) REFERENCES `cars` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



# Dump of table repair_shops
# ------------------------------------------------------------

DROP TABLE IF EXISTS `repair_shops`;

CREATE TABLE `repair_shops` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

LOCK TABLES `repair_shops` WRITE;
/*!40000 ALTER TABLE `repair_shops` DISABLE KEYS */;

INSERT INTO `repair_shops` (`id`, `name`)
VALUES
	(1,'Omega Service');

/*!40000 ALTER TABLE `repair_shops` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table repair_shops_employees
# ------------------------------------------------------------

DROP TABLE IF EXISTS `repair_shops_employees`;

CREATE TABLE `repair_shops_employees` (
  `repair_shop_id` bigint(20) NOT NULL,
  `employees_id` bigint(20) NOT NULL,
  PRIMARY KEY (`repair_shop_id`,`employees_id`),
  UNIQUE KEY `UK_canhluu5sxq7wcbqas16b0q2b` (`employees_id`),
  CONSTRAINT `FKdr9xj31ecubyfx2bwwmwjv64f` FOREIGN KEY (`repair_shop_id`) REFERENCES `repair_shops` (`id`),
  CONSTRAINT `FKkena2uvsoi1d8j9a1fjpjw4le` FOREIGN KEY (`employees_id`) REFERENCES `users` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



# Dump of table repair_shops_manufacturers
# ------------------------------------------------------------

DROP TABLE IF EXISTS `repair_shops_manufacturers`;

CREATE TABLE `repair_shops_manufacturers` (
  `repair_shop_id` bigint(20) NOT NULL,
  `car_manufacturer_id` bigint(20) NOT NULL,
  PRIMARY KEY (`repair_shop_id`,`car_manufacturer_id`),
  KEY `FKdpm8j6l6jjhnwgk4kqso9vbvx` (`car_manufacturer_id`),
  CONSTRAINT `FK5t18gfe0k5j5pe6nk0sbr5o24` FOREIGN KEY (`repair_shop_id`) REFERENCES `repair_shops` (`id`),
  CONSTRAINT `FKdpm8j6l6jjhnwgk4kqso9vbvx` FOREIGN KEY (`car_manufacturer_id`) REFERENCES `car_manufacturers` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



# Dump of table roles
# ------------------------------------------------------------

DROP TABLE IF EXISTS `roles`;

CREATE TABLE `roles` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `authority` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

LOCK TABLES `roles` WRITE;
/*!40000 ALTER TABLE `roles` DISABLE KEYS */;

INSERT INTO `roles` (`id`, `authority`)
VALUES
	(1,'SYSTEM_ADMIN'),
	(2,'CAR_SHOP_EMPLOYEE'),
	(3,'CAR_SHOP_ADMIN'),
	(4,'CLIENT');

/*!40000 ALTER TABLE `roles` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table users
# ------------------------------------------------------------

DROP TABLE IF EXISTS `users`;

CREATE TABLE `users` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `full_name` varchar(255) DEFAULT NULL,
  `is_account_non_expired` bit(1) DEFAULT NULL,
  `is_account_non_locked` bit(1) DEFAULT NULL,
  `is_credentials_non_expired` bit(1) DEFAULT NULL,
  `is_enabled` bit(1) DEFAULT NULL,
  `password` varchar(255) NOT NULL,
  `username` varchar(255) NOT NULL,
  `repair_shop_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_r43af9ap4edm43mmtq01oddj6` (`username`),
  KEY `FKdlahqdctt1p1nok2rpvnvrodg` (`repair_shop_id`),
  CONSTRAINT `FKdlahqdctt1p1nok2rpvnvrodg` FOREIGN KEY (`repair_shop_id`) REFERENCES `repair_shops` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;

INSERT INTO `users` (`id`, `full_name`, `is_account_non_expired`, `is_account_non_locked`, `is_credentials_non_expired`, `is_enabled`, `password`, `username`, `repair_shop_id`)
VALUES
	(1,'Yavor Mihaylov',00000000,10000000,10000000,10000000,'$2a$10$TIrR/7iVHcJgKz0mBLVBmeAOl.Ij0BXV7gZEQgkKCW6kqqAZsaeda','client',NULL),
	(2,NULL,00000000,10000000,10000000,10000000,'$2a$10$nm1zUW5UNb75Nxj.zIT7heHEKwvf2KhAOOSoyRU0/gcosEDTEdsLC','employee',1),
	(3,NULL,10000000,10000000,10000000,10000000,'$2a$10$ioeUnCKRn5MJjk8ml0wZpezxUwby8eZj0khfqMLOagYH4ngAyQS4C','admin',NULL),
	(4,NULL,00000000,10000000,10000000,10000000,'$2a$10$lfXcCzc6MJrHpgrY1Bx8X.XMM9Gg6PFdr3viwXXzjWOQ0uJnmEwgC','shop_admin',NULL);

/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table users_authorities
# ------------------------------------------------------------

DROP TABLE IF EXISTS `users_authorities`;

CREATE TABLE `users_authorities` (
  `users_id` bigint(20) NOT NULL,
  `authorities_id` bigint(20) NOT NULL,
  PRIMARY KEY (`users_id`,`authorities_id`),
  KEY `FK40fukc61kvbvpc2rhv01q1g2l` (`authorities_id`),
  CONSTRAINT `FK2cmfwo8tbjcpmltse0rh5ir0t` FOREIGN KEY (`users_id`) REFERENCES `users` (`id`),
  CONSTRAINT `FK40fukc61kvbvpc2rhv01q1g2l` FOREIGN KEY (`authorities_id`) REFERENCES `roles` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

LOCK TABLES `users_authorities` WRITE;
/*!40000 ALTER TABLE `users_authorities` DISABLE KEYS */;

INSERT INTO `users_authorities` (`users_id`, `authorities_id`)
VALUES
	(3,1),
	(2,2),
	(4,3),
	(1,4);

/*!40000 ALTER TABLE `users_authorities` ENABLE KEYS */;
UNLOCK TABLES;



/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
