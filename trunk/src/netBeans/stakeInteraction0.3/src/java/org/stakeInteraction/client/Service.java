/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.stakeInteraction.client;

import com.google.gwt.core.client.GWT;

/**
 *
 * @author Jorge
 */
public  class  Service  {


        public static GWTServiceAsync getService() {
        // Create the client proxy. Note that although you are creating the
        // service interface proper, you cast the result to the asynchronous
        // version of the interface. The cast is always safe because the
        // generated proxy implements the asynchronous interface automatically.

        return GWT.create(GWTService.class);
    }
}
