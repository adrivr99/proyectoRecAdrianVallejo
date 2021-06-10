package main.java.proyecto1;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
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
                                String opcionModificarClientes = leerNif();
                                // Bucle for para Modificar el cliente
                                for (int i = 0; i < listaCliente.size(); i++) {
                                    if (listaCliente.get(i).getNIF().equalsIgnoreCase(opcionModificarClientes)) {
                                        System.out.println(listaCliente.get(i).getNombre() + " " + listaCliente.get(i).getApellidos());
                                        listaCliente.remove(i);
                                        Cliente cliente = new Cliente();
                                        listaCliente.add(cliente.updateCliente(cliente));
                                    }
                                }
                                break;
                            case 3:
                                System.out.println("---------Añadir Cliente---------");
                                Cliente cliente = new Cliente();
                                listaCliente.add(cliente.addCliente(cliente));
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
                                String nifEliminar = leerNif();
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
                                listaProductos.forEach(System.out::println);
                                System.out.println("Elige un producto por su id para modificarlo");
                                int IDModificar = teclado.nextInt();
                                for (int i = 0; i < listaProductos.size(); i++) {
                                    if (listaProductos.get(i).getProducto() == IDModificar) {
                                        System.out.println("Producto: " + listaProductos.get(i).getNombre());
                                        int idProducto = listaProductos.get(i).getProducto();
                                        if (listaProductos.get(i) instanceof Articulo) {
                                            listaProductos.remove(listaProductos.get(i));
                                            Articulo articulo = new Articulo();
                                            articulo.addArticulo(articulo);
                                            articulo.setProducto(idProducto);
                                            // Añadimos el articulo en la misma posición en la que estabas
                                            listaProductos.add(i, articulo);
                                        } else if (listaProductos.get(i) instanceof Servicio) {
                                            listaProductos.remove(listaProductos.get(i));
                                            Servicio servicio = new Servicio();
                                            servicio.addServicio(servicio);
                                            servicio.setProducto(idProducto);
                                            // Añadimos el servicio
                                            // en la misma posición en la que estabas
                                            listaProductos.add(i, servicio);
                                        }
                                    }
                                }

                                break;
                            case 3:
                                System.out.println("--------Añadir Producto---------");
                                System.out.println("Que tipo de producto quieres crear? Articulo o Servicio?");
                                teclado.nextLine();
                                String crearProducto = teclado.nextLine();
                                if (crearProducto.equalsIgnoreCase("articulo")) {
                                    System.out.println("--------Añadir Articulo---------");
                                    int idProducto = listaProductos.get(listaProductos.size() - 1).getProducto();
                                    ++idProducto;
                                    Articulo articulo = new Articulo();
                                    articulo.addArticulo(articulo);
                                    articulo.setProducto(idProducto);
                                    listaProductos.add(articulo);
                                    if (listaProductos.contains(articulo)) {
                                        System.out.println("Artículo añadido correctamente");
                                    } else {
                                        System.out.println("No se ha podido añadir el Artículo");
                                    }
                                } else if (crearProducto.equalsIgnoreCase("servicio")) {
                                    System.out.println("--------Añadir Servicio---------");
                                    int idProducto = listaProductos.get(listaProductos.size() - 1).getProducto();
                                    ++idProducto;
                                    Servicio servicio = new Servicio();
                                    servicio.addServicio(servicio);
                                    servicio.setProducto(idProducto);
                                    listaProductos.add(servicio);
                                    if (listaProductos.contains(servicio)) {
                                        System.out.println("Servicio añadido correctamente");
                                    } else {
                                        System.out.println("No se ha podido añadir el Servicio");
                                    }
                                } else {
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
                    boolean salirPedidos = false;
                    int opcionPedidos = 0;
                    do {
                        System.out.println("-------------PEDIDOS------------");
                        System.out.println("1. Consultar Pedidos");
                        System.out.println("2. Modificar Pedidos");
                        System.out.println("3. Añadir Pedidos");
                        System.out.println("4. Borrar Pedidos");
                        System.out.println("5. Salir");
                        System.out.println("--------------------------------");
                        boolean exitPedidos = false;
                        do {
                            String texto = teclado.next();
                            try {
                                opcionPedidos = Integer.parseInt(texto);
                            } catch (NumberFormatException e) {
                                System.out.println("Tiene que ser un número");
                            }
                            if (opcionPedidos == 0) {
                                System.out.println("No existe esa opción");
                            }
                            if (opcionPedidos >= 1 && opcionPedidos <= 5) {
                                exitPedidos = true;
                            }
                        } while (!exitPedidos);
                        switch (opcionPedidos) {
                            case 1:
                                System.out.println("-------Listado de Pedidos------");
                                if (listaPedidos.isEmpty()) {
                                    System.out.println("No hay pedidos");
                                } else {
                                    listaPedidos.forEach(System.out::println);
                                }
                                break;
                            case 2:
                                System.out.println("-------Modificar Pedidos------");
                                break;
                            case 3:
                                System.out.println("-------Añadir Pedido-------");
                                Pedido pedido = new Pedido();
                                pedido.setEmpresa(rocketMouse);
                                pedido.setFechaPedido(LocalDate.now());
                                pedido.asignarNumeroPedido(pedido);
                                System.out.println("Elige un cliente por su NIF/DNI");
                                for (int i = 0; i < listaCliente.size(); i++) {
                                    System.out.println(listaCliente.get(i).getNombre() + " " + listaCliente.get(i).getApellidos() + " " + listaCliente.get(i).getNIF());
                                }
                                teclado.nextLine();
                                String nifPedido = teclado.nextLine();
                                boolean comprobarCliente = listaCliente.contains(nifPedido);
                                // Método para comprobar si existe el cliente, en ese caso lo añade a pedido
                                for (int i = 0; i < listaCliente.size(); i++) {
                                    if (listaCliente.get(i).getNIF().equalsIgnoreCase(nifPedido)){
                                        pedido.setDireccionCliente(listaCliente.get(i).getDireccion());
                                        pedido.setCliente(listaCliente.get(i).getNombre() + " " + listaCliente.get(i).getApellidos());
                                    }
                                }
                                boolean exitPago = false;
                                do{
                                    System.out.println("Método de pago, transferencia o tarjeta?");
                                    String metodoPago = teclado.nextLine();
                                    if (metodoPago.equalsIgnoreCase("transferencia") || metodoPago.equalsIgnoreCase("tarjeta")){
                                        pedido.setFormaPago(metodoPago);
                                        exitPago = true;
                                    }else {
                                        System.out.println("Método Incorrecto");
                                        exitPago = false;
                                    }
                                }while (!exitPago);
                                boolean exitEnvio = false;
                                do{
                                    System.out.println("Método de envio:\n1.Recoger en tienda\n2.Envio a domicilio");
                                    int envio = teclado.nextInt();
                                    if (envio == 1){
                                        pedido.setEnvio(false);
                                        exitEnvio = true;
                                    }else if (envio == 2){
                                        pedido.setEnvio(true);
                                        exitEnvio = true;
                                    }else{
                                        System.out.println("Método de envio no valido, seleciona 1 o 2");
                                    }
                                }while(!exitEnvio);
                                listaPedidos.add(pedido);
                                System.out.println(pedido.toString());
                                break;
                            case 4:
                                System.out.println("-------Borrar Pedido-------");
                                break;
                            case 5:
                                salirPedidos = true;
                                break;
                        }
                    } while (!salirPedidos);
                    exitMenu = false;
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
                                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd_hhmm");
                                String directorio = fechaHoraActual.format(formatter);


                                crearDirectorio("./backup/" + directorio);
                                // Escribe en un fichero JSON de Pedidos
                                mapeador.writeValue(new File("./backup/" + directorio + "/Pedidos.json"),
                                        generarPedido(listaPedidos));
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

    public static ArrayList<Pedido> generarPedido(ArrayList<Pedido> listaPedido) {
        ArrayList<Pedido> lista = new ArrayList<>();
        lista.addAll(listaPedido);
        return lista;
    }

    public static ArrayList<Producto> generarProducto(ArrayList<Producto> listaProducto) {
        ArrayList<Producto> lista = new ArrayList<>();
        lista.addAll(listaProducto);
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
