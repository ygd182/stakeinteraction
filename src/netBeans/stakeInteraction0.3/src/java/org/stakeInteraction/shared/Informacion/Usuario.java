/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.stakeInteraction.shared.Informacion;

import org.stakeInteraction.shared.EstrategiaDibujar.EstrategiaDibujarUser;
import org.stakeInteraction.shared.VisitanteGrafo.ElementoVisitado;
import org.stakeInteraction.shared.VisitanteGrafo.VisitanteGrafo;





/**
 *
 * @author grela
 */
public class Usuario extends Informacion implements ElementoVisitado {
private String cargo,nombreReal,apellido;
        private String edad;

  public Usuario(){
       super();
  }



   public Usuario(int id,String nombreUsuario,String link,EstrategiaDibujarUser estrategia)
    {
        super(id,nombreUsuario,link);
       this.setEstrategiaDibujarNodo(estrategia);
     
    }


  public Usuario(int id,String nombreUsuario,String link,EstrategiaDibujarUser estrategia,String nombreReal,String apellido,String edad,String cargo)
    {
        super(id,nombreUsuario,link);
       this.setEstrategiaDibujarNodo(estrategia);


        this.apellido = apellido;
        this.cargo = cargo;
        this.edad = edad;
        this.nombreReal = nombreReal;

    }

   public Usuario(String nombreUsuario,String link,EstrategiaDibujarUser estrategia)
    {
        super(nombreUsuario,link);
       this.setEstrategiaDibujarNodo(estrategia);

    }


  public Usuario(String nombreUsuario,String link,EstrategiaDibujarUser estrategia,String nombreReal,String apellido,String edad,String cargo)
    {
        super(nombreUsuario,link);
       this.setEstrategiaDibujarNodo(estrategia);


        this.apellido = apellido;
        this.cargo = cargo;
        this.edad = edad;
        this.nombreReal = nombreReal;

    }


    /**
     * @return the cargo
     */
    public String getCargo() {
        return cargo;
    }

    /**
     * @param cargo the cargo to set
     */
    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    /**
     * @return the apellido
     */
    public String getApellido() {
        return apellido;
    }

    /**
     * @param apellido the apellido to set
     */
    public void setApellido(String apellido) {
        this.apellido = apellido;

    }

    /**
     * @return the edad
     */
    public String getEdad() {
        return edad;
    }

    /**
     * @param edad the edad to set
     */
    public void setEdad(String edad) {
        this.edad = edad;
    }

    /**
     * @return the nombreReal
     */
    public String getNombreReal() {
        return nombreReal;
    }

    /**
     * @param nombreReal the nombreReal to set
     */
    public void setNombreReal(String nombreReal) {
        this.nombreReal = nombreReal;
    }

    @Override
    public void aceptar(VisitanteGrafo v) {
       v.visitarUsuario(this);
    }




    



}