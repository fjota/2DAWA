/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.cifpcm.empleados.buscador.data;

import es.cifpcm.data.DaoFactory;
import es.cifpcm.empleados.buscador.model.Employee;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Fer
 */
public class EmployeeDaoImpl implements EmployeeDao {

    private final Logger logger = LoggerFactory.getLogger(EmployeeDaoImpl.class);

    private final DaoFactory df;

    private Integer pageSize = DEFAULT_PAGE_SIZE;

    public EmployeeDaoImpl(DaoFactory df) {
        this.df = df;
    }

    @Override
    public List<Employee> selectEmployees(Integer pageIndex) {
        
        return executeSelectEmployees("SELECT * FROM employees", pageIndex);
    }

    @Override
    public List<Employee> selectEmployees(Integer pageIndex,
            EmployeeCriteria criteria) {

        String query = "SELECT emp_no, birth_date, first_name, last_name, "
                + "gender, hire_date FROM employees";

        query = query.concat(criteria.toString());

        return executeSelectEmployees(query, pageIndex);
    }

    @Override
    public Employee selectEmployee(Integer empNo) {

        final String query = "SELECT emp_no, birth_date, first_name, "
                + "last_name, gender, hire_date FROM employees WHERE emp_no?";

        Employee emp = null;

        try (Connection conn = df.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setInt(1, empNo);
            try (ResultSet rs = pstmt.executeQuery()) {

                if (rs.next()) {
                    emp = employeeFromRs(rs);
                }
            }

        } catch (SQLException ex) {
            logger.error(query, ex);
        }
        return emp;
    }

    @Override
    public boolean insertEmployee(Employee emp) {

        String query = "INSERT INTO employees (emp_no, birth_date, first_name, "
                + "last_name, gender, hire_date) VALUES (?, ?, ?, ?, ?, ?)";

        int regsAffected;

        try (Connection conn = df.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setInt(1, emp.getEmpNo());
            pstmt.setDate(2, emp.getBirthDate());
            pstmt.setString(3, emp.getFirstName());
            pstmt.setString(4, emp.getLastName());
            pstmt.setString(5, emp.getGender().toString());
            pstmt.setDate(6, emp.getHireDate());
            regsAffected = pstmt.executeUpdate();
            return regsAffected == 1;

        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(EmployeeDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }

    }

    @Override
    public Integer getPageSize() {
        return pageSize;
    }

    @Override
    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    private Employee employeeFromRs(ResultSet rs) throws SQLException {

        return new Employee(rs.getInt(1),
                rs.getDate(2), rs.getString(3), rs.getString(4),
                rs.getString(5).charAt(0), rs.getDate(6));
    }

    private String addPagination(String query, Integer pageIndex) {

        if (pageIndex == null) {
            return query;
        }

        query = query.concat(" LIMIT %d, %d");

        int firstRecord = pageIndex * pageSize;

        return String.format(query, firstRecord, pageSize);
    }

    private List<Employee> executeSelectEmployees(String query, Integer pageIndex) {

        // Añade claúsula de paginación Mysql
        query = addPagination(query, pageIndex);

        List<Employee> outcome = new ArrayList<>();

        try (Connection conn = df.getConnection();
                Statement stmt = conn.createStatement()) {

            try (ResultSet rs = stmt.executeQuery(query)) {

                while (rs.next()) {
                    outcome.add(employeeFromRs(rs));
                }
            }

        } catch (SQLException ex) {
            logger.error(query, ex);
        }
        return outcome;
    }

}
