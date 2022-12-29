package asw.goodbooks.recensioniseguite.domain;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.*; 
import java.util.stream.*; 

@Service 
public class RecensioniSeguiteService {

	@Autowired 
	private ConnessioniClientPort connessioniClient;

	@Autowired 
	private RecensioniClientPort recensioniClient;
	
	@Autowired
	private RecensioniService recensioniService;
	
	@Autowired
	private ConnessioniService connessioniService;
	
	@Autowired
	private RecensioniSeguiteRepository recensioniSeguiteRepository;

	/* Trova le recensioni seguite da un utente. */ 
	public Collection<Recensione> getRecensioniSeguite(String utente) {
		Collection<Recensione> recensioniSeguite = new TreeSet<>(); 
		
		Collection<ConnessioneConAutore> connessioniConAutore = connessioniClient.getConnessioniConAutoreByUtente(utente); 
		Collection<String> autoriSeguiti = 
			connessioniConAutore
				.stream()
				.map(c -> c.getAutore())
				.collect(Collectors.toSet()); 
		if (autoriSeguiti.size()>0) {
			Collection<Recensione> recensioniDiAutori = recensioniClient.getRecensioniByAutori(autoriSeguiti);
			recensioniSeguite.addAll(recensioniDiAutori); 
		}
		
		Collection<ConnessioneConRecensore> connessioniConRecensore = connessioniClient.getConnessioniConRecensoreByUtente(utente); 
		Collection<String> recensoriSeguiti = 
			connessioniConRecensore
				.stream()
				.map(c -> c.getRecensore())
				.collect(Collectors.toSet()); 
		if (recensoriSeguiti.size()>0) {
			Collection<Recensione> recensioniDiRecensori = recensioniClient.getRecensioniByRecensori(recensoriSeguiti);
			recensioniSeguite.addAll(recensioniDiRecensori); 
		}

		return recensioniSeguite; 
	}
	
	public void updateAfterNewRecensione(Recensione recensione) {
		Collection<String> utenti = connessioniService.getUtentiByAutoreAndRecensoreSeguiti(
				recensione.getAutoreLibro(), recensione.getRecensore());
		utenti.parallelStream().forEach(utente -> recensioniSeguiteRepository.save(
				new RecensioneSeguita(utente, recensione.getId(), recensione.getRecensore(),
						recensione.getTitoloLibro(), recensione.getAutoreLibro(), recensione.getTestoRecensione())));
	}
	
	public void updateAfterNewConnessioneConAutore(ConnessioneConAutore connessioneConAutore) {
		Collection<Recensione> recensioni = recensioniService.getRecensioniByAutoreLibro(connessioneConAutore.getAutore());
		recensioni.parallelStream().forEach(recensione -> recensioniSeguiteRepository.save(
				new RecensioneSeguita(connessioneConAutore.getUtente(), recensione.getId(),
						recensione.getRecensore(), recensione.getTitoloLibro(), recensione.getAutoreLibro(),
						recensione.getTestoRecensione())));
	}
	
	public void updateAfterNewConnessioneConRecensore(ConnessioneConRecensore connessioneConRecensore) {
		Collection<Recensione> recensioni = recensioniService.getRecensioniByRecensore(connessioneConRecensore.getRecensore());
		recensioni.parallelStream().forEach(recensione -> recensioniSeguiteRepository.save(
				new RecensioneSeguita(connessioneConRecensore.getUtente(), recensione.getId(),
						recensione.getRecensore(), recensione.getTitoloLibro(), recensione.getAutoreLibro(),
						recensione.getTestoRecensione())));
	}

}
