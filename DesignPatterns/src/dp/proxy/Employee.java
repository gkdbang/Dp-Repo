/**
 * 
 */
package dp.proxy;

/**
 * @author DhanunjayaY
 *
 */
public class Employee implements InternetAccess {
	
	private String name;
 
	
	public Employee(String name) {
		super();
		this.name = name;
	}

	/* (non-Javadoc)
	 * @see dp.proxy.InternateAccess#grantAccess()
	 */
	@Override
	public void grantAccess() {
		System.out.println("Internet Access granted to " + name);

	}

}
