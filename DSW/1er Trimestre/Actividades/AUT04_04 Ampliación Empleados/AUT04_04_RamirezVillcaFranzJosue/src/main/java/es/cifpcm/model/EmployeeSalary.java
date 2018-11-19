package es.cifpcm.model;

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

  public EmployeeSalary() {
    
  }
  
  public EmployeeSalary(int salary, Date fromDate, Date toDate) {
    this.salary = salary;
    this.fromDate = fromDate;
    this.toDate = toDate;
  }

  public int getSalary() {
    return salary;
  }

  public Date getFromDate() {
    return fromDate;
  }

  public Date getToDate() {
    return toDate;
  }

}
