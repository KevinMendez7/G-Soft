package com.scm.gsoft.service.cxc;

import java.util.List;

import com.scm.gsoft.domain.cxc.Cotiza;

public interface CotizaService {

	List<Cotiza> getCotizaList();

	Cotiza getCotizaById(Long idCotiza);

	Cotiza getCotizaByName(String nameCotiza);

	void updateCotiza(Cotiza cotiza);

	void createCotiza(Cotiza cotiza);

	void removeCotiza(Long idCotiza);

}
