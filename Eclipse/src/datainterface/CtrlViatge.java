package datainterface;

import java.util.Date;
import java.util.List;

import domain.Viatge;

public interface CtrlViatge {
	public Viatge get(String dni, Date dataIni);
	public Boolean exists(String dni, Date dataIni);
	public List<Viatge> all();
}
