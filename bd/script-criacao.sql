-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema gamestore
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `gamestore` ;

-- -----------------------------------------------------
-- Schema gamestore
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `gamestore` DEFAULT CHARACTER SET utf8 ;
USE `gamestore` ;

-- -----------------------------------------------------
-- Table `gamestore`.`produtos`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `gamestore`.`produtos` (
  `produto_id` INT NOT NULL AUTO_INCREMENT,
  `descricao` VARCHAR(255) NULL,
  `nome` VARCHAR(45) NULL,
  `preco` DECIMAL(10,2) NULL,
  PRIMARY KEY (`produto_id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `gamestore`.`jogos`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `gamestore`.`jogos` (
  `jogo_id` INT NOT NULL AUTO_INCREMENT,
  `memoria_necessaria` INT NULL,
  `numero_de_jogadores` INT NULL,
  `outras_informacoes` VARCHAR(255) NULL,
  `produto_id` INT NULL,
  PRIMARY KEY (`jogo_id`),
  INDEX `fk_produto_id_idx` (`produto_id` ASC),
  CONSTRAINT `fk_produto_jogos_id`
    FOREIGN KEY (`produto_id`)
    REFERENCES `gamestore`.`produtos` (`produto_id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `gamestore`.`consoles`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `gamestore`.`consoles` (
  `console_id` INT NOT NULL AUTO_INCREMENT,
  `tipo_drive` VARCHAR(255) NULL,
  `outras_informacoes` VARCHAR(255) NULL,
  `produto_id` INT NULL,
  PRIMARY KEY (`console_id`),
  INDEX `fk_produto_id_idx` (`produto_id` ASC),
  CONSTRAINT `fk_produto_console_id`
    FOREIGN KEY (`produto_id`)
    REFERENCES `gamestore`.`produtos` (`produto_id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `gamestore`.`acessorios`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `gamestore`.`acessorios` (
  `acessorio_id` INT ZEROFILL NOT NULL,
  `outras_informacoes` VARCHAR(255) NULL,
  `produto_id` INT NULL,
  PRIMARY KEY (`acessorio_id`),
  INDEX `fk_produto_id_idx` (`produto_id` ASC),
  CONSTRAINT `fk_produto_acessorios_id`
    FOREIGN KEY (`produto_id`)
    REFERENCES `gamestore`.`produtos` (`produto_id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `gamestore`.`clientes`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `gamestore`.`clientes` (
  `cliente_id` INT NOT NULL AUTO_INCREMENT,
  `codigo` INT NULL,
  `nome` VARCHAR(255) NULL,
  `endereco` VARCHAR(255) NULL,
  `outras_informacaoes` VARCHAR(255) NULL,
  PRIMARY KEY (`cliente_id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `gamestore`.`pedidos`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `gamestore`.`pedidos` (
  `pedido_id` INT NOT NULL AUTO_INCREMENT,
  `data` DATE NULL,
  `outras_informacoes` VARCHAR(255) NULL,
  `produto_id` INT NULL,
  `cliente_id` INT NULL,
  PRIMARY KEY (`pedido_id`),
  INDEX `fk_produto_id_idx` (`produto_id` ASC),
  INDEX `fk_cliente_id_idx` (`cliente_id` ASC),
  CONSTRAINT `fk_produto_pedidos_id`
    FOREIGN KEY (`produto_id`)
    REFERENCES `gamestore`.`produtos` (`produto_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_cliente_pedidos_id`
    FOREIGN KEY (`cliente_id`)
    REFERENCES `gamestore`.`clientes` (`cliente_id`)
    ON DELETE SET NULL
    ON UPDATE SET NULL)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `gamestore`.`compras`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `gamestore`.`compras` (
  `compra_id` INT NOT NULL AUTO_INCREMENT,
  `data` DATE NULL,
  `outras_informacoes` VARCHAR(255) NULL,
  `produto_id` INT NULL,
  `cliente_id` INT NULL,
  PRIMARY KEY (`compra_id`),
  INDEX `fk_produto_id_idx` (`produto_id` ASC),
  INDEX `fk_cliente_id_idx` (`cliente_id` ASC),
  CONSTRAINT `fk_produto_compras_id`
    FOREIGN KEY (`produto_id`)
    REFERENCES `gamestore`.`produtos` (`produto_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_cliente_compras_id`
    FOREIGN KEY (`cliente_id`)
    REFERENCES `gamestore`.`clientes` (`cliente_id`)
    ON DELETE SET NULL
    ON UPDATE SET NULL)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
