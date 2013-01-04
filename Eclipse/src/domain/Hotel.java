package domain;

import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="HOTEL")
public class Hotel {
	
	@Id
	@GeneratedValue
	private int id;
	
    @Column(name="nom", nullable = false, length = 100)
    private String nom;
    
    @Column(name="preu")
	private float preu;
	
	@OneToMany(cascade=CascadeType.ALL)  
	private List<Habitacio> habitacions;
	
	public Hotel(){
		
	}
	
	public Hotel(String nomCiutat, String nom, float preu){
		/** TODO **/
		this.nom = nom;
		this.preu = preu;
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
		/* TODO */
    	return null;
	}
}
