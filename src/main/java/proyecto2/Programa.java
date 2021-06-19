package proyecto2;


import static proyecto1.ServicioLectura.crearDirectorio;
import static proyecto1.ServicioLectura.generarJSON;
import static proyecto1.ServicioLectura.generarTxt;
import static proyecto1.ServicioLectura.leerJSONArticulos;
import static proyecto1.ServicioLectura.leerJSONClientes;
import static proyecto1.ServicioLectura.leerJSONPedidos;
import static proyecto1.ServicioLectura.leerJSONServicios;

import java.io.IOException;
import java.sql.Connection;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import model.*;
import controladores.ControladorCliente;
import controladores.ControladorListaProducto;
import controladores.ControladorProducto;
import controladores.ControladorPedido;
import proyecto2.ServicioLectura.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Programa {
public static void main(String[] args) throws IOException {
		Scanner teclado = new Scanner(System.in);
	
    	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("proyectoRecAdrianVallejo");
    	EntityManager em = entityManagerFactory.createEntityManager();
    	ControladorCliente cli = new ControladorCliente();
    	ControladorProducto pro = new ControladorProducto();
    	ControladorPedido ped = new ControladorPedido();
    	ControladorListaProducto lp = new ControladorListaProducto();
    	
    	Empresa empresa = new Empresa();
    	empresa.setNombre("Rocket Mouse");
    	empresa.setCIF("B - 76365789");
    	empresa.setDireccion("Avenida Espa�a, 10 La Linea de la Concepcion, Espa�a");
    	
    	List<Cliente> listaClientes = cli.findAll();
    	//listaClientes.forEach(System.out::println);
    	empresa.setListaClientes(listaClientes);
    	
    	List<Producto> listaProductos = pro.findAll();
    	//listaProductos.forEach(System.out::println);
    	empresa.setListaProductos(listaProductos);
    	
    	List<Pedido> listaPedidos = ped.findAll();
    	//listaProductos.forEach(System.out::println);
    	empresa.setListaPedidos(listaPedidos);
    	
    	List<Listaproducto> listaProductosPedido = lp.findAll();
    	
    	boolean salir = false;
        int opcionMenu = 0;
        do {
            System.out.println("--------------MENU--------------");
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
                    System.out.println("Tiene que ser un Numero");
                }
                if (opcionMenu == 0) {
                    System.out.println("No existe esa opcion");
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
                                System.out.println("Tiene que ser un numero");
                            }
                            if (opcionClientes >= 1 && opcionClientes <= 5) {
                                exitClientes = true;
                            }
                        } while (!exitClientes);
                        switch (opcionClientes) {
                            case 1:
                                System.out.println("-------Listado de Clientes------");
                                listaClientes.forEach(System.out::println);
                                break;
                            case 2:
                                System.out.println("-------Modificar Cliente--------");
                                listaClientes.forEach(System.out::println);
                                System.out.println("Elige un cliente por su id para modificarlo");
                                int opcionModificarClientes = teclado.nextInt();
                                // Bucle for para Modificar el cliente
                                
                                for (Cliente clienteAux: listaClientes) {
                                	if (clienteAux.getIdCliente() == opcionModificarClientes) {
                                		 listaClientes.remove(clienteAux);
                                         // Creamos un nuevo cliente
                                		 Cliente cliente = new Cliente();
                                         // LLenamos el nuevo cliente con el m�todo crear Cliente
                                         cliente = crearCliente();
                                         cli.borrarCliente(clienteAux);
                                         cli.modifyCliente(cliente);
                                         // A�adimos el cliente a la lista Clientes en la posici�n del cliente modificado.
                                         listaClientes.clear();;
                                         listaClientes = cli.findAll();
                                	}
                                }
                                break;
                            case 3:
                                System.out.println("---------A�adir Cliente---------");
                             // Creamos objeto cliente
                                Cliente cliente = new Cliente();
                                // Llenamos el cliente con el método crear Cliente
                                //cliente = crearCliente();
                                cliente = crearCliente();
                                cli.createCliente(cliente);
                                //Añadimos el cliente a la lista de Clientes.
                                listaClientes.add(cliente);
                                // Condicional para saber si se ha añadido el cliente a la lista
                                if (listaClientes.contains(cliente)) {
                                    System.out.println("Cliente a�adido correctamente");
                                } else {
                                    System.out.println("No se ha podido a�adir el cliente");
                                }
                                break;
                            case 4:
                            	listaClientes.forEach(System.out::println);
                                System.out.println("Elige el id del cliente de la lista a eliminar:");
                                teclado.nextLine();
                                // Leemos el nif del cliente con el metodo leerNif
                                int idEliminar = teclado.nextInt();
                                // Listamos la lista de clientes en busca del nifEliminar y eliminamos el cliente de la lista
                                for (int i = 0; i < listaClientes.size();i++) {
                                	if (listaClientes.get(i).getIdCliente() == idEliminar) {
                                		//listaClientes.remove(listaClientes.get(i));
                                		cli.borrarCliente(listaClientes.get(i));
                                	}
                                }
                                listaClientes.clear();
                                listaClientes = cli.findAll();
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
                                for (Producto productoAux: listaProductos) {
                                	if (productoAux.getProducto() == IDModificar) {
                                		if (productoAux.getTipo() == true) {
                                			Producto producto = new Producto();
                                    		producto = crearArticulo();
                                    		pro.borrarProducto(productoAux);
                                    		pro.createProducto(producto);
                                    		listaProductos.remove(productoAux);
                                    		listaProductos.clear();
                                    		listaProductos = pro.findAll();
                                		} else if (productoAux.getTipo() == false) {
                                			Producto producto = new Producto();
                                    		producto = crearServicio();
                                    		pro.borrarProducto(productoAux);
                                    		pro.createProducto(producto);
                                    		listaProductos.remove(productoAux);
                                    		listaProductos.clear();
                                    		listaProductos = pro.findAll();
                                		}
                                		
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
                                    Producto producto = new Producto();
                            		producto = crearArticulo();
                            		pro.createProducto(producto);
                            		listaProductos.clear();
                            		listaProductos = pro.findAll();
                                    if (listaProductos.contains(producto)) {
                                        System.out.println("Articulo a�adido correctamente");
                                    } else {
                                        System.out.println("No se ha podido a�adir el Articulo");
                                    }
                                } else if (crearProducto.equalsIgnoreCase("servicio")) {
                                    System.out.println("--------A�adir Servicio---------");
                                    Producto producto = new Producto();
                            		producto = crearServicio();
                            		pro.createProducto(producto);
                            		listaProductos.clear();
                            		listaProductos = pro.findAll();
                                    if (listaProductos.contains(producto)) {
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
                                for (int i = 0; i < listaProductos.size();i++) {
                                	if (listaProductos.get(i).getProducto() == IDEliminar) {
                                		pro.borrarProducto(listaProductos.get(i));
                                	}
                                }
                                listaProductos.clear();
                                listaProductos = pro.findAll();
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
                                    String idPedido = teclado.nextLine();
                                    // Bucle for para buscar dentro de la listaPedidos el pedido buscado por teclado
                                    for (Pedido pedidoAux: listaPedidos) {
                                        if (pedidoAux.getNumeroPedido().equalsIgnoreCase(idPedido)) {
                                            // Con el método generarTxt, generamos un archivo txt con los datos del
                                            // pedido
                                        	ServicioLectura.generarTxt(pedidoAux);
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
                                System.out.println("Elige el pedido a modificar por su numero de pedido");
                                String pedidoModificar = teclado.nextLine();
                                for (int i = 0; i < listaPedidos.size(); i++) {
                                    if (listaPedidos.get(i).getNumeroPedido().equalsIgnoreCase(pedidoModificar)) {
                                        Pedido pedido = new Pedido();
                                        pedido = crearPedido(listaClientes, listaProductos);
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
                                pedido = crearPedido(listaClientes, listaProductos);
                                
                                
                                ped.createPedido(pedido);
                                List <Listaproducto> listaProductoAux = addListaProductos(pedido, listaProductos);
                                for	(Listaproducto lpAux: listaProductoAux) {
                                	lp.createListaProducto(lpAux);
                                }
                                
                                pedido.setListaproductos(listaProductoAux);
                                
                                listaPedidos.clear();
                                listaPedidos = ped.findAll();
                                listaProductosPedido.clear();
                                listaProductosPedido = lp.findAll();
                                break;
                            case 4:
                                System.out.println("-------Borrar Pedido-------");
                                for (int i = 0; i < listaPedidos.size(); i++) {
                                    System.out.println("ID Pedido: " + listaPedidos.get(i).getIdPedido() +", Numero de Pedido: " + listaPedidos.get(i).getNumeroPedido());
                                }
                                System.out.println("Elige un pedido para eliminar: ");
                                teclado.nextLine();
                                int pedidoDelete = teclado.nextInt();
                                for (Listaproducto lpAux : listaProductosPedido) {
                                	for (Pedido pedidoAux : listaPedidos) {
                                		if(pedidoAux.getIdPedido() == pedidoDelete) {
                                			if(lpAux.getPedido().getIdPedido() == pedidoAux.getIdPedido()) {
                                    			lp.borrarListaProducto(lpAux);
                                    		}
                                		}
                            			
                                	}
                                }
                                for (Pedido pedidoAux : listaPedidos) {
                                	if(pedidoAux.getIdPedido() == pedidoDelete) {
                                		ped.borrarPedido(pedidoAux);
                                	}
                                }
                                listaPedidos.clear();
                                listaPedidos = ped.findAll();
                                listaProductosPedido.clear();
                                listaProductosPedido = lp.findAll();
                                
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
                            	listaClientes.clear();
                            	listaClientes = cli.findAll();
                            	listaProductos.clear();
                            	listaProductos = pro.findAll();
                            	listaPedidos.clear();
                            	listaPedidos = ped.findAll();
                            	listaProductosPedido.clear();
                            	listaProductosPedido = lp.findAll();
                                LocalDateTime fechaHoraActual = LocalDateTime.now();
                                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd_hhmm");
                                String directorio = fechaHoraActual.format(formatter);
                                crearDirectorio("./backupBBDD/" + directorio);
                                
                                //ServicioLectura.generarJSONClientes(listaClientes, directorio);
                                //ServicioLectura.generarJSONPedidos(listaPedidos, directorio);
                                ServicioLectura.generarJSONProductos(listaProductos, directorio);
                                //ServicioLectura.generarJSONProductosPedidos(listaProductosPedido, directorio);
                                // Con el método generarJSON, crearemos un archivo JSON que guardará la lista de pedidos
                                // pasandole la lista de pedidos y el directorio donde queremos que se guarde.
                                
                                //ServicioLectura.generarJSONPedidos(empresa, directorio);
                                //ServicioLectura.generarJSONClientes(empresa, directorio);
                                //ServicioLectura.generarJSONProductos(empresa, directorio);
                                break;
                            case 2:
                                System.out.println("-------Restaurar Copia de Seguridad-------");
                                // Mostramos por pantalla el contenido de la carpeta backup
                                ServicioLectura.listarDirectorio("./backupBBDD/");
                                System.out.println("Elige una copia de seguridad para restaurar");
                                teclado.nextLine();
                                String copiaEleccion = teclado.nextLine();
                                empresa.getListaClientes().clear();
                                empresa.getListaProductos().clear();
                                empresa.getListaPedidos().clear();
                                //System.out.println(empresa.toString());
                                //System.out.println("---------------------");
                                for (Listaproducto lpAux: listaProductosPedido) {
                                	lp.borrarListaProducto(lpAux);
                                }
                                for (Cliente cAux: listaClientes) {
                                	cli.borrarCliente(cAux);
                                }
                                listaProductos.clear();
                                listaPedidos.clear();
                                listaClientes.clear();
                                listaClientes = ServicioLectura.leerJSONClientes(copiaEleccion);
                                listaProductos = ServicioLectura.leerJSONProductos(copiaEleccion);
                                listaPedidos = ServicioLectura.leerJSONPedidos(copiaEleccion);
                                empresa.setListaProductos(listaProductos);
                                empresa.setListaClientes(listaClientes);
                                empresa.setListaPedidos(listaPedidos);
                                
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


private static List <Listaproducto> addListaProductos(Pedido pedido, List<Producto> listaProductos) {
	Scanner teclado = new Scanner(System.in);
	boolean exitAddProductos = false;
	List<Listaproducto> listaProductoPedido = new ArrayList<>();
    do {
        System.out.println("Elige un producto de la lista por su id");
        // Listamos los productos
        for (int i = 0; i < listaProductos.size(); i++) {
            System.out.println(listaProductos.get(i).getProducto() + "Producto: " + listaProductos.get(i).getNombre() + ", precio: " + listaProductos.get(i).getPrecio());
        }
        int elegirProducto = teclado.nextInt();
        Listaproducto productoPedido = new Listaproducto();
        productoPedido.setPedido(pedido);
        for (int i = 0; i < listaProductos.size();i++) {
        	if (listaProductos.get(i).getProducto() == elegirProducto) {
        		productoPedido.setProductoBean(listaProductos.get(i));
        		System.out.println("Indica la cantidad: ");
                int cantidadProducto = teclado.nextInt();
                productoPedido.setCantidad(cantidadProducto);
        	}
        }
        listaProductoPedido.add(productoPedido);
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
    //pedido.setListaproductos(listaProductoPedido);
	return listaProductoPedido;
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

	private static Cliente crearCliente() {
	    Cliente cliente = new Cliente();
	    Scanner teclado = new Scanner(System.in);
	    String NIF = leerNif();
	    cliente.setNif(NIF);
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
	
	private static Producto crearArticulo() {
        Producto articulo = new Producto();
        Scanner teclado = new Scanner(System.in);
        
        articulo.setTipo(true);

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
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
        Date fechaFabricacion = null;
        try {
        	fechaFabricacion = formato.parse(fechaString);
        } 
        catch (ParseException ex) 
        {
            System.out.println(ex);
        }
        articulo.setFechaFabricacion(fechaFabricacion);

        return articulo;
    }

    public static Producto crearServicio() {
        Producto servicio = new Producto();
        Scanner teclado = new Scanner(System.in);
        
        servicio.setTipo(false);

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
        servicio.setDuracion(duracion);

        System.out.println("Introduce la fecha de Inicio (yy-MM-dd)");
        String fechaIni = teclado.nextLine();
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
        Date fechaInicio = null;
        try {
        	fechaInicio = formato.parse(fechaIni);
        } 
        catch (ParseException ex) 
        {
            System.out.println(ex);
        }
        
        servicio.setFechaInicio(fechaInicio);

        System.out.println("Introduce la fecha de Inicio (yy-MM-dd)");
        String fechaFin = teclado.nextLine();
        Date fechaFinalizacion = null;
        try {
        	fechaFinalizacion = formato.parse(fechaFin);
        }catch (ParseException ex) 
        {
            System.out.println(ex);
        }
        servicio.setFechaFin(fechaFinalizacion);

        return servicio;
    }
    
    private static Pedido crearPedido(List<Cliente> listaClientes, List<Producto> listaProductos) {
    	ControladorListaProducto lp = new ControladorListaProducto();
    	Pedido pedido = new Pedido();
        Scanner teclado = new Scanner(System.in);
        // Asignamos la fecha del pedido con un LocalDate.now() para que sea la fecha actual
        LocalDate fechaActualLocal = LocalDate.now();
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
        Date fecha = java.sql.Date.valueOf(LocalDate.now());
        pedido.setFechaPedido(fecha);
        // Asignamos el número de pedido con el método asignarNumeroPedido
        pedido.asignarNumeroPedido(pedido);
        // Listamos la lista de clientes
        System.out.println("Elige un cliente por su ID");
        for (int i = 0; i < listaClientes.size(); i++) {
            System.out.println("Id Cliente: "+ listaClientes.get(i).getIdCliente() + " " + listaClientes.get(i).getNombre() + " " + listaClientes.get(i).getApellidos());
        }
        // Leemos el nif del cliente con el método leerNif()
        int idCliente = teclado.nextInt();
        for (int i = 0; i < listaClientes.size();i++) {
        	if (listaClientes.get(i).getIdCliente() == idCliente) {
        		pedido.setClienteBean(listaClientes.get(i));
        		pedido.setDireccionCliente(listaClientes.get(i).getDireccion());
        	}
        }
        System.out.println("Método de pago, transferencia o tarjeta?");
        teclado.nextLine();
        String metodoPago = teclado.nextLine();
        // Asignamos el método de pago
        pedido.setFormaPago(metodoPago);
        System.out.println("Método de envio:\n1.Recoger en tienda\n2.Envio a domicilio");
        int envio = teclado.nextInt();
        // Asignamos si se va a realizar un envío con true o false;
        boolean envioBoolean = false;
        if (envio == 1) {
            envioBoolean = false;
            pedido.setEnvio(envioBoolean);
            
        } else if (envio == 2) {
            envioBoolean = true;
            pedido.setEnvio(envioBoolean);
        }
        /*boolean exitAddProductos = false;
        // Creamos listas de articulos y servicios que estarán en el pedido
        List<Listaproducto> listaProductoPedido = new ArrayList<>();
        do {
            System.out.println("Elige un producto de la lista por su id");
            // Listamos los productos
            for (int i = 0; i < listaProductos.size(); i++) {
                System.out.println(listaProductos.get(i).getProducto() + "Producto: " + listaProductos.get(i).getNombre() + ", precio: " + listaProductos.get(i).getPrecio());
            }
            int elegirProducto = teclado.nextInt();
            Listaproducto productoPedido = new Listaproducto();
            productoPedido.setPedido(pedido);
            for (int i = 0; i < listaProductos.size();i++) {
            	if (listaProductos.get(i).getProducto() == elegirProducto) {
            		productoPedido.setProductoBean(listaProductos.get(i));
            		System.out.println("Indica la cantidad: ");
                    int cantidadProducto = teclado.nextInt();
                    productoPedido.setCantidad(cantidadProducto);
            	}
            }
            lp.createListaProducto(productoPedido);
            listaProductoPedido.add(productoPedido);
            System.out.println("Quieres añadir otro producto? (SI/NO)");
            teclado.nextLine();
            String salirAddProducto = teclado.nextLine();
            if (salirAddProducto.equalsIgnoreCase("Si")) {
                exitAddProductos = false;
            } else if (salirAddProducto.equalsIgnoreCase("No")) {
                exitAddProductos = true;
            }

        } while (!exitAddProductos);*/
        // Añadimos las listas de articulos y servicios al pedido
        //pedido.setListaproductos(listaProductoPedido);
        return pedido;
    }
}

