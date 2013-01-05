package domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name=HotelLowCost.TAULA)
public class HotelLowCost extends Hotel {
	public static final String TAULA = "HOTELLOWCOST";

    @Column(name="descompte")
	private float descompte;
    
    @Override
    public Float obteVariacioPreu() {
    	return -descompte;
    }
}