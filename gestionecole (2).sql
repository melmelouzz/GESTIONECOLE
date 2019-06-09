-- phpMyAdmin SQL Dump
-- version 4.8.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3306
-- Generation Time: Jun 09, 2019 at 12:12 PM
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
  `anneescolaire` varchar(255) NOT NULL,
  PRIMARY KEY (`id_anneescolaire`)
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `anneescolaire`
--

INSERT INTO `anneescolaire` (`id_anneescolaire`, `anneescolaire`) VALUES
(1, '2018/2019'),
(2, '2019/2020');

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
) ENGINE=MyISAM AUTO_INCREMENT=22 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `bulletin`
--

INSERT INTO `bulletin` (`id_bulletin`, `id_trimestre`, `id_inscription`, `appreciation`) VALUES
(1, 1, 1, 'Bon eleve'),
(2, 2, 2, 'Encore des efforts à faire, ne lachez pas'),
(3, 3, 3, 'Manque de concentration'),
(4, 2, 4, 'Bon travail mais trop de bavardages'),
(5, 1, 5, 'Excellent travail, continuez ainsi'),
(6, 3, 6, 'Bon travail'),
(7, 1, 7, 'Peu mieux faire'),
(8, 2, 1, 'Des efforts'),
(9, 3, 1, 'Travail correct '),
(10, 1, 2, 'Des difficultés mais travail serieux '),
(11, 3, 2, 'Ensemble serieux '),
(12, 1, 3, 'Eleve dissipé '),
(13, 2, 3, 'Attention au bavardage '),
(14, 1, 4, 'Bon élève'),
(15, 3, 4, 'Bon élève mais manque de serieux '),
(16, 2, 5, 'Excellent élève'),
(17, 3, 5, 'Très bon travail'),
(18, 1, 6, 'Bons resultats'),
(19, 2, 6, 'Eleve serieux'),
(20, 2, 7, 'Peu de motivation'),
(21, 3, 7, 'Manque de rigueur');

-- --------------------------------------------------------

--
-- Table structure for table `classe`
--

DROP TABLE IF EXISTS `classe`;
CREATE TABLE IF NOT EXISTS `classe` (
  `id_classe` int(11) NOT NULL AUTO_INCREMENT,
  `nom_classe` varchar(255) NOT NULL,
  `id_ecole` int(255) NOT NULL,
  `id_niveau` int(255) NOT NULL,
  `id_anneescolaire` int(255) NOT NULL,
  PRIMARY KEY (`id_classe`),
  KEY `id_niveau` (`id_niveau`),
  KEY `id_anneescolaire` (`id_anneescolaire`),
  KEY `id_ecole` (`id_ecole`)
) ENGINE=MyISAM AUTO_INCREMENT=18 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `classe`
--

INSERT INTO `classe` (`id_classe`, `nom_classe`, `id_ecole`, `id_niveau`, `id_anneescolaire`) VALUES
(1, 'A', 1, 1, 1),
(2, 'B', 1, 2, 1),
(3, 'C', 1, 3, 1),
(9, 'C', 1, 2, 1),
(8, 'A', 1, 2, 1),
(6, 'B', 1, 1, 1),
(7, 'C', 1, 1, 1),
(10, 'A', 1, 3, 1),
(11, 'B', 1, 3, 1),
(12, 'A', 1, 4, 1),
(13, 'B', 1, 4, 1),
(14, 'C', 1, 4, 1),
(15, 'A', 1, 5, 1),
(16, 'B', 1, 5, 1),
(17, 'C', 1, 5, 1);

-- --------------------------------------------------------

--
-- Table structure for table `detailbulletin`
--

DROP TABLE IF EXISTS `detailbulletin`;
CREATE TABLE IF NOT EXISTS `detailbulletin` (
  `id_detailbulletin` int(255) NOT NULL AUTO_INCREMENT,
  `id_bulletin` int(255) NOT NULL,
  `id_enseignement` int(255) NOT NULL,
  `appreciation` varchar(255) NOT NULL,
  PRIMARY KEY (`id_detailbulletin`),
  KEY `id_bulletin` (`id_bulletin`),
  KEY `id_enseignement` (`id_enseignement`)
) ENGINE=MyISAM AUTO_INCREMENT=10 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `detailbulletin`
--

INSERT INTO `detailbulletin` (`id_detailbulletin`, `id_bulletin`, `id_enseignement`, `appreciation`) VALUES
(1, 1, 1, 'Bon eleve'),
(2, 2, 2, 'Encore des efforts à faire, ne lachez pas'),
(3, 3, 3, 'Manque de concentration'),
(4, 4, 4, 'Bon travail mais trop de bavardages'),
(5, 5, 5, 'Excellent travail, continuez ainsi'),
(6, 6, 6, 'Bon travail\r\n'),
(7, 7, 7, 'Des efforts'),
(8, 8, 8, 'Travail serieux'),
(9, 9, 9, 'Manque de travail');

-- --------------------------------------------------------

--
-- Table structure for table `discipline`
--

DROP TABLE IF EXISTS `discipline`;
CREATE TABLE IF NOT EXISTS `discipline` (
  `id_discipline` int(255) NOT NULL AUTO_INCREMENT,
  `nom_discipline` varchar(255) NOT NULL,
  PRIMARY KEY (`id_discipline`)
) ENGINE=MyISAM AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `discipline`
--

INSERT INTO `discipline` (`id_discipline`, `nom_discipline`) VALUES
(1, 'Francais'),
(2, 'Mathématiques'),
(3, 'Histoire-Géographie'),
(4, 'Anglais'),
(5, 'Musique');

-- --------------------------------------------------------

--
-- Table structure for table `ecole`
--

DROP TABLE IF EXISTS `ecole`;
CREATE TABLE IF NOT EXISTS `ecole` (
  `id_ecole` int(255) NOT NULL AUTO_INCREMENT,
  `nom_ecole` varchar(255) NOT NULL,
  PRIMARY KEY (`id_ecole`)
) ENGINE=MyISAM AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `ecole`
--

INSERT INTO `ecole` (`id_ecole`, `nom_ecole`) VALUES
(1, 'ECE Paris');

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
) ENGINE=MyISAM AUTO_INCREMENT=11 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `enseignement`
--

INSERT INTO `enseignement` (`id_enseignement`, `id_classe`, `id_discipline`, `id_personne`) VALUES
(1, 1, 1, 5),
(2, 2, 2, 5),
(3, 3, 3, 4),
(4, 4, 4, 4),
(5, 5, 5, 5),
(6, 3, 2, 7),
(7, 1, 2, 8),
(8, 2, 3, 4),
(9, 3, 5, 7),
(10, 1, 4, 10);

-- --------------------------------------------------------

--
-- Table structure for table `evaluation`
--

DROP TABLE IF EXISTS `evaluation`;
CREATE TABLE IF NOT EXISTS `evaluation` (
  `id_evaluation` int(255) NOT NULL AUTO_INCREMENT,
  `id_detailbulletin` int(255) NOT NULL,
  `note` double NOT NULL,
  `appreciation` varchar(255) NOT NULL,
  PRIMARY KEY (`id_evaluation`),
  KEY `id_detailbulletin` (`id_detailbulletin`)
) ENGINE=MyISAM AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `evaluation`
--

INSERT INTO `evaluation` (`id_evaluation`, `id_detailbulletin`, `note`, `appreciation`) VALUES
(1, 1, 12, 'Bon eleve'),
(2, 2, 11.5, 'Encore des efforts à faire, ne lachez pas'),
(3, 3, 9.5, 'Manque de concentration'),
(4, 4, 13, 'Bon travail mais trop de bavardages'),
(5, 5, 16.5, 'Excellent travail, continuez ainsi');

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
) ENGINE=MyISAM AUTO_INCREMENT=8 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `inscription`
--

INSERT INTO `inscription` (`id_inscription`, `id_classe`, `id_personne`) VALUES
(1, 1, 1),
(2, 2, 2),
(3, 3, 3),
(4, 3, 6),
(5, 2, 9),
(6, 2, 11),
(7, 1, 12);

-- --------------------------------------------------------

--
-- Table structure for table `niveau`
--

DROP TABLE IF EXISTS `niveau`;
CREATE TABLE IF NOT EXISTS `niveau` (
  `id_niveau` int(255) NOT NULL AUTO_INCREMENT,
  `nom_niveau` varchar(255) NOT NULL,
  PRIMARY KEY (`id_niveau`)
) ENGINE=MyISAM AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `niveau`
--

INSERT INTO `niveau` (`id_niveau`, `nom_niveau`) VALUES
(1, 'CP'),
(2, 'CE1'),
(3, 'CE2'),
(4, 'CM1'),
(5, 'CM2');

-- --------------------------------------------------------

--
-- Table structure for table `personne`
--

DROP TABLE IF EXISTS `personne`;
CREATE TABLE IF NOT EXISTS `personne` (
  `id_personne` int(255) NOT NULL AUTO_INCREMENT,
  `nom_personne` varchar(255) NOT NULL,
  `prenom_personne` varchar(255) NOT NULL,
  `type` varchar(255) NOT NULL,
  PRIMARY KEY (`id_personne`)
) ENGINE=MyISAM AUTO_INCREMENT=13 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `personne`
--

INSERT INTO `personne` (`id_personne`, `nom_personne`, `prenom_personne`, `type`) VALUES
(1, 'CLAVIER', 'Mélanie', 'Eleve'),
(2, 'AlARDET', 'Eloi', 'Eleve'),
(3, 'LEFEBRE', 'Louis', 'Eleve'),
(4, 'PICARD', 'Clément', 'Professeur'),
(5, 'GUETIENNE', 'Emma', 'Professeur'),
(6, 'Guermonprez', 'Ines', 'Eleve'),
(7, 'Segado', 'JP', 'Professeur'),
(8, 'Lucatelli', 'Sandro', 'Professeur'),
(9, 'Bouzemane', 'Sam', 'Eleve'),
(10, 'Manolo', 'Hina', 'Professeur'),
(11, 'Guirao', 'Oceane', 'Eleve'),
(12, 'Dupont', 'Manon', 'Eleve');

-- --------------------------------------------------------

--
-- Table structure for table `trimestre`
--

DROP TABLE IF EXISTS `trimestre`;
CREATE TABLE IF NOT EXISTS `trimestre` (
  `id_trimestre` int(255) NOT NULL AUTO_INCREMENT,
  `numero` int(255) NOT NULL,
  `debut` varchar(255) NOT NULL,
  `fin` varchar(255) NOT NULL,
  `id_anneescolaire` int(11) NOT NULL,
  PRIMARY KEY (`id_trimestre`),
  KEY `id_anneescolaire` (`id_anneescolaire`)
) ENGINE=MyISAM AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `trimestre`
--

INSERT INTO `trimestre` (`id_trimestre`, `numero`, `debut`, `fin`, `id_anneescolaire`) VALUES
(1, 1, '01/09', '31/12', 2018),
(2, 2, '01/01', '30/04', 2018),
(3, 3, '01/05', '30/06', 2018);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
