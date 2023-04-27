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



INSERT INTO piezas (nombre) VALUES ('Valvula');
INSERT INTO piezas (nombre) VALUES ('Filtro');
INSERT INTO piezas (nombre) VALUES ('Bomba');

INSERT INTO proveedores (nombre) VALUES ('Proveedor 1');
INSERT INTO proveedores (nombre) VALUES ('Proveedor 2');
INSERT INTO proveedores (nombre) VALUES ('Proveedor 3');

INSERT INTO suministra (codigopieza, idproveedor, precio) VALUES (1, 1, 10);

INSERT INTO suministra (codigopieza, idproveedor, precio) VALUES (2, 2, 15);

INSERT INTO suministra (codigopieza, idproveedor, precio) VALUES (3, 3, 5);