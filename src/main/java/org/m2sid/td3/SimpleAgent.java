package org.m2sid.td3;

  import jade.core.Agent;

  public class SimpleAgent extends Agent 
  { 
      /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void setup() 
      { 
          System.out.println("Hello World. ");
          System.out.println("My name is "+ getLocalName()); 
      }
  }