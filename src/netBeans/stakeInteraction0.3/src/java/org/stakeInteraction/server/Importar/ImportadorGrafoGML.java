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
public class ImportadorGrafoGML extends ImportadorGrafo {

    public ImportadorGrafoGML(SesionAdmin sesion){
        super(sesion);
    }
    @Override
    public void importar() {
        sesion.eliminarGrafo();

          ImportarGML l=new ImportarGML();
         l.importar();//esto arranca y carga todo
        //-----------------------------------------
        Collection<Nodo> nodosDoc=l.getNodosDoc();
        Iterator it=nodosDoc.iterator();
        Nodo nodoDoc=null;

       // for(int i=0;i<nodosDoc.size();i++){
        while(it.hasNext()){
            nodoDoc=(Nodo) it.next();

            sesion.guardarNodoDocumento(nodoDoc);
        }

        //---------------------------------------

      Collection<Nodo> nodosUser=l.getNodosUser();
       it=nodosUser.iterator();
              Nodo nodoUser=null;
       while(it.hasNext()){
            nodoUser=(Nodo) it.next();

           sesion.guardarNodoUsuario(nodoUser);
        }

           //-------------------------------
              Vector<Arco> arcos=l.getArcos();
              Arco arco=null;
         for(int i=0;i<arcos.size();i++){
           arco=arcos.elementAt(i);

            sesion.guardarArco(arco);
        }

    }

}
