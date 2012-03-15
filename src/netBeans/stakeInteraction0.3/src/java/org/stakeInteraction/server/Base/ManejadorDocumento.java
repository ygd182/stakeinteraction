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
import org.stakeInteraction.shared.Informacion.Documento;

/**
 *
 * @author Jorge
 */
public class ManejadorDocumento extends ManejadorInformacion {


  private void agregarDocumentoConId(Documento d){
        try {
         conectar();
            PreparedStatement st = (PreparedStatement) conexion.prepareStatement("INSERT INTO informacion  VALUES (?, ?, ?)");

            st.setInt(1, d.getId());
            st.setString(2, d.getNombre());
             st.setString(3, d.getLink());




            st.executeUpdate();

             st = (PreparedStatement) conexion.prepareStatement("INSERT INTO documento  VALUES (?, ?)");
             st.setInt(1, d.getId());
             st.setString(2, d.getCuerpoDocumento());

                st.executeUpdate();


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


}




    private int agregarDocumento(Documento d){
      int idAgregado=-1;
       
       int id=agregarInformacion(d, "documento");
        if(id!=-1){
        try {
            d.setID(id);
         conectar();
            PreparedStatement st =  (PreparedStatement) conexion.prepareStatement("INSERT INTO documento  VALUES (?, ?)");
             st.setInt(1, d.getId());
             st.setString(2, d.getCuerpoDocumento());

                st.executeUpdate();
               idAgregado=id;

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
    }
        return idAgregado;
}


    private Documento getDocumento(int id){

  Documento d=(Documento) getInformacionPorIdInfo(id);
  if(d!=null){
    try {

          conectar();
             PreparedStatement st = (PreparedStatement) conexion.prepareStatement("select d.* from Documento d where d.idInformacion=? ");
             st.setInt(1, d.getId());
           ResultSet rs = st.executeQuery();
       


            if(rs.next()){ // si devolvio algo la consulta
                 /*  EstrategiaDibujarDoc estrategia=new EstrategiaDibujarDoc();
            d=new Documento(id,nombre,link,estrategia);   //crear doc*/
                d.setCuerpoDocumento(rs.getString(2));
        
        }



        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ManejadorInformacion.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ManejadorInformacion.class.getName()).log(Level.SEVERE, null, ex);
        }
     finally {
         if (null != conexion)
             try {
                desconectar();
          //      System.out.println("desconecto");
            } catch (SQLException ex) {
                Logger.getLogger(ManejadorCuentaUsuario.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        }
          return d;
}

  @Override
    public int insert(Object o) {
       return agregarDocumento((Documento) o);
    }

    @Override
    public void delete(int id) {



          try {
         conectar();
            PreparedStatement st = (PreparedStatement) conexion.prepareStatement("delete from Documento  where idInformacion=?");

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
        return  getDocumento(id);
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
         Documento doc=(Documento) o;
         conectar();

           PreparedStatement st = (PreparedStatement) conexion.prepareStatement("UPDATE Documento set cuerpo=?  where idinformacion=?");



             st.setInt(2, doc.getId());

             st.setString(1, doc.getCuerpoDocumento());


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
            PreparedStatement st = (PreparedStatement) conexion.prepareStatement("delete from Documento  where idInformacion!=-1");





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
