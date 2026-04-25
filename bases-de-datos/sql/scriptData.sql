USE aula_canina;

INSERT INTO cliente (nombre, apellidos, telefono, email, direccion, fecha_registro) VALUES
('Elena', 'Guiñón Bravo', '600111222', 'elena@email.com', 'Calle Sol 12, Madrid', '1989-07-10'),
('Lucía', 'Martínez Pérez', '600333444', 'lucia@email.com', 'Avenida Luna 8, Madrid', '2026-03-05'),
('Carlos', 'Sánchez Ruiz', '600555666', 'carlos@email.com', 'Calle Río 21, Madrid', '2026-03-08'),
('Ana', 'López Gómez', '600777888', 'ana@email.com', 'Plaza Mayor 3, Madrid', '2026-03-10');

INSERT INTO perro (nombre, raza, fecha_nacimiento, sexo, tamano, observaciones, id_cliente) VALUES
('Nala', 'Caniche', '2021-06-10', 'Hembra', 'Pequeño', 'Muy tranquila', 1),
('Thor', 'Labrador', '2020-02-14', 'Macho', 'Grande', 'Le asusta el secador', 2),
('Luna', 'Border Collie', '2022-09-01', 'Hembra', 'Mediano', 'Muy activa', 3),
('Rocky', 'Bulldog Francés', '2021-11-20', 'Macho', 'Pequeño', 'Piel sensible', 4);

INSERT INTO empleado (nombre, apellidos, telefono, email, fecha_contratacion, salario) VALUES
('Marta', 'Fernández Gil', '611111111', 'marta@aulacanina.com', '2025-09-01', 1450.00),
('Javier', 'Ruiz León', '622222222', 'javier@aulacanina.com', '2025-10-15', 1500.00),
('Sara', 'Moreno Díaz', '633333333', 'sara@aulacanina.com', '2026-01-10', 1400.00);

INSERT INTO servicio (nombre, descripcion, duracion, precio, activo) VALUES
('Baño', 'Lavado completo con productos específicos', 45, 20.00, TRUE),
('Peluquería', 'Corte y arreglo del pelo', 60, 30.00, TRUE),
('Corte de uñas', 'Corte y limado de uñas', 20, 12.00, TRUE),
('Deslanado', 'Eliminación de pelo muerto y cepillado profundo', 50, 25.00, TRUE);

INSERT INTO empleado_servicio (id_empleado, id_servicio) VALUES
(1, 1), (1, 2), (1, 3),
(2, 1), (2, 4),
(3, 2), (3, 3), (3, 4);

INSERT INTO reserva (fecha_reserva, fecha_servicio, hora_servicio, estado, observaciones, id_cliente, id_perro, id_empleado, id_servicio) VALUES
('2026-03-20', '2026-03-25', '10:00:00', 'Confirmada', 'Cliente pide champú hipoalergénico', 1, 1, 1, 2),
('2026-03-21', '2026-03-26', '11:30:00', 'Pendiente', 'Primera visita', 2, 2, 2, 1),
('2026-03-22', '2026-03-27', '09:30:00', 'Completada', 'Perro nervioso, ir despacio', 3, 3, 3, 4),
('2026-03-23', '2026-03-28', '12:00:00', 'Cancelada', 'Cancelada por el cliente', 4, 4, 1, 3);

INSERT INTO pago (fecha_pago, importe, metodo_pago, estado_pago, referencia, id_reserva) VALUES
('2026-03-25', 30.00, 'Tarjeta', 'Pagado', 'PAY-001', 1),
('2026-03-26', 20.00, 'Bizum', 'Pendiente', 'PAY-002', 2),
('2026-03-27', 25.00, 'Efectivo', 'Pagado', 'PAY-003', 3);