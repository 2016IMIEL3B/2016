-- phpMyAdmin SQL Dump
-- version 4.6.0
-- http://www.phpmyadmin.net
--
-- Client :  localhost
-- Généré le :  Mar 19 Avril 2016 à 11:08
-- Version du serveur :  5.5.47-0ubuntu0.14.04.1
-- Version de PHP :  5.5.9-1ubuntu4.14

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `JAVA_G4_AF`
--
DROP DATABASE IF EXISTS `JAVA_G4_AF`;
CREATE DATABASE IF NOT EXISTS `JAVA_G4_AF` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;
USE `JAVA_G4_AF`;

-- --------------------------------------------------------

--
-- Structure de la table `Quote`
--

DROP TABLE IF EXISTS `Quote`;
CREATE TABLE IF NOT EXISTS `Quote` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(250) CHARACTER SET utf8 DEFAULT NULL,
  `resume` varchar(250) CHARACTER SET utf8 DEFAULT NULL,
  `price` float DEFAULT NULL,
  `step` int(11) DEFAULT NULL,
  `login` varchar(250) CHARACTER SET utf8 DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=latin1;

--
-- Vider la table avant d'insérer `Quote`
--

TRUNCATE TABLE `Quote`;
--
-- Contenu de la table `Quote`
--

INSERT INTO `Quote` (`id`, `name`, `resume`, `price`, `step`, `login`) VALUES
(1, 'Devis habitation Jean', 'Je suis un résumé du devis de voiture de Jean.', 55, 2, 'Jean@mail.fr'),
(2, 'Devis voiture Paul', 'Je suis un résumé du devis de voiture de Paul.', 100, 1, 'Paul@mail.fr'),
(3, 'Devis voiture Claire', 'Je suis un résumé du devis de voiture de Claire.', 515, 0, 'Claire@mail.fr'),
(4, 'Devis habitation Gertrude', 'Je suis un résumé du devis de voiture de Gertrude.', 60, 4, 'Gertrude@mail.fr'),
(5, 'Devis habitation Michel', 'Je suis un résumé du devis de voiture de Michel.', 14, 3, 'Michel@mail.fr'),
(6, 'Devis voiture Louane', 'Je suis un résumé du devis de voiture de Louane.', 23, 2, 'Louane@mail.fr'),
(7, 'Devis habitation Kendji', 'Je suis un résumé du devis de voiture de Kendji.', 21, 3, 'Kendji@mail.fr'),
(8, 'Devis voiture Richard', 'Je suis un résumé du devis de voiture de Richard.', 60, 2, 'Richard@mail.fr'),
(9, 'Devis voiture Arnold', 'Je suis un résumé du devis de voiture de Arnold.', 49, 1, 'Arnold@mail.fr'),
(10, 'Devis habitation Willy', 'Je suis un résumé du devis de voiture de Willy.', 21, 0, 'Willy@mail.fr'),
(11, 'Devis voiture Louis', 'Je suis un résumé du devis de voiture de Louis.', 28, 0, 'Louis@mail.fr'),
(12, 'Devis habitation Carmen', 'Je suis un résumé du devis de voiture de Carmen.', 99, 4, 'Carmen@mail.fr'),
(13, 'Devis habitation Louisa', 'Je suis un résumé du devis de voiture de Louisa.', 64, 4, 'Louisa@mail.fr'),
(14, 'Devis voiture Léa', 'Je suis un résumé du devis de voiture de Léa.', 1544, 2, 'Léa@mail.fr'),
(15, 'Devis voiture Myriam', 'Je suis un résumé du devis de voiture de Myriam.', 78, 1, 'Myriam@mail.fr');

-- --------------------------------------------------------

--
-- Structure de la table `QuoteCar`
--

DROP TABLE IF EXISTS `QuoteCar`;
CREATE TABLE IF NOT EXISTS `QuoteCar` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `brand` int(11) DEFAULT NULL,
  `model` int(11) DEFAULT NULL,
  `fuel` int(11) DEFAULT NULL,
  `taxHorsepower` int(11) DEFAULT NULL,
  `dateLicence` date DEFAULT NULL,
  `numberAccident` int(11) DEFAULT NULL,
  `bonusMalus` float DEFAULT NULL,
  `garage` tinyint(1) DEFAULT NULL,
  `driver` varchar(250) CHARACTER SET utf8 DEFAULT NULL,
  `secondaryDriver` varchar(250) CHARACTER SET utf8 DEFAULT NULL,
  `address` varchar(250) CHARACTER SET utf8 DEFAULT NULL,
  `allRisk` tinyint(1) DEFAULT NULL,
  `tiers` tinyint(1) DEFAULT NULL,
  `idQuote` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_QuoteCar_id` (`idQuote`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=latin1;

--
-- Vider la table avant d'insérer `QuoteCar`
--

TRUNCATE TABLE `QuoteCar`;
--
-- Contenu de la table `QuoteCar`
--

INSERT INTO `QuoteCar` (`id`, `brand`, `model`, `fuel`, `taxHorsepower`, `dateLicence`, `numberAccident`, `bonusMalus`, `garage`, `driver`, `secondaryDriver`, `address`, `allRisk`, `tiers`, `idQuote`) VALUES
(1, 5, 11, 25, 20, '2012-10-14', 8, 0.5, 0, 'Paul Henry', NULL, NULL, 1, 0, 2),
(2, 6, 12, 26, 60, '2020-11-04', 5, 0, 1, 'Claire Chazal', 'Gerard Henry', 'Rue des mouffettes', 0, 1, 3),
(3, 7, 13, 27, 555, '1918-06-11', 2, 1.9, 0, 'Louane Avenir', NULL, NULL, 1, 0, 6),
(4, 8, 14, 28, 45, '2004-10-14', 1, 1.1, 1, 'Richard Gotener', 'Marie Drucker', 'Rue des papillons bleue', 1, 0, 8),
(5, 9, 15, 25, 2, '2016-02-16', 0, 0, 0, 'Arnold Schwarzeneger', NULL, NULL, 0, 1, 9),
(6, 5, 16, 26, 600, '2008-09-02', 0, 1, 1, 'Louis LaBrocante', 'Marcel Letroc', 'Rue des abeilles', 1, 0, 11),
(7, 6, 17, 27, 84, '2001-01-14', 3, 5, 0, 'Léa Drucker', 'Papa Drucker', NULL, 1, 0, 14),
(8, 7, 18, 28, 13, '1950-10-19', 6, 2, 1, 'Myriam Ladame', NULL, 'Rue des mouettes qui font caca', 0, 1, 15);

-- --------------------------------------------------------

--
-- Structure de la table `QuoteHome`
--

DROP TABLE IF EXISTS `QuoteHome`;
CREATE TABLE IF NOT EXISTS `QuoteHome` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `typeHome` varchar(250) CHARACTER SET utf8 DEFAULT NULL,
  `address` varchar(250) CHARACTER SET utf8 DEFAULT NULL,
  `area` int(11) DEFAULT NULL,
  `numberRoom` int(11) DEFAULT NULL,
  `floor` int(11) DEFAULT NULL,
  `numberBathroom` int(11) DEFAULT NULL,
  `garage` tinyint(1) DEFAULT NULL,
  `groundArea` int(11) DEFAULT NULL,
  `terraceArea` int(11) DEFAULT NULL,
  `typeHeating` varchar(250) CHARACTER SET utf8 DEFAULT NULL,
  `formula` varchar(250) CHARACTER SET utf8 DEFAULT NULL,
  `idQuote` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_QuoteHome_id` (`idQuote`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=latin1;

--
-- Vider la table avant d'insérer `QuoteHome`
--

TRUNCATE TABLE `QuoteHome`;
--
-- Contenu de la table `QuoteHome`
--

INSERT INTO `QuoteHome` (`id`, `typeHome`, `address`, `area`, `numberRoom`, `floor`, `numberBathroom`, `garage`, `groundArea`, `terraceArea`, `typeHeating`, `formula`, `idQuote`) VALUES
(1, 'Appartement', '29 rue du potager', 75, 3, 2, 3, 1, NULL, NULL, 'Fioul', 'Formule 2', 1),
(2, 'Studio', '34 rue du marchand de sable', 15, 3, NULL, 3, 0, NULL, NULL, 'Gaz', 'Formule 1', 4),
(3, 'Maison', '1 rue de la rue', 125, 3, 6, 3, 0, 25, 10, 'Electrique', 'Formule 2', 5),
(4, 'Studio', '10 avenue de la patate', 25, 3, NULL, 3, 1, NULL, NULL, 'Gaz', 'Formule 1', 7),
(5, 'Appartement', '9 route des carottes', 49, 3, 6, 3, 0, NULL, NULL, 'Fioul', 'Formule 2', 10),
(6, 'Maison', '100 boulevard des capucines', 90, 3, NULL, 3, 1, NULL, 40, 'Electrique', 'Formule 1', 12),
(7, 'Maison', '69 avenue des chiots', 135, 3, NULL, 3, 1, 38, NULL, 'Bois', 'Formule 2', 13);

--
-- Contraintes pour les tables exportées
--

--
-- Contraintes pour la table `QuoteCar`
--
ALTER TABLE `QuoteCar`
  ADD CONSTRAINT `FK_QuoteCar_id` FOREIGN KEY (`idQuote`) REFERENCES `Quote` (`id`);

--
-- Contraintes pour la table `QuoteHome`
--
ALTER TABLE `QuoteHome`
  ADD CONSTRAINT `FK_QuoteHome_id` FOREIGN KEY (`idQuote`) REFERENCES `Quote` (`id`);
--
-- Base de données :  `JAVA_G4_MS`
--
DROP DATABASE IF EXISTS `JAVA_G4_MS`;
CREATE DATABASE IF NOT EXISTS `JAVA_G4_MS` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;
USE `JAVA_G4_MS`;

-- --------------------------------------------------------

--
-- Structure de la table `list`
--

DROP TABLE IF EXISTS `list`;
CREATE TABLE IF NOT EXISTS `list` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `listKey` char(3) DEFAULT NULL,
  `value` varchar(255) DEFAULT NULL,
  `parent_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `list_parent_id` (`parent_id`)
) ENGINE=InnoDB AUTO_INCREMENT=39 DEFAULT CHARSET=utf8;

--
-- Vider la table avant d'insérer `list`
--

TRUNCATE TABLE `list`;
--
-- Contenu de la table `list`
--

INSERT INTO `list` (`id`, `listKey`, `value`, `parent_id`) VALUES
(5, 'MAR', 'Peugeot', NULL),
(6, 'MAR', 'Ford', NULL),
(7, 'MAR', 'Porsche', NULL),
(8, 'MAR', 'Toyota', NULL),
(9, 'MAR', 'Dacia', NULL),
(10, 'MAR', 'Kia', NULL),
(11, 'VEH', 'Clio', 4),
(12, 'VEH', 'Megane', 4),
(13, 'VEH', 'Captur', 4),
(14, 'VEH', '206', 5),
(15, 'VEH', '3008', 5),
(16, 'VEH', 'Focus', 6),
(17, 'VEH', 'Fiesta', 6),
(18, 'VEH', 'Cayenne', 7),
(19, 'VEH', '911', 7),
(20, 'VEH', 'Yaris', 8),
(21, 'VEH', 'Prius', 8),
(22, 'VEH', 'Sandero', 9),
(23, 'VEH', 'Duster', 9),
(24, 'VEH', 'Rio', 10),
(25, 'FUE', 'GPL', NULL),
(26, 'FUE', 'Essence', NULL),
(27, 'FUE', 'Electrique', NULL),
(28, 'FUE', 'Hybrid', NULL),
(31, 'HAB', 'Appartement', NULL),
(32, 'HAB', 'Maison', NULL),
(33, 'HAB', 'Studio', NULL),
(34, 'MAR', 'Renault', NULL),
(35, 'HEA', 'Electrique', NULL),
(36, 'HEA', 'Fioul', NULL),
(37, 'HEA', 'Gaz', NULL),
(38, 'HEA', 'Bois', NULL);

-- --------------------------------------------------------

--
-- Structure de la table `quote`
--

DROP TABLE IF EXISTS `quote`;
CREATE TABLE IF NOT EXISTS `quote` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userId` int(11) DEFAULT NULL,
  `typeQuote` varchar(255) DEFAULT NULL,
  `guarantee` varchar(255) DEFAULT NULL,
  `price` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

--
-- Vider la table avant d'insérer `quote`
--

TRUNCATE TABLE `quote`;
--
-- Contenu de la table `quote`
--

INSERT INTO `quote` (`id`, `userId`, `typeQuote`, `guarantee`, `price`) VALUES
(2, 3, 'habitation', 'maybe', 10),
(3, 5, 'voiture', 'yes', 1000),
(4, 6, 'habitation', 'yes', 1012),
(5, 7, 'voiture', 'maybe', 19),
(6, 8, 'voiture', 'maybe', 950),
(7, 8, 'habitation', 'no', 98),
(8, 9, 'voiture', 'maybe', 54),
(9, 10, 'habitation', 'no', 63);

-- --------------------------------------------------------

--
-- Structure de la table `user`
--

DROP TABLE IF EXISTS `user`;
CREATE TABLE IF NOT EXISTS `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `surname` varchar(255) DEFAULT NULL,
  `login` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `active` tinyint(1) NOT NULL DEFAULT '1',
  `createdAt` date NOT NULL DEFAULT '0000-00-00',
  `updatedAt` datetime NOT NULL DEFAULT '0000-00-00 00:00:00',
  `roles` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

--
-- Vider la table avant d'insérer `user`
--

TRUNCATE TABLE `user`;
--
-- Contenu de la table `user`
--

INSERT INTO `user` (`id`, `name`, `surname`, `login`, `password`, `active`, `createdAt`, `updatedAt`, `roles`) VALUES
(2, 'Wayne', 'Bruce', 'batman', '123456', 1, '2012-02-22', '2016-03-22 00:00:00', 'ROLE_ADMIN'),
(3, 'Kyle', 'Selina', 'catwoman', '123456', 1, '2014-03-22', '2016-03-22 00:00:00', 'ROLE_USER'),
(4, 'Parker', 'Peter', 'spiderman', '123456', 1, '2013-01-22', '2016-03-22 00:00:00', 'ROLE_USER'),
(5, 'Stark', 'Tony', 'ironman', '123456', 1, '2001-03-22', '2016-03-22 00:00:00', 'ROLE_USER'),
(6, 'Banner', 'Bruce', 'hulk', '123456', 0, '2006-06-22', '2016-03-22 00:00:00', 'ROLE_USER'),
(7, 'Romanoff', 'Natasha', 'blackwidow', '123456', 1, '2016-03-22', '2016-03-22 00:00:00', 'ROLE_USER'),
(8, 'Wilson', 'Wade', 'deadpool', '123456', 1, '2016-03-22', '2016-03-22 00:00:00', 'ROLE_USER'),
(9, 'Prince', 'Diana', 'wonderwoman', '123456', 0, '2008-03-22', '2016-03-22 00:00:00', 'ROLE_USER'),
(10, 'Allen', 'Barry', 'flash', '123456', 1, '2015-11-22', '2016-03-22 00:00:00', 'ROLE_USER');

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
