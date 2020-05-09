package Application;

import java.util.Locale;
import java.util.Scanner;

import Entities.Triangulo;

public class Program {
	
	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		
		Scanner sc = new Scanner(System.in);
		
		Triangulo x, y;
		
		x = new Triangulo();
		y = new Triangulo();
		
		System.out.println("Insira as medidas do triangulo X: ");
		x.a = sc.nextDouble();
		x.b = sc.nextDouble();
		x.c = sc.nextDouble();
		System.out.println("Insira as medidas do triangulo y: ");
		y.a = sc.nextDouble();
		y.b = sc.nextDouble();
		y.c = sc.nextDouble();
		
		double areaX = x.Area();
		double areaY = y.Area();
				
		System.out.printf("Area triangulo X: %.4f%n",areaX);
		System.out.printf("Area triangulo X: %.4f%n",areaY);
		
		if(areaX>areaY) {
			System.out.println("AREA X MAIOR");
		}else {
			System.out.println("AREA Y MAIOR");
		}
		sc.close();
	}

}
