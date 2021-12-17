package metier;

import java.time.LocalDate;

public class Facture
{
	private Client nom;
	private int montant;
	private boolean reglee;
	private LocalDate Date;
	public Facture(Client nom, int montant, boolean reglee, LocalDate Date)
	{
		this.nom = nom;
		this.montant = montant;
		this.reglee = reglee;
		this.Date = Date;
	}
	/**
	 * Retourne le client à qui est adressée la facture..
	 * @return le client.
	 */
	
	public Client getClient()
	{
		return nom;
	}

	/**
	 * Retourne le montant de la facture.
	 * @return le montant de la facture.
	 */
	
	public int getMontant()
	{
		return montant;
	}

	/**
	 * Retourne vrai si la facture est reglée.
	 * @return vrai ssi la facture est reglée.
	 */
	
	public boolean estReglee()
	{
		return reglee;
	}

	/**
	 * Retourne la date de la facture.
	 * @return la date de la facture.
	 */
	
	public LocalDate getDate()
	{
		return Date;
	}

	/**
	 * Supprime la facture
	 */
	
	public void delete()
	{
	}
	
	/**
	 * Duplique la facture.
	 * @return une copie de la facture.
	 */
	
	public Facture copie()
	{
		Facture new_facture = new Facture(this.nom, this.montant, this.reglee, LocalDate.now());
		return new_facture;
	}
}