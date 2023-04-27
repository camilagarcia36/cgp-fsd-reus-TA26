DROP TABLE IF EXISTS venta;
DROP TABLE IF EXISTS cajeros;
DROP TABLE IF EXISTS productos;
DROP TABLE IF EXISTS maquinas_registradoras;


CREATE TABLE IF NOT EXISTS cajeros (
  id INT AUTO_INCREMENT,
  nombre VARCHAR(255) DEFAULT NULL,
  PRIMARY KEY(id)
);

CREATE TABLE IF NOT EXISTS productos (
  codigoproducto INT AUTO_INCREMENT,
  nombre VARCHAR(100) DEFAULT NULL,
  precio INT DEFAULT NULL, 
  PRIMARY KEY(codigoproducto)
);

CREATE TABLE IF NOT EXISTS maquinas_registradoras (
  codigocaja INT AUTO_INCREMENT,
  piso INT DEFAULT NULL, 
  PRIMARY KEY(codigocaja)
);

CREATE TABLE IF NOT EXISTS venta (
  id INT AUTO_INCREMENT,
  cajero INT,
  maquina INT,
  producto INT,
  PRIMARY KEY (id),
  KEY(cajero, maquina, producto),
  CONSTRAINT cajero_fk FOREIGN KEY (cajero) REFERENCES cajeros (id) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT maquina_fk FOREIGN KEY (maquina) REFERENCES maquinas_registradoras (codigocaja) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT productos_fk FOREIGN KEY (producto) REFERENCES productos (codigoproducto) ON DELETE CASCADE ON UPDATE CASCADE
);

INSERT INTO cajeros (nombre) VALUES ('Juan');
INSERT INTO cajeros (nombre) VALUES ('Maria Rodriguez');
INSERT INTO cajeros (nombre) VALUES ('Carlos Garcia');

INSERT INTO productos (nombre, precio) VALUES ('Coca-Cola', 50);
INSERT INTO productos (nombre, precio) VALUES ('Pepsi', 45);
INSERT INTO productos (nombre, precio) VALUES ('Agua mineral', 20);

INSERT INTO maquinas_registradoras (piso) VALUES (1);
INSERT INTO maquinas_registradoras (piso) VALUES (2);
INSERT INTO maquinas_registradoras (piso) VALUES (3);

INSERT INTO venta (cajero, maquina, producto) VALUES (1, 1, 1);
INSERT INTO venta (cajero, maquina, producto) VALUES (2, 1, 2);
INSERT INTO venta (cajero, maquina, producto) VALUES (3, 2, 3);