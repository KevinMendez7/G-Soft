package com.scm.gsoft.dao.inv;

import java.util.List;

import com.scm.gsoft.domain.inv.Posicion;

public interface PosicionDao {

	List<Posicion> getPosicionList();

	Posicion getPosicionById(Long idPosicion);

	Posicion getPosicionByName(String namePosicion);

	void updatePosicion(Posicion posicion);

	void createPosicion(Posicion posicion);

	void removePosicion(Long idPosicion);

}
