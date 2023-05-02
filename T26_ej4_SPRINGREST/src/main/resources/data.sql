
DROP table IF EXISTS reserva;
DROP table IF EXISTS investigadores;
DROP table IF EXISTS equipos;
DROP table IF EXISTS facultad;

create table facultad(
    id int auto_increment,
    nombre nvarchar(100),
    PRIMARY KEY (id)
);

create table investigadores(
    id int auto_increment,
    dni varchar(9),
    nom_apels nvarchar(255),
    facultad int,
    PRIMARY KEY (id, dni),
    KEY (dni),
    KEY facultadInv_idx (facultad),
    CONSTRAINT facultadInv_idx FOREIGN KEY (facultad) REFERENCES facultad (id)
);

create table equipos(
    id int auto_increment,
    numserie char(4),
    nombre nvarchar(100),
    facultad int,
    PRIMARY KEY (id, numserie),
	KEY (numserie),
    KEY facultadEq_idx (facultad),
    CONSTRAINT facultadEq_idx FOREIGN KEY (facultad) REFERENCES facultad (id)
);

create table reserva(
    id int auto_increment,
    investigador varchar(9),
    equipo char(4),
    comienzo datetime,
    fin datetime,
    PRIMARY KEY (id),
    KEY equipo_idx (equipo),
    CONSTRAINT equipo_idx FOREIGN KEY (equipo) REFERENCES equipos (numserie),
    KEY investigador_idx (investigador),
    CONSTRAINT investigador_idx FOREIGN KEY (investigador) REFERENCES investigadores (dni)
);

INSERT INTO facultad (nombre) VALUES ('Nombre de la Facultad');
INSERT INTO investigadores (dni, nom_apels, facultad)
VALUES ('12345678A', 'Nombre y apellidos del investigador', 1);
INSERT INTO equipos (numserie, nombre, facultad)
VALUES ('001', 'Nombre del equipo', 1);
INSERT INTO reserva (investigador, equipo, comienzo, fin)
VALUES ('12345678A', '001', '2023-05-02 10:00:00', '2023-05-02 12:00:00');
