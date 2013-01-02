package domain;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="HABITACIO")
public class Habitacio {
	
	@Id
	@GeneratedValue
	private int id;

	@ManyToOne(cascade = CascadeType.ALL)
	private Hotel hotel;
	
    @Column(name="numero")
	private Integer numero;

    public Habitacio(){
    	
    }
    
    public Habitacio(Hotel hotel, Integer numero){
    	this.setHotel(hotel);
    	this.numero = numero;
    }
    
	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}
	
	public Hotel getHotel() {
		return hotel;
	}

	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(name="nomHotel", nullable = false, length = 100)
	public String getNomHotel() {
		return hotel.getNom();
	}
	/*
	public void setNomHotel(String nomHotel) {
		this.nomHotel = nomHotel;
	}
	*/
	
	public Boolean estaLliure(Date dataIni, Date dataFi) {
		/* TODO */
    	return null;	
	}
	
	public void afegeixViatge(Viatge v) {
		/* TODO */
	}
}
