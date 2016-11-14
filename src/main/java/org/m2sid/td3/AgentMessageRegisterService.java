package org.m2sid.td3;


import jade.core.Agent;
import jade.domain.DFService;
import jade.domain.FIPAException;
import jade.domain.FIPAAgentManagement.DFAgentDescription;
import jade.domain.FIPAAgentManagement.ServiceDescription;

public class AgentMessageRegisterService extends Agent 
{ 
    protected void setup() 
    { 
    	Object[] args = getArguments();
        System.out.println("Hello World. My param is : ");
        System.out.println("My name is "+ args[0]); 
        registerService((String)args[0]);
    }
    
    public void registerService(String name){
    	DFAgentDescription dfd = new DFAgentDescription();
        dfd.setName( getAID() ); 
        ServiceDescription sd  = new ServiceDescription();
        sd.setType( name );
        sd.setName( name );
        dfd.addServices(sd);
        
        try {  
            DFService.register(this, dfd );  
        }
        catch (FIPAException fe) { fe.printStackTrace(); }
    }
}