SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

DROP SCHEMA IF EXISTS `mydb` ;
CREATE SCHEMA IF NOT EXISTS `mydb` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci ;
DROP SCHEMA IF EXISTS `Consultorio` ;
CREATE SCHEMA IF NOT EXISTS `Consultorio` ;
USE `mydb` ;
USE `Consultorio` ;

-- -----------------------------------------------------
-- Table `Consultorio`.`TEps`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Consultorio`.`TEps` ;

CREATE  TABLE IF NOT EXISTS `Consultorio`.`TEps` (
  `Cod_Eps` VARCHAR(3) NOT NULL ,
  `Nit` VARCHAR(15) NOT NULL ,
  `NombreEps` VARCHAR(45) NOT NULL ,
  PRIMARY KEY (`Cod_Eps`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Consultorio`.`TMedicoEps`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Consultorio`.`TMedicoEps` ;

CREATE  TABLE IF NOT EXISTS `Consultorio`.`TMedicoEps` (
  `Cod_medico` VARCHAR(5) NOT NULL ,
  `Nombre` VARCHAR(45) NOT NULL ,
  `Apellido` VARCHAR(45) NOT NULL ,
  `TEps_Cod_Eps` VARCHAR(3) NOT NULL ,
  PRIMARY KEY (`Cod_medico`) ,
  CONSTRAINT `fk_TMedicoEps_TEps`
    FOREIGN KEY (`TEps_Cod_Eps` )
    REFERENCES `Consultorio`.`TEps` (`Cod_Eps` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE INDEX `fk_TMedicoEps_TEps_idx` ON `Consultorio`.`TMedicoEps` (`TEps_Cod_Eps` ASC) ;



SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
