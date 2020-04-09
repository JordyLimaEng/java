import java.util.Locale;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		//Funções matemáticas
		double n1 = 3.0, n2 = 4.0, n3 = -5.0, r1, r2, r3;
		
		r1 = Math.sqrt(n1);
		r2 = Math.sqrt(n2);
		r3 = Math.sqrt(25.0);
		
		System.out.println(r1+", "+r2+", "+r3+" ");
		
		r1 = Math.pow(n1,2);
		r2 = Math.pow(n2,n2);
		r3 = Math.pow(5.0,5.0);
		
		System.out.println(r1+", "+r2+", "+r3+" ");
		
		r1 = Math.abs(n3);
		
		System.out.println(r1);
		
	}

}
