/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.cifpcm.empleados.buscador.controller;

import es.cifpcm.common.ParseUtils;
import es.cifpcm.data.DaoFactory;
import es.cifpcm.empleados.buscador.data.EmployeeCriteria;
import es.cifpcm.empleados.buscador.data.EmployeeDao;
import es.cifpcm.empleados.buscador.model.Employee;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Fer
 */
public class SearchAction {
    
    private final Logger logger = LoggerFactory.getLogger(EmployeeCriteria.class);
    
    private EmployeeCriteria getCriteria(HttpServletRequest request) {
        
        EmployeeCriteria criteria = new EmployeeCriteria();
        
        String firstName = request.getParameter("firstName");
        if (firstName != null && !firstName.isEmpty()) {
            criteria.addLike("first_name", firstName);
        }
        
        String lastName = request.getParameter("lastName");
        if (lastName != null && !lastName.isEmpty()) {
            criteria.addLike("last_name", lastName);
        }
        
        logger.debug("getCriteria: encontrados {} parámetros de búsqueda", 
                criteria.getSize());
        
        return criteria;
    }
    
    public List<Employee> execute(HttpServletRequest request) {
        
        Integer page = ParseUtils.safeParseInt(request.getParameter("page"), 0);

        // Creamos condiciones de búsqueda (por nombre, por apellido...)
        EmployeeCriteria criteria = getCriteria(request);

        // Obtenemos acceso a datos
        DaoFactory daoFactory = DaoFactory.getInstance();
        EmployeeDao empDao = daoFactory.getEmployeeDao();
        
        if (criteria.isEmpty()) {
            return empDao.selectEmployees(page);
        } else {
            return empDao.selectEmployees(page, criteria);
        }
        
    }
    
}
