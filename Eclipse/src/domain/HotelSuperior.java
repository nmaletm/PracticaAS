package domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/** Implementació de la classe HotelSuperior del paquet Domain Model. **/
@Entity(name=HotelSuperior.TAULA)
@Table(name=HotelSuperior.TAULA)
public class HotelSuperior extends Hotel {
	public static final String TAULA = "HOTELSUPERIOR";
	
	/** Atributs de la Classe **/
    @Column(name="recarrec")
	private float recarrec;
    
    /** Implementació de l'operació obteVariacioPreu.
	 *  Retorna la variació de preu associada a aquest HoteSuperior.
	 *  Implementació del patró plantilla. **/
    @Override
    public Float obteVariacioPreu() {
    	return recarrec;
    }
}
