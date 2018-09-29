package es.cifpcm.data;

import es.cifpcm.model.Coche;
import java.util.List;

/**
 *
 * @author Josué Ramírez
 */
public interface Persistence {
    
    public void Open();
    public void Close();
    public void Save();
    public void Delete();
    
    public List<Coche> List();
}
