package com.scm.gsoft.service.inv;
// Generated 26/08/2018 02:38:20 AM by Hibernate Tools 4.3.1

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.scm.gsoft.dao.inv.ConsultasDao;
import com.scm.gsoft.domain.inv.Consultas;

@Service("ConsultasService")
@Transactional
public class ConsultasServiceImpl implements ConsultasService {

	@Autowired
	private ConsultasDao _consultasDao;

	@Override
	public List<Consultas> getConsultasList(){
		return _consultasDao.getConsultasList();
	}

	@Override
	public Consultas getConsultasById(Long idConsultas) {
		// TODO Auto-generated method stub
		return _consultasDao.getConsultasById(idConsultas);
	}

	@Override
	public Consultas getConsultasByName(String nameConsultas) {
		// TODO Auto-generated method stub
		return _consultasDao.getConsultasByName(nameConsultas);
	}

	@Override
	public void updateConsultas(Consultas consultas) {

		_consultasDao.updateConsultas(consultas);

	}

	@Override
	public void createConsultas(Consultas consultas) {

		_consultasDao.createConsultas(consultas);

	}

	@Override
	public void removeConsultas(Long idConsultas) {

		_consultasDao.removeConsultas(idConsultas);

	}

}
