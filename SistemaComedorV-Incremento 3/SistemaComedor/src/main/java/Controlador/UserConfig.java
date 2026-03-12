package Controlador;

import Modelo.Usuario;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import javax.swing.JOptionPane;


public class UserConfig {
    
//--------------------ACTUALIZAR EL ESTADO DEL USUARIO(PUEDEN SER TODOS SUS ATRIBUTOS O NO)--------------------------------------
/*Reescribe el archivo de DB con el nuevo estado del usuario */    
public static void actUser(Usuario actual){
    
//Creamos las variables de las rutas hacia los archivos
Modelo.Datos d = new Modelo.Datos();
String rutaOficial = d.getUsers(); 

//Creamos 2 archivos el original y el temporal
File archivoOriginal = new File(rutaOficial);
File archivoTemporal = new File(archivoOriginal.getAbsolutePath() + ".tmp");

//Variable para indicar si el cambio fue exitoso
boolean encontrado = false;

// Intentamos crear los archivos
    try (BufferedReader br = new BufferedReader(new FileReader(archivoOriginal));
     PrintWriter pw = new PrintWriter(new FileWriter(archivoTemporal))) {

        String linea;
        
        //Si se puedieron crear entonces leemos buscando el usuario deseado
        while ((linea = br.readLine()) != null) {
        if (linea.trim().isEmpty()) continue;

            //Si lo conseguimos actualizamos sus valores
            if(linea.equals(actual.getCedula())){        
                pw.println(actual.getCedula());//agrego cedula
                pw.println(actual.getPassword());//agrego contraseña
                pw.println(actual.getTipo());//agrego Tipo de usuario
                pw.println(actual.getNombre());//agrego Nombre
                pw.println(actual.getApellido());//agrego Apellido
                pw.println(String.valueOf(actual.getMonedero()));//Agrego el valor del monedero
                String turno = (actual.getTurno()) ? "true" : "false";
                pw.println(turno);//agrego si tiene un turno asignado
                pw.println(actual.getEstado());//agrego estado del usuario en la plataforma
                pw.println(actual.getCorreo());//agrego el correo del usuario
                pw.println();//Espaciador entre los usuarios
                encontrado = true;
                
               //Este bucle ignora los campos del usuario actual ya que se estan actualizando y pasa al siguiente  aseguir escribiendo 
                for(int i = 0 ; i < 9 ; i++){
                    linea = br.readLine();
                }
               }else{
               pw.println(linea);
               for(int i = 0 ; i  < 8 ; i++){
               linea = br.readLine();
               pw.println(linea);
               }
               pw.println();
              }
        }
    } catch (java.io.IOException e) {
        JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
      }
    if (encontrado) {
    //El archivo se cierra solo gracias al try/catch
        if (archivoOriginal.delete()) {
            archivoTemporal.renameTo(archivoOriginal);
        } else {
            JOptionPane.showMessageDialog(null, "Error: No se pudo actualizar el archivo. Verifica si está abierto.");
          }
    } 
    
}
}
