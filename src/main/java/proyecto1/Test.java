package main.java.proyecto1;

import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.File;

public class Test {
    public static void main(String[] args) {
        Empresa rocketMouse = new Empresa();

        // Fichero a leer con datos de ejemplo
        String idFichero = "Clientes.csv";

        // Variables para guardar los datos que se van leyendo
        String[] tokens;
        String linea;

        // Inicialización del flujo "datosFichero" en función del archivo llamado "idFichero"
        // Estructura try-with-resources. Permite cerrar los recursos una vez finalizadas
        // las operaciones con el archivo
        try (Scanner datosFichero = new Scanner(new File(idFichero), "UTF-8")) {
            // hasNextLine devuelve true mientras haya líneas por leer
            while (datosFichero.hasNextLine()) {
                // Guarda la línea completa en un String
                linea = datosFichero.nextLine();
                // Se guarda en el array de String cada elemento de la
                // línea en función del carácter separador de campos del fichero CSV
                tokens = linea.split(";");
                for (String string : tokens) {
                    System.out.print(string + "\t");
                }
                System.out.println("El fichero se ha cargado correctamente");
            }
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }

    }
}
