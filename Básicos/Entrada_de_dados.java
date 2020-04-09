import java.util.Locale;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		//Entrada de dados
		Scanner input = new Scanner(System.in);
		
		String x,A,B,C;
		int y;
		double z;
		char w;		
				
		System.out.print("Digite algo: ");
		x = input.next();
		System.out.println("voce digitou: " + x);
		
		System.out.print("Digite um numero inteiro: ");		
		y = input.nextInt();
		System.out.println("O numero foi: " + y);
				
		System.out.print("Digite um numero real: ");		
		z = input.nextDouble();
		System.out.println("O numero foi: " + z);
		
		System.out.print("Digite um caracter: ");		
		w = input.next().charAt(0);
		System.out.println("O numero foi: " + w);		
		
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
