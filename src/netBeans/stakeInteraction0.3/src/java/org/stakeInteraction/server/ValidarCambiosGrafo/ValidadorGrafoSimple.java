/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.stakeInteraction.server.ValidarCambiosGrafo;

import org.stakeInteraction.server.Sesion.SesionAdmin;
import org.stakeInteraction.shared.grafo.Grafo;

/**
 *
 * @author Jorge
 */
public class ValidadorGrafoSimple extends ValidadorGrafo {

    public ValidadorGrafoSimple(SesionAdmin sesion){
        super(sesion);
    }
    @Override
    public void validarGrafo() {
          Grafo g=sesion.getGrafoFiltradoCompleto(sesion.getCuenta().getGrafo().getId());

       visitante=new VisitanteValidadorSimple(sesion);
        g.aceptar(visitante);
    }

}
