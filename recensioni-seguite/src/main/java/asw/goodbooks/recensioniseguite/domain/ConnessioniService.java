package asw.goodbooks.recensioniseguite.domain;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ConnessioniService {
	
	@Autowired
	private ConnessioniConAutoriRepository connessioniConAutoriRepository;
	
	@Autowired
	private ConnessioniConRecensoriRepository connessioniConRecensoriRepository;
	
	public ConnessioneConAutore saveConnessioneConAutore(ConnessioneConAutore connessioneConAutore) {
		connessioneConAutore = connessioniConAutoriRepository.save(connessioneConAutore);
		return connessioneConAutore;
	}
	
	public ConnessioneConRecensore saveConnessioneConRecensore(ConnessioneConRecensore connessioneConRecensore) {
		connessioneConRecensore = connessioniConRecensoriRepository.save(connessioneConRecensore);
		return connessioneConRecensore;
	}
	
	public Collection<String> getUtentiByAutoreAndRecensoreSeguiti(String autore, String recensore) {
		Collection<ConnessioneConAutore> connessioniUtenteAutore = connessioniConAutoriRepository.findAllByAutore(autore);
		Collection<ConnessioneConRecensore> connessioniUtenteRecensore= connessioniConRecensoriRepository.findAllByRecensore(recensore);
		List<String> utenti = new ArrayList<String>();
		connessioniUtenteAutore.parallelStream().forEach(connessione -> utenti.add(connessione.getUtente()));
		connessioniUtenteRecensore.parallelStream().forEach(connessione -> utenti.add(connessione.getUtente()));
		return utenti;
	}

}
