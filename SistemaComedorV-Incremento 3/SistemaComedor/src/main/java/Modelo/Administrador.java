
package Modelo;

import java.util.ArrayList;
import java.util.List;

public class Administrador {
    Usuario usuarioAdmin;
    CCB costos;
    Datos datos;
    
    
    public Administrador(Usuario usuario){
     this.usuarioAdmin = usuario;
     this.costos = new CCB(0, 0, 0.3f); 
     this.datos = new Datos(); 
             
    }
    
    public CCB getCostos(){
        return this.costos;
    }
    public Datos getDatos(){
        return this.datos;
    }
    public Usuario getUser(){
        return this.usuarioAdmin;
    }
   
}
