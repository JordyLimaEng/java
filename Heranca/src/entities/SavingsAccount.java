package entities;

public final class SavingsAccount extends Account {///usa final para evitar que seja criada outra classe a partir desta
	
	private Double interestRate;
	
	public SavingsAccount(){
		super();
	}

	public SavingsAccount(Integer number, String holder, Double balance, Double interestRate) {
		super(number, holder, balance);
		this.interestRate = interestRate;
	}

	public Double getInterestRate() {
		return interestRate;
	}

	public void setInterestRate(Double interestRate) {
		this.interestRate = interestRate;
	}
	
	public void updateBalance() {
		balance += balance * interestRate;
	}
	
	//boa pratica de programação, para sobreposição de metodo da classe pai
	@Override
	public final void withdraw(double amount){//evitar que withdraw seja sobreposto
		balance -= amount;
	}
	
	
}
