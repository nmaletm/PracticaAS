package datainterface;

import java.util.List;

import domain.Hotel;

public interface CtrlHotel {
	public Hotel get(String nomCiutat, String nomHotel);
	public Boolean exists(String nomCiutat, String nomHotel);
	public List<Hotel> all();
}
