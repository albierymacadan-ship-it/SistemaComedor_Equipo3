
package Controlador;

import Modelo.Datos;
import Modelo.Usuario;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

public class ManejoImagenes { 
   private final String ArchivoImagenes = "archivos\\UserImages.txt";
   private final String CarpetaImagenes = "src\\main\\resources\\UserImages\\";
   private String id;
   private String NombreImagen;
   
   public ManejoImagenes(String id){
   this.id = id;
   }
   
   //Solo usado localmente
   public ManejoImagenes(String id, String NombreImagen){
   this.id = id;
   this.NombreImagen = NombreImagen;
   }
   
   public String getID(){
   return this.id;
   }
   
   public void setID(String x){
   this.id = x;
   }
   
   private String getNombreImagen(){
   return this.NombreImagen;
   }
   
   public void setNombreImagen(String imagen){
   this.NombreImagen = imagen;
   }
   
   private String getCarpeta(){
   return this.CarpetaImagenes;
   }
   
   private String getArchivo(){
   return this.ArchivoImagenes;
   }
   
   private String getRutaObjetiva(){
   return this.getCarpeta() + this.getNombreImagen();
   }
   
    
 public static void AgregarImagen(ManejoImagenes data){
    File archivo = new File(data.getArchivo());
    
    //Buscamos abrir el archivo al final
    try(PrintWriter salida = new PrintWriter(new FileWriter(archivo, true))){
        
        //usamos el archivo
        salida.println(data.getID().trim());
        salida.println(data.getNombreImagen().trim());
        salida.println();
        
    } catch (IOException ex) {
        System.getLogger(ManejoImagenes.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
    }
}
 
 /*Se encarga de cargar la ruta de la imagen del usuario para su posterior validación
 debe tener precargado el ID/cedula del usuario
 */
 
public static void CargarData(ManejoImagenes data){

 File archivo = new File(data.getArchivo());
 
    //Intentamos abrir el archivo
    try(BufferedReader entrada = new BufferedReader(new FileReader(archivo))){
        
        //Si se abre el archivo lo usamos
        String cedulaBuscada = data.getID();
        String lectura , NameI;
    
     while((lectura = entrada.readLine()) != null){
         
         /*Si la cedula del usuario existe en el archivo
         de imagenes cargo la ruta de la imagen del usuario*/
           if(lectura.equals(cedulaBuscada)){
                NameI = entrada.readLine();
                data.setNombreImagen(NameI);
                return;
           }
           
           /*Este bucles es para saltar campos como la ruta del archivo
           (En caso de no ser el buscado) y el espacio separador entre
           los usuarios
           */ 
           for(int i = 0 ; i < 2 ; i++){
            entrada.readLine();
           }
     }  
    }
    catch(IOException | NumberFormatException ex){
        System.err.println("Error en procesamiento: " + ex.getMessage());
    }
}

//---------------------------VALIDAR IMAGENES IGUALES----------------------------------

 /*
 Esta funcion se encarga de verificar que las imagenes son exactamente iguales
 */
  public static boolean sonIguales(File archivo1, File archivo2) throws IOException {
        // Cargamos las imágenes
        BufferedImage imgA = ImageIO.read(archivo1);
        BufferedImage imgB = ImageIO.read(archivo2);

        //Si son de diferente tamaño no es la misma foto directamente
        if (imgA.getWidth() != imgB.getWidth() || imgA.getHeight() != imgB.getHeight()) {
            return false;
        }

        //Comparamos con RGB pixel a pixel
        int width = imgA.getWidth();
        int height = imgA.getHeight();

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                
                //Si algun RGB no coincide no son la misma imagen
                if (imgA.getRGB(x, y) != imgB.getRGB(x, y)) {
                    return false; 
                }
            }
        }

        return true; // Si llegó aquí, son exactamente iguales
    }
  
 //-----------------------------CARGAR IMAGEN----------------------------------------------
  
public static String cargarImagen(){

        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Seleccione la imagen del usuario");
        
        // Filtro para que solo se vean imagenes del formato solicitado
        FileNameExtensionFilter filtro = new FileNameExtensionFilter("Imágenes (png, jpeg, PNG, JPEG)", 
                "png", "jpeg","PNG","JPEG");
        fileChooser.setFileFilter(filtro);

        //Mostramos el selector de archivos
        int seleccion = fileChooser.showOpenDialog(null);

        if (seleccion == JFileChooser.APPROVE_OPTION) {   
            File archivoOriginal = fileChooser.getSelectedFile();
            
            //Verificamos que la extension del archivo en valida
             boolean validExtension = (archivoOriginal.getName().contains("png")  || 
                    archivoOriginal.getName().contains("PNG") ||
                    archivoOriginal.getName().contains("jpeg")||
                    archivoOriginal.getName().contains("JPEG"));
        
                if(validExtension){
                    return archivoOriginal.getAbsolutePath();
                }else{
                    JOptionPane.showMessageDialog(null,"Debes agregar un archivo con extension PNG o JPEG");
                }
        }
        return null;
}
/*
Esta funcion se usa en una interfaz de usuario para que pueda agregar una imagen
de forma opcional para posteriormente poder acceder al servicio del comedor
por reconocimiento facial
*/

//------------------------------VERIFICAR SI EL USUARIO EXISTE EN DB-------------------------
/*Busca en el archivo la cedula de la usuario para enviar una alerta en caso de que ya contenga una
foto de esta forma se evita que el usuario este repetido
*/

public static boolean userExist(String ID) throws FileNotFoundException, IOException{
    ManejoImagenes data = new ManejoImagenes(ID);
    File archivo = new File(data.getArchivo());
    try(BufferedReader entrada = new BufferedReader( new FileReader(archivo))){
        String lectura;
        
        //Aqui no me importa la cantidad de datos que lea solo si la cedula ya esta en el archivo
            while((lectura = entrada.readLine()) != null){
                if(lectura.equals(ID)){
                    return true;
                }
            }
    }
    catch(FileNotFoundException ex){
             //Si no se puede abrir imprimo error
            ex.printStackTrace(System.out);
    }
    
return false;
}
//------------------------CREA EL NUEVO NOMBRE DE LA IMAGEN CARGADA POR PRIMERA VEZ--------------------------
public static String CrearNombreImagen(String ID, String nombreOriginal){
    if(nombreOriginal.contains("jpeg")){
        return ID + ".jpeg";
    }else if(nombreOriginal.contains("png")){
        return ID + ".png";
    }else if(nombreOriginal.contains("JPEG")){
        return ID + ".JPEG";
    }else if(nombreOriginal.contains("PNG")){
        return ID + ".PNG";
    }   
       return null;
}

  
    //---------------------------AGREGAR IMAGEN--------------------------------------------
 public static void cargarYCopiarImagen(String Cedula) throws IOException {
     //Si el usuario ya tiene una foto cargada no se le permite cargarla nuevamente
    if(userExist(Cedula)){
        JOptionPane.showMessageDialog(null,"Ya tienes una imagen cargada en el sistema");
    }else{ 
        //Crear y configurar el selector de archivos
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Seleccione la imagen del usuario");

        // Filtro para que solo se vean imagenes del formato solicitado
        FileNameExtensionFilter filtro = new FileNameExtensionFilter("Imágenes (png, PNG, jpeg, JPEG)", "png", 
                "jpeg","PNG","JPEG");
        fileChooser.setFileFilter(filtro);

        //Mostramos el selector de archivos
        int seleccion = fileChooser.showOpenDialog(null);

        if (seleccion == JFileChooser.APPROVE_OPTION) {
           File archivoOriginal = fileChooser.getSelectedFile();
           
           //Verificamos que la extension del archivo en valida
           boolean validExtension = (archivoOriginal.getName().contains("png")  || 
                    archivoOriginal.getName().contains("PNG") ||
                    archivoOriginal.getName().contains("jpeg")||
                    archivoOriginal.getName().contains("JPEG"));
           
           //Si es valida la extension prosigue con el codigo de lo contrario envia una alerta y no se hace nada
           if(validExtension){
               
               //Cambiamos el nombre a la cedula del usuario para un mejor orden en la DB
                String nombreOriginal = archivoOriginal.getName();
                String nombreArchivo = CrearNombreImagen(Cedula,nombreOriginal);

                //Creo mi objeto de mi clase manejadora de archivos
                ManejoImagenes data = new ManejoImagenes(Cedula.trim(),nombreArchivo.trim());

                try {

                    // Crear el archivo de datos y la carpeta de destino si no existe
                    File directorio = new File(data.getCarpeta());
                    File Imagenes = new File(data.getArchivo());

                    //Si no existe el directorio lo crea
                    if (!directorio.exists()) {
                        directorio.mkdirs();
                    }
                   
                    //Si no existe el archivo de las imagenes se crea
                        // intenta crear el archivo
                        if(!Imagenes.exists()){
                            try (PrintWriter salida = new PrintWriter(Imagenes)) {
                               System.out.print("Se creo el archivo" + nombreArchivo);
                           }catch (FileNotFoundException ex){

                               //Si no se puede abrir imprimo error
                               ex.printStackTrace(System.out);
                           }  
                        }

                    //Se establecen las  rutas de origen y destino del archivo tipo imagen
                    Path origen = Paths.get(archivoOriginal.getAbsolutePath());
                    Path destino = Paths.get(data.getCarpeta() + nombreArchivo);

                    //Copiar el archivo (reemplaza si ya existe uno con el mismo nombre)
                    Files.copy(origen, destino, StandardCopyOption.REPLACE_EXISTING);
                    System.out.println("Imagen copiada exitosamente a: " + destino.toString());

                   //Agregamos la imagen asociada al usuario a su archivo correspondiente
                   AgregarImagen(data);              
                   //Se agrego la imagen correctamente
                }catch (IOException e) {
                    System.err.println("Error al copiar la imagen: " + e.getMessage());
                }     
            }else{
               JOptionPane.showMessageDialog(null,"Debes agregar un archivo con extension PNG o JPEG");
           }
           
    }
}
 //No se agrego la imagen;
 }
 //----------------------------AUTENTICAR----------------------------------------------------------------------------

 public static int AutenticacionFacial(String cedula, String RutaAbsolutaImagen) throws IOException{
     ManejoImagenes data = new ManejoImagenes(cedula);
     //Precargamos la cedula para que CargarData pueda funcionar
     CargarData(data);
     
       //Si existe una imagen del usuario en la DataBase 
     if(data.getNombreImagen() != null){
         if(RutaAbsolutaImagen != null){
             File archivoSeleccionado = new File(RutaAbsolutaImagen);
             
              //Creo el archivo de mi dataBase para verificar
            File archivoSecretaria = new File(data.getRutaObjetiva());
            
            //Si retorna 1 es porque son iguales de lo contrario no lo son
            return sonIguales(archivoSeleccionado,archivoSecretaria) ? 1 : 0;           
         }else{
            return 3;//Este valor representa que no se agrego ninguna imagen
         }
         
    }else{
       return 2; // Este valor de retorno indica que el usuario no tiene cargada una foto en database
    }
}
 
 public static int cargarUsuarioImagen(String cedula, Usuario nuevo) {
     Datos dato = new Datos();
    File archivo = new File(dato.getUsers());
    if (!archivo.exists()) return 0;

    try (BufferedReader entrada = new BufferedReader(new FileReader(archivo))) {
        String r_cedula;
        
        while ((r_cedula = entrada.readLine()) != null) {
            
            String r_clave = entrada.readLine();
                   
            if (r_cedula.equals(cedula)) {
                
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

                // Retornamos rol según el campo estado
                return (nuevo.getTipo().equals("Administrador")) ? 2 : 1;

            } else {
         
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
 
}
