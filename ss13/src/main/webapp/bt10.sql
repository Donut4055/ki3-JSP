CREATE DATABASE bt10;
USE bt10;

CREATE TABLE categories_vi (
                               id INT AUTO_INCREMENT PRIMARY KEY,
                               categoryName VARCHAR(255) NOT NULL,
                               description TEXT
);

CREATE TABLE categories_en (
                               id INT AUTO_INCREMENT PRIMARY KEY,
                               categoryName VARCHAR(255) NOT NULL,
                               description TEXT
);


CREATE TABLE users (
                       id INT AUTO_INCREMENT PRIMARY KEY,
                       username VARCHAR(50) NOT NULL UNIQUE,
                       password VARCHAR(100) NOT NULL,
                       email VARCHAR(100) NOT NULL UNIQUE
);
