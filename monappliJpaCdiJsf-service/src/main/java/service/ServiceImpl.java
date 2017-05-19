package service;

import java.io.Serializable;
import java.util.Collection;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import dao.IDao;
import metier.Client;


@Named
//@SessionScoped
public class ServiceImpl implements IService, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5488726291781479511L;
	@Inject
	private IDao dao;

	/* (non-Javadoc)
	 * @see service.IService#addClient(metier.Client)
	 */
	@Override
	public long addClient(Client c) {
		return dao.addClient(c);
	}

	/* (non-Javadoc)
	 * @see service.IService#listClients()
	 */
	@Override
	public Collection<Client> listClients() {
		return dao.listClients();
	}

	/* (non-Javadoc)
	 * @see service.IService#deleteClient(metier.Client)
	 */
	@Override
	public void deleteClient(Client c) {
		dao.deleteClient(c);
	}

	/* (non-Javadoc)
	 * @see service.IService#majClient(metier.Client)
	 */
	@Override
	public void majClient(Client c) {
		dao.majClient(c);
	}

}
