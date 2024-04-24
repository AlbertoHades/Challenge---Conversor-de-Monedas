# Open Challenge Backend ONE - Conversor de Monedas
 ***ONE | Fase 3 - Especialización Back-End  G6 Alura - Oracle Next Education***

[![Alura Latam](https://img.shields.io/badge/Alura-Latam-blue?style=flat)](https://www.aluracursos.com/)
[![Static Badge](https://img.shields.io/badge/ONE-Oracle_Next_Education-orange?style=flat&logo=oracle&logoColor=orange)](https://www.oracle.com/co/education/oracle-next-education/) [![Static Badge](https://img.shields.io/badge/IDE-IntelliJ_IDEA-%23ff0534?style=flat&logo=IntelliJ%20IDEA&logoColor=%232196f3)](https://www.jetbrains.com/es-es/idea/) [![Static Badge](https://img.shields.io/badge/Language-Java-%23ff0000?style=flat)](#)
[![Static Badge](https://img.shields.io/badge/Java_Library-Gson_%2F_Json-blue?style=flat&logo=json)](https://mvnrepository.com/artifact/com.google.code.gson/gson)
[![Static Badge](https://img.shields.io/badge/API-Exchange_Rate_API-%23e90000?style=flat)](https://www.exchangerate-api.com/docs/java-currency-api)
[![Static Badge](https://img.shields.io/badge/test-status-%23009929?logo=github)](#)
[![Static Badge](https://img.shields.io/badge/license-MIT-blue)](*)

Este es un desafío de la Especialización __Back-End G6 Alura - Oracle Next Education.__ Consiste en desarrollar un Conversor de Monedas en lenguaje Java, donde se realizarán solicitudes a una API de tasas de cambio para manipular datos JSON. Finalmente, se debe filtrar y mostrar las monedas de interés para realizar la conversión de monedas o divisas de diferentes países.

Los pasos solicitados para completar este desafío:

1.  Configurando el entorno Java
2.	Conociendo la API para traer datos
3.	Importando la biblioteca Gson en IntelliJ IDEA 
4.	Construyendo el Cliente para Solicitudes (HttpClient)
5.	Construyendo la Solicitud (HttpRequest)
6.	Construyendo la la Respuesta (HttpResponse)
7.	Analizando la respuesta en formato JSON
8.	Filtrando las monedas
9.	Convirtiendo Valores
11. Interactuando con el usuario
12. Hacer un Readme.md
13. Adicionales
   
&nbsp;

> [!NOTE]
> En este Challenge solicitan primero crear el repositorio del proyecto en GitHub.  
> El siguiente material te ayudará con esta actividad: [Git - Configurando Git por primera vez](https://git-scm.com/book/es/v2/Inicio---Sobre-el-Control-de-Versiones-Configurando-Git-por-primera-vez) y [Como subir mi proyecto en GitHub](https://www.youtube.com/watch?v=bhKkeOMysuw)  

&nbsp;

### 1. Configurando el entorno Java  

[![Static Badge](https://img.shields.io/badge/IDE-IntelliJ_IDEA-%23ff0534?style=flat&logo=IntelliJ%20IDEA&logoColor=%232196f3)](https://www.jetbrains.com/es-es/idea/) 
[![Static Badge](https://img.shields.io/badge/Language-Java-%23ff0000?style=flat)](#)
[![Static Badge](https://img.shields.io/badge/Java_Library-Gson_%2F_Json-blue?style=flat&logo=json)](https://mvnrepository.com/artifact/com.google.code.gson/gson)
[![Static Badge](https://img.shields.io/badge/API-Exchange_Rate_API-%23e90000?style=flat)](https://www.exchangerate-api.com/docs/java-currency-api) 
[![Static Badge](https://img.shields.io/badge/JSON--In--Java--20220320-JAR-blue)](*) 
[![Static Badge](https://img.shields.io/badge/Git-Github-blue?style=flat&logo=GitHub)](https://github.com/)
[![Static Badge](https://img.shields.io/badge/Postman-gray?style=flat&logo=Postman&logoColor=orange)](https://www.postman.com/)
[![Static Badge](https://img.shields.io/badge/app-Trello-%231466c3?style=flat&logo=trello)](https://trello.com/)

En esta primera fase, nos piden que se lleve acabo la instalación y configuración del entorno de desarrollo Java para nuestro desafío de construcción del Conversor de Monedas. Asegúrate de contar con los siguientes programas, archivos, versiones y app necesarias:
- IntelliJ IDEA Community Edition
- JDK 
- JSON en Java y la librería Gson
- Git y GitHub 
- Postman
- Trello

&nbsp;

### 2. Conociendo la API para traer datos
[![Static Badge](https://img.shields.io/badge/Configuracion_del_entorno-%230067ff?style=flat)](#)
[![Static Badge](https://img.shields.io/badge/API-Exchange_Rate_API-%23e90000?style=flat)](https://www.exchangerate-api.com/docs/java-currency-api) 

En este paso crucial, es fundamental comprender mejor la API de tasas de cambio a utilizar, revisar su documentación y aprender cómo obtener la clave de API. Esta clave es esencial para realizar solicitudes y obtener datos actualizados. Asegúrate de seguir cuidadosamente las instrucciones proporcionadas por la API Exchange Rate-API.

> [!NOTE]
> Para este challenge se utilizo la siguiente API: 
> [Exchange Rate-API](https://www.exchangerate-api.com/), debe registrarse para obtener su clave API (YOUR-API-KEY).

Interactuando con la API, encontramos como se realizan las consultas, 
Ejemplo: USD a COP, Dolares EEUU a Pesos Colombianos y un monto a convertir de 1000USD

```java
// Setting URL
https://v6.exchangerate-api.com/v6/YOUR-API-KEY/pair//USD/COP/1000
```
al realizar la consulta  en la API nos arroja lo siguiente:
```java
// 20240421181021
// https://v6.exchangerate-api.com/v6/YOUR-API-KEY/pair//USD/COP/1000
{
  "result": "success",
  "documentation": "https://www.exchangerate-api.com/docs",
  "terms_of_use": "https://www.exchangerate-api.com/terms",
  "time_last_update_unix": 1713657602,
  "time_last_update_utc": "Sun, 21 Apr 2024 00:00:02 +0000",
  "time_next_update_unix": 1713744002,
  "time_next_update_utc": "Mon, 22 Apr 2024 00:00:02 +0000",
  "base_code": "USD",
  "target_code": "COP",
  "conversion_rate": 3906.1426,
  "conversion_result": 3906142.6
}
```
y observamos los key que nos sirven para nuestro proyecto: 
```java
  "base_code": "USD" (MONEDA ORIGEN)
  "target_code": "COP" (MONEDA DESTINO)
  "conversion_rate": 3906.1426, (TASA DE CONVERSION) a esa fecha.
  "conversion_result": 3906142.6 (RESULTADO DE LA CONVERSION)
```

&nbsp;

### 3. Importando la biblioteca Gson en IntelliJ IDEA  
[![Static Badge](https://img.shields.io/badge/IDE-IntelliJ_IDEA-%23ff0534?style=flat&logo=IntelliJ%20IDEA&logoColor=%232196f3)](https://www.jetbrains.com/es-es/idea/) 
[![Static Badge](https://img.shields.io/badge/Java_Library-Gson_%2F_Json-blue?style=flat&logo=json)](https://mvnrepository.com/artifact/com.google.code.gson/gson)
[![Static Badge](https://img.shields.io/badge/Configuracion_del_entorno-%230067ff?style=flat)](#) 
[![Static Badge](https://img.shields.io/badge/JSON--In--Java--2.10.1-JAR-blue)](*) 

Para importar la biblioteca Gson en IntelliJ, sigue estos pasos:
1.	Abre tu proyecto en IntelliJ.
2.	Haz clic derecho sobre la carpeta del proyecto en el panel izquierdo.
3.	Selecciona "Open Module Settings" en el menú contextual.
4.	En la ventana que se abre, ve a la pestaña "Dependencies".
5.	Haz clic en el signo "+" en la esquina inferior izquierda y elige "Library".
6.	Busca "gson" en el cuadro de búsqueda.
7.	Selecciona la versión de Gson que desees utilizar, previamente descargada.
8.	Haz clic en "OK" para cerrar la ventana.
&nbsp;
> [!IMPORTANT]
> Para descargar la biblioteca Gson, debemos ir a Maven Repository en Google. Buscamos Gson y seleccionamos la primera opción. La version descargada para este challenge es la 2.10.1.  [MVN Repository Gson](https://mvnrepository.com/artifact/com.google.code.gson/gson)

&nbsp;
*En esta captura de pantalla se muestra la importacion de la biblioteca Gson.*
[![Screenshot interactuando y probando los key con la aplicacion Postman](https://github.com/nandojmj/conversor_prueba/blob/main/recursos/images/json.png)](#)

&nbsp;

### 4. Construyendo el Cliente para Solicitudes (HttpClient)  
[![Static Badge](https://img.shields.io/badge/IDE-IntelliJ_IDEA-%23ff0534?style=flat&logo=IntelliJ%20IDEA&logoColor=%232196f3)](https://www.jetbrains.com/es-es/idea/) 
[![Static Badge](https://img.shields.io/badge/Language-Java-%23ff0000?style=flat)](#)
[![Static Badge](https://img.shields.io/badge/Consumo_de_la_API-%23009929?style=flat)](#)
[![Static Badge](https://img.shields.io/badge/Http-Client-%23ff1a00?style=flat)](#)

Se utilizo la instancia HttpClient para realizar solicitudes a la API de tasas de cambio y obtener datos esenciales. El uso de`HttpClient` en Java facilita la conexión y la obtención de respuestas de manera eficiente. Se utiliza para enviar solicitudes HTTP y recibir respuestas HTTP sin la necesidad de bibliotecas externas.

> [!NOTE]
>  Es necesario obtener su clave API para agregarla al codigo:  
> [Exchange Rate API](https://www.exchangerate-api.com/)
> [Documentacion Exchange Rate API Java ](https://www.exchangerate-api.com/docs/java-currency-api)


&nbsp;

*En este fragmento de código, de la Class ""Conversion", se crea una instancia de `HttpClient` utilizando el método estático `newHttpClient()`. en YOUR-API-KEY se utiliza la llave solicitada:*
```java
// Método para realizar la conversión
     public RegistroConversion convertir(String codMonOrigen, String codMonDestino, int monto) {
        // Construir la URI para la solicitud a la API
        URI direccion_API = URI.create("https://v6.exchangerate-api.com/v6/YOUR-API-KEY/pair/"
                + codMonOrigen + "/" + codMonDestino + "/" + monto);
        // Crear cliente y solicitud HTTP
        HttpClient client = HttpClient.newHttpClient();
         // Resto del código omitido...
```
&nbsp;

### 5. Construyendo la Solicitud (HttpRequest)

[![Static Badge](https://img.shields.io/badge/IDE-IntelliJ_IDEA-%23ff0534?style=flat&logo=IntelliJ%20IDEA&logoColor=%232196f3)](https://www.jetbrains.com/es-es/idea/) 
[![Static Badge](https://img.shields.io/badge/Language-Java-%23ff0000?style=flat)](#)
[![Static Badge](https://img.shields.io/badge/Consumo_de_la_API-%23009929?style=flat)](#)
[![Static Badge](https://img.shields.io/badge/Http-Request-%23f7a40c?style=flat)](#)

El uso de la instancia HttpRequest para configurar y personalizar nuestras solicitudes a la API de tasas de cambio. La instancia HttpRequest en Java nos brinda un control detallado sobre los parámetros de nuestras solicitudes.

`HttpRequest` representa una solicitud HTTP y se utiliza para construir la solicitud HTTP que se enviará al servidor.

*En este fragmento de código, de la Class ""Conversion", se crea una instancia de `HttpRequest` utilizando el método `newBuilder()` de la clase `HttpRequest`, al cual se le pasa la URI del recurso solicitado.*
```java
 public RegistroConversion convertir(String codMonOrigen, String codMonDestino, int monto) {
       // Resto del código omitido...

           // Crear cliente y solicitud HTTP
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(direccion_API)
                .build();
       // Resto del código omitido...
```

&nbsp;

### 6. Construyendo la la Respuesta (HttpResponse)

[![Static Badge](https://img.shields.io/badge/IDE-IntelliJ_IDEA-%23ff0534?style=flat&logo=IntelliJ%20IDEA&logoColor=%232196f3)](https://www.jetbrains.com/es-es/idea/) 
[![Static Badge](https://img.shields.io/badge/Language-Java-%23ff0000?style=flat)](#)
[![Static Badge](https://img.shields.io/badge/Consumo_de_la_API-%23009929?style=flat)](#)
[![Static Badge](https://img.shields.io/badge/Http-Response-green?style=flat)](#)

En esta parte se solicito el uso de la interfaz HttpResponse para gestionar las respuestas recibidas de la API. 

- `HttpResponse` representa una respuesta HTTP recibida después de enviar una solicitud HTTP al servidor.
- Se utiliza para leer la respuesta del servidor, incluyendo el código de estado, encabezados y el cuerpo de la respuesta.


&nbsp;

*En este código, se declara una instancia de `HttpResponse<String>`, donde `<String>` especifica el tipo de cuerpo esperado en la respuesta, en este caso, una cadena de texto.*
```java
 public RegistroConversion convertir(String codMonOrigen, String codMonDestino, int monto) {
       // Resto del código omitido...

         // Variable para almacenar la respuesta de la solicitud
           HttpResponse<String> response;
        try {
            // Realizar la solicitud HTTP
            response = client.send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
        // Resto del código omitido...
```

&nbsp;

### 7.	Analizando la respuesta en formato JSON
[![Static Badge](https://img.shields.io/badge/IDE-IntelliJ_IDEA-%23ff0534?style=flat&logo=IntelliJ%20IDEA&logoColor=%232196f3)](https://www.jetbrains.com/es-es/idea/) 
[![Static Badge](https://img.shields.io/badge/Language-Java-%23ff0000?style=flat)](#)
[![Static Badge](https://img.shields.io/badge/Consumo_de_la_API-%23009929?style=flat)](#)
[![Static Badge](https://img.shields.io/badge/Java_Library-Gson_%2F_Json-blue?style=flat&logo=json)](https://mvnrepository.com/artifact/com.google.code.gson/gson)
[![Static Badge](https://img.shields.io/badge/API-Exchange_Rate_API-%23e90000?style=flat)](https://www.exchangerate-api.com/docs/java-currency-api)
[![Static Badge](https://img.shields.io/badge/Postman-gray?style=flat&logo=Postman&logoColor=orange)](https://www.postman.com/)


En esta parte de  nuestro Challenge se nos solicito el análisis de la respuesta JSON utilizando la biblioteca Gson en Java. La manipulación de datos JSON es esencial, ya que la mayoría de las respuestas de las API se presentan en este formato.  Se nos recomendo el uso de herramientas como Postman, para facilitar el análisis de los datos que se obtendrán de la API. Con la biblioteca Gson, puedes realizar el mapeo eficiente de los datos JSON a objetos Java, facilitando así la extracción y manipulación de la información necesaria.

> [!IMPORTANT]
> Recordar utilizar la biblioteca Gson. Para descargar la biblioteca Gson, debemos ir a Maven Repository en Google. Buscamos Gson y seleccionamos la primera opción. La version descargada para este challenge es la 2.10.1.  [MVN Repository Gson](https://mvnrepository.com/artifact/com.google.code.gson/gson)

*Fragmento de codigo utilizado en la Class Conversion.java, se  crea un JsonReader y se configura para aceptar JSON no valido:*
```java
 public RegistroConversion convertir(String codMonOrigen, String codMonDestino, int monto) {
       // Resto del código omitido...
// Leer el JSON de la respuesta
        try (JsonReader reader = new JsonReader(new StringReader(response.body()))) {
            reader.setLenient(true);

            // Configurar Gson para deserializar la respuesta
            Gson gson = new GsonBuilder()
                    .registerTypeAdapter(LocalDateTime.class, new LocalDateTimeAdapter())
                    .create();
        // Resto del código omitido...
```

&nbsp;

Como ya habiamos identificado los campos de la API,  __`base_code`, `target_code`, `conversion_rate`__, y __`conversion_result`__ podemos interactuar con la API Exchange Rate y obtener esos datos para nuestro conversor.

&nbsp;
*En esta captura de pantalla se muestra la interacción con el software Postman.*
[![Screenshot interactuando y probando los key con la aplicacion Postman](https://github.com/nandojmj/conversor_prueba/blob/main/recursos/images/ExchangePostman.png)](#)

&nbsp;

y observamos los key que nos sirven para nuestro proyecto: 
```java
  "base_code": "USD" (MONEDA ORIGEN)
  "target_code": "COP" (MONEDA DESTINO)
  "conversion_rate": 3906.1426, (TASA DE CONVERSION) a esa fecha.
  "conversion_result": 3906142.6 (RESULTADO DE LA CONVERSION)
```

### 8. Filtrando las monedas
[![Static Badge](https://img.shields.io/badge/IDE-IntelliJ_IDEA-%23ff0534?style=flat&logo=IntelliJ%20IDEA&logoColor=%232196f3)](https://www.jetbrains.com/es-es/idea/) 
[![Static Badge](https://img.shields.io/badge/Language-Java-%23ff0000?style=flat)](#)
[![Static Badge](https://img.shields.io/badge/Consumo_de_la_API-%23009929?style=flat)](#)
[![Static Badge](https://img.shields.io/badge/Java_Library-Gson_%2F_Json-blue?style=flat&logo=json)](https://mvnrepository.com/artifact/com.google.code.gson/gson)
[![Static Badge](https://img.shields.io/badge/API-Exchange_Rate_API-%23e90000?style=flat)](https://www.exchangerate-api.com/docs/java-currency-api)
[![Static Badge](https://img.shields.io/badge/Postman-gray?style=flat&logo=Postman&logoColor=orange)](https://www.postman.com/)

En la octava fase de nuestro Challenge, nos pidieron el proceso de filtrar las monedas utilizando la biblioteca Gson en Java.
Para acceder a datos específicos, como los valores de las diferentes monedas, es esencial comprender cómo navegar por la estructura JSON de la respuesta de la API. 

Para el filtrado de monedas, será necesario utilizar el atributo "Currency Code" del JSON. Para el desafío, nos dieron a elegir al menos tres "Currency Code" para incluir en la aplicación. Estos códigos son:

1.	ARS - Peso argentino
2.	BOB - Boliviano boliviano
3.	BRL - Real brasileño
4.	CLP - Peso chileno
5.	COP - Peso colombiano
6.	USD - Dólar estadounidense

  Como ya tenemos los campos identificados __`base_code`, `target_code`, `conversion_rate`__, y __`conversion_result`__  ahora podemos interactuar con la API Exchange Rate y obtener esos datos para nuestro conversor.
En este proyecto se utilizaron 4 codigos iniciales:

1.	COP - Peso colombiano
2.	USD - Dólar estadounidense
3.	BRL - Real brasileño
4.	ARS - Peso argentino

*Ej: USD -> COP*
```
{
(https://v6.exchangerate-api.com/v6/YOUR-API-KEY/pair//USD/COP/100000)
    "result": "success",
    "documentation": "https://www.exchangerate-api.com/docs",
    "terms_of_use": "https://www.exchangerate-api.com/terms",
    "time_last_update_unix": 1713744001,
    "time_last_update_utc": "Mon, 22 Apr 2024 00:00:01 +0000",
    "time_next_update_unix": 1713830401,
    "time_next_update_utc": "Tue, 23 Apr 2024 00:00:01 +0000",
    "base_code": "USD",
    "target_code": "COP",
    "conversion_rate": 3913.8964,
    "conversion_result": 391389640
}
```

*Ej: BRL -> COP*
```
(https://v6.exchangerate-api.com/v6/YOUR-API-KEY/pair//BRL/COP/100000):
{
    "result": "success",
    "documentation": "https://www.exchangerate-api.com/docs",
    "terms_of_use": "https://www.exchangerate-api.com/terms",
    "time_last_update_unix": 1713744001,
    "time_last_update_utc": "Mon, 22 Apr 2024 00:00:01 +0000",
    "time_next_update_unix": 1713830401,
    "time_next_update_utc": "Tue, 23 Apr 2024 00:00:01 +0000",
    "base_code": "BRL",
    "target_code": "COP",
    "conversion_rate": 747.1028,
    "conversion_result": 74710280
}
```

*Ej: ARS -> COP*
```
{
(https://v6.exchangerate-api.com/v6/YOUR-API-KEY/pair//ARS/COP/100000)
    "result": "success",
    "documentation": "https://www.exchangerate-api.com/docs",
    "terms_of_use": "https://www.exchangerate-api.com/terms",
    "time_last_update_unix": 1713744001,
    "time_last_update_utc": "Mon, 22 Apr 2024 00:00:01 +0000",
    "time_next_update_unix": 1713830401,
    "time_next_update_utc": "Tue, 23 Apr 2024 00:00:01 +0000",
    "base_code": "ARS",
    "target_code": "COP",
    "conversion_rate": 4.5260,
    "conversion_result": 452600
}
 
```

&nbsp;

### 9. Convirtiendo Valores
[![Static Badge](https://img.shields.io/badge/IDE-IntelliJ_IDEA-%23ff0534?style=flat&logo=IntelliJ%20IDEA&logoColor=%232196f3)](https://www.jetbrains.com/es-es/idea/) 
[![Static Badge](https://img.shields.io/badge/Language-Java-%23ff0000?style=flat)](#)
[![Static Badge](https://img.shields.io/badge/Consumo_de_la_API-%23009929?style=flat)](#)
[![Static Badge](https://img.shields.io/badge/Java_Library-Gson_%2F_Json-blue?style=flat&logo=json)](https://mvnrepository.com/artifact/com.google.code.gson/gson)
[![Static Badge](https://img.shields.io/badge/API-Exchange_Rate_API-%23e90000?style=flat)](https://www.exchangerate-api.com/docs/java-currency-api)

En esta novena fase, se nos pidio  las conversiones entre las monedas. Se crearon tres clases en el package Conversion:

![ ](https://github.com/nandojmj/conversor_prueba/blob/main/recursos/images/packageconversion.JPG)(#)

### Clase Conversion

La clase `Conversion` se utiliza para realizar conversiones de moneda utilizando una API externa y gestionar el historial de conversiones.
Realiza solicitudes HTTP a la API de ExchangeRate-API para obtener las tasas de conversión, alcula el resultado de la conversión y la tasa de conversión y guarda un registro de cada conversión realizada junto con la marca de tiempo en un archivo JSON.

__a. Atributos:__ La clase tiene atributos que representan los datos necesarios para realizar una conversión de moneda:
- `monedaOrigen`: Representa la moneda de origen de la conversión.
- `monedaDestino`: Representa la moneda de destino de la conversión.
- `monto`: Representa el monto a convertir.
- `resultado`: Representa el resultado de la conversión.
- `conversionRate`: La tasa de conversión.

__b. Método `convertir`:__ Este método realiza la conversión de moneda utilizando una API externa. Utiliza un cliente
HTTP para enviar una solicitud a la API, recibe la respuesta en formato JSON, la parsea y extrae los datos necesarios
utilizando la biblioteca Gson. Luego, crea un objeto `Conversion` con los datos obtenidos y lo guarda en el historial de
conversiones.

__c. Adaptador personalizado para `LocalDateTime`:__ La clase incluye un adaptador personalizado para serializar y deserializar
objetos `LocalDateTime`. Esto se utiliza para formatear adecuadamente las fechas y horas al guardar y recuperar el historial
de conversiones (`class LocalDateTimeAdapter`).

En resumen, la clase `Conversion` se utiliza como una interfaz para realizar conversiones de moneda utilizando una API externa, gestionando el historial de conversiones y proporcionando métodos para acceder y modificar los datos relacionados con la conversión.

&nbsp;

```
                        +-------------------+        +---------------------+
                        |    Principal      | ---->  |     MenuHandler     |
                        +-------------------+        +---------------------+
                        |                   |utiliza | mostrarMenu()       |
                        |                   |----- ->| ejecutarOpcion()    |
                        |                   |        | convertirMoneda()   |
                        |                   |        | elegirOtrasMonedas()|
                        |                   |        | mostrarResultado()  |
                        |                   |        +---------------------+
                        +-------------------+ 
                                  | utiliza
                                  |
                                  V
                        +-------------------+       +---------------------+      +---------------------+
                        |    Conversion     | <---> |  ConversionResponse | <--> |  RegistroConversion |
                        +-------------------+       +---------------------+      +---------------------+
                        | - monedaOrigen    |       | - monedaOrigen      |      | - conversion        |
                        | - monedaDestino   |       | - monedaDestino     |      | - timestamp         |
                        | - monto           |       | - conversionRate    |      +---------------------+
                        | - resultado       |       | - resultado         |
                        | - conversionRate  |       +---------------------+
                        |                   |       |Índices API Exchange |
                        |                   |       | - base_code         |
                        |                   |       | - target_code       |
                        |                   |       | - conversion_rate   |
                        +-------------------+       | - conversion_result |
                                   |                +---------------------+
                                   | utiliza
                                   | 
                                   V
                        +---------------------+
                        | LocalDateTimeAdapter|
                        +---------------------+

```
*En este diagrama:*

- `Principal` utiliza `MenuHandler` para manejar las opciones del menú y realizar las conversiones.
- `MenuHandler` interactúa con `Conversion` para realizar las conversiones de moneda.
- `Conversio`n utiliza `ConversionResponse` para obtener los datos de la API de tasas de cambio.
- `Conversion` también interactúa con `RegistroConversion` para mantener un registro de las conversiones realizadas.
- Conversion utiliza `LocalDateTimeAdapter` para serializar y deserializar objetos `LocalDateTime`.

&nbsp;

*Fragmento de codigo utilizado en la clase `Conversion`:*
```java

/**
 * Clase que representa una conversión entre monedas.
 */
public class Conversion {

    /** El código de la moneda de origen. */
    @SerializedName("Moneda_Origen")
    private String monedaOrigen;

    /** El código de la moneda de destino. */
    @SerializedName("Moneda_Destino")
    private String monedaDestino;

    /** El monto o cantidad de moneda a convertir. */
    @SerializedName("Monto_a_Convertir")
    private double monto;

    /** El resultado de la conversión. */
    @SerializedName("Resultado")
    private double resultado;

    /** La tasa de conversión. */
    @SerializedName("Tasa_Conversion")
    private double conversionRate;

    /** Constructor vacío. */
    public Conversion() {}

    /**
     * Constructor con parámetros.
     * @param monedaOrigen El código de la moneda de origen.
     * @param monedaDestino El código de la moneda de destino.
     * @param monto El monto a convertir.
     */
    public Conversion(String monedaOrigen, String monedaDestino, double monto) {
        this.monedaOrigen = monedaOrigen;
        this.monedaDestino = monedaDestino;
        this.monto = monto;
    }
 
 // Resto del código omitido...

```
&nbsp;


### Clase ConversionResponse

La clase se utiliza para representar los datos de respuesta de una conversión de moneda obtenida de la API externa. Aquí está un resumen de su propósito y uso:

__a. Atributos:__ La clase tiene tres atributos que representan los datos de la conversión:
       - `monedaOrigen`: Representa la moneda de origen de la conversión.
       - `monedaDestino`: Representa la moneda de destino de la conversión.
       - `conversionRate`: La tasa de conversión entre la moneda base y la moneda destino.
       - `resultado`: Representa el resultado de la conversión.
       
__b. Anotaciones de SerializedName:__ Las anotaciones `@SerializedName` se utilizan para especificar el nombre de los campos en el 
      JSON que se utilizarán para mapear los datos a los atributos de la clase. Esto es útil cuando los nombres de los campos en el 
      JSON no coinciden con los nombres de los atributos en la clase.
      
__c. Getters y setters:__ Se proporcionan métodos para acceder y modificar los atributos de la clase.

__d. Método toString:__ Se sobrescribe el método `toString` para proporcionar una representación de cadena de la clase. Esto es útil 
      para imprimir fácilmente los objetos de tipo  `ConversionResponse` en forma legible para los humanos.     
    
En resumen, la clase `ConversionResponse` se utiliza como un contenedor de datos para representar la respuesta de una conversión de moneda, facilitando el procesamiento y manipulación de estos datos en el código del programa.

 &nbsp;

*Fragmento de codigo utilizado en la clase `ConversionResponse.java`:*
```java
 // Resto del código omitido...
     /**
 * Clase que representa la respuesta de la API de ExchangeRate-API.
 * Proporciona métodos para acceder a los datos de la conversión.
 */
public class ConversionResponse {

    /** El código de la moneda base en la conversión. Índices de la API de ExchangeRate-API:
     * "base_code"."target_code" "conversion_rate" "conversion_result"*/

    /** El código de la moneda origen en la conversión. */
    @SerializedName("base_code")
    private String monedaOrigen;

    /** El código de la moneda destino en la conversión. */
    @SerializedName("target_code")
    private String monedaDestino;

    /** La tasa de conversión entre la moneda base y la moneda destino. */
    @SerializedName("conversion_rate")
    private double conversionRate;

    /** El resultado de la conversión. */
    @SerializedName("conversion_result")
    private double resultado;

    /** Obtiene el código de la moneda base. */
    public String getMonedaOrigen() {
        return monedaOrigen;
    }

    /** Establece el código de la moneda base. */
    public void setMonedaOrigen(String monedaOrigen) {
        this.monedaOrigen = monedaOrigen;
    }
// Resto del código omitido...
 
```
&nbsp;

### Clase RegistroConversion

La clase `RegistroConversion` se utiliza para representar un registro de conversión, que incluye los detalles de la conversión realizada y la marca de tiempo en la que se realizó. Aquí está un resumen de su propósito y uso:

__a. Atributos:__ La clase tiene dos atributos:
      - `conversion`: Representa el objeto de conversión asociado a este registro.
          - `timestamp`: Representa la marca de tiempo del registro, indicando cuándo se realizó la conversión.

__b. Constructor__
      - `RegistroConversion(Conversion conversion)`: Constructor que inicializa un registro de conversión con 
         la conversión 
         y la marca de tiempo actual.
          - Parámetros:
             - `conversion`: La conversión de moneda que se está registrando.

__c. Métodos de acceso__
         - `getConversion()`: Devuelve la conversión asociada con este registro.
         - `setConversion(Conversion conversion)`: Establece la conversión asociada con este registro.
             - Parámetros:
                 - `conversion`: La conversión a establecer.
         - `getTimestamp()`: Devuelve la marca de tiempo de este registro.
         - `setTimestamp(LocalDateTime timestamp)`: Establece la marca de tiempo de este registro.
             - Parámetros:
                 - `timestamp`: La marca de tiempo a establecer.

__d. Método `toString()`__
            - `toString()`: Genera una representación en forma de cadena de este registro de conversión, incluyendo 
               la moneda de origen, la moneda de destino, el monto, la tasa de conversión, el resultado y la marca 
               de tiempo en un formato legible.

Ejemplo de uso:

```java
// Crear una instancia de Conversion
Conversion conversion = new Conversion("USD", "EUR", 100.0);

// Crear un registro de conversión
RegistroConversion registro = new RegistroConversion(conversion);

// Imprimir el registro
System.out.println(registro);
```
&nbsp;
```
Registro de Conversión: {
  Moneda de Origen: USD
  Moneda de Destino: EUR
  Monto: 100.0
  Tasa de Conversión: 0.8325
  Resultado: 83.25
  Marca de Tiempo: 2024-04-23 09:30:15
}
```

&nbsp;

*Fragmento de codigo utilizado en la `Class RegistroConversion.java`:*
```java
 package conversion;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

 public class RegistroConversion {
    // Atributos
    private Conversion conversion; // Objeto de conversión asociado a este registro
    private LocalDateTime timestamp; // Marca de tiempo del registro

    // Constructor
    public RegistroConversion(Conversion conversion) {
        this.conversion = conversion; // Asigna el objeto de conversión proporcionado
        this.timestamp = LocalDateTime.now(); // Establece la marca de tiempo actual
    }

    // Getters y setters
    public Conversion getConversion() {
        return conversion; // Retorna el objeto de conversión asociado a este registro
    }

    public void setConversion(Conversion conversion) {
        this.conversion = conversion; // Establece el objeto de conversión asociado a este registro
    }

    public LocalDateTime getTimestamp() {
        return timestamp; // Retorna la marca de tiempo del registro
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp; // Establece la marca de tiempo del registro
    }
 // Resto del código omitido...

 
```
&nbsp;



### 10. Interactuando con el usuario
[![Static Badge](https://img.shields.io/badge/IDE-IntelliJ_IDEA-%23ff0534?style=flat&logo=IntelliJ%20IDEA&logoColor=%232196f3)](https://www.jetbrains.com/es-es/idea/) 
[![Static Badge](https://img.shields.io/badge/Language-Java-%23ff0000?style=flat)](#)
[![Static Badge](https://img.shields.io/badge/Pruebas_finales-%2340a5ff?style=flat)](#)

En esta etapa del desafío, se solicito  la interacción con el usuario, implementando una interfaz textual a través de la consola que presenta opciones de conversión de monedas. La estructura incluirá un menú dentro de un bucle de repetición, permitiendo al usuario seleccionar opciones numéricas y proporcionar datos para la conversión, utilizando la  `clase Scanner` para capturar la entrada del usuario.

Se creo la clase `MenuHandler` que  proporciona métodos para mostrar un menú de opciones de conversión de moneda y ejecutar la opción seleccionada por el usuario.
Función:
La clase MenuHandler realiza las siguientes funciones:
- Muestra un menú con varias opciones de conversión de moneda.
- Ejecuta la opción seleccionada por el usuario, realizando la conversión correspondiente.
- Gestiona la entrada del usuario para elegir otras monedas a convertir.


  &nbsp;
  
Ejemplo:

```java
// Crear una instancia de Conversion
Conversion conversion = new Conversion();
Scanner lectura = new Scanner(System.in);

// Mostrar el menú de opciones
MenuHandler.mostrarMenu();

// Leer la opción seleccionada por el usuario
int opcion = lectura.nextInt();

// Ejecutar la opción seleccionada
MenuHandler.ejecutarOpcion(opcion, conversion, lectura);

// Cerrar el scanner después de su uso
lectura.close();
```
En resumen facilita la interacción del usuario con el programa de conversión de moneda. Proporciona métodos para mostrar un menú de opciones, ejecutar la opción seleccionada y realizar la conversión correspondiente.

&nbsp;

*Fragmento de codigo utilizado en la Class MenuHandler.java:*
```java
 // Resto del código omitido...

public class MenuHandler {
    // Método para mostrar el menú de opciones
    public static void mostrarMenu() {
        System.out.println("************************************************************");
        System.out.println("""
                1- Convertir de COP (peso colombiano) a USD (dólar).
                2- Convertir de USD (dólar) a COP (peso colombiano).
                3- Convertir de BRL (real brasileño) a USD (dólar).
                4- Convertir de USD (dólar) a BRL (real brasileño).
                5- Convertir de ARS (peso argentino) a USD (dólar).
                6- Convertir de USD (dólar) a ARS (peso argentino).
                7- Elegir otras monedas para convertir.
                8- Salir
                Elija una opción:""");
    }

    // Método para ejecutar la opción seleccionada por el usuario
    public static void ejecutarOpcion(int opcion, Conversion conversion, Scanner lectura) {
        switch (opcion) {
            case 1:
                convertirMoneda("COP", "USD", conversion, lectura); // Convertir de COP a USD
                break;
             case 2:
                convertirMoneda("USD", "COP", conversion, lectura); // Convertir de USD a COP
                break;
            case 3:
                convertirMoneda("BRL", "USD", conversion, lectura); // Convertir de BRL a USD
                break;

             // Resto del código omitido...

             case 8:
                System.out.println("¡Gracias por usar el convertidor! ¡Hasta luego!"); // Mensaje de despedida
                System.exit(0); // Finaliza el programa
            default:
                System.out.println("Opción inválida. Por favor, seleccione una opción válida del menú."); // Mensaje de opción inválida
                break;
        }
    }
            // Resto del código omitido...
```
&nbsp;
&nbsp;

### 11. **Hacer un README:** [![Static Badge](https://img.shields.io/badge/status-OK-gree)](#)
Uno de los pasos más importantes al participar en una selección de trabajo es resolver un desafío propuesto por la empresa con la información de la resolución, y generalmente esto debe estar en el README. ¿Y qué es el README? Es un archivo con extensión .md y es un documento con la descripción del proyecto. 
Este mismo archivo que se esta leyendo fue el resultado del README para el Challenge.


### 12.	**Extra (Opcional)**

Se nos propueso nn caso que quiecieramos desafiarnos aún más y proporcionar a los usuarios una experiencia más rica y personalizada, hay diversas funcionalidades interesantes que puedes explorar:

#### 12.1  Historial de Conversiones: [![Static Badge](https://img.shields.io/badge/status-OK-gree)](#)
Agregar la capacidad de rastrear y mostrar el historial de las últimas conversiones realizadas, brindando a los usuarios una visión completa de sus actividades.

####  Registro de Historial en Archivo JSON 

En la clase `Conversion`, se mantiene un registro de todas las conversiones realizadas en un archivo JSON llamado "registros_data_time.json". Aquí está cómo se realiza:

1. **Lectura del Historial desde un Archivo JSON**:
   Se lee el historial de conversiones desde el archivo JSON utilizando Gson. Si el archivo no existe, se crea un historial vacío.

    ```java
    RegistroConversion[] historial;
    try (Reader fileReader = new FileReader("registros_data_time.json")) {
        historial = gson.fromJson(fileReader, RegistroConversion[].class);
    } catch (FileNotFoundException e) {
        historial = new RegistroConversion[0];
    }
    ```

2. **Actualización del Historial**: 

   Se agrega el nuevo registro de conversión al final del historial existente.

    ```java
    RegistroConversion[] nuevoHistorial = new RegistroConversion[historial.length + 1];
    System.arraycopy(historial, 0, nuevoHistorial, 0, historial.length);
    nuevoHistorial[historial.length] = registroConversion;
    ```

3. **Escritura del Historial Actualizado en el Archivo JSON**:
   Se escribe el historial actualizado en el archivo JSON para mantener un registro de todas las conversiones realizadas.

    ```java
    try (Writer fileWriter = new FileWriter("registros_data_time.json")) {
        gson.toJson(nuevoHistorial, fileWriter);
    } catch (IOException e) {
        e.printStackTrace();
    }
    ```

De esta manera, cada vez que se realiza una conversión de moneda, se agrega un nuevo registro al historial y se actualiza el archivo JSON con el nuevo historial. Así, se mantiene un registro completo y actualizado de todas las conversiones realizadas.

*Captura de pantalla de la ejecucion del proyecto mostrando resultados de conversion y se observa el contenido en el archivo `registros_data_time.json` en formato json, donde se registran y actualizan las consultas realizadas, incluyendo información sobre qué monedas se convirtieron*

![ ](https://github.com/nandojmj/conversor_prueba/blob/main/recursos/images/json2.png) 

Registro en el archivo `registros_data_time.json`:
```
 {
    "conversion": {
      "Moneda_Origen": "ARS",
      "Moneda_Destino": "USD",
      "Monto_a_Convertir": 100500.0,
      "Resultado": 116.178,
      "Tasa_Conversion": 0.001156
    },
    "timestamp": "2024-04-22 14:15:58"
  },
  {
    "conversion": {
      "Moneda_Origen": "USD",
      "Moneda_Destino": "COP",
      "Monto_a_Convertir": 500.0,
      "Resultado": 1956948.2,
      "Tasa_Conversion": 3913.8964
    },
    "timestamp": "2024-04-22 14:17:03"
  }
```


#### 12.2  Soporte para Más Monedas: [![Static Badge](https://img.shields.io/badge/status-OK-gree)](#)
Se amplía la lista de monedas disponibles para la elección, permitiendo a los usuarios convertir entre una variedad aún mayor de opciones monetarias.La API admite las 161 monedas mundiales que circulan habitualmente. Estos cubren el 99% de todos los estados y territorios reconocidos por la ONU.

***Fragmento de codigo utilizado en la Class `MenuHandler.java` para seleccionar otras monedas que se desea convertir. En el menu principal la opcion 7 nos lleva a `7-Elegir otro tipo de monedas a convertir: donde nos mostra 100 codigos currency con sus respectivos paises` cumpliendo con la opcion adicional del challenge de Soporte para Más Monedas ***

```java
// Resto del código omitido...
  public static void mostrarMenu() {
        System.out.println("************************************************************");
        System.out.println("""
                1- Convertir de COP (peso colombiano) a USD (dólar).
                2- Convertir de USD (dólar) a COP (peso colombiano).
                3- Convertir de BRL (real brasileño) a USD (dólar).
                4- Convertir de USD (dólar) a BRL (real brasileño).
                5- Convertir de ARS (peso argentino) a USD (dólar).
                6- Convertir de USD (dólar) a ARS (peso argentino).
                7- Elegir otras monedas para convertir.
                8- Salir

 // Resto del código omitido...

            case 6:
                convertirMoneda("USD", "ARS", conversion, lectura); // Convertir de USD a ARS
                break;
            case 7:
                elegirOtrasMonedas(conversion, lectura); // Llama al método para elegir otras monedas a convertir
                break;
            case 8:
                System.out.println("¡Gracias por usar el convertidor! ¡Hasta luego!"); // Mensaje de despedida
                System.exit(0); // Finaliza el programa

// Resto del código omitido...

           private static void elegirOtrasMonedas(Conversion conversion, Scanner lectura) {
        try {
            System.out.println("""
            Esta lista contiene 100 códigos de moneda y sus respectivos países para facilitar la conversión de moneda:
        
            | 1.  **AED**: United Arab Emirates      | 2.  **AFN**: Afghanistan          | 3.  **ALL**: Albania
            | 4.  **AMD**: Armenia                   | 5.  **ANG**: Netherlands Antilles | 6.  **AOA**: Angola
            | 7.  **ARS**: Argentina                 | 8.  **AUD**: Australia            | 9.  **AWG**: Aruba
            | 10. **AZN**: Azerbaijan                | 11. **BBD**: Barbados             | 12. **BGN**: Bulgaria
            | 13. **BHD**: Bahrain                   | 14. **BRL**: Brazil               | 15. **BSD**: Bahamas
            | 16. **BTN**: Bhutan                    | 17. **BWP**: Botswana             | 18. **BZD**: Belize

// Resto del código omitido...

      | 100. **PLN**: Poland
            Ingrese el código de moneda base:""");

            String monedaBase = lectura.next().toUpperCase(); // Lee el código de moneda base ingresado por el usuario
            System.out.println("Ingrese el código de moneda destino:");
            String monedaDestino = lectura.next().toUpperCase(); // Lee el código de moneda destino ingresado por el usuario
            convertirMoneda(monedaBase, monedaDestino, conversion, lectura); // Realiza la conversión
        } catch (Exception e) {
// Resto del código omitido...
```



&nbsp;

#### 12.3  Registros con Marca de Tiempo: [![Static Badge](https://img.shields.io/badge/status-OK-gree)](#)

Se creo la clase `LocalDateTimeAdapter`, para cumplir con este adicional del desafio.

La clase `LocalDateTimeAdapter` es una clase utilizada para adaptar la serialización y deserialización de objetos `LocalDateTime` al formato JSON utilizando la biblioteca Gson de Google. Su objetivo es proporcionar la capacidad de convertir objetos `LocalDateTime` a formato JSON y viceversa de manera que puedan ser almacenados y recuperados adecuadamente.

- **Implementación**:
  - La clase implementa las interfaces `JsonSerializer` y `JsonDeserializer` de Gson para personalizar la serialización y deserialización de objetos `LocalDateTime`.
  - Utiliza un objeto `DateTimeFormatter` para definir el formato de fecha y hora deseado ("yyyy-MM-dd HH:mm:ss").
  - Sobrescribe los métodos `serialize` y `deserialize` para convertir entre `LocalDateTime` y JSON.

- **Método `serialize`**:
  - Este método toma un objeto `LocalDateTime` como entrada y devuelve un `JsonElement`, que en este caso es un `JsonPrimitive` que contiene la fecha y hora formateadas según el patrón definido por `DateTimeFormatter`.

- **Método `deserialize`**:
  - Este método toma un `JsonElement` (que se espera que sea un `JsonPrimitive` con una cadena representando una fecha y hora) y lo convierte de nuevo a un objeto `LocalDateTime` utilizando el formato definido por `DateTimeFormatter`.

En resumen, `LocalDateTimeAdapter` es una clase útil para adaptar la serialización y deserialización de objetos `LocalDateTime` al formato JSON, lo que facilita su almacenamiento y recuperación en aplicaciones que utilizan Gson para el manejo de JSON.


*Fragmento de codigo utilizado en la Class `RegistroConversion.java` donde se crea  `registros_data_time.json` en formato json, donde se registran y actualizan las consultas realizadas, incluyendo información sobre qué monedas se convirtieron y en qué fecha para cumplir con la parte adicional de este challenge:*
```java
 // Resto del código omitido...

package adapters;

  // Resto del código omitido...
/** Clase interna para adaptar la serialización y deserialización de LocalDateTime. */
public class LocalDateTimeAdapter implements JsonSerializer<LocalDateTime>, JsonDeserializer<LocalDateTime> {
    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    @Override
    public JsonElement serialize(LocalDateTime src, java.lang.reflect.Type typeOfSrc, JsonSerializationContext context) {
        return new JsonPrimitive(formatter.format(src));
    }

    @Override
    public LocalDateTime deserialize(JsonElement json, java.lang.reflect.Type typeOfT, JsonDeserializationContext context)
            throws JsonParseException {
        return LocalDateTime.parse(json.getAsString(), formatter);
    }
}

  // Resto del código omitido...
    
```


*Fragmento del registro del archivo `registros_data_time.json` en formato json, donde se registran y actualizan las consultas realizadas, incluyendo información sobre qué monedas se convirtieron y en qué fecha para cumplir con la parte adicional de este challenge:*

```
 {
    "conversion": {
      "Moneda_Origen": "ARS",
      "Moneda_Destino": "USD",
      "Monto_a_Convertir": 100500.0,
      "Resultado": 116.178,
      "Tasa_Conversion": 0.001156
    },
    "timestamp": "2024-04-22 14:15:58"
  },
  {
    "conversion": {
      "Moneda_Origen": "USD",
      "Moneda_Destino": "COP",
      "Monto_a_Convertir": 500.0,
      "Resultado": 1956948.2,
      "Tasa_Conversion": 3913.8964
    },
    "timestamp": "2024-04-22 14:17:03"
  }
```
            
### 14. Ejecución del Proyecto
Para ejecutar el proyecto, sigue estos pasos:

* Clona o descarga desde Github el repositorio en tu disco local.
* Importa el proyecto en tu IDE de Java (este proyecto se realizo en IntelliJ IDEA).
* Configura las dependencias y ajusta la configuración según sea necesario.
* Corre la aplicacion para interactuar con consola.

### 15. Capturas y Video
[![Static Badge](https://img.shields.io/badge/status-under%20construction-%2393a8ac)](#)

[![Screenshot interactuando y probando los key con la aplicacion Postman](https://github.com/nandojmj/conversor_prueba/blob/main/recursos/images/captura.gif)](#)

[![Screenshot interactuando y probando los key con la aplicacion Postman](https://github.com/nandojmj/conversor_prueba/blob/main/recursos/images/Captura2.JPG)](#)

[![Screenshot interactuando y probando los key con la aplicacion Postman](https://github.com/nandojmj/conversor_prueba/blob/main/recursos/images/Captura3.JPG)](#) 




## Documentation
[![Static Badge](https://img.shields.io/badge/status-under%20construction-%2393a8ac)](#)

## Glossary

[![Static Badge](https://img.shields.io/badge/status-under%20construction-%2393a8ac)](#)
