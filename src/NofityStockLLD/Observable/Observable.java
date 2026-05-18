package NofityStockLLD.Observable;

import NofityStockLLD.Observer.Observer;
import NofityStockLLD.enitities.Product;

public interface Observable {
      public void addObserver(Observer observer);
      public void notifyObservers(Product product);
      public void removeObserver(Observer observer);
}
