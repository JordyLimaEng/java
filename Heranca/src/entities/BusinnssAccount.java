package entities;

public class BusinnssAccount extends Account {
	
	private Double loanLimit;
	
	public BusinnssAccount() {
		super();
	}

	public BusinnssAccount(Integer number, String holder, Double balance, Double loanLimit) {
		super(number, holder, balance);//reaproveita o construtor da classe pai
		this.loanLimit = loanLimit;
	}

	public Double getLoanLimit() {
		return loanLimit;
	}

	public void setLoanLimit(Double loanLimit) {
		this.loanLimit = loanLimit;
	}
	
	public void loan(double amount) {
		if(amount <= loanLimit) {
			balance += amount - 10;			
		}
	}
	
	@Override
	public void withdraw(double amount) {
		super.withdraw(amount);
		balance -= 2.0;
	}
	
	
}
