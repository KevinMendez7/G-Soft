
package com.scm.gsoft.dao.inv;
// Generated 26/08/2018 02:38:20 AM by Hibernate Tools 4.3.1

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.scm.gsoft.domain.inv.Tipo;

@Repository
@Transactional
public class TipoDaoImpl extends AbstractSession implements TipoDao {

	@Override
	public List<Tipo> getTipoList(){
		return (List<Tipo>) getCxcSession().createQuery("from Tipo").list();
	}

	@Override
	public Tipo getTipoById(Long idTipo) {
		// TODO Auto-generated method stub
		return getCxcSession().get(Tipo.class, idTipo);
	}

	@Override
	public Tipo getTipoByName(String nameTipo) {
		// TODO Auto-generated method stub
		return (Tipo) getCxcSession().createQuery("from Tipo where nombre = :nameTipo")
				.setParameter("nameTipo", nameTipo).uniqueResult();
	}

	@Override
	public void updateTipo(Tipo tipo) {
		getCxcSession().update(tipo);

	}

	@Override
	public void createTipo(Tipo tipo) {

		getCxcSession().persist(tipo);

	}

	@Override
	public void removeTipo(Long idTipo) {

		Tipo tipo = getTipoById(idTipo);
		if(tipo != null) {
			getCxcSession().delete(tipo);
		}

	}

}
