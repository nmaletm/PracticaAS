package domain;


import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import utility.Pair;

@Entity
@Table(name="CIUTAT")
public class Ciutat {
	
	@Id
    @Column(name="nom", nullable = false, length = 100)
	private String nom;
    
    @Column(name="descripcio", length = 100)
	private String descripcio;
    
    @Column(name="preuVol")
	private float preuVol;
    
	@OneToMany(cascade=CascadeType.ALL)  
	private List<Hotel> hotels;  
	
    public String getNom() {
    	return nom;
    }
    
    public Float getPreuVol() {
    	return preuVol;
    }
    
    public HashSet<Pair<String,Float>> getHotelsLliures(Date dataIni, Date dataFi) {
    	HashSet<Pair<String,Float>> resultat = new HashSet<Pair<String,Float>>();
    	
    	Iterator<Hotel> it = hotels.iterator();
    	while (it.hasNext()) {
    		Hotel h = it.next();
    		Boolean b = h.teHabitacioLliure(dataIni, dataFi);
    		if (b) {
    			Float preu = h.calculaPreuHabitacio(dataIni, dataFi);
    			String nom = h.getNom();
    			resultat.add(new Pair<String,Float>(nom,preu));
    		}
    	}
    	return resultat;
    }    
}
