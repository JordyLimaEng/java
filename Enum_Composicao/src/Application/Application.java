package Application;

import java.util.Date;

import entities.enums.OrderStatus;
import entitites.Order;

public class Application {

	public static void main(String[] args) {
		//Enumerações são um tipo especial para especificar literalmente
		// um conjunto de constantes relacionadas... enum
		//melhor semantica e código mais legivel e auxiliado pelo compilador
		
		Order order = new Order(1080, new Date(), OrderStatus.PENDING_PAYMENT);
		
		System.out.println(order);
		
		//eventualmente os valores para enum's serao recebidos do usuario
		// portanto é necessario também converter de string para enum
		
		OrderStatus os1 = OrderStatus.DELIVERED;
		
		OrderStatus os2 = OrderStatus.valueOf("DELIVERED");
		
		System.out.println(os1);
		System.out.println(os2);
		
		//Composição - associação que permite que um objeto obtenha outra
		// relação tem-um ou tem-varios
		// reuso, flexibilidade, organização e coesão
		
		
	}

}
