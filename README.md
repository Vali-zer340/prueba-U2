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