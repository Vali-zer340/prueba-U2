package cl.iplacex.automatizacion;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.nio.charset.StandardCharsets;

public class LoginServer {

    public static void main(String[] args) throws IOException {

        HttpServer servidor = HttpServer.create(new InetSocketAddress(8080), 0);

        servidor.createContext("/login", LoginServer::procesarLogin);

        servidor.start();

        System.out.println("Servidor iniciado en http://localhost:8080/login");
    }

    private static void procesarLogin(HttpExchange exchange) throws IOException {

        if (!exchange.getRequestMethod().equalsIgnoreCase("POST")) {
            responder(exchange, 405, "Metodo no permitido");
            return;
        }

        String cuerpo = new String(
                exchange.getRequestBody().readAllBytes(),
                StandardCharsets.UTF_8
        );

        boolean credencialesValidas =
                cuerpo.contains("\"usuario\":\"admin\"") &&
                cuerpo.contains("\"contrasena\":\"1234\"");

        if (credencialesValidas) {
            responder(exchange, 200, "Login exitoso");
        } else {
            responder(exchange, 401, "Credenciales invalidas");
        }
    }

    private static void responder(
            HttpExchange exchange,
            int codigo,
            String mensaje
    ) throws IOException {

        byte[] respuesta = mensaje.getBytes(StandardCharsets.UTF_8);

        exchange.sendResponseHeaders(codigo, respuesta.length);

        try (OutputStream output = exchange.getResponseBody()) {
            output.write(respuesta);
        }
    }
}