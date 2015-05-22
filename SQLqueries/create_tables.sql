SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

CREATE SCHEMA IF NOT EXISTS `ragency` DEFAULT CHARACTER SET utf8 ;
USE `ragency` ;

-- -----------------------------------------------------
-- Table `ragency`.`company`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ragency`.`company` (
  `idcompany` INT(11) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(100) NOT NULL,
  `contacts` VARCHAR(150) NOT NULL,
  PRIMARY KEY (`idcompany`),
  UNIQUE INDEX `idcompany_UNIQUE` (`idcompany` ASC))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `ragency`.`educationtype`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ragency`.`educationtype` (
  `idtype` INT(11) NOT NULL AUTO_INCREMENT,
  `typename` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idtype`),
  UNIQUE INDEX `idtype_UNIQUE` (`idtype` ASC))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `ragency`.`post`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ragency`.`post` (
  `idpost` INT(11) NOT NULL AUTO_INCREMENT,
  `postname` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idpost`),
  UNIQUE INDEX `idpost_UNIQUE` (`idpost` ASC))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `ragency`.`sphere`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ragency`.`sphere` (
  `idsphere` INT(11) NOT NULL AUTO_INCREMENT,
  `spherename` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idsphere`),
  UNIQUE INDEX `idsphere_UNIQUE` (`idsphere` ASC))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `ragency`.`specialization`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ragency`.`specialization` (
  `idspec` INT(11) NOT NULL AUTO_INCREMENT,
  `specname` VARCHAR(100) NOT NULL,
  PRIMARY KEY (`idspec`),
  UNIQUE INDEX `idspec_UNIQUE` (`idspec` ASC))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `ragency`.`people`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ragency`.`people` (
  `idpeople` INT(11) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(30) NOT NULL,
  `surname` VARCHAR(30) NOT NULL,
  `middlename` VARCHAR(30) NULL DEFAULT NULL,
  `age` INT(11) NOT NULL,
  `salary` FLOAT NULL DEFAULT NULL,
  `contacts` VARCHAR(100) NULL DEFAULT NULL,
  `idpost` INT(11) NOT NULL,
  `idsphere` INT(11) NOT NULL,
  `idtype` INT(11) NOT NULL,
  `idspec` INT(11) NOT NULL,
  `studyplace` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idpeople`),
  UNIQUE INDEX `idpeople_UNIQUE` (`idpeople` ASC),
  INDEX `fk_people_post1_idx` (`idpost` ASC),
  INDEX `fk_people_sphere1_idx` (`idsphere` ASC),
  INDEX `fk_people_educationtype1_idx` (`idtype` ASC),
  INDEX `fk_people_specialization1_idx` (`idspec` ASC),
  CONSTRAINT `fk_people_post1`
    FOREIGN KEY (`idpost`)
    REFERENCES `ragency`.`post` (`idpost`)
    ON DELETE RESTRICT
    ON UPDATE RESTRICT,
  CONSTRAINT `fk_people_sphere1`
    FOREIGN KEY (`idsphere`)
    REFERENCES `ragency`.`sphere` (`idsphere`),
  CONSTRAINT `fk_people_educationtype1`
    FOREIGN KEY (`idtype`)
    REFERENCES `ragency`.`educationtype` (`idtype`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_people_specialization1`
    FOREIGN KEY (`idspec`)
    REFERENCES `ragency`.`specialization` (`idspec`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `ragency`.`history`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ragency`.`history` (
  `idhistory` INT(11) NOT NULL AUTO_INCREMENT,
  `salary` FLOAT NOT NULL,
  `dateFrom` DATE NULL DEFAULT NULL,
  `dateTo` DATE NULL DEFAULT NULL,
  `idpost` INT(11) NOT NULL,
  `idcompany` INT(11) NOT NULL,
  `idpeople` INT(11) NOT NULL,
  PRIMARY KEY (`idhistory`),
  UNIQUE INDEX `idhistory_UNIQUE` (`idhistory` ASC),
  INDEX `fk_history_post1_idx` (`idpost` ASC),
  INDEX `fk_history_company1_idx` (`idcompany` ASC),
  INDEX `fk_history_people1_idx` (`idpeople` ASC),
  CONSTRAINT `fk_history_company1`
    FOREIGN KEY (`idcompany`)
    REFERENCES `ragency`.`company` (`idcompany`),
  CONSTRAINT `fk_history_people1`
    FOREIGN KEY (`idpeople`)
    REFERENCES `ragency`.`people` (`idpeople`),
  CONSTRAINT `fk_history_post1`
    FOREIGN KEY (`idpost`)
    REFERENCES `ragency`.`post` (`idpost`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `ragency`.`lang`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ragency`.`lang` (
  `idlang` INT(11) NOT NULL AUTO_INCREMENT,
  `langname` VARCHAR(100) NOT NULL,
  PRIMARY KEY (`idlang`),
  UNIQUE INDEX `idlang_UNIQUE` (`idlang` ASC))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `ragency`.`people_has_lang`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ragency`.`people_has_lang` (
  `people_idpeople` INT(11) NOT NULL,
  `lang_idlang` INT(11) NOT NULL,
  PRIMARY KEY (`people_idpeople`, `lang_idlang`),
  INDEX `fk_people_has_lang_lang1_idx` (`lang_idlang` ASC),
  INDEX `fk_people_has_lang_people1_idx` (`people_idpeople` ASC),
  CONSTRAINT `fk_people_has_lang_lang1`
    FOREIGN KEY (`lang_idlang`)
    REFERENCES `ragency`.`lang` (`idlang`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_people_has_lang_people1`
    FOREIGN KEY (`people_idpeople`)
    REFERENCES `ragency`.`people` (`idpeople`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `ragency`.`skill`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ragency`.`skill` (
  `idskill` INT(11) NOT NULL AUTO_INCREMENT,
  `skillname` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`idskill`),
  UNIQUE INDEX `idskill_UNIQUE` (`idskill` ASC))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `ragency`.`people_has_skill`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ragency`.`people_has_skill` (
  `people_idpeople` INT(11) NOT NULL,
  `skill_idskill` INT(11) NOT NULL,
  PRIMARY KEY (`people_idpeople`, `skill_idskill`),
  INDEX `fk_people_has_skill_skill1_idx` (`skill_idskill` ASC),
  INDEX `fk_people_has_skill_people1_idx` (`people_idpeople` ASC),
  CONSTRAINT `fk_people_has_skill_people1`
    FOREIGN KEY (`people_idpeople`)
    REFERENCES `ragency`.`people` (`idpeople`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_people_has_skill_skill1`
    FOREIGN KEY (`skill_idskill`)
    REFERENCES `ragency`.`skill` (`idskill`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `ragency`.`vacancy`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ragency`.`vacancy` (
  `idvacancy` INT(11) NOT NULL AUTO_INCREMENT,
  `salary` FLOAT NULL DEFAULT NULL,
  `idspec` INT(11) NOT NULL,
  `idpost` INT(11) NOT NULL,
  `idtype` INT(11) NOT NULL,
  `idsphere` INT(11) NOT NULL,
  `idcompany` INT(11) NOT NULL,
  PRIMARY KEY (`idvacancy`),
  UNIQUE INDEX `idvacancy_UNIQUE` (`idvacancy` ASC),
  INDEX `fk_vacancy_specialization1_idx` (`idspec` ASC),
  INDEX `fk_vacancy_post1_idx` (`idpost` ASC),
  INDEX `fk_vacancy_educationtype1_idx` (`idtype` ASC),
  INDEX `fk_vacancy_sphere1_idx` (`idsphere` ASC),
  INDEX `fk_vacancy_company1_idx` (`idcompany` ASC),
  CONSTRAINT `fk_vacancy_company1`
    FOREIGN KEY (`idcompany`)
    REFERENCES `ragency`.`company` (`idcompany`)
    ON DELETE CASCADE,
  CONSTRAINT `fk_vacancy_educationtype1`
    FOREIGN KEY (`idtype`)
    REFERENCES `ragency`.`educationtype` (`idtype`),
  CONSTRAINT `fk_vacancy_post1`
    FOREIGN KEY (`idpost`)
    REFERENCES `ragency`.`post` (`idpost`),
  CONSTRAINT `fk_vacancy_specialization1`
    FOREIGN KEY (`idspec`)
    REFERENCES `ragency`.`specialization` (`idspec`),
  CONSTRAINT `fk_vacancy_sphere1`
    FOREIGN KEY (`idsphere`)
    REFERENCES `ragency`.`sphere` (`idsphere`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `ragency`.`vacancy_has_lang`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ragency`.`vacancy_has_lang` (
  `vacancy_idvacancy` INT(11) NOT NULL,
  `lang_idlang` INT(11) NOT NULL,
  PRIMARY KEY (`vacancy_idvacancy`, `lang_idlang`),
  INDEX `fk_vacancy_has_lang_lang1_idx` (`lang_idlang` ASC),
  INDEX `fk_vacancy_has_lang_vacancy1_idx` (`vacancy_idvacancy` ASC),
  CONSTRAINT `fk_vacancy_has_lang_lang1`
    FOREIGN KEY (`lang_idlang`)
    REFERENCES `ragency`.`lang` (`idlang`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_vacancy_has_lang_vacancy1`
    FOREIGN KEY (`vacancy_idvacancy`)
    REFERENCES `ragency`.`vacancy` (`idvacancy`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `ragency`.`vacancy_has_skill`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ragency`.`vacancy_has_skill` (
  `vacancy_idvacancy` INT(11) NOT NULL,
  `skill_idskill` INT(11) NOT NULL,
  PRIMARY KEY (`vacancy_idvacancy`, `skill_idskill`),
  INDEX `fk_vacancy_has_skill_skill1_idx` (`skill_idskill` ASC),
  INDEX `fk_vacancy_has_skill_vacancy1_idx` (`vacancy_idvacancy` ASC),
  CONSTRAINT `fk_vacancy_has_skill_skill1`
    FOREIGN KEY (`skill_idskill`)
    REFERENCES `ragency`.`skill` (`idskill`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_vacancy_has_skill_vacancy1`
    FOREIGN KEY (`vacancy_idvacancy`)
    REFERENCES `ragency`.`vacancy` (`idvacancy`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
