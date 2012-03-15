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
import org.stakeInteraction.shared.grafo.Arco;
import org.stakeInteraction.shared.grafo.Nodo;

/**
 *
 * @author Jorge
 */


public class ManejadorArco extends ManejadorBase {



    public int agregarArcoConId(Arco arco){

        try {

         conectar();

           PreparedStatement st = (PreparedStatement) conexion.prepareStatement("INSERT INTO arco (idArco,idNodo,idNodoVecino,valido) VALUES (?,?,?,?)");

               st.setInt(1, arco.getId());
             st.setInt(3, arco.GetNodo().getId());
             st.setInt(2, arco.getIdNodoOrigen());
             st.setBoolean(4, arco.isValido());



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
        return arco.getId();
    }


     public int agregarArcoSinId(Arco arco){
        int id=-1;
         try {

         conectar();

           PreparedStatement st = (PreparedStatement) conexion.prepareStatement("INSERT INTO arco (idNodo,idNodoVecino,valido) VALUES (?, ?,?)");

             st.setInt(1, arco.getIdNodoOrigen());
             st.setInt(2, arco.GetNodo().getId());

             st.setBoolean(3, arco.isValido());


            
                st.executeUpdate();


                  ResultSet  rs = st.executeQuery("SELECT LAST_INSERT_ID()");

                   if (rs.next()) { //obetener la ultima id generada
                          id=rs.getInt(1);
                               arco.setId(id);
                              }
               



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
        return id;
    }

    @Override
    public int insert(Object o) {
         Arco arco=(Arco) o;
        int id=arco.getId();
        if(id==-1)
            return agregarArcoSinId(arco);
        else
            return agregarArcoConId(arco);
         
    }

    @Override
    public void delete(int id) {
         try {
         conectar();
            PreparedStatement st = (PreparedStatement) conexion.prepareStatement("delete from Arco  where idArco=?");

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
        Arco a=null;
        try {
         conectar();
            PreparedStatement st = (PreparedStatement) conexion.prepareStatement("select * from Arco where idArco=?");

            st.setInt(1, id);





                ResultSet rs = st.executeQuery();
            if(rs.next()){
                a=new Arco();
                a.setId(rs.getInt(1));
                a.setValido(rs.getBoolean(4));
            /*  Nodo o=new Nodo();
              o.setId(rs.getInt(2));
              ManejadorNodo m=new ManejadorNodo();
              o=(Nodo) m.get(o.getId());*/

              Nodo d=new Nodo();
              d.setId(rs.getInt(3));
               ManejadorNodo m=new ManejadorNodo();
              d=(Nodo) m.get(d.getId());

              a.setIdNodoOrigen(rs.getInt(2));
              a.setNodo(d);




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
    return a;
    }

    @Override
    public Vector<Object> getAll(String condicion) {
      Vector<Object> arcos=null;
        try {
         conectar();
            PreparedStatement st = (PreparedStatement) conexion.prepareStatement("select * from Arco where condicion");







                ResultSet rs = st.executeQuery();
             
                 arcos=new Vector<Object>();
           while(rs.next()){
                  Arco a=null;
                a=new Arco();
                a.setId(rs.getInt(1));
                   a.setValido(rs.getBoolean(4));
            /*  Nodo o=new Nodo();
              o.setId(rs.getInt(2));
              ManejadorNodo m=new ManejadorNodo();
              o=(Nodo) m.get(o.getId());*/

              Nodo d=new Nodo();
              d.setId(rs.getInt(3));
               ManejadorNodo m=new ManejadorNodo();
              d=(Nodo) m.get(d.getId());

              a.setIdNodoOrigen(rs.getInt(2));
              a.setNodo(d);

             arcos.add(a);


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
    return arcos;
    }

    @Override
    public Object get(String condicion) {
        Arco a=null;
        try {
         conectar();
            PreparedStatement st = (PreparedStatement) conexion.prepareStatement("select * from Arco where "+condicion);

           // st.setInt(1, id);





                ResultSet rs = st.executeQuery();
            if(rs.next()){
                a=new Arco();
                a.setId(rs.getInt(1));
                   a.setValido(rs.getBoolean(4));
            /*  Nodo o=new Nodo();
              o.setId(rs.getInt(2));
              ManejadorNodo m=new ManejadorNodo();
              o=(Nodo) m.get(o.getId());*/

              Nodo d=new Nodo();
              d.setId(rs.getInt(3));
               ManejadorNodo m=new ManejadorNodo();
              d=(Nodo) m.get(d.getId());

              a.setIdNodoOrigen(rs.getInt(2));
              a.setNodo(d);




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
    return a;
    }

    @Override
    public void update(Object o) {

                    try {
          Arco arco=(Arco) o;
         conectar();

           PreparedStatement st = (PreparedStatement) conexion.prepareStatement("Update arco set valido=? where idArco=?");



             st.setInt(2, arco.getId());
             st.setBoolean(1, arco.isValido());

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




      public void deleteAllNodoVecino(int idNodoVecino) {
         try {
         conectar();
            PreparedStatement st = (PreparedStatement) conexion.prepareStatement("delete from Arco  where idNodoVecino=?");

            st.setInt(1, idNodoVecino);



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
            PreparedStatement st = (PreparedStatement) conexion.prepareStatement("delete from Arco  where idArco!=-1");


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
