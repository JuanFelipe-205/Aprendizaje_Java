package platzi.play.excepcion;

/// Extiende la clase "RuntimeException" para crear excepciones
public class PeliculaExistenteException extends RuntimeException{

    public PeliculaExistenteException(String titulo){
        super("El contenido " + titulo + " ya existe");
    }

}
