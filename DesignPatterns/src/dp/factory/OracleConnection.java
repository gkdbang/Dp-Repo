/**
 * 
 */
package dp.factory;

/**
 * @author DhanunjayaY
 *
 */
public class OracleConnection implements DBConnection {

	/* (non-Javadoc)
	 * @see dp.factory.DBConnection#connection()
	 */
	@Override
	public void connection() {
		System.out.println("Oracle DB connection created");
	}

}
