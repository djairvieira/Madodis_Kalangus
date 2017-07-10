-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: docente
-- ------------------------------------------------------
-- Server version	5.5.5-10.1.21-MariaDB

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
-- Table structure for table `tb_aula_arquivo`
--

DROP TABLE IF EXISTS `tb_aula_arquivo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_aula_arquivo` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `content` longblob NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  `name` varchar(100) NOT NULL,
  `type` varchar(100) DEFAULT NULL,
  `AULA_ID` int(11) NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `FK5493A328B3B7C8BC` (`AULA_ID`),
  CONSTRAINT `FK5493A328B3B7C8BC` FOREIGN KEY (`AULA_ID`) REFERENCES `tb_aula` (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_aula_arquivo`
--

LOCK TABLES `tb_aula_arquivo` WRITE;
/*!40000 ALTER TABLE `tb_aula_arquivo` DISABLE KEYS */;
INSERT INTO `tb_aula_arquivo` VALUES (1,'‰PNG\r\n\Z\n\0\0\0\rIHDR\0\0,\0\0\0¨\0\0\0mõ#=\0\0\0ºPLTEÿÿÿ\ì %\rŠ\Ç\ë\0\0\0€\Ã\0‡\Æ\0…\Å\0ƒ\Äý\ê\ê\0„\Äû\Ø\Ù\ë\ì\"\0\Â\ì\ì þóó\ë\0ó†ˆ\ìôù\ëö«¬ðhjPŸ\Ðöúü÷µ¶\Ï\âðù\É\Ét°\Øø¼½|´Ú•Á\à\á\íö\Å\ÜíŠ»\Ýðbd´\Ò\èü\ã\ãú\Ò\Ó\Ö\æòhª\Õ*’Ê¡\Ç\ã\í59ñprZ¤Ò¯\Ï\ç\ïWZõŸ \ïORô›œ\í<@òy{ö¯°ó‹Œ\í.2\îEH\ï[]ô’“\0xÀ:—\Í\ïPR\ìd\Ù\0\0ŠIDATxœ\í]{ª¸bEPD\ë[ú@[\í\Ëöô´žÿÿ·†„Bx\Ú\â(–u¿ù\æŽ@Ëµw\ÒJ¥D‰%JT&\ç\î@‘\Ðœ»\ÂD;w\n„%¨Ÿ»\ÅÁ¼œ»\ÅA\rü=wŠƒ\Z\0\ç\îBq°\0 v\î>K\0–\ç\îCa0Ñ´2.ÍŠÏŽ\Ö=w\nƒ;µót\î>€ë”VF\Ô²J\ËÊˆw™\Ó\Þ\ÎÝ‰¢@mp`t\îN#Àq`q\î^\ÏM‡¬sw¢ X:†\Õ|>w/\n‚Ç°\Ê\È!Ža•.+Z«\æý¹»Q<ªY\å\Ê0>¡a5\Ê|EL WœV®u2`‰¸jr\ç\îG\àrU.u²`\är\ÕÙŸ»#@\×\åª2`\ïr\Õ\0­s÷\äòñ¬a®\Ê\Ø=\r‹¦Š¹*‹\Ò0M\×_•\\¥\â\ÓuW\\S‹ƒ\Ëv¦b\Ü®\äÈœ}½\r\îKG\æ¢u/»\\©ˆy°ö\ÂP&/0êšŠ¹ú\æjô4pW\Æ\ÐÀ\\…cÑ§PÕ²\èÁq\íœü\Ê\\i}­Á»³t\ë\"ñ\àqõ¼\Ðz\Ç\Ú@Yµ\ìáŸ†¹\êü^x\Ð\ék¥·\"hý‘	WÁ\nÒ‰ª¡`þýL»@\ÔT<\rrZ€«\Ö#òù\ÍR\Õò±À+‡«€ˆCù¾‚\ê$d`¸º\Åb\é\í¹:vð¹\nø«\Zvc¥»¢°ð¸’©—xh‚2m\è£\æq¥\Òñ\Õ\\FW48\âÛ›¨Oq¾¢\ä*€G_5:Ô”W\'\\•\Ò…²\Æ\áh]´¥¹cP+a>Wôxûç†¨Í\Ø#^‰\Ã\n$Sd–œ(Lˆa+\Z:\î ,+þð+\È\ébý¡¬»¥\áy,õþr¹\Óx\êÃ¢\Ê^\ØP\î2¤q‹u9!¼t\",ñÜŒðX•;µtYÀd5‚\Å}…e\à@c¯FŒ\Â\nñú Ç¼W«‹Q\\?ø\æ\Æ\ÌvBoŠ\ÌQó«\r´ókóFD‘\Å\É&\ÇqHfX¹¸dUöHr?>’H5}ý\×@V\r½ƒ\Z\Ì4·‰h\Ã\åW u\rdab‚{(¼cŽ\å·WAV‰\ÇAjydqZ^K\é\ë \ë\r„å…¿ª\ÇV^¸\×A\ÚøP\ß}ýD¶žæ›¸²Zp 2žœ\Äð\\n‰°+!\Ù\Ãû.>¯\åôµU\Ùk!J}¯%ç’³¸\Z²*¯*\×	Æ¥-Ú´òˆã¯‡,\è¶=fà³•\Ëû]Ypk!cZ•[\Ù7­¾!‰¬ú¤û\Ùn·ßŸ&9\Ä)‹Q÷\å=¯Æ¢\Ñ!G®6<²rjbÈª\rö÷\0\0­#;\èh Ó¦_ñ\å\î\â\îoX\×Á—n\éJ¶1mO\æø·ÁÓ¤’S<\ëÈ—\Þ@TspñQd->ÿ\0Mö£\r<ø?\Ú\0¨ðÑŸÿ:\èŠ\ìÉ–‹—ûˆ\ÆH\Õþm¥ý<\ÊOù}”\Ù`ý\ä2!\ë·&kò\n:w#.Òù¼i&üš\\»\'º\È(¦1\']+û\ÉýK~9…{¶ \ÛMsøI\Âd¨—C\á³õ\Ü!G€›#GN\05¶1\Ä\Ö\Òù_=\Ç=n­&[]´ŒÿaF˜,,is\r\Õñ/ŽŸñ}dC#&@²½!a­\Ædëˆª\ä6¦Ñ&G>\è§yòXFC\r\î< ù·ý\Ò\í>}>tüD\â$kq?—W=F\Z\ÈE\æ]û©\Û\í\Z\ËOÁ¤±\0L»Ø´òˆ\Âd\Õ@üyQ¿û\ÄóÏž5Ü“q\ÈT–c“óª|Z\á\ÆT¯±\Ó$©–lŸdôóä¡—FÌ†\Ï/l$\Ô\"£\Ç;ý†\ä{Ù©Ú•Ã©ƒ\Çpc$•pªòvvE\ãP\Íã¨±l<]\ê_\æ1vâ‚–\Ä¸Ü“•6f¿ Y¹\è—;d\Øy:71¦\î\"Sý):Yfý)0#\Â<O>\'\çg$\Ë+³ ¼\ËQ\Ïa£i$“ótòš.mGP\é\Ê\ç\àüŒdy³y?2–\ZMú6LCŠz´\Ìd?e\ïÎ„Ú¦Àpc\Ç\Ó\Í0½ÕŒd-X²üZz–Á\Õ?Zr\Ùy\íôdQxm&qµ\Ú~})‚T«’06Rš\ÊHV+D‰]sZ6Zy‘eÌ­\ía<\ï\'\Ý3\Úcü\Õ\Õ\ÌÍuDž¯*\ã\ä\ïû6Yd`\Ò)LlÁ¡\È\ê›\Ö\á\ëk=3\Òn”A&¹AŸ*<Ï‹\â*é¦¬\â_ˆ,ú¯ŒC\ÒTÁû§d\rgkEP\Ö=ý\Ö}\æÇ¶x^Ir]\édµõ\å\È+ýõ\É\"¥u\Ô1ø£„£\0‚}‹¬\á´*‰U\ÅN´‚‰šý;ôÄ–GY‹·öÝ«ˆ*D‘5ÀŸ5ý\ÛaóKn\ìx²ô/9 \ØŒ\ÊA\í3ýs	Ž\Äuü\rqd\Õ\Û \É*+\×P<ø¢N„1\êm9²±c\É2l¥\n}a~\äƒQˆ˜Ö°qiûH4Y\Ëg 7¸\ÐFC\n_½Q÷‰†\Ì\ÏYÿ\×\Øqdé¶‚\Ü\n/ZG=‚an\Æ\ëm„mÎªÉ¦I\ÖC¬\0H“µ°(É¬€ö±\àqd™˜*\çu\ìcžó¡¯\æ›iw\Â*…ô\ã+	y­\Ø!AÖ¢IHM{\Zr•°¨\åÅštû5®\ß\Ø1d_¼‘Ÿ­ƒ+\Z}c8wbô/’|:Œ‹\Â&\æV\Ã\Ø	1L–·\á_¯Ÿ“\å¢ù	\ÇYJ\ÔrM	\Â\ÔÓš\ß\Øýû€m\ì²t¡\ê³\Å;ñ6\ß\Ï6sse\è:C\\_7V\æ|7³\ÆÛƒC‘\ËÁ\ÕI‰\Z.\\²b=b˜,¢ô=µ\Z$‹¬®qjóoD\à\ÐLl\ì¨aØ·D¡*R„9H7’$	Š\"\Ôÿ‘œ+!o\äB–am\Ï\æ	6©KÖƒ0öý¢¶\Ç\à\é/\â–=\ÑF‘;®6[‘Œ¥LpØª:l*\Ð\n\ç\Ã\ÔpÃ”Ž†ÞŠ9XF’Ui4¨·ž`E™Z‰y^l\Ý\Øw‚\Ò>ô\ÒÛµ­\Ç\á\ÍYS\Ùq>¨:f\rŽ\ï\Ù\Öf¾\Ê“9°\Ü >ö:Kžþ\Ù\\H4YD\ÔB*\Ã…T\Ý\Øg‡¶¼pc?ZHë†³\ÞÌ¬©½\ík\èöùõ¡×³Ç–\ë\Ë2OWb/ö:Kv\Ú\ì_?Š&‹SÈ§G\Üñ{‰i\ìÂ¶Õ ž\Ì\ØX²\È{0’h²¼Å´\æ\Õ\Ù„õ´\Æ.Œ,w \âo`\Èò¼“8Š!‹ˆZ\Î\í£\Ð{h\Ó\Øe‘eU\\H/\Ò\Þ/H)\Ût(Š¸¡V(\Ë\Z*hÆ¯c\Ébÿ<F-š¬Šç´°¨þx¨\×Ø\É2~Ú€W ‘µ\ÒŸ\ÅQó¶:2dQ‹»‹J’Æ‚Sk\í>Ÿ}“¦¿Š;\Z}8™ò7\ÛÄ›X²¼| ý\Öo ”¿\Çx\åOøz\àªG1g\r@.ùû!/%\Ì[Gc-¦\ÚU˜¬=YDûŽ¦þ\á×±²d\ÑÁ\\\è\\€vDc\ÏTc? \Ër<Œðý\ÇôW\Ê,\å6,üšþ&ð\0ü¢ûA\ë5!ô9 \æ0Irª±[\Ô\Ø[°±ï“µƒ«8\éH\ËZ\ÅÝ¯\Ã1(VS3‡YD±óu:\ÕÕ€Ý·kð.ˆ¨\å>Á&¸\äÆ¾O\ny)Fja¡wÖ–W$I4¢.¯\\¥:=\â\'A¸e¿–‹&˜\È\Ñd\Õ\è\ÛCG[¢\Zk€Ió‡d\r]²x\éf¼‹SúúÊœo,\Û²ðò1*2\Ø9#ZŠV\à\å/õK\ï´\Ð\ëu¸®Œ\ç\"\îýqQ\ã\ZÑ˜¬\ÖñF‘\ï“e(\Þ\Ê\ÙY1K\ë\ÞÖžN-ˆ\ét×Š¼¤ ¦*2\n…\Ôc³B¶ÀßˆIÑ•§°ˆr‚Š¹Š6›»‹\æ0YD\Ô\â¢Â\íýÆ¾?\Ç+\Å \Ú_ñ¶\â%‰\ÏF•§:>ýƒªt\é\ÍU„Cd‘\íûš\ZQ_0h\0¯´\Ùwh5pûÁl8G)±\ã J‚\È$û­/¥—}šÀ/\Ò\è>\ì9èŽ»„žB¸…Ácó\î£}k\ï/ä–¸ÆŽ€i\ßRVPo„ª½1˜&$>KV›`\á­WÂ—F“I^E×µ\åd2\ÊŠ±›\×öL\n½ZÏš\ìÓº•^)\0–\çÒŠ„.úp¾™Ú½µ\èjð’\ç¿Äƒm\í\Òõ\äl ¾\é:\Î\êëº±\Zš.†+#¿¥#\Ä[\\ñ‰04bX\å¡I9ú@Í§>õª\ÑþVýwb\ïqU\à“<õ\Íñ¯ã±¼\'\ë9¡@õ\Âal¿’µ\Í|ð\ì	K\ÉE\â©\"V\Ó»<\à„ªj\Í\é±EeY‚©¾ie”¾¢áª˜\Í_gºÊƒ06\êb\ê~‚T•\ÖY«8t§‚\×ÿY\ÉM\Õ[{<µf³\r\ÂlfM\Ç[´’<Ý\â\ë²\Ò\Ñw…þ£=¦X/\Ãú‘ª–¨L¿OW\ÑÒµ¥ŒBE—ý“ÁXhX\ÊQ ()½cô«+ƒa+S±\ZRIú›ž\"U“	«J‚´eU\Ò_Š¾9\ÛV\é’dßœ\à.B\å0\Ý\ç\î\ã\Ð_\Íg\Ó\íx±\Ç	–šZvo\Í¤lY\×\Û\é\Æ4þ\ïN^ó‘¾”\íf˜\êwú}=T\Zÿ‹`\ÌŠ ð\'v;\Û+ XŸñBU¶™öþ³„j\Òb@wwÍ‰ÿC,\Ùû:ýwœ37\ìŒ\Ó\Õ8m;ù¥£G4\'ÿ¦9¯|scÞ¥`J¸ºù‘\Z•\nsz#(§ýŠ“£\ï\Ë\n\Ò!\ÇúQ\Zº9\ë9­’q\Óõ\åÂ 5I\ÈcT(¢\ÃBÛ ¯3„8\Ü\×Â’\Â\ÛY¶\Â%A_™;g°†%\Îò\ÈY`¯™\Ñ\ÔøIû\ç\ÃT¡·¯ºŒÁM–pÿ\à\Îf)f\è£ò‡ùncM·=^\"õ€D³9°•4úúÿ\È0\"aÐ¦K\ç\Í‰?lm((c¸•’°T²wX£bI$-\Ã}­=\ÈL§a\Íf¦œ~\æ=!Œ\r±2LPPN/–E\Ç6\Å\í,*Í±¾˜‹‚nnÆ½jJ\ÝZ¡h{\ëÚ¶\â\nœw¼$\n\ÏF\ß0\ç3R·&¹ƒ+hK8o\áš\Z\Úm+\Ú\ÐX[›¹™°»Õ°œ_\"uE!Ñ‡›~¡Û†Y/\è£l{\áü\Û§ÌŠ\í\æsTÑ–ÁVô\ÍZE¡gœ¼\ãE\Ç\ÐZUHÕ¯MüdC8\Û:“/\Þ\ã“K@†>ÜŒ\×(\×!\Þ(½Ýµøu\Ænj\í\Ì\Õw•cx|Ï¸w÷ó¸\åñ×ž![\Íz___\nš\ä\à!)~œN3µ\"‰?`\âG8L\Ã\åñW	c>=(Š‚+\ß\Ých$xÆ¡‡q€gcˆRðp\Z|*\Ía<3s¿\Âÿ\Ã\Ä\'bIRDÀE–€(\îB!©\ÓcG¸r@R<j\ÍKB6Ø¡W~q‚,}‚sw¤\Ä\å\à?ûX*!\áÿ \0\0\0\0IEND®B`‚','JAVA IMG','java',NULL,1),(2,'‰PNG\r\n\Z\n\0\0\0\rIHDR\0\0,\0\0\0¨\0\0\0mõ#=\0\0\0ºPLTEÿÿÿ\ì %\rŠ\Ç\ë\0\0\0€\Ã\0‡\Æ\0…\Å\0ƒ\Äý\ê\ê\0„\Äû\Ø\Ù\ë\ì\"\0\Â\ì\ì þóó\ë\0ó†ˆ\ìôù\ëö«¬ðhjPŸ\Ðöúü÷µ¶\Ï\âðù\É\Ét°\Øø¼½|´Ú•Á\à\á\íö\Å\ÜíŠ»\Ýðbd´\Ò\èü\ã\ãú\Ò\Ó\Ö\æòhª\Õ*’Ê¡\Ç\ã\í59ñprZ¤Ò¯\Ï\ç\ïWZõŸ \ïORô›œ\í<@òy{ö¯°ó‹Œ\í.2\îEH\ï[]ô’“\0xÀ:—\Í\ïPR\ìd\Ù\0\0ŠIDATxœ\í]{ª¸bEPD\ë[ú@[\í\Ëöô´žÿÿ·†„Bx\Ú\â(–u¿ù\æŽ@Ëµw\ÒJ¥D‰%JT&\ç\î@‘\Ðœ»\ÂD;w\n„%¨Ÿ»\ÅÁ¼œ»\ÅA\rü=wŠƒ\Z\0\ç\îBq°\0 v\î>K\0–\ç\îCa0Ñ´2.ÍŠÏŽ\Ö=w\nƒ;µót\î>€ë”VF\Ô²J\ËÊˆw™\Ó\Þ\ÎÝ‰¢@mp`t\îN#Àq`q\î^\ÏM‡¬sw¢ X:†\Õ|>w/\n‚Ç°\Ê\È!Ža•.+Z«\æý¹»Q<ªY\å\Ê0>¡a5\Ê|EL WœV®u2`‰¸jr\ç\îG\àrU.u²`\är\ÕÙŸ»#@\×\åª2`\ïr\Õ\0­s÷\äòñ¬a®\Ê\Ø=\r‹¦Š¹*‹\Ò0M\×_•\\¥\â\ÓuW\\S‹ƒ\Ëv¦b\Ü®\äÈœ}½\r\îKG\æ¢u/»\\©ˆy°ö\ÂP&/0êšŠ¹ú\æjô4pW\Æ\ÐÀ\\…cÑ§PÕ²\èÁq\íœü\Ê\\i}­Á»³t\ë\"ñ\àqõ¼\Ðz\Ç\Ú@Yµ\ìáŸ†¹\êü^x\Ð\ék¥·\"hý‘	WÁ\nÒ‰ª¡`þýL»@\ÔT<\rrZ€«\Ö#òù\ÍR\Õò±À+‡«€ˆCù¾‚\ê$d`¸º\Åb\é\í¹:vð¹\nø«\Zvc¥»¢°ð¸’©—xh‚2m\è£\æq¥\Òñ\Õ\\FW48\âÛ›¨Oq¾¢\ä*€G_5:Ô”W\'\\•\Ò…²\Æ\áh]´¥¹cP+a>Wôxûç†¨Í\Ø#^‰\Ã\n$Sd–œ(Lˆa+\Z:\î ,+þð+\È\ébý¡¬»¥\áy,õþr¹\Óx\êÃ¢\Ê^\ØP\î2¤q‹u9!¼t\",ñÜŒðX•;µtYÀd5‚\Å}…e\à@c¯FŒ\Â\nñú Ç¼W«‹Q\\?ø\æ\Æ\ÌvBoŠ\ÌQó«\r´ókóFD‘\Å\É&\ÇqHfX¹¸dUöHr?>’H5}ý\×@V\r½ƒ\Z\Ì4·‰h\Ã\åW u\rdab‚{(¼cŽ\å·WAV‰\ÇAjydqZ^K\é\ë \ë\r„å…¿ª\ÇV^¸\×A\ÚøP\ß}ýD¶žæ›¸²Zp 2žœ\Äð\\n‰°+!\Ù\Ãû.>¯\åôµU\Ùk!J}¯%ç’³¸\Z²*¯*\×	Æ¥-Ú´òˆã¯‡,\è¶=fà³•\Ëû]Ypk!cZ•[\Ù7­¾!‰¬ú¤û\Ùn·ßŸ&9\Ä)‹Q÷\å=¯Æ¢\Ñ!G®6<²rjbÈª\rö÷\0\0­#;\èh Ó¦_ñ\å\î\â\îoX\×Á—n\éJ¶1mO\æø·ÁÓ¤’S<\ëÈ—\Þ@TspñQd->ÿ\0Mö£\r<ø?\Ú\0¨ðÑŸÿ:\èŠ\ìÉ–‹—ûˆ\ÆH\Õþm¥ý<\ÊOù}”\Ù`ý\ä2!\ë·&kò\n:w#.Òù¼i&üš\\»\'º\È(¦1\']+û\ÉýK~9…{¶ \ÛMsøI\Âd¨—C\á³õ\Ü!G€›#GN\05¶1\Ä\Ö\Òù_=\Ç=n­&[]´ŒÿaF˜,,is\r\Õñ/ŽŸñ}dC#&@²½!a­\Ædëˆª\ä6¦Ñ&G>\è§yòXFC\r\î< ù·ý\Ò\í>}>tüD\â$kq?—W=F\Z\ÈE\æ]û©\Û\í\Z\ËOÁ¤±\0L»Ø´òˆ\Âd\Õ@üyQ¿û\ÄóÏž5Ü“q\ÈT–c“óª|Z\á\ÆT¯±\Ó$©–lŸdôóä¡—FÌ†\Ï/l$\Ô\"£\Ç;ý†\ä{Ù©Ú•Ã©ƒ\Çpc$•pªòvvE\ãP\Íã¨±l<]\ê_\æ1vâ‚–\Ä¸Ü“•6f¿ Y¹\è—;d\Øy:71¦\î\"Sý):Yfý)0#\Â<O>\'\çg$\Ë+³ ¼\ËQ\Ïa£i$“ótòš.mGP\é\Ê\ç\àüŒdy³y?2–\ZMú6LCŠz´\Ìd?e\ïÎ„Ú¦Àpc\Ç\Ó\Í0½ÕŒd-X²üZz–Á\Õ?Zr\Ùy\íôdQxm&qµ\Ú~})‚T«’06Rš\ÊHV+D‰]sZ6Zy‘eÌ­\ía<\ï\'\Ý3\Úcü\Õ\Õ\ÌÍuDž¯*\ã\ä\ïû6Yd`\Ò)LlÁ¡\È\ê›\Ö\á\ëk=3\Òn”A&¹AŸ*<Ï‹\â*é¦¬\â_ˆ,ú¯ŒC\ÒTÁû§d\rgkEP\Ö=ý\Ö}\æÇ¶x^Ir]\édµõ\å\È+ýõ\É\"¥u\Ô1ø£„£\0‚}‹¬\á´*‰U\ÅN´‚‰šý;ôÄ–GY‹·öÝ«ˆ*D‘5ÀŸ5ý\ÛaóKn\ìx²ô/9 \ØŒ\ÊA\í3ýs	Ž\Äuü\rqd\Õ\Û \É*+\×P<ø¢N„1\êm9²±c\É2l¥\n}a~\äƒQˆ˜Ö°qiûH4Y\Ëg 7¸\ÐFC\n_½Q÷‰†\Ì\ÏYÿ\×\Øqdé¶‚\Ü\n/ZG=‚an\Æ\ëm„mÎªÉ¦I\ÖC¬\0H“µ°(É¬€ö±\àqd™˜*\çu\ìcžó¡¯\æ›iw\Â*…ô\ã+	y­\Ø!AÖ¢IHM{\Zr•°¨\åÅštû5®\ß\Ø1d_¼‘Ÿ­ƒ+\Z}c8wbô/’|:Œ‹\Â&\æV\Ã\Ø	1L–·\á_¯Ÿ“\å¢ù	\ÇYJ\ÔrM	\Â\ÔÓš\ß\Øýû€m\ì²t¡\ê³\Å;ñ6\ß\Ï6sse\è:C\\_7V\æ|7³\ÆÛƒC‘\ËÁ\ÕI‰\Z.\\²b=b˜,¢ô=µ\Z$‹¬®qjóoD\à\ÐLl\ì¨aØ·D¡*R„9H7’$	Š\"\Ôÿ‘œ+!o\äB–am\Ï\æ	6©KÖƒ0öý¢¶\Ç\à\é/\â–=\ÑF‘;®6[‘Œ¥LpØª:l*\Ð\n\ç\Ã\ÔpÃ”Ž†ÞŠ9XF’Ui4¨·ž`E™Z‰y^l\Ý\Øw‚\Ò>ô\ÒÛµ­\Ç\á\ÍYS\Ùq>¨:f\rŽ\ï\Ù\Öf¾\Ê“9°\Ü >ö:Kžþ\Ù\\H4YD\ÔB*\Ã…T\Ý\Øg‡¶¼pc?ZHë†³\ÞÌ¬©½\ík\èöùõ¡×³Ç–\ë\Ë2OWb/ö:Kv\Ú\ì_?Š&‹SÈ§G\Üñ{‰i\ìÂ¶Õ ž\Ì\ØX²\È{0’h²¼Å´\æ\Õ\Ù„õ´\Æ.Œ,w \âo`\Èò¼“8Š!‹ˆZ\Î\í£\Ð{h\Ó\Øe‘eU\\H/\Ò\Þ/H)\Ût(Š¸¡V(\Ë\Z*hÆ¯c\Ébÿ<F-š¬Šç´°¨þx¨\×Ø\É2~Ú€W ‘µ\ÒŸ\ÅQó¶:2dQ‹»‹J’Æ‚Sk\í>Ÿ}“¦¿Š;\Z}8™ò7\ÛÄ›X²¼| ý\Öo ”¿\Çx\åOøz\àªG1g\r@.ùû!/%\Ì[Gc-¦\ÚU˜¬=YDûŽ¦þ\á×±²d\ÑÁ\\\è\\€vDc\ÏTc? \Ër<Œðý\ÇôW\Ê,\å6,üšþ&ð\0ü¢ûA\ë5!ô9 \æ0Irª±[\Ô\Ø[°±ï“µƒ«8\éH\ËZ\ÅÝ¯\Ã1(VS3‡YD±óu:\ÕÕ€Ý·kð.ˆ¨\å>Á&¸\äÆ¾O\ny)Fja¡wÖ–W$I4¢.¯\\¥:=\â\'A¸e¿–‹&˜\È\Ñd\Õ\è\ÛCG[¢\Zk€Ió‡d\r]²x\éf¼‹SúúÊœo,\Û²ðò1*2\Ø9#ZŠV\à\å/õK\ï´\Ð\ëu¸®Œ\ç\"\îýqQ\ã\ZÑ˜¬\ÖñF‘\ï“e(\Þ\Ê\ÙY1K\ë\ÞÖžN-ˆ\ét×Š¼¤ ¦*2\n…\Ôc³B¶ÀßˆIÑ•§°ˆr‚Š¹Š6›»‹\æ0YD\Ô\â¢Â\íýÆ¾?\Ç+\Å \Ú_ñ¶\â%‰\ÏF•§:>ýƒªt\é\ÍU„Cd‘\íûš\ZQ_0h\0¯´\Ùwh5pûÁl8G)±\ã J‚\È$û­/¥—}šÀ/\Ò\è>\ì9èŽ»„žB¸…Ácó\î£}k\ï/ä–¸ÆŽ€i\ßRVPo„ª½1˜&$>KV›`\á­WÂ—F“I^E×µ\åd2\ÊŠ±›\×öL\n½ZÏš\ìÓº•^)\0–\çÒŠ„.úp¾™Ú½µ\èjð’\ç¿Äƒm\í\Òõ\äl ¾\é:\Î\êëº±\Zš.†+#¿¥#\Ä[\\ñ‰04bX\å¡I9ú@Í§>õª\ÑþVýwb\ïqU\à“<õ\Íñ¯ã±¼\'\ë9¡@õ\Âal¿’µ\Í|ð\ì	K\ÉE\â©\"V\Ó»<\à„ªj\Í\é±EeY‚©¾ie”¾¢áª˜\Í_gºÊƒ06\êb\ê~‚T•\ÖY«8t§‚\×ÿY\ÉM\Õ[{<µf³\r\ÂlfM\Ç[´’<Ý\â\ë²\Ò\Ñw…þ£=¦X/\Ãú‘ª–¨L¿OW\ÑÒµ¥ŒBE—ý“ÁXhX\ÊQ ()½cô«+ƒa+S±\ZRIú›ž\"U“	«J‚´eU\Ò_Š¾9\ÛV\é’dßœ\à.B\å0\Ý\ç\î\ã\Ð_\Íg\Ó\íx±\Ç	–šZvo\Í¤lY\×\Û\é\Æ4þ\ïN^ó‘¾”\íf˜\êwú}=T\Zÿ‹`\ÌŠ ð\'v;\Û+ XŸñBU¶™öþ³„j\Òb@wwÍ‰ÿC,\Ùû:ýwœ37\ìŒ\Ó\Õ8m;ù¥£G4\'ÿ¦9¯|scÞ¥`J¸ºù‘\Z•\nsz#(§ýŠ“£\ï\Ë\n\Ò!\ÇúQ\Zº9\ë9­’q\Óõ\åÂ 5I\ÈcT(¢\ÃBÛ ¯3„8\Ü\×Â’\Â\ÛY¶\Â%A_™;g°†%\Îò\ÈY`¯™\Ñ\ÔøIû\ç\ÃT¡·¯ºŒÁM–pÿ\à\Îf)f\è£ò‡ùncM·=^\"õ€D³9°•4úúÿ\È0\"aÐ¦K\ç\Í‰?lm((c¸•’°T²wX£bI$-\Ã}­=\ÈL§a\Íf¦œ~\æ=!Œ\r±2LPPN/–E\Ç6\Å\í,*Í±¾˜‹‚nnÆ½jJ\ÝZ¡h{\ëÚ¶\â\nœw¼$\n\ÏF\ß0\ç3R·&¹ƒ+hK8o\áš\Z\Úm+\Ú\ÐX[›¹™°»Õ°œ_\"uE!Ñ‡›~¡Û†Y/\è£l{\áü\Û§ÌŠ\í\æsTÑ–ÁVô\ÍZE¡gœ¼\ãE\Ç\ÐZUHÕ¯MüdC8\Û:“/\Þ\ã“K@†>ÜŒ\×(\×!\Þ(½Ýµøu\Ænj\í\Ì\Õw•cx|Ï¸w÷ó¸\åñ×ž![\Íz___\nš\ä\à!)~œN3µ\"‰?`\âG8L\Ã\åñW	c>=(Š‚+\ß\Ých$xÆ¡‡q€gcˆRðp\Z|*\Ía<3s¿\Âÿ\Ã\Ä\'bIRDÀE–€(\îB!©\ÓcG¸r@R<j\ÍKB6Ø¡W~q‚,}‚sw¤\Ä\å\à?ûX*!\áÿ \0\0\0\0IEND®B`‚','Novo teste','NovoTeste',NULL,1);
/*!40000 ALTER TABLE `tb_aula_arquivo` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-07-09 22:34:25
