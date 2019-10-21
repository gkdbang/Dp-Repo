/**
 * 
 */
package dp.decorator;

/**
 * @author DhanunjayaY
 *
 */
public class SportsPkg extends DecoratorPattern {

	public SportsPkg(SatilliteTV tv) {
		super(tv);
	}
	@Override
	public void getChannel(int channel) {
		if(channel > 101 && channel <= 200){
			System.out.println("Your are waching sports Channels");
		}else{
			super.getChannel(channel);
		}

	}

	/* (non-Javadoc)
	 * @see dp.decorator.SatilliteTV#getFee()
	 */
	@Override
	public int getFee() {
		return super.getFee() + 10;
	}

}
