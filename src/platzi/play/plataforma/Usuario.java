package platzi.play.plataforma;

import platzi.play.contenido.Pelicula;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Usuario {

    public String nombre;
    public String apellido;
    public int edad;
    public String genero;
    public LocalDateTime fechaRegistro;
    public LocalDate fechaNacimineto;

    public void ver(Pelicula pelicula){
        System.out.println(nombreCompleto());
        pelicula.reporducir();
        System.out.println();
    }

    public String nombreCompleto(){
        return this.nombre + " " + this.apellido;
    }

    public void infomracionUsuario(){
        System.out.println(
                "Nombre: " + this.nombre +
                "\nApellido: " + this.apellido +
                "\nEdad: " + this.edad +
                "\nGenero: " + this.genero +
                "\nFecha registro: " + fechaRegistro.getYear() + " / " + fechaRegistro.getMonth() +
                "\nFecha nacimiento:" + fechaNacimineto.getYear() + " / "  + fechaNacimineto.getMonth() + " / " + fechaNacimineto.getDayOfMonth()
        );
    }
}
