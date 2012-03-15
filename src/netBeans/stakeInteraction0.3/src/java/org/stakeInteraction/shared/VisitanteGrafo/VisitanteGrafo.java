/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.stakeInteraction.shared.VisitanteGrafo;

import org.stakeInteraction.shared.Informacion.Documento;
import org.stakeInteraction.shared.Informacion.Usuario;
import org.stakeInteraction.shared.grafo.Arco;
import org.stakeInteraction.shared.grafo.Grafo;
import org.stakeInteraction.shared.grafo.Nodo;

/**
 *
 * @author Jorge
 */
public interface VisitanteGrafo {

    public void visitarGrafo(Grafo grafo);
    public void visitarNodo(Nodo nodo);
    public void visitarArco(Arco arco);
    public void visitarUsuario(Usuario usuario);
    public void visitarDocumento(Documento documento);

}
