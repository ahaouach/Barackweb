package org.sid.dao;

import java.util.List;

import org.sid.entities.Barrique;
import org.sid.entities.Etiquette;
import org.sid.entities.Rack;

public interface BarriqueRepositoryCustom {

	public List<Barrique> AlerteMaturite();

	public void addBarrique(Barrique b, long IdEtiquette, long IdRack);

	public List<Barrique> getBarriques();

	public List<Barrique> RechercherBarrique(long IdEntrepot);



	
	


}
