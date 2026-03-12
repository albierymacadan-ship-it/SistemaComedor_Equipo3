package Modelo;

//Clase para llevar registro de los reservados
public class listaReservaciones {
   String Tipo;
   public int cantidad;
   
   //Constructor
   public listaReservaciones(){}
      
   public void setTipo(String a){
       this.Tipo = a;
   }
   
   public String getTipo(){
       return this.Tipo;
   }
   
}