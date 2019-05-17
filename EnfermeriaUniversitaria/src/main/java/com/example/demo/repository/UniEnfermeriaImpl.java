package com.example.demo.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.example.demo.model.AtencionUrgencia;
import com.example.demo.model.Medicamento;
import com.example.demo.model.Paciente;

@Repository
public class UniEnfermeriaImpl implements UniEnfermeria{
	
	private Map<Integer, AtencionUrgencia> atenciones;
	
	
	private int consecutivo;
	
	
	public UniEnfermeriaImpl() {
	atenciones= new HashMap<Integer, AtencionUrgencia>();
	}
	
	@Override
	public boolean agregarAtencionUrgencia(AtencionUrgencia atencion) {
		if(!atenciones.containsKey(atencion.getConsecutivo())) {
			atenciones.put(atencion.getConsecutivo(), atencion);
			return true;
		}
		return false;
	}

	@Override
	public int asignarConsecutivoAtencion() {
		
		if(consecutivo==0) {
			consecutivo=1;
		}else {
			
			consecutivo=consecutivo++;
		}
		return consecutivo;
	}
	

}
