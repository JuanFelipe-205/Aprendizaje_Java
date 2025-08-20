package platzi.play;

import platzi.play.contenido.Pelicula;
import platzi.play.plataforma.Plataforma;
import platzi.play.plataforma.Usuario;
import platzi.play.util.ScannerUtils;

import java.time.LocalDate;


public class Main {

    public static final String NOMBRE_PLATAFORMA = "PLATZY PLAY ";
    public static final String VERSION = "1.0.0 ";

    public static void main(String[] args) {

        Plataforma plataforma = new Plataforma(NOMBRE_PLATAFORMA);
        System.out.println(NOMBRE_PLATAFORMA + " v" + VERSION);

        /// Pelicula:
        String nombre = ScannerUtils.textoString("Nombre de la pelicula");
        String genero = ScannerUtils.textoString("Tipo de genero");
        int duracion = ScannerUtils.textoInt("Duracion");
        double calificacion = (ScannerUtils.textoDouble("Calificacion"));

        Pelicula pelicula = new Pelicula(nombre, duracion, genero, calificacion);
        Pelicula pelicula2 = new Pelicula("Harry Potter", 200, "Fisicion", 4.8);

        /// Plataforma:
        plataforma.agregar(pelicula);
        plataforma.agregar(pelicula2);

        /// Usuario:
        LocalDate fechaNacimiento = LocalDate.of(2005, 12, 15);
        Usuario usuario = new Usuario("Juan", "Vargas", 19, "M", fechaNacimiento);

        System.out.println("\nPeliculas disponibles: ");
        plataforma.mostrarTitulos();

        System.out.println("\nInformacion de usuario:");
        usuario.infomracionUsuario();

        System.out.println("\nFicha tecnica de la pelicula: ");
        System.out.println(pelicula.obtenerFichaTecnica());

    }
}
