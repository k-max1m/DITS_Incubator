CREATE DATABASE IF NOT EXISTS `dits`;
USE `dits`;

CREATE TABLE IF NOT EXISTS `dits`.`topic` (
    `topicId` INT NOT NULL unique,
    `discription` varchar(255),
    `name`  varchar(255),
    PRIMARY KEY (`topicId`)
);

CREATE TABLE IF NOT EXISTS `dits`.`role` (
    `roleId` INT NOT NULL unique,
    `tutor` binary,
    `user` binary,
    `admin` binary,
    PRIMARY KEY (`roleId`)
    );

CREATE TABLE IF NOT EXISTS `dits`.`test` (
    `testId` INT NOT NULL unique,
	`name`  varchar(255),
    `discription` varchar(255),
    `topicId` INT NOT NULL,
    PRIMARY KEY (`testId`),
    FOREIGN KEY (`topicId`) 
    REFERENCES `topic`(`topicId`)
  );
  
  CREATE TABLE IF NOT EXISTS  `dits`.`question` (
	`questionId` INT NOT NULL unique,
	`description` VARCHAR(255) NULL,
	`testId` INT NOT NULL,
	PRIMARY KEY (`questionId`),
	FOREIGN KEY (`testId`)
    REFERENCES `test` (`testId`)
);
  
  CREATE TABLE IF NOT EXISTS `dits`.`answer` (
    `answerId` INT NOT NULL unique,
    `description` VARCHAR(255) NULL,
    `correct` BOOLEAN DEFAULT 0,
    `questionId` INT NOT NULL,
    PRIMARY KEY (`answerId`),
    FOREIGN KEY (`questionId`)
    REFERENCES `question`(`questionId`)
  );

CREATE TABLE IF NOT EXISTS `dits`.`user` (
    `userId` INT NOT NULL unique,
    `firstName` varchar(45) NULL,
    `lastName`  varchar(45) NULL,
    `login` varchar(255) NOT NULL,
    `password` varchar(255) NOT NULL,
    `roleId` INT NOT NULL,
    PRIMARY KEY (`userId`),
    FOREIGN KEY (`roleId`) 
    REFERENCES `role`(`roleId`)
    );

CREATE TABLE IF NOT EXISTS `dits`.`statistic` (
    `statisticId` INT NOT NULL unique,
    `date` date NULL,
    `correct`  boolean,
    `questionId` INT NOT NULL,
    `userId` INT NOT NULL,
    PRIMARY KEY (`statisticId`),
    FOREIGN KEY (`questionId`) 
    REFERENCES `question`(`questionId`),
    FOREIGN KEY (`userId`)
    REFERENCES `user`(`userId`)
  );

CREATE TABLE IF NOT EXISTS `dits`.`literature` (
    `literatureId` INT NOT NULL unique,
    `description` VARCHAR(255) NULL,
    `questionId` INT NOT NULL,
    PRIMARY KEY (`literatureId`),
    FOREIGN KEY (`questionId`)
    REFERENCES `question`(`questionId`)
  );
  
CREATE TABLE IF NOT EXISTS `dits`.`link` (
    `linkId` INT NOT NULL unique,
    `link` VARCHAR(255) NULL,
    `literatureId` INT NOT NULL,
    PRIMARY KEY (`linkId`),
    FOREIGN KEY (`literatureId`)
    REFERENCES `literature`(`literatureId`)
  );  
 
INSERT INTO `dits`.`topic` (`topicId`, `description`, `name`) VALUES ('1', 'description1', 'topic1');
INSERT INTO `dits`.`topic` (`topicId`, `description`, `name`) VALUES ('2', 'description2', 'topic2');

INSERT INTO `dits`.`role` (`roleId`, `tutor`, `user`, `admin`) VALUES ('1', 'true', 'false', 'false');
INSERT INTO `dits`.`role` (`roleId`, `tutor`, `user`, `admin`) VALUES ('2', 'false', 'false', 'true');

INSERT INTO `dits`.`user` (`userId`, `firstName`, `lastName`, `login`, `password`, `roleId`) VALUES ('1', 'Jora', 'Jenkins', 'JJen','JlikeChe1', '1');
INSERT INTO `dits`.`user` (`userId`, `firstName`, `lastName`, `login`, `password`, `roleId`) VALUES ('2', 'Artem', 'Rudiy', 'ArRudiy','Pushka02', '2');

INSERT INTO `dits`.`test` (`testId`, `name`, `description`, `topicId`) VALUES ('1', 'test1', 'description1', '1');
INSERT INTO `dits`.`test` (`testId`, `name`, `description`, `topicId`) VALUES ('2', 'test2', 'description2', '1');
INSERT INTO `dits`.`test` (`testId`, `name`, `description`, `topicId`) VALUES ('3', 'test3', 'description3', '2');
INSERT INTO `dits`.`test` (`testId`, `name`, `description`, `topicId`) VALUES ('4', 'test4', 'description4', '2');

INSERT INTO `dits`.`question` (`questionId`, `description`, `testId`) VALUES ('1', 'question1', '1');
INSERT INTO `dits`.`question` (`questionId`, `description`, `testId`) VALUES ('2', 'question2', '1');
INSERT INTO `dits`.`question` (`questionId`, `description`, `testId`) VALUES ('3', 'question1', '2');
INSERT INTO `dits`.`question` (`questionId`, `description`, `testId`) VALUES ('4', 'question2', '2');
INSERT INTO `dits`.`question` (`questionId`, `description`, `testId`) VALUES ('5', 'question1', '3');
INSERT INTO `dits`.`question` (`questionId`, `description`, `testId`) VALUES ('6', 'question2', '3');
INSERT INTO `dits`.`question` (`questionId`, `description`, `testId`) VALUES ('7', 'question1', '4');
INSERT INTO `dits`.`question` (`questionId`, `description`, `testId`) VALUES ('8', 'question2', '4');

INSERT INTO `dits`.`statistic` (`statisticId`, `date`, `correct`, `questionId`, `userId`) VALUES ('1', '2020-10-22', 'true', '1','1');
INSERT INTO `dits`.`statistic` (`statisticId`, `date`, `correct`, `questionId`, `userId`) VALUES ('2', '2020-10-22', 'true', '3','1');
INSERT INTO `dits`.`statistic` (`statisticId`, `date`, `correct`, `questionId`, `userId`) VALUES ('3', '2020-10-22', 'false', '2','1');
INSERT INTO `dits`.`statistic` (`statisticId`, `date`, `correct`, `questionId`, `userId`) VALUES ('4', '2020-10-22', 'true', '4','1');
INSERT INTO `dits`.`statistic` (`statisticId`, `date`, `correct`, `questionId`, `userId`) VALUES ('5', '2020-10-22', 'true', '5','1');
INSERT INTO `dits`.`statistic` (`statisticId`, `date`, `correct`, `questionId`, `userId`) VALUES ('6', '2020-10-22', 'false', '1','2');
INSERT INTO `dits`.`statistic` (`statisticId`, `date`, `correct`, `questionId`, `userId`) VALUES ('7', '2020-10-22', 'true', '2','2');
INSERT INTO `dits`.`statistic` (`statisticId`, `date`, `correct`, `questionId`, `userId`) VALUES ('8', '2020-10-22', 'false', '3','2');
INSERT INTO `dits`.`statistic` (`statisticId`, `date`, `correct`, `questionId`, `userId`) VALUES ('9', '2020-10-22', 'false', '4','2');
INSERT INTO `dits`.`statistic` (`statisticId`, `date`, `correct`, `questionId`, `userId`) VALUES ('10', '2020-10-22', 'true', '5','2');
 
INSERT INTO `dits`.`answer` (`answerId`, `description`, `correct`, `questionId`) VALUES ('1', 'description1', '1', '1');
INSERT INTO `dits`.`answer` (`answerId`, `description`, `correct`, `questionId`) VALUES ('2', 'description2', '0', '1');
INSERT INTO `dits`.`answer` (`answerId`, `description`, `correct`, `questionId`) VALUES ('3', 'description3', '0', '1');
INSERT INTO `dits`.`answer` (`answerId`, `description`, `correct`, `questionId`) VALUES ('4', 'description4', '0', '1');
INSERT INTO `dits`.`answer` (`answerId`, `description`, `correct`, `questionId`) VALUES ('5', 'description5', '1', '2');
INSERT INTO `dits`.`answer` (`answerId`, `description`, `correct`, `questionId`) VALUES ('6', 'description6', '0', '2');
INSERT INTO `dits`.`answer` (`answerId`, `description`, `correct`, `questionId`) VALUES ('7', 'description7', '0', '2');
INSERT INTO `dits`.`answer` (`answerId`, `description`, `correct`, `questionId`) VALUES ('8', 'description8', '0', '2');
INSERT INTO `dits`.`answer` (`answerId`, `description`, `correct`, `questionId`) VALUES ('9', 'description9', '1', '3');
INSERT INTO `dits`.`answer` (`answerId`, `description`, `correct`, `questionId`) VALUES ('10', 'description10', '0', '3');
INSERT INTO `dits`.`answer` (`answerId`, `description`, `correct`, `questionId`) VALUES ('11', 'description1', '0', '3');
INSERT INTO `dits`.`answer` (`answerId`, `description`, `correct`, `questionId`) VALUES ('12', 'description2', '0', '3');
INSERT INTO `dits`.`answer` (`answerId`, `description`, `correct`, `questionId`) VALUES ('13', 'description3', '1', '4');
INSERT INTO `dits`.`answer` (`answerId`, `description`, `correct`, `questionId`) VALUES ('14', 'description4', '0', '4');
INSERT INTO `dits`.`answer` (`answerId`, `description`, `correct`, `questionId`) VALUES ('15', 'description5', '0', '4');
INSERT INTO `dits`.`answer` (`answerId`, `description`, `correct`, `questionId`) VALUES ('16', 'description6', '0', '4');
INSERT INTO `dits`.`answer` (`answerId`, `description`, `correct`, `questionId`) VALUES ('17', 'description7', '1', '5');
INSERT INTO `dits`.`answer` (`answerId`, `description`, `correct`, `questionId`) VALUES ('18', 'description8', '0', '5');
INSERT INTO `dits`.`answer` (`answerId`, `description`, `correct`, `questionId`) VALUES ('19', 'description9', '0', '5');
INSERT INTO `dits`.`answer` (`answerId`, `description`, `correct`, `questionId`) VALUES ('20', 'description10', '0', '5');
INSERT INTO `dits`.`answer` (`answerId`, `description`, `correct`, `questionId`) VALUES ('21', 'description10', '1', '6');
INSERT INTO `dits`.`answer` (`answerId`, `description`, `correct`, `questionId`) VALUES ('22', 'description1', '0', '6');
INSERT INTO `dits`.`answer` (`answerId`, `description`, `correct`, `questionId`) VALUES ('23', 'description2', '0', '6');
INSERT INTO `dits`.`answer` (`answerId`, `description`, `correct`, `questionId`) VALUES ('24', 'description3', '0', '6');
INSERT INTO `dits`.`answer` (`answerId`, `description`, `correct`, `questionId`) VALUES ('25', 'description4', '1', '7');
INSERT INTO `dits`.`answer` (`answerId`, `description`, `correct`, `questionId`) VALUES ('26', 'description5', '0', '7');
INSERT INTO `dits`.`answer` (`answerId`, `description`, `correct`, `questionId`) VALUES ('27', 'description6', '0', '7');
INSERT INTO `dits`.`answer` (`answerId`, `description`, `correct`, `questionId`) VALUES ('28', 'description7', '0', '7');
INSERT INTO `dits`.`answer` (`answerId`, `description`, `correct`, `questionId`) VALUES ('29', 'description8', '1', '8');
INSERT INTO `dits`.`answer` (`answerId`, `description`, `correct`, `questionId`) VALUES ('30', 'description9', '0', '8');
INSERT INTO `dits`.`answer` (`answerId`, `description`, `correct`, `questionId`) VALUES ('31', 'description10', '0', '8');
INSERT INTO `dits`.`answer` (`answerId`, `description`, `correct`, `questionId`) VALUES ('32', 'description10', '0', '8');
  
INSERT INTO `dits`.`literature` (`literatureId`, `description`, `questionId`) VALUES ('1', 'description1', '1');
INSERT INTO `dits`.`literature` (`literatureId`, `description`, `questionId`) VALUES ('2', 'description2', '2');
INSERT INTO `dits`.`literature` (`literatureId`, `description`, `questionId`) VALUES ('3', 'description3', '3');
INSERT INTO `dits`.`literature` (`literatureId`, `description`, `questionId`) VALUES ('4', 'description4', '4');
INSERT INTO `dits`.`literature` (`literatureId`, `description`, `questionId`) VALUES ('5', 'description5', '5');
INSERT INTO `dits`.`literature` (`literatureId`, `description`, `questionId`) VALUES ('6', 'description6', '6');
INSERT INTO `dits`.`literature` (`literatureId`, `description`, `questionId`) VALUES ('7', 'description7', '7');
INSERT INTO `dits`.`literature` (`literatureId`, `description`, `questionId`) VALUES ('8', 'description8', '8');
INSERT INTO `dits`.`literature` (`literatureId`, `description`, `questionId`) VALUES ('9', 'description9', '9');
INSERT INTO `dits`.`literature` (`literatureId`, `description`, `questionId`) VALUES ('10', 'description10', '10');

INSERT INTO `dits`.`link` (`linkId`, `link`, `literatureId`) VALUES ('1', 'link1', '1');
INSERT INTO `dits`.`link` (`linkId`, `link`, `literatureId`) VALUES ('2', 'link2', '2');
INSERT INTO `dits`.`link` (`linkId`, `link`, `literatureId`) VALUES ('3', 'link3', '3');
INSERT INTO `dits`.`link` (`linkId`, `link`, `literatureId`) VALUES ('4', 'link4', '4');
INSERT INTO `dits`.`link` (`linkId`, `link`, `literatureId`) VALUES ('5', 'link5', '5');
INSERT INTO `dits`.`link` (`linkId`, `link`, `literatureId`) VALUES ('6', 'link6', '6');
INSERT INTO `dits`.`link` (`linkId`, `link`, `literatureId`) VALUES ('7', 'link7', '7');
INSERT INTO `dits`.`link` (`linkId`, `link`, `literatureId`) VALUES ('8', 'link8', '8');
INSERT INTO `dits`.`link` (`linkId`, `link`, `literatureId`) VALUES ('9', 'link9', '9');
INSERT INTO `dits`.`link` (`linkId`, `link`, `literatureId`) VALUES ('10', 'link10', '10');

CREATE OR REPLACE VIEW user_statistic AS
 SELECT
        user.userId AS userId,
        COUNT(*) AS allAnswers,
        SUM(`statistic`.`correct`) AS correctAnswers,
        COUNT(`statistic`.`correct`) - SUM(`statistic`.`correct`) AS incorrectAnswers
    FROM
        (`statistic`
        JOIN user ON (`statistic`.`userId` = user.`userId`))
    GROUP BY statistic.userId;
    
DROP PROCEDURE if exists test_stat;
create procedure test_stat(id int) 
	select count(qs.answerId) from
	(select * from statistic s join question q on s.questionId = q.questionId join answer a on s.questionId = a.questionId where testId = id) qs 
	group by qs.correct;
