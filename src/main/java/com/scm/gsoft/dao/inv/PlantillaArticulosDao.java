package com.scm.gsoft.dao.inv;

import java.util.List;

import com.scm.gsoft.domain.inv.PlantillaArticulos;

public interface PlantillaArticulosDao {

	List<PlantillaArticulos> getPlantillaArticulosList();

	PlantillaArticulos getPlantillaArticulosById(Long idPlantillaArticulos);

	PlantillaArticulos getPlantillaArticulosByName(String namePlantillaArticulos);

	void updatePlantillaArticulos(PlantillaArticulos plantillaArticulos);

	void createPlantillaArticulos(PlantillaArticulos plantillaArticulos);

	void removePlantillaArticulos(Long idPlantillaArticulos);

}
