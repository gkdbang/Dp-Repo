/**
 * 
 */
package dp.proxy;

/**
 * @author DhanunjayaY
 *
 */
public class ProxyTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		InternetAccess ia = new ProxyPattern("DY");
		ia.grantAccess();

	}

}
