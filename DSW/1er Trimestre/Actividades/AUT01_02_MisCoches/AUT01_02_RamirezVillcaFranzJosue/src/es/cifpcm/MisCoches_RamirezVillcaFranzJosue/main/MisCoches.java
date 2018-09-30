package es.cifpcm.MisCoches_RamirezVillcaFranzJosue.main;

import es.cifpcm.MisCoches_RamirezVillcaFranzJosue.data.ImplementsPersistence;
import es.cifpcm.MisCoches_RamirezVillcaFranzJosue.data.Persistence;
import es.cifpcm.MisCoches_RamirezVillcaFranzJosue.model.Coche;
import es.cifpcm.MisCoches_RamirezVillcaFranzJosue.util.ConsoleClear;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Josué Ramírez
 */
public class MisCoches {
    
    public static Persistence pst;
    private static Scanner sc;
    
    public static void main(String[] args) throws InterruptedException, IOException  {
        sc = new Scanner(System.in);               
        pst = new ImplementsPersistence();                        
        pst.Open();           
        int opcion;
        
        do {              
            ConsoleClear.ClearConsoleIde();
            PrintMainMenu();
            opcion = GetOpcion();            
            switch (opcion) {
                case 1: 
                    ConsoleClear.ClearConsoleIde();
                    ListarCoches();                    
                    GetNewCocheInput();                       
                    System.in.read();
                    break;
                case 9: 
                    ConsoleClear.ClearConsoleIde();         
                    GoAdminMenu();
                    opcion = GetOpcion();
                    switch (opcion) {
                        case 1: 
                            ConsoleClear.ClearConsoleIde();
                            InsertarCoche();
                            break;
                        case 2: 
                            ConsoleClear.ClearConsoleIde();
                            ListarCoches();
                            BorrarCoche();
                            System.in.read();
                            break;
                    }
                    break;
            }
            
        } while (opcion != 0);
        
    }
    
    private static void InsertarCoche(){
        Coche coche = new Coche();
        System.out.println("Introduzca los datos del coche \n");        
        System.out.println("Marca: ");
        coche.setMarca(sc.next());
        
        System.out.println("Modelo: ");
        coche.setModelo(sc.next());
        
        System.out.println("Categoria: ");
        coche.setCategoria(sc.nextInt());
        
        System.out.println("Precio Dia: ");
        coche.setPrecioDia(sc.nextInt());
        
        pst.Save(coche);
        
    }
    
    private static void BorrarCoche() throws InterruptedException{
        Boolean hasCar = false;
        StringBuilder sb = new StringBuilder();
        List<Coche> memStore = pst.List();
        System.out.println("Introduzca el Modelo de coche que desea eliminar: ");
        String modelo = sc.next();
        ConsoleClear.ClearConsoleIde();
        for (int i = 0; i < memStore.size(); i++) {
            if (memStore.get(i).getModelo().equals(modelo)) {
                sb.append("Se ha eliminado exitosamente el siguiente registro \n");
                sb.append("Marca \t\tModelo \t\tCategoria \t\tPrecio Dia \t\t\n");
                sb.append("---------------------------------------------------------------\n");
                sb.append(memStore.get(i).getMarca()).append("\t\t");
                sb.append(memStore.get(i).getModelo()).append("\t\t");
                sb.append(memStore.get(i).getCategoria()).append("\t\t\t");
                sb.append(memStore.get(i).getPrecioDia()).append("\t\t");
                sb.append("\n");
                System.out.println(sb.toString());                                                              
                hasCar = true;
                pst.Delete(i);
                break;
            }
            
        }
        if (!hasCar) {
            System.out.println("No se encontro el modelo que busca");            
        }
        System.out.println("\n(Presiona Enter para volver al menu principal)");                      
       
    }
    
    private static void ListarCoches(){                                         
        List<Coche> memStore;        
        memStore = pst.List();
        System.out.println("Marca \t\tModelo \t\tCategoria \t\tPrecio Dia \t\t");
        System.out.println("---------------------------------------------------------------");
        for (int i = 0; i < memStore.size(); i++) {        
            System.out.print(memStore.get(i).getMarca() + "\t\t");
            System.out.print(memStore.get(i).getModelo() + "\t\t");
            System.out.print(memStore.get(i).getCategoria() + "\t\t\t");
            System.out.print(memStore.get(i).getPrecioDia() + "\t\t");
            System.out.println("");
        }
        System.out.println("");
    }
    
    private static void GoAdminMenu(){
        PrintAdminMenu();
    }
    
    private static void PrintMainMenu(){
        StringBuilder sb = new StringBuilder();                   
        sb.append("======= Mis Coches Rentacar ======= \n");
        sb.append("-- Échese una siesta mientras buscamos \n");
        sb.append("\n");
        sb.append("1. Busque por modelo \n");
        sb.append("0. Salir \n");
        sb.append("--------------- \n");
        sb.append("9. Admin \n");            
        System.out.println(sb.toString());
                
    }
    
    private static void PrintAdminMenu(){
        StringBuilder sb = new StringBuilder();        
        sb.append("======= Mis Coches Rentacar - Admin ======= \n");        
        sb.append("\n");
        sb.append("1. Añadir Coche \n");
        sb.append("2. Borrar Coche \n");
        sb.append("0. Salir \n");                 
        System.out.println(sb.toString());             
    }
    
    //Busca un coche por modelo
    private static void GetNewCocheInput() throws InterruptedException{
        StringBuilder sb = new StringBuilder();
        Boolean hasCar = false;
        List<Coche> memStore = pst.List();
        System.out.println("Introduzca el Modelo de coche que desea buscar: ");
        String modelo = sc.next();
        ConsoleClear.ClearConsoleIde();
        for (int i = 0; i < memStore.size(); i++) {
            if (memStore.get(i).getModelo().equals(modelo)) {                
                sb.append("Marca \t\tModelo \t\tCategoria \t\tPrecio Dia \t\t\n");
                sb.append("---------------------------------------------------------------\n");
                sb.append(memStore.get(i).getMarca()).append("\t\t");
                sb.append(memStore.get(i).getModelo()).append("\t\t");
                sb.append(memStore.get(i).getCategoria()).append("\t\t\t");
                sb.append(memStore.get(i).getPrecioDia()).append("\t\t");
                sb.append("\n");
                System.out.println(sb.toString());                                              
                hasCar = true;
                break;
            }           
        }
        if (!hasCar) {
            System.out.println("No se encontro el modelo que busca");            
        }
        System.out.println("\n(Presiona Enter para volver al menu principal)");
    }
        
    private static int GetOpcion(){
        int opcion;
        System.out.println("Introduzca opción: ");
        opcion = sc.nextInt();
        return opcion;        
    }
}
