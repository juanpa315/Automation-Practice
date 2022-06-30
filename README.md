# **Introducción.**

Este proyecto consiste en una Automatizacion web sobre un aplicativo de E-commerce (http://automationpractice.com/index.php), en donde se realizan diferentes casos, cómo crear una cuenta, registrar un usuario, y realizar un solicitud sobre una compra, para esto se trabajan diferentes conceptos, como la localización de diversos elementos web, envío de data desde excel, carga de archivos, interactuar con elementos de tipo select entre otros.


### **Tecnologías.**

**Arquitectura:** Page Object Model (POM).
**Gestor de dependencias:** Gradle.
**Paradigma de Programación:** Programación orientada a objetos (POO).
**Lenguaje de programación:** java.
**Otras técnologías:** Selenium WebDriver y cucumber.

### **Estructura del proyecto.**

**Feature:** Aquí se especifican los escenarios de prueba y se plasman los pasos para realizar el caso.
**Steps:** Se implementan cada uno de los pasos creados en la feature y se comunica con el page para acceder a los metodos especificos de cada pagina.
**Page:** Aquí se plasman los métodos necesarios para poder interactuar con la pagina web.
**Base.java:** Aquí se ponen métodos genéricos que son utilizados por diferentes paginas, con la intención de crearlos una única vez.
**Locators.java:** Aquí se especifican todos los elementos web que se utlizaran para la automatización. 
