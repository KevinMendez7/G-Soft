package com.scm.gsoft.dao.cxc;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.scm.gsoft.domain.cxc.Estado;

@Repository
@Transactional
public class EstadoDaoImpl extends AbstractSession implements EstadoDao {

	@Override
	public List<Estado> getEstadoList(){
		return (List<Estado>) getCxcSession().createQuery("from Estado").list();
	}

	@Override
	public Estado getEstadoById(Long idEstado) {
		// TODO Auto-generated method stub
		return getCxcSession().get(Estado.class, idEstado);
	}

	@Override
	public Estado getEstadoByName(String nameEstado) {
		// TODO Auto-generated method stub
		return (Estado) getCxcSession().createQuery("from Estado where nombre = :nameEstado")
				.setParameter("nameEstado", nameEstado).uniqueResult();
	}

	@Override
	public void updateEstado(Estado estado) {
		getCxcSession().update(estado);

	}

	@Override
	public void createEstado(Estado estado) {

		getCxcSession().persist(estado);

	}

	@Override
	public void removeEstado(Long idEstado) {

		Estado estado = getEstadoById(idEstado);
		if(estado != null) {
			getCxcSession().delete(estado);
		}

	}

}
