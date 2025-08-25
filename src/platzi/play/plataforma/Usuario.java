package platzi.play.plataforma;

import platzi.play.contenido.Contenido;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Usuario {

    private String nombre;
    private String apellido;
    private int edad;
    private String genero;
    private LocalDateTime fechaRegistro;
    private LocalDate fechaNacimineto;

    /// Constructores
    public Usuario(String nombre, String apellido, int edad, String genero,  LocalDate fechaNacimineto) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.genero = genero;
        this.fechaRegistro = LocalDateTime.now();
        this.fechaNacimineto = fechaNacimineto;
    }

    /// Metodos
    public void ver(Contenido contenido){
        System.out.println(nombreCompleto());
        contenido.reporducirPelicula();
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

    /// Set y Get
    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public int getEdad() {
        return edad;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public LocalDateTime getFechaRegistro() {
        return fechaRegistro;
    }

    public LocalDate getFechaNacimineto() {
        return fechaNacimineto;
    }
}
