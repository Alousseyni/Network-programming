package dataCenterProjects;


public class Ville {
	// instance
	protected String nomVille;
	protected String nomPays;
	protected int nbrHabitants;
	protected char categorie;
	protected static int numberOfInstant=0;
	//constructors
	public Ville() {
		nomVille ="Inconnu";
		nomPays  ="Inconnu";
		nbrHabitants=0;
		this.setCategoriesInstance();
		numberOfInstant++;
	}
	public Ville(String nomVille,int nbrHabitants,String nomPays) {
		this.nomVille 		= nomVille;
		this.nbrHabitants	=nbrHabitants;
		this.nomPays		= nomPays;	
		this.setCategoriesInstance();
		numberOfInstant++;
	}
	// setter and getters

	public String getNomVille() {
		return nomVille;
	}
	public static int getNumberOfInstant() {
		return numberOfInstant;
	}
	public void setNomVille(String nomVille) {
		this.nomVille = nomVille;
	}
	public String getNomPays() {
		return nomPays;
	}
	public void setNomPays(String nomPays) {
		this.nomPays = nomPays;
	}
	public int getNbrHabitants() {
		return nbrHabitants;
	}
	public void setNbrHabitants(int nbrHabitants) {
		this.nbrHabitants = nbrHabitants;
	}
	public char getCategorie() {
		return categorie;
	}
	public void setCategorie(char categorie) {
		this.categorie = categorie;
	}
	public String toString() {
		return "La ville <"+this.nomVille+"> est un ville du <"+this.nomPays+"> comportant pres de :"+this.nbrHabitants+" et classé dans la categorie <"+this.categorie+">";
		
	}
	// internal methods 
	private void setCategoriesInstance() 
	{
		int[] nHabitants = {0,10_000,100_000,500_000,1_000_000,10_000_000,20_000_000,30_000_000,40_000_000,50_000_000,55_000_000,60_000_000};
		char[] cat 		 = {'?','A','B','C','D','E','F','G','H','I','J','K'}; 
		int i=0;
		while((i<cat.length) && (this.nbrHabitants > nHabitants[i])) {
			i++;
			this.categorie = cat[i];

		}
		
	}
	public void compareVille(Ville v) {
		if (this.nbrHabitants > v.nbrHabitants) {
			System.out.println(this.nomPays+" est plus peuplée que "+v.nomPays+" avec plus de <"+this.nbrHabitants+"> habitants");
		}else {
			System.out.println(v.nomPays+" est plus peuplée que "+this.nomPays+" avec plus de <"+v.nbrHabitants+"> habitants");
		}
	}

}
