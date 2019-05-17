package com.example.demo;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.model.AtencionUrgencia;
import com.example.demo.model.InventarioMedicamento;
import com.example.demo.model.Medicamento;
import com.example.demo.model.Paciente;
import com.example.demo.model.Suministro;
import com.example.demo.repository.MedicamentosRepository;
import com.example.demo.repository.UniEnfermeria;
import com.example.demo.repository.UniPacientesRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RepositoryTest {
	
	@Autowired
	private MedicamentosRepository medicamentosImpl;
	
	@Autowired
	private UniPacientesRepository uniPacientesImpl;
	
	@Autowired
	private UniEnfermeria uniEnfermeriaImpl;
	
	
	@Before
	public void inicializar() {
		iniciarMedicamentos();
		iniciarPacientes();
	}
	
	public void iniciarMedicamentos() {
		
		Medicamento medicamento= new Medicamento(123, "Loratadina", "GQ", "Angel", "Inyectada", "Diaria");
		Calendar calendar = Calendar.getInstance();
		InventarioMedicamento lote1= new InventarioMedicamento(6, "Juanchito", new Date(calendar.getTimeInMillis()+1000000), medicamento);
		InventarioMedicamento lote2= new InventarioMedicamento(8, "Juanchito", new Date(calendar.getTimeInMillis()+1000000), medicamento);
		InventarioMedicamento lote3= new InventarioMedicamento(10, "Juanchito", new Date(calendar.getTimeInMillis()+1000000), medicamento);
		List<InventarioMedicamento> inventarios= new ArrayList<>();
		inventarios.add(lote1);
		inventarios.add(lote2);
		inventarios.add(lote3);
		medicamento.setInventarios(inventarios);
		medicamentosImpl.crearMedicamento(medicamento);
		
	}
	
	public void iniciarPacientes() {
		Paciente paciente1= new Paciente("1107", "Maria Paula", "Vargas", true, "672");
		Paciente paciente2= new Paciente("1106", "Maria ", "colorado", true, "672");
		Paciente paciente3= new Paciente("1105", "Samuel", "abonia", true, "672");
		uniPacientesImpl.crearPaciente(paciente1);
		uniPacientesImpl.crearPaciente(paciente2);
		uniPacientesImpl.crearPaciente(paciente3);
	}
	
	
	
	
	
	
	//PRUEBAS REPOSITORIO DEL MEDICAMENTO
	
	@Test
	public void testVerficarDisponibilidadMedicamento() {
		int consecutivo=1;
		Medicamento existe= medicamentosImpl.verificarDisponibilidadMedicamneto(consecutivo, 12);
		assertNotNull(existe);
	}
	
	
	
	@Test
	public void testAgregarMedicamento() {
		Medicamento medicamento= new Medicamento(medicamentosImpl.asignarConsecutivoMedicamento(), "Loratadina", "AAAAA", "Angel", "oral", "cada 24 horas");
		assertTrue(medicamentosImpl.crearMedicamento(medicamento));
	}
	
	
	@Test
	public void testAgregarEntregaMedicamento() {
		
		Paciente paciente= uniPacientesImpl.verificarExistenciaPaciente("123");
		Date fecha = Calendar.getInstance().getTime();
		int consecutivo=uniEnfermeriaImpl.asignarConsecutivoAtencion();
		AtencionUrgencia atencion= new AtencionUrgencia(consecutivo,fecha,"Urgente","Inyección","No","Nada",paciente); 
		Suministro suministro= new Suministro(medicamentosImpl.asignarConsecutivoSuministro(), 4, fecha, "acne", "Lavar con jabón");
		boolean entrego=medicamentosImpl.agregarEntregaMedicamento(atencion, suministro,123);
		assertTrue(entrego);
		
		
	}
	
	
	
	
	//PRUEBAS REPOSITORIO DE ENFEMERIA
	
	@Test
	public void testAgregarAtencionUrgencia() {
		Paciente paciente= uniPacientesImpl.verificarExistenciaPaciente("123");
		Date fecha = Calendar.getInstance().getTime();
		AtencionUrgencia atencion=  new AtencionUrgencia(uniEnfermeriaImpl.asignarConsecutivoAtencion(), fecha, "aaaa", "Inyeccion", "No", "Hi", paciente);
		Boolean agrego= uniEnfermeriaImpl.agregarAtencionUrgencia(atencion);
		assertTrue(agrego);
 	}
	
	
	//PRUEBAS REPOSITORIO DE PACIENTES
	

	@Test
	public void testCrearPaciente() {
		Paciente paciente= new Paciente("1234", "Maria Paula", "Vargas", true, "1234");
		assertTrue(uniPacientesImpl.crearPaciente(paciente));
		
	}
	
	
	@Test
	public void testVerificarExistenciaPaciente() {
		Paciente paciente= uniPacientesImpl.verificarExistenciaPaciente("12324");
		assertNotNull(paciente);
		
	}
	
	
	
	
	
}
