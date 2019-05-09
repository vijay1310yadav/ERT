/*create database employee;
create table employee_details;
SELECT * FROM employee.employeedetails;
INSERT INTO employeedetails VALUE(3,"Rajat","Salvi","rajatsalvi6@gmail.com",15-11-1996,"IT");
select * from employee_details;
update employeedetails set imageurl="https://upload.wikimedia.org/wikipedia/commons/4/4d/Profile_Picture_for_user_MereTechnicality_%281%29.png" where id=2;
*/

CREATE DATABASE IF NOT EXISTS `employee` ;
USE `employee`;
--
-- Table structure for table `employee_details`
--

DROP TABLE IF EXISTS `employee_details`;
CREATE TABLE `employee_details` (
  `employee_id` int(11) NOT NULL AUTO_INCREMENT,
  `first_name` varchar(45) DEFAULT NULL,
  `last_name` varchar(45) DEFAULT NULL,
  `email_id` varchar(45) DEFAULT NULL,
  `dob` varchar(45) DEFAULT NULL,
  `department` varchar(45) DEFAULT NULL,
  `image_url` varchar(300) DEFAULT NULL,
  `attendance` boolean DEFAULT false,
  PRIMARY KEY (`employee_id`)
);
--
-- Dumping data for table `employee_details`
--

LOCK TABLES `employee_details` WRITE;

INSERT INTO `employee_details` VALUES 
	(1,'Vijay','Yadav','vijay@karma.com','1994','I.T.','https://i.stack.imgur.com/dWrvS.png',true),
	(2,'Rajat','Salvi','rajat@karma.com','1994','I.T.','https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRMNOGI8FsbGX3zNdouW6Mjlpnt54Oc-e2OVmwMp3GzCrXpCGeF',true),
	(3,'Ajay','Mall','ajay@karma.com','1994','I.T.','https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRG9WGU-2xz1aprfxl2_4xTXwmKDSKhoTCra-cetPu9QzyJB6hy',false),
	(4,'Siddhi','Raut','siddhi@karma.com','1994','I.T.','https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQPYSkanP2B1jZQ6IxaOU3TruroEZgN40WWdpAmo4IKxCr7vH4I',true),
	(5,'Hemant','Kambli','hemant@karma.com','Not Known','I.T.','http://clipart-library.com/img/1644270.png',true);

-- Dump completed on 2016-09-24 21:50:59






