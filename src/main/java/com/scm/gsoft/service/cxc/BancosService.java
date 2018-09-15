package com.scm.gsoft.service.cxc;

import java.util.List;

import com.scm.gsoft.domain.cxc.Bancos;

public interface BancosService {

	List<Bancos> getBancosList();

	Bancos getBancosById(Long idBancos);

	Bancos getBancosByName(String nameBancos);

	void updateBancos(Bancos bancos);

	void createBancos(Bancos bancos);

	void removeBancos(Long idBancos);

}
