package platzi.play;

import platzi.play.contenido.Pelicula;
import platzi.play.plataforma.Plataforma;
import platzi.play.plataforma.Usuario;
import platzi.play.util.ScannerUtils;

import java.time.LocalDate;


public class Main {

    public static final String NOMBRE_PLATAFORMA = "PLATZY PLAY ";
    public static final String VERSION = "1.0.0 ";
    public static final int AGREGAR = 1, MOSTRAR = 2, BUSCAR = 3, ELIMINAR = 4, SALIR = 5 ;

    public static void main(String[] args) {

        Plataforma plataforma = new Plataforma(NOMBRE_PLATAFORMA);
        System.out.println(NOMBRE_PLATAFORMA + " v" + VERSION);

        while(true){
            System.out.println("Escoja una opcion: ");
            int opcion = ScannerUtils.textoInt("1. Agregar elemento \n2. Mostrar  \n3. Buscar titulo \n4. Eliminar elemento \n5. Salir");

            System.out.println("Opcion elegida: " + opcion);

            switch (opcion) {
                case AGREGAR : {
                    String nombre = ScannerUtils.textoString("Nombre de la pelicula");
                    String genero = ScannerUtils.textoString("Tipo de genero");
                    int duracion = ScannerUtils.textoInt("Duracion");
                    double calificacion = (ScannerUtils.textoDouble("Calificacion"));

                    plataforma.agregar(new Pelicula(nombre, duracion, genero, calificacion));
                }
                case MOSTRAR : plataforma.mostrarTitulos();
                case BUSCAR : {
                    System.out.println("Pendiente ...");
                }
                case ELIMINAR : System.out.println("Pendiente ....");

                case SALIR : System.exit(0);

            };
            System.out.println();
        }

//        /// Usuario:
//        LocalDate fechaNacimiento = LocalDate.of(2005, 12, 15);
//        Usuario usuario = new Usuario("Juan", "Vargas", 19, "M", fechaNacimiento);
//
//        System.out.println("\nPeliculas disponibles: ");
//        plataforma.mostrarTitulos();
//
//        System.out.println("\nInformacion de usuario:");
//        usuario.infomracionUsuario();
//
//        System.out.println("\nFicha tecnica de la pelicula: ");
//        System.out.println(pelicula.obtenerFichaTecnica());
    }
}
