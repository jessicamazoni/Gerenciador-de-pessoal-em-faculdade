-- MySQL dump 10.13  Distrib 5.6.24, for Win32 (x86)
--
-- Host: localhost    Database: dbfaculdade
-- ------------------------------------------------------
-- Server version	5.1.36-community-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `aluno`
--

DROP TABLE IF EXISTS `aluno`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `aluno` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `nome` varchar(45) NOT NULL,
  `sexo` enum('Feminino','Masculino') NOT NULL,
  `data` date DEFAULT NULL,
  `rg` bigint(20) NOT NULL,
  `curso` int(11) NOT NULL,
  `endereco` varchar(70) DEFAULT NULL,
  `id_campus` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `id_campus` (`id_campus`)
) ENGINE=MyISAM AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `aluno`
--

LOCK TABLES `aluno` WRITE;
/*!40000 ALTER TABLE `aluno` DISABLE KEYS */;
INSERT INTO `aluno` VALUES (1,'Emilio','Masculino','1996-10-16',34535,1,'fgdgdf',2),(2,'Joae','Masculino','2000-09-09',43544,2,'34534',3),(3,'dfgddf','Masculino','2000-09-09',345345,2,'sdfsdf',2),(4,'sdgfgd','Masculino','2000-09-09',34534,2,'sdfsfdd',1),(5,'xcxcv','Masculino','2000-09-09',345345,1,'sdfsdfs',1);
/*!40000 ALTER TABLE `aluno` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `campus`
--

DROP TABLE IF EXISTS `campus`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `campus` (
  `idC` int(11) NOT NULL AUTO_INCREMENT,
  `cidade` varchar(20) NOT NULL,
  PRIMARY KEY (`idC`)
) ENGINE=MyISAM AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `campus`
--

LOCK TABLES `campus` WRITE;
/*!40000 ALTER TABLE `campus` DISABLE KEYS */;
INSERT INTO `campus` VALUES (1,'DF'),(2,'SP'),(3,'RJ');
/*!40000 ALTER TABLE `campus` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `contaspagar`
--

DROP TABLE IF EXISTS `contaspagar`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `contaspagar` (
  `idpagar` int(11) NOT NULL,
  `emissao` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `vencimento` date DEFAULT NULL,
  `doc` double DEFAULT NULL,
  `descricao` varchar(100) NOT NULL,
  `parcelas` int(11) NOT NULL,
  `valor` varchar(10) DEFAULT NULL,
  `juros` decimal(10,2) NOT NULL,
  `desconto` decimal(10,2) NOT NULL,
  `valorParcela` varchar(10) NOT NULL,
  `situacao` varchar(100) NOT NULL,
  PRIMARY KEY (`idpagar`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `contaspagar`
--

LOCK TABLES `contaspagar` WRITE;
/*!40000 ALTER TABLE `contaspagar` DISABLE KEYS */;
/*!40000 ALTER TABLE `contaspagar` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `controle`
--

DROP TABLE IF EXISTS `controle`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `controle` (
  `idcontrole` int(11) NOT NULL,
  `idturma` int(11) NOT NULL,
  `nome_aluno` varchar(100) NOT NULL,
  `iddisc` int(11) NOT NULL,
  `iddisc1` int(11) NOT NULL,
  `iddisc2` int(11) NOT NULL,
  `iddisc3` int(11) NOT NULL,
  `iddisc4` int(11) NOT NULL,
  `iddisc5` int(11) NOT NULL,
  `Disciplina1` varchar(100) DEFAULT NULL,
  `Disciplina2` varchar(100) DEFAULT NULL,
  `Disciplina3` varchar(100) DEFAULT NULL,
  `Disciplina4` varchar(100) DEFAULT NULL,
  `Disciplina5` varchar(100) DEFAULT NULL,
  `Nota1` double DEFAULT NULL,
  `Nota2` double DEFAULT NULL,
  `Nota3` double DEFAULT NULL,
  `Nota4` double DEFAULT NULL,
  `Nota5` double DEFAULT NULL,
  `Média` double DEFAULT NULL,
  `faltas` int(11) NOT NULL,
  `Situacao` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`idcontrole`),
  KEY `idturma` (`idturma`),
  KEY `iddisc` (`iddisc`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `controle`
--

LOCK TABLES `controle` WRITE;
/*!40000 ALTER TABLE `controle` DISABLE KEYS */;
/*!40000 ALTER TABLE `controle` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `curso`
--

DROP TABLE IF EXISTS `curso`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `curso` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(20) NOT NULL,
  `id_func` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `curso`
--

LOCK TABLES `curso` WRITE;
/*!40000 ALTER TABLE `curso` DISABLE KEYS */;
INSERT INTO `curso` VALUES (1,'Matematica',1),(2,'Portugues',2);
/*!40000 ALTER TABLE `curso` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `disciplinas`
--

DROP TABLE IF EXISTS `disciplinas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `disciplinas` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `disciplinas`
--

LOCK TABLES `disciplinas` WRITE;
/*!40000 ALTER TABLE `disciplinas` DISABLE KEYS */;
INSERT INTO `disciplinas` VALUES (1,'Matematica'),(2,'Portugues');
/*!40000 ALTER TABLE `disciplinas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `fornecedores`
--

DROP TABLE IF EXISTS `fornecedores`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `fornecedores` (
  `idforn` int(11) NOT NULL,
  `nome_razao` varchar(10) DEFAULT NULL,
  `CPF_CNPJ` varchar(20) DEFAULT NULL,
  `telefone` varchar(20) DEFAULT NULL,
  `celular` varchar(20) NOT NULL,
  `email` varchar(50) DEFAULT NULL,
  `endereco` varchar(10) DEFAULT NULL,
  `bairro` varchar(100) NOT NULL,
  `complemento` varchar(100) NOT NULL,
  `UF` varchar(10) NOT NULL,
  `cidade` varchar(10) NOT NULL,
  `CEP` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`idforn`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `fornecedores`
--

LOCK TABLES `fornecedores` WRITE;
/*!40000 ALTER TABLE `fornecedores` DISABLE KEYS */;
/*!40000 ALTER TABLE `fornecedores` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `funcionario`
--

DROP TABLE IF EXISTS `funcionario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `funcionario` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `nome` varchar(45) NOT NULL,
  `data` date DEFAULT NULL,
  `sexo` enum('F','M') DEFAULT NULL,
  `rg` bigint(20) NOT NULL,
  `prof` int(11) NOT NULL,
  `endereco` varchar(70) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `prof` (`prof`)
) ENGINE=MyISAM AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `funcionario`
--

LOCK TABLES `funcionario` WRITE;
/*!40000 ALTER TABLE `funcionario` DISABLE KEYS */;
INSERT INTO `funcionario` VALUES (1,'emilio','2009-09-08','M',243234,1,'Guara'),(2,'jose','2000-09-09','M',345345,2,'Sobradinho'),(3,'sdfsdfsd','2000-09-09','F',534534,1,'sdfsdfs');
/*!40000 ALTER TABLE `funcionario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `matricula`
--

DROP TABLE IF EXISTS `matricula`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `matricula` (
  `idmatricula` int(11) NOT NULL,
  `idaluno` int(11) NOT NULL,
  `nome_aluno` varchar(100) DEFAULT NULL,
  `idcurso` int(11) NOT NULL,
  `nome_curso` varchar(100) DEFAULT NULL,
  `data_matricula` date NOT NULL,
  `data_inicio` date NOT NULL,
  `data_final` date NOT NULL,
  `carga_horaria` varchar(100) DEFAULT NULL,
  `valor` decimal(10,2) DEFAULT NULL,
  `situacao` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`idmatricula`),
  KEY `idaluno` (`idaluno`),
  KEY `idcurso` (`idcurso`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `matricula`
--

LOCK TABLES `matricula` WRITE;
/*!40000 ALTER TABLE `matricula` DISABLE KEYS */;
/*!40000 ALTER TABLE `matricula` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pagamentos`
--

DROP TABLE IF EXISTS `pagamentos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pagamentos` (
  `idpgto` int(11) NOT NULL,
  `idmatricula` int(11) NOT NULL,
  `nome_aluno` varchar(100) NOT NULL,
  `Emissao` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `Vencimento` date NOT NULL,
  `descricao` varchar(100) NOT NULL,
  `parcelas` int(11) NOT NULL,
  `Valor` decimal(10,2) DEFAULT NULL,
  `desconto` decimal(10,2) DEFAULT NULL,
  `juros` decimal(10,2) DEFAULT NULL,
  `valor_parcela` decimal(10,2) DEFAULT NULL,
  `situacao` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`idpgto`),
  KEY `idmatricula` (`idmatricula`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pagamentos`
--

LOCK TABLES `pagamentos` WRITE;
/*!40000 ALTER TABLE `pagamentos` DISABLE KEYS */;
/*!40000 ALTER TABLE `pagamentos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `profissao`
--

DROP TABLE IF EXISTS `profissao`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `profissao` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(20) NOT NULL,
  `sal` float DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `profissao`
--

LOCK TABLES `profissao` WRITE;
/*!40000 ALTER TABLE `profissao` DISABLE KEYS */;
INSERT INTO `profissao` VALUES (1,'Zelador',1),(2,'Professor',3);
/*!40000 ALTER TABLE `profissao` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `turmas`
--

DROP TABLE IF EXISTS `turmas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `turmas` (
  `idturma` int(11) NOT NULL,
  `idmatricula` int(11) NOT NULL,
  `data_matricula` date NOT NULL,
  `idaluno` int(11) NOT NULL,
  `nome_aluno` varchar(100) NOT NULL,
  `idcurso` int(11) NOT NULL,
  `nome_curso` varchar(100) NOT NULL,
  `iddisc` int(11) NOT NULL,
  `iddisc1` int(11) NOT NULL,
  `iddisc2` int(11) NOT NULL,
  `iddisc3` int(11) NOT NULL,
  `iddisc4` int(11) NOT NULL,
  `iddisc5` int(11) NOT NULL,
  `Disciplina1` varchar(100) DEFAULT NULL,
  `Disciplina2` varchar(100) DEFAULT NULL,
  `Disciplina3` varchar(100) DEFAULT NULL,
  `Disciplina4` varchar(100) DEFAULT NULL,
  `Disciplina5` varchar(100) DEFAULT NULL,
  `horarios` varchar(100) DEFAULT NULL,
  `limitevagas` int(11) NOT NULL,
  PRIMARY KEY (`idturma`),
  KEY `idmatricula` (`idmatricula`),
  KEY `idaluno` (`idaluno`),
  KEY `idcurso` (`idcurso`),
  KEY `iddisc` (`iddisc`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `turmas`
--

LOCK TABLES `turmas` WRITE;
/*!40000 ALTER TABLE `turmas` DISABLE KEYS */;
/*!40000 ALTER TABLE `turmas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuario`
--

DROP TABLE IF EXISTS `usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `usuario` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `tipo` varchar(20) NOT NULL,
  `login` varchar(30) NOT NULL,
  `senha` varchar(30) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario`
--

LOCK TABLES `usuario` WRITE;
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
INSERT INTO `usuario` VALUES (1,'Professor','1','1234');
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-11-18 17:28:29
