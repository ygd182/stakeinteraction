/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.stakeInteraction.server.Sesion;

import org.stakeInteraction.server.Base.ManejadorCuentaUsuario;
import org.stakeInteraction.shared.CuentaUsuario.CuentaUsuario;

/**
 *
 * @author Jorge
 */
public class Conexion {


    public CuentaUsuario conectar(String nombre, String contraseña) {

         ManejadorCuentaUsuario m=new ManejadorCuentaUsuario();
        //  CuentaUsuario c=m.getCuentaUsuario(nombre,contraseña);
        CuentaUsuario cuenta = (CuentaUsuario) m.get("nombre='"+nombre+"' and contraseña='"+contraseña+"'");
     //    System.out.println("cuentaUsuario :"+c.getId()+" "+c.getNombre());
        return cuenta;

    }
}
