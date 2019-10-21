/**
 * 
 */
package dp.facede;

/**
 * @author DhanunjayaY
 *
 */
public class PDFReport implements Report {

	/* (non-Javadoc)
	 * @see dp.facede.Report#getReport(java.lang.String, dp.facede.DatabaseConnection)
	 */
	@Override
	public void getReport(String table, DatabaseConnection connection) {
		System.out.println("PDF Report from " + table);

	}

}
