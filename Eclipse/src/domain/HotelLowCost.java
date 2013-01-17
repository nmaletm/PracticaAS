package domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/** Implementació de la classe HorelLowCost del paquet Domain Model. **/
@Entity(name=HotelLowCost.TAULA)
@Table(name=HotelLowCost.TAULA)
public class HotelLowCost extends Hotel {
	public static final String TAULA = "HOTELLOWCOST";

	/** Constructors **/
	public HotelLowCost(String hNomCiutat, String hNom, float hPreu, List<Habitacio> hHabitacions) throws Exception {
		super(hNomCiutat, hNom, hPreu, hHabitacions);
	}

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