package org.m2sid.td3;

import jade.core.AID;
import jade.core.Agent;
import jade.domain.DFService;
import jade.domain.FIPAException;
import jade.domain.FIPAAgentManagement.DFAgentDescription;
import jade.domain.FIPAAgentManagement.ServiceDescription;
import jade.util.leap.Iterator;

public class AgentListeService extends Agent {

	protected void setup(){
		DFAgentDescription dfd= new DFAgentDescription();
		
		try{
			DFAgentDescription []result= DFService.search(this, dfd);
			for(int i=0;i<result.length;i++){
				DFAgentDescription desc= (DFAgentDescription)result[i];
				String message=desc.getName().getName();
				
				Iterator iter=desc.getAllServices();
				while(iter.hasNext()){
					ServiceDescription sd= (ServiceDescription)iter.next();
					message += sd.getName()+", ";
					
				}
				System.out.println(message);
				
				
			}
			
		}catch(FIPAException p){
			System.err.println(p.getMessage());
		}
	}
}
