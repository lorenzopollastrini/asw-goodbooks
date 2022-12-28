package asw.goodbooks.recensioniseguite.recensionieventlistener;

import java.util.logging.Logger;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import asw.goodbooks.common.api.event.DomainEvent;
import asw.goodbooks.recensioni.api.event.RecensioniEventChannel;
import asw.goodbooks.recensioniseguite.domain.RecensioniEventConsumer;

@Component
public class RecensioniEventKafkaListener {
	
	private final Logger logger = Logger.getLogger(this.getClass().toString());
	
	@Autowired
	private RecensioniEventConsumer recensioniEventConsumer;
	
	@KafkaListener(topics = RecensioniEventChannel.channel)
	public void listen(ConsumerRecord<String, DomainEvent> record) throws Exception {
		logger.info("EVENT LISTENER: " + record.toString());
		DomainEvent event = record.value();
		recensioniEventConsumer.onEvent(event);
	}

}
