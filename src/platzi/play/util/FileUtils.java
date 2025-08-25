package platzi.play.util;

import platzi.play.contenido.Contenido;
import platzi.play.contenido.Enums.Calidad;
import platzi.play.contenido.Enums.Genero;
import platzi.play.contenido.Enums.Idioma;

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
        try {
            Files.writeString(
                    Paths.get(NOMBRE_ARCHIVO),
                    lineas + System.lineSeparator(),
                    StandardOpenOption.CREATE,
                    StandardOpenOption.APPEND
            );
            System.out.println(lineas);
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

                if (datos.length == 7) {

                    String nombre = datos[0];
                    int duracion = Integer.parseInt(datos[1]);
                    Genero genero = Genero.valueOf(datos[2].toUpperCase());
                    Idioma idioma = Idioma.valueOf(datos[3].toUpperCase());
                    Calidad calidad = Calidad.valueOf(datos[4].toUpperCase());
                    LocalDate fechaEstreno = LocalDate.parse(datos[5]);
                    double calificacion = datos[6].isBlank() ? 0 : Double.parseDouble(datos[6]);

                    Contenido contenido = new Contenido(nombre, duracion, genero, idioma, calidad, calificacion);
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
