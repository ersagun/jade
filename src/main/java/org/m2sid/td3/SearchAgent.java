package td1.df;

import java.util.List;
import java.util.Iterator;

import jade.core.Agent;
import jade.domain.FIPAException;
import jade.domain.DFService; //Communicator
import jade.domain.FIPAAgentManagement.ServiceDescription;
import jade.domain.FIPAAgentManagement.DFAgentDescription;
import jade.domain.FIPAAgentManagement.SearchConstraints;

public class SearchAgent extends Agent {

  protected void setup() {
    System.out.println("Hello. I am "+this.getLocalName()+".");

    this.searchAgents();
  }

  private void searchAgents() {
      int i;
    DFAgentDescription dfd = new DFAgentDescription();
    
    try {
	DFAgentDescription[] result = DFService.search(this, dfd);
      //
      for (i = 0; i < result.length; i++) {
	  DFAgentDescription desc = (DFAgentDescription)result[i];
	  String out = desc.getName()+" provide";
	  Iterator iter2 = desc.getAllServices();
	  while (iter2.hasNext()) {
	      ServiceDescription sd = (ServiceDescription)iter2.next();
	      out += " "+sd.getName();
	  }
	  System.out.println(this.getLocalName()+": "+out);
      }
      
    }
    catch (Exception fe) {
      System.err.println(getLocalName() + " search with DF is not succeeded because of " + fe.getMessage());
      doDelete();
    }
  }
}
