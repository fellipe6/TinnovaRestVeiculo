package br.com.fellipe.tinnova.entities.exception;

public class VeiculoNotFoundException extends RuntimeException{


	private static final long serialVersionUID = 1L;
		
	public VeiculoNotFoundException(String msg) {
	super(msg);
	}

	
}
