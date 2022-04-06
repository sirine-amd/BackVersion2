package com.pfe.back.BackPfe.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.pfe.back.BackPfe.entities.Formation;
import com.pfe.back.BackPfe.entities.demande_inscription;

@Service
public interface demande_inscriptionService {

	public List<demande_inscription> getDemandes_inscriptions();

	public void deleteFormation(Long id);

	public demande_inscription adddemande_inscription(demande_inscription demande_inscription);

	public List<demande_inscription> getDemandes_inscriptionsFormation();

	public List<demande_inscription> getDemandes_inscriptionsExamen();

	public boolean accepterdemande(Long id);

	public boolean refuserdemande(Long id);

	public List<demande_inscription> gethistorique();

}
