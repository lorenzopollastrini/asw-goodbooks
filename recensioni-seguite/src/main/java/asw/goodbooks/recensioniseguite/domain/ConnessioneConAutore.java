package asw.goodbooks.recensioniseguite.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.*; 

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ConnessioneConAutore {

	@Id
	@GeneratedValue
	private Long id;
	
	private String utente; 
	private String autore; 
	
}
