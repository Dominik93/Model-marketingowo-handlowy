/*
Navicat MySQL Data Transfer

Source Server         : Hand
Source Server Version : 50528
Source Host           : wirt07.biznes-host.pl:3306
Source Database       : virt101443_mh

Target Server Type    : MYSQL
Target Server Version : 50528
File Encoding         : 65001

Date: 2015-05-02 15:26:30
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for Address
-- ----------------------------
DROP TABLE IF EXISTS `Address`;
CREATE TABLE `Address` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `Street` varchar(255) COLLATE utf8_polish_ci NOT NULL,
  `Number` int(11) NOT NULL,
  `City` varchar(255) COLLATE utf8_polish_ci NOT NULL,
  `ZipCode` varchar(255) COLLATE utf8_polish_ci NOT NULL,
  PRIMARY KEY (`ID`),
  CONSTRAINT `to_Data` FOREIGN KEY (`ID`) REFERENCES `PersonalData` (`AddressID`) ON UPDATE NO ACTION,
  CONSTRAINT `to_Shop` FOREIGN KEY (`ID`) REFERENCES `Shop` (`AddressID`) ON UPDATE NO ACTION,
  CONSTRAINT `to_Supplier` FOREIGN KEY (`ID`) REFERENCES `Supplier` (`AddressID`) ON UPDATE NO ACTION,
  CONSTRAINT `to_Warehouse` FOREIGN KEY (`ID`) REFERENCES `Warehouse` (`AddressID`) ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_polish_ci;

-- ----------------------------
-- Table structure for Delivery_Status
-- ----------------------------
DROP TABLE IF EXISTS `Delivery_Status`;
CREATE TABLE `Delivery_Status` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `Name` varchar(255) COLLATE utf8_polish_ci NOT NULL,
  PRIMARY KEY (`ID`),
  CONSTRAINT `to_Status_Shop` FOREIGN KEY (`ID`) REFERENCES `Delivery_to_Shop` (`Delivery_StatusID`) ON UPDATE NO ACTION,
  CONSTRAINT `to_Status_Warehouse` FOREIGN KEY (`ID`) REFERENCES `Delivery_to_Warehouse` (`Delivery_StatusID`) ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_polish_ci;

-- ----------------------------
-- Table structure for Delivery_to_Shop
-- ----------------------------
DROP TABLE IF EXISTS `Delivery_to_Shop`;
CREATE TABLE `Delivery_to_Shop` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `Product_SupplierID` int(11) NOT NULL,
  `ShopID` int(11) NOT NULL,
  `Value` int(11) NOT NULL,
  `Time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `Delivery_StatusID` int(11) NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `Product_SupplierID` (`Product_SupplierID`),
  KEY `Delivery_StatusID` (`Delivery_StatusID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Table structure for Delivery_to_Warehouse
-- ----------------------------
DROP TABLE IF EXISTS `Delivery_to_Warehouse`;
CREATE TABLE `Delivery_to_Warehouse` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `Product_SupplierID` int(11) NOT NULL,
  `WarehouseID` int(11) NOT NULL,
  `Value` int(11) NOT NULL,
  `Time` int(11) NOT NULL,
  `Delivery_StatusID` int(11) NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `Product_SupplierID` (`Product_SupplierID`),
  KEY `Delivery_StatusID` (`Delivery_StatusID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Table structure for Delivery_Type
-- ----------------------------
DROP TABLE IF EXISTS `Delivery_Type`;
CREATE TABLE `Delivery_Type` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `Name` varchar(255) NOT NULL,
  `Cost` float NOT NULL,
  PRIMARY KEY (`ID`),
  CONSTRAINT `to_Delivery_Type` FOREIGN KEY (`ID`) REFERENCES `Order` (`Delivery_TypeID`) ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Table structure for Online_Client
-- ----------------------------
DROP TABLE IF EXISTS `Online_Client`;
CREATE TABLE `Online_Client` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `PersonalDataID` int(11) NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `PersonalDataID` (`PersonalDataID`),
  CONSTRAINT `to_Order` FOREIGN KEY (`ID`) REFERENCES `Order` (`Online_ClientID`) ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Table structure for Order
-- ----------------------------
DROP TABLE IF EXISTS `Order`;
CREATE TABLE `Order` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `Online_ClientID` int(11) NOT NULL,
  `Time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `Delivery_StatusID` int(11) NOT NULL,
  `Delivery_TypeID` int(11) NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `Online_ClientID` (`Online_ClientID`),
  KEY `Delivery_TypeID` (`Delivery_TypeID`),
  CONSTRAINT `to_Prod_Oreder` FOREIGN KEY (`ID`) REFERENCES `Order_Prod_from_Warehouse` (`OrderID`) ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Table structure for Order_Prod_from_Warehouse
-- ----------------------------
DROP TABLE IF EXISTS `Order_Prod_from_Warehouse`;
CREATE TABLE `Order_Prod_from_Warehouse` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `Prod_in_WarehouseID` int(11) NOT NULL,
  `OrderID` int(11) NOT NULL,
  `Value` int(11) NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `Prod_in_WarehouseID` (`Prod_in_WarehouseID`),
  KEY `OrderID` (`OrderID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Table structure for PersonalData
-- ----------------------------
DROP TABLE IF EXISTS `PersonalData`;
CREATE TABLE `PersonalData` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `AddressID` int(11) NOT NULL,
  `Name` varchar(255) COLLATE utf8_polish_ci NOT NULL,
  `Surname` varchar(255) COLLATE utf8_polish_ci NOT NULL,
  `PhoneNumber` varchar(255) COLLATE utf8_polish_ci NOT NULL,
  `EmailAddress` varchar(255) COLLATE utf8_polish_ci NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `AddressID` (`AddressID`),
  CONSTRAINT `to_Online_Client` FOREIGN KEY (`ID`) REFERENCES `Online_Client` (`PersonalDataID`) ON UPDATE NO ACTION,
  CONSTRAINT `to_Worker_Data` FOREIGN KEY (`ID`) REFERENCES `Worker` (`PersonalDataID`) ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_polish_ci;

-- ----------------------------
-- Table structure for Position
-- ----------------------------
DROP TABLE IF EXISTS `Position`;
CREATE TABLE `Position` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `Name` varchar(255) COLLATE utf8_polish_ci NOT NULL,
  `Bid` float NOT NULL,
  PRIMARY KEY (`ID`),
  CONSTRAINT `to_Work_Pos_in_Warehouse` FOREIGN KEY (`ID`) REFERENCES `Working_in_Warehouse` (`PositionID`) ON UPDATE NO ACTION,
  CONSTRAINT `to_Work_Pos_in_Shop` FOREIGN KEY (`ID`) REFERENCES `Working_in_Shop` (`PositionID`) ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_polish_ci;

-- ----------------------------
-- Table structure for Prod_in_Shop
-- ----------------------------
DROP TABLE IF EXISTS `Prod_in_Shop`;
CREATE TABLE `Prod_in_Shop` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `ProductID` int(11) NOT NULL,
  `ShopID` int(11) NOT NULL,
  `Value` int(11) NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `ProductID` (`ProductID`),
  KEY `ShopID` (`ShopID`),
  CONSTRAINT `to_Purchase_Shop` FOREIGN KEY (`ID`) REFERENCES `Purchase_Prod_from_Shop` (`Prod_in_ShopID`) ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Table structure for Prod_in_Warehouse
-- ----------------------------
DROP TABLE IF EXISTS `Prod_in_Warehouse`;
CREATE TABLE `Prod_in_Warehouse` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `WarehouseID` int(11) NOT NULL,
  `ProductID` int(11) NOT NULL,
  `Value` int(11) NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `ProductID` (`ProductID`),
  KEY `WarehouseID` (`WarehouseID`),
  CONSTRAINT `to_Prod_in_Warehouse_Order` FOREIGN KEY (`ID`) REFERENCES `Order_Prod_from_Warehouse` (`Prod_in_WarehouseID`) ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Table structure for Product
-- ----------------------------
DROP TABLE IF EXISTS `Product`;
CREATE TABLE `Product` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `Name` varchar(255) COLLATE utf8_polish_ci NOT NULL,
  `Cost` float NOT NULL,
  `Price` float NOT NULL,
  PRIMARY KEY (`ID`),
  CONSTRAINT `to_Prod_in_Shop` FOREIGN KEY (`ID`) REFERENCES `Prod_in_Shop` (`ProductID`) ON UPDATE NO ACTION,
  CONSTRAINT `to_Product_Supplier` FOREIGN KEY (`ID`) REFERENCES `Product_Supplier` (`ProductID`) ON UPDATE NO ACTION,
  CONSTRAINT `to_Prod_in_Warehouse` FOREIGN KEY (`ID`) REFERENCES `Prod_in_Warehouse` (`ProductID`) ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_polish_ci;

-- ----------------------------
-- Table structure for Product_Supplier
-- ----------------------------
DROP TABLE IF EXISTS `Product_Supplier`;
CREATE TABLE `Product_Supplier` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `ProductID` int(11) NOT NULL,
  `SupplierID` int(11) NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `ProductID` (`ProductID`),
  KEY `SupplierID` (`SupplierID`),
  CONSTRAINT `to_Delivery_to_Warehouse` FOREIGN KEY (`ID`) REFERENCES `Delivery_to_Warehouse` (`Product_SupplierID`) ON UPDATE NO ACTION,
  CONSTRAINT `to_Delivery_to_Shop` FOREIGN KEY (`ID`) REFERENCES `Delivery_to_Shop` (`Product_SupplierID`) ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Table structure for Purchase
-- ----------------------------
DROP TABLE IF EXISTS `Purchase`;
CREATE TABLE `Purchase` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `WorkerID` int(11) NOT NULL,
  `Time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`ID`),
  KEY `WorkerID` (`WorkerID`),
  CONSTRAINT `to_Prod_Purchase` FOREIGN KEY (`ID`) REFERENCES `Purchase_Prod_from_Shop` (`PurchaseID`) ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Table structure for Purchase_Prod_from_Shop
-- ----------------------------
DROP TABLE IF EXISTS `Purchase_Prod_from_Shop`;
CREATE TABLE `Purchase_Prod_from_Shop` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `PurchaseID` int(11) NOT NULL,
  `Prod_in_ShopID` int(11) NOT NULL,
  `Value` int(11) NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `PurchaseID` (`PurchaseID`),
  KEY `Prod_in_ShopID` (`Prod_in_ShopID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Table structure for Shop
-- ----------------------------
DROP TABLE IF EXISTS `Shop`;
CREATE TABLE `Shop` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `AddressID` int(11) NOT NULL,
  `Rent` float NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `AddressID` (`AddressID`),
  CONSTRAINT `to_Work_in_Shop` FOREIGN KEY (`ID`) REFERENCES `Working_in_Shop` (`ShopID`) ON UPDATE NO ACTION,
  CONSTRAINT `to_Product_in_Shop` FOREIGN KEY (`ID`) REFERENCES `Prod_in_Shop` (`ShopID`) ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Table structure for Supplier
-- ----------------------------
DROP TABLE IF EXISTS `Supplier`;
CREATE TABLE `Supplier` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `AddressID` int(11) NOT NULL,
  `Name` varchar(255) COLLATE utf8_polish_ci NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `AddressID` (`AddressID`),
  CONSTRAINT `to_Supplier_Product` FOREIGN KEY (`ID`) REFERENCES `Product_Supplier` (`SupplierID`) ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_polish_ci;

-- ----------------------------
-- Table structure for Warehouse
-- ----------------------------
DROP TABLE IF EXISTS `Warehouse`;
CREATE TABLE `Warehouse` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `AddressID` int(11) NOT NULL,
  `Rent` float NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `AddressID` (`AddressID`),
  CONSTRAINT `to_Work_in_Warehouse` FOREIGN KEY (`ID`) REFERENCES `Working_in_Warehouse` (`WarehouseID`) ON UPDATE NO ACTION,
  CONSTRAINT `to_Product_in_Warehouse` FOREIGN KEY (`ID`) REFERENCES `Prod_in_Warehouse` (`WarehouseID`) ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Table structure for Worker
-- ----------------------------
DROP TABLE IF EXISTS `Worker`;
CREATE TABLE `Worker` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `PersonalDataID` int(11) NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `PersonalDataID` (`PersonalDataID`),
  CONSTRAINT `to_Purchase` FOREIGN KEY (`ID`) REFERENCES `Purchase` (`WorkerID`) ON UPDATE NO ACTION,
  CONSTRAINT `to_Worker_in_Shop` FOREIGN KEY (`ID`) REFERENCES `Working_in_Shop` (`WorkerID`) ON UPDATE NO ACTION,
  CONSTRAINT `to_Worker_in_Warehouse` FOREIGN KEY (`ID`) REFERENCES `Working_in_Warehouse` (`WorkerID`) ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Table structure for Working_in_Shop
-- ----------------------------
DROP TABLE IF EXISTS `Working_in_Shop`;
CREATE TABLE `Working_in_Shop` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `ShopID` int(11) NOT NULL,
  `WorkerID` int(11) NOT NULL,
  `PositionID` int(11) NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `ShopID` (`ShopID`),
  KEY `WorkerID` (`WorkerID`),
  KEY `PositionID` (`PositionID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Table structure for Working_in_Warehouse
-- ----------------------------
DROP TABLE IF EXISTS `Working_in_Warehouse`;
CREATE TABLE `Working_in_Warehouse` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `WarehouseID` int(11) NOT NULL,
  `WorkerID` int(11) NOT NULL,
  `PositionID` int(11) NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `WarehouseID` (`WarehouseID`),
  KEY `WorkerID` (`WorkerID`),
  KEY `PositionID` (`PositionID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
