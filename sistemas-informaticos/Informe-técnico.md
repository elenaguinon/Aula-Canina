# Informe técnico del entorno de ejecución

## Proyecto: Aula Canina

Este informe explica el entorno necesario para ejecutar la aplicación **Aula Canina**. La aplicación tiene una web hecha con HTML y CSS, una base de datos MySQL en XAMPP y una aplicación JavaFX conectada con JDBC.

---

## 1. Tipo de sistema donde se ejecuta

La aplicación se ejecutará en un **PC de usuario con instalación local**.

He elegido esta opción porque es la más adecuada para el proyecto. No hace falta usar un servidor externo ni una máquina virtual, ya que todo puede funcionar desde el mismo ordenador.

En este equipo se ejecutarán:

* La web corporativa de Aula Canina.
* La base de datos MySQL usando XAMPP.
* La aplicación JavaFX desde IntelliJ.
* El repositorio del proyecto con Git y GitHub.

También se usa XAMPP como servidor local para poder trabajar con MySQL y phpMyAdmin.

---

## 2. Requisitos de hardware

### Requisitos mínimos

| Componente     | Requisito mínimo                  |
| -------------- | --------------------------------- |
| CPU            | Procesador de 2 núcleos           |
| RAM            | 4 GB                              |
| Almacenamiento | 5 GB libres                       |
| Pantalla       | Resolución 1366 x 768             |
| Periféricos    | Teclado y ratón                   |
| Internet       | Necesario para GitHub y descargas |

### Requisitos recomendados

| Componente     | Requisito recomendado              |
| -------------- | ---------------------------------- |
| CPU            | Procesador de 4 núcleos o superior |
| RAM            | 8 GB o más                         |
| Almacenamiento | 10 GB libres o más                 |
| Disco          | SSD recomendado                    |
| Pantalla       | Full HD 1920 x 1080                |
| Internet       | Conexión estable                   |

Estos requisitos son suficientes porque la aplicación no es muy pesada. Aun así, se recomienda tener 8 GB de RAM para poder abrir IntelliJ, XAMPP, navegador y Visual Studio Code al mismo tiempo sin problemas.

---

## 3. Sistema operativo recomendado

El sistema operativo recomendado es:

**Windows 10 o Windows 11**

He elegido Windows porque es el sistema donde se está desarrollando el proyecto y porque permite instalar fácilmente las herramientas necesarias.

Herramientas que se usarán en Windows:

* IntelliJ IDEA.
* Visual Studio Code.
* XAMPP.
* Java JDK.
* Git.
* Navegador web.

El proyecto también podría funcionar en Linux o macOS, pero en este caso se recomienda Windows porque es el entorno que se va a usar para probar Aula Canina.

---

## 4. Instalación del entorno

Para instalar el entorno se seguirán estos pasos:

### Paso 1: Instalar Java JDK

Primero hay que instalar Java JDK, porque la aplicación está hecha en Java.

Para comprobar que está instalado, se puede usar este comando en la terminal:

```bash
java -version
```

### Paso 2: Instalar IntelliJ IDEA

Después se instala IntelliJ IDEA, que se usará para abrir y ejecutar la aplicación JavaFX.

Desde IntelliJ se abrirá la carpeta:

```text
programacion-y-mpo/
```

La clase principal que se ejecuta es:

```text
App.java
```

### Paso 3: Instalar XAMPP

Luego se instala XAMPP para poder usar MySQL en local.

Después de instalarlo:

1. Abrir XAMPP Control Panel.
2. Activar el servicio MySQL.
3. Entrar en phpMyAdmin desde el navegador.
4. Crear o importar la base de datos de Aula Canina.

### Paso 4: Importar la base de datos

Desde phpMyAdmin se importa el script SQL del proyecto.

El script está en:

```text
bases-de-datos/sql/
```

La base de datos debe contener las tablas necesarias para clientes, perros, reservas, servicios, empleados y administrador.

### Paso 5: Instalar Git

Git se usa para controlar las versiones del proyecto.

Para comprobar que está instalado:

```bash
git --version
```

### Paso 6: Configurar JDBC

Para que Java se conecte con MySQL, hay que tener añadido el conector JDBC de MySQL al proyecto.

La clase de conexión debe tener una configuración parecida a esta:

```java
private static final String URL = "jdbc:mysql://localhost:3306/aula_canina";
private static final String USER = "root";
private static final String PASSWORD = "";
```

En XAMPP normalmente el usuario es `root` y la contraseña está vacía.

---

## 5. Ejecución del proyecto

El proyecto se ejecuta en varias partes.

### Web corporativa

La web se abre desde el navegador.

Archivo principal:

```text
lenguaje-de-marcas/index.html
```

También se puede abrir con Live Server desde Visual Studio Code.

### Base de datos

Para ejecutar la base de datos:

1. Abrir XAMPP.
2. Iniciar MySQL.
3. Entrar en phpMyAdmin.
4. Comprobar que la base de datos está creada.
5. Revisar que las tablas tienen datos.

### Aplicación JavaFX

Para ejecutar la aplicación Java:

1. Abrir IntelliJ IDEA.
2. Abrir la carpeta `programacion-y-mpo/`.
3. Comprobar que MySQL está iniciado en XAMPP.
4. Ejecutar `App.java`.
5. Iniciar sesión con el usuario administrador.
6. Probar las pantallas de clientes, perros, reservas, servicios y trabajadores.

La aplicación permite gestionar datos reales de la base de datos mediante JDBC.

---

## 6. Mantenimiento básico

Para mantener el proyecto en buen estado se harán revisiones básicas.

| Tarea                           | Frecuencia                            |
| ------------------------------- | ------------------------------------- |
| Hacer commits en Git            | Cada vez que se avance en el proyecto |
| Subir cambios a GitHub          | Varias veces por semana               |
| Revisar que la web abre bien    | Cuando se modifique HTML o CSS        |
| Probar la base de datos         | Cuando se cambien tablas o datos      |
| Revisar la conexión JDBC        | Cuando se modifique Java o MySQL      |
| Exportar copia de seguridad SQL | Después de cambios importantes        |
| Actualizar la documentación     | Al terminar cada fase                 |

### Qué revisar

Hay que comprobar que:

* La web abre correctamente.
* Los enlaces funcionan.
* XAMPP inicia MySQL sin errores.
* La base de datos aparece en phpMyAdmin.
* La aplicación JavaFX arranca.
* El login de administrador funciona.
* Las pantallas cargan datos correctamente.

### Qué hacer si falla

1. Comprobar que XAMPP está abierto.
2. Comprobar que MySQL está iniciado.
3. Revisar el nombre de la base de datos.
4. Revisar usuario y contraseña en `DBConnection.java`.
5. Comprobar que las tablas y columnas existen.
6. Revisar si el conector JDBC está bien añadido.
7. Mirar los últimos cambios hechos en Git.
8. Arreglar el error y hacer un nuevo commit.

---

## 7. Protección mínima

Aunque es un proyecto académico, se aplicarán medidas básicas de seguridad.

Medidas que se tendrán en cuenta:

* Usar login de administrador en la aplicación JavaFX.
* No usar datos sensibles reales.
* No subir contraseñas reales al repositorio.
* Hacer copias de seguridad de la base de datos.
* Mantener ordenado el repositorio de GitHub.
* No borrar datos directamente sin tener una copia previa.
* Mantener actualizados Java, XAMPP, IntelliJ y Git.

Los datos usados en el proyecto serán ficticios. Esto evita problemas de privacidad y hace que el proyecto sea más seguro.

---

## Evidencias

Muestro las capturas de pantalla mostrando como el funciona el proyecto:

```text
sistemas-informaticos/evidencias/
```

Capturas que se añadirán:

| Captura                         | Qué demuestra                           |
| ------------------------------- | --------------------------------------- |
| XAMPP con MySQL iniciado        | Que el servidor local está funcionando  |
| phpMyAdmin con la base de datos | Que la base de datos está creada        |
| Login de la aplicación          | Que la aplicación arranca               |
| Panel principal                 | Que se puede acceder al sistema         |
| Pantalla de reservas            | Que la gestión de reservas funciona     |
| Pantalla de perros              | Que la gestión de perros funciona       |
| Pantalla de trabajadores        | Que la gestión de trabajadores funciona |
| Web abierta en navegador        | Que la parte web funciona               |

Estas capturas servirán como prueba de funcionamiento del entorno.
