/**
 * 
 */
package dp.decorator;

/**
 * @author DhanunjayaY
 *
 */
public class DecoratorPattern implements SatilliteTV {

	private SatilliteTV tv;
	
	public DecoratorPattern(SatilliteTV tv) {
		this.tv = tv;
	}
	
	/* (non-Javadoc)
	 * @see dp.decorator.SatilliteTV#getChannel(int)
	 */
	@Override
	public void getChannel(int channel) {
		tv.getChannel(channel);

	}

	/* (non-Javadoc)
	 * @see dp.decorator.SatilliteTV#getFee()
	 */
	@Override
	public int getFee() {
		
		return tv.getFee();
	}

}
