package javaconsoleapp;

import java.util.Scanner;

public class JavaConsoleApp {

    public static void main(String[] args) {       
       System.out.println("Tipo \t Rango");   
       System.out.println("----------------------------");   
       System.out.println("Int \t " + "[" + Integer.MIN_VALUE + "," + Integer.MAX_VALUE + "]");
       System.out.println("Long \t " + "[" + Long.MIN_VALUE + "," + Long.MAX_VALUE + "]");
       System.out.println("Float \t " + "[" + Float.MIN_VALUE + "," + Float.MAX_VALUE + "]");
       System.out.println("Double \t " + "[" + Double.MIN_VALUE + "," + Double.MAX_VALUE + "]");
       System.out.println();    
       System.out.println("Tipo \t Bits");    
       System.out.println("----------------------------");   
       System.out.println("Int \t " + Integer.SIZE);
       System.out.println("Long \t " + Long.SIZE);
    }
    
}
