# Dashboard de métricas de pruebas

## Objetivo

Centralizar en un único panel los resultados de las pruebas funcionales, BDD y de performance ejecutadas por el pipeline de integración continua.

## Métricas funcionales

- Total de pruebas ejecutadas.
- Pruebas exitosas.
- Pruebas fallidas.
- Errores.
- Duración total de la ejecución.
- Estado general del pipeline.

## Métricas BDD

- Escenarios ejecutados.
- Escenarios exitosos.
- Escenarios fallidos.
- Porcentaje de éxito.
- Duración de la ejecución BDD.

## Métricas de performance

- Solicitudes por segundo (TPS).
- Latencia promedio.
- Latencia p95.
- Tasa de errores.
- Cantidad de usuarios virtuales.
- Cantidad total de solicitudes.

## Ejemplo de resultados

### Pruebas funcionales

- 2 pruebas unitarias ejecutadas.
- 0 fallos.
- 0 errores.

### Pruebas BDD

- 3 escenarios ejecutados.
- 3 escenarios exitosos.
- 0 fallos.

### Performance

- 50 solicitudes procesadas.
- Aproximadamente 4,94 solicitudes por segundo.
- Latencia promedio: 7,75 ms.
- Latencia p95: 64,22 ms.
- Tasa de errores: 0,00 %.
- 5 usuarios virtuales.

## Simulación del dashboard

Las métricas anteriores podrían enviarse desde el pipeline a una herramienta de visualización como Grafana.

El dashboard podría dividirse en tres secciones:

1. Estado de pruebas funcionales y BDD.
2. Rendimiento del sistema.
3. Estado general de la última ejecución del pipeline.

Esto permitiría observar tendencias entre ejecuciones, identificar aumentos en la latencia, detectar errores y revisar rápidamente si la calidad del sistema se mantiene estable.