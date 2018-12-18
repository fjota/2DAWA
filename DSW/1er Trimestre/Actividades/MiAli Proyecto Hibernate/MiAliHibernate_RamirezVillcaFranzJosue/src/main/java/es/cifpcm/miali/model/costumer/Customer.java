package es.cifpcm.miali.model.costumer;

import java.util.Date;

/**
 *
 * @author Josue Ramirez
 */
public class Customer {
  
  private int customerId;
  private String firstName;
  private String lastName;
  private String telefono;
  private String email;
  private Date fechaNacimiento;

  public Customer() {
  }

  public Customer(int customerId, String firstName, String lastName, String telefono, String email, Date fechaNacimiento) {
    this.customerId = customerId;
    this.firstName = firstName;
    this.lastName = lastName;
    this.telefono = telefono;
    this.email = email;
    this.fechaNacimiento = fechaNacimiento;
  }

  public int getCustomerId() {
    return customerId;
  }

  public void setCustomerId(int customerId) {
    this.customerId = customerId;
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

  public String getTelefono() {
    return telefono;
  }

  public void setTelefono(String telefono) {
    this.telefono = telefono;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public Date getFechaNacimiento() {
    return fechaNacimiento;
  }

  public void setFechaNacimiento(Date fechaNacimiento) {
    this.fechaNacimiento = fechaNacimiento;
  }
  
  
}
