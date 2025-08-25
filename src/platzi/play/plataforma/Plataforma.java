package platzi.play.plataforma;

import platzi.play.contenido.Enums.Genero;
import platzi.play.contenido.Pelicula;
import platzi.play.excepcion.PeliculaExistenteException;

import java.util.*;
import java.util.stream.Stream;

public class Plataforma {

    /// Atributos
    private String nombre;
    private List<Pelicula> contenido;
    private Map<Pelicula, Integer> visualizaciones;

    /// Constructor
    public Plataforma(String nombre) {
        this.nombre = nombre;
        this.contenido = new ArrayList<>();
        this.visualizaciones = new HashMap<>();
    }

    /// Metodos
    public void agregar(Pelicula elemento){
        Pelicula pelicula = this.buscarTitulo(elemento.getTitulo());

        if (pelicula != null){
            throw new PeliculaExistenteException(elemento.getTitulo());
        }

        this.contenido.add(elemento);
    }

    public void reproducir(Pelicula contenido){
        int conteoActual = visualizaciones.getOrDefault(contenido, 1);
        System.out.println(contenido.getTitulo() + " se ha reproducido: " + conteoActual);

        this.contarVisualizaciones(contenido);
        contenido.reporducirPelicula();
    }

    private void contarVisualizaciones(Pelicula contenido) {
        int conteoActual = visualizaciones.getOrDefault(contenido, 1);
        visualizaciones.put(contenido, conteoActual + 1);
    }

    public List<String> getTitulos(){
        return contenido.stream()
                .map(Pelicula::getTitulo)
                .toList();
    }

    public void eliminarTitulos(Pelicula pelicula){
        this.contenido.remove(pelicula);
    }

    public Pelicula buscarTitulo(String titulo){
        return contenido.stream()
                .filter(pelicula -> pelicula.getTitulo().equalsIgnoreCase(titulo))
                .findFirst()
                .orElse(null);

    }

    public List<Pelicula> buscarGenero(Genero genero){
        return contenido.stream()
                .filter(pelicula -> pelicula.getGenero().equals(genero))
                .toList();
    }

    public int getDuracionTotal(){
        return contenido.stream()
                .mapToInt(Pelicula::getDuracion)
                .sum();
    }

    public List<Pelicula> getPopulares(int cantidad){
        return contenido.stream()
                .sorted(Comparator.comparing(Pelicula::getCalificacion).reversed())
                .limit(cantidad)
                .toList();
    }

    public List<Pelicula> getPeliculaPuntacion(int calificacion){
        return contenido.stream()
                .sorted(Comparator.comparing(Pelicula::getCalificacion))
                .filter(contenido -> contenido.getCalificacion() == calificacion)
                .toList();
    }

    public List<Pelicula> getPeliculaDuracion(int opcion){
        if (opcion == 1 ){
            Optional<Pelicula> masLarga = contenido.stream()
                    .max(Comparator.comparing(Pelicula::getDuracion));

            return Stream.of(masLarga)
                    .filter(Optional::isPresent)
                    .map(Optional::get)
                    .toList();

        } else if (opcion == 2) {
            Optional<Pelicula> masCorta = contenido.stream()
                    .min(Comparator.comparing(Pelicula::getDuracion));

            return Stream.of(masCorta)
                    .filter(Optional::isPresent)
                    .map(Optional::get)
                    .toList();

        } else {
            System.out.println("Opcion invalida ... ");
            return List.of();
        }

    }

    /// GET y SET
    public List<Pelicula> getcontenido() {
        return contenido;
    }
    public void setcontenido(List<Pelicula> contenido) {
        this.contenido = contenido;
    }

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

}
