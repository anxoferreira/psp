package tcp0;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

class Servidor0 {
    
    public static void main(String[] args) {
        
        try {
            int port = 6000; // puerto
            ServerSocket servidor = new ServerSocket(port);
            System.out.println("escuchando en " + servidor.getLocalPort());
            Socket cliente1 = servidor.accept(); // esperando a un cliente
            // realizar acciones con cliente1
            Socket cliente2 = servidor.accept(); // esperando a otro cliente
            // realizar acciones con cliente2
            servidor.close(); // cierro socket servidor
        } catch (IOException e) {
            e.printStackTrace();
        }
        
    }

}