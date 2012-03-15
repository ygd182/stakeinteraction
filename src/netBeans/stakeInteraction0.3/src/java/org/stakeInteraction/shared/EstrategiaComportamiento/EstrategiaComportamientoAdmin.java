/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.stakeInteraction.shared.EstrategiaComportamiento;

import java.io.Serializable;
import org.stakeInteraction.client.GWTServiceUsage;
import org.stakeInteraction.shared.CuentaUsuario.CuentaUsuario;
import org.stakeInteraction.shared.EstrategiaDibujar.EstrategiaDibujarPantallaPrincipal;
import org.stakeInteraction.shared.EstrategiaDibujar.EstrategiaDibujarPantallaPrincipalAdmin;

/**
 *
 * @author Jorge
 */
public class EstrategiaComportamientoAdmin implements EstrategiaComportamiento,Serializable {

    @Override
    public void crearSesion(CuentaUsuario cuenta) {
        GWTServiceUsage.crearSesionAdmin(cuenta);

    }

    @Override
    public EstrategiaDibujarPantallaPrincipal crearEstrategiaDibujarPantalla() {
        return new EstrategiaDibujarPantallaPrincipalAdmin();
    }

}
