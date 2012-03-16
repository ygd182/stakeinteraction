/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.stakeInteraction.server.Base;


import java.util.Vector;
import org.stakeInteraction.shared.CuentaUsuario.CuentaUsuario;

import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.stakeInteraction.shared.EstrategiaComportamiento.EstrategiaComportamiento;
import org.stakeInteraction.shared.EstrategiaComportamiento.EstrategiaComportamientoAdmin;
import org.stakeInteraction.shared.EstrategiaComportamiento.EstrategiaComportamientoUser;
import org.stakeInteraction.shared.grafo.Grafo;


/**
 *
 * @author Jorge
 */
public class ManejadorCuentaUsuario extends ManejadorBase {




 //   public CuentaUsuario getCuentaUsuario(String nombre,String contraseña){ //devuelve null ai no encuentra nada

     public CuentaUsuario getCuentaUsuario(String condicion){ //devuelve null ai no encuentra nada
      //devuelve null ai no encuentra nada
            CuentaUsuario c = null;
        try {
                System.out.println("select * from CuentaUsuario where "+ condicion);
            conectar();
            PreparedStatement s = (PreparedStatement) conexion.prepareStatement("select * from CuentaUsuario where "+ condicion);
           /* s.setString(1, nombre);
            s.setString(2, contraseña);*/
            ResultSet rs = s.executeQuery();
            if (rs.next()) {
                //sin esto no anda
                c = new CuentaUsuario(rs.getInt(1), rs.getString(2), rs.getString(3));
                Grafo g=new Grafo(rs.getInt(4));
              //   System.out.println("idgrafo"+g.getId());
                c.setGrafo(g);
                  System.out.println(rs.getString(5));
                if(rs.getString(5).equals("admin")){
                     System.out.println("admin");
                   EstrategiaComportamientoAdmin e=new EstrategiaComportamientoAdmin();
                   c.setEstrategia(e);
                }else{
                     System.out.println("user");
                    EstrategiaComportamientoUser e=new EstrategiaComportamientoUser();
                   c.setEstrategia(e);
                }
            }

        } catch (SQLException ex) {
            Logger.getLogger(ManejadorCuentaUsuario.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ManejadorCuentaUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
      finally {
         if (null != conexion)
             try {
                desconectar();
            } catch (SQLException ex) {
                Logger.getLogger(ManejadorCuentaUsuario.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
          return c;
}



public void agregarCuentaUsuarioConId(CuentaUsuario c){
        try {
         conectar();
            PreparedStatement st = (PreparedStatement) conexion.prepareStatement("INSERT INTO cuentausuario  VALUES (?, ?, ?,?,?)");

            st.setInt(1, c.getId());
            st.setString(2, c.getNombre());
            st.setString(3, c.getContraseña());
        //   st.setInt(4, c.getIdNodo());
            st.setInt(4,c.getGrafo().getId());
            st.setString(5, "usuario");


            st.executeUpdate();




            desconectar();
        } catch (SQLException ex) {
            Logger.getLogger(ManejadorCuentaUsuario.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ManejadorCuentaUsuario.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
         if (null != conexion)
             try {
                desconectar();
            } catch (SQLException ex) {
                Logger.getLogger(ManejadorCuentaUsuario.class.getName()).log(Level.SEVERE, null, ex);
            }
      }


}


public int agregarCuentaUsuario(CuentaUsuario c){
     int idAgregado=-1;
        
        try {
         conectar();
            PreparedStatement st = (PreparedStatement) conexion.prepareStatement("INSERT INTO cuentausuario (nombre,contraseña,idGrafo,tipo)  VALUES ( ?, ?,?,?)");

         
            st.setString(1, c.getNombre());
            st.setString(2, c.getContraseña());
            //st.setInt(3, c.getIdNodo());
            st.setInt(3,c.getGrafo().getId());
            st.setString(4, "usuario");


            st.executeUpdate();

              ResultSet  rs = st.executeQuery("SELECT LAST_INSERT_ID()");

            if (rs.next()) { //obetener la ultima id generada
            int id=rs.getInt(1);
            c.setId(id);
            idAgregado=id;

            }
           // desconectar();
        } catch (SQLException ex) {
            Logger.getLogger(ManejadorCuentaUsuario.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ManejadorCuentaUsuario.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
         if (null != conexion)
             try {
                desconectar();
            } catch (SQLException ex) {
                Logger.getLogger(ManejadorCuentaUsuario.class.getName()).log(Level.SEVERE, null, ex);
            }
      }
    return idAgregado;

}

public void eliminarCuentaUsuario(int id){
     try {
         conectar();
            PreparedStatement st = (PreparedStatement) conexion.prepareStatement("delete from cuentausuario  where idCuentaUsuario=?");

            st.setInt(1, id);



            st.executeUpdate();




           // desconectar();
        } catch (SQLException ex) {
            Logger.getLogger(ManejadorCuentaUsuario.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ManejadorCuentaUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
         finally {
         if (null != conexion)
             try {
                desconectar();
                System.out.println("desconecto");
            } catch (SQLException ex) {
                Logger.getLogger(ManejadorCuentaUsuario.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

}

    @Override
    public int insert(Object o) {
        CuentaUsuario c=(CuentaUsuario) o;
       return agregarCuentaUsuario(c);
    }

    @Override
    public void delete(int id) {
        eliminarCuentaUsuario(id);
    }

    @Override
    public Object get(int id) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Vector<Object> getAll(String condicion) {
        Vector<Object> cuentas=null;
        CuentaUsuario c = null;
        try {
               
            conectar();
            PreparedStatement s = (PreparedStatement) conexion.prepareStatement("select * from CuentaUsuario where "+ condicion);
           /* s.setString(1, nombre);
            s.setString(2, contraseña);*/
            ResultSet rs = s.executeQuery();
            cuentas=new Vector<Object>();
            while (rs.next()) {
                //sin esto no anda
                c = new CuentaUsuario(rs.getInt(1), rs.getString(2), rs.getString(3));
                Grafo g=new Grafo(rs.getInt(4));
                c.setGrafo(g);

               /*  if(rs.getString(5)=="admin"){
                   EstrategiaComportamientoAdmin e=new EstrategiaComportamientoAdmin();
                   c.setEstrategia(e);
                }else{
                      EstrategiaComportamientoUser e=new EstrategiaComportamientoUser();
                   c.setEstrategia(e);
                }*/
                 cuentas.add(c);
            }

        } catch (SQLException ex) {
            Logger.getLogger(ManejadorCuentaUsuario.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ManejadorCuentaUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
      finally {
         if (null != conexion)
             try {
                desconectar();
            } catch (SQLException ex) {
                Logger.getLogger(ManejadorCuentaUsuario.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
          return cuentas;
    }

    @Override
    public Object get(String condicion) {
       return getCuentaUsuario(condicion);
    }

    @Override
    public void update(Object o) {

     try {
          CuentaUsuario cuenta=(CuentaUsuario) o;
         conectar();

           PreparedStatement st = (PreparedStatement) conexion.prepareStatement("Update CuentaUsuario set nombre=?, contraseña=?,idGrafo=? where idCuentaUsuario=?");



             st.setInt(3, cuenta.getGrafo().getId());
             st.setString(1, cuenta.getNombre());
             st.setString(2, cuenta.getContraseña());
             st.setInt(4, cuenta.getId());
            // st.setBoolean(1, cuenta.isValido());

                st.executeUpdate();


        } catch (SQLException ex) {
            Logger.getLogger(ManejadorInformacion.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ManejadorInformacion.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
         if (null != conexion)
             try {
                desconectar();
            } catch (SQLException ex) {
                Logger.getLogger(ManejadorInformacion.class.getName()).log(Level.SEVERE, null, ex);
            }
          }

    }

    @Override
    public void deleteAll() {
        try {
         conectar();
            PreparedStatement st = (PreparedStatement) conexion.prepareStatement("delete from cuentausuario  where idCuentaUsuario!=-1");





            st.executeUpdate();




           // desconectar();
        } catch (SQLException ex) {
            Logger.getLogger(ManejadorCuentaUsuario.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ManejadorCuentaUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
         finally {
         if (null != conexion)
             try {
                desconectar();
                System.out.println("desconecto");
            } catch (SQLException ex) {
                Logger.getLogger(ManejadorCuentaUsuario.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }




}





