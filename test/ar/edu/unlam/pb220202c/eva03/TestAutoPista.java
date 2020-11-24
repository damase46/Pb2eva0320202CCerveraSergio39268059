package ar.edu.unlam.pb220202c.eva03;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class TestAutoPista {
	
	private Autopista autopista;
	
	@Before
	public void setup() {
		autopista = new Autopista();
	}
	
	@Test
	public void queSePuedaRegistrarTelepase () {
		
		Vehiculo v1 = new Automovil("ABC-134");
		Vehiculo v2 = new Camion("ABC-124", 2);
		
		Assert.assertTrue(autopista.registrarTelepase(1233, v1));
		Assert.assertTrue(autopista.registrarTelepase(1232, v2));
		
		Assert.assertFalse(autopista.registrarTelepase(null, v1));
		Assert.assertFalse(autopista.registrarTelepase(1234, null));
	}

	@Test(expected = VehiculoNotFounException.class)
	public void queAlSalirDelAutopistaNoestaEncirculacionLanceUnaExcepcion() {
		autopista.salirAutpista(new Automovil("rwe-532"));
	}
	
	@Test
	public void queVerifiqueQueSeObtengaUnaListaDeAutosInsfractoresOrdenadaPorPatente(){

		Vehiculo v1 = new Automovil("ABC-134");
		Vehiculo v2 = new Camion("ZBC-124", 2);
		Vehiculo v3 = new Automovil("HBC-134");
		Vehiculo v4 = new Camion("IBC-124", 2);
		
		autopista.registrarTelepase(1233, v1);
		autopista.registrarTelepase(1234, v2);
		autopista.registrarTelepase(1235, v3);
		autopista.registrarTelepase(1236, v4);
		
		autopista.ingresarAutopista(1233);
		autopista.ingresarAutopista(1234);
		autopista.ingresarAutopista(1235);
		autopista.ingresarAutopista(1236);
		
		v1.incrmentarVelocidad(150);
		v2.incrmentarVelocidad(180);
		v3.incrmentarVelocidad(200);
		v4.incrmentarVelocidad(60);
		
		
		TreeSet<Vehiculo> result = autopista.obtenerVehiculosConExcesosDeVelocidadOrdenadosPorPatente();
		
		Iterator<Vehiculo> iterator = result.iterator();
		Assert.assertEquals(v1.getPatente(), iterator.next().getPatente());
		Assert.assertEquals(v3.getPatente(), iterator.next().getPatente());
		Assert.assertEquals(v2.getPatente(), iterator.next().getPatente());
		
	}

	@Test
	public void queAlIngresarAlaAutopista() {
		Vehiculo v1 = new Automovil("ABC-134");
		autopista.registrarTelepase(1233, v1);
		
		autopista.ingresarAutopista(1233);
		
		Set<Vehiculo> enCirculacion = autopista.getVehiculosEnCirculacion();
		Assert.assertEquals(v1.getPatente(), enCirculacion.iterator().next().getPatente());
	}
	
	@Test
	public void queVerifiqueLaCantidadDeVehiculosEnCirculacion() {
		
		Assert.assertEquals(Integer.valueOf(0), autopista.cantidadDeVehiculosENCirculacion());
		
		Vehiculo v1 = new Automovil("ABC-134");
		Vehiculo v2 = new Camion("ABC-124", 2);
		
		autopista.registrarTelepase(1233, v1);
		autopista.registrarTelepase(1234, v2);
		
		autopista.ingresarAutopista(1233);
		autopista.ingresarAutopista(1234);
		
		Integer result = autopista.cantidadDeVehiculosENCirculacion();
		Assert.assertEquals(Integer.valueOf(2), result);
	}
	
}
