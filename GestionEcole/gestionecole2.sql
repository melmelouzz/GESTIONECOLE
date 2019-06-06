
SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


CREATE TABLE `AnneeScolaire` (
  `id_anneescolaire` int(11) NOT NULL PRIMARY KEY
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

CREATE TABLE `Trimestre` (
  `id_trimestre` int(255) NOT NULL PRIMARY KEY AUTO_INCREMENT,
  `numero` int(255) NOT NULL,
  `debut` varchar(255) NOT NULL,
  `fin` varchar(255) NOT NULL,
  `id_anneescolaire` int(11) NOT NULL,
  FOREIGN KEY (`id_anneescolaire`) REFERENCES AnneeScolaire(`id_anneescolaire`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

CREATE TABLE `Niveau` (
  `id_niveau` int(255) NOT NULL PRIMARY KEY,
  `nom_niveau` varchar(255) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

CREATE TABLE `Classe` (
  `id_classe` int(11) NOT NULL PRIMARY KEY AUTO_INCREMENT,
  `nom_classe` varchar(255) NOT NULL,
  `id_ecole` int(255) NOT NULL,
  `id_niveau` int(255) NOT NULL,
  `id_anneescolaire` int(255) NOT NULL,
  FOREIGN KEY (`id_niveau`) REFERENCES Niveau(`id_niveau`),
  FOREIGN KEY (`id_anneescolaire`) REFERENCES AnneeScolaire(`id_anneescolaire`),
  FOREIGN KEY (`id_ecole`) REFERENCES Ecole(`id_ecole`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;


CREATE TABLE `Discipline` (
  `id_discipline` int(255) NOT NULL PRIMARY KEY AUTO_INCREMENT,
  `nom_discipline` int(255) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

CREATE TABLE `Enseignement` (
  `id_enseignement` int(255) NOT NULL PRIMARY KEY AUTO_INCREMENT,
  `id_classe` int(255) NOT NULL,
  `id_discipline` int(255) NOT NULL,
  `id_personne` int(255) NOT NULL,
  FOREIGN KEY (`id_classe`) REFERENCES Classe(`id_classe`),
  FOREIGN KEY (`id_discipline`) REFERENCES Discipline(`id_discipline`),
  FOREIGN KEY (`id_personne`) REFERENCES Personne(`id_personne`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

CREATE TABLE `Inscription` (
  `id_inscription` int(255) NOT NULL PRIMARY KEY AUTO_INCREMENT,
  `id_classe` int(255) NOT NULL,
  `id_personne` int(255) NOT NULL,
  FOREIGN KEY (`id_classe`) REFERENCES Classe(`id_classe`),
  FOREIGN KEY (`id_personne`) REFERENCES Personne(`id_personne`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

CREATE TABLE `Personne` (
  `id_personne` int(255) NOT NULL PRIMARY KEY AUTO_INCREMENT,
  `nom_personne` varchar(255) NOT NULL,
  `prenom_personne` varchar(255) NOT NULL,
  `type` varchar(255) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

CREATE TABLE `Bulletin` (
  `id_bulletin` int(255) NOT NULL PRIMARY KEY AUTO_INCREMENT,
  `id_trimestre` int(255) NOT NULL,
  `id_inscription` int(255) NOT NULL,
  `appreciation` varchar(255) NOT NULL,
  FOREIGN KEY (`id_trimestre`) REFERENCES Trimestre(`id_trimestre`),
  FOREIGN KEY (`id_inscription`) REFERENCES Inscription(`id_inscription`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

CREATE TABLE `DetailBulletin` (
  `id_detailbulletin` int(255) NOT NULL PRIMARY KEY AUTO_INCREMENT,
  `id_bulletin` int(255) NOT NULL,
  `id_enseignement` int(255) NOT NULL,
  `appreciation` varchar(255) NOT NULL,
  FOREIGN KEY (`id_bulletin`) REFERENCES Bulletin(`id_bulletin`),
  FOREIGN KEY (`id_enseignement`) REFERENCES Enseignement(`id_enseignement`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

CREATE TABLE `Ecole` (
  `id_ecole` int(255) NOT NULL PRIMARY KEY AUTO_INCREMENT,
  `nom_ecole` int(255) NOT NULL
  ) ENGINE=MyISAM DEFAULT CHARSET=latin1;

CREATE TABLE `Evaluation` (
  `id_evaluation` int(255) NOT NULL PRIMARY KEY AUTO_INCREMENT,
  `id_detailbulletin` int(255) NOT NULL,
  `note` double NOT NULL,
  `appreciation` varchar(255) NOT NULL,
  FOREIGN KEY (`id_detailbulletin`) REFERENCES DetailBulletin(`id_detailbulletin`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
