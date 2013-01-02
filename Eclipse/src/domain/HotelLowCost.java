package domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="HOTELLOWCOST")
public class HotelLowCost extends Hotel {
	
    @Column(name="descompte")
	private float descompte;
    
    @Override
    public Float obteVariacioPreu() {
    	return -descompte;
    }
}