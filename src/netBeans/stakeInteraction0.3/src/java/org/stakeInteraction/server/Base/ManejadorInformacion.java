/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.stakeInteraction.server.Base;



import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.stakeInteraction.shared.EstrategiaDibujar.EstrategiaDibujarDoc;
import org.stakeInteraction.shared.EstrategiaDibujar.EstrategiaDibujarUser;
import org.stakeInteraction.shared.Informacion.Documento;
import org.stakeInteraction.shared.Informacion.Informacion;
import org.stakeInteraction.shared.Informacion.Usuario;





/**
 *
 * @author Jorge
 */
public class ManejadorInformacion extends ManejadorBase {

   /*  private Vector<Usuario> cargarUsuarios(){
        try {
            Vector<Usuario> usuarios = new Vector<Usuario>();
            Statement s = (Statement) conexion.createStatement();
            ResultSet rs = s.executeQuery("select * from Usuario");
            while (rs.next()) {



            }

        } catch (SQLException ex) {
            Logger.getLogger(ManejadorInformacion.class.getName()).log(Level.SEVERE, null, ex);
        }
         return null;
 }

  private Vector<Documento> cargarDocumentos(){
        try {
            Vector<Documento> documentos = new Vector<Documento>();
            Statement s = (Statement) conexion.createStatement();
            ResultSet rs = s.executeQuery("select * from Documento");
            while (rs.next()) {



            }

        } catch (SQLException ex) {
            Logger.getLogger(ManejadorInformacion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }



private    Vector<Informacion>  cargarInformacion(){
        try {
            Vector<Informacion> info = new Vector<Informacion>();
            Statement s = (Statement) conexion.createStatement();
            ResultSet rs = s.executeQuery("select * from Informacion");
            while (rs.next()) {



            }
        } catch (SQLException ex) {
            Logger.getLogger(ManejadorInformacion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
}
*/

private Informacion getInformacionPorIdNodo(int idNodo){

    Informacion i = null;
    try {

            conexion = conectar();
            Statement s = (Statement) conexion.createStatement();
            ResultSet rs = s.executeQuery("select i.idInformacion,i.nombre,i.link from Nodo n, Informacion i where n.idNodo="+idNodo+" and n.idInformacion=i.idInformacion");


          if ( rs.next()){ //sin esto no anda
             int id=rs.getInt(1);
            String nombre=rs.getString(2);
            String link=rs.getString(3);

           rs = s.executeQuery("select d.* from Documento d, Informacion i where i.idInformacion="+id +" and d.idInformacion=i.idInformacion ");
            if(rs.next()){ // si devolvio algo la consulta
                   EstrategiaDibujarDoc estrategia=new EstrategiaDibujarDoc();
            i=new Documento(id,nombre,link,estrategia);   //crear doc
        }
            else{
             rs = s.executeQuery("select u.* from Usuario u, Informacion i where i.idInformacion="+id +" and u.idInformacion=i.idInformacion");
             if(rs.next()){
                    EstrategiaDibujarUser estrategia=new EstrategiaDibujarUser();
               i=new Usuario(id,nombre,link,estrategia);   //crear usuario
              ((Usuario)i).setNombreReal(rs.getString(2));
              ((Usuario)i).setApellido(rs.getString(3));
              ((Usuario)i).setEdad(rs.getString(4));
              ((Usuario)i).setCargo(rs.getString(5));
                 }
              }
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
               // System.out.println("desconecto");
            } catch (SQLException ex) {
                Logger.getLogger(ManejadorCuentaUsuario.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
          return i;
}


public Informacion getInformacionCompleta(int idInformacion){

    Informacion i = null;
    try {

            conectar();
             PreparedStatement st = (PreparedStatement) conexion.prepareStatement("select i.* from  Informacion i where i.idInformacion=?");
              st.setInt(1, idInformacion);
           ResultSet rs = st.executeQuery();

          if ( rs.next()){ //sin esto no anda
             int id=rs.getInt(1);
            String nombre=rs.getString(2);
            String link=rs.getString(3);

           rs = st.executeQuery("select d.* from Documento d, Informacion i where i.idInformacion="+id +" and d.idInformacion=i.idInformacion ");
            if(rs.next()){ // si devolvio algo la consulta
                   EstrategiaDibujarDoc estrategia=new EstrategiaDibujarDoc();
            i=new Documento(id,nombre,link,estrategia);   //crear doc
            ((Documento)i).setCuerpoDocumento(rs.getString(2));
        }
            else{
             rs = st.executeQuery("select u.* from Usuario u, Informacion i where i.idInformacion="+id +" and u.idInformacion=i.idInformacion");
             if(rs.next()){
                    EstrategiaDibujarUser estrategia=new EstrategiaDibujarUser();
               i=new Usuario(id,nombre,link,estrategia);   //crear usuario
              ((Usuario)i).setNombreReal(rs.getString(2));
              ((Usuario)i).setApellido(rs.getString(3));
              ((Usuario)i).setEdad(rs.getString(4));
              ((Usuario)i).setCargo(rs.getString(5));
                 }
              }
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
               // System.out.println("desconecto");
            } catch (SQLException ex) {
                Logger.getLogger(ManejadorCuentaUsuario.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
          return i;
}

//--------------------------------------------------------------------------------------


protected Informacion getInformacionPorIdInfo(int idInformacion){

    Informacion i = null;
    try {

          conectar();
             PreparedStatement st = (PreparedStatement) conexion.prepareStatement("select i.* from  Informacion i where i.idInformacion=?");
              st.setInt(1, idInformacion);
           ResultSet rs = st.executeQuery();
          if ( rs.next()){ //sin esto no anda


            int id=rs.getInt(1);
            String nombre=rs.getString(2);
            String link=rs.getString(3);
            String tipo=rs.getString(4);
        //    System.out.println("tipo: "+tipo);
            if(tipo.equals("usuario")){

                       EstrategiaDibujarUser estrategia=new EstrategiaDibujarUser();
               i=new Usuario(id,nombre,link,estrategia);
            }
          else{
                 EstrategiaDibujarDoc estrategia=new EstrategiaDibujarDoc();
               i=new Documento(id,nombre,link,estrategia);
          }



           
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
             //   System.out.println("desconecto");
            } catch (SQLException ex) {
                Logger.getLogger(ManejadorCuentaUsuario.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
          return i;
}








//---------------------------------------------------------------------------------------------------------



private int agregarInformacionConId(Informacion i,String tipo){
        try {
         conectar();
            PreparedStatement st = (PreparedStatement) conexion.prepareStatement("INSERT INTO informacion  VALUES (?, ?, ?,?)");

            st.setInt(1, i.getId());
            st.setString(2, i.getNombre());
             st.setString(3, i.getLink());
             st.setString(4, tipo);



            st.executeUpdate();



        //    desconectar();
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
      return i.getId();

}


protected int agregarInformacion(Informacion i,String tipo){
    if(i.getId()==-1)
        return agregarInformacionSinId(i, tipo);
    else
        return agregarInformacionConId(i,tipo);
}

private int agregarInformacionSinId(Informacion i,String tipo){
    int id=i.getId();
    try {
         conectar();
           PreparedStatement st = (PreparedStatement) conexion.prepareStatement("INSERT INTO informacion (nombre,link,tipo)  VALUES (?, ?,?)");


            st.setString(1, i.getNombre());
             st.setString(2, i.getLink());
             st.setString(3, tipo);
          

                         st.executeUpdate();

                         ResultSet  rs = st.executeQuery("SELECT LAST_INSERT_ID()");

                         if (rs.next()) { //obtener la ultima id generada
                          id=rs.getInt(1);
                              }
          

          //  desconectar();
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
        int idAgregado=-1;
        return idAgregado;
    }

    @Override
    public void delete(int id) {
          try {
         conectar();
            PreparedStatement st = (PreparedStatement) conexion.prepareStatement("delete from Informacion  where idInformacion=?");

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
        return  getInformacionPorIdInfo(id);
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
      try {
         Informacion info=(Informacion) o;
         conectar();

           PreparedStatement st = (PreparedStatement) conexion.prepareStatement("UPDATE informacion set nombre=?,link=?  where idinformacion=?");



             st.setInt(3, info.getId());

             st.setString(1, info.getNombre());
             st.setString(2, info.getLink());

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
            PreparedStatement st = (PreparedStatement) conexion.prepareStatement("delete from Informacion  where idInformacion!=-1");





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
