# Informe técnico del Entorno de Ejecución

## 1. Introducción y breve descripción del proyecto

Este documento forma parte del Proyecto Intermodular de 1º de DAW y corresponde al módulo de **Sistemas Informáticos**.

El objetivo de este informe es definir el entorno donde se ejecutará el proyecto **Aula Canina**, una aplicación formada por una web corporativa y un sistema de gestión para una escuela canina ficticia.

El proyecto tendrá varias partes:

* Una web desarrollada con **HTML y CSS**.
* Una base de datos en **MySQL**.
* Una aplicación de gestión desarrollada en **Java**.
* Conexión entre Java y MySQL mediante **JDBC**.
* Documentación técnica del proyecto.

La web servirá para mostrar información sobre la escuela, sus servicios, tarifas y formas de contacto. La aplicación Java servirá para gestionar clientes, perros, servicios y reservas.

---

## 2. Tipo de sistema donde se ejecutará

Para este proyecto, el entorno elegido será un **PC de usuario con instalación local**.

Esto significa que la aplicación se ejecutará en un ordenador personal, donde estarán instaladas las herramientas necesarias para desarrollar y probar el proyecto.


| Tipo de sistema | Uso en el proyecto                         |
| --------------- | ------------------------------------------ |
| PC de usuario   | Opción principal elegida                   |
| Servidor local  | Se usará para MySQL        |
| Máquina virtual | No es necesaria     |
| Equipo dedicado | No es necesario |

---

## 3. Requisitos de hardware

### Requisitos mínimos

| Componente          | Requisito mínimo                  |
| ------------------- | --------------------------------- |
| CPU                 | Procesador de 2 núcleos           |
| RAM                 | 4 GB                              |
| Almacenamiento      | 5 GB libres                       |
| Pantalla            | Resolución mínima 1366 x 768      |
| Conexión a Internet | Necesaria para GitHub y descargas |

### Requisitos recomendados

| Componente          | Requisito recomendado              |
| ------------------- | ---------------------------------- |
| CPU                 | Procesador de 4 núcleos o superior |
| RAM                 | 8 GB o más                         |
| Almacenamiento      | 10 GB libres o más                 |
| Disco               | SSD recomendado                    |
| Pantalla            | Full HD 1920 x 1080                |
| Conexión a Internet | Estable                            |

---

## 4. Sistema operativo recomendado

El sistema operativo recomendado para desarrollar y ejecutar **Aula Canina** será:

> **Windows 10 o Windows 11**

### Justificación

 Windows es un sistema operativo común y es sencillo para instalar las herramientas necesarias.

Además, permite trabajar cómodamente con:

* Visual Studio Code.
* IntelliJ.
* MySQL.
* Git.
* Navegadores web.
* Terminal.

Aunque el proyecto también podría ejecutarse en Linux o Mac.

---

## 5. Software necesario

Para poder trabajar con el proyecto será necesario instalar varias herramientas.

| Software             | Uso                                    |
| -------------------- | -------------------------------------- |
| Visual Studio Code   | Editar HTML, CSS, Java y Markdown      |
| IntelliJ             | Ejecutar y compilar la aplicación Java |
| Xamp Control Panel      | Crear y gestionar la base de datos     |
| Git                  | Control de versiones                   |
| GitHub               | Repositorio remoto del proyecto        |
| Navegador web        | Visualizar la web corporativa          |

---

## 6. Instalación del entorno

La instalación del entorno se hará de la siguiente manera:

### Paso 1: Instalar Visual Studio Code

Primero se instalará **Visual Studio Code**, que será el editor principal para trabajar con el proyecto, en todas aquellas facetas dónde no utilicemos Java.

Se usará para editar:

* Archivos HTML.
* Archivos CSS.
* Archivos SQL.
* Documentación en Markdown.

### Paso 2: Instalar IntelliJ

Después se instalará el **IntelliJ**, necesario para compilar y ejecutar la aplicación de gestión.

Para comprobar que Java está instalado correctamente, se podrá usar el siguiente comando:

```bash
java -version
```


### Paso 3: Instalar Xammpp

La base de datos del proyecto se desarrollará con **Xammpp**.

Será necesario instalar:

* Xammpp.


Xammpp se encargará de almacenar los datos y para crear tablas, insertar datos y hacer consultas de forma visual.

### Paso 4: Instalar Git

Git será necesario para controlar las versiones del proyecto.

Para comprobar la instalación se usará:

```bash
git --version
```

### Paso 5: Crear o clonar el repositorio

El proyecto se guardará en un repositorio llamado:

```text
Aula-Canina
```

La estructura inicial será:

```text
aula-canina/
│
├── README.md
│
├── lenguajes-de-marcas/
│
├── bases-de-datos/
│
├── programacion-y-mpo/
│
├── entornos-de-desarrollo/
│
├── sistemas-informaticos/
│
└── itinerario-empleabilidad/
```

### Paso 6: Configurar JDBC

Para que Java pueda conectarse con MySQL, será necesario añadir el conector JDBC de MySQL al proyecto.

Esta parte se completará más adelante, cuando se desarrolle la aplicación Java.

---

## 8. Ejecución del proyecto

El proyecto tendrá varias formas de ejecutarse según la parte que se quiera probar.

### Web corporativa

La web se podrá abrir directamente desde el navegador.

Ejemplo:

```text
lenguajes-de-marcas/index.html
```

También se podrá usar la extensión **Live Server** de Visual Studio Code para visualizar los cambios de forma más cómoda.

### Base de datos

La base de datos se ejecutará desde MySQL Server.

Los scripts SQL estarán dentro de la carpeta:

```text
bases-de-datos/
```

Desde MySQL Workbench se podrán ejecutar scripts para:

* Crear la base de datos.
* Crear las tablas.
* Insertar datos de ejemplo.
* Probar consultas.

### Aplicación Java

La aplicación Java se ejecutará desde el entorno de desarrollo o desde terminal.

La carpeta principal será:

```text
programacion-y-mpo/
```

En una primera versión, la aplicación podrá funcionar por consola mediante un menú simple.

---

## 9. Usuarios, permisos y estructura

Aunque es un proyecto académico, es importante pensar en una organización mínima de usuarios y permisos.

### Usuarios previstos

| Usuario       | Función                                            |
| ------------- | -------------------------------------------------- |
| Administrador | Gestiona toda la aplicación y la base de datos     |
| Empleado      | Consulta y gestiona clientes, perros y reservas    |
| Cliente       | Usuario externo que consulta información en la web |

### Permisos básicos

| Usuario       | Permisos                                          |
| ------------- | ------------------------------------------------- |
| Administrador | Crear, modificar, eliminar y consultar datos      |
| Empleado      | Consultar, añadir y modificar reservas o clientes |
| Cliente       | Solo consultar información pública de la web      |

En esta primera fase no se implementará todavía un sistema real de login, pero se deja planteado para que la estructura sea coherente con el funcionamiento de una escuela canina.

---

## 10. Carpetas del proyecto

La estructura del repositorio estará separada por módulos.

| Carpeta                     | Contenido                                  |
| --------------------------- | ------------------------------------------ |
| `lenguajes-de-marcas/`      | Web HTML y CSS                             |
| `bases-de-datos/`           | Scripts SQL, modelo relacional y diagramas |
| `programacion-y-mpo/`       | Aplicación Java y mejoras de POO           |
| `entornos-de-desarrollo/`   | Documentación relacionada con Git y GitHub |
| `sistemas-informaticos/`    | Informe técnico del entorno                |
| `itinerario-empleabilidad/` | Perfil profesional, portfolio y reflexión  |

---

## 11. Datos y copias de seguridad

Los datos principales del proyecto estarán guardados en la base de datos MySQL.

### Ubicación de datos

| Tipo de dato       | Ubicación                      |
| ------------------ | ------------------------------ |
| Código fuente      | Repositorio GitHub             |
| Base de datos      | MySQL local                    |
| Scripts SQL        | Carpeta `bases-de-datos/`      |
| Documentación      | Carpetas de cada módulo        |
| Imágenes de la web | Carpeta `lenguajes-de-marcas/` |

### Copias de seguridad

Se realizarán copias de seguridad de dos formas:

1. Subiendo el proyecto a GitHub de forma frecuente.
2. Exportando la base de datos cuando tenga tablas y datos importantes.

Las copias de seguridad de la base de datos podrán guardarse en:

```text
bases-de-datos/backups/
```

---

## 12. Mantenimiento básico

Para que el proyecto se mantenga en buen estado, se seguirán algunas tareas básicas de mantenimiento.

### Tareas de mantenimiento

| Tarea                                 | Frecuencia recomendada            |
| ------------------------------------- | --------------------------------- |
| Hacer commits en Git                  | Cada avance importante            |
| Subir cambios a GitHub                | Varias veces por semana           |
| Revisar que la web abre correctamente | Cada vez que se modifique         |
| Probar scripts SQL                    | Cuando se cambie la base de datos |
| Revisar conexión JDBC                 | Cuando se modifique Java o MySQL  |
| Actualizar documentación              | Al terminar cada fase             |

### Qué revisar

Se deberá revisar que:

* La web se abre correctamente.
* Los enlaces funcionan.
* La base de datos no tiene errores.
* La aplicación Java conecta con MySQL.
* El repositorio está ordenado.
* El README está actualizado.

### Qué hacer si falla

Si algo falla, se seguirá este orden:

1. Leer el mensaje de error.
2. Comprobar si el programa o servicio está iniciado.
3. Revisar rutas de archivos y nombres de carpetas.
4. Comprobar usuario y contraseña de MySQL.
5. Revisar últimos cambios realizados.
6. Consultar commits anteriores si es necesario.
7. Documentar la solución si el error era importante.

---

## 13. Protección mínima del sistema

Aunque el proyecto es académico y local, se aplicarán algunas medidas básicas de seguridad.

### Medidas previstas

* Usar contraseña para el usuario de MySQL.
* No subir contraseñas reales al repositorio.
* Mantener GitHub organizado y sin archivos innecesarios.
* Crear copias de seguridad de la base de datos.
* No usar permisos de administrador si no es necesario.
* Mantener actualizado el sistema operativo y las herramientas principales.

### Datos sensibles

En el proyecto se usarán datos ficticios. No se utilizarán datos reales de personas ni de mascotas.

Esto es importante para evitar problemas de privacidad.

---

## 14. Evidencias previstas

Más adelante, cuando el proyecto esté en fase de ejecución, se añadirán evidencias para demostrar que funciona.

Las evidencias podrán ser:

* Captura de la web abierta en el navegador.
* Captura de la base de datos en MySQL Workbench.
* Captura de la aplicación Java ejecutándose.
* Captura de la conexión JDBC funcionando.
* Captura del repositorio GitHub.

Estas evidencias se guardarán en la carpeta:

```text
sistemas-informaticos/evidencias/
```

---

## 15. Esquema básico del sistema

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
| Aplicación Java     | -----------------> | Base de datos MySQL |
| Gestión interna     |                    | Aula Canina         |
+---------------------+                    +---------------------+
```

La web será la parte pública para los clientes. La aplicación Java y la base de datos formarán la parte interna de gestión.

---

## 16. Conclusión

Para esta fase del proyecto, se ha decidido que **Aula Canina** se ejecutará en un PC de usuario con entorno local.

Esta opción es adecuada porque el proyecto está pensado para primero de DAW y no necesita todavía una infraestructura compleja. Con Windows, Java, MySQL, Git y Visual Studio Code se puede desarrollar y probar todo lo necesario.

El diseño del sistema queda preparado para las siguientes fases, donde se empezará a desarrollar la web, la base de datos y la aplicación Java.
