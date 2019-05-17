package com.example.demo.repository;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.example.demo.model.Paciente;

@Repository
public class UniPacientesImpl implements UniPacientesRepository{
	
	private Map<String, Paciente> pacientes;

	@Override
	public boolean crearPaciente(Paciente paciente) {
		if(!pacientes.containsKey(paciente.getDocumento())) {
			pacientes.put(paciente.getDocumento(), paciente);
		}
		return false;
	}

	@Override
	public Paciente verificarExistenciaPaciente(String id) {
		if(pacientes.containsKey(id)) {
			return pacientes.get(id);
		}
		return null;
	}

}
