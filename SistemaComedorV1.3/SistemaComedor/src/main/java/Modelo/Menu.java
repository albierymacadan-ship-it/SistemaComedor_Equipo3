
package Modelo;

import java.util.ArrayList;
import java.util.List;

public class Menu {
   public List<Plato> platos;
   public CCB costo;
   public Datos dato;
   
   public Menu(){
   platos = new ArrayList<>();
   dato = new Datos();
   costo = new CCB(100,50,(float)0.3);
   }     
}
