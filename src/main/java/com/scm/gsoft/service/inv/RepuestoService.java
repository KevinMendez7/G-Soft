package com.scm.gsoft.service.inv;

import java.util.List;

import com.scm.gsoft.domain.inv.Repuesto;

public interface RepuestoService {

	List<Repuesto> getRepuestoList();

	Repuesto getRepuestoById(Long idRepuesto);

	Repuesto getRepuestoByName(String nameRepuesto);

	void updateRepuesto(Repuesto repuesto);

	void createRepuesto(Repuesto repuesto);

	void removeRepuesto(Long idRepuesto);

}
