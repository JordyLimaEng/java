package entities;

public /*abstract*/ class Account { //abstract garante que a classe Account na seja instanciada

		private Integer number;
		private String holder;
		protected Double balance;//acessivel de uma classe do mesmo pacote ou classe filha
		
		public Account() {}

		public Account(Integer number, String holder, Double balance) {
			super();
			this.number = number;
			this.holder = holder;
			this.balance = balance;
		}

		public Integer getNumber() {
			return number;
		}

		public void setNumber(Integer number) {
			this.number = number;
		}

		public String getHolder() {
			return holder;
		}

		public void setHolder(String holder) {
			this.holder = holder;
		}

		public Double getBalance() {
			return balance;
		}
		
		public void withdraw(double amount) {
			balance -= amount + 5.0;
		}
		
		public void deposit(double amount) {
			balance += amount;		
		}
		
}
