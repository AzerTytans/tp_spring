package taa.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import taa.spring.IFastLane;;

@Component
public class Client implements IRun, IClient{
  
  @Autowired
  private IFastLane ifastlane;
  
  @Autowired
  private ILane ilane;
  
  @Autowired
  private IJustHaveALook ijusthavealook;
  
  
  public void run() {
    System.out.println("Scenario 1");
    ijusthavealook.isAvailable(0);
    ijusthavealook.getPrice(0);
    ifastlane.oneShotOrder(0);
    System.out.println("Article reference 0 : reçu.");
    System.out.println("Scenario 2");
    ilane.addItemToCart(0);
    ilane.addItemToCart(2);
    ilane.addItemToCart(3);
    ilane.addItemToCart(4);
    ilane.addItemToCart(0);
    System.out.println("Commande multiple reçu.");
  }

}
