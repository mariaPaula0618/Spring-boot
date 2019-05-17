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
public class InventarioMedicamento {

	@NonNull
	private int cantidadDisponible;
	@NonNull
	private String ubicacion;
	@NonNull
	private Date fechaExpiracion;
	
	
	//Referencia con medicamento
	@NonNull
	private Medicamento medicamento;
}
