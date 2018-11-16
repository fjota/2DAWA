/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.cifpcm.empleados.buscador.data;

import es.cifpcm.empleados.buscador.model.Employee;
import java.util.List;

/**
 *
 * @author Fer
 */
public interface EmployeeDao {

    static final int DEFAULT_PAGE_SIZE = 20;

    /**
     *
     * @param pageIndex
     * @return
     */
    List<Employee> selectEmployees(Integer pageIndex);

    /**
     *
     * @param PageIndex
     * @param criteria
     * @return
     */
    List<Employee> selectEmployees(Integer PageIndex, EmployeeCriteria criteria);

    /**
     *
     * @param empNo
     * @return
     */
    Employee selectEmployee(Integer empNo);

    /**
     *
     * @return
     */
    Integer getPageSize();

    /**
     *
     * @param pageSize
     */
    void setPageSize(Integer pageSize);
    
    /**
     *
     * @param emp
     * @return 
     */
    boolean insertEmployee(Employee emp);

}
