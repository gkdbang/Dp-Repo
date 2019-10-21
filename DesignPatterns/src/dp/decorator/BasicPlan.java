/**
 * 
 */
package dp.decorator;

/**
 * @author DhanunjayaY
 *
 */
public class BasicPlan implements SatilliteTV {

	/* (non-Javadoc)
	 * @see dp.decorator.SatilliteTV#getChannel(java.lang.String)
	 */
	@Override
	public void getChannel(int channel) {
		if(channel > 0 && channel <= 100){
			System.out.println("Your are waching Basic Channels");
		}else{
			System.out.println("Your not subscribed to this Channel");
		}

	}

	/* (non-Javadoc)
	 * @see dp.decorator.SatilliteTV#getFee()
	 */
	@Override
	public int getFee() {
		return 100;
	}

}
