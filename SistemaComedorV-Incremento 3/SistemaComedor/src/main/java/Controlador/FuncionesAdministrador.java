
package Controlador;

import Modelo.Datos;
import Vista.InterfazAdmin;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class FuncionesAdministrador {
    
    public FuncionesAdministrador(){}
    
    public void EliminarPlato(InterfazAdmin admin,String txtID){
       
    String idAEliminar = txtID.trim();
    Modelo.Datos d = new Modelo.Datos();
    String rutaOficial = d.getMenus(); 

File archivoOriginal = new File(rutaOficial);
File archivoTemporal = new File(archivoOriginal.getAbsolutePath() + ".tmp");

boolean encontrado = false;

// Usamos nombres completos para evitar errores de importación
    try (BufferedReader br = new BufferedReader(new FileReader(archivoOriginal));
     PrintWriter pw = new PrintWriter(new FileWriter(archivoTemporal))) {

        String linea;
        while ((linea = br.readLine()) != null) {
        if (linea.trim().isEmpty()) continue;

        String[] partes = linea.split(",");
        // Comparamos el ID
            if (partes.length > 0 && partes[0].trim().equals(idAEliminar)) {
                encontrado = true; 
            } else {
                pw.println(linea); 
              }
        }
    } catch (java.io.IOException e) {
        JOptionPane.showMessageDialog(admin, "Error: " + e.getMessage());
      }

    if (encontrado) {
    // IMPORTANTE: Cerrar procesos antes de borrar (el try-with-resources lo hace solo)
        if (archivoOriginal.delete()) {
            archivoTemporal.renameTo(archivoOriginal);
            JOptionPane.showMessageDialog(admin, "Plato " + idAEliminar + " eliminado.");
        } else {
            JOptionPane.showMessageDialog(admin, "Error: No se pudo borrar el archivo. Verifica si está abierto.");
          }
    } else {
        archivoTemporal.delete();
        JOptionPane.showMessageDialog(admin, "No se encontró el ID: " + idAEliminar);
      }
    }
    
//---------------------------------AGREGAR BECARIO-----------------------------------------
public static void guardarBecario(String ruta, String cedula, float tarifa) {
    File archivo = new File(ruta);
    try {
        
        //si no existe se crea
        archivo.createNewFile(); 
        
        try (PrintWriter salida = new PrintWriter(new FileWriter(archivo, true))) {
            salida.println(cedula + " " + tarifa);
        }
    } 
    catch (IOException ex) {
        System.out.println("Error al guardar: " + ex.getMessage());
    }
}

//----------------------------ELIMINAR BECARIO----------------------------------------------
 public static boolean eliminarBecario(String ruta, String cedula) {
    File archivo = new File(ruta);
    ArrayList<String> lineasRestantes = new ArrayList<>();
    boolean encontrado = false;

    try {
        if (!archivo.exists()) return false;

        //Leer y filtrar
        try (Scanner lector = new Scanner(archivo)) {
            while (lector.hasNextLine()) {
                String linea = lector.nextLine();
                if (linea.startsWith(cedula + " ")) {
                    encontrado = true; 
                    // Saltamos esta línea (la eliminamos)
                } else {
                    lineasRestantes.add(linea);
                }
            }
        }

        //Reescribimos el archivo si la cedula se consiguio en el archivo de becarios
        if (encontrado) {
            try (PrintWriter salida = new PrintWriter(new FileWriter(archivo, false))) {
                for (String l : lineasRestantes) {
                    salida.println(l);
                }
            }
        }
    } catch (IOException ex) {
        ex.printStackTrace();
    }
    return encontrado;
}
     
    }
 
