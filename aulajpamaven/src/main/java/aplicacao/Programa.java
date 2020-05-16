package aplicacao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import dominio.Pessoa;

public class Programa {

	public static void main(String[] args) {
		
		//::::código para escrever no banco de dados::::
//		Pessoa p1 = new Pessoa(null,"Carlos Silveira", "carlos@gmail.com");
//		Pessoa p2 = new Pessoa(null,"Maria José", "maria@gmail.com");
//		Pessoa p3 = new Pessoa(null,"Carl Johnson", "CJ@gmail.com");//null em id pois o bd incrementa autom.
//		
//		//com esses dois comando já é instanciada a conexão com o banco de dados
//		EntityManagerFactory emf = Persistence.createEntityManagerFactory("exemplo-jpa");
//		EntityManager em = emf.createEntityManager();
//		
//		//quando o jpa faz operação além de leitura, é necessario uma transação
//		em.getTransaction().begin();
//		//.persis(obj) salva o dado desejado no bd
//		em.persist(p1);
//		em.persist(p2);
//		em.persist(p3);
//		em.getTransaction().commit();//envia os comandos para o BD
//		System.out.println("OK!");


		//com esses dois comando já é instanciada a conexão com o banco de dados
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("exemplo-jpa");
		EntityManager em = emf.createEntityManager();
		
//		//::::código para buscar no banco de dados::::
//		Pessoa p = em.find(Pessoa.class, 3);
//		
//		System.out.println(p);
		
//		Pessoa p = new Pessoa(2,null,null);//JPA não remove, a instância não está sendo monitorada (destacada)
//		em.remove(p);
		
		//remover pessoa p no BD		
		Pessoa p = em.find(Pessoa.class, 2);
		em.getTransaction().begin();
		em.remove(p);
		em.getTransaction().commit();//sempre que for operação além de find() utilizar os transactions
		
		System.out.println("OK!");
		em.close();//sempre fechar ao usar em e emf
		emf.close();
		
	}	

}
