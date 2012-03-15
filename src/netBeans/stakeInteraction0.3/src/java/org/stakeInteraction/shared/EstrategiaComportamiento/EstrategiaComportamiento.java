/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.stakeInteraction.shared.EstrategiaComportamiento;

import org.stakeInteraction.shared.CuentaUsuario.CuentaUsuario;
import org.stakeInteraction.shared.EstrategiaDibujar.EstrategiaDibujarPantallaPrincipal;

/**
 *
 * @author Jorge
 */
public interface EstrategiaComportamiento {

    public void crearSesion(CuentaUsuario cuenta);
    public EstrategiaDibujarPantallaPrincipal crearEstrategiaDibujarPantalla();
}
