package service;

import java.util.Collection;

import metier.Client;

public interface IService {

	long addClient(Client c);

	Collection<Client> listClients();

	void deleteClient(Client c);

	void majClient(Client c);

}