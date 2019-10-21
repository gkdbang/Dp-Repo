/**
 * 
 */
package dp.proxy;

/**
 * @author DhanunjayaY
 *
 */
public class ProxyPattern implements InternetAccess {

	private String name;
	
	private InternetAccess interateAccess;
	
	
	public ProxyPattern(String name) {
		super();
		this.name = name;
	}
	/* (non-Javadoc)
	 * @see dp.proxy.InternetAccess#grantAccess()
	 */
	@Override
	public void grantAccess() {
		if(getRoles(name)){
			interateAccess = new Employee(name);
			interateAccess.grantAccess();
		}else{
			System.out.println("not authorized to access the internet");
		}

	}
	
	private boolean getRoles(String name){
		//TODO perform DB call to get his roles
		return true;
	}

}
