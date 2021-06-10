package main.java.proyecto1;

import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class ServicioLectura {
    public static ArrayList <Cliente> CSVClientes(String idFichero){
        // Variables para guardar los datos que se van leyendo
        String[] tokens;
        String linea;
        ArrayList <Cliente> listaClientes = new ArrayList<>();

        // Inicialización del flujo "datosFichero" en función del archivo llamado "idFichero"
        // Estructura try-with-resources. Permite cerrar los recursos una vez finalizadas
        // las operaciones con el archivo
        try (Scanner datosFichero = new Scanner(new File(idFichero), "ISO-8859-1")) {
            // hasNextLine devuelve true mientras haya líneas por leer
            while (datosFichero.hasNextLine()) {
                // Guarda la línea completa en un String
                linea = datosFichero.nextLine();
                // Se guarda en el array de String cada elemento de la
                // línea en función del carácter separador de campos del fichero CSV
                tokens = linea.split(";");
                Cliente cliente = new Cliente();
                cliente.setNIF(tokens[0]);
                cliente.setNombre(tokens[1]);
                cliente.setApellidos(tokens[2]);
                cliente.setDireccion(tokens[3]);
                listaClientes.add(cliente);
            }
            return listaClientes;
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public static ArrayList <Articulo> CSVArticulos(String idFichero){
        // Variables para guardar los datos que se van leyendo
        String[] tokens;
        String linea;
        ArrayList <Articulo> listaArticulos = new ArrayList<>();

        // Inicialización del flujo "datosFichero" en función del archivo llamado "idFichero"
        // Estructura try-with-resources. Permite cerrar los recursos una vez finalizadas
        // las operaciones con el archivo
        try (Scanner datosFichero = new Scanner(new File(idFichero), "ISO-8859-1")) {
            // hasNextLine devuelve true mientras haya líneas por leer
            while (datosFichero.hasNextLine()) {
                // Guarda la línea completa en un String
                linea = datosFichero.nextLine();
                // Se guarda en el array de String cada elemento de la
                // línea en función del carácter separador de campos del fichero CSV
                tokens = linea.split(";");
                Articulo articulo = new Articulo();
                articulo.setPeso(Double.parseDouble(tokens[0]) );
                articulo.setFechaFabricacion(LocalDate.parse(tokens[1]));
                articulo.setProducto(Integer.parseInt(tokens[2]));
                articulo.setNombre(tokens[3]);
                articulo.setPrecio(Double.parseDouble(tokens[4]));
                listaArticulos.add(articulo);
            }
            return listaArticulos;
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public static ArrayList <Servicio> CSVServicios(String idFichero){
        // Variables para guardar los datos que se van leyendo
        String[] tokens;
        String linea;
        ArrayList <Servicio> listaServicios = new ArrayList<>();

        // Inicialización del flujo "datosFichero" en función del archivo llamado "idFichero"
        // Estructura try-with-resources. Permite cerrar los recursos una vez finalizadas
        // las operaciones con el archivo
        try (Scanner datosFichero = new Scanner(new File(idFichero), "ISO-8859-1")) {
            // hasNextLine devuelve true mientras haya líneas por leer
            while (datosFichero.hasNextLine()) {
                // Guarda la línea completa en un String
                linea = datosFichero.nextLine();
                // Se guarda en el array de String cada elemento de la
                // línea en función del carácter separador de campos del fichero CSV
                tokens = linea.split(";");
                Servicio servicio = new Servicio();
                servicio.setDuracionEstimada(Double.parseDouble(tokens[0]) );
                servicio.setFechaComienzo(LocalDate.parse(tokens[1]));
                servicio.setFechaFin(LocalDate.parse(tokens[2]));
                servicio.setProducto(Integer.parseInt(tokens[3]));
                servicio.setNombre(tokens[4]);
                servicio.setPrecio(Double.parseDouble(tokens[5]));
                listaServicios.add(servicio);
            }
            return listaServicios;
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
    public static void generarTxt(Pedido pedido) {
        try (BufferedWriter flujo = new BufferedWriter(new FileWriter(pedido.getNumeroPedido()+".txt", true))) {

            //flujo.write sirve para escribir en el fichero
            flujo.write(String.valueOf(pedido));
            //flujo.newLine sirve para pasar a la siguiente linea
            flujo.newLine();
            //flujo.flush sirve para liberar el buffer
            flujo.flush();

        } catch (IOException e) {
            System.out.println("No se ha podido introducir");

        }
    }
}
