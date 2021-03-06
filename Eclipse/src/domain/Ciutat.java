package domain;

import hibernate.HibernateUtil;

import java.util.Date;
import java.util.HashSet;
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

import utility.Pair;

/** Implementació de la classe Ciutat del paquet Domain Model. **/
@Entity(name=Ciutat.TAULA)
@Table(name=Ciutat.TAULA)
public class Ciutat {
	public static final String TAULA = "CIUTAT";

	/** Atributs de la Classe **/
	@Id
    @Column(name="nom", nullable = false, length = 60)
	private String nom;
    
    @Column(name="descripcio", length = 100)
	private String descripcio;
    
    @Column(name="preuVol")
	private float preuVol;
    
    /** Constructors **/
    public Ciutat() {}
    
    public Ciutat(String cNom, String cDescripcio, float cPreuVol, List<Hotel> cHotels) throws Exception {
    	if(cHotels.size() == 0) throw new Exception ("noTeHotels");
    	nom = cNom;
    	descripcio = cDescripcio;
    	preuVol = cPreuVol;
    	hotels = cHotels;
    	HibernateUtil.save(this);
    }
    
    /** Relació 1->1..* amb la classe Hotel, navegable en el sentit Ciutat->Hotel. **/
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER) 
	@IndexColumn(name="INDEX_COL_"+TAULA)
	private List<Hotel> hotels;  
	
	/** Implementació de l'operació getHotelsLliures.
	 *  Retorna els hotels d'aquesta ciutat que tenen una o més habitacions lliures en el període dataIni-dataFi. **/
    public HashSet<Pair<String,Float>> getHotelsLliures(Date dataIni, Date dataFi) {
    	HashSet<Pair<String,Float>> resultat = new HashSet<Pair<String,Float>>();
    	
    	Iterator<Hotel> it = getHotels().iterator();
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

    /** Getters i Setters dels atributs **/
    public String getNom() {
    	return nom;
    }
    
	public void setNom(String nom) {
		this.nom = nom;
		HibernateUtil.update(this);
	}
	
    public Float getPreuVol() {
    	return preuVol;
    }
    
	public void setPreuVol(int preuVol) {
		this.preuVol = preuVol;		
		HibernateUtil.update(this);
	}

	public String getDescripcio() {
		return descripcio;
	}

	public void setDescripcio(String descripcio) {
		this.descripcio = descripcio;
		HibernateUtil.update(this);
	}

	public List<Hotel> getHotels() {
		return hotels;
	}

	public void setHotels(List<Hotel> hotels) throws Exception {
		if(hotels.size() == 0) throw new Exception ("noTeHotels");
		this.hotels = hotels;
		HibernateUtil.update(this);
	}
}
