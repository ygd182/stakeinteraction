/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.stakeInteraction.server.Base;

import com.mysql.jdbc.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Jorge
 */
public class ManejadorArcosDeUsuario extends ManejadorBase {

     @Override
    public int insert(Object o) {
         int idAgregado=-1;
        return idAgregado;
        //throw new UnsupportedOperationException("Not supported yet.");
    }

  //  @Override
    public void delete( int idGrafo, int idArco) {
         try {
         conectar();
            PreparedStatement st = (PreparedStatement) conexion.prepareStatement("delete from ArcoDeUsuario  where idGrafo=? and idArco=?");

            st.setInt(1, idGrafo);
            st.setInt(2, idArco);



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



    public void deleteGrafo(int id) {
         try {
         conectar();
            PreparedStatement st = (PreparedStatement) conexion.prepareStatement("delete from ArcoDeUsuario  where idGrafo=?");

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
    public Object get(int id) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Object get(String condicion) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Vector<Object> getAll(String condicion) {
      Vector<Object> nodos=null;
        try {
         conectar();
            PreparedStatement st = (PreparedStatement) conexion.prepareStatement("select * from ArcoDeUsuario where "+condicion);


                ResultSet rs = st.executeQuery();
                nodos=new Vector<Object>();

            while(rs.next()){


                nodos.add(rs.getInt(2));
            }
        // desconectar();
        } catch (SQLException ex) {
            Logger.getLogger(ManejadorNodo.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ManejadorNodo.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
         if (null != conexion)
             try {
                desconectar();
            } catch (SQLException ex) {
                Logger.getLogger(ManejadorInformacion.class.getName()).log(Level.SEVERE, null, ex);
            }
      }
    return nodos;
    }



   public void guardar(int idGrafo,int idArco){
      try {
       conectar();
            PreparedStatement st = (PreparedStatement) conexion.prepareStatement("INSERT INTO ArcoDeUsuario  VALUES (?, ?)");

            st.setInt(1, idGrafo);
            st.setInt(2, idArco);



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

    @Override
    public void update(Object o) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void delete(int idArco) {
         try {
         conectar();
            PreparedStatement st = (PreparedStatement) conexion.prepareStatement("delete from ArcoDeUsuario  where  idArco=?");


            st.setInt(1, idArco);



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
    public void deleteAll() {
         try {
         conectar();
            PreparedStatement st = (PreparedStatement) conexion.prepareStatement("delete from ArcoDeUsuario  where  idArco!=-1");





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
