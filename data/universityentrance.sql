CREATE DATABASE  IF NOT EXISTS `universityentrance` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `universityentrance`;
-- MySQL dump 10.13  Distrib 8.0.33, for Win64 (x86_64)
--
-- Host: localhost    Database: universityentrance
-- ------------------------------------------------------
-- Server version	8.0.33

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `banner`
--

DROP TABLE IF EXISTS `banner`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `banner` (
  `id` int NOT NULL AUTO_INCREMENT,
  `title` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_unicode_ci NOT NULL,
  `image` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_unicode_ci NOT NULL,
  `link` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_unicode_ci NOT NULL,
  `created_date` datetime NOT NULL,
  `updated_date` datetime NOT NULL,
  `status` tinyint NOT NULL,
  `recruitment_id` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_cate_bn_idx` (`recruitment_id`),
  CONSTRAINT `fk_cate_bn` FOREIGN KEY (`recruitment_id`) REFERENCES `recruitment` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `banner`
--

LOCK TABLES `banner` WRITE;
/*!40000 ALTER TABLE `banner` DISABLE KEYS */;
INSERT INTO `banner` VALUES (1,'Banner 1','banner1.jpg','https://res.cloudinary.com/ds8i6jriz/image/upload/v1691837059/MyImages/UniversityEntrance/banner/banner1_uosk46.jpg','2023-08-05 08:20:42','2023-08-05 08:20:42',1,1),(2,'Banner 2','banner2.jpg','https://res.cloudinary.com/ds8i6jriz/image/upload/v1691837059/MyImages/UniversityEntrance/banner/banner2_w70vsb.jpg','2023-08-05 08:20:42','2023-08-05 08:20:42',0,1),(3,'Banner 3','banner3.jpg','https://res.cloudinary.com/ds8i6jriz/image/upload/v1691949896/MyImages/UniversityEntrance/banner/modern-university-admission-banner-template-design-168ce33d82bc9d6823f5a58bc1a51092_screen_bbor76.jpg','2023-08-05 08:20:42','2023-08-05 08:20:42',0,1),(4,'Banner 4','banner4.jpg','https://res.cloudinary.com/ds8i6jriz/image/upload/v1691950360/MyImages/UniversityEntrance/banner/maroon-university-enrollment-banner-design-template-ed350a837743449b01870b3e812a72d5_screen_ejuuvt.jpg','2023-08-05 08:20:42','2023-08-05 08:20:42',1,1),(5,'Banner 5','banner5.jpg','https://res.cloudinary.com/ds8i6jriz/image/upload/v1691950562/MyImages/UniversityEntrance/banner/Web_20Banner_202_y8l2un.jpg','2023-08-05 08:20:42','2023-08-05 08:20:42',1,1),(6,'Banner 6','banner6.jpg','https://res.cloudinary.com/ds8i6jriz/image/upload/v1691950495/MyImages/UniversityEntrance/banner/CDOE-Banner_tynlsa.jpg','2023-08-05 08:20:42','2023-08-05 08:20:42',0,1),(7,'Banner 7','banner7.jpg','https://res.cloudinary.com/ds8i6jriz/image/upload/v1691950532/MyImages/UniversityEntrance/banner/OL-Banner-3_rn8jyc.jpg','2023-08-05 08:20:42','2023-08-05 08:20:42',0,1),(8,'Banner 8','banner8.jpg','https://res.cloudinary.com/ds8i6jriz/image/upload/v1691949896/MyImages/UniversityEntrance/banner/modern-university-admission-banner-template-design-168ce33d82bc9d6823f5a58bc1a51092_screen_bbor76.jpg','2023-08-05 08:20:42','2023-08-05 08:20:42',0,2),(9,'Banner 9','banner9.jpg','https://res.cloudinary.com/ds8i6jriz/image/upload/v1691837059/MyImages/UniversityEntrance/banner/banner1_uosk46.jpg','2023-08-05 08:20:42','2023-08-05 08:20:42',1,3),(10,'Banner 10','banner10.jpg','https://res.cloudinary.com/ds8i6jriz/image/upload/v1691837059/MyImages/UniversityEntrance/banner/banner2_w70vsb.jpg','2023-08-05 08:20:42','2023-08-05 08:20:42',0,2);
/*!40000 ALTER TABLE `banner` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `category`
--

DROP TABLE IF EXISTS `category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `category` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  `description` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `category`
--

LOCK TABLES `category` WRITE;
/*!40000 ALTER TABLE `category` DISABLE KEYS */;
INSERT INTO `category` VALUES (1,'Đào tạo đại học chính quy','Dành cho các sinh viên chính quy'),(2,'Đào tạo từ xa','Dành cho các sinh viên học đại học từ xa'),(3,'Đào tạo văn bằng 2 và liên thông','Dành cho người đi làm, muốn có bằng đại học thứ 2, hoặc liên thông lên đại học');
/*!40000 ALTER TABLE `category` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `comment`
--

DROP TABLE IF EXISTS `comment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `comment` (
  `id` int NOT NULL AUTO_INCREMENT,
  `new_id` int NOT NULL,
  `user_id` int NOT NULL,
  `content` text CHARACTER SET utf8mb3 COLLATE utf8mb3_unicode_ci NOT NULL,
  `created_date` datetime NOT NULL,
  `folow_comment` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_newid_cmts_news_idx` (`new_id`),
  KEY `fk_userid_cmts_users_idx` (`user_id`),
  KEY `fk_folow_cmt_idx` (`folow_comment`),
  CONSTRAINT `fk_folow_cmt` FOREIGN KEY (`folow_comment`) REFERENCES `comment` (`id`),
  CONSTRAINT `fk_newid_cmts_news` FOREIGN KEY (`new_id`) REFERENCES `news` (`id`),
  CONSTRAINT `fk_userid_cmts_users` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `comment`
--

LOCK TABLES `comment` WRITE;
/*!40000 ALTER TABLE `comment` DISABLE KEYS */;
INSERT INTO `comment` VALUES (1,1,1,'Who make it?','2023-08-05 08:48:32',2),(2,1,2,'Who make it?','2023-08-05 08:48:32',NULL),(3,2,1,'Who make it?','2023-08-05 08:48:32',NULL),(4,2,1,'Who make it?','2023-08-05 08:48:32',3),(5,2,5,'Who make it?','2023-08-05 08:48:32',3),(6,1,3,'Who make it?','2023-08-05 08:48:32',2),(7,1,8,'Who make it?','2023-08-05 08:48:32',6);
/*!40000 ALTER TABLE `comment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `department`
--

DROP TABLE IF EXISTS `department`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `department` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_unicode_ci NOT NULL,
  `description` text CHARACTER SET utf8mb3 COLLATE utf8mb3_unicode_ci NOT NULL,
  `website` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_unicode_ci NOT NULL,
  `video` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_unicode_ci NOT NULL,
  `average_score` float NOT NULL,
  `cateid` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_cateid_idx` (`cateid`),
  CONSTRAINT `fk_cateid` FOREIGN KEY (`cateid`) REFERENCES `category` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `department`
--

LOCK TABLES `department` WRITE;
/*!40000 ALTER TABLE `department` DISABLE KEYS */;
INSERT INTO `department` VALUES (1,'Khoa Công nghệ Thông tin','Chương trình đào tạo của Khoa Công nghệ Thông tin cung cấp kiến thức và kỹ năng cần thiết cho sinh viên để trở thành những kỹ sư phần mềm có trình độ cao. Chương trình đào tạo bao gồm các môn học về khoa học máy tính, kỹ thuật phần mềm, hệ thống máy tính, mạng máy tính và cơ sở dữ liệu. Sinh viên tốt nghiệp Khoa Công nghệ Thông tin có thể làm việc trong các lĩnh vực như phát triển phần mềm, quản trị mạng, quản trị hệ thống và tư vấn công nghệ thông tin.','https://www.uit.edu.vn/','https://www.youtube.com/watch?v=dQw4w9WgXcQ',8.5,1),(2,'Khoa Kinh tế','Chương trình đào tạo của Khoa Kinh tế cung cấp kiến thức và kỹ năng cần thiết cho sinh viên để trở thành những nhà kinh tế có trình độ cao. Chương trình đào tạo bao gồm các môn học về kinh tế học, tài chính, kế toán, quản trị kinh doanh và marketing. Sinh viên tốt nghiệp Khoa Kinh tế có thể làm việc trong các lĩnh vực như ngân hàng, tài chính, kế toán, quản lý, kinh doanh và marketing.','https://www.hus.edu.vn/','https://www.youtube.com/watch?v=dQw4w9WgXcQ',8,1),(3,'Khoa Luật','Chương trình đào tạo của Khoa Luật cung cấp kiến thức và kỹ năng cần thiết cho sinh viên để trở thành những luật sư có trình độ cao. Chương trình đào tạo bao gồm các môn học về luật học, pháp luật, tố tụng hình sự, tố tụng dân sự và luật kinh tế. Sinh viên tốt nghiệp Khoa Luật có thể làm việc trong các lĩnh vực như luật sư, thẩm phán, công tố viên, luật sư tư vấn và giảng dạy luật.','https://www.luật.vn/','https://www.youtube.com/watch?v=dQw4w9WgXcQ',7.5,3),(4,'Khoa Y','Chương trình đào tạo của Khoa Y cung cấp kiến thức và kỹ năng cần thiết cho sinh viên để trở thành những bác sĩ có trình độ cao. Chương trình đào tạo bao gồm các môn học về y học, giải phẫu học, sinh lý học, dược lý học và bệnh học. Sinh viên tốt nghiệp Khoa Y có thể làm việc trong các lĩnh vực như bác sĩ, phẫu thuật viên, bác sĩ nội trú và bác sĩ đa khoa.','https://www.ykhoahanoi.edu.vn/','https://www.youtube.com/watch?v=dQw4w9WgXcQ',9,1),(5,'Khoa Dược','Chương trình đào tạo của Khoa Dược cung cấp kiến thức và kỹ năng cần thiết cho sinh viên để trở thành những dược sĩ có trình độ cao. Chương trình đào tạo bao gồm các môn học về dược học, hóa học, sinh học, dược lý học và bào chế thuốc. Sinh viên tốt nghiệp Khoa Dược có thể làm việc trong các lĩnh vực như dược sĩ, nhà nghiên cứu dược phẩm và kiểm soát chất lượng thuốc.','https://www.dược.vn/','https://www.youtube.com/watch?v=dQw4w9WgXcQ',8.5,2),(6,'Khoa Giáo dục','Chương trình đào tạo của Khoa Giáo dục cung cấp kiến thức và kỹ năng cần thiết cho sinh viên để trở thành những giáo viên có trình độ cao. Chương trình đào tạo bao gồm các môn học về giáo dục học, tâm lý học giáo dục, phương pháp giảng dạy và quản lý giáo dục. Sinh viên tốt nghiệp Khoa Giáo dục có thể làm việc trong các lĩnh vực như giáo viên, nhà quản lý giáo dục và nhà nghiên cứu giáo dục.','https://www.gd.vn/','https://www.youtube.com/watch?v=dQw4w9WgXcQ',8,2);
/*!40000 ALTER TABLE `department` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `livestream`
--

DROP TABLE IF EXISTS `livestream`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `livestream` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_unicode_ci NOT NULL,
  `description` text CHARACTER SET utf8mb3 COLLATE utf8mb3_unicode_ci NOT NULL,
  `start_date` date NOT NULL,
  `start_time` time NOT NULL,
  `recruitment_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_re_live_idx` (`recruitment_id`),
  CONSTRAINT `fk_re_live` FOREIGN KEY (`recruitment_id`) REFERENCES `recruitment` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `livestream`
--

LOCK TABLES `livestream` WRITE;
/*!40000 ALTER TABLE `livestream` DISABLE KEYS */;
INSERT INTO `livestream` VALUES (1,'Livestream 1','This is a livestream about the latest news.','2023-03-08','10:04:50',NULL),(2,'Livestream 2','This is a livestream about a new product launch.','2023-03-09','01:23:45',NULL),(3,'Livestream 3','This is a livestream about a live event.','2023-03-10','14:56:32',NULL),(4,'Livestream 4','This is a livestream about a Q&A session.','2023-03-11','23:45:00',NULL),(5,'Livestream 5','This is a livestream about a live chat.','2023-03-12','04:00:00',NULL),(6,'Livestream 6','This is a livestream about a live game.','2023-03-13','12:00:00',NULL),(7,'Livestream 7','This is a livestream about a live concert.','2023-03-14','22:00:00',NULL),(8,'Livestream 8','This is a livestream about a live performance.','2023-03-15','18:00:00',NULL),(9,'Livestream 9','This is a livestream about a live event.','2023-03-16','06:00:00',NULL),(10,'Livestream 10','This is a livestream about a live event.','2023-03-17','06:00:00',NULL);
/*!40000 ALTER TABLE `livestream` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `major`
--

DROP TABLE IF EXISTS `major`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `major` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `department_id` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_dpm_major_idx` (`department_id`),
  CONSTRAINT `fk_dpm_major` FOREIGN KEY (`department_id`) REFERENCES `department` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `major`
--

LOCK TABLES `major` WRITE;
/*!40000 ALTER TABLE `major` DISABLE KEYS */;
INSERT INTO `major` VALUES (1,'Kỹ thuật phần mềm',1),(2,'Kinh tế',2),(3,'Xây dựng',3),(4,'Y khoa',4),(5,'Luật',5),(6,'Nông nghiệp',6),(8,'Kỹ thuật phần mềm',1),(9,'Kinh tế',2),(10,'Xây dựng',3),(11,'Y khoa',4),(12,'Luật',5),(13,'Nông nghiệp',6),(14,'Tài chính - Ngân hàng',3),(15,'Du lịch',5);
/*!40000 ALTER TABLE `major` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `news`
--

DROP TABLE IF EXISTS `news`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `news` (
  `id` int NOT NULL AUTO_INCREMENT,
  `title` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_unicode_ci NOT NULL,
  `content` text CHARACTER SET utf8mb3 COLLATE utf8mb3_unicode_ci NOT NULL,
  `created_date` datetime NOT NULL,
  `updated_date` datetime NOT NULL,
  `status` tinyint NOT NULL,
  `recruitment_id` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_re_news_idx` (`recruitment_id`),
  CONSTRAINT `fk_re_news` FOREIGN KEY (`recruitment_id`) REFERENCES `recruitment` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `news`
--

LOCK TABLES `news` WRITE;
/*!40000 ALTER TABLE `news` DISABLE KEYS */;
INSERT INTO `news` VALUES (1,'Tuyển sinh hệ chính quy năm 2023','Tuyển sinh hệ chính quy năm 2023. Thời gian tuyển sinh từ ngày 10 tháng 1 đến ngày 30 tháng 4 năm 2023. Yêu cầu tuyển sinh: Tốt nghiệp THPT hoặc tương đương. Điểm chuẩn: 24 điểm.','2023-07-14 07:08:58','2023-08-14 07:08:58',0,2),(2,'Tuyển sinh hệ liên thông năm 2023','Tuyển sinh hệ liên thông năm 2023. Thời gian tuyển sinh từ ngày 1 tháng 5 đến ngày 30 tháng 6 năm 2023. Yêu cầu tuyển sinh: Tốt nghiệp trung cấp hoặc cao đẳng. Điểm chuẩn: 20 điểm.','2023-08-05 07:09:10','2023-08-11 07:09:10',0,1),(3,'Tuyển sinh cao học năm 2023','Tuyển sinh cao học năm 2023. Thời gian tuyển sinh từ ngày 1 tháng 7 đến ngày 31 tháng 8 năm 2023. Yêu cầu tuyển sinh: Tốt nghiệp đại học. Điểm chuẩn: 28 điểm.','2023-08-05 08:46:52','2023-08-14 07:09:34',0,1),(4,'Tuyển sinh thạc sĩ năm 2023','Tuyển sinh thạc sĩ năm 2023. Thời gian tuyển sinh từ ngày 1 tháng 9 đến ngày 30 tháng 10 năm 2023. Yêu cầu tuyển sinh: Tốt nghiệp thạc sĩ. Điểm chuẩn: 32 điểm.','2023-08-05 08:46:52','2023-08-07 08:46:52',0,1),(5,'Tuyển sinh đào tạo từ xa năm 2023','Tuyển sinh đào tạo từ xa năm 2023. Thời gian tuyển sinh từ ngày 1 tháng 11 đến ngày 31 tháng 12 năm 2023. Yêu cầu tuyển sinh: Tốt nghiệp THPT hoặc tương đương. Điểm chuẩn: 22 điểm.','2023-08-12 07:09:46','2023-08-14 07:09:46',0,1);
/*!40000 ALTER TABLE `news` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `question`
--

DROP TABLE IF EXISTS `question`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `question` (
  `id` int NOT NULL AUTO_INCREMENT,
  `content` text NOT NULL,
  `answer` text NOT NULL,
  `user_id` int NOT NULL,
  `livestream_id` int NOT NULL,
  `created_date` datetime NOT NULL,
  `answered_date` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_userid_ques_users_idx` (`user_id`),
  KEY `fk_liveid_ques_live_idx` (`livestream_id`),
  CONSTRAINT `fk_liveid_ques_live` FOREIGN KEY (`livestream_id`) REFERENCES `livestream` (`id`),
  CONSTRAINT `fk_userid_ques_users` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `question`
--

LOCK TABLES `question` WRITE;
/*!40000 ALTER TABLE `question` DISABLE KEYS */;
INSERT INTO `question` VALUES (1,'Khi nào là thời gian tốt nhất để đăng ký học?','Thời gian tốt nhất để đăng ký học là khi bạn đã có quyết định và sẵn sàng bắt đầu. Tuy nhiên, nếu bạn vẫn đang phân vân, bạn có thể đăng ký học sớm hơn để có thêm thời gian suy nghĩ.',1,5,'2023-08-05 09:12:41','2023-08-05 09:13:31'),(2,'Tôi có thể học gì sau khi tốt nghiệp?','Sau khi tốt nghiệp, bạn có thể học tiếp lên cao hoặc tìm kiếm một công việc. Nếu bạn muốn học tiếp lên cao, bạn có thể học thạc sĩ hoặc tiến sĩ. Nếu bạn muốn tìm kiếm một công việc, bạn có thể tìm kiếm một công việc trong lĩnh vực mà bạn đã học hoặc tìm kiếm một công việc trong một lĩnh vực khác.',2,1,'2023-08-05 09:12:41','2023-08-05 09:14:40'),(3,'Tôi có thể làm gì để chuẩn bị cho kỳ thi?','Bạn có thể chuẩn bị cho kỳ thi bằng cách học tập chăm chỉ và làm bài tập về nhà. Bạn cũng có thể tham gia các lớp học luyện thi và ôn tập các đề thi cũ.',3,1,'2023-08-05 09:12:41','2023-08-05 09:14:40'),(4,'Tôi nên chọn trường nào?','Bạn nên chọn trường dựa trên các yếu tố như chất lượng giảng dạy, cơ sở vật chất, vị trí và chi phí. Bạn cũng nên xem xét các yếu tố cá nhân như sở thích và nhu cầu của bạn.',4,4,'2023-08-05 09:12:41','2023-08-05 09:14:40'),(5,'Tôi có thể học trực tuyến được không?','Có, bạn có thể học trực tuyến. Có rất nhiều chương trình học trực tuyến có chất lượng cao. Bạn có thể tìm kiếm các chương trình học trực tuyến trên các trang web như Coursera, edX và Udacity.',5,2,'2023-08-05 09:12:41','2023-08-05 09:14:40'),(6,'Tôi có thể làm gì nếu tôi không đạt được điểm cao trong kỳ thi?','Nếu bạn không đạt được điểm cao trong kỳ thi, bạn có thể làm lại kỳ thi. Bạn cũng có thể tìm kiếm các chương trình học khác hoặc tìm kiếm một công việc mà không cần bằng cấp.',6,1,'2023-08-05 09:12:41','2023-08-05 09:14:40'),(7,'Tôi có thể làm gì nếu tôi không biết mình muốn học gì?','Nếu bạn không biết mình muốn học gì, bạn có thể tham khảo ý kiến của bạn bè, gia đình và cố vấn học tập. Bạn cũng có thể tìm kiếm các bài kiểm tra và bài trắc nghiệm trực tuyến để giúp bạn tìm ra con đường sự nghiệp phù hợp với mình.',7,3,'2023-08-05 09:12:41','2023-08-05 09:14:40'),(8,'Tôi có thể làm gì nếu tôi không có đủ tiền để học?','Nếu bạn không có đủ tiền để học, bạn có thể tìm kiếm các học bổng và trợ cấp. Bạn cũng có thể tìm kiếm các chương trình học miễn phí hoặc giá rẻ.',8,3,'2023-08-05 09:12:41','2023-08-05 09:14:40'),(9,'Tôi có thể làm gì nếu tôi không có thời gian để học?','Nếu bạn không có thời gian để học, bạn có thể tìm kiếm các chương trình học online hoặc các chương trình học có thể hoàn thành trong thời gian ngắn. Bạn cũng có thể tìm kiếm các chương trình học có thể học ngoài giờ làm việc.',9,2,'2023-08-05 09:12:41','2023-08-05 09:14:40'),(10,'Tôi có thể làm gì nếu tôi không biết tiếng Anh?','Nếu bạn không biết tiếng Anh, bạn có thể tìm kiếm các chương trình học có giảng dạy bằng tiếng Anh. Bạn cũng có thể tìm kiếm các khóa học tiếng Anh để giúp bạn cải thiện khả năng ngôn ngữ của mình.',10,3,'2023-08-05 09:12:41','2023-08-05 09:14:40');
/*!40000 ALTER TABLE `question` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `recruitment`
--

DROP TABLE IF EXISTS `recruitment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `recruitment` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `description` text NOT NULL,
  `start_date` date NOT NULL,
  `end_date` date NOT NULL,
  `type` varchar(10) NOT NULL,
  `deparment_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_category_idx` (`deparment_id`),
  CONSTRAINT `fk_category` FOREIGN KEY (`deparment_id`) REFERENCES `department` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `recruitment`
--

LOCK TABLES `recruitment` WRITE;
/*!40000 ALTER TABLE `recruitment` DISABLE KEYS */;
INSERT INTO `recruitment` VALUES (1,'Tuyển sinh đại học chính quy 2023','Tuyển sinh đại học chính quy 2023','2023-06-01','2023-07-31','Xét tuyển',1),(2,'Tuyển sinh đại học chính quy 2023','Tuyển sinh đại học chính quy 2023','2023-06-01','2023-07-31','Xét tuyển',1),(3,'Tuyển sinh đại học chính quy 2023','Tuyển sinh đại học chính quy 2023','2023-06-01','2023-07-31','Xét tuyển',1),(4,'Tuyển sinh đại học chính quy 2023','Tuyển sinh đại học chính quy 2023','2023-06-01','2023-07-31','Xét tuyển',1);
/*!40000 ALTER TABLE `recruitment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `role`
--

DROP TABLE IF EXISTS `role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `role` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_unicode_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `role`
--

LOCK TABLES `role` WRITE;
/*!40000 ALTER TABLE `role` DISABLE KEYS */;
INSERT INTO `role` VALUES (1,'admin'),(2,'user');
/*!40000 ALTER TABLE `role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `score`
--

DROP TABLE IF EXISTS `score`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `score` (
  `id` int NOT NULL AUTO_INCREMENT,
  `major_id` int NOT NULL,
  `year` year NOT NULL,
  `score` float NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_major_score_idx` (`major_id`),
  CONSTRAINT `fk_major_score` FOREIGN KEY (`major_id`) REFERENCES `major` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `score`
--

LOCK TABLES `score` WRITE;
/*!40000 ALTER TABLE `score` DISABLE KEYS */;
INSERT INTO `score` VALUES (1,1,2023,22),(2,3,2022,21),(3,5,2021,20),(4,5,2020,19),(5,3,2019,18);
/*!40000 ALTER TABLE `score` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `id` int NOT NULL AUTO_INCREMENT,
  `first_name` varchar(45) CHARACTER SET utf8mb3 COLLATE utf8mb3_unicode_ci NOT NULL,
  `last_name` varchar(45) CHARACTER SET utf8mb3 COLLATE utf8mb3_unicode_ci NOT NULL,
  `email` varchar(45) CHARACTER SET utf8mb3 COLLATE utf8mb3_unicode_ci NOT NULL,
  `phone` varchar(45) CHARACTER SET utf8mb3 COLLATE utf8mb3_unicode_ci NOT NULL,
  `username` varchar(45) CHARACTER SET utf8mb3 COLLATE utf8mb3_unicode_ci NOT NULL,
  `password` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_unicode_ci NOT NULL,
  `avatar` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_unicode_ci NOT NULL,
  `user_role` int NOT NULL,
  `date_of_bird` date DEFAULT NULL,
  `active` bit(1) NOT NULL DEFAULT b'1',
  PRIMARY KEY (`id`),
  UNIQUE KEY `email_UNIQUE` (`email`),
  UNIQUE KEY `username_UNIQUE` (`username`),
  UNIQUE KEY `phone_UNIQUE` (`phone`),
  KEY `fk_roleid_users_roles_idx` (`user_role`),
  CONSTRAINT `fk_roleid_users_roles` FOREIGN KEY (`user_role`) REFERENCES `role` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'Cảnh','Điều Ngọc','canhdieungoc@gmail.com','0504146784','canhdieungoc','canhdieungoc123@','https://res.cloudinary.com/ds8i6jriz/image/upload/v1691837083/MyImages/UniversityEntrance/avatar/avt3_atudsl.jpg',1,'2004-01-07',_binary ''),(2,'Khang','Nhan Nguyên','khangnhannguyen@gmail.com','0119030299','khangnhannguyen','khangnhannguyen123@','https://res.cloudinary.com/ds8i6jriz/image/upload/v1691837083/MyImages/UniversityEntrance/avatar/avt2_nwbeon.jpg',1,'2000-01-04',_binary ''),(3,'Hiệp','Mạc Hoàng','hiepmachoang@gmail.com','0206696076','hiepmachoang','hiepmachoang123@','https://res.cloudinary.com/ds8i6jriz/image/upload/v1691837082/MyImages/UniversityEntrance/avatar/avt1_bgmadm.jpg',2,'2003-03-27',_binary ''),(4,'Luật','Thái Công','luatthaicong@gmail.com','0585418152','luatthaicong','luatthaicong123@','https://res.cloudinary.com/ds8i6jriz/image/upload/v1691837082/MyImages/UniversityEntrance/avatar/avt4_byi2ba.jpg',2,'2003-10-03',_binary ''),(5,'Quân','Nguyễn Hải','quannguyenhai@gmail.com','0757844680','quannguyenhai','quannguyenhai123@','https://res.cloudinary.com/ds8i6jriz/image/upload/v1691837083/MyImages/UniversityEntrance/avatar/avt3_atudsl.jpg',2,'2004-04-30',_binary ''),(6,'Quỳnh','Hình Mạnh','quynhhinhmanh@gmail.com','0700454988','quynhhinhmanh','quynhhinhmanh123@','https://res.cloudinary.com/ds8i6jriz/image/upload/v1691837083/MyImages/UniversityEntrance/avatar/avt2_nwbeon.jpg',2,'2003-07-05',_binary '\0'),(7,'Thanh','Ngọ Chí','thanhngochi@gmail.com','0696697454','thanhngochi','thanhngochi123@','https://res.cloudinary.com/ds8i6jriz/image/upload/v1691837082/MyImages/UniversityEntrance/avatar/avt1_bgmadm.jpg',2,'2003-12-10',_binary ''),(8,'Châu','Bạch Tùng','chaubachtung@gmail.com','0719484192','chaubachtung','chaubachtung123@','https://res.cloudinary.com/ds8i6jriz/image/upload/v1691837082/MyImages/UniversityEntrance/avatar/avt4_byi2ba.jpg',2,'2003-10-22',_binary '\0'),(9,'Nam','Mộc Hoàng','nammochoang@gmail.com','0195774102','nammochoang','nammochoang123@','https://res.cloudinary.com/ds8i6jriz/image/upload/v1691837083/MyImages/UniversityEntrance/avatar/avt2_nwbeon.jpg',2,'2000-02-18',_binary ''),(10,'Trường','Tấn Quang','truongtanquang@gmail.com','0649900171','truongtanquang','truongtanquang123@','https://res.cloudinary.com/ds8i6jriz/image/upload/v1691837082/MyImages/UniversityEntrance/avatar/avt4_byi2ba.jpg',2,'2001-03-10',_binary '\0'),(11,'Trụ','Nguyễn Tấn','tru@gmail.com','0123456789','user','123','https://res.cloudinary.com/ds8i6jriz/image/upload/v1691837082/MyImages/UniversityEntrance/avatar/avt4_byi2ba.jpg',2,'2004-01-04',_binary ''),(12,'Trụ','Tấn','nguyentantru@gmail.com','0784674775','tru','123','https://res.cloudinary.com/ds8i6jriz/image/upload/v1693327162/b8cevacwo28j5wfc9o5m.png',1,'2004-01-04',_binary ''),(13,'tru','ab','nguyentantru142002@gmail.com','0738888387','tan','$2a$10$Rq97khMnY1Gmu2IQKxnxfOLA/1FGJIKLxz9/mWOKWWO14l7YPmRhe','https://res.cloudinary.com/ds8i6jriz/image/upload/v1694301023/eokfegto9df1gvnhjzyh.png',1,NULL,_binary '\0');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-09-10  7:11:31
