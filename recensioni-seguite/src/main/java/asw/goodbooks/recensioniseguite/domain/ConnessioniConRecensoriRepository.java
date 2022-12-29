package asw.goodbooks.recensioniseguite.domain;

import java.util.Collection;

import org.springframework.data.repository.CrudRepository;

public interface ConnessioniConRecensoriRepository extends CrudRepository<ConnessioneConRecensore, Long> {
	
	public Collection<ConnessioneConRecensore> findAllByRecensore(String recensore);

}
