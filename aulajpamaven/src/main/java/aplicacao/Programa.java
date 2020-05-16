package aplicacao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import dominio.Pessoa;

public class Programa {

	public static void main(String[] args) {
		
		//::::c�digo para escrever no banco de dados::::
//		Pessoa p1 = new Pessoa(null,"Carlos Silveira", "carlos@gmail.com");
//		Pessoa p2 = new Pessoa(null,"Maria Jos�", "maria@gmail.com");
//		Pessoa p3 = new Pessoa(null,"Carl Johnson", "CJ@gmail.com");//null em id pois o bd incrementa autom.
//		
//		//com esses dois comando j� � instanciada a conex�o com o banco de dados
//		EntityManagerFactory emf = Persistence.createEntityManagerFactory("exemplo-jpa");
//		EntityManager em = emf.createEntityManager();
//		
//		//quando o jpa faz opera��o al�m de leitura, � necessario uma transa��o
//		em.getTransaction().begin();
//		//.persis(obj) salva o dado desejado no bd
//		em.persist(p1);
//		em.persist(p2);
//		em.persist(p3);
//		em.getTransaction().commit();//envia os comandos para o BD
//		System.out.println("OK!");


		//com esses dois comando j� � instanciada a conex�o com o banco de dados
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("exemplo-jpa");
		EntityManager em = emf.createEntityManager();
		
//		//::::c�digo para buscar no banco de dados::::
//		Pessoa p = em.find(Pessoa.class, 3);
//		
//		System.out.println(p);
		
//		Pessoa p = new Pessoa(2,null,null);//JPA n�o remove, a inst�ncia n�o est� sendo monitorada (destacada)
//		em.remove(p);
		
		//remover pessoa p no BD		
		Pessoa p = em.find(Pessoa.class, 2);
		em.getTransaction().begin();
		em.remove(p);
		em.getTransaction().commit();//sempre que for opera��o al�m de find() utilizar os transactions
		
		System.out.println("OK!");
		em.close();//sempre fechar ao usar em e emf
		emf.close();
		
	}	

}
