/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.cifpcm.data;

import java.io.Serializable;

/**
 * Almacena las coordenadas de una base de datos, así como
 * el usuario y contraseña de conexión.
 * 
 * @author Fer
 */
public class DaoFactoryConfig implements Serializable {

    private String driverClassName;
    private String connectionUrl;
    private String dbUser;
    private String dbPassword;

    public DaoFactoryConfig() {
    }

    public DaoFactoryConfig(String driverClass, String connectionUrl, String dbUser, String dbPassword) {

        this.driverClassName = driverClass;
        this.connectionUrl = connectionUrl;
        this.dbUser = dbUser;
        this.dbPassword = dbPassword;
    }

    public DaoFactoryConfig(final DaoFactoryConfig dfc) {

        this.driverClassName = dfc.driverClassName;
        this.connectionUrl = dfc.connectionUrl;
        this.dbUser = dfc.dbUser;
        this.dbPassword = dfc.dbPassword;

    }

    public String getDriverClassName() {
        return driverClassName;
    }

    public void setDriverClassName(String driverClassName) {
        this.driverClassName = driverClassName;
    }

    public String getConnectionUrl() {
        return connectionUrl;
    }

    public void setConnectionUrl(String connectionUrl) {
        this.connectionUrl = connectionUrl;
    }

    public String getDbUser() {
        return dbUser;
    }

    public void setDbUser(String dbUser) {
        this.dbUser = dbUser;
    }

    public String getDbPassword() {
        return dbPassword;
    }

    public void setDbPassword(String dbPassword) {
        this.dbPassword = dbPassword;
    }
}
