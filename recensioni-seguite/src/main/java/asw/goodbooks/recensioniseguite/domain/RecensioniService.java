package asw.goodbooks.recensioniseguite.domain;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RecensioniService {
	
	@Autowired
	private RecensioniRepository recensioniRepository;
	
	public Recensione saveRecensione(Recensione recensione) {
		recensione = recensioniRepository.save(recensione);
		return recensione;
	}
	
	public Collection<Recensione> getRecensioniByAutoreLibro(String autore) {
		Collection<Recensione> recensioni = recensioniRepository.findAllByAutoreLibro(autore);
		return recensioni;
	}
	
	public Collection<Recensione> getRecensioniByRecensore(String recensore) {
		Collection<Recensione> recensioni = recensioniRepository.findAllByRecensore(recensore);
		return recensioni;
	}

}
