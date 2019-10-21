package dp.decorator;

public class KidsPkg extends DecoratorPattern {

	public KidsPkg(SatilliteTV tv) {
		super(tv);
	}

	@Override
	public void getChannel(int channel) {
		if(channel > 201 && channel <= 300){
			System.out.println("Your are waching kids Channels");
		}else{
			super.getChannel(channel);
		}

	}

	/* (non-Javadoc)
	 * @see dp.decorator.SatilliteTV#getFee()
	 */
	@Override
	public int getFee() {
		return super.getFee() + 5;
	}
}
