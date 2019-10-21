/**
 * 
 */
package dp.stratogy;

/**
 * @author DhanunjayaY
 *
 */
public class CCPayment implements Stratogy {

	private String number;
	private String name;
	private String exp;
	private int cvv;
	
	
	/**
	 * @param number
	 * @param name
	 * @param exp
	 * @param cvv
	 */
	public CCPayment(String number, String name, String exp, int cvv) {
		super();
		this.number = number;
		this.name = name;
		this.exp = exp;
		this.cvv = cvv;
	}


	/* (non-Javadoc)
	 * @see dp.stratogy.Stratogy#pay(int)
	 */
	@Override
	public void pay(int amount) {
		System.out.println(amount + " you paid from credit card");
	}

}
