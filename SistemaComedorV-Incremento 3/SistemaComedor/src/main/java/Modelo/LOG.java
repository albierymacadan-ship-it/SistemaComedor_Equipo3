
package Modelo;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class LOG {
  ArrayList<String> log;
  listaReservaciones comensales[];
    
  public LOG(){
       
      //Inicializamos la lista del log de reservas y arreglo con los tipos de usuario y cantidad de reservas
       this.log = new ArrayList<String>();
       
       this.comensales = new listaReservaciones[5];
       
       //Inicializamos cada uno de los espacios
       for (int i = 0; i < 5; i++) {
        this.comensales[i] = new listaReservaciones();
    }
       
       this.comensales[0].setTipo("Estudiante");
       this.comensales[1].setTipo("Empleado");
       this.comensales[2].setTipo("Profesor");
       this.comensales[3].setTipo("Exonerado");
       this.comensales[4].setTipo("Becario");
       
   }
   
  //INCREMENTA LA CANTIDAD DE RESERVAS SEGUN EL TIPO DE USAURIO
   private void incrementarComensales(listaReservaciones comensales[], String tipo){
        if (tipo.equals("Estudiante")) {
          comensales[0].cantidad++;
      } else if (tipo.equals("Empleado")) {
          comensales[1].cantidad++;
      } else if (tipo.equals("Profesor")) {
          comensales[2].cantidad++;
      } else if (tipo.equals("Exonerado")) {
          comensales[3].cantidad++;
      } else if (tipo.equals("Becario")) {
          comensales[4].cantidad++;
      }
      
  }
  
   //DECREMENTA LA CANTIDAD DE RESERVAS SEGUN EL TIPO DE USAURIO
    private void decrementarComensales(listaReservaciones comensales[],String tipo){
      
        if (tipo.equals("Estudiante")) {
            if (comensales[0].cantidad > 0) comensales[0].cantidad--;
        } 
        else if (tipo.equals("Empleado")) {
            if (comensales[1].cantidad > 0) comensales[1].cantidad--;
        } 
        else if (tipo.equals("Profesor")) {
            if (comensales[2].cantidad > 0) comensales[2].cantidad--;
        } 
        else if (tipo.equals("Exonerado")) {
            if (comensales[3].cantidad > 0) comensales[3].cantidad--;
        } 
        else if (tipo.equals("Becario")) {
            if (comensales[4].cantidad > 0) comensales[4].cantidad--;
    }
  }
    
    //------------------------AGREGA LOS LOGS Y LAS RESERVAS X COMENSAL-----------------------------------------------
    public void insertToLog(Usuario actual, Plato plato){
        
        //Creamos un formato de hora para el log
        Date fechaActual = new Date();
        SimpleDateFormat formateador = new SimpleDateFormat("HH:mm:ss");
        String hora = formateador.format(fechaActual);
        
        //Creamos un format de fecha
        LocalDate hoy = LocalDate.now();
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String fechaTexto = hoy.format(formato);
        
        if (actual.getTurno() == true) {
           incrementarComensales(this.comensales, actual.getTipo());
           this.log.add("El usuario " + actual.getCedula() + " hizo una reserva del menu " + plato.getID() + " a las " + hora + " el " + fechaTexto);
       } else {
           decrementarComensales(this.comensales, actual.getTipo());
           this.log.add("El usuario " + actual.getCedula() + " canceló una reserva del menu " + plato.getID() + " a las " + hora + " el " + fechaTexto);
       }
    
    this.saveLOG();
        
    }
    
 //----------------------GUARDA LOS COMENSALES EN UN ARCHIVO---------------------------------- 
 private void guardarComensales(String ruta, listaReservaciones comensales[]) {
    File archivo = new File(ruta);

    try {
        
        //Si el archivo no existe se crea , si existe solo pasa a escribir
        archivo.createNewFile();   
        try (PrintWriter salida = new PrintWriter(new FileWriter(archivo))) {
            for (int i = 0; i < 5; i++) {
                
                //Escribimos en el archivo
                salida.println(comensales[i].getTipo() + " " + comensales[i].cantidad);
            }
        }
    } 
    catch (IOException ex) {
    System.getLogger(LOG.class.getName()).log(System.Logger.Level.ERROR, "Error al manejar el archivo", ex);
    }   
}   

 //-----------------------------GUARDA LOS LOGS EN UN ARCHIVO-------------------------------------------------------------
   private void guardarReservas(String ruta, ArrayList<String> log) {
        File archivo = new File(ruta);

        try {
            
            //Lo mismo que arriba
            archivo.createNewFile();
            try (PrintWriter salida = new PrintWriter(new FileWriter(archivo))) {
                for (int i = 0; i < log.size(); i++) {
                    
                    //Escribimos en el archivo
                    salida.println(log.get(i));
                }
            }
        }
        catch (IOException ex) {
            System.getLogger(LOG.class.getName()).log(System.Logger.Level.ERROR, "Error al manejar el archivo", ex);
        } 
    }
   
   //HACE USO DE LAS 2 FUNCIONES EN 1 SOLA QUE SE ENCARGA DE ESCRIBIR AMBOS ARCHIVOS AL FINALIZAR EL PROGRAMA
   public void saveLOG(){
   Datos dato = new Datos();
    
   //Guardamos los datos recolectados en los logs
   guardarComensales(dato.getComensales(),this.comensales);
   guardarReservas(dato.getLog(),this.log);
   }
   
   //--------------------------------CARGA LA CANTIDAD DE RESERVAS DE LOS COMENSALES DEL ARCHIVO-------------------------------
   private void cargarComensales(String ruta, listaReservaciones comensales[]) {
    File archivo = new File(ruta);
    try {
        //Por si acaso
        archivo.createNewFile();

        try (Scanner lector = new Scanner(archivo)) {
            int i = 0;
            // Leemos mientras haya líneas y no superemos el límite de 5
            while (lector.hasNextLine() && i < 5) {
                String linea = lector.nextLine();
                String[] partes = linea.split(" "); // Divide el texto por el espacio
                
                if (partes.length >= 2) {
                    comensales[i].setTipo(partes[0]);
                    comensales[i].cantidad = Integer.parseInt(partes[1]);
                    i++;
                }
            }
        }
    } catch (IOException | NumberFormatException ex) {
        System.getLogger(LOG.class.getName()).log(System.Logger.Level.ERROR, "Error al cargar comensales", ex);
    }
}
   
 //-------------------------CARGA EL LOG DE ARCHIVO--------------------------------------------
   private void cargarReservas(String ruta, ArrayList<String> log) {
    File archivo = new File(ruta);
    try {
        //Por si acaso
        archivo.createNewFile();

        // Limpiamos la lista actual 
        log.clear();

        try (Scanner lector = new Scanner(archivo)) {
            while (lector.hasNextLine()) {
                String linea = lector.nextLine();
                log.add(linea); // Añadimos cada línea del archivo a la lista
            }
        }
    } catch (IOException ex) {
        System.getLogger(LOG.class.getName()).log(System.Logger.Level.ERROR, "Error al cargar reservas", ex);
    }
}
   
   public void cargarLOG(){
   Datos dato = new Datos();
   
   //Cargamos los datos almacenados en caso de haber
   cargarComensales(dato.getComensales(),this.comensales);
   cargarReservas(dato.getLog(),this.log);    
   }
  
}
