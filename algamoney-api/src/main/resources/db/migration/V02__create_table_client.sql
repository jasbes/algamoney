CREATE TABLE client (
	id BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
	name VARCHAR(50) NOT NULL,
	street VARCHAR(30),
	number VARCHAR(30),
	complement VARCHAR(30),
	cp VARCHAR(30),
	city VARCHAR(30),
	state VARCHAR(30),
	active BOOLEAN NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO client (name, street, number, complement, cp, city, state, active) values ('João Silva', 'Rua do Abacaxi', '10', null, '38.400-12', 'Uberlândia', 'MG', true);
INSERT INTO client (name, street, number, complement, cp, city, state, active) values ('Maria Rita', 'Rua do Sabiá', '110', 'Apto 101', '11.400-12', 'Ribeirão Preto', 'SP', true);
INSERT INTO client (name, street, number, complement, cp, city, state, active) values ('Pedro Santos', 'Rua da Bateria', '23', null, '54.212-12', 'Goiânia', 'GO', true);
INSERT INTO client (name, street, number, complement, cp, city, state, active) values ('Ricardo Pereira', 'Rua do Motorista', '123', 'Apto 302', '38.400-12', 'Salvador', 'BA', true);
INSERT INTO client (name, street, number, complement, cp, city, state, active) values ('Josué Mariano', 'Av Rio Branco', '321', null, '56.400-12', 'Natal', 'RN', true);
INSERT INTO client (name, street, number, complement, cp, city, state, active) values ('Pedro Barbosa', 'Av Brasil', '100', null, '77.400-12', 'Porto Alegre', 'RS', true);
INSERT INTO client (name, street, number, complement, cp, city, state, active) values ('Henrique Medeiros', 'Rua do Sapo', '1120', 'Apto 201', '12.400-12', 'Rio de Janeiro', 'RJ', true);
INSERT INTO client (name, street, number, complement, cp, city, state, active) values ('Carlos Santana', 'Rua da Manga', '433', null, '31.400-12', 'Belo Horizonte', 'MG', true);
INSERT INTO client (name, street, number, complement, cp, city, state, active) values ('Leonardo Oliveira', 'Rua do Músico', '566', null, '38.400-00', 'Uberlândia', 'MG', true);
INSERT INTO client (name, street, number, complement, cp, city, state, active) values ('Isabela Martins', 'Rua da Terra', '1233', 'Apto 10', '99.400-12', 'Manaus', 'AM', true);