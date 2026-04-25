-- 1. Listado de clientes --
SELECT * FROM cliente;

-- 2. Listado de perros con su propietario --
SELECT p.nombre AS perro, p.raza, c.nombre AS cliente, c.apellidos
FROM perro p
JOIN cliente c ON p.id_cliente = c.id_cliente;

-- 3. Reservas con toda la información relacionada --
SELECT 
    r.id_reserva,
    r.fecha_servicio,
    r.hora_servicio,
    r.estado,
    c.nombre AS cliente,
    c.apellidos,
    p.nombre AS perro,
    e.nombre AS empleado,
    s.nombre AS servicio,
    s.precio
FROM reserva r
JOIN cliente c ON r.id_cliente = c.id_cliente
JOIN perro p ON r.id_perro = p.id_perro
JOIN empleado e ON r.id_empleado = e.id_empleado
JOIN servicio s ON r.id_servicio = s.id_servicio
ORDER BY r.fecha_servicio, r.hora_servicio;

-- 4. Buscar reservas de un cliente concreto --
SELECT r.id_reserva, r.fecha_servicio, r.hora_servicio, r.estado
FROM reserva r
JOIN cliente c ON r.id_cliente = c.id_cliente
WHERE c.nombre = 'Elena';

-- 5. Servicios activos --
SELECT * FROM servicio
WHERE activo = TRUE;

-- 6. Empleados y servicios que pueden realizar --
SELECT 
    e.nombre AS empleado,
    e.apellidos,
    s.nombre AS servicio
FROM empleado_servicio es
JOIN empleado e ON es.id_empleado = e.id_empleado
JOIN servicio s ON es.id_servicio = s.id_servicio
ORDER BY e.nombre;

-- 7. Pagos realizados con información de la reserva --
SELECT 
    p.id_pago,
    p.fecha_pago,
    p.importe,
    p.metodo_pago,
    p.estado_pago,
    r.id_reserva,
    r.fecha_servicio
FROM pago p
JOIN reserva r ON p.id_reserva = r.id_reserva;

-- 8. Número total de perros por cliente --
SELECT 
    c.nombre,
    c.apellidos,
    COUNT(p.id_perro) AS total_perros
FROM cliente c
LEFT JOIN perro p ON c.id_cliente = p.id_cliente
GROUP BY c.id_cliente, c.nombre, c.apellidos;

-- 9. Número de reservas por estado --
SELECT estado, COUNT(*) AS total
FROM reserva
GROUP BY estado;

-- 10. Ingreso total de pagos realizados --
SELECT SUM(importe) AS total_ingresos
FROM pago
WHERE estado_pago = 'Pagado';

-- 11. Servicio más reservado --
SELECT 
    s.nombre,
    COUNT(r.id_reserva) AS total_reservas
FROM servicio s
LEFT JOIN reserva r ON s.id_servicio = r.id_servicio
GROUP BY s.id_servicio, s.nombre
ORDER BY total_reservas DESC;

-- 12. Reservas futuras confirmadas --
SELECT *
FROM reserva
WHERE estado = 'Confirmada'
ORDER BY fecha_servicio, hora_servicio;