/**
 * 
 */
package dp.factory;


/**
 * @author DhanunjayaY
 *
 */
public class ConnectionFactory {

	public static DBConnection getConnection(String key){
		if (key.equals("or")) {
			return  new OracleConnection();
		}else if(key.equals("sqls")){
			return new SQLServerConnection();
		}else{
			return new MySQLConnection();
		}
	}
}
