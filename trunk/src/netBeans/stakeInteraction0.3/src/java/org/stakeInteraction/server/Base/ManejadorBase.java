/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.stakeInteraction.server.Base;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author Jorge
 */
public abstract class ManejadorBase {
protected   Connection conexion;
    public  Connection conectar() throws SQLException, ClassNotFoundException {
       
          //  conexion = (Connection) DriverManager.getConnection("jdbc:mysql://127.0.0.1/diseño_schema","root","yor" );
       Class.forName("com.mysql.jdbc.Driver");
       conexion = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/disenio_schema","root","pass" );
         return conexion;
    }

    public  void desconectar() throws SQLException {
       
            conexion.close();
        
          
         
    }

      public abstract int insert(Object o);

        public abstract void delete(int id);

        public abstract Object get(int id);

        public abstract Object get(String condicion);

        public abstract Vector<Object> getAll(String condicion);

        public abstract void update(Object o);

        public abstract void deleteAll();

    
}
