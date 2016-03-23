-- MySQL Script generated by MySQL Workbench
-- 03/22/16 12:16:21
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema DBInsurance
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema DBInsurance
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `DBInsurance` ;
USE `DBInsurance` ;

-- -----------------------------------------------------
-- Table `DBInsurance`.`Group`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `DBInsurance`.`Group` (
  `idGroup` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(25) NOT NULL,
  PRIMARY KEY (`idGroup`, `name`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `DBInsurance`.`User`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `DBInsurance`.`User` (
  `idUser` INT NOT NULL AUTO_INCREMENT,
  `firstName` VARCHAR(25) NOT NULL,
  `lastName` VARCHAR(25) NOT NULL,
  `login` VARCHAR(25) NOT NULL,
  `password` VARCHAR(32) NOT NULL,
  `idGroup` INT NOT NULL,
  PRIMARY KEY (`idUser`),
  INDEX `idGroup_idx` (`idGroup` ASC),
  CONSTRAINT `fk_User_Group`
    FOREIGN KEY (`idGroup`)
    REFERENCES `DBInsurance`.`Group` (`idGroup`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `DBInsurance`.`Insurance`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `DBInsurance`.`Insurance` (
  `idInsurance` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `creationDate` DATE NOT NULL,
  `price` INT(8) NOT NULL,
  `summary` LONGTEXT NULL,
  `step` INT(5) NOT NULL,
  `statement` ENUM('En cours', 'Termin�') NOT NULL,
  `idUser` INT NOT NULL,
  PRIMARY KEY (`idInsurance`),
  INDEX `idUser_idx` (`idUser` ASC),
  CONSTRAINT `fk_Insurance_User`
    FOREIGN KEY (`idUser`)
    REFERENCES `DBInsurance`.`User` (`idUser`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `DBInsurance`.`CarInsurance`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `DBInsurance`.`CarInsurance` (
  `idCarInsurance` INT NOT NULL AUTO_INCREMENT,
  `secondaryDriver` VARCHAR(40) NULL,
  `allRisks` INT(1) NOT NULL,
  `third` INT(1) NOT NULL,
  `idInsurance` INT NOT NULL,
  PRIMARY KEY (`idCarInsurance`),
  INDEX `idInsurance_idx` (`idInsurance` ASC),
  CONSTRAINT `fk_CarInsurance_Insurance`
    FOREIGN KEY (`idInsurance`)
    REFERENCES `DBInsurance`.`Insurance` (`idInsurance`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `DBInsurance`.`HouseInsurance`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `DBInsurance`.`HouseInsurance` (
  `idHouseInsurance` INT NOT NULL AUTO_INCREMENT,
  `option` INT(1) NULL,
  `idInsurance` INT NOT NULL,
  PRIMARY KEY (`idHouseInsurance`),
  INDEX `idInsurance_idx` (`idInsurance` ASC),
  CONSTRAINT `fk_HouseInsurance_Insurance`
    FOREIGN KEY (`idInsurance`)
    REFERENCES `DBInsurance`.`Insurance` (`idInsurance`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `DBInsurance`.`Driver`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `DBInsurance`.`Driver` (
  `idDriver` INT NOT NULL AUTO_INCREMENT,
  `drivingLicenseDate` DATE NOT NULL,
  `accidentNumber` INT(3) NOT NULL,
  `bonusMalus` INT(3) NOT NULL,
  `idUser` INT NOT NULL,
  PRIMARY KEY (`idDriver`),
  INDEX `idUser_idx` (`idUser` ASC),
  CONSTRAINT `fk_Driver_User`
    FOREIGN KEY (`idUser`)
    REFERENCES `DBInsurance`.`User` (`idUser`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `DBInsurance`.`Vehicule`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `DBInsurance`.`Vehicule` (
  `idVehicule` INT NOT NULL AUTO_INCREMENT,
  `brand` VARCHAR(25) NOT NULL,
  `model` VARCHAR(25) NOT NULL,
  `fuel` VARCHAR(25) NOT NULL,
  `horsepowerTax` INT(3) NOT NULL,
  `inGarage` INT(1) NOT NULL,
  `idDriver` INT NOT NULL,
  PRIMARY KEY (`idVehicule`),
  INDEX `idDriver_idx` (`idDriver` ASC),
  CONSTRAINT `fk_Vehicule_Driver`
    FOREIGN KEY (`idDriver`)
    REFERENCES `DBInsurance`.`Driver` (`idDriver`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `DBInsurance`.`Adress`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `DBInsurance`.`Adress` (
  `idAdress` INT NOT NULL AUTO_INCREMENT,
  `street` VARCHAR(25) NOT NULL,
  `city` VARCHAR(25) NOT NULL,
  `code` INT(5) NOT NULL,
  `country` VARCHAR(25) NOT NULL,
  PRIMARY KEY (`idAdress`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `DBInsurance`.`Home`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `DBInsurance`.`Home` (
  `idHome` INT NOT NULL AUTO_INCREMENT,
  `type` VARCHAR(11) NOT NULL,
  `surface` INT(3) NOT NULL,
  `roomNumber` INT(2) NOT NULL,
  `floor` INT(2) NOT NULL,
  `bathroomNumber` INT(1) NOT NULL,
  `withGarage` INT(1) NOT NULL,
  `groundSurface` INT(3) NOT NULL,
  `terraceSurface` INT(3) NOT NULL,
  `heatingType` VARCHAR(20) NOT NULL,
  `idAdress` INT NOT NULL,
  `idUser` INT NOT NULL,
  PRIMARY KEY (`idHome`),
  INDEX `idAdress_idx` (`idAdress` ASC),
  INDEX `idUser_idx` (`idUser` ASC),
  CONSTRAINT `fk_Home_Adress`
    FOREIGN KEY (`idAdress`)
    REFERENCES `DBInsurance`.`Adress` (`idAdress`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Home_User`
    FOREIGN KEY (`idUser`)
    REFERENCES `DBInsurance`.`User` (`idUser`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `DBInsurance`.`Role`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `DBInsurance`.`Role` (
  `idRole` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(25) NOT NULL,
  PRIMARY KEY (`idRole`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `DBInsurance`.`GroupRole`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `DBInsurance`.`GroupRole` (
  `idGroup` INT NOT NULL,
  `idRole` INT NOT NULL,
  INDEX `idGroup_idx` (`idGroup` ASC),
  INDEX `idRole_idx` (`idRole` ASC),
  CONSTRAINT `fk_GroupRole_Group`
    FOREIGN KEY (`idGroup`)
    REFERENCES `DBInsurance`.`Group` (`idGroup`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_GroupRole_Role`
    FOREIGN KEY (`idRole`)
    REFERENCES `DBInsurance`.`Role` (`idRole`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
