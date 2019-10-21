/**
 * 
 */
package dp.facede;

/**
 * @author DhanunjayaY
 *
 */
public class FacedePattern {

	void getReport(String database, String report, String tableName){
		switch (database) {
		case "MySql":
			DatabaseConnection conn = new MySQLConnection().getConnection();
			if(report.equals("HTML")){
				Report rep= new HTMLReport();
				rep.getReport("Employee", conn);
			}else{
				Report rep= new PDFReport();
				rep.getReport("Employee", conn);
			}
			break;
		case "Oracle":
			DatabaseConnection con = new OracleConnection().getConnection();
			if(report.equals("HTML")){
				Report rep= new HTMLReport();
				rep.getReport("Employee", con);
			}else{
				Report rep= new PDFReport();
				rep.getReport("Employee", con);
			}
			break;
		default:
			break;
		}
	}
}
