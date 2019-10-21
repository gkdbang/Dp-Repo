package dp.adapter;

public class AdapterTest {

	public static void main(String[] args) {
		Adapter adapter = new AdapterImpl();
		
		Volts v4 = getVolts(adapter, 4);
		System.out.println("4 Volts = " + v4.getVolts());
		Volts v120 = getVolts(adapter, 120);
		System.out.println("120 Volts = " + v120.getVolts());
		Volts v240 = getVolts(adapter, 240);
		System.out.println("240 Volts = " + v240.getVolts());

	}

	private static Volts getVolts(Adapter adapter, int i) {
		switch (i) {
		case 4:
			return adapter.get4Volts();
		case 120:
			return adapter.get120Volts();
		case 240:
			return adapter.get240Volts();
		default:
			break;
		}
		return null;
	}

}
