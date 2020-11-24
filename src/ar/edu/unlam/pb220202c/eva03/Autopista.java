package ar.edu.unlam.pb220202c.eva03;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

/**
 * Si es necesario Utilice herencia o implemente de Interfaces
 * Se debe crear contructeres getters y Setters y los atributos o metodos que crean convenientes
 *
 */
public class Autopista {

	private HashMap <Integer,Vehiculo> telepase;
	private HashSet <Vehiculo> vehiculosEnCirculacion;
	
	public Autopista() {
		telepase = new HashMap<Integer, Vehiculo>();
		vehiculosEnCirculacion = new HashSet<Vehiculo>();
	}
	
	public Boolean registrarTelepase (Integer numeroTelpase, Vehiculo vehiculo) {
		
		if(numeroTelpase == null || vehiculo == null) {
			return false;
		}
		
		telepase.put(numeroTelpase, vehiculo);
		
		return true;
	}
	
	/**
	 * si el telepase no esta registrado lanza una Exceptios del tipo VehiculoNotFounException
	 * y no permite ingresar al autopista	
	 * 
	 * @param numeroTelepase
	 * @return
	 */
	public Boolean ingresarAutopista (Integer numeroTelepase) {
		
		if (!telepase.containsKey(numeroTelepase)) {
			throw new VehiculoNotFounException("No puede ingresar a la autopista");
		}
		
		vehiculosEnCirculacion.add(telepase.get(numeroTelepase));
		return true;
	}
	
	/**
	 * lanza Una exception VehiculoNotFounException si no esta en circulacion
	 * @param vehiculo
	 */
	public void salirAutpista (Vehiculo vehiculo) {
		
		if(!vehiculosEnCirculacion.contains(vehiculo)) {
			throw new VehiculoNotFounException("El vehiculo no se encuentra en circulacion");
		}
		
		vehiculosEnCirculacion.remove(vehiculo);
		
	}
	
	public TreeSet<Vehiculo> obtenerVehiculosConExcesosDeVelocidadOrdenadosPorPatente(){
		
		Set<Vehiculo> vehiculosEnInfraccion = vehiculosEnCirculacion.stream()
			.filter(vehiculos -> vehiculos.enInfraccion())
			.collect(Collectors.toSet());
	
		return new TreeSet<Vehiculo>(vehiculosEnInfraccion);
    }
	

	public Integer cantidadDeVehiculosENCirculacion() {
	
		return vehiculosEnCirculacion.size();
	}
	
	public Set<Vehiculo> getVehiculosEnCirculacion() {
		return vehiculosEnCirculacion;
	}
}
