package dp.abstractfactory;

public class BankFactory implements BankingFactory {

	@Override
	public Bank getBankFactory(String name) {
		if(name.equals("sbi")){
			return new SBI();
		}else{
			return new HDFC();
		}
	}

	@Override
	public Loan getLoanFactory(String name) {
		
		return null;
	}

}
