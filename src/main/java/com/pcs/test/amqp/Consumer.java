
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
import com.rabbitmq.client.ConsumerCancelledException;
import com.rabbitmq.client.QueueingConsumer;
import com.rabbitmq.client.ShutdownSignalException;

/**
 * This class is responsible for ..(Short Description)
 * 
 * @author pcseg129
 */
public class Consumer {
	private final static String QUEUE_NAME = "NEW_QUEUE";
	
	public static void main(String[] args) throws IOException, 
	TimeoutException, ShutdownSignalException, ConsumerCancelledException, InterruptedException {
	    ConnectionFactory factory = new ConnectionFactory();
	    factory.setHost("pcss-hdop04");
	    Connection connection = factory.newConnection();
	    Channel channel = connection.createChannel();
	    channel.queueDeclare(QUEUE_NAME, false, false, false, null);
	    System.out.println("listen for messages");
	    
	    
	    QueueingConsumer consumer = new QueueingConsumer(channel);
	    channel.basicConsume(QUEUE_NAME, true, consumer);
	    
	    while(true){
	    	QueueingConsumer.Delivery delivery = consumer.nextDelivery();
	    	String msg = new String(delivery.getBody(),"UTF-8");
	    	System.out.println("Msg received " + msg);
	    }
    }

}
