package com.example.demo.service;

import com.example.demo.model.AtencionUrgencia;
import com.example.demo.model.Medicamento;
import com.example.demo.model.Paciente;

public interface AtencionEnfermeriaUniversitaria {
	
	public boolean agregarSuministrosEnf(AtencionUrgencia atencion, Medicamento medicamneto, int cantidad);
	
	public boolean agregarAtencionUrgenciaEnf(Paciente paciente);

}
