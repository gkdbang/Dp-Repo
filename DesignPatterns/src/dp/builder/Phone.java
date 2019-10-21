/**
 * 
 */
package dp.builder;

/**
 * @author DhanunjayaY
 *
 */
public class Phone {

	private String os;
	private double size;
	private String processer;
	private int battery;
	
	public Phone(String os, double size, String processer, int battery) {
		super();
		this.os = os;
		this.size = size;
		this.processer = processer;
		this.battery = battery;
	}
	
	@Override
	public String toString() {
		return "Phone [os=" + os + ", size=" + size + ", processer="
				+ processer + ", battery=" + battery + "]";
	}
	
	
}
