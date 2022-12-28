package asw.goodbooks.recensioni.eventpublisher;

import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import asw.goodbooks.common.api.event.DomainEvent;
import asw.goodbooks.recensioni.api.event.RecensioniEventChannel;
import asw.goodbooks.recensioni.domain.RecensioniEventPublisher;

@Component
public class RecensioniEventKafkaPublisher implements RecensioniEventPublisher {
	
	private final Logger logger = Logger.getLogger(this.getClass().toString());
	
	@Autowired
	private KafkaTemplate<String, DomainEvent> template;
	
	private String channel = RecensioniEventChannel.channel;

	@Override
	public void publish(DomainEvent event) {
		logger.info("EVENT PUBLISHER: " + event.toString() + " ON CHANNEL: " + channel);
		template.send(channel, event);
	}

}
