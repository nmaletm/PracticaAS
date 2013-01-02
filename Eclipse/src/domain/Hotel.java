package domain;

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
	
	private String nomCiutat;
	//private Ciutat ciutat; ho comentem per a poder provar
    
    @Column(name="nom", nullable = false, length = 100)
    private String nom;
    
    @Column(name="preu")
	private float preu;
	
	@OneToMany(cascade=CascadeType.ALL)  
	private List<Habitacio> habitacions;  
	
	
	public Hotel(){
		
	}
	
	//public Hotel(String nom, float preu, Ciutat ciutat){
	public Hotel(String nom, float preu, String nomCiutat){
		//el mateix que posa al getNomCiutat
		this.nomCiutat = nomCiutat;
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
	
    @Column(name="nomCiutat", nullable = false, length = 100)
	public String getNomCiutat() {
		// Quan estigui feta la classe Ciutat aix� far� referencia a aquesta, i desapareixer� el atribut nomCiutat
		return nomCiutat;
	}
	public void setNomCiutat(String nomCiutat) {
		this.nomCiutat = nomCiutat;
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
	
}
