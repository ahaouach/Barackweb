package org.sid.dao;

import java.util.List;

import org.sid.entities.Rack;

public interface RackRepositoryCustom {

	public List<Rack> getRacks();

	public Rack addRack(Rack r, long IdEntrepot);

	public Rack ModifRack(long IdRack, int Numero, String Emplacement, int NbreLigne, int NbreColonne, int NbrePronfondeur);

	public List<Rack> RechercherRack(int Numero);

}
