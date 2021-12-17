package metier;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Client
{
	private static List<Client> clients = new ArrayList<Client>();
	private String nom;
	public List<Facture> facture = new ArrayList<Facture>();
	/** 
	 * Crée un client.
	 * @param nom le nom du client. 
	 */
	
	public Client(String nom)
	{
		this.nom = nom;
		clients.add(this);
	}

	/**
	 * Retourne le nom du client.
	 * @return le nom du client.
	 */
	
	public String getNom()
	{
		return nom;
	}
	
	/**
	 * Modifie le nom du client.
	 * @param nom le nom du client.
	 */
	
	public void setNom(String nom)
	{
		this.nom = nom;
	}
	
	/**
	 * Créé une facture.
	 * @param montant Le montant de la facture.
	 * @return la facture créée.
	 */
	
	public Facture createFacture(int montant)
	{
		if (montant <= 0) {
			System.out.println("Le montant d'une facture ne peut pas être négatif.");
			return null;
		}
		Facture new_facture = new Facture(this, montant, false, LocalDate.now());
		facture.add(new_facture);
		return new_facture;
	}
	
	/**
	 * Retourne une copie de la liste des factures du client. 
	 * @return une copie de la liste des factures du client.
	 */

	public List<Facture> getFactures()
	{
		List<Facture> new_facture = new ArrayList<Facture>();
		for (int i = 0; i < facture.size(); i++)
			new_facture.add(facture.get(i));
		return new_facture;
	}
	
	/**
	 * Retourne la somme des montants des factures.
	 * @return la somme des montants des factures.
	 */
	
	public int sommeMontants()
	{
		int montant = 0;
	
		for (int i = 0; i < facture.size(); i++)
			montant += facture.get(i).getMontant();
		return montant;
	}

	/**
	 * Créé une facture en précisant si elle est reglée.
	 * @param montant Le montant de la facture.
	 * @param reglée Vrai si la facture est reglée.
	 * @return la facture créée.
	 */
	
	public Facture createFacture(int montant, boolean reglee)
	{
		if (montant <= 0) {
			System.err.println("Le montant d'une facture ne peut pas être négatif.");
			return null;
		}
		Facture new_facture = new Facture(this, montant, reglee, LocalDate.now());
		facture.add(new_facture);
		return new_facture;
	}	
	
	/**
	 * Retourne la liste des factures reglées. 
	 * @return la liste des factures reglées.
	 */

	public List<Facture> facturesReglees()
	{
		List<Facture> new_facture = new ArrayList<Facture>();
		for (int i = 0; i < facture.size(); i++)
			if (facture.get(i).estReglee())	
				new_facture.add(facture.get(i));
		return new_facture;
	}
	

	/**
	 * Retourne tous les clients créés.
	 * @return une copie de la liste de tous les clients.
	 */
	public static List<Client> tous()
	{
		List<Client> new_clients = new ArrayList<Client>();
		for (int i = 0; i < clients.size(); i++)
			new_clients.add(clients.get(i));
		return new_clients;
	}
	
	/**
	 * Supprime le client.
	 */
	
	public void delete()
	{
		clients.remove(this);
	}
}
