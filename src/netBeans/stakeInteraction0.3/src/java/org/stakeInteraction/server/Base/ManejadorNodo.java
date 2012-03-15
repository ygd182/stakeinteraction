/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.stakeInteraction.server.Base;

import com.google.gwt.gen2.table.client.HasTableDefinition;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.Hashtable;
import java.util.List;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.stakeInteraction.shared.Informacion.Informacion;
import org.stakeInteraction.shared.grafo.Arco;
import org.stakeInteraction.shared.grafo.Nodo;

/**
 *
 * @author Jorge
 */
public class ManejadorNodo extends ManejadorBase{



      public Vector<Nodo> cargarListaNodos(){
         Hashtable<Integer,Nodo> nodos=null;
          try {
           conectar();
             nodos = getHashNodos();
            CargarAdyacentes(nodos);


        } catch (ClassNotFoundException ex) {
              System.out.println("problema con la ManejadorNodo class not found");
            Logger.getLogger(ManejadorNodo.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
              System.out.println("problema con la ManejadorNodo");
            Logger.getLogger(ManejadorNodo.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
         if (null != conexion)
             try {
                desconectar();
            } catch (SQLException ex) {
                Logger.getLogger(ManejadorInformacion.class.getName()).log(Level.SEVERE, null, ex);
            }
      }
      
         Vector<Nodo> v=new Vector<Nodo>(nodos.values());
        return v ;
   }

   /* private  Hashtable<Integer,Nodo> cargarNodos(   ResultSet rs) throws SQLException{
      Hashtable<Integer,Nodo> nodos=new Hashtable<Integer,Nodo>();
        int idInformacion=-1;
        while(rs.next()){
              Nodo n=new Nodo();
              n.setId(rs.getInt(1));
             

              //cargar informacion y arcos
             idInformacion= rs.getInt(2);
             if(idInformacion!=-1){
                 ManejadorInformacion m=new ManejadorInformacion();
                 n.setInformacion(m.getInformacionPorIdInfo(idInformacion));
            }

             nodos.put(n.getId(),n);


            }
        return nodos;

    }*/

    private  Hashtable<Integer,Nodo> getHashNodos(){
         Hashtable<Integer,Nodo> nodos=null;
        try {
         
            nodos=new Hashtable<Integer, Nodo>();
             Statement s=(Statement) conexion.createStatement();
            ResultSet rs=s.executeQuery("select * from Nodo");
           //  nodos=cargarNodos( rs);

              int idInformacion=-1;
              Nodo n=null;
        while(rs.next()){
               n=new Nodo();
              n.setId(rs.getInt(1));
              n.setValido(rs.getBoolean(3));

              //cargar informacion y arcos
             idInformacion= rs.getInt(2);
             if(idInformacion!=-1){
                 ManejadorInformacion m=new ManejadorInformacion();
                 n.setInformacion(m.getInformacionPorIdInfo(idInformacion));
            }

             nodos.put(n.getId(),n);

            
       
          }
     }

   catch (SQLException ex) {
            Logger.getLogger(ManejadorNodo.class.getName()).log(Level.SEVERE, null, ex);
        }
   return nodos ;
    }

    /*private Nodo buscarNodo(int id,Vector<Nodo> nodos){
       Nodo n=null;
        for(int i=0;i<nodos.size();i++){
            n=nodos.elementAt(i);
            if(n.getId()==id)
                 return n;
        }
       return null;
    }*/


    private void CargarAdyacentes(Hashtable<Integer, Nodo>  nodos){
        try {
            Statement s = (Statement) conexion.createStatement();
            ResultSet rs = s.executeQuery("select * from Arco");
            Vector<Arco> arcos = new Vector<Arco>();
            Arco a;
             Nodo nodoVecino;
             Nodo nodo;
            while (rs.next()) {
                a = new Arco();
                a.setId(rs.getInt(1));

                a.setValido(rs.getBoolean(4));
                
                nodoVecino=nodos.get(rs.getInt(3)); //id nodovecino
                a.setNodo(nodoVecino);
                a.setIdNodoOrigen(rs.getInt(2));
               nodo=nodos.get(rs.getInt(2)); //id nodo
               nodo.agregarAdyacente(a);

               arcos.add(a);
            }
         //   return arcos;

        } catch (SQLException ex) {
            Logger.getLogger(ManejadorNodo.class.getName()).log(Level.SEVERE, null, ex);
          //   return null;
        }
    }



















  public void agregarAdyacentes(Nodo nodo){   //primero tiene q estar guardada info despues nodos despues arcos y ahi cargo los adyacentes

      List<Arco> adyacentes=nodo.getAdyacentes();
      ManejadorArco m=new ManejadorArco();
      for(int i=0;i<adyacentes.size();i++){
          m.insert(adyacentes.get(i));
      }



}





  /*  if(id!=-1){

                         st.executeUpdate();

                         ResultSet  rs = st.executeQuery("SELECT LAST_INSERT_ID()");

                         if (rs.next()) { //obtener la ultima id generada
                          id=rs.getInt(1);
                              }
            }
          else{
                  st.setInt(1, id);
                  st.executeUpdate();
          }
 */


  private int agregarNodoSinID(Nodo nodo){
     int id=-1;
      try {
         conectar();

           PreparedStatement st = (PreparedStatement) conexion.prepareStatement("INSERT INTO nodo (idInformacion,valido) VALUES (?,?)");

                st.setInt(1, nodo.getInformacion().getId());

            //    System.out.println("valido manejador nodo:"+nodo.isValido());
                st.setBoolean(2, nodo.isValido());

                st.executeUpdate();


                  ResultSet  rs = st.executeQuery("SELECT LAST_INSERT_ID()");

                  if (rs.next()) { //obetener la ultima id generada
                            id=rs.getInt(1);
                               nodo.setId(id);
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

   private int agregarNodoConID(Nodo nodo){

       try {
         conectar();

           PreparedStatement st = (PreparedStatement) conexion.prepareStatement("INSERT INTO nodo (idNodo,idInformacion,valido) VALUES (?,?,?)");

                st.setInt(1, nodo.getId());
                st.setInt(2, nodo.getInformacion().getId());

            //    System.out.println("valido manejador nodo:"+nodo.isValido());
                st.setBoolean(3, nodo.isValido());

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

        return nodo.getId();
  }

    @Override
    public int insert(Object o) {
      
        
        Nodo nodo=(Nodo) o;
        int id=nodo.getId();
       if(id==-1)
           return agregarNodoSinID(nodo);
       else
           return agregarNodoConID(nodo);

    }

    @Override
    public void delete(int id) {
         try {
         conectar();
            PreparedStatement st = (PreparedStatement) conexion.prepareStatement("delete from Nodo  where idNodo=?");

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
       Nodo n=null;
    try {
         conectar();
            PreparedStatement st = (PreparedStatement) conexion.prepareStatement("select * from Nodo where idNodo=?");

            st.setInt(1, id);





                ResultSet rs = st.executeQuery();
            if(rs.next()){
                n=new Nodo();
                n.setId(rs.getInt(1));
                 n.setValido(rs.getBoolean(3));
              //  n.setNombre(rs.getString(2));
                ManejadorInformacion m=new ManejadorInformacion();
                n.setInformacion((Informacion) m.get(rs.getInt(2)));
            /*    ManejadorArco ma=new ManejadorArco();
                ma.getAll("where idNodo="+n.getId());*/


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
    return n;
    }

    @Override
    public Vector<Object> getAll(String condicion) {
        


     Vector<Object> nodos=null;
    try {
         conectar();
            PreparedStatement st = (PreparedStatement) conexion.prepareStatement("select * from Nodo where condicion");







                ResultSet rs = st.executeQuery();
                nodos=new Vector<Object>();
                 Nodo n=null;
            while(rs.next()){
                n=new Nodo();
                n.setId(rs.getInt(1));
                 n.setValido(rs.getBoolean(3));
              //  n.setNombre(rs.getString(2));
                ManejadorInformacion m=new ManejadorInformacion();
                n.setInformacion((Informacion) m.get(rs.getInt(2)));
            /*    ManejadorArco ma=new ManejadorArco();
                ma.getAll("where idNodo="+n.getId());*/

                nodos.add(n);
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

    @Override
    public Object get(String condicion) {
        Nodo n=null;
    try {
         conectar();
            PreparedStatement st = (PreparedStatement) conexion.prepareStatement("select * from Nodo where condicion");

          





                ResultSet rs = st.executeQuery();
            if(rs.next()){
                n=new Nodo();
                n.setId(rs.getInt(1));
                 n.setValido(rs.getBoolean(3));
              //  n.setNombre(rs.getString(2));
                ManejadorInformacion m=new ManejadorInformacion();
                n.setInformacion((Informacion) m.get(rs.getInt(2)));
            /*    ManejadorArco ma=new ManejadorArco();
                ma.getAll("where idNodo="+n.getId());*/


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
    return n;
    }

    @Override
    public void update(Object o) {
      try {
          Nodo nodo=(Nodo) o;
         conectar();

           PreparedStatement st = (PreparedStatement) conexion.prepareStatement("UPDATE nodo set valido=?, idinformacion=? where idNodo=?");



             st.setInt(2, nodo.getInformacion().getId());

             st.setInt(3, nodo.getId());
             st.setBoolean(1, nodo.isValido());

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
            PreparedStatement st = (PreparedStatement) conexion.prepareStatement("delete from Nodo  where idNodo!=-1");

          



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
