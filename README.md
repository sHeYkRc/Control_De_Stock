# Control de Stock

Aplicacion de escritorio desarrolada en **java** con interfaz gráfica utiliznado **Swing** y conexión a baes de datos **MySQL** mediante **JDBC**
Permite gestionar el inventario de productos de forma senilla, visualizando, agregando, editando y elimando registros, además de reporte por categoría.

---

## Funcionalidades 

- Agrega productos con nombre, descripción, cantidad y categoría.
- Modifica produtos existentes.
- Elimina productos del sistema.
- Generar reportes agrupados por categoría.
- Visualización automática de productos al iniciar (si existe alguno registrado).


--- 

## Tecnologías utilizadas

- Java 11
- Swing
- JDBC
- MySQL
- C3P0 (gestion de conexiones)
- Maven

---

## Cómo ejecutar el proyecto

- Clonar el repositorio
- Importa el proyecto en tu IDE como proyecto Maven.
  

Antes de ejecutar la aplicación, asegúrate de crear la base de datos y las tablas necesarias. Aquí un ejemplo básico:
## 🧱 Estructura de la base de datos

```sql
CREATE DATABASE control_de_stock;

USE control_de_stock;

CREATE TABLE categoria (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(255) NOT NULL
);

CREATE TABLE producto (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(255) NOT NULL,
    descripcion TEXT,
    cantidad INT NOT NULL,
    categoria_id INT,
    FOREIGN KEY (categoria_id) REFERENCES categoria(id)
);
