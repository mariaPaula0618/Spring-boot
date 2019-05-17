package com.example.demo.service;

import java.util.Calendar;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.AtencionUrgencia;
import com.example.demo.model.Medicamento;
import com.example.demo.model.Paciente;
import com.example.demo.repository.MedicamentosRepository;
import com.example.demo.repository.UniEnfermeria;
import com.example.demo.repository.UniPacientesRepository;

@Service
public class AtencionEnfermeriaUniversitariaImpl implements AtencionEnfermeriaUniversitaria{
	
	@Autowired
	private MedicamentosRepository  medicamentosImpl;
	
	@Autowired
	private UniPacientesRepository uniPacientesImpl;
	
	@Autowired
	private UniEnfermeria uniEnfermeriaImpl;
	
	
	
	@Override
	public boolean agregarSuministrosEnf(AtencionUrgencia atencion, Medicamento medicamneto, int cantidad) {
		boolean agrego=false;
		
		
		
		
		return agrego;
	
		
	}

	@Override
	public boolean agregarAtencionUrgenciaEnf(Paciente paciente) {
		Paciente pcte=uniPacientesImpl.verificarExistenciaPaciente(paciente.getDocumento());
		boolean agrego=false;
		if(pcte!=null) {
			Date fecha = Calendar.getInstance().getTime();
			AtencionUrgencia atencion = new AtencionUrgencia(uniEnfermeriaImpl.asignarConsecutivoAtencion(), fecha, "Registro Atencion", "", "", "", paciente);
			agrego=uniEnfermeriaImpl.agregarAtencionUrgencia(atencion);
		}
		return agrego;
		
	}

}
