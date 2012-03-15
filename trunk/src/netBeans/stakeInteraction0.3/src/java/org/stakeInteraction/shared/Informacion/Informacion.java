/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.stakeInteraction.shared.Informacion;


import java.io.Serializable;
import org.stakeInteraction.shared.EstrategiaDibujar.EstrategiaDibujarNodo;
import org.stakeInteraction.shared.VisitanteGrafo.ElementoVisitado;
import org.stakeInteraction.shared.VisitanteGrafo.VisitanteGrafo;







/**
 *
 * @author grela
 */
public abstract class Informacion implements Serializable, ElementoVisitado {
    private int id;
    private String nombre;
    private String link; //para una foto o para acceder al documento
    private EstrategiaDibujarNodo estrategiaDibujar;



    public Informacion(){
    id=-1;
    }

   public Informacion(int id,String nombre,String link){
       this.id=id;
       this.nombre=nombre;
       this.link=link;
    }


    public Informacion(String nombre,String link){
       this.id=-1;
       this.nombre=nombre;
       this.link=link;
    }

    /**
     * @return the creadorNodo
     */
    public EstrategiaDibujarNodo getEstrategiaDibujarNodo() {
        return estrategiaDibujar;
    }

    /**
     * @param creadorNodo the creadorNodo to set
     */
    public void setEstrategiaDibujarNodo(EstrategiaDibujarNodo estrategiaDibujarNodo) {
        this.estrategiaDibujar = estrategiaDibujarNodo;
    }


      /**
     * @return the nombreUsuario
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombreUsuario the nombreUsuario to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


 public void setID(int id){
     this.id=id;
 }

 public int getId(){
     return id;
 }

    /**
     * @return the link
     */
    public String getLink() {
        return link;
    }

    /**
     * @param link the link to set
     */
    public void setLink(String link) {
        this.link = link;
    }

    @Override
    public  abstract void aceptar(VisitanteGrafo v);
    

}
