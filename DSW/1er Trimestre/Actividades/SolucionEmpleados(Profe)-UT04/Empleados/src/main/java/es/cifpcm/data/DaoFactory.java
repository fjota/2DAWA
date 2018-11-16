/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.cifpcm.data;

import es.cifpcm.empleados.buscador.data.EmployeeDaoImpl;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import es.cifpcm.empleados.buscador.data.EmployeeDao;

/**
 *
 * @author Fer
 */
public class DaoFactory {
    
    private final Logger logger = LoggerFactory.getLogger(DaoFactory.class);
    
    private static DaoFactory instance;
    
    protected final DaoFactoryConfig dfc;

    // Se ejecuta una sola vez
    protected DaoFactory(DaoFactoryConfig dfc) {
        this.dfc = new DaoFactoryConfig(dfc);
        try {
            Class.forName(dfc.getDriverClassName());
            logger.debug("Cargado driver de base de datos {}", dfc.getDriverClassName());
        } catch (ClassNotFoundException ex) {
            logger.error("Error cargando driver", ex);
        }
    }

    /**
     *
     * @return
     */
    public Connection getConnection() {
        try {
            return DriverManager.getConnection(dfc.getConnectionUrl(),
                    dfc.getDbUser(), dfc.getDbPassword());
        } catch (SQLException ex) {
            logger.error("getConnection", ex);
            return null;
        }
    }

    /**
     *
     * @param conn
     */
    public void closeConnection(Connection conn) {
        
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException ex) {
                logger.error("closeConnection", ex);
            }
        }
        
    }

    /**
     *
     * @return
     */
    public EmployeeDao getEmployeeDao() {
        return new EmployeeDaoImpl(this);
    }

    /**
     * Se llama la primera vez para crear la fábrica de objetos.
     * 
     * @param dfc
     * @return
     */
    public static synchronized DaoFactory createInstance(DaoFactoryConfig dfc) {

        // El método es synchronized, no pueden entrar dos hilos a la vez
        // Se asegura que sólo se crea una instancia de la DaoFactory
        if (instance == null) {
            instance = new DaoFactory(dfc);
        }
        return instance;        
    }
    
    /**
     *  Devuelve la fábrica creada
     * 
     * @return
     */
    public static DaoFactory getInstance() {
        return instance;
    }
}
