package datainterface;

import java.util.List;

import domain.Client;

public interface CtrlClient {
	public Client get(String dni);
	public Boolean exists(String dni);
	public List<Client> all();
}
