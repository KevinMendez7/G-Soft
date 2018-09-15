package com.scm.gsoft.service.inv;

import java.util.List;

import com.scm.gsoft.domain.inv.Consultas;

public interface ConsultasService {

	List<Consultas> getConsultasList();

	Consultas getConsultasById(Long idConsultas);

	Consultas getConsultasByName(String nameConsultas);

	void updateConsultas(Consultas consultas);

	void createConsultas(Consultas consultas);

	void removeConsultas(Long idConsultas);

}
