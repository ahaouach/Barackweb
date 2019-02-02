package org.sid.dao;

import java.util.List;

import org.sid.entities.Barrique;
import org.sid.entities.Rack;

public interface BarriqueRepositoryCustom {

	public List<Barrique> AlerteMaturite();

	public Barrique addBarrique(Barrique b, long IdEtiquette, long IdRack);


}
