## Configuración de Maven

El proyecto utiliza Maven para la gestión de dependencias y la ejecución de pruebas automatizadas.

En el archivo pom.xml se configuró JUnit 5.11.0 como framework para las pruebas unitarias.

Para ejecutar las pruebas localmente se utiliza:

mvn test

También se puede limpiar el proyecto y volver a ejecutar las pruebas mediante:

mvn clean test

## Pruebas unitarias

Se creó la clase Calculadora, que contiene las operaciones de suma y resta.

Para validar su funcionamiento se implementaron dos pruebas unitarias en la clase CalculadoraTest:

- sumarDosNumeros: valida la operación de suma.
- restarDosNumeros: valida la operación de resta.

Cada prueba posee un único objetivo y puede ejecutarse de forma independiente, manteniendo la atomicidad de la suite.

La ejecución local obtuvo el siguiente resultado:

Tests run: 2, Failures: 0, Errors: 0, Skipped: 0
BUILD SUCCESS

## Control de versiones

El proyecto utiliza Git para mantener el control de versiones y registrar los cambios realizados durante el desarrollo.

Se utilizaron las siguientes ramas:

- main: rama principal del proyecto.
- desarrollo: rama utilizada para implementar cambios antes de integrarlos a main.

Algunos comandos utilizados durante el desarrollo fueron:

git init
git branch -M main
git switch -c desarrollo
git add .
git commit -m "Configurar proyecto Maven y pruebas unitarias"
git push

Durante el desarrollo se realizaron commits con mensajes descriptivos para mantener un historial claro del proyecto.

## Integración Continua

El pipeline de Integración Continua fue configurado mediante GitHub Actions en el archivo:

.github/workflows/ci.yml

El pipeline se ejecuta automáticamente cuando se realiza:

- Un push a main.
- Un push a desarrollo.
- Un pull request hacia main.

Durante cada ejecución se realizan los siguientes pasos:

1. Descarga del código del repositorio.
2. Configuración del entorno Java.
3. Uso de caché para las dependencias Maven.
4. Ejecución de mvn clean test.
5. Publicación de los reportes de pruebas.

## Reportes de pruebas

Maven Surefire genera los resultados de las pruebas dentro de:

target/surefire-reports/

GitHub Actions guarda estos resultados como un artefacto llamado:

reporte-pruebas

Este artefacto queda disponible desde la ejecución del pipeline para consultar posteriormente los resultados generados por las pruebas.

## Resultado

Las pruebas fueron ejecutadas correctamente tanto de forma local como mediante GitHub Actions.

Resultados obtenidos:

- 2 pruebas ejecutadas.
- 0 fallos.
- 0 errores.
- 0 pruebas omitidas.
- Pipeline finalizado correctamente.
- Reporte de pruebas disponible como artefacto.

## BDD con Cucumber

Para llevar las pruebas a un enfoque BDD se utilizó Cucumber junto con Java.

Se definió una funcionalidad de inicio de sesión mediante Gherkin en:

src/test/resources/features/login.feature

Los escenarios implementados incluyen:

- Inicio de sesión exitoso.
- Inicio de sesión rechazado con credenciales inválidas mediante Scenario Outline y Examples.

Los step definitions se implementaron en:

src/test/java/cl/iplacex/automatizacion/steps/LoginSteps.java

La ejecución se realiza mediante:

src/test/java/cl/iplacex/automatizacion/RunCucumberTest.java

## Sesión Three Amigos

Se documentó una simulación de sesión Three Amigos en:

docs/three-amigos.md

En esta sesión se definieron:

- Roles de negocio, QA y desarrollo.
- Criterios de aceptación.
- Ejemplos válidos e inválidos.
- Decisiones para la automatización BDD.

## Ejecución BDD

Los escenarios BDD se ejecutan mediante Maven junto con las pruebas unitarias:

mvn test

El resultado obtenido fue:

- 3 escenarios BDD ejecutados correctamente.
- 2 pruebas unitarias ejecutadas correctamente.
- 5 pruebas totales.
- 0 fallos.
- 0 errores.
- BUILD SUCCESS.

## Reporte BDD

Cucumber genera un reporte HTML en:

target/cucumber-report.html

El pipeline de GitHub Actions publica este archivo como un artefacto denominado:

reporte-bdd

De esta forma, el equipo puede acceder al reporte generado durante la ejecución de CI.

## Prueba de performance

Se implementó una prueba básica de performance utilizando k6.

El script se encuentra en:

performance/login-performance.js

La prueba simula 5 usuarios virtuales durante 10 segundos realizando solicitudes al endpoint de login.

Los principales indicadores monitoreados son:

- Solicitudes por segundo (TPS).
- Latencia promedio.
- Latencia p95.
- Tasa de errores.
- Cantidad de usuarios virtuales.
- Total de solicitudes.

Los resultados obtenidos fueron:

- 50 solicitudes procesadas.
- Aproximadamente 4,94 solicitudes por segundo.
- Latencia promedio: 7,75 ms.
- Latencia p95: 64,22 ms.
- Tasa de errores: 0,00 %.
- 100 % de checks exitosos.

Los thresholds definidos fueron:

- Latencia p95 menor a 1000 ms.
- Tasa de errores menor al 5 %.

Ambos criterios fueron cumplidos correctamente.

## Dashboard de métricas

Se diseñó una simulación de dashboard para centralizar métricas funcionales, BDD y de performance.

La documentación se encuentra en:

docs/dashboard-metricas.md

El dashboard permitiría visualizar:

- Estado de las pruebas.
- Cantidad de escenarios exitosos y fallidos.
- Latencia.
- TPS.
- Tasa de errores.
- Estado general del pipeline.

## Alertas automáticas

Se documentó la estrategia de alertas en:

docs/alertas.md

Las alertas se activarían ante situaciones como:

- Pruebas unitarias fallidas.
- Escenarios BDD fallidos.
- Pipeline fallido.
- Latencia p95 superior a 1000 ms.
- Tasa de errores superior al 5 %.

Estas notificaciones podrían enviarse mediante correo electrónico, Teams, Slack u otro canal utilizado por el equipo.