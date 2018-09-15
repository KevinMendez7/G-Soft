package com.scm.gsoft.dao.cxc;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.scm.gsoft.domain.cxc.CabezaP;

@Repository
@Transactional
public class CabezaPDaoImpl extends AbstractSession implements CabezaPDao {

	@Override
	public List<CabezaP> getCabezaPList(){
		return (List<CabezaP>) getCxcSession().createQuery("from CabezaP").list();
	}

	@Override
	public CabezaP getCabezaPById(Long idCabezaP) {
		// TODO Auto-generated method stub
		return getCxcSession().get(CabezaP.class, idCabezaP);
	}

	@Override
	public CabezaP getCabezaPByName(String nameCabezaP) {
		// TODO Auto-generated method stub
		return (CabezaP) getCxcSession().createQuery("from CabezaP where nombre = :nameCabezaP")
				.setParameter("nameCabezaP", nameCabezaP).uniqueResult();
	}

	@Override
	public void updateCabezaP(CabezaP cabezaP) {
		getCxcSession().update(cabezaP);

	}

	@Override
	public void createCabezaP(CabezaP cabezaP) {

		getCxcSession().persist(cabezaP);

	}

	@Override
	public void removeCabezaP(Long idCabezaP) {

		CabezaP cabezaP = getCabezaPById(idCabezaP);
		if(cabezaP != null) {
			getCxcSession().delete(cabezaP);
		}

	}

}
