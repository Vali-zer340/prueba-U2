# Sesión Three Amigos - Funcionalidad de Login

## Objetivo

Definir de forma colaborativa el comportamiento esperado de una funcionalidad simple de inicio de sesión antes de implementar los escenarios BDD.

## Roles participantes

### Product Owner / Negocio
Define el comportamiento esperado desde el punto de vista del usuario y los criterios de aceptación de la funcionalidad.

### QA
Identifica escenarios de prueba, casos válidos e inválidos y posibles situaciones límite.

### Desarrollador
Evalúa cómo implementar el comportamiento definido y verifica que los criterios puedan automatizarse mediante pruebas.

## Funcionalidad analizada

Inicio de sesión de usuario mediante nombre de usuario y contraseña.

## Criterios de aceptación

1. Un usuario con credenciales válidas debe poder iniciar sesión correctamente.
2. Si el nombre de usuario o la contraseña son incorrectos, el acceso debe ser rechazado.
3. El sistema debe informar claramente cuando las credenciales no sean válidas.
4. Cada intento de inicio de sesión debe poder validarse de forma independiente.

## Ejemplos discutidos

### Ejemplo 1 - Credenciales correctas

Usuario: admin  
Contraseña: 1234

Resultado esperado: inicio de sesión exitoso.

### Ejemplo 2 - Contraseña incorrecta

Usuario: admin  
Contraseña: incorrecta

Resultado esperado: acceso rechazado.

### Ejemplo 3 - Usuario incorrecto

Usuario: usuario  
Contraseña: 1234

Resultado esperado: acceso rechazado.

## Decisiones tomadas

- Se utilizará una funcionalidad de login simple para demostrar el uso de BDD.
- Los escenarios serán escritos en Gherkin.
- Se implementará un escenario de inicio de sesión exitoso.
- Se utilizará un Scenario Outline para probar diferentes combinaciones de credenciales inválidas.
- Los escenarios serán automatizados utilizando Java y Cucumber.