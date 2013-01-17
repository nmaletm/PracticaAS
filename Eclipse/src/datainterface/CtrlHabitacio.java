package datainterface;

import java.util.List;

import domain.Habitacio;

public interface CtrlHabitacio {
	public Habitacio get(Integer idHotel, Integer numero) throws Exception;
	public Boolean exists(Integer idHotel, Integer numero);
	public List<Habitacio> all();
}
