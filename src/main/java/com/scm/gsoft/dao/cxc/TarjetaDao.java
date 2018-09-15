package com.scm.gsoft.dao.cxc;

import java.util.List;

import com.scm.gsoft.domain.cxc.Tarjeta;

public interface TarjetaDao {

	List<Tarjeta> getTarjetaList();

	Tarjeta getTarjetaById(Long idTarjeta);

	Tarjeta getTarjetaByName(String nameTarjeta);

	void updateTarjeta(Tarjeta tarjeta);

	void createTarjeta(Tarjeta tarjeta);

	void removeTarjeta(Long idTarjeta);

}
