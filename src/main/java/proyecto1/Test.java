package main.java.proyecto1;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.util.DurationUnitConverter;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) throws IOException {
        Scanner teclado = new Scanner(System.in);
        Empresa rocketMouse = new Empresa();

        ArrayList<Cliente> listaCliente = ServicioLectura.CSVClientes("Clientes.csv");
        ArrayList<Articulo> listaArticulos = ServicioLectura.CSVArticulos("Articulos.csv");
        ArrayList<Servicio> listaServicios = ServicioLectura.CSVServicios(("Servicios.csv"));
        ArrayList<Producto> listaProductos = new ArrayList<>();
        for (Producto producto : listaArticulos) {
            listaProductos.add(producto);
        }
        for (Producto producto : listaServicios) {
            listaProductos.add(producto);
        }
        ArrayList<Pedido> listaPedidos = new ArrayList<>();

        boolean salir = false;
        int opcionMenu = 0;
        do {
            System.out.println("--------------MENÚ--------------");
            System.out.println("1. Clientes");
            System.out.println("2. Productos");
            System.out.println("3. Pedidos");
            System.out.println("4. Copias de Seguridad");
            System.out.println("5. Salir");
            boolean exitMenu = false;
            do {
                String texto = teclado.next();
                try {
                    opcionMenu = Integer.parseInt(texto);
                } catch (NumberFormatException e) {
                    System.out.println("Tiene que ser un número");
                }
                if (opcionMenu == 0) {
                    System.out.println("No existe esa opción");
                }
                if (opcionMenu >= 1 && opcionMenu <= 5) {
                    exitMenu = true;
                }
            } while (!exitMenu);

            exitMenu = false;
            switch (opcionMenu) {
                case 1://CLIENTES
                    boolean salirClientes = false;
                    int opcionClientes = 0;
                    do {
                        System.out.println("------------CLIENTES------------");
                        System.out.println("1. Consultar Clientes");
                        System.out.println("2. Modificar Clientes");
                        System.out.println("3. Añadir Clientes");
                        System.out.println("4. Borrar Clientes");
                        System.out.println("5. Salir");
                        System.out.println("--------------------------------");
                        boolean exitClientes = false;
                        do {
                            String texto = teclado.next();
                            try {
                                opcionClientes = Integer.parseInt(texto);
                            } catch (NumberFormatException e) {
                                System.out.println("Tiene que ser un número");
                            }
                            if (opcionClientes >= 1 && opcionClientes <= 5) {
                                exitClientes = true;
                            }
                        } while (!exitClientes);
                        switch (opcionClientes) {
                            case 1:
                                System.out.println("-------Listado de Clientes------");
                                listaCliente.forEach(System.out::println);
                                break;
                            case 2:
                                System.out.println("-------Modificar Cliente--------");
                                listaCliente.forEach(System.out::println);
                                System.out.println("Elige un cliente por su id para modificarlo");
                                boolean exitModificarClientes = false;
                                String opcionModificarClientes = leerNif();
                                // Bucle for para Modificar el cliente
                                for (int i = 0; i < listaCliente.size(); i++) {
                                    if (listaCliente.get(i).getNIF().equalsIgnoreCase(opcionModificarClientes)) {
                                        System.out.println(listaCliente.get(i).getNombre() + " " + listaCliente.get(i).getApellidos());
                                        String nif = leerNif();
                                        listaCliente.get(i).setNIF(nif);
                                        teclado.nextLine();
                                        System.out.println("Introduce el nombre:");
                                        String nombre = teclado.nextLine();
                                        listaCliente.get(i).setNombre(nombre);
                                        System.out.println("Introduce los apellidos");
                                        String apellidos = teclado.nextLine();
                                        listaCliente.get(i).setApellidos(apellidos);
                                        System.out.println("Introduce la direccion (Calle, Número, Ciudad, País");
                                        String direccion = teclado.nextLine();
                                        listaCliente.get(i).setDireccion(direccion);
                                    }
                                }
                                break;
                            case 3:
                                System.out.println("---------Añadir Cliente---------");
                                String nif = leerNif();
                                teclado.nextLine();
                                System.out.println("Introduce el nombre:");
                                String nombre = teclado.nextLine();
                                System.out.println("Introduce los apellidos");
                                String apellidos = teclado.nextLine();
                                System.out.println("Introduce la direccion (Calle, Número, Ciudad, País");
                                String direccion = teclado.nextLine();
                                Cliente cliente = new Cliente(nif, nombre, apellidos, direccion);
                                listaCliente.add(cliente);
                                if (listaCliente.contains(cliente)) {
                                    System.out.println("Cliente añadido correctamente");
                                } else {
                                    System.out.println("No se ha podido añadir el cliente");
                                }
                                break;
                            case 4:
                                System.out.println("---------Borrar Cliente---------");
                                listaCliente.forEach(System.out::println);
                                System.out.println("Elige el NIF del cliente de la lista a eliminar:");
                                teclado.nextLine();
                                String nifEliminar = teclado.nextLine();
                                for (int i = 0; i < listaCliente.size(); i++) {
                                    if (listaCliente.get(i).getNIF().equalsIgnoreCase(nifEliminar)) {
                                        listaCliente.remove(i);
                                    }
                                }
                                break;
                            case 5:
                                salirClientes = true;
                                break;
                        }
                    } while (!salirClientes);
                    break;
                case 2://PRODUCTOS
                    boolean salirProductos = false;
                    int opcionProductos = 0;
                    do {
                        System.out.println("------------PRODUCTOS-----------");
                        System.out.println("1. Consultar Productos");
                        System.out.println("2. Modificar Productos");
                        System.out.println("3. Añadir Productos");
                        System.out.println("4. Borrar Productos");
                        System.out.println("5. Salir");
                        System.out.println("--------------------------------");
                        boolean exitProductos = false;
                        do {
                            String texto = teclado.next();
                            try {
                                opcionProductos = Integer.parseInt(texto);
                            } catch (NumberFormatException e) {
                                System.out.println("Tiene que ser un número");
                            }
                            if (opcionProductos >= 1 && opcionProductos <= 5) {
                                exitProductos = true;
                            }
                        } while (!exitProductos);
                        switch (opcionProductos) {
                            case 1:
                                System.out.println("------Listado de Productos------");
                                listaProductos.forEach(System.out::println);
                                break;
                            case 2:
                                System.out.println("-------Modificar Producto-------");
                                listaArticulos.forEach(System.out::println);
                                listaServicios.forEach(System.out::println);
                                System.out.println("Elige un producto por su id para modificarlo");
                                String opcionModificarProductos = teclado.next();
                                // Bucle for para mostrar el productos
                                for (Producto listaProducto : listaProductos) {
                                    if (listaProducto instanceof Servicio) {

                                    }
                                    if (listaProducto instanceof Articulo) {

                                    }
                                }

                                break;
                            case 3:
                                System.out.println("--------Añadir Producto---------");
                                System.out.println("Que tipo de producto quieres crear? Articulo o Servicio?");
                                teclado.nextLine();
                                String crearProducto = teclado.nextLine();
                                if (crearProducto.equalsIgnoreCase("articulo")){
                                    System.out.println("--------Añadir Articulo---------");
                                    int idProducto = listaProductos.get(listaProductos.size()-1).getProducto();
                                    ++idProducto;
                                    System.out.println("Introduce el nombre del producto: ");
                                    String nombre = teclado.nextLine();
                                    System.out.println("Introduce el precio:");
                                    String precioString = teclado.nextLine();
                                    double precio = Double.parseDouble(precioString);
                                    System.out.println("Introduce el peso:");
                                    String pesoString = teclado.nextLine();
                                    double peso = Double.parseDouble(pesoString);
                                    System.out.println("Introduce la fecha de fabricacion (yy-MM-dd)");
                                    String fecha = teclado.nextLine();
                                    LocalDate fechaFabricacion = LocalDate.parse(fecha);

                                    Articulo articulo = new Articulo(peso, fechaFabricacion, idProducto, nombre, precio);
                                    listaProductos.add(articulo);

                                } else if (crearProducto.equalsIgnoreCase("servicio")){
                                    System.out.println("--------Añadir Servicio---------");
                                    int idProducto = listaProductos.get(listaProductos.size()-1).getProducto();
                                    ++idProducto;
                                    System.out.println("Introduce el nombre del producto: ");
                                    String nombre = teclado.nextLine();
                                    System.out.println("Introduce el precio:");
                                    String precioString = teclado.nextLine();
                                    double precio = Double.parseDouble(precioString);
                                    System.out.println("Introduce la duración estimada:");
                                    String duracionString = teclado.nextLine();
                                    double duracion = Double.parseDouble(duracionString);
                                    System.out.println("Introduce la fecha de Inicio (yy-MM-dd)");
                                    String fechaIni = teclado.nextLine();
                                    LocalDate fechaInicio = LocalDate.parse(fechaIni);
                                    System.out.println("Introduce la fecha de Inicio (yy-MM-dd)");
                                    String fechaFin = teclado.nextLine();
                                    LocalDate fechaFinalizacion = LocalDate.parse(fechaFin);

                                    Servicio servicio = new Servicio(duracion, fechaInicio, fechaFinalizacion, idProducto, nombre, precio);
                                    listaProductos.add(servicio);

                                }else{
                                    System.out.println("Error 404");
                                }
                                break;
                            case 4:
                                System.out.println("---------Borrar Producto--------");
                                listaProductos.forEach(System.out::println);
                                System.out.println("Elige el ID del producto de la lista a eliminar:");
                                teclado.nextLine();
                                int IDEliminar = teclado.nextInt();
                                for (int i = 0; i < listaProductos.size(); i++) {
                                    if (listaProductos.get(i).getProducto() == IDEliminar) {
                                        listaProductos.remove(i);
                                    }
                                }
                                break;
                            case 5:
                                salirProductos = true;
                                break;
                        }
                    } while (!salirProductos);
                    break;
                case 3:
                    boolean salirPedidos;
                    System.out.println("-------------PEDIDOS------------");
                    System.out.println("1. Consultar Pedidos");
                    System.out.println("2. Modificar Pedidos");
                    System.out.println("3. Añadir Pedidos");
                    System.out.println("4. Borrar Pedidos");
                    System.out.println("5. Salir");
                    System.out.println("--------------------------------");
                    break;
                case 4:
                    boolean salirCopias = false;
                    int opcionCopias = 0;
                    do {
                        System.out.println("------COPIAS DE SEGURIDAD------");
                        System.out.println("1. Generar Copia de Seguridad");
                        System.out.println("2. Restaurar Copia de Seguridad");
                        System.out.println("3. Salir");
                        System.out.println("--------------------------------");
                        boolean exitCopias = false;
                        do {
                            String texto = teclado.next();
                            try {
                                opcionCopias = Integer.parseInt(texto);
                            } catch (NumberFormatException e) {
                                System.out.println("Tiene que ser un número");
                            }
                            if (opcionCopias >= 1 && opcionCopias <= 3) {
                                exitCopias = true;
                            }
                        } while (!exitCopias);
                        switch (opcionCopias) {
                            case 1:
                                ObjectMapper mapeador = new ObjectMapper();

                                mapeador.configure(SerializationFeature.INDENT_OUTPUT, true);

                                LocalDateTime fechaHoraActual = LocalDateTime.now();
                                DateTimeFormatter formatter = DateTimeFormatter.ISO_DATE_TIME;
                                String str = fechaHoraActual.format(formatter);


                                //crearDirectorio("./backup/" + str);
                                // Escribe en un fichero JSON de Clientes
                                mapeador.writeValue(new File("./backup/Clientes.json"), generarCliente(listaCliente));

                                // Escribe en un fichero JSON el catálogo de envíos
                                mapeador.writeValue(new File("./backup/Articulos.json"), generarArticulo(listaArticulos));
                                break;
                            case 2:
                                System.out.println("-------Restaurar Copia de Seguridad-------");
                                listarDirectorio("./backup");
                                break;
                            case 3:
                                salirCopias = true;
                                break;

                        }
                    } while (!salirCopias);
                    break;
                case 5:
                    salir = true;

            }
        } while (!salir);
    }

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

    public static ArrayList<Cliente> generarCliente(ArrayList<Cliente> listaCliente) {
        ArrayList<Cliente> lista = new ArrayList<>();
        lista.addAll(listaCliente);
        return lista;
    }

    public static ArrayList<Articulo> generarArticulo(ArrayList<Articulo> listaArticulo) {
        ArrayList<Articulo> lista = new ArrayList<>();
        lista.addAll(listaArticulo);
        return lista;
    }

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

    private static String leerNif() {
        Scanner teclado = new Scanner(System.in);
        String nif = null;
        boolean entrada;
        do {
            System.out.println("Introduce el NIF");
            String texto = teclado.next();
            if (texto.length() == 9) {
                nif = texto;
                entrada = true;
            } else {
                System.out.println("Debes introducir 8 letras y un caracter");
                entrada = false;
            }

        } while (!entrada);
        return nif;
    }
}
