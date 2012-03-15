/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.stakeInteraction.server.Base;



import java.util.List;
import java.util.Vector;
import org.stakeInteraction.server.ExportarGrafo.VisitanteExportarGML;
import org.stakeInteraction.server.filtro.FiltroNodoGrafoPorUsuario;
import org.stakeInteraction.shared.Informacion.Documento;
import org.stakeInteraction.shared.Informacion.Informacion;
import org.stakeInteraction.shared.Informacion.Usuario;
import org.stakeInteraction.shared.CuentaUsuario.CuentaUsuario;
import org.stakeInteraction.shared.grafo.Arco;
import org.stakeInteraction.shared.grafo.Grafo;
import org.stakeInteraction.shared.grafo.Nodo;


/**
 *
 * @author Jorge
 */
public class Main {




    private static  Grafo cargarGrafo(Vector<Nodo> l){

                Grafo g=new Grafo();
           //     System.out.println("CLIENTE");
                Nodo n=null;
		 for(int i=0;i<l.size();i++){

                   n= l.get(i);


		g.agregarNodo(n);

		 }

                return g;


	}




    public static void agregarArco(Arco a){
          ManejadorArco ma=new ManejadorArco();
         // Arco a=new Arco(n);
          a.setIdNodoOrigen(a.getIdNodoOrigen());
          ma.insert(a);
    }

     public static void main(String[] args){
       
  /* Informacion i= m.getInformacionPorIdNodo(1);
    System.out.println("informacion :"+i.getId()+" "+i.getNombre()+" "+i.getLink());*/


  /*  CuentaUsuario c=m.getCuentaUsuario("pepe","1234");
        System.out.println("cuentaUsuario :"+c.getId()+" "+c.getNombre());*/


      //   ManejadorCuentaUsuario m=new ManejadorCuentaUsuario();
       // ManejadorNodo mn=new ManejadorNodo();

        /*  Grafo g=new Grafo(1);
           CuentaUsuario c=new CuentaUsuario(7, "lenny999", "1234",g,2);
           m.agregarCuentaUsuario(c);*/
      //    m.eliminarCuentaUsuario(10);
      /*    Usuario i= (Usuario) m.getInformacionPorIdInfo(2);
           System.out.println("cuentaUsuario :"+i.getId()+" "+i.getNombre()+" "+i.getCargo());*/


      

        //    m.delete(11);*/
      /*   ManejadorUsuario m=new ManejadorUsuario();

        Usuario u=new Usuario(7, "carl", "l", null, "carl","carlson", 45, "empleado nuclear");
        m.agregarUsuario(u);
         System.out.println(u.getId());*/

    /*     ManejadorDocumento m=new ManejadorDocumento();
         Documento d=new Documento(13213, "doc7", "link",  "cuerpodoc7",null);
         m.agregarDocumento(d);*/

       /*    ManejadorDocumento m=new ManejadorDocumento();

 */     /*  ManejadorUsuario m=new ManejadorUsuario();
         Usuario d=(Usuario) m.getInformacionPorIdInfo(10);
                   d=m.getUsuario(d);

     //    System.out.println(d.getId()+d.getNombre()+d.getCuerpoDocumento());
         Nodo n=new Nodo(d);
         ManejadorNodo mn=new ManejadorNodo();
         mn.agregarNodo(n);*/
     /*    ManejadorNodo mn=new ManejadorNodo();
          Nodo n=(Nodo) mn.get(4);
          ManejadorArco ma=new ManejadorArco();
          Arco a=new Arco(n);
          a.setIdNodoOrigen(n.getId());
          ma.insert(a);*/

        /* ExportarCSV e=new ExportarCSV();
         e.exportarGrafo();*/
        // System.out.println();*/
        // e.exportarMatrizAdyacencia()



/* ManejadorDocumento m=new ManejadorDocumento();
   Documento d=(Documento) m.get(4);
          System.out.println(d.getId()+d.getNombre());*/

 /* ManejadorUsuario m=new ManejadorUsuario();
         Usuario d=m.getUsuario(1);*/

       
      //  System.out.println(d.getId()+d.getNombre()+d.getCuerpoDocumento());
        
 /*      ManejadorGrafo m=new ManejadorGrafo();
       VisitanteExportarGML v=new VisitanteExportarGML();
       Grafo g=m.getGrafoCompleto();
       g.aceptar(v);*/

/*
         ManejadorGrafoDeUsuario gu=new ManejadorGrafoDeUsuario();
         FiltroGrafoPorUsuario f=new FiltroGrafoPorUsuario(gu.getAll("idGrafo=1"));
         ManejadorGrafo m=new ManejadorGrafo();
         Grafo g=m.getGrafoFiltrado(f);
      //   Grafo g=m.getGrafoCompleto();
        // g.visitarDFS(g.getAllNodos().firstElement());
         //g.recorrerDFS();





         Vector<Nodo> nodos=g.getAllNodos();
         Nodo n=null;
         for(int i=0;i<g.getCantDeNodos();i++){
             n=nodos.get(i);
             System.out.print(n);
                
         List<Arco> arcos=n.getAdyacentes();
         for(int j=0;j<arcos.size();j++){
            System.out.print("-"+arcos.get(j).GetNodo());
             
         }
          System.out.println("----");
         }


      //   System.out.println( g.getCantDeNodos());*/
/*
           ManejadorCuentaUsuario m=new ManejadorCuentaUsuario();
      //  CuentaUsuario c=m.getCuentaUsuario(nombre,contraseña);
          CuentaUsuario c=(CuentaUsuario) m.get("nombre='"+"pepe"+"' and contraseña='"+"1234"+"'");
         System.out.println("cuentaUsuario :"+c.getId()+" "+c.getNombre());
*/
      /*   Usuario u=new Usuario(19, "carl", "l", null, "carl","carlson", 45, "empleado nuclear");
       Documento d=new Documento(17,"doc 5", "link","cuerpodoc", null);
         ManejadorGrafo m=new ManejadorGrafo();
         Nodo n=new Nodo(d,true);
         n.setId(13);
      // System.out.println(  m.guardarNodoDocumento(n));
       //  System.out.println(  m.guardarNodoUsuario(n));
       m.eliminarNodoDocumento(n);
       //  m.eliminarNodoUsuario(n);
*/
       /*  Arco a=new Arco();
         a.setValido(false);
         a.setId(10);
         ManejadorArco m=new ManejadorArco();
         m.update(a);*/

     /*      ManejadorCuentaUsuario m=new ManejadorCuentaUsuario();
        Vector<CuentaUsuario> cuentas= new Vector<CuentaUsuario>();
        Vector<Object> c=m.getAll(" tipo='user'");
        for(int i=0;i<c.size();i++){
            cuentas.add((CuentaUsuario) c.get(i));
            System.out.println(cuentas.get(i).getNombre());
        }*/

       /*    ManejadorDocumento m=new ManejadorDocumento();

         Informacion d=new Documento(50,"doc 50", "link","cuerpodoc", null);*/
      /*   ManejadorUsuario m=new ManejadorUsuario();

           Usuario u=new Usuario(7, "carl", "l", null, "carl","carlson", 45, "empleado nuclear");*/
         /*    int id= m.insert(d);
            System.out.println(id);
           
           ManejadorNodo mn=new ManejadorNodo();
          Nodo n=new Nodo(50,d,false);
        // n.setId(42);
         System.out.println( mn.insert(n));*/
         ManejadorGrafo m=new ManejadorGrafo(0);
         m.eliminarGrafos();
     }

}
