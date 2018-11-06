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
  private Character gender;
  private Date hireDate;

  public Employee() {
  }

  public Integer getEmpNo() {
    return empNo;
  }

  public void setEmpNo(Integer empNo) {
    this.empNo = empNo;
  }

  public Date getBirthDate() {
    return birthDate;
  }

  public void setBirthDate(Date birthDate) {
    this.birthDate = birthDate;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public Character getGender() {
    return gender;
  }

  public void setGender(Character gender) {
    this.gender = gender;
  }

  public Date getHireDate() {
    return hireDate;
  }

  public void setHireDate(Date hireDate) {
    this.hireDate = hireDate;
  }

}
