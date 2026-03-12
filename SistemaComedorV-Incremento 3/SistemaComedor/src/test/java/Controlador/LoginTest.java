package Controlador;

import Modelo.Usuario;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;
import Controlador.ArchivosUsuarios;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.*;


public class LoginTest {

    @Test
    public void testValidarYCargarUsuario_Admin(@TempDir Path tempDir) throws IOException {
        Path file = tempDir.resolve("users.txt");
        String ced = "12345678";
        String pass = "secret";
        String content = ced + System.lineSeparator()
                + pass + System.lineSeparator()
                + "Administrador" + System.lineSeparator()
                + "Juan" + System.lineSeparator()
                + "Perez" + System.lineSeparator()
                + "50.5" + System.lineSeparator()
                + "false" + System.lineSeparator()
                + "activo" + System.lineSeparator()
                + "juan@example.com" + System.lineSeparator()
                + System.lineSeparator();
        Files.write(file, content.getBytes());

        Usuario u = new Usuario();
        int rol = ArchivosUsuarios.validarYCargarUsuario(file.toString(), ced, pass, u);

        assertEquals(2, rol, "Debería retornar rol 2 para Administrador");
        assertEquals(ced, u.getCedula());
        assertEquals(pass, u.getPassword());
        assertEquals("Administrador", u.getTipo());
        assertEquals("Juan", u.getNombre());
        assertEquals("Perez", u.getApellido());
        assertEquals(50.5f, u.getMonedero(), 0.001f);
        assertFalse(u.getTurno());
        assertEquals("activo", u.getEstado());
        assertEquals("juan@example.com", u.getCorreo());
    }

    @Test
    public void testValidarYCargarUsuario_NotFound(@TempDir Path tempDir) throws IOException {
        Path file = tempDir.resolve("users.txt");
        String content = "";
        Files.write(file, content.getBytes());

        Usuario u = new Usuario();
        int rol = ArchivosUsuarios.validarYCargarUsuario(file.toString(), "no", "no", u);

        assertEquals(0, rol, "Debería retornar 0 si no se encuentra el usuario");
    }
}

