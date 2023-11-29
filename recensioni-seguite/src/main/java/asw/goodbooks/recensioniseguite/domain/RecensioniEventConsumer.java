package asw.goodbooks.recensioniseguite.domain;

import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import asw.goodbooks.common.api.event.DomainEvent;
import asw.goodbooks.recensioni.api.event.RecensioneCreatedEvent;

@Service
public class RecensioniEventConsumer {
	
	private final Logger logger = Logger.getLogger(this.getClass().toString());
	
	@Autowired
	private RecensioniService recensioniService;
	
	@Autowired
	private RecensioniSeguiteService recensioniSeguiteService;
	
	public void onEvent(DomainEvent event) {
		if (event.getClass().equals(RecensioneCreatedEvent.class)) {
			RecensioneCreatedEvent rce = (RecensioneCreatedEvent) event;
			onRecensioneCreated(rce);
		} else {
			logger.info("UNKNOWN EVENT: " + event);
		}
	}
	
	private void onRecensioneCreated(RecensioneCreatedEvent event) {
		Recensione recensione = new Recensione(event.getId(), event.getRecensore(),
				event.getTitoloLibro(), event.getAutoreLibro(), event.getTestoRecensione());
		logger.info("CREATED RECENSIONE: " + recensione);
		recensioniService.saveRecensione(recensione);
		logger.info("SAVED RECENSIONE: " + recensione);
		
		recensioniSeguiteService.updateAfterNewRecensione(recensione);
	}

}