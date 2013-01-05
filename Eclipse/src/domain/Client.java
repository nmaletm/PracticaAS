package domain;

import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="CLIENT")
public class Client {
	
	@Id
    @Column(name="dni", nullable = false, length = 10)
	private String dni;
    
    @Column(name="nom", length = 60)
	private String nom;
    
    @Column(name="tlfn", length = 10)
	private String tlfn;
    
    @Column(name="nombreViatges")
	private Integer nombreViatges;
    
	@OneToMany(cascade=CascadeType.ALL)  
	private List<Viatge> viatges;  
	
    public Boolean teViatge(Date dataIni, Date dataFi) {
    	Iterator<Viatge> it = getViatges().iterator();
    	Boolean trobat = false;
    	while (it.hasNext() && !trobat)
    		trobat = it.next().interseccionaPeriode(dataIni, dataFi);
    	return trobat;
    }
    
    public void afegeixViatge (Viatge v) {
    	getViatges().add(v);
    	setNombreViatges(getNombreViatges() + 1);
    }

	public List<Viatge> getViatges() {
		return viatges;
	}

	public void setViatges(List<Viatge> viatges) {
		this.viatges = viatges;
	}

	public Integer getNombreViatges() {
		return nombreViatges;
	}

	public void setNombreViatges(Integer nombreViatges) {
		this.nombreViatges = nombreViatges;
	}

	public String getTlfn() {
		return tlfn;
	}

	public void setTlfn(String tlfn) {
		this.tlfn = tlfn;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}
}