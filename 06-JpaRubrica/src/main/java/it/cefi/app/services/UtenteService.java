package it.cefi.app.services;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.cefi.app.models.Utente;
import it.cefi.app.repositories.UtenteRepository;

@Service
public class UtenteService  {

	//creo l'oggetto dell'interfaccia
	
	@Autowired
	private UtenteRepository utenteRepository;
	
	public void saveUtente (Utente ut)
	{
		utenteRepository.save(ut); 
	}
	
	public List<Utente> getAllUsers ()
	{
		return utenteRepository.findAll(); 
	}
	
	public void deleteUser (Integer[] id)
	{
		for (Integer idutente:id)
		{
			utenteRepository.deleteById(idutente);
		}
	}
	
	public void deleteUser2 (Integer[] id)
	{
		utenteRepository.deleteAllByIdInBatch(Arrays.asList(id));
	}
	
	public List <Utente> findByEta(int eta)
	{
		return utenteRepository.findByEtaGreaterThan(eta);
	}
	
	
}
