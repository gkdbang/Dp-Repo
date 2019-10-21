/**
 * 
 */
package dp.template;

/**
 * @author DhanunjayaY
 *
 */
public class GlassHouse extends House {

	/* (non-Javadoc)
	 * @see dp.template.House#buildWindows()
	 */
	@Override
	void buildWindows() {
		System.out.println("Glass windows are arranged to the house");

	}

	/* (non-Javadoc)
	 * @see dp.template.House#buildPillers()
	 */
	@Override
	public void buildPillers() {
		System.out.println("Pillers are constructed with glass coating");

	}

	/* (non-Javadoc)
	 * @see dp.template.House#buildWalls()
	 */
	@Override
	public void buildWalls() {
		System.out.println("Glass walls are arranged to the house");
	}
	
	@Override
	public void buildRoof() {
		System.out.println("Glass Roof implemented for house");
	}

}
