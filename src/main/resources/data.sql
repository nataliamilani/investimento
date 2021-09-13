CREATE TABLE investimento (id VARCHAR(36) AUTO_INCREMENT PRIMARY KEY,
cliente_id INT(10),
conta_id INT(10),
saldo decimal);

INSERT INTO investimento (id, cliente_id ,conta_id, saldo) VALUES (null, 1, 1, null);
INSERT INTO investimento (id, cliente_id ,conta_id, saldo) VALUES (null, 2, 4, null);