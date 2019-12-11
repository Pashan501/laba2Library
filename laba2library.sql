-- phpMyAdmin SQL Dump
-- version 3.5.1
-- http://www.phpmyadmin.net
--
-- Хост: 127.0.0.1
-- Время создания: Дек 08 2019 г., 12:46
-- Версия сервера: 5.5.25
-- Версия PHP: 5.2.12

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- База данных: `laba2library`
--

-- --------------------------------------------------------

--
-- Структура таблицы `books`
--

CREATE TABLE IF NOT EXISTS `books` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `Name` varchar(40) NOT NULL,
  `Genre` varchar(40) NOT NULL,
  `AuthorName` varchar(40) NOT NULL,
  `Description` varchar(2000) DEFAULT NULL,
  `year` int(11) DEFAULT NULL,
  `img-source` varchar(40) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=13 ;

--
-- Дамп данных таблицы `books`
--

INSERT INTO `books` (`id`, `Name`, `Genre`, `AuthorName`, `Description`, `year`, `img-source`) VALUES
(1, 'Witcher The Last Wish', 'Fantasy', 'Andrzej Sapkowski', NULL, 2005, '../img-books/witcher.jpg'),
(2, 'The Big Book of Pussy', 'Roman', 'Daian Henson', 'The Big Book of Pussy, not to be confused with a book of big pussies, closed out the popular “body part” series with an offering just as controversial as it was popular back in 2011. As in previous volumes, editor Dian Hanson explored the historical significance of her subject, explaining how the female genitalia have been coveted, feared, reviled, and worshipped by civilizations worldwide, from New Guinea to old Ireland. Her text was supported by playfully positive photographs of women exposing their vulvas, from 1910 to today. And with more than 400 photos, the point was made emphatically, in images both naturally furry and stylishly groomed.\r\n', 2018, '../img-books/big_pussy.png'),
(4, 'Crime and Punishment', 'Philosophical fiction', ' Fyodor Dostoevsky', 'Crime and Punishment focuses on the mental \nanguish and moral dilemmas of Rodion Raskolnikov, an impoverished ex-student in Saint \nPetersburg who formulates a plan to kill an unscrupulous pawnbroker for her money. \nBefore the killing, Raskolnikov believes that with the money he could liberate himself \nfrom poverty and go on to perform great deeds. However, once it is done he finds himself \nracked with confusion, paranoia, and disgust for what he has done. His ethical justifications\n disintegrate completely as he struggles with guilt and horror and confronts the real-world moral consequences of his deed.', 1866, '../img-books/Crime&Punish.png'),
(5, 'Do Androids Dream of Electric Sheep?', 'Philosophical fiction', 'Philip K. Dick', 'The novel is set in a post-apocalyptic San Francisco, where Earth''s life has been greatly damaged by a nuclear global war. Most animal species are endangered or extinct from extreme radiation poisoning, so that owning an animal is now a sign of status and empathy, an attitude encouraged towards animals. The book served as the primary basis for the 1982 film Blade Runner, and many elements and themes from it were used in its 2017 sequel Blade Runner 2049.He main plot follows Rick Deckard, a bounty hunter who is tasked with  (i.e. killing) six escaped Nexus-6 model androids, while a secondary plot follows John Isidore, a man of sub-par IQ who aids the fugitive androids. In connection with Deckard''s mission, the novel explores the issue of what it is to be human and whether empathy is a purely human ability.', 1968, '../img-books/AndroSheep.jpg'),
(6, 'VALIS', 'Philosophical fiction', 'Philip K. Dick', 'It is the first book in the incomplete VALIS trilogy of novels, followed by The Divine Invasion (1981). The planned third novel, The Owl in Daylight, had not yet taken definite shape at the time of the author''s death.[1] Radio Free Albemuth, a posthumously published earlier version of VALIS, is not included as a component of the VALIS trilogy. Dick completed one more novel after The Divine Invasion, The Transmigration of Timothy Archer (1982), based on Dick''s association with Bishop James A. Pike and not connected to the VALIS theme.', 1981, '../img-books/VALIS.jpg'),
(7, 'Madame Bovary', 'Realist novel', 'Gustave Flaubert', 'Novel was first serialized in La Revue de Paris between 1 October 1856 and 15 December 1856, public prosecutors attacked the novel for obscenity. The resulting trial in January 1857 made the story notorious. After Flaubert''s acquittal on 7 February 1857, Madame Bovary became a bestseller in April 1857 when it was published in two volumes. A seminal work of literary realism, the novel is now considered Flaubert''s masterpiece, and one of the most influential literary works in history. The British critic James Wood writes: Flaubert established, for good or ill, what most readers think of as modern realist narration, and his influence is almost too familiar to be visible.', 1857, '../img-books/MadameBovary.jpg'),
(8, 'The Old Man and the Sea', 'Fiction', 'Ernest Hemingway', 'The Old Man and the Sea is a short novel written by the American author Ernest Hemingway in 1951 in Cuba, and published in 1952.[1] It was the last major work of fiction by Hemingway that was published during his lifetime. One of his most famous works, it tells the story of Santiago, an aging Cuban fisherman who struggles with a giant marlin far out in the Gulf Stream off the coast of Cuba.', 1952, '../img-books/TheOldMan.jpg'),
(9, 'Anna Karenina', 'Realist novel', '	Leo Tolstoy', 'A complex novel in eight parts, with more than a dozen major characters, it is spread over more than 800 pages (depending on the translation and publisher), typically contained in two volumes. It deals with themes of betrayal, faith, family, marriage, Imperial Russian society, desire, and rural vs. city life. The plot centers on an extramarital affair between Anna and dashing cavalry officer Count Alexei Kirillovich Vronsky that scandalizes the social circles of Saint Petersburg and forces the young lovers to flee for Italy in a search for happiness. Returning to Russia, their lives further unravel.', 1877, '../img-books/AnnaKarenina.jpg'),
(10, 'The Lord of the Rings\n', 'Fantasy', 'J.R.R. Tolkien', 'The title of the novel refers to the story''s main antagonist, the Dark Lord Sauron, who had in an earlier age created the One Ring to rule the other Rings of Power as the ultimate weapon in his campaign to conquer and rule all of Middle-earth. From quiet beginnings in the Shire, a hobbit land not unlike the English countryside, the story ranges across Middle-earth, following the course of the War of the Ring through the eyes of its characters, most notably the hobbits Frodo Baggins, Sam, Merry and Pippin.', 1954, '../img-books/TheLord.jpg'),
(11, 'There There\n', 'Realist novel', 'Tommy Orange', 'There There is the first novel by Cheyenne and Arapaho author Tommy Orange. Published in 2018, it opens with an essay by Orange as a prologue, and then proceeds to follow a large cast of Native Americans living in the area of Oakland, California, as they struggle with a wide array of challenges ranging from depression and alcoholism, to unemployment, fetal alcohol syndrome, and the challenges of living with an ethnic identity. All coalesce at a community pow wow and its attempted robbery.', 2018, '../img-books/ThereThere.png'),
(12, ' Invisible Man\n', 'Roman', 'Ralph Ellison', 'Invisible Man is a novel by Ralph Ellison, published by Random House in 1952. It addresses many of the social and intellectual issues facing African Americans early in the twentieth century, including black nationalism, the relationship between black identity and Marxism, and the reformist racial policies of Booker T. Washington, as well as issues of individuality and personal identity.', 1952, '../img-books/InvisibleMan.jpg');

-- --------------------------------------------------------

--
-- Структура таблицы `user`
--

CREATE TABLE IF NOT EXISTS `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(10) DEFAULT NULL,
  `surName` varchar(20) DEFAULT NULL,
  `email` varchar(40) DEFAULT NULL,
  `country` varchar(15) DEFAULT NULL,
  `city` varchar(15) DEFAULT NULL,
  `street` varchar(40) DEFAULT NULL,
  `password` varchar(40) DEFAULT NULL,
  `type` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `email` (`email`),
  UNIQUE KEY `email_2` (`email`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=5 ;

--
-- Дамп данных таблицы `user`
--

INSERT INTO `user` (`id`, `name`, `surName`, `email`, `country`, `city`, `street`, `password`, `type`) VALUES
(1, NULL, NULL, 'admin@a', NULL, NULL, NULL, '-55adeb68e4d047d9d23b3786e1db75cd', 'admin'),
(2, 'Pasha', 'Zhuk', 'pashazhuk@gmail.com', 'Ukraine', 'Kyiv', 'Lesya Kurbasa ', '-43d151cdd34b2e4e315c376140d5d667', 'user'),
(3, 'sobaka', 'sobaka', 'sobaka@sobaka', 'sobaka', 'sobaka', 'sobaka', '7d4bd57ca88e89c790af96d0f348fbfd', 'user'),
(4, 'Daniel', 'Protsak', 'daniel.protsak@gmail.com', 'Ukraine', 'Kyiv', 'dsfsfds', '1746d4aea1ed77f413dc62079e835d3f', 'user');

-- --------------------------------------------------------

--
-- Структура таблицы `userbooks`
--

CREATE TABLE IF NOT EXISTS `userbooks` (
  `user_id` int(11) DEFAULT NULL,
  `book_id` int(11) DEFAULT NULL,
  KEY `user_id` (`user_id`),
  KEY `book_id` (`book_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Ограничения внешнего ключа сохраненных таблиц
--

--
-- Ограничения внешнего ключа таблицы `userbooks`
--
ALTER TABLE `userbooks`
  ADD CONSTRAINT `userbooks_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE CASCADE,
  ADD CONSTRAINT `userbooks_ibfk_2` FOREIGN KEY (`book_id`) REFERENCES `books` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
