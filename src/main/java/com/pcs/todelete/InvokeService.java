/**
 * Copyright 2014 Pacific Controls Software Services LLC (PCSS). All Rights
 * Reserved.
 * 
 * This software is the property of Pacific Controls Software Services LLC and
 * its suppliers. The intellectual and technical concepts contained herein are
 * proprietary to PCSS. Dissemination of this information or reproduction of
 * this material is strictly forbidden unless prior written permission is
 * obtained from Pacific Controls Software Services.
 * 
 * PCSS MAKES NO REPRESENTATION OR WARRANTIES ABOUT THE SUITABILITY OF THE
 * SOFTWARE, EITHER EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE IMPLIED
 * WARRANTIES OF MERCHANTANILITY, FITNESS FOR A PARTICULAR PURPOSE, OR
 * NON-INFRINGMENT. PCSS SHALL NOT BE LIABLE FOR ANY DAMAGES SUFFERED BY
 * LICENSEE AS A RESULT OF USING, MODIFYING OR DISTRIBUTING THIS SOFTWARE OR ITS
 * DERIVATIVES.
 */
package com.pcs.todelete;

import java.util.ArrayList;
import java.util.List;

import weborb.client.Fault;
import weborb.client.IBasicMessagingResponder;
import weborb.client.Responder;
import weborb.client.WeborbClient;

/**
 * This class is responsible for ..(Short Description)
 * 
 * @author pcseg129
 */
public class InvokeService {
	private static WeborbClient client = new WeborbClient(
	        "http://localhost:8080/weborb.wo", "GenericDestination");

	public static void main(String[] args) {
		List<String> names = getDestNames();
		System.out.println("after method call");
		for(String dest:names){
			System.out.println(dest);
		}
	}


	private static List<String> getDestNames() {
		InvokeService invokeService = new InvokeService();
		MyResponder myResponder = invokeService.new MyResponder();
		try {
			client.invoke("com.pcs.weborb.messaging.DynamicDestManager",
			        "getDynamicDestinations", null,myResponder );
			return myResponder.getDestnames();

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	class MyResponder implements IBasicMessagingResponder {
		List<String> destnames = new ArrayList<String>();
		public void responseHandler(Object result) {
			Object[] messages = (Object[])result;
			for (Object dest : messages) {
				System.out.println(((Object[])dest)[0]);
				destnames.add(
				        ((Object[])dest)[0].toString());
			}
		}

		public void errorHandler(Fault fault) {
			System.out.println("error");
		}
		public List<String> getDestnames(){
			return destnames;
		}
	}

}
