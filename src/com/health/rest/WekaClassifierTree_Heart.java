package com.health.rest;

public class WekaClassifierTree_Heart {

	
	
	 public static double classify(Object[] i)
			    throws Exception {

			    double p = Double.NaN;
			    p = WekaClassifierTree_Heart.N3cdb401917(i);
			    return p;
			  }
			  static double N3cdb401917(Object []i) {
			    double p = Double.NaN;
			    if (i[7] == null) {
			      p = 0;
			    } else if (((Double) i[7]).doubleValue() <= 1.8) {
			    	System.out.println(i[7]);
			    p = WekaClassifierTree_Heart.N5e4d488518(i);
			    } else if (((Double) i[7]).doubleValue() > 1.8) {
			      p = 1;
			    } 
			    return p;
			  }
			  static double N5e4d488518(Object []i) {
			    double p = Double.NaN;
			    if (i[6] == null) {
			      p = 0;
			    } else if (((Double) i[6]).doubleValue() <= 168.0) {
			    p = WekaClassifierTree_Heart.N23d4442119(i);
			    } else if (((Double) i[6]).doubleValue() > 168.0) {
			      p = 0;
			    } 
			    return p;
			  }
			  static double N23d4442119(Object []i) {
			    double p = Double.NaN;
			    if (i[2] == null) {
			      p = 0;
			    } else if (i[2].equals("1")) {
			      p = 0;
			    } else if (i[2].equals(new Double(2))) {
			    	System.out.println(i[2]);
			    p = WekaClassifierTree_Heart.N44c4e4e720(i);
			    } else if (i[2].equals("3")) {
			    p = WekaClassifierTree_Heart.N5a901cf621(i);
			    } else if (i[2].equals("4")) {
			    p = WekaClassifierTree_Heart.N4fe5de9323(i);
			    } 
			    return p;
			  }
			  static double N44c4e4e720(Object []i) {
			    double p = Double.NaN;
			    if (i[3] == null) {
			      p = 1;
			    } else if (((Double) i[3]).doubleValue() <= 120.0) {
			      p = 1;
			    } else if (((Double) i[3]).doubleValue() > 120.0) {
			    	System.out.println(i[3]);
			      p = 0;
			    } 
			    return p;
			  }
			  static double N5a901cf621(Object []i) {
			    double p = Double.NaN;
			    if (i[0] == null) {
			      p = 0;
			    } else if (((Double) i[0]).doubleValue() <= 61.0) {
			      p = 0;
			    } else if (((Double) i[0]).doubleValue() > 61.0) {
			    p = WekaClassifierTree_Heart.N9c895d922(i);
			    } 
			    return p;
			  }
			  static double N9c895d922(Object []i) {
			    double p = Double.NaN;
			    if (i[6] == null) {
			      p = 0;
			    } else if (((Double) i[6]).doubleValue() <= 148.0) {
			      p = 0;
			    } else if (((Double) i[6]).doubleValue() > 148.0) {
			      p = 1;
			    } 
			    return p;
			  }
			  static double N4fe5de9323(Object []i) 
			  {
			    double p = Double.NaN;
			    if (i[1] == null) {
			      p = 0;
			    } else if (i[1].equals("0")) {
			      p = 0;
			    } else if (i[1].equals("1")) {
			      p = 1;
			    } 
			    return p;
			  }
}
