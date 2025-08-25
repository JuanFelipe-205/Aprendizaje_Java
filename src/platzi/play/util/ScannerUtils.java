package platzi.play.util;

import platzi.play.contenido.Enums.Calidad;
import platzi.play.contenido.Enums.Genero;
import platzi.play.contenido.Enums.Idioma;

import java.util.Scanner;

public class ScannerUtils {

    public static Scanner sc = new Scanner(System.in);

    public static String textoString(String mensaje){
        System.out.println(mensaje + ": ");
        return sc.nextLine();
    }

    public static int textoInt(String mensaje){

        System.out.print(mensaje + ": ");

        while (!sc.hasNextInt()){
            System.out.println("Dato invalido " + mensaje );
            sc.next();
        }

        int dato = sc.nextInt();
        sc.nextLine();
        return dato;
    }

    public static double textoDouble(String mensaje){

        System.out.println(mensaje + ": ");

        while (!sc.hasNextDouble()){
            System.out.println("Dato invalido " + mensaje );
            sc.next();
        }

        double dato = sc.nextDouble();
        sc.nextLine();
        return dato;
    }

    /// Plantear una opcion para juntar "capturarGenero, capturarIdioma, capturarCalidad"
    public static Genero capturarGenero(String mensaje){
        while (true){
            System.out.println(mensaje);
            for (Genero genero: Genero.values()){
                System.out.println("- " + genero.name());
            }

            System.out.print(":");
            String entrada = sc.nextLine();

            try{
                return Genero.valueOf(entrada.toUpperCase());

            } catch (IllegalArgumentException e) {
                System.out.println("Dato no aceptado. \n" + mensaje + ": ");
            }
        }
    }

    public static Idioma capturarIdioma(String mensaje){
        while (true){
            System.out.println(mensaje);
            for (Idioma idioma: Idioma.values()){
                System.out.println("- " + idioma.name());
            }

            System.out.print(":");
            String entrada = sc.nextLine();

            try{
                return Idioma.valueOf(entrada.toUpperCase());

            } catch (IllegalArgumentException e) {
                System.out.println("Dato no aceptado. \n" + mensaje + ": ");
            }
        }
    }

    public static Calidad capturarCalidad(String mensaje){
        while (true){
            System.out.println(mensaje);
            for (Calidad calidad: Calidad.values()){
                System.out.println("- " + calidad.name());
            }

            System.out.print(":");
            String entrada = sc.nextLine();

            try{
                return Calidad.valueOf(entrada.toUpperCase());

            } catch (IllegalArgumentException e) {
                System.out.println("Dato no aceptado. \n" + mensaje + ": ");
            }
        }
    }
}
