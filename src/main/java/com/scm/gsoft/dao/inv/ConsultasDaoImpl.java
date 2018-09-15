package com.scm.gsoft.dao.inv;
// Generated 26/08/2018 02:38:20 AM by Hibernate Tools 4.3.1

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.scm.gsoft.domain.inv.Consultas;

@Repository
@Transactional
public class ConsultasDaoImpl extends AbstractSession implements ConsultasDao {

	@Override
	public List<Consultas> getConsultasList(){
		return (List<Consultas>) getCxcSession().createQuery("from Consultas").list();
	}

	@Override
	public Consultas getConsultasById(Long idConsultas) {
		// TODO Auto-generated method stub
		return getCxcSession().get(Consultas.class, idConsultas);
	}

	@Override
	public Consultas getConsultasByName(String nameConsultas) {
		// TODO Auto-generated method stub
		return (Consultas) getCxcSession().createQuery("from Consultas where nombre = :nameConsultas")
				.setParameter("nameConsultas", nameConsultas).uniqueResult();
	}

	@Override
	public void updateConsultas(Consultas consultas) {
		getCxcSession().update(consultas);

	}

	@Override
	public void createConsultas(Consultas consultas) {

		getCxcSession().persist(consultas);

	}

	@Override
	public void removeConsultas(Long idConsultas) {

		Consultas consultas = getConsultasById(idConsultas);
		if(consultas != null) {
			getCxcSession().delete(consultas);
		}

	}

}
