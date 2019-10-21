package dp.factory;

public class ConnectionFactoryTest {

	public static void main(String[] args) {
		DBConnection connection = 
				ConnectionFactory.getConnection("87");
		connection.connection();
	}

}
