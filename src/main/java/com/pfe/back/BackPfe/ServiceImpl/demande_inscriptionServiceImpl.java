package com.pfe.back.BackPfe.ServiceImpl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pfe.back.BackPfe.entities.Formation;
import com.pfe.back.BackPfe.entities.User;
import com.pfe.back.BackPfe.entities.demande_inscription;
import com.pfe.back.BackPfe.repository.FormationRepo;
import com.pfe.back.BackPfe.repository.demande_inscriptionRepo;
import com.pfe.back.BackPfe.services.demande_inscriptionService;
@Service
public class demande_inscriptionServiceImpl implements demande_inscriptionService {
	@Autowired
	private demande_inscriptionRepo demande_inscriptionRepository;

	@Override
	public List<demande_inscription> getDemandes_inscriptions() {
		List<demande_inscription> L= demande_inscriptionRepository.findAll();
		List<demande_inscription> L2 = null;
		System.out.println("ok");
		System.out.println(L.size());

		for(int i=0;i<L.size();i++)
		{		System.out.println(L.get(i).getEtat());

			if(L.get(i).getEtat().equals("non traitée"))
			{	L2.add(L.get(i));
			System.out.println("ok");
			System.out.println(L.get(i).getEtat());

			}
				
		}
		return L2;
	}

	@Override
	public void deleteFormation(Long id) {
		demande_inscriptionRepository.deleteById(id);
		
	}

	@Override
	public demande_inscription adddemande_inscription(demande_inscription demande_inscription) {
		return demande_inscriptionRepository.save(demande_inscription);		}
	@Override

	public List<demande_inscription> getDemandes_inscriptionsFormation() {
		List<demande_inscription> L =demande_inscriptionRepository.findByType("formation");
		List<demande_inscription> L2=new ArrayList<>(); 
		System.out.println("ok");
		System.out.println(L.size());

		for(int i=0;i<L.size();i++)
		{		System.out.println(L.get(i).getEtat());

			if(L.get(i).getEtat().equals("non traitée"))
			{	L2.add(L.get(i));
			System.out.println("ok");
			System.out.println(L.get(i).getEtat());

			}
				
		}
		return L2;
	}
	@Override

	public List<demande_inscription> getDemandes_inscriptionsExamen() {
		return demande_inscriptionRepository.findByType("examen");
	}

	@Override
	public boolean accepterdemande(Long id) {
		
		Optional<demande_inscription> demande=demande_inscriptionRepository.findById(id);
		if(demande.isPresent())
		{SimpleDateFormat dtf = new SimpleDateFormat("yyyy/MM/dd");
		  Calendar calendar = Calendar.getInstance();
		  
		  Date dateObj = calendar.getTime();
			demande_inscription demande2=demande.get();
			demande2.setEtat("acceptée");
			demande2.setDatetraitement(dateObj);
			demande_inscriptionRepository.save(demande2);
			return true;
		}
		return false;
	}
	@Override
	public boolean refuserdemande(Long id) {
		Optional<demande_inscription> demande=demande_inscriptionRepository.findById(id);
		if(demande.isPresent())
		{	  SimpleDateFormat dtf = new SimpleDateFormat("yyyy/MM/dd");
		  Calendar calendar = Calendar.getInstance();
		  
		  Date dateObj = calendar.getTime();
		  
			demande_inscription demande2=demande.get();
			demande2.setEtat("refusée");
			demande2.setDatetraitement(dateObj);
			demande_inscriptionRepository.save(demande2);
			return true;
		}
		return false;
	}
	@Override
	public List<demande_inscription> gethistorique() {
		List<demande_inscription> L =demande_inscriptionRepository.findByType("formation");
		List<demande_inscription> L2=new ArrayList<>(); 
		System.out.println(L.size());

		for(int i=0;i<L.size();i++)
		{		
			if(! (L.get(i).getEtat().equals("non traitée")))
			{L2.add(L.get(i));
			System.out.println("ok");
			System.out.println(L.get(i).getEtat());

			}
				
		}
		return L2;
	}

}
