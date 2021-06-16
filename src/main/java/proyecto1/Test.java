package proyecto1;

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

import static proyecto1.ServicioLectura.*;

public class Test {

    public static void main(String[] args) throws IOException {
        Scanner teclado = new Scanner(System.in);
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
        Empresa empresa = new Empresa("Rocket Mouse", "B - 76365789", "Avenida Espa�a, 10 La L�nea de la Concepci�n, Espa�a", 956202122, listaCliente, listaPedidos, listaProductos);

        boolean salir = false;
        int opcionMenu = 0;
        do {
            System.out.println("--------------MEN�--------------");
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
                    System.out.println("Tiene que ser un N�mero");
                }
                if (opcionMenu == 0) {
                    System.out.println("No existe esa opci�n");
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
                        System.out.println("3. A�adir Clientes");
                        System.out.println("4. Borrar Clientes");
                        System.out.println("5. Salir");
                        System.out.println("--------------------------------");
                        boolean exitClientes = false;
                        do {
                            String texto = teclado.next();
                            try {
                                opcionClientes = Integer.parseInt(texto);
                            } catch (NumberFormatException e) {
                                System.out.println("Tiene que ser un n�mero");
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
                                        // Borramos el cliente
                                        listaCliente.remove(i);
                                        // Creamos un nuevo cliente
                                        Cliente cliente = new Cliente();
                                        // LLenamos el nuevo cliente con el m�todo crear Cliente
                                        cliente = crearCliente();
                                        // A�adimos el cliente a la lista Clientes en la posici�n del cliente modificado.
                                        listaCliente.add(i, cliente);
                                    }
                                }
                                break;
                            case 3:
                                System.out.println("---------A�adir Cliente---------");
                                // Creamos objeto cliente
                                Cliente cliente = new Cliente();
                                // Llenamos el cliente con el método crear Cliente
                                cliente = crearCliente();
                                //Añadimos el cliente a la lista de Clientes.
                                listaCliente.add(cliente);
                                // Condicional para saber si se ha añadido el cliente a la lista
                                if (listaCliente.contains(cliente)) {
                                    System.out.println("Cliente a�adido correctamente");
                                } else {
                                    System.out.println("No se ha podido a�adir el cliente");
                                }
                                break;
                            case 4:
                                System.out.println("---------Borrar Cliente---------");
                                listaCliente.forEach(System.out::println);
                                System.out.println("Elige el NIF del cliente de la lista a eliminar:");
                                teclado.nextLine();
                                // Leemos el nif del cliente con el metodo leerNif
                                String nifEliminar = leerNif();
                                // Listamos la lista de clientes en busca del nifEliminar y eliminamos el cliente de la lista
                                for (int i = 0; i < listaCliente.size(); i++) {
                                    if (listaCliente.get(i).getNIF().equalsIgnoreCase(nifEliminar)) {
                                        listaCliente.remove(i);
                                    }
                                }
                                break;
                            case 5:
                                salirClientes = true;
                                break;
                            /*case 6:
                                listaCliente.clear();
                                break;*/
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
                        System.out.println("3. A�adir Productos");
                        System.out.println("4. Borrar Productos");
                        System.out.println("5. Salir");
                        System.out.println("--------------------------------");
                        boolean exitProductos = false;
                        do {
                            String texto = teclado.next();
                            try {
                                opcionProductos = Integer.parseInt(texto);
                            } catch (NumberFormatException e) {
                                System.out.println("Tiene que ser un n�mero");
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
                                teclado.nextLine();
                                int IDModificar = teclado.nextInt();
                                // Con un bucle for buscamos dentro de la lista de productos el id de producto que hemos elegido
                                for (int i = 0; i < listaProductos.size(); i++) {
                                    if (listaProductos.get(i).getProducto() == IDModificar) {
                                        int idProducto = listaProductos.get(i).getProducto();
                                        // instanceof para obtener los getters y setters de la clase heredada
                                        if (listaProductos.get(i) instanceof Articulo) {
                                            listaProductos.remove(i);
                                            Articulo articulo = new Articulo();
                                            // Llenamos el art�culo con el m�todo crearArticulo()
                                            articulo = crearArticulo();
                                            articulo.setProducto(idProducto);
                                            // A�adimos el articulo en la misma posicion en la que estaba
                                            listaProductos.add(i, articulo);
                                        } // instanceof para obtener los getters y setters de la clase heredada
                                        else if (listaProductos.get(i) instanceof Servicio) {
                                            listaProductos.remove(i);
                                            Servicio servicio = new Servicio();
                                            // Llenamos el servicio con el m�todo crearServicio()
                                            servicio = crearServicio();
                                            servicio.setProducto(idProducto);
                                            // A�adimos el servicio en la misma posicion en la que estaba
                                            listaProductos.add(i, servicio);
                                        }
                                    } else {
                                        System.out.println("No existe ese producto");
                                    }
                                }

                                break;
                            case 3:
                                System.out.println("--------A�adir Producto---------");
                                System.out.println("Que tipo de producto quieres crear? Articulo o Servicio?");
                                teclado.nextLine();
                                String crearProducto = teclado.nextLine();
                                // Condicional para saber tipo de producto queremos crear
                                if (crearProducto.equalsIgnoreCase("articulo")) {
                                    System.out.println("--------A�adir Articulo---------");
                                    // Guardamos el id del �ltimo producto en una variable
                                    int idProducto = listaProductos.get(listaProductos.size() - 1).getProducto();
                                    ++idProducto;
                                    Articulo articulo = new Articulo();
                                    // Llenamos articulo con el metodo crearArticulo()
                                    articulo = crearArticulo();
                                    articulo.setProducto(idProducto);
                                    // A�adimos articulo a la lista de Productos
                                    listaArticulos.add(articulo);
                                    listaProductos.add(articulo);
                                    if (listaProductos.contains(articulo)) {
                                        System.out.println("Arti�culo a�adido correctamente");
                                    } else {
                                        System.out.println("No se ha podido a�adir el Arti�culo");
                                    }
                                } else if (crearProducto.equalsIgnoreCase("servicio")) {
                                    System.out.println("--------A�adir Servicio---------");
                                    // Guardamos el id del �ltimo producto en una variable
                                    int idProducto = listaProductos.get(listaProductos.size() - 1).getProducto();
                                    ++idProducto;
                                    Servicio servicio = new Servicio();
                                    // Llenamos servicio con el m�todo crearServicio()
                                    servicio = crearServicio();
                                    servicio.setProducto(idProducto);
                                    // A�adimos servicio a la lista de Productos
                                    listaServicios.add(servicio);
                                    listaProductos.add(servicio);
                                    if (listaProductos.contains(servicio)) {
                                        System.out.println("Servicio a�adido correctamente");
                                    } else {
                                        System.out.println("No se ha podido a�adir el Servicio");
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
                                // Listamos la lista de clientes en busca del nifEliminar y eliminamos el cliente de la lista
                                for (int i = 0; i < listaProductos.size(); i++) {
                                    if (listaProductos.get(i).getProducto() == IDEliminar) {
                                        listaProductos.remove(i);
                                    }
                                }
                                break;
                            case 5:
                                salirProductos = true;
                                break;
                            /*case 6:
                                listaProductos.clear();
                                break;*/
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
                        System.out.println("3. A�adir Pedidos");
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
                                    // Lista los pedidos de la listaPedidos
                                    listaPedidos.forEach(System.out::println);
                                    System.out.println("Elige un pedido de la lista para imprimir");
                                    teclado.nextLine();
                                    String numeroPedido = teclado.nextLine();
                                    // Bucle for para buscar dentro de la listaPedidos el pedido buscado por teclado
                                    for (Pedido pedidoAux : listaPedidos) {
                                        if (pedidoAux.getNumeroPedido().equalsIgnoreCase(numeroPedido)) {
                                            // Con el método generarTxt, generamos un archivo txt con los datos del
                                            // pedido
                                            generarTxt(pedidoAux);
                                        } else {
                                            System.out.println("Pedido no existe");
                                        }
                                    }
                                }
                                break;
                            case 2:
                                System.out.println("-------Modificar Pedidos------");
                                for (int i = 0; i < listaPedidos.size(); i++) {
                                    System.out.println("Pedido: " + listaPedidos.get(i).getNumeroPedido());
                                }
                                teclado.nextLine();
                                System.out.println("Elige el pedido a modificar por su número de pedido");
                                String pedidoModificar = teclado.nextLine();
                                for (int i = 0; i < listaPedidos.size(); i++) {
                                    if (listaPedidos.get(i).getNumeroPedido().equalsIgnoreCase(pedidoModificar)) {
                                        Pedido pedido = new Pedido();
                                        pedido = crearPedido(empresa, pedido, listaCliente, listaProductos, listaArticulos, listaServicios);
                                        String numeroPedido = listaPedidos.get(i).getNumeroPedido();
                                        pedido.setNumeroPedido(numeroPedido);
                                        listaPedidos.remove(i);
                                        listaPedidos.add(i, pedido);

                                    }
                                }
                                break;
                            case 3:
                                System.out.println("-------A�adir Pedido-------");
                                Pedido pedido = new Pedido();
                                // Llamamos al método crearPedido para generar un pédido pidiendo todos los datos
                                pedido = crearPedido(empresa, pedido, listaCliente, listaProductos, listaArticulos, listaServicios);
                                listaPedidos.add(pedido);
                                break;
                            case 4:
                                System.out.println("-------Borrar Pedido-------");
                                for (int i = 0; i < listaPedidos.size(); i++) {
                                    System.out.println("Numero de Pedido: " + listaPedidos.get(i).getNumeroPedido());
                                }
                                System.out.println("Elige un pedido para eliminar: ");
                                teclado.nextLine();
                                String pedidoDelete = teclado.nextLine();
                                for (int i = 0; i < listaPedidos.size(); i++) {
                                    if (listaPedidos.get(i).getNumeroPedido().equalsIgnoreCase(pedidoDelete)) {
                                        listaPedidos.remove(i);
                                    }
                                }
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
                                System.out.println("Tiene que ser un numero");
                            }
                            if (opcionCopias >= 1 && opcionCopias <= 3) {
                                exitCopias = true;
                            }
                        } while (!exitCopias);
                        switch (opcionCopias) {
                            case 1:
                                // Escribimos el nombre del directorio que se va a generar convirtiendo un LocalDateTime
                                // en un String para pasarlo por el metodo crearDirectorio que nos creará un directorio
                                // dentro de la carpeta backup
                                empresa.setListaClientes(listaCliente);
                                empresa.setListaPedidos(listaPedidos);
                                empresa.setListaProductos(listaProductos);
                                LocalDateTime fechaHoraActual = LocalDateTime.now();
                                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd_hhmm");
                                String directorio = fechaHoraActual.format(formatter);
                                crearDirectorio("./backup/" + directorio);
                                // Con el método generarJSON, crearemos un archivo JSON que guardará la lista de pedidos
                                // pasandole la lista de pedidos y el directorio donde queremos que se guarde.
                                generarJSON(empresa, directorio, listaArticulos, listaServicios);
                                break;
                            case 2:
                                System.out.println("-------Restaurar Copia de Seguridad-------");
                                // Mostramos por pantalla el contenido de la carpeta backup
                                listarDirectorio("./backup");
                                System.out.println("Elige una copia de seguridad para restaurar");
                                teclado.nextLine();
                                String copiaEleccion = teclado.nextLine();
                                // Primero elegimos una de las copias de seguridad escribiendolo por teclado, luego
                                // limpiamos la lista de pedidos para que se guarde con la de la copia de seguridad.
                                // Por último con el método leerJSON, leera el archivo JSON que se encuentra dentro
                                // de la carpeta que hemos escogido y añadira todos los pedidos que tenga en la lista.
                                empresa.getListaClientes().clear();
                                empresa.getListaProductos().clear();
                                empresa.getListaPedidos().clear();
                                //System.out.println(empresa.toString());
                                //System.out.println("---------------------");
                                listaArticulos.clear();
                                listaServicios.clear();
                                listaProductos.clear();
                                listaPedidos.clear();
                                listaCliente = leerJSONClientes(copiaEleccion);
                                listaArticulos = leerJSONArticulos(copiaEleccion);
                                listaServicios = leerJSONServicios(copiaEleccion);
                                for (Producto producto : listaArticulos) {
                                    listaProductos.add(producto);
                                }
                                for (Producto producto : listaServicios) {
                                    listaProductos.add(producto);
                                }
                                listaPedidos = leerJSONPedidos(copiaEleccion);
                                empresa.setListaProductos(listaProductos);
                                empresa.setListaClientes(leerJSONClientes(copiaEleccion));
                                empresa.setListaPedidos(leerJSONPedidos(copiaEleccion));
                                //System.out.println(empresa.toString());
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

    private static Pedido crearPedido(Empresa empresa, Pedido pedido, ArrayList<Cliente> listaCliente, ArrayList<Producto> listaProductos, ArrayList<Articulo> listaArticulos, ArrayList<Servicio> listaServicios) {

        Scanner teclado = new Scanner(System.in);
        // Asignamos la empresa
        // Asignamos la fecha del pedido con un LocalDate.now() para que sea la fecha actual
        pedido.setFechaPedido(LocalDate.now());
        // Asignamos el número de pedido con el método asignarNumeroPedido
        pedido.asignarNumeroPedido(pedido);
        // Listamos la lista de clientes
        System.out.println("Elige un cliente por su NIF/DNI");
        for (int i = 0; i < listaCliente.size(); i++) {
            System.out.println(listaCliente.get(i).getNombre() + " " + listaCliente.get(i).getApellidos() + " " + listaCliente.get(i).getNIF());
        }
        // Leemos el nif del cliente con el método leerNif()
        String nif = leerNif();
        // Con el método asignarCliente asignamos un cliente de la lista al pedido
        pedido.setCliente(pedido.asignarCliente(listaCliente, nif));
        // Con el método asignarDireccionCliente asignamos la dirección del cliente que hemos
        // guardado con el método anterior
        pedido.setDireccionCliente(pedido.asignarDireccionCliente(listaCliente, pedido));
        System.out.println("Método de pago, transferencia o tarjeta?");
        String metodoPago = teclado.nextLine();
        // Asignamos el método de pago
        pedido.setFormaPago(pedido.asignarPago(metodoPago));
        System.out.println("Método de envio:\n1.Recoger en tienda\n2.Envio a domicilio");
        int envio = teclado.nextInt();
        // Asignamos si se va a realizar un envío con true o false;
        pedido.setEnvio(pedido.asignarEnvio(envio));
        boolean exitAddProductos = false;
        // Creamos listas de articulos y servicios que estarán en el pedido
        ArrayList<ListaArticulos> listaArticulosPedidos = new ArrayList<>();
        ArrayList<ListaServicios> listaServiciosPedidos = new ArrayList<>();
        do {
            System.out.println("Elige un producto de la lista por su id");
            // Listamos los productos
            for (int i = 0; i < listaProductos.size(); i++) {
                System.out.println(listaProductos.get(i).getProducto() + "Producto: " + listaProductos.get(i).getNombre() + ", precio: " + listaProductos.get(i).getPrecio());
            }
            int elegirProducto = teclado.nextInt();
            // Creamos dos bucles for, uno para artículos y otro para servicios.
            // Esto hace que recorre un bucle buscando que el id del producto sea igual que el productos que hemos elegido
            // En caso de que en el primer bucle no se encuentre pasa al segundo.
            for (int i = 0; i < listaArticulos.size(); i++) {
                if (listaArticulos.get(i).getProducto() == elegirProducto) {
                    //Creamos un objeto ListaArticulos y con el método addArticuloLista lo añadimos
                    ListaArticulos articuloPedido = new ListaArticulos();
                    articuloPedido.setArticulo(articuloPedido.addArticuloLista(listaArticulos, elegirProducto));
                    System.out.println("Indica la cantidad: ");
                    int cantidadArticulo = teclado.nextInt();
                    articuloPedido.setCantidad(cantidadArticulo);
                    listaArticulosPedidos.add(articuloPedido);
                }
            }
            for (int i = 0; i < listaServicios.size(); i++) {
                if (listaServicios.get(i).getProducto() == elegirProducto) {
                    //Creamos un objeto ListaServicios y con el método addServicioLista lo añadimos
                    ListaServicios servicioPedido = new ListaServicios();
                    servicioPedido.setServicio(servicioPedido.addServicioLista(listaServicios, elegirProducto));
                    System.out.println("Indica la cantidad: ");
                    int cantidad = teclado.nextInt();
                    servicioPedido.setCantidad(cantidad);
                    listaServiciosPedidos.add(servicioPedido);
                }
            }
            System.out.println("Quieres añadir otro producto? (SI/NO)");
            teclado.nextLine();
            String salirAddProducto = teclado.nextLine();
            if (salirAddProducto.equalsIgnoreCase("Si")) {
                exitAddProductos = false;
            } else if (salirAddProducto.equalsIgnoreCase("No")) {
                exitAddProductos = true;
            }

        } while (!exitAddProductos);
        // Añadimos las listas de articulos y servicios al pedido
        pedido.setListaArticulos(listaArticulosPedidos);
        pedido.setListaServicios(listaServiciosPedidos);
        return pedido;
    }

    private static Cliente crearCliente() {
        Cliente cliente = new Cliente();
        Scanner teclado = new Scanner(System.in);
        String nif = leerNif();
        cliente.setNIF(nif);
        System.out.println("Introduce el nombre:");
        String nombre = teclado.nextLine();
        cliente.setNombre(nombre);
        System.out.println("Introduce los apellidos");
        String apellidos = teclado.nextLine();
        cliente.setApellidos(apellidos);
        System.out.println("Introduce la direccion (Calle, Número, Ciudad, País");
        String direccion = teclado.nextLine();
        cliente.setDireccion(direccion);
        return cliente;
    }

    private static Articulo crearArticulo() {
        Articulo articulo = new Articulo();
        Scanner teclado = new Scanner(System.in);

        System.out.println("Introduce el nombre del producto: ");
        String nombre = teclado.nextLine();
        articulo.setNombre(nombre);

        System.out.println("Introduce el precio:");
        String precioString = teclado.nextLine();
        double precio = Double.parseDouble(precioString);
        articulo.setPrecio(precio);

        System.out.println("Introduce el peso:");
        String pesoString = teclado.nextLine();
        double peso = Double.parseDouble(pesoString);
        articulo.setPeso(peso);

        System.out.println("Introduce la fecha de fabricacion (yy-MM-dd)");
        String fechaString = teclado.nextLine();
        LocalDate fechaFabricacion = LocalDate.parse(fechaString);
        articulo.setFechaFabricacion(fechaFabricacion);

        return articulo;
    }

    public static Servicio crearServicio() {
        Servicio servicio = new Servicio();
        Scanner teclado = new Scanner(System.in);

        System.out.println("Introduce el nombre del producto: ");
        String nombre = teclado.nextLine();
        servicio.setNombre(nombre);

        System.out.println("Introduce el precio:");
        String precioString = teclado.nextLine();
        double precio = Double.parseDouble(precioString);
        servicio.setPrecio(precio);

        System.out.println("Introduce la duracion estimada:");
        String duracionString = teclado.nextLine();
        double duracion = Double.parseDouble(duracionString);
        servicio.setDuracionEstimada(duracion);

        System.out.println("Introduce la fecha de Inicio (yy-MM-dd)");
        String fechaIni = teclado.nextLine();
        LocalDate fechaInicio = LocalDate.parse(fechaIni);
        servicio.setFechaComienzo(fechaInicio);

        System.out.println("Introduce la fecha de Inicio (yy-MM-dd)");
        String fechaFin = teclado.nextLine();
        LocalDate fechaFinalizacion = LocalDate.parse(fechaFin);
        servicio.setFechaFin(fechaFinalizacion);

        return servicio;
    }
}
