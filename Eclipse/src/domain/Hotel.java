package domain;

import java.util.Date;
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
		/* TODO */
    	return null;
	}
	
	public Float calculaPreuHabitacio(Date dataIni, Date dataFi) {
		/* TODO */
    	return null;	
	}
	
	public Habitacio getHabitacioLliure(Date dataIni, Date dataFi) {
		/* TODO */
    	return null;
	}
}
