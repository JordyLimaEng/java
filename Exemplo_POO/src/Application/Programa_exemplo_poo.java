package Application;

import java.util.Locale;
import java.util.Scanner;

import Entities.Produto;

public class Programa_exemplo_poo {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		Produto produto = new Produto();
		
		System.out.println("Dados do produto:");
		System.out.print("Nome: ");		
		//se for privado, os atributos de produto n�o s�o acess�veis aqui
		//os atributos de produto aqui est�o sendo alterado atrav�s de setters (encapsulamento)
		produto.setNome(sc.nextLine()); 
		System.out.println(produto.getNome());
		System.out.print("Pre�o: ");
		produto.setPreco(sc.nextDouble());
		System.out.print("Quantidade: ");
		//n�o h� um setter para quantidade por l�gica de 
		//apenas pode adicionar quando houver movimento do estoque, 
		//e n�o ser acessado sempre a qualquer momento.
		produto.addProduto(sc.nextInt()); 
		
		System.out.println(produto); //como � object e agora tem vers�o na classe Produto, 
									 //ja detecta q est� em um print e executa o toString
		
		System.out.println("Quantidade de produtos a serem inseridos no estoque: ");
		int quant = sc.nextInt();
		produto.addProduto(quant);
		
		System.out.println("Estoque atualizado: " + produto);
		
		System.out.println("Quantidade de produtos a serem removidos no estoque: ");
		quant = sc.nextInt();
		produto.removerProduto(quant);
		
		System.out.println("Estoque atualizado: " + produto);
		
		
		sc.close();

	}

}
