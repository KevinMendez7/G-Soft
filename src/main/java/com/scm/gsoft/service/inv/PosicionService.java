package com.scm.gsoft.service.inv;

import java.util.List;

import com.scm.gsoft.domain.inv.Posicion;

public interface PosicionService {

	List<Posicion> getPosicionList();

	Posicion getPosicionById(Long idPosicion);

	Posicion getPosicionByName(String namePosicion);

	void updatePosicion(Posicion posicion);

	void createPosicion(Posicion posicion);

	void removePosicion(Long idPosicion);

}
