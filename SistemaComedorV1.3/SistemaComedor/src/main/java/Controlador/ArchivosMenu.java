
package Controlador;

import Modelo.Datos;
import Modelo.Menu;
import Modelo.Plato;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class ArchivosMenu {
    
     //----------------------------------CREAR ARCHIVO DE MENUS -----------------------------------
    
    public ArchivosMenu(){}
   
   public static void crearArchivoMenu(String ruta) {
    File archivo = new File(ruta);
    
    //se crea el archivo solo si no existe
    if (!archivo.exists()) {
        try (PrintWriter salida = new PrintWriter(archivo)) {
     
            System.out.println("Archivo de menú creado exitosamente en: " + ruta);
        } catch (FileNotFoundException ex) {
            System.err.println("Error al crear el archivo físico: " + ex.getMessage());
        }
    } else {
        System.out.println("El archivo de menú ya existe, no es necesario crearlo.");
    }
}
   //----------------------------------AGREGAR PLATOS AL MENU-----------------------------------------
   public static void agregarMenuArchivo(Datos datos, Plato nuevo) {
    // Usamos la ruta oficial que viene de la clase Datos
    String rutaOficial = datos.getMenus(); 

    String lineaParaGuardar = nuevo.getID() + "," +
                              nuevo.getCantidad() + "," +
                              nuevo.getDesayuno() + "," +
                              nuevo.getAlmuerzo() + "," +
                              nuevo.getPostre() + "," +
                              nuevo.getDiaSemana() + "," +
                              nuevo.getFecha();

    // Cambiamos "menus.txt" por la variable rutaOficial
    try (java.io.FileWriter fw = new java.io.FileWriter(rutaOficial, true);
         java.io.PrintWriter pw = new java.io.PrintWriter(fw)) {
        
        pw.println(lineaParaGuardar);
        System.out.println("Guardado exitosamente en: " + rutaOficial);
        
    } catch (java.io.IOException e) {
        System.out.println("Error al guardar: " + e.getMessage());
    }
}
    //-------------------------------LEER MENU----------------------------------------
    
 public static void leerMenu(Menu menuObjeto, java.util.ArrayList<Plato> listaPlatos) {
    listaPlatos.clear(); // Limpiamos para no repetir datos
    String ruta = menuObjeto.dato.getMenus(); 

    try (java.io.BufferedReader br = new java.io.BufferedReader(new java.io.FileReader(ruta))) {
        String linea;
        while ((linea = br.readLine()) != null) {
            if (linea.trim().isEmpty()) continue; // Salta líneas vacías

            String[] datos = linea.split(",");
            
            // Verificamos que existan los 7 datos (ID, Cantidad, Desayuno, Almuerzo, Postre, Dia, Fecha)
    if (datos.length >= 7) {
        Plato actual = new Plato();
        actual.setID(datos[0].trim());
        actual.setCantidad(Integer.parseInt(datos[1].trim()));
        actual.setDesayuno(datos[2].trim());
        actual.setAlmuerzo(datos[3].trim());
        actual.setPostre(datos[4].trim());
        actual.setDiaSemana(datos[5].trim());
        actual.setFecha(datos[6].trim());
                
        boolean existe = false;
        for (Plato cargado : listaPlatos) {
            // Validamos de que no hayan platos repetidos(identicos puede haber el mismo menu en diferentes fechas)
            if (cargado.getID().equalsIgnoreCase(actual.getID()) && 
                cargado.getFecha().equals(actual.getFecha())) {
                existe = true;
                break;
            }
        }

        if (!existe) {
            listaPlatos.add(actual);
        }             
            }
        }
    } catch (Exception e) {
        System.out.println("Error al leer archivo: " + e.getMessage());
    }
}
      public static void crearArchivo(String nombreArchivo){
        //Creo elemento de la clase File
    File archivo = new File(nombreArchivo);
        try {
        //Cierro el archivo
        try ( //Creo el archivo
                PrintWriter salida = new PrintWriter(archivo)) {
            //Cierro el archivo
            System.out.print("Se creo el archivo" + nombreArchivo);
        }
            
        } catch (FileNotFoundException ex){
            //Si no se puede abrir imprimo error
           ex.printStackTrace(System.out);
        }  
    }
}
