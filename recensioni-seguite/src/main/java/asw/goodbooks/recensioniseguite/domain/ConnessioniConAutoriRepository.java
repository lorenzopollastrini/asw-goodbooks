package asw.goodbooks.recensioniseguite.domain;

import java.util.Collection;

import org.springframework.data.repository.CrudRepository;

public interface ConnessioniConAutoriRepository extends CrudRepository<ConnessioneConAutore, Long> {
	
	public Collection<ConnessioneConAutore> findAllByAutore(String autore);

}
