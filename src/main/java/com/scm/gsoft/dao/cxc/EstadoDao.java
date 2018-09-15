package com.scm.gsoft.dao.cxc;

import java.util.List;

import com.scm.gsoft.domain.cxc.Estado;

public interface EstadoDao {

	List<Estado> getEstadoList();

	Estado getEstadoById(Long idEstado);

	Estado getEstadoByName(String nameEstado);

	void updateEstado(Estado estado);

	void createEstado(Estado estado);

	void removeEstado(Long idEstado);

}
