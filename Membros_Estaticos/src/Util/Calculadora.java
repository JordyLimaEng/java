package Util;

public class Calculadora {
	public static final double PI = 3.14159; //final diz que o valor é constante e não muda mais
	//padrão para constantes é fonte upper scale

	public static double circunferencia(double raio) {
		return 2*PI*raio;
	}
	
	public static double volume(double raio) {
		return 4*PI*Math.pow(raio, 3)/3;
	}

}
