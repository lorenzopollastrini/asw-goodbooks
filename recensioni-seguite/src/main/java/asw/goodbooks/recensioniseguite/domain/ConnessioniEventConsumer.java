package asw.goodbooks.recensioniseguite.domain;

import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import asw.goodbooks.common.api.event.DomainEvent;
import asw.goodbooks.connessioni.api.event.ConnessioneConAutoreCreatedEvent;
import asw.goodbooks.connessioni.api.event.ConnessioneConRecensoreCreatedEvent;

@Service
public class ConnessioniEventConsumer {
	
	private final Logger logger = Logger.getLogger(this.getClass().toString());
	
	@Autowired
	private ConnessioniService connessioniService;
	
	@Autowired
	private RecensioniSeguiteService recensioniSeguiteService;
	
	public void onEvent(DomainEvent event) {
		
		if (event.getClass().equals(ConnessioneConAutoreCreatedEvent.class)) {
			ConnessioneConAutoreCreatedEvent ccace = (ConnessioneConAutoreCreatedEvent) event;
			onConnessioneConAutoreCreatedEvent(ccace);
		} else if (event.getClass().equals(ConnessioneConRecensoreCreatedEvent.class)) {
			ConnessioneConRecensoreCreatedEvent ccrce = (ConnessioneConRecensoreCreatedEvent) event;
			onConnessioneConRecensoreCreatedEvent(ccrce);
		} else {
			logger.info("UNKNOWN EVENT: " + event);
		}
	}
	
	private void onConnessioneConAutoreCreatedEvent(ConnessioneConAutoreCreatedEvent event) {
		ConnessioneConAutore connessioneConAutore = new ConnessioneConAutore(event.getId(),
				event.getUtente(), event.getAutore());
		logger.info("CREATED CONNESSIONE CON AUTORE: " + connessioneConAutore);
		connessioniService.saveConnessioneConAutore(connessioneConAutore);
		logger.info("SAVED CONNESSIONE CON AUTORE: " + connessioneConAutore);
		
		recensioniSeguiteService.updateAfterNewConnessioneConAutore(connessioneConAutore);
	}
	
	private void onConnessioneConRecensoreCreatedEvent(ConnessioneConRecensoreCreatedEvent event) {
		ConnessioneConRecensore connessioneConRecensore = new ConnessioneConRecensore(event.getId(),
				event.getUtente(), event.getRecensore());
		logger.info("CREATED CONNESSIONE CON RECENSORE: " + connessioneConRecensore);
		connessioniService.saveConnessioneConRecensore(connessioneConRecensore);
		logger.info("SAVED CONNESSIONE CON RECENSORE: " + connessioneConRecensore);
		
		recensioniSeguiteService.updateAfterNewConnessioneConRecensore(connessioneConRecensore);
	}

}
