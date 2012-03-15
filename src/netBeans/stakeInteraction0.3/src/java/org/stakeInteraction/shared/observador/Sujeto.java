/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.stakeInteraction.shared.observador;

import java.util.Iterator;
import java.util.Vector;

/**
 *
 * @author grela
 */
public class Sujeto {
    Vector<Observador> observadores;

    public Sujeto()
    {
        observadores=new Vector<Observador>();
    }
    public void adscribir(Observador o)
    {
        this.observadores.add(o);
    }
    public void quitar(Observador o)
    {
        this.observadores.remove(o);
    }
    public void notificar()
    {
        for(Iterator<Observador> i=observadores.iterator();i.hasNext();)
        {
            i.next().actualizar(this);
        }
    }


}
