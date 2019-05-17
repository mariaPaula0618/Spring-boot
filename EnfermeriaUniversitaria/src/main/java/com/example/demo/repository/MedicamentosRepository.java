package com.example.demo.repository;

import javax.print.attribute.HashAttributeSet;

import com.example.demo.model.AtencionUrgencia;
import com.example.demo.model.Medicamento;
import com.example.demo.model.Suministro;


public interface MedicamentosRepository {
	
	
	public boolean crearMedicamento(Medicamento medicamento);
	public Medicamento verificarExistenciaMedicamento(int consecutivo);
	public Medicamento verificarDisponibilidadMedicamneto(int consecutivo, int cantidad);
	
	public boolean agregarEntregaMedicamento(AtencionUrgencia atencion, Suministro suministro, int consecutivoMedicamento);
	public int asignarConsecutivoSuministro();
	public int asignarConsecutivoMedicamento();
	public void actualizarInventario(Medicamento medicamento, int cantidad);
	
}
