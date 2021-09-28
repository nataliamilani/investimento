CREATE TABLE IF NOT EXISTS investimento (
id_investimento INTEGER AUTO_INCREMENT PRIMARY KEY,
cliente_id INT(10),
conta_id INT(10),
saldo DECIMAL,
CONSTRAINT uc_containvestimento UNIQUE (conta_id)
);

INSERT IGNORE INTO investimento (cliente_id ,conta_id, saldo) VALUES (1, 1500500004, 16000.00);
INSERT IGNORE INTO investimento (cliente_id ,conta_id, saldo) VALUES (2, 1500500005, 10000.00);