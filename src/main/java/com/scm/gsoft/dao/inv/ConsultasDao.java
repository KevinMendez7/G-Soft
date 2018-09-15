package com.scm.gsoft.dao.inv;

import java.util.List;

import com.scm.gsoft.domain.inv.Consultas;

public interface ConsultasDao {

	List<Consultas> getConsultasList();

	Consultas getConsultasById(Long idConsultas);

	Consultas getConsultasByName(String nameConsultas);

	void updateConsultas(Consultas consultas);

	void createConsultas(Consultas consultas);

	void removeConsultas(Long idConsultas);

}
