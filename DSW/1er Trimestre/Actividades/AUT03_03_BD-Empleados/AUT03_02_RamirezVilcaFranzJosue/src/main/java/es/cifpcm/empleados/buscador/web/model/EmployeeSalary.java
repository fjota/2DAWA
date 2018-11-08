package es.cifpcm.empleados.buscador.web.model;

import java.util.Date;

/**
 * Instalar dependencia mysql-connector-java
 *
 * @author Josué Ramírez
 */
public class EmployeeSalary {
  
  private int salary;
  private Date fromDate;
  private Date toDate;

  public EmployeeSalary(int salary, Date fromDate, Date toDate) {    
    this.salary = salary;
    this.fromDate = fromDate;
    this.toDate = toDate;
  }

  public int getSalary() {
    return salary;
  }

  public void setSalary(int salary) {
    this.salary = salary;
  }

  public Date getFromDate() {
    return fromDate;
  }

  public void setFromDate(Date fromDate) {
    this.fromDate = fromDate;
  }

  public Date getToDate() {
    return toDate;
  }

  public void setToDate(Date toDate) {
    this.toDate = toDate;
  }

}
