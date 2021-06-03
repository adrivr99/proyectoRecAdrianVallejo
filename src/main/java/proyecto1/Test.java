package main.java.proyecto1;

import main.java.proyecto1.Empresa;

import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        Empresa rocketMouse = new Empresa();

        ArrayList<Cliente> listaCliente = ServicioLectura.CSVClientes("Clientes.csv");
        ArrayList<Articulo> listaArticulos = ServicioLectura.CSVArticulos("Articulos.csv");
        //listaCliente.forEach(System.out::println);



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
                if (opcionMenu == 0){
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
                    int opcionClientes= 0;
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
                                break;
                            case 3:
                                System.out.println("---------Añadir Cliente---------");
                                break;
                            case 4:
                                System.out.println("---------Borrar Cliente---------");
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
                                listaArticulos.forEach(System.out::println);
                                break;
                            case 2:
                                System.out.println("-------Modificar Producto-------");
                                break;
                            case 3:
                                System.out.println("--------Añadir Producto---------");
                                break;
                            case 4:
                                System.out.println("---------Borrar Producto--------");
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
                    boolean salirCopias;
                    System.out.println("------COPIAS DE SEGURIDAD------");
                    System.out.println("1. Generar Copia de Seguridad");
                    System.out.println("2. Restaurar Copia de Seguridad");
                    System.out.println("3. Salir");
                    System.out.println("--------------------------------");
                    break;
                case 5:
                    salir = true;

            }
        } while (!salir);
        /*System.out.println("--------------MENÚ--------------");
        System.out.println("1. Clientes");
        System.out.println("2. Productos");
        System.out.println("3. Pedidos");
        System.out.println("4. Imprimir Pedido");
        System.out.println("5. Generar Copias de Seguridad");
        System.out.println("6. Restarurar Copias de Seguridad");
        System.out.println("7. Salir");*/

    }
}
