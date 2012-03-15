/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.stakeInteraction.server;

import org.stakeInteraction.server.EscribirArchivo;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.fileupload.DiskFileUpload;
import org.apache.commons.fileupload.FileItem;

/**
 *
 * @author Jorge
 */
@WebServlet(name="UploadFichero", urlPatterns={"/UploadFichero"})
public class UploadFichero extends HttpServlet {
   
    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
     /*   response.setContentType("text/html");
        PrintWriter out = response.getWriter();*/
       /* out.println("<html>");
        out.println("<head>");
        out.println("<title>Servlet</title>");
        out.println("</head>");
        out.println("<body>");*/

        System.out.println("Comenzamos procesamiento ficheros");

        procesaFicheros(request);

        /*out.println("</body>");
        out.println("</html>");*/

//        out.close();
    }


    void depura(String cadena)
    {
        System.out.println("El error es " + cadena);
    }

    public boolean procesaFicheros(HttpServletRequest req ) {
        try {
            // construimos el objeto que es capaz de parsear la perición
            DiskFileUpload fu = new DiskFileUpload();

            // maximo numero de bytes
            fu.setSizeMax(1024*512); // 512 K

            depura("Ponemos el tamaño máximo");
            // tamaño por encima del cual los ficheros son escritos directamente en disco
            fu.setSizeThreshold(4096);

            // directorio en el que se escribirán los ficheros con tamaño superior al soportado en memoria
            fu.setRepositoryPath("/tmp");

            // ordenamos procesar los ficheros
            List fileItems = fu.parseRequest(req);

            if(fileItems == null)
            {
                depura("La lista es nula");
                return false;
            }

       //    out.print("<br>El número de ficheros subidos es: " +  fileItems.size());

            // Iteramos por cada fichero
	    Iterator i = fileItems.iterator();
            FileItem actual = null;
            depura("estamos en la iteración");

            while (i.hasNext())
            {
                actual = (FileItem)i.next();
                String fileName = actual.getName();
              //  String fileName = ("grafo.gml");
              //  out.println("<br>Nos han subido el fichero" + fileName);

                // construimos un objeto file para recuperar el trayecto completo
                File fichero = new File(fileName);
                depura("El nombre del fichero es " + fichero.getName());

                // nos quedamos solo con el nombre y descartamos el path
               // fichero = new  File( fichero.getName());
                 fichero = new  File( "grafo.gml");
                EscribirArchivo.relative(fichero, fichero);

                // escribimos el fichero colgando del nuevo path
                actual.write(fichero);
            }

        }
        catch(Exception e) {
            depura("Error de Aplicación " + e.getMessage());
            return false;
        }

        return true;
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        processRequest(request, response);
    } 

    /** 
     * Handles the HTTP <code>POST</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        processRequest(request, response);
    }

    /** 
     * Returns a short description of the servlet.
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
