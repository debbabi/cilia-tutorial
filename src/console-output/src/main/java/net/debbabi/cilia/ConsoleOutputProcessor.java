package net.debbabi.cilia;

import fr.liglab.adele.cilia.Data;

public class ConsoleOutputProcessor {

	public Data show(Data data) {
		if (data != null) {
			System.out.println(data.getContent().toString());
		} 		
		return data;
	}

}
