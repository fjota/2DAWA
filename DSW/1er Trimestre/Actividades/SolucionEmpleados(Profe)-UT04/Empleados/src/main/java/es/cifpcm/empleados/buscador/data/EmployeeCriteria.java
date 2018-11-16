/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.cifpcm.empleados.buscador.data;

import java.util.ArrayList;
import java.util.List;

/**
 * Esta clase nos va a servir para definir condiciones de búsqueda.
 *
 * @author Fer
 */
public class EmployeeCriteria {

    private final List<String> whereClauses = new ArrayList<>();

    public EmployeeCriteria() {

    }

    public EmployeeCriteria addEqual(String field, Integer value) {

        if (value != null) {
            whereClauses.add(field.concat(" =").concat(value.toString()));
        }
        return this;
    }

    public EmployeeCriteria addEqual(String field, String value) {
        if (value != null) {
            whereClauses.add(field.concat(" ='").concat(value).concat("'"));
        }
        return this;
    }

    public EmployeeCriteria addLike(String field, String value) {
        if (value != null) {
            whereClauses.add(field.concat(" LIKE '").concat(value).concat("%%'"));
        }
        return this;
    }

    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < whereClauses.size(); i++) {

            if (i == 0) {
                sb.append(" WHERE ");
            } else {
                sb.append(" AND ");
            }

            sb.append(whereClauses.get(i));
        }
        return sb.toString();
    }

    /**
     *
     * @return
     */
    public boolean isEmpty() {
        return whereClauses.isEmpty();
    }
    
    /**
     *
     * @return
     */
    public int getSize() {
        return whereClauses.size();
    }
    
}
