package NofityStockLLD.Observer;

import java.util.List;

import NofityStockLLD.enitities.Product;
import NofityStockLLD.enitities.User;

public interface Observer {
    public void update(List<User> user,Product product) ;
}
