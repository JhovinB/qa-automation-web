# qa-automation-web

Este proyecto automatiza el flujo completo de compra
en el sitio SauceDemo(https://www.saucedemo.com/)
utilizando Selenium WebDriver, Cucumber (BDD), JUnit, ejecutado bajo Maven 
y desarrollado bajo el Patron de diseño Page Object Model(POM)

## Objetivo

Validar de manera automática el proceso de compra end-to-end:
1. Login
2. Agregar productos al carrito.
3. Realizar checkout.
4. Completar información del cliente.
5. Finalizar compra.
6. Cerrar sesión.

---
## Instrucciones de ejecución

### Requisitos previos
Asegúrate de tener instalados:
- Java 17 o superior
- Maven 3.8+
- Google Chrome (versión 142 o compatible)
- Chromedriver.exe en 'src/test/resources/driver/'
### Librerías utilizadas

-Selenium Java	4.21.0	
-Cucumber Java	7.15.0	
-Cucumber JUnit	7.15.0	
-JUnit	4.13.2	
-AssertJ	3.26.0
-ExtentReports + Adapter	5.1.1 / 1.14.0	
-Maven Cucumber Reporting	5.8.0

### Verifica la instalación:
bash
    java -version
    mvn -version
    google-chrome --version

### Clonar el repositorio
git clone https://github.com/JhovinB/qa-automation-web.git

### ejecutar
mvn clean test

## Reportes generados

| Reporte              | Ruta                                                | Tipo    |
| -------------------- | --------------------------------------------------- | ------- |
|Cucumber JSON         | 'target/cucumber-reports/cucumber.json'             | '.json' |
|Reporte HTML básico   | 'target/cucumber-reports/cucumber-html-report.html' | '.html' |
|Extent Report         | 'target/extent-reports/'                            | '.html' |


## Tiempo estimado de ejecución
Estimación de 16 a 17 segundos en ejecutarse.

## Autor
Jhovin Maho Bonifacio Lozano
QA Automation Engineer