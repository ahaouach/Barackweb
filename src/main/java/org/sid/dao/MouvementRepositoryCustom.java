package org.sid.dao;

import java.util.List;

import org.sid.entities.Mouvement;

public interface MouvementRepositoryCustom {

	public Mouvement addMouvement(Mouvement mv, long IdBarique, long IdTypeMouvement, long IdUser);

	public List<Mouvement> MouvementsDates(String Libelle, String DateDebut, String DateFin);

}
