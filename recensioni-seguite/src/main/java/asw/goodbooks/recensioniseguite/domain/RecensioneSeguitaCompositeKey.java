package asw.goodbooks.recensioniseguite.domain;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RecensioneSeguitaCompositeKey implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private String utente;
	private long idRecensione;

}
