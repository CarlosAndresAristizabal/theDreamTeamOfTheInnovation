-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 04-05-2023 a las 00:53:38
-- Versión del servidor: 10.4.28-MariaDB
-- Versión de PHP: 8.2.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `registroinvestigadores`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `autor`
--

CREATE TABLE `autor` (
  `Id` varchar(20) NOT NULL,
  `Nombre` varchar(50) NOT NULL,
  `Afiliacion` varchar(100) NOT NULL,
  `Web` varchar(100) NOT NULL,
  `ArticulosDisponibles` int(255) NOT NULL,
  `ArticulosNoDisponibles` int(255) NOT NULL,
  `TotalArticulos` int(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `autor`
--

INSERT INTO `autor` (`Id`, `Nombre`, `Afiliacion`, `Web`, `ArticulosDisponibles`, `ArticulosNoDisponibles`, `TotalArticulos`) VALUES
('EicYvbwAAAAJ', 'Ronald C Kessler', 'McNeil Family Professor of Health Care Policy, Harvard Medical School', 'https://scholar.harvard.edu/rckessler', 556, 27, 583),
('NM21Mt8AAAAJ', 'Juan Suarez Gonzalez', 'Research Institute for Nuclear Problems of The Belarusian State University', 'http://example.edu/~SuarezGonzalez_Juan', 684, 1, 685),
('jB7gVJAAAAAJ', 'Carlo Dallapiccola', 'Professor of Physics, University of Massachusetts - Amherst', '0', 1307, 0, 1307),
('2SF6AXQAAAAJ', 'Carlo Croce', 'Professor, Ohio State University', '0', 396, 17, 413),
('dL9XOygAAAAJ', 'Steve C R Williams', 'Institute of Psychiatry, King\'s College London', '0', 228, 15, 243),
('ZrzFgFgAAAAJ', 'Rober Martinez-Espineira', 'Memorial University of Newfoundland', 'http://www.ucs.mun.ca/~rmartinezesp/', 7, 3, 10),
('f4KlrXIAAAAJ', 'Lei(Layla) Li', 'Duke University, CERN', '0', 1326, 39, 1365),
('HQv0p0kAAAAJ', 'Heng Li', 'Dana-Farber Cancer Institute & Harvard University', 'http://liheng.org/', 74, 0, 74),
('C7cbc0EAAAAJ', 'Wei Li', 'Rice University', 'http://lilab.rice.edu/', 540, 0, 540),
('nzRMMAUAAAAJ', 'Bin Li，李斌', 'Professor of food science, Huazhong Agriculture University', '0', 337, 453, 790),
('IfxP1QQAAAAJ', 'Zhen Li', 'Student, University of Glasgow', '0', 594, 470, 1064);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
