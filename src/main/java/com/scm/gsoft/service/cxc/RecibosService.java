package com.scm.gsoft.service.cxc;

import java.util.List;

import com.scm.gsoft.domain.cxc.Recibos;

public interface RecibosService {

	List<Recibos> getRecibosList();

	Recibos getRecibosById(Long idRecibos);

	Recibos getRecibosByName(String nameRecibos);

	void updateRecibos(Recibos recibos);

	void createRecibos(Recibos recibos);

	void removeRecibos(Long idRecibos);

}
