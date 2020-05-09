package Application;

import entities.Account;
import entities.BusinnssAccount;
import entities.SavingsAccount;

public class program {

	public static void main(String[] args) {
		
		Account  acc = new Account(1001,"Alex",1000.0);
		
		BusinnssAccount bacc = new BusinnssAccount(1002, "Maria",0.0, 500.0);
		
		//UPCASTING
		Account acc1 = bacc;		
		Account acc2 = new BusinnssAccount(1003, "Bob", 0.0, 200.0);		
		Account acc3 = new SavingsAccount(1004, "Anna", 0.0, 0.01);
		
		//DOWNCASTING
		BusinnssAccount acc4 = (BusinnssAccount)acc2; //tem que fazer um casting pra poder funcionar
		acc4.loan(100.0);
		
		//BusinnssAccount acc5 = (BusinnssAccount)acc3; //não é permitido, mas o compilador nao sabe e so vai saber ao executar, 
													  //acc3 é uma saving account
		//para evitar error, usa-se instanceOf
		
		if(acc3 instanceof BusinnssAccount) {
			BusinnssAccount acc5 = (BusinnssAccount)acc3;
			acc5.loan(200.0);
			System.out.println("loan!");
		}
		
		if(acc3 instanceof SavingsAccount) {
			SavingsAccount acc5 = (SavingsAccount)acc3;
			acc5.updateBalance();
			System.out.println("update!");
		}
		
		acc.getBalance();
		
		//fazendo uso do override da superclasse
		
		acc.withdraw(200.0);
		System.out.println(acc.getBalance());
		
		Account acc5 = new SavingsAccount(1002,"Maria",1000.0,0.01);
		acc5.withdraw(200.0);
		System.out.println(acc5.getBalance());
		
		Account c3 = new BusinnssAccount(1003, "bBOB", 1000.0, 500.0);
		c3.withdraw(200.0);
		System.out.println(c3.getBalance());
		
		///teste de abstract... se abstract, a c1 n pode ser instanciada
		Account c1 = new Account(1001, "Alex", 1000.0);
		Account c2 = new SavingsAccount(1002, "Maria", 1000.0, 0.01);
		Account c4 = new BusinnssAccount(1003, "Bob", 1000.0, 500.0);
		//metodos abstratos sao usados quando a classe é mt genérica
		
		
	}

}
