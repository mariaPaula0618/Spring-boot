package com.example.demo.model;

import java.util.Date;
import java.util.List;

import org.springframework.lang.NonNull;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
@Data 
@NoArgsConstructor
@RequiredArgsConstructor
public class AtencionUrgencia {
	
	@NonNull
	private int consecutivo;
	@NonNull
	private Date fechaHora;
	@NonNull
	private String descrionGeneral;
	@NonNull
	private String procedimientoRealizado;
	@NonNull
	private String remitido;
	@NonNull
	private String observaciones;
	
	private String lugarRemision;
	
	
	//Referencia con Suministro
	
	private List<Suministro> suministros;
	
	//Referencia con paciente
	@NonNull
	private Paciente paciente;
	
}
