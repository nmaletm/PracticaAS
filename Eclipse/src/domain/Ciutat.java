package domain;


import java.util.Date;
import java.util.HashSet;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import utility.Pair;

@Entity
@Table(name="CIUTAT")
public class Ciutat {
	
    @Column(name="nom", nullable = false, length = 100)
	private String nom;
    
    @Column(name="descripcio", length = 100)
	private String descripcio;
    
    @Column(name="preuVol")
	private float preuVol;
    
    public String getNom() {
    	return nom;
    }
    
    public Float getPreuVol() {
    	return preuVol;
    }
    
    public HashSet<Pair<String,Float>> getHotelsLliures(Date dataIni, Date dataFi) {
    	/* TODO */
    	return null;
    }    
}
