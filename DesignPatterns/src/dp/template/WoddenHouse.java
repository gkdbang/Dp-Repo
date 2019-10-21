/**
 * 
 */
package dp.template;

/**
 * @author DhanunjayaY
 *
 */
public class WoddenHouse extends House {

	/* (non-Javadoc)
	 * @see dp.template.House#buildWindows()
	 */
	@Override
	void buildWindows() {
		System.out.println("Wodden windows are arranged to the house");

	}

	/* (non-Javadoc)
	 * @see dp.template.House#buildPillers()
	 */
	@Override
	void buildPillers() {
		System.out.println("Pillers are constructed with wodden covers");

	}

	/* (non-Javadoc)
	 * @see dp.template.House#buildWalls()
	 */
	@Override
	void buildWalls() {
		System.out.println("Wodden walls are arranged to the house");
	}

}
