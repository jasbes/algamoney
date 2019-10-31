CREATE TABLE entry (
	id BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
	description VARCHAR(50) NOT NULL,
	due_date DATE NOT NULL,
	payment_date DATE,
	amount DECIMAL(10,2) NOT NULL,
	comment VARCHAR(100),
	type VARCHAR(20) NOT NULL,
	category_id BIGINT(20) NOT NULL,
	client_id BIGINT(20) NOT NULL,
	FOREIGN KEY (category_id) REFERENCES category(id),
	FOREIGN KEY (client_id) REFERENCES client(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO entry (description, due_date, payment_date, amount, comment, type, category_id, client_id) values ('Salário mensal', '2017-06-10', null, 6500.00, 'Distribuição de lucros', 'IN', 1, 1);
INSERT INTO entry (description, due_date, payment_date, amount, comment, type, category_id, client_id) values ('Bahamas', '2017-02-10', '2017-02-10', 100.32, null, 'OUT', 2, 2);
INSERT INTO entry (description, due_date, payment_date, amount, comment, type, category_id, client_id) values ('Top Club', '2017-06-10', null, 120, null, 'IN', 3, 3);
INSERT INTO entry (description, due_date, payment_date, amount, comment, type, category_id, client_id) values ('CEMIG', '2017-02-10', '2017-02-10', 110.44, 'Geração', 'IN', 3, 4);
INSERT INTO entry (description, due_date, payment_date, amount, comment, type, category_id, client_id) values ('DMAE', '2017-06-10', null, 200.30, null, 'OUT', 3, 5);
INSERT INTO entry (description, due_date, payment_date, amount, comment, type, category_id, client_id) values ('Extra', '2017-03-10', '2017-03-10', 1010.32, null, 'IN', 4, 6);
INSERT INTO entry (description, due_date, payment_date, amount, comment, type, category_id, client_id) values ('Bahamas', '2017-06-10', null, 500, null, 'IN', 1, 7);
INSERT INTO entry (description, due_date, payment_date, amount, comment, type, category_id, client_id) values ('Top Club', '2017-03-10', '2017-03-10', 400.32, null, 'OUT', 4, 8);
INSERT INTO entry (description, due_date, payment_date, amount, comment, type, category_id, client_id) values ('Despachante', '2017-06-10', null, 123.64, 'Multas', 'OUT', 3, 9);
INSERT INTO entry (description, due_date, payment_date, amount, comment, type, category_id, client_id) values ('Pneus', '2017-04-10', '2017-04-10', 665.33, null, 'IN', 5, 10);
INSERT INTO entry (description, due_date, payment_date, amount, comment, type, category_id, client_id) values ('Café', '2017-06-10', null, 8.32, null, 'OUT', 1, 5);
INSERT INTO entry (description, due_date, payment_date, amount, comment, type, category_id, client_id) values ('Eletrônicos', '2017-04-10', '2017-04-10', 2100.32, null, 'OUT', 5, 4);
INSERT INTO entry (description, due_date, payment_date, amount, comment, type, category_id, client_id) values ('Instrumentos', '2017-06-10', null, 1040.32, null, 'OUT', 4, 3);
INSERT INTO entry (description, due_date, payment_date, amount, comment, type, category_id, client_id) values ('Café', '2017-04-10', '2017-04-10', 4.32, null, 'OUT', 4, 2);
INSERT INTO entry (description, due_date, payment_date, amount, comment, type, category_id, client_id) values ('Lanche', '2017-06-10', null, 10.20, null, 'OUT', 4, 1);