/**
 * 
 */
package dp.adapter;

/**
 * @author DhanunjayaY
 *
 */
public class AdapterImpl implements Adapter {

	/* (non-Javadoc)
	 * @see dp.adapter.Adapter#get240Volts()
	 */
	@Override
	public Volts get240Volts() {
		// TODO Auto-generated method stub
		return new Socket().getVolts();
	}

	/* (non-Javadoc)
	 * @see dp.adapter.Adapter#get120Volts()
	 */
	@Override
	public Volts get120Volts() {
		// TODO Auto-generated method stub
		return convert(new Socket().getVolts(), 2);
	}

	/* (non-Javadoc)
	 * @see dp.adapter.Adapter#get4Volts()
	 */
	@Override
	public Volts get4Volts() {
		// TODO Auto-generated method stub
		return convert(new Socket().getVolts(), 60);
	}
	
	private Volts convert(Volts volts, int i){
		return new Volts(volts.getVolts()/i);
	}

}
