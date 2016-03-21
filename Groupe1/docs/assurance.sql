-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `mydb` DEFAULT CHARACTER SET utf8 ;
USE `mydb` ;

-- -----------------------------------------------------
-- Table `mydb`.`Account`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Account` (
  `id` INT NOT NULL,
  `isAdmin` TINYINT(1) NOT NULL,
  `login` VARCHAR(45) NOT NULL,
  `password` VARCHAR(64) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Brand`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Brand` (
  `id` INT NOT NULL,
  `name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Model`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Model` (
  `id` INT NOT NULL,
  `name` VARCHAR(45) NOT NULL,
  `idBrand` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_Model_Brand1_idx` (`idBrand` ASC),
  CONSTRAINT `fk_Model_Brand1`
    FOREIGN KEY (`idBrand`)
    REFERENCES `mydb`.`Brand` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Vehicle`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Vehicle` (
  `id` INT NOT NULL,
  `fuel` VARCHAR(45) NOT NULL,
  `horsepower` VARCHAR(45) NOT NULL,
  `sleepInside` TINYINT(1) NOT NULL,
  `anyRisk` TINYINT(1) NOT NULL,
  `idModel` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_Vehicle_Model1_idx` (`idModel` ASC),
  CONSTRAINT `fk_Vehicle_Model1`
    FOREIGN KEY (`idModel`)
    REFERENCES `mydb`.`Model` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Habitation`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Habitation` (
  `id` INT NOT NULL,
  `type` VARCHAR(45) NOT NULL,
  `surface` DOUBLE NOT NULL,
  `roomNumber` INT NOT NULL,
  `floor` INT NULL,
  `bathroomNumber` INT NOT NULL,
  `garage` TINYINT(1) NOT NULL,
  `groundSurface` DOUBLE NOT NULL,
  `patioSurface` DOUBLE NOT NULL,
  `heatingType` VARCHAR(45) NOT NULL,
  `option` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Quote`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Quote` (
  `id` INT NOT NULL,
  `name` VARCHAR(45) NOT NULL,
  `step` INT NOT NULL,
  `isCompleted` TINYINT(1) NOT NULL,
  `price` DOUBLE NOT NULL,
  `summary` VARCHAR(255) NOT NULL,
  `idVehicle` INT NULL,
  `idHabitation` INT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_Quote_Vehicle1_idx` (`idVehicle` ASC),
  INDEX `fk_Quote_Habitation1_idx` (`idHabitation` ASC),
  CONSTRAINT `fk_Quote_Vehicle1`
    FOREIGN KEY (`idVehicle`)
    REFERENCES `mydb`.`Vehicle` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Quote_Habitation1`
    FOREIGN KEY (`idHabitation`)
    REFERENCES `mydb`.`Habitation` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Address`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Address` (
  `id` INT NOT NULL,
  `number` INT NOT NULL,
  `street` VARCHAR(45) NOT NULL,
  `postode` VARCHAR(45) NOT NULL,
  `city` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`User`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`User` (
  `id` INT NOT NULL,
  `firstname` VARCHAR(45) NOT NULL,
  `lastname` VARCHAR(45) NOT NULL,
  `bonus` INT NOT NULL,
  `drivingLicenceDate` DATETIME NOT NULL,
  `accidentNumber` INT NOT NULL,
  `isSecondary` TINYINT(1) NOT NULL,
  `idAddress` INT NOT NULL,
  `idAccount` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_Client_Address1_idx` (`idAddress` ASC),
  INDEX `fk_User_Account1_idx` (`idAccount` ASC),
  CONSTRAINT `fk_Client_Address1`
    FOREIGN KEY (`idAddress`)
    REFERENCES `mydb`.`Address` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_User_Account1`
    FOREIGN KEY (`idAccount`)
    REFERENCES `mydb`.`Account` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`QuoteUser`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`QuoteUser` (
  `idQuote` INT NOT NULL,
  `idUser` INT NOT NULL,
  PRIMARY KEY (`idQuote`, `idUser`),
  INDEX `fk_Quote_has_User_User1_idx` (`idUser` ASC),
  INDEX `fk_Quote_has_User_Quote1_idx` (`idQuote` ASC),
  CONSTRAINT `fk_Quote_has_User_Quote1`
    FOREIGN KEY (`idQuote`)
    REFERENCES `mydb`.`Quote` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Quote_has_User_User1`
    FOREIGN KEY (`idUser`)
    REFERENCES `mydb`.`User` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
