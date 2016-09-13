package taa.spring;

public interface IJustHaveALook extends IStore{
  public double getPrice(int reference);
  public boolean isAvailable(int reference);
}
