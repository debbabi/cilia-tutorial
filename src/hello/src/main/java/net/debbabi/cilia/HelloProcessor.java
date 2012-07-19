package net.debbabi.cilia;

import fr.liglab.adele.cilia.Data;

public class HelloProcessor {
	
	 public Data sayHello(Data data) {
	      if (data != null) {	    	 
	         data.setContent("Hello, " + data.getContent().toString() + "!");
	      } 
	      return data;
	 }
	 
}
