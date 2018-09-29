package es.cifpcm.main;

import es.cifpcm.data.Persistence;
import java.util.Scanner;

/**
 *
 * @author Josué Ramírez
 */
public class MisCoches {
    
    private static Persistence pst;
    private static Scanner sc;
    
    public static void main(String[] args) {
        sc = new Scanner(System.in);
        System.out.println(System.getProperty("java.io.tmpdir"));
        pst.Open();
    }
    
    private static void InsertarCoche(){
        
    }
    
    private static void BorrarCoche(){
        
    }
    
    private static void ListarCoches(){
        
    }
    
    private static void GoAdminMenu(){
        PrintAdminMenu();
    }
    
    private static void PrintMainMenu(){
        int option;        
        
        do {           
            System.out.println("======= Mis Coches Rentacar =======");
            System.out.println("-- Échese una siesta mientras buscamos");
            System.out.println("\n");
            System.out.println("1. Busque por modelo");
            System.out.println("0. Salir");
            System.out.println("---------------");
            System.out.println("9. Admin");
            System.out.println("Introduzca opción:");
            option = sc.nextInt();
            if (option == 9) {
                GoAdminMenu();
            }
            
        } while (option != 0);
        
        
    }
    
    private static void PrintAdminMenu(){
        int option;        
        
        do {           
            System.out.println("======= Mis Coches Rentacar - Admin =======");            
            System.out.println("\n");
            System.out.println("1. Añadir Coche");
            System.out.println("0. Borrar Coche");
            System.out.println("0. Salir");
            System.out.println("Introduzca opción:");
            option = sc.nextInt();
            
        } while (option != 0);
    }
    
    private static void GetNewCocheInput(){
        
    }
    
    private static void GetDeleteCocheInput(){
        
    }
        
    private static int GetOpcion(){
        int opcion;
        return 0;        
    }
}
