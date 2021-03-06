package domain;

import hibernate.HibernateUtil;

import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/** Implementació de la classe Client del paquet Domain Model. **/
@Entity(name=Client.TAULA)
@Table(name=Client.TAULA)
public class Client {
	public static final String TAULA = "CLIENT";
	
	/** Atributs de la Classe **/
	@Id
    @Column(name="dni", nullable = false, length = 10)
	private String dni;
    
    @Column(name="nom", length = 60)
	private String nom;
    
    @Column(name="tlfn", length = 10)
	private String tlfn;
    
    @Column(name="nombreViatges")
	private Integer nombreViatges;
    
    /** Constructors **/
    public Client() {
    	
    }
    
    public Client(String cdni, String cnom, String ctlfn, List<Viatge> cviatges) {
    	dni = cdni;
    	nom = cnom;
    	tlfn = ctlfn;
    	nombreViatges = 0;
    	viatges = cviatges;
    	HibernateUtil.save(this);
    }
    
    /** Relació 1->* amb la classe Viatge, navegable en ambdós sentits. **/
	@OneToMany(cascade=CascadeType.REMOVE, fetch=FetchType.EAGER)  
//	@IndexColumn(name="INDEX_COL_"+TAULA)
	@JoinColumn(name="client_dni")
	private List<Viatge> viatges;  
	
	/** Implementació de l'operació téViatge.
	 *  Retorna cert si el client té algun Viatge comprès en el període dataIni-dataFi, fals en cas contrari. **/
    public Boolean teViatge(Date dataIni, Date dataFi) {
    	Iterator<Viatge> it = getViatges().iterator();
    	Boolean trobat = false;
    	while (it.hasNext() && !trobat)
    		trobat = it.next().interseccionaPeriode(dataIni, dataFi);
    	return trobat;
    }
    
	/** Implementació de l'operació afageixViatge.
	 *  Afegeix el Viatge v al conjunt de viatges del Client. **/
    public void afegeixViatge (Viatge v) {
    	getViatges().add(v);
    	setNombreViatges(getNombreViatges() + 1);
    }

    /** Getters i Setters dels atributs **/
	public List<Viatge> getViatges() {
		return viatges;
	}

	public void setViatges(List<Viatge> viatges) {
		this.viatges = viatges;
		HibernateUtil.update(this);
	}

	public Integer getNombreViatges() {
		return nombreViatges;
	}

	public void setNombreViatges(Integer nombreViatges) {
		this.nombreViatges = nombreViatges;
		HibernateUtil.update(this);
	}

	public String getTlfn() {
		return tlfn;
	}

	public void setTlfn(String tlfn) {
		this.tlfn = tlfn;
		HibernateUtil.update(this);
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
		HibernateUtil.update(this);
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
		HibernateUtil.update(this);
	}
}