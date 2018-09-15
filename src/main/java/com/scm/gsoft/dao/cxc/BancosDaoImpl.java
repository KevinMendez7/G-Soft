package com.scm.gsoft.dao.cxc;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.scm.gsoft.domain.cxc.Bancos;

@Repository
@Transactional
public class BancosDaoImpl extends AbstractSession implements BancosDao {
	
	@Override
	public List<Bancos> getBancosList(){
		return (List<Bancos>) getCxcSession().createQuery("from Bancos").list();
	}

	@Override
	public Bancos getBancosById(Long idBanco) {
		// TODO Auto-generated method stub
		return getCxcSession().get(Bancos.class, idBanco);
	}

	@Override
	public Bancos getBancosByName(String nameBanco) {
		// TODO Auto-generated method stub
		return (Bancos) getCxcSession().createQuery("from Bancos where nombre = :nameBanco")
				.setParameter("nameBanco", nameBanco).uniqueResult();
	}

	@Override
	public void updateBancos(Bancos bancos) {
		getCxcSession().update(bancos);
		
	}

	@Override
	public void createBancos(Bancos bancos) {
		
		getCxcSession().persist(bancos);
		
	}

	@Override
	public void removeBancos(Long idBancos) {
		
		Bancos bancos = getBancosById(idBancos);
		if(bancos != null) {
			getCxcSession().delete(bancos);
		}
				
	}

}
