CREATE DATABASE IF NOT EXISTS empresa_db;
USE empresa_db;

CREATE TABLE IF NOT EXISTS empleados (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    departamento VARCHAR(50) NOT NULL
);

INSERT INTO empleados (nombre, departamento) VALUES
('Carlos López', 'Tecnología'),
('María Ruiz', 'Finanzas');
