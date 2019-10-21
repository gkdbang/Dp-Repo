/**
 * 
 */
package dp.abstractfactory;

/**
 * @author DhanunjayaY
 *
 */
public class AbstractFactoryTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		BankingFactory b = AbstractFactoryCreator.getFactory("bank");
		b.getBankFactory("sbi").getBankName();
		
		BankingFactory b1 = AbstractFactoryCreator.getFactory("loan");
		System.out.println(b1.getLoanFactory("personal").getIntrestRate());

	}

}
