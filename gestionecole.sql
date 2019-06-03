-- phpMyAdmin SQL Dump
-- version 4.8.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3306
-- Generation Time: Jun 03, 2019 at 02:25 PM
-- Server version: 5.7.24
-- PHP Version: 7.2.14

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `gestionecole`
--

-- --------------------------------------------------------

--
-- Table structure for table `anneescolaire`
--

DROP TABLE IF EXISTS `anneescolaire`;
CREATE TABLE IF NOT EXISTS `anneescolaire` (
  `id_anneescolaire` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id_anneescolaire`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `bulletin`
--

DROP TABLE IF EXISTS `bulletin`;
CREATE TABLE IF NOT EXISTS `bulletin` (
  `id_bulletin` int(255) NOT NULL AUTO_INCREMENT,
  `id_trimestre` int(255) NOT NULL,
  `id_inscription` int(255) NOT NULL,
  `appreciation` varchar(255) NOT NULL,
  PRIMARY KEY (`id_bulletin`),
  KEY `id_trimestre` (`id_trimestre`),
  KEY `id_inscription` (`id_inscription`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `classe`
--

DROP TABLE IF EXISTS `classe`;
CREATE TABLE IF NOT EXISTS `classe` (
  `id_classe` int(255) NOT NULL AUTO_INCREMENT,
  `nom_classe` varchar(255) NOT NULL,
  `id_ecole` int(255) NOT NULL,
  `id_niveau` int(255) NOT NULL,
  `id_anneescolaire` int(255) NOT NULL,
  PRIMARY KEY (`id_classe`),
  KEY `id_ecole` (`id_ecole`),
  KEY `id_niveau` (`id_niveau`),
  KEY `id_anneescolaire` (`id_anneescolaire`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `detailbulletin`
--

DROP TABLE IF EXISTS `detailbulletin`;
CREATE TABLE IF NOT EXISTS `detailbulletin` (
  `id_detailBulettin` int(255) NOT NULL AUTO_INCREMENT,
  `id_bulletin` int(255) NOT NULL,
  `id_enseignement` int(255) NOT NULL,
  `appreciation` varchar(255) NOT NULL,
  PRIMARY KEY (`id_detailBulettin`),
  KEY `id_bulletin` (`id_bulletin`),
  KEY `id_enseignement` (`id_enseignement`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `discipline`
--

DROP TABLE IF EXISTS `discipline`;
CREATE TABLE IF NOT EXISTS `discipline` (
  `id_discipline` int(255) NOT NULL AUTO_INCREMENT,
  `nom_discipline` int(255) NOT NULL,
  PRIMARY KEY (`id_discipline`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `ecole`
--

DROP TABLE IF EXISTS `ecole`;
CREATE TABLE IF NOT EXISTS `ecole` (
  `id_ecole` int(255) NOT NULL AUTO_INCREMENT,
  `nom_ecole` int(255) NOT NULL,
  PRIMARY KEY (`id_ecole`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `enseignement`
--

DROP TABLE IF EXISTS `enseignement`;
CREATE TABLE IF NOT EXISTS `enseignement` (
  `id_enseignement` int(255) NOT NULL AUTO_INCREMENT,
  `id_classe` int(255) NOT NULL,
  `id_discipline` int(255) NOT NULL,
  `id_personne` int(255) NOT NULL,
  PRIMARY KEY (`id_enseignement`),
  KEY `id_classe` (`id_classe`),
  KEY `id_discipline` (`id_discipline`),
  KEY `id_personne` (`id_personne`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `evaluation`
--

DROP TABLE IF EXISTS `evaluation`;
CREATE TABLE IF NOT EXISTS `evaluation` (
  `id_evaluation` int(255) NOT NULL AUTO_INCREMENT,
  `id_detailBulettin` int(255) NOT NULL,
  `note` double NOT NULL,
  `appreciation` varchar(255) NOT NULL,
  PRIMARY KEY (`id_evaluation`),
  KEY `id_detailBulettin` (`id_detailBulettin`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `inscription`
--

DROP TABLE IF EXISTS `inscription`;
CREATE TABLE IF NOT EXISTS `inscription` (
  `id_inscription` int(255) NOT NULL AUTO_INCREMENT,
  `id_classe` int(255) NOT NULL,
  `id_personne` int(255) NOT NULL,
  PRIMARY KEY (`id_inscription`),
  KEY `id_classe` (`id_classe`),
  KEY `id_personne` (`id_personne`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `niveau`
--

DROP TABLE IF EXISTS `niveau`;
CREATE TABLE IF NOT EXISTS `niveau` (
  `id_niveau` int(255) NOT NULL,
  `nom` varchar(255) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `personne`
--

DROP TABLE IF EXISTS `personne`;
CREATE TABLE IF NOT EXISTS `personne` (
  `id_personne` int(255) NOT NULL AUTO_INCREMENT,
  `nom_personne` int(255) NOT NULL,
  `prenom_personne` int(255) NOT NULL,
  `type` varchar(255) NOT NULL,
  PRIMARY KEY (`id_personne`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `trimestre`
--

DROP TABLE IF EXISTS `trimestre`;
CREATE TABLE IF NOT EXISTS `trimestre` (
  `id_trimestre` int(255) NOT NULL AUTO_INCREMENT,
  `numero` int(255) NOT NULL,
  `début` varchar(255) NOT NULL,
  `fin` varchar(255) NOT NULL,
  `id` int(255) NOT NULL,
  PRIMARY KEY (`id_trimestre`),
  KEY `id` (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
