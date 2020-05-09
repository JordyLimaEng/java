package Application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Application {

	public static void main(String[] args) {
		//classes do tipo wrapper
		//� melhor utilizar valores do tipo object Integer, Double, Character, Boolean
		//Byte, Short, Long, Float pois aceitam receber valores do tipo NULL
		
		//tipos primitivos em java
		//boolean, char, byte, shot, int, long, float, double
		
		//se n�o for dito, por padr�o os tipos ... sao inicializados:
		// boolean - false, char - 0, numero - 0, objeto - 0
		
		//desaloca��o de mem�ria (garbage collector)
		//automatiza o gerenciamento de mem�ria de um program em execu��o
		
		// desaloca��o por escopo
		// exemplo de um if, as variaveis dentro de um if ou m�todo s�o desalocadas ap�s sairem do escpo de execu��o.
		
		Locale.setDefault(Locale.US);		
		Scanner sc = new Scanner(System.in);
		
		/*int n = sc.nextInt();
		double[] v = new double[n]; //declara��o de vetor
		
		for(int i=0; i<n; i++) {
			v[i] = sc.nextDouble();
		}		
		
		double r = 0,  acc = 0;
		
		for(int i=0; i<n; i++) {
			acc += v[i];			
		}
		
		r = acc/n;
		
		System.out.printf("m�dia: %.2f", r);
		*/		
		
		/*
		int n = sc.nextInt();		
		Produto[] vetor = new Produto[n];
		
		for(int i=0; i<vetor.length; i++) {
			sc.nextLine();
			System.out.print("Indique o nome do produto: ");
			String nome = sc.nextLine();
			System.out.print("Indique o preco do produto: ");
			double preco = sc.nextDouble();					
			vetor[i] = new Produto(nome, preco);
		}
		
		double acc = 0, med = 0;
		
		for(int i=0; i<vetor.length; i++) {
			acc += vetor[i].getPreco();
		}
		
		System.out.printf("Preco medio - %.2f\n", acc/n);
		*/
		
		//Exercicio de fixa��o
		
		/*System.out.println("Quantos quartos ser�o alugados? ");
		int n = sc.nextInt();		
		Quartos[] v = new Quartos[10];
		
		for(int i=0; i<n; i++) {
			System.out.printf("\nAluguel #%d:\n", i+1);
			sc.nextLine();
			
			System.out.print("Nome: ");
			String nome = sc.nextLine();
			
			System.out.print("Email: ");
			String email = sc.nextLine();
			
			System.out.print("Quarto: ");
			int quarto = sc.nextInt();
			
			v[quarto] = new Quartos(nome, email);
		}
		
		System.out.println("Quartos alugados:\n");
		for(int i=0; i<10; i++) {		
			if(v[i] != null) {
				System.out.println(i + ": "+ v[i]);
			}
		}
		*/
		
		//for each
		
		/*String[] v = new String[] {"Maria", "Bob", "Alex"};
		
		for(String obj : v) {// percorre todos os "objs" de v
			System.out.println(obj);			
		}*/
		

		/*
		//listas		
		List<String> list = new ArrayList<String>(); //declara��o usando wrapper
		
		list.add("Maria");
		list.add("Mari");
		list.add("Marta");
				
		for(String x: list) { //for each
			System.out.println(x);
		}
		
		list.add(2,"Marco"); //add em um espa�o especifico
		
		System.out.print("\n");
		for(String x: list) {
			System.out.println(x);
		}
		
		list.remove("Marco"); //Remove o valor especificado
		
		System.out.print("\n");
		for(String x: list) {
			System.out.println(x);
		}
		
		list.remove(1); //Remove em um local especifico
		
		System.out.print("\n");
		for(String x: list) {
			System.out.println(x);
		}
		
		list.removeIf(x -> x.charAt(3) == 't'); //Remove de de acordo com condi��o
		
		System.out.print("\n");
		for(String x: list) {
			System.out.println(x);
		}
		
		//acha posicao de elemento se achar retorna pos, se nao -1
		System.out.println("pos de maria - " + list.indexOf("Maria")); 
		
		list.add("Saria");
		list.add("Tari");
		list.add("Marta");
		
		//filtrar lista de acordo com condicao
		List<String> result = list.stream().filter(x -> x.charAt(0) == 'M').collect(Collectors.toList());
		
		System.out.print("\nvetor sem filtro\n");
		for(String x: list) {
			System.out.println(x);
		}
		
		System.out.print("\nvetor filtrado para M\n");
		for(String x: result) {
			System.out.println(x);
		}
		
		System.out.println();// encontrar um determinado valor e se encontrar o retorna, se n�o retorna null
		String nome = list.stream().filter(x -> x.charAt(0) == 'T').findFirst().orElse(null);
		System.out.println(nome);
		*/
		
		//Matrizes (vetores bidimensionais)		
		int n = sc.nextInt();		
		int[][] mat = new int[n][n];
		
		for (int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				mat[i][j] = sc.nextInt();
			}			
		}
		int acc = 0;
		for (int i=0; i<mat.length; i++) { //imprimindo diagonal principal e indica qt numeros neg
			for(int j=0; j<mat[i].length; j++) {//mat[i].length est� relacionado como se cada linha da matriz fosse um vetor de posi��es
				if(i==j) {System.out.print(mat[i][j] + " ");}
				if(mat[i][j] < 0) {acc++;};
			}
		}
		
		System.out.println("Possui " + acc + " numeros negativos");
		
		//propriedade length em matrizes so usar o mat.lentgh()
		
		
		
		
		
		
		sc.close();
	}

}
