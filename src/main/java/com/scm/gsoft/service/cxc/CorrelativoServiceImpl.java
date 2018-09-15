package com.scm.gsoft.service.cxc;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.scm.gsoft.dao.cxc.CorrelativoDao;
import com.scm.gsoft.domain.cxc.Correlativo;

@Service("CorrelativoService")
@Transactional
public class CorrelativoServiceImpl implements CorrelativoService {

	@Autowired
	private CorrelativoDao _correlativoDao;

	@Override
	public List<Correlativo> getCorrelativoList(){
		return _correlativoDao.getCorrelativoList();
	}

	@Override
	public Correlativo getCorrelativoById(Long idCorrelativo) {
		// TODO Auto-generated method stub
		return _correlativoDao.getCorrelativoById(idCorrelativo);
	}

	@Override
	public Correlativo getCorrelativoByName(String nameCorrelativo) {
		// TODO Auto-generated method stub
		return _correlativoDao.getCorrelativoByName(nameCorrelativo);
	}

	@Override
	public void updateCorrelativo(Correlativo correlativo) {

		_correlativoDao.updateCorrelativo(correlativo);

	}

	@Override
	public void createCorrelativo(Correlativo correlativo) {

		_correlativoDao.createCorrelativo(correlativo);

	}

	@Override
	public void removeCorrelativo(Long idCorrelativo) {

		_correlativoDao.removeCorrelativo(idCorrelativo);

	}

}
