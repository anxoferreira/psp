package intro;

import java.util.*;
import java.io.*;
import java.net.*;

public class Ejemplo2urlCon {
    public static void main(String[] args) {
      
        Scanner sc = new Scanner(System.in);
      
        try {
            //escribe tu propia ruta aqui
            URL url = new URL("http://localhost/vernombre.php");
            URLConnection conexion = url.openConnection();
            conexion.setDoOutput(true);

            System.out.println("Introduce tu nombre ");
            String nombre = sc.nextLine();
            System.out.println("Introduce tus apellidos ");
            String apellidos = sc.nextLine();
            String cadena = "nombre=" + nombre + "&apellidos=" + apellidos;

            //ESCRIBIR EN LA URL
            PrintWriter output = new PrintWriter
                    (conexion.getOutputStream());
            output.write(cadena);
            output.close(); //cerrar flujo

            //LEER DE LA URL
            BufferedReader reader = new BufferedReader
                    (new InputStreamReader(conexion.getInputStream()));
            String linea;
            while ((linea = reader.readLine()) != null) {
                System.out.println(linea);
            }
            reader.close();//cerrar flujo

        } catch (MalformedURLException me) {
            System.err.println("MalformedURLException: " + me);
        } catch (IOException ioe) {
            System.err.println("IOException: " + ioe);
        }
    }
}

// k