package com.scm.gsoft.service.inv;
// Generated 26/08/2018 02:38:20 AM by Hibernate Tools 4.3.1

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.scm.gsoft.dao.inv.PlantillaArticulosDao;
import com.scm.gsoft.domain.inv.PlantillaArticulos;

@Service("PlantillaArticulosService")
@Transactional
public class PlantillaArticulosServiceImpl implements PlantillaArticulosService {

	@Autowired
	private PlantillaArticulosDao _plantillaArticulosDao;

	@Override
	public List<PlantillaArticulos> getPlantillaArticulosList(){
		return _plantillaArticulosDao.getPlantillaArticulosList();
	}

	@Override
	public PlantillaArticulos getPlantillaArticulosById(Long idPlantillaArticulos) {
		// TODO Auto-generated method stub
		return _plantillaArticulosDao.getPlantillaArticulosById(idPlantillaArticulos);
	}

	@Override
	public PlantillaArticulos getPlantillaArticulosByName(String namePlantillaArticulos) {
		// TODO Auto-generated method stub
		return _plantillaArticulosDao.getPlantillaArticulosByName(namePlantillaArticulos);
	}

	@Override
	public void updatePlantillaArticulos(PlantillaArticulos plantillaArticulos) {

		_plantillaArticulosDao.updatePlantillaArticulos(plantillaArticulos);

	}

	@Override
	public void createPlantillaArticulos(PlantillaArticulos plantillaArticulos) {

		_plantillaArticulosDao.createPlantillaArticulos(plantillaArticulos);

	}

	@Override
	public void removePlantillaArticulos(Long idPlantillaArticulos) {

		_plantillaArticulosDao.removePlantillaArticulos(idPlantillaArticulos);

	}

}
