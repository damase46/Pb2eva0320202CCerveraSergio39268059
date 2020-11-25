package ar.edu.unlam.pb220202c.eva03;

/**
 *  *
 *Si es necesario Utilice herencia o implemente de Interfaces
 *Se debe crear contructeres getters y Setters y loos que crean convenientes
 *el Limite de velociadad para autos es de 130km
 *en caso que supere dicho limite el este sera multado
 */
public class Automovil extends Vehiculo  {
	
	private static final Integer LIMITE = 130;

	public Automovil(String patente) {
		super(patente, LIMITE);
	}
	
	
}
