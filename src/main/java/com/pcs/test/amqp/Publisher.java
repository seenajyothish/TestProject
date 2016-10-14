
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
package com.pcs.test.amqp;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

/**
 * This class is responsible for ..(Short Description)
 * 
 * @author pcseg129
 */
public class Publisher {
	
	private final static String QUEUE_NAME = "NEW_QUEUE";
	
	public static void main(String[] args) throws IOException, TimeoutException {
		System.out.println("starting");
	    ConnectionFactory factory = new ConnectionFactory();
	    factory.setHost("pcss-hdop04");
	    factory.setAutomaticRecoveryEnabled(true);
	    Connection connection = factory.newConnection();
	    Channel channel = connection.createChannel();
	    channel.queueDeclare(QUEUE_NAME, false, false, false, null);
	    String message = "first message , hello world";
	    channel.basicPublish("", QUEUE_NAME, null, message.getBytes());
	    System.out.println("message sent");
	    
	    channel.close();
	    connection.close();
    }

}
