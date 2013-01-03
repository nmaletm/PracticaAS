package domain;

import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="CLIENT")
public class Client {
	
	@Id
    @Column(name="dni", nullable = false, length = 100)
	private String dni;
    
    @Column(name="nom", length = 100)
	private String nom;
    
    @Column(name="tlfn", length = 100)
	private String tlfn;
    
    @Column(name="nombreViatges")
	private Integer nombreViatges;
    
	@OneToMany(cascade=CascadeType.ALL)  
	private List<Viatge> viatges;  
	
    public Boolean teViatge(Date dataIni, Date dataFi) {
    	Iterator<Viatge> it = viatges.iterator();
    	Boolean trobat = false;
    	while (it.hasNext() && !trobat)
    		trobat = it.next().interseccionaPeriode(dataIni, dataFi);
    	return trobat;
    }
    
    public void afegeixViatge (Viatge v) {
    	viatges.add(v);
    	nombreViatges++;
    }
}