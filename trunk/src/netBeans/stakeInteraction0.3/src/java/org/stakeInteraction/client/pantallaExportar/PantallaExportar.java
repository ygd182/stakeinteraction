/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.stakeInteraction.client.pantallaExportar;






import com.extjs.gxt.ui.client.event.ButtonEvent;
import com.extjs.gxt.ui.client.event.SelectionListener;
import com.extjs.gxt.ui.client.widget.Window;


import com.google.gwt.user.client.rpc.AsyncCallback;

import java.util.Vector;
import org.stakeInteraction.client.Service;

import com.extjs.gxt.ui.client.widget.form.TextArea;
import com.extjs.gxt.ui.client.widget.button.Button;
import org.stakeInteraction.client.GWTServiceUsage;




/**
 *
 * @author Jorge
 */
public class PantallaExportar {
     
private  Window window;
// FormPanel simple;
    public PantallaExportar() {






            window = new Window();
    window.setSize(300,50);
    window.setPlain(true);
    window.setModal(true);
    window.setBlinkModal(true);
    window.setHeading("Exportar grafo");
  //  window.setLayout(new FitLayout());

    TextArea txt=new TextArea();
    txt.setValue("Elija el formato en el cual quiere exportar el grafo");
    txt.disableTextSelection(true);
  //  txt.setEnabled(false);
    txt.setSize(290, 40);
    

   /* Button lista=new Button("Lista CSV",new SelectionListener<ButtonEvent>() {
      @Override
      public void componentSelected(ButtonEvent ce) {

        com.google.gwt.user.client.Window.open( "http://localhost:8080/stakeNet0.2.4/exportar/lista.csv","lista.csv", "");
          //   Window.open("file:///C:/Users/Jorge/.netbeans/6.9/config/GF3/domain1/texto.csv" ,"texto.csv", "");
              window.hide();
      }
    });
       Button matriz=new Button("Matriz CSV",new SelectionListener<ButtonEvent>() {
      @Override
      public void componentSelected(ButtonEvent ce) {
         
       com.google.gwt.user.client.Window.open( "http://localhost:8080/stakeNet0.2.4/exportar/matriz.csv","matriz.csv", "");
           window.hide();
      }
    });*/
          Button gml=new Button("Grafo GML",new SelectionListener<ButtonEvent>() {
      @Override
      public void componentSelected(ButtonEvent ce) {
            GWTServiceUsage.exportarGml();
         //  com.google.gwt.user.client.Window.open("http://localhost:8080/stakeNet0.2.4/DownloadAttachmentServlet","DownloadFile","");

            //Window.open( "http://localhost:8080/stakeNet0.2.4/exportar/grafo.gml","grafo.gml", "");
              window.hide();
      }
    });
  //  lista.setWidth("100px");
   // matriz.setWidth("100px");
    gml.setWidth("100px");


      window.add(txt);
   //     window.add(lista);
    //      window.add(matriz);
             window.add(gml);


         /*   simple.setButtonAlign(HorizontalAlignment.CENTER);


    FormButtonBinding binding = new FormButtonBinding(simple);
    binding.addButton(lista);
     binding.addButton(matriz);
      binding.addButton(gml);

      window.add(simple);*/
     window.setClosable(true);
       window.show();



/*
    


   
              final DialogBox d = new DialogBox();
                    // Add a handler to close the DialogBox
                    final Button closeButton = new Button("Open");
                    // We can set the id of a widget by accessing its Element
                    closeButton.getElement().setId("closeButton");
                    closeButton.addClickHandler(new ClickHandler() {

                        @Override
                        public void onClick(ClickEvent event) {
                            Window.open("org.stakeNet.server.DownloadAttachmentServlet", "_blank", "enabled");
                            //d.hide();
                        }
                    });
                    d.setWidget(closeButton);
                    d.setText("anduvo");
                    d.show();
                }

 */


/*

        RequestBuilder req = new RequestBuilder(RequestBuilder.POST, "Mensaje");
          try {
             req.setHeader("Content-Type","application/x-www-form-urlencoded");
             req.sendRequest(URL.encodeComponent("usuario")+ "=" + URL.encodeComponent(""),new RequestCallback() {

public void onResponseReceived(Request req, Response res) {
Window.alert(res.getText());
  
  
   Window.open(res.getHeader("Content-Disposition"), "downloadWindow", "");
  Window.Location.assign(GWT.getHostPageBaseURL() + "DownloadAttachementServlet");

}

public void onError(Request arg0, Throwable arg1) {
throw new UnsupportedOperationException("Not supported yet.");
}
});
} catch (RequestException ex) {
ex.printStackTrace();


        }*/
        
    }

    

}
