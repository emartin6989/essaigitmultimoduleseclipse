package mbeans;

import java.io.Serializable;
import java.util.Collection;

import javax.enterprise.context.ApplicationScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import com.metier.Client;
import com.service.IService;

@Named
@ApplicationScoped
public class ClientBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Inject
	private IService service;

	private Client client = new Client();

	private boolean editMode = false;

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public IService getServices() {
		return service;
	}

	public void setServices(IService services) {
		this.service = services;
	}

	public boolean isEditMode() {
		return editMode;
	}

	public void setEditMode(boolean editMode) {
		this.editMode = editMode;
	}

	public String add() {
		if (!client.getNom().equalsIgnoreCase("") && !client.getPrenom().equalsIgnoreCase("")) {
			if (editMode == false) {
				service.addClient(client);
			} else {
				service.majClient(client);
				editMode = false;
			}
		} else {
			FacesContext context = FacesContext.getCurrentInstance();
			context.addMessage("client",
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Veuillez saisir les valeurs non nulles", null));
		}
		client = new Client();
		return "index";
	}

	public Collection<Client> list() {
		return service.listClients();
	}

	public void delete() {
		service.deleteClient(client);
		client = new Client();
	}

	public void maj() {
		editMode = true;
	}
}