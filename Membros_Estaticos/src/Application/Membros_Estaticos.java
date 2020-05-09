package Application;

import java.util.Locale;
import java.util.Scanner;

import Util.Calculadora;

public class Membros_Estaticos {
	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		
		
		//utilizando static de forma funcional
		System.out.println("valor do raio");
		double raio = sc.nextDouble();
		
		double c = Calculadora.circunferencia(raio);
		
		double v = Calculadora.volume(raio);
		
		System.out.printf("circunferencia: %.2f%n",c);
		System.out.printf("Volume: %.2f%n",v);
		System.out.printf("PI: %.2f%n",Calculadora.PI);
		
		sc.close();
	}
}
