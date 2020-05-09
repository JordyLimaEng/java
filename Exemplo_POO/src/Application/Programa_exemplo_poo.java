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
		//se for privado, os atributos de produto não são acessíveis aqui
		//os atributos de produto aqui estão sendo alterado através de setters (encapsulamento)
		produto.setNome(sc.nextLine()); 
		System.out.println(produto.getNome());
		System.out.print("Preço: ");
		produto.setPreco(sc.nextDouble());
		System.out.print("Quantidade: ");
		//não há um setter para quantidade por lógica de 
		//apenas pode adicionar quando houver movimento do estoque, 
		//e não ser acessado sempre a qualquer momento.
		produto.addProduto(sc.nextInt()); 
		
		System.out.println(produto); //como é object e agora tem versão na classe Produto, 
									 //ja detecta q está em um print e executa o toString
		
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
