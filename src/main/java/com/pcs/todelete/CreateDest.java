
/**
* Copyright 2014 Pacific Controls Software Services LLC (PCSS). All Rights Reserved.
*
* This software is the property of Pacific Controls  Software  Services LLC  and  its
* suppliers. The intellectual and technical concepts contained herein are proprietary 
* to PCSS. Dissemination of this information or  reproduction  of  this  material  is
* strictly forbidden  unless  prior  written  permission  is  obtained  from  Pacific 
* Controls Software Services.
* 
* PCSS MAKES NO REPRESENTATION OR WARRANTIES ABOUT THE SUITABILITY  OF  THE  SOFTWARE,
* EITHER EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE  IMPLIED  WARRANTIES  OF
* MERCHANTANILITY, FITNESS FOR A PARTICULAR PURPOSE,  OR  NON-INFRINGMENT.  PCSS SHALL
* NOT BE LIABLE FOR ANY DAMAGES SUFFERED BY LICENSEE AS A RESULT OF  USING,  MODIFYING
* OR DISTRIBUTING THIS SOFTWARE OR ITS DERIVATIVES.
*/
package com.pcs.todelete;

import weborb.client.Fault;
import weborb.client.Responder;
import weborb.client.WeborbClient;


/**
 * This class is responsible for ..(Short Description)
 * 
 * @author pcseg129
 */
public class CreateDest {
	private static WeborbClient client = new WeborbClient(
	        "http://localhost:8080/weborb.wo", "GenericDestination");
	public static void main(String[] args) {
		createDynamicDest();
	}
	
	public static void  createDynamicDest(){
		Responder responder = new Responder() {
			@Override
			public void responseHandler(Object arg0) {
				System.out.println("response " + String.valueOf(arg0));
			}

			@Override
			public void errorHandler(Fault arg0) {
				System.out.println("error");
			}
		};
		try {
			client.invoke("com.pcs.weborb.messaging.CreateJmsDest",
			        "createDestination", new Object[] {
			                "latestdest", "latestdata"}, responder);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	

}
