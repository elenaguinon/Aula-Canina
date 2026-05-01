CREATE DATABASE aula_canina

USE aula_canina;

CREATE TABLE cliente (
    id_cliente INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(50) NOT NULL,
    apellidos VARCHAR(100) NOT NULL,
    telefono VARCHAR(15) NOT NULL,
    email VARCHAR(100) NOT NULL UNIQUE,
    direccion VARCHAR(150),
    fecha_registro DATE NOT NULL
);

CREATE TABLE perro (
    id_perro INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(50) NOT NULL,
    raza VARCHAR(50) NOT NULL,
    fecha_nacimiento DATE,
    sexo ENUM('Macho', 'Hembra') NOT NULL,
    tamano ENUM('Pequeño', 'Mediano', 'Grande') NOT NULL,
    observaciones TEXT,
    id_cliente INT NOT NULL,
    CONSTRAINT fk_perro_cliente
        FOREIGN KEY (id_cliente) REFERENCES cliente(id_cliente)
        ON DELETE CASCADE
        ON UPDATE CASCADE
);

CREATE TABLE empleado (
    id_empleado INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(50) NOT NULL,
    apellidos VARCHAR(100) NOT NULL,
    telefono VARCHAR(15) NOT NULL,
    email VARCHAR(100) NOT NULL UNIQUE,
    fecha_contratacion DATE NOT NULL,
    salario DECIMAL(8,2) NOT NULL CHECK (salario >= 0)
);

CREATE TABLE servicio (
    id_servicio INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(50) NOT NULL,
    descripcion TEXT,
    duracion INT NOT NULL CHECK (duracion > 0),
    precio DECIMAL(8,2) NOT NULL CHECK (precio >= 0),
    activo BOOLEAN NOT NULL DEFAULT TRUE
);

CREATE TABLE empleado_servicio (
    id_empleado INT NOT NULL,
    id_servicio INT NOT NULL,
    PRIMARY KEY (id_empleado, id_servicio),
    CONSTRAINT fk_emp_serv_empleado
        FOREIGN KEY (id_empleado) REFERENCES empleado(id_empleado)
        ON DELETE CASCADE
        ON UPDATE CASCADE,
    CONSTRAINT fk_emp_serv_servicio
        FOREIGN KEY (id_servicio) REFERENCES servicio(id_servicio)
        ON DELETE CASCADE
        ON UPDATE CASCADE
);

CREATE TABLE reserva (
    id_reserva INT AUTO_INCREMENT PRIMARY KEY,
    fecha_reserva DATE NOT NULL,
    fecha_servicio DATE NOT NULL,
    hora_servicio TIME NOT NULL,
    estado ENUM('Pendiente', 'Confirmada', 'Completada', 'Cancelada') NOT NULL,
    observaciones TEXT,
    id_cliente INT NOT NULL,
    id_perro INT NOT NULL,
    id_empleado INT NOT NULL,
    id_servicio INT NOT NULL,
    CONSTRAINT fk_reserva_cliente
        FOREIGN KEY (id_cliente) REFERENCES cliente(id_cliente)
        ON DELETE RESTRICT
        ON UPDATE CASCADE,
    CONSTRAINT fk_reserva_perro
        FOREIGN KEY (id_perro) REFERENCES perro(id_perro)
        ON DELETE RESTRICT
        ON UPDATE CASCADE,
    CONSTRAINT fk_reserva_empleado
        FOREIGN KEY (id_empleado) REFERENCES empleado(id_empleado)
        ON DELETE RESTRICT
        ON UPDATE CASCADE,
    CONSTRAINT fk_reserva_servicio
        FOREIGN KEY (id_servicio) REFERENCES servicio(id_servicio)
        ON DELETE RESTRICT
        ON UPDATE CASCADE
);

CREATE TABLE pago (
    id_pago INT AUTO_INCREMENT PRIMARY KEY,
    fecha_pago DATE NOT NULL,
    importe DECIMAL(8,2) NOT NULL CHECK (importe >= 0),
    metodo_pago ENUM('Efectivo', 'Tarjeta', 'Bizum') NOT NULL,
    estado_pago ENUM('Pendiente', 'Pagado', 'Reembolsado') NOT NULL,
    referencia VARCHAR(100),
    id_reserva INT NOT NULL,
    CONSTRAINT fk_pago_reserva
        FOREIGN KEY (id_reserva) REFERENCES reserva(id_reserva)
        ON DELETE CASCADE
        ON UPDATE CASCADE
);

CREATE TABLE IF NOT EXISTS ADMINISTRADOR (
    id_Admin INT AUTO_INCREMENT PRIMARY KEY,
    Usuario VARCHAR(50) NOT NULL UNIQUE,
    Password VARCHAR(100) NOT NULL,
    Rol VARCHAR(30) DEFAULT 'ADMIN'
);

INSERT INTO ADMINISTRADOR (Usuario, Password, Rol)
VALUES ('admin', 'admin123', 'ADMIN');