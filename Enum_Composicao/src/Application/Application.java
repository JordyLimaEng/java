package Application;

import java.util.Date;

import entities.enums.OrderStatus;
import entitites.Order;

public class Application {

	public static void main(String[] args) {
		//Enumera��es s�o um tipo especial para especificar literalmente
		// um conjunto de constantes relacionadas... enum
		//melhor semantica e c�digo mais legivel e auxiliado pelo compilador
		
		Order order = new Order(1080, new Date(), OrderStatus.PENDING_PAYMENT);
		
		System.out.println(order);
		
		//eventualmente os valores para enum's serao recebidos do usuario
		// portanto � necessario tamb�m converter de string para enum
		
		OrderStatus os1 = OrderStatus.DELIVERED;
		
		OrderStatus os2 = OrderStatus.valueOf("DELIVERED");
		
		System.out.println(os1);
		System.out.println(os2);
		
		//Composi��o - associa��o que permite que um objeto obtenha outra
		// rela��o tem-um ou tem-varios
		// reuso, flexibilidade, organiza��o e coes�o
		
		
	}

}
