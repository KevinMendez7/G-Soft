package com.scm.gsoft.dao.inv;
// Generated 26/08/2018 02:38:20 AM by Hibernate Tools 4.3.1

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.scm.gsoft.domain.inv.Marcas;

@Repository
@Transactional
public class MarcasDaoImpl extends AbstractSession implements MarcasDao {

	@Override
	public List<Marcas> getMarcasList(){
		return (List<Marcas>) getCxcSession().createQuery("from Marcas").list();
	}

	@Override
	public Marcas getMarcasById(Long idMarcas) {
		// TODO Auto-generated method stub
		return getCxcSession().get(Marcas.class, idMarcas);
	}

	@Override
	public Marcas getMarcasByName(String nameMarcas) {
		// TODO Auto-generated method stub
		return (Marcas) getCxcSession().createQuery("from Marcas where nombre = :nameMarcas")
				.setParameter("nameMarcas", nameMarcas).uniqueResult();
	}

	@Override
	public void updateMarcas(Marcas marcas) {
		getCxcSession().update(marcas);

	}

	@Override
	public void createMarcas(Marcas marcas) {

		getCxcSession().persist(marcas);

	}

	@Override
	public void removeMarcas(Long idMarcas) {

		Marcas marcas = getMarcasById(idMarcas);
		if(marcas != null) {
			getCxcSession().delete(marcas);
		}

	}

}
