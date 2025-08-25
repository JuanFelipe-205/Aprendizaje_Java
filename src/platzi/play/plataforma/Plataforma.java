package platzi.play.plataforma;

import platzi.play.contenido.Contenido;
import platzi.play.contenido.Documental;
import platzi.play.contenido.Enums.Genero;
import platzi.play.contenido.Pelicula;
import platzi.play.contenido.Promocionable;
import platzi.play.excepcion.PeliculaExistenteException;
import platzi.play.util.FileUtils;

import java.util.*;
import java.util.stream.Stream;

public class Plataforma {

    /// Atributos
    private String nombre;
    private List<Contenido> contenido;
    private Map<Contenido, Integer> visualizaciones;

    /// Constructor
    public Plataforma(String nombre) {
        this.nombre = nombre;
        this.contenido = new ArrayList<>();
        this.visualizaciones = new HashMap<>();
    }

    /// Metodos
    public void agregar(Contenido elemento){
        Contenido contenido = this.buscarTitulo(elemento.getTitulo());

        if (contenido != null){
            throw new PeliculaExistenteException(elemento.getTitulo());
        }

        FileUtils.escribirContenido(elemento);
        this.contenido.add(elemento);
    }

    public void reproducir(Contenido contenido){
        int conteoActual = visualizaciones.getOrDefault(contenido, 1);
        System.out.println(contenido.getTitulo() + " se ha reproducido: " + conteoActual);

        this.contarVisualizaciones(contenido);
        contenido.reporducirPelicula();
    }

    private void contarVisualizaciones(Contenido contenido) {
        int conteoActual = visualizaciones.getOrDefault(contenido, 1);
        visualizaciones.put(contenido, conteoActual + 1);
    }

    public List<String> getTitulos(){
        return contenido.stream()
                .map(Contenido::getTitulo)
                .toList();
    }

    public void eliminarTitulos(Contenido contenido){
        this.contenido.remove(contenido);
    }

    public Contenido buscarTitulo(String titulo){
        return contenido.stream()
                .filter(pelicula -> pelicula.getTitulo().equalsIgnoreCase(titulo))
                .findFirst()
                .orElse(null);

    }

    public List<Pelicula> getPeliculas(){
        return contenido.stream()
                .filter(contenido -> contenido instanceof Pelicula)
                .map(contenidoFiltrado -> (Pelicula) contenidoFiltrado)
                .toList();
    }

    public List<Promocionable> getContenidoPromocionable(){
        return contenido.stream()
                .filter(contenido -> contenido instanceof Promocionable)
                .map(contenidoProm -> (Promocionable) contenidoProm)
                .toList();
    }

    public List<Documental> getDocumentales(){
        return contenido.stream()
                .filter(contenido -> contenido instanceof Documental)
                .map(contenidoFiltrado -> (Documental) contenidoFiltrado)
                .toList();
    }

    public List<Contenido> buscarGenero(Genero genero){
        return contenido.stream()
                .filter(pelicula -> pelicula.getGenero().equals(genero))
                .toList();
    }

    public int getDuracionTotal(){
        return contenido.stream()
                .mapToInt(Contenido::getDuracion)
                .sum();
    }

    public List<Contenido> getPopulares(int cantidad){
        return contenido.stream()
                .sorted(Comparator.comparing(Contenido::getCalificacion).reversed())
                .limit(cantidad)
                .toList();
    }

    public List<Contenido> getPeliculaPuntacion(int calificacion){
        return contenido.stream()
                .sorted(Comparator.comparing(Contenido::getCalificacion))
                .filter(contenido -> contenido.getCalificacion() == calificacion)
                .toList();
    }

    public List<Contenido> getPeliculaDuracion(int opcion){
        if (opcion == 1 ){
            Optional<Contenido> masLarga = contenido.stream()
                    .max(Comparator.comparing(Contenido::getDuracion));

            return Stream.of(masLarga)
                    .filter(Optional::isPresent)
                    .map(Optional::get)
                    .toList();

        } else if (opcion == 2) {
            Optional<Contenido> masCorta = contenido.stream()
                    .min(Comparator.comparing(Contenido::getDuracion));

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
    public List<Contenido> getcontenido() {
        return contenido;
    }
    public void setcontenido(List<Contenido> contenido) {
        this.contenido = contenido;
    }

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

}
