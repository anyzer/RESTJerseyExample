package com.CrunchifyRESTJerseyExample.ClientClass;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;


public class App 
{
    public static void main( String[] args )
    {
    	
    	System.out.println("Get Method");
    	try {
	    	Client client = Client.create();
	    	
	    	WebResource webResource = client
	    			.resource("http://10.39.71.245:8080/CrunchifyRESTJerseyExample/crunchify/myservice/getTrack");
	        
	    	ClientResponse response = webResource.accept("application/json")
	    			.get(ClientResponse.class);
	    	
	    	if(response.getStatus() != 200) {
	    		throw new RuntimeException("Failed, HTTP error code: " + response.getStatus());
	    	}
	    	
	    	String output = response.getEntity(String.class);
	    	
	    	System.out.println("Output from server ...args");
	    	System.out.println(output + "\n\n");
    	} catch (Exception e){
    		e.printStackTrace();
    	}
    	
    	
    	System.out.println("Post Method");
    	try{
    		
    		Client clientPost = Client.create();
    		WebResource webRes = clientPost
    				.resource("http://10.39.71.245:8080/CrunchifyRESTJerseyExample/crunchify/myservice/postTrack");
    		
    		String input = "{\"singer\":\"Metallica\",\"title\":\"Fade To Black\"}";
    		
    		ClientResponse response = webRes.type("application/json")
    				   .post(ClientResponse.class, input);
    		
    		if (response.getStatus() != 201) {
    			throw new RuntimeException("Failed : HTTP error code : " + response.getStatus());
    		}
    		
    		System.out.println("Output from Server .... \n");
    		String output = response.getEntity(String.class);
    		System.out.println(output);
    		
    		
    	}catch (Exception e){
    		e.printStackTrace();
    	}
    	
    	
    }
}
