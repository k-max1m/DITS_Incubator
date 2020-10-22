CREATE DATABASE IF NOT EXISTS `dits`;
USE `dits`;

CREATE TABLE IF NOT EXISTS `dits`.`topic` (
    `statisticId` INT NOT NULL unique,
    `date` date NULL,
    'correct'  boolean,
    'questionId' INT NOT NULL,
    'userId' INT NOT NULL,
    PRIMARY KEY (`statisticId`),
    FOREIGN KEY question(`questionId`) 
    REFERENCES question(`questionId`)
    FOREIGN KEY user(`userId`)
    REFERENCES user(`userId`)
  );

CREATE TABLE IF NOT EXISTS `dits`.`test` (
    `statisticId` INT NOT NULL unique,
    `date` date NULL,
    'correct'  boolean,
    'questionId' INT NOT NULL,
    'userId' INT NOT NULL,
    PRIMARY KEY (`statisticId`),
    FOREIGN KEY question(`questionId`) 
    REFERENCES question(`questionId`)
    FOREIGN KEY user(`userId`)
    REFERENCES user(`userId`)
  );
  
  CREATE TABLE IF NOT EXISTS `dits`.`question` (
    `linkId` INT NOT NULL unique,
    `link` VARCHAR(255) NULL,
    `literatureId` INT NOT NULL,
    PRIMARY KEY (`linkId`),
    FOREIGN KEY (`literatureId`) 
    REFERENCES literature(`literatureId`)
  );
  
  CREATE TABLE IF NOT EXISTS `dits`.`answer` (
    `answerId` INT NOT NULL unique,
    `description` VARCHAR(255) NULL,
    `correct` BOOLEAN DEFAULT 0,
    `questionId` INT NOT NULL,
    PRIMARY KEY (`answerId`),
    FOREIGN KEY (`questionId`)
    REFERENCES question(`questionId`)
  );

CREATE TABLE IF NOT EXISTS `dits`.`role` (
    `roleId` INT NOT NULL unique,
    'tutor' binary,
    'user' binary,
    'admin' binary,
    PRIMARY KEY (`roleId`),
    );

CREATE TABLE IF NOT EXISTS `dits`.`user` (
    `userId` INT NOT NULL unique,
    `firstName` varchar,
    'lastName'  varchar,
    'login' varchar,
    'password' varchar,
    'roleId'
    PRIMARY KEY (`userId`),
    FOREIGN KEY (`roleId`) 
    REFERENCES role(`roleId`)
    );

CREATE TABLE IF NOT EXISTS `dits`.`statistic` (
    `statisticId` INT NOT NULL uniqueT,
    `date` date NULL,
    'correct'  boolean,
    'questionId' INT NOT NULL,
    'userId' INT NOT NULL,
    PRIMARY KEY (`statisticId`),
    FOREIGN KEY question(`questionId`) 
    REFERENCES question(`questionId`)
    FOREIGN KEY user(`userId`)
    REFERENCES user(`userId`)
  );

CREATE TABLE IF NOT EXISTS `dits`.`literature` (
    `literatureId` INT NOT NULL unique,
    `description` VARCHAR(255) NULL,
    `questionId` INT NOT NULL,
    PRIMARY KEY (`literatureId`),
    FOREIGN KEY (`questionId`)
    REFERENCES question(`questionId`)
  );
  
CREATE TABLE IF NOT EXISTS `dits`.`link` (
    `linkId` INT NOT NULL unique,
    `link` VARCHAR(255) NULL,
    `literatureId` INT NOT NULL,
    PRIMARY KEY (`linkId`),
    FOREIGN KEY (`literatureId`)
    REFERENCES literature(`literatureId`)
  );  
 
INSERT INTO `dits`.`role` (`roleId`, `tutor`, `user`, `admin`) VALUES ('1', 'true', 'false', 'false');
INSERT INTO `dits`.`role` (`roleId`, `tutor`, `user`, `admin`) VALUES ('2', 'false', 'false', 'true');

INSERT INTO `dits`.`user` (`userId`, `firstName`, `lastName`, `login`, `password`, `roleId`) VALUES ('1', 'Jora', 'Jenkins', 'JJen','JlikeChe1', '1');
INSERT INTO `dits`.`user` (`userId`, `firstName`, `lastName`, `login`, `password`, `roleId`) VALUES ('2', 'Artem', 'Rudiy', 'ArRudiy','Pushka02', '2');

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
INSERT INTO `dits`.`answer` (`answerId`, `description`, `correct`, `questionId`) VALUES ('2', 'description2', '2', '2');
INSERT INTO `dits`.`answer` (`answerId`, `description`, `correct`, `questionId`) VALUES ('3', 'description3', '3', '3');
INSERT INTO `dits`.`answer` (`answerId`, `description`, `correct`, `questionId`) VALUES ('4', 'description4', '4', '4');
INSERT INTO `dits`.`answer` (`answerId`, `description`, `correct`, `questionId`) VALUES ('5', 'description5', '5', '5');
INSERT INTO `dits`.`answer` (`answerId`, `description`, `correct`, `questionId`) VALUES ('6', 'description6', '6', '6');
INSERT INTO `dits`.`answer` (`answerId`, `description`, `correct`, `questionId`) VALUES ('7', 'description7', '7', '7');
INSERT INTO `dits`.`answer` (`answerId`, `description`, `correct`, `questionId`) VALUES ('8', 'description8', '8', '8');
INSERT INTO `dits`.`answer` (`answerId`, `description`, `correct`, `questionId`) VALUES ('9', 'description9', '9', '9');
INSERT INTO `dits`.`answer` (`answerId`, `description`, `correct`, `questionId`) VALUES ('10', 'description10', '10', '10');

  
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

DROP PROCEDURE if exists stat;
create procedure user_stat(id int) 
	select 
		COUNT(0) AS `all_answers`,
		SUM(`statistic`.`correct`) AS `correct`,
        (COUNT(`statistic`.`correct`) - SUM(`statistic`.`correct`)) AS `incorrect`
	from `statistic`
where `userId` = id;
    
