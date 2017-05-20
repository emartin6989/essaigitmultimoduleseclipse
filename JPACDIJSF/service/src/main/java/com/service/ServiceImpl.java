package com.service;

import java.io.Serializable;
import java.util.Collection;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.dao.IDao;
import com.metier.Client;
@Named
@ApplicationScoped
public class ServiceImpl implements IService, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Inject
	private IDao dao;

	@Override
	public long addClient(Client c) {
		return dao.addClient(c);
	}

	@Override
	public Collection<Client> listClients() {
		return dao.listClients();
	}

	@Override
	public void deleteClient(Client c) {
		dao.deleteClient(c);
	}

	@Override
	public void majClient(Client c) {
		dao.majClient(c);
	}

}
