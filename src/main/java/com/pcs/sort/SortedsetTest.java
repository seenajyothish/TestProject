
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
package com.pcs.sort;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 * This class is responsible for ..(Short Description)
 * 
 * @author pcseg129
 */
public class SortedsetTest {
	public static void main(String[] args) throws UnsupportedEncodingException {
		System.out.println(URLEncoder.encode("°C","UTF-8"));
		System.out.println(URLDecoder.decode("%C2%B0C"));
		System.out.println(URLDecoder.decode("%C2%B0C","UTF-8"));
		
		
		
		System.out.println(URLDecoder.decode("[\"unit\":\"%C2%B0C\"]","UTF-8"));
	   SortedSet<String> names = new TreeSet<String>(String.CASE_INSENSITIVE_ORDER);
	   
	   names.add("welcome_tin");
	   names.add("Sensor");
	   names.add("even_block");
	   names.add("main_houseplant");
	   names.add("SENSOR");
	   names.add("1Time");
	   names.add("senSor");
	   names.add("3Pens");
	   names.add("opposed_makeup");
	   names.add("senSor");
	   names.add("Generator");
	   names.add("testname");
	   names.add("sensor");
	   
	   for(String str :names){
		   System.out.println(str);
	   }
    }

}
