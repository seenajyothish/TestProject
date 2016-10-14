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
package com.pcs.messaging;

import java.util.Calendar;

import weborb.client.Fault;
import weborb.client.IBasicMessagingResponder;
import weborb.client.WeborbClient;

/**
 * This class is responsible for weborb messaging testing
 * 
 * @author pcseg129
 */
public class MessagingSender {
	public static void main(String[] args) throws Exception {
		Calendar calendar = Calendar.getInstance();
		String msg = "My Message send at " + calendar.getTime().toString();;
		WeborbClient client = new WeborbClient(
		        "http://localhost:8080/weborb.wo", "mydest");
		client.publish(msg);
		System.out.println("published");
	}

}
class MySubscriptionResponder implements IBasicMessagingResponder {
	public void responseHandler(Object result) {
		Object[] messages = (Object[])result;

		for (Object message : messages)
			System.out
			        .println("Received message from destination - " + message);
	}

	public void errorHandler(Fault fault) {
		System.out.println( "Received error - " + fault.getDetail() );
	}
}
