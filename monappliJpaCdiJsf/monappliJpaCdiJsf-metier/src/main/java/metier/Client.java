package metier;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;

@ManagedBean
@Entity
//@NamedQuery(name="Client.findAll", query="SELECT c FROM Client c")
public class Client implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1054901659889598121L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	private String nom;
	private String prenom;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	@Override
	public String toString() {
		return "Client [id=" + id + ", nom=" + nom + ", prenom=" + prenom + "]";
	}

}
