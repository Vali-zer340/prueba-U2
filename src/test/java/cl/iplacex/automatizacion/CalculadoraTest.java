package cl.iplacex.automatizacion;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

class CalculadoraTest {

    @Test
    void sumarDosNumeros() {
        Calculadora calculadora = new Calculadora();

        int resultado = calculadora.sumar(5, 3);

        assertEquals(8, resultado);
    }

    @Test
    void restarDosNumeros() {
        Calculadora calculadora = new Calculadora();

        int resultado = calculadora.restar(10, 4);

        assertEquals(6, resultado);
    }
}