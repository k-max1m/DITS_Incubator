CREATE DATABASE IF NOT EXISTS `dits`;
USE `dits`;

CREATE TABLE IF NOT EXISTS `dits`.`answer` (
    `answerId` INT NOT NULL AUTO_INCREMENT,
    `description` VARCHAR(255) NULL,
    `correct` BOOLEAN DEFAULT 0,
    `questionId` INT NOT NULL,
    PRIMARY KEY (`answerId`),
    FOREIGN KEY (`questionId`)
    REFERENCES question(`questionId`)
  );

CREATE TABLE IF NOT EXISTS `dits`.`literature` (
    `literatureId` INT NOT NULL AUTO_INCREMENT,
    `description` VARCHAR(255) NULL,
    `questionId` INT NOT NULL,
    PRIMARY KEY (`literatureId`),
    FOREIGN KEY (`questionId`)
    REFERENCES question(`questionId`)
  );

CREATE TABLE IF NOT EXISTS `dits`.`link` (
    `linkId` INT NOT NULL AUTO_INCREMENT,
    `link` VARCHAR(255) NULL,
    `literatureId` INT NOT NULL,
    PRIMARY KEY (`linkId`),
    FOREIGN KEY (`literatureId`) 
    REFERENCES literature(`literatureId`)
  );
  
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

CREATE OR REPLACE VIEW `user_statistic` AS
 SELECT
        `user`.`userId` AS `userId`,
        COUNT(*) AS `allAnswers`,
        SUM(`statistic`.`correct`) AS `correctAnswers`,
        COUNT(`statistic`.`correct`) - SUM(`statistic`.`correct`) AS `incorrectAnswers`
    FROM
        (`statistic`
        JOIN `user` ON (`statistic`.`userId` = `user`.`userId`))
    GROUP BY `statistic`.`userId`;
    