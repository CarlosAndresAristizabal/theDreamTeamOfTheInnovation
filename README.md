# `Top 10` de los investigadores usando `GOOGLE SCHOLAR API` con uso de base de datos `MySQL` implementando el patrón de diseño `MVC` y programado en `JAVA`.

Bienvenidos este código consiste en usar una API que es [`Google scholar API`](https://serpapi.com/google-scholar-api), las cuales podemos hacer consultas, poder manejar los datos consultados y esos datos extraerlos para poder guardarlos una base de datos, programado con `JAVA` y el uso de librerias externas entre ellas (`JSON-simple`, `JSON`, `MySQL-Connector`).

# Requisitos para el uso

- Necesitas crear una cuenta en [`SerApi`](https://serpapi.com/) de las cuales obtienes una ApiKey.
- Después de hacer la cuenta puedes ir a la sección de [`perfiles de API`](https://serpapi.com/google-scholar-profiles-api) aqui puedes buscar por nombre y en el resultado puedes obtener el `author_id` .
- Descargar el archivo de [`MySQL`](/MySQL/autor.sql) y los importas en tu manejador de base de datos favorito con el nombre de la tabla `registroinvestigadores.`
- Hacer una copia o una rama del repositorio.

> `NOTA:` <em>El `author_id` este id lo pide el programa y igual que el ApiKey.</em>

# Estructura del código

Esta diseñado con el patrón de diseño `MVC` esta es la organización del código.

![Estructura](ReadmeDOC/Estructura.png)

# Modelos.

### ⚜️Modelo autor

![Autor Variables](ReadmeDOC/autor_Variables.png)

### ⚜️Constructores.

![Autor Constructores](ReadmeDOC/autor_Constructor.png)

### ⚜️ Getters y Setters

![Autor Getters y Setters](ReadmeDOC/autor_Getters_Setters.png)

### ⚜️Impresión de datos

![Autor Impresion de datos](ReadmeDOC/autor_Impresión_datos.png)

### Modelo conexion API

![Conexion API](ReadmeDOC/conexionAPI.png)

# Controlador API Autor

### ⚜️ Importamos las librerias, creamos las variables e instanciamos los constructores de los modelos.

![Librerias y variables](ReadmeDOC/controladorAPIAutor.png)

### ⚜️Constructores

![Constructor](ReadmeDOC/controladorAPIAutor_constructor.png)

### ⚜️Conexion URL

![Conexion Url](ReadmeDOC/controladorAPiAutor_conexionURL.png)

### ⚜️ Lectrua del JSON

![Lrctura del JSON](ReadmeDOC/controladorAPiAutor_Lectura_JSON.png)

### ⚜️Recorrido del JSON

![Recorrido JSON](ReadmeDOC/controladorAPiAutor_recorrido_JSON.png)

### ⚜️Resultado y impresión

![Resultado](ReadmeDOC/controladorAPiAutor_Resultado_JSON.png)

### ⚜️ Guardar los datos obtenidos en la BD

![Guardar datos](ReadmeDOC/controladorAPiAutor_Guardar_BD.png)

### ⚜️Consulta de la BD

![Consulta BD](ReadmeDOC/controladorAPiAutor_Consulta_BD.png)

### ⚜️TOP 10

![Top 10 de los investigadores guardados en la BD](ReadmeDOC/controladorAPiAutor_TOP_BD.png)

# Vista

### ⚜️Variables y constructor

![Variables y Constructor](ReadmeDOC/Vista.png)

### ⚜️Encabezado

![Encabezado](ReadmeDOC/Vista_Encabezado.png)

### ⚜️Contenido

![Contenido](ReadmeDOC/Vista_Contenido.png)

### ⚜️Footer

![Footer](ReadmeDOC/Vista_Footer.png)

# App Main

![Main](ReadmeDOC/Main.png)

# Consola salida

### ⚜️Aqui muestra el encabezado y apikey

![Encabezado Consola](ReadmeDOC/Consola_1.png)

> `NOTA:`<em> Aqui te pide el ApiKey</em>

### ⚜️ Menú de opciónes

![Menu de opciónes](ReadmeDOC/Consola_2.png)

### ⚜️Opción 1. Buscar perfil por ID

![Buscar perfil](ReadmeDOC/Consola_3.png)

> `NOTA:` <em> Después de ingresar al menú te pide el ID y muestra el resultado.</em>

### ⚜️Menú de opción para guardar en la BD

![Guardar BD](ReadmeDOC/Consola_4.png)

> `NOTA:` <em>Guardas los resultados en la base de datos </em>

### ⚜️Mensaje de guardado y te mostrará el footer

![Exitos guardado](ReadmeDOC/Consola_5.png)

### ⚜️ Opción 2. Consulta los datos que hay en la base de datos

![Resultados](ReadmeDOC/Consola_6.png)

### ⚜️Opción 3. Te mostrara el TOP 10 de los investigadores

![Top](ReadmeDOC/Consola_7.png)

# Asi termina el código. esta es la primera versión la segunda versión habra mejoras.
