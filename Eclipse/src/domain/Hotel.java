package domain;

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

/** Implementació de la classe Hotel del paquet Domain Model. **/
@Entity(name=Hotel.TAULA)
@Table(name=Hotel.TAULA)
public class Hotel {
	public static final String TAULA = "HOTEL";
	
	/** Id Artificial **/
	@Id
	private int id;
	
	private String nomCiutat;
	
	/** Atributs de la Classe **/
    @Column(name="nom", nullable = false, length = 60)
    private String nom;
    
    @Column(name="preu")
	private float preu;
	
    /** Relació 1->3..* amb la classe Habitació, navegable en el sentit Hotel->Habitació. **/
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER)  
	@IndexColumn(name="INDEX_COL_"+TAULA)
	private List<Habitacio> habitacions;
	
	public Hotel(){
		this.id = 0;
	}

	public Hotel(String nomCiutat, String nom, float preu){
		this.nomCiutat = nomCiutat;
		this.nom = nom;
		this.preu = preu;
		this.id = this.hashCode();
	}
	
	public List<Habitacio> getHabitacions() {
		return habitacions;
	}
	public void setHabitacions(List<Habitacio> habitacions) {
		this.habitacions = habitacions;
	}

    /** Implementació de l'operació obteVariacioPreu.
	 *  Retorna la variació de preu associada a aquest Hotel.
	 *  Implementació del patró plantilla. **/
	public Float obteVariacioPreu() {
		return (float) 0;
	}
	
	/** Implementació de l'operació teHabitacioLliure.
	 *  Retorna cert si l'Hotel té alguna Habitacio no ocupada en el període dataIni-dataFi. **/
	public Boolean teHabitacioLliure(Date dataIni, Date dataFi) {
		Boolean trobat = false;
		Iterator<Habitacio> it = habitacions.iterator();
		while (it.hasNext() && !trobat) {
			trobat = it.next().estaLliure(dataIni, dataFi);
		}
    	return trobat;
	}
	
	/** Implementació de l'operació calculaPreuHabitacio.
	 *  Retorna el preu de llogar una Habitacio d'aquest Hotel pel període dataIni-dataFi. **/
	public Float calculaPreuHabitacio(Date dataIni, Date dataFi) {
		float var = obteVariacioPreu();
    	return (preu+var)*((dataFi.getTime()-dataIni.getTime())/1000/60/60/24);	
	}
	
	/** Implementació de l'operació getHabitacioLliure.
	 *  Retorna una Habitacio lliure d'aquest Hotel pel període dataIni-dataFi. **/
	public Habitacio getHabitacioLliure(Date dataIni, Date dataFi) {
		Boolean trobat = false;
		Habitacio hab = null;
		
		Iterator<Habitacio> it = habitacions.iterator();
		while (it.hasNext() && !trobat) {
			Habitacio h = it.next();
			trobat = h.estaLliure(dataIni, dataFi);
			if (trobat) hab = h;
		}
		
    	return hab;
	}
	    
	/** Getters i Setters dels atributs **/
	public float getPreu() {
		return preu;
	}
	
	public void setPreu(float preu) {
		this.preu = preu;
	}
	
	public String getNom() {
		return nom;
	}
	
	public void setNom(String nom) {
		this.nom = nom;
		this.id = this.hashCode();
	}
	
	/** Generació de l'Id Artificial **/
    public int hashCode(){
        return hashCode(this.nomCiutat, this.nom);
    }
    
    public static int hashCode(String nomCiutat, String nom){
        String sSurrogate =   String.format("%60s", nomCiutat)      // 60 chars
                            + String.format("%60s", nom);           // 60 chars
       
        return sSurrogate.hashCode();
    }
    
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
}
