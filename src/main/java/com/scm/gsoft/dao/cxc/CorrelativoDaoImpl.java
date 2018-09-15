package com.scm.gsoft.dao.cxc;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.scm.gsoft.domain.cxc.Correlativo;

@Repository
@Transactional
public class CorrelativoDaoImpl extends AbstractSession implements CorrelativoDao {

	@Override
	public List<Correlativo> getCorrelativoList(){
		return (List<Correlativo>) getCxcSession().createQuery("from Correlativo").list();
	}

	@Override
	public Correlativo getCorrelativoById(Long idCorrelativo) {
		// TODO Auto-generated method stub
		return getCxcSession().get(Correlativo.class, idCorrelativo);
	}

	@Override
	public Correlativo getCorrelativoByName(String nameCorrelativo) {
		// TODO Auto-generated method stub
		return (Correlativo) getCxcSession().createQuery("from Correlativo where nombre = :nameCorrelativo")
				.setParameter("nameCorrelativo", nameCorrelativo).uniqueResult();
	}

	@Override
	public void updateCorrelativo(Correlativo correlativo) {
		getCxcSession().update(correlativo);

	}

	@Override
	public void createCorrelativo(Correlativo correlativo) {

		getCxcSession().persist(correlativo);

	}

	@Override
	public void removeCorrelativo(Long idCorrelativo) {

		Correlativo correlativo = getCorrelativoById(idCorrelativo);
		if(correlativo != null) {
			getCxcSession().delete(correlativo);
		}

	}

}
