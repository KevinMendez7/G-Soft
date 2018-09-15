package com.scm.gsoft.service.cxc;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.scm.gsoft.dao.cxc.VendedorDao;
import com.scm.gsoft.domain.cxc.Vendedor;

@Qualifier("VendedorServiceCxc")
@Service("VendedorServiceCxc")
@Transactional
public class VendedorServiceImpl implements VendedorService {

	@Autowired
	@Qualifier("VendedorDaoCxc")
	private VendedorDao _vendedorDao;

	@Override
	public List<Vendedor> getVendedorList(){
		return _vendedorDao.getVendedorList();
	}

	@Override
	public Vendedor getVendedorById(Long idVendedor) {
		// TODO Auto-generated method stub
		return _vendedorDao.getVendedorById(idVendedor);
	}

	@Override
	public Vendedor getVendedorByName(String nameVendedor) {
		// TODO Auto-generated method stub
		return _vendedorDao.getVendedorByName(nameVendedor);
	}

	@Override
	public void updateVendedor(Vendedor vendedor) {

		_vendedorDao.updateVendedor(vendedor);

	}

	@Override
	public void createVendedor(Vendedor vendedor) {

		_vendedorDao.createVendedor(vendedor);

	}

	@Override
	public void removeVendedor(Long idVendedor) {

		_vendedorDao.removeVendedor(idVendedor);

	}

}
