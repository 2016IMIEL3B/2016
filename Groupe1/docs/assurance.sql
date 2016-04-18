-- phpMyAdmin SQL Dump
-- version 4.5.2
-- http://www.phpmyadmin.net
--
-- Client :  localhost
-- Généré le :  Mar 22 Mars 2016 à 09:33
-- Version du serveur :  10.1.9-MariaDB
-- Version de PHP :  5.6.15

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `assurance`
--

-- --------------------------------------------------------

--
-- Structure de la table `Account`
--

CREATE TABLE `Account` (
  `id` int(11) NOT NULL,
  `isAdmin` tinyint(1) NOT NULL,
  `login` varchar(45) NOT NULL,
  `password` varchar(64) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Contenu de la table `Account`
--

INSERT INTO `Account` (`id`, `isAdmin`, `login`, `password`) VALUES
(1, 1, 'gtostain', 'admin456'),
(2, 1, 'jcadieu', 'admin456'),
(3, 1, 'sarques', 'admin456');

-- --------------------------------------------------------

--
-- Structure de la table `Address`
--

CREATE TABLE `Address` (
  `id` int(11) NOT NULL,
  `number` int(11) NOT NULL,
  `street` varchar(45) NOT NULL,
  `postode` varchar(45) NOT NULL,
  `city` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Contenu de la table `Address`
--

INSERT INTO `Address` (`id`, `number`, `street`, `postode`, `city`) VALUES
(1, 7, 'Rue d’Athènes', '14120', 'Mondeville'),
(2, 10, 'Rue Michel', '35000', 'Rennes'),
(3, 9, 'Rue de la Republique', '13000', 'Marseille');

-- --------------------------------------------------------

--
-- Structure de la table `Brand`
--

CREATE TABLE `Brand` (
  `id` int(11) NOT NULL,
  `name` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Contenu de la table `Brand`
--

INSERT INTO `Brand` (`id`, `name`) VALUES
(1, 'Renault'),
(2, 'Peugeot'),
(3, 'Mercedes');

-- --------------------------------------------------------

--
-- Structure de la table `Habitation`
--

CREATE TABLE `Habitation` (
  `id` int(11) NOT NULL,
  `type` varchar(45) NOT NULL,
  `surface` double NOT NULL,
  `roomNumber` int(11) NOT NULL,
  `floor` int(11) DEFAULT NULL,
  `bathroomNumber` int(11) NOT NULL,
  `garage` tinyint(1) NOT NULL,
  `groundSurface` double DEFAULT NULL,
  `patioSurface` double NOT NULL,
  `heatingType` varchar(45) NOT NULL,
  `option` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Contenu de la table `Habitation`
--

INSERT INTO `Habitation` (`id`, `type`, `surface`, `roomNumber`, `floor`, `bathroomNumber`, `garage`, `groundSurface`, `patioSurface`, `heatingType`, `option`) VALUES
(1, 'appartement', 60, 2, 2, 1, 1, NULL, 5, 'electrique', '1'),
(2, 'maison', 100, 4, NULL, 2, 1, 200, 0, 'electrique', '1');

-- --------------------------------------------------------

--
-- Structure de la table `Model`
--

CREATE TABLE `Model` (
  `id` int(11) NOT NULL,
  `name` varchar(45) NOT NULL,
  `idBrand` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Contenu de la table `Model`
--

INSERT INTO `Model` (`id`, `name`, `idBrand`) VALUES
(1, '208', 2),
(2, 'Clio V', 1),
(3, 'Megane', 1),
(4, 'Classe C', 3);

-- --------------------------------------------------------

--
-- Structure de la table `Quote`
--

CREATE TABLE `Quote` (
  `id` int(11) NOT NULL,
  `name` varchar(45) NOT NULL,
  `step` int(11) NOT NULL,
  `isCompleted` tinyint(1) NOT NULL,
  `price` double NOT NULL,
  `summary` varchar(255) NOT NULL,
  `idVehicle` int(11) DEFAULT NULL,
  `idHabitation` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Contenu de la table `Quote`
--

INSERT INTO `Quote` (`id`, `name`, `step`, `isCompleted`, `price`, `summary`, `idVehicle`, `idHabitation`) VALUES
(1, 'test', 4, 1, 800, 'RAS', 1, NULL),
(2, 'testDevis', 4, 1, 700, 'RAS', 2, NULL),
(3, 'devisHabitation', 4, 1, 1000, 'RAS', NULL, 1);

-- --------------------------------------------------------

--
-- Structure de la table `QuoteUser`
--

CREATE TABLE `QuoteUser` (
  `idQuote` int(11) NOT NULL,
  `idUser` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Contenu de la table `QuoteUser`
--

INSERT INTO `QuoteUser` (`idQuote`, `idUser`) VALUES
(1, 1),
(2, 2),
(3, 3);

-- --------------------------------------------------------

--
-- Structure de la table `User`
--

CREATE TABLE `User` (
  `id` int(11) NOT NULL,
  `firstname` varchar(45) NOT NULL,
  `lastname` varchar(45) NOT NULL,
  `bonus` int(11) NOT NULL,
  `drivingLicenceDate` datetime NOT NULL,
  `accidentNumber` int(11) NOT NULL,
  `isSecondary` tinyint(1) NOT NULL,
  `idAddress` int(11) NOT NULL,
  `idAccount` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Contenu de la table `User`
--

INSERT INTO `User` (`id`, `firstname`, `lastname`, `bonus`, `drivingLicenceDate`, `accidentNumber`, `isSecondary`, `idAddress`, `idAccount`) VALUES
(1, 'Guillaume', 'Tostain', 20, '2012-01-01 00:00:00', 0, 0, 1, 1),
(2, 'Jonas', 'Cadieu', 30, '2012-01-01 00:00:00', 0, 0, 2, 2),
(3, 'Simon', 'Arques', 25, '2012-01-01 00:00:00', 0, 0, 3, 3);

-- --------------------------------------------------------

--
-- Structure de la table `Vehicle`
--

CREATE TABLE `Vehicle` (
  `id` int(11) NOT NULL,
  `fuel` varchar(45) NOT NULL,
  `horsepower` varchar(45) NOT NULL,
  `sleepInside` tinyint(1) NOT NULL,
  `anyRisk` tinyint(1) NOT NULL,
  `idModel` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Contenu de la table `Vehicle`
--

INSERT INTO `Vehicle` (`id`, `fuel`, `horsepower`, `sleepInside`, `anyRisk`, `idModel`) VALUES
(1, 'diesel', '5', 0, 1, 1),
(2, 'essence', '5', 1, 0, 2);

--
-- Index pour les tables exportées
--

--
-- Index pour la table `Account`
--
ALTER TABLE `Account`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `Address`
--
ALTER TABLE `Address`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `Brand`
--
ALTER TABLE `Brand`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `Habitation`
--
ALTER TABLE `Habitation`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `Model`
--
ALTER TABLE `Model`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_Model_Brand1_idx` (`idBrand`);

--
-- Index pour la table `Quote`
--
ALTER TABLE `Quote`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_Quote_Vehicle1_idx` (`idVehicle`),
  ADD KEY `fk_Quote_Habitation1_idx` (`idHabitation`);

--
-- Index pour la table `QuoteUser`
--
ALTER TABLE `QuoteUser`
  ADD PRIMARY KEY (`idQuote`,`idUser`),
  ADD KEY `fk_Quote_has_User_User1_idx` (`idUser`),
  ADD KEY `fk_Quote_has_User_Quote1_idx` (`idQuote`);

--
-- Index pour la table `User`
--
ALTER TABLE `User`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_Client_Address1_idx` (`idAddress`),
  ADD KEY `fk_User_Account1_idx` (`idAccount`);

--
-- Index pour la table `Vehicle`
--
ALTER TABLE `Vehicle`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_Vehicle_Model1_idx` (`idModel`);

--
-- AUTO_INCREMENT pour les tables exportées
--

--
-- AUTO_INCREMENT pour la table `Account`
--
ALTER TABLE `Account`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT pour la table `Address`
--
ALTER TABLE `Address`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT pour la table `Brand`
--
ALTER TABLE `Brand`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT pour la table `Habitation`
--
ALTER TABLE `Habitation`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT pour la table `Model`
--
ALTER TABLE `Model`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
--
-- AUTO_INCREMENT pour la table `Quote`
--
ALTER TABLE `Quote`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT pour la table `User`
--
ALTER TABLE `User`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT pour la table `Vehicle`
--
ALTER TABLE `Vehicle`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- Contraintes pour les tables exportées
--

--
-- Contraintes pour la table `Model`
--
ALTER TABLE `Model`
  ADD CONSTRAINT `fk_Model_Brand1` FOREIGN KEY (`idBrand`) REFERENCES `Brand` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Contraintes pour la table `Quote`
--
ALTER TABLE `Quote`
  ADD CONSTRAINT `fk_Quote_Habitation1` FOREIGN KEY (`idHabitation`) REFERENCES `Habitation` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_Quote_Vehicle1` FOREIGN KEY (`idVehicle`) REFERENCES `Vehicle` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Contraintes pour la table `QuoteUser`
--
ALTER TABLE `QuoteUser`
  ADD CONSTRAINT `fk_Quote_has_User_Quote1` FOREIGN KEY (`idQuote`) REFERENCES `Quote` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_Quote_has_User_User1` FOREIGN KEY (`idUser`) REFERENCES `User` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Contraintes pour la table `User`
--
ALTER TABLE `User`
  ADD CONSTRAINT `fk_Client_Address1` FOREIGN KEY (`idAddress`) REFERENCES `Address` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_User_Account1` FOREIGN KEY (`idAccount`) REFERENCES `Account` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Contraintes pour la table `Vehicle`
--
ALTER TABLE `Vehicle`
  ADD CONSTRAINT `fk_Vehicle_Model1` FOREIGN KEY (`idModel`) REFERENCES `Model` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
