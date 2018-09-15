package com.scm.gsoft.dao.cxc;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.scm.gsoft.domain.cxc.CiaL;

@Qualifier("CiaLDaoCxc")
@Repository("CiaLRepositoryCxc")
@Transactional
public class CiaLDaoImpl extends AbstractSession implements CiaLDao {

	@Override
	public List<CiaL> getCiaLList(){
		return (List<CiaL>) getCxcSession().createQuery("from CiaL").list();
	}

	@Override
	public CiaL getCiaLById(Long idCiaL) {
		// TODO Auto-generated method stub
		return getCxcSession().get(CiaL.class, idCiaL);
	}

	@Override
	public CiaL getCiaLByName(String nameCiaL) {
		// TODO Auto-generated method stub
		return (CiaL) getCxcSession().createQuery("from CiaL where nombre = :nameCiaL")
				.setParameter("nameCiaL", nameCiaL).uniqueResult();
	}

	@Override
	public void updateCiaL(CiaL ciaL) {
		getCxcSession().update(ciaL);

	}

	@Override
	public void createCiaL(CiaL ciaL) {

		getCxcSession().persist(ciaL);

	}

	@Override
	public void removeCiaL(Long idCiaL) {

		CiaL ciaL = getCiaLById(idCiaL);
		if(ciaL != null) {
			getCxcSession().delete(ciaL);
		}

	}

}
