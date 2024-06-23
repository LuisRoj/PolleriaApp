CREATE DATABASE PolleriaDB;
USE PolleriaDB;

-- Tabla roles
CREATE TABLE roles (
    idrol INT PRIMARY KEY,
    nombre VARCHAR(50) NOT NULL,
    estado varchar(3) NOT NULL
);

-- Tabla usuarios
CREATE TABLE usuarios (
    idusuario INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(50) NOT NULL,
    password VARCHAR(255) NOT NULL,
    nombre VARCHAR(50) NOT NULL,
    apellido VARCHAR(50) NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL,
    telefono VARCHAR(20) NOT NULL,
    direccion VARCHAR(255), -- Opcional, solo se usará para clientes.
    idrol INT,
    estado TINYINT NOT NULL,
    FOREIGN KEY (idrol) REFERENCES roles(idrol)
);

-- Tabla categorias
CREATE TABLE categorias (
    idcategoria INT AUTO_INCREMENT PRIMARY KEY,
    nombre_categoria VARCHAR(50) NOT NULL,
    estado_categoria TINYINT NOT NULL
);

-- Tabla unidad_medida
CREATE TABLE unidad_medida (
    idunidad_medida INT AUTO_INCREMENT PRIMARY KEY,
    nombre_unidad VARCHAR(50) NOT NULL,
    estado_unidad TINYINT NOT NULL
);

-- Tabla presentacion
CREATE TABLE presentacion (
    idpresentacion INT AUTO_INCREMENT PRIMARY KEY,
    nombre_presentacion VARCHAR(50) NOT NULL,
    estado_presentacion TINYINT NOT NULL
);

-- Tabla productos
CREATE TABLE productos (
    idproducto INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(50) NOT NULL,
    idcategoria INT,
    idunidad_medida INT,
    idpresentacion INT,
    precio DECIMAL(10, 2) NOT NULL,
    estado_producto TINYINT NOT NULL,
    FOREIGN KEY (idcategoria) REFERENCES categorias(idcategoria),
    FOREIGN KEY (idunidad_medida) REFERENCES unidad_medida(idunidad_medida),
    FOREIGN KEY (idpresentacion) REFERENCES presentacion(idpresentacion)
);

-- Tabla pedidos
CREATE TABLE pedidos (
    idpedido INT AUTO_INCREMENT PRIMARY KEY,
    idusuario INT, -- Cambiado de idcliente a idusuario
    fecha_pedido DATETIME NOT NULL,
    estado_pedido TINYINT NOT NULL,
    total DECIMAL(10, 2) NOT NULL,
    FOREIGN KEY (idusuario) REFERENCES usuarios(idusuario)
);

-- Tabla pedido_detalle
CREATE TABLE pedido_detalle (
    idpedido_detalle INT AUTO_INCREMENT PRIMARY KEY,
    idpedido INT,
    idproducto INT,
    cantidad INT NOT NULL,
    precio DECIMAL(10, 2) NOT NULL,
    subtotal DECIMAL(10, 2) NOT NULL,
    FOREIGN KEY (idpedido) REFERENCES pedidos(idpedido),
    FOREIGN KEY (idproducto) REFERENCES productos(idproducto)
);

-- Tabla ventas
CREATE TABLE ventas (
    idventa INT AUTO_INCREMENT PRIMARY KEY,
    idpedido INT,
    fecha_venta DATETIME NOT NULL,
    total DECIMAL(10, 2) NOT NULL,
    FOREIGN KEY (idpedido) REFERENCES pedidos(idpedido)
);

-- Insertar datos en roles
INSERT INTO roles (idrol, nombre, estado) VALUES
(1, 'ADMIN', 1),
(2, 'Cliente', 1),
(3, 'Empleado', 0);

-- Insertar datos en usuarios
INSERT INTO usuarios (username, password, nombre, apellido, email, telefono, direccion, idrol, estado) VALUES
('admin', 'adminpass', 'Juan', 'Pérez', 'juan.perez@example.com', '123456789', 'Av. Siempre Viva 123', 1, 1),
('cliente1', 'cliente1pass', 'María', 'López', 'maria.lopez@example.com', '987654321', 'Calle Falsa 456', 2, 1);

-- Insertar datos en categorias
INSERT INTO categorias (nombre_categoria, estado_categoria) VALUES
('Pollo', 1),
('Bebidas', 1),
('Complementos', 1);

-- Insertar datos en unidad_medida
INSERT INTO unidad_medida (nombre_unidad, estado_unidad) VALUES
('Kilogramo', 1),
('Litro', 1),
('Unidad', 1);

-- Insertar datos en presentacion
INSERT INTO presentacion (nombre_presentacion, estado_presentacion) VALUES
('Entero', 1),
('Mitad', 1),
('Cuarto', 1);

-- Insertar datos en productos
INSERT INTO productos (nombre, idcategoria, idunidad_medida, idpresentacion, precio, estado_producto) VALUES
('Pollo Asado', 1, 1, 1, 15.99, 1),
('Gaseosa', 2, 2, NULL, 2.50, 1),
('Papas Fritas', 3, 3, NULL, 3.99, 1);

-- Insertar datos en pedidos
INSERT INTO pedidos (idusuario, fecha_pedido, estado_pedido, total) VALUES
(2, '2023-06-01 10:30:00', 1, 22.48),
(2, '2023-06-02 11:45:00', 0, 18.49); -- Estado 0 para pendiente

-- Insertar datos en pedido_detalle
INSERT INTO pedido_detalle (idpedido, idproducto, cantidad, precio, subtotal) VALUES
(1, 1, 1, 15.99, 15.99),
(1, 2, 1, 2.50, 2.50),
(1, 3, 1, 3.99, 3.99),
(2, 1, 1, 15.99, 15.99),
(2, 3, 1, 3.99, 3.99);

-- Insertar datos en ventas
INSERT INTO ventas (idpedido, fecha_venta, total) VALUES
(1, '2023-06-01 11:00:00', 22.48);
