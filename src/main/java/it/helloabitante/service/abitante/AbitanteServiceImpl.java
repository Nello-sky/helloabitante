package it.helloabitante.service.abitante;

import java.util.List;

import it.helloabitante.dao.abitante.AbitanteDAO;
import it.helloabitante.model.Abitante;

public class AbitanteServiceImpl implements AbitanteService {

	private AbitanteDAO abitanteDAO;

	public void setAbitanteDAO(AbitanteDAO abitanteDAO) {
		this.abitanteDAO = abitanteDAO;
	}

	@Override
	public List<Abitante> cercaPerNomeECognome(String nome, String cognome) {
		// abitanteDAO.setConnection(MyConnection.getConnection());
		return abitanteDAO.findByNomeAndCognome(nome, cognome);
	}

	public Abitante caricaSingolo(Long id) throws Exception {
		return abitanteDAO.get(id);
	}

	@Override
	public int inserisciNuovo(Abitante input) {
		try {
			return abitanteDAO.insert(input);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);

		}
	}

	@Override
	public List<Abitante> listAll() {
		try {
			return abitanteDAO.list();
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

}
