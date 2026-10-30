package udp.src;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Cliente1 {

    public static void main(String[] args) {

        int port = 12345;

        try (DatagramSocket socket = new DatagramSocket();
                Scanner autos = new Scanner(System.in)) {

            InetAddress destino = InetAddress.getLocalHost();
            String textoUsuario = "";

            System.out.println("Cliente conectado. Escribe tus mensajes (escribe 'salir' para terminar):\n");

            // Bucle para enviar tantos mensajes como quieras
            while (true) {
                System.out.print("Mensaje a enviar: ");
                textoUsuario = autos.nextLine();

                byte[] mensaje = textoUsuario.getBytes(StandardCharsets.UTF_8);
                DatagramPacket envio = new DatagramPacket(mensaje, mensaje.length, destino, port);

                socket.send(envio);
                System.out.println("-> Mensaje enviado.");

                // Si el usuario escribe salir, también rompemos el bucle del cliente
                if (textoUsuario.equalsIgnoreCase("salir")) {
                    System.out.println("Cerrando cliente...");
                    break;
                }
            }

        } catch (Exception e) {
            System.err.println("Error en el cliente UDP: " + e.getMessage());
            e.printStackTrace();
        }

    }

}