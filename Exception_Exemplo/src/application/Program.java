package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reservation;
import model.exceptions.DomainException;

//utilizando exce��es personalizadas
//problema resolvido de forma muito ruim, ruim e boa.

public class Program {

	public static void main(String[] args) throws ParseException {
		Good();
	}
	
	public static void Good(){//nao precisa mais propragar a exce��o, aqu ela � tratada
		
		/*
		 * Solu��o Boa -- Utilizando tratamento de exce��es
		 */

		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		try {
			System.out.print("Room Number: ");
			int number = sc.nextInt();
			System.out.print("CheckIn date (dd/MM/yyyy): ");
			Date CheckIn = sdf.parse(sc.next());// esta fun��o pode gerar uma exce��o
												// o proprio compilador sugere tratar a exce��o
												// ou propagar ela (esta solu��o, ao colocar 'throws ParseException')
			System.out.print("CheckOut date (dd/MM/yyyy): ");
			Date CheckOut = sdf.parse(sc.next());
	
			Reservation reservation = new Reservation(number, CheckIn, CheckOut);
			System.out.println("Reservation: " + reservation);
	
			System.out.println();
	
			System.out.println("Enter date to update the reservation: ");
			System.out.print("CheckIn date (dd/MM/yyyy): ");
			CheckIn = sdf.parse(sc.next());
			System.out.print("CheckOut date (dd/MM/yyyy): ");
			CheckOut = sdf.parse(sc.next());
			
			reservation.updateDates(CheckIn, CheckOut);
			System.out.println("Reservation: " + reservation);
		}catch(ParseException e) {
			System.out.println("Invalid Date Form!!");			
		}catch(/*IllegalArgumentException*/DomainException e) {
			System.out.println("Error in reservation: " + e.getMessage());
		}catch(RuntimeException e) {//caso alguma exce��o q n tenha sido tratada utiliza esta
			System.out.println("Unexpected error!");
		}
		
		sc.close();		
	}

	public static void Bad() throws ParseException, DomainException {
		/*
		 * Solu��o RUIM -- l�gica delega as fun��es para as classes corretas mas com problemas
		 */

		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		System.out.print("Room Number: ");
		int number = sc.nextInt();
		System.out.print("CheckIn date (dd/MM/yyyy): ");
		Date CheckIn = sdf.parse(sc.next());// esta fun��o pode gerar uma exce��o
											// o proprio compilador sugere tratar a exce��o
											// ou propagar ela (esta solu��o, ao colocar 'throws ParseException')
		System.out.print("CheckOut date (dd/MM/yyyy): ");
		Date CheckOut = sdf.parse(sc.next());

		if (!CheckOut.after(CheckIn)) {
			System.out.println("Check out must be after check in!!!!");
		} else {
			Reservation reservation = new Reservation(number, CheckIn, CheckOut);
			System.out.println("Reservation: " + reservation);

			System.out.println();

			System.out.println("Enter date to update the reservation: ");
			System.out.print("CheckIn date (dd/MM/yyyy): ");
			CheckIn = sdf.parse(sc.next());
			System.out.print("CheckOut date (dd/MM/yyyy): ");
			CheckOut = sdf.parse(sc.next());
			
			/*String error = reservation.updateDates(CheckIn, CheckOut);
			if(error != null) {
				System.out.println("Error in reservation: "+error);
			}else {
				System.out.println("Reservation: " + reservation);				
			} descomentar se for usar a bad*/
		}

		sc.close();

	}

	public void VeryBad() throws ParseException, DomainException {

		/*
		 * Solu��o Muito RUIM -- problemas em delega��o a��es das classes
		 */

		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		System.out.print("Room Number: ");
		int number = sc.nextInt();
		System.out.print("CheckIn date (dd/MM/yyyy): ");
		Date CheckIn = sdf.parse(sc.next());// esta fun��o pode gerar uma exce��o
											// o proprio compilador sugere tratar a exce��o
											// ou propagar ela (esta solu��o, ao colocar 'throws ParseException')
		System.out.print("CheckOut date (dd/MM/yyyy): ");
		Date CheckOut = sdf.parse(sc.next());

		if (!CheckOut.after(CheckIn)) {
			System.out.println("Check out must be after check in!!!!");
		} else {
			Reservation reservation = new Reservation(number, CheckIn, CheckOut);
			System.out.println("Reservation: " + reservation);

			System.out.println();

			System.out.println("Enter date to update the reservation: ");
			System.out.print("CheckIn date (dd/MM/yyyy): ");
			CheckIn = sdf.parse(sc.next());
			System.out.print("CheckOut date (dd/MM/yyyy): ");
			CheckOut = sdf.parse(sc.next());

			Date now = new Date();
			if (CheckIn.before(now) || CheckOut.before(now)) {
				System.out.println("Error!!! Reservation dates must be future dates!!!");
			} else if (!CheckOut.after(CheckIn)) {
				System.out.println("Check out must be after check in!!!!");
			} else {
				//reservation.updateDates(CheckIn, CheckOut);
				System.out.println("Reservation: " + reservation);
			}
		}

		sc.close();

	}

}
