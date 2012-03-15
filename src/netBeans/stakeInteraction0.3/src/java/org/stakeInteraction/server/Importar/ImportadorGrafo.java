/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.stakeInteraction.server.Importar;

import java.util.Collection;
import java.util.Iterator;
import java.util.Vector;
import org.stakeInteraction.server.Sesion.SesionAdmin;
import org.stakeInteraction.shared.grafo.Arco;
import org.stakeInteraction.shared.grafo.Nodo;

/**
 *
 * @author Jorge
 */
public abstract class ImportadorGrafo {
protected SesionAdmin sesion;

public ImportadorGrafo(SesionAdmin sesion){
   this.sesion=sesion;
}

    public  abstract void importar();

        
}
