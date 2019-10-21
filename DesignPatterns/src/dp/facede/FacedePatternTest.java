/**
 * 
 */
package dp.facede;

import javax.xml.crypto.Data;

/**
 * @author DhanunjayaY
 *
 */
public class FacedePatternTest {
	
	private static final String MYSQL = "MySql";
	private static final String ORACLE = "Oracle";
	
	private static final String HTML = "HTML";
	private static final String PDF = "PDF";

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		FacedePattern fp = new FacedePattern();
		fp.getReport(MYSQL, HTML, "Employee");
		 System.out.println("------------------");
		fp.getReport(ORACLE, PDF, "Employee");
	}

}
