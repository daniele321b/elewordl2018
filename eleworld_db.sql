# ************************************************************
# Sequel Pro SQL dump
# Version 4541
#
# http://www.sequelpro.com/
# https://github.com/sequelpro/sequelpro
#
# Host: 127.0.0.1 (MySQL 5.7.18)
# Database: myfinaldb
# Generation Time: 2020-02-26 13:03:16 +0000
# ************************************************************


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


# Dump of table carrello
# ------------------------------------------------------------

DROP TABLE IF EXISTS `carrello`;

CREATE TABLE `carrello` (
  `utente_Email` varchar(45) NOT NULL,
  `prodotti_CodiceModello` int(11) NOT NULL,
  `prodotti_Categoria_Nome` varchar(45) NOT NULL,
  `prodotti_Magazzino_ID` int(11) NOT NULL,
  PRIMARY KEY (`utente_Email`,`prodotti_CodiceModello`,`prodotti_Categoria_Nome`,`prodotti_Magazzino_ID`),
  KEY `fk_carrello_prodotti1_idx` (`prodotti_CodiceModello`,`prodotti_Categoria_Nome`,`prodotti_Magazzino_ID`),
  CONSTRAINT `fk_carrello_prodotti1` FOREIGN KEY (`prodotti_CodiceModello`, `prodotti_Categoria_Nome`, `prodotti_Magazzino_ID`) REFERENCES `prodotti` (`CodiceModello`, `Categoria_Nome`, `Magazzino_ID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_carrello_utente1` FOREIGN KEY (`utente_Email`) REFERENCES `utente` (`Email`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



# Dump of table cartedicredito
# ------------------------------------------------------------

DROP TABLE IF EXISTS `cartedicredito`;

CREATE TABLE `cartedicredito` (
  `Ncarta` varchar(16) NOT NULL,
  `CVC` varchar(3) DEFAULT NULL,
  `Intestatario` varchar(45) DEFAULT NULL,
  `DataScadenza` date DEFAULT NULL,
  PRIMARY KEY (`Ncarta`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

LOCK TABLES `cartedicredito` WRITE;
/*!40000 ALTER TABLE `cartedicredito` DISABLE KEYS */;

INSERT INTO `cartedicredito` (`Ncarta`, `CVC`, `Intestatario`, `DataScadenza`)
VALUES
	('0','0','admin','2020-10-10'),
	('0000000000000000','0',NULL,NULL),
	('1111111111111111','0',NULL,NULL),
	('1234123412341234','0',NULL,NULL),
	('12345',NULL,NULL,NULL),
	('2222222222222222','0',NULL,NULL);

/*!40000 ALTER TABLE `cartedicredito` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table categoria
# ------------------------------------------------------------

DROP TABLE IF EXISTS `categoria`;

CREATE TABLE `categoria` (
  `Nome` varchar(45) NOT NULL,
  PRIMARY KEY (`Nome`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

LOCK TABLES `categoria` WRITE;
/*!40000 ALTER TABLE `categoria` DISABLE KEYS */;

INSERT INTO `categoria` (`Nome`)
VALUES
	('Caffe'),
	('Cottura'),
	('Ferri'),
	('Frigo'),
	('Lavasto'),
	('Lavatrici'),
	('Microonde'),
	('Scope'),
	('Tv');

/*!40000 ALTER TABLE `categoria` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table dettagliordini
# ------------------------------------------------------------

DROP TABLE IF EXISTS `dettagliordini`;

CREATE TABLE `dettagliordini` (
  `IdDettagliOrdini` int(11) NOT NULL,
  `Ordine_IdOrdine` int(11) NOT NULL,
  `Prodotti_CodiceModello` int(11) NOT NULL,
  `Prodotti_Categoria_Nome` varchar(45) NOT NULL,
  `Prodotti_Magazzino_ID` int(11) NOT NULL,
  `Ordine_Utente_Email` varchar(45) NOT NULL,
  PRIMARY KEY (`IdDettagliOrdini`,`Ordine_IdOrdine`,`Prodotti_CodiceModello`,`Prodotti_Categoria_Nome`,`Prodotti_Magazzino_ID`,`Ordine_Utente_Email`),
  KEY `fk_Dettagli ordini_Ordine1_idx` (`Ordine_IdOrdine`),
  KEY `fk_DettagliOrdini_Prodotti1_idx` (`Prodotti_CodiceModello`,`Prodotti_Categoria_Nome`,`Prodotti_Magazzino_ID`),
  KEY `fk_DettagliOrdini_Ordine1_idx` (`Ordine_Utente_Email`),
  CONSTRAINT `fk_Dettagli ordini_Ordine1` FOREIGN KEY (`Ordine_IdOrdine`) REFERENCES `ordine` (`IdOrdine`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_DettagliOrdini_Ordine1` FOREIGN KEY (`Ordine_Utente_Email`) REFERENCES `ordine` (`Utente_Email`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_DettagliOrdini_Prodotti1` FOREIGN KEY (`Prodotti_CodiceModello`, `Prodotti_Categoria_Nome`, `Prodotti_Magazzino_ID`) REFERENCES `prodotti` (`CodiceModello`, `Categoria_Nome`, `Magazzino_ID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



# Dump of table magazzino
# ------------------------------------------------------------

DROP TABLE IF EXISTS `magazzino`;

CREATE TABLE `magazzino` (
  `IdMagazzino` int(11) NOT NULL,
  PRIMARY KEY (`IdMagazzino`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

LOCK TABLES `magazzino` WRITE;
/*!40000 ALTER TABLE `magazzino` DISABLE KEYS */;

INSERT INTO `magazzino` (`IdMagazzino`)
VALUES
	(1);

/*!40000 ALTER TABLE `magazzino` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table ordine
# ------------------------------------------------------------

DROP TABLE IF EXISTS `ordine`;

CREATE TABLE `ordine` (
  `IdOrdine` int(11) NOT NULL,
  `DataOrdine` date DEFAULT NULL,
  `DataConsegna` date DEFAULT NULL,
  `Stato` varchar(45) DEFAULT NULL,
  `Utente_Email` varchar(45) NOT NULL,
  PRIMARY KEY (`IdOrdine`,`Utente_Email`),
  KEY `fk_Ordine_Utente1_idx` (`Utente_Email`),
  CONSTRAINT `fk_Ordine_Utente1` FOREIGN KEY (`Utente_Email`) REFERENCES `utente` (`Email`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



# Dump of table prodotti
# ------------------------------------------------------------

DROP TABLE IF EXISTS `prodotti`;

CREATE TABLE `prodotti` (
  `CodiceModello` int(11) NOT NULL,
  `Nome` varchar(45) DEFAULT NULL,
  `Produttore` varchar(45) DEFAULT NULL,
  `Colore` varchar(45) DEFAULT NULL,
  `Prezzo` float DEFAULT NULL,
  `PrezzoScontato` float DEFAULT NULL,
  `Peso` double DEFAULT NULL,
  `Altezza` int(11) DEFAULT NULL,
  `Profondita` int(11) DEFAULT NULL,
  `Larghezza` int(11) DEFAULT NULL,
  `Descrizione` varchar(90) DEFAULT NULL,
  `Immagine` varchar(100) DEFAULT NULL,
  `Giacenza` int(11) DEFAULT NULL,
  `Categoria_Nome` varchar(45) NOT NULL,
  `Magazzino_ID` int(11) NOT NULL,
  PRIMARY KEY (`CodiceModello`,`Categoria_Nome`,`Magazzino_ID`),
  KEY `fk_Prodotti_Categoria_idx` (`Categoria_Nome`),
  KEY `fk_Prodotti_Magazzino1_idx` (`Magazzino_ID`),
  CONSTRAINT `fk_Prodotti_Categoria` FOREIGN KEY (`Categoria_Nome`) REFERENCES `categoria` (`Nome`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Prodotti_Magazzino1` FOREIGN KEY (`Magazzino_ID`) REFERENCES `magazzino` (`IdMagazzino`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

LOCK TABLES `prodotti` WRITE;
/*!40000 ALTER TABLE `prodotti` DISABLE KEYS */;

INSERT INTO `prodotti` (`CodiceModello`, `Nome`, `Produttore`, `Colore`, `Prezzo`, `PrezzoScontato`, `Peso`, `Altezza`, `Profondita`, `Larghezza`, `Descrizione`, `Immagine`, `Giacenza`, `Categoria_Nome`, `Magazzino_ID`)
VALUES
	(17,'Caffe','Delonghi','nero',150,0,15,35,35,35,'MAcchina da caffe','delonghi2.png',3,'Caffe',1),
	(18,'Macchina caffeee','Delonghi','nero',150,0,15,12,12,12,'Bella macchina da caffe','delonghi2.png',12,'Caffe',1),
	(19,'prodotto','prodotto','nero',1000,500,50,40,40,40,'prodotto bello','poltiscope1.png',100,'Scope',1),
	(100,'Saeco Caffè','Saeco','grigio',499,359,7,21,100,100,'Macchina per caffè Automatica - Pressione 15 bar','saeco1.png',3,'Caffe',1),
	(101,'DeLonghi Caffè','DeLonghi ','grigio',149,NULL,4,24,30,38,'Macchina per caffè - Pressione: 15 bar ','delonghi.png',2,'Caffe',1),
	(102,'Bosch Forno','Bosch','nero',230,0,32,59,54,58,'Forno multifunzione - Classe di efficienza energetica: A','bosch1.png',8,'Cottura',1),
	(103,'Whirlpool Forno','Whirlpool','grigio',549,499,35,59,59,53,'Forno multifunzione - Classe di efficienza energetica: A','whirlpool1.png',2,'Cottura',1),
	(104,'Bosch Forno','Bosch','nero',365,299,36,59,59,55,'Forno multifunzione - Classe di efficienza energetica: A+','bosch2.png',3,'Cottura',1),
	(105,'Bosch Ferro','Bosch','bianco',139,0,4,29,23,39,'Ferro da stiro a caldaia - Potenza max: 2400 W','bosch1ferro.png',9,'Ferri',1),
	(106,'Imetec Ferro','Imetec','bianco',109,99,5,21,27,35,'Ferro da stiro a caldaia - Potenza max: 2800 W','imetec1.png',6,'Ferri',1),
	(107,'Smeg Frigo','Smeg','grigio',259,0,90,144,54,62,'Frigorifero Doppia porta Classe di efficienza energetica: A +','smegfrigo1.png',1,'Frigo',1),
	(108,'Samsung Frigo','Samsung','grigio',1299,1199,117,179,91,69,'Frigorifero Doppia porta Classe di efficienza energetica: A ','samsungfrigo1.png',0,'Frigo',1),
	(109,'Bosch Lavasto','Bosch','grigio',329,259,44,84,60,60,'','boschlavas1.png',13,'Lavasto',1),
	(110,'Beko Lavasto','Beco','nero',271,NULL,43,85,60,60,NULL,'bekolava1.png',10,'Lavasto',1),
	(111,'Whirlpool Lavat','Whirpool','grigio',469,399,73,85,59,60,'Lavasciuga carica Frontale','whirlpoollava1.png',3,'Lavatrici',1),
	(112,'Bosch Lavat','Bosch','bianca',499,0,67,84,59,55,'Lavasciuga carica Frontale','boschlava1.png',9,'Lavatrici',1),
	(113,'Samsung Lavat','Samsung','bianca',799,NULL,73,85,60,60,'Lavasciuga carica Frontale','samsunglava1.png',10,'Lavatrici',1),
	(114,'Samsung Micro','Samsung','grigio',99,0,13,27,48,35,'Microonde Capacità: 23 L','samsungmicro1.png',25,'Microonde',1),
	(115,'Whirlpool Micro','Whirlpool',NULL,26,199,33,54,52,50,NULL,'whirlpoolmicro1.png',9,'Microonde',1),
	(116,'DeLonghi Scope','DeLonghi','nero',72,NULL,3,120,25,14,'Scopa elettrica - Potenza: 900 W ','delonghiscope1.png',0,'Scope',1);

/*!40000 ALTER TABLE `prodotti` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table utente
# ------------------------------------------------------------

DROP TABLE IF EXISTS `utente`;

CREATE TABLE `utente` (
  `Email` varchar(45) NOT NULL,
  `Nome` varchar(45) NOT NULL,
  `Cognome` varchar(45) NOT NULL,
  `Password` varchar(45) NOT NULL,
  `Tipo` varchar(45) NOT NULL,
  `Paese` varchar(45) DEFAULT NULL,
  `Provincia` varchar(2) DEFAULT NULL,
  `Citta` varchar(45) DEFAULT NULL,
  `Via` varchar(45) DEFAULT NULL,
  `Cap` varchar(5) DEFAULT NULL,
  `Civico` int(11) DEFAULT NULL,
  `CarteDiCredito_Ncarta` varchar(16) NOT NULL,
  PRIMARY KEY (`Email`),
  KEY `fk_Utente_CarteDiCredito1_idx` (`CarteDiCredito_Ncarta`),
  CONSTRAINT `fk_Utente_CarteDiCredito1` FOREIGN KEY (`CarteDiCredito_Ncarta`) REFERENCES `cartedicredito` (`Ncarta`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

LOCK TABLES `utente` WRITE;
/*!40000 ALTER TABLE `utente` DISABLE KEYS */;

INSERT INTO `utente` (`Email`, `Nome`, `Cognome`, `Password`, `Tipo`, `Paese`, `Provincia`, `Citta`, `Via`, `Cap`, `Civico`, `CarteDiCredito_Ncarta`)
VALUES
	('admin@admin.com','admin','admin','admin','user',NULL,NULL,NULL,NULL,NULL,0,'2222222222222222'),
	('admin@admin.it','admin','admin','admin','admin','Italia','CE','Caserta','Napoli','81020',1,'0'),
	('admin@eleworld.it','admin','admin','admin','admin','Italia','SA','Nocera','xxv luglio','84013',3,'1111111111111111'),
	('daniele2@cioffi.it','daniele','cioffi','12345','user','italia','CE','maddaloni','mario sena','81024',4,'1234123412341234'),
	('daniele@cioffi.it','dani','cioffi','12345','user',NULL,NULL,NULL,NULL,NULL,0,'12345'),
	('mario@consalvo.it','mario','consalvo','12345','user',NULL,NULL,NULL,NULL,NULL,0,'12345'),
	('mario@mario.it','Mario','Consalv','123321','user',NULL,NULL,NULL,NULL,NULL,0,'0000000000000000'),
	('utente@utente.it','Daniele','Cioffi','123456','user','italia','CE','maddaloni','mario sena','81020',5,'1234123412341234');

/*!40000 ALTER TABLE `utente` ENABLE KEYS */;
UNLOCK TABLES;



/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
