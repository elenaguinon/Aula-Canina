# Informe técnico del Entorno de Ejecución

## 1. Introducción y breve descripción del proyecto

Este documento forma parte del Proyecto Intermodular de 1º de DAW y corresponde al módulo de **Sistemas Informáticos**.

El objetivo de este informe es definir, preparar y documentar el entorno real donde se ejecutará el proyecto **Aula Canina**, una aplicación formada por una web corporativa y un sistema de gestión para una escuela canina ficticia.

El proyecto está compuesto por varias partes:

* Una web corporativa desarrollada con **HTML y CSS**.
* Una base de datos en **MySQL**, gestionada desde **XAMPP/phpMyAdmin**.
* Una aplicación de gestión desarrollada en **Java con JavaFX**.
* Conexión entre Java y MySQL mediante **JDBC**.
* Documentación técnica del proyecto.
* Repositorio en **GitHub** para el control de versiones.

La web sirve para mostrar información pública sobre la escuela, sus servicios, tarifas y formas de contacto. La aplicación Java sirve como herramienta interna para gestionar clientes, perros, servicios, trabajadores y reservas.

---

## 2. Tipo de sistema donde se ejecutará

Para este proyecto, el entorno elegido será un **PC de usuario con instalación local**.

Esto significa que la aplicación se ejecutará en un ordenador personal donde estarán instaladas todas las herramientas necesarias para desarrollar, probar y mantener el proyecto.

| Tipo de sistema | Uso en el proyecto                                          |
| --------------- | ----------------------------------------------------------- |
| PC de usuario   | Opción principal elegida para ejecutar y probar el proyecto |
| Servidor local  | Se usará mediante XAMPP para ejecutar MySQL/phpMyAdmin      |
| Máquina virtual | No es necesaria para esta fase del proyecto                 |
| Equipo dedicado | No es necesario porque el proyecto es académico y local     |

### Justificación

Se ha elegido un PC de usuario con entorno local porque el proyecto está pensado para 1º de DAW y no requiere una infraestructura compleja. Con un único equipo se puede desarrollar la web, ejecutar la aplicación Java, levantar la base de datos MySQL y documentar todo el proceso.

Además, XAMPP permite simular un pequeño servidor local de forma sencilla, lo que resulta adecuado para probar la base de datos y la conexión JDBC desde Java.

---

## 3. Preparación del entorno real

Para la fase 4 del proyecto se prepara un entorno real de ejecución en local. Este entorno permite comprobar que Aula Canina puede arrancar y funcionar correctamente en un equipo de usuario.

### Elementos preparados

| Elemento          | Estado esperado                              |
| ----------------- | -------------------------------------------- |
| Sistema operativo | Windows 10 o Windows 11 instalado            |
| Java/JDK          | Instalado y configurado                      |
| IntelliJ IDEA     | Instalado para ejecutar la aplicación JavaFX |
| XAMPP             | Instalado para usar MySQL y phpMyAdmin       |
| MySQL             | Servicio iniciado desde XAMPP                |
| Base de datos     | Creada e importada desde los scripts SQL     |
| Git               | Instalado para controlar versiones           |
| GitHub            | Repositorio Aula-Canina actualizado          |
| Navegador web     | Preparado para abrir la web corporativa      |

### Comprobaciones iniciales

Antes de ejecutar el proyecto se comprobará que:

1. XAMPP está abierto.
2. El servicio **MySQL** está iniciado.
3. La base de datos de Aula Canina existe en phpMyAdmin.
4. Las tablas están creadas correctamente.
5. El proyecto Java se abre en IntelliJ.
6. El conector JDBC de MySQL está añadido al proyecto.
7. La clase `DBConnection` tiene el nombre correcto de la base de datos, usuario y contraseña.
8. La aplicación Java arranca desde la clase principal `App.java`.

---

## 4. Requisitos de hardware

### Requisitos mínimos

| Componente          | Requisito mínimo                  |
| ------------------- | --------------------------------- |
| CPU                 | Procesador de 2 núcleos           |
| RAM                 | 4 GB                              |
| Almacenamiento      | 5 GB libres                       |
| Pantalla            | Resolución mínima 1366 x 768      |
| Conexión a Internet | Necesaria para GitHub y descargas |
| Periféricos         | Teclado y ratón                   |

### Requisitos recomendados

| Componente          | Requisito recomendado                      |
| ------------------- | ------------------------------------------ |
| CPU                 | Procesador de 4 núcleos o superior         |
| RAM                 | 8 GB o más                                 |
| Almacenamiento      | 10 GB libres o más                         |
| Disco               | SSD recomendado                            |
| Pantalla            | Full HD 1920 x 1080                        |
| Conexión a Internet | Estable                                    |
| Periféricos         | Teclado, ratón y pantalla externa opcional |

### Justificación

La aplicación no requiere grandes recursos porque se ejecuta en local y gestiona un volumen de datos reducido. Sin embargo, se recomienda disponer de al menos 8 GB de RAM para trabajar cómodamente con IntelliJ, XAMPP, navegador, Visual Studio Code y Git al mismo tiempo.

---

## 5. Sistema operativo recomendado

El sistema operativo recomendado para desarrollar y ejecutar **Aula Canina** será:

> **Windows 10 o Windows 11**

### Justificación

Windows es el sistema operativo utilizado en el entorno de desarrollo del proyecto y permite instalar de forma sencilla las herramientas necesarias:

* IntelliJ IDEA.
* Visual Studio Code.
* XAMPP.
* Git.
* Navegadores web.
* Java/JDK.

Aunque el proyecto podría adaptarse a Linux o macOS, para esta fase se recomienda Windows porque es el entorno donde se ha preparado y probado la aplicación.

---

## 6. Software necesario

Para poder trabajar con el proyecto será necesario instalar varias herramientas.

| Software            | Uso                                           |
| ------------------- | --------------------------------------------- |
| Visual Studio Code  | Editar HTML, CSS, SQL y Markdown              |
| IntelliJ IDEA       | Ejecutar y compilar la aplicación Java/JavaFX |
| Java JDK            | Compilar y ejecutar la aplicación Java        |
| XAMPP Control Panel | Iniciar MySQL y acceder a phpMyAdmin          |
| phpMyAdmin          | Crear, importar y consultar la base de datos  |
| MySQL Connector/J   | Permitir conexión JDBC entre Java y MySQL     |
| Git                 | Control de versiones local                    |
| GitHub              | Repositorio remoto del proyecto               |
| Navegador web       | Visualizar la web corporativa y phpMyAdmin    |

---

## 7. Instalación del entorno

La instalación del entorno se hará de forma ordenada para que cualquier persona pueda repetirla.

### Paso 1: Instalar Java JDK

La aplicación de gestión está desarrollada en Java, por lo que es necesario tener instalado el JDK.

Para comprobar la instalación se ejecutará en terminal:

```bash
java -version
```

También se puede comprobar:

```bash
javac -version
```

### Paso 2: Instalar IntelliJ IDEA

IntelliJ IDEA será el entorno utilizado para abrir, compilar y ejecutar la aplicación JavaFX.

Se usará para:

* Abrir la carpeta `programacion-y-mpo/`.
* Revisar el código Java.
* Ejecutar la clase principal `App.java`.
* Comprobar errores de compilación.
* Gestionar dependencias del proyecto.

### Paso 3: Instalar XAMPP

XAMPP se usará para levantar el servicio de MySQL en local.

Una vez instalado:

1. Abrir **XAMPP Control Panel**.
2. Pulsar **Start** en el módulo **MySQL**.
3. Acceder a phpMyAdmin desde el navegador.
4. Crear o importar la base de datos del proyecto.

### Paso 4: Importar la base de datos

Desde phpMyAdmin:

1. Crear una base de datos para el proyecto, por ejemplo `aula_canina`.
2. Entrar en la base de datos creada.
3. Usar la opción **Importar**.
4. Seleccionar el script SQL del repositorio.
5. Ejecutar la importación.
6. Comprobar que las tablas aparecen correctamente.

Los scripts SQL se encuentran en:

```text
bases-de-datos/sql/
```

### Paso 5: Instalar Git

Git será necesario para controlar las versiones del proyecto.

Para comprobar la instalación se usará:

```bash
git --version
```

### Paso 6: Clonar o actualizar el repositorio

El proyecto está organizado en el repositorio:

```text
Aula-Canina
```

La estructura principal es:

```text
Aula-Canina/
│
├── README.md
├── bases-de-datos/
├── lenguaje-de-marcas/
├── programacion-y-mpo/
├── sistemas-informaticos/
└── .idea/
```

Para actualizar el repositorio local se puede usar:

```bash
git pull
```

### Paso 7: Configurar JDBC

Para que Java pueda conectarse con MySQL, es necesario tener añadido el conector JDBC de MySQL.

La clase de conexión debe contener una configuración similar a esta:

```java
private static final String URL = "jdbc:mysql://localhost:3306/aula_canina";
private static final String USER = "root";
private static final String PASSWORD = "";
```

En XAMPP, por defecto, el usuario suele ser `root` y la contraseña suele estar vacía.

### Paso 8: Ejecutar la aplicación Java

Para ejecutar la aplicación:

1. Abrir IntelliJ IDEA.
2. Abrir la carpeta `programacion-y-mpo/`.
3. Comprobar que XAMPP tiene MySQL iniciado.
4. Abrir la clase `App.java`.
5. Pulsar **Run**.
6. Iniciar sesión con el usuario administrador.

---

## 8. Configuración básica

### Configuración de XAMPP

La configuración básica necesaria es:

| Elemento       | Configuración          |
| -------------- | ---------------------- |
| Servicio MySQL | Iniciado desde XAMPP   |
| Puerto MySQL   | 3306                   |
| Usuario MySQL  | root                   |
| Contraseña     | Vacía en entorno local |
| Gestor visual  | phpMyAdmin             |

### Configuración de la base de datos

La base de datos debe contener las tablas necesarias para el funcionamiento de Aula Canina, como:

* `CLIENTE`
* `PERRO`
* `RESERVA`
* `SERVICIO`
* `EMPLEADO`
* `ADMINISTRADOR`

La tabla de administrador permite acceder al panel de gestión de la aplicación.

### Configuración de la aplicación Java

La aplicación Java debe tener configurada correctamente la conexión a MySQL mediante JDBC.

La clase encargada de la conexión es:

```text
programacion-y-mpo/src/main/java/com/aulacanina/database/DBConnection.java
```

La clase principal de ejecución es:

```text
programacion-y-mpo/src/main/java/com/aulacanina/App.java
```

---

## 9. Ejecución del proyecto

El proyecto tendrá varias formas de ejecutarse según la parte que se quiera probar.

### Web corporativa

La web se puede abrir directamente desde el navegador.

Archivo principal:

```text
lenguaje-de-marcas/index.html
```

También se puede usar la extensión **Live Server** de Visual Studio Code para visualizar los cambios de forma más cómoda.

### Base de datos

La base de datos se ejecuta desde MySQL en XAMPP.

Pasos:

1. Abrir XAMPP.
2. Iniciar MySQL.
3. Abrir phpMyAdmin.
4. Comprobar que la base de datos existe.
5. Consultar las tablas y los datos.

### Aplicación Java

La aplicación Java se ejecuta desde IntelliJ IDEA.

Pasos:

1. Abrir el proyecto `programacion-y-mpo/`.
2. Comprobar que el conector JDBC está disponible.
3. Ejecutar `App.java`.
4. Iniciar sesión como administrador.
5. Probar las pantallas de gestión.

Funcionalidades principales:

* Login de administrador.
* Consulta de clientes.
* Registro y consulta de perros.
* Registro, consulta, cancelación y eliminación de reservas.
* Registro y consulta de trabajadores.
* Consulta de servicios.
* Prueba de conexión con la base de datos.

---

## 10. Usuarios, permisos y estructura

Aunque es un proyecto académico, se define una organización básica de usuarios y permisos para que el sistema sea realista.

### Usuarios previstos

| Usuario       | Función                                                    |
| ------------- | ---------------------------------------------------------- |
| Administrador | Gestiona toda la aplicación y la base de datos             |
| Empleado      | Consulta y gestiona clientes, perros y reservas            |
| Cliente       | Usuario externo que consulta información pública de la web |

### Permisos básicos

| Usuario       | Permisos                                                  |
| ------------- | --------------------------------------------------------- |
| Administrador | Crear, modificar, eliminar y consultar datos              |
| Empleado      | Consultar, añadir y modificar reservas, clientes y perros |
| Cliente       | Solo consultar información pública de la web              |

### Usuarios implementados en esta fase

En esta fase se ha implementado un **login de administrador** para acceder al panel de gestión JavaFX.

| Usuario implementado | Acceso                                 |
| -------------------- | -------------------------------------- |
| Administrador        | Accede a la aplicación Java de gestión |

Los datos del administrador se almacenan en la tabla `ADMINISTRADOR` de la base de datos.

---

## 11. Carpetas del proyecto

La estructura del repositorio está separada por módulos.

| Carpeta                  | Contenido                                      |
| ------------------------ | ---------------------------------------------- |
| `lenguaje-de-marcas/`    | Web HTML y CSS                                 |
| `bases-de-datos/`        | Scripts SQL, modelo relacional y diagramas     |
| `programacion-y-mpo/`    | Aplicación Java, JavaFX, JDBC y mejoras de POO |
| `sistemas-informaticos/` | Informe técnico, capturas y evidencias         |
| `.idea/`                 | Configuración del entorno IntelliJ             |

Para el módulo de Sistemas Informáticos, la documentación y evidencias deben guardarse en:

```text
sistemas-informaticos/
```

Se recomienda la siguiente organización:

```text
sistemas-informaticos/
│
├── Informe-tecnico.md
├── evidencias/
│   ├── 01-xampp-mysql-activo.png
│   ├── 02-phpmyadmin-bbdd.png
│   ├── 03-app-login.png
│   ├── 04-app-panel-principal.png
│   ├── 05-app-reservas.png
│   └── 06-conexion-correcta.png
└── esquema-sistema.png
```

---

## 12. Datos y copias de seguridad

Los datos principales del proyecto estarán guardados en la base de datos MySQL local.

### Ubicación de datos

| Tipo de dato       | Ubicación                           |
| ------------------ | ----------------------------------- |
| Código fuente      | Repositorio GitHub                  |
| Base de datos      | MySQL local mediante XAMPP          |
| Scripts SQL        | `bases-de-datos/sql/`               |
| Documentación      | Carpetas de cada módulo             |
| Imágenes de la web | Carpeta de la web corporativa       |
| Evidencias         | `sistemas-informaticos/evidencias/` |

### Copias de seguridad

Se realizarán copias de seguridad de dos formas:

1. Subiendo el proyecto a GitHub de forma frecuente.
2. Exportando la base de datos desde phpMyAdmin.

Las copias de seguridad de la base de datos podrán guardarse en:

```text
bases-de-datos/backups/
```

### Proceso recomendado para exportar la base de datos

1. Abrir phpMyAdmin.
2. Seleccionar la base de datos `aula_canina`.
3. Pulsar en **Exportar**.
4. Elegir formato SQL.
5. Descargar el archivo.
6. Guardarlo en `bases-de-datos/backups/`.
7. Subirlo a GitHub si no contiene datos sensibles.

---

## 13. Mantenimiento básico

Para que el proyecto se mantenga en buen estado, se seguirán algunas tareas básicas de mantenimiento.

### Tareas de mantenimiento

| Tarea                                 | Frecuencia recomendada                    |
| ------------------------------------- | ----------------------------------------- |
| Hacer commits en Git                  | Cada avance importante                    |
| Subir cambios a GitHub                | Varias veces por semana                   |
| Revisar que la web abre correctamente | Cada vez que se modifique                 |
| Probar scripts SQL                    | Cuando se cambie la base de datos         |
| Revisar conexión JDBC                 | Cuando se modifique Java o MySQL          |
| Probar login de administrador         | Cuando se modifique la aplicación Java    |
| Revisar pantallas de gestión          | Después de cada cambio importante         |
| Actualizar documentación              | Al terminar cada fase                     |
| Exportar copia de seguridad SQL       | Después de cambios importantes en la BBDD |

### Qué revisar

Se deberá revisar que:

* La web se abre correctamente.
* Los enlaces funcionan.
* La base de datos no tiene errores.
* XAMPP inicia MySQL correctamente.
* La aplicación Java conecta con MySQL.
* El login de administrador funciona.
* Las pantallas de reservas, perros, clientes, servicios y trabajadores cargan datos.
* El repositorio está ordenado.
* El README está actualizado.

### Qué hacer si falla

Si algo falla, se seguirá este orden:

1. Leer el mensaje de error.
2. Comprobar si XAMPP está abierto.
3. Comprobar si MySQL está iniciado.
4. Revisar si la base de datos existe en phpMyAdmin.
5. Comprobar usuario y contraseña de MySQL.
6. Revisar el nombre de la base de datos en `DBConnection.java`.
7. Revisar si las tablas y columnas coinciden con los DAO.
8. Comprobar si el conector JDBC está añadido al proyecto.
9. Revisar los últimos cambios realizados.
10. Consultar commits anteriores si es necesario.
11. Documentar la solución si el error era importante.

---

## 14. Protección mínima del sistema

Aunque el proyecto es académico y local, se aplicarán algunas medidas básicas de seguridad.

### Medidas previstas

* Usar login de administrador en la aplicación Java.
* No subir contraseñas reales al repositorio.
* Usar datos ficticios para clientes, perros y reservas.
* Mantener GitHub organizado y sin archivos innecesarios.
* Crear copias de seguridad de la base de datos.
* No usar permisos de administrador del sistema operativo si no es necesario.
* Mantener actualizado Windows, Java, XAMPP, IntelliJ y Git.
* Evitar modificar directamente la base de datos sin guardar antes una copia.

### Datos sensibles

En el proyecto se usarán datos ficticios. No se utilizarán datos reales de personas ni de mascotas.

Esto es importante para evitar problemas de privacidad.

---

## 15. Evidencias de funcionamiento

Para demostrar que el proyecto funciona, se guardarán capturas en la carpeta:

```text
sistemas-informaticos/evidencias/
```

### Evidencias que se deben incluir

| Evidencia               | Qué debe mostrar                      | Archivo recomendado          |
| ----------------------- | ------------------------------------- | ---------------------------- |
| XAMPP funcionando       | MySQL iniciado en XAMPP               | `01-xampp-mysql-activo.png`  |
| Base de datos creada    | phpMyAdmin con la BBDD y tablas       | `02-phpmyadmin-bbdd.png`     |
| Login de la aplicación  | Pantalla de login de Aula Canina      | `03-app-login.png`           |
| Panel principal         | Inicio de la aplicación tras login    | `04-app-panel-principal.png` |
| Gestión de reservas     | Tabla o formulario de reservas        | `05-app-reservas.png`        |
| Gestión de perros       | Registro o listado de perros          | `06-app-perros.png`          |
| Gestión de trabajadores | Registro o listado de trabajadores    | `07-app-trabajadores.png`    |
| Conexión correcta       | Mensaje de conexión correcta          | `08-conexion-correcta.png`   |
| Web corporativa         | Página principal abierta en navegador | `09-web-home.png`            |

### Descripción de evidencias

Las capturas deben demostrar que:

* El entorno está preparado.
* MySQL se ejecuta correctamente.
* La base de datos está creada.
* La aplicación Java arranca.
* El login funciona.
* Las pantallas principales cargan correctamente.
* La aplicación puede consultar o registrar datos.

---

## 16. Esquema básico del sistema

```text
+---------------------+
|   Usuario / Cliente |
+----------+----------+
           |
           v
+---------------------+
|  Web corporativa    |
|  HTML + CSS         |
+---------------------+


+---------------------+        JDBC        +---------------------+
| Aplicación JavaFX   | -----------------> | Base de datos MySQL |
| Gestión interna     |                    | XAMPP/phpMyAdmin    |
+---------------------+                    +---------------------+
           |
           v
+---------------------+
| Administrador       |
| Login interno       |
+---------------------+
```

La web será la parte pública para los clientes. La aplicación JavaFX y la base de datos forman la parte interna de gestión.

---

## 17. Checklist de la fase 4

| Tarea                      | Estado                               |
| -------------------------- | ------------------------------------ |
| Preparar el entorno real   | Realizado                            |
| Documentar instalación     | Realizado                            |
| Configuración básica       | Realizado                            |
| Usuarios y permisos        | Realizado                            |
| Capturas de funcionamiento | Pendiente de añadir en `evidencias/` |
| Evidencias del proyecto    | Pendiente de añadir en `evidencias/` |

---

## 18. Conclusión

Para esta fase del proyecto, se ha preparado el entorno real de ejecución de **Aula Canina** en un PC de usuario con Windows, Java, IntelliJ, XAMPP, MySQL, phpMyAdmin, Git y GitHub.

Esta opción es adecuada porque el proyecto está pensado para primero de DAW y no necesita todavía una infraestructura compleja. El entorno local permite probar la web corporativa, importar la base de datos y ejecutar la aplicación JavaFX conectada mediante JDBC.

Además, se han definido usuarios, permisos, estructura de carpetas, mantenimiento básico, copias de seguridad y evidencias necesarias para demostrar que el sistema arranca y funciona correctamente.
