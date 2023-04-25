
DROP table IF EXISTS proveedores;
DROP table IF EXISTS piezas;
DROP table IF EXISTS suministra;
CREATE TABLE IF NOT EXISTS piezas(
	id int auto_increment,
	Nombre nvarchar(100),
	PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS proveedores(
	id int,
	Nombre nvarchar(100),
	PRIMARY KEY (id)
);
CREATE TABLE IF NOT EXISTS suministra(
	id int auto_increment,
	idPieza int,
	idProveedor int,
	Precio int,
	PRIMARY KEY (id),
 
    CONSTRAINT idPieza_fk FOREIGN KEY (idPieza) REFERENCES piezas (id),
    CONSTRAINT idProveedor_fk FOREIGN KEY (idProveedor) REFERENCES proveedores (id)
);

INSERT INTO piezas (Nombre) VALUES ('Pieza 1');
INSERT INTO piezas (Nombre) VALUES ('Pieza 2');
INSERT INTO piezas (Nombre) VALUES ('Pieza 3');
INSERT INTO proveedores (Id, Nombre) VALUES (11, 'Proveedor 1');
INSERT INTO proveedores (Id, Nombre) VALUES (22, 'Proveedor 2');
INSERT INTO proveedores (Id, Nombre) VALUES (33, 'Proveedor 3');
INSERT INTO suministra (idPieza, idProveedor, Precio) VALUES (1, 11, 100);
INSERT INTO suministra (idPieza, idProveedor, Precio) VALUES (2, 22, 200);
INSERT INTO suministra (idPieza, idProveedor, Precio) VALUES (3, 33, 300);
