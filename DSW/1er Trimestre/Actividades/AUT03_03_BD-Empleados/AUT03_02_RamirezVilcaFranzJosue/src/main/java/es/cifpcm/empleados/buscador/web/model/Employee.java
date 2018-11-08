package es.cifpcm.empleados.buscador.web.model;

import java.util.Date;

/**
 * Instalar dependencia mysql-connector-java 
 * @author Josué Ramírez
 */
public class Employee {

  private Integer empNo;
  private Date birthDate;
  private String firstName;
  private String lastName;
  private char gender;
  private Date hireDate;

  public Employee(Integer empNo, Date birthDate, String firstName, String lastName, char gender, Date hireDate) {
    this.empNo = empNo;
    this.birthDate = birthDate;
    this.firstName = firstName;
    this.lastName = lastName;
    this.gender = gender;
    this.hireDate = hireDate;    
  }

  public Integer getEmpNo() {
    return empNo;
  } 

  public Date getBirthDate() {
    return birthDate;
  }
  
  public String getFirstName() {
    return firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public char getGender() {
    return gender;
  }

  public Date getHireDate() {
    return hireDate;
  }

}
