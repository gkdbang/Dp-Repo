/**
 * 
 */
package dp.stratogy;

/**
 * @author DhanunjayaY
 *
 */
public class StratogyTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Item item1 = new Item("Item1", 17247, 20);
		Item item2 = new Item("Item4", 1434, 40);
		Item item3 = new Item("Item5", 12344, 222);
		Item item4 = new Item("Item6", 8893, 9);
		
		ShoppingCart sc = new ShoppingCart();
		sc.getItems().add(item4);
		sc.getItems().add(item3);
		sc.getItems().add(item1);
		sc.getItems().add(item2);
		
		sc.payment(new UPIPayment("ydhana@okhdfc"));
		sc.payment(new CCPayment("12344554545333","DY", "07/2022", 767));

	}

}
