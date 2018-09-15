package com.scm.gsoft.dao.cxc;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.scm.gsoft.domain.cxc.EntregaMerc;

@Repository
@Transactional
public class EntregaMercDaoImpl extends AbstractSession implements EntregaMercDao {

	@Override
	public List<EntregaMerc> getEntregaMercList(){
		return (List<EntregaMerc>) getCxcSession().createQuery("from EntregaMerc").list();
	}

	@Override
	public EntregaMerc getEntregaMercById(Long idEntregaMerc) {
		// TODO Auto-generated method stub
		return getCxcSession().get(EntregaMerc.class, idEntregaMerc);
	}

	@Override
	public EntregaMerc getEntregaMercByName(String nameEntregaMerc) {
		// TODO Auto-generated method stub
		return (EntregaMerc) getCxcSession().createQuery("from EntregaMerc where nombre = :nameEntregaMerc")
				.setParameter("nameEntregaMerc", nameEntregaMerc).uniqueResult();
	}

	@Override
	public void updateEntregaMerc(EntregaMerc entregaMerc) {
		getCxcSession().update(entregaMerc);

	}

	@Override
	public void createEntregaMerc(EntregaMerc entregaMerc) {

		getCxcSession().persist(entregaMerc);

	}

	@Override
	public void removeEntregaMerc(Long idEntregaMerc) {

		EntregaMerc entregaMerc = getEntregaMercById(idEntregaMerc);
		if(entregaMerc != null) {
			getCxcSession().delete(entregaMerc);
		}

	}

}
