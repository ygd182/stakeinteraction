/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.stakeInteraction.shared.Informacion;


import org.stakeInteraction.shared.EstrategiaDibujar.EstrategiaDibujarDoc;
import org.stakeInteraction.shared.VisitanteGrafo.ElementoVisitado;
import org.stakeInteraction.shared.VisitanteGrafo.VisitanteGrafo;




/**
 *
 * @author grela
 */
public class Documento extends Informacion implements ElementoVisitado {

  
    private String cuerpoDocumento;

  

    



     public Documento(){
     super();
     }


    public Documento(int id,String nombreDocumento,String link,String cuerpoDocumento,EstrategiaDibujarDoc estrategia)
    {
        super(id,nombreDocumento,link);
        this.setEstrategiaDibujarNodo(estrategia);

      this.cuerpoDocumento = cuerpoDocumento;

        //dragController.makeDraggable(caja);
    }
 
    public Documento(int id,String nombreDocumento,String link,EstrategiaDibujarDoc estrategia)
    {
        super(id,nombreDocumento,link);
        this.setEstrategiaDibujarNodo(estrategia);

      

        //dragController.makeDraggable(caja);
    }


     public Documento(String nombreDocumento,String link,String cuerpoDocumento,EstrategiaDibujarDoc estrategia)
    {
        super(nombreDocumento,link);
        this.setEstrategiaDibujarNodo(estrategia);

      this.cuerpoDocumento = cuerpoDocumento;

        //dragController.makeDraggable(caja);
    }

    public Documento(String nombreDocumento,String link,EstrategiaDibujarDoc estrategia)
    {
        super(nombreDocumento,link);
        this.setEstrategiaDibujarNodo(estrategia);



        //dragController.makeDraggable(caja);
    }


    /**
     * @return the cuerpoDocumento
     */
    public String getCuerpoDocumento() {
        return cuerpoDocumento;
    }

    /**
     * @param cuerpoDocumento the cuerpoDocumento to set
     */
    public void setCuerpoDocumento(String cuerpoDocumento) {
        this.cuerpoDocumento = cuerpoDocumento;
    }

    @Override
    public void aceptar(VisitanteGrafo v) {
        v.visitarDocumento(this);
    }


  

}
