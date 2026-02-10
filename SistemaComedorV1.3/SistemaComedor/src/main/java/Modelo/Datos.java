package Modelo;
import static Controlador.ArchivosUsuarios.*;


public class Datos{

    private final String users;
    private final String inventario;
    private final String menus;
    
    public Datos(){
    this.users = "archivos\\database.txt";
    this.inventario = "archivos\\inventario.txt";
    this.menus = "archivos\\menus.txt";
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
    
    /**
     *
     * @param args
     */
    public static void main (String[] args){
    crearArchivo("archivos\\database.txt");
}
}

