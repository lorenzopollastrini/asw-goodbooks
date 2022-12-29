package asw.goodbooks.recensioniseguite.domain;

import java.util.Collection;

import org.springframework.data.repository.CrudRepository;

public interface RecensioniSeguiteRepository extends CrudRepository<RecensioneSeguita, RecensioneSeguitaCompositeKey> {

	public Collection<RecensioneSeguita> findAllByUtente(String utente);
	
}
