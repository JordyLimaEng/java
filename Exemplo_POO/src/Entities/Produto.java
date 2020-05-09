package Entities;

public class Produto {
	
	//*public* � acess�vel em todas as classes
	//*protected* pode ser acessado no mesmo pacote e subclasses de pacotes diferentes 	
	//*nada* String nome; // s� seria acessivel no mesmo pacote ou classe
		private String nome;// objeto s� � acessivel nessa classe
		private double preco;
		private int quantidade;
		
		public Produto() {}
		
		public double valorTotalEstoque() {
			return preco*quantidade;
		}
		
		public void addProduto(int quantidade) {
			this.quantidade += quantidade; //this � usado para atualizar o atributo da classe
		} 
		
		public void removerProduto(int quantidade) {
			this.quantidade -= quantidade;
		}
		
		public void setNome(String nome) {
			this.nome = nome;
		}
		
		public void setPreco(double preco) {
			this.preco = preco;
		}
		
		public String getNome() {
			return this.nome;
		}
		
		public double getPreco() {
			return this.preco;
		}
		
		public int getQuantidade() {
			return this.quantidade;
		}
		
		public String toString() {
			return nome + ", R$ " + String.format("%.2f", preco) + ", " + quantidade + " unidades, total: " + String.format("R$ %.2f", valorTotalEstoque());
		}
		
}
