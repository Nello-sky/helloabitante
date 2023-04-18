package it.helloabitante.dao.abitante;

import java.util.ArrayList;
import java.util.List;

import it.helloabitante.dao.DB_Mock;
import it.helloabitante.dao.EntityManagerMock;
import it.helloabitante.model.Abitante;

public class AbitanteDAOImpl implements AbitanteDAO {

	// questo è simbolico, MOCK appunto
	private EntityManagerMock entityManager;

	@Override
	public List<Abitante> findByNomeAndCognome(String nome, String cognome) {
		List<Abitante> result = new ArrayList<>();

		for (Abitante abitanteItem : DB_Mock.LISTA_ABITANTI) {
			if (abitanteItem.getNome().startsWith(nome) && abitanteItem.getCognome().startsWith(cognome))
				result.add(abitanteItem);
		}
		return result;
	}

	@Override
	public List<Abitante> list() throws Exception {
		List<Abitante> LISTA = new ArrayList<>();
		for (Abitante abitanteItem : DB_Mock.LISTA_ABITANTI) {
			LISTA.add(abitanteItem);
		}
		return LISTA;
	}

	@Override // genera eccezzione se non presente id
	public Abitante get(Long id) throws Exception {
		for (Abitante abitanteItem : DB_Mock.LISTA_ABITANTI) {
			if (abitanteItem.getIdAbitante().equals(id))
				return abitanteItem;
		}
		return null;
	}

	@Override
	public int update(Abitante input) throws Exception {
		int result = 0;
	
		for (Abitante abitanteItem : DB_Mock.LISTA_ABITANTI) {
			if (abitanteItem.getIdAbitante().equals(input.getIdAbitante())) {
				abitanteItem.setNome(input.getNome());
				abitanteItem.setCognome(input.getCognome());
				abitanteItem.setCodiceFiscale(input.getCodiceFiscale());
				abitanteItem.setEta(input.getEta());
				abitanteItem.setMottoDiVita(input.getMottoDiVita());
				result++;
			}
		}
		return result;	
	}

	@Override
	public int insert(Abitante input) throws Exception {
		input.setIdAbitante(DB_Mock.getNexIdAvailable());
		return DB_Mock.LISTA_ABITANTI.add(input) ? 1 : 0;
	}

	@Override
	public int  delete(Long idToRemove) throws Exception {
		List<Abitante> listaNuova = new ArrayList<>();
		int result = 0;
		for (Abitante abitanteItem : DB_Mock.LISTA_ABITANTI) {
			if (!abitanteItem.getIdAbitante().equals(idToRemove))
				listaNuova.add(abitanteItem);
			else {
				result++;
			}
		}
		DB_Mock.LISTA_ABITANTI.clear();
		DB_Mock.LISTA_ABITANTI.addAll(listaNuova);
		return result;
	}

	@Override
	public void setEntityManager(EntityManagerMock entityManager) {
		this.entityManager = entityManager;
	}


}
