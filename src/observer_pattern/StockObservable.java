package observer_pattern;

import java.util.ArrayList;
import java.util.List;

interface StockObservable {
    void add(StockObserver obj);
    void remove(StockObserver obj);
    void notifyObs();
    int getStock();
    void setStock(int newStock);
}

class PhoneStock implements StockObservable {

	List<StockObserver> obsList = new ArrayList<>();
	int stock;
	
	@Override
	public synchronized void add(StockObserver obj) {
		// TODO Auto-generated method stub
		obsList.add(obj);
	}

	@Override
	public synchronized void remove(StockObserver obj) {
		// TODO Auto-generated method stub
		obsList.remove(obj);
	}
	@Override
	public synchronized void notifyObs() {
		// TODO Auto-generated method stub
		for(StockObserver obs : obsList) {
			obs.update();
		}
		
	}
	public synchronized void setStock(int newStock) {
		if(stock == 0 && newStock > 0) {
			stock = newStock;
			notifyObs();
		}
		else {
		stock = newStock;
		}
	}
	public int getStock() {
		return this.stock;
	}

	
}
