/**
 * 
 */
package dp.builder;

/**
 * @author DhanunjayaY
 *
 */
public class PhoneBulderClient {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Phone phone = new Phone("Android", 5.5, "Qualcomm", 5000);
		System.out.println(phone);
		
		Phone phone1 = new PhoneBuider().setOs("IOS").setBattery(3100).getPhone();
		System.out.println(phone1);

	}

}
