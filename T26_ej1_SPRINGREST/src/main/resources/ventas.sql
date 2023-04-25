
DROP TABLE IF EXISTS piezas;
DROP TABLE IF EXISTS proveedores;
DROP TABLE IF EXISTS suministra;

CREATE TABLE IF NOT EXISTS piezas (
  id INT AUTO_INCREMENT,
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
  idpieza INT,
  idproveedor INT,
  precio INT DEFAULT NULL,
  PRIMARY KEY(id),
  KEY(idpieza, idproveedor),
   CONSTRAINT piezas_fk FOREIGN KEY (idpieza) REFERENCES piezas (id) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT proveedores_fk FOREIGN KEY (idproveedor) REFERENCES proveedores (id) ON DELETE CASCADE ON UPDATE CASCADE
);

INSERT INTO piezas (nombre) VALUES ('tuerca'); 
INSERT INTO piezas (nombre) VALUES ('rueda'); 
INSERT INTO piezas (nombre) VALUES ('Bujia'); 
INSERT INTO piezas (nombre) VALUES ('cilindro'); 

INSERT INTO proveedores (nombre) VALUES ('Volkswagen');
INSERT INTO proveedores (nombre) VALUES ('Audi');
INSERT INTO proveedores (nombre) VALUES ('SEAT');
INSERT INTO proveedores (nombre) VALUES ('Skoda');

INSERT INTO suministra(idpieza, idproveedor, precio) VALUES (1, 1, 10000);
INSERT INTO suministra(idpieza, idproveedor, precio) VALUES (2, 2, 90000);
INSERT INTO suministra(idpieza, idproveedor, precio) VALUES (3, 3, 8000);
INSERT INTO suministra(idpieza, idproveedor, precio) VALUES (4, 4, 4000);
