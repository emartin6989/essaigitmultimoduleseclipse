package dao;

import java.util.Collection;

import metier.Client;

public interface IDao {

	public long addClient(Client c);
	public void deleteClient(Client c);
	public void majClient(Client c);
	public Collection<Client> listClients();
	public Client findClientById(long idClient);
}
