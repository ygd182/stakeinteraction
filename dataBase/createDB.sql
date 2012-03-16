
delimiter $$

CREATE DATABASE `disenio_schema` /*!40100 DEFAULT CHARACTER SET latin1 */$$

delimiter $$

CREATE TABLE `cuentausuario` (
  `idCuentaUsuario` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) DEFAULT NULL,
  `contraseña` varchar(45) DEFAULT NULL,
  `idGrafo` int(11) DEFAULT NULL,
  `tipo` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idCuentaUsuario`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=latin1$$

delimiter $$


CREATE TABLE `informacion` (
  `idInformacion` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) DEFAULT NULL,
  `link` varchar(150) DEFAULT NULL,
  `tipo` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idInformacion`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=latin1$$

delimiter $$

CREATE TABLE `usuario` (
  `idInformacion` int(11) NOT NULL,
  `nombre` varchar(45) DEFAULT NULL,
  `apellido` varchar(45) DEFAULT NULL,
  `edad` varchar(45) DEFAULT NULL,
  `cargo` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idInformacion`),
  KEY `FK_idInformacion` (`idInformacion`),
  CONSTRAINT `FK_idInformacion` FOREIGN KEY (`idInformacion`) REFERENCES `informacion` (`idInformacion`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1$$

delimiter $$

CREATE TABLE `documento` (
  `idInformacion` int(11) NOT NULL,
  `cuerpo` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idInformacion`),
  KEY `FK_idInfo` (`idInformacion`),
  CONSTRAINT `FK_idInfo` FOREIGN KEY (`idInformacion`) REFERENCES `informacion` (`idInformacion`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1$$


delimiter $$
CREATE TABLE `nodo` (
  `idNodo` int(11) NOT NULL AUTO_INCREMENT,
  `idInformacion` int(11) DEFAULT '-1',
  `valido` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`idNodo`),
  KEY `FK_idInfoNodo` (`idInformacion`),
  CONSTRAINT `FK_idInfoNodo` FOREIGN KEY (`idInformacion`) REFERENCES `informacion` (`idInformacion`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=latin1$$

delimiter $$

CREATE TABLE `nododeusuario` (
  `idGrafo` int(11) NOT NULL,
  `idNodo` int(11) NOT NULL,
  PRIMARY KEY (`idGrafo`,`idNodo`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1$$

CREATE TABLE `arco` (
  `idArco` int(11) NOT NULL AUTO_INCREMENT,
  `idNodo` int(11) DEFAULT NULL,
  `idNodoVecino` int(11) DEFAULT NULL,
  `valido` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`idArco`),
  KEY `FK_idNodo` (`idNodo`),
  KEY `FK_idNodoVecino` (`idNodoVecino`),
  CONSTRAINT `FK_idNodo` FOREIGN KEY (`idNodo`) REFERENCES `nodo` (`idNodo`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_idNodoVecino` FOREIGN KEY (`idNodoVecino`) REFERENCES `nodo` (`idNodo`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=latin1$$

delimiter $$

CREATE TABLE `arcodeusuario` (
  `idgrafo` int(11) NOT NULL,
  `idarco` int(11) NOT NULL,
  PRIMARY KEY (`idgrafo`,`idarco`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1$$

delimiter $$







