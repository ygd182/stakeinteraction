/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.stakeInteraction.server.Importar;

import java.io.FileReader;
import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;
import java.util.Vector;
import org.stakeInteraction.shared.Informacion.Documento;
import org.stakeInteraction.shared.Informacion.Informacion;
import org.stakeInteraction.shared.Informacion.Usuario;
import org.stakeInteraction.shared.grafo.Arco;
import org.stakeInteraction.shared.grafo.Nodo;

/**
 *
 * @author Jorge
 */
public class ImportarGML {
private HashMap<Integer,Nodo> documentos;
private HashMap<Integer,Nodo> usuarios;
private Vector<Arco> arcos;
int idGrafo;
private Scanner sc;

public ImportarGML(){
    documentos=new HashMap<Integer,Nodo>();
    usuarios=new HashMap<Integer,Nodo>();
    arcos=new Vector<Arco>();
}

private void crearNodo(){
     Nodo n=new Nodo();
                      String  line = sc.nextLine();
                        line = sc.nextLine();
                       //   System.out.println(line+" ");
                      String[]  data = line.split(" ", 2);
                       //  System.out.println(data[1]+" ");
                        int id= Integer.parseInt(data[1]);
                        n.setId(id);

                          line = sc.nextLine();
                           data = line.split(" ", 2);
                           data[1]=data[1].replaceAll("\"","");
                          
                          
                    //       System.out.println(line+" ");
                       //    System.out.println(data[1]+" ");
                          if(data[1].equals("Documento"))
                          {
                             Documento d=crearDocumento();
                             n.setInformacion(d);
                             documentos.put(id, n);
                          }
                          else{
                              Usuario u=crearUsuario();
                            n.setInformacion(u);
                            usuarios.put(id, n);
                          }
                           line = sc.nextLine();



}

private void crearArco(){

    /*edge
[
id 5
source 3
target 2
value 1
]*/

       String  line = sc.nextLine();
     line = sc.nextLine();
     String[]  data = line.split(" ", 2);
     int id= Integer.parseInt(data[1]);

         line = sc.nextLine();

     data = line.split(" ", 2);
     int idSource= Integer.parseInt(data[1]);

       line = sc.nextLine();

     data = line.split(" ", 2);
    int idTarget= Integer.parseInt(data[1]);

     line = sc.nextLine();
      line = sc.nextLine();

   Nodo n=buscarNodo(idTarget);
     System.out.println(id+"\n"+idSource+"\n"+idTarget+"\n");
    Arco a=new Arco(n, id, idSource, true);
    arcos.add(a);

}
/*
private String avanzar(){
   return sc.nextLine();
}*/

private Documento crearDocumento(){
     /*idDocumento8
nombre "mediador"
link "http://localhost:8080/stakeNet0.2.4/documentacion/mediador.png"
cuerpo "*/


    String  line = sc.nextLine();

     String[]  data = line.split(" ", 2);
     int id= Integer.parseInt(data[1]);

      line = sc.nextLine();
       System.out.println(line+" ");
       data = line.split(" ", 2);
       data[1].replaceAll("\"", "");
        data[1]=data[1].replaceAll("\"","");
       String nombre=data[1];

          line = sc.nextLine();
       data = line.split(" ", 2);
      data[1]= data[1].replaceAll("\"", "");
       String link=data[1];

          line = sc.nextLine();
       data = line.split(" ", 2);
      data[1]= data[1].replaceAll("\"", "");
       String cuerpo=data[1];

        System.out.println(id+"\n"+nombre+"\n"+link+"\n"+cuerpo);
      Documento d=new Documento(id, nombre, link, cuerpo, null);
    return d;

}

private Usuario crearUsuario(){
    /*tipo Usuario"
idUsuario 3
nombre "jorbolpe"
link "link"
nombreReal "Jorge"
apellido "Bolpe"
edad 0"
cargo "Desarrollador"*/
       String  line = sc.nextLine();

     String[]  data = line.split(" ", 2);
     int id= Integer.parseInt(data[1]);

      line = sc.nextLine();
       data = line.split(" ", 2);
      data[1]= data[1].replaceAll("\"", "");
       String nombre=data[1];

          line = sc.nextLine();
       data = line.split(" ", 2);
      data[1]= data[1].replaceAll("\"", "");
       String link=data[1];

          line = sc.nextLine();
      //    System.out.println(line+" ");
       data = line.split(" ", 2);
       data[1]=data[1].replaceAll("\"", "");
       String nombreReal=data[1];

         line = sc.nextLine();
       //  System.out.println(line+" ");
       data = line.split(" ", 2);
       data[1]=data[1].replaceAll("\"", "");
       String apellido=data[1];

         line = sc.nextLine();
       data = line.split(" ", 2);
       data[1]=data[1].replaceAll("\"", "");
       String edad=data[1];

         line = sc.nextLine();
       data = line.split(" ", 2);
       data[1]=data[1].replaceAll("\"", "");
       String  cargo=data[1];

       System.out.println(id+"\n"+nombre+"\n"+link+"\n"+nombreReal+"\n"+apellido+"\n"+edad+"\n"+cargo);
       Usuario u=new Usuario(id, nombre, link, null, nombreReal, apellido, edad, cargo);
    return u;
}

private Nodo buscarNodo(int id){
    Nodo n=null;
   n= documentos.get(id);
   if(n==null)
       n=usuarios.get(id);

   return n;
}

     public void importar()
    {
        FileReader reader = null;
        try
        {
           // NB: the file name is hard-coded
            reader = new FileReader("grafo.gml");
          sc = new Scanner(reader);

            String line;
            String[] data;

            while(sc.hasNextLine())
            {
                line = sc.nextLine();
                if(line.length() != 0)
                {
                   
                    if(line.equals("graph")){
                       crearGrafo();

                    }

		    
                }
            }
                   
                         sc.close();
                   } 
        
             catch(IOException e)
                {
                 System.out.println("Error reading file");
                  e.printStackTrace();
                  }
        
     }


private void crearGrafo(){
   String  line = sc.nextLine();
 /*  line = sc.nextLine();
     String[]  data = line.split(" ", 2);
     System.out.println(line+" ");
      idGrafo= Integer.parseInt(data[1]);*/

       while(sc.hasNextLine())
            {
                line = sc.nextLine();
                if(line.length() != 0)
                {
                      if(line.equals("node")){
                    
                       crearNodo();

                    }
                    if(line.equals("edge")){

                       crearArco();

                    }

                }


           }

    }




  public static void main(String[] args){
      ImportarGML l=new ImportarGML();
     l.importar();
  }


  public Collection<Nodo> getNodosDoc(){
      return  documentos.values();
  }

    public Collection<Nodo> getNodosUser(){
      return (Collection<Nodo>) usuarios.values();
  }

      public Vector<Arco> getArcos(){
      return arcos;
  }

}
