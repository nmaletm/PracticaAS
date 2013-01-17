package domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/** Implementació de la classe HorelLowCost del paquet Domain Model. **/
@Entity(name=HotelLowCost.TAULA)
@Table(name=HotelLowCost.TAULA)
public class HotelLowCost extends Hotel {
	public static final String TAULA = "HOTELLOWCOST";

	/** Atributs de la Classe **/
    @Column(name="descompte")
	private float descompte;
    
    /** Implementació de l'operació obteVariacioPreu.
	 *  Retorna la variació de preu associada a aquest HoteLowCost. 
	 *  Implementació del patró plantilla. **/
    @Override
    public Float obteVariacioPreu() {
    	return -descompte;
    }
}