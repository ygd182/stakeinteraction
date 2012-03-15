/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.stakeInteraction.client.ventanaGrafo;

import org.stakeInteraction.client.GWTServiceUsage;
import org.stakeInteraction.client.ventanaGrafo.mediador.ContenedorGrafo;
import org.stakeInteraction.client.ventanaGrafo.mediador.DirectorDialogoGrafo;
import org.stakeInteraction.shared.grafo.Grafo;


/**
 *
 * @author grela
 */
public class VentanaGrafoUser {
    public  VentanaGrafoUser()
    {
               //---------sacar esto y dejar login
      //observer observable
      Grafo grafo=new Grafo();
      ContenedorGrafo contenedorGrafo=new ContenedorGrafo(grafo);
      grafo.adscribir(contenedorGrafo);
     //observer observable

     DirectorDialogoGrafo director=new DirectorDialogoGrafo(contenedorGrafo);
     director.crearUtiles();
     director.agregarControlDeUsuarios();
     director.mostrarDialogo();


     GWTServiceUsage.pedirGrafoBase(grafo);
    }

}
