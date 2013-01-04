package domain;

import java.util.Date;
import java.util.List;
import java.util.Iterator;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="HABITACIO")
public class Habitacio {
	
	@Id
	@GeneratedValue
	private int id;
	
    @Column(name="numero")
	private Integer numero;

	@OneToMany(cascade=CascadeType.ALL)  
	private List<Viatge> viatges;
	
    public Habitacio(){
    	
    }
    
    public Habitacio(Integer hotelID, Integer numero){
    	/** TODO **/
    	this.numero = numero;
    }
    
	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Boolean estaLliure(Date dataIni, Date dataFi) {
		Boolean trobat = true;
		Iterator<Viatge> it = viatges.iterator();
		while (it.hasNext() && trobat)
			trobat = !it.next().interseccionaPeriode(dataIni, dataFi);
    	return trobat;	
	}
	
	public void afegeixViatge(Viatge v) {
		/* TODO */
	}
}
