package asw.goodbooks.recensioniseguite.recensionieventlistener;

import java.util.logging.Logger;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import asw.goodbooks.common.api.event.DomainEvent;
import asw.goodbooks.connessioni.api.event.ConnessioniEventChannel;
import asw.goodbooks.recensioniseguite.domain.ConnessioniEventConsumer;

@Component
public class ConnessioniEventKafkaListener {
	
	private final Logger logger = Logger.getLogger(this.getClass().toString());
	
	@Autowired
	private ConnessioniEventConsumer connessioniEventConsumer;
	
	@KafkaListener(topics = ConnessioniEventChannel.channel)
	public void listen(ConsumerRecord<String, DomainEvent> record) throws Exception {
		logger.info("EVENT LISTENER: " + record.toString());
		DomainEvent event = record.value();
		connessioniEventConsumer.onEvent(event);
	}

}
