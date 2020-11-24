package ar.edu.unlam.pb220202c.eva03;

public class VehiculoNotFounException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public VehiculoNotFounException(String msj) {
		super(msj);
	}
}
