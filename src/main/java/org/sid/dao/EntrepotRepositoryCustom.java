package org.sid.dao;

import java.util.List;

import org.sid.entities.Barrique;
import org.sid.entities.Entrepot;

public interface EntrepotRepositoryCustom {
	public List<Entrepot> getEntrepots();

	public void addEntrepot(Entrepot e);

	public List<Entrepot> getEntrepotsEtat();

	public Entrepot ModifEntrepot(long IdEntrepot, String ReferenceEntrepot, float Superficie);

	public List<Entrepot> RechercherEntrepot(long IdEntrepot);
}
