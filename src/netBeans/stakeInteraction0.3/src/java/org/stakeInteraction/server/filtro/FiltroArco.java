/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.stakeInteraction.server.filtro;

import org.stakeInteraction.shared.grafo.Arco;

/**
 *
 * @author Jorge
 */
public interface FiltroArco {

      public abstract boolean filtrar(Arco arco);
}
