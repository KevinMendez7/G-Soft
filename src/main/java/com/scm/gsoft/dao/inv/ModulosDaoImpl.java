package com.scm.gsoft.dao.inv;
// Generated 26/08/2018 02:38:20 AM by Hibernate Tools 4.3.1

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.scm.gsoft.domain.inv.Modulos;

@Repository
@Transactional
public class ModulosDaoImpl extends AbstractSession implements ModulosDao {

	@Override
	public List<Modulos> getModulosList(){
		return (List<Modulos>) getCxcSession().createQuery("from Modulos").list();
	}

	@Override
	public Modulos getModulosById(Long idModulos) {
		// TODO Auto-generated method stub
		return getCxcSession().get(Modulos.class, idModulos);
	}

	@Override
	public Modulos getModulosByName(String nameModulos) {
		// TODO Auto-generated method stub
		return (Modulos) getCxcSession().createQuery("from Modulos where nombre = :nameModulos")
				.setParameter("nameModulos", nameModulos).uniqueResult();
	}

	@Override
	public void updateModulos(Modulos modulos) {
		getCxcSession().update(modulos);

	}

	@Override
	public void createModulos(Modulos modulos) {

		getCxcSession().persist(modulos);

	}

	@Override
	public void removeModulos(Long idModulos) {

		Modulos modulos = getModulosById(idModulos);
		if(modulos != null) {
			getCxcSession().delete(modulos);
		}

	}

}
