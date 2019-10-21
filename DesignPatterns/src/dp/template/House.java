/**
 * 
 */
package dp.template;

/**
 * @author DhanunjayaY
 *
 */
public abstract class House {
	
	final void buildHouse(){
		buildFoundation();
		buildPillers();
		buildWalls();
		buildWindows();
		buildRoof();
		System.out.println("House constructed...");
	}

	public void buildRoof() {
		System.out.println("Roof developed ");
		
	}

	public void buildFoundation() {
		
		System.out.println("Foundation created to build house");
	}
	
	abstract void buildWindows();
	
	abstract void buildPillers();
	
	abstract void buildWalls();
	
	

}
