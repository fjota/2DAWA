package es.cifpcm.MisCoches_RamirezVillcaFranzJosue.data;

import es.cifpcm.MisCoches_RamirezVillcaFranzJosue.model.Coche;
import java.util.List;

/**
 *
 * @author Josué Ramírez
 */
public interface Persistence {
    
    public void Open();    
    public void Save(Coche coche);
    public void Delete(int indice);
    
    public List<Coche> List();
}
