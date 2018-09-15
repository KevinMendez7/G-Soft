package com.scm.gsoft.dao.inv;
// Generated 26/08/2018 02:38:20 AM by Hibernate Tools 4.3.1

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.scm.gsoft.domain.inv.InventarioS;

@Repository
@Transactional
public class InventarioSDaoImpl extends AbstractSession implements InventarioSDao {

	@Override
	public List<InventarioS> getInventarioSList(){
		return (List<InventarioS>) getCxcSession().createQuery("from InventarioS").list();
	}

	@Override
	public InventarioS getInventarioSById(Long idInventarioS) {
		// TODO Auto-generated method stub
		return getCxcSession().get(InventarioS.class, idInventarioS);
	}

	@Override
	public InventarioS getInventarioSByName(String nameInventarioS) {
		// TODO Auto-generated method stub
		return (InventarioS) getCxcSession().createQuery("from InventarioS where nombre = :nameInventarioS")
				.setParameter("nameInventarioS", nameInventarioS).uniqueResult();
	}

	@Override
	public void updateInventarioS(InventarioS inventarioS) {
		getCxcSession().update(inventarioS);

	}

	@Override
	public void createInventarioS(InventarioS inventarioS) {

		getCxcSession().persist(inventarioS);

	}

	@Override
	public void removeInventarioS(Long idInventarioS) {

		InventarioS inventarioS = getInventarioSById(idInventarioS);
		if(inventarioS != null) {
			getCxcSession().delete(inventarioS);
		}

	}

}
