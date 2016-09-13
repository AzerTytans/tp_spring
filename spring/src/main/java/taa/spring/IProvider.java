package taa.spring;

public interface IProvider {
  public double getPrice(Article a);
  public void order(Article a);
}
