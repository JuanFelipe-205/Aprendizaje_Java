package platzi.play.excepcion;

/// Extiende la clase "RuntimeException" para crear excepciones
public class PeliculaExistenteException extends RuntimeException{

    public PeliculaExistenteException(String titulo){
        super("La pelicula " + titulo + " ya existe");
    }

}
