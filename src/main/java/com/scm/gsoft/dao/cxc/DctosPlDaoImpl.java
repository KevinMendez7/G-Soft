package com.scm.gsoft.dao.cxc;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.scm.gsoft.domain.cxc.DctosPl;

@Repository
@Transactional
public class DctosPlDaoImpl extends AbstractSession implements DctosPlDao {

	@Override
	public List<DctosPl> getDctosPlList(){
		return (List<DctosPl>) getCxcSession().createQuery("from DctosPl").list();
	}

	@Override
	public DctosPl getDctosPlById(Long idDctosPl) {
		// TODO Auto-generated method stub
		return getCxcSession().get(DctosPl.class, idDctosPl);
	}

	@Override
	public DctosPl getDctosPlByName(String nameDctosPl) {
		// TODO Auto-generated method stub
		return (DctosPl) getCxcSession().createQuery("from DctosPl where nombre = :nameDctosPl")
				.setParameter("nameDctosPl", nameDctosPl).uniqueResult();
	}

	@Override
	public void updateDctosPl(DctosPl dctosPl) {
		getCxcSession().update(dctosPl);

	}

	@Override
	public void createDctosPl(DctosPl dctosPl) {

		getCxcSession().persist(dctosPl);

	}

	@Override
	public void removeDctosPl(Long idDctosPl) {

		DctosPl dctosPl = getDctosPlById(idDctosPl);
		if(dctosPl != null) {
			getCxcSession().delete(dctosPl);
		}

	}

}
