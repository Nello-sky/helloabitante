package it.helloabitante.dao.abitante;

import java.util.List;

import it.helloabitante.dao.IBaseDAO;
import it.helloabitante.model.Abitante;

public interface AbitanteDAO extends IBaseDAO<Abitante> {
	public List<Abitante> findByNomeAndCognome(String nome, String cognome);
}
