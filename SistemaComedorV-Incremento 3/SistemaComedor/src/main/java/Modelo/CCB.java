package Modelo;
import java.io.*;
import java.util.Scanner;

public class CCB {
    private int CostoFijos, CostoVariables;
    private float Merma;
    private final String archivoCostos = "archivos\\costos.txt"; // Ruta del archivo
    
    // Constructor vacío que intenta cargar datos
    public CCB(){
        cargarCostos();
    }

    public CCB(int CostoD, int CostoI, float Merma){
      this.CostoFijos = CostoD;
      this.CostoVariables = CostoI;
      this.Merma = Merma;
    }
    
    
    public int getCF(){ return this.CostoFijos;}
    public int getCV(){ return this.CostoVariables;}
    public float getMM(){ return this.Merma;}
    
    public void setCF(int cf) { this.CostoFijos = cf; }
    public void setCV(int cv) { this.CostoVariables = cv; }
    
    // --- NUEVO: GUARDAR COSTOS EN TXT ---
    public void guardarCostos(int fijos, int variables) {
        this.CostoFijos = fijos;
        this.CostoVariables = variables;
        // La merma la dejamos fija en 0.3 (30%) o la puedes guardar también
        
        try (PrintWriter salida = new PrintWriter(new FileWriter(archivoCostos))) {
            salida.println(fijos);
            salida.println(variables);
            salida.println(this.Merma);
            System.out.println("Costos actualizados correctamente.");
        } catch (IOException ex) {
            System.err.println("Error guardando costos: " + ex.getMessage());
        }
    }

    // --- NUEVO: CARGAR COSTOS DEL TXT ---
    private void cargarCostos() {
        File archivo = new File(archivoCostos);
        if (archivo.exists()) {
            try (Scanner scanner = new Scanner(archivo)) {
                if(scanner.hasNextInt()) this.CostoFijos = scanner.nextInt();
                if(scanner.hasNextInt()) this.CostoVariables = scanner.nextInt();
                if(scanner.hasNextFloat()) this.Merma = scanner.nextFloat();
            } catch (FileNotFoundException ex) {
            }
        } else {
            // Valores por defecto si no existe archivo
            this.CostoFijos = 100;
            this.CostoVariables = 50;
            this.Merma = 0.3f; 
        }
    }
    
    //------------------------EXTRAE LA TARIFA DE UN COMENSAL BECARIO--------------------------------
    public static float getTarifa(String cedula) {
    Datos dato = new Datos();
    File archivo = new File(dato.getBecarios());
    try {
        if (!archivo.exists()) return 0.0f;

        try (Scanner lector = new Scanner(archivo)) {
            while (lector.hasNextLine()) {
                String linea = lector.nextLine();
                String[] partes = linea.split(" ");
                
                // Si la primera parte coincide con la cédula
                if (partes[0].equals(cedula)) {
                    return Float.parseFloat(partes[1]);
                }
            }
        }
    } catch (IOException | NumberFormatException ex) {
        ex.printStackTrace();
    }
        return 0.0f;
}
    //Calculo particual de CCB para los Becarios
    public static float calcularBecarioCCB(CCB C, Plato plato, Usuario actual){
        // Evitar división por cero
        if (plato.getCantidad() == 0) return 0;
        
        //Calculo de la base
        float base = (float) ((( (C.getCF() + C.getCV() )/ plato.getCantidad()) *(1 + C.getMM()) ));
        float tarifa = getTarifa(actual.getCedula());
        
        //Esto es necesario ya que siempre lo almacenamos como un flotante mas no en forma de % al dividirlo 
        //Obtenemos el % de la tarifa
        return base * (tarifa/100);    
    }
    
    public static float calcularCCB(CCB C ,Plato plato, String tipo){
        // Evitar división por cero
        if (plato.getCantidad() == 0) return 0;
        
        float base = (float) ((( (C.getCF() + C.getCV() )/ plato.getCantidad()) *(1 + C.getMM()) ));
        
        if(tipo.equals("Estudiante")){
           return base * 0.3f;
        }
        else if(tipo.equals("Profesor")){
           return base * 0.7f;
        }
        else if(tipo.equals("Empleado")){
           return base * 1.1f;
        }
        else if(tipo.equals("Administrador")){
            return 0; // El admin no paga o paga full, depende de la regla
        }
        return 0;
    }           
}