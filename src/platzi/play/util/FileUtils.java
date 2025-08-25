package platzi.play.util;

import platzi.play.contenido.Contenido;
import platzi.play.contenido.Documental;
import platzi.play.contenido.Enums.Calidad;
import platzi.play.contenido.Enums.Genero;
import platzi.play.contenido.Enums.Idioma;
import platzi.play.contenido.Pelicula;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class FileUtils {

    public static final String NOMBRE_ARCHIVO = "contenido.txt";
    public static final String SEPARADOR = "|";

    public static void escribirContenido(Contenido contenido){
        String lineas = String.join(SEPARADOR,
                contenido.getTitulo(),
                String.valueOf(contenido.getDuracion()),
                contenido.getGenero().name(),
                contenido.getIdioma().name(),
                contenido.getCalidad().name(),
                String.valueOf(contenido.getFechaEstreno()),
                String.valueOf(contenido.getCalificacion())
        );

        String lineaFinal;

        if (contenido instanceof Documental documental){
            lineaFinal = "DOCUMENTAL" + SEPARADOR + lineas + documental.getNarrador();

        }else{
            lineaFinal = "PELICULA" + SEPARADOR + lineas;

        }

        try {
            Files.writeString(
                    Paths.get(NOMBRE_ARCHIVO),
                    lineaFinal + System.lineSeparator(),
                    StandardOpenOption.CREATE,
                    StandardOpenOption.APPEND
            );
            System.out.println("Proceso exitoso !!!");

        }catch (IOException e){
            System.out.println("Error escribiendo el archivo " + e.getMessage());
        }
    }

    public static List<Contenido> leerContenido(){
        List<Contenido> contenidoPlataforma = new ArrayList<>();

        try {
            List<String> lineas = Files.readAllLines(Paths.get(NOMBRE_ARCHIVO));

            lineas.forEach(linea -> {
                String[] datos = linea.split("\\" + SEPARADOR);

                String tipoContenido = datos[0];

                if (("PELICULA".equals(tipoContenido) && datos.length == 8) || ("DOCUMENTAL".equals(tipoContenido) && datos.length == 9)) {

                    String nombre = datos[1];
                    int duracion = Integer.parseInt(datos[2]);
                    Genero genero = Genero.valueOf(datos[3].toUpperCase());
                    Idioma idioma = Idioma.valueOf(datos[4].toUpperCase());
                    Calidad calidad = Calidad.valueOf(datos[5].toUpperCase());
                    LocalDate fechaEstreno = LocalDate.parse(datos[6]);
                    double calificacion = datos[7].isBlank() ? 0 : Double.parseDouble(datos[7]);

                    Contenido contenido;

                    if (tipoContenido.equals("PELICULA")){
                        contenido = new Pelicula(nombre, duracion, genero, idioma, calidad, calificacion);

                    }else{
                        String narrador = datos[8];
                        contenido = new Documental(nombre, duracion, genero, idioma, calidad, calificacion, narrador);
                    }

                    contenido.setFechaEstreno(fechaEstreno);

                    contenidoPlataforma.add(contenido);
                }
            });
        } catch (IOException e) {
            System.out.println("Error al leer el archivo" + e.getMessage());
        }

        return contenidoPlataforma;
    }
}
