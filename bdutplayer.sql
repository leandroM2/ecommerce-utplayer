-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 05-10-2022 a las 01:13:12
-- Versión del servidor: 10.4.24-MariaDB
-- Versión de PHP: 8.1.6

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `bdutplayer`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `boleta`
--

CREATE TABLE `boleta` (
  `emp_RUC` varchar(11) CHARACTER SET ucs2 COLLATE ucs2_spanish_ci NOT NULL,
  `id_boleta` int(11) NOT NULL,
  `bol_fecha` varchar(255) COLLATE utf8_spanish_ci NOT NULL,
  `bol_metododepago` varchar(255) COLLATE utf8_spanish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `boleta`
--

INSERT INTO `boleta` (`emp_RUC`, `id_boleta`, `bol_fecha`, `bol_metododepago`) VALUES
('12876549354', 5, '2021-09-29', 'VISA'),
('12876549354', 6, '2021-10-07', 'EFECTIVO'),
('12876549354', 7, '2021-10-21 02:45:48', 'EFECTIVO'),
('12876549354', 8, '2021-10-21 02:55:25', 'EFECTIVO'),
('12876549354', 10, '2021-10-21 03:06:29', 'EFECTIVO'),
('12876549354', 11, '2021-10-21 03:26:17', 'EFECTIVO'),
('12876549354', 12, '2021-10-21 03:29:28', 'EFECTIVO'),
('12876549354', 16, '2021-10-21 15:44:51', 'EFECTIVO'),
('12876549354', 17, '2021-10-21 15:44:59', 'EFECTIVO'),
('12876549354', 19, '2021-10-21 15:48:10', 'EFECTIVO'),
('12876549354', 20, '2021-10-21 15:48:44', 'EFECTIVO'),
('12876549354', 21, '2021-10-21 15:49:56', 'EFECTIVO'),
('12876549354', 22, '2021-10-21 15:50:10', 'EFECTIVO'),
('12876549354', 23, '2021-10-21 15:54:48', 'EFECTIVO'),
('12876549354', 24, '2021-10-21 15:55:39', 'EFECTIVO'),
('12876549354', 25, '2021-10-21 15:55:48', 'EFECTIVO'),
('12876549354', 26, '2021-10-21 15:56:44', 'EFECTIVO'),
('12876549354', 27, '2021-10-21 15:56:54', 'EFECTIVO'),
('12876549354', 28, '2021-10-21 15:57:01', 'EFECTIVO'),
('12876549354', 29, '2021-10-21 15:57:37', 'EFECTIVO'),
('12876549354', 30, '2021-10-21 15:57:44', 'EFECTIVO'),
('12876549354', 31, '2021-10-21 15:58:06', 'EFECTIVO'),
('12876549354', 32, '2021-10-21 15:58:16', 'EFECTIVO'),
('12876549354', 33, '2021-10-21 16:00:59', 'EFECTIVO'),
('12876549354', 34, '2021-10-21 16:01:09', 'EFECTIVO'),
('12876549354', 35, '2021-10-21 16:01:40', 'EFECTIVO'),
('12876549354', 36, '2021-10-21 16:01:51', 'EFECTIVO'),
('12876549354', 37, '2021-10-21 16:23:38', 'EFECTIVO'),
('12876549354', 38, '2021-10-21 16:23:57', 'EFECTIVO'),
('12876549354', 39, '2021-10-21 16:26:12', 'EFECTIVO'),
('12876549354', 40, '2021-10-21 16:27:44', 'EFECTIVO'),
('12876549354', 41, '2021-10-21 16:28:03', 'EFECTIVO'),
('12876549354', 42, '2021-10-21 16:28:17', 'EFECTIVO'),
('12876549354', 43, '2021-10-21 16:28:35', 'EFECTIVO'),
('12876549354', 44, '2021-10-21 16:29:56', 'EFECTIVO'),
('12876549354', 45, '2021-10-21 16:30:04', 'EFECTIVO'),
('12876549354', 46, '2021-10-21 16:30:15', 'EFECTIVO'),
('12876549354', 47, '2021-10-21 16:30:55', 'EFECTIVO'),
('12876549354', 48, '2021-10-21 16:33:50', 'EFECTIVO'),
('12876549354', 49, '2021-10-21 16:37:11', 'EFECTIVO'),
('12876549354', 50, '2021-10-21 16:38:17', 'EFECTIVO'),
('12876549354', 51, '2021-10-21 16:39:29', 'EFECTIVO'),
('12876549354', 52, '2021-10-21 16:39:47', 'EFECTIVO'),
('12876549354', 53, '2021-10-21 16:41:04', 'EFECTIVO'),
('12876549354', 54, '2021-10-21 16:41:24', 'EFECTIVO'),
('12876549354', 55, '2021-10-21 17:21:06', 'EFECTIVO'),
('12876549354', 56, '2021-10-21 17:43:32', 'EFECTIVO'),
('12876549354', 57, '2021-10-21 17:44:58', 'EFECTIVO'),
('12876549354', 58, '2021-10-21 17:52:41', 'EFECTIVO'),
('12876549354', 59, '2021-10-21 19:23:28', 'EFECTIVO'),
('12876549354', 60, '2021-10-21 19:47:03', 'EFECTIVO'),
('12876549354', 70, 'Fri Dec 10 05:42:53 COT 2021', 'DEBITO');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `comics`
--

CREATE TABLE `comics` (
  `id` int(11) NOT NULL,
  `nombre` varchar(255) COLLATE utf8_spanish_ci NOT NULL,
  `precio` decimal(10,2) NOT NULL,
  `editorial` varchar(255) COLLATE utf8_spanish_ci NOT NULL,
  `categoria` varchar(255) COLLATE utf8_spanish_ci NOT NULL,
  `stock` int(11) NOT NULL,
  `imagen` varchar(255) COLLATE utf8_spanish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `comics`
--

INSERT INTO `comics` (`id`, `nombre`, `precio`, `editorial`, `categoria`, `stock`, `imagen`) VALUES
(1, 'CA: CIVIL WAR I-VI', '70.00', 'MARVEL', 'SUPERHEROES', 40, 'CW.jpg'),
(2, 'HELLBOY 2', '55.00', 'DARK HORSE', 'ACCION', 15, 'HB.jpg'),
(3, 'BATMAN: HUSH', '59.00', 'DC', 'SUPERHEROES', 100, 'BMH.jpg'),
(4, 'THE WALKING DEAD Vol. 1', '59.00', 'SKYBOUND', 'GORE', 65, 'TWD.jpg'),
(6, 'ESPÍRITU DE LA VERDAD', '79.00', 'DC', 'SUPERHEROES', 40, 'WW.jpg'),
(7, 'FLASHPOINT', '35.00', 'DC', 'SUPERHEROES', 100, 'FP.jpg'),
(8, 'SUPERMAN: RED SON', '26.00', 'DC', 'SUPERHEROES', 25, 'SM.jpg'),
(10, 'WATCHMEN', '120.00', 'DARK HORSE', 'DRAMA', 10, 'WATCH.jpg'),
(11, 'SANDMAN', '55.00', 'VERTIGO', 'DRAMA', 40, 'SAND.jpg'),
(32, 'HAWKEYE', '70.00', 'MARVEL', 'SUPERHEROES', 50, 'COMIC.JPG'),
(33, 'work', '100.00', 'work', 'work', 99, 'work.jpg'),
(34, 'work', '100.00', 'work', 'work', 99, 'work.jpg');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `det_boleta`
--

CREATE TABLE `det_boleta` (
  `IdDetalle` int(11) NOT NULL,
  `ID_producto` int(11) NOT NULL,
  `ID_boleta` int(11) NOT NULL,
  `det_cantidad` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf16 COLLATE=utf16_spanish_ci;

--
-- Volcado de datos para la tabla `det_boleta`
--

INSERT INTO `det_boleta` (`IdDetalle`, `ID_producto`, `ID_boleta`, `det_cantidad`) VALUES
(13, 1, 5, 10),
(14, 20, 5, 15),
(15, 3, 6, 8),
(16, 17, 6, 6),
(17, 20, 7, 2),
(18, 1, 8, 1),
(20, 1, 10, 1),
(21, 3, 11, 10),
(22, 31, 12, 4),
(25, 1, 16, 1),
(26, 2, 17, 5),
(28, 1, 19, 1),
(29, 1, 20, 1),
(30, 1, 21, 1),
(31, 1, 22, 1),
(32, 1, 23, 1),
(33, 1, 24, 1),
(34, 1, 25, 1),
(35, 1, 26, 1),
(36, 1, 27, 1),
(37, 1, 28, 1),
(38, 1, 29, 1),
(39, 2, 30, 2),
(40, 1, 31, 1),
(41, 1, 32, 1),
(42, 1, 33, 1),
(43, 1, 34, 1),
(44, 1, 35, 1),
(45, 1, 36, 1),
(46, 1, 37, 1),
(47, 1, 38, 1),
(48, 1, 39, 1),
(49, 1, 40, 1),
(50, 1, 41, 1),
(51, 1, 42, 1),
(52, 1, 43, 1),
(53, 1, 44, 1),
(54, 1, 45, 1),
(55, 1, 46, 1),
(56, 1, 47, 1),
(57, 1, 48, 1),
(58, 1, 49, 1),
(59, 1, 50, 1),
(60, 1, 51, 1),
(61, 1, 52, 1),
(62, 1, 53, 1),
(63, 38, 54, 4),
(64, 1, 55, 1),
(65, 1, 56, 1),
(66, 1, 57, 1),
(67, 1, 58, 1),
(68, 1, 59, 1),
(69, 1, 60, 10);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `empresa`
--

CREATE TABLE `empresa` (
  `emp_RUC` varchar(11) COLLATE ucs2_spanish_ci NOT NULL,
  `emp_direccion` varchar(50) COLLATE ucs2_spanish_ci NOT NULL,
  `emp_contacto` varchar(9) COLLATE ucs2_spanish_ci NOT NULL,
  `emp_correo` varchar(50) COLLATE ucs2_spanish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=ucs2 COLLATE=ucs2_spanish_ci;

--
-- Volcado de datos para la tabla `empresa`
--

INSERT INTO `empresa` (`emp_RUC`, `emp_direccion`, `emp_contacto`, `emp_correo`) VALUES
('12876549354', 'mz1 lt3 barrio los geraneos', '935798264', 'utPlayer@gmail.com');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `figuras`
--

CREATE TABLE `figuras` (
  `id` int(11) NOT NULL,
  `nombre` varchar(255) COLLATE utf8_spanish_ci NOT NULL,
  `precio` decimal(10,2) NOT NULL,
  `marca` varchar(255) COLLATE utf8_spanish_ci NOT NULL,
  `categoria` varchar(255) COLLATE utf8_spanish_ci NOT NULL,
  `stock` int(11) NOT NULL,
  `imagen` varchar(255) COLLATE utf8_spanish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `figuras`
--

INSERT INTO `figuras` (`id`, `nombre`, `precio`, `marca`, `categoria`, `stock`, `imagen`) VALUES
(1, 'FIGURA DE BO-KATAN KRYZE', '120.00', 'HASBRO', 'THE BLACK SERIES', 50, 'BOKATAN.jpg'),
(2, 'FIGURA DE JOHNNY SILVERHAND', '500.00', 'HOT-TOYS CO.', 'HOTTOYS', 5, 'SILVER.jpg'),
(3, 'FIGURA DE GOKU SSJ 2', '69.00', 'FUNKO', 'FUNKO. POP!', 30, 'GOKU.jpg'),
(4, 'FIGURA DE \"EL MAESTRO\" ', '99.00', 'HASBRO', 'MARVEL LEGENDS', 25, 'HULK.jpg'),
(5, 'FIGURA DE JACK SPARROW', '450.00', 'HOT-TOYS CO.', 'HOTTOYS', 40, 'JACK.jpg'),
(6, 'FIGURA DE OBI WAN KENOBI', '79.00', 'HASBRO', 'THE BLACK SERIES', 20, 'OBIWAN.jpg'),
(7, 'FIGURA DE DARKSEID', '99.00', 'FUNKO', 'FUNKO. POP!', 30, 'DARK.jpg'),
(8, 'FIGURA DE BLACK WIDOW', '85.00', 'HASBRO', 'MARVEL LEGENDS', 70, 'BLACKW.jpg');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `mangas`
--

CREATE TABLE `mangas` (
  `id` int(11) NOT NULL,
  `nombre` varchar(255) COLLATE utf8_spanish_ci NOT NULL,
  `precio` decimal(10,2) NOT NULL,
  `publisher` varchar(255) COLLATE utf8_spanish_ci NOT NULL,
  `categoria` varchar(255) COLLATE utf8_spanish_ci NOT NULL,
  `stock` int(11) NOT NULL,
  `imagen` varchar(255) COLLATE utf8_spanish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `mangas`
--

INSERT INTO `mangas` (`id`, `nombre`, `precio`, `publisher`, `categoria`, `stock`, `imagen`) VALUES
(1, 'CITY HUNTER', '39.00', 'SHUEISHA', 'SHONEN', 45, 'CITYHUNTER.jpg'),
(2, 'KATEKYO HITMAN REBORN!', '49.00', 'SHUKAN JUMP', 'SHONEN', 15, 'REBORN.jpg'),
(3, 'BERSERK', '99.00', 'HAKESUNSHA', 'SEINEN', 100, 'BERSERK.jpg'),
(4, 'SLAM DUNK', '20.00', 'TOEI', 'DEPORTE', 35, 'SLAM.jpg'),
(5, 'GOBLIN SLAYER', '40.00', 'BIG GANGAN', 'GORE', 120, 'GOBLIN.jpg'),
(6, 'FULL METAL ALCHEMIST', '79.00', 'BIG GANGAN', 'STEAMPUNK', 50, 'FULLMETAL.jpg');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `producto`
--

CREATE TABLE `producto` (
  `id` int(11) NOT NULL,
  `nombre` varchar(255) COLLATE utf8_spanish_ci NOT NULL,
  `precio` decimal(10,2) NOT NULL,
  `plataforma` varchar(255) COLLATE utf8_spanish_ci NOT NULL,
  `categoria` varchar(255) COLLATE utf8_spanish_ci NOT NULL,
  `stock` int(11) NOT NULL,
  `imagen` varchar(225) COLLATE utf8_spanish_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `producto`
--

INSERT INTO `producto` (`id`, `nombre`, `precio`, `plataforma`, `categoria`, `stock`, `imagen`) VALUES
(1, 'GOD OF WAR 2018', '59.00', 'PS4', 'DIGITAL', 100, 'GOW.jpg'),
(2, 'ZELDA: BREATH OF THE WILD', '45.00', 'NINTENDO SWITCH', 'DIGITAL', 43, 'BTOW.jpg'),
(3, 'FIFA 21', '59.00', 'PS5', 'DIGITAL', 35, 'fifa.png'),
(17, 'HALO INFINITE', '39.00', 'XBOX S|X', 'DIGITAL', 25, 'Halo I.jpg'),
(18, 'UNCHARTED 4', '89.00', 'PS4', 'FISICO', 40, 'UNCHAR.jpg'),
(19, 'RESIDENT EVIL 4: REMASTER', '59.00', 'XBOX S|X', 'DIGITAL', 100, 'RE4.jpg'),
(20, 'PES 2018', '60.00', 'XBOX 360', 'DIGITAL', 14, 'PES.jpg'),
(21, 'FAR CRY 4', '70.00', 'PS4', 'FISICO', 50, 'FC4.jpg'),
(22, 'THE TOMB RIDER', '75.00', 'XBOX ONE', 'DIGITAL', 10, 'TOMB.jpg'),
(23, 'SPIDERMAN MILES MORALES', '100.00', 'PS5', 'DIGITAL', 15, 'MORALES.jpg'),
(24, 'TES V: SKYRIM', '99.00', 'NINTENDO SWITCH', 'FISICO', 30, 'SKYRIM.jpg'),
(25, 'ASSASSINS CREED ODYSEEY', '89.00', 'XBOX ONE', 'DIGITAL', 10, 'ODI.jpg'),
(26, 'CYBERPUNK 2077', '150.00', 'PC', 'FISICO', 20, 'CP2077.jpg'),
(28, 'PERSONA 5', '110.00', 'PS4', 'FISICO', 60, 'persona5.jpg'),
(29, 'HORION ZERO DAWN', '120.00', 'PS4', 'FISICO', 25, 'Horizon.jpg'),
(30, 'MORTAK KOMBAT 11', '130.00', 'PS4', 'FISICO', 70, 'MK11.jpg'),
(31, 'MAD MAX', '75.00', 'PS4', 'FISICO', 36, 'MADMAX.jpg'),
(32, 'STAR WARS JEDI FALLEN ORDER', '120.00', 'PS4', 'FISICO', 30, 'JEDI.jpg'),
(33, 'SEKIRO SHADOWS DIE TWICE', '99.00', 'PS4', 'FISICO', 55, 'SEKIRO.png'),
(34, 'GRAND THEFT AUTO V', '60.00', 'PS3', 'FISICO', 20, 'GTA5.jpg'),
(35, 'DOOM ETERNAL', '99.00', 'PS5', 'FISICO', 70, 'DOOM.jpg'),
(36, 'SPIDERMAN PS4', '100.00', 'PS4', 'FISICO', 60, 'SPIDER.jpg'),
(37, 'MAFIA 3', '60.00', 'PC', 'DIGITAL', 20, 'RE4.jpg'),
(38, 'UNCHARTED 4', '45.00', 'PS5', 'DIGITAL', 8, 'UNCHAR.jpg');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `ropa`
--

CREATE TABLE `ropa` (
  `id` int(11) NOT NULL,
  `nombre` varchar(255) COLLATE utf8_spanish_ci NOT NULL,
  `precio` decimal(10,0) NOT NULL,
  `talla` varchar(3) COLLATE utf8_spanish_ci NOT NULL,
  `categoria` varchar(255) COLLATE utf8_spanish_ci NOT NULL,
  `stock` int(11) NOT NULL,
  `imagen` varchar(255) COLLATE utf8_spanish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `ropa`
--

INSERT INTO `ropa` (`id`, `nombre`, `precio`, `talla`, `categoria`, `stock`, `imagen`) VALUES
(1, 'CAMISETA HOKAGUE NARUTO', '65', 'L', 'CAMISETA', 20, 'HOKANARUTO.jpg'),
(2, 'ALAS DE LA LIBERTAD', '150', 'XL', 'ABRIGO', 30, 'AOT.jpg'),
(3, 'GORRO CAPITAN AMERICA', '20', 'L', 'GORRA', 120, 'GORROCAP.jpg'),
(4, 'SUETER BATMAN ARKHAM', '80', 'M', 'ABRIGO', 65, 'ABRIGOBAT.jpg'),
(5, 'POLERA ASSASSINS CREED', '100', 'S', 'ABRIGO', 25, 'ABRIGOAC.jpg'),
(6, 'CAMISETA WONDER WOMAN', '60', 'M', 'CAMISETA', 25, 'WWCAMISETA.jpg');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuarios`
--

CREATE TABLE `usuarios` (
  `id` int(11) NOT NULL,
  `clave` blob NOT NULL,
  `ape` varchar(255) COLLATE utf8_spanish_ci NOT NULL,
  `correo` varchar(255) COLLATE utf8_spanish_ci NOT NULL,
  `tipo` varchar(255) COLLATE utf8_spanish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `usuarios`
--

INSERT INTO `usuarios` (`id`, `clave`, `ape`, `correo`, `tipo`) VALUES
(1, 0x4c13aa557f777fed6673338eee1e4ec6, 'GONZALES', 'arturo@utp.com', 'ADMIN'),
(2, 0x5943994674ac996cca4c9636cb61d807, 'ALVAREZ', 'diego@utp.com', 'ADMIN'),
(3, 0xb703c769404cd94d28a10cdec7558ec6, 'PERALES', 'rosa@utp.com', 'CLIENT'),
(4, 0xa3b420ab7068f346dfeea1dffa1b5535, 'MOREALES', 'prueba@utp.com', 'CLIENT'),
(5, 0x4c13aa557f777fed6673338eee1e4ec6, 'GUERRERO', 'prueba2@utp.com', 'ADMIN'),
(6, 0x501defc4013f3f21529c123f33c065ad, 'MAYURI', 'mayuri@utp.com', 'ADMIN');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `boleta`
--
ALTER TABLE `boleta`
  ADD PRIMARY KEY (`id_boleta`),
  ADD KEY `emp_RUC` (`emp_RUC`);

--
-- Indices de la tabla `comics`
--
ALTER TABLE `comics`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `det_boleta`
--
ALTER TABLE `det_boleta`
  ADD PRIMARY KEY (`IdDetalle`),
  ADD KEY `ID_producto` (`ID_producto`),
  ADD KEY `ID_boleta` (`ID_boleta`);

--
-- Indices de la tabla `empresa`
--
ALTER TABLE `empresa`
  ADD PRIMARY KEY (`emp_RUC`);

--
-- Indices de la tabla `figuras`
--
ALTER TABLE `figuras`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `mangas`
--
ALTER TABLE `mangas`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `producto`
--
ALTER TABLE `producto`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `ropa`
--
ALTER TABLE `ropa`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `usuarios`
--
ALTER TABLE `usuarios`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `boleta`
--
ALTER TABLE `boleta`
  MODIFY `id_boleta` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=71;

--
-- AUTO_INCREMENT de la tabla `comics`
--
ALTER TABLE `comics`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=35;

--
-- AUTO_INCREMENT de la tabla `det_boleta`
--
ALTER TABLE `det_boleta`
  MODIFY `IdDetalle` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=70;

--
-- AUTO_INCREMENT de la tabla `figuras`
--
ALTER TABLE `figuras`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT de la tabla `mangas`
--
ALTER TABLE `mangas`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT de la tabla `producto`
--
ALTER TABLE `producto`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=39;

--
-- AUTO_INCREMENT de la tabla `ropa`
--
ALTER TABLE `ropa`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT de la tabla `usuarios`
--
ALTER TABLE `usuarios`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `boleta`
--
ALTER TABLE `boleta`
  ADD CONSTRAINT `boleta_ibfk_1` FOREIGN KEY (`emp_RUC`) REFERENCES `empresa` (`emp_RUC`);

--
-- Filtros para la tabla `det_boleta`
--
ALTER TABLE `det_boleta`
  ADD CONSTRAINT `det_boleta_ibfk_1` FOREIGN KEY (`ID_producto`) REFERENCES `producto` (`id`),
  ADD CONSTRAINT `det_boleta_ibfk_2` FOREIGN KEY (`ID_boleta`) REFERENCES `boleta` (`id_boleta`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
