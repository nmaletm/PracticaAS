package domain;

import hibernate.HibernateUtil;

import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.IndexColumn;

/** Implementació de la classe Habitació del paquet Domain Model. **/
@Entity(name=Habitacio.TAULA)
@Table(name=Habitacio.TAULA)
public class Habitacio {
	public static final String TAULA = "HABITACIO";

	/** Id Artificial **/
	@Id
	private int id;
	
	private Integer hotelID;
	
	/** Atributs de la Classe **/
    @Column(name="numero")
	private Integer numero;

    /** Relació 0..1->* amb la classe Viatge, navegable en ambdós sentits. **/
	@OneToMany(cascade=CascadeType.REMOVE, fetch=FetchType.EAGER)  
	@IndexColumn(name="INDEX_COL_"+TAULA)
	private List<Viatge> viatges;
	
	/** Constructors **/
	public Habitacio() {
		setId(0);
	}
	
    public Habitacio(Integer hotelID, Integer numero){
    	this.hotelID = hotelID;
    	this.numero = numero;
    	this.id = this.hashCode();
    	HibernateUtil.save(this);
    }
    
	/** Implementació de l'operació estaLliure.
	 *  Retorna cert si l'Habitacio no està associada a cap Viatge en el període dataIni-dataFi. **/
	public Boolean estaLliure(Date dataIni, Date dataFi) {
		Boolean trobat = true;
		Iterator<Viatge> it = viatges.iterator();
		while (it.hasNext() && trobat)
			trobat = !it.next().interseccionaPeriode(dataIni, dataFi);
    	return trobat;	
	}
	
	/** Implementació de l'operació afegeixViatge.
	 *  Afegeix el Viatge v al conjunt de viatges de l'Habitació. **/
	public void afegeixViatge(Viatge v) {
		viatges.add(v);
		HibernateUtil.update(this);
		v.afegeixHabitacio(this);
	}
	
    /** Getters i Setters dels atributs **/
	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
    	this.id = this.hashCode();
    	HibernateUtil.update(this);
	}

	/** Generació de l'Id Artificial **/
    public int hashCode(){
        return hashCode(this.hotelID, this.numero);
    }
    
    public static int hashCode(Integer hotelID, Integer numero){
        String sSurrogate =   String.format("%20d", hotelID)      // 20 chars
                            + String.format("%20d", numero);      // 20 chars
       
        return sSurrogate.hashCode();
    }
    
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
}
