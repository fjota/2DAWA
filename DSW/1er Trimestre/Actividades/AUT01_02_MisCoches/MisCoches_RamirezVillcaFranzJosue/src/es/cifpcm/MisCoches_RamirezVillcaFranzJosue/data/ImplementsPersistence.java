package es.cifpcm.MisCoches_RamirezVillcaFranzJosue.data;

import es.cifpcm.MisCoches_RamirezVillcaFranzJosue.model.Coche;
import java.util.List;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Josué Ramírez
 */
public class ImplementsPersistence implements Persistence {

    private final String FILESTORE_PATH = System.getProperty("java.io.tmpdir") + "\\RamirezVillcaFranzJosue.dat";
    private List<Coche> memStore = new ArrayList<>();        

    @Override
    public void Open() {    
        Coche nuevoCoche = new Coche();
        
        //Create new file if doesn´t exist
        if (!new File(FILESTORE_PATH).exists()) {
            try {
                new File(FILESTORE_PATH).createNewFile();
            } catch (IOException e) {
                System.out.println("No se pudo crear el fichero");
            }
        }      
        
        //Read file and save content at List
        try {
            FileInputStream fileIn = new FileInputStream(FILESTORE_PATH);
                        
            try (ObjectInputStream entrada = new ObjectInputStream(fileIn)) {
                nuevoCoche = (Coche) entrada.readObject();  
                memStore.add(nuevoCoche);
                while (nuevoCoche != null) {
                    nuevoCoche = (Coche) entrada.readObject();  
                    memStore.add(nuevoCoche);
                }                                 
                entrada.close();
            }
            
        } catch (FileNotFoundException ex) {
            /*Logger.getLogger(ImplementsPersistence.class.getName()).log(Level.SEVERE, null, ex);*/
        } catch (IOException | ClassNotFoundException ex) {
            /*Logger.getLogger(ImplementsPersistence.class.getName()).log(Level.SEVERE, null, ex);*/
        }
        
    }   

    @Override
    public void Save(Coche coche) {      
        memStore.add(coche);
        //Open File and Write content
        try {
            FileOutputStream fileOut = new FileOutputStream(FILESTORE_PATH);
            
            try (ObjectOutputStream salida = new ObjectOutputStream(fileOut)) {                                                
                for (int i = 0; i < memStore.size(); i++) {
                    salida.writeObject(memStore.get(i));
                }
                salida.close();
            }
            
        } catch (FileNotFoundException ex) {
            /*Logger.getLogger(ImplementsPersistence.class.getName()).log(Level.SEVERE, null, ex);*/
        } catch (IOException ex) {
            /*Logger.getLogger(ImplementsPersistence.class.getName()).log(Level.SEVERE, null, ex);*/
        }
    }

    @Override
    public void Delete(int indice) {
        memStore.remove(indice);
        //Open File and delete content
        try {
            FileOutputStream fileOut = new FileOutputStream(FILESTORE_PATH);
            
            try (ObjectOutputStream salida = new ObjectOutputStream(fileOut)) {                                                
                for (int i = 0; i < memStore.size(); i++) {
                    salida.writeObject(memStore.get(i));
                }
                salida.close();
            }
            
        } catch (FileNotFoundException ex) {
            /*Logger.getLogger(ImplementsPersistence.class.getName()).log(Level.SEVERE, null, ex);*/
        } catch (IOException ex) {
            /*Logger.getLogger(ImplementsPersistence.class.getName()).log(Level.SEVERE, null, ex);*/
        }
    }

    @Override
    public List<Coche> List() {
        return memStore;
    }

}
