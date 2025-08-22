package platzi.play.plataforma;

import platzi.play.contenido.Pelicula;

import java.util.ArrayList;
import java.util.List;

public class Plataforma {

    private String nombre;
    private List<Pelicula> conteinido;

    public Plataforma(String nombre) {
        this.nombre = nombre;
        this.conteinido = new ArrayList<>();
    }

    public void agregar(Pelicula pelicula){
        this.conteinido.add(pelicula);
    }

    public void mostrarTitulos(){
        for (Pelicula pelicula : conteinido){
            System.out.println(pelicula.getTitulo());
        }
    }

    public void eliminarTitulos(Pelicula pelicula){
        this.conteinido.remove(pelicula);
    }

    public List<Pelicula> getConteinido() {
        return conteinido;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setConteinido(List<Pelicula> conteinido) {
        this.conteinido = conteinido;
    }
}
