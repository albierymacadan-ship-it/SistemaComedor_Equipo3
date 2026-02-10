package Modelo;

public class Plato {
    private String Desayuno, Almuerzo, Postre, DiaSemana, Fecha, id;
    private int cantidad;
    
    // Constructor sin nada
    public Plato(){}
    
    // Contructor con parametros
    public Plato(String dia, String fecha, String desayuno, 
            String almuerzo,String postre, String id, int cant){
    this.DiaSemana = dia;
    this.Fecha = fecha;
    this.Desayuno = desayuno;
    this.Almuerzo = almuerzo;
    this.Postre = postre;
    this.id = id;
    this.cantidad = cant;
    }
    
    // Getters
    public String getDiaSemana() {
        return this.DiaSemana;
    }

    public String getFecha() {
        return this.Fecha;
    }

    public String getDesayuno() {
        return this.Desayuno;
    }
    
    public String getAlmuerzo(){
        return this.Almuerzo;
    }
    
    public String getPostre(){
        return this.Postre;
    }
    
    // --- ESTOS SON LOS QUE IMPORTAN PARA EL ADMIN ---
    public String getID(){
        return this.id;
    }
    
    public void setID(String a){
        this.id = a;
    }
    
    public int getCantidad(){
       return this.cantidad;
    }
    
    public void setCantidad(int a){
        this.cantidad = a;
    }

    // Setters restantes
    public void setDiaSemana(String a){
        this.DiaSemana = a;
    }
    
    public void setFecha(String a){
        this.Fecha = a;
    }
    
    public void setDesayuno(String a){
        this.Desayuno = a;
    }
    
    public void setAlmuerzo(String a){
        this.Almuerzo = a;
    }
    
    public void setPostre(String a){
        this.Postre = a;
    }
}
