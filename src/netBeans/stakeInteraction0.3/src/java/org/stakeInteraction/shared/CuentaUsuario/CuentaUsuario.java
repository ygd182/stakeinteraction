/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.stakeInteraction.shared.CuentaUsuario;

import java.io.Serializable;
import org.stakeInteraction.shared.EstrategiaComportamiento.EstrategiaComportamiento;

import org.stakeInteraction.shared.grafo.Grafo;

/**
 *
 * @author Jorge
 */
public class CuentaUsuario  implements Serializable {
 private int id;
 private String nombre;
 private String contraseña;
// private Nodo nodo;
 private Grafo grafo;
 private int idNodo;
 private EstrategiaComportamiento estrategia;


  public CuentaUsuario(){};


 public CuentaUsuario(int id,String nombre,String contraseña){
     this.id=id;
     this.nombre=nombre;
     this.contraseña=contraseña;
   //  this.nodo=null;
 }

  public CuentaUsuario(int id,String nombre,String contraseña,Grafo grafo,int idNodo,EstrategiaComportamiento estrategia){
     this.id=id;
     this.nombre=nombre;
     this.contraseña=contraseña;
     this.estrategia=estrategia;
     this.grafo=grafo;
     this.idNodo=idNodo;
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
        this.setId(id);
 }

 public int getId(){
     return id;
 }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the contraseña
     */
    public String getContraseña() {
        return contraseña;
    }

    /**
     * @param contraseña the contraseña to set
     */
    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    /**
     * @return the grafo
     */
    public Grafo getGrafo() {
        return grafo;
    }

    /**
     * @param grafo the grafo to set
     */
    public void setGrafo(Grafo grafo) {
        this.grafo = grafo;
    }

    /**
     * @return the idNodo
     */
    public int getIdNodo() {
        return idNodo;
    }

    /**
     * @param idNodo the idNodo to set
     */
    public void setIdNodo(int idNodo) {
        this.idNodo = idNodo;
    }

    /**
     * @return the estrategia
     */
    public EstrategiaComportamiento getEstrategia() {
        return estrategia;
    }

    /**
     * @param estrategia the estrategia to set
     */
    public void setEstrategia(EstrategiaComportamiento estrategia) {
        this.estrategia = estrategia;
    }

    /**
     * @return the nodo
     */
/*    public Nodo getNodo() {
        return nodo;
    }

    /**
     * @param nodo the nodo to set
     */
  /*  public void setNodo(Nodo nodo) {
        this.nodo = nodo;
    }*/


}
