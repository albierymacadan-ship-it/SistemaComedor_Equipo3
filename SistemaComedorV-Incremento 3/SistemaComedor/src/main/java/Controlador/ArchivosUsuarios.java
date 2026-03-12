package Controlador;
import java.io.*;
import Modelo.Usuario;

public class ArchivosUsuarios {
    //--------------------------CREAR EL ARCHIVO---------------------------------------------
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
    //--------------------------AÑADIR USUARIO AL ARCHIVO---------------------------------------------
       public static void agregarUsuarioArchivo(String nombreArchivo, Usuario usuario) throws IOException{
        //Creo elemento de la clase File
    File archivo = new File(nombreArchivo);
       //INTENTO ABRIR EL ARCHIVO, (SE CIERRA SOLO); 
        try (PrintWriter salida = new PrintWriter(new FileWriter(archivo,true))){
            //USO EL ARCHIVO
            salida.println(usuario.getCedula());//agrego cedula
            salida.println(usuario.getPassword());//agrego contraseña
            salida.println(usuario.getTipo());//agrego Tipo de usuario
            salida.println(usuario.getNombre());//agrego Nombre
            salida.println(usuario.getApellido());//agrego Apellido
            salida.println(String.valueOf(usuario.getMonedero()));//Agrego el valor del monedero
            salida.println(String.valueOf(usuario.getTurno()));//agrego si tiene un turno asignado
            salida.println(usuario.getEstado());//agrego estado del usuario en la plataforma
            salida.println(usuario.getCorreo());//agrego el correo del usuario
            salida.println();//Espaciador entre los usuarios
            System.out.print("Se creo el archivo" + nombreArchivo);  
            //POR EL TRY EL ARCHIVO SE CERRARA SOLO
        } catch (FileNotFoundException ex){
            //Si no se puede abrir imprimo error
           ex.printStackTrace(System.out);
        }  
    }
       //--------------------------VALIDAR EXISTENCIA DE USUARIO---------------------------------------------
       public static boolean validarUsuarioEnRegistro(String nombreArchivo, Usuario persona){
           //Creo archivo
           File archivo = new File(nombreArchivo);  
        try {
            //Abro el archivo y lo uso
            BufferedReader entrada = new BufferedReader(new FileReader(archivo));
            String lectura ;
            while((lectura = entrada.readLine()) != null){
             if(lectura.equals(persona.getCedula())){
                 return true; //Usuario existente
             }
                //Saltar los siguientes 8 campos para ir directamente a la siguiente cedula
                for(int i = 0 ; i < 9 ;i++){
                    entrada.readLine();
                }
            }
        } catch (FileNotFoundException ex) {
            System.getLogger(ArchivosUsuarios.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        } catch (IOException ex) {
            System.getLogger(ArchivosUsuarios.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        } 
        return false;//No existe el usuario
       }
      //--------------------------VALIDAR LOGIN---------------------------------------------
        
public static int validarYCargarUsuario(String nombreArchivo, String cedula, String clave, Usuario nuevo) {
    File archivo = new File(nombreArchivo);
    if (!archivo.exists()) return 0;

    try (BufferedReader entrada = new BufferedReader(new FileReader(archivo))) {
        String r_cedula;
        
        while ((r_cedula = entrada.readLine()) != null) {
            // 1. Leemos la clave (segunda línea del bloque)
            String r_clave = entrada.readLine();
            
            // si la clave y la cedula coinciden con la data base
            if (r_cedula.equals(cedula)  && r_clave.equals(clave)) {
                
               //Se cargan los datos del usuario
                nuevo.setCedula(r_cedula);
                nuevo.setPassword(r_clave);
                nuevo.setTipo(entrada.readLine());
                nuevo.setNombre(entrada.readLine());
                nuevo.setApellido(entrada.readLine());
                
                String sMonedero = entrada.readLine();
                nuevo.setMonedero(sMonedero != null ? Float.parseFloat(sMonedero) : (float)0.0);
                
                String sTurno = entrada.readLine();
                nuevo.setTurno(Boolean.parseBoolean(sTurno));
                
                String r_estado = entrada.readLine();
                nuevo.setEstado(r_estado);
                
                nuevo.setCorreo(entrada.readLine());

                // Retornamos rol según el campo Estado
                return (nuevo.getTipo().equals("Administrador")) ? 2 : 1;

            } else {
                // NO ES EL USUARIO: Saltamos las 6 líneas restantes del bloque
                // para que la siguiente lectura del 'while' sea la cédula del siguiente usuario
                for (int i = 0; i < 8; i++) {
                    entrada.readLine();
                }
            }
        }
    } catch (IOException | NumberFormatException ex) {
        System.err.println("Error en procesamiento: " + ex.getMessage());
    }
    return 0; // No encontrado
}

public static boolean eliminarPlato(String idABuscar) {
    java.io.File archivoOriginal = new java.io.File("menus.txt");
    java.io.File archivoTemporal = new java.io.File("menus_temp.txt");
    boolean encontrado = false;

    try (java.io.BufferedReader reader = new java.io.BufferedReader(new java.io.FileReader(archivoOriginal));
         java.io.BufferedWriter writer = new java.io.BufferedWriter(new java.io.FileWriter(archivoTemporal))) {

        String linea;
        while ((linea = reader.readLine()) != null) {
            // Separamos la línea por las comas para obtener el ID real
            String[] datos = linea.split(",");
            
            // Si el primer dato (el ID) coincide, lo ignoramos (borramos)
            if (datos.length > 0 && datos[0].trim().equals(idABuscar.trim())) {
                encontrado = true;
                continue; 
            }
            writer.write(linea + System.lineSeparator());
        }

    } catch (java.io.IOException e) {
        return false;
    }

    // Reemplazo de archivos
    archivoOriginal.delete();
    archivoTemporal.renameTo(archivoOriginal);
    return encontrado;
}

}
    
