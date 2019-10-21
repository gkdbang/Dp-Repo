/**
 * 
 */
package dp.factory;

/**
 * @author DhanunjayaY
 *
 */
public class MySQLConnection implements DBConnection {

	/* (non-Javadoc)
	 * @see dp.factory.DBConnection#connection()
	 */
	@Override
	public void connection() {
		System.out.println("MySQL DB connection created");
	}

}
