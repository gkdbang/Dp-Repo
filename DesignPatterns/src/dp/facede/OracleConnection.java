/**
 * 
 */
package dp.facede;

/**
 * @author DhanunjayaY
 *
 */
public class OracleConnection implements DatabaseConnection {

	/* (non-Javadoc)
	 * @see dp.facede.DatabaseConnection#getConnection()
	 */
	@Override
	public DatabaseConnection getConnection() {
		System.out.println("Oracle database connection");
		return new OracleConnection();
	}

}
