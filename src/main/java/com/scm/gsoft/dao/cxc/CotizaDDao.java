package com.scm.gsoft.dao.cxc;

import java.util.List;

import com.scm.gsoft.domain.cxc.CotizaD;

public interface CotizaDDao {

	List<CotizaD> getCotizaDList();

	CotizaD getCotizaDById(Long idCotizaD);

	CotizaD getCotizaDByName(String nameCotizaD);

	void updateCotizaD(CotizaD cotizaD);

	void createCotizaD(CotizaD cotizaD);

	void removeCotizaD(Long idCotizaD);

}
