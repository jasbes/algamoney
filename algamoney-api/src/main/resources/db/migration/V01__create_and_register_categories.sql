
CREATE TABLE category (
	code BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
	name VARCHAR(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO category (name) values ('Leisure');
INSERT INTO category (name) values ('Food');
INSERT INTO category (name) values ('Supermarket');
INSERT INTO category (name) values ('Pharmacy');
INSERT INTO category (name) values ('Others');