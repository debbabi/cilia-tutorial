package net.debbabi.cilia;

import org.apache.felix.ipojo.annotations.Component;
import org.apache.felix.ipojo.annotations.Instantiate;
import org.apache.felix.ipojo.annotations.Invalidate;
import org.apache.felix.ipojo.annotations.Requires;
import org.apache.felix.ipojo.annotations.Validate;

import fr.liglab.adele.cilia.CiliaContext;
import fr.liglab.adele.cilia.builder.Architecture;
import fr.liglab.adele.cilia.builder.Builder;
import fr.liglab.adele.cilia.exceptions.BuilderConfigurationException;
import fr.liglab.adele.cilia.exceptions.BuilderException;
import fr.liglab.adele.cilia.exceptions.BuilderPerformerException;
import fr.liglab.adele.cilia.exceptions.CiliaIllegalParameterException;
import fr.liglab.adele.cilia.exceptions.CiliaIllegalStateException;


@Component
@Instantiate
public class HelloChainCreator {

	@Requires
	CiliaContext context;
	
	Builder builder;

	@Validate
	public void start() {
		
		builder = context.getBuilder();
		try {
			Architecture chain = builder.create("HelloWorldChain");

			chain.create().mediator().type("GuiInput").id("gui").configure();
			chain.create().mediator().type("Hello").id("hello").configure();
			chain.create().mediator().type("ConsoleOutput").id("console").configure();

			chain.bind().from("gui:std").to("hello:std");
			chain.bind().from("hello:std").to("console:std");

			builder.done();
			context.getApplicationRuntime().startChain("HelloWorldChain");	
				
		} catch (BuilderException e) {
			e.printStackTrace();
		} catch (BuilderConfigurationException e) {
			e.printStackTrace();
		} catch (BuilderPerformerException e) {
			e.printStackTrace();
		} catch (CiliaIllegalParameterException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (CiliaIllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}

	@Invalidate
	public void stop() {		
		if (builder != null) {
			try {
				builder.remove("HelloWorldChain");
			} catch (BuilderException e) {
				e.printStackTrace();
			}
		}
		if (context != null) {
			try {
				context.getApplicationRuntime().stopChain("HelloWorldChain");				
			} catch (CiliaIllegalParameterException e1) {			
				e1.printStackTrace();
			} catch (CiliaIllegalStateException e1) {			
				e1.printStackTrace();
			}
		}
	}
}
