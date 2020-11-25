package ar.edu.unlam.pb220202c.eva03;

/**
 * Si es necesario Utilice herencia o implemente de Interfaces
 * Se debe crear contructeres getters y Setters y los que crean conveniente
 * el Limite de velociadad para autos es de 80km
 * en caso que supere dicho limite el este sera multado
 *
 */
public class Camion extends Vehiculo implements Imultable{
	
	public static final Integer LIMITE = 80;	
	
	private Integer cantidadDeEjes;

	public Camion(String patente, Integer cantidadDeEjes) {
		super(patente, LIMITE);
		this.cantidadDeEjes = cantidadDeEjes;
	}
	
	public Integer getCantidadDeEjes() {
		return cantidadDeEjes;
	}

	public void setCantidadDeEjes(Integer cantidadDeEjes) {
		this.cantidadDeEjes = cantidadDeEjes;
	}

}
