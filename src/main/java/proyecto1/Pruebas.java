package proyecto1;

import java.io.File;

public class Pruebas {
    public static void main(String[] args) {
        /*String sCarpAct = System.getProperty("user.dir");
        File carpeta = new File(System.getProperty("user.dir"));
        String[] listado = carpeta.list();
        if (listado == null || listado.length == 0) {
            System.out.println("No hay elementos dentro de la carpeta actual");
            return;
        }
        else {
            for (int i=0; i< listado.length; i++) {
                System.out.println(listado[i]);
            }
        }*/
        listarDirectorio("./backup");
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
}
