package com.scm.gsoft.dao.cxc;

import java.util.List;

import com.scm.gsoft.domain.cxc.RazonNoVenta;

public interface RazonNoVentaDao {

	List<RazonNoVenta> getRazonNoVentaList();

	RazonNoVenta getRazonNoVentaById(Long idRazonNoVenta);

	RazonNoVenta getRazonNoVentaByName(String nameRazonNoVenta);

	void updateRazonNoVenta(RazonNoVenta razonNoVenta);

	void createRazonNoVenta(RazonNoVenta razonNoVenta);

	void removeRazonNoVenta(Long idRazonNoVenta);

}
