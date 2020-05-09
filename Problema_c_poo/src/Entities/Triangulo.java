package Entities;

public class Triangulo{
	public double a, b, c;
	
	public double Area() {
		double p = (a+b+c)/2.0;
		return Math.sqrt(p*(p-a)*(p-b)*(p-c));
	}
}