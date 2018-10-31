-- phpMyAdmin SQL Dump
-- version 4.8.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Oct 26, 2018 at 01:21 PM
-- Server version: 10.1.31-MariaDB
-- PHP Version: 7.2.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `musictimeline`
--

-- --------------------------------------------------------

--
-- Table structure for table `artist`
--

CREATE TABLE `artist` (
  `idArtist` int(11) NOT NULL,
  `name` varchar(256) NOT NULL,
  `country` varchar(4) DEFAULT NULL,
  `type` varchar(5) DEFAULT NULL COMMENT 'solo or group',
  `image` varchar(256) DEFAULT NULL,
  `idUser` int(11) DEFAULT NULL COMMENT 'Foreign_Key'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `artist`
--

INSERT INTO `artist` (`idArtist`, `name`, `country`, `type`, `image`, `idUser`) VALUES
(1, 'George Michael', 'uk', 'solo', 'George-Michael.jpg', NULL),
(2, 'Avenged Sevenfold', 'usa', 'group', 'Avenged-Sevenfold.jpg', NULL),
(3, 'Pharrell Williams', 'usa', 'solo', 'Pharrell-Williams.jpg', NULL),
(4, 'Katy Perry', 'usa', 'solo', 'Katy-Perry.jpg', NULL),
(5, 'Adele', 'uk', 'solo', 'Adele.jpg', NULL),
(6, 'Ed Sheeran', 'uk', 'solo', 'Ed-Sheeran.jpg', NULL),
(7, 'Luis Fonsi', 'pri', 'solo', 'Luis-Fonsi.jpg', NULL),
(8, 'Linkin Park', 'usa', 'group', 'Linkin-Park.jpg', NULL),
(9, 'Nicole Cross', 'dd', 'solo', NULL, NULL),
(10, 'Leroy Sanchez', 'usa', 'solo', NULL, NULL),
(11, 'Conkarah', 'sol', 'solo', NULL, NULL),
(12, 'Leo Moracchioli', 'no', 'solo', NULL, NULL),
(13, 'Boyce Avenue', 'usa', 'group', NULL, NULL),
(14, 'J.Fla', 'kr', 'solo', NULL, NULL),
(15, 'Xplore Yesterday', 'fr', 'group', 'Xplore-Yesterday.jpg', NULL),
(16, 'Foo Fighters', 'usa', 'group', 'Foo-Fighters.jpg', NULL),
(17, 'Imagine Dragons', 'usa', 'group', 'Imagine-Dragons.jpg', NULL),
(18, 'Our Last Night', 'usa', 'group', 'Our-Last-Night.jpg', NULL),
(19, 'Madilyn Bailey', 'usa', 'solo', 'Madilyn-Bailey.jpg', NULL),
(21, 'aaa@gmail.com', NULL, NULL, NULL, 18),
(22, 'utente@gmail.com', NULL, NULL, NULL, 22);

-- --------------------------------------------------------

--
-- Table structure for table `chart`
--

CREATE TABLE `chart` (
  `idChart` int(11) NOT NULL,
  `nameChart` varchar(256) NOT NULL,
  `link` varchar(256) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `chart`
--

INSERT INTO `chart` (`idChart`, `nameChart`, `link`) VALUES
(1, 'Billboard Hot 100 number-one singles of 2015', 'https://en.wikipedia.org/wiki/List_of_Billboard_Hot_100_number-one_singles_of_2015'),
(2, 'Billboard Hot 100 number-one singles of 2016', 'https://en.wikipedia.org/wiki/List_of_Billboard_Hot_100_number-one_singles_of_2016'),
(3, 'Billboard Hot 100 number-one singles of 2017', 'https://en.wikipedia.org/wiki/List_of_Billboard_Hot_100_number-one_singles_of_2017'),
(4, 'Billboard Rock Digital Song Sales', 'https://www.billboard.com/charts/rock-digital-song-sales/2017-08-12'),
(5, 'Billboard Mainstream Rock Songs', 'https://www.billboard.com/charts/hot-mainstream-rock-tracks/2014-06-21'),
(6, 'Billboard Digital Song Sales', 'https://www.billboard.com/charts/digital-song-sales/2014-03-01'),
(7, 'Billboard Hot Rock Songs', 'https://www.billboard.com/charts/rock-songs');

-- --------------------------------------------------------

--
-- Table structure for table `genre`
--

CREATE TABLE `genre` (
  `nameGenre` varchar(50) NOT NULL,
  `description` varchar(2000) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `genre`
--

INSERT INTO `genre` (`nameGenre`, `description`) VALUES
('FUNK', 'Funk is a music genre that originated in African American communities in the mid-1960s when African American musicians created a rhythmic, danceable new form of music through a mixture of soul music, jazz, and rhythm and blues (R&B). '),
('HARDCORE', 'Hardcore punk (often abbreviated to hardcore) is a punk rock music genre and subculture that originated in the late 1970s. It is generally faster, harder, and more aggressive than other forms of punk rock.'),
('LATINO', 'Latin American music encompasses a wide variety of styles, including influential genres such as bachata, bossa nova, merengue, rumba, salsa, samba, son, and tango. During the 20th century, many styles were influenced by the music of the United States giving rise to genres such as Latin pop, rock, jazz, hip hop, and reggaeton.'),
('METAL', 'Heavy metal (or simply metal) is a genre of rock music that developed in the late 1960s and early 1970s, largely in the United Kingdom. The bands that created heavy metal developed a thick, massive sound, characterized by highly amplified distortion, extended guitar solos, emphatic beats, and overall loudness. '),
('POP', 'Pop music is a genre of popular music that originated in its modern form in the United States and United Kingdom during the mid-1950s.The terms \"popular music\" and \"pop music\" are often used interchangeably, although the former describes all music that is popular and includes many different styles. \"Pop\" and \"rock\" were roughly synonymous terms until the late 1960s, when they became increasingly differentiated from each other.'),
('REGGAE', 'Reggae is a music genre that originated in Jamaica in the late 1960s. The term also denotes the modern popular music of Jamaica and its diaspora.'),
('ROCK', 'Rock music is a broad genre of popular music that originated as \"rock and roll\" in the United States in the early 1950s, and developed into a range of different styles in the 1960s and later, particularly in the United Kingdom and in the United States.'),
('TRAP', 'Trap is a style of popular music that developed in the late 1990s to early 2000s from Southern hip hop in the United States. It is typified by double or triple-time sub-divided hi-hats, heavy, sub-bass layered kick drums from the Roland TR-808 drum machine, layered synthesizers and an overall dark, ominous or bleak atmosphere. The term \"trap\" referred to places where drug deals take place.');

-- --------------------------------------------------------

--
-- Table structure for table `media`
--

CREATE TABLE `media` (
  `idMedia` int(11) NOT NULL,
  `type` varchar(5) NOT NULL DEFAULT 'video' COMMENT 'audio or video',
  `serviceSrc` varchar(256) NOT NULL DEFAULT 'YouTube',
  `uri` varchar(256) NOT NULL,
  `validityCheck` tinyint(1) NOT NULL DEFAULT '1',
  `quality` varchar(20) DEFAULT NULL,
  `format` varchar(20) DEFAULT NULL,
  `live` tinyint(1) NOT NULL DEFAULT '0',
  `idSingle` int(11) NOT NULL COMMENT 'Foreign_Key'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `media`
--

INSERT INTO `media` (`idMedia`, `type`, `serviceSrc`, `uri`, `validityCheck`, `quality`, `format`, `live`, `idSingle`) VALUES
(1, 'video', 'YouTube', 'Jgk3u44W2i4', 1, '1080p', NULL, 0, 1),
(2, 'video', 'YouTube', 'y6Sxv-sUYtM', 1, '1080p', NULL, 0, 2),
(3, 'video', 'YouTube', '0KSOMA3QBU0', 1, '1080p', NULL, 0, 3),
(4, 'video', 'YouTube', 'YQHsXMglC9A', 1, '1080p', NULL, 0, 4),
(5, 'video', 'YouTube', 'JGwWNGJdvx8', 1, '2160p', NULL, 0, 7),
(6, 'video', 'YouTube', 'kJQP7kiw5Fk', 1, '1080p', NULL, 0, 8),
(7, 'video', 'YouTube', '9sCnUSqcNU8', 1, '2160p', NULL, 1, 9),
(8, 'video', 'YouTube', '_t1gfn9aqiQ', 1, '1080p', NULL, 0, 10),
(9, 'video', 'YouTube', 'vlZ9kjCrGJw', 1, '1080p', NULL, 0, 11),
(10, 'video', 'YouTube', 'LtQUJMBH8uE', 1, '1080p', NULL, 0, 13),
(11, 'video', 'YouTube', 'LWgqWuJG5Jg', 1, '2160p', NULL, 0, 14),
(12, 'video', 'YouTube', 'MhQKe-aERsU', 1, '1080p', NULL, 0, 15),
(13, 'video', 'YouTube', '51iquRYKPbs', 1, '1080p', NULL, 0, 20),
(14, 'video', 'YouTube', 'RmAbWm-hiY0', 1, '720p', NULL, 0, 21),
(15, 'video', 'YouTube', 'kbpqZT_56Ns', 1, '480p', NULL, 0, 22),
(16, 'video', 'YouTube', 'ktvTqknDobU', 1, '1080p', NULL, 0, 23),
(17, 'video', 'YouTube', 'KpUHWlMIbQU', 1, '1080p', NULL, 0, 24),
(18, 'video', 'YouTube', 'F3qqXqyaFsQ', 1, '1080p', NULL, 0, 25),
(19, 'video', 'YouTube', 'eUYy1JcTHBc', 1, '1080p', NULL, 0, 26),
(20, 'video', 'YouTube', 'ysSxxIqKNN0', 1, '1080p', NULL, 0, 27),
(21, 'video', 'YouTube', 'gOsM-DYAEhY', 1, '1080p', NULL, 0, 28),
(22, 'video', 'YouTube', 'fKopy74weus', 1, '1080p', NULL, 0, 29);

-- --------------------------------------------------------

--
-- Table structure for table `position`
--

CREATE TABLE `position` (
  `idSingle` int(11) NOT NULL COMMENT 'Foreign_Key',
  `idChart` int(11) NOT NULL COMMENT 'Foreign_Key',
  `num` int(3) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `position`
--

INSERT INTO `position` (`idSingle`, `idChart`, `num`) VALUES
(1, 5, 4),
(2, 6, 1),
(4, 1, 48),
(4, 2, 3),
(7, 3, 8),
(8, 3, 22),
(9, 4, 2),
(20, 7, 1),
(21, 7, 1),
(22, 7, 1),
(23, 7, 1),
(27, 7, 1),
(28, 7, 1),
(29, 7, 1);

-- --------------------------------------------------------

--
-- Table structure for table `rating`
--

CREATE TABLE `rating` (
  `idUser` int(11) NOT NULL,
  `idSingle` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `remake`
--

CREATE TABLE `remake` (
  `idOriginalSingle` int(11) NOT NULL COMMENT 'Foreign_Key',
  `idRemakeSingle` int(11) NOT NULL COMMENT 'Foreign_Key'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `remake`
--

INSERT INTO `remake` (`idOriginalSingle`, `idRemakeSingle`) VALUES
(4, 10),
(4, 11),
(4, 12),
(4, 13),
(4, 14),
(7, 15),
(10, 11),
(10, 12),
(10, 13),
(10, 14),
(20, 21),
(23, 24),
(23, 25),
(23, 26);

-- --------------------------------------------------------

--
-- Table structure for table `single`
--

CREATE TABLE `single` (
  `idSingle` int(11) NOT NULL,
  `title` varchar(256) NOT NULL,
  `year` int(4) NOT NULL,
  `language` varchar(4) NOT NULL,
  `insertDate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `type` varchar(8) NOT NULL COMMENT 'original or remake',
  `cover` varchar(256) DEFAULT NULL,
  `info` varchar(256) DEFAULT NULL,
  `nameGenre` varchar(100) DEFAULT NULL COMMENT 'Foreign_Key',
  `idArtist` int(11) NOT NULL COMMENT 'Foreign_Key'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `single`
--

INSERT INTO `single` (`idSingle`, `title`, `year`, `language`, `insertDate`, `type`, `cover`, `info`, `nameGenre`, `idArtist`) VALUES
(1, 'This Means War', 2014, 'en', '2015-12-30 20:01:27', 'original', NULL, 'https://en.wikipedia.org/wiki/This_Means_War_(Avenged_Sevenfold_song)', 'METAL', 2),
(2, 'Happy', 2014, 'en', '2015-12-31 16:22:16', 'original', NULL, 'https://en.wikipedia.org/wiki/Happy_(Pharrell_Williams_song)', 'FUNK', 3),
(3, 'Dark Horse', 2014, 'en', '2016-01-01 08:49:46', 'original', NULL, 'https://en.wikipedia.org/wiki/Dark_Horse_(Katy_Perry_song)', 'TRAP', 4),
(4, 'Hello', 2015, 'en', '2018-06-16 20:53:17', 'original', NULL, 'https://en.wikipedia.org/wiki/Hello_(Adele_song)', 'POP', 5),
(7, 'Shape of You', 2017, 'en', '2018-06-16 21:25:46', 'original', NULL, 'https://en.wikipedia.org/wiki/Shape_of_You', 'POP', 6),
(8, 'Despacito', 2017, 'es', '2018-06-16 21:53:15', 'original', NULL, 'https://en.wikipedia.org/wiki/Despacito', 'LATINO', 7),
(9, 'Numb', 2017, 'en', '2018-06-16 22:10:25', 'original', NULL, 'https://en.wikipedia.org/wiki/Numb_(Linkin_Park_song)', 'ROCK', 8),
(10, 'Hello', 2015, 'en', '2018-06-17 11:09:23', 'remake', NULL, NULL, 'POP', 9),
(11, 'Hello', 2015, 'en', '2018-06-17 14:35:10', 'remake', NULL, NULL, 'POP', 10),
(12, 'Hello', 2015, 'en', '2018-06-17 14:55:54', 'remake', NULL, NULL, 'REGGAE', 11),
(13, 'Hello', 2015, 'en', '2018-06-17 15:03:00', 'remake', NULL, NULL, 'METAL', 12),
(14, 'Hello', 2016, 'en', '2018-06-17 15:13:59', 'remake', NULL, NULL, 'POP', 13),
(15, 'Shape of You', 2017, 'en', '2018-06-17 15:57:33', 'remake', NULL, NULL, 'POP', 14),
(20, 'The Catalyst', 2010, 'en', '2018-06-25 16:43:12', 'original', NULL, 'https://en.wikipedia.org/wiki/The_Catalyst', 'ROCK', 8),
(21, 'The Catalyst', 2012, 'en', '2018-06-25 16:43:12', 'remake', NULL, NULL, 'METAL', 15),
(22, 'Rope', 2011, 'en', '2018-06-25 16:46:13', 'original', NULL, 'https://en.wikipedia.org/wiki/Rope_(song)', 'ROCK', 16),
(23, 'Radioactive', 2013, 'en', '2018-06-25 16:46:13', 'original', NULL, 'https://en.wikipedia.org/wiki/Radioactive_(Imagine_Dragons_song)', 'ROCK', 17),
(24, 'Radioactive', 2016, 'en', '2018-06-25 16:48:14', 'remake', NULL, NULL, 'METAL', 12),
(25, 'Radioactive', 2013, 'en', '2018-06-25 16:48:14', 'remake', NULL, NULL, 'HARDCORE', 18),
(26, 'Radioactive', 2013, 'en', '2018-06-25 16:49:08', 'remake', NULL, NULL, 'ROCK', 19),
(27, 'New Divide', 2009, 'en', '2018-06-25 16:49:08', 'original', NULL, 'https://en.wikipedia.org/wiki/New_Divide', 'ROCK', 8),
(28, 'Whatever It Takes', 2018, 'en', '2018-06-25 16:49:40', 'original', NULL, 'https://en.wikipedia.org/wiki/Whatever_It_Takes_(Imagine_Dragons_song)', 'ROCK', 17),
(29, 'Thunder', 2017, 'en', '2018-06-25 17:09:51', 'original', NULL, 'https://en.wikipedia.org/wiki/Thunder_(Imagine_Dragons_song)', 'ROCK', 17);

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `idUser` int(11) NOT NULL,
  `username` varchar(30) NOT NULL,
  `password` varchar(256) NOT NULL,
  `email` varchar(256) NOT NULL,
  `role` varchar(10) NOT NULL COMMENT 'admin,artist or user'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`idUser`, `username`, `password`, `email`, `role`) VALUES
(1, 'rossimario', '73l8gRjwLftklgfdXT+MdiMEjJwGPVMsyVxe16iYpk8=', 'rossimario@gmail.com', 'user'),
(2, 'pallina', '73l8gRjwLftklgfdXT+MdiMEjJwGPVMsyVxe16iYpk8=', 'pallina@gmail.com', 'user'),
(8, 'cinzia', 'FeKw08M4keuw8e9gnsQZQgwg4yDOlMZfvIwzEkSOsiU=', 'bocchicinzia@gmail.com', 'user'),
(18, 'aaa', '8qypO4DK5oEiHwRF+k4sroofn4+h4XQdljnKrSIvU30=', 'aaa@gmail.com', 'artist'),
(19, 'aaaa', 'FeKw08M4keuw8e9gnsQZQgwg4yDOlMZfvIwzEkSOsiU=', 'aa@gmail.com', 'user'),
(20, 'www', 'FeKw08M4keuw8e9gnsQZQgwg4yDOlMZfvIwzEkSOsiU=', 'ww@gmail.com', 'user'),
(21, 'eee', 'FeKw08M4keuw8e9gnsQZQgwg4yDOlMZfvIwzEkSOsiU=', 'bocchicinzia@gmail.com', 'user'),
(22, 'utenteprova', 'FeKw08M4keuw8e9gnsQZQgwg4yDOlMZfvIwzEkSOsiU=', 'utente@gmail.com', 'artist'),
(23, 'ppppp', 'FeKw08M4keuw8e9gnsQZQgwg4yDOlMZfvIwzEkSOsiU=', 'bocchicinzia@gmail.com', 'user'),
(24, 'MistoCraft99', 'CKzNv1cXVySIAZOtwtqYwVK1BWAiDS9uTOlDNdRSRnc=', 'multycraft99@gmail.com', 'user');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `artist`
--
ALTER TABLE `artist`
  ADD PRIMARY KEY (`idArtist`),
  ADD UNIQUE KEY `name` (`name`);

--
-- Indexes for table `chart`
--
ALTER TABLE `chart`
  ADD PRIMARY KEY (`idChart`);

--
-- Indexes for table `genre`
--
ALTER TABLE `genre`
  ADD PRIMARY KEY (`nameGenre`);

--
-- Indexes for table `media`
--
ALTER TABLE `media`
  ADD PRIMARY KEY (`idMedia`);

--
-- Indexes for table `position`
--
ALTER TABLE `position`
  ADD PRIMARY KEY (`idSingle`,`idChart`);

--
-- Indexes for table `rating`
--
ALTER TABLE `rating`
  ADD PRIMARY KEY (`idUser`,`idSingle`);

--
-- Indexes for table `remake`
--
ALTER TABLE `remake`
  ADD PRIMARY KEY (`idOriginalSingle`,`idRemakeSingle`);

--
-- Indexes for table `single`
--
ALTER TABLE `single`
  ADD PRIMARY KEY (`idSingle`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`idUser`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `artist`
--
ALTER TABLE `artist`
  MODIFY `idArtist` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=23;

--
-- AUTO_INCREMENT for table `chart`
--
ALTER TABLE `chart`
  MODIFY `idChart` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT for table `media`
--
ALTER TABLE `media`
  MODIFY `idMedia` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=23;

--
-- AUTO_INCREMENT for table `single`
--
ALTER TABLE `single`
  MODIFY `idSingle` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=30;

--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `idUser` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=25;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
