-- phpMyAdmin SQL Dump
-- version 4.5.2
-- http://www.phpmyadmin.net
--
-- Client :  localhost
-- Généré le :  Jeu 24 Mars 2016 à 16:28
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
-- Structure de la table `Address`
--

CREATE TABLE `Address` (
  `id` int(11) NOT NULL,
  `number` int(11) NOT NULL,
  `street` varchar(45) NOT NULL,
  `postcode` int(11) NOT NULL,
  `city` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Contenu de la table `Address`
--

INSERT INTO `Address` (`id`, `number`, `street`, `postcode`, `city`) VALUES
(1, 7, 'Rue d’Athènes', 14120, 'Mondeville'),
(2, 10, 'Rue Michel', 35000, 'Rennes'),
(3, 9, 'Rue de la Republique', 13000, 'Marseille');

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
(2, 'Peugeot');

-- --------------------------------------------------------

--
-- Structure de la table `Client`
--

CREATE TABLE `Client` (
  `id` int(11) NOT NULL,
  `bonus` int(11) NOT NULL,
  `drivingLicenceDate` datetime NOT NULL,
  `accidentNumber` int(11) NOT NULL,
  `isSecondary` tinyint(1) NOT NULL,
  `userId` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Contenu de la table `Client`
--

INSERT INTO `Client` (`id`, `bonus`, `drivingLicenceDate`, `accidentNumber`, `isSecondary`, `userId`) VALUES
(1, 50, '2012-01-01 00:00:00', 0, 0, 1),
(2, 30, '2013-01-01 00:00:00', 0, 0, 2);

-- --------------------------------------------------------

--
-- Structure de la table `Habitation`
--

CREATE TABLE `Habitation` (
  `id` int(11) NOT NULL,
  `type` varchar(45) NOT NULL,
  `surface` int(11) NOT NULL,
  `roomNumber` int(11) NOT NULL,
  `floor` int(11) DEFAULT NULL,
  `bathroomNumber` int(11) NOT NULL,
  `garage` tinyint(1) NOT NULL,
  `groundSurface` int(11) DEFAULT NULL,
  `patioSurface` int(11) NOT NULL,
  `heatingType` varchar(45) NOT NULL,
  `option` varchar(45) NOT NULL,
  `addressId` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Contenu de la table `Habitation`
--

INSERT INTO `Habitation` (`id`, `type`, `surface`, `roomNumber`, `floor`, `bathroomNumber`, `garage`, `groundSurface`, `patioSurface`, `heatingType`, `option`, `addressId`) VALUES
(1, 'maison', 100, 3, NULL, 1, 1, 200, 20, 'electrique', '1', 1),
(2, 'appartement', 50, 2, 3, 1, 0, NULL, 20, 'electrique', '1', 2);

-- --------------------------------------------------------

--
-- Structure de la table `Model`
--

CREATE TABLE `Model` (
  `id` int(11) NOT NULL,
  `name` varchar(45) NOT NULL,
  `brandId` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Contenu de la table `Model`
--

INSERT INTO `Model` (`id`, `name`, `brandId`) VALUES
(1, 'Clio IV', 1),
(2, '208', 2);

-- --------------------------------------------------------

--
-- Structure de la table `Quote`
--

CREATE TABLE `Quote` (
  `id` int(11) NOT NULL,
  `name` varchar(45) NOT NULL,
  `step` int(11) NOT NULL,
  `isCompleted` tinyint(1) NOT NULL,
  `price` float NOT NULL,
  `summary` varchar(255) NOT NULL,
  `vehicleId` int(11) DEFAULT NULL,
  `habitationId` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Contenu de la table `Quote`
--

INSERT INTO `Quote` (`id`, `name`, `step`, `isCompleted`, `price`, `summary`, `vehicleId`, `habitationId`) VALUES
(1, 'devisClioIV', 1, 0, 800, 'devis clio IV', 1, NULL),
(2, 'devisAppartement', 1, 0, 1000, 'devis maison centre rennes', NULL, 2);

-- --------------------------------------------------------

--
-- Structure de la table `QuoteUser`
--

CREATE TABLE `QuoteUser` (
  `quoteId` int(11) NOT NULL,
  `userId` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Contenu de la table `QuoteUser`
--

INSERT INTO `QuoteUser` (`quoteId`, `userId`) VALUES
(1, 1),
(2, 2);

-- --------------------------------------------------------

--
-- Structure de la table `Role`
--

CREATE TABLE `Role` (
  `roleId` int(11) NOT NULL,
  `roleName` varchar(45) NOT NULL,
  `userId` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Contenu de la table `Role`
--

INSERT INTO `Role` (`roleId`, `roleName`, `userId`) VALUES
(1, 'ROLE_ADMIN', 1),
(2, 'ROLE_USER', 2);

-- --------------------------------------------------------

--
-- Structure de la table `User`
--

CREATE TABLE `User` (
  `userId` int(11) NOT NULL,
  `firstName` varchar(45) NOT NULL,
  `lastName` varchar(45) NOT NULL,
  `login` varchar(45) NOT NULL,
  `password` varchar(64) NOT NULL,
  `addressId` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Contenu de la table `User`
--

INSERT INTO `User` (`userId`, `firstName`, `lastName`, `login`, `password`, `addressId`) VALUES
(1, 'Guillaume', 'Tostain', 'gtostain', 'admin456', 1),
(2, 'Jonas', 'Cadieu', 'jcadieu', 'admin456', 2);

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
  `modelId` int(11) NOT NULL,
  `addressId` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Contenu de la table `Vehicle`
--

INSERT INTO `Vehicle` (`id`, `fuel`, `horsepower`, `sleepInside`, `anyRisk`, `modelId`, `addressId`) VALUES
(1, 'diesel', '5', 1, 1, 1, 1),
(2, 'essence', '4', 0, 0, 2, 2);

--
-- Index pour les tables exportées
--

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
-- Index pour la table `Client`
--
ALTER TABLE `Client`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_Client_User1_idx` (`userId`);

--
-- Index pour la table `Habitation`
--
ALTER TABLE `Habitation`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_Habitation_Address1_idx` (`addressId`);

--
-- Index pour la table `Model`
--
ALTER TABLE `Model`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_Model_Brand1_idx` (`brandId`);

--
-- Index pour la table `Quote`
--
ALTER TABLE `Quote`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_Quote_Vehicle1_idx` (`vehicleId`),
  ADD KEY `fk_Quote_Habitation1_idx` (`habitationId`);

--
-- Index pour la table `QuoteUser`
--
ALTER TABLE `QuoteUser`
  ADD PRIMARY KEY (`quoteId`,`userId`),
  ADD KEY `fk_Quote_has_User_User1_idx` (`userId`),
  ADD KEY `fk_Quote_has_User_Quote1_idx` (`quoteId`);

--
-- Index pour la table `Role`
--
ALTER TABLE `Role`
  ADD PRIMARY KEY (`roleId`),
  ADD KEY `fk_Role_User1_idx` (`userId`);

--
-- Index pour la table `User`
--
ALTER TABLE `User`
  ADD PRIMARY KEY (`userId`),
  ADD KEY `fk_User_Address1_idx` (`addressId`);

--
-- Index pour la table `Vehicle`
--
ALTER TABLE `Vehicle`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_Vehicle_Model1_idx` (`modelId`),
  ADD KEY `fk_Vehicle_Address1_idx` (`addressId`);

--
-- AUTO_INCREMENT pour les tables exportées
--

--
-- AUTO_INCREMENT pour la table `Address`
--
ALTER TABLE `Address`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT pour la table `Brand`
--
ALTER TABLE `Brand`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT pour la table `Client`
--
ALTER TABLE `Client`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT pour la table `Habitation`
--
ALTER TABLE `Habitation`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT pour la table `Model`
--
ALTER TABLE `Model`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT pour la table `Quote`
--
ALTER TABLE `Quote`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT pour la table `Role`
--
ALTER TABLE `Role`
  MODIFY `roleId` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT pour la table `User`
--
ALTER TABLE `User`
  MODIFY `userId` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
--
-- AUTO_INCREMENT pour la table `Vehicle`
--
ALTER TABLE `Vehicle`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- Contraintes pour les tables exportées
--

--
-- Contraintes pour la table `Client`
--
ALTER TABLE `Client`
  ADD CONSTRAINT `fk_Client_User1` FOREIGN KEY (`userId`) REFERENCES `User` (`userId`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Contraintes pour la table `Habitation`
--
ALTER TABLE `Habitation`
  ADD CONSTRAINT `fk_Habitation_Address1` FOREIGN KEY (`addressId`) REFERENCES `Address` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Contraintes pour la table `Model`
--
ALTER TABLE `Model`
  ADD CONSTRAINT `fk_Model_Brand1` FOREIGN KEY (`brandId`) REFERENCES `Brand` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Contraintes pour la table `Quote`
--
ALTER TABLE `Quote`
  ADD CONSTRAINT `fk_Quote_Habitation1` FOREIGN KEY (`habitationId`) REFERENCES `Habitation` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_Quote_Vehicle1` FOREIGN KEY (`vehicleId`) REFERENCES `Vehicle` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Contraintes pour la table `QuoteUser`
--
ALTER TABLE `QuoteUser`
  ADD CONSTRAINT `fk_Quote_has_User_Quote1` FOREIGN KEY (`quoteId`) REFERENCES `Quote` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_Quote_has_User_User1` FOREIGN KEY (`userId`) REFERENCES `Client` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Contraintes pour la table `Role`
--
ALTER TABLE `Role`
  ADD CONSTRAINT `fk_Role_User1` FOREIGN KEY (`userId`) REFERENCES `User` (`userId`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Contraintes pour la table `User`
--
ALTER TABLE `User`
  ADD CONSTRAINT `fk_User_Address1` FOREIGN KEY (`addressId`) REFERENCES `Address` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Contraintes pour la table `Vehicle`
--
ALTER TABLE `Vehicle`
  ADD CONSTRAINT `fk_Vehicle_Address1` FOREIGN KEY (`addressId`) REFERENCES `Address` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_Vehicle_Model1` FOREIGN KEY (`modelId`) REFERENCES `Model` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
