package platzi.play.contenido;

import platzi.play.contenido.Enums.Genero;

public record ResumenContenido(
        String titulo,
        int Duracion,
        Genero genero
) {

    /// Esta clase es ideal para los DTO, los cuales sond atos que no tienen validaciones y son inmutables
}
