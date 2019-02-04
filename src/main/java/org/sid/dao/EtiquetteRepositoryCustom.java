package org.sid.dao;

import java.util.List;

import org.sid.entities.Etiquette;

public interface EtiquetteRepositoryCustom {

	public void ModifEttiquette(long IdEtiquette, String code);

	public List<Etiquette> getEtiquettes();

	public Etiquette addEtiquette(Etiquette et);

}
