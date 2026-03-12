package Modelo;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CCBTest {

    @Test
    public void testCalcularCCBEstudiante() {
        // Configuramos costos: Fijos=100, Variables=50, Merma=0.3 (30%)
        CCB costos = new CCB(100, 50, 0.3f); 
        Plato plato = new Plato();
        plato.setCantidad(1); // 1 plato para evitar división por cero
        
        // Según tu fórmula en CCB.java: base = ((100+50)/1) * (1+0.3) = 195
        // Tarifa Estudiante = base * 0.3 = 58.5
        float resultado = CCB.calcularCCB(costos, plato, "Estudiante");
        
        // Verificamos que el cálculo sea exactamente 58.5
        assertEquals(58.5f, resultado, 0.01, "El cálculo para estudiante es incorrecto");
    }

    @Test
    public void testCalcularCCBProfesor() {
        CCB costos = new CCB(100, 50, 0.3f); 
        Plato plato = new Plato();
        plato.setCantidad(1); 
        
        // Tarifa Profesor = base * 0.7 = 195 * 0.7 = 136.5
        float resultado = CCB.calcularCCB(costos, plato, "Profesor");
        assertEquals(136.5f, resultado, 0.01, "El cálculo para profesor es incorrecto");
    }
}