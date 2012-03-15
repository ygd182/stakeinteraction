/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.stakeInteraction.server.ExportarGrafo;

import org.stakeInteraction.server.EscribirArchivo;
import org.stakeInteraction.server.Sesion.Sesion;
import org.stakeInteraction.shared.VisitanteGrafo.VisitanteGrafo;
import org.stakeInteraction.shared.grafo.Grafo;

/**
 *
 * @author Jorge
 */
public abstract class ExportadorGrafo {
protected Sesion sesion;
VisitanteGrafo visitante;
    public ExportadorGrafo(Sesion sesion, VisitanteGrafo visitante){
        this.sesion=sesion;
        this.visitante=visitante;
    }

    public ExportadorGrafo(Sesion sesion){
        this.sesion=sesion;
    }

    public abstract void exportar();
         
    
}
