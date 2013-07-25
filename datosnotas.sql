-- phpMyAdmin SQL Dump
-- version 3.5.8.1deb1
-- http://www.phpmyadmin.net
--
-- Servidor: localhost
-- Tiempo de generación: 24-07-2013 a las 02:56:47
-- Versión del servidor: 5.5.31-0ubuntu0.13.04.1
-- Versión de PHP: 5.4.9-4ubuntu2.2

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de datos: `datosnotas`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `Alumno`
--

CREATE TABLE IF NOT EXISTS `Alumno` (
  `idAlumno` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idAlumno`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=12 ;

--
-- Volcado de datos para la tabla `Alumno`
--

INSERT INTO `Alumno` (`idAlumno`, `nombre`) VALUES
(1, 'Ricardo Arana Reyes Guerrero'),
(2, 'Miguel Gomez Erazo'),
(3, 'Rocio Bonifaz Cuenca'),
(4, 'Pablo Perez Palacios'),
(5, 'Carlos Cornejo Caballero'),
(9, 'Alonso Eyzaguirre Castillo'),
(10, 'Jorge Herrera Lucana'),
(11, 'Jose Tuncar Rayo');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `Curso`
--

CREATE TABLE IF NOT EXISTS `Curso` (
  `idCurso` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idCurso`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=4 ;

--
-- Volcado de datos para la tabla `Curso`
--

INSERT INTO `Curso` (`idCurso`, `nombre`) VALUES
(1, 'Fisica'),
(2, 'Lenguaje de Programación'),
(3, 'Matematica 5');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `nota`
--

CREATE TABLE IF NOT EXISTS `nota` (
  `idnota` int(11) NOT NULL AUTO_INCREMENT,
  `parcial` int(11) DEFAULT NULL,
  `final` int(11) DEFAULT NULL,
  `Alumno_idAlumno` int(11) NOT NULL,
  `Curso_idCurso` int(11) NOT NULL,
  PRIMARY KEY (`idnota`,`Alumno_idAlumno`,`Curso_idCurso`),
  KEY `fk_nota_Alumno` (`Alumno_idAlumno`),
  KEY `fk_nota_Curso1` (`Curso_idCurso`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=10 ;

--
-- Volcado de datos para la tabla `nota`
--

INSERT INTO `nota` (`idnota`, `parcial`, `final`, `Alumno_idAlumno`, `Curso_idCurso`) VALUES
(2, 8, 13, 5, 2),
(5, 0, 0, 9, 1),
(6, 11, 9, 9, 3),
(7, 14, 16, 10, 2),
(8, 9, 16, 10, 3),
(9, 15, 11, 11, 1);

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `nota`
--
ALTER TABLE `nota`
  ADD CONSTRAINT `fk_nota_Alumno` FOREIGN KEY (`Alumno_idAlumno`) REFERENCES `Alumno` (`idAlumno`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_nota_Curso1` FOREIGN KEY (`Curso_idCurso`) REFERENCES `Curso` (`idCurso`) ON DELETE NO ACTION ON UPDATE NO ACTION;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
