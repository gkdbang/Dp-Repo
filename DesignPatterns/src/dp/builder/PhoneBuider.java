/**
 * 
 */
package dp.builder;

/**
 * @author DhanunjayaY
 *
 */
public class PhoneBuider {
	
	private String os;
	private double size;
	private String processer;
	private int battery;
	
	public PhoneBuider setOs(String os) {
		this.os = os;
		return this;
	}
	public PhoneBuider setSize(double size) {
		this.size = size;
		return this;
	}
	public PhoneBuider setProcesser(String processer) {
		this.processer = processer;
		return this;
	}
	public PhoneBuider setBattery(int battery) {
		this.battery = battery;
		return this;
	}
	
	public Phone getPhone(){
		return new Phone(os, size, processer, battery);
	}
}
