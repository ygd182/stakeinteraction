/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.stakeInteraction.server.ExportarGrafo;

import org.stakeInteraction.server.EscribirArchivo;
import org.stakeInteraction.server.Sesion.Sesion;
import org.stakeInteraction.shared.grafo.Grafo;

/**
 *
 * @author Jorge
 */
public class ExportadorGrafoGML extends ExportadorGrafo {

    public ExportadorGrafoGML(Sesion sesion){
       super(sesion);
       this.visitante =new VisitanteExportarGML();
        
    }

    @Override
    public void exportar() {
         Grafo g=sesion.getGrafoFiltradoCompleto(sesion.getCuenta().getGrafo().getId());
       
               g.aceptar(this.visitante);

               EscribirArchivo.write("grafoExportar.gml", ((VisitanteExportarGML)this.visitante).getLineas());
    }

}
