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
import org.stakeInteraction.shared.EstrategiaDibujar.EstrategiaDibujarUser;
import org.stakeInteraction.shared.Informacion.Usuario;

/**
 *
 * @author Jorge
 */
public class ManejadorUsuario extends ManejadorInformacion {





  private int agregarUsuario(Usuario u){

       int idAgregado=-1;
       

      int id=agregarInformacion(u,"usuario");
        if(id!=-1){
          idAgregado=id;
        try {
         conectar();

           PreparedStatement st = (PreparedStatement) conexion.prepareStatement("INSERT INTO usuario  VALUES (?, ?,?,?,?)");
             st.setInt(1, id);

             st.setString(2, u.getNombreReal());
             st.setString(3, u.getApellido());
             st.setString(4, u.getEdad());
             st.setString(5, u.getCargo());

                st.executeUpdate();

                u.setID(id);

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
       return idAgregado;
}


   private Usuario getUsuario(int id){
        Usuario u=(Usuario) getInformacionPorIdInfo(id);
        if(u!=null){
          try{
              conectar();
              PreparedStatement st = (PreparedStatement) conexion.prepareStatement("select u.* from Usuario u where  u.idInformacion=?");
            st.setInt(1, u.getId());
               ResultSet rs = st.executeQuery();
              if(rs.next()){
                 //   EstrategiaDibujarUser estrategia=new EstrategiaDibujarUser();
           // u=new Usuario(id,nombre,link,estrategia);   //crear usuario
              u.setNombreReal(rs.getString(2));
             u.setApellido(rs.getString(3));
              u.setEdad(rs.getString(4));
            u.setCargo(rs.getString(5));
       //     System.out.println(rs.getString(4));
                 }

                 //  desconectar();

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ManejadorInformacion.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ManejadorInformacion.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
         if (null != conexion)
             try {
                desconectar();
              //  System.out.println("desconecto");
            } catch (SQLException ex) {
                Logger.getLogger(ManejadorCuentaUsuario.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
       }
          return u;

}

/*
    public Usuario getUsuario(int id){
     Usuario u=null;
          try{
              conectar();
              PreparedStatement st = (PreparedStatement) conexion.prepareStatement("select i.nombre,i.link,u.* from Usuario u, Informacion i where  u.idInformacion=? and i.idinformacion=?");
            st.setInt(1, id);
               st.setInt(2, id);
               ResultSet rs = st.executeQuery();
              if(rs.next()){
                   EstrategiaDibujarUser estrategia=new EstrategiaDibujarUser();
            u=new Usuario(id,rs.getString(1),rs.getString(2),estrategia);   //crear usuario
              u.setNombreReal(rs.getString(4));
             u.setApellido(rs.getString(5));
              u.setEdad(rs.getInt(6));
            u.setCargo(rs.getString(7));
      //      System.out.println(rs.getString(5)+u.getCargo());
                 }

                 //  desconectar();

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ManejadorInformacion.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ManejadorInformacion.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
         if (null != conexion)
             try {
                desconectar();
              //  System.out.println("desconecto");
            } catch (SQLException ex) {
                Logger.getLogger(ManejadorCuentaUsuario.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
          return u;

}*/

      @Override
    public int insert(Object o) {
      return agregarUsuario((Usuario) o);
    }

    @Override
    public void delete(int id) {
         try {
         conectar();
            PreparedStatement st = (PreparedStatement) conexion.prepareStatement("delete from Usuario  where idInformacion=?");

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

         //delete a informacion
        super.delete(id);
    }

    @Override
    public Object get(int id) {
        return  getUsuario(id);
    }

    @Override
    public Vector<Object> getAll(String condicion) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Object get(String condicion) {
        throw new UnsupportedOperationException("Not supported yet.");
    }



       @Override
    public void update(Object o) {
     super.update(o);
       try {
         Usuario user=(Usuario) o;
         conectar();

           PreparedStatement st = (PreparedStatement) conexion.prepareStatement("UPDATE Usuario set nombre=? , apellido=? , edad=? , cargo=?  where idinformacion=?");



             st.setInt(5, user.getId());

             st.setString(1, user.getNombreReal());
             st.setString(2, user.getApellido());
             st.setString(3, user.getEdad());
             st.setString(4, user.getCargo());


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
            PreparedStatement st = (PreparedStatement) conexion.prepareStatement("delete from Usuario where idInformacion!=-1");





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
