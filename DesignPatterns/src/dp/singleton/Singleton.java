/**
 * 
 */
package dp.singleton;

/**
 * @author DhanunjayaY
 *
 */
public class Singleton {
	
	private static Singleton instance;
	
	private Singleton(){
		super();
	}
	
	public static Singleton getInstance(){
		if(instance == null){
			synchronized (Singleton.class) {
				if(instance == null){
					instance = new Singleton();
				}
				return instance;
			}
		}
		return instance;
	}
	
	

}
