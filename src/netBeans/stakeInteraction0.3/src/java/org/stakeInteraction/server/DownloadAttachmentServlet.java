/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.stakeInteraction.server;

import org.stakeInteraction.server.EscribirArchivo;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.util.Vector;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.stakeInteraction.server.Base.ManejadorGrafo;
import org.stakeInteraction.server.Base.ManejadorNodo;
import org.stakeInteraction.server.ExportarGrafo.VisitanteExportarGML;
import org.stakeInteraction.shared.grafo.Grafo;
import org.stakeInteraction.shared.grafo.Nodo;

/**
 *
 * @author Jorge
 */
public class DownloadAttachmentServlet extends HttpServlet {
   
    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            /* TODO output your page here
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet DownloadAttachmentServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet DownloadAttachmentServlet at " + request.getContextPath () + "</h1>");
            out.println("</body>");
            out.println("</html>");
            */
        } finally { 
            out.close();
        }
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





      /*    ManejadorNodo m=new ManejadorNodo();
   Vector<Nodo> nodos=m.cargarListaNodos();


       Grafo g=cargarGrafo(nodos);*/
       // ManejadorGrafo m=new ManejadorGrafo(0);
     /*   Grafo g=ManejadorGrafo.getGrafoCompleto();
       VisitanteExportarGML vi=new VisitanteExportarGML();
               g.aceptar(vi);

 Vector<String> v=vi.getLineas();*/

          byte[] bbuf = new byte[1024];

       
    
		String filename = "grafoExportar.gml";

         try {
               ServletOutputStream out = response.getOutputStream();
                 ServletContext context = getServletConfig().getServletContext();

              //   System.out.println("context: "+context.getRealPath(""));
                 /* EscribirArchivo.write(context.getRealPath("") + "/" +filename,v );*/

                  File file = new File(/*context.getRealPath("") + "/" +*/ filename);
                  String mimetype = context.getMimeType(filename);

                  response.setContentType((mimetype != null) ? mimetype : "application/octet-stream");
                  response.setContentLength((int) file.length());
                   response.setHeader("Content-Disposition", "attachement; filename=\"" + filename + "\"");

                    DataInputStream in = new DataInputStream(new FileInputStream(file));

                    int length;
                    while ((in != null) && ((length = in.read(bbuf)) != -1)) {
                     out.write(bbuf, 0, length);
                      }

                      in.close();
                      out.flush();
                     out.close();
                }
                 catch (Exception e) {
                                      e.printStackTrace();
                    }


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
