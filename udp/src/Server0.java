package udp.src;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.nio.charset.StandardCharsets;

public class Server0 {

    public static void main(String[] args) {

        int puertoEscucha = 12345;
        byte[] buffers = new byte[1024];

        try (DatagramSocket socket = new DatagramSocket(puertoEscucha)) {

            System.out.println("Esperando datagrama en el puerto: " + puertoEscucha + "...");

            // 1. Creamos el paquete para recibir los datos
            DatagramPacket recibo = new DatagramPacket(buffers, buffers.length);

            // 2. RECIBIMOS EL PAQUETE
            socket.receive(recibo);

            // 3. Obtenemos los datos y el texto una vez recibido
            int bytesRec = recibo.getLength();
            String paquete = new String(recibo.getData(), 0, bytesRec, StandardCharsets.UTF_8);

            // 4. Mostramos toda la información correctamente
            System.out.println("Mensaje recibido: " + paquete);
            System.out.println("Puerto origen del mensaje: " + recibo.getPort());
            System.out.println("IP del origen: " + recibo.getAddress().getHostAddress());

        } catch (IOException e) {

            System.err.println("Error al recibir el paquete UDP: " + e.getMessage());
            e.printStackTrace();

        }

    }

}