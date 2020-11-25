package ar.edu.unlam.pb220202c.eva03;

/**
 * Se debe crear contructeres getters y Setters y loos que crean convenientes
 *
 */
public class Vehiculo implements Comparable<Vehiculo>, Imultable{

	private String patente;
	private Integer velocidadActual;
	private Integer limiteVelocidad;
	
	public Vehiculo(String patente, Integer limiteVelocidad) {
		velocidadActual = 0;
		this.patente = patente;
		this.limiteVelocidad = limiteVelocidad;
	}


	public void incrmentarVelocidad(Integer velocidad) {
		velocidadActual += velocidad;
		
	}


	public String getPatente() {
		return patente;
	}


	public void setPatente(String patente) {
		this.patente = patente;
	}


	public Integer getVelocidadActual() {
		return velocidadActual;
	}


	public void setVelocidadActual(Integer velocidadActual) {
		this.velocidadActual = velocidadActual;
	}


	public Integer getLimiteVelocidad() {
		return limiteVelocidad;
	}


	public void setLimiteVelocidad(Integer limiteVelocidad) {
		this.limiteVelocidad = limiteVelocidad;
	}

	@Override
	public Boolean enInfraccion() {
		return velocidadActual > limiteVelocidad;
	}	

	@Override
	public int compareTo(Vehiculo vehiculo) {
		return this.patente.compareTo(vehiculo.patente);
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((patente == null) ? 0 : patente.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Vehiculo other = (Vehiculo) obj;
		if (patente == null) {
			if (other.patente != null)
				return false;
		} else if (!patente.equals(other.patente))
			return false;
		return true;
	}

}
