/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.stakeInteraction.client.VentanaImportar;

/**
 *
 * @author Jorge
 */


import com.extjs.gxt.ui.client.widget.LayoutContainer;
import com.extjs.gxt.ui.client.widget.Window;


import com.google.gwt.user.client.Element;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.ClickListener;
import com.google.gwt.user.client.ui.FileUpload;
import com.google.gwt.user.client.ui.FormHandler;
import com.google.gwt.user.client.ui.FormPanel;
import com.google.gwt.user.client.ui.FormSubmitCompleteEvent;
import com.google.gwt.user.client.ui.FormSubmitEvent;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HasAlignment;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;
import org.stakeInteraction.client.GWTServiceUsage;

public class VentanaSubirArchivo extends Window {

   LayoutContainer l;





  @Override
  protected void onRender(Element parent, int index) {
    super.onRender(parent, index);
   // setStyleAttribute("margin", "10px");
  //  this.setWidth(364);
  //  this.setTitle();
    this.setHeading("Seleccione el archivo (*.gml)");
 /*   final FormPanel panel = new FormPanel();
    panel.setHeading("Importar grafo");
    panel.setFrame(true);
    panel.setAction("http://localhost:8080/stakeNet0.2.4/UploadFichero");
    panel.setEncoding(Encoding.MULTIPART);
    panel.setMethod(Method.POST);
    panel.setButtonAlign(HorizontalAlignment.CENTER);
    panel.setWidth(350);



    FileUploadField file = new FileUploadField();
    file.setAllowBlank(false);
    file.setName("fichero");
    file.setFieldLabel("Archivo");

    panel.add(file);





    Button btn = new Button("Reset");
    btn.addSelectionListener(new SelectionListener<ButtonEvent>() {
      @Override
      public void componentSelected(ButtonEvent ce) {
        panel.reset();
      }
    });
    panel.addButton(btn);

   /*panel.addFormListener(new FormListenerAdapter(){
             public boolean doBeforeAction(Form form) {return true;}
             public void onActionComplete(Form form, int httpStatus, java.lang.String responseText){

              }
            public void onActionFailed(Form form, int httpStatus, java.lang.String responseText){
                  com.google.gwt.user.client.Window.alert("File upload is failed.");
                 }
             });




    btn = new Button("Subir Archivo");
    btn.addSelectionListener(new SelectionListener<ButtonEvent>() {
      @Override
      public void componentSelected(ButtonEvent ce) {
        if (!panel.isValid()) {
          return;
        }
        // normally would submit the form but for example no server set up to
        // handle the post
        panel.submit();

        if(true){ //si anduvo el subir

       //     GWTServiceUsage.importar();
            hide();
              // MessageBox.info("Action", "You file was uploaded", null);

          }
      }
    });
    panel.addButton(btn);

    add(panel);*/
  //  this.setSize(panel.getWidth()+10, panel.getHeight()+10);


    final FormPanel form = new FormPanel();
form.setEncoding(FormPanel.ENCODING_MULTIPART);
form.setMethod(FormPanel.METHOD_POST);
form.addStyleName("table-center");
form.addStyleName("demo-panel-padded");
form.setWidth("275px");
form.setAction("UploadFichero");
VerticalPanel holder = new VerticalPanel();

final FileUpload upload = new FileUpload();
upload.setName("upload");

holder.add(upload);

holder.add(new HTML("<hr />"));

holder.setHorizontalAlignment(HasAlignment.ALIGN_RIGHT);
holder.add(new Button("SubirArchivo", new ClickListener()
{
	public void onClick(Widget sender)
	{
		 form.submit();
	}
}));

form.add(holder);

// form.setAction("url");

form.addFormHandler(new FormHandler()
{
	public void onSubmit(FormSubmitEvent event)
	{
		// if (something_is_wrong)
		// {
		// Take some action
		// event.setCancelled(true);
		// }
	}

	public void onSubmitComplete(FormSubmitCompleteEvent event)
	{
            GWTServiceUsage.importar();
		//com.google.gwt.user.client.Window.alert(    upload.getFilename());
                hide();;
	}
});

      add(form);
  }


}