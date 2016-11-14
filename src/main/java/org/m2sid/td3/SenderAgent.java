package td1.datamessage;

import java.util.Iterator;

import jade.core.AID;
import jade.core.Agent;
import jade.lang.acl.ACLMessage;
import jade.domain.DFService;
import jade.domain.FIPAAgentManagement.DFAgentDescription;
import jade.domain.FIPAAgentManagement.ServiceDescription;


public class SenderAgent extends Agent {

  protected void setup() {
    System.out.println("Hello. My name is " + this.getLocalName());
    Object[] args = getArguments();
    String message = (String) args[0];
    AID aid = new AID();
        
    DFAgentDescription dfd = new DFAgentDescription();
    
    try {
        DFAgentDescription[] result = DFService.search(this, dfd);
        String out = "";
        int i=0;
	String service = "";
        while ((service.compareTo("receiver")!=0) && (i<result.length)) {
    	DFAgentDescription desc = (DFAgentDescription)result[i];
	Iterator iter2 = desc.getAllServices();
	  while (iter2.hasNext()) {
	      ServiceDescription sd = (ServiceDescription)iter2.next();
	      service = sd.getName();
	      if (service.compareTo("receiver") == 0){
		  aid = desc.getName();
		  break;
	      }
	  }
    	System.out.println(aid.getName());
    
    sendMessage(message, aid);
    	i++;
    }
        }
     catch (Exception fe) {
    }
    
  }

  private void sendMessage(String mess, AID id) {
    try {
      ACLMessage aclMessage = new ACLMessage(ACLMessage.REQUEST);
      aclMessage.addReceiver(id);
      
      aclMessage.setContent(mess);

      this.send(aclMessage);
    }
    catch (Exception ex) {
      ex.printStackTrace();
    }
  }

}




