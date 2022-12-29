package asw.goodbooks.connessioni.eventpublisher;

import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import asw.goodbooks.common.api.event.DomainEvent;
import asw.goodbooks.connessioni.api.event.ConnessioniEventChannel;
import asw.goodbooks.connessioni.domain.ConnessioniEventPublisher;

@Component
public class ConnessioniEventKafkaPublisher implements ConnessioniEventPublisher {
	
	private final Logger logger = Logger.getLogger(this.getClass().toString());
	
	@Autowired
	private KafkaTemplate<String, DomainEvent> template;
	
	private String channel = ConnessioniEventChannel.channel;

	@Override
	public void publish(DomainEvent event) {
		logger.info("EVENT PUBLISHER: " + event.toString() + " ON CHANNEL: " + channel);
		template.send(channel, event);
	}

}
