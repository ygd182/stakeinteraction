/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.stakeInteraction.server.ExportarGrafo;

import java.util.List;
import java.util.Vector;
import org.stakeInteraction.shared.VisitanteGrafo.VisitanteGrafo;
import org.stakeInteraction.shared.Informacion.Documento;
import org.stakeInteraction.shared.Informacion.Usuario;
import org.stakeInteraction.shared.grafo.Arco;
import org.stakeInteraction.shared.grafo.Grafo;
import org.stakeInteraction.shared.grafo.Nodo;

/**
 *
 * @author Jorge
 */
public class VisitanteExportarGML implements VisitanteGrafo {
 private    Vector<String> lineas;
     Vector<String> nodos;
        Vector<String>  arcos;

    public VisitanteExportarGML(){
        lineas=new Vector<String>();
        nodos=new Vector<String>();
        arcos=new Vector<String>();
    }

    @Override
    public void visitarGrafo(Grafo grafo) {
           Vector<Nodo> allNodos=grafo.getAllNodos();

     // Vector<String> nodosgml=new Vector<String>();
           arcos=new Vector<String>();
        lineas.add("graph");
        lineas.add("[");
       // lineas.add("id "+grafo.getId());
       // lineas.addAll(nodosgml);
        Nodo n=null;
        for(int i=0;i<allNodos.size();i++){
            n= allNodos.elementAt(i);
            n.aceptar(this);


      }
          lineas.addAll(nodos);
          lineas.addAll(arcos);
          lineas.add("]");
        imprimir(lineas);
    }

    @Override
    public void visitarNodo(Nodo nodo) {

           nodos.add("node");
           nodos.add("[");

           nodos.add("id "+nodo.getId());
        //   nodos.add("label ");
           nodo.getInformacion().aceptar(this);

           nodos.add("]");

             List<Arco> ady=nodo.getAdyacentes();
                Arco a=null;
               for(int i=0;i<ady.size();i++){
                   a=ady.get(i);
                   a.aceptar(this);

               }



    }

    @Override
    public void visitarArco(Arco arco) {

        Vector<String> aux=new Vector<String>();
        Nodo n=null;

           n=arco.getNodo();

           aux.add("edge");
               aux.add("[");
               aux.add("id "+arco.getId());
           aux.add("source "+arco.getIdNodoOrigen());
           aux.add("target "+arco.GetNodo().getId());
           aux.add("value 1");

           aux.add("]");

           arcos.addAll(aux);


    }

    @Override
    public void visitarUsuario(Usuario usuario) {
     //   System.out.println("visita usuario "+usuario.getNombreReal()+usuario.getApellido());
        nodos.add("tipo \"Usuario"+"\"");
       nodos.add("idUsuario "+usuario.getId());
       nodos.add("nombre "+"\""+usuario.getNombre()+"\"");
       nodos.add("link "+"\""+usuario.getLink()+"\"");
       nodos.add("nombreReal "+"\""+usuario.getNombreReal()+"\"");
       nodos.add("apellido "+"\""+usuario.getApellido()+"\"");
       nodos.add("edad "+"\""+usuario.getEdad()+"\"");
       nodos.add("cargo "+"\""+usuario.getCargo()+"\"");
    }

    @Override
    public void visitarDocumento(Documento documento) {
      //       System.out.println("visita documento"+documento.getCuerpoDocumento());
        nodos.add("tipo \"Documento\"");
        nodos.add("idDocumento "+documento.getId());
      nodos.add("nombre "+"\""+documento.getNombre()+"\"");
       nodos.add("link "+"\""+documento.getLink()+"\"");
        nodos.add("cuerpo "+"\""+documento.getCuerpoDocumento()+"\"");
    }

       private void imprimir(Vector<String> filas){
         for(int i=0;i<filas.size();i++){
             System.out.println(filas.elementAt(i));
    }
    }
         public Vector<String> getLineas(){
             return lineas;
         }

       
       
}
