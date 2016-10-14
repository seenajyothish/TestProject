
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
package com.pcs.messaging;

import weborb.client.Fault;
import weborb.client.IBasicMessagingResponder;
import weborb.client.WeborbClient;

/**
 * This class is responsible for ..(Short Description)
 * 
 * @author pcseg129
 */
public class DestinationCreator {
	
	private static WeborbClient client = new WeborbClient(
	        "http://10.234.31.202:8080/weborb.wo", "GenericDestination");
	public boolean checkDestinationExist(String destName){
		Object[] destinations =  getDestinations();
		boolean isExist = false;
		for (Object dest : destinations) {
			if(((Object[])dest).length>0){
				if(destName.equals( ( (Object[])dest)[0].toString())){
					isExist = true;
					break;
				}
			}
		}
		return isExist;
	}
	
	private Object[] getDestinations(){
		DestinationCreator manager = new DestinationCreator();
		MyResponder myResponder = manager.new MyResponder();
		try {
			client.invoke("com.pcs.weborb.messaging.DynamicDestinationManager",
			        "getDynamicDestinations", null,myResponder );
			Object result = myResponder.getResult();
			Object[] destinations = (Object[])result;
			return destinations;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public void createJmsDestination(String destName,String topicName){
		DestinationCreator manager = new DestinationCreator();
		MyResponder myResponder = manager.new MyResponder();
		try {
			client.invoke("com.pcs.weborb.messaging.DynamicDestinationManager",
			        "createDestination", new Object[] {
					destName, topicName}, myResponder);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void createDestination(String destName,String topicName){
		if(!checkDestinationExist(destName)){
			createJmsDestination(destName,topicName);
		}
	}
	
	class MyResponder implements IBasicMessagingResponder {
		Object result;
		public void responseHandler(Object resultObj) {
			result = resultObj;
		}
		public void errorHandler(Fault fault) {
			System.out.println("error");
		}
		public Object getResult(){
			return result;
		}
	}
	
	public static void main(String[] args) {
		DestinationCreator destinationCreator = new DestinationCreator();
		boolean rs = destinationCreator.checkDestinationExist("my_first_device");
		System.out.println(rs);
		if(!rs){
			destinationCreator.createJmsDestination("my_first_device", "my_first_device");
		}
    }


}
