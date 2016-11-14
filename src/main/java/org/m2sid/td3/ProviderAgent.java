package td1.df;

import jade.core.Agent;
import jade.domain.FIPAException;
import jade.domain.DFService; //Communicator
import jade.domain.FIPAAgentManagement.ServiceDescription;
import jade.domain.FIPAAgentManagement.DFAgentDescription;

public class ProviderAgent extends Agent {

  private String service;

  protected void setup() {
      Object[] args = getArguments();
      service = (String) args[0];

    System.out.println("Hello. My name is "+this.getLocalName()+
      " and I provide "+service+" service.");
    registerService();
  }

    
  private void registerService() {
    DFAgentDescription dfd = new DFAgentDescription();
    dfd.setName(this.getAID());

    ServiceDescription sd = new ServiceDescription();
    sd.setType(service);
    sd.setName(service);

    dfd.addServices(sd);
    try {
      DFService.register(this, dfd);
    }
    catch (FIPAException e) {
      System.err.println(getLocalName() +
        " registration with DF unsucceeded. Reason: " + e.getMessage());
      doDelete();
    }
  }
}
