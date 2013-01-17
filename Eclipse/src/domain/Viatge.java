package domain;

import hibernate.HibernateUtil;

import java.util.Date;
import java.util.HashSet;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import utility.Pair;

/** Implementació de la classe Viatge del paquet Domain Model. **/
@Entity(name=Viatge.TAULA)
@Table(name=Viatge.TAULA)
public class Viatge {
	public static final String TAULA = "VIATGE";
	
	/** Id Artificial **/
	@Id
	private int id;
	
	/** Atributs de la Classe **/
    @Column(name="dataInici", nullable = false)
	private Date dataInici;
    
    @Column(name="dataFinal")
	private Date dataFinal;
    
    /** Relació *->1 amb la classe Client, navegable en ambdós sentits. **/
	@ManyToOne(cascade = CascadeType.ALL) // PERSIST
    private Client client;
	
	/** Relació *->1 amb la classe Ciutat, navegable en el sentit Viatge->Ciutat. **/
	@ManyToOne(cascade = CascadeType.ALL) // PERSIST
	private Ciutat ciutat;
    
	/** Relació *->0..1 amb la classe Habitació, navegable en ambdós sentits. **/
	@ManyToOne(optional = true, cascade = CascadeType.ALL)
	private Habitacio habitacio;
	
    public Viatge() {
    	setId(0);
    }
    
    public Viatge(Client cl, Date dataIni, Date dataFi, Ciutat c) {
    	client = cl;
    	dataInici = dataIni;
    	dataFinal = dataFi;
    	ciutat = c;
    	cl.afegeixViatge(this);
    	setId(hashCode());
    	HibernateUtil.update(cl);
    }
    
    /** Implementació de l'operació interseccionaPeriode.
	 *  Retorna cert si el període del Viatge intersecciona amb el període dataIni-dataFi, fals en altre cas. **/
    public Boolean interseccionaPeriode(Date dataIni, Date dataFi) {
    	return ((dataInici.before(dataIni) && dataFinal.after(dataIni)) || 
    			(dataInici.before(dataFi) && dataFinal.after(dataFi)) ||
    			(dataInici.after(dataFi) && dataFinal.before(dataFi)));
    }
    
    /** Implementació de l'operació getHotelsLliures.
	 *  Retorna el conjunt d'hotels. de la Ciutat del Viatge, que estan lliures durant el període d'aquest Viatge. **/
    public HashSet<Pair<String,Float>> getHotelsLliures() {
    	return ciutat.getHotelsLliures(dataInici, dataFinal);
    }
    
    /** Implementació de l'operació afegeixHabitació.
	 *  Assigna l'Habitacio h a aquest Viatge. **/
    public void afegeixHabitacio(Habitacio h) {
    	habitacio = h;
    }
    
    /** Implementació de l'operació getNomCiutat.
	 *  Retorna el nom de la Ciutat del Viatge. **/
    public String getNomCiutat() {
    	return ciutat.getNom();
    }
    
    /** Getters i Setters dels atributs **/
    public Date getDataFi() {
    	return dataFinal;
    }
    
    /** Generació de l'Id Artificial **/
    public int hashCode(){
    	return hashCode(this.client.getDni(), this.dataInici);
    }
    
    public static int hashCode(String dni, Date dataIni){
        String sSurrogate =   String.format("%10s", dni)      // 20 chars
                            + String.format("%10d", dataIni.hashCode());     // 10 chars
       
        return sSurrogate.hashCode();
    }

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}
