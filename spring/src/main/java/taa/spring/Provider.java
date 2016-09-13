package taa.spring;

import org.springframework.stereotype.Component;

@Component
public class Provider implements IProvider{

  public double getPrice(Article a) {
    return a.prix;
  }

  public void order(Article a) {
    a.quantite += 5;
  }

}
