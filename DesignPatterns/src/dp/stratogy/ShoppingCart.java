/**
 * 
 */
package dp.stratogy;

import java.util.ArrayList;
import java.util.List;

/**
 * @author DhanunjayaY
 *
 */
public class ShoppingCart {
	
	private List<Item> items = null;

	/**
	 * 
	 */
	public ShoppingCart() {
		super();
		items = new ArrayList<Item>();
	}

	/**
	 * @return the items
	 */
	public List<Item> getItems() {
		return items;
	}

	/**
	 * @param items the items to set
	 */
	public void setItems(List<Item> items) {
		this.items = items;
	}
	
	private double calculateBill(){
		double bill = 0.0;
		for (Item item : getItems()) {
			bill += item.getPrice();
		}
		return bill;
	}
	
	public boolean payment(Stratogy stratogy){
		stratogy.pay((int)calculateBill());
		return true;
	}
	
	

}
