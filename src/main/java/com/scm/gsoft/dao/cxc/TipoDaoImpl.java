package com.scm.gsoft.dao.cxc;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.scm.gsoft.domain.cxc.Tipo;

@Qualifier("TipoDaoCxc")
@Repository("TipoRepositoryCxc")
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
