package com.scm.gsoft.dao.cxc;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.scm.gsoft.domain.cxc.Emisores;

@Repository
@Transactional
public class EmisoresDaoImpl extends AbstractSession implements EmisoresDao {

	@Override
	public List<Emisores> getEmisoresList(){
		return (List<Emisores>) getCxcSession().createQuery("from Emisores").list();
	}

	@Override
	public Emisores getEmisoresById(Long idEmisores) {
		// TODO Auto-generated method stub
		return getCxcSession().get(Emisores.class, idEmisores);
	}

	@Override
	public Emisores getEmisoresByName(String nameEmisores) {
		// TODO Auto-generated method stub
		return (Emisores) getCxcSession().createQuery("from Emisores where nombre = :nameEmisores")
				.setParameter("nameEmisores", nameEmisores).uniqueResult();
	}

	@Override
	public void updateEmisores(Emisores emisores) {
		getCxcSession().update(emisores);

	}

	@Override
	public void createEmisores(Emisores emisores) {

		getCxcSession().persist(emisores);

	}

	@Override
	public void removeEmisores(Long idEmisores) {

		Emisores emisores = getEmisoresById(idEmisores);
		if(emisores != null) {
			getCxcSession().delete(emisores);
		}

	}

}
