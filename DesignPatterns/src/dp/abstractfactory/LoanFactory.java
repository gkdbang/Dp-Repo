package dp.abstractfactory;

public class LoanFactory implements BankingFactory{

	@Override
	public Bank getBankFactory(String name) {
		return null;
	}

	@Override
	public Loan getLoanFactory(String name) {
		if(name.equals("personal")){
			return new PersonalLoan();
		}else{
			return new HousingLoan();
		}
	}

}
