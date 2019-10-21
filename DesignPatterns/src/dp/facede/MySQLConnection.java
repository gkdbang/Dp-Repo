package dp.facede;

public class MySQLConnection implements DatabaseConnection {

	@Override
	public DatabaseConnection getConnection() {
		System.out.println("MySql Database connection");
		return new MySQLConnection();
	}

}
