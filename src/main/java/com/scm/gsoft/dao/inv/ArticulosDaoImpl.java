package com.scm.gsoft.dao.inv;
// Generated 26/08/2018 02:38:20 AM by Hibernate Tools 4.3.1

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.scm.gsoft.domain.inv.Articulos;

@Repository
@Transactional
public class ArticulosDaoImpl extends AbstractSession implements ArticulosDao {

	@Override
	public List<Articulos> getArticulosList(){
		return (List<Articulos>) getCxcSession().createQuery("from Articulos").list();
	}

	@Override
	public Articulos getArticulosById(Long idArticulos) {
		// TODO Auto-generated method stub
		return getCxcSession().get(Articulos.class, idArticulos);
	}

	@Override
	public Articulos getArticulosByName(String nameArticulos) {
		// TODO Auto-generated method stub
		return (Articulos) getCxcSession().createQuery("from Articulos where nombre = :nameArticulos")
				.setParameter("nameArticulos", nameArticulos).uniqueResult();
	}

	@Override
	public void updateArticulos(Articulos articulos) {
		getCxcSession().update(articulos);

	}

	@Override
	public void createArticulos(Articulos articulos) {

		getCxcSession().persist(articulos);

	}

	@Override
	public void removeArticulos(Long idArticulos) {

		Articulos articulos = getArticulosById(idArticulos);
		if(articulos != null) {
			getCxcSession().delete(articulos);
		}

	}

}
