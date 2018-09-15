package com.scm.gsoft.service.cxc;

import java.util.List;

import com.scm.gsoft.domain.cxc.CotizaH;

public interface CotizaHService {

	List<CotizaH> getCotizaHList();

	CotizaH getCotizaHById(Long idCotizaH);

	CotizaH getCotizaHByName(String nameCotizaH);

	void updateCotizaH(CotizaH cotizaH);

	void createCotizaH(CotizaH cotizaH);

	void removeCotizaH(Long idCotizaH);

}
