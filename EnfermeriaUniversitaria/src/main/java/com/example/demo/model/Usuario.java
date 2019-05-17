package com.example.demo.model;

import org.springframework.lang.NonNull;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class Usuario {
	@NonNull
	private String login;
	@NonNull
	private String nombre;
	@NonNull
	private String apellido;
	@NonNull
	private char[] contraseña;
	@NonNull
	private boolean estado;
	
	
	//REFERENCIA A PACIENTE
	
	@NonNull
	private Paciente paciente;
}
