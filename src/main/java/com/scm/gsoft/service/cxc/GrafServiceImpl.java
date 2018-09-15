package com.scm.gsoft.service.cxc;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.scm.gsoft.dao.cxc.GrafDao;
import com.scm.gsoft.domain.cxc.Graf;

@Service("GrafService")
@Transactional
public class GrafServiceImpl implements GrafService {

	@Autowired
	private GrafDao _grafDao;

	@Override
	public List<Graf> getGrafList(){
		return _grafDao.getGrafList();
	}

	@Override
	public Graf getGrafById(Long idGraf) {
		// TODO Auto-generated method stub
		return _grafDao.getGrafById(idGraf);
	}

	@Override
	public Graf getGrafByName(String nameGraf) {
		// TODO Auto-generated method stub
		return _grafDao.getGrafByName(nameGraf);
	}

	@Override
	public void updateGraf(Graf graf) {

		_grafDao.updateGraf(graf);

	}

	@Override
	public void createGraf(Graf graf) {

		_grafDao.createGraf(graf);

	}

	@Override
	public void removeGraf(Long idGraf) {

		_grafDao.removeGraf(idGraf);

	}

}
