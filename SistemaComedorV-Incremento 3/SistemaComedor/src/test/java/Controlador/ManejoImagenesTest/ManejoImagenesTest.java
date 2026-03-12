package Controlador.ManejoImagenesTest; // Asegúrate de que el paquete sea el mismo

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.io.File;

public class ManejoImagenesTest {
    @Test
    public void testRutaCarpetaExiste() {
        File carpeta = new File("src/main/resources/UserImages/");
        assertTrue(carpeta.exists(), "La carpeta de imágenes debe existir en la ruta definida");
    }
}
