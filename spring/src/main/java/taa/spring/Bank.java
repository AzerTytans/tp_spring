package taa.spring;

import org.springframework.stereotype.Component;

@Component
public class Bank implements IBank{
  
  public double compte_client;
  public double compte_store;

  public Bank(){
    super();
    compte_client = 100.00;
    compte_store = 1000.00;
  }
  
  public void transfert(double prix) {
    compte_client -= prix;
    compte_store += prix;
  }

}
