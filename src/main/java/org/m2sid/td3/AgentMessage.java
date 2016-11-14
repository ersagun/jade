package org.m2sid.td3;

import jade.core.Agent;

public class AgentMessage extends Agent 
{ 
    protected void setup() 
    { 
    	Object[] args = getArguments();
        System.out.println("Hello World. My param is : ");
        System.out.println("My name is "+ args[0]); 
    }
}