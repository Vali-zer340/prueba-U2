Feature: Inicio de sesión

  Como usuario del sistema
  quiero iniciar sesión con mis credenciales
  para acceder a las funcionalidades disponibles.

  Scenario: Inicio de sesión exitoso
    Given existe un usuario con nombre "admin" y contraseña "1234"
    When el usuario intenta iniciar sesión con nombre "admin" y contraseña "1234"
    Then el acceso debe ser permitido

  Scenario Outline: Inicio de sesión rechazado con credenciales inválidas
    Given existe un usuario con nombre "admin" y contraseña "1234"
    When el usuario intenta iniciar sesión con nombre "<usuario>" y contraseña "<contrasena>"
    Then el acceso debe ser rechazado

    Examples:
      | usuario | contrasena |
      | admin   | incorrecta |
      | usuario | 1234       |