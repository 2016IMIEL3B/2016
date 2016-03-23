-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Client :  127.0.0.1
-- Généré le :  Mar 22 Mars 2016 à 09:21
-- Version du serveur :  10.1.10-MariaDB
-- Version de PHP :  5.6.15

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";

CREATE DATABASE java_g4_ms;

USE java_g4_ms;

-- --------------------------------------------------------

--
-- Structure de la table `list`
--

CREATE TABLE `list` (
  `id` int(11) NOT NULL,
  `list_key` varchar(255) NOT NULL DEFAULT '',
  `value` varchar(255) NOT NULL DEFAULT ''
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `quote`
--

CREATE TABLE `quote` (
  `id` int(11) NOT NULL,
  `userName` varchar(255) NOT NULL DEFAULT '',
  `userSurname` varchar(255) NOT NULL DEFAULT '',
  `userId` int(11) NOT NULL,
  `typeQuote` varchar(255) NOT NULL DEFAULT '',
  `guarantee` varchar(255) NOT NULL DEFAULT '',
  `price` int(11) NOT NULL DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `user`
--

CREATE TABLE `user` (
  `id` int(11) NOT NULL,
  `name` varchar(255) NOT NULL DEFAULT '',
  `surname` varchar(255) NOT NULL DEFAULT '',
  `login` varchar(255) NOT NULL DEFAULT '',
  `password` varchar(255) NOT NULL DEFAULT '',
  `active` tinyint(1) NOT NULL DEFAULT '1',
  `createdAt` date NOT NULL DEFAULT '0000-00-00',
  `updatedAt` datetime NOT NULL DEFAULT '0000-00-00 00:00:00',
  `roles` varchar(255) NOT NULL DEFAULT ''
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Index pour les tables exportées
--

--
-- Index pour la table `list`
--
ALTER TABLE `list`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `quote`
--
ALTER TABLE `quote`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT pour les tables exportées
--

--
-- AUTO_INCREMENT pour la table `list`
--
ALTER TABLE `list`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT pour la table `quote`
--
ALTER TABLE `quote`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT pour la table `user`
--
ALTER TABLE `user`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

INSERT INTO `user` (`id`, `name`, `surname`, `login`, `password`, `active`, `createdAt`, `updatedAt`, `roles`) VALUES (NULL, 'Kent', 'Clarc', 'superman', '123456', '1', '2016-03-22', '2016-03-22 00:00:00', '');
INSERT INTO `quote` (`id`, `userName`, `userSurname`, `userId`, `typeQuote`, `guarantee`, `price`) VALUES (NULL, 'Parker', 'Peter', '1', 'habitation', 'maybe', '10');
INSERT INTO `list` (`id`, `list_key`, `value`) VALUES (NULL, 'marque', 'citroen'), (NULL, 'fuel', 'diesel');
