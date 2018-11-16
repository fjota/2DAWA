/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.cifpcm.common;

/**
 *
 * @author Fer
 */
public class ParseUtils {
    
    /**
     * Intenta convertir un String en Integer y en caso de error devuelve
     * el valor por defecto suministrado.
     * 
     * @param strValue  valor de tipo string a convertir
     * @param defValue  valor por defecto en caso de error
     * @return
     */
    public static final Integer safeParseInt(String strValue, Integer defValue) {
        
        if (strValue == null || strValue.isEmpty())
            return defValue;
        
        try {
            return Integer.parseInt(strValue);
        } catch (NumberFormatException nfex) {
            return defValue;
        }   
    }
    
    /**
     * Intenta convertir un String en Integer y en caso de error devuelve null.
     * 
     * @param strValue  valor de tipo String a convertir
     * @return
     */
    public static final Integer safeParseInt(String strValue) {
        return safeParseInt(strValue, null);
    }
    
    
}
