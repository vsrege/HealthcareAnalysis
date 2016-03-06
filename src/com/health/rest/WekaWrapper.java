package com.health.rest;

import weka.core.Attribute;
import weka.core.Capabilities;
import weka.core.Capabilities.Capability;
import weka.core.CapabilitiesHandler;
import weka.core.Instance;
import weka.core.Instances;
import weka.core.RevisionUtils;
import weka.classifiers.Classifier;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;




import org.apache.http.*;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import com.sun.jersey.api.view.Viewable;


@Path("/monitor") 
public class WekaWrapper {

	/**
	 * @param args
	

		  /**
		   * Returns only the toString() method.
		   *
		   * @return a string describing the classifier
		   */
	  @POST
	  @Path("/monitorstatus")
		  public Response monitor(@FormParam("patientid") String pid, @Context HttpServletRequest request,
			      @Context HttpServletResponse response)throws Exception{ 
	    System.out.println("hello");
	    System.out.println(pid);
	   
	    WekaClassifierTree_Heart i = new WekaClassifierTree_Heart();
	   
	    Object[] instanceValue1 = new Object[8];

       

       	//TwilioMessage tm = new TwilioMessage();
          HttpClient client = new DefaultHttpClient();
           DatabaseConnection conn = new DatabaseConnection();
           conn.getConnection();
           if(conn != null)
           {
           	System.out.println("Database Connected");
           	
           }
           Person p= conn.getData(pid);
           System.out.println(p.getAge());
           instanceValue1[0] = new Double(p.getAge());
           instanceValue1[1] = new Double(p.getGender());
           instanceValue1[2] = new Double(p.getCheastpain());
           instanceValue1[3] = new Double(p.getRestingbloodpressure());
           instanceValue1[6] = new Double(p.getMaxHeartRate());
           //instanceValue1[6] = 128;
           instanceValue1[7] = new Double(p.getOldpeak());
           
           
           int in=0;
           double value=0.0;
           while(in<1)
           {

        	   
        	   URL url = new URL("https://thingspeak.com/channels/37277/fields/field1/last?key=Y9W2LWNQELP4BBMA");
        	   HttpURLConnection conn1 = (HttpURLConnection) url.openConnection();
        	   conn1.setRequestMethod("GET");
        	   conn1.setRequestProperty("Accept", "application/json");

           BufferedReader rd = new BufferedReader
                   (new InputStreamReader(conn1.getInputStream()));
         
           String line = "";
           if ((line = rd.readLine()) != null) {
           
		       
             System.out.println("Incoming Data "+line);
             System.out.println(" prediction " +WekaClassifierTree_Heart.classify(instanceValue1));
              value = WekaClassifierTree_Heart.classify(instanceValue1);
             in++;
           } 
          
           }
	    String pred="";
           if(value==0 || value==0.0){ pred="No";}
           else if(value==1 || value==1.0){pred="Yes";}
           
           System.out.println("Prediction is:"+pred);
           /*try
           {
           tm.sendSMS("+14086079887", "Please take an appointment with the doctor.");
           }
           catch(Exception e)
           {
        	   System.out.println("error");
           }*/
        HttpSession session=request.getSession();
   		session.setAttribute("prediction", pred);
   		session.setAttribute("patient", pid);
		
   		System.out.println("Prediction is:"+pred);
		Viewable output= new Viewable("/Results.jsp");
		return Response.status(200).entity(output).build();

	  }
	  
	  
	  	@POST
		@Path("/notifyUser")
	  	@Produces(MediaType.TEXT_PLAIN)
		public Response notify(String data,@Context HttpServletRequest request,
			      @Context HttpServletResponse response)throws Exception{
			
			System.out.println(data);
			
			
			String result="";
			TwilioMessage tm = new TwilioMessage();
			
			
			 try
	        {
				 result="Patient has been notified";
	        tm.sendSMS("+14084785222", "Please take an appointment with the doctor.");
	        System.out.println("Patient has been notified");
	        //return result;
	        }
	        catch(Exception e)
	        {
	        	result="Error sending SMS";
	     	   System.out.println("error sending SMS");
	     	   
	     	 // return result;
	        }
			 Viewable output= new Viewable("/Results.jsp");
				return Response.status(200).entity(output).build();
	}

	  
	  
	
		  public String globalInfo() {
		    return toString();
		  }

		  /**
		   * Returns the capabilities of this classifier.
		   *
		   * @return the capabilities
		   */
		  public Capabilities getCapabilities() {
		    weka.core.Capabilities result = new weka.core.Capabilities((CapabilitiesHandler) this);

		    result.enable(weka.core.Capabilities.Capability.NOMINAL_ATTRIBUTES);
		    result.enable(weka.core.Capabilities.Capability.NUMERIC_ATTRIBUTES);
		    result.enable(weka.core.Capabilities.Capability.DATE_ATTRIBUTES);
		    result.enable(weka.core.Capabilities.Capability.MISSING_VALUES);
		    result.enable(weka.core.Capabilities.Capability.NOMINAL_CLASS);
		    result.enable(weka.core.Capabilities.Capability.MISSING_CLASS_VALUES);

		    result.setMinimumNumberInstances(0);

		    return result;
		  }

		  /**
		   * only checks the data against its capabilities.
		   *
		   * @param i the training data
		   */
		  public void buildClassifier(Instances i) throws Exception {
		    // can classifier handle the data?
		    getCapabilities().testWithFail(i);
		  }

		  /**
		   * Classifies the given instance.
		   *
		   * @param i the instance to classify
		   * @return the classification result
		   */
		  public double classifyInstance(Instance i) throws Exception {
		    Object[] s = new Object[i.numAttributes()];
		    
		    for (int j = 0; j < s.length; j++) {
		      if (!i.isMissing(j)) {
		        if (i.attribute(j).isNominal())
		          s[j] = new String(i.stringValue(j));
		        else if (i.attribute(j).isNumeric())
		          s[j] = new Double(i.value(j));
		      }
		    }
		    
		    // set class value to missing
		    s[i.classIndex()] = null;
		    
		    return WekaClassifierTree_Heart.classify(s);
		  }

		  /**
		   * Returns the revision string.
		   * 
		   * @return        the revision
		   */
		  public String getRevision() {
		    return RevisionUtils.extract("1.0");
		  }

		  /**
		   * Returns only the classnames and what classifier it is based on.
		   *
		   * @return a short description
		   */
		  public String toString() {
		    return "Auto-generated classifier wrapper, based on weka.classifiers.trees.J48 (generated with Weka 3.6.12).\n" + this.getClass().getName() + "/WekaClassifierTree_Heart";
		  }

		  /**
		   * Runs the classfier from commandline.
		   *
		   * @param args the commandline arguments
		 * @throws Exception 
		   */
		  
		 
		public double[] distributionForInstance(Instance arg0) throws Exception {
			// TODO Auto-generated method stub
			return null;
		}
		}

	
		
		
		
		
		
		
		
		
		
		
		
		
