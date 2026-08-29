# Configuración de alertas automáticas

## Objetivo

Notificar al equipo cuando las pruebas detecten fallos funcionales, errores en escenarios BDD o degradaciones de rendimiento.

## Alertas funcionales y BDD

Se configuraría una alerta cuando:

- Exista al menos una prueba unitaria fallida.
- Exista al menos un escenario BDD fallido.
- El pipeline finalice con estado de error.

Estas alertas podrían enviarse mediante correo electrónico, Microsoft Teams, Slack o cualquier canal de comunicación utilizado por el equipo.

## Alertas de performance

Se utilizarían los thresholds configurados en k6 para detectar degradaciones.

Las principales condiciones serían:

- Latencia p95 superior a 1000 ms.
- Tasa de errores superior al 5 %.
- Fallo de alguno de los checks definidos en la prueba.
- Disminución significativa del throughput respecto de ejecuciones anteriores.

## Funcionamiento dentro del pipeline

Si alguna condición crítica no se cumple, la prueba devuelve un estado de error y el pipeline puede marcar la ejecución como fallida.

A partir de este estado, el sistema de CI puede activar una notificación automática al equipo indicando:

- Nombre del pipeline.
- Rama o commit afectado.
- Tipo de prueba que falló.
- Métrica o criterio que provocó la alerta.
- Enlace a los reportes o artefactos generados.

## Ejemplo de alerta

ALERTA DE CALIDAD

Pipeline: Integración Continua  
Estado: Fallido  
Motivo: Latencia p95 superior al límite permitido  
Valor obtenido: 1250 ms  
Límite definido: 1000 ms  

Acción recomendada: revisar el rendimiento del endpoint de login antes de integrar los cambios.