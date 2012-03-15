/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.stakeInteraction.server;

    import java.io.*;
import java.util.Vector;
/**
 *
 * @author Jorge
 */
public class EscribirArchivo {




 public static void write(String nombre,Vector<String> lineas)
  {
  try{
  // Create file
  FileWriter fstream = new FileWriter(nombre);
 // BufferedWriter out = new BufferedWriter(fstream);
  PrintWriter out = new PrintWriter(fstream);

  for(int i=0;i<lineas.size();i++){
   //  out.write(lineas.elementAt(i));
      out.println(lineas.elementAt(i));
  }

  //Close the output stream
  out.close();
  relative(new File(nombre), new File(nombre));
   
  }catch (Exception e){//Catch exception if any
  System.err.println("Error: " + e.getMessage());
  }
    }


   public static String relative( final File base, final File file ) {
    final int rootLength = base.getAbsolutePath().length();
    final String absFileName = file.getAbsolutePath();
    final String relFileName = absFileName.substring(rootLength );

    System.out.println(absFileName);

    System.out.println(relFileName);
    return relFileName;
}

}
