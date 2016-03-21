#------------------------------------------------------------
#        Script MySQL.
#------------------------------------------------------------

CREATE DATABASE JAVA_G4_AF;

USE JAVA_G4_AF;

#------------------------------------------------------------
# Table: User
#------------------------------------------------------------

CREATE TABLE Users(
        id        int (11) Auto_increment  NOT NULL ,
        mail      Varchar (250) NOT NULL ,
        id_Quote  Int ,
        PRIMARY KEY (id )
)ENGINE=InnoDB;


#------------------------------------------------------------
# Table: Quote
#------------------------------------------------------------

CREATE TABLE Quote(
        id     int (11) Auto_increment  NOT NULL ,
        name   Varchar (250) NOT NULL ,
        resume Varchar (250) NOT NULL ,
        price  Float ,
        step   Int NOT NULL ,
        PRIMARY KEY (id )
)ENGINE=InnoDB;


#------------------------------------------------------------
# Table: QuoteCar
#------------------------------------------------------------

CREATE TABLE QuoteCar(
        brand           Varchar (250) NOT NULL ,
        model           Varchar (250) NOT NULL ,
        fuel            Varchar (250) NOT NULL ,
        taxHorsepower   Int NOT NULL ,
        dateLicence     Date NOT NULL ,
        numberAccident  Int NOT NULL ,
        bonusMalus      Float NOT NULL ,
        garage          Boolean NOT NULL ,
        driver          Varchar (250) NOT NULL ,
        secondaryDriver Varchar (250) ,
        address         Varchar (250) ,
        allRisk         Boolean NOT NULL ,
        tiers           Boolean NOT NULL ,
        id_Quote        Int NOT NULL ,
        PRIMARY KEY (id_Quote )
)ENGINE=InnoDB;


#------------------------------------------------------------
# Table: QuoteHome
#------------------------------------------------------------

CREATE TABLE QuoteHome(
        typeHome       Varchar (250) NOT NULL ,
        address        Varchar(250) NOT NULL ,
        area           Int NOT NULL ,
        numberRoom     Int NOT NULL ,
        floor          Int ,
        numberBathroom Int NOT NULL ,
        garage         Boolean NOT NULL ,
        groundArea     Int ,
        terraceArea    Int ,
        typeHeating    Varchar (250) NOT NULL ,
        formula        Varchar (250) NOT NULL ,
        id_Quote       Int NOT NULL ,
        PRIMARY KEY (id_Quote )
)ENGINE=InnoDB;

ALTER TABLE Users ADD CONSTRAINT FK_Users_id_Quote FOREIGN KEY (id_Quote) REFERENCES Quote(id);
ALTER TABLE QuoteCar ADD CONSTRAINT FK_QuoteCar_id FOREIGN KEY (id_Quote) REFERENCES Quote(id);
ALTER TABLE QuoteHome ADD CONSTRAINT FK_QuoteHome_id FOREIGN KEY (id_Quote) REFERENCES Quote(id);
