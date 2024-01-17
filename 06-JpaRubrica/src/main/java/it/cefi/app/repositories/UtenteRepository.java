package it.cefi.app.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.cefi.app.models.Utente;

@Repository
public interface UtenteRepository extends JpaRepository<Utente, Integer> {

	/*
	  		creazione di una query method:
	  		
	  	keyword_(ex:findBy)nomecampo(ex:Eta)_keyword(ex:GreaterThan)_(parametro)

	  	List <Utente> findByEtaGreaterThan(int eta);
	  	corrisponde a-----> FROM Utente ut WHERE ut.eta>=:eta
	*/
	
	List <Utente> findByEtaGreaterThan(int eta);
}
