package datainterface;

import java.util.Date;
import java.util.List;

import domain.Viatge;

public interface CtrlViatge {
	public Viatge get(String dni, Date dataIni) throws Exception;
	public Boolean exists(String dni, Date dataIni);
	public List<Viatge> all();
}
