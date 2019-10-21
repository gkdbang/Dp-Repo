/**
 * 
 */
package dp.stratogy;

/**
 * @author DhanunjayaY
 *
 */
public class UPIPayment implements Stratogy {

	private String upiaddress;
	
	
	/**
	 * @param upiaddress
	 */
	public UPIPayment(String upiaddress) {
		super();
		this.upiaddress = upiaddress;
	}


	/* (non-Javadoc)
	 * @see dp.stratogy.Stratogy#pay(int)
	 */
	@Override
	public void pay(int amount) {
		System.out.println(amount + " you paid from UPI mode");

	}

}
