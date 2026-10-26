package tcp0.src;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;

public class Cliente0 {

    public static void main(String[] args) {

        try {
            String host = "localhost";
            int port = 6000;// puerto remoto

            // ABRIR SOCKET
            Socket cliente = new Socket(host, port);// conecta

            InetAddress inetAdress = cliente.getInetAddress();
            System.out.println("Puerto local: " + cliente.getLocalPort());
            System.out.println("Puerto Remoto: " + cliente.getPort());
            System.out.println("Host Remoto: " + inetAdress.getHostName().toString());
            System.out.println("IP Host Remoto: " + inetAdress.getHostAddress().toString());
            cliente.close();// Cierra el socket

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
