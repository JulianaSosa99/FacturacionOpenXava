
# 💼 Sistema de Facturación — OpenXava + MySQL

![Java](https://img.shields.io/badge/Java-11-orange)
![Framework](https://img.shields.io/badge/OpenXava-7.6-blue)
![DB](https://img.shields.io/badge/MySQL-8.0-lightblue)
![Build](https://img.shields.io/badge/Maven-3.8+-green)

Aplicación web de **facturación y gestión de productos** desarrollada con **OpenXava**, conectada a una base de datos **MySQL**.
Incluye autenticación, módulos CRUD y estructura adaptable a cualquier entorno académico o empresarial.

---

## 🚀 Instalación rápida

```bash
# Clonar el repositorio
git clone https://github.com/usuario/facturacion.git
cd facturacion

# Compilar el proyecto
mvn clean package
```

---

## ⚙️ Configuración de Base de Datos

En MySQL:

```sql
CREATE DATABASE facturaciondb CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
```

Archivo `src/main/webapp/META-INF/context.xml`:

```xml
<Resource name="jdbc/facturacionDS" auth="Container" type="javax.sql.DataSource"
  username="root" password="tu_clave"
  driverClassName="com.mysql.cj.jdbc.Driver"
  url="jdbc:mysql://localhost:3306/facturaciondb?useSSL=false&serverTimezone=UTC"/>
```

---

## ▶️ Ejecución

```bash
# Desde OpenXava Studio o Eclipse
Run As → Java Application → facturacion
```

Luego abre en navegador:
👉 [http://localhost:8080/facturacion](http://localhost:8080/facturacion)

**Usuario:** admin
**Contraseña:** admin

---

## 🧰 Stack

* Java 11
* OpenXava 7.6
* Tomcat 9
* MySQL 8.0
* Maven

---

## 🧑‍💻 Autor

**Juliana Sosa**
📅 Octubre 2025
🛠️ Proyecto académico — Sistema de Facturación con OpenXava
