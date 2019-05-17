package com.example.demo.repository;

import com.example.demo.model.Paciente;

public interface UniPacientesRepository {
	
	
	public boolean crearPaciente(Paciente paciente);
	public Paciente verificarExistenciaPaciente(String id);
	 

}
