package com.health.rest;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import com.twilio.sdk.TwilioRestClient;
import com.twilio.sdk.TwilioRestException;
import com.twilio.sdk.resource.factory.MessageFactory;
import com.twilio.sdk.resource.instance.Message;


public class TwilioMessage {
	
	 
		 TwilioRestClient client ;
	    /* Twilio REST API version */
	    public static final String ACCOUNTSID = "ACfdc8a3ba83c563bb79f47069aacaf79a";//ACc585003f4da9cfd347eec20670536d80
	    public static final String AUTHTOKEN = "a185752dc27bd53c865559cd73d37d34";//fa2801b4516aa08f1aff3b449d4ac5a3
	    
	   
	    
	    public void sendSMS(String userNumber,String smsMessage){
	    	
	    	client=new TwilioRestClient(ACCOUNTSID, AUTHTOKEN);
	    	
	    	 System.out.println("In Twilio");
	        // Build a filter for the MessageList
	        List<NameValuePair> params = new ArrayList<NameValuePair>();
	        params.add(new BasicNameValuePair("Body", smsMessage));
	        params.add(new BasicNameValuePair("To", userNumber));
	        params.add(new BasicNameValuePair("From", "+12489875640"));
	     
	        MessageFactory messageFactory = client.getAccount().getMessageFactory();
	        Message message;
	        System.out.println(messageFactory);
	        try {
				message = messageFactory.create(params);
				 System.out.println(message);
			}
	        catch (TwilioRestException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    }
	    
	 
	
}
