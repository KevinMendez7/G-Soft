package com.scm.gsoft.service.cxc;

import java.util.List;

import com.scm.gsoft.domain.cxc.Ventas;

public interface VentasService {

	List<Ventas> getVentasList();

	Ventas getVentasById(Long idVentas);

	Ventas getVentasByName(String nameVentas);

	void updateVentas(Ventas ventas);

	void createVentas(Ventas ventas);

	void removeVentas(Long idVentas);

}
