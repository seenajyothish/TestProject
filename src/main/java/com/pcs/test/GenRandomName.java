
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
package com.pcs.test;

import java.util.Random;

import javax.naming.Context;

import org.kohsuke.randname.RandomNameGenerator;

/**
 * This class is responsible for ..(Short Description)
 * 
 * @author pcseg129
 */
public class GenRandomName {
	public static void main(String[] args) {
		
		Random random = new Random();
		for(int i=0;i<10;i++){
			int rnd = random.nextInt();
			RandomNameGenerator nameGenerator = new RandomNameGenerator(rnd);
			System.out.println(nameGenerator.next());
		}
	}
}
