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

@Entity(name=Hotel.TAULA)
@Table(name=Hotel.TAULA)
public class Hotel {
	public static final String TAULA = "HOTEL";

	@Id
	private int id;
	
    @Column(name="nom", nullable = false, length = 60)
    private String nom;
    
    @Column(name="preu")
	private float preu;
    
    private String nomCiutat;
	
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
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public List<Habitacio> getHabitacions() {
		return habitacions;
	}
	public void setHabitacions(List<Habitacio> habitacions) {
		this.habitacions = habitacions;
	}

	public Float obteVariacioPreu() {
		return (float) 0;
	}
	
	public Boolean teHabitacioLliure(Date dataIni, Date dataFi) {
		Boolean trobat = false;
		Iterator<Habitacio> it = habitacions.iterator();
		while (it.hasNext() && !trobat) {
			trobat = it.next().estaLliure(dataIni, dataFi);
		}
    	return trobat;
	}
	
	public Float calculaPreuHabitacio(Date dataIni, Date dataFi) {
		float var = obteVariacioPreu();
    	return (preu+var)*((dataFi.getTime()-dataIni.getTime())/1000/60/60/24);	
	}
	
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
	
    public int hashCode(){
        return hashCode(this.nomCiutat, this.nom);
    }
    
    public static int hashCode(String nomCiutat, String nom){
        String sSurrogate =   String.format("%60s", nomCiutat)      // 60 chars
                            + String.format("%60s", nom);           // 60 chars
       
        return sSurrogate.hashCode();
    }
}
