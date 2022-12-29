package asw.goodbooks.recensioniseguite.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@IdClass(RecensioneSeguitaCompositeKey.class)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RecensioneSeguita {

	@Id
	private String utente;
	
	@Id
	private Long idRecensione;
	
	private String recensore;
	private String titoloLibro;
	private String autoreLibro;
	private String testoRecensione;
	
}
