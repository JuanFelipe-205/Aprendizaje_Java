package platzi.play.contenido;

import java.time.LocalDate;
import java.util.Date;

public class Pelicula {

    /// El valor por refencia de estos datos es NULL, 0, false.
    private String titulo;
    private int duracion;
    private String genero;
    private LocalDate fechaEstreno;
    private double calificacion;
    private boolean disponible;

    /// Constructores
    public Pelicula(String titulo, int duracion, String genero) {
        this.titulo = titulo;
        this.duracion = duracion;
        this.genero = genero;
        this.fechaEstreno = LocalDate.now();
        this.disponible = true;
    }

    public Pelicula(String titulo, int duracion, String genero, double calificacion) {
        this(titulo, duracion, genero);
       this.calificar(calificacion);
    }

    /// Metodos
    public void reporducir(){
        System.out.println("Reproduciendo ... "+ titulo);
    }

    public String obtenerFichaTecnica(){
        return titulo + " (" + fechaEstreno.getYear() + ") " +
                "\nGenero: " + genero +
                "\nDuracion: " + duracion +
                "\nCalficacion: " + cantidadEstrellas(this.calificacion);
    }

    public void calificar(double calificacion){
        if (calificacion >= 0 && calificacion <=5){
            /// Cambia el valor de Calificaion de la clase Pelicula.Java
            /// Se usa this, debido a que tiene el mismo nombre de entrada y de atributo
            this.calificacion  = calificacion;
        }
    }

    public String cantidadEstrellas(double calificacion){
        /// Casteo de Double a Int
        int estrellas = (int) calificacion;
        ///  Casteo de Int a String
        String mensaje = String.valueOf(estrellas) + " estrellas";

        return mensaje;
    }

    public boolean esPopular(){
        return calificacion >= 4;
    }

    ///  Get y Set
    public String getTitulo() {
        return titulo;
    }

    public int getDuracion() {
        return duracion;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public LocalDate getFechaEstreno() {
        return fechaEstreno;
    }

    public void setFechaEstreno(LocalDate fechaEstreno) {
        this.fechaEstreno = fechaEstreno;
    }

    public double getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(double calificacion) {
        this.calificacion = calificacion;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }
}
