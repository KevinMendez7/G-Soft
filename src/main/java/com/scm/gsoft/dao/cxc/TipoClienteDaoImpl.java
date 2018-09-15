package com.scm.gsoft.dao.cxc;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.scm.gsoft.domain.cxc.TipoCliente;

@Repository
@Transactional
public class TipoClienteDaoImpl extends AbstractSession implements TipoClienteDao {

	@Override
	public List<TipoCliente> getTipoClienteList(){
		return (List<TipoCliente>) getCxcSession().createQuery("from TipoCliente").list();
	}

	@Override
	public TipoCliente getTipoClienteById(Long idTipoCliente) {
		// TODO Auto-generated method stub
		return getCxcSession().get(TipoCliente.class, idTipoCliente);
	}

	@Override
	public TipoCliente getTipoClienteByName(String nameTipoCliente) {
		// TODO Auto-generated method stub
		return (TipoCliente) getCxcSession().createQuery("from TipoCliente where nombre = :nameTipoCliente")
				.setParameter("nameTipoCliente", nameTipoCliente).uniqueResult();
	}

	@Override
	public void updateTipoCliente(TipoCliente tipoCliente) {
		getCxcSession().update(tipoCliente);

	}

	@Override
	public void createTipoCliente(TipoCliente tipoCliente) {

		getCxcSession().persist(tipoCliente);

	}

	@Override
	public void removeTipoCliente(Long idTipoCliente) {

		TipoCliente tipoCliente = getTipoClienteById(idTipoCliente);
		if(tipoCliente != null) {
			getCxcSession().delete(tipoCliente);
		}

	}

}
