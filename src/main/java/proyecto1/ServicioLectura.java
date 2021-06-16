package proyecto1;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.io.*;
import java.nio.file.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class ServicioLectura {

    public static ArrayList<Cliente> CSVClientes(String idFichero) {
        // Variables para guardar los datos que se van leyendo
        String[] tokens;
        String linea;
        ArrayList<Cliente> listaClientes = new ArrayList<>();

        // Inicialización del flujo "datosFichero" en función del archivo llamado "idFichero"
        // Estructura try-with-resources. Permite cerrar los recursos una vez finalizadas
        // las operaciones con el archivo
        try ( Scanner datosFichero = new Scanner(new File(idFichero), "ISO-8859-1")) {
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

    public static ArrayList<Articulo> CSVArticulos(String idFichero) {
        // Variables para guardar los datos que se van leyendo
        String[] tokens;
        String linea;
        ArrayList<Articulo> listaArticulos = new ArrayList<>();

        // Inicialización del flujo "datosFichero" en función del archivo llamado "idFichero"
        // Estructura try-with-resources. Permite cerrar los recursos una vez finalizadas
        // las operaciones con el archivo
        try ( Scanner datosFichero = new Scanner(new File(idFichero), "ISO-8859-1")) {
            // hasNextLine devuelve true mientras haya líneas por leer
            while (datosFichero.hasNextLine()) {
                // Guarda la línea completa en un String
                linea = datosFichero.nextLine();
                // Se guarda en el array de String cada elemento de la
                // línea en función del carácter separador de campos del fichero CSV
                tokens = linea.split(";");
                Articulo articulo = new Articulo();
                articulo.setPeso(Double.parseDouble(tokens[0]));
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

    public static ArrayList<Servicio> CSVServicios(String idFichero) {
        // Variables para guardar los datos que se van leyendo
        String[] tokens;
        String linea;
        ArrayList<Servicio> listaServicios = new ArrayList<>();

        // Inicialización del flujo "datosFichero" en función del archivo llamado "idFichero"
        // Estructura try-with-resources. Permite cerrar los recursos una vez finalizadas
        // las operaciones con el archivo
        try ( Scanner datosFichero = new Scanner(new File(idFichero), "ISO-8859-1")) {
            // hasNextLine devuelve true mientras haya líneas por leer
            while (datosFichero.hasNextLine()) {
                // Guarda la línea completa en un String
                linea = datosFichero.nextLine();
                // Se guarda en el array de String cada elemento de la
                // línea en función del carácter separador de campos del fichero CSV
                tokens = linea.split(";");
                Servicio servicio = new Servicio();
                servicio.setDuracionEstimada(Double.parseDouble(tokens[0]));
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

    // M�todo para generar un archivo TXT de un pedido
    public static void generarTxt(Pedido pedido) {
        try ( BufferedWriter flujo = new BufferedWriter(new FileWriter(pedido.getNumeroPedido() + ".txt", true))) {

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

    // M�todo para crear un directorio pasandole la ruta como par�metro
    public static void crearDirectorio(String ruta) {

        Path directory = Paths.get(ruta);
        try {
            Files.createDirectory(directory);
        } catch (FileAlreadyExistsException faee) {
            System.out.println("No se puede crear " + ruta + " porque ya existe");
        } catch (AccessDeniedException ade) {
            System.out.println("No tiene permisos para crear " + ruta);
        } catch (IOException e) {
            System.out.println("Problema creando el directorio " + ruta);
            System.out.println("Seguramente la ruta está mal escrita o no existe");
        }

    }

    // M�todo para listar el contenido de un directorio pasandole la ruta por par�metros
    public static void listarDirectorio(String ruta) {
        File f = new File(ruta);
        if (f.exists()) {
            // Obtiene los ficheros y directorios dentro de f y los
            // devuelve en un array
            File[] ficheros = f.listFiles();
            for (File file2 : ficheros) {
                System.out.println(file2.getName());
            }
        } else {
            System.out.println("El directorio a listar no existe");
        }
    }

    // M�todo para generar un archivo JSON
    public static void generarJSON(Empresa empresa, String directorio, ArrayList<Articulo> listaArticulos, ArrayList<Servicio> listaServicios) throws IOException {
        ObjectMapper mapeador = new ObjectMapper();
        mapeador.configure(SerializationFeature.INDENT_OUTPUT, true);
        mapeador.writeValue(new File("./backup/" + directorio + "/Pedidos.json"),
                empresa.getListaPedidos());
        mapeador.writeValue(new File("./backup/" + directorio + "/Clientes.json"),
                empresa.getListaClientes());
        mapeador.writeValue(new File("./backup/" + directorio + "/Articulos.json"),
                listaArticulos);
        mapeador.writeValue(new File("./backup/" + directorio + "/Servicios.json"),
                listaServicios);
    }

    // M�todo para leer un archivo JSON y devuelve una lista de pedidos
    public static ArrayList<Pedido> leerJSONPedidos(String copiaEleccion) throws IOException {
        ObjectMapper mapeador = new ObjectMapper();
        ArrayList<Pedido> lista = new ArrayList<>();
        lista = mapeador.readValue(new File("./backup/" + copiaEleccion + "/Pedidos.json"),
                mapeador.getTypeFactory().constructCollectionType(ArrayList.class, Pedido.class));

        return lista;
    }

    public static ArrayList<Cliente> leerJSONClientes(String copiaEleccion) throws IOException {
        ObjectMapper mapeador = new ObjectMapper();
        ArrayList<Cliente> lista = new ArrayList<>();
        lista = mapeador.readValue(new File("./backup/" + copiaEleccion + "/Clientes.json"),
                mapeador.getTypeFactory().constructCollectionType(ArrayList.class, Cliente.class));

        return lista;
    }

    public static ArrayList<Articulo> leerJSONArticulos(String copiaEleccion) throws IOException {
        ObjectMapper mapeador = new ObjectMapper();
        ArrayList<Articulo> lista = new ArrayList<>();
        lista = mapeador.readValue(new File("./backup/" + copiaEleccion + "/Articulos.json"),
                mapeador.getTypeFactory().constructCollectionType(ArrayList.class, Articulo.class));

        return lista;
    }
    public static ArrayList<Servicio> leerJSONServicios(String copiaEleccion) throws IOException {
        ObjectMapper mapeador = new ObjectMapper();
        ArrayList<Servicio> lista = new ArrayList<>();
        lista = mapeador.readValue(new File("./backup/" + copiaEleccion + "/Servicios.json"),
                mapeador.getTypeFactory().constructCollectionType(ArrayList.class, Servicio.class));

        return lista;
    }
}
