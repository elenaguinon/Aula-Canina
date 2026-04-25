## Base de datos - Aula Canina SL

La base de datos de Aula Canina SL ha sido diseñada para modelar el funcionamiento interno de una empresa de servicios caninos y representar la gestión interna de clientes, perros, empleados, servicios, reservas y pagos.

### Entidades principales
- Cliente
- Perro
- Empleado
- Servicio
- Reserva
- Pago
- Empleado_Servicio

### Funcionalidad del modelo
- Registrar clientes y sus perros
- Gestionar empleados y sus especialidades
- Ofrecer distintos servicios caninos
- Registrar reservas para cada perro
- Asociar cada reserva a un empleado y un servicio
- Guardar los pagos de las reservas

### Archivos incluidos
- `/diagramas/Aula_Canina_ER.pdf`: diagrama entidad-relación
- `diagramas/Aula_Canina_Relacional.pdf`: modelo relacional
- `sql/scriptTablas`: creación de la base de datos y tablas
- `sql/scriptData.sql`: inserción de datos de ejemplo
- `sql/querys.sql`: consultas SQL de prueba

### Tecnologías utilizadas
- MySQL
- phpMyAdmin

### Cómo ejecutar
1. Crear una base de datos en phpMyAdmin
2. Ejecutar el script `scriptTablas`
3. Ejecutar el script `scriptData.sql`
4. Ejecutar `querys.sql` para comprobar el funcionamiento