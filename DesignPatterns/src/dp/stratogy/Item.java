/**
 * 
 */
package dp.stratogy;

/**
 * @author DhanunjayaY
 *
 */
public class Item {
	private String name;
	private Integer code;
	private double price;
	
	/**
	 * @param name
	 * @param code
	 * @param price
	 */
	public Item(String name, Integer code, double price) {
		super();
		this.name = name;
		this.code = code;
		this.price = price;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the code
	 */
	public Integer getCode() {
		return code;
	}

	/**
	 * @param code the code to set
	 */
	public void setCode(Integer code) {
		this.code = code;
	}

	/**
	 * @return the price
	 */
	public double getPrice() {
		return price;
	}

	/**
	 * @param price the price to set
	 */
	public void setPrice(double price) {
		this.price = price;
	}
	
}
