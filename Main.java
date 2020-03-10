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
		
		//Entrada de dados
		Scanner input = new Scanner(System.in);
		
		String x,A,B,C;
		int y;
		double z;
		char w;
				
		System.out.print("Digite algo: ");
		x = input.next();
		//System.out.println("voce digitou: " + x);
		
		System.out.print("Digite um numero inteiro: ");		
		y = input.nextInt();
		//System.out.println("O numero foi: " + y);
				
		System.out.print("Digite um numero real: ");		
		z = input.nextDouble();
		//System.out.println("O numero foi: " + z);
		
		System.out.print("Digite um caracter: ");		
		w = input.next().charAt(0);
		//System.out.println("O numero foi: " + w);		
		
		input.nextLine();//pra elimintar a \n pendente
		
		System.out.print("Digite primeira frase: ");
		A = input.nextLine();
		
		System.out.print("Digite segunda frase: ");
		B = input.nextLine();
		
		System.out.print("Digite terceira frase: ");
		C = input.nextLine();				
		
		input.close();	
		
		System.out.printf("\nDados digitados: %s %d %.2f %c\n\n",x,y,z,w);
		System.out.println("Frases: "+A+", "+B+", "+C);		
		
	}

}
