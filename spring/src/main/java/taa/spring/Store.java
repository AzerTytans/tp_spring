package taa.spring;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Store implements IStore, IJustHaveALook, IFastLane, ILane{

  private List<Article> lesarticles;
  private List<Article> cart;

  @Autowired
  private IBank ibank;

  @Autowired
  private IProvider iprovider;

  public Store(){
    super();
    cart = new ArrayList<Article>();
    lesarticles = new ArrayList<Article>();
    lesarticles.add(new Article(1, 0, 5.00));
    lesarticles.add(new Article(1, 1, 4.00));
    lesarticles.add(new Article(1, 2, 3.00));
    lesarticles.add(new Article(1, 3, 2.00));
    lesarticles.add(new Article(1, 4, 1.00));
  }

  public void addItemToCart(int reference) {
    Article a = findArticle(reference);
    if(a.quantite > 0){
      cart.add(a);
      a.quantite--;
    }
    else{
      System.out.println("Article : " + a.reference + " en rupture de sotck. Commande en cours.");
      iprovider.order(a);
      cart.add(a);
      a.quantite--;
    }
  }

  public void pay() {
    double prix = 0.0;
    for(Article a : cart)
      prix += a.prix;
    System.out.println("Vous devez payez : " + prix);
    ibank.transfert(prix);
    System.out.println("Paiement effectué.");
  }

  public double getPrice(int reference) {
    Article a = findArticle(reference);
    return a.prix;
  }

  public boolean isAvailable(int reference) {
    Article a = findArticle(reference);
    return a.quantite > 0;
  }

  public void oneShotOrder(int reference) {
    Article a = findArticle(reference);
    if(a.quantite > 0){
      System.out.println("Vous devez payez : " + a.prix);
      ibank.transfert(a.prix);
      a.quantite--;
      System.out.println("Paiement effectué.");
    }
    else{
      System.out.println("Article : " + a.reference + " en rupture de sotck. Commande en cours.");
      iprovider.order(a);
      System.out.println("Vous devez payez : " + a.prix);
      ibank.transfert(a.prix);
      a.quantite--;
      System.out.println("Paiement effectué.");
    }
  }

  public Article findArticle(int reference){
    for(Article ar : lesarticles)
      if(ar.reference == reference)
        return ar;
    return null;
  }


}
