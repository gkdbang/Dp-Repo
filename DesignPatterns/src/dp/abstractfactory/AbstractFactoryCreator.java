/**
 * 
 */
package dp.abstractfactory;

/**
 * @author DhanunjayaY
 *
 */
public class AbstractFactoryCreator {

	public static BankingFactory getFactory(String name){
		if(name.equals("bank")){
			return new BankFactory();
		}else{
			return new LoanFactory();
		}
	}
}
