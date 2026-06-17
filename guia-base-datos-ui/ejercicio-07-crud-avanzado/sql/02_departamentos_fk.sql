USE empresa_db;

CREATE TABLE IF NOT EXISTS departamentos (
    id_depto INT AUTO_INCREMENT PRIMARY KEY,
    nombre_depto VARCHAR(50) NOT NULL
);

INSERT INTO departamentos (nombre_depto) VALUES
('Recursos Humanos'),
('Finanzas'),
('Tecnología'),
('Marketing');

DROP TABLE IF EXISTS empleados;

CREATE TABLE empleados (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    id_departamento INT NOT NULL,
    foto VARCHAR(255),
    FOREIGN KEY (id_departamento) REFERENCES departamentos(id_depto)
);

INSERT INTO empleados (nombre, id_departamento, foto) VALUES
('Carlos López', 3, NULL),
('María Ruiz', 2, NULL);
