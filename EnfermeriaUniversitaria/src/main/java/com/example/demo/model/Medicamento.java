package com.example.demo.model;

import java.util.List;

import org.springframework.lang.NonNull;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class Medicamento {
	
	@NonNull
	private int consecutivo;
	@NonNull
	private String nombre;
	@NonNull
	private String nombreGenerico;
	@NonNull
	private String laboratorio;
	@NonNull
	private String tipoAdiminstracion;
	@NonNull
	private String indicaciones;

	private String contraIndicaciones;
	
	//Referencia a suministro
	
	private List<Suministro> suministros;

	//Referenca a conPciente
	
	private List<InventarioMedicamento> inventarios;
}
