package domain;


import java.util.Date;
import java.util.HashSet;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import utility.Pair;

@Entity
@Table(name="VIATGE")
public class Viatge {
	
	@Id
	@GeneratedValue
	private int id;
	
    @Column(name="dataInici", nullable = false)
	private Date dataInici;
    
    @Column(name="dataFi")
	private Date dataFinal;
    
	@ManyToOne(cascade = CascadeType.PERSIST)
    private Client client;
	
	@ManyToOne(cascade = CascadeType.PERSIST)
	private Ciutat ciutat;
    
	@ManyToOne(optional = true, cascade = CascadeType.PERSIST)
	private Habitacio habitacio;
	
    public Viatge(Client cl, Date dataIni, Date dataFi, Ciutat c) {
    	client = cl;
    	dataInici = dataIni;
    	dataFinal = dataFi;
    	ciutat = c;
    	cl.afegeixViatge(this);
    }
    
    public Date getDataFi() {
    	return dataFinal;
    }
    
    public String getNomCiutat() {
    	/* TODO */
    	return null;
    }
    
    public Boolean interseccionaPeriode(Date dataIni, Date dataFi) {
        /* TODO */
    	return null;
    }
    
    public HashSet<Pair<String,Float>> getHotelsLliures(Date dataIni, Date DataFi) {
    	/* TODO */
    	return null;
    }
    
    public void afegeixHabitacio(Habitacio h) {
    	/* TODO */	
    }
}
