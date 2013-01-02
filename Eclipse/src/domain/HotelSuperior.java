package domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="HOTELSUPERIOR")
public class HotelSuperior extends Hotel {

    @Column(name="recarrec")
	private float recarrec;
    
    @Override
    public Float obteVariacioPreu() {
    	return recarrec;
    }
}
