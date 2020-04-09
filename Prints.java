import java.util.Locale;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		//exemplos de tipos e saída de dados
		int a=50, b=24;
		double res;
		res = (double) a/b;
		System.out.printf("Resultado: %d / %d = %.2f\n",a,b,res);
		System.out.println("valor A = "+a+"   Valor B = "+b);
				
		String nome = "João";
		int idade = 50;
		double renda = 5000;
		
		System.out.printf("%s tem renda R$%.2f e idade %d\n\n", nome, renda, idade);
		
		//uso de prints
		String product1="Computer", product2="Office Desk";
		int age=30, code=5290;
		char gender = 'F';
		double price1=2100.0, price2=650.50, measure=53.234567;
		
		
		System.out.printf("Products:\nComputer, which price is $ %.2f\n "
				+"Office Desk, which price is $ %.2f\n\n"
				+"Record: %d, code %d and gender: %s\n\n"
				+"Measure with eight decimal places: %.8f\n"
				+"Rouded (three decimal places): %.3f\n",
				price1,price2,age,code,gender,measure,measure);
		
		
		Locale.setDefault(Locale.US);
		
		System.out.printf("US decimal point: %.3f\n\n",measure);
		
		
	}

}
