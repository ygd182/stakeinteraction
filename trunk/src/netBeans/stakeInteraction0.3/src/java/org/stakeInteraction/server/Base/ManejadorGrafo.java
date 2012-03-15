/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.stakeInteraction.server.Base;

import java.util.List;
import java.util.Vector;
import org.stakeInteraction.server.FiltradorGrafo.VisitanteFiltradorGrafo;

import org.stakeInteraction.server.filtro.FiltroArco;
import org.stakeInteraction.server.filtro.FiltroNodo;
import org.stakeInteraction.shared.CuentaUsuario.CuentaUsuario;
import org.stakeInteraction.shared.Informacion.Documento;
import org.stakeInteraction.shared.Informacion.Informacion;
import org.stakeInteraction.shared.Informacion.Usuario;
import org.stakeInteraction.shared.grafo.Arco;
import org.stakeInteraction.shared.grafo.Grafo;
import org.stakeInteraction.shared.grafo.Nodo;

/**
 *
 * @author Jorge
 */
public class ManejadorGrafo {
private Grafo grafo;
    public ManejadorGrafo(int idGrafo){
       grafo=new Grafo(idGrafo);
    }

    public static Grafo getGrafoCompleto(){
        Grafo g=new Grafo();
        ManejadorInformacion manejadorInformacion=new ManejadorInformacion();
        ManejadorNodo manejadorNodo=new ManejadorNodo();
        Vector<Nodo> nodos=manejadorNodo.cargarListaNodos();
        Nodo n=null;
        Informacion inf=null;
       for(int i=0;i<nodos.size();i++){
          n= nodos.get(i);
          inf= manejadorInformacion.getInformacionCompleta(n.getInformacion().getId());
          n.setInformacion(inf);
          g.agregarNodo(n);
       }
     //   grafo.clonar(g);
        return g;
    }


/*
    public Grafo getGrafoFiltrado(FiltroNodo f){
        ManejadorNodo m=new ManejadorNodo();
        Vector<Nodo> nodos=m.cargarListaNodos();
        Grafo g=new Grafo();
           //     System.out.println("CLIENTE");
                Nodo n=null;
                Arco a=null;
                List<Arco> ady=null;
       for(int i=0;i<nodos.size();i++){

                   n= nodos.get(i);

              if(f.comparar(n.getId())){
		

                   ady=n.getAdyacentes();  //esto es lo de los adyacentes
                   
                    for(int j=0;j<ady.size();j++){
                        a=ady.get(j);
                     
                        if(!(f.comparar(a.GetNodo().getId()))){
                            ady.remove(j);
                            j--;
                          
                        }
                     }
                   g.agregarNodo(n);
                    }
        }
        


        return g;
    }*/


      public Grafo getGrafoFiltrado(FiltroNodo fn, FiltroArco fa){
     /*   ManejadorNodo m=new ManejadorNodo();
        Vector<Nodo> nodos=m.cargarListaNodos();
        Grafo g=new Grafo();
           //     System.out.println("CLIENTE");
                Nodo n=null;
                Arco a=null;
                List<Arco> ady=null;
       for(int i=0;i<nodos.size();i++){

                   n= nodos.get(i);

              if(fn.comparar(n.getId())){


                   ady=n.getAdyacentes();  //esto es lo de los adyacentes

                    for(int j=0;j<ady.size();j++){
                        a=ady.get(j);

                        if(!(fa.comparar(a.getId()))){ //filtro los arcos
                            ady.remove(j);
                            j--;

                        }
                     }
                   g.agregarNodo(n);
                    }
        }*/


                ManejadorNodo m=new ManejadorNodo();
        Vector<Nodo> nodos=m.cargarListaNodos();
          Grafo g=cargarGrafo(nodos);
          VisitanteFiltradorGrafo v=new VisitanteFiltradorGrafo(fn, fa);
           g.aceptar(v);
          g=v.getGrafo();
        grafo.clonar(g);
        return g;
    }

   public Grafo getGrafoFiltradoCompleto(FiltroNodo fn, FiltroArco fa){
      //  ManejadorNodo m=new ManejadorNodo();
     /*  Grafo gCompleto=this.getGrafoCompleto();
        Vector<Nodo> nodos=gCompleto.getAllNodos();
        Grafo g=new Grafo();
           //     System.out.println("CLIENTE");
                Nodo n=null;
                Arco a=null;
                List<Arco> ady=null;
       for(int i=0;i<nodos.size();i++){

                   n= nodos.get(i);

              if(fn.comparar(n.getId())){


                   ady=n.getAdyacentes();  //esto es lo de los adyacentes

                    for(int j=0;j<ady.size();j++){
                        a=ady.get(j);

                        if(!(fa.comparar(a.getId()))){ //filtro los arcos
                            ady.remove(j);
                            j--;

                        }
                     }
                   g.agregarNodo(n);
                    }
        }*/



         Grafo g=getGrafoCompleto();
          VisitanteFiltradorGrafo v=new VisitanteFiltradorGrafo(fn, fa);
           g.aceptar(v);
          g=v.getGrafo();
       // grafo.clonar(g);
        return g;
    }


      private  Grafo cargarGrafo(Vector<Nodo> l){

                Grafo g=new Grafo();
           //     System.out.println("CLIENTE");
                Nodo n=null;
		 for(int i=0;i<l.size();i++){

                   n= l.get(i);


		g.agregarNodo(n);

		 }

                return g;
    }




      //---------------guardar grafo por usuario
  public void guardarGrafoPorUsuario(Grafo g){
         Vector<Nodo> nodos=g.getAllNodos();
         ManejadorNodosDeUsuario m=new ManejadorNodosDeUsuario();
         for(int i=0;i<nodos.size();i++){
           m.guardar( g.getId(),nodos.get(i).getId());
         }

      }



  public int guardarNodoDocumento(Nodo nodo){
     ManejadorDocumento m=new ManejadorDocumento();
     int idInfo= m.insert(nodo.getInformacion());
      nodo.getInformacion().setID(idInfo);


      ManejadorNodo mn= new ManejadorNodo();
      int idNodo= mn.insert(nodo);

      return idNodo;

  }

   public int guardarNodoUsuario(Nodo nodo){
     ManejadorUsuario m=new ManejadorUsuario();
     int idInfo= m.insert(nodo.getInformacion());
      nodo.getInformacion().setID(idInfo);


      ManejadorNodo mn= new ManejadorNodo();
      int idNodo= mn.insert(nodo);

      return idNodo;

  }




   private void eliminarArcosAdyacentes(Nodo nodo){
      List<Arco> adyacentes=nodo.getAdyacentes();
      ManejadorArco m=new ManejadorArco();
      for(int i=0;i<adyacentes.size();i++){
          m.delete(adyacentes.get(i).getId());  //los q apunto
      }
      m.deleteAllNodoVecino(nodo.getId()); //los q me apuntan


 }

public void eliminarNodoUsuario(Nodo nodo){
      


      ManejadorNodo mn= new ManejadorNodo();
      eliminarArcosAdyacentes(nodo);               //elimino Arcos adyacentes (los q salen del nodo y los q entran)
      mn.delete(nodo.getId());                       //elimino el nodo

       ManejadorUsuario m=new ManejadorUsuario();
      m.delete(nodo.getInformacion().getId());    //elimino la informacion
}



public void eliminarNodoDocumento(Nodo nodo){
     


      ManejadorNodo mn= new ManejadorNodo();
     eliminarArcosAdyacentes(nodo);               //elimino Arcos adyacentes (los q salen del nodo y los q entran)

     mn.delete(nodo.getId());                       //elimino el nodo

        ManejadorDocumento m=new ManejadorDocumento();
      m.delete(nodo.getInformacion().getId());    //elimino la informacion
}



public void editarNodoUsuario(Nodo nodo){



      ManejadorNodo mn= new ManejadorNodo();
                 
      mn.update(nodo);              //update el nodo

       ManejadorUsuario m=new ManejadorUsuario();
      m.update(nodo.getInformacion());    //update la informacion
}



public void editarNodoDocumento(Nodo nodo){



      ManejadorNodo mn= new ManejadorNodo();

      mn.update(nodo);              //update el nodo

        ManejadorDocumento m=new ManejadorDocumento();
      m.update(nodo.getInformacion());    //update la informacion
}



 public  void editarNodo(Nodo nodo){
         ManejadorNodo mn= new ManejadorNodo();

      mn.update(nodo);              //update el nodo
    }

 public void editarArco(Arco arco){
       ManejadorArco m=new ManejadorArco();
       m.update(arco);
 }

   public int guardarArco(Arco arco) {
       ManejadorArco m=new ManejadorArco();
      int id= m.insert(arco);
      return id;
      
    }


   public void editarUsuario(Usuario usuario){

       ManejadorUsuario m=new ManejadorUsuario();
      m.update(usuario);    //update la informacion
}



public void editarDocumento(Documento documento){

        ManejadorDocumento m=new ManejadorDocumento();
      m.update(documento);    //update la informacion
}

    public void eliminarArco(Arco arco) {
        ManejadorArco m=new ManejadorArco();
        m.delete(arco.getId());
    }



    //---------------Operaciones de cada Grafo de Usuario-----------------------

    public void agregarArcoPorUsuario( int idArco){
             ManejadorArcosDeUsuario m=new ManejadorArcosDeUsuario();
             m.guardar(grafo.getId(), idArco);
    }

    public void eliminarArcoPorUsuario( int idArco){
        ManejadorArcosDeUsuario m=new ManejadorArcosDeUsuario();
             m.delete(grafo.getId(), idArco);
    }

    public void agregarNodoPorUsuario( int idNodo){
          ManejadorNodosDeUsuario m=new ManejadorNodosDeUsuario();

           m.guardar(grafo.getId(),idNodo);
    }

   
    private void eliminarArcosAdyacentesPorUsuario(Nodo nodo){
      List<Arco> adyacentes=nodo.getAdyacentes();
      ManejadorArcosDeUsuario m=new ManejadorArcosDeUsuario();
      Arco a=null;
      for(int i=0;i<adyacentes.size();i++){
          a=adyacentes.get(i);
         eliminarArcoPorUsuario(a.getId() );
      }
 }
       private void eliminarArcosEntrantesPorUsuario(Nodo nodo){
       Vector<Nodo> nodos=grafo.getAllNodos();
       nodos.remove(nodo);
       Nodo n=null;
       List<Arco> ady=null;
       Arco a=null;

        ManejadorArcosDeUsuario m=new ManejadorArcosDeUsuario();
       for(int i=0;i<nodos.size();i++){
           n=nodos.get(i);
           ady=n.getAdyacentes();
           for(int j=0;j<ady.size();j++){
               a=ady.get(j);
               if(a.GetNodo().getId()==nodo.getId()){
                 eliminarArcoPorUsuario(a.getId());

               }
           }
       }
   }

    public void eliminarNodoPorUsuario( Nodo nodo){
             ManejadorNodosDeUsuario m=new ManejadorNodosDeUsuario();
              int idNodo=nodo.getId();

              m.delete(grafo.getId(), idNodo);

              eliminarArcosAdyacentesPorUsuario( nodo);
              eliminarArcosEntrantesPorUsuario(nodo);
    }


    //--------------------para mantener la consistencia entre las tablas de los usuarios y la BD------

       private void eliminarArcosEntrantesPorTodoUsuario(Nodo nodo){
       Vector<Nodo> nodos=grafo.getAllNodos();
       nodos.remove(nodo);
       Nodo n=null;
       List<Arco> ady=null;
       Arco a=null;
       
        ManejadorArcosDeUsuario m=new ManejadorArcosDeUsuario();
       for(int i=0;i<nodos.size();i++){
           n=nodos.get(i);
           ady=n.getAdyacentes();
           for(int j=0;j<ady.size();j++){
               a=ady.get(j);
               if(a.GetNodo().getId()==nodo.getId()){
                 eliminarArcoPorTodoUsuario(a.getId());
                 
               }
           }
       }
   }


           private void eliminarArcosAdyacentesPorTodoUsuario(Nodo nodo){
      List<Arco> adyacentes=nodo.getAdyacentes();
      ManejadorArcosDeUsuario m=new ManejadorArcosDeUsuario();
      Arco a=null;
      for(int i=0;i<adyacentes.size();i++){
          a=adyacentes.get(i);
         eliminarArcoPorTodoUsuario(a.getId());
      }
 }
    
    public void eliminarNodoPorTodoUsuario(Nodo nodo){
             ManejadorNodosDeUsuario m=new ManejadorNodosDeUsuario();
            int idNodo=nodo.getId();

              m.delete( idNodo);
                eliminarArcosAdyacentesPorTodoUsuario(nodo); //los adyacentes por usuario
               eliminarArcosEntrantesPorTodoUsuario(nodo);// los q me apuntan por usuario
    }
 public void eliminarArcoPorTodoUsuario( int idArco){
        ManejadorArcosDeUsuario m=new ManejadorArcosDeUsuario();
             m.delete(idArco);
    }

 //--------------------Para agregar a todos los grafos de Admin----

 public void agregarNodoPorTodoAdmin(int idNodo){
        ManejadorCuentaUsuario mc=new ManejadorCuentaUsuario();
       Vector<Object> cuentas= mc.getAll(" tipo='admin' ");
         if(cuentas!=null){

        ManejadorNodosDeUsuario m=new ManejadorNodosDeUsuario();
        CuentaUsuario c=null;
        for(int i=0;i<cuentas.size();i++){
            c=(CuentaUsuario) cuentas.get(i);
            m.guardar(c.getGrafo().getId(),idNodo);
        }

     }

    }

  public void agregarArcoPorTodoAdmin(int idArco){
        ManejadorCuentaUsuario mc=new ManejadorCuentaUsuario();
       Vector<Object> cuentas= mc.getAll(" tipo='admin' ");

         if(cuentas!=null){

        ManejadorArcosDeUsuario m=new ManejadorArcosDeUsuario();
        CuentaUsuario c=null;
        for(int i=0;i<cuentas.size();i++){
            c=(CuentaUsuario) cuentas.get(i);
            m.guardar(c.getGrafo().getId(),idArco);
        }
      }

    }



  public void eliminarGrafos(){   //delete where id=-1
      ManejadorArcosDeUsuario mau=new ManejadorArcosDeUsuario();
      mau.deleteAll();
      ManejadorNodosDeUsuario mnu=new ManejadorNodosDeUsuario();
      mnu.deleteAll();

      ManejadorUsuario mu=new ManejadorUsuario();
      mu.deleteAll();
      ManejadorDocumento md=new ManejadorDocumento();
      md.deleteAll();

       ManejadorArco ma=new ManejadorArco();
      ma.deleteAll();
      ManejadorNodo mn=new ManejadorNodo();
      mn.deleteAll();

      ManejadorInformacion mi=new ManejadorInformacion();
      mi.deleteAll();

     

  }
}
