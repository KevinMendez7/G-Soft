package com.scm.gsoft.dao.inv;
// Generated 26/08/2018 02:38:20 AM by Hibernate Tools 4.3.1

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.scm.gsoft.domain.inv.PlantillaArticulos;

@Repository
@Transactional
public class PlantillaArticulosDaoImpl extends AbstractSession implements PlantillaArticulosDao {

	@Override
	public List<PlantillaArticulos> getPlantillaArticulosList(){
		return (List<PlantillaArticulos>) getCxcSession().createQuery("from PlantillaArticulos").list();
	}

	@Override
	public PlantillaArticulos getPlantillaArticulosById(Long idPlantillaArticulos) {
		// TODO Auto-generated method stub
		return getCxcSession().get(PlantillaArticulos.class, idPlantillaArticulos);
	}

	@Override
	public PlantillaArticulos getPlantillaArticulosByName(String namePlantillaArticulos) {
		// TODO Auto-generated method stub
		return (PlantillaArticulos) getCxcSession().createQuery("from PlantillaArticulos where nombre = :namePlantillaArticulos")
				.setParameter("namePlantillaArticulos", namePlantillaArticulos).uniqueResult();
	}

	@Override
	public void updatePlantillaArticulos(PlantillaArticulos plantillaArticulos) {
		getCxcSession().update(plantillaArticulos);

	}

	@Override
	public void createPlantillaArticulos(PlantillaArticulos plantillaArticulos) {

		getCxcSession().persist(plantillaArticulos);

	}

	@Override
	public void removePlantillaArticulos(Long idPlantillaArticulos) {

		PlantillaArticulos plantillaArticulos = getPlantillaArticulosById(idPlantillaArticulos);
		if(plantillaArticulos != null) {
			getCxcSession().delete(plantillaArticulos);
		}

	}

}
