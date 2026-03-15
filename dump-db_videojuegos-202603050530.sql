/*M!999999\- enable the sandbox mode */ 
-- MariaDB dump 10.19-12.1.2-MariaDB, for Linux (x86_64)
--
-- Host: localhost    Database: db_videojuegos
-- ------------------------------------------------------
-- Server version	12.1.2-MariaDB

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*M!100616 SET @OLD_NOTE_VERBOSITY=@@NOTE_VERBOSITY, NOTE_VERBOSITY=0 */;

--
-- Table structure for table `tbl_cat_categoria`
--

DROP TABLE IF EXISTS `tbl_cat_categoria`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8mb4 */;
CREATE TABLE `tbl_cat_categoria` (
  `CategoriaId` int(11) NOT NULL AUTO_INCREMENT,
  `Clasificacion_Nombre` varchar(45) NOT NULL,
  PRIMARY KEY (`CategoriaId`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_uca1400_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_cat_categoria`
--

LOCK TABLES `tbl_cat_categoria` WRITE;
/*!40000 ALTER TABLE `tbl_cat_categoria` DISABLE KEYS */;
set autocommit=0;
INSERT INTO `tbl_cat_categoria` VALUES
(1,'RPG'),
(2,'ACCION'),
(3,'ESTRATEGIA'),
(4,'SIMULACION'),
(5,'AVENTURA'),
(6,'DEPORTES'),
(7,'PUZZLE'),
(8,'MUNDO ABIERTO'),
(9,'UN JUGADOR'),
(10,'MULTIJUGADOR'),
(11,'BATTLE ROYALE');
/*!40000 ALTER TABLE `tbl_cat_categoria` ENABLE KEYS */;
UNLOCK TABLES;
commit;

--
-- Table structure for table `tbl_cat_desarrolladores`
--

DROP TABLE IF EXISTS `tbl_cat_desarrolladores`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8mb4 */;
CREATE TABLE `tbl_cat_desarrolladores` (
  `DesarrolladoresId` int(11) NOT NULL AUTO_INCREMENT,
  `Desarrolladores_Nombre` varchar(45) NOT NULL,
  PRIMARY KEY (`DesarrolladoresId`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_uca1400_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_cat_desarrolladores`
--

LOCK TABLES `tbl_cat_desarrolladores` WRITE;
/*!40000 ALTER TABLE `tbl_cat_desarrolladores` DISABLE KEYS */;
set autocommit=0;
INSERT INTO `tbl_cat_desarrolladores` VALUES
(1,'MERLINO GAMES'),
(2,'METAZOOIE STUDIOS'),
(3,'MICHIYUKI PROJECT'),
(4,'MIGHTY SQUID STUDIOS'),
(5,'ACTIVISION'),
(6,'AQ INTERACTIVE'),
(7,'BIOWARE'),
(8,'BLIZZARD ENTRETAINMENT'),
(9,'BETHESDA SOFTWORKS');
/*!40000 ALTER TABLE `tbl_cat_desarrolladores` ENABLE KEYS */;
UNLOCK TABLES;
commit;

--
-- Table structure for table `tbl_cat_esbr`
--

DROP TABLE IF EXISTS `tbl_cat_esbr`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8mb4 */;
CREATE TABLE `tbl_cat_esbr` (
  `EsbrId` int(11) NOT NULL AUTO_INCREMENT,
  `Esbr_Esbr` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`EsbrId`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_uca1400_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_cat_esbr`
--

LOCK TABLES `tbl_cat_esbr` WRITE;
/*!40000 ALTER TABLE `tbl_cat_esbr` DISABLE KEYS */;
set autocommit=0;
INSERT INTO `tbl_cat_esbr` VALUES
(1,'EC - Early Childhood'),
(2,'E - Everyone'),
(3,'E10+ - Everyone 10+'),
(4,'T - Teen'),
(5,'M - Mature'),
(6,'AO - Adults Only'),
(7,'RP - Rating Pending');
/*!40000 ALTER TABLE `tbl_cat_esbr` ENABLE KEYS */;
UNLOCK TABLES;
commit;

--
-- Table structure for table `tbl_cat_plataformas`
--

DROP TABLE IF EXISTS `tbl_cat_plataformas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8mb4 */;
CREATE TABLE `tbl_cat_plataformas` (
  `PlataformasId` int(11) NOT NULL AUTO_INCREMENT,
  `Plataformas_Nombre` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`PlataformasId`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_uca1400_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_cat_plataformas`
--

LOCK TABLES `tbl_cat_plataformas` WRITE;
/*!40000 ALTER TABLE `tbl_cat_plataformas` DISABLE KEYS */;
set autocommit=0;
INSERT INTO `tbl_cat_plataformas` VALUES
(1,'PS5'),
(2,'XBOX SERIES'),
(3,'WINDOWS 10/11'),
(4,'SWITCH'),
(5,'LINUX'),
(6,'MOBILE'),
(7,'MACOS');
/*!40000 ALTER TABLE `tbl_cat_plataformas` ENABLE KEYS */;
UNLOCK TABLES;
commit;

--
-- Table structure for table `tbl_ope_multimedia`
--

DROP TABLE IF EXISTS `tbl_ope_multimedia`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8mb4 */;
CREATE TABLE `tbl_ope_multimedia` (
  `MultimediaId` int(11) NOT NULL AUTO_INCREMENT,
  `Multimedia_ImagenURL` varchar(200) NOT NULL,
  `Multimedia_TrailerURL` varchar(200) NOT NULL,
  PRIMARY KEY (`MultimediaId`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_uca1400_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_ope_multimedia`
--

LOCK TABLES `tbl_ope_multimedia` WRITE;
/*!40000 ALTER TABLE `tbl_ope_multimedia` DISABLE KEYS */;
set autocommit=0;
INSERT INTO `tbl_ope_multimedia` VALUES
(1,'https://tu-servidor.com/covers/elden_ring.jpg','https://youtube.com/watch?v=E3Huy2cdih0'),
(2,'https://tu-servidor.com/covers/elden_ring.jpg','https://youtube.com/watch?v=E3Huy2cdih0'),
(5,'/hola','prueba'),
(6,'/hola','prueba'),
(7,'/hola','prueba'),
(8,'/hola','prueba'),
(9,'/hola','prueba'),
(10,'/uploads/1772218675975-img.png','aaaaaaaaaaa'),
(11,'/uploads/1772219216612-img.png','testtes'),
(12,'/uploads/1772500139592-img.webp','https://www.youtube.com/watch?v=6qpf3YWbCcE'),
(13,'/uploads/1772647618391-img.jpg','https://www.youtube.com/watch?v=6qpf3YWbCcE'),
(14,'/uploads/1772647769480-img.jpg','https://www.youtube.com/watch?v=6qpf3YWbCcE'),
(15,'/uploads/1772647782856-img.jpg','https://www.youtube.com/watch?v=6qpf3YWbCcE'),
(16,'/uploads/1772647968781-img.jpg','https://www.youtube.com/watch?v=6qpf3YWbCcE'),
(17,'/uploads/1772648063391-img.jpg','https://www.youtube.com/watch?v=6qpf3YWbCcE'),
(18,'/uploads/1772650538862-img.jpg','https://www.youtube.com/watch?v=6qpf3YWbCcE'),
(19,'/uploads/1772671391424-img.jpg','https://www.youtube.com/watch?v=6qpf3YWbCcE');
/*!40000 ALTER TABLE `tbl_ope_multimedia` ENABLE KEYS */;
UNLOCK TABLES;
commit;

--
-- Table structure for table `tbl_ope_videojuegos`
--

DROP TABLE IF EXISTS `tbl_ope_videojuegos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8mb4 */;
CREATE TABLE `tbl_ope_videojuegos` (
  `VideojuegosId` int(11) NOT NULL AUTO_INCREMENT,
  `Videojuegos_Titulo` varchar(80) NOT NULL,
  `Videojuegos_DesarrolladoresId` int(11) NOT NULL,
  `Videojuegos_FechaLanzamiento` date NOT NULL,
  `Videojuegos_Descripcion` text NOT NULL,
  `Videojuegos_EsbrId` int(11) NOT NULL,
  `Videojuegos_Precio` float NOT NULL,
  `Videojuegos_Requisitos` mediumtext NOT NULL,
  `Videojuegos_Activo` bit(1) NOT NULL,
  `Videojuegos_MultimediaId` int(11) DEFAULT NULL,
  PRIMARY KEY (`VideojuegosId`),
  KEY `fk_videojuegos_desarrollador_idx` (`Videojuegos_DesarrolladoresId`),
  KEY `fk_videojuegos_esbr_idx` (`Videojuegos_EsbrId`),
  KEY `fk_videojuegos_multimedia_idx` (`Videojuegos_MultimediaId`),
  CONSTRAINT `fk_videojuegos_desarrollador` FOREIGN KEY (`Videojuegos_DesarrolladoresId`) REFERENCES `tbl_cat_desarrolladores` (`DesarrolladoresId`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_videojuegos_esbr` FOREIGN KEY (`Videojuegos_EsbrId`) REFERENCES `tbl_cat_esbr` (`EsbrId`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_videojuegos_multimedia` FOREIGN KEY (`Videojuegos_MultimediaId`) REFERENCES `tbl_ope_multimedia` (`MultimediaId`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_uca1400_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_ope_videojuegos`
--

LOCK TABLES `tbl_ope_videojuegos` WRITE;
/*!40000 ALTER TABLE `tbl_ope_videojuegos` DISABLE KEYS */;
set autocommit=0;
INSERT INTO `tbl_ope_videojuegos` VALUES
(1,'ELDEN RING',1,'2022-02-25','LEVÁNTATE, SINLUZ, Y DÉJATE GUIAR POR LA GRACIA PARA ESGRIMIR EL PODER DEL CÍRCULO DE ELDEN.',4,59.99,'MÍNIMO: INTEL CORE I5-8400, 12GB RAM, GTX 1060 3GB. RECOMENDADO: INTEL CORE I7-8700K, 16GB RAM, GTX 1070 8GB.',0x01,1),
(9,'GEARS OF WAR',1,'2026-01-05','LOCUST Y MARCUS DANDOSE DE CHINGADAZOS BIEN FUERTE',1,32,'UN ETSBOS',0x01,NULL),
(10,'GEARS OF WAR',1,'2026-01-05','LOCUST Y MARCUS DANDOSE DE CHINGADAZOS BIEN FUERTE',1,32,'UN ETSBOS',0x01,NULL),
(11,'GEARS OF WAR',1,'2026-01-05','LOCUST Y MARCUS DANDOSE DE CHINGADAZOS BIEN FUERTE',1,32,'UN ETSBOS',0x01,NULL),
(12,'TEST',1,'2021-02-24','TESTESTESTES',1,12.12,'ALGOOO',0x01,NULL),
(13,'GEARS OF WAR',1,'2026-01-05','LOCUST Y MARCUS DANDOSE DE CHINGADAZOS BIEN FUERTE',1,32,'UN ETSBOS',0x01,NULL),
(14,'AFSFA',1,'2026-03-04','DASDSA',1,12,'SFA',0x01,NULL),
(15,'AFSFA',1,'2026-03-04','DASDSA',1,12,'SFA',0x01,NULL),
(16,'AFSFA',1,'2026-03-04','DASDSA',1,12,'SFA',0x01,NULL),
(17,'TEST',1,'2021-02-24','TESTESTESTES',1,12.12,'ALGOOO',0x01,NULL),
(18,'AFSFA',1,'2026-03-04','DASDSA',1,12,'SFA',0x01,NULL),
(19,'AFSFA',1,'2026-03-04','DASDSA',1,12,'SFA',0x01,NULL),
(20,'AFSFA',1,'2026-03-04','DASDSA',1,12,'SFA',0x01,NULL),
(21,'AFSFA',1,'2026-03-04','DASDSA',1,12,'SFA',0x01,NULL),
(22,'AFSFA',1,'2026-03-04','DASDSA',1,12,'SFA',0x01,NULL),
(23,'AFSFA',1,'2026-03-04','DASDSA',1,12,'SFA',0x01,NULL),
(24,'AFSFA',1,'2026-03-04','DASDSA',1,12,'SFA',0x01,NULL),
(30,'ADSA',1,'2026-03-04','DSADSA',1,12,'SDAD',0x01,18),
(31,'ADSA',1,'2026-03-04','DSADSA',1,12,'SDAD',0x01,19);
/*!40000 ALTER TABLE `tbl_ope_videojuegos` ENABLE KEYS */;
UNLOCK TABLES;
commit;

--
-- Table structure for table `tbl_rel_videojuegos_categoria`
--

DROP TABLE IF EXISTS `tbl_rel_videojuegos_categoria`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8mb4 */;
CREATE TABLE `tbl_rel_videojuegos_categoria` (
  `VideojuegosCategoriaId` int(11) NOT NULL AUTO_INCREMENT,
  `VideojuegosId` int(11) NOT NULL,
  `CategoriaId` int(11) NOT NULL,
  PRIMARY KEY (`VideojuegosCategoriaId`),
  KEY `fk_videojuegos_idx` (`VideojuegosId`),
  KEY `fk_categoria_idx` (`CategoriaId`),
  CONSTRAINT `fk_categoria` FOREIGN KEY (`CategoriaId`) REFERENCES `tbl_cat_categoria` (`CategoriaId`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_videojuegoscat` FOREIGN KEY (`VideojuegosId`) REFERENCES `tbl_ope_videojuegos` (`VideojuegosId`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_uca1400_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_rel_videojuegos_categoria`
--

LOCK TABLES `tbl_rel_videojuegos_categoria` WRITE;
/*!40000 ALTER TABLE `tbl_rel_videojuegos_categoria` DISABLE KEYS */;
set autocommit=0;
INSERT INTO `tbl_rel_videojuegos_categoria` VALUES
(13,16,2),
(14,17,1),
(15,17,3),
(16,17,5),
(17,18,2),
(18,19,2),
(19,20,2),
(20,21,2),
(21,22,2),
(22,23,2),
(23,24,2),
(29,30,1),
(30,31,1);
/*!40000 ALTER TABLE `tbl_rel_videojuegos_categoria` ENABLE KEYS */;
UNLOCK TABLES;
commit;

--
-- Table structure for table `tbl_rel_videojuegos_plataforma`
--

DROP TABLE IF EXISTS `tbl_rel_videojuegos_plataforma`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8mb4 */;
CREATE TABLE `tbl_rel_videojuegos_plataforma` (
  `VideojuegosPlataformaId` int(11) NOT NULL AUTO_INCREMENT,
  `VideojuegosId` int(11) NOT NULL,
  `PlataformaId` int(11) NOT NULL,
  PRIMARY KEY (`VideojuegosPlataformaId`),
  KEY `fk_videojuegos_idx` (`VideojuegosId`),
  KEY `fk_plataforma_idx` (`PlataformaId`),
  CONSTRAINT `fk_plataforma` FOREIGN KEY (`PlataformaId`) REFERENCES `tbl_cat_plataformas` (`PlataformasId`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_videojuegosplat` FOREIGN KEY (`VideojuegosId`) REFERENCES `tbl_ope_videojuegos` (`VideojuegosId`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=36 DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_uca1400_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_rel_videojuegos_plataforma`
--

LOCK TABLES `tbl_rel_videojuegos_plataforma` WRITE;
/*!40000 ALTER TABLE `tbl_rel_videojuegos_plataforma` DISABLE KEYS */;
set autocommit=0;
INSERT INTO `tbl_rel_videojuegos_plataforma` VALUES
(14,9,1),
(15,10,1),
(16,11,1),
(17,13,1),
(18,16,2),
(19,17,1),
(20,17,2),
(21,17,4),
(22,18,2),
(23,19,2),
(24,20,2),
(25,21,2),
(26,22,2),
(27,23,2),
(28,24,2),
(34,30,1),
(35,31,2);
/*!40000 ALTER TABLE `tbl_rel_videojuegos_plataforma` ENABLE KEYS */;
UNLOCK TABLES;
commit;

--
-- Dumping routines for database 'db_videojuegos'
--
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'IGNORE_SPACE,STRICT_TRANS_TABLES,ERROR_FOR_DIVISION_BY_ZERO,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_addGame_X_data` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_unicode_ci */ ;
DELIMITER ;;
CREATE DEFINER=`videojuegos`@`localhost` PROCEDURE `sp_addGame_X_data`(
    IN _titulo varchar(80),
    IN _desarrolladoresId int,
    IN _fechaLanzamiento date,
    IN _descripcion text,
    IN _esbrId int,
    IN _precio float,
    IN _requisitos mediumtext,
    IN _activo bit(1),
    IN _categorias text,
    IN _plataformas text
)
BEGIN
    declare _videojuegoId int;
    declare _idActual int;
    
    -- Insertamos el videojuego con el multimediaId en NULL temporalmente
    insert into tbl_ope_videojuegos
    values(
    	null,
        upper(_titulo),
        _desarrolladoresId,
        _fechaLanzamiento,
        upper(_descripcion),
        _esbrId,
        _precio,
        upper(_requisitos),
        _activo,
        NULL -- Aún no tenemos multimedia
    );
    
    set _videojuegoId = LAST_INSERT_ID();
    
    -- Lógica de categorías (igual a la que ya tienes)
    while locate(',', _categorias) > 0 DO
        SET _idActual = substring(_categorias, 1 , locate(',', _categorias) - 1);
        insert into tbl_rel_videojuegos_categoria values(null, _videojuegoId, cast(_idActual as unsigned));
        set _categorias = substring(_categorias , locate(',', _categorias) + 1);
    end while;
    if _categorias <> '' then
        insert into tbl_rel_videojuegos_categoria values(null, _videojuegoId, cast(_categorias as unsigned));
    end if;
    
    -- Lógica de plataformas (igual a la que ya tienes)
    while locate(',', _plataformas) > 0 DO
        SET _idActual = substring(_plataformas, 1 , locate(',', _plataformas) - 1);
        insert into tbl_rel_videojuegos_plataforma values(null, _videojuegoId, cast(_idActual as unsigned));
        set _plataformas = substring(_plataformas , locate(',', _plataformas) + 1);
    end while;
    if _plataformas <> '' then
        insert into tbl_rel_videojuegos_plataforma values(null, _videojuegoId, cast(_plataformas as unsigned));
    end if;

    -- RETORNAMOS EL ID PARA JAVA
    SELECT _videojuegoId as nuevoId;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'IGNORE_SPACE,STRICT_TRANS_TABLES,ERROR_FOR_DIVISION_BY_ZERO,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_deleteGameById` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_unicode_ci */ ;
DELIMITER ;;
CREATE DEFINER=`videojuegos`@`localhost` PROCEDURE `sp_deleteGameById`(IN _VideojuegoId int)
BEGIN
	delete from tbl_rel_videojuegos_categoria where VideojuegosId = _VideojuegoId;
	delete from tbl_rel_videojuegos_plataforma where VideojuegosId = _VideojuegoId;
	delete from tbl_ope_videojuegos where VideojuegosId = _VideojuegoId;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'IGNORE_SPACE,STRICT_TRANS_TABLES,ERROR_FOR_DIVISION_BY_ZERO,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_showAllGames` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_unicode_ci */ ;
DELIMITER ;;
CREATE DEFINER=`videojuegos`@`localhost` PROCEDURE `sp_showAllGames`()
BEGIN
	select 
		v.VideojuegosId,
		v.Videojuegos_Titulo,
		v.Videojuegos_FechaLanzamiento,
		v.Videojuegos_Precio,
		v.Videojuegos_Descripcion,
		v.Videojuegos_Requisitos,
		v.Videojuegos_Activo,
		d.Desarrolladores_Nombre,
		e.Esbr_Esbr,
		m.Multimedia_ImagenURL,
		m.Multimedia_TrailerURL,
		group_concat(distinct c.Clasificacion_Nombre separator ', ') as categorias,
		group_concat(distinct p.Plataformas_Nombre separator ', ') as plataformas
	from tbl_ope_videojuegos v
	inner join tbl_cat_desarrolladores d on v.Videojuegos_DesarrolladoresId = d.DesarrolladoresId
	inner join tbl_cat_esbr e on v.Videojuegos_EsbrId = e.EsbrId
	inner join tbl_ope_multimedia m on v.Videojuegos_MultimediaId = m.MultimediaId
	inner join tbl_rel_videojuegos_categoria relcat on v.VideojuegosId = relcat.VideojuegosId
	inner join tbl_cat_categoria c on relcat.CategoriaId = c.CategoriaId
	inner join tbl_rel_videojuegos_plataforma relpla on v.VideojuegosId = relpla.VideojuegosId
	inner join tbl_cat_plataformas p on relpla.PlataformaId = p.PlataformasId
	group by v.VideojuegosId;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'IGNORE_SPACE,STRICT_TRANS_TABLES,ERROR_FOR_DIVISION_BY_ZERO,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_showGameById` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_unicode_ci */ ;
DELIMITER ;;
CREATE DEFINER=`videojuegos`@`localhost` PROCEDURE `sp_showGameById`(IN _VideojuegoId int)
BEGIN
		select 
		v.VideojuegosId,
		v.Videojuegos_Titulo,
		v.Videojuegos_FechaLanzamiento,
		v.Videojuegos_Precio,
		v.Videojuegos_Descripcion,
		v.Videojuegos_Requisitos,
		v.Videojuegos_Activo,
		d.Desarrolladores_Nombre,
		e.Esbr_Esbr,
		m.Multimedia_ImagenURL,
		m.Multimedia_TrailerURL,
		group_concat(distinct c.Clasificacion_Nombre separator ', ') as categorias,
		group_concat(distinct p.Plataformas_Nombre separator ', ') as plataformas
	from tbl_ope_videojuegos v
	inner join tbl_cat_desarrolladores d on v.Videojuegos_DesarrolladoresId = d.DesarrolladoresId
	inner join tbl_cat_esbr e on v.Videojuegos_EsbrId = e.EsbrId
	inner join tbl_ope_multimedia m on v.Videojuegos_MultimediaId = m.MultimediaId
	inner join tbl_rel_videojuegos_categoria relcat on v.VideojuegosId = relcat.VideojuegosId
	inner join tbl_cat_categoria c on relcat.CategoriaId = c.CategoriaId
	inner join tbl_rel_videojuegos_plataforma relpla on v.VideojuegosId = relpla.VideojuegosId
	inner join tbl_cat_plataformas p on relpla.PlataformaId = p.PlataformasId
	where v.VideojuegosId = _VideojuegoId
	group by v.VideojuegosId;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'IGNORE_SPACE,STRICT_TRANS_TABLES,ERROR_FOR_DIVISION_BY_ZERO,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_updateMultimediaGame` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_unicode_ci */ ;
DELIMITER ;;
CREATE DEFINER=`videojuegos`@`localhost` PROCEDURE `sp_updateMultimediaGame`(
	IN _videojuegoId int,
    IN _imagenUrl varchar(200),
    IN _trailerUrl varchar(200)
)
BEGIN
	declare _multimediaId int;

    -- 1. Insertamos en la tabla multimedia
    insert into tbl_ope_multimedia
    values (null, _imagenUrl, _trailerUrl);
    
    set _multimediaId = LAST_INSERT_ID();

    -- 2. Actualizamos el videojuego para que apunte a esta nueva multimedia
    update tbl_ope_videojuegos 
    set Videojuegos_MultimediaId = _multimediaId 
    where VideojuegosId = _videojuegoId;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*M!100616 SET NOTE_VERBOSITY=@OLD_NOTE_VERBOSITY */;

-- Dump completed on 2026-03-05  5:30:02
