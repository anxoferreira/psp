package udp.src;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.nio.charset.StandardCharsets;

public class Cliente0 {

    public static void main(String[] args) {

        int port = 12345;

        // Usamos try-with-resources para que el socket se cierre automáticamente
        try (DatagramSocket socket = new DatagramSocket()) {

            InetAddress destino = InetAddress.getLocalHost();
            String saludo = "Enviando saludos desde el cliente!";

            byte[] mensaje = saludo.getBytes(StandardCharsets.UTF_8);

            DatagramPacket envio = new DatagramPacket(mensaje, mensaje.length, destino, port);

            // ¡IMPORTANTE! Faltaba enviar el paquete a través del socket
            socket.send(envio);

            System.out.println("Mensaje enviado correctamente a " + destino.getHostAddress() + ":" + port);

        } catch (Exception e) {
            System.err.println("Error al enviar el paquete UDP: " + e.getMessage());
            e.printStackTrace();
        }

    }

}