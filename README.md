# Prueba U2 - Automatización de Pruebas

## Objetivo

El objetivo de este proyecto es implementar un flujo básico de automatización de pruebas para un proyecto Java, utilizando Maven para la gestión de dependencias y ejecución de pruebas, JUnit para las pruebas unitarias, Git para el control de versiones y GitHub Actions para la integración continua.

## Tecnologías utilizadas

- Java
- Maven
- JUnit 5
- Git
- GitHub
- GitHub Actions

## Estructura del proyecto

```text
prueba-U2/
├── .github/
│   └── workflows/
│       └── ci.yml
├── .mvn/
├── src/
│   ├── main/
│   │   └── java/
│   │       └── cl/iplacex/automatizacion/
│   │           └── Calculadora.java
│   └── test/
│       └── java/
│           └── cl/iplacex/automatizacion/
│               └── CalculadoraTest.java
├── .gitignore
├── pom.xml
└── README.md