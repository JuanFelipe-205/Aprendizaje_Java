package platzi.play.contenido;

import platzi.play.contenido.Enums.Calidad;
import platzi.play.contenido.Enums.Genero;
import platzi.play.contenido.Enums.Idioma;

public class Documental extends Contenido implements Promocionable{

    /// Atributos propios de la clase
    private String narrador;

    /// Constructores
    public Documental(String titulo, int duracion, Genero genero, Idioma idioma, Calidad calidad) {
        super(titulo, duracion, genero, idioma, calidad);
    }

    public Documental(String titulo, int duracion, Genero genero, Idioma idioma, Calidad calidad, double calificacion, String narrador) {
        super(titulo, duracion, genero, idioma, calidad, calificacion);
        this.narrador = narrador;
    }

    /// Metodos
    @Override
    public void reporducirPelicula() {
        System.out.println("Reproduciendo el documental " + getTitulo() + "\nNarrado por: " + getNarrador() );

    }

    @Override
    public String promocionar() {
        return "¡¡¡Nuevo en platzi play !!!! \nDescubre el documental " + this.getTitulo() + " - narrado por " + this.getNarrador();
    }

    /// GET y SET
    public String getNarrador() {
        return narrador;
    }
    public void setNarrador(String narrador) {
        this.narrador = narrador;
    }


}
