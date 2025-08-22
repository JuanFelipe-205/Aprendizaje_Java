package platzi.play.util;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class ScannerUtils {

    public static Scanner sc = new Scanner(System.in);

    public static String textoString(String mensaje){
        System.out.print(mensaje + ": ");
        return sc.nextLine();
    }

    public static int textoInt(String mensaje){

        while (!sc.hasNextInt()){
            System.out.println("Dato invalido " + mensaje );
            sc.next();
        }

        System.out.print(mensaje + ": ");
        return sc.nextInt();
    }

    public static double textoDouble(String mensaje){

        while (!sc.hasNextDouble()){
            System.out.println("Dato invalido " + mensaje );
            sc.next();
        }

        System.out.print(mensaje + ": ");
        return sc.nextDouble();
    }
}
