package platzi.play;

import platzi.play.contenido.Enums.Calidad;
import platzi.play.contenido.Enums.Genero;
import platzi.play.contenido.Enums.Idioma;
import platzi.play.contenido.Pelicula;
import platzi.play.excepcion.PeliculaExistenteException;
import platzi.play.plataforma.Plataforma;
import platzi.play.util.ScannerUtils;

import java.util.List;


public class Main {

    public static final String NOMBRE_PLATAFORMA = "PLATZY PLAY ";
    public static final String VERSION = "1.0.0 ";
    public static final int AGREGAR = 1, ELIMINAR = 2, MOSTRAR = 3, BUSCARPELICULA = 4, REPRODUCIRPELICULA = 5,  VERPOPULARES = 6,  BUSCARGENERO = 7, FILTRARPORPUNTACION = 8, FILTRARPORDURACION = 9, SALIR = 0;

    public static void main(String[] args) {

        Plataforma plataforma = new Plataforma(NOMBRE_PLATAFORMA);
        System.out.println(NOMBRE_PLATAFORMA + " v" + VERSION);

        cargarPeliculas(plataforma);
        System.out.println("Mas de " + plataforma.getDuracionTotal() +" minutos de contenido\n");

        while(true){
            int opcion = ScannerUtils.textoInt(""" 
            Escoja una opcion... 
            1. Agregar elemento    \t6. Mejores Peliculas 
            2. Eliminar contenido  \t7. Filtrar por genero 
            3. Mostrar Peliculas   \t8. Filtrar por calificacion 
            4. Buscar titulo       \t9. Filtrar por duracion
            5. Reproducir pelicula \t0. Salir
            """);

            System.out.println("\nOpcion elegida: " + opcion  +"...");

            switch (opcion) {
                case AGREGAR -> {
                    String nombre = ScannerUtils.textoString("Nombre de la pelicula");
                    Genero genero = ScannerUtils.capturarGenero("Nombre de genero");
                    Idioma idioma = ScannerUtils.capturarIdioma("Idioma");
                    Calidad calidad = ScannerUtils.capturarCalidad("Calidad");
                    int duracion = ScannerUtils.textoInt("Duracion");
                    double calificacion = (ScannerUtils.textoDouble("Calificacion"));

                    try {
                        plataforma.agregar(new Pelicula(nombre,  duracion, genero, idioma, calidad,calificacion ));
                    } catch (PeliculaExistenteException e) {
                        System.out.println(e.getMessage());
                    }

                    plataforma.agregar(new Pelicula(nombre, duracion, genero, idioma, calidad, calificacion));
                }
                case ELIMINAR -> {
                    String Titulo = ScannerUtils.textoString("Nombre de la pelicula");
                    Pelicula pelicula = plataforma.buscarTitulo(Titulo);

                    if (pelicula != null){
                        plataforma.eliminarTitulos(pelicula);
                        System.out.println("Se ha eliminado la pelicula ...");

                    }else{
                        System.out.println("La pelicula no existe ...");
                    }
                }
                case MOSTRAR -> {
                    List<String> titulos = plataforma.getTitulos();
                    titulos.forEach(System.out::println);

                }
                case BUSCARPELICULA -> {
                    String busquedarTitulo = ScannerUtils.textoString("Nombre de la pelicula");
                    Pelicula pelicula = plataforma.buscarTitulo(busquedarTitulo);

                    if (pelicula != null){
                        System.out.println(pelicula.obtenerFichaTecnica());
                    }else{
                        System.out.println("La pelicula no existe ...");
                    }
                }
                case REPRODUCIRPELICULA -> {
                    String peliculaDeseada = ScannerUtils.textoString("Nombre de la pelicula");
                    Pelicula pelicula = plataforma.buscarTitulo(peliculaDeseada);

                    if (pelicula != null){
                        plataforma.reproducir(pelicula);
                    }else {
                        System.out.println("La pelicula " + peliculaDeseada + " no existe");
                    }

                }
                case BUSCARGENERO -> {
                    Genero busqueda = ScannerUtils.capturarGenero("Escoja una opcion: ");

                    List<Pelicula> pelicula = plataforma.buscarGenero(busqueda);
                    System.out.println("Cantidad de peliculas encontradas: " + pelicula.size());
                    pelicula.forEach(titulo -> System.out.println(titulo.obtenerFichaTecnica() + "\n"));
                }
                case VERPOPULARES -> {
                    int cantidad = ScannerUtils.textoInt("Cantidad de peliculas");
                    List<Pelicula> contenidoPopulares = plataforma.getPopulares(cantidad);
                    contenidoPopulares.forEach(contenido -> System.out.println(contenido.obtenerFichaTecnica() + "\n"));
                }
                case FILTRARPORPUNTACION ->{
                    int calificacion = ScannerUtils.textoInt("Calificacion");
                    if (calificacion <= 5 && calificacion >= 1){
                        List<Pelicula> peliculaList = plataforma.getPeliculaPuntacion(calificacion);
                        peliculaList.forEach(pelicula -> System.out.println(pelicula.obtenerFichaTecnica() + "\n"));

                    }else{
                        System.out.println("Calificaicon invalida \nLas peliculas son puntudas de 1 a 5");
                    }
                }
                case FILTRARPORDURACION -> {
                    System.out.println("Escoja una opcion \n1. Pelicula mas larga \n2. Pelicula mas corta");
                    int calificaiconOpcion = ScannerUtils.textoInt("");

                    List<Pelicula> peliculaList = plataforma.getPeliculaDuracion(calificaiconOpcion);
                    peliculaList.forEach(pelicula -> System.out.println(pelicula.obtenerFichaTecnica() + "\n"));

                }
                case SALIR -> System.exit(0);
            };
            System.out.println();
        }
    }

    private static void cargarPeliculas(Plataforma plataforma){
        plataforma.agregar(new Pelicula("Inception", 148, Genero.CIENCIA_FICCICON, Idioma.ESPANOL,  Calidad.ESTANDAR, 2.6));
        plataforma.agregar(new Pelicula("The Godfather", 175, Genero.COMEDIA,  Idioma.INGLES, Calidad.ALTA_DEFINICION,4.0));
        plataforma.agregar(new Pelicula("The Dark Knight", 152, Genero.ACCION,  Idioma.INGLES, Calidad.ALTA_DEFINICION,3.7));
        plataforma.agregar(new Pelicula("Interstellar", 169, Genero.CIENCIA_FICCICON,  Idioma.INGLES, Calidad.ESTANDAR,3.0));
        plataforma.agregar(new Pelicula("Parasite", 132, Genero.DRAMA,  Idioma.FRANCES, Calidad.ESTANDAR,4.0));
        plataforma.agregar(new Pelicula("Forrest Gump", 142, Genero.DRAMA,  Idioma.FRANCES, Calidad.ULTRA_DEFINICION,4.7));
        plataforma.agregar(new Pelicula("The Matrix", 136, Genero.CIENCIA_FICCICON,  Idioma.ESPANOL, Calidad.ULTRA_DEFINICION,4.3));
        plataforma.agregar(new Pelicula("Gladiator", 155, Genero.ACCION,  Idioma.PORTUGUES, Calidad.ULTRA_DEFINICION,2.1));
        plataforma.agregar(new Pelicula("Toy Story", 81, Genero.ANIMADA,  Idioma.ESPANOL, Calidad.ULTRA_DEFINICION,3.9));
        plataforma.agregar(new Pelicula("Titanic", 195, Genero.DRAMA,  Idioma.PORTUGUES, Calidad.ALTA_DEFINICION,4.1));
    }

}
