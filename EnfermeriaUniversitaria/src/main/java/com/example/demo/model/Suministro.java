package com.example.demo.model;

import java.util.Date;

import org.springframework.lang.NonNull;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class Suministro {
	
	@NonNull
	private int consecutivo;
	@NonNull
	private int cantidad;
	@NonNull
	private Date fechaHora;
	@NonNull
	private String patologia;
	@NonNull
	private String observacion;
	
	
	
	
	//referencia al paciente
	
	private Paciente paciente;
	
	
	//referencia a medicamento
	
	private Medicamento medicamento;
	
	
} 
