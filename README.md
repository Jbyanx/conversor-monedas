# conversor-monedas
challenge conversor de monedas de alura
Esta es una aplicación por terminal que se conecta a la API de Exchange Key para realizar conversiones de monedas en tiempo real. Utiliza la biblioteca Gson para manejar el cast del JSON de respuesta a clases Java.

## Características

- **Conversión en tiempo real:** Obtén tasas de cambio actualizadas al momento.
- **Interfaz de línea de comandos (CLI):** Fácil de usar desde la terminal.
- **Selección interactiva de monedas:** Muestra una lista de 17 monedas disponibles y permite al usuario elegir la moneda de origen y destino.
- **JSON Parsing con Gson:** Manejo eficiente y sencillo de respuestas JSON.

## Requisitos

- **Java:** Versión 8 o superior.
- **Bibliotecas externas:** 
  - [Gson](https://github.com/google/gson): Para el manejo del JSON.
- **Clave de API:** Necesitarás una clave de la API de Exchange Key.
