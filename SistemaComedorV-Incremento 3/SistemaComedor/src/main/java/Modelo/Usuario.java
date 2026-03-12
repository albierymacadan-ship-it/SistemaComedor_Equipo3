package Modelo;

public class Usuario {
    private String nombre, apellido, correo, password, estado, cedula, tipo;
    private boolean turno;
    private float monedero;
    
    public Usuario(String name, String lastname, String correo,
            String clave, String id , String type ){
    this.nombre = name;
    this.apellido = lastname;
    this.correo = correo;
    this.password = clave;
    this.cedula = id;
    this.tipo = type;
    this.estado = "offline";
    this.turno = false;
    this.monedero = 0;
    }

    public Usuario() {}
    //---------------------------------------------
    // get,set NOMBRE
    public String getNombre(){
    return this.nombre;
    }
   
    public void setNombre(String nombre){
    this.nombre = nombre;
    }
    //---------------------------------------------
     //get,set APELLIDO
    public String getApellido(){
    return this.apellido;
    }
    
    public void setApellido(String apellido){
    this.apellido = apellido;
    }
    //---------------------------------------------
     //get,set Correo
    public String getCorreo(){
    return this.correo;
    }
    
    public void setCorreo(String correo){
    this.correo = correo;
    }
    //---------------------------------------------
    //get,set contraseña servira para restablecerla
    public String getPassword(){
    return this.password;
    }
    
    public void setPassword(String clave){
    this.password = clave;
    }
    //---------------------------------------------
    
     //get,set CEDULA
    public String getCedula(){
    return this.cedula;
    }
    
    public void setCedula(String a){
    this.cedula = a; 
    }
    //---------------------------------------------
    
    //get de TIPO DE USUARIO NO PUEDE SER CAMBIADO
    public String getTipo(){
    return this.tipo;
    }
    
    public void setTipo(String a){
    this.tipo = a;
    }
    //---------------------------------------------
    
    //get,set ESTADO representa el estado del usuario para los administradores online / offline
    public String getEstado(){
    return this.estado;
    }
    
    public void setEstado(String a){
    this.estado = a;
    }
    //---------------------------------------------
    
    //get,set TURNO representa el enlace del usuario al seleccionar el plato
    public boolean getTurno(){
    return this.turno;
    }
    
    public void setTurno(boolean a){
    this.turno = a;
    }
    //---------------------------------------------
    
    //get.set MONEDERO
    
    public float getMonedero(){
    return this.monedero;
    }
    
    public void setMonedero(float nuevoEstadoMonedero){
    this.monedero = nuevoEstadoMonedero;
    }
}
