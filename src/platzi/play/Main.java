package platzi.play;

import platzi.play.contenido.Pelicula;
import platzi.play.plataforma.Usuario;
import platzi.play.util.ScannerUtils;

import java.time.LocalDate;
import java.time.LocalDateTime;


public class Main {

    public static void main(String[] args) {

        System.out.println("PLATZY PLAY ");

        /// Se instansea la clase Pelicula
        Pelicula pelicula = new Pelicula();
        Usuario usuario = new Usuario();

        pelicula.titulo = ScannerUtils.textoString("Nombre de la pelicula");
        pelicula.fechaEstreno = LocalDate.of(2018, 1, 11); /// Para setar valores en los LocalDate se usa .of
        pelicula.genero = ScannerUtils.textoString("Tipo de genero");
        pelicula.calificar(ScannerUtils.textoDouble("Calificacion"));
        pelicula.duracion = ScannerUtils.textoInt("Duracion");

        usuario.nombre = "Juan";
        usuario.apellido = "Vargas";
        usuario.edad = 19;
        usuario.genero = "M";
        usuario.fechaNacimineto = LocalDate.of(2005, 12, 15);
        usuario.fechaRegistro = LocalDateTime.now();

        System.out.println("\nInformacion de usuario:");
        usuario.infomracionUsuario();

        System.out.println("\nPelicula a ver:");
        usuario.ver(pelicula);

        System.out.println("\nFicha tecnica de la pelicula: ");
        System.out.println(pelicula.obtenerFichaTecnica());

    }
}
