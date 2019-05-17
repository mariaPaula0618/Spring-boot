package com.example.demo.model;

import java.util.List;

import org.springframework.lang.NonNull;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class Paciente {
	
	@NonNull
	private String documento;
	@NonNull
	private String nombre;
	@NonNull
	private String apellido;
	@NonNull
	private boolean estado;
	
	private String programaAcademico;
	private String dependenciaAcademica;
	
	
	private List<Suministro> suministros;
	private List<AtencionUrgencia> atenciones;
	
	@NonNull
	private String usuario;

}
