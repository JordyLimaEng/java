package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import model.exceptions.DomainException;

public class Reservation {
	
	private Integer roomNumber;
	private Date CheckIn;
	private Date CheckOut;
	
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	public Reservation(Integer roomNumber, Date checkIn, Date checkOut) throws DomainException {
		if (!CheckOut.after(CheckIn)) {//sempre q possivel, melhor tratar desde o incio
			//throw new IllegalArgumentException("Check out must be after check in!!!!");
			throw new DomainException("Check out must be after check in!!!!");
		}
		this.roomNumber = roomNumber;
		this.CheckIn = checkIn;
		this.CheckOut = checkOut;
	}
	
	public Integer getRoomNumber() {
		return roomNumber;
	}
	
	public void setRoomNumber(Integer roomNumber) {
		this.roomNumber = roomNumber;
	}
	
	public Date getCheckIn() {
		return CheckIn;
	}
	
	public Date getCheckOut() {
		return CheckOut;
	}
	
	public long duration() {//calcula a dura��o em dias da estadia 
		long diff = CheckOut.getTime() - CheckIn.getTime();//faz a diferen�a de dias em ms 
		return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);//transforma ms em dias
	}
	
	public /*String*/void updateDates(Date CheckIn, Date CheckOut) throws DomainException {//propraga a exce��o pois quem deve tratar est� em program.java nao neste bloco
		
		/*
		//solu��o ruim
		Date now = new Date();
		if (CheckIn.before(now) || CheckOut.before(now)) {
			return "Error!!! Reservation dates must be future dates!!!";
		}
		if (!CheckOut.after(CheckIn)) {
			return "Check out must be after check in!!!!";
		}		
		//solu��o ruim		 
		*/
		
		//solu��o boa
		
		Date now = new Date();
		if (CheckIn.before(now) || CheckOut.before(now)) {
			//precisa jogar alguma exce��o, nesse caso diz como se os argumentos estivesse invalidos
			//throw new IllegalArgumentException("Error!!! Reservation dates must be future dates!!!");
			throw new DomainException("Error!!! Reservation dates must be future dates!!!"); //exce��o personalizada
		}
		if (!CheckOut.after(CheckIn)) {
			//throw new IllegalArgumentException("Check out must be after check in!!!!");
			throw new DomainException("Check out must be after check in!!!!");
		}		
		
		//solu��o boa
		
		this.CheckIn = CheckIn;
		this.CheckOut= CheckOut;
		
		//return null; //se retorna null, n�o deu erro algum = faz parte da solu��o ruim
	}
	
	@Override
	public String toString(){
		return "Room "
				+roomNumber
				+", checkIn: "
				+sdf.format(CheckIn)
				+", checkOut: "
				+sdf.format(CheckOut)
				+", "
				+duration()
				+" nights";
	}
	
	
}
