package com.scm.gsoft.service.cxc;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.scm.gsoft.dao.cxc.BorraDao;
import com.scm.gsoft.domain.cxc.Borra;

@Qualifier("BorraServiceCxc")
@Service("BorraServiceCxc")
@Transactional
public class BorraServiceImpl implements BorraService {

	@Autowired
	@Qualifier("BorraDaoCxc")
	private BorraDao _borraDao;

	@Override
	public List<Borra> getBorraList(){
		return _borraDao.getBorraList();
	}

	@Override
	public Borra getBorraById(Long idBorra) {
		// TODO Auto-generated method stub
		return _borraDao.getBorraById(idBorra);
	}

	@Override
	public Borra getBorraByCodeBodega(String codeBodega) {
		// TODO Auto-generated method stub
		return _borraDao.getBorraByCodeBodega(codeBodega);
	}

	@Override
	public void updateBorra(Borra borra) {

		_borraDao.updateBorra(borra);

	}

	@Override
	public void createBorra(Borra borra) {

		_borraDao.createBorra(borra);

	}

	@Override
	public void removeBorra(Long idBorra) {

		_borraDao.removeBorra(idBorra);

	}

}
