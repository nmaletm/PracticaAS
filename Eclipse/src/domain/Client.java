package domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="CLIENT")
public class Client {
	
    @Column(name="dni", nullable = false, length = 100)
	private String dni;
    
    @Column(name="nom", length = 100)
	private String nom;
    
    @Column(name="tlfn", length = 100)
	private String tlfn;
    
    @Column(name="nombreViatges")
	private Integer nombreViatges;
    
    public Boolean teViatge(Date dataIni, Date dataFi) {
    	/* TODO */
    	return null;
    }
    
    public void afegeixViatge (Viatge v) {
    	/* TODO */
    }
}