package platzi.play.contenido;

import platzi.play.contenido.Enums.Calidad;
import platzi.play.contenido.Enums.Genero;
import platzi.play.contenido.Enums.Idioma;

import java.time.LocalDate;

public abstract class Contenido {

    /// El valor por refencia de estos datos es NULL, 0, false.
    private String titulo;
    private int duracion;
    private Genero genero;
    private Idioma idioma;
    private Calidad calidad;
    private LocalDate fechaEstreno;
    private double calificacion;
    private boolean disponible;

    /// Constructores
    public Contenido(String titulo, int duracion, Genero genero, Idioma idioma, Calidad calidad) {
        this.titulo = titulo;
        this.duracion = duracion;
        this.genero = genero;
        this.idioma = idioma;
        this.calidad = calidad;
        this.fechaEstreno = LocalDate.now();
        this.disponible = true;
    }

    public Contenido(String titulo, int duracion, Genero genero, Idioma idioma, Calidad calidad, double calificacion) {
        this(titulo, duracion, genero, idioma, calidad);
        this.calificar(calificacion);
    }

    /// Metodos
    public abstract void reporducirPelicula();

    public String obtenerFichaTecnica(){
        return titulo + " (" + fechaEstreno.getYear() + ") " +
                "\nGenero: " + genero +
                "\nIdioma:" + idioma +
                "\nCalidad: " + calidad +
                "\nDuracion: " + duracion +
                "\nCalficacion: " + cantidadEstrellas(this.calificacion);
    }

    public void calificar(double calificacion){
        if (calificacion >= 0 && calificacion <=5){
            /// Cambia el valor de Calificaion de la clase Contenido.Java
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

    public Genero getGenero() {
        return genero;
    }
    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    public Idioma getIdioma() {
        return idioma;
    }
    public void setIdioma(Idioma idioma) {
        this.idioma = idioma;
    }

    public Calidad getCalidad() {
        return calidad;
    }
    public void setCalidad(Calidad calidad) {
        this.calidad = calidad;
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
