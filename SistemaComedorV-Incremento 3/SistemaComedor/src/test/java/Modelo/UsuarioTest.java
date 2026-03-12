package Modelo;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class UsuarioTest {

    @Test
    public void testRecargarMonedero() {
        // Creamos un usuario de prueba
        Usuario user = new Usuario();
        user.setMonedero(15.0f); // Saldo inicial de 15$
        
        // Simulamos la recarga que haría la interfaz (ej. recarga 20.5$)
        float montoARecargar = 20.5f;
        user.setMonedero(user.getMonedero() + montoARecargar);
        
        // Verificamos que la suma sea correcta (15 + 20.5 = 35.5)
        assertEquals(35.5f, user.getMonedero(), 0.01, "El monedero no sumó correctamente");
    }
}