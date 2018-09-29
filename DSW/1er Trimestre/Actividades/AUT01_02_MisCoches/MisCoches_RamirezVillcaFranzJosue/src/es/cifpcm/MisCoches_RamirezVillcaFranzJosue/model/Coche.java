package es.cifpcm.MisCoches_RamirezVillcaFranzJosue.model;

import java.io.Serializable;

/**
 *
 * @author Josué Ramírez
 */
public class Coche implements Serializable{
    
    private String marca;
    private String modelo;
    private int categoria;
    private int precioDia;

    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public int getCategoria() {
        return categoria;
    }

    public int getPrecioDia() {
        return precioDia;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public void setCategoria(int categoria) {
        this.categoria = categoria;
    }

    public void setPrecioDia(int precioDia) {
        this.precioDia = precioDia;
    }           
    
}
