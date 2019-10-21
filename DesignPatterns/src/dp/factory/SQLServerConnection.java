/**
 * 
 */
package dp.factory;

/**
 * @author DhanunjayaY
 *
 */
public class SQLServerConnection implements DBConnection {

	/* (non-Javadoc)
	 * @see dp.factory.DBConnection#connection()
	 */
	@Override
	public void connection() {
		System.out.println("SQLServer DB connection created");
	}

}
