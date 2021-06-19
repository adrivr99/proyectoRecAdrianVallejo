package proyecto2;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.io.*;
import java.nio.file.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import model.Cliente;
import model.Producto;
import model.Pedido;
import model.Listaproducto;
import proyecto2.Empresa.*;

public class ServicioLectura {

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
    public static void generarJSONPedidos(List<Pedido> listaPedidos, String directorio) throws IOException {
        ObjectMapper mapeador = new ObjectMapper();
        mapeador.configure(SerializationFeature.INDENT_OUTPUT, true);
        mapeador.writeValue(new File("./backupBBDD/" + directorio + "/Pedidos.json"),
                listaPedidos);
    }
    
 // M�todo para generar un archivo JSON
    public static void generarJSONClientes(List<Cliente> listaClientes, String directorio) throws IOException {
        ObjectMapper mapeador = new ObjectMapper();
        mapeador.configure(SerializationFeature.INDENT_OUTPUT, true);
        mapeador.writeValue(new File("./backupBBDD/" + directorio + "/Clientes.json"),
                listaClientes);
    }
    
 // M�todo para generar un archivo JSON
    public static void generarJSONProductos(List<Producto> listaProductos, String directorio) throws IOException {
        ObjectMapper mapeador = new ObjectMapper();
        mapeador.configure(SerializationFeature.INDENT_OUTPUT, true);
        mapeador.writeValue(new File("./backupBBDD/" + directorio + "/Productos.json"),
                listaProductos);
    }
    
    // M�todo para generar un archivo JSON
    public static void generarJSONProductosPedidos(List<Listaproducto> listaPedidosProductos, String directorio) throws IOException {
        ObjectMapper mapeador = new ObjectMapper();
        mapeador.configure(SerializationFeature.INDENT_OUTPUT, true);
        mapeador.writeValue(new File("./backupBBDD/" + directorio + "/ListaProductosPedidos.json"),
                listaPedidosProductos);
    }

    // M�todo para leer un archivo JSON y devuelve una lista de pedidos
    public static ArrayList<Pedido> leerJSONPedidos(String copiaEleccion) throws IOException {
        ObjectMapper mapeador = new ObjectMapper();
        ArrayList<Pedido> lista = new ArrayList<>();
        lista = mapeador.readValue(new File("./backupBBDD/" + copiaEleccion + "/Pedidos.json"),
                mapeador.getTypeFactory().constructCollectionType(ArrayList.class, Pedido.class));

        return lista;
    }

    public static ArrayList<Cliente> leerJSONClientes(String copiaEleccion) throws IOException {
        ObjectMapper mapeador = new ObjectMapper();
        ArrayList<Cliente> lista = new ArrayList<>();
        lista = mapeador.readValue(new File("./backupBBDD/" + copiaEleccion + "/Clientes.json"),
                mapeador.getTypeFactory().constructCollectionType(ArrayList.class, Cliente.class));

        return lista;
    }

    public static ArrayList<Producto> leerJSONProductos(String copiaEleccion) throws IOException {
        ObjectMapper mapeador = new ObjectMapper();
        ArrayList<Producto> lista = new ArrayList<>();
        lista = mapeador.readValue(new File("./backupBBDD/" + copiaEleccion + "/Productos.json"),
                mapeador.getTypeFactory().constructCollectionType(ArrayList.class, Producto.class));

        return lista;
    }
}
