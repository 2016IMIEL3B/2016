-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema assurance
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `assurance` ;

-- -----------------------------------------------------
-- Schema assurance
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `assurance` DEFAULT CHARACTER SET utf8 ;
USE `assurance` ;

-- -----------------------------------------------------
-- Table `assurance`.`Address`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `assurance`.`Address` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `number` INT NOT NULL,
  `street` VARCHAR(45) NOT NULL,
  `postcode` INT NOT NULL,
  `city` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `assurance`.`User`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `assurance`.`User` (
  `userId` INT NOT NULL AUTO_INCREMENT,
  `firstName` VARCHAR(45) NOT NULL,
  `lastName` VARCHAR(45) NOT NULL,
  `login` VARCHAR(45) NOT NULL,
  `password` VARCHAR(64) NOT NULL,
  `addressId` INT NOT NULL,
  PRIMARY KEY (`userId`),
  INDEX `fk_User_Address1_idx` (`addressId` ASC),
  CONSTRAINT `fk_User_Address1`
    FOREIGN KEY (`addressId`)
    REFERENCES `assurance`.`Address` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `assurance`.`Brand`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `assurance`.`Brand` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `assurance`.`Model`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `assurance`.`Model` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `brandId` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_Model_Brand1_idx` (`brandId` ASC),
  CONSTRAINT `fk_Model_Brand1`
    FOREIGN KEY (`brandId`)
    REFERENCES `assurance`.`Brand` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `assurance`.`Vehicle`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `assurance`.`Vehicle` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `fuel` VARCHAR(45) NOT NULL,
  `horsepower` VARCHAR(45) NOT NULL,
  `sleepInside` TINYINT(1) NOT NULL,
  `anyRisk` TINYINT(1) NOT NULL,
  `modelId` INT NOT NULL,
  `addressId` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_Vehicle_Model1_idx` (`modelId` ASC),
  INDEX `fk_Vehicle_Address1_idx` (`addressId` ASC),
  CONSTRAINT `fk_Vehicle_Model1`
    FOREIGN KEY (`modelId`)
    REFERENCES `assurance`.`Model` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Vehicle_Address1`
    FOREIGN KEY (`addressId`)
    REFERENCES `assurance`.`Address` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `assurance`.`Habitation`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `assurance`.`Habitation` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `type` VARCHAR(45) NOT NULL,
  `surface` INT NOT NULL,
  `roomNumber` INT NOT NULL,
  `floor` INT NULL,
  `bathroomNumber` INT NOT NULL,
  `garage` TINYINT(1) NOT NULL,
  `groundSurface` INT NULL,
  `patioSurface` INT NOT NULL,
  `heatingType` VARCHAR(45) NOT NULL,
  `option` VARCHAR(45) NOT NULL,
  `addressId` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_Habitation_Address1_idx` (`addressId` ASC),
  CONSTRAINT `fk_Habitation_Address1`
    FOREIGN KEY (`addressId`)
    REFERENCES `assurance`.`Address` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `assurance`.`Quote`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `assurance`.`Quote` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `step` INT NOT NULL,
  `isCompleted` TINYINT(1) NOT NULL,
  `price` FLOAT NOT NULL,
  `summary` VARCHAR(255) NOT NULL,
  `vehicleId` INT NULL,
  `habitationId` INT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_Quote_Vehicle1_idx` (`vehicleId` ASC),
  INDEX `fk_Quote_Habitation1_idx` (`habitationId` ASC),
  CONSTRAINT `fk_Quote_Vehicle1`
    FOREIGN KEY (`vehicleId`)
    REFERENCES `assurance`.`Vehicle` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Quote_Habitation1`
    FOREIGN KEY (`habitationId`)
    REFERENCES `assurance`.`Habitation` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `assurance`.`Client`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `assurance`.`Client` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `bonus` INT NOT NULL,
  `drivingLicenceDate` DATETIME NOT NULL,
  `accidentNumber` INT NOT NULL,
  `isSecondary` TINYINT(1) NOT NULL,
  `userId` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_Client_User1_idx` (`userId` ASC),
  CONSTRAINT `fk_Client_User1`
    FOREIGN KEY (`userId`)
    REFERENCES `assurance`.`User` (`userId`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `assurance`.`QuoteUser`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `assurance`.`QuoteUser` (
  `quoteId` INT NOT NULL,
  `userId` INT NOT NULL,
  PRIMARY KEY (`quoteId`, `userId`),
  INDEX `fk_Quote_has_User_User1_idx` (`userId` ASC),
  INDEX `fk_Quote_has_User_Quote1_idx` (`quoteId` ASC),
  CONSTRAINT `fk_Quote_has_User_Quote1`
    FOREIGN KEY (`quoteId`)
    REFERENCES `assurance`.`Quote` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Quote_has_User_User1`
    FOREIGN KEY (`userId`)
    REFERENCES `assurance`.`Client` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `assurance`.`Role`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `assurance`.`Role` (
  `roleId` INT NOT NULL AUTO_INCREMENT,
  `roleName` VARCHAR(45) NOT NULL,
  `userId` INT NOT NULL,
  PRIMARY KEY (`roleId`),
  INDEX `fk_Role_User1_idx` (`userId` ASC),
  CONSTRAINT `fk_Role_User1`
    FOREIGN KEY (`userId`)
    REFERENCES `assurance`.`User` (`userId`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
