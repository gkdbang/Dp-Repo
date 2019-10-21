/**
 * 
 */
package dp.abstractfactory;

/**
 * @author DhanunjayaY
 *
 */
public interface BankingFactory {

	public Bank getBankFactory(String name);
	public Loan getLoanFactory(String name);
}
