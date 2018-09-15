package com.scm.gsoft.dao.cxc;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.scm.gsoft.domain.cxc.Borra;

@Qualifier("BorraDaoCxc")
@Repository("BorraRepositoryCxc")
@Transactional
public class BorraDaoImpl extends AbstractSession implements BorraDao {

	@Override
	public List<Borra> getBorraList(){
		return (List<Borra>) getCxcSession().createQuery("from Borra").list();
	}

	@Override
	public Borra getBorraById(Long idBorra) {
		// TODO Auto-generated method stub
		return getCxcSession().get(Borra.class, idBorra);
	}

	@Override
	public Borra getBorraByCodeBodega(String codeBodega) {
		// TODO Auto-generated method stub
		return (Borra) getCxcSession().createQuery("from Borra where nombre = :codeBodega")
				.setParameter("codeBodega", codeBodega).uniqueResult();
	}

	@Override
	public void updateBorra(Borra borra) {
		getCxcSession().update(borra);

	}

	@Override
	public void createBorra(Borra borra) {

		getCxcSession().persist(borra);

	}

	@Override
	public void removeBorra(Long idBorra) {

		Borra borra = getBorraById(idBorra);
		if(borra != null) {
			getCxcSession().delete(borra);
		}

	}

}
