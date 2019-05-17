package com.example.demo.repository;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.example.demo.model.AtencionUrgencia;
import com.example.demo.model.InventarioMedicamento;
import com.example.demo.model.Medicamento;
import com.example.demo.model.Suministro;

@Repository
public class MedicamentosImpl implements MedicamentosRepository{


	private Map<Integer, Medicamento> medicamentos;
	private Map<Integer, Suministro> suministros;

	private int consecutivoMedicamento;
	private int consecutivoSuministro;

	public MedicamentosImpl() {
		medicamentos= new HashMap<>();
		suministros= new HashMap<>();
		consecutivoMedicamento=0;
		consecutivoSuministro=0;


	}

	@Override
	public boolean crearMedicamento(Medicamento medicamento) {
		// TODO Auto-generated method stub
		if(!medicamentos.containsKey(medicamento.getConsecutivo())) {
			medicamentos.put(medicamento.getConsecutivo(), medicamento);
			return true;
		}
		return false;
	}

	@Override
	public Medicamento verificarExistenciaMedicamento(int consecutivo) {
		// TODO Auto-generated method stub
		if(medicamentos.containsKey(consecutivo)) {
			return medicamentos.get(consecutivo);
		}else {

			return null;
		}
	}

	@Override
	public Medicamento verificarDisponibilidadMedicamneto(int consecutivo, int cantidad) {
		// TODO Auto-generated method stub
		Medicamento medicamento= verificarExistenciaMedicamento(consecutivo);
		List<InventarioMedicamento> inventarios= medicamento.getInventarios();
		int cantidadAcumulada=0;
		for (int i = 0; i < inventarios.size();i++) {
			InventarioMedicamento inventario=inventarios.get(i);
			Date fecha = Calendar.getInstance().getTime();
			if(inventario.getFechaExpiracion().compareTo(fecha)>0) {
				cantidadAcumulada+= inventario.getCantidadDisponible();
				if(cantidadAcumulada>=cantidad) {
					return medicamento;
				}
				
			}
			
		}
		return null;
	}

	@Override
	public boolean agregarEntregaMedicamento(AtencionUrgencia atencion, Suministro suministro,int consecutivoMedicamento) {
		Medicamento medicamento= verificarDisponibilidadMedicamneto(consecutivoMedicamento, suministro.getCantidad());
		if(medicamento!=null) {
			suministro.setMedicamento(medicamento);
			List<Suministro> sum=atencion.getSuministros();
			sum.add(suministro);
			atencion.setSuministros(sum);
			suministros.put(suministro.getConsecutivo(), suministro);
			actualizarInventario(medicamento, suministro.getCantidad());
			
			return true;
		}else {
			return false;
		}
		
	
	}

	@Override
	public int asignarConsecutivoSuministro() {
		if(consecutivoSuministro==0) {
			consecutivoSuministro=1;
		}else {
			consecutivoSuministro++;
		}
		return consecutivoSuministro;
	}

	@Override
	public int asignarConsecutivoMedicamento() {
		if(consecutivoMedicamento==0) {
			consecutivoMedicamento=1;
		}else {
			consecutivoMedicamento++;
		}
		return consecutivoMedicamento;
	}

	@Override
	public void actualizarInventario(Medicamento medicamento, int cantidad) {
		// TODO Auto-generated method stub
		List<InventarioMedicamento> inventarios= medicamento.getInventarios();
		boolean actualizar=false;
		
		for (int i = 0; i < inventarios.size()&&!actualizar; i++) {
			InventarioMedicamento invt=inventarios.get(i);
			int cantidadDisponible=invt.getCantidadDisponible();
			int result=cantidadDisponible-cantidad;
			if(result<0) {
				invt.setCantidadDisponible(0);
			}else {
				invt.setCantidadDisponible(result);
				actualizar=true;
			}
			
		}

	}


}
