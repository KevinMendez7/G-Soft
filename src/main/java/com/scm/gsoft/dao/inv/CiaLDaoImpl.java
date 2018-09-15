package com.scm.gsoft.dao.inv;
// Generated 26/08/2018 02:38:20 AM by Hibernate Tools 4.3.1

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.scm.gsoft.domain.inv.CiaL;

@Repository
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
