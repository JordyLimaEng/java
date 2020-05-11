package model.exceptions;

//exceção personalizada
public class DomainException extends Exception{//compilador nao obriga a corrigir a RuntimeException
	private static final long serialVersionUID = 1L;
	
	public DomainException(String msg) {
		super(msg);
	}
}
