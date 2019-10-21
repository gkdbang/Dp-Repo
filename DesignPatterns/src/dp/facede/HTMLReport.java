/**
 * 
 */
package dp.facede;

/**
 * @author DhanunjayaY
 *
 */
public class HTMLReport implements Report {

	/* (non-Javadoc)
	 * @see dp.facede.Report#getReport(java.lang.String, dp.facede.DatabaseConnection)
	 */
	@Override
	public void getReport(String table, DatabaseConnection connection) {
		System.out.println("HTML Report from " + table);

	}

}
