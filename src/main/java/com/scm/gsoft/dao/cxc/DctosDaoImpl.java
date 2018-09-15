package com.scm.gsoft.dao.cxc;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.scm.gsoft.domain.cxc.Dctos;

@Repository
@Transactional
public class DctosDaoImpl extends AbstractSession implements DctosDao {

	@Override
	public List<Dctos> getDctosList(){
		return (List<Dctos>) getCxcSession().createQuery("from Dctos").list();
	}

	@Override
	public Dctos getDctosById(Long idDctos) {
		// TODO Auto-generated method stub
		return getCxcSession().get(Dctos.class, idDctos);
	}

	@Override
	public Dctos getDctosByName(String nameDctos) {
		// TODO Auto-generated method stub
		return (Dctos) getCxcSession().createQuery("from Dctos where nombre = :nameDctos")
				.setParameter("nameDctos", nameDctos).uniqueResult();
	}

	@Override
	public void updateDctos(Dctos dctos) {
		getCxcSession().update(dctos);

	}

	@Override
	public void createDctos(Dctos dctos) {

		getCxcSession().persist(dctos);

	}

	@Override
	public void removeDctos(Long idDctos) {

		Dctos dctos = getDctosById(idDctos);
		if(dctos != null) {
			getCxcSession().delete(dctos);
		}

	}

}
