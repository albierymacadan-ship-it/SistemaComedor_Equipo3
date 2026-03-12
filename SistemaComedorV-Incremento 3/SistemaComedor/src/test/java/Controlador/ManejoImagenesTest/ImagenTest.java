package Controlador.ManejoImagenesTest;

import Controlador.ManejoImagenes;
import Controlador.ManejoImagenes;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.io.File;
import java.io.IOException;

public class ImagenTest {

    @Test
    public void testImagenesIdenticas() throws IOException {
        // Usaremos la misma imagen para comparar contra sí misma
        // Reemplaza '12345678' por una cédula que exista en tu carpeta
        File imagen1 = new File("src/main/resources/UserImages/12345678.jpeg");
        
        if(imagen1.exists()) {
            boolean resultado = ManejoImagenes.sonIguales(imagen1, imagen1);
            assertTrue(resultado, "Una imagen comparada con sigo misma debería ser igual");
        } else {
            System.out.println("Nota: No se encontró la imagen de prueba, el test se saltó.");
        }
    }
}