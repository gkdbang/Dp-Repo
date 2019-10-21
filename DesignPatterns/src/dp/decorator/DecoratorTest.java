/**
 * 
 */
package dp.decorator;

/**
 * @author DhanunjayaY
 *
 */
public class DecoratorTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SatilliteTV tv = new KidsPkg(new BasicPlan() );
		tv.getChannel(280);
		System.out.println(tv.getFee());
	}

}
