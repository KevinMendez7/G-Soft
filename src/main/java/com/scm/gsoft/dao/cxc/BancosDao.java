package com.scm.gsoft.dao.cxc;

import java.util.List;

import com.scm.gsoft.domain.cxc.Bancos;

public interface BancosDao {
	
	List<Bancos> getBancosList();
	
	Bancos getBancosById(Long idBanco);
	
	Bancos getBancosByName(String nameBanco);
	
	void updateBancos(Bancos bancos);
	
	void createBancos(Bancos bancos);
	
	void removeBancos(Long idBancos);

}
