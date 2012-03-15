/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.stakeInteraction.server.filtro;

import org.stakeInteraction.shared.grafo.Nodo;

/**
 *
 * @author Jorge
 */
public interface FiltroNodo {

    public abstract boolean filtrar(Nodo nodo);

}
