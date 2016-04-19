-- phpMyAdmin SQL Dump
-- version 4.6.0
-- http://www.phpmyadmin.net
--
-- Client :  localhost
-- Généré le :  Lun 18 Avril 2016 à 16:35
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

-- --------------------------------------------------------

--
-- Structure de la table `Quote`
--

CREATE TABLE `Quote` (
  `id` int(11) NOT NULL,
  `name` varchar(250) NOT NULL,
  `resume` varchar(250) NOT NULL,
  `price` float DEFAULT NULL,
  `step` int(11) NOT NULL,
  `login` varchar(250) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

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

CREATE TABLE `QuoteCar` (
  `id` int(11) NOT NULL,
  `brand` varchar(250) NOT NULL,
  `model` varchar(250) NOT NULL,
  `fuel` varchar(250) NOT NULL,
  `taxHorsepower` int(11) NOT NULL,
  `dateLicence` date NOT NULL,
  `numberAccident` int(11) NOT NULL,
  `bonusMalus` float NOT NULL,
  `garage` tinyint(1) NOT NULL,
  `driver` varchar(250) NOT NULL,
  `secondaryDriver` varchar(250) DEFAULT NULL,
  `address` varchar(250) DEFAULT NULL,
  `allRisk` tinyint(1) NOT NULL,
  `tiers` tinyint(1) NOT NULL,
  `idQuote` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `QuoteCar`
--

INSERT INTO `QuoteCar` (`id`, `brand`, `model`, `fuel`, `taxHorsepower`, `dateLicence`, `numberAccident`, `bonusMalus`, `garage`, `driver`, `secondaryDriver`, `address`, `allRisk`, `tiers`, `idQuote`) VALUES
(1, 'Peugeot', '206', 'Diesel', 20, '2012-10-14', 8, 0.5, 0, 'Paul Henry', NULL, NULL, 1, 0, 2),
(2, 'Renault', 'Megane', 'Essence', 60, '2020-11-04', 5, 0, 1, 'Claire Chazal', 'Gerard Henry', 'Rue des mouffettes', 0, 1, 3),
(3, 'Ford', 'Fiesta', 'GPL', 555, '1918-06-11', 2, 1.9, 0, 'Louane Avenir', NULL, NULL, 1, 0, 6),
(4, 'Toyota', 'Yaris', 'Electrique', 45, '2004-10-14', 1, 1.1, 1, 'Richard Gotener', 'Marie Drucker', 'Rue des papillons bleue', 1, 0, 8),
(5, 'Porshe', '911', 'Essence', 2, '2016-02-16', 0, 0, 0, 'Arnold Schwarzeneger', NULL, NULL, 0, 1, 9),
(6, 'Mercedes', 'A', 'Diesel', 600, '2008-09-02', 0, 1, 1, 'Louis LaBrocante', 'Marcel Letroc', 'Rue des abeilles', 1, 0, 11),
(7, 'Peugeot', '208', 'GPL', 84, '2001-01-14', 3, 5, 0, 'Léa Drucker', 'Papa Drucker', NULL, 1, 0, 14),
(8, 'Renault', 'Captur', 'Diesel', 13, '1950-10-19', 6, 2, 1, 'Myriam Ladame', NULL, 'Rue des mouettes qui font caca', 0, 1, 15);

-- --------------------------------------------------------

--
-- Structure de la table `QuoteHome`
--

CREATE TABLE `QuoteHome` (
  `id` int(11) NOT NULL,
  `typeHome` varchar(250) NOT NULL,
  `address` varchar(250) NOT NULL,
  `area` int(11) NOT NULL,
  `numberRoom` int(11) NOT NULL,
  `floor` int(11) DEFAULT NULL,
  `numberBathroom` int(11) NOT NULL,
  `garage` tinyint(1) NOT NULL,
  `groundArea` int(11) DEFAULT NULL,
  `terraceArea` int(11) DEFAULT NULL,
  `typeHeating` varchar(250) DEFAULT NULL,
  `formula` varchar(250) DEFAULT NULL,
  `idQuote` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

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
-- Index pour les tables exportées
--

--
-- Index pour la table `Quote`
--
ALTER TABLE `Quote`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `QuoteCar`
--
ALTER TABLE `QuoteCar`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK_QuoteCar_id` (`idQuote`);

--
-- Index pour la table `QuoteHome`
--
ALTER TABLE `QuoteHome`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK_QuoteHome_id` (`idQuote`);

--
-- AUTO_INCREMENT pour les tables exportées
--

--
-- AUTO_INCREMENT pour la table `Quote`
--
ALTER TABLE `Quote`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;
--
-- AUTO_INCREMENT pour la table `QuoteCar`
--
ALTER TABLE `QuoteCar`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;
--
-- AUTO_INCREMENT pour la table `QuoteHome`
--
ALTER TABLE `QuoteHome`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;
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

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
