package com.scm.gsoft.service.inv;
// Generated 26/08/2018 02:38:20 AM by Hibernate Tools 4.3.1

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.scm.gsoft.dao.inv.Maestro1Dao;
import com.scm.gsoft.domain.inv.Maestro1;

@Service("Maestro1Service")
@Transactional
public class Maestro1ServiceImpl implements Maestro1Service {

	@Autowired
	private Maestro1Dao _maestro1Dao;

	@Override
	public List<Maestro1> getMaestro1List(){
		return _maestro1Dao.getMaestro1List();
	}

	@Override
	public Maestro1 getMaestro1ById(Long idMaestro1) {
		// TODO Auto-generated method stub
		return _maestro1Dao.getMaestro1ById(idMaestro1);
	}

	@Override
	public Maestro1 getMaestro1ByName(String nameMaestro1) {
		// TODO Auto-generated method stub
		return _maestro1Dao.getMaestro1ByName(nameMaestro1);
	}

	@Override
	public void updateMaestro1(Maestro1 maestro1) {

		_maestro1Dao.updateMaestro1(maestro1);

	}

	@Override
	public void createMaestro1(Maestro1 maestro1) {

		_maestro1Dao.createMaestro1(maestro1);

	}

	@Override
	public void removeMaestro1(Long idMaestro1) {

		_maestro1Dao.removeMaestro1(idMaestro1);

	}

}
