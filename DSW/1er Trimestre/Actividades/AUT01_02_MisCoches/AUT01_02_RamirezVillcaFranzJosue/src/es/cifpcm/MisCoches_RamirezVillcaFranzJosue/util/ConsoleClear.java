package es.cifpcm.MisCoches_RamirezVillcaFranzJosue.util;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;

/**
 *
 * @author Josué Ramírez
 */
public class ConsoleClear {

    public static void ClearConsoleIde() throws InterruptedException {
        try {
            Robot robot = new Robot();
            robot.keyPress(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_L);

            robot.keyRelease(KeyEvent.VK_L);
            robot.keyRelease(KeyEvent.VK_CONTROL); 
            Thread.sleep(90);
        } catch (AWTException e) {
            System.err.println(e);
        }
    }

    public static void ClearConsole() {
        try {
            String os = System.getProperty("os.name");

            if (os.contains("Windows")) {
                Runtime.getRuntime().exec("cls");
            } else {
                Runtime.getRuntime().exec("clear");
            }
        } catch (IOException e) {
            System.err.println(e);
        }
    }
}
