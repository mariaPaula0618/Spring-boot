package com.example.demo.repository;

import java.util.List;

import com.example.demo.model.AtencionUrgencia;
import com.example.demo.model.Medicamento;
import com.example.demo.model.Paciente;

public interface UniEnfermeria {
	
	
	public boolean agregarAtencionUrgencia(AtencionUrgencia atencion); 
	public int asignarConsecutivoAtencion();


}
