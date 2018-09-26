package actividad1;

import java.util.Scanner;

public class Actividad1 {

    public static void main(String[] args) {

        /* 
       System.out.println("El SYSTEM_ROOT de windows está ubicado en: \n" + "C:\\Windows\\System32");
       System.out.println("En un lugar de \"La Mancha\" de cuyo nombre no quiero acordarme \n " + "Vivia un \'Hidalgo\'");
       System.out.println("Procesador \t Fabricante \n Pentium \t Intel \n Athlon \t AMD");*/
        System.out.println("a. : " + "El SYSTEM_ROOT de windows está ubicado en: \n" + "     C:\\Windows\\System32 \n\n" + "b. : " + "En un lugar de \"La Mancha\" de cuyo nombre no quiero acordarme \n " + "     Vivia un \'Hidalgo\' \n\n" + "c. : " + "Procesador \t Fabricante \n     Pentium \t\t Intel \n     Athlon \t\t AMD");
        
        System.out.print("\033[H\033[2J");
        System.out.println("hoola");
    }

    public static void _segundoEjercicio() {
        /*Scanner sc = new Scanner(System.in);
        String nombre;        
        do {            
            System.out.println("Introducir un identificador de variable");
            nombre = sc.next();
            if (nombre.startsWith("$") || nombre.startsWith("_") || nombre.startsWith()) {
                
            }
            
        } while (!"salir".equals(nombre));*/
    }

    public static void _primerEjercicio() {
        System.out.println("Hola Mundo");

        System.out.println("Introduzca un número");
        Scanner sc = new Scanner(System.in);
        int numero = sc.nextInt();
        System.out.println("Su número multiplicato por 10 es: " + numero * 10);

        System.out.println("Introduzca tu nombre");
        String nombre = sc.next();
        System.out.println("Bienvenido/a " + nombre);

        System.out.println("Introduzca un número");
        numero = sc.nextInt();
        System.out.println("Introduzca otro número");
        int numero2 = sc.nextInt();
        System.out.println("La suma de los dos números es: " + (numero + numero2));

        System.out.println("Introduzca su año de nacimiento");
        numero = sc.nextInt();
        System.out.println("Introduzca el año actual");
        numero2 = sc.nextInt();
        System.out.println("Ahora usando inteligentia artificial, redes neuronales, calculamos que usted tiene: " + (numero2 - numero));
    }

    public final static void _consoleClear() {
        try {
            final String os = System.getProperty("os.name");

            if (os.contains("Windows")) {
                Runtime.getRuntime().exec("cls");
            } else {
                Runtime.getRuntime().exec("clear");
            }
        } catch (final Exception e) {
            for (int i = 0; i < 50; i++) {                
                System.out.println();                
            }            
        }
    }
}
