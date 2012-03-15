/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.stakeInteraction.shared.EstrategiaComportamiento;

import java.io.Serializable;
import org.stakeInteraction.client.GWTServiceUsage;
import org.stakeInteraction.shared.CuentaUsuario.CuentaUsuario;
import org.stakeInteraction.shared.EstrategiaDibujar.EstrategiaDibujarPantallaPrincipal;
import org.stakeInteraction.shared.EstrategiaDibujar.EstrategiaDibujarPantallaPrincipalUser;

/**
 *
 * @author Jorge
 */
public class EstrategiaComportamientoUser implements EstrategiaComportamiento,Serializable {

    @Override
    public void crearSesion(CuentaUsuario cuenta) {
      GWTServiceUsage.crearSesionUser(cuenta);
    }

    @Override
    public EstrategiaDibujarPantallaPrincipal crearEstrategiaDibujarPantalla() {
        return new EstrategiaDibujarPantallaPrincipalUser();
    }

}
