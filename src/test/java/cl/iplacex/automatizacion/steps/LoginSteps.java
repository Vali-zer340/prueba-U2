package cl.iplacex.automatizacion.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LoginSteps {

    private String usuarioValido;
    private String contrasenaValida;
    private boolean accesoPermitido;

    @Given("existe un usuario con nombre {string} y contraseña {string}")
    public void existeUnUsuarioConNombreYContrasena(String usuario, String contrasena) {
        usuarioValido = usuario;
        contrasenaValida = contrasena;
    }

    @When("el usuario intenta iniciar sesión con nombre {string} y contraseña {string}")
    public void elUsuarioIntentaIniciarSesion(String usuario, String contrasena) {
        accesoPermitido =
                usuarioValido.equals(usuario) &&
                contrasenaValida.equals(contrasena);
    }

    @Then("el acceso debe ser permitido")
    public void elAccesoDebeSerPermitido() {
        assertTrue(accesoPermitido);
    }

    @Then("el acceso debe ser rechazado")
    public void elAccesoDebeSerRechazado() {
        assertFalse(accesoPermitido);
    }
}