package aut01_01_ramirezvillcafranzjosue;

import es.cifpcm.io.file.FileCreator;
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.Scanner;

/**
 *
 * @author Josué Ramírez
 */
public class AUT01_01_RamirezVillcaFranzJosue {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {        
        StringBuilder sb = new StringBuilder();        
        Scanner sc = new Scanner(System.in);
        String tituloPagina;
        String nombreUsuario;
        
        System.out.println("Introduzca título: ");
        tituloPagina = sc.nextLine();
        
         try {
            Robot robot = new Robot();
            robot.setAutoDelay(250);
            robot.keyPress(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_L);
        } catch (AWTException ex) {
            ex.printStackTrace();
        }
        
        
        System.out.println("Introduzca nombre: ");
        nombreUsuario = sc.nextLine();
        
        sb.append("<html>");
        sb.append("<head>");
        sb.append("<title>");
        sb.append(tituloPagina);
        sb.append("</title>");
        sb.append("</head/>");
        sb.append("<body/>");
        sb.append("<h1>" + "Hola: ");
        sb.append(nombreUsuario);
        sb.append("</h1>");
        sb.append("</body>");
        sb.append("</hmtl>");
        
        FileCreator.createFile(System.getenv("TEMP") + "\\RamirezVillcaFranzJosue.html", sb.toString());
        System.out.println("El fichero se creo en: " + System.getenv("TEMP") + "\\RamirezVillcaFranzJosue.html");
    }
    
}
