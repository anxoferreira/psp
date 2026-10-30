package udp.src;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.nio.charset.StandardCharsets;

public class Server1 {

    public static void main(String[] args) {

        int puertoEscucha = 12345;
        byte[] buffers = new byte[1024];

        // Abrimos el socket con try-with-resources para que se cierre solo al terminar
        try (DatagramSocket socket = new DatagramSocket(puertoEscucha)) {

            System.out.println("Servidor iniciado. Esperando datagramas en el puerto: " + puertoEscucha + "...");
            System.out.println("(El servidor se cerrará si el cliente envía 'salir')\n");

            while (true) {
                try {
                    // Creamos el paquete para recibir los datos
                    DatagramPacket recibo = new DatagramPacket(buffers, buffers.length);

                    // Recibimos el paquete (bloqueante hasta que llega algo)
                    socket.receive(recibo);

                    // Obtenemos los datos y el texto
                    int bytesRec = recibo.getLength();
                    String paquete = new String(recibo.getData(), 0, bytesRec, StandardCharsets.UTF_8);

                    System.out.println("Mensaje recibido: " + paquete);
                    System.out
                            .println("IP de origen: " + recibo.getAddress().getHostAddress() + ":" + recibo.getPort());
                    System.out.println("--------------------------------------------------");

                    // Condición para cerrar el servidor de forma automática
                    if (paquete.equalsIgnoreCase("salir")) {
                        System.out.println("Comando de salida recibido. Cerrando servidor...");
                        break;
                    }

                } catch (IOException e) {
                    System.err.println("Error al recibir el paquete UDP: " + e.getMessage());
                }
            }

        } catch (IOException e) {
            System.err.println("No se pudo abrir el socket en el puerto " + puertoEscucha + ": " + e.getMessage());
            e.printStackTrace();
        }

        System.out.println("Servidor cerrado correctamente.");
    }

}