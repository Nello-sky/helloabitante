package it.helloabitante.service.abitante;

import java.util.List;

import it.helloabitante.dao.abitante.AbitanteDAO;
import it.helloabitante.model.Abitante;

public interface AbitanteService {
	
	public void setAbitanteDAO(AbitanteDAO abitanteDAO);

	public List<Abitante> cercaPerNomeECognome(String nome, String cognome);

	public Abitante caricaSingolo(Long id);
	
	public int inserisciNuovo(Abitante input);
	
	public List<Abitante> listAll() ;
	
	void rimuovi(Long idAbitante) ;
	
	void aggiorna(Abitante input);
}
