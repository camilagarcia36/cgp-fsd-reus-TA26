DROP TABLE IF EXISTS suministra;

DROP TABLE IF EXISTS piezas;

DROP TABLE IF EXISTS proveedores;

CREATE TABLE IF NOT EXISTS piezas (
	codigo INT AUTO_INCREMENT,
	nombre VARCHAR(100) DEFAULT NULL,
	PRIMARY KEY(codigo)
);

CREATE TABLE IF NOT EXISTS proveedores (
	id INT AUTO_INCREMENT,
	nombre VARCHAR(100) DEFAULT NULL,
	PRIMARY KEY(id)
);

CREATE TABLE IF NOT EXISTS suministra (
	id INT AUTO_INCREMENT,
	codigopieza INT,
	idproveedor INT,
	precio INT DEFAULT NULL,
	PRIMARY KEY(id),
	KEY(codigopieza, idproveedor),
	CONSTRAINT piezas_fk FOREIGN KEY (codigopieza) REFERENCES piezas (codigo) ON DELETE CASCADE ON UPDATE CASCADE,
	CONSTRAINT proveedores_fk FOREIGN KEY (idproveedor) REFERENCES proveedores (id) ON DELETE CASCADE ON UPDATE CASCADE
);

INSERT INTO
	piezas (nombre)
VALUES
	('Tuerca');

INSERT INTO
	piezas (nombre)
VALUES
	('Perno');

INSERT INTO
	piezas (nombre)
VALUES
	('Arandela');

INSERT INTO
	piezas (nombre)
VALUES
	('Cable');

INSERT INTO
	piezas (nombre)
VALUES
	('Resorte');

INSERT INTO
	piezas (nombre)
VALUES
	('Tornillo');

INSERT INTO
	piezas (nombre)
VALUES
	('Correa');

INSERT INTO
	piezas (nombre)
VALUES
	('Valvula');

INSERT INTO
	piezas (nombre)
VALUES
	('Cilindro');

INSERT INTO
	piezas (nombre)
VALUES
	('Bujia');

INSERT INTO
	proveedores (nombre)
VALUES
	('Proveedor 1');

INSERT INTO
	proveedores (nombre)
VALUES
	('Proveedor 2');

INSERT INTO
	proveedores (nombre)
VALUES
	('Proveedor 3');

INSERT INTO
	proveedores (nombre)
VALUES
	('Proveedor 4');

INSERT INTO
	proveedores (nombre)
VALUES
	('Proveedor 5');

INSERT INTO
	proveedores (nombre)
VALUES
	('Proveedor 6');

INSERT INTO
	proveedores (nombre)
VALUES
	('Proveedor 7');

INSERT INTO
	proveedores (nombre)
VALUES
	('Proveedor 8');

INSERT INTO
	proveedores (nombre)
VALUES
	('Proveedor 9');

INSERT INTO
	proveedores (nombre)
VALUES
	('Proveedor 10');

INSERT INTO
	suministra (codigopieza, idproveedor, precio)
VALUES
	(1, 10, 10);

INSERT INTO
	suministra (codigopieza, idproveedor, precio)
VALUES
	(2, 9, 15);

INSERT INTO
	suministra (codigopieza, idproveedor, precio)
VALUES
	(3, 8, 5);

INSERT INTO
	suministra (codigopieza, idproveedor, precio)
VALUES
	(4, 7, 20);

INSERT INTO
	suministra (codigopieza, idproveedor, precio)
VALUES
	(5, 6, 8);

INSERT INTO
	suministra (codigopieza, idproveedor, precio)
VALUES
	(6, 5, 12);

INSERT INTO
	suministra (codigopieza, idproveedor, precio)
VALUES
	(7, 4, 18);

INSERT INTO
	suministra (codigopieza, idproveedor, precio)
VALUES
	(8, 3, 25);

INSERT INTO
	suministra (codigopieza, idproveedor, precio)
VALUES
	(9, 2, 30);

INSERT INTO
	suministra (codigopieza, idproveedor, precio)
VALUES
	(10, 1, 40);