package platzi.play;

import platzi.play.contenido.Contenido;
import platzi.play.contenido.Documental;
import platzi.play.contenido.Enums.Calidad;
import platzi.play.contenido.Enums.Genero;
import platzi.play.contenido.Enums.Idioma;
import platzi.play.contenido.Pelicula;
import platzi.play.excepcion.PeliculaExistenteException;
import platzi.play.plataforma.Plataforma;
import platzi.play.util.FileUtils;
import platzi.play.util.ScannerUtils;

import java.util.List;


public class Main {

    public static final String NOMBRE_PLATAFORMA = "PLATZY PLAY ";
    public static final String VERSION = "1.0.0 ";
    public static final int AGREGAR = 1;
    public static final int ELIMINAR = 2;
    public static final int MOSTRAR = 3;
    public static final int BUSCARPELICULA = 4;
    public static final int REPRODUCIRPELICULA = 5;
    public static final int VERPOPULARES = 6;
    public static final int BUSCARGENERO = 7;
    public static final int FILTRARPORPUNTACION = 8;
    public static final int FILTRARPORDURACION = 9;
    public static final int SALIR = 0;

    public static void main(String[] args) {

        Plataforma plataforma = new Plataforma(NOMBRE_PLATAFORMA);
        System.out.println(NOMBRE_PLATAFORMA + " v" + VERSION);

        cargarPeliculas(plataforma);
        System.out.println("Mas de " + plataforma.getDuracionTotal() +" minutos de contenido\n");

        while(true){
            int opcion = ScannerUtils.textoInt(""" 
            Escoja una opcion... 
            1. Agregar elemento     \t6. Mejores Peliculas 
            2. Eliminar contenido   \t7. Filtrar por genero 
            3. Mostrar contenido    \t8. Filtrar por calificacion 
            4. Buscar titulo        \t9. Filtrar por duracion
            5. Reproducir contenido \t0. Salir
            """);

            System.out.println("\nOpcion elegida: " + opcion  +"...");

            switch (opcion) {
                case AGREGAR -> {
                    int tipoContenido = ScannerUtils.textoInt("Que tipo que contenido quiere agregar ? \n1. Pelicula \t2.Documental \n");
                    String nombre = ScannerUtils.textoString("Nombre de la contenido");
                    Genero genero = ScannerUtils.capturarGenero("Nombre de genero");
                    Idioma idioma = ScannerUtils.capturarIdioma("Idioma");
                    Calidad calidad = ScannerUtils.capturarCalidad("Calidad");
                    int duracion = ScannerUtils.textoInt("Duracion");
                    double calificacion = (ScannerUtils.textoDouble("Calificacion"));

                    try {
                        if (tipoContenido == 1){
                            plataforma.agregar(new Pelicula(nombre,  duracion, genero, idioma, calidad,calificacion));
                        }else{
                            String narrador = ScannerUtils.textoString("Nombre del narrador");
                            plataforma.agregar(new Documental(nombre,  duracion, genero, idioma, calidad,calificacion, narrador));
                        }

                    } catch (PeliculaExistenteException e) {
                        System.out.println(e.getMessage());
                    }
                }
                case ELIMINAR -> {
                    String Titulo = ScannerUtils.textoString("Nombre de la contenido");
                    Contenido contenido = plataforma.buscarTitulo(Titulo);

                    if (contenido != null){
                        plataforma.eliminarTitulos(contenido);
                        System.out.println("Se ha eliminado la contenido ...");

                    }else{
                        System.out.println("La contenido no existe ...");
                    }
                }
                case MOSTRAR -> {
                    List<String> titulos = plataforma.getTitulos();
                    titulos.forEach(System.out::println);

                }
                case BUSCARPELICULA -> {
                    String busquedarTitulo = ScannerUtils.textoString("Nombre de la contenido");
                    Contenido contenido = plataforma.buscarTitulo(busquedarTitulo);

                    if (contenido != null){
                        System.out.println(contenido.obtenerFichaTecnica());
                    }else{
                        System.out.println("La contenido no existe ...");
                    }
                }
                case REPRODUCIRPELICULA -> {
                    String peliculaDeseada = ScannerUtils.textoString("Nombre de la contenido");
                    Contenido contenido = plataforma.buscarTitulo(peliculaDeseada);

                    if (contenido != null){
                        plataforma.reproducir(contenido);
                    }else {
                        System.out.println("La contenido " + peliculaDeseada + " no existe");
                    }

                }
                case BUSCARGENERO -> {
                    Genero busqueda = ScannerUtils.capturarGenero("Escoja una opcion: ");

                    List<Contenido> contenido = plataforma.buscarGenero(busqueda);
                    System.out.println("Cantidad de peliculas encontradas: " + contenido.size());
                    contenido.forEach(titulo -> System.out.println(titulo.obtenerFichaTecnica() + "\n"));
                }
                case VERPOPULARES -> {
                    int cantidad = ScannerUtils.textoInt("Cantidad de peliculas");
                    List<Contenido> contenidoPopulares = plataforma.getPopulares(cantidad);
                    contenidoPopulares.forEach(contenido -> System.out.println(contenido.obtenerFichaTecnica() + "\n"));
                }
                case FILTRARPORPUNTACION ->{
                    int calificacion = ScannerUtils.textoInt("Calificacion");
                    if (calificacion <= 5 && calificacion >= 1){
                        List<Contenido> contenidoList = plataforma.getPeliculaPuntacion(calificacion);
                        contenidoList.forEach(contenido -> System.out.println(contenido.obtenerFichaTecnica() + "\n"));

                    }else{
                        System.out.println("Calificaicon invalida \nLas peliculas son puntudas de 1 a 5");
                    }
                }
                case FILTRARPORDURACION -> {
                    System.out.println("Escoja una opcion \n1. Contenido mas larga \n2. Contenido mas corta");
                    int calificaiconOpcion = ScannerUtils.textoInt("");

                    List<Contenido> contenidoList = plataforma.getPeliculaDuracion(calificaiconOpcion);
                    contenidoList.forEach(contenido -> System.out.println(contenido.obtenerFichaTecnica() + "\n"));

                }
                case SALIR -> System.exit(0);
            };
            System.out.println();
        }
    }

    private static void cargarPeliculas(Plataforma plataforma) {
        plataforma.getcontenido().addAll(FileUtils.leerContenido());
    }

}
