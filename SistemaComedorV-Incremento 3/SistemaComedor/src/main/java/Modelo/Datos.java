package Modelo;
import static Controlador.ArchivosUsuarios.*;


public class Datos{

    private final String users;
    private final String inventario;
    private final String menus;
    private final String becarios;
    private final String log;
    private final String cantidadComensales;
    
    public Datos(){
    this.users = "archivos\\database.txt";
    this.inventario = "archivos\\inventario.txt";
    this.menus = "archivos\\menus.txt";
    this.becarios = "archivos\\becarios.txt";
    this.log = "archivos\\log.txt";
    this.cantidadComensales = "archivos\\cantidadComensales";
    }
    
    public String getUsers(){
    return this.users;
    }
    
    public String getinventario(){
    return this.inventario;
    }
    
    public String getMenus(){
    return this.menus;
    }
    
    public String getBecarios(){
    return this.becarios;
    }
    
    public String getLog(){
    return this.log;
    }
    
    public String getComensales(){
    return this.cantidadComensales;
    }
    
    public static void main (String[] args){
    crearArchivo("archivos\\database.txt");
}
}

