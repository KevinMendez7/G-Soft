package com.scm.gsoft.service.inv;

import java.util.List;

import com.scm.gsoft.domain.inv.SubGrupos;

public interface SubGruposService {

	List<SubGrupos> getSubGruposList();

	SubGrupos getSubGruposById(Long idSubGrupos);

	SubGrupos getSubGruposByName(String nameSubGrupos);

	void updateSubGrupos(SubGrupos subGrupos);

	void createSubGrupos(SubGrupos subGrupos);

	void removeSubGrupos(Long idSubGrupos);

}
