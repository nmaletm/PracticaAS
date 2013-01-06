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

@Entity(name=Viatge.TAULA)
@Table(name=Viatge.TAULA)
public class Viatge {
	public static final String TAULA = "VIATGE";

	@Id
	private int id;
	
    @Column(name="dataInici", nullable = false)
	private Date dataInici;
    
    @Column(name="dataFinal")
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
    	id = hashCode();
    	HibernateUtil.update(cl);
    }
    
    public Date getDataFi() {
    	return dataFinal;
    }
    
    public String getNomCiutat() {
    	return ciutat.getNom();
    }
    
    public Boolean interseccionaPeriode(Date dataIni, Date dataFi) {
    	return ((dataInici.before(dataIni) && dataFinal.after(dataIni)) || 
    			(dataInici.before(dataFi) && dataFinal.after(dataFi)) ||
    			(dataInici.after(dataFi) && dataFinal.before(dataFi)));
    }
    
    public HashSet<Pair<String,Float>> getHotelsLliures() {
    	return ciutat.getHotelsLliures(dataInici, dataFinal);
    }
    
    public void afegeixHabitacio(Habitacio h) {
    	habitacio = h;
    }
	
    public int hashCode(){
    	return hashCode(this.client.getDni(), this.dataInici);
    }
    
    public static int hashCode(String dni, Date dataIni){
        String sSurrogate =   String.format("%10s", dni)      // 20 chars
                            + String.format("%D", dataIni);     // 10 chars
       
        return sSurrogate.hashCode();
    }
}
