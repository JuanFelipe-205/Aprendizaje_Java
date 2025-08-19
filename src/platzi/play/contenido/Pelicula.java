package platzi.play.contenido;

import java.time.LocalDate;
import java.util.Date;

public class Pelicula {

    /// El valor por refencia de estos datos es NULL, 0, false.
    public String titulo;
    public String descripcion;
    public int duracion;
    public String genero;
    public LocalDate fechaEstreno;
    public double calificacion;
    public boolean disponible;

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

}
