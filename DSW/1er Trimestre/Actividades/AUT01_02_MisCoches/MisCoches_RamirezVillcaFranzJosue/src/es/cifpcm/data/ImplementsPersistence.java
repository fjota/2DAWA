package es.cifpcm.data;

import es.cifpcm.model.Coche;
import java.io.BufferedOutputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.util.List;
import static java.nio.file.StandardOpenOption.*;
import java.nio.file.*;
import java.io.*;

/**
 *
 * @author Josué Ramírez
 */
public class ImplementsPersistence implements Persistence {
    
    private String FILESTORE_PATH;
    private List<Coche> memStore;
    Path p = Paths.get(FILESTORE_PATH);
    
    public void ImplementsPersistence() {
        FILESTORE_PATH = System.getProperty("java.io.tmpdir") + "\\RamirezVillcaFranzJosue.dat";
        
    }
    
    public void Open() {
        try {
            OutputStream outS = new BufferedOutputStream(Files.newOutputStream(p, CREATE, APPEND));
        } catch (IOException e) {
            System.err.println();
        }
    }
    
    public void Close() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public void Save() {
          
    }
    
    public void Delete() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
        
    public List<Coche> List() {
        return memStore;
    }
    
}
