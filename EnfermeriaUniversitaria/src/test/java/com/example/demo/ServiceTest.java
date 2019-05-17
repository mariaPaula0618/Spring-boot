package com.example.demo;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

import java.util.Calendar;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.model.AtencionUrgencia;
import com.example.demo.model.Paciente;
import com.example.demo.repository.MedicamentosRepository;
import com.example.demo.repository.UniEnfermeria;
import com.example.demo.repository.UniPacientesRepository;
import com.example.demo.service.AtencionEnfermeriaUniversitaria;
import com.example.demo.service.AtencionEnfermeriaUniversitariaImpl;

@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
public class ServiceTest {
	

	@Mock
	private MedicamentosRepository  medicamentosImpl;
	
	@Mock
	private UniPacientesRepository uniPacientesImpl;
	
	@Mock
	private UniEnfermeria uniEnfermeriaImpl;
	
	
	@InjectMocks
	private AtencionEnfermeriaUniversitariaImpl atencionEnfermeriaUniversitaria;
	
	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}
	
	
	@Test
	public void testRegistrarAtencionUrgencia() {
		
		Paciente paciente = new Paciente("1107","Maria","Vargas",true,"123");
		when(uniEnfermeriaImpl.asignarConsecutivoAtencion()).thenReturn(123);
		AtencionUrgencia atencion =  new AtencionUrgencia(uniEnfermeriaImpl.asignarConsecutivoAtencion(),Calendar.getInstance().getTime(),
				"Atencion Estudiante","Inyección","Si","Ninguna",paciente);
		when(uniEnfermeriaImpl.agregarAtencionUrgencia(atencion)).thenReturn(true);
		when(uniPacientesImpl.verificarExistenciaPaciente(paciente.getDocumento())).thenReturn(paciente);
		assertTrue(atencionEnfermeriaUniversitaria.agregarAtencionUrgenciaEnf(paciente));
	}
	
	
	@Test
	public void testAgregarEntregaMedicamento() {
		
	}
	
	
	
	
	
}
