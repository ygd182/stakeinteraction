/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.stakeInteraction.server.ValidarCambiosGrafo;

import org.stakeInteraction.server.Sesion.SesionAdmin;
import org.stakeInteraction.shared.VisitanteGrafo.VisitanteGrafo;
import org.stakeInteraction.shared.grafo.Grafo;

/**
 *
 * @author Jorge
 */
public abstract class ValidadorGrafo {
protected SesionAdmin sesion;
protected VisitanteGrafo visitante;

    public ValidadorGrafo(SesionAdmin sesion){
        this.sesion=sesion;
    }

     public ValidadorGrafo(SesionAdmin sesion,VisitanteGrafo visitante){
        this.sesion=sesion;
        this.visitante=visitante;
    }


    public abstract void validarGrafo();
}
