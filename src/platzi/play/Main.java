package platzi.play;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        System.out.println("PLATZY PLAY ");
        Scanner sc = new Scanner(System.in);

        System.out.println("Cual es tu nombre ?");
        String nombre = sc.nextLine();
        System.out.println("Hola " + nombre + ", esto es Platzi play !!");

        System.out.println("Que edad tienes ?");
        int edad = sc.nextInt();
        System.out.println(nombre + " puedes ver contendio " + edad);

    }
}
