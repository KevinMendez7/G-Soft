package com.scm.gsoft.dao.cxc;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.scm.gsoft.domain.cxc.DetVarios;

@Repository
@Transactional
public class DetVariosDaoImpl extends AbstractSession implements DetVariosDao {

	@Override
	public List<DetVarios> getDetVariosList(){
		return (List<DetVarios>) getCxcSession().createQuery("from DetVarios").list();
	}

	@Override
	public DetVarios getDetVariosById(Long idDetVarios) {
		// TODO Auto-generated method stub
		return getCxcSession().get(DetVarios.class, idDetVarios);
	}

	@Override
	public DetVarios getDetVariosByName(String nameDetVarios) {
		// TODO Auto-generated method stub
		return (DetVarios) getCxcSession().createQuery("from DetVarios where nombre = :nameDetVarios")
				.setParameter("nameDetVarios", nameDetVarios).uniqueResult();
	}

	@Override
	public void updateDetVarios(DetVarios detVarios) {
		getCxcSession().update(detVarios);

	}

	@Override
	public void createDetVarios(DetVarios detVarios) {

		getCxcSession().persist(detVarios);

	}

	@Override
	public void removeDetVarios(Long idDetVarios) {

		DetVarios detVarios = getDetVariosById(idDetVarios);
		if(detVarios != null) {
			getCxcSession().delete(detVarios);
		}

	}

}
