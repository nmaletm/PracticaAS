package domain;

import hibernate.HibernateUtil;

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
@Table(name=Habitacio.TAULA)
public class Habitacio {
	public static final String TAULA = "HABITACIO";

	@Id
	private int id;
	
    @Column(name="numero")
	private Integer numero;

	@OneToMany(cascade=CascadeType.ALL)  
	private List<Viatge> viatges;
	
	private Integer hotelID;
	
    public Habitacio(){
    	this.id = 0;
    }
    
    public Habitacio(Integer hotelID, Integer numero){
    	this.hotelID = hotelID;
    	this.numero = numero;
    	this.id = this.hashCode();
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
		viatges.add(v);
		v.afegeixHabitacio(this);
		HibernateUtil.update(v);
	}
	
    public int hashCode(){
        String sSurrogate =   String.format("%20d", this.hotelID)      // 20 chars
                            + String.format("%20d", this.numero);      // 20 chars
       
        return sSurrogate.hashCode();
    }
}
