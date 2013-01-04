package datainterface;

import java.util.List;

import domain.Ciutat;

public interface CtrlCiutats {
	public Ciutat get(String nom) throws Exception;
	public Boolean exists(String nom);
	public List<Ciutat> all();
}
